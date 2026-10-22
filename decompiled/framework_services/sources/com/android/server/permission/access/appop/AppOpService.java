package com.android.server.permission.access.appop;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.UserHandle;
import android.permission.PermissionManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.LongSparseArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.android.internal.util.IntPair;
import com.android.server.appop.AppOpsCheckingServiceInterface;
import com.android.server.permission.access.AccessCheckingService;
import com.android.server.permission.access.AccessPolicy;
import com.android.server.permission.access.AccessState;
import com.android.server.permission.access.GetStateScope;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutateStateScope;
import com.android.server.permission.access.SchemePolicy;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.permission.AppIdPermissionPolicy;
import com.android.server.permission.access.permission.DevicePermissionPolicy;
import com.android.server.permission.access.permission.Permission;
import com.android.server.permission.access.permission.PermissionFlags;
import com.android.server.permission.access.permission.PermissionService;
import com.android.server.permission.jarjar.kotlin.Triple;
import com.android.server.permission.jarjar.kotlin.Unit;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Ref$BooleanRef;
import com.android.server.pm.Settings;
import java.util.Map;

/* JADX INFO: compiled from: AppOpService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppOpService implements AppOpsCheckingServiceInterface {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;
    private final AppIdAppOpPolicy appIdPolicy;
    private final ArrayMap<String, ArraySet<String>> backgroundToForegroundPermissionNames;
    private final Context context;
    private final DevicePermissionPolicy devicePermissionPolicy;
    private final ArrayMap<String, String> foregroundToBackgroundPermissionName;
    private SparseBooleanArray foregroundableOps;
    private Handler handler;
    private volatile ArraySet<AppOpsCheckingServiceInterface.AppOpsModeChangedListener> listeners;
    private final Object listenersLock;
    private final PackageAppOpPolicy packagePolicy;
    private final AppIdPermissionPolicy permissionPolicy;
    private final SparseArray<String> runtimeAppOpToPermissionNames;
    private final ArrayMap<String, Integer> runtimePermissionNameToAppOp;
    private final AccessCheckingService service;

    /* JADX INFO: compiled from: AppOpService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: AppOpService.kt */
    private final class OnAppIdAppOpModeChangedListener extends AppIdAppOpPolicy.OnAppOpModeChangedListener {
        private final LongSparseArray<Integer> pendingChanges;
        final /* synthetic */ AppOpService this$0;

        public OnAppIdAppOpModeChangedListener(AppOpService this$0) {
            this.this$0 = this$0;
            this.pendingChanges = new LongSparseArray();
        }

        @Override // com.android.server.permission.access.appop.AppIdAppOpPolicy.OnAppOpModeChangedListener
        public void onAppOpModeChanged(int appId, int userId, String appOpName, int oldMode, int newMode) {
            int uid = UserHandle.getUid(userId, appId);
            int appOpCode = AppOpsManager.strOpToOp(appOpName);
            long key = IntPair.of(uid, appOpCode);
            this.pendingChanges.put(key, Integer.valueOf(newMode));
        }

        @Override // com.android.server.permission.access.appop.AppIdAppOpPolicy.OnAppOpModeChangedListener
        public void onStateMutated() {
            ArraySet listenersLocal = AppOpService.access$getListeners$p(this.this$0);
            LongSparseArray<Integer> r2 = this.pendingChanges;
            int $i$f$forEachIndexed = 0;
            int index$iv = 0;
            int r5 = r2.size();
        L3:
            if (index$iv >= r5) goto L8;
            long key = r2.keyAt(index$iv);
            int mode = r2.valueAt(index$iv).intValue();
            ArraySet $this$forEachIndexed$iv = listenersLocal;
            int index$iv2 = 0;
            int r13 = $this$forEachIndexed$iv.size();
        L5:
            if (index$iv2 >= r13) goto L7;
            AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener = (AppOpsCheckingServiceInterface.AppOpsModeChangedListener) $this$forEachIndexed$iv.valueAt(index$iv2);
            ArraySet listenersLocal2 = listenersLocal;
            int uid = IntPair.first(key);
            LongSparseArray<Integer> r17 = r2;
            int appOpCode = IntPair.second(key);
            listener.onUidModeChanged(uid, appOpCode, mode, "default:0");
            index$iv2 = index$iv2 + 1;
            listenersLocal = listenersLocal2;
            r2 = r17;
            $i$f$forEachIndexed = $i$f$forEachIndexed;
            goto L5
        L7:
            index$iv = index$iv + 1;
            goto L3
        L8:
            this.pendingChanges.clear();
        }
    }

    /* JADX INFO: compiled from: AppOpService.kt */
    private final class OnPackageAppOpModeChangedListener extends PackageAppOpPolicy.OnAppOpModeChangedListener {
        private final ArrayMap<Triple<String, Integer, Integer>, Integer> pendingChanges;
        final /* synthetic */ AppOpService this$0;

        public OnPackageAppOpModeChangedListener(AppOpService this$0) {
            this.this$0 = this$0;
            this.pendingChanges = new ArrayMap();
        }

        @Override // com.android.server.permission.access.appop.PackageAppOpPolicy.OnAppOpModeChangedListener
        public void onAppOpModeChanged(String packageName, int userId, String appOpName, int oldMode, int newMode) {
            int appOpCode = AppOpsManager.strOpToOp(appOpName);
            Triple<String, Integer, Integer> r1 = new Triple(packageName, Integer.valueOf(userId), Integer.valueOf(appOpCode));
            this.pendingChanges.put(r1, Integer.valueOf(newMode));
        }

        @Override // com.android.server.permission.access.appop.PackageAppOpPolicy.OnAppOpModeChangedListener
        public void onStateMutated() {
            ArraySet listenersLocal = AppOpService.access$getListeners$p(this.this$0);
            ArrayMap<Triple<String, Integer, Integer>, Integer> r2 = this.pendingChanges;
            int index$iv = 0;
            int r5 = r2.size();
        L3:
            if (index$iv >= r5) goto L8;
            Triple<String, Integer, Integer> r6 = r2.keyAt(index$iv);
            int mode = r2.valueAt(index$iv).intValue();
            Triple<String, Integer, Integer> r7 = r6;
            ArraySet $this$forEachIndexed$iv = listenersLocal;
            int index$iv2 = 0;
            int r12 = $this$forEachIndexed$iv.size();
        L5:
            if (index$iv2 >= r12) goto L7;
            AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener = (AppOpsCheckingServiceInterface.AppOpsModeChangedListener) $this$forEachIndexed$iv.valueAt(index$iv2);
            String packageName = r7.getFirst();
            ArraySet listenersLocal2 = listenersLocal;
            int userId = r7.getSecond().intValue();
            ArrayMap<Triple<String, Integer, Integer>, Integer> r18 = r2;
            int appOpCode = r7.getThird().intValue();
            listener.onPackageModeChanged(packageName, userId, appOpCode, mode);
            index$iv2 = index$iv2 + 1;
            listenersLocal = listenersLocal2;
            r2 = r18;
            goto L5
        L7:
            index$iv = index$iv + 1;
            goto L3
        L8:
            this.pendingChanges.clear();
        }
    }

    /* JADX INFO: compiled from: AppOpService.kt */
    private final class OnPermissionFlagsChangedListener implements AppIdPermissionPolicy.OnPermissionFlagsChangedListener, DevicePermissionPolicy.OnDevicePermissionFlagsChangedListener {
        private final ArrayMap<Triple<Integer, String, Integer>, Integer> pendingChanges;
        final /* synthetic */ AppOpService this$0;

        public OnPermissionFlagsChangedListener(AppOpService this$0) {
            this.this$0 = this$0;
            this.pendingChanges = new ArrayMap();
        }

        @Override // com.android.server.permission.access.permission.AppIdPermissionPolicy.OnPermissionFlagsChangedListener
        public void onPermissionFlagsChanged(int appId, int userId, String permissionName, int oldFlags, int newFlags) {
            onDevicePermissionFlagsChanged(appId, userId, "default:0", permissionName, oldFlags, newFlags);
        }

        @Override // com.android.server.permission.access.permission.DevicePermissionPolicy.OnDevicePermissionFlagsChangedListener
        public void onDevicePermissionFlagsChanged(int appId, int userId, String deviceId, String permissionName, int oldFlags, int newFlags) {
            ArraySet foregroundPermissions = (ArraySet) AppOpService.access$getBackgroundToForegroundPermissionNames$p(this.this$0).get(permissionName);
            if (foregroundPermissions == null) goto L13;
            AppOpService r10 = this.this$0;
            int index$iv = 0;
            int r15 = foregroundPermissions.size();
        L5:
            if (index$iv >= r15) goto L12;
            String foregroundPermissionName = (String) foregroundPermissions.valueAt(index$iv);
            Integer r5 = (Integer) AppOpService.access$getRuntimePermissionNameToAppOp$p(r10).get(foregroundPermissionName);
            if (r5 == null) goto L11;
            int appOpCode = r5.intValue();
            int foregroundPermissionFlags = getPermissionFlags(appId, userId, foregroundPermissionName);
            addPendingChangedModeIfNeeded(appId, userId, deviceId, appOpCode, foregroundPermissionFlags, oldFlags, foregroundPermissionFlags, newFlags);
        L11:
            index$iv = index$iv + 1;
            goto L5
        L12:
            Unit r3 = Unit.INSTANCE;
            return;
        L13:
            String backgroundPermission = (String) AppOpService.access$getForegroundToBackgroundPermissionName$p(this.this$0).get(permissionName);
            Unit r4 = null;
            if (backgroundPermission == null) goto L19;
            Integer r6 = (Integer) AppOpService.access$getRuntimePermissionNameToAppOp$p(this.this$0).get(permissionName);
            if (r6 == null) goto L19;
            int appOpCode2 = r6.intValue();
            int backgroundPermissionFlags = getPermissionFlags(appId, userId, backgroundPermission);
            addPendingChangedModeIfNeeded(appId, userId, deviceId, appOpCode2, oldFlags, backgroundPermissionFlags, newFlags, backgroundPermissionFlags);
            r4 = Unit.INSTANCE;
        L19:
            if (r4 != null) goto L28;
            Integer r1 = (Integer) AppOpService.access$getRuntimePermissionNameToAppOp$p(this.this$0).get(permissionName);
            if (r1 == null) goto L29;
            int appOpCode3 = r1.intValue();
            addPendingChangedModeIfNeeded(appId, userId, deviceId, appOpCode3, oldFlags, 16, newFlags, 16);
            Unit r0 = Unit.INSTANCE;
            return;
        L29:
            return;
        }

        private final int getPermissionFlags(int appId, int userId, String permissionName) {
            AccessCheckingService this_$iv = AppOpService.access$getService$p(this.this$0);
            AppOpService r1 = this.this$0;
            AccessState r4 = AccessCheckingService.access$getState$p(this_$iv);
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("state");
            r4 = null;
        L5:
            GetStateScope $this$getPermissionFlags_u24lambda_u247 = new GetStateScope(r4);
            AppIdPermissionPolicy $this$getPermissionFlags_u24lambda_u247_u24lambda_u246 = AppOpService.access$getPermissionPolicy$p(r1);
            return $this$getPermissionFlags_u24lambda_u247_u24lambda_u246.getPermissionFlags($this$getPermissionFlags_u24lambda_u247, appId, userId, permissionName);
        }

        private final void addPendingChangedModeIfNeeded(int appId, int userId, String deviceId, int appOpCode, int oldForegroundFlags, int oldBackgroundFlags, int newForegroundFlags, int newBackgroundFlags) {
            int oldMode = AppOpService.access$evaluateModeFromPermissionFlags(this.this$0, oldForegroundFlags, oldBackgroundFlags);
            int newMode = AppOpService.access$evaluateModeFromPermissionFlags(this.this$0, newForegroundFlags, newBackgroundFlags);
            if (oldMode == newMode) goto L6;
            int uid = UserHandle.getUid(userId, appId);
            this.pendingChanges.put(new Triple(Integer.valueOf(uid), deviceId, Integer.valueOf(appOpCode)), Integer.valueOf(newMode));
            return;
        }

        @Override // com.android.server.permission.access.permission.AppIdPermissionPolicy.OnPermissionFlagsChangedListener, com.android.server.permission.access.permission.DevicePermissionPolicy.OnDevicePermissionFlagsChangedListener
        public void onStateMutated() {
            ArraySet listenersLocal = AppOpService.access$getListeners$p(this.this$0);
            ArrayMap<Triple<Integer, String, Integer>, Integer> r2 = this.pendingChanges;
            int index$iv = 0;
            int r5 = r2.size();
        L3:
            if (index$iv >= r5) goto L8;
            Triple<Integer, String, Integer> r6 = r2.keyAt(index$iv);
            int mode = r2.valueAt(index$iv).intValue();
            Triple<Integer, String, Integer> r7 = r6;
            ArraySet $this$forEachIndexed$iv = listenersLocal;
            int index$iv2 = 0;
            int r12 = $this$forEachIndexed$iv.size();
        L5:
            if (index$iv2 >= r12) goto L7;
            AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener = (AppOpsCheckingServiceInterface.AppOpsModeChangedListener) $this$forEachIndexed$iv.valueAt(index$iv2);
            int uid = r7.getFirst().intValue();
            ArraySet listenersLocal2 = listenersLocal;
            String deviceId = r7.getSecond();
            ArrayMap<Triple<Integer, String, Integer>, Integer> r18 = r2;
            int appOpCode = r7.getThird().intValue();
            listener.onUidModeChanged(uid, appOpCode, mode, deviceId);
            index$iv2 = index$iv2 + 1;
            listenersLocal = listenersLocal2;
            r2 = r18;
            goto L5
        L7:
            index$iv = index$iv + 1;
            goto L3
        L8:
            this.pendingChanges.clear();
        }
    }

    public AppOpService(AccessCheckingService service) {
        this.service = service;
        SchemePolicy r0 = this.service.getSchemePolicy$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(Settings.ATTR_PACKAGE, "app-op");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.android.server.permission.access.appop.PackageAppOpPolicy");
        this.packagePolicy = (PackageAppOpPolicy) r0;
        SchemePolicy r1 = this.service.getSchemePolicy$frameworks__base__services__permission__android_common__services_permission_pre_jarjar("uid", "app-op");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.android.server.permission.access.appop.AppIdAppOpPolicy");
        this.appIdPolicy = (AppIdAppOpPolicy) r1;
        SchemePolicy r2 = this.service.getSchemePolicy$frameworks__base__services__permission__android_common__services_permission_pre_jarjar("uid", "permission");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.android.server.permission.access.permission.AppIdPermissionPolicy");
        this.permissionPolicy = (AppIdPermissionPolicy) r2;
        SchemePolicy r3 = this.service.getSchemePolicy$frameworks__base__services__permission__android_common__services_permission_pre_jarjar("uid", "device-permission");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.android.server.permission.access.permission.DevicePermissionPolicy");
        this.devicePermissionPolicy = (DevicePermissionPolicy) r3;
        this.context = this.service.getContext();
        this.runtimeAppOpToPermissionNames = new SparseArray();
        this.runtimePermissionNameToAppOp = new ArrayMap();
        this.foregroundableOps = new SparseBooleanArray();
        this.foregroundToBackgroundPermissionName = new ArrayMap();
        this.backgroundToForegroundPermissionNames = new ArrayMap();
        this.listeners = new ArraySet();
        this.listenersLock = new Object();
    }

    public static final /* synthetic */ int access$evaluateModeFromPermissionFlags(AppOpService $this, int foregroundFlags, int backgroundFlags) {
        return $this.evaluateModeFromPermissionFlags(foregroundFlags, backgroundFlags);
    }

    public static final /* synthetic */ AppIdAppOpPolicy access$getAppIdPolicy$p(AppOpService $this) {
        return $this.appIdPolicy;
    }

    public static final /* synthetic */ ArrayMap access$getBackgroundToForegroundPermissionNames$p(AppOpService $this) {
        return $this.backgroundToForegroundPermissionNames;
    }

    public static final /* synthetic */ ArrayMap access$getForegroundToBackgroundPermissionName$p(AppOpService $this) {
        return $this.foregroundToBackgroundPermissionName;
    }

    public static final /* synthetic */ ArraySet access$getListeners$p(AppOpService $this) {
        return $this.listeners;
    }

    public static final /* synthetic */ PackageAppOpPolicy access$getPackagePolicy$p(AppOpService $this) {
        return $this.packagePolicy;
    }

    public static final /* synthetic */ AppIdPermissionPolicy access$getPermissionPolicy$p(AppOpService $this) {
        return $this.permissionPolicy;
    }

    public static final /* synthetic */ ArrayMap access$getRuntimePermissionNameToAppOp$p(AppOpService $this) {
        return $this.runtimePermissionNameToAppOp;
    }

    public static final /* synthetic */ AccessCheckingService access$getService$p(AppOpService $this) {
        return $this.service;
    }

    public final void initialize() {
        this.handler = new Handler(this.context.getMainLooper());
        this.appIdPolicy.addOnAppOpModeChangedListener(new OnAppIdAppOpModeChangedListener(this));
        this.packagePolicy.addOnAppOpModeChangedListener(new OnPackageAppOpModeChangedListener(this));
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void writeState() {
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void readState() {
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void shutdown() {
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void systemReady() {
        createPermissionAppOpMapping();
        OnPermissionFlagsChangedListener permissionListener = new OnPermissionFlagsChangedListener(this);
        this.permissionPolicy.addOnPermissionFlagsChangedListener(permissionListener);
        this.devicePermissionPolicy.addOnPermissionFlagsChangedListener(permissionListener);
    }

    private final void createPermissionAppOpMapping() {
        AccessCheckingService this_$iv = this.service;
        AccessState r3 = AccessCheckingService.access$getState$p(this_$iv);
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r3 = null;
    L5:
        GetStateScope $this$createPermissionAppOpMapping_u24lambda_u241 = new GetStateScope(r3);
        AppIdPermissionPolicy $this$createPermissionAppOpMapping_u24lambda_u241_u24lambda_u240 = this.permissionPolicy;
        IndexedMap<String, Permission> r4 = $this$createPermissionAppOpMapping_u24lambda_u241_u24lambda_u240.getPermissions($this$createPermissionAppOpMapping_u24lambda_u241);
        int appOpCode = 0;
    L7:
        if (appOpCode >= 166) goto L30;
        if (AppOpsManager.opToDefaultMode(appOpCode) != 4) goto L11;
        SparseBooleanArray $this$set$iv = this.foregroundableOps;
        $this$set$iv.put(appOpCode, true);
    L11:
        String permissionName = AppOpsManager.opToPermission(appOpCode);
        if (permissionName == null) goto L28;
        if (appOpCode != AppOpsManager.permissionToOpCode(permissionName)) goto L28;
        Permission r5 = r4.get(permissionName);
        Intrinsics.checkNotNull(r5);
        Permission permission = r5;
        int $i$f$getProtection = 1;
        if (permission.getPermissionInfo().getProtection() == 1) goto L19;
        $i$f$getProtection = 0;
    L19:
        if ($i$f$getProtection == 0) goto L28;
        this.runtimePermissionNameToAppOp.put(permissionName, Integer.valueOf(appOpCode));
        this.runtimeAppOpToPermissionNames.set(appOpCode, permissionName);
        String backgroundPermissionName = permission.getPermissionInfo().backgroundPermission;
        if (backgroundPermissionName == null) goto L28;
        SparseBooleanArray $this$set$iv2 = this.foregroundableOps;
        $this$set$iv2.put(appOpCode, true);
        this.foregroundToBackgroundPermissionName.put(permissionName, backgroundPermissionName);
        Map $this$getOrPut$iv = this.backgroundToForegroundPermissionNames;
        ArraySet<String> r9 = $this$getOrPut$iv.get(backgroundPermissionName);
        if (r9 != null) goto L25;
        ArraySet<String> r11 = new ArraySet();
        $this$getOrPut$iv.put(backgroundPermissionName, r11);
    L26:
        r11.add(permissionName);
        goto L28
    L25:
        r11 = r9;
    L28:
        appOpCode = appOpCode + 1;
        goto L7
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultUidModes(int uid, String deviceId) {
        AppOpService r0 = this;
        int appId = UserHandle.getAppId(uid);
        int userId = UserHandle.getUserId(uid);
        AccessCheckingService this_$iv = r0.service;
        AccessState r4 = AccessCheckingService.access$getState$p(this_$iv);
        ArrayMap<String, Integer> r5 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r4 = null;
    L5:
        GetStateScope $this$getNonDefaultUidModes_u24lambda_u246 = new GetStateScope(r4);
        AppIdAppOpPolicy $this$getNonDefaultUidModes_u24lambda_u246_u24lambda_u244 = r0.appIdPolicy;
        IndexedMap<String, Integer> r10 = $this$getNonDefaultUidModes_u24lambda_u246_u24lambda_u244.getAppOpModes($this$getNonDefaultUidModes_u24lambda_u246, appId, userId);
        if (r10 == null) goto L8;
        r5 = r10.getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar();
    L8:
        SparseIntArray r6 = r0.opNameMapToOpSparseArray(r5);
        ArrayMap<String, Integer> r11 = r0.runtimePermissionNameToAppOp;
        int r12 = r11.size();
        int index$iv = 0;
    L9:
        if (index$iv >= r12) goto L15;
        String r7 = r11.keyAt(index$iv);
        int appOpCode = r11.valueAt(index$iv).intValue();
        String permissionName = r7;
        int mode = r0.getUidModeFromPermissionState($this$getNonDefaultUidModes_u24lambda_u246, appId, userId, permissionName, deviceId);
        if (mode == AppOpsManager.opToDefaultMode(appOpCode)) goto L13;
        r6.put(appOpCode, mode);
    L13:
        index$iv = index$iv + 1;
        r0 = this;
        goto L9
    L15:
        return r6;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseIntArray getNonDefaultPackageModes(String packageName, int userId) {
        return opNameMapToOpSparseArray(getPackageModes(packageName, userId));
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getUidMode(int uid, String deviceId, int op) {
        int appId = UserHandle.getAppId(uid);
        int userId = UserHandle.getUserId(uid);
        String opName = AppOpsManager.opToPublicName(op);
        String permissionName = this.runtimeAppOpToPermissionNames.get(op);
        AccessState r0 = null;
        if (permissionName != null) goto L9;
        AccessCheckingService this_$iv = this.service;
        AccessState r9 = AccessCheckingService.access$getState$p(this_$iv);
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L8:
        GetStateScope $this$getUidMode_u24lambda_u248 = new GetStateScope(r0);
        AppIdAppOpPolicy $this$getUidMode_u24lambda_u248_u24lambda_u247 = this.appIdPolicy;
        return $this$getUidMode_u24lambda_u248_u24lambda_u247.getAppOpMode($this$getUidMode_u24lambda_u248, appId, userId, opName);
    L7:
        r0 = r9;
        goto L8
    L9:
        AccessCheckingService this_$iv2 = this.service;
        AccessState r10 = AccessCheckingService.access$getState$p(this_$iv2);
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L13:
        GetStateScope $this$getUidMode_u24lambda_u249 = new GetStateScope(r0);
        return getUidModeFromPermissionState($this$getUidMode_u24lambda_u249, appId, userId, permissionName, deviceId);
    L12:
        r0 = r10;
        goto L13
    }

    private final ArrayMap<String, Integer> getUidModes(int uid) {
        int appId = UserHandle.getAppId(uid);
        int userId = UserHandle.getUserId(uid);
        AccessCheckingService this_$iv = this.service;
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r5 = null;
    L5:
        GetStateScope $this$getUidModes_u24lambda_u2411 = new GetStateScope(r5);
        AppIdAppOpPolicy $this$getUidModes_u24lambda_u2411_u24lambda_u2410 = this.appIdPolicy;
        IndexedMap<String, Integer> r7 = $this$getUidModes_u24lambda_u2411_u24lambda_u2410.getAppOpModes($this$getUidModes_u24lambda_u2411, appId, userId);
        if (r7 != null) goto L8;
        return null;
    L8:
        return r7.getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar();
    }

    private final int getUidModeFromPermissionState(GetStateScope $this$getUidModeFromPermissionState, int appId, int userId, String permissionName, String deviceId) {
        if (Intrinsics.areEqual(deviceId, "default:0") == false) goto L5;
    L7:
        boolean checkDevicePermissionFlags = false;
    L9:
        if (checkDevicePermissionFlags == false) goto L11;
        DevicePermissionPolicy $this$getUidModeFromPermissionState_u24lambda_u2412 = this.devicePermissionPolicy;
        GetStateScope $this$getUidModeFromPermissionState2 = $this$getUidModeFromPermissionState;
        int appId2 = appId;
        int userId2 = userId;
        String deviceId2 = deviceId;
        int permissionFlags = $this$getUidModeFromPermissionState_u24lambda_u2412.getPermissionFlags($this$getUidModeFromPermissionState2, appId2, deviceId2, userId2, permissionName);
        String permissionName2 = permissionName;
    L12:
        String backgroundPermissionName = this.foregroundToBackgroundPermissionName.get(permissionName2);
        if (backgroundPermissionName == null) goto L17;
        if (checkDevicePermissionFlags == false) goto L16;
        DevicePermissionPolicy $this$getUidModeFromPermissionState_u24lambda_u2414 = this.devicePermissionPolicy;
        int backgroundPermissionFlags = $this$getUidModeFromPermissionState_u24lambda_u2414.getPermissionFlags($this$getUidModeFromPermissionState2, appId2, deviceId2, userId2, backgroundPermissionName);
    L18:
        int result = evaluateModeFromPermissionFlags(permissionFlags, backgroundPermissionFlags);
        if (result == 1) goto L21;
        return result;
    L21:
        String fullerPermissionName = PermissionService.Companion.getFullerPermission(permissionName2);
        if (fullerPermissionName != null) goto L25;
        return result;
    L25:
        return getUidModeFromPermissionState($this$getUidModeFromPermissionState2, appId2, userId2, fullerPermissionName, deviceId2);
    L16:
        AppIdPermissionPolicy $this$getUidModeFromPermissionState_u24lambda_u2415 = this.permissionPolicy;
        backgroundPermissionFlags = $this$getUidModeFromPermissionState_u24lambda_u2415.getPermissionFlags($this$getUidModeFromPermissionState2, appId2, userId2, backgroundPermissionName);
        goto L18
    L17:
        backgroundPermissionFlags = 16;
        goto L18
    L11:
        $this$getUidModeFromPermissionState2 = $this$getUidModeFromPermissionState;
        appId2 = appId;
        userId2 = userId;
        permissionName2 = permissionName;
        deviceId2 = deviceId;
        AppIdPermissionPolicy $this$getUidModeFromPermissionState_u24lambda_u2413 = this.permissionPolicy;
        permissionFlags = $this$getUidModeFromPermissionState_u24lambda_u2413.getPermissionFlags($this$getUidModeFromPermissionState2, appId2, userId2, permissionName2);
        goto L12
    L5:
        if (PermissionManager.DEVICE_AWARE_PERMISSIONS.contains(permissionName) == false) goto L7;
        checkDevicePermissionFlags = true;
        goto L9
    }

    private final int evaluateModeFromPermissionFlags(int foregroundFlags, int backgroundFlags) {
        if (PermissionFlags.INSTANCE.isAppOpGranted(foregroundFlags) == true) goto L5;
        return 1;
    L5:
        if (PermissionFlags.INSTANCE.isAppOpGranted(backgroundFlags) == false) goto L7;
        return 0;
    L7:
        return 4;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean setUidMode(int uid, String deviceId, int code, int mode) {
        int appId = UserHandle.getAppId(uid);
        int userId = UserHandle.getUserId(uid);
        String appOpName = AppOpsManager.opToPublicName(code);
        AccessState r2 = null;
        if (this.runtimeAppOpToPermissionNames.contains(code) == false) goto L20;
        AccessState r9 = AccessCheckingService.access$getState$p(this.service);
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L8:
        GetStateScope $this$setUidMode_u24lambda_u2417 = new GetStateScope(r2);
        AppIdAppOpPolicy $this$setUidMode_u24lambda_u2417_u24lambda_u2416 = this.appIdPolicy;
        int oldMode = $this$setUidMode_u24lambda_u2417_u24lambda_u2416.getAppOpMode($this$setUidMode_u24lambda_u2417, appId, userId, appOpName);
        if (oldMode == mode) goto L11;
        boolean wouldHaveChanged = true;
    L12:
        if (wouldHaveChanged == false) goto L14;
        String r3 = "Blocked";
    L15:
        String logMessage = r3 + " setUidMode call for runtime permission app op: uid = " + uid + ", code = " + AppOpsManager.opToName(code) + ", mode = " + AppOpsManager.modeToName(mode) + ", callingUid = " + Binder.getCallingUid() + ", oldMode = " + AppOpsManager.modeToName(oldMode);
        if (wouldHaveChanged == false) goto L18;
        Slog.w(LOG_TAG, logMessage);
    L19:
        return false;
    L18:
        Slog.w(LOG_TAG, logMessage);
        goto L19
    L14:
        r3 = "Ignored";
        goto L15
    L11:
        wouldHaveChanged = false;
        goto L12
    L7:
        r2 = r9;
        goto L8
    L20:
        Ref$BooleanRef wasChanged = new Ref$BooleanRef();
        AccessCheckingService this_$iv = this.service;
        Object r12 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r12);
        AccessState r4 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L26
        if (r4 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L26
    L29:
        AccessState oldState$iv = r2;
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L26
        MutateStateScope $this$setUidMode_u24lambda_u2419 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L26
        AppIdAppOpPolicy $this$setUidMode_u24lambda_u2419_u24lambda_u2418 = access$getAppIdPolicy$p(this);     // Catch: Throwable -> L26
        wasChanged.element = Boolean.valueOf($this$setUidMode_u24lambda_u2419_u24lambda_u2418.setAppOpMode($this$setUidMode_u24lambda_u2419, appId, userId, appOpName, mode)).booleanValue();     // Catch: Throwable -> L26
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L26
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L26
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L26
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L26
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r12);
        return wasChanged.element;
    L28:
        r2 = r4;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public int getPackageMode(String packageName, int op, int userId) {
        String opName = AppOpsManager.opToPublicName(op);
        AccessCheckingService this_$iv = this.service;
        AccessState r4 = AccessCheckingService.access$getState$p(this_$iv);
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r4 = null;
    L5:
        GetStateScope $this$getPackageMode_u24lambda_u2421 = new GetStateScope(r4);
        PackageAppOpPolicy $this$getPackageMode_u24lambda_u2421_u24lambda_u2420 = this.packagePolicy;
        return $this$getPackageMode_u24lambda_u2421_u24lambda_u2420.getAppOpMode($this$getPackageMode_u24lambda_u2421, packageName, userId, opName);
    }

    private final ArrayMap<String, Integer> getPackageModes(String packageName, int userId) {
        AccessCheckingService this_$iv = this.service;
        AccessState r3 = AccessCheckingService.access$getState$p(this_$iv);
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r3 = null;
    L5:
        GetStateScope $this$getPackageModes_u24lambda_u2423 = new GetStateScope(r3);
        PackageAppOpPolicy $this$getPackageModes_u24lambda_u2423_u24lambda_u2422 = this.packagePolicy;
        IndexedMap<String, Integer> r5 = $this$getPackageModes_u24lambda_u2423_u24lambda_u2422.getAppOpModes($this$getPackageModes_u24lambda_u2423, packageName, userId);
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void setPackageMode(String packageName, int appOpCode, int mode, int userId) {
        String appOpName = AppOpsManager.opToPublicName(appOpCode);
        if (this.runtimeAppOpToPermissionNames.contains(appOpCode) == false) goto L6;
        Slog.w(LOG_TAG, "(packageName=" + packageName + ", userId=" + userId + ")'s appop state for runtime op " + appOpName + " should not be set directly.", new RuntimeException());
        return;
    L6:
        AccessCheckingService this_$iv = this.service;
        Object r11 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r11);
        AccessState r2 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L12
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L12
        r2 = null;
    L14:
        AccessState oldState$iv = r2;
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L12
        MutateStateScope $this$setPackageMode_u24lambda_u2425 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L12
        PackageAppOpPolicy $this$setPackageMode_u24lambda_u2425_u24lambda_u2424 = access$getPackagePolicy$p(this);     // Catch: Throwable -> L12
        $this$setPackageMode_u24lambda_u2425_u24lambda_u2424.setAppOpMode($this$setPackageMode_u24lambda_u2425, packageName, userId, appOpName, mode);     // Catch: Throwable -> L12
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L12
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L12
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L12
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L12
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r11);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void removeUid(int uid) {
        int appId = UserHandle.getAppId(uid);
        int userId = UserHandle.getUserId(uid);
        AccessCheckingService this_$iv = this.service;
        Object r4 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r4);
        AccessState oldState$iv = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L8
        if (oldState$iv != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L8
        oldState$iv = null;
    L10:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L8
        MutateStateScope $this$removeUid_u24lambda_u2427 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L8
        AppIdAppOpPolicy $this$removeUid_u24lambda_u2427_u24lambda_u2426 = access$getAppIdPolicy$p(this);     // Catch: Throwable -> L8
        $this$removeUid_u24lambda_u2427_u24lambda_u2426.removeAppOpModes($this$removeUid_u24lambda_u2427, appId, userId);     // Catch: Throwable -> L8
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L8
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L8
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L8
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r4);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removePackage(String packageName, int userId) {
        Ref$BooleanRef wasChanged = new Ref$BooleanRef();
        AccessCheckingService this_$iv = this.service;
        Object r3 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r3);
        AccessState oldState$iv = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L8
        if (oldState$iv != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L8
        oldState$iv = null;
    L10:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L8
        MutateStateScope $this$removePackage_u24lambda_u2429 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L8
        PackageAppOpPolicy $this$removePackage_u24lambda_u2429_u24lambda_u2428 = access$getPackagePolicy$p(this);     // Catch: Throwable -> L8
        wasChanged.element = Boolean.valueOf($this$removePackage_u24lambda_u2429_u24lambda_u2428.removeAppOpModes($this$removePackage_u24lambda_u2429, packageName, userId)).booleanValue();     // Catch: Throwable -> L8
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L8
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L8
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L8
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r3);
        return wasChanged.element;
    L8:
        th = move-exception;
        throw th;
    }

    private final SparseIntArray opNameMapToOpSparseArray(ArrayMap<String, Integer> r10) {
        if (r10 == null) goto L8;
        SparseIntArray opSparseArray = new SparseIntArray(r10.size());
        int index$iv = 0;
        int r4 = r10.size();
    L5:
        if (index$iv >= r4) goto L10;
        String r5 = r10.keyAt(index$iv);
        int opMode = r10.valueAt(index$iv).intValue();
        String opName = r5;
        opSparseArray.put(AppOpsManager.strOpToOp(opName), opMode);
        index$iv = index$iv + 1;
        goto L5
    L10:
        return opSparseArray;
    L8:
        return new SparseIntArray();
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public void clearAllModes() {
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(int uid, String deviceId) {
        SparseBooleanArray $this$getForegroundOps_u24lambda_u2433 = new SparseBooleanArray();
        ArrayMap<String, Integer> r4 = getUidModes(uid);
        if (r4 == null) goto L11;
        int index$iv = 0;
        int r8 = r4.size();
    L5:
        if (index$iv >= r8) goto L11;
        String r9 = r4.keyAt(index$iv);
        int mode = r4.valueAt(index$iv).intValue();
        String op = r9;
        if (mode != 4) goto L9;
        int key$iv = AppOpsManager.strOpToOp(op);
        $this$getForegroundOps_u24lambda_u2433.put(key$iv, true);
    L9:
        index$iv = index$iv + 1;
    L11:
        SparseBooleanArray $this$forEachIndexed$iv = this.foregroundableOps;
        int index$iv2 = 0;
        int r10 = $this$forEachIndexed$iv.size();
    L12:
        if (index$iv2 >= r10) goto L18;
        int op2 = $this$forEachIndexed$iv.keyAt(index$iv2);
        $this$forEachIndexed$iv.valueAt(index$iv2);
        if (getUidMode(uid, deviceId, op2) != 4) goto L16;
        $this$getForegroundOps_u24lambda_u2433.put(op2, true);
    L16:
        index$iv2 = index$iv2 + 1;
        goto L12
    L18:
        return $this$getForegroundOps_u24lambda_u2433;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public SparseBooleanArray getForegroundOps(String packageName, int userId) {
        SparseBooleanArray $this$getForegroundOps_u24lambda_u2436 = new SparseBooleanArray();
        ArrayMap<String, Integer> r4 = getPackageModes(packageName, userId);
        if (r4 == null) goto L11;
        int index$iv = 0;
        int r8 = r4.size();
    L5:
        if (index$iv >= r8) goto L11;
        String r9 = r4.keyAt(index$iv);
        int mode = r4.valueAt(index$iv).intValue();
        String op = r9;
        if (mode != 4) goto L9;
        int key$iv = AppOpsManager.strOpToOp(op);
        $this$getForegroundOps_u24lambda_u2436.put(key$iv, true);
    L9:
        index$iv = index$iv + 1;
    L11:
        SparseBooleanArray $this$forEachIndexed$iv = this.foregroundableOps;
        int index$iv2 = 0;
        int r10 = $this$forEachIndexed$iv.size();
    L12:
        if (index$iv2 >= r10) goto L18;
        int op2 = $this$forEachIndexed$iv.keyAt(index$iv2);
        $this$forEachIndexed$iv.valueAt(index$iv2);
        if (getPackageMode(packageName, op2, userId) != 4) goto L16;
        $this$getForegroundOps_u24lambda_u2436.put(op2, true);
    L16:
        index$iv2 = index$iv2 + 1;
        goto L12
    L18:
        return $this$getForegroundOps_u24lambda_u2436;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean addAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        Object r0 = this.listenersLock;
        monitor-enter(r0);
        ArraySet<AppOpsCheckingServiceInterface.AppOpsModeChangedListener> r2 = new ArraySet(this.listeners);     // Catch: Throwable -> L8
        boolean r3 = r2.add(listener);     // Catch: Throwable -> L8
        this.listeners = r2;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.AppOpsCheckingServiceInterface
    public boolean removeAppOpsModeChangedListener(AppOpsCheckingServiceInterface.AppOpsModeChangedListener listener) {
        Object r0 = this.listenersLock;
        monitor-enter(r0);
        ArraySet<AppOpsCheckingServiceInterface.AppOpsModeChangedListener> r2 = new ArraySet(this.listeners);     // Catch: Throwable -> L8
        boolean r3 = r2.remove(listener);     // Catch: Throwable -> L8
        this.listeners = r2;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = AppOpService.class.getSimpleName();
    }
}
