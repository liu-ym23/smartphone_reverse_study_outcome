package com.android.server.appbinding;

import android.app.AppGlobals;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.IPackageManager;
import android.content.pm.ServiceInfo;
import android.database.ContentObserver;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.server.SystemService;
import com.android.server.am.PersistentConnection;
import com.android.server.appbinding.finders.AppServiceFinder;
import com.android.server.appbinding.finders.CarrierMessagingClientServiceFinder;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class AppBindingService extends Binder {
    public static final boolean DEBUG = false;
    public static final String TAG = "AppBindingService";
    private final ArrayList<AppServiceFinder> mApps;
    private final ArrayList<AppServiceConnection> mConnections;
    private AppBindingConstants mConstants;
    private final Context mContext;
    private final Handler mHandler;
    private final IPackageManager mIPackageManager;
    private final Injector mInjector;
    private final Object mLock;
    final BroadcastReceiver mPackageUserMonitor;
    private final SparseBooleanArray mRunningUsers;
    private final ContentObserver mSettingsObserver;

    private static class AppServiceConnection extends PersistentConnection<IInterface> {
        private final AppBindingConstants mConstants;
        private final AppServiceFinder mFinder;

        @Override // com.android.server.am.PersistentConnection
        protected /* bridge */ /* synthetic */ IInterface asInterface(IBinder r1) {
            return asInterface(r1);
        }

        AppServiceConnection(Context context, int userId, AppBindingConstants constants, Handler handler, AppServiceFinder finder, ComponentName componentName) {
            super(AppBindingService.TAG, context, handler, userId, componentName, constants.SERVICE_RECONNECT_BACKOFF_SEC, constants.SERVICE_RECONNECT_BACKOFF_INCREASE, constants.SERVICE_RECONNECT_MAX_BACKOFF_SEC, constants.SERVICE_STABLE_CONNECTION_THRESHOLD_SEC);
            this.mFinder = finder;
            this.mConstants = constants;
        }

        @Override // com.android.server.am.PersistentConnection
        protected int getBindFlags() {
            return this.mFinder.getBindFlags(this.mConstants);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.server.am.PersistentConnection
        protected IInterface asInterface(IBinder obj) {
            return this.mFinder.asInterface(obj);
        }

        public AppServiceFinder getFinder() {
            return this.mFinder;
        }
    }

    static class Injector {
        Injector() {
        }

        public IPackageManager getIPackageManager() {
            return AppGlobals.getPackageManager();
        }

        public String getGlobalSettingString(ContentResolver resolver, String key) {
            return Settings.Global.getString(resolver, key);
        }
    }

    public static class Lifecycle extends SystemService {
        final AppBindingService mService;

        public Lifecycle(Context context) {
            this(context, new Injector());
        }

        Lifecycle(Context context, Injector injector) {
            super(context);
            this.mService = new AppBindingService(injector, context, null);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService("app_binding", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            AppBindingService.m1676$$Nest$monBootPhase(this.mService, phase);
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
            AppBindingService.m1677$$Nest$monStartUser(this.mService, user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            AppBindingService.m1679$$Nest$monUnlockUser(this.mService, user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser user) {
            AppBindingService.m1678$$Nest$monStopUser(this.mService, user.getUserIdentifier());
        }
    }

    public static /* synthetic */ void $r8$lambda$74taiIo0jz2bqs2agXCRToMgdXo(PrintWriter r0, AppServiceFinder r1) {
        lambda$dump$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$TT8pSjvUg1ykLLlQWcXzJ2vIJUM(AppBindingService r0, AppServiceFinder r1, int r2) {
        r0.onAppChanged(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$WJJF9W1bOyjht8IuGNEkMdA8Zyk(int r0, AppServiceFinder r1) {
        lambda$onUserRemoved$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$tvIwJPpivK224lS3eKKEJbebz_w(PrintWriter r0, AppServiceFinder r1) {
        lambda$dumpSimple$2(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageAddedReplacing, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1675$$Nest$mhandlePackageAddedReplacing(AppBindingService r0, String r1, int r2) {
        r0.handlePackageAddedReplacing(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monBootPhase, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1676$$Nest$monBootPhase(AppBindingService r0, int r1) {
        r0.onBootPhase(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monStartUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1677$$Nest$monStartUser(AppBindingService r0, int r1) {
        r0.onStartUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monStopUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1678$$Nest$monStopUser(AppBindingService r0, int r1) {
        r0.onStopUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUnlockUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1679$$Nest$monUnlockUser(AppBindingService r0, int r1) {
        r0.onUnlockUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1680$$Nest$monUserRemoved(AppBindingService r0, int r1) {
        r0.onUserRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrefreshConstants, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1681$$Nest$mrefreshConstants(AppBindingService r0) {
        r0.refreshConstants();
    }

    /* synthetic */ AppBindingService(Injector r1, Context r2, AppBindingServiceIA r3) {
        this(r1, r2);
    }

    private AppBindingService(Injector injector, Context context) {
        this.mLock = new Object();
        this.mRunningUsers = new SparseBooleanArray(2);
        this.mApps = new ArrayList();
        this.mConnections = new ArrayList();
        final Handler r1 = null;
        this.mSettingsObserver = new AnonymousClass1(this, r1);
        this.mPackageUserMonitor = new AnonymousClass2(this);
        this.mInjector = injector;
        this.mContext = context;
        this.mIPackageManager = injector.getIPackageManager();
        this.mHandler = BackgroundThread.getHandler();
        this.mApps.add(new CarrierMessagingClientServiceFinder(context, new AppBindingService$$ExternalSyntheticLambda2(this), this.mHandler));
        this.mConstants = AppBindingConstants.initializeFromString("");
    }

    private void forAllAppsLocked(Consumer<AppServiceFinder> consumer) {
        int i = 0;
    L4:
        if (i >= this.mApps.size()) goto L7;
        consumer.accept(this.mApps.get(i));
        i = i + 1;
        goto L4
    }

    private void onBootPhase(int phase) {
        switch(phase) {
            case 550: goto L5;
            case 600: goto L4;
            default: goto L8;
        };
    L4:
        onPhaseThirdPartyAppsCanStart();
        return;
    L5:
        onPhaseActivityManagerReady();
        return;
    }

    private void onPhaseActivityManagerReady() {
        IntentFilter packageFilter = new IntentFilter();
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        packageFilter.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(this.mPackageUserMonitor, UserHandle.ALL, packageFilter, null, this.mHandler);
        IntentFilter userFilter = new IntentFilter();
        userFilter.addAction("android.intent.action.USER_REMOVED");
        this.mContext.registerReceiverAsUser(this.mPackageUserMonitor, UserHandle.ALL, userFilter, null, this.mHandler);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("app_binding_constants"), false, this.mSettingsObserver);
        refreshConstants();
    }

    private void refreshConstants() {
        String newSetting = this.mInjector.getGlobalSettingString(this.mContext.getContentResolver(), "app_binding_constants");
        Object r1 = this.mLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.equals(this.mConstants.sourceSettings, newSetting) == false) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        Slog.i(TAG, "Updating constants with: " + newSetting);     // Catch: Throwable -> L8
        this.mConstants = AppBindingConstants.initializeFromString(newSetting);     // Catch: Throwable -> L8
        rebindAllLocked("settings update");     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
    }

    private void onPhaseThirdPartyAppsCanStart() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        forAllAppsLocked(new AppBindingService$$ExternalSyntheticLambda4());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onStartUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRunningUsers.append(userId, true);     // Catch: Throwable -> L7
        bindServicesLocked(userId, null, "user start");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onUnlockUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        bindServicesLocked(userId, null, "user unlock");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onStopUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        unbindServicesLocked(userId, null, "user stop");     // Catch: Throwable -> L7
        this.mRunningUsers.delete(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onUserRemoved(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        forAllAppsLocked(new AppBindingService$$ExternalSyntheticLambda1(userId));     // Catch: Throwable -> L7
        this.mRunningUsers.delete(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$onUserRemoved$0(int userId, AppServiceFinder app) {
        app.onUserRemoved(userId);
    }

    private void onAppChanged(AppServiceFinder finder, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String reason = finder.getAppDescription() + " changed";     // Catch: Throwable -> L7
        unbindServicesLocked(userId, finder, reason);     // Catch: Throwable -> L7
        bindServicesLocked(userId, finder, reason);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private AppServiceFinder findFinderLocked(int userId, String packageName) {
        int i = 0;
    L4:
        if (i >= this.mApps.size()) goto L9;
        AppServiceFinder app = this.mApps.get(i);
        if (packageName.equals(app.getTargetPackage(userId)) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return app;
    L9:
        return null;
    }

    private AppServiceConnection findConnectionLock(int userId, AppServiceFinder target) {
        int i = 0;
    L4:
        if (i >= this.mConnections.size()) goto L11;
        AppServiceConnection conn = this.mConnections.get(i);
        if (conn.getUserId() != userId) goto L10;
        if (conn.getFinder() != target) goto L10;
        return conn;
    L10:
        i = i + 1;
        goto L4
    L11:
        return null;
    }

    private void handlePackageAddedReplacing(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AppServiceFinder finder = findFinderLocked(userId, packageName);     // Catch: Throwable -> L7
        if (finder == null) goto L9;
        unbindServicesLocked(userId, finder, "package update");     // Catch: Throwable -> L7
        bindServicesLocked(userId, finder, "package update");     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void rebindAllLocked(String reason) {
        int i = 0;
    L4:
        if (i >= this.mRunningUsers.size()) goto L11;
        if (this.mRunningUsers.valueAt(i) == false) goto L9;
        int userId = this.mRunningUsers.keyAt(i);
        unbindServicesLocked(userId, null, reason);
        bindServicesLocked(userId, null, reason);
    L9:
        i = i + 1;
        goto L4
    }

    private void bindServicesLocked(int userId, AppServiceFinder target, String reasonForLog) {
        int i = 0;
    L4:
        if (i >= this.mApps.size()) goto L18;
        AppServiceFinder app = this.mApps.get(i);
        if (target == null) goto L9;
        if (target == app) goto L9;
        int userId2 = userId;
    L16:
        i = i + 1;
        userId = userId2;
    L9:
        AppServiceConnection existingConn = findConnectionLock(userId, app);
        if (existingConn == null) goto L12;
        unbindServicesLocked(userId, target, reasonForLog);
    L12:
        ServiceInfo service = app.findService(userId, this.mIPackageManager, this.mConstants);
        if (service != null) goto L15;
        userId2 = userId;
        goto L16
    L15:
        userId2 = userId;
        AppServiceConnection conn = new AppServiceConnection(this.mContext, userId2, this.mConstants, this.mHandler, app, service.getComponentName());
        this.mConnections.add(conn);
        conn.bind();
        goto L16
    }

    private void unbindServicesLocked(int userId, AppServiceFinder target, String reasonForLog) {
        int i = this.mConnections.size() - 1;
    L3:
        if (i < 0) goto L13;
        AppServiceConnection conn = this.mConnections.get(i);
        if (conn.getUserId() != userId) goto L11;
        if (target != null) goto L8;
    L10:
        this.mConnections.remove(i);
        conn.unbind();
        goto L11
    L8:
        if (conn.getFinder() == target) goto L10;
    L11:
        i = i - 1;
        goto L3
    }

    @Override // android.os.Binder
    public void dump(FileDescriptor fd, final PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L6;
        return;
    L6:
        if (args.length > 0) goto L8;
    L11:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mConstants.dump("  ", pw);     // Catch: Throwable -> L19
        pw.println();     // Catch: Throwable -> L19
        pw.print("  Running users:");     // Catch: Throwable -> L19
        int i = 0;
    L15:
        if (i >= this.mRunningUsers.size()) goto L22;
        if (this.mRunningUsers.valueAt(i) == false) goto L21;
        pw.print(" ");     // Catch: Throwable -> L19
        pw.print(this.mRunningUsers.keyAt(i));     // Catch: Throwable -> L19
    L21:
        i = i + 1;     // Catch: Throwable -> L19
        goto L15
    L22:
        pw.println();     // Catch: Throwable -> L19
        pw.println("  Connections:");     // Catch: Throwable -> L19
        int i2 = 0;
    L24:
        if (i2 >= this.mConnections.size()) goto L27;
        AppServiceConnection conn = this.mConnections.get(i2);     // Catch: Throwable -> L19
        pw.print("    App type: ");     // Catch: Throwable -> L19
        pw.print(conn.getFinder().getAppDescription());     // Catch: Throwable -> L19
        pw.println();     // Catch: Throwable -> L19
        conn.dump("      ", pw);     // Catch: Throwable -> L19
        i2 = i2 + 1;     // Catch: Throwable -> L19
        goto L24
    L27:
        if (this.mConnections.size() != 0) goto L29;
        pw.println("    None:");     // Catch: Throwable -> L19
    L29:
        pw.println();     // Catch: Throwable -> L19
        pw.println("  Finders:");     // Catch: Throwable -> L19
        forAllAppsLocked(new AppBindingService$$ExternalSyntheticLambda3(pw));     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L8:
        if ("-s".equals(args[0]) == false) goto L11;
        dumpSimple(pw);
    }

    private static /* synthetic */ void lambda$dump$1(PrintWriter pw, AppServiceFinder app) {
        app.dump("    ", pw);
    }

    private void dumpSimple(final PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L23:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mConnections.size()) goto L18;
        AppServiceConnection conn = this.mConnections.get(i);     // Catch: Throwable -> L10
        pw.print("conn,");     // Catch: Throwable -> L10
        pw.print(conn.getFinder().getAppDescription());     // Catch: Throwable -> L10
        pw.print(",");     // Catch: Throwable -> L10
        pw.print(conn.getUserId());     // Catch: Throwable -> L10
        pw.print(",");     // Catch: Throwable -> L10
        pw.print(conn.getComponentName().getPackageName());     // Catch: Throwable -> L10
        pw.print(",");     // Catch: Throwable -> L10
        pw.print(conn.getComponentName().getClassName());     // Catch: Throwable -> L10
        pw.print(",");     // Catch: Throwable -> L10
        if (conn.isBound() == false) goto L12;
        String r3 = "bound";
    L13:
        pw.print(r3);     // Catch: Throwable -> L10
        pw.print(",");     // Catch: Throwable -> L10
        if (conn.isConnected() == false) goto L16;
        String r4 = "connected";
    L17:
        pw.print(r4);     // Catch: Throwable -> L10
        pw.print(",#con=");     // Catch: Throwable -> L10
        pw.print(conn.getNumConnected());     // Catch: Throwable -> L10
        pw.print(",#dis=");     // Catch: Throwable -> L10
        pw.print(conn.getNumDisconnected());     // Catch: Throwable -> L10
        pw.print(",#died=");     // Catch: Throwable -> L10
        pw.print(conn.getNumBindingDied());     // Catch: Throwable -> L10
        pw.print(",backoff=");     // Catch: Throwable -> L10
        pw.print(conn.getNextBackoffMs());     // Catch: Throwable -> L10
        pw.println();     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L23
    L16:
        r4 = "not-connected";
        goto L17
    L12:
        r3 = "not-bound";
        goto L13
    L18:
        forAllAppsLocked(new AppBindingService$$ExternalSyntheticLambda0(pw));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private static /* synthetic */ void lambda$dumpSimple$2(PrintWriter pw, AppServiceFinder app) {
        app.dumpSimple(pw);
    }

    AppBindingConstants getConstantsForTest() {
        return this.mConstants;
    }
}
