package com.android.server.apphibernation;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.IActivityManager;
import android.app.StatsManager;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManagerInternal;
import android.apphibernation.HibernationStats;
import android.apphibernation.IAppHibernationService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.Environment;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.util.StatsEvent;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.Settings;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class AppHibernationService extends SystemService {
    private static final long PACKAGE_MATCH_FLAGS = 537698816;
    private static final String TAG = "AppHibernationService";
    public static boolean sIsServiceEnabled;
    private final Executor mBackgroundExecutor;
    private final BroadcastReceiver mBroadcastReceiver;
    private final Context mContext;
    private final Map<String, GlobalLevelState> mGlobalHibernationStates;
    private final HibernationStateDiskStore<GlobalLevelState> mGlobalLevelHibernationDiskStore;
    private final IActivityManager mIActivityManager;
    private final IPackageManager mIPackageManager;
    private final Injector mInjector;
    private final AppHibernationManagerInternal mLocalService;
    private final Object mLock;
    private final boolean mOatArtifactDeletionEnabled;
    private final PackageManagerInternal mPackageManagerInternal;
    private final AppHibernationServiceStub mServiceStub;
    private final StorageStatsManager mStorageStatsManager;
    private final UsageStatsManagerInternal.UsageEventListener mUsageEventListener;
    private final SparseArray<HibernationStateDiskStore<UserLevelState>> mUserDiskStores;
    private final UserManager mUserManager;
    private final SparseArray<Map<String, UserLevelState>> mUserStates;

    static final class AppHibernationServiceStub extends IAppHibernationService.Stub {
        final AppHibernationService mService;

        AppHibernationServiceStub(AppHibernationService service) {
            this.mService = service;
        }

        public boolean isHibernatingForUser(String packageName, int userId) {
            return this.mService.isHibernatingForUser(packageName, userId);
        }

        public void setHibernatingForUser(String packageName, int userId, boolean isHibernating) {
            this.mService.setHibernatingForUser(packageName, userId, isHibernating);
        }

        public void setHibernatingGlobally(String packageName, boolean isHibernating) {
            this.mService.setHibernatingGlobally(packageName, isHibernating);
        }

        public boolean isHibernatingGlobally(String packageName) {
            return this.mService.isHibernatingGlobally(packageName);
        }

        public List<String> getHibernatingPackagesForUser(int userId) {
            return this.mService.getHibernatingPackagesForUser(userId);
        }

        public Map<String, HibernationStats> getHibernationStatsForUser(List<String> packageNames, int userId) {
            if (packageNames == null) goto L4;
            Set<String> pkgsSet = new ArraySet(packageNames);
        L6:
            return this.mService.getHibernationStatsForUser(pkgsSet, userId);
        L4:
            pkgsSet = null;
            goto L6
        }

        public boolean isOatArtifactDeletionEnabled() {
            return AppHibernationService.m1707$$Nest$misOatArtifactDeletionEnabled(this.mService);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new AppHibernationShellCommand(this.mService).exec(this, in, out, err, args, callback, resultReceiver);
        }

        protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
            AppHibernationService.m1706$$Nest$mdump(this.mService, fout);
        }
    }

    interface Injector {
        IActivityManager getActivityManager();

        Executor getBackgroundExecutor();

        Context getContext();

        HibernationStateDiskStore<GlobalLevelState> getGlobalLevelDiskStore();

        IPackageManager getPackageManager();

        PackageManagerInternal getPackageManagerInternal();

        StorageStatsManager getStorageStatsManager();

        UsageStatsManagerInternal getUsageStatsManagerInternal();

        HibernationStateDiskStore<UserLevelState> getUserLevelDiskStore(int r1);

        UserManager getUserManager();

        boolean isOatArtifactDeletionEnabled();
    }

    private static final class InjectorImpl implements Injector {
        private static final String HIBERNATION_DIR_NAME = "hibernation";
        private final Context mContext;
        private final ScheduledExecutorService mScheduledExecutorService;
        private final UserLevelHibernationProto mUserLevelHibernationProto;

        InjectorImpl(Context context) {
            this.mContext = context;
            this.mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            this.mUserLevelHibernationProto = new UserLevelHibernationProto();
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public Context getContext() {
            return this.mContext;
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public IPackageManager getPackageManager() {
            return IPackageManager.Stub.asInterface(ServiceManager.getService(Settings.ATTR_PACKAGE));
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public PackageManagerInternal getPackageManagerInternal() {
            return (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public IActivityManager getActivityManager() {
            return ActivityManager.getService();
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public UserManager getUserManager() {
            return (UserManager) this.mContext.getSystemService(UserManager.class);
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public StorageStatsManager getStorageStatsManager() {
            return (StorageStatsManager) this.mContext.getSystemService(StorageStatsManager.class);
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public Executor getBackgroundExecutor() {
            return this.mScheduledExecutorService;
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public UsageStatsManagerInternal getUsageStatsManagerInternal() {
            return (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public HibernationStateDiskStore<GlobalLevelState> getGlobalLevelDiskStore() {
            File dir = new File(Environment.getDataSystemDirectory(), HIBERNATION_DIR_NAME);
            return new HibernationStateDiskStore(dir, new GlobalLevelHibernationProto(), this.mScheduledExecutorService);
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public HibernationStateDiskStore<UserLevelState> getUserLevelDiskStore(int userId) {
            File dir = new File(Environment.getDataSystemCeDirectory(userId), HIBERNATION_DIR_NAME);
            return new HibernationStateDiskStore(dir, this.mUserLevelHibernationProto, this.mScheduledExecutorService);
        }

        @Override // com.android.server.apphibernation.AppHibernationService.Injector
        public boolean isOatArtifactDeletionEnabled() {
            return this.mContext.getResources().getBoolean(R.bool.config_ignoreVibrationsOnWirelessCharger);
        }
    }

    private static final class LocalService extends AppHibernationManagerInternal {
        private final AppHibernationService mService;

        LocalService(AppHibernationService service) {
            this.mService = service;
        }

        @Override // com.android.server.apphibernation.AppHibernationManagerInternal
        public boolean isHibernatingForUser(String packageName, int userId) {
            return this.mService.isHibernatingForUser(packageName, userId);
        }

        @Override // com.android.server.apphibernation.AppHibernationManagerInternal
        public void setHibernatingForUser(String packageName, int userId, boolean isHibernating) {
            this.mService.setHibernatingForUser(packageName, userId, isHibernating);
        }

        @Override // com.android.server.apphibernation.AppHibernationManagerInternal
        public void setHibernatingGlobally(String packageName, boolean isHibernating) {
            this.mService.setHibernatingGlobally(packageName, isHibernating);
        }

        @Override // com.android.server.apphibernation.AppHibernationManagerInternal
        public boolean isHibernatingGlobally(String packageName) {
            return this.mService.isHibernatingGlobally(packageName);
        }

        @Override // com.android.server.apphibernation.AppHibernationManagerInternal
        public boolean isOatArtifactDeletionEnabled() {
            return AppHibernationService.m1707$$Nest$misOatArtifactDeletionEnabled(this.mService);
        }
    }

    private final class StatsPullAtomCallbackImpl implements StatsManager.StatsPullAtomCallback {
        private static final int MEGABYTE_IN_BYTES = 1000000;
        final /* synthetic */ AppHibernationService this$0;

        /* synthetic */ StatsPullAtomCallbackImpl(AppHibernationService r1, AppHibernationServiceIA r2) {
            this(r1);
        }

        private StatsPullAtomCallbackImpl(AppHibernationService r1) {
            this.this$0 = r1;
        }

        public int onPullAtom(int atomTag, List<StatsEvent> data) {
            if (AppHibernationService.isAppHibernationEnabled() == false) goto L5;
        L9:
            switch(atomTag) {
                case 10107: goto L27;
                case 10108: goto L10;
                case 10109: goto L12;
                default: goto L10;
            };
        L10:
            return 1;
        L12:
            int hibernatedAppCount = 0;
            long storage_saved_byte = 0;
            Object r4 = AppHibernationService.m1704$$Nest$fgetmLock(this.this$0);
            monitor-enter(r4);
            Iterator r5 = AppHibernationService.m1703$$Nest$fgetmGlobalHibernationStates(this.this$0).values().iterator();     // Catch: Throwable -> L20
        L16:
            if (r5.hasNext() == false) goto L23;
            GlobalLevelState state = (GlobalLevelState) r5.next();     // Catch: Throwable -> L20
            if (state.hibernated == false) goto L16;
            hibernatedAppCount = hibernatedAppCount + 1;     // Catch: Throwable -> L20
            storage_saved_byte = storage_saved_byte + state.savedByte;     // Catch: Throwable -> L20
            goto L16
        L23:
            monitor-exit(r4);     // Catch: Throwable -> L20
            data.add(FrameworkStatsLog.buildStatsEvent(atomTag, hibernatedAppCount, storage_saved_byte / 1000000));
        L34:
            return 0;
        L20:
            th = move-exception;
            throw th;
        L27:
            List<UserInfo> userInfos = AppHibernationService.m1705$$Nest$fgetmUserManager(this.this$0).getAliveUsers();
            int numUsers = userInfos.size();
            int i = 0;
        L28:
            if (i >= numUsers) goto L34;
            int userId = userInfos.get(i).id;
            if (AppHibernationService.m1705$$Nest$fgetmUserManager(this.this$0).isUserUnlockingOrUnlocked(userId) == false) goto L32;
            data.add(FrameworkStatsLog.buildStatsEvent(atomTag, this.this$0.getHibernatingPackagesForUser(userId).size(), userId));
        L32:
            i = i + 1;
            goto L28
        L5:
            if (atomTag != 10107) goto L7;
        L8:
            return 0;
        L7:
            if (atomTag != 10109) goto L9;
            goto L8
        }
    }

    public static /* synthetic */ void $r8$lambda$3HfMTVJhc1WapdDpoQXuXDMtFks(AppHibernationService r0, String r1, int r2) {
        r0.lambda$setHibernatingForUser$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Fws_Wf_jgjjpMDT6HEIS6H9GGIc(AppHibernationService r0) {
        r0.lambda$onBootPhase$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$VQ5tI_-mCe1y9rez4cVqHzkounA, reason: not valid java name */
    public static /* synthetic */ void m1700$r8$lambda$VQ5tI_mCe1y9rez4cVqHzkounA(UserLevelState r0, int r1) {
        lambda$setHibernatingForUser$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dnVAvtPQn-Iq4D0phPGD5byVE1w, reason: not valid java name */
    public static /* synthetic */ void m1701$r8$lambda$dnVAvtPQnIq4D0phPGD5byVE1w(AppHibernationService r0, DeviceConfig.Properties r1) {
        r0.onDeviceConfigChanged(r1);
    }

    public static /* synthetic */ void $r8$lambda$fT12eBCv0K0U7e7DCdE6loRthKg(AppHibernationService r0, int r1, UsageEvents.Event r2) {
        r0.lambda$new$6(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$opUpfhtJr-oO2TJqTn3WA57WfLw, reason: not valid java name */
    public static /* synthetic */ void m1702$r8$lambda$opUpfhtJroO2TJqTn3WA57WfLw(AppHibernationService r0, String r1, GlobalLevelState r2) {
        r0.lambda$setHibernatingGlobally$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$pmiSg0_3IcxhUY6KWcWtKuVRLt4(AppHibernationService r0, HibernationStateDiskStore r1, int r2) {
        r0.lambda$onUserUnlocking$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$tF9416fHhyawKHBQuNFp5SEq1cc(AppHibernationService r0, String r1, int r2, UserLevelState r3) {
        r0.lambda$setHibernatingForUser$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalHibernationStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m1703$$Nest$fgetmGlobalHibernationStates(AppHibernationService r0) {
        return r0.mGlobalHibernationStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1704$$Nest$fgetmLock(AppHibernationService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m1705$$Nest$fgetmUserManager(AppHibernationService r0) {
        return r0.mUserManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1706$$Nest$mdump(AppHibernationService r0, PrintWriter r1) {
        r0.dump(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misOatArtifactDeletionEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1707$$Nest$misOatArtifactDeletionEnabled(AppHibernationService r0) {
        return r0.isOatArtifactDeletionEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1708$$Nest$monPackageAdded(AppHibernationService r0, String r1, int r2) {
        r0.onPackageAdded(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1709$$Nest$monPackageRemoved(AppHibernationService r0, String r1, int r2) {
        r0.onPackageRemoved(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageRemovedForAllUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1710$$Nest$monPackageRemovedForAllUsers(AppHibernationService r0, String r1) {
        r0.onPackageRemovedForAllUsers(r1);
    }

    public AppHibernationService(Context context) {
        this(new InjectorImpl(context));
    }

    AppHibernationService(Injector injector) {
        super(injector.getContext());
        this.mLock = new Object();
        this.mUserStates = new SparseArray();
        this.mUserDiskStores = new SparseArray();
        this.mGlobalHibernationStates = new ArrayMap();
        this.mLocalService = new LocalService(this);
        this.mServiceStub = new AppHibernationServiceStub(this);
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mUsageEventListener = new AppHibernationService$$ExternalSyntheticLambda4(this);
        this.mContext = injector.getContext();
        this.mIPackageManager = injector.getPackageManager();
        this.mPackageManagerInternal = injector.getPackageManagerInternal();
        this.mIActivityManager = injector.getActivityManager();
        this.mUserManager = injector.getUserManager();
        this.mStorageStatsManager = injector.getStorageStatsManager();
        this.mGlobalLevelHibernationDiskStore = injector.getGlobalLevelDiskStore();
        this.mBackgroundExecutor = injector.getBackgroundExecutor();
        this.mOatArtifactDeletionEnabled = injector.isOatArtifactDeletionEnabled();
        this.mInjector = injector;
        Context userAllContext = this.mContext.createContextAsUser(UserHandle.ALL, 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        userAllContext.registerReceiver(this.mBroadcastReceiver, intentFilter);
        LocalServices.addService(AppHibernationManagerInternal.class, this.mLocalService);
        this.mInjector.getUsageStatsManagerInternal().registerListener(this.mUsageEventListener);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("app_hibernation", this.mServiceStub);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 1000) goto L6;
        this.mBackgroundExecutor.execute(new AppHibernationService$$ExternalSyntheticLambda5(this));
    L6:
        if (phase != 500) goto L9;
        sIsServiceEnabled = isDeviceConfigAppHibernationEnabled();
        DeviceConfig.addOnPropertiesChangedListener("app_hibernation", ActivityThread.currentApplication().getMainExecutor(), new AppHibernationService$$ExternalSyntheticLambda6(this));
        StatsManager statsManager = (StatsManager) getContext().getSystemService(StatsManager.class);
        StatsPullAtomCallbackImpl pullAtomCallback = new StatsPullAtomCallbackImpl(this, null);
        statsManager.setPullAtomCallback(FrameworkStatsLog.USER_LEVEL_HIBERNATED_APPS, null, this.mBackgroundExecutor, pullAtomCallback);
        statsManager.setPullAtomCallback(FrameworkStatsLog.GLOBAL_HIBERNATED_APPS, null, this.mBackgroundExecutor, pullAtomCallback);
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0() {
        List<GlobalLevelState> states = this.mGlobalLevelHibernationDiskStore.readHibernationStates();
        Object r1 = this.mLock;
        monitor-enter(r1);
        initializeGlobalHibernationStates(states);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isOatArtifactDeletionEnabled() {
        getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_APP_HIBERNATION", "Caller does not have MANAGE_APP_HIBERNATION permission.");
        return this.mOatArtifactDeletionEnabled;
    }

    boolean isHibernatingForUser(String packageName, int userId) {
        if (sIsServiceEnabled == true) goto L5;
        return false;
    L5:
        getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_APP_HIBERNATION", "Caller did not have permission while calling isHibernatingForUser");
        int userId2 = handleIncomingUser(userId, "isHibernatingForUser");
        Object r1 = this.mLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (checkUserStatesExist(userId2, "isHibernatingForUser", false) == true) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return false;
    L13:
        Map<String, UserLevelState> packageStates = this.mUserStates.get(userId2);     // Catch: Throwable -> L11
        UserLevelState pkgState = packageStates.get(packageName);     // Catch: Throwable -> L11
        if (pkgState != null) goto L16;
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return false;
    L16:
        if (this.mPackageManagerInternal.canQueryPackage(Binder.getCallingUid(), packageName) == false) goto L21;
        boolean r2 = pkgState.hibernated;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r2;
    }

    boolean isHibernatingGlobally(String packageName) {
        if (sIsServiceEnabled == true) goto L5;
        return false;
    L5:
        getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_APP_HIBERNATION", "Caller does not have MANAGE_APP_HIBERNATION permission.");
        Object r0 = this.mLock;
        monitor-enter(r0);
        GlobalLevelState state = this.mGlobalHibernationStates.get(packageName);     // Catch: Throwable -> L15
        if (state != null) goto L10;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L10:
        if (this.mPackageManagerInternal.canQueryPackage(Binder.getCallingUid(), packageName) == false) goto L17;
        boolean r1 = state.hibernated;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r1;
    L15:
        th = move-exception;
        throw th;
    }

    void setHibernatingForUser(final String packageName, int userId, boolean isHibernating) {
        if (sIsServiceEnabled == true) goto L5;
        return;
    L5:
        getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_APP_HIBERNATION", "Caller does not have MANAGE_APP_HIBERNATION permission.");
        final int realUserId = handleIncomingUser(userId, "setHibernatingForUser");
        Object r2 = this.mLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (checkUserStatesExist(realUserId, "setHibernatingForUser", true) == true) goto L14;
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L14:
        Map<String, UserLevelState> packageStates = this.mUserStates.get(realUserId);     // Catch: Throwable -> L12
        final UserLevelState pkgState = packageStates.get(packageName);     // Catch: Throwable -> L12
        if (pkgState != null) goto L17;
    L30:
        Slog.e(TAG, TextUtils.formatSimple("Package %s is not installed for user %s", new Object[]{packageName, Integer.valueOf(realUserId)}));     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L17:
        if (this.mPackageManagerInternal.canQueryPackage(Binder.getCallingUid(), packageName) == false) goto L30;
        if (pkgState.hibernated != isHibernating) goto L23;
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L23:
        pkgState.hibernated = isHibernating;     // Catch: Throwable -> L12
        if (isHibernating == false) goto L26;
        this.mBackgroundExecutor.execute(new AppHibernationService$$ExternalSyntheticLambda0(this, packageName, realUserId, pkgState));     // Catch: Throwable -> L12
    L27:
        final UserLevelState stateSnapshot = new UserLevelState(pkgState);     // Catch: Throwable -> L12
        this.mBackgroundExecutor.execute(new AppHibernationService$$ExternalSyntheticLambda2(stateSnapshot, realUserId));     // Catch: Throwable -> L12
        List<UserLevelState> states = new ArrayList(this.mUserStates.get(realUserId).values());     // Catch: Throwable -> L12
        this.mUserDiskStores.get(realUserId).scheduleWriteHibernationStates(states);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L26:
        this.mBackgroundExecutor.execute(new AppHibernationService$$ExternalSyntheticLambda1(this, packageName, realUserId));     // Catch: Throwable -> L12
        pkgState.lastUnhibernatedMs = System.currentTimeMillis();     // Catch: Throwable -> L12
        goto L27
    }

    private /* synthetic */ void lambda$setHibernatingForUser$1(String packageName, int realUserId, UserLevelState pkgState) {
        hibernatePackageForUser(packageName, realUserId, pkgState);
    }

    private /* synthetic */ void lambda$setHibernatingForUser$2(String packageName, int realUserId) {
        unhibernatePackageForUser(packageName, realUserId);
    }

    private static /* synthetic */ void lambda$setHibernatingForUser$3(UserLevelState stateSnapshot, int userIdSnapshot) {
        FrameworkStatsLog.write(FrameworkStatsLog.USER_LEVEL_HIBERNATION_STATE_CHANGED, stateSnapshot.packageName, userIdSnapshot, stateSnapshot.hibernated);
    }

    void setHibernatingGlobally(final String packageName, boolean isHibernating) {
        if (sIsServiceEnabled == true) goto L5;
        return;
    L5:
        getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_APP_HIBERNATION", "Caller does not have MANAGE_APP_HIBERNATION permission.");
        Object r0 = this.mLock;
        monitor-enter(r0);
        final GlobalLevelState state = this.mGlobalHibernationStates.get(packageName);     // Catch: Throwable -> L17
        if (state != null) goto L10;
    L23:
        Slog.e(TAG, TextUtils.formatSimple("Package %s is not installed for any user", new Object[]{packageName}));     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L10:
        if (this.mPackageManagerInternal.canQueryPackage(Binder.getCallingUid(), packageName) == false) goto L23;
        if (state.hibernated == isHibernating) goto L21;
        state.hibernated = isHibernating;     // Catch: Throwable -> L17
        if (isHibernating == false) goto L19;
        this.mBackgroundExecutor.execute(new AppHibernationService$$ExternalSyntheticLambda3(this, packageName, state));     // Catch: Throwable -> L17
    L20:
        List<GlobalLevelState> states = new ArrayList(this.mGlobalHibernationStates.values());     // Catch: Throwable -> L17
        this.mGlobalLevelHibernationDiskStore.scheduleWriteHibernationStates(states);     // Catch: Throwable -> L17
        goto L21
    L19:
        state.savedByte = 0;     // Catch: Throwable -> L17
        state.lastUnhibernatedMs = System.currentTimeMillis();     // Catch: Throwable -> L17
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setHibernatingGlobally$4(String packageName, GlobalLevelState state) {
        hibernatePackageGlobally(packageName, state);
    }

    List<String> getHibernatingPackagesForUser(int userId) {
        ArrayList<String> hibernatingPackages = new ArrayList();
        if (sIsServiceEnabled == true) goto L5;
        return hibernatingPackages;
    L5:
        getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_APP_HIBERNATION", "Caller does not have MANAGE_APP_HIBERNATION permission.");
        int userId2 = handleIncomingUser(userId, "getHibernatingPackagesForUser");
        Object r2 = this.mLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (checkUserStatesExist(userId2, "getHibernatingPackagesForUser", true) == true) goto L14;
        monitor-exit(r2);     // Catch: Throwable -> L12
        return hibernatingPackages;
    L14:
        Map<String, UserLevelState> userStates = this.mUserStates.get(userId2);     // Catch: Throwable -> L12
        Iterator<UserLevelState> r4 = userStates.values().iterator();     // Catch: Throwable -> L12
    L16:
        if (r4.hasNext() == false) goto L24;
        UserLevelState state = r4.next();     // Catch: Throwable -> L12
        String packageName = state.packageName;     // Catch: Throwable -> L12
        if (this.mPackageManagerInternal.canQueryPackage(Binder.getCallingUid(), packageName) == false) goto L16;
        if (state.hibernated == false) goto L16;
        hibernatingPackages.add(state.packageName);     // Catch: Throwable -> L12
        goto L16
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return hibernatingPackages;
    }

    public Map<String, HibernationStats> getHibernationStatsForUser(Set<String> packageNames, int userId) {
        Map<String, HibernationStats> statsMap = new ArrayMap();
        if (sIsServiceEnabled == true) goto L5;
        return statsMap;
    L5:
        getContext().enforceCallingOrSelfPermission("android.permission.MANAGE_APP_HIBERNATION", "Caller does not have MANAGE_APP_HIBERNATION permission.");
        int userId2 = handleIncomingUser(userId, "getHibernationStatsForUser");
        Object r2 = this.mLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (checkUserStatesExist(userId2, "getHibernationStatsForUser", true) == true) goto L14;
        monitor-exit(r2);     // Catch: Throwable -> L12
        return statsMap;
    L14:
        Map<String, UserLevelState> userPackageStates = this.mUserStates.get(userId2);     // Catch: Throwable -> L12
        if (packageNames == null) goto L17;
        Set<String> pkgs = packageNames;
    L18:
        Iterator<String> r5 = pkgs.iterator();     // Catch: Throwable -> L12
    L20:
        if (r5.hasNext() == false) goto L31;
        String pkgName = r5.next();     // Catch: Throwable -> L12
        if (this.mPackageManagerInternal.canQueryPackage(Binder.getCallingUid(), pkgName) == false) goto L20;
        if (this.mGlobalHibernationStates.containsKey(pkgName) == false) goto L30;
        if (userPackageStates.containsKey(pkgName) == false) goto L30;
        long diskBytesSaved = this.mGlobalHibernationStates.get(pkgName).savedByte + userPackageStates.get(pkgName).savedByte;     // Catch: Throwable -> L12
        HibernationStats stats = new HibernationStats(diskBytesSaved);     // Catch: Throwable -> L12
        statsMap.put(pkgName, stats);     // Catch: Throwable -> L12
    L30:
        Slog.w(TAG, TextUtils.formatSimple("No hibernation state associated with package %s user %d. Maybethe package was uninstalled? ", new Object[]{pkgName, Integer.valueOf(userId2)}));     // Catch: Throwable -> L12
        goto L20
    L31:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return statsMap;
    L17:
        pkgs = userPackageStates.keySet();     // Catch: Throwable -> L12
        goto L18
    }

    private void hibernatePackageForUser(String packageName, int userId, UserLevelState state) {
        Trace.traceBegin(524288, "hibernatePackage");
        long caller = Binder.clearCallingIdentity();
        ApplicationInfo info = this.mIPackageManager.getApplicationInfo(packageName, PACKAGE_MATCH_FLAGS, userId);     // Catch: Throwable -> L11 IOException -> L13 PackageManager.NameNotFoundException -> L15 RemoteException -> L17
        StorageStats stats = this.mStorageStatsManager.queryStatsForPackage(info.storageUuid, packageName, new UserHandle(userId));     // Catch: Throwable -> L11 IOException -> L13 PackageManager.NameNotFoundException -> L15 RemoteException -> L17
        noteHibernationChange(packageName, info.uid, true);     // Catch: Throwable -> L11 IOException -> L13 PackageManager.NameNotFoundException -> L15 RemoteException -> L17
        this.mIActivityManager.forceStopPackage(packageName, userId);     // Catch: Throwable -> L11 IOException -> L13 PackageManager.NameNotFoundException -> L15 RemoteException -> L17
        this.mIPackageManager.deleteApplicationCacheFilesAsUser(packageName, userId, null);     // Catch: Throwable -> L11 IOException -> L13 PackageManager.NameNotFoundException -> L15 RemoteException -> L17
        Object r6 = this.mLock;     // Catch: Throwable -> L11 IOException -> L13 PackageManager.NameNotFoundException -> L15 RemoteException -> L17
        monitor-enter(r6);     // Catch: Throwable -> L11 IOException -> L13 PackageManager.NameNotFoundException -> L15 RemoteException -> L17
        state.savedByte = stats.getCacheBytes();     // Catch: Throwable -> L8
        monitor-exit(r6);     // Catch: Throwable -> L8
    L7:
        Binder.restoreCallingIdentity(caller);
        Trace.traceEnd(524288);
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11 IOException -> L13 PackageManager.NameNotFoundException -> L15 RemoteException -> L17
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(caller);
        Trace.traceEnd(524288);
        throw th;
    L13:
        e = move-exception;
        Slog.e(TAG, "Storage device not found", e);     // Catch: Throwable -> L11
    L15:
        e = move-exception;
        Slog.e(TAG, "Package name not found when querying storage stats", e);     // Catch: Throwable -> L11
    L17:
        e = move-exception;
        throw new IllegalStateException("Failed to hibernate due to manager not being available", e);     // Catch: Throwable -> L11
    }

    private void unhibernatePackageForUser(String packageName, int userId) {
        Trace.traceBegin(524288, "unhibernatePackage");
        long caller = Binder.clearCallingIdentity();
        ApplicationInfo info = this.mIPackageManager.getApplicationInfo(packageName, PACKAGE_MATCH_FLAGS, userId);     // Catch: Throwable -> L6 RemoteException -> L8
        noteHibernationChange(packageName, info.uid, false);     // Catch: Throwable -> L6 RemoteException -> L8
        Intent lockedBcIntent = new Intent("android.intent.action.LOCKED_BOOT_COMPLETED").setPackage(packageName);     // Catch: Throwable -> L6 RemoteException -> L8
        String[] requiredPermissions = {"android.permission.RECEIVE_BOOT_COMPLETED"};     // Catch: Throwable -> L6 RemoteException -> L8
        this.mIActivityManager.broadcastIntentWithFeature(null, null, lockedBcIntent, null, null, -1, null, null, requiredPermissions, null, null, -1, null, false, false, userId);     // Catch: Throwable -> L6 RemoteException -> L8
        Intent bcIntent = new Intent("android.intent.action.BOOT_COMPLETED").setPackage(packageName);     // Catch: Throwable -> L6 RemoteException -> L8
        this.mIActivityManager.broadcastIntentWithFeature(null, null, bcIntent, null, null, -1, null, null, requiredPermissions, null, null, -1, null, false, false, userId);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(caller);
        Trace.traceEnd(524288);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(caller);
        Trace.traceEnd(524288);
        throw th;
    L8:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L6
    }

    private void hibernatePackageGlobally(String packageName, GlobalLevelState state) {
        Trace.traceBegin(524288, "hibernatePackageGlobally");
        long savedBytes = 0;
        if (this.mOatArtifactDeletionEnabled == false) goto L5;
        savedBytes = Math.max(this.mPackageManagerInternal.deleteOatArtifactsOfPackage(packageName), 0);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        state.savedByte = savedBytes;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Trace.traceEnd(524288);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void noteHibernationChange(String packageName, int uid, boolean hibernated) {
        if (hibernated == false) goto L19;
        this.mIActivityManager.noteAppRestrictionEnabled(packageName, uid, 60, true, 2, null, 3, 7776000000L);     // Catch: RemoteException -> L7
        return;
    L11:
        Slog.e(TAG, "Couldn't set restriction state change");
        return;
    }

    private void initializeUserHibernationStates(int userId, List<UserLevelState> diskStates) {
        List<PackageInfo> packages = this.mIPackageManager.getInstalledPackages(PACKAGE_MATCH_FLAGS, userId).getList();     // Catch: RemoteException -> L27
        Map<String, UserLevelState> userLevelStates = new ArrayMap();
        int i = 0;
        int size = packages.size();
    L4:
        if (i >= size) goto L7;
        String packageName = packages.get(i).packageName;
        UserLevelState state = new UserLevelState();
        state.packageName = packageName;
        userLevelStates.put(packageName, state);
        i = i + 1;
        goto L4
    L7:
        if (diskStates == null) goto L25;
        Map<String, PackageInfo> installedPackages = new ArrayMap();
        int i2 = 0;
        int size2 = packages.size();
    L9:
        if (i2 >= size2) goto L11;
        installedPackages.put(packages.get(i2).packageName, packages.get(i2));
        i2 = i2 + 1;
        goto L9
    L11:
        int i3 = 0;
        int size3 = diskStates.size();
    L12:
        if (i3 >= size3) goto L25;
        String packageName2 = diskStates.get(i3).packageName;
        PackageInfo pkgInfo = installedPackages.get(packageName2);
        UserLevelState currentState = diskStates.get(i3);
        if (pkgInfo != null) goto L17;
        Slog.w(TAG, TextUtils.formatSimple("No hibernation state associated with package %s user %d. Maybethe package was uninstalled? ", new Object[]{packageName2, Integer.valueOf(userId)}));
    L24:
        i3 = i3 + 1;
        goto L12
    L17:
        if (pkgInfo.applicationInfo == null) goto L23;
        ApplicationInfo r8 = pkgInfo.applicationInfo;
        int r9 = r8.flags & 2097152;
        r8.flags = r9;
        if (r9 != 0) goto L23;
        if (currentState.hibernated == false) goto L23;
        currentState.hibernated = false;
        currentState.lastUnhibernatedMs = System.currentTimeMillis();
    L23:
        userLevelStates.put(packageName2, currentState);
    L25:
        this.mUserStates.put(userId, userLevelStates);
        return;
    L27:
        e = move-exception;
        throw new IllegalStateException("Package manager not available", e);
    }

    private void initializeGlobalHibernationStates(List<GlobalLevelState> diskStates) {
        List<PackageInfo> packages = this.mIPackageManager.getInstalledPackages(541893120, 0).getList();     // Catch: RemoteException -> L19
        int i = 0;
        int size = packages.size();
    L4:
        if (i >= size) goto L7;
        String packageName = packages.get(i).packageName;
        GlobalLevelState state = new GlobalLevelState();
        state.packageName = packageName;
        this.mGlobalHibernationStates.put(packageName, state);
        i = i + 1;
        goto L4
    L7:
        if (diskStates == null) goto L18;
        Set<String> installedPackages = new ArraySet();
        int i2 = 0;
        int size2 = packages.size();
    L9:
        if (i2 >= size2) goto L11;
        installedPackages.add(packages.get(i2).packageName);
        i2 = i2 + 1;
        goto L9
    L11:
        int i3 = 0;
        int size3 = diskStates.size();
    L12:
        if (i3 >= size3) goto L29;
        GlobalLevelState state2 = diskStates.get(i3);
        if (installedPackages.contains(state2.packageName) == true) goto L16;
        Slog.w(TAG, TextUtils.formatSimple("No hibernation state associated with package %s. Maybe the package was uninstalled? ", new Object[]{state2.packageName}));
    L17:
        i3 = i3 + 1;
        goto L12
    L16:
        this.mGlobalHibernationStates.put(state2.packageName, state2);
        goto L17
    L29:
        return;
    L18:
        return;
    L19:
        e = move-exception;
        throw new IllegalStateException("Package manager not available", e);
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        final int userId = user.getUserIdentifier();
        final HibernationStateDiskStore<UserLevelState> diskStore = this.mInjector.getUserLevelDiskStore(userId);
        this.mUserDiskStores.put(userId, diskStore);
        this.mBackgroundExecutor.execute(new AppHibernationService$$ExternalSyntheticLambda7(this, diskStore, userId));
    }

    private /* synthetic */ void lambda$onUserUnlocking$5(HibernationStateDiskStore diskStore, int userId) {
        List<UserLevelState> storedStates = diskStore.readHibernationStates();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == false) goto L17;
        initializeUserHibernationStates(userId, storedStates);     // Catch: Throwable -> L14
        Iterator<UserLevelState> r2 = this.mUserStates.get(userId).values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r2.hasNext() == false) goto L17;
        UserLevelState userState = r2.next();     // Catch: Throwable -> L14
        String pkgName = userState.packageName;     // Catch: Throwable -> L14
        GlobalLevelState globalState = this.mGlobalHibernationStates.get(pkgName);     // Catch: Throwable -> L14
        if (globalState.hibernated == false) goto L8;
        if (userState.hibernated == true) goto L8;
        setHibernatingGlobally(pkgName, false);     // Catch: Throwable -> L14
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L14
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        int userId = user.getUserIdentifier();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mUserDiskStores.remove(userId);     // Catch: Throwable -> L7
        this.mUserStates.remove(userId);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onPackageAdded(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserStates.contains(userId) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        UserLevelState userState = new UserLevelState();     // Catch: Throwable -> L8
        userState.packageName = packageName;     // Catch: Throwable -> L8
        this.mUserStates.get(userId).put(packageName, userState);     // Catch: Throwable -> L8
        if (this.mGlobalHibernationStates.containsKey(packageName) == true) goto L13;
        GlobalLevelState globalState = new GlobalLevelState();     // Catch: Throwable -> L8
        globalState.packageName = packageName;     // Catch: Throwable -> L8
        this.mGlobalHibernationStates.put(packageName, globalState);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void onPackageRemoved(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserStates.contains(userId) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mUserStates.get(userId).remove(packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void onPackageRemovedForAllUsers(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mGlobalHibernationStates.remove(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onDeviceConfigChanged(DeviceConfig.Properties properties) {
        Iterator r0 = properties.getKeyset().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        String key = (String) r0.next();
        if (TextUtils.equals("app_hibernation_enabled", key) == false) goto L4;
        sIsServiceEnabled = isDeviceConfigAppHibernationEnabled();
        Slog.d(TAG, "App hibernation changed to enabled=" + sIsServiceEnabled);
        return;
    }

    private int handleIncomingUser(int userId, String name) {
        int callingUid = Binder.getCallingUid();
        return this.mIActivityManager.handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, true, name, null);
    L7:
        e = move-exception;
        RemoteException re = e;
    L12:
        throw re.rethrowFromSystemServer();
    L9:
        e = move-exception;
        re = e;
        goto L12
    }

    private boolean checkUserStatesExist(int userId, String methodName, boolean shouldLog) {
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L8;
        if (shouldLog == false) goto L6;
        Slog.w(TAG, TextUtils.formatSimple("Attempt to call %s on stopped or nonexistent user %d", new Object[]{methodName, Integer.valueOf(userId)}));
    L6:
        return false;
    L8:
        if (this.mUserStates.contains(userId) == true) goto L12;
        if (shouldLog == false) goto L11;
        Slog.w(TAG, TextUtils.formatSimple("Attempt to call %s before states have been read from disk", new Object[]{methodName}));
    L11:
        return false;
    L12:
        return true;
    }

    private void dump(PrintWriter pw) {
        if (DumpUtils.checkDumpAndUsageStatsPermission(getContext(), TAG, pw) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter idpw = new IndentingPrintWriter(pw, "  ");
        Object r1 = this.mLock;
        monitor-enter(r1);
        int userCount = this.mUserStates.size();     // Catch: Throwable -> L13
        int i = 0;
    L8:
        if (i >= userCount) goto L16;
        int userId = this.mUserStates.keyAt(i);     // Catch: Throwable -> L13
        idpw.print("User Level Hibernation States, ");     // Catch: Throwable -> L13
        idpw.printPair("user", Integer.valueOf(userId));     // Catch: Throwable -> L13
        idpw.println();     // Catch: Throwable -> L13
        Map<String, UserLevelState> stateMap = this.mUserStates.get(userId);     // Catch: Throwable -> L13
        idpw.increaseIndent();     // Catch: Throwable -> L13
        Iterator<UserLevelState> r6 = stateMap.values().iterator();     // Catch: Throwable -> L13
    L11:
        if (r6.hasNext() == false) goto L15;
        UserLevelState state = r6.next();     // Catch: Throwable -> L13
        idpw.print(state);     // Catch: Throwable -> L13
        idpw.println();     // Catch: Throwable -> L13
        goto L11
    L15:
        idpw.decreaseIndent();     // Catch: Throwable -> L13
        i = i + 1;     // Catch: Throwable -> L13
        goto L8
    L16:
        idpw.println();     // Catch: Throwable -> L13
        idpw.print("Global Level Hibernation States");     // Catch: Throwable -> L13
        idpw.println();     // Catch: Throwable -> L13
        Iterator<GlobalLevelState> r3 = this.mGlobalHibernationStates.values().iterator();     // Catch: Throwable -> L13
    L18:
        if (r3.hasNext() == false) goto L20;
        GlobalLevelState state2 = r3.next();     // Catch: Throwable -> L13
        idpw.print(state2);     // Catch: Throwable -> L13
        idpw.println();     // Catch: Throwable -> L13
        goto L18
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$6(int userId, UsageEvents.Event event) {
        if (isAppHibernationEnabled() == true) goto L5;
        return;
    L5:
        int eventType = event.mEventType;
        if (eventType != 7) goto L8;
    L11:
        String pkgName = event.mPackage;
        setHibernatingForUser(pkgName, userId, false);
        setHibernatingGlobally(pkgName, false);
        return;
    L8:
        if (eventType == 1) goto L11;
        if (eventType == 31) goto L11;
    }

    public static boolean isAppHibernationEnabled() {
        return sIsServiceEnabled;
    }

    private static boolean isDeviceConfigAppHibernationEnabled() {
        return DeviceConfig.getBoolean("app_hibernation", "app_hibernation_enabled", true);
    }
}
