package com.android.server.permission.access;

import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.os.SystemProperties;
import android.permission.PermissionManager;
import android.util.ArrayMap;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.SystemService;
import com.android.server.appop.AppOpsCheckingServiceInterface;
import com.android.server.permission.PermissionManagerLocal;
import com.android.server.permission.access.appop.AppOpService;
import com.android.server.permission.access.immutable.IndexedListSet;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IntMap;
import com.android.server.permission.access.immutable.IntMapExtensionsKt;
import com.android.server.permission.access.immutable.IntSetExtensionsKt;
import com.android.server.permission.access.immutable.MutableIndexedListSet;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIntMap;
import com.android.server.permission.access.immutable.MutableIntSet;
import com.android.server.permission.access.permission.PermissionManagerLocalImpl;
import com.android.server.permission.access.permission.PermissionService;
import com.android.server.permission.jarjar.kotlin.Pair;
import com.android.server.permission.jarjar.kotlin.TuplesKt;
import com.android.server.permission.jarjar.kotlin.Unit;
import com.android.server.permission.jarjar.kotlin.jdk7.AutoCloseableKt;
import com.android.server.permission.jarjar.kotlin.jvm.functions.Function1;
import com.android.server.permission.jarjar.kotlin.jvm.internal.InlineMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.pm.PackageManagerLocal;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.permission.PermissionAllowlist;
import com.android.server.pm.permission.PermissionManagerServiceInterface;
import com.android.server.pm.pkg.PackageState;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AccessCheckingService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessCheckingService extends SystemService {
    private AppOpService appOpService;
    private PackageManagerInternal packageManagerInternal;
    private PackageManagerLocal packageManagerLocal;
    private PermissionService permissionService;
    private final AccessPersistence persistence;
    private final AccessPolicy policy;
    private volatile AccessState state;
    private final Object stateLock;
    private SystemConfig systemConfig;
    private UserManagerService userManagerService;

    public static final /* synthetic */ AccessPersistence access$getPersistence$p(AccessCheckingService $this) {
        return $this.persistence;
    }

    public static final /* synthetic */ AccessPolicy access$getPolicy$p(AccessCheckingService $this) {
        return $this.policy;
    }

    public static final /* synthetic */ AccessState access$getState$p(AccessCheckingService $this) {
        return $this.state;
    }

    public static final /* synthetic */ Object access$getStateLock$p(AccessCheckingService $this) {
        return $this.stateLock;
    }

    public static final /* synthetic */ void access$setState$p(AccessCheckingService $this, AccessState r1) {
        $this.state = r1;
    }

    public AccessCheckingService(Context context) {
        super(context);
        this.stateLock = new Object();
        this.policy = new AccessPolicy();
        this.persistence = new AccessPersistence(this.policy);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.appOpService = new AppOpService(this);
        this.permissionService = new PermissionService(this);
        AppOpService r0 = this.appOpService;
        PermissionService r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appOpService");
        r0 = null;
    L5:
        LocalServices.addService(AppOpsCheckingServiceInterface.class, r0);
        PermissionService r2 = this.permissionService;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("permissionService");
    L9:
        LocalServices.addService(PermissionManagerServiceInterface.class, r1);
        LocalManagerRegistry.addManager(PermissionManagerLocal.class, new PermissionManagerLocalImpl(this));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void initialize() {
        this.packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.packageManagerLocal = (PackageManagerLocal) LocalManagerRegistry.getManagerOrThrow(PackageManagerLocal.class);
        this.userManagerService = UserManagerService.getInstance();
        this.systemConfig = SystemConfig.getInstance();
        UserManagerService r0 = this.userManagerService;
        PermissionService r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerService");
        r0 = null;
    L5:
        MutableIntSet userIds = IntSetExtensionsKt.MutableIntSet(r0.getUserIdsIncludingPreCreated());
        PackageManagerLocal r2 = this.packageManagerLocal;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r2 = null;
    L8:
        Pair<Map<String, PackageState>, Map<String, PackageState>> r3 = getAllPackageStates(r2);
        Map<String, PackageState> r5 = r3.component1();
        Map<String, PackageState> r6 = r3.component2();
        PackageManagerInternal r4 = this.packageManagerInternal;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r4 = null;
    L11:
        IntMap<String[]> r7 = getKnownPackages(r4);
        SystemConfig r8 = this.systemConfig;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("systemConfig");
        r8 = null;
    L14:
        boolean isLeanback = isLeanback(r8);
        SystemConfig r9 = this.systemConfig;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("systemConfig");
        r9 = null;
    L17:
        ArrayMap<String, SystemConfig.PermissionEntry> r10 = r9.getPermissions();
        SystemConfig r11 = this.systemConfig;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("systemConfig");
        r11 = null;
    L20:
        IndexedListSet<String> r12 = getPrivilegedPermissionAllowlistPackages(r11);
        SystemConfig r13 = this.systemConfig;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("systemConfig");
        r13 = null;
    L23:
        PermissionAllowlist permissionAllowlist = r13.getPermissionAllowlist();
        SystemConfig r14 = this.systemConfig;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("systemConfig");
        r14 = null;
    L26:
        IndexedMap<String, IndexedListSet<String>> r15 = getImplicitToSourcePermissions(r14);
        MutableAccessState state = new MutableAccessState();
        this.policy.initialize(state, userIds, r5, r6, r7, isLeanback, r10, r12, permissionAllowlist, r15);
        this.persistence.initialize();
        this.persistence.read(state);
        this.state = state;
        AppOpService r16 = this.appOpService;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("appOpService");
        r16 = null;
    L29:
        r16.initialize();
        PermissionService r17 = this.permissionService;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("permissionService");
    L33:
        r1.initialize();
        return;
    L32:
        r1 = r17;
        goto L33
    }

    private final boolean isLeanback(SystemConfig $this$isLeanback) {
        return $this$isLeanback.getAvailableFeatures().containsKey("android.software.leanback");
    }

    private final IndexedListSet<String> getPrivilegedPermissionAllowlistPackages(SystemConfig $this$privilegedPermissionAllowlistPackages) {
        boolean r2 = true;
        MutableIndexedListSet $this$_get_privilegedPermissionAllowlistPackages__u24lambda_u240 = new MutableIndexedListSet(null, 1, null);
        $this$_get_privilegedPermissionAllowlistPackages__u24lambda_u240.add(PackageManagerService.PLATFORM_PACKAGE_NAME);
        if ($this$privilegedPermissionAllowlistPackages.getAvailableFeatures().containsKey("android.hardware.type.automotive") == false) goto L11;
        String carServicePackage = SystemProperties.get("ro.android.car.carservice.package");
        if (carServicePackage.length() > 0) goto L8;
        r2 = false;
    L8:
        if (r2 == false) goto L11;
        $this$_get_privilegedPermissionAllowlistPackages__u24lambda_u240.add(carServicePackage);
    L11:
        return $this$_get_privilegedPermissionAllowlistPackages__u24lambda_u240;
    }

    private final IndexedMap<String, IndexedListSet<String>> getImplicitToSourcePermissions(SystemConfig $this$implicitToSourcePermissions) {
        int r2 = 1;
        MutableIndexedMap r0 = new MutableIndexedMap(null, 1, null);
        MutableIndexedMap $this$_get_implicitToSourcePermissions__u24lambda_u244 = r0;
        int r4 = 0;
        Iterable $this$forEach$iv = $this$implicitToSourcePermissions.getSplitPermissions();
        Iterator r7 = $this$forEach$iv.iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        Object element$iv = r7.next();
        PermissionManager.SplitPermissionInfo splitPermissionInfo = (PermissionManager.SplitPermissionInfo) element$iv;
        String sourcePermissionName = splitPermissionInfo.getSplitPermission();
        Iterable $this$forEach$iv2 = splitPermissionInfo.getNewPermissions();
        Iterator r14 = $this$forEach$iv2.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        Object element$iv2 = r14.next();
        String implicitPermissionName = (String) element$iv2;
        MutableIndexedMap $this$getOrPut$iv = $this$_get_implicitToSourcePermissions__u24lambda_u244;
        Object it$iv = $this$getOrPut$iv.get(implicitPermissionName);
        if (it$iv == null) goto L11;
        int r5 = 1;
    L12:
        MutableIndexedListSet $this$plusAssign$iv = (MutableIndexedListSet) it$iv;
        $this$plusAssign$iv.add(sourcePermissionName);
        r2 = r5;
        r4 = r4;
        r0 = r0;
        $this$_get_implicitToSourcePermissions__u24lambda_u244 = $this$_get_implicitToSourcePermissions__u24lambda_u244;
        goto L7
    L11:
        r5 = 1;
        it$iv = new MutableIndexedListSet(null, 1, null);
        $this$getOrPut$iv.put(implicitPermissionName, it$iv);
        goto L12
    L13:
        r4 = r4;
        goto L4
    L15:
        return r0;
    }

    public final void onUserAdded$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(int userId) {
        Object r2 = access$getStateLock$p(this);
        monitor-enter(r2);
        AccessState oldState$iv = access$getState$p(this);     // Catch: Throwable -> L8
        if (oldState$iv != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L8
        oldState$iv = null;
    L10:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L8
        MutateStateScope $this$onUserAdded_u24lambda_u246 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$onUserAdded_u24lambda_u246_u24lambda_u245 = access$getPolicy$p(this);     // Catch: Throwable -> L8
        $this$onUserAdded_u24lambda_u246_u24lambda_u245.onUserAdded($this$onUserAdded_u24lambda_u246, userId);     // Catch: Throwable -> L8
        access$getPersistence$p(this).write(newState$iv);     // Catch: Throwable -> L8
        access$setState$p(this, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = access$getPolicy$p(this);     // Catch: Throwable -> L8
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L8
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r2);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void onUserRemoved$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(int userId) {
        Object r2 = access$getStateLock$p(this);
        monitor-enter(r2);
        AccessState oldState$iv = access$getState$p(this);     // Catch: Throwable -> L8
        if (oldState$iv != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L8
        oldState$iv = null;
    L10:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L8
        MutateStateScope $this$onUserRemoved_u24lambda_u248 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$onUserRemoved_u24lambda_u248_u24lambda_u247 = access$getPolicy$p(this);     // Catch: Throwable -> L8
        $this$onUserRemoved_u24lambda_u248_u24lambda_u247.onUserRemoved($this$onUserRemoved_u24lambda_u248, userId);     // Catch: Throwable -> L8
        access$getPersistence$p(this).write(newState$iv);     // Catch: Throwable -> L8
        access$setState$p(this, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = access$getPolicy$p(this);     // Catch: Throwable -> L8
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L8
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r2);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void onStorageVolumeMounted$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(String volumeUuid, List<String> r19, boolean isSystemUpdated) {
        PackageManagerLocal r0 = this.packageManagerLocal;
        AccessState oldState$iv = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        Pair<Map<String, PackageState>, Map<String, PackageState>> r1 = getAllPackageStates(r0);
        Map<String, PackageState> r6 = r1.component1();
        Map<String, PackageState> r7 = r1.component2();
        PackageManagerInternal r2 = this.packageManagerInternal;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r2 = null;
    L8:
        IntMap<String[]> r8 = getKnownPackages(r2);
        Object r13 = access$getStateLock$p(this);
        monitor-enter(r13);
        AccessState r4 = access$getState$p(this);     // Catch: Throwable -> L14
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L14
    L17:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L14
        MutateStateScope $this$onStorageVolumeMounted_u24lambda_u2410 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L14
        AccessPolicy $this$onStorageVolumeMounted_u24lambda_u2410_u24lambda_u249 = access$getPolicy$p(this);     // Catch: Throwable -> L14
        $this$onStorageVolumeMounted_u24lambda_u2410_u24lambda_u249.onStorageVolumeMounted($this$onStorageVolumeMounted_u24lambda_u2410, r6, r7, r8, volumeUuid, r19, isSystemUpdated);     // Catch: Throwable -> L14
        access$getPersistence$p(this).write(newState$iv);     // Catch: Throwable -> L14
        access$setState$p(this, newState$iv);     // Catch: Throwable -> L14
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = access$getPolicy$p(this);     // Catch: Throwable -> L14
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r13);
        return;
    L16:
        oldState$iv = r4;
    L14:
        th = move-exception;
        throw th;
    }

    public final void onPackageAdded$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(String packageName) {
        PackageManagerLocal r0 = this.packageManagerLocal;
        AccessState oldState$iv = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        Pair<Map<String, PackageState>, Map<String, PackageState>> r1 = getAllPackageStates(r0);
        Map<String, PackageState> r5 = r1.component1();
        Map<String, PackageState> r6 = r1.component2();
        PackageManagerInternal r2 = this.packageManagerInternal;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r2 = null;
    L8:
        IntMap<String[]> r7 = getKnownPackages(r2);
        Object r10 = access$getStateLock$p(this);
        monitor-enter(r10);
        AccessState r3 = access$getState$p(this);     // Catch: Throwable -> L25
        if (r3 == null) goto L31;
        oldState$iv = r3;
    L18:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L25
        MutateStateScope $this$onPackageAdded_u24lambda_u2412 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L25
        AccessPolicy $this$onPackageAdded_u24lambda_u2412_u24lambda_u2411 = access$getPolicy$p(this);     // Catch: Throwable -> L25
        $this$onPackageAdded_u24lambda_u2412_u24lambda_u2411.onPackageAdded($this$onPackageAdded_u24lambda_u2412, r5, r6, r7, packageName);     // Catch: Throwable -> L23
        access$getPersistence$p(this).write(newState$iv);     // Catch: Throwable -> L23
        access$setState$p(this, newState$iv);     // Catch: Throwable -> L23
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = access$getPolicy$p(this);     // Catch: Throwable -> L23
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L23
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r10);
        return;
    L23:
        th = th;
    L27:
        monitor-exit(r10);
        throw th;
    L31:
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L15
    L15:
        th = th;
    L25:
        th = th;
        goto L27
    }

    public final void onPackageRemoved$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(String packageName, int appId) {
        PackageManagerLocal r0 = this.packageManagerLocal;
        AccessState oldState$iv = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        Pair<Map<String, PackageState>, Map<String, PackageState>> r1 = getAllPackageStates(r0);
        Map<String, PackageState> r6 = r1.component1();
        Map<String, PackageState> r7 = r1.component2();
        PackageManagerInternal r2 = this.packageManagerInternal;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r2 = null;
    L8:
        IntMap<String[]> r8 = getKnownPackages(r2);
        Object r12 = access$getStateLock$p(this);
        monitor-enter(r12);
        AccessState r4 = access$getState$p(this);     // Catch: Throwable -> L14
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L14
    L17:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L14
        MutateStateScope $this$onPackageRemoved_u24lambda_u2414 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L14
        AccessPolicy $this$onPackageRemoved_u24lambda_u2414_u24lambda_u2413 = access$getPolicy$p(this);     // Catch: Throwable -> L14
        $this$onPackageRemoved_u24lambda_u2414_u24lambda_u2413.onPackageRemoved($this$onPackageRemoved_u24lambda_u2414, r6, r7, r8, packageName, appId);     // Catch: Throwable -> L14
        access$getPersistence$p(this).write(newState$iv);     // Catch: Throwable -> L14
        access$setState$p(this, newState$iv);     // Catch: Throwable -> L14
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = access$getPolicy$p(this);     // Catch: Throwable -> L14
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r12);
        return;
    L16:
        oldState$iv = r4;
    L14:
        th = move-exception;
        throw th;
    }

    public final void onPackageInstalled$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(String packageName, int userId) {
        PackageManagerLocal r0 = this.packageManagerLocal;
        AccessState oldState$iv = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        Pair<Map<String, PackageState>, Map<String, PackageState>> r1 = getAllPackageStates(r0);
        Map<String, PackageState> r6 = r1.component1();
        Map<String, PackageState> r7 = r1.component2();
        PackageManagerInternal r2 = this.packageManagerInternal;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r2 = null;
    L8:
        IntMap<String[]> r8 = getKnownPackages(r2);
        Object r12 = access$getStateLock$p(this);
        monitor-enter(r12);
        AccessState r4 = access$getState$p(this);     // Catch: Throwable -> L14
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L14
    L17:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L14
        MutateStateScope $this$onPackageInstalled_u24lambda_u2416 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L14
        AccessPolicy $this$onPackageInstalled_u24lambda_u2416_u24lambda_u2415 = access$getPolicy$p(this);     // Catch: Throwable -> L14
        $this$onPackageInstalled_u24lambda_u2416_u24lambda_u2415.onPackageInstalled($this$onPackageInstalled_u24lambda_u2416, r6, r7, r8, packageName, userId);     // Catch: Throwable -> L14
        access$getPersistence$p(this).write(newState$iv);     // Catch: Throwable -> L14
        access$setState$p(this, newState$iv);     // Catch: Throwable -> L14
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = access$getPolicy$p(this);     // Catch: Throwable -> L14
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r12);
        return;
    L16:
        oldState$iv = r4;
    L14:
        th = move-exception;
        throw th;
    }

    public final void onPackageUninstalled$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(String packageName, int appId, int userId) {
        PackageManagerLocal r0 = this.packageManagerLocal;
        AccessState oldState$iv = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        Pair<Map<String, PackageState>, Map<String, PackageState>> r1 = getAllPackageStates(r0);
        Map<String, PackageState> r6 = r1.component1();
        Map<String, PackageState> r7 = r1.component2();
        PackageManagerInternal r2 = this.packageManagerInternal;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r2 = null;
    L8:
        IntMap<String[]> r8 = getKnownPackages(r2);
        Object r13 = access$getStateLock$p(this);
        monitor-enter(r13);
        AccessState r4 = access$getState$p(this);     // Catch: Throwable -> L14
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L14
    L17:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L14
        MutateStateScope $this$onPackageUninstalled_u24lambda_u2418 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L14
        AccessPolicy $this$onPackageUninstalled_u24lambda_u2418_u24lambda_u2417 = access$getPolicy$p(this);     // Catch: Throwable -> L14
        $this$onPackageUninstalled_u24lambda_u2418_u24lambda_u2417.onPackageUninstalled($this$onPackageUninstalled_u24lambda_u2418, r6, r7, r8, packageName, appId, userId);     // Catch: Throwable -> L14
        access$getPersistence$p(this).write(newState$iv);     // Catch: Throwable -> L14
        access$setState$p(this, newState$iv);     // Catch: Throwable -> L14
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = access$getPolicy$p(this);     // Catch: Throwable -> L14
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r13);
        return;
    L16:
        oldState$iv = r4;
    L14:
        th = move-exception;
        throw th;
    }

    public final void onSystemReady$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        Object r2 = access$getStateLock$p(this);
        monitor-enter(r2);
        AccessState oldState$iv = access$getState$p(this);     // Catch: Throwable -> L8
        if (oldState$iv != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L8
        oldState$iv = null;
    L10:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L8
        MutateStateScope $this$onSystemReady_u24lambda_u2420 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$onSystemReady_u24lambda_u2420_u24lambda_u2419 = access$getPolicy$p(this);     // Catch: Throwable -> L8
        $this$onSystemReady_u24lambda_u2420_u24lambda_u2419.onSystemReady($this$onSystemReady_u24lambda_u2420);     // Catch: Throwable -> L8
        access$getPersistence$p(this).write(newState$iv);     // Catch: Throwable -> L8
        access$setState$p(this, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = access$getPolicy$p(this);     // Catch: Throwable -> L8
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L8
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r2);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final Pair<Map<String, PackageState>, Map<String, PackageState>> getAllPackageStates(PackageManagerLocal $this$allPackageStates) {
        PackageManagerLocal.UnfilteredSnapshot it = $this$allPackageStates.withUnfilteredSnapshot();
        Pair<Map<String, PackageState>, Map<String, PackageState>> r3 = TuplesKt.to(it.getPackageStates(), it.getDisabledSystemPackageStates());     // Catch: Throwable -> L6
        AutoCloseableKt.closeFinally(it, null);
        return r3;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    private final IntMap<String[]> getKnownPackages(PackageManagerInternal $this$knownPackages) {
        MutableIntMap $this$_get_knownPackages__u24lambda_u2422 = new MutableIntMap(null, 1, null);
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 2, $this$knownPackages.getKnownPackageNames(2, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 7, $this$knownPackages.getKnownPackageNames(7, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 4, $this$knownPackages.getKnownPackageNames(4, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 1, $this$knownPackages.getKnownPackageNames(1, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 6, $this$knownPackages.getKnownPackageNames(6, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 10, $this$knownPackages.getKnownPackageNames(10, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 11, $this$knownPackages.getKnownPackageNames(11, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 12, $this$knownPackages.getKnownPackageNames(12, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 15, $this$knownPackages.getKnownPackageNames(15, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 16, $this$knownPackages.getKnownPackageNames(16, 0));
        IntMapExtensionsKt.set($this$_get_knownPackages__u24lambda_u2422, 17, $this$knownPackages.getKnownPackageNames(17, 0));
        return $this$_get_knownPackages__u24lambda_u2422;
    }

    public final <T> T getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(Function1<? super GetStateScope, ? extends T> r4) {
        AccessState r2 = access$getState$p(this);
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r2 = null;
    L6:
        return r4.invoke(new GetStateScope(r2));
    }

    public final void mutateState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(Function1<? super MutateStateScope, Unit> r10) {
        Object r1 = access$getStateLock$p(this);
        monitor-enter(r1);
        AccessState oldState = access$getState$p(this);     // Catch: Throwable -> L8
        if (oldState != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L8
        oldState = null;
    L10:
        MutableAccessState newState = oldState.toMutable();     // Catch: Throwable -> L8
        r10.invoke(new MutateStateScope(oldState, newState));     // Catch: Throwable -> L8
        access$getPersistence$p(this).write(newState);     // Catch: Throwable -> L8
        access$setState$p(this, newState);     // Catch: Throwable -> L8
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423 = access$getPolicy$p(this);     // Catch: Throwable -> L8
        $this$mutateState_u24lambda_u2424_u24lambda_u2423.onStateMutated(new GetStateScope(newState));     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
        InlineMarker.finallyStart(1);
        monitor-exit(r1);
        InlineMarker.finallyEnd(1);
        return;
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final SchemePolicy getSchemePolicy$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(String subjectScheme, String objectScheme) {
        return this.policy.getSchemePolicy(subjectScheme, objectScheme);
    }
}
