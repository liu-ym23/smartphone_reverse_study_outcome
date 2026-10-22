package com.android.server.am;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.permission.PermissionManager;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Pair;
import android.util.SparseArray;
import com.android.internal.app.IAppOpsCallback;
import com.android.internal.app.IAppOpsService;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class AppPermissionTracker extends BaseAppStateTracker<AppPermissionPolicy> implements PackageManager.OnPermissionsChangedListener {
    static final boolean DEBUG_PERMISSION_TRACKER = false;
    static final String TAG = "ActivityManager";
    private final SparseArray<MyAppOpsCallback> mAppOpsCallbacks;
    private final MyHandler mHandler;
    private volatile boolean mLockedBootCompleted;
    private SparseArray<ArraySet<UidGrantedPermissionState>> mUidGrantedPermissionsInMonitor;

    static final class AppPermissionPolicy extends BaseAppStatePolicy<AppPermissionTracker> {
        static final String[] DEFAULT_BG_PERMISSIONS_IN_MONITOR = null;
        static final boolean DEFAULT_BG_PERMISSION_MONITOR_ENABLED = true;
        static final String KEY_BG_PERMISSIONS_IN_MONITOR = "bg_permission_in_monitor";
        static final String KEY_BG_PERMISSION_MONITOR_ENABLED = "bg_permission_monitor_enabled";
        volatile Pair[] mBgPermissionsInMonitor;

        static {
            DEFAULT_BG_PERMISSIONS_IN_MONITOR = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android:fine_location", "android.permission.CAMERA", "android:camera", "android.permission.RECORD_AUDIO", "android:record_audio"};
        }

        AppPermissionPolicy(BaseAppStateTracker.Injector injector, AppPermissionTracker tracker) {
            super(injector, tracker, KEY_BG_PERMISSION_MONITOR_ENABLED, true);
            this.mBgPermissionsInMonitor = parsePermissionConfig(DEFAULT_BG_PERMISSIONS_IN_MONITOR);
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onSystemReady() {
            super.onSystemReady();
            updateBgPermissionsInMonitor();
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onPropertiesChanged(String name) {
            switch(name.hashCode()) {
                case -1888141258: goto L6;
                default: goto L8;
            };
        L8:
            byte r0 = -1;
        L9:
            switch(r0) {
                case 0: goto L11;
                default: goto L10;
            };
        L10:
            super.onPropertiesChanged(name);
            return;
        L11:
            updateBgPermissionsInMonitor();
            return;
        L6:
            if (name.equals(KEY_BG_PERMISSIONS_IN_MONITOR) == false) goto L8;
            r0 = 0;
            goto L9
        }

        Pair[] getBgPermissionsInMonitor() {
            return this.mBgPermissionsInMonitor;
        }

        private Pair[] parsePermissionConfig(String[] perms) {
            Pair[] result = new Pair[perms.length / 2];
            int i = 0;
            int j = 0;
        L4:
            if (i >= perms.length) goto L18;
            if (TextUtils.isEmpty(perms[i]) == false) goto L8;
            String r3 = null;
        L10:
            if (TextUtils.isEmpty(perms[i + 1]) == false) goto L12;
            int r4 = -1;
        L13:
            result[j] = Pair.create(r3, Integer.valueOf(r4));     // Catch: Exception -> L15
            goto L16
        L12:
            r4 = AppOpsManager.strOpToOp(perms[i + 1]);     // Catch: Exception -> L15
            goto L13
        L8:
            r3 = perms[i];     // Catch: Exception -> L15
        L16:
            i = i + 2;
            j = j + 1;
            goto L4
        L18:
            return result;
        }

        private void updateBgPermissionsInMonitor() {
            String config = DeviceConfig.getString("activity_manager", KEY_BG_PERMISSIONS_IN_MONITOR, null);
            if (config == null) goto L5;
            String[] r1 = config.split(",");
        L6:
            Pair[] newPermsInMonitor = parsePermissionConfig(r1);
            if (Arrays.equals(this.mBgPermissionsInMonitor, newPermsInMonitor) == true) goto L12;
            this.mBgPermissionsInMonitor = newPermsInMonitor;
            if (isEnabled() == false) goto L13;
            onTrackerEnabled(false);
            onTrackerEnabled(true);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r1 = DEFAULT_BG_PERMISSIONS_IN_MONITOR;
            goto L6
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onTrackerEnabled(boolean enabled) {
            AppPermissionTracker.m1321$$Nest$monPermissionTrackerEnabled((AppPermissionTracker) this.mTracker, enabled);
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        void dump(PrintWriter pw, String prefix) {
            pw.print(prefix);
            pw.println("APP PERMISSION TRACKER POLICY SETTINGS:");
            String prefix2 = "  " + prefix;
            super.dump(pw, prefix2);
            pw.print(prefix2);
            pw.print(KEY_BG_PERMISSIONS_IN_MONITOR);
            pw.print('=');
            pw.print('[');
            int i = 0;
        L4:
            if (i >= this.mBgPermissionsInMonitor.length) goto L15;
            if (i <= 0) goto L8;
            pw.print(',');
        L8:
            Pair<String, Integer> pair = this.mBgPermissionsInMonitor[i];
            if (pair.first == null) goto L11;
            pw.print((String) pair.first);
        L11:
            pw.print(',');
            if (((Integer) pair.second).intValue() == (-1)) goto L14;
            pw.print(AppOpsManager.opToPublicName(((Integer) pair.second).intValue()));
        L14:
            i = i + 1;
            goto L4
        L15:
            pw.println(']');
        }
    }

    private class MyAppOpsCallback extends IAppOpsCallback.Stub {
        final /* synthetic */ AppPermissionTracker this$0;

        /* synthetic */ MyAppOpsCallback(AppPermissionTracker r1, AppPermissionTrackerIA r2) {
            this(r1);
        }

        private MyAppOpsCallback(AppPermissionTracker r1) {
            this.this$0 = r1;
        }

        public void opChanged(int op, int uid, String packageName, String persistentDeviceId) {
            if (uid >= 0) goto L4;
            return;
        L4:
            AppPermissionTracker.m1314$$Nest$fgetmHandler(this.this$0).obtainMessage(3, op, uid, packageName).sendToTarget();
        }
    }

    private static class MyHandler extends Handler {
        static final int MSG_APPOPS_CHANGED = 3;
        static final int MSG_PERMISSIONS_CHANGED = 2;
        static final int MSG_PERMISSIONS_DESTROY = 1;
        static final int MSG_PERMISSIONS_INIT = 0;
        private AppPermissionTracker mTracker;

        MyHandler(AppPermissionTracker tracker) {
            super(tracker.mBgHandler.getLooper());
            this.mTracker = tracker;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L8;
                case 1: goto L7;
                case 2: goto L6;
                case 3: goto L5;
                default: goto L13;
            };
        L5:
            AppPermissionTracker.m1317$$Nest$mhandleOpChanged(this.mTracker, msg.arg1, msg.arg2, (String) msg.obj);
            return;
        L6:
            AppPermissionTracker.m1318$$Nest$mhandlePermissionsChanged(this.mTracker, msg.arg1);
            return;
        L7:
            AppPermissionTracker.m1319$$Nest$mhandlePermissionsDestroy(this.mTracker);
            AppPermissionTracker.m1315$$Nest$mhandleAppOpsDestroy(this.mTracker);
            return;
        L8:
            AppPermissionTracker.m1316$$Nest$mhandleAppOpsInit(this.mTracker);
            AppPermissionTracker.m1320$$Nest$mhandlePermissionsInit(this.mTracker);
            return;
        }
    }

    private class UidGrantedPermissionState {
        final int mAppOp;
        private boolean mAppOpAllowed;
        final String mPermission;
        private boolean mPermissionGranted;
        final int mUid;
        final /* synthetic */ AppPermissionTracker this$0;

        UidGrantedPermissionState(AppPermissionTracker r1, int uid, String permission, int appOp) {
            this.this$0 = r1;
            this.mUid = uid;
            this.mPermission = permission;
            this.mAppOp = appOp;
            updatePermissionState();
            updateAppOps();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        void updatePermissionState() {
            boolean r1 = true;
            if (TextUtils.isEmpty(this.mPermission) == false) goto L7;
            this.mPermissionGranted = true;
            return;
        L7:
            if (this.this$0.mInjector.checkPermission(this.mPermission, -1, this.mUid) == 0) goto L10;
            r1 = false;
        L10:
            this.mPermissionGranted = r1;
        }

        void updateAppOps() {
            if (this.mAppOp != (-1)) goto L6;
            this.mAppOpAllowed = true;
            return;
        L6:
            String[] packages = this.this$0.mInjector.getPackageManager().getPackagesForUid(this.mUid);
            if (packages == null) goto L20;
            IAppOpsService appOpsService = this.this$0.mInjector.getIAppOpsService();
            int r4 = packages.length;
            int r5 = 0;
        L10:
            if (r5 >= r4) goto L20;
            String pkg = packages[r5];
            int mode = appOpsService.checkOperation(this.mAppOp, this.mUid, pkg);     // Catch: RemoteException -> L16
            if (mode != 0) goto L19;
            this.mAppOpAllowed = true;     // Catch: RemoteException -> L16
            return;
        L19:
            r5 = r5 + 1;
        L20:
            this.mAppOpAllowed = false;
        }

        boolean isGranted() {
            if (this.mPermissionGranted == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mAppOpAllowed == false) goto L7;
            return true;
        }

        public boolean equals(Object other) {
            if (other != null) goto L5;
        L16:
            return false;
        L5:
            if ((other instanceof UidGrantedPermissionState) == false) goto L16;
            UidGrantedPermissionState otherState = (UidGrantedPermissionState) other;
            if (this.mUid == otherState.mUid) goto L10;
            return false;
        L10:
            if (this.mAppOp == otherState.mAppOp) goto L12;
            return false;
        L12:
            if (Objects.equals(this.mPermission, otherState.mPermission) == false) goto L19;
            return true;
        L19:
            return false;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.mUid) * 31) + Integer.hashCode(this.mAppOp)) * 31;
            if (this.mPermission != null) goto L5;
            int r1 = 0;
        L7:
            return r0 + r1;
        L5:
            r1 = this.mPermission.hashCode();
            goto L7
        }

        public String toString() {
            String s = "UidGrantedPermissionState{" + System.identityHashCode(this) + " " + UserHandle.formatUid(this.mUid) + ": ";
            boolean emptyPermissionName = TextUtils.isEmpty(this.mPermission);
            if (emptyPermissionName == true) goto L6;
            s = s + this.mPermission + "=" + this.mPermissionGranted;
        L6:
            if (this.mAppOp == (-1)) goto L11;
            if (emptyPermissionName == true) goto L9;
            s = s + ",";
        L9:
            s = s + AppOpsManager.opToPublicName(this.mAppOp) + "=" + this.mAppOpAllowed;
        L11:
            return s + "}";
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ MyHandler m1314$$Nest$fgetmHandler(AppPermissionTracker r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAppOpsDestroy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1315$$Nest$mhandleAppOpsDestroy(AppPermissionTracker r0) {
        r0.handleAppOpsDestroy();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAppOpsInit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1316$$Nest$mhandleAppOpsInit(AppPermissionTracker r0) {
        r0.handleAppOpsInit();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOpChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1317$$Nest$mhandleOpChanged(AppPermissionTracker r0, int r1, int r2, String r3) {
        r0.handleOpChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePermissionsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1318$$Nest$mhandlePermissionsChanged(AppPermissionTracker r0, int r1) {
        r0.handlePermissionsChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePermissionsDestroy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1319$$Nest$mhandlePermissionsDestroy(AppPermissionTracker r0) {
        r0.handlePermissionsDestroy();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePermissionsInit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1320$$Nest$mhandlePermissionsInit(AppPermissionTracker r0) {
        r0.handlePermissionsInit();
    }

    /* JADX INFO: renamed from: -$$Nest$monPermissionTrackerEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1321$$Nest$monPermissionTrackerEnabled(AppPermissionTracker r0, boolean r1) {
        r0.onPermissionTrackerEnabled(r1);
    }

    AppPermissionTracker(Context context, AppRestrictionController controller) {
        this(context, controller, null, null);
    }

    AppPermissionTracker(Context context, AppRestrictionController controller, Constructor<? extends BaseAppStateTracker.Injector<AppPermissionPolicy>> injector, Object outerContext) {
        super(context, controller, injector, outerContext);
        this.mAppOpsCallbacks = new SparseArray();
        this.mUidGrantedPermissionsInMonitor = new SparseArray();
        this.mLockedBootCompleted = false;
        this.mHandler = new MyHandler(this);
        this.mInjector.setPolicy(new AppPermissionPolicy(this.mInjector, this));
    }

    @Override // com.android.server.am.BaseAppStateTracker
    int getType() {
        return 5;
    }

    public void onPermissionsChanged(int uid) {
        this.mHandler.obtainMessage(2, uid, 0).sendToTarget();
    }

    private void handleAppOpsInit() {
        ArrayList<Integer> ops = new ArrayList();
        Pair<String, Integer>[] permissions = ((AppPermissionPolicy) this.mInjector.getPolicy()).getBgPermissionsInMonitor();
        int i = 0;
    L4:
        if (i >= permissions.length) goto L9;
        Pair<String, Integer> pair = permissions[i];
        if (((Integer) pair.second).intValue() == (-1)) goto L8;
        ops.add((Integer) pair.second);
    L8:
        i = i + 1;
        goto L4
    L9:
        int i2 = ops.size();
        startWatchingMode((Integer[]) ops.toArray(new Integer[i2]));
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:? -> B:25:0x00b5). Please report as a decompilation issue!!! */
    private void handlePermissionsInit() {
        AppPermissionTracker r1 = this;
        int[] allUsers = r1.mInjector.getUserManagerInternal().getUserIds();
        PackageManagerInternal pmi = r1.mInjector.getPackageManagerInternal();
        r1.mInjector.getPermissionManagerServiceInternal();
        Pair<String, Integer>[] permissions = ((AppPermissionPolicy) r1.mInjector.getPolicy()).getBgPermissionsInMonitor();
        SparseArray<ArraySet<UidGrantedPermissionState>> uidPerms = r1.mUidGrantedPermissionsInMonitor;
        int r0 = allUsers.length;
        int r14 = 0;
    L3:
        if (r14 >= r0) goto L43;
        int userId = allUsers[r14];
        List<ApplicationInfo> apps = pmi.getInstalledApplications(0, userId, 1000);
        if (apps != null) goto L7;
        int r18 = r0;
    L42:
        r14 = r14 + 1;
        r1 = this;
        r0 = r18;
        allUsers = allUsers;
        goto L3
    L7:
        long now = SystemClock.elapsedRealtime();
        int i = 0;
        int size = apps.size();
    L8:
        if (i >= size) goto L41;
        ApplicationInfo ai = apps.get(i);
        int r13 = permissions.length;
        int size2 = size;
        int size3 = 0;
    L10:
        if (size3 >= r13) goto L40;
        int r17 = size3;
        Pair<String, Integer> permission = permissions[r17];
        int r19 = r0;
        List<ApplicationInfo> apps2 = apps;
        int i2 = i;
        long now2 = now;
        UidGrantedPermissionState state = new UidGrantedPermissionState(r1, ai.uid, (String) permission.first, ((Integer) permission.second).intValue());
        if (state.isGranted() == true) goto L14;
        ai = ai;
        now = now2;
        int[] allUsers2 = allUsers;
    L44:
        size3 = r17 + 1;     // Catch: Throwable -> L25
        r1 = this;
        r0 = r19;
        apps = apps2;
        i = i2;
        allUsers = allUsers2;
        ai = ai;
    L25:
        th = th;
    L38:
        monitor-exit(r22);     // Catch: Throwable -> L25
        throw th;
    L14:
        Object r3 = r1.mLock;
        monitor-enter(r3);
        ArraySet<UidGrantedPermissionState> grantedPermissions = uidPerms.get(ai.uid);     // Catch: Throwable -> L32
        if (grantedPermissions != null) goto L34;
        grantedPermissions = new ArraySet();     // Catch: Throwable -> L32
        uidPerms.put(ai.uid, grantedPermissions);     // Catch: Throwable -> L32
        int[] r25 = allUsers;
        UidGrantedPermissionState state2 = state;
        Object r22 = r3;
        allUsers2 = r25;
        now = now2;
        r1.notifyListenersOnStateChange(ai.uid, "", true, now, 16);     // Catch: Throwable -> L25
    L35:
        grantedPermissions.add(state2);     // Catch: Throwable -> L25
        monitor-exit(r22);     // Catch: Throwable -> L25
    L30:
        th = th;
        r22 = r3;
        goto L38
    L34:
        now = now2;
        r22 = r3;
        allUsers2 = allUsers;
        state2 = state;
    L32:
        th = th;
        r22 = r3;
        goto L38
    L40:
        i = i + 1;
        r1 = this;
        size = size2;
        goto L8
    L41:
        r18 = r0;
        goto L42
    }

    private void handleAppOpsDestroy() {
        stopWatchingMode();
    }

    private void handlePermissionsDestroy() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseArray<ArraySet<UidGrantedPermissionState>> uidPerms = this.mUidGrantedPermissionsInMonitor;     // Catch: Throwable -> L9
        long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        int i = 0;
        int size = uidPerms.size();     // Catch: Throwable -> L9
    L5:
        if (i >= size) goto L12;
        int uid = uidPerms.keyAt(i);     // Catch: Throwable -> L9
        ArraySet<UidGrantedPermissionState> grantedPermissions = uidPerms.valueAt(i);     // Catch: Throwable -> L9
        if (grantedPermissions.size() <= 0) goto L11;
        notifyListenersOnStateChange(uid, "", false, now, 16);     // Catch: Throwable -> L9
    L11:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        uidPerms.clear();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void handleOpChanged(int op, int uid, String packageName) {
        Pair<String, Integer>[] permissions = ((AppPermissionPolicy) this.mInjector.getPolicy()).getBgPermissionsInMonitor();
        if (permissions != null) goto L5;
        return;
    L5:
        if (permissions.length <= 0) goto L25;
        int i = 0;
    L8:
        if (i >= permissions.length) goto L27;
        Pair<String, Integer> pair = permissions[i];
        if (((Integer) pair.second).intValue() == op) goto L12;
        i = i + 1;
        goto L8
    L12:
        UidGrantedPermissionState state = new UidGrantedPermissionState(this, uid, (String) pair.first, op);
        Object r4 = this.mLock;
        monitor-enter(r4);
        handlePermissionsChangedLocked(uid, new UidGrantedPermissionState[]{state});     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L27:
        return;
    }

    private void handlePermissionsChanged(int uid) {
        Pair<String, Integer>[] permissions = ((AppPermissionPolicy) this.mInjector.getPolicy()).getBgPermissionsInMonitor();
        if (permissions != null) goto L5;
        return;
    L5:
        if (permissions.length <= 0) goto L22;
        this.mInjector.getPermissionManagerServiceInternal();
        UidGrantedPermissionState[] states = new UidGrantedPermissionState[permissions.length];
        int i = 0;
    L8:
        if (i >= permissions.length) goto L10;
        Pair<String, Integer> pair = permissions[i];
        states[i] = new UidGrantedPermissionState(this, uid, (String) pair.first, ((Integer) pair.second).intValue());
        i = i + 1;
        goto L8
    L10:
        Object r3 = this.mLock;
        monitor-enter(r3);
        handlePermissionsChangedLocked(uid, states);     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void handlePermissionsChangedLocked(int uid, UidGrantedPermissionState[] states) {
        int index = this.mUidGrantedPermissionsInMonitor.indexOfKey(uid);
        if (index < 0) goto L5;
        ArraySet<UidGrantedPermissionState> grantedPermissions = this.mUidGrantedPermissionsInMonitor.valueAt(index);
    L6:
        long now = SystemClock.elapsedRealtime();
        int i = 0;
    L8:
        if (i >= states.length) goto L28;
        boolean granted = states[i].isGranted();
        boolean changed = false;
        if (granted == false) goto L14;
        if (grantedPermissions != null) goto L13;
        grantedPermissions = new ArraySet();
        this.mUidGrantedPermissionsInMonitor.put(uid, grantedPermissions);
        changed = true;
    L13:
        grantedPermissions.add(states[i]);
        boolean changed2 = changed;
    L23:
        if (changed2 == false) goto L25;
        int uid2 = uid;
        notifyListenersOnStateChange(uid2, "", granted, now, 16);
    L26:
        i = i + 1;
        uid = uid2;
        goto L8
    L25:
        uid2 = uid;
        goto L26
    L14:
        if (grantedPermissions != null) goto L16;
    L22:
        changed2 = false;
        goto L23
    L16:
        if (grantedPermissions.isEmpty() == true) goto L22;
        if (grantedPermissions.remove(states[i]) == false) goto L22;
        if (grantedPermissions.isEmpty() == false) goto L22;
        this.mUidGrantedPermissionsInMonitor.removeAt(index);
        changed2 = true;
        goto L23
    L28:
        return;
    L5:
        grantedPermissions = null;
        goto L6
    }

    private void startWatchingMode(Integer[] ops) {
        SparseArray<MyAppOpsCallback> r0 = this.mAppOpsCallbacks;
        monitor-enter(r0);
        stopWatchingMode();     // Catch: Throwable -> L9
        IAppOpsService appOpsService = this.mInjector.getIAppOpsService();     // Catch: Throwable -> L9
        int r2 = ops.length;     // Catch: Throwable -> L9 RemoteException -> L11
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L14;
        int op = ops[r3].intValue();     // Catch: Throwable -> L9 RemoteException -> L11
        MyAppOpsCallback cb = new MyAppOpsCallback(this, null);     // Catch: Throwable -> L9 RemoteException -> L11
        this.mAppOpsCallbacks.put(op, cb);     // Catch: Throwable -> L9 RemoteException -> L11
        appOpsService.startWatchingModeWithFlags(op, null, 1, cb);     // Catch: Throwable -> L9 RemoteException -> L11
        r3 = r3 + 1;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void stopWatchingMode() {
        SparseArray<MyAppOpsCallback> r0 = this.mAppOpsCallbacks;
        monitor-enter(r0);
        IAppOpsService appOpsService = this.mInjector.getIAppOpsService();     // Catch: Throwable -> L9
        int i = this.mAppOpsCallbacks.size() - 1;
    L6:
        if (i < 0) goto L14;
        appOpsService.stopWatchingMode(this.mAppOpsCallbacks.valueAt(i));     // Catch: Throwable -> L9 RemoteException -> L11
    L12:
        i = i - 1;
        goto L6
    L14:
        this.mAppOpsCallbacks.clear();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onPermissionTrackerEnabled(boolean enabled) {
        if (this.mLockedBootCompleted == true) goto L5;
        return;
    L5:
        PermissionManager pm = this.mInjector.getPermissionManager();
        if (enabled == false) goto L8;
        pm.addOnPermissionsChangeListener(this);
        this.mHandler.obtainMessage(0).sendToTarget();
        return;
    L8:
        pm.removeOnPermissionsChangeListener(this);
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onLockedBootCompleted() {
        this.mLockedBootCompleted = true;
        onPermissionTrackerEnabled(((AppPermissionPolicy) this.mInjector.getPolicy()).isEnabled());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:? -> B:26:0x00d1). Please report as a decompilation issue!!! */
    @Override // com.android.server.am.BaseAppStateTracker
    void dump(PrintWriter pw, String prefix) {
        AppPermissionTracker r1 = this;
        pw.print(prefix);
        pw.println("APP PERMISSIONS TRACKER:");
        Pair<String, Integer>[] permissions = ((AppPermissionPolicy) r1.mInjector.getPolicy()).getBgPermissionsInMonitor();
        String prefixMore = "  " + prefix;
        String prefixMoreMore = "  " + prefixMore;
        int r0 = permissions.length;
        int r7 = 0;
    L3:
        if (r7 >= r0) goto L39;
        Pair<String, Integer> permission = permissions[r7];
        pw.print(prefixMore);
        boolean emptyPermissionName = TextUtils.isEmpty((CharSequence) permission.first);
        if (emptyPermissionName == true) goto L8;
        pw.print((String) permission.first);
    L8:
        if (((Integer) permission.second).intValue() == (-1)) goto L12;
        if (emptyPermissionName == true) goto L11;
        pw.print('+');
    L11:
        pw.print(AppOpsManager.opToPublicName(((Integer) permission.second).intValue()));
    L12:
        pw.println(':');
        Object r10 = r1.mLock;
        monitor-enter(r10);
        SparseArray<ArraySet<UidGrantedPermissionState>> uidPerms = r1.mUidGrantedPermissionsInMonitor;     // Catch: Throwable -> L30
        pw.print(prefixMoreMore);     // Catch: Throwable -> L30
        pw.print('[');     // Catch: Throwable -> L30
        boolean needDelimiter = false;
        int i = 0;
        int size = uidPerms.size();     // Catch: Throwable -> L30
    L15:
        if (i >= size) goto L34;
        ArraySet<UidGrantedPermissionState> uidPerm = uidPerms.valueAt(i);     // Catch: Throwable -> L30
        int r17 = r0;
        int j = uidPerm.size() - 1;     // Catch: Throwable -> L30
    L17:
        if (j < 0) goto L32;
        UidGrantedPermissionState state = uidPerm.valueAt(j);     // Catch: Throwable -> L30
        int j2 = j;
        Pair<String, Integer>[] r18 = permissions;
    L26:
        th = th;
    L37:
        monitor-exit(r10);     // Catch: Throwable -> L26
        throw th;
    L21:
        if (state.mAppOp != ((Integer) permission.second).intValue()) goto L29;
        if (TextUtils.equals(state.mPermission, (CharSequence) permission.first) == false) goto L29;
        if (needDelimiter == false) goto L28;
        pw.print(',');     // Catch: Throwable -> L26
    L28:
        pw.print(UserHandle.formatUid(state.mUid));     // Catch: Throwable -> L26
        needDelimiter = true;
    L33:
        i = i + 1;     // Catch: Throwable -> L26
        r0 = r17;
        permissions = r18;
    L29:
        j = j2 - 1;     // Catch: Throwable -> L26
        permissions = r18;
        goto L17
    L32:
        r18 = permissions;
        goto L33
    L34:
        int r19 = r0;
        Pair<String, Integer>[] r110 = permissions;
        pw.println(']');     // Catch: Throwable -> L26
        monitor-exit(r10);     // Catch: Throwable -> L26
        r7 = r7 + 1;     // Catch: Throwable -> L26
        r1 = this;
        r0 = r19;
        permissions = r110;
    L30:
        th = th;
        goto L37
    L39:
        super.dump(pw, prefix);
    }
}
