package android.net;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConnectivityModuleConnector {
    private static final String CONFIG_ALWAYS_RATELIMIT_NETWORKSTACK_CRASH = "always_ratelimit_networkstack_crash";
    private static final String CONFIG_MIN_CRASH_INTERVAL_MS = "min_crash_interval";
    private static final String CONFIG_MIN_UPTIME_BEFORE_CRASH_MS = "min_uptime_before_crash";
    private static final long DEFAULT_MIN_CRASH_INTERVAL_MS = 21600000;
    private static final long DEFAULT_MIN_UPTIME_BEFORE_CRASH_MS = 1800000;
    private static final String IN_PROCESS_SUFFIX = ".InProcess";
    private static final String PREFS_FILE = "ConnectivityModuleConnector.xml";
    private static final String PREF_KEY_LAST_CRASH_TIME = "lastcrash_time";
    private static final String TAG = null;
    private static ConnectivityModuleConnector sInstance;
    private Context mContext;
    private final Dependencies mDeps;
    private final ArraySet<ConnectivityModuleHealthListener> mHealthListeners;

    public interface ConnectivityModuleHealthListener {
        void onNetworkStackFailure(String r1);
    }

    protected interface Dependencies {
        Intent getModuleServiceIntent(PackageManager r1, String r2, String r3, boolean r4);
    }

    private static class DependenciesImpl implements Dependencies {
        /* synthetic */ DependenciesImpl(ConnectivityModuleConnectorIA r1) {
            this();
        }

        private DependenciesImpl() {
        }

        @Override // android.net.ConnectivityModuleConnector.Dependencies
        public Intent getModuleServiceIntent(PackageManager pm, String serviceIntentBaseAction, String servicePermissionName, boolean inSystemProcess) {
            if (inSystemProcess == false) goto L5;
            String r1 = serviceIntentBaseAction + ConnectivityModuleConnector.IN_PROCESS_SUFFIX;
        L6:
            Intent intent = new Intent(r1);
            ComponentName comp = intent.resolveSystemService(pm, 0);
            if (comp != null) goto L10;
            return null;
        L10:
            intent.setComponent(comp);
            int uid = pm.getPackageUidAsUser(comp.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L21
            if (inSystemProcess == false) goto L14;
            int expectedUid = 1000;
        L15:
            if (uid != expectedUid) goto L20;
            if (inSystemProcess == true) goto L18;
            ConnectivityModuleConnector.m2$$Nest$smcheckModuleServicePermission(pm, comp, servicePermissionName);
        L18:
            return intent;
        L20:
            throw new SecurityException("Invalid network stack UID: " + uid);
        L14:
            expectedUid = 1073;
        L21:
            e = move-exception;
            throw new SecurityException("Could not check network stack UID; package not found.", e);
        L5:
            r1 = serviceIntentBaseAction;
            goto L6
        }
    }

    public interface ModuleServiceCallback {
        void onModuleServiceConnected(IBinder r1);
    }

    private class ModuleServiceConnection implements ServiceConnection {
        private final ModuleServiceCallback mModuleServiceCallback;
        private final String mPackageName;
        final /* synthetic */ ConnectivityModuleConnector this$0;

        /* synthetic */ ModuleServiceConnection(ConnectivityModuleConnector r1, String r2, ModuleServiceCallback r3, ConnectivityModuleConnectorIA r4) {
            this(r1, r2, r3);
        }

        private ModuleServiceConnection(ConnectivityModuleConnector r1, String packageName, ModuleServiceCallback moduleCallback) {
            this.this$0 = r1;
            this.mPackageName = packageName;
            this.mModuleServiceCallback = moduleCallback;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            ConnectivityModuleConnector.m0$$Nest$mlogi(this.this$0, "Networking module service connected");
            this.mModuleServiceCallback.onModuleServiceConnected(service);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            ConnectivityModuleConnector.m1$$Nest$mmaybeCrashWithTerribleFailure(this.this$0, "Lost network stack. This is not the root cause of any issue, it is a side effect of a crash that happened earlier. Earlier logs should point to the actual issue.", this.mPackageName, true);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mlogi, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m0$$Nest$mlogi(ConnectivityModuleConnector r0, String r1) {
        r0.logi(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeCrashWithTerribleFailure, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1$$Nest$mmaybeCrashWithTerribleFailure(ConnectivityModuleConnector r0, String r1, String r2, boolean r3) {
        r0.maybeCrashWithTerribleFailure(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smcheckModuleServicePermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2$$Nest$smcheckModuleServicePermission(PackageManager r0, ComponentName r1, String r2) {
        checkModuleServicePermission(r0, r1, r2);
    }

    static {
        TAG = ConnectivityModuleConnector.class.getSimpleName();
    }

    private ConnectivityModuleConnector() {
        this(new DependenciesImpl(null));
    }

    ConnectivityModuleConnector(Dependencies deps) {
        this.mHealthListeners = new ArraySet();
        this.mDeps = deps;
    }

    public static synchronized ConnectivityModuleConnector getInstance() {
        monitor-enter(ConnectivityModuleConnector.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new ConnectivityModuleConnector();     // Catch: Throwable -> L7
    L9:
        ConnectivityModuleConnector r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(ConnectivityModuleConnector.class);
        return r1;
    }

    public void init(Context context) {
        log("Network stack init");
        this.mContext = context;
    }

    public void registerHealthListener(ConnectivityModuleHealthListener listener) {
        ArraySet<ConnectivityModuleHealthListener> r0 = this.mHealthListeners;
        monitor-enter(r0);
        this.mHealthListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void startModuleService(String serviceIntentBaseAction, String servicePermissionName, ModuleServiceCallback callback) {
        log("Starting networking module " + serviceIntentBaseAction);
        PackageManager pm = this.mContext.getPackageManager();
        Intent intent = this.mDeps.getModuleServiceIntent(pm, serviceIntentBaseAction, servicePermissionName, true);
        if (intent != null) goto L5;
        intent = this.mDeps.getModuleServiceIntent(pm, serviceIntentBaseAction, servicePermissionName, false);
        log("Starting networking module in network_stack process");
    L6:
        ConnectivityModuleConnectorIA r3 = null;
        if (intent != null) goto L10;
        maybeCrashWithTerribleFailure("Could not resolve the networking module", null, false);
        return;
    L10:
        String packageName = intent.getComponent().getPackageName();
        if (this.mContext.bindServiceAsUser(intent, new ModuleServiceConnection(this, packageName, callback, r3), 65, UserHandle.SYSTEM) == true) goto L14;
        maybeCrashWithTerribleFailure("Could not bind to networking module in-process, or in app with " + intent, packageName, false);
        return;
    L14:
        log("Networking module service start requested");
        return;
    L5:
        log("Starting networking module in system_server process");
        goto L6
    }

    private static void checkModuleServicePermission(PackageManager pm, ComponentName comp, String servicePermissionName) {
        int hasPermission = pm.checkPermission(servicePermissionName, comp.getPackageName());
        if (hasPermission != 0) goto L6;
        return;
    L6:
        throw new SecurityException("Networking module does not have permission " + servicePermissionName);
    }

    private synchronized void maybeCrashWithTerribleFailure(String message, String packageName, boolean fromServiceDisConnect) {
        monitor-enter(this);
        logWtf(message, null);     // Catch: Throwable -> L33
        long uptime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L33
        long now = System.currentTimeMillis();     // Catch: Throwable -> L33
        long minCrashIntervalMs = DeviceConfig.getLong("connectivity", CONFIG_MIN_CRASH_INTERVAL_MS, DEFAULT_MIN_CRASH_INTERVAL_MS);     // Catch: Throwable -> L33
        long minUptimeBeforeCrash = DeviceConfig.getLong("connectivity", CONFIG_MIN_UPTIME_BEFORE_CRASH_MS, 1800000);     // Catch: Throwable -> L33
        boolean haveKnownRecentCrash = false;
        boolean alwaysRatelimit = DeviceConfig.getBoolean("connectivity", CONFIG_ALWAYS_RATELIMIT_NETWORKSTACK_CRASH, false);     // Catch: Throwable -> L33
        SharedPreferences prefs = getSharedPreferences();     // Catch: Throwable -> L33
        long lastCrashTime = tryGetLastCrashTime(prefs);     // Catch: Throwable -> L33
        if (Build.IS_DEBUGGABLE == false) goto L9;
        if (alwaysRatelimit == true) goto L9;
        boolean r0 = true;
    L10:
        boolean alwaysCrash = r0;
        if (uptime >= minUptimeBeforeCrash) goto L13;
        boolean r1 = true;
    L14:
        boolean justBooted = r1;
        if (lastCrashTime != 0) goto L17;
    L19:
        boolean r2 = false;
    L20:
        boolean haveLastCrashTime = r2;
        if (haveLastCrashTime == true) goto L23;
    L25:
        Slog.i(TAG, "CModuleConnector:" + message + " alwaysCrash=" + alwaysCrash + " justBooted=" + justBooted + " lastCrashTime=" + lastCrashTime + " haveKnownRecentCrash=" + haveKnownRecentCrash + " fromServiceDisConnect=" + fromServiceDisConnect + " uptime=" + uptime + " haveLastCrashTime=" + haveLastCrashTime);     // Catch: Throwable -> L33
        if (fromServiceDisConnect == true) goto L35;
        if (alwaysCrash == true) goto L31;
        if (justBooted == true) goto L35;
        if (haveKnownRecentCrash == true) goto L35;
    L31:
        tryWriteLastCrashTime(prefs, now);     // Catch: Throwable -> L33
        throw new IllegalStateException(message);     // Catch: Throwable -> L33
    L35:
        if (packageName == null) goto L48;
        ArraySet<ConnectivityModuleHealthListener> r4 = this.mHealthListeners;     // Catch: Throwable -> L33
        monitor-enter(r4);     // Catch: Throwable -> L33
        ArraySet<ConnectivityModuleHealthListener> listeners = new ArraySet(this.mHealthListeners);     // Catch: Throwable -> L45
        monitor-exit(r4);     // Catch: Throwable -> L45
        Iterator<ConnectivityModuleHealthListener> r3 = listeners.iterator();     // Catch: Throwable -> L33
    L42:
        if (r3.hasNext() == false) goto L48;
        ConnectivityModuleHealthListener listener = r3.next();     // Catch: Throwable -> L33
        listener.onNetworkStackFailure(packageName);     // Catch: Throwable -> L33
        goto L42
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L48:
        monitor-exit(this);
        return;
    L23:
        if (now >= (lastCrashTime + minCrashIntervalMs)) goto L25;
        haveKnownRecentCrash = true;
        goto L25
    L17:
        if (lastCrashTime >= now) goto L19;
        r2 = true;
        goto L20
    L13:
        r1 = false;
    L9:
        r0 = false;
    L33:
        th = move-exception;
        throw th;
    }

    private SharedPreferences getSharedPreferences() {
        File prefsFile = new File(Environment.getDataSystemDeDirectory(0), PREFS_FILE);     // Catch: Throwable -> L4
        return this.mContext.createDeviceProtectedStorageContext().getSharedPreferences(prefsFile, 0);
    L4:
        e = move-exception;
        logWtf("Error loading shared preferences", e);
        return null;
    }

    private long tryGetLastCrashTime(SharedPreferences prefs) {
        if (prefs != null) goto L10;
        return 0;
    L10:
        return prefs.getLong(PREF_KEY_LAST_CRASH_TIME, 0);
    L7:
        e = move-exception;
        logWtf("Error getting last crash time", e);
        return 0;
    }

    private void tryWriteLastCrashTime(SharedPreferences prefs, long value) {
        if (prefs != null) goto L9;
        return;
    L9:
        prefs.edit().putLong(PREF_KEY_LAST_CRASH_TIME, value).commit();     // Catch: Throwable -> L6
        return;
    L6:
        e = move-exception;
        logWtf("Error writing last crash time", e);
    }

    private void log(String message) {
        Log.d(TAG, message);
    }

    private void logWtf(String message, Throwable e) {
        Slog.wtf(TAG, message, e);
        Log.e(TAG, message, e);
    }

    private void loge(String message, Throwable e) {
        Log.e(TAG, message, e);
    }

    private void logi(String message) {
        Log.i(TAG, message);
    }
}
