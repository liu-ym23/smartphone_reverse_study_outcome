package com.android.server.pm;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManagerInternal;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IBackgroundInstallControlService;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IRemoteCallback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArrayMap;
import android.util.SparseSetArray;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class BackgroundInstallControlService extends SystemService {
    private static final String DISK_DIR_NAME = "bic";
    private static final String DISK_FILE_NAME = "states";
    private static final String ENFORCE_PERMISSION_ERROR_MSG = "User is not permitted to call service: ";
    public static final int INSTALL_EVENT_TYPE_INSTALL = 1;
    public static final int INSTALL_EVENT_TYPE_UNINSTALL = 2;
    public static final int INSTALL_EVENT_TYPE_UNKNOWN = 0;
    private static final int MAX_FOREGROUND_TIME_FRAMES_SIZE = 10;
    private static final int MSG_PACKAGE_ADDED = 1;
    private static final int MSG_PACKAGE_REMOVED = 2;
    private static final int MSG_USAGE_EVENT_RECEIVED = 0;
    private static final String TAG = "BackgroundInstallControlService";
    private SparseSetArray<String> mBackgroundInstalledPackages;
    private final BinderService mBinderService;
    private final BackgroundInstallControlCallbackHelper mCallbackHelper;
    private final Context mContext;
    private final File mDiskFile;
    private final Handler mHandler;
    private final SparseArrayMap<String, TreeSet<ForegroundTimeFrame>> mInstallerForegroundTimeFrames;
    private final PackageManager mPackageManager;
    private final PackageManagerInternal mPackageManagerInternal;
    protected final PackageManagerInternal.PackageListObserver mPackageObserver;
    private final PermissionManagerServiceInternal mPermissionManager;

    private static final class BinderService extends IBackgroundInstallControlService.Stub {
        final BackgroundInstallControlService mService;

        BinderService(BackgroundInstallControlService service) {
            this.mService = service;
        }

        public ParceledListSlice<PackageInfo> getBackgroundInstalledPackages(long flags, int userId) {
            this.mService.enforceCallerPermissions();
            String propertyString = SystemProperties.get("debug.transparency.bg-install-apps");
            if (TextUtils.isEmpty(propertyString) == true) goto L10;
            if (Build.IS_DEBUGGABLE == false) goto L10;
            return this.mService.getMockBackgroundInstalledPackages(propertyString);
        L10:
            return this.mService.getBackgroundInstalledPackages(flags, userId);
        }

        public void registerBackgroundInstallCallback(IRemoteCallback callback) {
            BackgroundInstallControlService.m6608$$Nest$fgetmCallbackHelper(this.mService).registerBackgroundInstallCallback(callback);
        }

        public void unregisterBackgroundInstallCallback(IRemoteCallback callback) {
            BackgroundInstallControlService.m6608$$Nest$fgetmCallbackHelper(this.mService).unregisterBackgroundInstallCallback(callback);
        }
    }

    private static class EventHandler extends Handler {
        private final BackgroundInstallControlService mService;

        EventHandler(Looper looper, BackgroundInstallControlService service) {
            super(looper);
            this.mService = service;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Slog.d(BackgroundInstallControlService.TAG, "Package event received: " + msg.what);
            switch(msg.what) {
                case 0: goto L7;
                case 1: goto L6;
                case 2: goto L5;
                default: goto L4;
            };
        L4:
            Slog.w(BackgroundInstallControlService.TAG, "Unknown message: " + msg.what);
            return;
        L5:
            this.mService.handlePackageRemove((String) msg.obj, msg.arg1);
            return;
        L6:
            this.mService.handlePackageAdd((String) msg.obj, msg.arg1);
            return;
        L7:
            this.mService.handleUsageEvent((UsageEvents.Event) msg.obj, msg.arg1);
        }
    }

    static final class ForegroundTimeFrame implements Comparable<ForegroundTimeFrame> {
        public final Set<Integer> activities;
        public long endTimeStampMillis;
        public final long startTimeStampMillis;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ForegroundTimeFrame r1) {
            return compareTo2(r1);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ForegroundTimeFrame o) {
            int comp = Long.compare(this.startTimeStampMillis, o.startTimeStampMillis);
            if (comp == 0) goto L6;
            return comp;
        L6:
            return Integer.compare(hashCode(), o.hashCode());
        }

        ForegroundTimeFrame(long startTimeStampMillis) {
            this.startTimeStampMillis = startTimeStampMillis;
            this.endTimeStampMillis = 0;
            this.activities = new ArraySet();
        }

        public boolean isDone() {
            if (this.endTimeStampMillis == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void addEvent(UsageEvents.Event event) {
            switch(event.mEventType) {
                case 1: goto L10;
                case 2: goto L6;
                case 23: goto L6;
                default: goto L15;
            };
        L10:
            this.activities.add(Integer.valueOf(event.mInstanceId));
            return;
        L15:
            return;
        L6:
            if (this.activities.contains(Integer.valueOf(event.mInstanceId)) == false) goto L12;
            this.activities.remove(Integer.valueOf(event.mInstanceId));
            if (this.activities.size() != 0) goto L13;
            this.endTimeStampMillis = event.mTimeStamp;
            return;
        L13:
            return;
        }
    }

    interface Injector {
        BackgroundInstallControlCallbackHelper getBackgroundInstallControlCallbackHelper();

        Context getContext();

        File getDiskFile();

        Looper getLooper();

        PackageManager getPackageManager();

        PackageManagerInternal getPackageManagerInternal();

        PermissionManagerServiceInternal getPermissionManager();

        UsageStatsManagerInternal getUsageStatsManagerInternal();
    }

    private static final class InjectorImpl implements Injector {
        private final Context mContext;

        InjectorImpl(Context context) {
            this.mContext = context;
        }

        @Override // com.android.server.pm.BackgroundInstallControlService.Injector
        public Context getContext() {
            return this.mContext;
        }

        @Override // com.android.server.pm.BackgroundInstallControlService.Injector
        public PackageManager getPackageManager() {
            return this.mContext.getPackageManager();
        }

        @Override // com.android.server.pm.BackgroundInstallControlService.Injector
        public PackageManagerInternal getPackageManagerInternal() {
            return (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        }

        @Override // com.android.server.pm.BackgroundInstallControlService.Injector
        public UsageStatsManagerInternal getUsageStatsManagerInternal() {
            return (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        }

        @Override // com.android.server.pm.BackgroundInstallControlService.Injector
        public PermissionManagerServiceInternal getPermissionManager() {
            return (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
        }

        @Override // com.android.server.pm.BackgroundInstallControlService.Injector
        public Looper getLooper() {
            ServiceThread serviceThread = new ServiceThread(BackgroundInstallControlService.TAG, -2, true);
            serviceThread.start();
            return serviceThread.getLooper();
        }

        @Override // com.android.server.pm.BackgroundInstallControlService.Injector
        public File getDiskFile() {
            File dir = new File(Environment.getDataSystemDirectory(), BackgroundInstallControlService.DISK_DIR_NAME);
            File file = new File(dir, BackgroundInstallControlService.DISK_FILE_NAME);
            return file;
        }

        @Override // com.android.server.pm.BackgroundInstallControlService.Injector
        public BackgroundInstallControlCallbackHelper getBackgroundInstallControlCallbackHelper() {
            return new BackgroundInstallControlCallbackHelper();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InstallEventType {
    }

    public static /* synthetic */ void $r8$lambda$Ii6fFjkYscgJbLxp4fiuTNLoT7c(StringBuilder r0, int r1, String r2) {
        lambda$getBackgroundInstalledPackages$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$hszxYcBNn367LxTqmV-LFsN7dNI, reason: not valid java name */
    public static /* synthetic */ boolean m6606$r8$lambda$hszxYcBNn367LxTqmVLFsN7dNI(String r0, PackageInstaller.SessionInfo r1) {
        return lambda$getLatestInstallSession$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$r3_D5ZCfbKAc8o--pXGNM2kXs6w, reason: not valid java name */
    public static /* synthetic */ void m6607$r8$lambda$r3_D5ZCfbKAc8opXGNM2kXs6w(BackgroundInstallControlService r0, int r1, UsageEvents.Event r2) {
        r0.lambda$new$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbackHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackgroundInstallControlCallbackHelper m6608$$Nest$fgetmCallbackHelper(BackgroundInstallControlService r0) {
        return r0.mCallbackHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6609$$Nest$fgetmHandler(BackgroundInstallControlService r0) {
        return r0.mHandler;
    }

    public BackgroundInstallControlService(Context context) {
        this(new InjectorImpl(context));
    }

    BackgroundInstallControlService(Injector injector) {
        super(injector.getContext());
        this.mBackgroundInstalledPackages = null;
        this.mInstallerForegroundTimeFrames = new SparseArrayMap();
        this.mPackageObserver = new AnonymousClass1(this);
        this.mPackageManager = injector.getPackageManager();
        this.mPackageManagerInternal = injector.getPackageManagerInternal();
        this.mPermissionManager = injector.getPermissionManager();
        this.mHandler = new EventHandler(injector.getLooper(), this);
        this.mDiskFile = injector.getDiskFile();
        this.mContext = injector.getContext();
        this.mCallbackHelper = injector.getBackgroundInstallControlCallbackHelper();
        UsageStatsManagerInternal usageStatsManagerInternal = injector.getUsageStatsManagerInternal();
        usageStatsManagerInternal.registerListener(new BackgroundInstallControlService$$ExternalSyntheticLambda2(this));
        this.mBinderService = new BinderService(this);
    }

    private /* synthetic */ void lambda$new$0(int userId, UsageEvents.Event event) {
        this.mHandler.obtainMessage(0, userId, 0, event).sendToTarget();
    }

    void enforceCallerPermissions() throws SecurityException {
        this.mContext.enforceCallingOrSelfPermission("android.permission.GET_BACKGROUND_INSTALLED_PACKAGES", "User is not permitted to call service: android.permission.GET_BACKGROUND_INSTALLED_PACKAGES");
    }

    ParceledListSlice<PackageInfo> getBackgroundInstalledPackages(long flags, int userId) {
        long token = Binder.clearCallingIdentity();
        List<PackageInfo> packages = this.mPackageManager.getInstalledPackagesAsUser(PackageManager.PackageInfoFlags.of(flags), userId);     // Catch: Throwable -> L10
        initBackgroundInstalledPackages();     // Catch: Throwable -> L10
        if (Build.IS_DEBUGGABLE == false) goto L13;
        final StringBuilder sb = new StringBuilder();     // Catch: Throwable -> L10
        sb.append("Tracked background installed package size: ");     // Catch: Throwable -> L10
        sb.append(this.mBackgroundInstalledPackages.size());     // Catch: Throwable -> L10
        sb.append("\n");     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= this.mBackgroundInstalledPackages.size()) goto L12;
        final int installingUserId = this.mBackgroundInstalledPackages.keyAt(i);     // Catch: Throwable -> L10
        this.mBackgroundInstalledPackages.get(installingUserId).forEach(new BackgroundInstallControlService$$ExternalSyntheticLambda3(sb, installingUserId));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        Slog.d(TAG, "Tracked background installed package: " + sb.toString());     // Catch: Throwable -> L10
    L13:
        ListIterator<PackageInfo> iter = packages.listIterator();     // Catch: Throwable -> L10
    L15:
        if (iter.hasNext() == false) goto L23;
        String packageName = iter.next().packageName;     // Catch: Throwable -> L10
        if (this.mBackgroundInstalledPackages.contains(userId, packageName) == true) goto L15;
        if (Build.IS_DEBUGGABLE == false) goto L21;
        Slog.d(TAG, packageName + " is not tracked, removing");     // Catch: Throwable -> L10
    L21:
        iter.remove();     // Catch: Throwable -> L10
        goto L15
    L23:
        ParceledListSlice<PackageInfo> r4 = new ParceledListSlice(packages);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return r4;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private static /* synthetic */ void lambda$getBackgroundInstalledPackages$1(StringBuilder sb, int installingUserId, String pkgName) {
        sb.append("userId: ");
        sb.append(installingUserId);
        sb.append(", name: ");
        sb.append(pkgName);
        sb.append("\n");
    }

    ParceledListSlice<PackageInfo> getMockBackgroundInstalledPackages(String propertyString) {
        String[] mockPackageNames = propertyString.split(",");
        List<PackageInfo> mockPackages = new ArrayList();
        int r2 = mockPackageNames.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L11;
        String name = mockPackageNames[r3];
        PackageInfo packageInfo = this.mPackageManager.getPackageInfo(name, PackageManager.PackageInfoFlags.of(131072));     // Catch: PackageManager.NameNotFoundException -> L7
        mockPackages.add(packageInfo);     // Catch: PackageManager.NameNotFoundException -> L7
    L9:
        r3 = r3 + 1;
    L8:
        Slog.w(TAG, "Package's PackageInfo not found " + name);
        goto L9
    L11:
        return new ParceledListSlice(mockPackages);
    }

    void handlePackageAdd(String packageName, int userId) {
        if (Build.IS_DEBUGGABLE == false) goto L31;
        Slog.d(TAG, "handlePackageAdd: checking " + packageName);
    L31:
        ApplicationInfo appInfo = this.mPackageManager.getApplicationInfoAsUser(packageName, PackageManager.ApplicationInfoFlags.of(0), userId);     // Catch: PackageManager.NameNotFoundException -> L28
        InstallSourceInfo installInfo = this.mPackageManager.getInstallSourceInfo(packageName);     // Catch: PackageManager.NameNotFoundException -> L25
        String installerPackageName = installInfo.getInstallingPackageName();     // Catch: PackageManager.NameNotFoundException -> L25
        String initiatingPackageName = installInfo.getInitiatingPackageName();     // Catch: PackageManager.NameNotFoundException -> L25
        if (this.mPermissionManager.checkPermission(installerPackageName, "android.permission.INSTALL_PACKAGES", "default:0", userId) != 0) goto L11;
        long installTimestamp = System.currentTimeMillis() - (SystemClock.uptimeMillis() - retrieveInstallStartTimestamp(packageName, userId, appInfo));
        if (installedByAdb(initiatingPackageName) == true) goto L22;
        if (wasForegroundInstallation(installerPackageName, userId, installTimestamp) == true) goto L22;
        Slog.d(TAG, "handlePackageAdd: adding " + packageName + " from " + userId + " and notifying callbacks");
        initBackgroundInstalledPackages();
        this.mBackgroundInstalledPackages.add(userId, packageName);
        this.mCallbackHelper.notifyAllCallbacks(userId, packageName, 1);
        writeBackgroundInstalledPackagesToDisk();
        return;
    L22:
        if (Build.IS_DEBUGGABLE == false) goto L36;
        Slog.d(TAG, "handlePackageAdd " + packageName + ": is installed by ADB or was foreground installation, skipping");
        return;
    L36:
        return;
    L11:
        if (Build.IS_DEBUGGABLE == false) goto L35;
        Slog.d(TAG, "handlePackageAdd " + packageName + ": installer (" + installerPackageName + ") doesn't have INSTALL_PACKAGES permission, skipping");
        return;
    L35:
        return;
    L26:
        Slog.w(TAG, "Package's installer not found: " + packageName);
        return;
    L29:
        Slog.w(TAG, "Package's appInfo not found " + packageName);
    }

    private long retrieveInstallStartTimestamp(String packageName, int userId, ApplicationInfo appInfo) {
        long installStartTimestamp = appInfo.createTimestamp;
        Optional<PackageInstaller.SessionInfo> latestInstallSession = getLatestInstallSession(packageName, userId);     // Catch: Exception -> L6
        if (latestInstallSession.isEmpty() == false) goto L9;
        Slog.w(TAG, "Package's historical install session not found, falling back to appInfo.createTimestamp: " + packageName);     // Catch: Exception -> L6
    L13:
    L12:
        return installStartTimestamp;
    L9:
        installStartTimestamp = latestInstallSession.get().getCreatedMillis();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Slog.w(TAG, "Retrieval of install time from historical session failed, falling back to appInfo.createTimestamp");
        Slog.w(TAG, Log.getStackTraceString(e));
        goto L12
    }

    private Optional<PackageInstaller.SessionInfo> getLatestInstallSession(final String packageName, int userId) {
        List<PackageInstaller.SessionInfo> historicalSessions = this.mPackageManagerInternal.getHistoricalSessions(userId).getList();
        return historicalSessions.stream().filter(new BackgroundInstallControlService$$ExternalSyntheticLambda0(packageName)).max(Comparator.comparingLong(new BackgroundInstallControlService$$ExternalSyntheticLambda1()));
    }

    private static /* synthetic */ boolean lambda$getLatestInstallSession$2(String packageName, PackageInstaller.SessionInfo s) {
        return packageName.equals(s.getAppPackageName());
    }

    private boolean installedByAdb(String initiatingPackageName) {
        if (SystemProperties.get("debug.gts.transparency.bg-install-apps").isEmpty() == true) goto L6;
        Slog.d(TAG, "handlePackageAdd: is GTS tests, skipping ADB check");
        return false;
    L6:
        if (PackageManagerServiceUtils.isInstalledByAdb(initiatingPackageName) == false) goto L11;
        Slog.d(TAG, "handlePackageAdd: is installed by ADB, skipping");
        return true;
    L11:
        return false;
    }

    private boolean wasForegroundInstallation(String installerPackageName, int userId, long installTimestamp) {
        TreeSet<ForegroundTimeFrame> foregroundTimeFrames = (TreeSet) this.mInstallerForegroundTimeFrames.get(userId, installerPackageName);
        if (foregroundTimeFrames != null) goto L5;
        return false;
    L5:
        Iterator<ForegroundTimeFrame> r2 = foregroundTimeFrames.iterator();
    L7:
        if (r2.hasNext() == false) goto L18;
        ForegroundTimeFrame foregroundTimeFrame = r2.next();
        if (foregroundTimeFrame.startTimeStampMillis > installTimestamp) goto L7;
        if (foregroundTimeFrame.isDone() == false) goto L13;
        if (installTimestamp > foregroundTimeFrame.endTimeStampMillis) goto L7;
        return true;
    L13:
        return true;
    L18:
        return false;
    }

    void handlePackageRemove(String packageName, int userId) {
        initBackgroundInstalledPackages();
        if (this.mBackgroundInstalledPackages.contains(userId, packageName) == false) goto L5;
        this.mCallbackHelper.notifyAllCallbacks(userId, packageName, 2);
    L5:
        Slog.d(TAG, "handlePackageRemove: removing " + packageName + " from " + userId);
        this.mBackgroundInstalledPackages.remove(userId, packageName);
        writeBackgroundInstalledPackagesToDisk();
    }

    void handleUsageEvent(UsageEvents.Event event, int userId) {
        if (event.mEventType == 1) goto L10;
        if (event.mEventType == 2) goto L10;
        if (event.mEventType == 23) goto L10;
        return;
    L10:
        if (isInstaller(event.mPackage, userId) == true) goto L13;
        return;
    L13:
        if (this.mInstallerForegroundTimeFrames.contains(userId, event.mPackage) == true) goto L15;
        this.mInstallerForegroundTimeFrames.add(userId, event.mPackage, new TreeSet());
    L15:
        TreeSet<ForegroundTimeFrame> foregroundTimeFrames = (TreeSet) this.mInstallerForegroundTimeFrames.get(userId, event.mPackage);
        if (foregroundTimeFrames.size() == 0) goto L20;
        if (foregroundTimeFrames.last().isDone() == true) goto L20;
    L23:
        foregroundTimeFrames.last().addEvent(event);
        if (foregroundTimeFrames.size() <= 10) goto L27;
        foregroundTimeFrames.pollFirst();
        return;
    L27:
        return;
    L20:
        if (event.mEventType == 1) goto L22;
        return;
    L22:
        foregroundTimeFrames.add(new ForegroundTimeFrame(event.mTimeStamp));
        goto L23
    }

    void writeBackgroundInstalledPackagesToDisk() {
        AtomicFile atomicFile = new AtomicFile(this.mDiskFile);
        FileOutputStream fileOutputStream = atomicFile.startWrite();     // Catch: IOException -> L18
        ProtoOutputStream protoOutputStream = new ProtoOutputStream(fileOutputStream);     // Catch: Exception -> L11
        int i = 0;
    L6:
        if (i >= this.mBackgroundInstalledPackages.size()) goto L14;
        int userId = this.mBackgroundInstalledPackages.keyAt(i);     // Catch: Exception -> L11
        Iterator r6 = this.mBackgroundInstalledPackages.get(userId).iterator();     // Catch: Exception -> L11
    L9:
        if (r6.hasNext() == false) goto L13;
        String packageName = (String) r6.next();     // Catch: Exception -> L11
        long token = protoOutputStream.start(2246267895809L);     // Catch: Exception -> L11
        protoOutputStream.write(1138166333441L, packageName);     // Catch: Exception -> L11
        protoOutputStream.write(1120986464258L, userId + 1);     // Catch: Exception -> L11
        protoOutputStream.end(token);     // Catch: Exception -> L11
        goto L9
    L13:
        i = i + 1;     // Catch: Exception -> L11
        goto L6
    L14:
        protoOutputStream.flush();     // Catch: Exception -> L11
        atomicFile.finishWrite(fileOutputStream);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to finish write to states protobuf.", e);
        atomicFile.failWrite(fileOutputStream);
        return;
    L18:
        e = move-exception;
        Slog.e(TAG, "Failed to start write to states protobuf.", e);
    }

    void initBackgroundInstalledPackages() {
        if (this.mBackgroundInstalledPackages == null) goto L5;
        return;
    L5:
        this.mBackgroundInstalledPackages = new SparseSetArray();
        if (this.mDiskFile.exists() == true) goto L8;
        return;
    L8:
        AtomicFile atomicFile = new AtomicFile(this.mDiskFile);
        FileInputStream fileInputStream = atomicFile.openRead();     // Catch: IOException -> L37
        ProtoInputStream protoInputStream = new ProtoInputStream(fileInputStream);     // Catch: Throwable -> L22
    L11:
        if (protoInputStream.nextField() == (-1)) goto L34;
        if (protoInputStream.getFieldNumber() != 1) goto L11;
        long token = protoInputStream.start(2246267895809L);     // Catch: Throwable -> L22
        String packageName = null;
        int userId = ProcessList.INVALID_ADJ;
    L18:
        if (protoInputStream.nextField() == (-1)) goto L26;
        switch(protoInputStream.getFieldNumber()) {
            case 1: goto L25;
            case 2: goto L24;
            default: goto L21;
        };     // Catch: Throwable -> L22
    L24:
        userId = protoInputStream.readInt(1120986464258L) - 1;     // Catch: Throwable -> L22
        goto L18
    L25:
        packageName = protoInputStream.readString(1138166333441L);     // Catch: Throwable -> L22
        goto L18
    L21:
        Slog.w(TAG, "Undefined field in proto: " + protoInputStream.getFieldNumber());     // Catch: Throwable -> L22
        goto L18
    L26:
        protoInputStream.end(token);     // Catch: Throwable -> L22
        if (packageName == null) goto L31;
        if (userId == (-10000)) goto L31;
        this.mBackgroundInstalledPackages.add(userId, packageName);     // Catch: Throwable -> L22
    L31:
        Slog.w(TAG, "Fails to get packageName or UserId from proto file");     // Catch: Throwable -> L22
        goto L11
    L34:
        if (fileInputStream == null) goto L72;
        fileInputStream.close();     // Catch: IOException -> L37
        return;
    L72:
        return;
    L22:
        th = move-exception;
        if (fileInputStream != null) goto L49;
    L46:
        throw th;     // Catch: IOException -> L37
    L49:
        fileInputStream.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L37
    L37:
        e = move-exception;
        Slog.w(TAG, "Error reading state from the disk", e);
    }

    SparseSetArray<String> getBackgroundInstalledPackages() {
        return this.mBackgroundInstalledPackages;
    }

    SparseArrayMap<String, TreeSet<ForegroundTimeFrame>> getInstallerForegroundTimeFrames() {
        return this.mInstallerForegroundTimeFrames;
    }

    private boolean isInstaller(String pkgName, int userId) {
        if (this.mInstallerForegroundTimeFrames.contains(userId, pkgName) == false) goto L6;
        return true;
    L6:
        if (this.mPermissionManager.checkPermission(pkgName, "android.permission.INSTALL_PACKAGES", "default:0", userId) == 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        onStart(false);
    }

    void onStart(boolean isForTesting) {
        if (isForTesting == true) goto L4;
        publishBinderService("background_install_control", this.mBinderService);
    L4:
        this.mPackageManagerInternal.getPackageList(this.mPackageObserver);
    }
}
