package com.android.server.permission.access.permission;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.permission.SplitPermissionInfoParcelable;
import android.metrics.LogMaker;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.permission.IOnPermissionsChangeListener;
import android.permission.PermissionControllerManager;
import android.permission.PermissionManager;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.Utils;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.server.BaseZswSystemServiceFactory;
import com.android.server.FgThread;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.PermissionThread;
import com.android.server.ServiceThread;
import com.android.server.SystemConfig;
import com.android.server.am.HostingRecord;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.permission.access.AccessCheckingService;
import com.android.server.permission.access.AccessPolicy;
import com.android.server.permission.access.AccessState;
import com.android.server.permission.access.GetStateScope;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutableUserState;
import com.android.server.permission.access.MutateStateScope;
import com.android.server.permission.access.SchemePolicy;
import com.android.server.permission.access.UserState;
import com.android.server.permission.access.appop.AppIdAppOpPolicy;
import com.android.server.permission.access.collection.ArraySetExtensionsKt;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IndexedReferenceMap;
import com.android.server.permission.access.immutable.IndexedSet;
import com.android.server.permission.access.immutable.IndexedSetExtensionsKt;
import com.android.server.permission.access.immutable.IntMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntSet;
import com.android.server.permission.access.immutable.IntSetExtensionsKt;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedSet;
import com.android.server.permission.access.immutable.MutableIntMap;
import com.android.server.permission.access.immutable.MutableIntSet;
import com.android.server.permission.access.util.IntExtensionsKt;
import com.android.server.permission.jarjar.kotlin.Unit;
import com.android.server.permission.jarjar.kotlin.collections.ArraysKt;
import com.android.server.permission.jarjar.kotlin.collections.CollectionsKt;
import com.android.server.permission.jarjar.kotlin.collections.MapsKt;
import com.android.server.permission.jarjar.kotlin.collections.SetsKt;
import com.android.server.permission.jarjar.kotlin.jdk7.AutoCloseableKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Ref$ObjectRef;
import com.android.server.pm.ComputerEngine;
import com.android.server.pm.PackageInstallerService;
import com.android.server.pm.PackageManagerLocal;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.permission.LegacyPermission;
import com.android.server.pm.permission.LegacyPermissionSettings;
import com.android.server.pm.permission.LegacyPermissionState;
import com.android.server.pm.permission.PermissionManagerServiceInterface;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import libcore.util.EmptyArray;

/* JADX INFO: compiled from: PermissionService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionService implements PermissionManagerServiceInterface {
    private static final long BACKGROUND_RATIONALE_CHANGE_ID = 0;
    private static final long BACKUP_TIMEOUT_MILLIS = 0;
    public static final Companion Companion = null;
    private static final ArrayMap<String, String> FULLER_PERMISSIONS = null;
    private static final String LOG_TAG = null;
    private static final ArraySet<String> NOTIFICATIONS_PERMISSIONS = null;
    private final Context context;
    private final DevicePermissionPolicy devicePolicy;
    private Handler handler;
    private HandlerThread handlerThread;
    private final SparseBooleanArray isDelayedPermissionBackupFinished;
    private MetricsLogger metricsLogger;
    private final ArraySet<String> mountedStorageVolumes;
    private OnPermissionFlagsChangedListener onPermissionFlagsChangedListener;
    private OnPermissionsChangeListeners onPermissionsChangeListeners;
    private PackageManagerInternal packageManagerInternal;
    private PackageManagerLocal packageManagerLocal;
    private PermissionControllerManager permissionControllerManager;
    private IPlatformCompat platformCompat;
    private final AppIdPermissionPolicy policy;
    private final AccessCheckingService service;
    private final Object storageVolumeLock;
    private final ArrayMap<String, List<String>> storageVolumePackageNames;
    private SystemConfig systemConfig;
    private UserManagerInternal userManagerInternal;
    private UserManagerService userManagerService;
    private VirtualDeviceManagerInternal virtualDeviceManagerInternal;

    /* JADX INFO: compiled from: PermissionService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final String getFullerPermission(String permissionName) {
            return (String) PermissionService.access$getFULLER_PERMISSIONS$cp().get(permissionName);
        }
    }

    /* JADX INFO: compiled from: PermissionService.kt */
    private final class OnPermissionFlagsChangedListener implements AppIdPermissionPolicy.OnPermissionFlagsChangedListener, DevicePermissionPolicy.OnDevicePermissionFlagsChangedListener {
        private final MutableIntSet gidsChangedUids;
        private boolean isKillRuntimePermissionRevokedUidsSkipped;
        private boolean isPermissionFlagsChanged;
        private final ArraySet<String> killRuntimePermissionRevokedUidsReasons;
        private final MutableIntMap<Set<String>> runtimePermissionChangedUidDevices;
        private final SparseBooleanArray runtimePermissionRevokedUids;
        final /* synthetic */ PermissionService this$0;

        public OnPermissionFlagsChangedListener(PermissionService this$0) {
            this.this$0 = this$0;
            this.runtimePermissionChangedUidDevices = new MutableIntMap(null, 1, null);
            this.runtimePermissionRevokedUids = new SparseBooleanArray();
            this.gidsChangedUids = new MutableIntSet(null, 1, null);
            this.killRuntimePermissionRevokedUidsReasons = new ArraySet();
        }

        public static final /* synthetic */ boolean access$isAppBackupAndRestoreRunning(OnPermissionFlagsChangedListener $this, int uid) {
            return $this.isAppBackupAndRestoreRunning(uid);
        }

        public final void skipKillRuntimePermissionRevokedUids(MutateStateScope $this$skipKillRuntimePermissionRevokedUids) {
            this.isKillRuntimePermissionRevokedUidsSkipped = true;
        }

        public final void addKillRuntimePermissionRevokedUidsReason(MutateStateScope $this$addKillRuntimePermissionRevokedUidsReason, String reason) {
            this.killRuntimePermissionRevokedUidsReasons.add(reason);
        }

        @Override // com.android.server.permission.access.permission.AppIdPermissionPolicy.OnPermissionFlagsChangedListener
        public void onPermissionFlagsChanged(int appId, int userId, String permissionName, int oldFlags, int newFlags) {
            onDevicePermissionFlagsChanged(appId, userId, "default:0", permissionName, oldFlags, newFlags);
        }

        @Override // com.android.server.permission.access.permission.DevicePermissionPolicy.OnDevicePermissionFlagsChangedListener
        public void onDevicePermissionFlagsChanged(int appId, int userId, String deviceId, String permissionName, int oldFlags, int newFlags) {
            boolean r2 = true;
            this.isPermissionFlagsChanged = true;
            int uid = UserHandle.getUid(userId, appId);
            AccessCheckingService this_$iv = PermissionService.access$getService$p(this.this$0);
            PermissionService r7 = this.this$0;
            AccessState r10 = AccessCheckingService.access$getState$p(this_$iv);
            if (r10 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("state");
            r10 = null;
        L5:
            GetStateScope $this$onDevicePermissionFlagsChanged_u24lambda_u241 = new GetStateScope(r10);
            AppIdPermissionPolicy $this$onDevicePermissionFlagsChanged_u24lambda_u241_u24lambda_u240 = PermissionService.access$getPolicy$p(r7);
            Permission permission = $this$onDevicePermissionFlagsChanged_u24lambda_u241_u24lambda_u240.getPermissions($this$onDevicePermissionFlagsChanged_u24lambda_u241).get(permissionName);
            if (permission != null) goto L8;
            return;
        L8:
            boolean wasPermissionGranted = PermissionFlags.INSTANCE.isPermissionGranted(oldFlags);
            boolean isPermissionGranted = PermissionFlags.INSTANCE.isPermissionGranted(newFlags);
            if (permission.getPermissionInfo().getProtection() != 1) goto L11;
            boolean r11 = true;
        L12:
            if (r11 == false) goto L29;
            if (wasPermissionGranted == false) goto L22;
            if (isPermissionGranted == true) goto L22;
            SparseBooleanArray $this$set$iv = this.runtimePermissionRevokedUids;
            if (PermissionService.access$getNOTIFICATIONS_PERMISSIONS$cp().contains(permissionName) == true) goto L18;
        L20:
            boolean value$iv = false;
        L21:
            $this$set$iv.put(uid, value$iv);
            goto L22
        L18:
            if (this.runtimePermissionRevokedUids.get(uid, true) == false) goto L20;
            value$iv = true;
        L22:
            MutableIntMap<Set<String>> r12 = this.runtimePermissionChangedUidDevices;
            Set<String> r13 = r12.get(uid);
            if (r13 != null) goto L26;
            r13 = new LinkedHashSet();
            r12.put(uid, r13);
        L26:
            r13.add(deviceId);
        L29:
            if (permission.getGids().length == 0) goto L32;
            r2 = false;
        L32:
            if (r2 == true) goto L36;
            if (wasPermissionGranted == isPermissionGranted) goto L37;
            IntSetExtensionsKt.plusAssign(this.gidsChangedUids, uid);
            return;
        L37:
            return;
        L36:
            return;
        L11:
            r11 = false;
            goto L12
        }

        @Override // com.android.server.permission.access.permission.AppIdPermissionPolicy.OnPermissionFlagsChangedListener, com.android.server.permission.access.permission.DevicePermissionPolicy.OnDevicePermissionFlagsChangedListener
        public void onStateMutated() {
            if (this.isPermissionFlagsChanged == false) goto L5;
            PackageManager.invalidatePackageInfoCache();
            this.isPermissionFlagsChanged = false;
        L5:
            IntMap $this$forEachIndexed$iv = this.runtimePermissionChangedUidDevices;
            PermissionService r1 = this.this$0;
            int index$iv = 0;
            int r5 = $this$forEachIndexed$iv.getSize();
        L6:
            if (index$iv >= r5) goto L16;
            int uid = $this$forEachIndexed$iv.keyAt(index$iv);
            Iterator<T> r13 = $this$forEachIndexed$iv.valueAt(index$iv).iterator();
        L9:
            if (r13.hasNext() == false) goto L15;
            Object element$iv = r13.next();
            String deviceId = (String) element$iv;
            OnPermissionsChangeListeners r17 = PermissionService.access$getOnPermissionsChangeListeners$p(r1);
            if (r17 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("onPermissionsChangeListeners");
            OnPermissionsChangeListeners r7 = null;
        L14:
            r7.onPermissionsChanged(uid, deviceId);
            goto L9
        L13:
            r7 = r17;
            goto L14
        L15:
            index$iv = index$iv + 1;
            goto L6
        L16:
            this.runtimePermissionChangedUidDevices.clear();
            if (this.isKillRuntimePermissionRevokedUidsSkipped == false) goto L19;
        L30:
            this.runtimePermissionRevokedUids.clear();
            IntSet $this$forEachIndexed$iv2 = this.gidsChangedUids;
            final PermissionService r2 = this.this$0;
            int index$iv2 = 0;
            int r6 = $this$forEachIndexed$iv2.getSize();
        L31:
            if (index$iv2 >= r6) goto L36;
            final int uid2 = $this$forEachIndexed$iv2.elementAt(index$iv2);
            Handler r10 = PermissionService.access$getHandler$p(r2);
            if (r10 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("handler");
            r10 = null;
        L35:
            r10.post(new PermissionService$OnPermissionFlagsChangedListener$onStateMutated$3$1(r2, uid2));
            index$iv2 = index$iv2 + 1;
            goto L31
        L36:
            this.gidsChangedUids.clear();
            this.isKillRuntimePermissionRevokedUidsSkipped = false;
            this.killRuntimePermissionRevokedUidsReasons.clear();
            return;
        L19:
            if (this.killRuntimePermissionRevokedUidsReasons.isEmpty() == true) goto L21;
            final String reason = CollectionsKt.joinToString$default(this.killRuntimePermissionRevokedUidsReasons, ", ", null, null, 0, null, null, 62, null);
        L22:
            SparseBooleanArray $this$forEachIndexed$iv3 = this.runtimePermissionRevokedUids;
            final PermissionService r4 = this.this$0;
            int r11 = $this$forEachIndexed$iv3.size();
            int index$iv3 = 0;
        L23:
            if (index$iv3 >= r11) goto L30;
            final int uid3 = $this$forEachIndexed$iv3.keyAt(index$iv3);
            final boolean areOnlyNotificationsPermissionsRevoked = $this$forEachIndexed$iv3.valueAt(index$iv3);
            Handler r0 = PermissionService.access$getHandler$p(r4);
            if (r0 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("handler");
            Handler r14 = null;
        L28:
            r14.post(new PermissionService$OnPermissionFlagsChangedListener$onStateMutated$2$1(areOnlyNotificationsPermissionsRevoked, this, uid3, r4, reason));
            index$iv3 = index$iv3 + 1;
            goto L23
        L27:
            r14 = r0;
            goto L28
        L21:
            reason = "permissions revoked";
            goto L22
        }

        private final boolean isAppBackupAndRestoreRunning(int uid) {
            if (this.this$0.checkUidPermission(uid, "android.permission.BACKUP", "default:0") == 0) goto L5;
            return false;
        L5:
            int userId = UserHandle.getUserId(uid);
            Integer r2 = getSecureInt("user_setup_complete", userId);
            if (r2 != null) goto L9;
        L11:
            boolean isInSetup = false;
        L12:
            if (isInSetup == false) goto L14;
            return true;
        L14:
            Integer r4 = getSecureInt("user_setup_personalization_state", userId);
            if (r4 != null) goto L18;
            return false;
        L18:
            if (r4.intValue() == 1) goto L21;
            return false;
        L21:
            return true;
        L9:
            if (r2.intValue() != 0) goto L11;
            isInSetup = true;
            goto L12
        }

        private final Integer getSecureInt(String settingName, int userId) {
            return Integer.valueOf(Settings.Secure.getIntForUser(PermissionService.access$getContext$p(this.this$0).getContentResolver(), settingName, userId));
        L4:
            e = move-exception;
            Slog.i(PermissionService.access$getLOG_TAG$cp(), "Setting " + settingName + " not found", e);
            return null;
        }
    }

    /* JADX INFO: compiled from: PermissionService.kt */
    private static final class OnPermissionsChangeListeners extends Handler {
        public static final Companion Companion = null;
        private final RemoteCallbackList<IOnPermissionsChangeListener> listeners;

        /* JADX INFO: compiled from: PermissionService.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public OnPermissionsChangeListeners(Looper looper) {
            super(looper);
            this.listeners = new RemoteCallbackList();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 1) goto L6;
            int uid = msg.arg1;
            Object r1 = msg.obj;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.String");
            String deviceId = (String) r1;
            handleOnPermissionsChanged(uid, deviceId);
            return;
        }

        private final void handleOnPermissionsChanged(final int uid, final String deviceId) {
            this.listeners.broadcast(new PermissionService$OnPermissionsChangeListeners$handleOnPermissionsChanged$1(uid, deviceId));
        }

        public final void addListener(IOnPermissionsChangeListener listener) {
            this.listeners.register(listener);
        }

        public final void removeListener(IOnPermissionsChangeListener listener) {
            this.listeners.unregister(listener);
        }

        public final void onPermissionsChanged(int uid, String deviceId) {
            if (this.listeners.getRegisteredCallbackCount() <= 0) goto L6;
            obtainMessage(1, uid, 0, deviceId).sendToTarget();
            return;
        }
    }

    public PermissionService(AccessCheckingService service) {
        this.service = service;
        SchemePolicy r0 = this.service.getSchemePolicy$frameworks__base__services__permission__android_common__services_permission_pre_jarjar("uid", "permission");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.android.server.permission.access.permission.AppIdPermissionPolicy");
        this.policy = (AppIdPermissionPolicy) r0;
        SchemePolicy r1 = this.service.getSchemePolicy$frameworks__base__services__permission__android_common__services_permission_pre_jarjar("uid", "device-permission");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.android.server.permission.access.permission.DevicePermissionPolicy");
        this.devicePolicy = (DevicePermissionPolicy) r1;
        this.context = this.service.getContext();
        this.storageVolumeLock = new Object();
        this.mountedStorageVolumes = new ArraySet();
        this.storageVolumePackageNames = new ArrayMap();
        this.isDelayedPermissionBackupFinished = new SparseBooleanArray();
    }

    public static final /* synthetic */ void access$enforcePermissionTreeSize(PermissionService $this, GetStateScope $receiver, PermissionInfo permissionInfo, Permission permissionTree) {
        $this.enforcePermissionTreeSize($receiver, permissionInfo, permissionTree);
    }

    public static final /* synthetic */ Permission access$getAndEnforcePermissionTree(PermissionService $this, GetStateScope $receiver, String permissionName) {
        return $this.getAndEnforcePermissionTree($receiver, permissionName);
    }

    public static final /* synthetic */ Context access$getContext$p(PermissionService $this) {
        return $this.context;
    }

    public static final /* synthetic */ DevicePermissionPolicy access$getDevicePolicy$p(PermissionService $this) {
        return $this.devicePolicy;
    }

    public static final /* synthetic */ ArrayMap access$getFULLER_PERMISSIONS$cp() {
        return FULLER_PERMISSIONS;
    }

    public static final /* synthetic */ Handler access$getHandler$p(PermissionService $this) {
        return $this.handler;
    }

    public static final /* synthetic */ String access$getLOG_TAG$cp() {
        return LOG_TAG;
    }

    public static final /* synthetic */ ArraySet access$getNOTIFICATIONS_PERMISSIONS$cp() {
        return NOTIFICATIONS_PERMISSIONS;
    }

    public static final /* synthetic */ OnPermissionFlagsChangedListener access$getOnPermissionFlagsChangedListener$p(PermissionService $this) {
        return $this.onPermissionFlagsChangedListener;
    }

    public static final /* synthetic */ OnPermissionsChangeListeners access$getOnPermissionsChangeListeners$p(PermissionService $this) {
        return $this.onPermissionsChangeListeners;
    }

    public static final /* synthetic */ AppIdPermissionPolicy access$getPolicy$p(PermissionService $this) {
        return $this.policy;
    }

    public static final /* synthetic */ AccessCheckingService access$getService$p(PermissionService $this) {
        return $this.service;
    }

    public static final /* synthetic */ SparseBooleanArray access$isDelayedPermissionBackupFinished$p(PermissionService $this) {
        return $this.isDelayedPermissionBackupFinished;
    }

    public static final /* synthetic */ void access$killUid(PermissionService $this, int uid, String reason) {
        $this.killUid(uid, reason);
    }

    public static final /* synthetic */ void access$setAppOpPermissionGranted(PermissionService $this, MutateStateScope $receiver, PackageState packageState, int userId, String permissionName, boolean isGranted) {
        $this.setAppOpPermissionGranted($receiver, packageState, userId, permissionName, isGranted);
    }

    public static final /* synthetic */ void access$setRuntimePermissionGranted(PermissionService $this, MutateStateScope $receiver, PackageState packageState, int userId, String permissionName, String deviceId, boolean isGranted, boolean canManageRolePermission, boolean overridePolicyFixed, boolean reportError, String methodName) {
        $this.setRuntimePermissionGranted($receiver, packageState, userId, permissionName, deviceId, isGranted, canManageRolePermission, overridePolicyFixed, reportError, methodName);
    }

    public static final /* synthetic */ void access$updatePermissionFlags(PermissionService $this, MutateStateScope $receiver, int appId, int userId, String permissionName, String deviceId, int flagMask, int flagValues, boolean canUpdateSystemFlags, boolean reportErrorForUnknownPermission, boolean isPermissionRequested, String methodName, String packageName) {
        $this.updatePermissionFlags($receiver, appId, userId, permissionName, deviceId, flagMask, flagValues, canUpdateSystemFlags, reportErrorForUnknownPermission, isPermissionRequested, methodName, packageName);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public /* bridge */ /* synthetic */ List getAllowlistedRestrictedPermissions(String packageName, int flags, int userId) {
        return getAllowlistedRestrictedPermissions(packageName, flags, userId);
    }

    public final void initialize() {
        this.metricsLogger = new MetricsLogger();
        this.packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.packageManagerLocal = (PackageManagerLocal) LocalManagerRegistry.getManagerOrThrow(PackageManagerLocal.class);
        this.platformCompat = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));
        this.systemConfig = SystemConfig.getInstance();
        this.userManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.userManagerService = UserManagerService.getInstance();
        PackageManager.invalidatePackageInfoCache();
        PermissionManager.disablePackageNamePermissionCache();
        ServiceThread $this$initialize_u24lambda_u240 = new ServiceThread(LOG_TAG, 10, true);
        $this$initialize_u24lambda_u240.start();
        this.handlerThread = $this$initialize_u24lambda_u240;
        HandlerThread r1 = this.handlerThread;
        OnPermissionFlagsChangedListener r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
        r1 = null;
    L5:
        this.handler = new Handler(r1.getLooper());
        this.onPermissionsChangeListeners = new OnPermissionsChangeListeners(FgThread.get().getLooper());
        this.onPermissionFlagsChangedListener = new OnPermissionFlagsChangedListener(this);
        AppIdPermissionPolicy r0 = this.policy;
        OnPermissionFlagsChangedListener r3 = this.onPermissionFlagsChangedListener;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("onPermissionFlagsChangedListener");
        r3 = null;
    L8:
        r0.addOnPermissionFlagsChangedListener(r3);
        DevicePermissionPolicy r4 = this.devicePolicy;
        OnPermissionFlagsChangedListener r5 = this.onPermissionFlagsChangedListener;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("onPermissionFlagsChangedListener");
    L12:
        r4.addOnPermissionFlagsChangedListener(r2);
        BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswPermissionService();
        return;
    L11:
        r2 = r5;
        goto L12
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        PermissionService r1 = this;
        PackageManagerLocal r0 = r1.packageManagerLocal;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        PackageManagerLocal.UnfilteredSnapshot r3 = r0.withUnfilteredSnapshot();
        PackageManagerLocal.UnfilteredSnapshot snapshot = r3;
        int r4 = 0;
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L11
        if (r1.isUidInstantApp(snapshot, callingUid) == false) goto L13;
        List<PermissionGroupInfo> r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L11
        AutoCloseableKt.closeFinally(r3, null);
        return r6;
    L13:
        AccessCheckingService this_$iv = r1.service;     // Catch: Throwable -> L11
        AccessState r9 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L11
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L11
        r9 = null;
    L16:
        GetStateScope $this$getAllPermissionGroups_u24lambda_u245_u24lambda_u242 = new GetStateScope(r9);     // Catch: Throwable -> L11
        AppIdPermissionPolicy $this$getAllPermissionGroups_u24lambda_u245_u24lambda_u242_u24lambda_u241 = r1.policy;     // Catch: Throwable -> L11
        IndexedMap<String, PermissionGroupInfo> r12 = $this$getAllPermissionGroups_u24lambda_u245_u24lambda_u242_u24lambda_u241.getPermissionGroups($this$getAllPermissionGroups_u24lambda_u245_u24lambda_u242);     // Catch: Throwable -> L11
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L11
        int index$iv$iv = 0;
        int r13 = r12.getSize();     // Catch: Throwable -> L11
    L17:
        if (index$iv$iv >= r13) goto L55;
        Object key$iv = r12.keyAt(index$iv$iv);     // Catch: Throwable -> L11
        Object value$iv = r12.valueAt(index$iv$iv);     // Catch: Throwable -> L11
        String r19 = (String) key$iv;     // Catch: Throwable -> L11
        PermissionGroupInfo permissionGroup = (PermissionGroupInfo) value$iv;     // Catch: Throwable -> L11
        int r110 = r4;
        if (r1.isPackageVisibleToUid(snapshot, permissionGroup.packageName, callingUid) == false) goto L50;
        PermissionGroupInfo info = r1.generatePermissionGroupInfo(permissionGroup, flags);     // Catch: Throwable -> L11
        Set skipPermission = SetsKt.setOf("android.permission-group.INSTALLED_APPS");     // Catch: Throwable -> L11
        if (info == null) goto L49;
        PackageManagerLocal.UnfilteredSnapshot snapshot2 = snapshot;
        PackageManagerInternal r2 = r1.packageManagerInternal;     // Catch: Throwable -> L11
        if (r2 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");     // Catch: Throwable -> L11
        r2 = null;
    L25:
        PackageDataSnapshot snapshotInternal = r2.snapshot();     // Catch: Throwable -> L11
        if ((snapshotInternal instanceof ComputerEngine) == false) goto L47;
        String[] pkgs = ((ComputerEngine) snapshotInternal).getPackagesForUid(callingUid);     // Catch: Throwable -> L11
        boolean isXtsCaller = false;
        if (pkgs == null) goto L41;
        int r5 = pkgs.length;     // Catch: Throwable -> L11
        int r8 = 0;
    L30:
        PermissionGroupInfo permissionGroup2 = permissionGroup;
        if (r8 >= r5) goto L36;
        if (Utils.isXtsPkg(pkgs[r8]) == true) goto L34;
        r8 = r8 + 1;     // Catch: Throwable -> L11
        permissionGroup = permissionGroup2;
        goto L30
    L34:
        boolean r10 = true;
    L37:
        if (r10 != true) goto L41;
        isXtsCaller = true;
        goto L41
    L36:
        r10 = false;
    L41:
        if (isXtsCaller == false) goto L46;
        PermissionGroupInfo info2 = info;
        if (skipPermission.contains(info2.name) == false) goto L48;
        Slog.e(LOG_TAG, "getAllPermissionGroups: skipping " + info2 + ".name for XTS caller");     // Catch: Throwable -> L11
        PermissionGroupInfo info3 = null;
    L52:
        if (info3 == null) goto L54;
        r7.add(info3);     // Catch: Throwable -> L11
    L54:
        index$iv$iv = index$iv$iv + 1;
        r1 = this;
        r4 = r110;
        snapshot = snapshot2;
    L48:
        info3 = info2;
        goto L52
    L46:
        info2 = info;
        goto L48
    L47:
        info2 = info;
        goto L48
    L49:
        snapshot2 = snapshot;
        info3 = null;
        goto L52
    L50:
        snapshot2 = snapshot;
        info3 = null;
        goto L52
    L55:
        AutoCloseableKt.closeFinally(r3, null);
        return r7;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        AutoCloseableKt.closeFinally(r3, th);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [T, android.content.pm.PermissionGroupInfo] */
    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionGroupInfo getPermissionGroupInfo(String permissionGroupName, int flags) {
        Ref$ObjectRef permissionGroup = new Ref$ObjectRef();
        PackageManagerLocal r1 = this.packageManagerLocal;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r1 = null;
    L5:
        PackageManagerLocal.UnfilteredSnapshot snapshot = r1.withUnfilteredSnapshot();
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L14
        if (isUidInstantApp(snapshot, callingUid) == false) goto L11;
        AutoCloseableKt.closeFinally(snapshot, null);
        return null;
    L11:
        AccessCheckingService this_$iv = this.service;     // Catch: Throwable -> L14
        AccessState r9 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L14
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L14
        r9 = null;
    L16:
        GetStateScope $this$getPermissionGroupInfo_u24lambda_u248_u24lambda_u247 = new GetStateScope(r9);     // Catch: Throwable -> L14
        AppIdPermissionPolicy $this$getPermissionGroupInfo_u24lambda_u248_u24lambda_u247_u24lambda_u246 = this.policy;     // Catch: Throwable -> L14
        PermissionGroupInfo r12 = $this$getPermissionGroupInfo_u24lambda_u248_u24lambda_u247_u24lambda_u246.getPermissionGroups($this$getPermissionGroupInfo_u24lambda_u248_u24lambda_u247).get(permissionGroupName);     // Catch: Throwable -> L14
        if (r12 != 0) goto L20;
        AutoCloseableKt.closeFinally(snapshot, null);
        return null;
    L20:
        permissionGroup.element = r12;     // Catch: Throwable -> L14
        if (isPackageVisibleToUid(snapshot, ((PermissionGroupInfo) permissionGroup.element).packageName, callingUid) == true) goto L25;
        AutoCloseableKt.closeFinally(snapshot, null);
        return null;
    L25:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        AutoCloseableKt.closeFinally(snapshot, null);
        return generatePermissionGroupInfo((PermissionGroupInfo) permissionGroup.element, flags);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        AutoCloseableKt.closeFinally(snapshot, th);
        throw th;
    }

    private final PermissionGroupInfo generatePermissionGroupInfo(PermissionGroupInfo $this$generatePermissionGroupInfo, int flags) {
        PermissionGroupInfo $this$generatePermissionGroupInfo_u24lambda_u249 = new PermissionGroupInfo($this$generatePermissionGroupInfo);
        if (IntExtensionsKt.hasBits(flags, 128) == true) goto L6;
        $this$generatePermissionGroupInfo_u24lambda_u249.metaData = null;
    L6:
        return $this$generatePermissionGroupInfo_u24lambda_u249;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v2, types: [T, com.android.server.permission.access.permission.Permission] */
    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionInfo getPermissionInfo(String permissionName, int flags, String opPackageName) {
        Ref$ObjectRef permission = new Ref$ObjectRef();
        int targetSdkVersion = 0;
        PackageManagerLocal r0 = this.packageManagerLocal;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        PackageManagerLocal.UnfilteredSnapshot snapshot = r0.withUnfilteredSnapshot();
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L14
        if (isUidInstantApp(snapshot, callingUid) == false) goto L11;
        AutoCloseableKt.closeFinally(snapshot, null);
        return null;
    L11:
        AccessCheckingService this_$iv = this.service;     // Catch: Throwable -> L14
        AccessState r11 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L14
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L14
        r11 = null;
    L18:
        GetStateScope $this$getPermissionInfo_u24lambda_u2412_u24lambda_u2411 = new GetStateScope(r11);     // Catch: Throwable -> L14
        AppIdPermissionPolicy $this$getPermissionInfo_u24lambda_u2412_u24lambda_u2411_u24lambda_u2410 = this.policy;     // Catch: Throwable -> L14
        Permission r14 = $this$getPermissionInfo_u24lambda_u2412_u24lambda_u2411_u24lambda_u2410.getPermissions($this$getPermissionInfo_u24lambda_u2412_u24lambda_u2411).get(permissionName);     // Catch: Throwable -> L44
        if (r14 != 0) goto L24;
        AutoCloseableKt.closeFinally(snapshot, null);
        return null;
    L24:
        permission.element = r14;     // Catch: Throwable -> L44
        Permission this_$iv2 = (Permission) permission.element;     // Catch: Throwable -> L44
        if (isPackageVisibleToUid(snapshot, this_$iv2.getPermissionInfo().packageName, callingUid) == true) goto L55;
        AutoCloseableKt.closeFinally(snapshot, null);
        return null;
    L55:
        PackageState r9 = getPackageState(snapshot, opPackageName);     // Catch: Throwable -> L32
        if (r9 == null) goto L34;
        AndroidPackage opPackage = r9.getAndroidPackage();     // Catch: Throwable -> L32
    L35:
        int r12 = 10000;
        if (isRootOrSystemOrShellUid(callingUid) == true) goto L41;
        if (opPackage == null) goto L41;
        r12 = opPackage.getTargetSdkVersion();     // Catch: Throwable -> L32
    L41:
        targetSdkVersion = r12;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L32
        AutoCloseableKt.closeFinally(snapshot, null);
        return generatePermissionInfo((Permission) permission.element, flags, targetSdkVersion);
    L34:
        opPackage = null;
    L32:
        th = th;
    L17:
        Throwable r3 = th;
        throw r3;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        AutoCloseableKt.closeFinally(snapshot, r3);
        throw th;
    L44:
        th = th;
    L14:
        th = th;
        goto L17
    }

    static /* synthetic */ PermissionInfo generatePermissionInfo$default(PermissionService r0, Permission r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = 10000;
    L6:
        return r0.generatePermissionInfo(r1, r2, r3);
    }

    private final PermissionInfo generatePermissionInfo(Permission $this$generatePermissionInfo, int flags, int targetSdkVersion) {
        PermissionInfo $this$generatePermissionInfo_u24lambda_u2413 = new PermissionInfo($this$generatePermissionInfo.getPermissionInfo());
        $this$generatePermissionInfo_u24lambda_u2413.flags |= 1073741824;
        if (IntExtensionsKt.hasBits(flags, 128) == true) goto L6;
        $this$generatePermissionInfo_u24lambda_u2413.metaData = null;
    L6:
        if (targetSdkVersion >= 26) goto L11;
        int protection = $this$generatePermissionInfo_u24lambda_u2413.getProtection();
        if (protection == 2) goto L11;
        $this$generatePermissionInfo_u24lambda_u2413.protectionLevel = protection;
    L11:
        return $this$generatePermissionInfo_u24lambda_u2413;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> queryPermissionsByGroup(String permissionGroupName, int flags) {
        PermissionService r1 = this;
        PackageManagerLocal r0 = r1.packageManagerLocal;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        PackageManagerLocal.UnfilteredSnapshot snapshot = r0.withUnfilteredSnapshot();
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L13
        if (r1.isUidInstantApp(snapshot, callingUid) == false) goto L10;
        AutoCloseableKt.closeFinally(snapshot, null);
        return null;
    L10:
        AccessCheckingService this_$iv = r1.service;     // Catch: Throwable -> L13
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L13
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L13
        r5 = null;
    L15:
        GetStateScope $this$queryPermissionsByGroup_u24lambda_u2418_u24lambda_u2416 = new GetStateScope(r5);     // Catch: Throwable -> L13
        if (permissionGroupName == null) goto L26;
        AppIdPermissionPolicy $this$queryPermissionsByGroup_u24lambda_u2418_u24lambda_u2416_u24lambda_u2414 = r1.policy;     // Catch: Throwable -> L13
        PermissionGroupInfo permissionGroup = $this$queryPermissionsByGroup_u24lambda_u2418_u24lambda_u2416_u24lambda_u2414.getPermissionGroups($this$queryPermissionsByGroup_u24lambda_u2418_u24lambda_u2416).get(permissionGroupName);     // Catch: Throwable -> L13
        if (permissionGroup != null) goto L23;
        AutoCloseableKt.closeFinally(snapshot, null);
        return null;
    L23:
        if (r1.isPackageVisibleToUid(snapshot, permissionGroup.packageName, callingUid) == true) goto L26;
        AutoCloseableKt.closeFinally(snapshot, null);
        return null;
    L26:
        AppIdPermissionPolicy $this$queryPermissionsByGroup_u24lambda_u2418_u24lambda_u2416_u24lambda_u2415 = r1.policy;     // Catch: Throwable -> L13
        IndexedMap<String, Permission> r13 = $this$queryPermissionsByGroup_u24lambda_u2418_u24lambda_u2416_u24lambda_u2415.getPermissions($this$queryPermissionsByGroup_u24lambda_u2418_u24lambda_u2416);     // Catch: Throwable -> L13
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L13
        IndexedMap<String, Permission> r3 = r13;
        int index$iv$iv = 0;
        int r4 = r3.getSize();     // Catch: Throwable -> L13
    L27:
        if (index$iv$iv >= r4) goto L40;
        Object key$iv = r3.keyAt(index$iv$iv);     // Catch: Throwable -> L13
        Object value$iv = r3.valueAt(index$iv$iv);     // Catch: Throwable -> L13
        Permission permission = (Permission) value$iv;     // Catch: Throwable -> L13
        String r6 = (String) key$iv;     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(permission.getPermissionInfo().group, permissionGroupName) == false) goto L34;
        IndexedMap<String, Permission> r22 = r3;
        if (r1.isPackageVisibleToUid(snapshot, permission.getPermissionInfo().packageName, callingUid) == false) goto L35;
        r4 = r4;
        index$iv$iv = index$iv$iv;
        PermissionInfo r7 = generatePermissionInfo$default(r1, permission, flags, 0, 2, null);     // Catch: Throwable -> L13
    L37:
        if (r7 == null) goto L39;
        r2.add(r7);     // Catch: Throwable -> L13
    L39:
        index$iv$iv = index$iv$iv + 1;
        r1 = this;
        r4 = r4;
        r3 = r22;
    L35:
        r7 = null;
        goto L37
    L34:
        r22 = r3;
        goto L35
    L40:
        AutoCloseableKt.closeFinally(snapshot, null);
        return r2;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        AutoCloseableKt.closeFinally(snapshot, th);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtection(int protection) {
        AccessCheckingService this_$iv$iv = this.service;
        AccessState r4 = AccessCheckingService.access$getState$p(this_$iv$iv);
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r4 = null;
    L5:
        GetStateScope $this$getPermissionsWithProtectionOrProtectionFlags_u24lambda_u2422$iv = new GetStateScope(r4);
        AppIdPermissionPolicy $this$getPermissionsWithProtectionOrProtectionFlags_u24lambda_u2422_u24lambda_u2421$iv = this.policy;
        IndexedMap<String, Permission> r5 = $this$getPermissionsWithProtectionOrProtectionFlags_u24lambda_u2422_u24lambda_u2421$iv.getPermissions($this$getPermissionsWithProtectionOrProtectionFlags_u24lambda_u2422$iv);
        ArrayList r1 = new ArrayList();
        int r14 = r5.getSize();
        int index$iv$iv$iv = 0;
    L6:
        if (index$iv$iv$iv >= r14) goto L19;
        Object key$iv$iv = r5.keyAt(index$iv$iv$iv);
        Object value$iv$iv = r5.valueAt(index$iv$iv$iv);
        Permission permission$iv = (Permission) value$iv$iv;
        String r2 = (String) key$iv$iv;
        if (permission$iv.getPermissionInfo().getProtection() != protection) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        PermissionInfo r3 = generatePermissionInfo$default(this, permission$iv, 0, 0, 2, null);
    L15:
        if (r3 == null) goto L17;
        r1.add(r3);
    L17:
        index$iv$iv$iv = index$iv$iv$iv + 1;
        goto L6
    L13:
        r3 = null;
        goto L15
    L10:
        r6 = false;
        goto L11
    L19:
        return r1;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtectionFlags(int protectionFlags) {
        AccessCheckingService this_$iv$iv = this.service;
        AccessState r4 = AccessCheckingService.access$getState$p(this_$iv$iv);
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r4 = null;
    L5:
        GetStateScope $this$getPermissionsWithProtectionOrProtectionFlags_u24lambda_u2422$iv = new GetStateScope(r4);
        AppIdPermissionPolicy $this$getPermissionsWithProtectionOrProtectionFlags_u24lambda_u2422_u24lambda_u2421$iv = this.policy;
        IndexedMap<String, Permission> r5 = $this$getPermissionsWithProtectionOrProtectionFlags_u24lambda_u2422_u24lambda_u2421$iv.getPermissions($this$getPermissionsWithProtectionOrProtectionFlags_u24lambda_u2422$iv);
        ArrayList r1 = new ArrayList();
        int r14 = r5.getSize();
        int index$iv$iv$iv = 0;
    L6:
        if (index$iv$iv$iv >= r14) goto L16;
        Object key$iv$iv = r5.keyAt(index$iv$iv$iv);
        Object value$iv$iv = r5.valueAt(index$iv$iv$iv);
        Permission permission$iv = (Permission) value$iv$iv;
        String r2 = (String) key$iv$iv;
        if (IntExtensionsKt.hasBits(permission$iv.getPermissionInfo().getProtectionFlags(), protectionFlags) == false) goto L10;
        PermissionInfo r3 = generatePermissionInfo$default(this, permission$iv, 0, 0, 2, null);
    L12:
        if (r3 == null) goto L14;
        r1.add(r3);
    L14:
        index$iv$iv$iv = index$iv$iv$iv + 1;
        goto L6
    L10:
        r3 = null;
        goto L12
    L16:
        return r1;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getPermissionGids(String permissionName, int userId) {
        AccessCheckingService this_$iv = this.service;
        AccessState r3 = AccessCheckingService.access$getState$p(this_$iv);
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r3 = null;
    L5:
        GetStateScope $this$getPermissionGids_u24lambda_u2425 = new GetStateScope(r3);
        AppIdPermissionPolicy $this$getPermissionGids_u24lambda_u2425_u24lambda_u2424 = this.policy;
        Permission permission = $this$getPermissionGids_u24lambda_u2425_u24lambda_u2424.getPermissions($this$getPermissionGids_u24lambda_u2425).get(permissionName);
        if (permission != null) goto L10;
        return EmptyArray.INT;
    L10:
        return permission.getGidsForUser(userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getInstalledPermissions(String packageName) {
        if (packageName == null) goto L20;
        AccessCheckingService this_$iv = this.service;
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r5 = null;
    L7:
        GetStateScope $this$getInstalledPermissions_u24lambda_u2428 = new GetStateScope(r5);
        AppIdPermissionPolicy $this$getInstalledPermissions_u24lambda_u2428_u24lambda_u2427 = this.policy;
        IndexedMap<String, Permission> r7 = $this$getInstalledPermissions_u24lambda_u2428_u24lambda_u2427.getPermissions($this$getInstalledPermissions_u24lambda_u2428);
        ArraySet r2 = new ArraySet();
        int index$iv$iv = 0;
        int r10 = r7.getSize();
    L8:
        if (index$iv$iv >= r10) goto L18;
        Object key$iv = r7.keyAt(index$iv$iv);
        Object value$iv = r7.valueAt(index$iv$iv);
        Permission permission = (Permission) value$iv;
        String r16 = (String) key$iv;
        if (Intrinsics.areEqual(permission.getPermissionInfo().packageName, packageName) == false) goto L12;
        String r0 = permission.getPermissionInfo().name;
    L14:
        if (r0 == null) goto L16;
        r2.add(r0);
    L16:
        index$iv$iv = index$iv$iv + 1;
        goto L8
    L12:
        r0 = null;
        goto L14
    L18:
        return r2;
    L20:
        throw new IllegalArgumentException("packageName cannot be null".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [T, com.android.server.permission.access.permission.Permission] */
    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addPermission(PermissionInfo permissionInfo, boolean async) {
        String permissionName = permissionInfo.name;
        if (permissionName == null) goto L58;
        int callingUid = Binder.getCallingUid();
        PackageManagerLocal r0 = this.packageManagerLocal;
        AccessState oldState$iv = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L7:
        PackageManagerLocal.UnfilteredSnapshot it = r0.withUnfilteredSnapshot();
        boolean r6 = isUidInstantApp(it, callingUid);     // Catch: Throwable -> L51
        AutoCloseableKt.closeFinally(it, null);
        if (r6 == true) goto L50;
        if (permissionInfo.labelRes == 0) goto L14;
    L18:
        Ref$ObjectRef oldPermission = new Ref$ObjectRef();
        AccessCheckingService this_$iv = this.service;
        Object r16 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r16);
        AccessState r4 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L24
        if (r4 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L24
    L27:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L24
        MutateStateScope $this$addPermission_u24lambda_u2434 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L24
        Permission permissionTree = access$getAndEnforcePermissionTree(this, $this$addPermission_u24lambda_u2434, permissionName);     // Catch: Throwable -> L24
        access$enforcePermissionTreeSize(this, $this$addPermission_u24lambda_u2434, permissionInfo, permissionTree);     // Catch: Throwable -> L24
        AppIdPermissionPolicy $this$addPermission_u24lambda_u2434_u24lambda_u2432 = access$getPolicy$p(this);     // Catch: Throwable -> L24
        oldPermission.element = $this$addPermission_u24lambda_u2434_u24lambda_u2432.getPermissions($this$addPermission_u24lambda_u2434).get(permissionName);     // Catch: Throwable -> L24
        if (oldPermission.element == 0) goto L37;
        if (((Permission) oldPermission.element).getType() != 2) goto L32;
        boolean r7 = true;
    L33:
        if (r7 == true) goto L37;
        throw new SecurityException("Not allowed to modify non-dynamic permission " + permissionName);     // Catch: Throwable -> L24
    L32:
        r7 = false;
    L37:
        permissionInfo.packageName = permissionTree.getPermissionInfo().packageName;     // Catch: Throwable -> L24
        permissionInfo.protectionLevel = PermissionInfo.fixProtectionLevel(permissionInfo.protectionLevel);     // Catch: Throwable -> L24
        Permission newPermission = new Permission(permissionInfo, true, 2, permissionTree.getAppId(), null, false, 48, null);     // Catch: Throwable -> L24
        AppIdPermissionPolicy $this$addPermission_u24lambda_u2434_u24lambda_u2433 = access$getPolicy$p(this);     // Catch: Throwable -> L24
        if (async == true) goto L40;
        boolean r5 = true;
    L41:
        $this$addPermission_u24lambda_u2434_u24lambda_u2433.addPermission($this$addPermission_u24lambda_u2434, newPermission, r5);     // Catch: Throwable -> L24
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L24
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L24
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L24
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L24
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r16);
        if (oldPermission.element == 0) goto L46;
        return false;
    L46:
        return true;
    L40:
        r5 = false;
        goto L41
    L26:
        oldState$iv = r4;
    L24:
        th = move-exception;
        throw th;
    L14:
        if (permissionInfo.nonLocalizedLabel != null) goto L18;
        throw new SecurityException("Label must be specified in permission");
    L50:
        throw new SecurityException("Instant apps cannot add permissions");
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    L58:
        throw new IllegalArgumentException("permissionName cannot be null".toString());
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removePermission(String permissionName) {
        int callingUid = Binder.getCallingUid();
        PackageManagerLocal r1 = this.packageManagerLocal;
        AccessState oldState$iv = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r1 = null;
    L5:
        PackageManagerLocal.UnfilteredSnapshot it = r1.withUnfilteredSnapshot();
        boolean r5 = isUidInstantApp(it, callingUid);     // Catch: Throwable -> L36
        AutoCloseableKt.closeFinally(it, null);
        if (r5 == true) goto L35;
        AccessCheckingService this_$iv = this.service;
        Object r4 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r4);
        AccessState r6 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L15
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L15
    L18:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L15
        MutateStateScope $this$removePermission_u24lambda_u2438 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L15
        access$getAndEnforcePermissionTree(this, $this$removePermission_u24lambda_u2438, permissionName);     // Catch: Throwable -> L15
        AppIdPermissionPolicy $this$removePermission_u24lambda_u2438_u24lambda_u2436 = access$getPolicy$p(this);     // Catch: Throwable -> L15
        Permission permission = $this$removePermission_u24lambda_u2438_u24lambda_u2436.getPermissions($this$removePermission_u24lambda_u2438).get(permissionName);     // Catch: Throwable -> L15
        if (permission != null) goto L22;
    L27:
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L15
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L15
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L15
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L15
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r4);
        return;
    L22:
        if (permission.getType() != 2) goto L24;
        boolean r12 = true;
    L25:
        if (r12 == false) goto L31;
        AppIdPermissionPolicy $this$removePermission_u24lambda_u2438_u24lambda_u2437 = access$getPolicy$p(this);     // Catch: Throwable -> L15
        $this$removePermission_u24lambda_u2438_u24lambda_u2437.removePermission($this$removePermission_u24lambda_u2438, permission);     // Catch: Throwable -> L15
        goto L27
    L31:
        throw new SecurityException("Not allowed to modify non-dynamic permission " + permissionName);     // Catch: Throwable -> L15
    L24:
        r12 = false;
        goto L25
    L17:
        oldState$iv = r6;
    L15:
        th = move-exception;
        throw th;
    L35:
        throw new SecurityException("Instant applications don't have access to this method");
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    private final Permission getAndEnforcePermissionTree(GetStateScope $this$getAndEnforcePermissionTree, String permissionName) {
        int callingUid = Binder.getCallingUid();
        AppIdPermissionPolicy $this$getAndEnforcePermissionTree_u24lambda_u2439 = this.policy;
        Permission permissionTree = $this$getAndEnforcePermissionTree_u24lambda_u2439.findPermissionTree($this$getAndEnforcePermissionTree, permissionName);
        if (permissionTree == null) goto L8;
        if (permissionTree.getAppId() != UserHandle.getAppId(callingUid)) goto L8;
        return permissionTree;
    L8:
        throw new SecurityException("Calling UID " + callingUid + " is not allowed to add to or remove from the permission tree");
    }

    private final void enforcePermissionTreeSize(GetStateScope $this$enforcePermissionTreeSize, PermissionInfo permissionInfo, Permission permissionTree) {
        if (permissionTree.getAppId() == 1000) goto L9;
        int permissionTreeFootprint = calculatePermissionTreeFootprint($this$enforcePermissionTreeSize, permissionTree);
        if ((permissionInfo.calculateFootprint() + permissionTreeFootprint) > 32768) goto L8;
        return;
    L8:
        throw new SecurityException("Permission tree size cap exceeded");
    }

    private final int calculatePermissionTreeFootprint(GetStateScope $this$calculatePermissionTreeFootprint, Permission permissionTree) {
        int size = 0;
        AppIdPermissionPolicy $this$calculatePermissionTreeFootprint_u24lambda_u2441 = this.policy;
        IndexedMap<String, Permission> r5 = $this$calculatePermissionTreeFootprint_u24lambda_u2441.getPermissions($this$calculatePermissionTreeFootprint);
        int index$iv = 0;
        int r8 = r5.getSize();
    L3:
        if (index$iv >= r8) goto L9;
        String r9 = r5.keyAt(index$iv);
        Permission permission = r5.valueAt(index$iv);
        if (permissionTree.getAppId() != permission.getAppId()) goto L7;
        size = size + (permission.getPermissionInfo().name.length() + permission.getPermissionInfo().calculateFootprint());
    L7:
        index$iv = index$iv + 1;
        goto L3
    L9:
        return size;
    }

    /* JADX WARN: Failed to calculate best type for var: r13v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v9 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v1 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionRequestState(java.lang.String r26, java.lang.String r27, int r28, java.lang.String r29) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ed: MOVE (r19v6 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (1 ??[boolean, int, float, short, byte, char]) A[DECLARE_VAR] (LINE:57) in method: com.android.server.permission.access.permission.PermissionService.getPermissionRequestState(java.lang.String, java.lang.String, int, java.lang.String):int, file: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.permission.access.permission.PermissionService.getPermissionRequestState(java.lang.String, java.lang.String, int, java.lang.String):int");
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkUidPermission(int uid, String permissionName, String deviceId) {
        int userId = UserHandle.getUserId(uid);
        UserManagerInternal r0 = this.userManagerInternal;
        AccessState r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r0 = null;
    L6:
        if (r0.exists(userId) == true) goto L8;
        return -1;
    L8:
        PackageManagerInternal r2 = this.packageManagerInternal;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r2 = null;
    L11:
        AndroidPackage androidPackage = r2.getPackage(uid);
        if (androidPackage == null) goto L30;
        PackageManagerInternal r3 = this.packageManagerInternal;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r3 = null;
    L16:
        PackageStateInternal packageState = r3.getPackageStateInternal(androidPackage.getPackageName());
        if (packageState != null) goto L20;
        Slog.e(LOG_TAG, "checkUidPermission: PackageState not found for AndroidPackage " + androidPackage);
        return -1;
    L20:
        AccessCheckingService this_$iv = this.service;
        AccessState r4 = AccessCheckingService.access$getState$p(this_$iv);
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L24:
        GetStateScope $this$checkUidPermission_u24lambda_u2447 = new GetStateScope(r1);
        boolean isPermissionGranted = isPermissionGranted($this$checkUidPermission_u24lambda_u2447, packageState, userId, permissionName, deviceId);
        if (isPermissionGranted == true) goto L28;
        return -1;
    L28:
        return 0;
    L23:
        r1 = r4;
        goto L24
    L30:
        if (isSystemUidPermissionGranted(uid, permissionName) == true) goto L33;
        return -1;
    L33:
        return 0;
    }

    private final boolean isSystemUidPermissionGranted(int uid, String permissionName) {
        SystemConfig r0 = this.systemConfig;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("systemConfig");
        r0 = null;
    L5:
        ArraySet<String> r1 = r0.getSystemPermissions().get(uid);
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.contains(permissionName) == false) goto L11;
        return true;
    L11:
        String fullerPermissionName = FULLER_PERMISSIONS.get(permissionName);
        if (fullerPermissionName != null) goto L14;
    L16:
        return false;
    L14:
        if (r1.contains(fullerPermissionName) == false) goto L16;
        return true;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkPermission(String packageName, String permissionName, String deviceId, int userId) {
        UserManagerInternal r0 = this.userManagerInternal;
        AccessState r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r0 = null;
    L6:
        if (r0.exists(userId) == true) goto L8;
        return -1;
    L8:
        PackageManagerLocal r1 = this.packageManagerLocal;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r1 = null;
    L11:
        PackageManagerLocal.FilteredSnapshot it = withFilteredSnapshot(r1, Binder.getCallingUid(), userId);
        PackageState packageState = it.getPackageState(packageName);     // Catch: Throwable -> L25
        AutoCloseableKt.closeFinally(it, null);
        if (packageState != null) goto L16;
        return -1;
    L16:
        AccessCheckingService this_$iv = this.service;
        AccessState r6 = AccessCheckingService.access$getState$p(this_$iv);
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L20:
        GetStateScope $this$checkPermission_u24lambda_u2449 = new GetStateScope(r2);
        boolean isPermissionGranted = isPermissionGranted($this$checkPermission_u24lambda_u2449, packageState, userId, permissionName, deviceId);
        if (isPermissionGranted == false) goto L35;
        return 0;
    L35:
        return -1;
    L19:
        r2 = r6;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    private final boolean isPermissionGranted(GetStateScope $this$isPermissionGranted, PackageState packageState, int userId, String permissionName, String deviceId) {
        int appId = packageState.getAppId();
        boolean isInstantApp = packageState.getUserStateOrDefault(userId).isInstantApp();
        if (isSinglePermissionGranted($this$isPermissionGranted, appId, userId, isInstantApp, permissionName, deviceId) == false) goto L5;
        return true;
    L5:
        String fullerPermissionName = FULLER_PERMISSIONS.get(permissionName);
        if (fullerPermissionName != null) goto L8;
        return false;
    L8:
        if (isSinglePermissionGranted($this$isPermissionGranted, appId, userId, isInstantApp, fullerPermissionName, deviceId) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private final boolean isSinglePermissionGranted(GetStateScope $this$isSinglePermissionGranted, int appId, int userId, boolean isInstantApp, String permissionName, String deviceId) {
        int flags = getPermissionFlagsWithPolicy($this$isSinglePermissionGranted, appId, userId, permissionName, deviceId);
        if (PermissionFlags.INSTANCE.isPermissionGranted(flags) == true) goto L5;
        return false;
    L5:
        if (isInstantApp == false) goto L12;
        AppIdPermissionPolicy $this$isSinglePermissionGranted_u24lambda_u2450 = this.policy;
        Permission permission = $this$isSinglePermissionGranted_u24lambda_u2450.getPermissions($this$isSinglePermissionGranted).get(permissionName);
        if (permission != null) goto L10;
        return false;
    L10:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 4096) == true) goto L14;
        return false;
    L14:
        return true;
    L12:
        return true;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getGrantedPermissions(String packageName, int userId) {
        PermissionService r1 = this;
        int r4 = userId;
        if (packageName == null) goto L39;
        Preconditions.checkArgumentNonnegative(r4, "userId");
        PackageManagerLocal r0 = r1.packageManagerLocal;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L7:
        PackageManagerLocal.UnfilteredSnapshot it = r0.withUnfilteredSnapshot();
        PackageState packageState = r1.getPackageState(it, packageName);     // Catch: Throwable -> L32
        AutoCloseableKt.closeFinally(it, null);
        if (packageState != null) goto L13;
        Slog.w(LOG_TAG, "getGrantedPermissions: Unknown package " + packageName);
        return SetsKt.emptySet();
    L13:
        AccessCheckingService this_$iv = r1.service;
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r5 = null;
    L16:
        GetStateScope $this$getGrantedPermissions_u24lambda_u2455 = new GetStateScope(r5);
        AppIdPermissionPolicy $this$getGrantedPermissions_u24lambda_u2455_u24lambda_u2453 = r1.policy;
        IndexedMap<String, Integer> r6 = $this$getGrantedPermissions_u24lambda_u2455_u24lambda_u2453.getUidPermissionFlags($this$getGrantedPermissions_u24lambda_u2455, packageState.getAppId(), r4);
        if (r6 == null) goto L19;
        ArraySet r7 = new ArraySet();
        int index$iv$iv = 0;
        int r8 = r6.getSize();
    L21:
        if (index$iv$iv >= r8) goto L31;
        Object key$iv = r6.keyAt(index$iv$iv);
        Object value$iv = r6.valueAt(index$iv$iv);
        ((Number) value$iv).intValue();
        int index$iv$iv2 = index$iv$iv;
        String permissionName = (String) key$iv;
        int r23 = r8;
        if (r1.isPermissionGranted($this$getGrantedPermissions_u24lambda_u2455, packageState, r4, permissionName, "default:0") == false) goto L25;
        String r2 = permissionName;
    L27:
        if (r2 == null) goto L29;
        r7.add(r2);
    L29:
        index$iv$iv = index$iv$iv2 + 1;
        r1 = this;
        r4 = userId;
        r8 = r23;
        goto L21
    L25:
        r2 = null;
        goto L27
    L31:
        return r7;
    L19:
        return SetsKt.emptySet();
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    L39:
        throw new IllegalArgumentException("packageName cannot be null".toString());
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getGidsForUid(int uid) {
        PermissionService r0 = this;
        int appId = UserHandle.getAppId(uid);
        int userId = UserHandle.getUserId(uid);
        SystemConfig r3 = r0.systemConfig;
        AccessState r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("systemConfig");
        r3 = null;
    L5:
        int[] globalGids = r3.getGlobalGids();
        AccessCheckingService this_$iv = r0.service;
        AccessState r8 = AccessCheckingService.access$getState$p(this_$iv);
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L9:
        GetStateScope $this$getGidsForUid_u24lambda_u2459 = new GetStateScope(r4);
        AppIdPermissionPolicy $this$getGidsForUid_u24lambda_u2459_u24lambda_u2456 = r0.policy;
        IndexedMap<String, Integer> r9 = $this$getGidsForUid_u24lambda_u2459_u24lambda_u2456.getUidPermissionFlags($this$getGidsForUid_u24lambda_u2459, appId, userId);
        if (r9 != null) goto L13;
        int[] r10 = Arrays.copyOf(globalGids, globalGids.length);
        Intrinsics.checkNotNullExpressionValue(r10, "copyOf(...)");
        return r10;
    L13:
        IntArray gids = IntArray.wrap(globalGids);
        int index$iv = 0;
        int r13 = r9.getSize();
    L14:
        if (index$iv >= r13) goto L30;
        String r14 = r9.keyAt(index$iv);
        int flags = r9.valueAt(index$iv).intValue();
        String permissionName = r14;
        int appId2 = appId;
        if (PermissionFlags.INSTANCE.isPermissionGranted(flags) == false) goto L28;
        AppIdPermissionPolicy $this$getGidsForUid_u24lambda_u2459_u24lambda_u2458_u24lambda_u2457 = r0.policy;
        Permission permission = $this$getGidsForUid_u24lambda_u2459_u24lambda_u2458_u24lambda_u2457.getPermissions($this$getGidsForUid_u24lambda_u2459).get(permissionName);
        if (permission == null) goto L28;
        int[] permissionGids = permission.getGidsForUser(userId);
        if (permissionGids.length != 0) goto L24;
        boolean r1 = true;
    L25:
        if (r1 == true) goto L28;
        gids.addAll(permissionGids);
        goto L28
    L24:
        r1 = false;
    L28:
        index$iv = index$iv + 1;
        r0 = this;
        appId = appId2;
        goto L14
    L30:
        return gids.toArray();
    L8:
        r4 = r8;
        goto L9
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void grantRuntimePermission(String packageName, String permissionName, String deviceId, int userId) {
        setRuntimePermissionGranted$default(this, packageName, userId, permissionName, deviceId, true, false, null, 96, null);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokeRuntimePermission(String packageName, String permissionName, String deviceId, int userId, String reason) {
        setRuntimePermissionGranted$default(this, packageName, userId, permissionName, deviceId, false, false, reason, 32, null);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokePostNotificationPermissionWithoutKillForTest(String packageName, int userId) {
        setRuntimePermissionGranted$default(this, packageName, userId, "android.permission.POST_NOTIFICATIONS", "default:0", false, true, null, 64, null);
    }

    static /* synthetic */ void setRuntimePermissionGranted$default(PermissionService r8, String r9, int r10, String r11, String r12, boolean r13, boolean r14, String r15, int r16, Object r17) {
        if ((r16 & 32) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r16 & 64) == 0) goto L9;
        String r7 = null;
    L10:
        r8.setRuntimePermissionGranted(r9, r10, r11, r12, r13, r6, r7);
        return;
    L9:
        r7 = r15;
        goto L10
    L5:
        r6 = r14;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.android.server.pm.pkg.PackageState] */
    private final void setRuntimePermissionGranted(String packageName, int userId, String permissionName, String deviceId, boolean isGranted, boolean skipKillUid, String revokeReason) {
        if (isGranted == false) goto L6;
        String r0 = "grantRuntimePermission";
    L5:
        String methodName = r0;
        int callingUid = Binder.getCallingUid();
        if (isGranted == true) goto L11;
    L11:
        UserManagerInternal r2 = this.userManagerInternal;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r2 = null;
    L15:
        if (r2.exists(userId) == true) goto L18;
        Slog.w(LOG_TAG, methodName + ": Unknown user " + userId);
        return;
    L18:
        enforceCallingOrSelfCrossUserPermission(userId, true, true, methodName);
        if (isGranted == false) goto L21;
        String enforcedPermissionName = "android.permission.GRANT_RUNTIME_PERMISSIONS";
    L22:
        this.context.enforceCallingOrSelfPermission(enforcedPermissionName, methodName);
        Ref$ObjectRef packageState = new Ref$ObjectRef();
        PackageManagerInternal r7 = this.packageManagerInternal;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r7 = null;
    L25:
        String permissionControllerPackageName = (String) ArraysKt.first(r7.getKnownPackageNames(7, 0));
        PackageManagerLocal r9 = this.packageManagerLocal;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r9 = null;
    L28:
        PackageManagerLocal.UnfilteredSnapshot snapshot = r9.withUnfilteredSnapshot();
        PackageManagerLocal.FilteredSnapshot it = filtered(snapshot, callingUid, userId);     // Catch: Throwable -> L93
        ?? r3 = it.getPackageState(packageName);     // Catch: Throwable -> L95
        AutoCloseableKt.closeFinally(it, null);     // Catch: Throwable -> L93
        packageState.element = r3;     // Catch: Throwable -> L93
        PackageState r1 = getPackageState(snapshot, permissionControllerPackageName);     // Catch: Throwable -> L93
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L91
        AutoCloseableKt.closeFinally(snapshot, null);
        PackageState r5 = (PackageState) packageState.element;
        if (r5 == null) goto L39;
        AndroidPackage r6 = r5.getAndroidPackage();
    L40:
        AndroidPackage androidPackage = r6;
        if (androidPackage != null) goto L45;
        Slog.w(LOG_TAG, methodName + ": Unknown package " + packageName);
        return;
    L45:
        if (isRootOrSystemUid(callingUid) == true) goto L50;
        int r8 = UserHandle.getAppId(callingUid);
        Intrinsics.checkNotNull(r1);
        if (r8 == r1.getAppId()) goto L50;
        boolean canManageRolePermission = false;
    L52:
        if (this.context.checkCallingOrSelfPermission("android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY") != 0) goto L54;
        boolean overridePolicyFixed = true;
    L55:
        AccessCheckingService this_$iv = this.service;
        Object r18 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r18);
        AccessState oldState$iv = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L87
        if (oldState$iv == null) goto L124;
    L65:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L87
        MutateStateScope $this$setRuntimePermissionGranted_u24lambda_u2463 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L87
        OnPermissionFlagsChangedListener r23 = access$getOnPermissionFlagsChangedListener$p(this);     // Catch: Throwable -> L87
        if (r23 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("onPermissionFlagsChangedListener");     // Catch: Throwable -> L62
        OnPermissionFlagsChangedListener r21 = null;
    L69:
        OnPermissionFlagsChangedListener $this$setRuntimePermissionGranted_u24lambda_u2463_u24lambda_u2462 = r21;
        if (skipKillUid == false) goto L72;
        OnPermissionFlagsChangedListener $this$setRuntimePermissionGranted_u24lambda_u2463_u24lambda_u2463 = $this$setRuntimePermissionGranted_u24lambda_u2463_u24lambda_u2462;
        $this$setRuntimePermissionGranted_u24lambda_u2463_u24lambda_u2463.skipKillRuntimePermissionRevokedUids($this$setRuntimePermissionGranted_u24lambda_u2463);     // Catch: Throwable -> L62
    L73:
        if (revokeReason == null) goto L76;
        $this$setRuntimePermissionGranted_u24lambda_u2463_u24lambda_u2463.addKillRuntimePermissionRevokedUidsReason($this$setRuntimePermissionGranted_u24lambda_u2463, revokeReason);     // Catch: Throwable -> L62
    L62:
        th = th;
    L89:
        monitor-exit(r18);
        throw th;
    L76:
        access$setRuntimePermissionGranted(this, $this$setRuntimePermissionGranted_u24lambda_u2463, (PackageState) packageState.element, userId, permissionName, deviceId, isGranted, canManageRolePermission, overridePolicyFixed, true, methodName);     // Catch: Throwable -> L85
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L85
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L83
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L83
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L83
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L83
        monitor-exit(r18);
        return;
    L83:
        th = th;
    L85:
        th = th;
        goto L89
    L72:
        $this$setRuntimePermissionGranted_u24lambda_u2463_u24lambda_u2463 = $this$setRuntimePermissionGranted_u24lambda_u2463_u24lambda_u2462;
        goto L73
    L68:
        r21 = r23;
        goto L69
    L124:
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L62
        oldState$iv = null;
    L87:
        th = th;
        goto L89
    L54:
        overridePolicyFixed = false;
    L50:
        canManageRolePermission = true;
        goto L52
    L39:
        r6 = null;
    L91:
        th = move-exception;
        Throwable r11 = th;
    L120:
        throw r11;     // Catch: Throwable -> L105
    L105:
        th = move-exception;
        AutoCloseableKt.closeFinally(snapshot, r11);
        throw th;
    L95:
        th = move-exception;
        throw th;     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);     // Catch: Throwable -> L101
        throw th;     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        r11 = th;
    L93:
        th = move-exception;
        r11 = th;
        goto L120
    L21:
        enforcedPermissionName = "android.permission.REVOKE_RUNTIME_PERMISSIONS";
        goto L22
    L6:
        r0 = "revokeRuntimePermission";
        goto L5
    }

    private final void setRequestedPermissionStates(PackageState packageState, int userId, ArrayMap<String, Integer> r31) {
        PermissionService r1 = this;
        AccessCheckingService this_$iv = r1.service;
        Object r16 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r16);
        AccessState r2 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L8
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L8
        r2 = null;
    L10:
        AccessState oldState$iv = r2;
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L8
        MutateStateScope $this$setRequestedPermissionStates_u24lambda_u2466 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L8
        ArrayMap<String, Integer> r7 = r31;
        int r8 = r7.size();     // Catch: Throwable -> L8
        int index$iv = 0;
    L11:
        if (index$iv >= r8) goto L46;
        String r3 = r7.keyAt(index$iv);     // Catch: Throwable -> L8
        int permissionState = r7.valueAt(index$iv).intValue();     // Catch: Throwable -> L8
        String permissionName = r3;     // Catch: Throwable -> L8
        switch(permissionState) {
            case 1: goto L15;
            case 2: goto L15;
            default: goto L14;
        };     // Catch: Throwable -> L8
    L14:
        Slog.w(access$getLOG_TAG$cp(), "setRequestedPermissionStates: Unknown permission state " + permissionState + " for permission " + permissionName);     // Catch: Throwable -> L8
        ArrayMap<String, Integer> r27 = r7;
        int r22 = r8;
        int index$iv2 = index$iv;
        AccessState oldState$iv2 = oldState$iv;
        MutableAccessState newState$iv2 = newState$iv;
    L45:
        index$iv = index$iv2 + 1;     // Catch: Throwable -> L8
        r1 = this;
        newState$iv = newState$iv2;
        r8 = r22;
        oldState$iv = oldState$iv2;
        r7 = r27;
        goto L11
    L15:
        AndroidPackage r4 = packageState.getAndroidPackage();     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L8
        if (r4.getRequestedPermissions().contains(permissionName) == true) goto L18;
        r27 = r7;
        r22 = r8;
        index$iv2 = index$iv;
        oldState$iv2 = oldState$iv;
        newState$iv2 = newState$iv;
        goto L45
    L18:
        AppIdPermissionPolicy $this$setRequestedPermissionStates_u24lambda_u2466_u24lambda_u2465_u24lambda_u2464 = access$getPolicy$p(r1);     // Catch: Throwable -> L8
        Permission permission = $this$setRequestedPermissionStates_u24lambda_u2466_u24lambda_u2465_u24lambda_u2464.getPermissions($this$setRequestedPermissionStates_u24lambda_u2466).get(permissionName);     // Catch: Throwable -> L8
        if (permission != null) goto L22;
        r27 = r7;
        r22 = r8;
        index$iv2 = index$iv;
        oldState$iv2 = oldState$iv;
        newState$iv2 = newState$iv;
        goto L45
    L22:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 32) == true) goto L41;
        if (permission.getPermissionInfo().getProtection() != 1) goto L26;
        boolean r0 = true;
    L27:
        if (r0 == true) goto L41;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 64) == true) goto L32;
        r27 = r7;
        r22 = r8;
        index$iv2 = index$iv;
        oldState$iv2 = oldState$iv;
        newState$iv2 = newState$iv;
        goto L45
    L32:
        if (PackageInstallerService.INSTALLER_CHANGEABLE_APP_OP_PERMISSIONS.contains(permissionName) == true) goto L34;
        r27 = r7;
        r22 = r8;
        index$iv2 = index$iv;
        oldState$iv2 = oldState$iv;
        newState$iv2 = newState$iv;
        goto L45
    L34:
        if (permissionState != 1) goto L36;
        boolean r6 = true;
    L37:
        access$setAppOpPermissionGranted(r1, $this$setRequestedPermissionStates_u24lambda_u2466, packageState, userId, permissionName, r6);     // Catch: Throwable -> L8
        r27 = r7;
        r22 = r8;
        index$iv2 = index$iv;
        oldState$iv2 = oldState$iv;
        newState$iv2 = newState$iv;
        goto L45
    L36:
        r6 = false;
        goto L37
    L26:
        r0 = false;
    L41:
        if (permissionState != 1) goto L43;
        r22 = r8;
        index$iv2 = index$iv;
        access$setRuntimePermissionGranted(this, $this$setRequestedPermissionStates_u24lambda_u2466, packageState, userId, permissionName, "default:0", true, false, false, false, "setRequestedPermissionStates");     // Catch: Throwable -> L8
        r27 = r7;
        oldState$iv2 = oldState$iv;
        newState$iv2 = newState$iv;
        access$updatePermissionFlags(this, $this$setRequestedPermissionStates_u24lambda_u2466, packageState.getAppId(), userId, permissionName, "default:0", 72, 0, false, false, true, "setRequestedPermissionStates", packageState.getPackageName());     // Catch: Throwable -> L8
        goto L45
    L43:
        r27 = r7;
        r22 = r8;
        index$iv2 = index$iv;
        oldState$iv2 = oldState$iv;
        newState$iv2 = newState$iv;
        goto L45
    L46:
        MutableAccessState newState$iv3 = newState$iv;
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv3);     // Catch: Throwable -> L8
        AccessCheckingService.access$setState$p(this_$iv, newState$iv3);     // Catch: Throwable -> L8
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L8
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv3));     // Catch: Throwable -> L8
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r16);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void setRuntimePermissionGranted(MutateStateScope $this$setRuntimePermissionGranted, PackageState packageState, int userId, String permissionName, String deviceId, boolean isGranted, boolean canManageRolePermission, boolean overridePolicyFixed, boolean reportError, String methodName) {
        AppIdPermissionPolicy $this$setRuntimePermissionGranted_u24lambda_u2467 = this.policy;
        Permission permission = $this$setRuntimePermissionGranted_u24lambda_u2467.getPermissions($this$setRuntimePermissionGranted).get(permissionName);
        if (permission != null) goto L8;
        if (reportError == true) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Unknown permission " + permissionName);
    L8:
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(androidPackage);
        String packageName = packageState.getPackageName();
        boolean r12 = false;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 32) == false) goto L11;
    L39:
        int appId = packageState.getAppId();
        int oldFlags = getPermissionFlagsWithPolicy($this$setRuntimePermissionGranted, appId, userId, permissionName, deviceId);
        if (androidPackage.getRequestedPermissions().contains(permissionName) == true) goto L46;
        if (oldFlags != 0) goto L46;
        if (reportError == false) goto L83;
        Slog.e(LOG_TAG, "Permission " + permissionName + " isn't requested by package " + packageName);
        return;
    L83:
        return;
    L46:
        if (IntExtensionsKt.hasBits(oldFlags, 256) == false) goto L51;
        if (reportError == false) goto L84;
        Slog.e(LOG_TAG, methodName + ": Cannot change system fixed permission " + permissionName + " for package " + packageName);
        return;
    L84:
        return;
    L51:
        if (IntExtensionsKt.hasBits(oldFlags, 128) == false) goto L56;
        if (overridePolicyFixed == true) goto L56;
        if (reportError == false) goto L85;
        Slog.e(LOG_TAG, methodName + ": Cannot change policy fixed permission " + permissionName + " for package " + packageName);
        return;
    L85:
        return;
    L56:
        if (isGranted == true) goto L58;
    L62:
        if (isGranted == true) goto L64;
    L68:
        int newFlags = PermissionFlags.INSTANCE.updateRuntimePermissionGranted(oldFlags, isGranted);
        if (oldFlags != newFlags) goto L71;
        return;
    L71:
        setPermissionFlagsWithPolicy($this$setRuntimePermissionGranted, appId, userId, permissionName, deviceId, newFlags);
        if (permission.getPermissionInfo().getProtection() != 1) goto L74;
        r12 = true;
    L74:
        if (r12 == false) goto L88;
        if (isGranted == false) goto L77;
        int action = 1243;
    L78:
        LogMaker log = new LogMaker(action);
        log.setPackageName(packageName);
        log.addTaggedData(1241, permissionName);
        MetricsLogger r5 = this.metricsLogger;
        if (r5 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("metricsLogger");
        r5 = null;
    L81:
        r5.write(log);
        return;
    L77:
        action = 1245;
        goto L78
    L88:
        return;
    L64:
        if (IntExtensionsKt.hasBits(oldFlags, 524288) == false) goto L68;
        if (reportError == false) goto L87;
        Slog.e(LOG_TAG, methodName + ": Cannot grant soft-restricted non-exempt permission " + permissionName + " to package " + packageName);
        return;
    L87:
        return;
    L58:
        if (IntExtensionsKt.hasBits(oldFlags, 262144) == false) goto L62;
        if (reportError == false) goto L86;
        Slog.e(LOG_TAG, methodName + ": Cannot grant hard-restricted non-exempt permission " + permissionName + " to package " + packageName);
        return;
    L86:
        return;
    L11:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 67108864) == false) goto L18;
        if (canManageRolePermission == true) goto L39;
        if (reportError == true) goto L16;
        return;
    L16:
        throw new SecurityException("Permission " + permissionName + " is managed by role");
    L18:
        if (permission.getPermissionInfo().getProtection() != 1) goto L20;
        boolean r1 = true;
    L21:
        if (r1 == true) goto L23;
        if (reportError == true) goto L38;
        return;
    L38:
        throw new SecurityException("Permission " + permissionName + " requested by package " + packageName + " is not a changeable permission type");
    L23:
        if (androidPackage.getTargetSdkVersion() >= 23) goto L26;
        return;
    L26:
        if (isGranted == false) goto L39;
        if (packageState.getUserStateOrDefault(userId).isInstantApp() == false) goto L39;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 4096) == true) goto L39;
        if (reportError == true) goto L34;
        return;
    L34:
        throw new SecurityException("Cannot grant non-instant permission " + permissionName + " to package " + packageName);
    L20:
        r1 = false;
        goto L21
    }

    private final void setAppOpPermissionGranted(MutateStateScope $this$setAppOpPermissionGranted, PackageState packageState, int userId, String permissionName, boolean isGranted) {
        SchemePolicy r0 = this.service.getSchemePolicy$frameworks__base__services__permission__android_common__services_permission_pre_jarjar("uid", "app-op");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.android.server.permission.access.appop.AppIdAppOpPolicy");
        AppIdAppOpPolicy appOpPolicy = (AppIdAppOpPolicy) r0;
        String appOpName = AppOpsManager.permissionToOp(permissionName);
        Intrinsics.checkNotNull(appOpName);
        if (isGranted == false) goto L6;
        int r1 = 0;
    L5:
        int mode = r1;
        appOpPolicy.setAppOpMode($this$setAppOpPermissionGranted, packageState.getAppId(), userId, appOpName, mode);
        return;
    L6:
        r1 = 2;
        goto L5
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionFlags(String packageName, String permissionName, String deviceId, int userId) {
        UserManagerInternal r0 = this.userManagerInternal;
        AccessState r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r0 = null;
    L6:
        if (r0.exists(userId) == true) goto L9;
        Slog.w(LOG_TAG, "getPermissionFlags: Unknown user " + userId);
        return 0;
    L9:
        enforceCallingOrSelfCrossUserPermission(userId, true, false, "getPermissionFlags");
        PackageManagerLocal r2 = this.packageManagerLocal;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r2 = null;
    L12:
        PackageManagerLocal.FilteredSnapshot it = r2.withFilteredSnapshot();
        PackageState packageState = it.getPackageState(packageName);     // Catch: Throwable -> L28
        AutoCloseableKt.closeFinally(it, null);
        if (packageState != null) goto L18;
        Slog.w(LOG_TAG, "getPermissionFlags: Unknown package " + packageName);
        return 0;
    L18:
        AccessCheckingService this_$iv = this.service;
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L22:
        GetStateScope $this$getPermissionFlags_u24lambda_u2472 = new GetStateScope(r1);
        AppIdPermissionPolicy $this$getPermissionFlags_u24lambda_u2472_u24lambda_u2471 = this.policy;
        Permission permission = $this$getPermissionFlags_u24lambda_u2472_u24lambda_u2471.getPermissions($this$getPermissionFlags_u24lambda_u2472).get(permissionName);
        if (permission != null) goto L26;
        Slog.w(LOG_TAG, "getPermissionFlags: Unknown permission " + permissionName);
        return 0;
    L26:
        int flags = getPermissionFlagsWithPolicy($this$getPermissionFlags_u24lambda_u2472, packageState.getAppId(), userId, permissionName, deviceId);
        return PermissionFlags.INSTANCE.toApiFlags(flags);
    L21:
        r1 = r5;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, PermissionManager.PermissionState> getAllPermissionStates(String packageName, String deviceId, int userId) {
        PermissionService r1 = this;
        String r6 = deviceId;
        int r4 = userId;
        UserManagerInternal r0 = r1.userManagerInternal;
        AccessState r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r0 = null;
    L6:
        if (r0.exists(r4) == true) goto L9;
        Slog.w(LOG_TAG, "getAllPermissionStates: Unknown user " + r4);
        return MapsKt.emptyMap();
    L9:
        r1.enforceCallingOrSelfCrossUserPermission(r4, true, false, "getAllPermissionStates");
        r1.enforceCallingOrSelfAnyPermission("getAllPermissionStates", new String[]{"android.permission.GRANT_RUNTIME_PERMISSIONS", "android.permission.REVOKE_RUNTIME_PERMISSIONS", "android.permission.GET_RUNTIME_PERMISSIONS"});
        PackageManagerLocal r3 = r1.packageManagerLocal;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r3 = null;
    L12:
        PackageManagerLocal.FilteredSnapshot it = r3.withFilteredSnapshot();
        PackageState packageState = it.getPackageState(packageName);     // Catch: Throwable -> L35
        AutoCloseableKt.closeFinally(it, null);
        if (packageState != null) goto L18;
        Slog.w(LOG_TAG, "getAllPermissionStates: Unknown package " + packageName);
        return MapsKt.emptyMap();
    L18:
        AccessCheckingService this_$iv = r1.service;
        AccessState r9 = AccessCheckingService.access$getState$p(this_$iv);
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L22:
        GetStateScope $this$getAllPermissionStates_u24lambda_u2477 = new GetStateScope(r2);
        if (Intrinsics.areEqual(r6, "default:0") == false) goto L25;
        AppIdPermissionPolicy $this$getAllPermissionStates_u24lambda_u2477_u24lambda_u2474 = r1.policy;
        IndexedMap<String, Integer> r5 = $this$getAllPermissionStates_u24lambda_u2477_u24lambda_u2474.getAllPermissionFlags($this$getAllPermissionStates_u24lambda_u2477, packageState.getAppId(), r4);
    L27:
        if (r5 == null) goto L29;
        IndexedMap<String, Integer> r10 = r5;
        ArrayMap permissionStates = new ArrayMap();
        int r14 = r10.getSize();
        int index$iv = 0;
    L31:
        if (index$iv >= r14) goto L34;
        String r7 = r10.keyAt(index$iv);
        AccessCheckingService this_$iv2 = this_$iv;
        int flags = r10.valueAt(index$iv).intValue();
        String permissionName = r7;
        boolean granted = r1.isPermissionGranted($this$getAllPermissionStates_u24lambda_u2477, packageState, r4, permissionName, r6);
        int apiFlags = PermissionFlags.INSTANCE.toApiFlags(flags);
        permissionStates.put(permissionName, new PermissionManager.PermissionState(granted, apiFlags));
        index$iv = index$iv + 1;
        r1 = this;
        r6 = deviceId;
        r4 = userId;
        this_$iv = this_$iv2;
        goto L31
    L34:
        return permissionStates;
    L29:
        return MapsKt.emptyMap();
    L25:
        DevicePermissionPolicy $this$getAllPermissionStates_u24lambda_u2477_u24lambda_u2475 = r1.devicePolicy;
        r5 = $this$getAllPermissionStates_u24lambda_u2477_u24lambda_u2475.getAllPermissionFlags($this$getAllPermissionStates_u24lambda_u2477, packageState.getAppId(), r6, r4);
        goto L27
    L21:
        r2 = r9;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionRevokedByPolicy(String packageName, String permissionName, String deviceId, int userId) {
        UserManagerInternal r0 = this.userManagerInternal;
        AccessState r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r0 = null;
    L6:
        if (r0.exists(userId) == true) goto L9;
        Slog.w(LOG_TAG, "isPermissionRevokedByPolicy: Unknown user " + userId);
        return false;
    L9:
        enforceCallingOrSelfCrossUserPermission(userId, true, false, "isPermissionRevokedByPolicy");
        PackageManagerLocal r2 = this.packageManagerLocal;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r2 = null;
    L12:
        PackageManagerLocal.FilteredSnapshot it = withFilteredSnapshot(r2, Binder.getCallingUid(), userId);
        PackageState packageState = it.getPackageState(packageName);     // Catch: Throwable -> L26
        AutoCloseableKt.closeFinally(it, null);
        if (packageState != null) goto L17;
        return false;
    L17:
        AccessCheckingService this_$iv = this.service;
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L21:
        GetStateScope $this$isPermissionRevokedByPolicy_u24lambda_u2479 = new GetStateScope(r1);
        if (isPermissionGranted($this$isPermissionRevokedByPolicy_u24lambda_u2479, packageState, userId, permissionName, deviceId) == false) goto L24;
        return false;
    L24:
        int flags = getPermissionFlagsWithPolicy($this$isPermissionRevokedByPolicy_u24lambda_u2479, packageState.getAppId(), userId, permissionName, deviceId);
        return IntExtensionsKt.hasBits(flags, 128);
    L20:
        r1 = r5;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionsReviewRequired(String packageName, int userId) {
        if (packageName == null) goto L34;
        PackageManagerLocal r0 = this.packageManagerLocal;
        AccessState r3 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L7:
        PackageManagerLocal.UnfilteredSnapshot it = r0.withUnfilteredSnapshot();
        PackageState packageState = getPackageState(it, packageName);     // Catch: Throwable -> L27
        AutoCloseableKt.closeFinally(it, null);
        if (packageState != null) goto L12;
        return false;
    L12:
        AccessCheckingService this_$iv = this.service;
        AccessState r8 = AccessCheckingService.access$getState$p(this_$iv);
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L16:
        GetStateScope $this$isPermissionsReviewRequired_u24lambda_u2483 = new GetStateScope(r3);
        AppIdPermissionPolicy $this$isPermissionsReviewRequired_u24lambda_u2483_u24lambda_u2482 = this.policy;
        IndexedMap<String, Integer> r9 = $this$isPermissionsReviewRequired_u24lambda_u2483_u24lambda_u2482.getUidPermissionFlags($this$isPermissionsReviewRequired_u24lambda_u2483, packageState.getAppId(), userId);
        if (r9 != null) goto L19;
        return false;
    L19:
        int index$iv$iv = 0;
        int r10 = r9.getSize();
    L20:
        if (index$iv$iv >= r10) goto L25;
        Object key$iv = r9.keyAt(index$iv$iv);
        Object value$iv = r9.valueAt(index$iv$iv);
        String r16 = (String) key$iv;
        if (IntExtensionsKt.hasBits(((Number) value$iv).intValue(), 5120) == true) goto L23;
        index$iv$iv = index$iv$iv + 1;
        goto L20
    L23:
        return true;
    L25:
        return false;
    L15:
        r3 = r8;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    L34:
        throw new IllegalArgumentException("packageName cannot be null".toString());
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean shouldShowRequestPermissionRationale(String packageName, String permissionName, String deviceId, int userId) {
        UserManagerInternal r0 = this.userManagerInternal;
        IPlatformCompat r8 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r0 = null;
    L6:
        if (r0.exists(userId) == true) goto L9;
        Slog.w(LOG_TAG, "shouldShowRequestPermissionRationale: Unknown user " + userId);
        return false;
    L9:
        enforceCallingOrSelfCrossUserPermission(userId, true, false, "shouldShowRequestPermissionRationale");
        int callingUid = Binder.getCallingUid();
        PackageManagerLocal r1 = this.packageManagerLocal;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r1 = null;
    L12:
        PackageManagerLocal.FilteredSnapshot it = withFilteredSnapshot(r1, callingUid, userId);
        PackageState packageState = it.getPackageState(packageName);     // Catch: Throwable -> L55
        AutoCloseableKt.closeFinally(it, null);
        if (packageState != null) goto L17;
        return false;
    L17:
        int appId = packageState.getAppId();
        if (UserHandle.getAppId(callingUid) == appId) goto L20;
        return false;
    L20:
        AccessCheckingService this_$iv = this.service;
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r5 = null;
    L23:
        GetStateScope $this$shouldShowRequestPermissionRationale_u24lambda_u2486 = new GetStateScope(r5);
        if (isPermissionGranted($this$shouldShowRequestPermissionRationale_u24lambda_u2486, packageState, userId, permissionName, deviceId) == false) goto L26;
        return false;
    L26:
        int flags = getPermissionFlagsWithPolicy($this$shouldShowRequestPermissionRationale_u24lambda_u2486, appId, userId, permissionName, deviceId);
        if (IntExtensionsKt.hasAnyBit(flags, 262592) == false) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(permissionName, "android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L54;
        long token$iv = Binder.clearCallingIdentity();
        IPlatformCompat r2 = this.platformCompat;     // Catch: Throwable -> L36 RemoteException -> L38
        if (r2 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("platformCompat");     // Catch: Throwable -> L36 RemoteException -> L38
    L41:
        boolean r18 = true;
        boolean isBackgroundRationaleChangeEnabled = r8.isChangeEnabledByPackageName(BACKGROUND_RATIONALE_CHANGE_ID, packageName, userId);     // Catch: Throwable -> L36 RemoteException -> L44
    L48:
        Binder.restoreCallingIdentity(token$iv);
        if (isBackgroundRationaleChangeEnabled == false) goto L54;
        return r18;
    L44:
        e = e;
    L46:
        Slog.e(LOG_TAG, "shouldShowRequestPermissionRationale: Unable to check if compatibility change is enabled", e);     // Catch: Throwable -> L36
        isBackgroundRationaleChangeEnabled = false;
        goto L48
    L40:
        r8 = r2;
    L36:
        th = move-exception;
        Binder.restoreCallingIdentity(token$iv);
        throw th;
    L38:
        e = e;
        r18 = true;
    L54:
        return IntExtensionsKt.hasBits(flags, 32);
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlags(String packageName, String permissionName, int flagMask, int flagValues, boolean enforceAdjustPolicyPermission, String deviceId, int userId) {
        boolean r0 = true;
        int callingUid = Binder.getCallingUid();
        UserManagerInternal r2 = this.userManagerInternal;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r2 = null;
    L6:
        if (r2.exists(userId) == true) goto L9;
        Slog.w(LOG_TAG, "updatePermissionFlags: Unknown user " + userId);
        return;
    L9:
        enforceCallingOrSelfCrossUserPermission(userId, true, true, "updatePermissionFlags");
        enforceCallingOrSelfAnyPermission("updatePermissionFlags", new String[]{"android.permission.GRANT_RUNTIME_PERMISSIONS", "android.permission.REVOKE_RUNTIME_PERMISSIONS"});
        if (isRootOrSystemUid(callingUid) == true) goto L26;
        int r7 = flagMask;
        if (IntExtensionsKt.hasBits(r7, 4) == false) goto L27;
        if (enforceAdjustPolicyPermission == false) goto L15;
        this.context.enforceCallingOrSelfPermission("android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY", "Need android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY to change policy flags");
        goto L27
    L15:
        PackageManagerInternal r3 = this.packageManagerInternal;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r3 = null;
    L18:
        int targetSdkVersion = r3.getUidTargetSdkVersion(callingUid);
        if (targetSdkVersion >= 29) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == true) goto L27;
        throw new IllegalArgumentException("android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY needs to be checked for packages targeting 29 or later when changing policy flags".toString());
    L21:
        r8 = false;
    L27:
        PackageManagerInternal r4 = this.packageManagerInternal;
        if (r4 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r4 = null;
    L30:
        PackageStateInternal packageState = r4.getPackageStateInternal(packageName);
        if (packageState == null) goto L33;
        AndroidPackage r5 = packageState.getAndroidPackage();
    L34:
        AndroidPackage androidPackage = r5;
        if (androidPackage == null) goto L89;
        PackageManagerInternal r6 = this.packageManagerInternal;
        if (r6 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r6 = null;
    L40:
        if (r6.filterAppAccess(packageName, callingUid, userId, false) == true) goto L89;
        boolean canUpdateSystemFlags = isRootOrSystemUid(callingUid);
        if (androidPackage.getRequestedPermissions().contains(permissionName) == false) goto L45;
        boolean isPermissionRequested = true;
    L63:
        int appId = packageState.getAppId();
        AccessCheckingService this_$iv = this.service;
        Object r18 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r18);
        AccessState r9 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L85
        if (r9 == null) goto L91;
        AccessState r21 = r9;
    L73:
        AccessState oldState$iv = r21;
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L85
        MutateStateScope $this$updatePermissionFlags_u24lambda_u2490 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L85
        access$updatePermissionFlags(this, $this$updatePermissionFlags_u24lambda_u2490, appId, userId, permissionName, deviceId, r7, flagValues, canUpdateSystemFlags, true, isPermissionRequested, "updatePermissionFlags", packageName);     // Catch: Throwable -> L83
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L83
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L81
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L81
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L81
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L81
        monitor-exit(r18);
        return;
    L81:
        th = th;
    L87:
        monitor-exit(r18);
        throw th;
    L83:
        th = th;
        goto L87
    L91:
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L70
        r21 = null;
    L70:
        th = th;
    L85:
        th = th;
        goto L87
    L45:
        PackageManagerInternal r10 = this.packageManagerInternal;
        if (r10 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r10 = null;
    L48:
        String[] sharedUserPackageNames = r10.getSharedUserPackagesForPackage(packageName, userId);
        int r11 = sharedUserPackageNames.length;
        int r12 = 0;
    L49:
        if (r12 >= r11) goto L62;
        String r17 = sharedUserPackageNames[r12];
        boolean r20 = r0;
        PackageManagerInternal r13 = this.packageManagerInternal;
        if (r13 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r13 = null;
    L53:
        AndroidPackage sharedUserPackage = r13.getPackage(r17);
        if (sharedUserPackage != null) goto L56;
    L58:
        boolean r14 = false;
    L59:
        if (r14 == true) goto L60;
        r12 = r12 + 1;
        r0 = r20;
        goto L49
    L60:
        isPermissionRequested = r20;
        goto L63
    L56:
        if (sharedUserPackage.getRequestedPermissions().contains(permissionName) == false) goto L58;
        r14 = r20;
        goto L59
    L62:
        isPermissionRequested = false;
    L89:
        Slog.w(LOG_TAG, "updatePermissionFlags: Unknown package " + packageName);
        return;
    L33:
        r5 = null;
        goto L34
    L26:
        r7 = flagMask;
        goto L27
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlagsForAllApps(int flagMask, int flagValues, int userId) {
        PermissionService r1 = this;
        int r4 = userId;
        int callingUid = Binder.getCallingUid();
        UserManagerInternal r0 = r1.userManagerInternal;
        AccessState oldState$iv = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r0 = null;
    L6:
        if (r0.exists(r4) == true) goto L9;
        Slog.w(LOG_TAG, "updatePermissionFlagsForAllApps: Unknown user " + r4);
        return;
    L9:
        r1.enforceCallingOrSelfCrossUserPermission(r4, true, true, "updatePermissionFlagsForAllApps");
        r1.enforceCallingOrSelfAnyPermission("updatePermissionFlagsForAllApps", new String[]{"android.permission.GRANT_RUNTIME_PERMISSIONS", "android.permission.REVOKE_RUNTIME_PERMISSIONS"});
        boolean canUpdateSystemFlags = r1.isRootOrSystemUid(callingUid);
        PackageManagerLocal r2 = r1.packageManagerLocal;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r2 = null;
    L12:
        PackageManagerLocal.UnfilteredSnapshot it = r2.withUnfilteredSnapshot();
        Map<String, PackageState> r6 = it.getPackageStates();     // Catch: Throwable -> L64
        AutoCloseableKt.closeFinally(it, null);
        AccessCheckingService this_$iv = r1.service;
        Object r17 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r17);
        int r3 = 0;
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L60
        if (r5 == null) goto L76;
        oldState$iv = r5;
    L24:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L60
        MutateStateScope $this$updatePermissionFlagsForAllApps_u24lambda_u2494 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L60
        Iterator<Map.Entry<String, PackageState>> r21 = r6.entrySet().iterator();     // Catch: Throwable -> L60
    L25:
        if (r21.hasNext() == false) goto L50;
        Map.Entry<String, PackageState> r7 = r21.next();     // Catch: Throwable -> L46
        String packageName = r7.getKey();     // Catch: Throwable -> L46
        PackageState packageState = r7.getValue();     // Catch: Throwable -> L46
        if (packageState.isApex() == false) goto L30;
        int r33 = r3;
        AccessState oldState$iv2 = oldState$iv;
        AccessCheckingService this_$iv2 = this_$iv;
        MutableAccessState newState$iv2 = newState$iv;
        MutateStateScope $this$updatePermissionFlagsForAllApps_u24lambda_u2495 = $this$updatePermissionFlagsForAllApps_u24lambda_u2494;
    L49:
        r1 = this;
        r4 = userId;
        newState$iv = newState$iv2;
        $this$updatePermissionFlagsForAllApps_u24lambda_u2494 = $this$updatePermissionFlagsForAllApps_u24lambda_u2495;
        oldState$iv = oldState$iv2;
        this_$iv = this_$iv2;
        r3 = r33;
        goto L25
    L30:
        AndroidPackage androidPackage = packageState.getAndroidPackage();     // Catch: Throwable -> L46
        if (androidPackage != null) goto L33;
        r33 = r3;
        oldState$iv2 = oldState$iv;
        this_$iv2 = this_$iv;
        newState$iv2 = newState$iv;
        $this$updatePermissionFlagsForAllApps_u24lambda_u2495 = $this$updatePermissionFlagsForAllApps_u24lambda_u2494;
        goto L49
    L33:
        Iterable $this$forEach$iv = androidPackage.getRequestedPermissions();     // Catch: Throwable -> L46
        Iterator r28 = $this$forEach$iv.iterator();     // Catch: Throwable -> L46
    L35:
        if (r28.hasNext() == false) goto L48;
        Object element$iv = r28.next();     // Catch: Throwable -> L46
        String permissionName = (String) element$iv;     // Catch: Throwable -> L46
        AccessCheckingService this_$iv3 = this_$iv;
        AccessState oldState$iv3 = oldState$iv;
        MutateStateScope $this$updatePermissionFlagsForAllApps_u24lambda_u2496 = $this$updatePermissionFlagsForAllApps_u24lambda_u2494;
        int r34 = r3;
        MutableAccessState newState$iv3 = newState$iv;
        access$updatePermissionFlags(r1, $this$updatePermissionFlagsForAllApps_u24lambda_u2496, packageState.getAppId(), r4, permissionName, "default:0", flagMask, flagValues, canUpdateSystemFlags, false, true, "updatePermissionFlagsForAllApps", packageName);     // Catch: Throwable -> L42
        r1 = this;
        r4 = userId;
        newState$iv = newState$iv3;
        $this$updatePermissionFlagsForAllApps_u24lambda_u2494 = $this$updatePermissionFlagsForAllApps_u24lambda_u2496;
        oldState$iv = oldState$iv3;
        this_$iv = this_$iv3;
        r3 = r34;
    L42:
        th = th;
    L62:
        monitor-exit(r17);
        throw th;
    L44:
        th = th;
        goto L62
    L48:
        r33 = r3;
        oldState$iv2 = oldState$iv;
        this_$iv2 = this_$iv;
        newState$iv2 = newState$iv;
        $this$updatePermissionFlagsForAllApps_u24lambda_u2495 = $this$updatePermissionFlagsForAllApps_u24lambda_u2494;
    L46:
        th = th;
        goto L62
    L50:
        AccessCheckingService this_$iv4 = this_$iv;
        MutableAccessState newState$iv4 = newState$iv;
        AccessCheckingService.access$getPersistence$p(this_$iv4).write(newState$iv4);     // Catch: Throwable -> L58
        AccessCheckingService.access$setState$p(this_$iv4, newState$iv4);     // Catch: Throwable -> L56
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv4);     // Catch: Throwable -> L56
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv4));     // Catch: Throwable -> L56
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L56
        monitor-exit(r17);
        return;
    L56:
        th = th;
    L58:
        th = th;
        goto L62
    L76:
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L21
    L21:
        th = th;
    L60:
        th = th;
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    private final void updatePermissionFlags(MutateStateScope $this$updatePermissionFlags, int appId, int userId, String permissionName, String deviceId, int flagMask, int flagValues, boolean canUpdateSystemFlags, boolean reportErrorForUnknownPermission, boolean isPermissionRequested, String methodName, String packageName) {
        if (canUpdateSystemFlags == true) goto L5;
        int flagMask2 = IntExtensionsKt.andInv(flagMask, 30768);
        int flagValues2 = IntExtensionsKt.andInv(flagValues, 30768);
    L6:
        AppIdPermissionPolicy $this$updatePermissionFlags_u24lambda_u2495 = this.policy;
        Permission permission = $this$updatePermissionFlags_u24lambda_u2495.getPermissions($this$updatePermissionFlags).get(permissionName);
        if (permission != null) goto L12;
        if (reportErrorForUnknownPermission == true) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Unknown permission " + permissionName);
    L12:
        int oldFlags = getPermissionFlagsWithPolicy($this$updatePermissionFlags, appId, userId, permissionName, deviceId);
        if (isPermissionRequested == true) goto L17;
        if (oldFlags != 0) goto L17;
        Slog.w(LOG_TAG, methodName + ": Permission " + permissionName + " isn't requested by package " + packageName);
        return;
    L17:
        int newFlags = PermissionFlags.INSTANCE.updateFlags(permission, oldFlags, flagMask2, flagValues2);
        setPermissionFlagsWithPolicy($this$updatePermissionFlags, appId, userId, permissionName, deviceId, newFlags);
        return;
    L5:
        flagMask2 = flagMask;
        flagValues2 = flagValues;
        goto L6
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public ArrayList<String> getAllowlistedRestrictedPermissions(String packageName, int allowlistedFlags, int userId) {
        if (packageName == null) goto L49;
        Preconditions.checkFlagsArgument(allowlistedFlags, 7);
        Preconditions.checkArgumentNonnegative(userId, "userId cannot be null");
        UserManagerInternal r0 = this.userManagerInternal;
        PackageManagerInternal r1 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r0 = null;
    L7:
        if (r0.exists(userId) == true) goto L10;
        Slog.w(LOG_TAG, "AllowlistedRestrictedPermission api: Unknown user " + userId);
        return null;
    L10:
        boolean isCallerPrivileged = false;
        enforceCallingOrSelfCrossUserPermission(userId, false, false, "getAllowlistedRestrictedPermissions");
        int callingUid = Binder.getCallingUid();
        PackageManagerLocal r3 = this.packageManagerLocal;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r3 = null;
    L13:
        PackageManagerLocal.FilteredSnapshot it = withFilteredSnapshot(r3, callingUid, userId);
        PackageState packageState = it.getPackageState(packageName);     // Catch: Throwable -> L43
        AutoCloseableKt.closeFinally(it, null);
        if (packageState != null) goto L18;
        return null;
    L18:
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        if (androidPackage != null) goto L22;
        return null;
    L22:
        if (this.context.checkCallingOrSelfPermission("android.permission.WHITELIST_RESTRICTED_PERMISSIONS") != 0) goto L25;
        isCallerPrivileged = true;
    L25:
        if (IntExtensionsKt.hasBits(allowlistedFlags, 1) == false) goto L30;
        if (isCallerPrivileged == true) goto L30;
        throw new SecurityException("Querying system allowlist requires android.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L30:
        PackageManagerInternal r4 = this.packageManagerInternal;
        if (r4 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
    L34:
        boolean isCallerInstallerOnRecord = r1.isCallerInstallerOfRecord(androidPackage, callingUid);
        if (IntExtensionsKt.hasAnyBit(allowlistedFlags, 6) == false) goto L42;
        if (isCallerPrivileged == true) goto L42;
        if (isCallerInstallerOnRecord == true) goto L42;
        throw new SecurityException("Querying upgrade or installer allowlist requires being installer on record or android.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L42:
        return getAllowlistedRestrictedPermissionsUnchecked(packageState.getAppId(), allowlistedFlags, userId);
    L33:
        r1 = r4;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    L49:
        throw new IllegalArgumentException("packageName cannot be null".toString());
    }

    private final int getPermissionFlagsWithPolicy(GetStateScope $this$getPermissionFlagsWithPolicy, int appId, int userId, String permissionName, String deviceId) {
        if (Intrinsics.areEqual(deviceId, "default:0") == false) goto L6;
        AppIdPermissionPolicy $this$getPermissionFlagsWithPolicy_u24lambda_u2498 = this.policy;
        return $this$getPermissionFlagsWithPolicy_u24lambda_u2498.getPermissionFlags($this$getPermissionFlagsWithPolicy, appId, userId, permissionName);
    L6:
        if (PermissionManager.DEVICE_AWARE_PERMISSIONS.contains(permissionName) == true) goto L9;
        Slog.i(LOG_TAG, permissionName + " is not device aware permission,  get the flags for default device.");
        AppIdPermissionPolicy $this$getPermissionFlagsWithPolicy_u24lambda_u2499 = this.policy;
        return $this$getPermissionFlagsWithPolicy_u24lambda_u2499.getPermissionFlags($this$getPermissionFlagsWithPolicy, appId, userId, permissionName);
    L9:
        DevicePermissionPolicy $this$getPermissionFlagsWithPolicy_u24lambda_u24100 = this.devicePolicy;
        return $this$getPermissionFlagsWithPolicy_u24lambda_u24100.getPermissionFlags($this$getPermissionFlagsWithPolicy, appId, deviceId, userId, permissionName);
    }

    private final boolean setPermissionFlagsWithPolicy(MutateStateScope $this$setPermissionFlagsWithPolicy, int appId, int userId, String permissionName, String deviceId, int flags) {
        if (Intrinsics.areEqual(deviceId, "default:0") == false) goto L6;
        AppIdPermissionPolicy $this$setPermissionFlagsWithPolicy_u24lambda_u24101 = this.policy;
        return $this$setPermissionFlagsWithPolicy_u24lambda_u24101.setPermissionFlags($this$setPermissionFlagsWithPolicy, appId, userId, permissionName, flags);
    L6:
        if (PermissionManager.DEVICE_AWARE_PERMISSIONS.contains(permissionName) == true) goto L9;
        Slog.i(LOG_TAG, permissionName + " is not device aware permission,  set the flags for default device.");
        AppIdPermissionPolicy $this$setPermissionFlagsWithPolicy_u24lambda_u24102 = this.policy;
        return $this$setPermissionFlagsWithPolicy_u24lambda_u24102.setPermissionFlags($this$setPermissionFlagsWithPolicy, appId, userId, permissionName, flags);
    L9:
        DevicePermissionPolicy $this$setPermissionFlagsWithPolicy_u24lambda_u24103 = this.devicePolicy;
        return $this$setPermissionFlagsWithPolicy_u24lambda_u24103.setPermissionFlags($this$setPermissionFlagsWithPolicy, appId, deviceId, userId, permissionName, flags);
    }

    private final ArrayList<String> getAllowlistedRestrictedPermissionsUnchecked(int appId, int allowlistedFlags, int userId) {
        AccessCheckingService this_$iv = this.service;
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r5 = null;
    L5:
        GetStateScope $this$getAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24105 = new GetStateScope(r5);
        AppIdPermissionPolicy $this$getAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24105_u24lambda_u24104 = this.policy;
        IndexedMap<String, Integer> r7 = $this$getAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24105_u24lambda_u24104.getUidPermissionFlags($this$getAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24105, appId, userId);
        if (r7 != null) goto L8;
        return null;
    L8:
        int queryFlags = 0;
        if (IntExtensionsKt.hasBits(allowlistedFlags, 1) == false) goto L12;
        queryFlags = 0 | 65536;
    L12:
        if (IntExtensionsKt.hasBits(allowlistedFlags, 4) == false) goto L15;
        queryFlags = queryFlags | 131072;
    L15:
        if (IntExtensionsKt.hasBits(allowlistedFlags, 2) == false) goto L17;
        queryFlags = queryFlags | 32768;
    L17:
        ArrayList<String> r3 = new ArrayList();
        int index$iv$iv = 0;
        int r13 = r7.getSize();
    L18:
        if (index$iv$iv >= r13) goto L28;
        Object key$iv = r7.keyAt(index$iv$iv);
        Object value$iv = r7.valueAt(index$iv$iv);
        int flags = ((Number) value$iv).intValue();
        String permissionName = (String) key$iv;
        if (IntExtensionsKt.hasAnyBit(flags, queryFlags) == true) goto L24;
        permissionName = null;
    L24:
        if (permissionName == null) goto L26;
        r3.add(permissionName);
    L26:
        index$iv$iv = index$iv$iv + 1;
        goto L18
    L28:
        return r3;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addAllowlistedRestrictedPermission(String packageName, String permissionName, int allowlistedFlags, int userId) {
        if (permissionName == null) goto L15;
        if (enforceRestrictedPermission(permissionName) == true) goto L6;
        return false;
    L6:
        ArrayList<String> r0 = getAllowlistedRestrictedPermissions(packageName, allowlistedFlags, userId);
        if (r0 != null) goto L9;
        r0 = new ArrayList(1);
    L9:
        ArrayList<String> r4 = r0;
        if (r4.contains(permissionName) == true) goto L13;
        r4.add(permissionName);
        return setAllowlistedRestrictedPermissions(packageName, r4, allowlistedFlags, userId, true);
    L13:
        return false;
    L15:
        throw new IllegalArgumentException("permissionName cannot be null".toString());
    }

    private final void addAllowlistedRestrictedPermissionsUnchecked(AndroidPackage androidPackage, int appId, List<String> r10, int userId) {
        ArrayList<String> r0 = getAllowlistedRestrictedPermissionsUnchecked(appId, 2, userId);
        if (r0 == null) goto L7;
        ArraySet $this$addAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24109_u24lambda_u24108 = new ArraySet(r10);
        CollectionsKt.addAll($this$addAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24109_u24lambda_u24108, r0);
        List<String> r1 = CollectionsKt.toList($this$addAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24109_u24lambda_u24108);
        if (r1 == null) goto L7;
    L8:
        setAllowlistedRestrictedPermissionsUnchecked(androidPackage, appId, r1, 2, userId);
        return;
    L7:
        r1 = r10;
        goto L8
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean removeAllowlistedRestrictedPermission(String packageName, String permissionName, int allowlistedFlags, int userId) {
        if (permissionName == null) goto L15;
        if (enforceRestrictedPermission(permissionName) == true) goto L6;
        return false;
    L6:
        ArrayList<String> r0 = getAllowlistedRestrictedPermissions(packageName, allowlistedFlags, userId);
        if (r0 != null) goto L10;
        return false;
    L10:
        if (r0.remove(permissionName) == true) goto L12;
        return false;
    L12:
        return setAllowlistedRestrictedPermissions(packageName, r0, allowlistedFlags, userId, false);
    L15:
        throw new IllegalArgumentException("permissionName cannot be null".toString());
    }

    private final boolean enforceRestrictedPermission(String permissionName) {
        AccessCheckingService this_$iv = this.service;
        AccessState r3 = AccessCheckingService.access$getState$p(this_$iv);
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r3 = null;
    L5:
        GetStateScope $this$enforceRestrictedPermission_u24lambda_u24112 = new GetStateScope(r3);
        AppIdPermissionPolicy $this$enforceRestrictedPermission_u24lambda_u24112_u24lambda_u24111 = this.policy;
        Permission permission = $this$enforceRestrictedPermission_u24lambda_u24112_u24lambda_u24111.getPermissions($this$enforceRestrictedPermission_u24lambda_u24112).get(permissionName);
        boolean isImmutablyRestrictedPermission = false;
        if (permission != null) goto L9;
        Slog.w(LOG_TAG, "permission definition for " + permissionName + " does not exist");
        return false;
    L9:
        PackageManagerLocal r1 = this.packageManagerLocal;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r1 = null;
    L12:
        PackageManagerLocal.FilteredSnapshot it = r1.withFilteredSnapshot();
        PackageState r5 = it.getPackageState(permission.getPermissionInfo().packageName);     // Catch: Throwable -> L36
        AutoCloseableKt.closeFinally(it, null);
        if (r5 != null) goto L18;
        return false;
    L18:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 4) == false) goto L20;
    L23:
        boolean r2 = true;
    L24:
        if (r2 == true) goto L26;
    L29:
        if (isImmutablyRestrictedPermission == true) goto L31;
    L35:
        return true;
    L31:
        if (this.context.checkCallingOrSelfPermission("android.permission.WHITELIST_RESTRICTED_PERMISSIONS") == 0) goto L35;
        throw new SecurityException("Cannot modify allowlist of an immutably restricted permission: " + permission.getPermissionInfo().name);
    L26:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 16) == false) goto L29;
        isImmutablyRestrictedPermission = true;
        goto L29
    L20:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 8) == true) goto L23;
        r2 = false;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    private final boolean setAllowlistedRestrictedPermissions(String packageName, List<String> r13, int allowlistedFlags, int userId, boolean isAddingPermission) {
        if (Integer.bitCount(allowlistedFlags) != 1) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        if (this.context.checkCallingOrSelfPermission("android.permission.WHITELIST_RESTRICTED_PERMISSIONS") != 0) goto L9;
        boolean r1 = true;
    L10:
        boolean isCallerPrivileged = r1;
        int callingUid = Binder.getCallingUid();
        PackageManagerLocal r2 = this.packageManagerLocal;
        PackageManagerInternal r3 = null;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r2 = null;
    L13:
        PackageManagerLocal.FilteredSnapshot snapshot = withFilteredSnapshot(r2, callingUid, userId);
        PackageState packageState = snapshot.getPackageStates().get(packageName);     // Catch: Throwable -> L39
        if (packageState != null) goto L18;
        AutoCloseableKt.closeFinally(snapshot, null);
        return false;
    L18:
        AutoCloseableKt.closeFinally(snapshot, null);
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        if (androidPackage != null) goto L21;
        return false;
    L21:
        PackageManagerInternal r4 = this.packageManagerInternal;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
    L25:
        boolean isCallerInstallerOnRecord = r3.isCallerInstallerOfRecord(androidPackage, callingUid);
        if (IntExtensionsKt.hasBits(allowlistedFlags, 4) == false) goto L37;
        if (isCallerPrivileged == true) goto L32;
        if (isCallerInstallerOnRecord == true) goto L32;
        throw new SecurityException("Modifying upgrade allowlist requires being installer on record or android.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L32:
        if (isAddingPermission == false) goto L37;
        if (isCallerPrivileged == true) goto L37;
        throw new SecurityException("Adding to upgrade allowlist requiresandroid.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L37:
        setAllowlistedRestrictedPermissionsUnchecked(androidPackage, packageState.getAppId(), r13, allowlistedFlags, userId);
        return true;
    L24:
        r3 = r4;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        AutoCloseableKt.closeFinally(snapshot, th);
        throw th;
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private final void setAllowlistedRestrictedPermissionsUnchecked(AndroidPackage androidPackage, int appId, List<String> r32, int allowlistedFlags, int userId) {
        int exemptMask = 0;
        if (IntExtensionsKt.hasBits(allowlistedFlags, 1) == false) goto L5;
        exemptMask = 0 | 65536;
    L5:
        int r3 = 4;
        if (IntExtensionsKt.hasBits(allowlistedFlags, 4) == false) goto L9;
        exemptMask = exemptMask | 131072;
    L9:
        if (IntExtensionsKt.hasBits(allowlistedFlags, 2) == false) goto L11;
        int exemptMask2 = exemptMask | 32768;
    L12:
        AccessCheckingService this_$iv = this.service;
        Object r14 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r14);
        int r0 = 0;
        AccessState r4 = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L18
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L18
        r4 = null;
    L20:
        AccessState oldState$iv = r4;
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L18
        MutateStateScope $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L18
        AppIdPermissionPolicy $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24116 = access$getPolicy$p(this);     // Catch: Throwable -> L18
        IndexedMap<String, Permission> r7 = $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24116.getPermissions($this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117);     // Catch: Throwable -> L18
        Iterable $this$forEachIndexed$iv = androidPackage.getRequestedPermissions();     // Catch: Throwable -> L18
        int index$iv = 0;
        Iterator r20 = $this$forEachIndexed$iv.iterator();     // Catch: Throwable -> L18
    L21:
        if (r20.hasNext() == false) goto L48;
        Object item$iv = r20.next();     // Catch: Throwable -> L18
        int index$iv2 = index$iv + 1;     // Catch: Throwable -> L18
        if (index$iv >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L18
    L26:
        String requestedPermission = (String) item$iv;     // Catch: Throwable -> L18
        Permission permission = r7.get(requestedPermission);     // Catch: Throwable -> L18
        if (permission == null) goto L45;
        int exemptFlags = 0;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, r3) == true) goto L34;
        int r28 = r0;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 8) == true) goto L35;
        int r1 = 0;
    L36:
        if (r1 != 0) goto L53;
        AppIdPermissionPolicy $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24117 = $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24116;
    L47:
        r7 = r7;
        $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24116 = $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24117;
        index$iv = index$iv2;
        r3 = 4;
        newState$iv = newState$iv;
        r0 = r28;
        goto L21
    L53:
    L43:
        th = th;
    L51:
        monitor-exit(r14);
        throw th;
    L40:
        if (r32.contains(requestedPermission) == false) goto L42;
        exemptFlags = exemptMask2;
    L42:
        $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24117 = $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24116;
        $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24117.updatePermissionExemptFlags($this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117, appId, userId, permission, exemptMask2, exemptFlags);     // Catch: Throwable -> L43
    L35:
        r1 = 1;
        goto L36
    L34:
        r28 = r0;
        goto L35
    L45:
        r28 = r0;
        $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24117 = $this$setAllowlistedRestrictedPermissionsUnchecked_u24lambda_u24117_u24lambda_u24116;
        goto L47
    L48:
        MutableAccessState newState$iv2 = newState$iv;
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv2);     // Catch: Throwable -> L43
        AccessCheckingService.access$setState$p(this_$iv, newState$iv2);     // Catch: Throwable -> L43
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L43
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv2));     // Catch: Throwable -> L43
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L43
        monitor-exit(r14);
        return;
    L18:
        th = th;
        goto L51
    L11:
        exemptMask2 = exemptMask;
        goto L12
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissions(AndroidPackage androidPackage, int userId, boolean restorePregrants) {
        AccessCheckingService this_$iv = this.service;
        Object r2 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r2);
        AccessState oldState$iv = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L8
        if (oldState$iv != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L8
        oldState$iv = null;
    L10:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L8
        MutateStateScope $this$resetRuntimePermissions_u24lambda_u24120 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L8
        AppIdPermissionPolicy $this$resetRuntimePermissions_u24lambda_u24120_u24lambda_u24118 = access$getPolicy$p(this);     // Catch: Throwable -> L8
        $this$resetRuntimePermissions_u24lambda_u24120_u24lambda_u24118.resetRuntimePermissions($this$resetRuntimePermissions_u24lambda_u24120, androidPackage.getPackageName(), userId, restorePregrants);     // Catch: Throwable -> L8
        DevicePermissionPolicy $this$resetRuntimePermissions_u24lambda_u24120_u24lambda_u24119 = access$getDevicePolicy$p(this);     // Catch: Throwable -> L8
        $this$resetRuntimePermissions_u24lambda_u24120_u24lambda_u24119.resetRuntimePermissions($this$resetRuntimePermissions_u24lambda_u24120, androidPackage.getPackageName(), userId);     // Catch: Throwable -> L8
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L8
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L8
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L8
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r2);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissionsForUser(int userId) {
        PermissionService r1 = this;
        PackageManagerLocal r0 = r1.packageManagerLocal;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        PackageManagerLocal.UnfilteredSnapshot snapshot = r0.withUnfilteredSnapshot();
        AccessCheckingService this_$iv = r1.service;     // Catch: Throwable -> L27
        Object r9 = AccessCheckingService.access$getStateLock$p(this_$iv);     // Catch: Throwable -> L27
        monitor-enter(r9);     // Catch: Throwable -> L27
        int r2 = 0;
        AccessState oldState$iv = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L12
        if (oldState$iv != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L12
        oldState$iv = null;
    L14:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L12
        MutateStateScope $this$resetRuntimePermissionsForUser_u24lambda_u24125_u24lambda_u24124 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L12
        Iterator<Map.Entry<String, PackageState>> r16 = snapshot.getPackageStates().entrySet().iterator();     // Catch: Throwable -> L12
    L16:
        if (r16.hasNext() == false) goto L22;
        PackageState packageState = r16.next().getValue();     // Catch: Throwable -> L12
        if (packageState.isApex() == true) goto L21;
        AppIdPermissionPolicy $this$resetRuntimePermissionsForUser_u24lambda_u24125_u24lambda_u24124_u24lambda_u24123_u24lambda_u24121 = access$getPolicy$p(r1);     // Catch: Throwable -> L12
        $this$resetRuntimePermissionsForUser_u24lambda_u24125_u24lambda_u24124_u24lambda_u24123_u24lambda_u24121.resetRuntimePermissions($this$resetRuntimePermissionsForUser_u24lambda_u24125_u24lambda_u24124, packageState.getPackageName(), userId, true);     // Catch: Throwable -> L12
        DevicePermissionPolicy $this$resetRuntimePermissionsForUser_u24lambda_u24125_u24lambda_u24124_u24lambda_u24123_u24lambda_u24122 = access$getDevicePolicy$p(this);     // Catch: Throwable -> L12
        $this$resetRuntimePermissionsForUser_u24lambda_u24125_u24lambda_u24124_u24lambda_u24123_u24lambda_u24122.resetRuntimePermissions($this$resetRuntimePermissionsForUser_u24lambda_u24125_u24lambda_u24124, packageState.getPackageName(), userId);     // Catch: Throwable -> L12
    L21:
        r1 = this;
        r2 = r2;
        goto L16
    L22:
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L12
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L12
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L12
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r9);     // Catch: Throwable -> L27
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L27
        AutoCloseableKt.closeFinally(snapshot, null);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        AutoCloseableKt.closeFinally(snapshot, th);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void addOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        this.context.enforceCallingOrSelfPermission("android.permission.OBSERVE_GRANT_REVOKE_PERMISSIONS", "addOnPermissionsChangeListener");
        OnPermissionsChangeListeners r0 = this.onPermissionsChangeListeners;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onPermissionsChangeListeners");
        r0 = null;
    L5:
        r0.addListener(listener);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removeOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        this.context.enforceCallingOrSelfPermission("android.permission.OBSERVE_GRANT_REVOKE_PERMISSIONS", "removeOnPermissionsChangeListener");
        OnPermissionsChangeListeners r0 = this.onPermissionsChangeListeners;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("onPermissionsChangeListeners");
        r0 = null;
    L5:
        r0.removeListener(listener);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<SplitPermissionInfoParcelable> getSplitPermissions() {
        SystemConfig r0 = this.systemConfig;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("systemConfig");
        r0 = null;
    L6:
        return PermissionManager.splitPermissionInfoListToParcelableList(r0.getSplitPermissions());
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String[] getAppOpPermissionPackages(String permissionName) {
        if (permissionName == null) goto L41;
        ArraySet packageNames = new ArraySet();
        AccessCheckingService this_$iv = this.service;
        AccessState r6 = AccessCheckingService.access$getState$p(this_$iv);
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r6 = null;
    L7:
        GetStateScope $this$getAppOpPermissionPackages_u24lambda_u24128 = new GetStateScope(r6);
        AppIdPermissionPolicy $this$getAppOpPermissionPackages_u24lambda_u24128_u24lambda_u24127 = this.policy;
        Permission permission = $this$getAppOpPermissionPackages_u24lambda_u24128_u24lambda_u24127.getPermissions($this$getAppOpPermissionPackages_u24lambda_u24128).get(permissionName);
        if (permission != null) goto L10;
    L11:
        packageNames.toArray(new String[0]);
    L12:
        PackageManagerLocal r4 = this.packageManagerLocal;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r4 = null;
    L15:
        PackageManagerLocal.UnfilteredSnapshot snapshot = r4.withUnfilteredSnapshot();
        Iterator<Map.Entry<String, PackageState>> r11 = snapshot.getPackageStates().entrySet().iterator();     // Catch: Throwable -> L28
    L18:
        if (r11.hasNext() == false) goto L32;
        PackageState packageState = r11.next().getValue();     // Catch: Throwable -> L28
        if (packageState.isApex() == true) goto L18;
        AndroidPackage androidPackage = packageState.getAndroidPackage();     // Catch: Throwable -> L28
        if (androidPackage == null) goto L18;
        if (androidPackage.getRequestedPermissions().contains(permissionName) == false) goto L18;
        packageNames.add(androidPackage.getPackageName());     // Catch: Throwable -> L28
        goto L18
    L32:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L28
        AutoCloseableKt.closeFinally(snapshot, null);
        return (String[]) packageNames.toArray(new String[0]);
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        AutoCloseableKt.closeFinally(snapshot, th);
        throw th;
    L10:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 64) == true) goto L12;
    L41:
        throw new IllegalArgumentException("permissionName cannot be null".toString());
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, Set<String>> getAllAppOpPermissionPackages() {
        ArrayMap appOpPermissionPackageNames = new ArrayMap();
        AccessCheckingService this_$iv = this.service;
        AccessState r5 = AccessCheckingService.access$getState$p(this_$iv);
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r5 = null;
    L5:
        GetStateScope $this$getAllAppOpPermissionPackages_u24lambda_u24132 = new GetStateScope(r5);
        AppIdPermissionPolicy $this$getAllAppOpPermissionPackages_u24lambda_u24132_u24lambda_u24131 = this.policy;
        IndexedMap<String, Permission> r7 = $this$getAllAppOpPermissionPackages_u24lambda_u24132_u24lambda_u24131.getPermissions($this$getAllAppOpPermissionPackages_u24lambda_u24132);
        PackageManagerLocal r0 = this.packageManagerLocal;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L8:
        PackageManagerLocal.UnfilteredSnapshot r3 = r0.withUnfilteredSnapshot();
        PackageManagerLocal.UnfilteredSnapshot snapshot = r3;
        Iterator<Map.Entry<String, PackageState>> r9 = snapshot.getPackageStates().entrySet().iterator();     // Catch: Throwable -> L31
    L11:
        if (r9.hasNext() == false) goto L37;
        PackageState packageState = r9.next().getValue();     // Catch: Throwable -> L31
        if (packageState.isApex() == false) goto L15;
        PackageManagerLocal.UnfilteredSnapshot snapshot2 = snapshot;
    L36:
        snapshot = snapshot2;
        goto L11
    L15:
        AndroidPackage androidPackage = packageState.getAndroidPackage();     // Catch: Throwable -> L31
        if (androidPackage != null) goto L18;
        snapshot2 = snapshot;
        goto L36
    L18:
        Iterable $this$forEach$iv = androidPackage.getRequestedPermissions();     // Catch: Throwable -> L31
        Iterator r16 = $this$forEach$iv.iterator();     // Catch: Throwable -> L31
    L20:
        if (r16.hasNext() == false) goto L35;
        Object element$iv = r16.next();     // Catch: Throwable -> L31
        String permissionName = (String) element$iv;     // Catch: Throwable -> L31
        Permission permission = r7.get(permissionName);     // Catch: Throwable -> L31
        if (permission != null) goto L24;
        PackageManagerLocal.UnfilteredSnapshot snapshot3 = snapshot;
    L34:
        snapshot = snapshot3;
        goto L20
    L24:
        snapshot3 = snapshot;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 64) == false) goto L34;
        Object r20 = appOpPermissionPackageNames.get(permissionName);     // Catch: Throwable -> L31
        if (r20 != null) goto L30;
        ArraySet r21 = new ArraySet();     // Catch: Throwable -> L31
        appOpPermissionPackageNames.put(permissionName, r21);     // Catch: Throwable -> L31
        r20 = r21;
    L30:
        ArraySet packageNames = (ArraySet) r20;     // Catch: Throwable -> L31
        packageNames.add(androidPackage.getPackageName());     // Catch: Throwable -> L31
        goto L34
    L35:
        snapshot2 = snapshot;
        goto L36
    L37:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L31
        AutoCloseableKt.closeFinally(r3, null);
        return appOpPermissionPackageNames;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        AutoCloseableKt.closeFinally(r3, th);
        throw th;
    }

    public byte[] backupRuntimePermissions(int userId) {
        Preconditions.checkArgumentNonnegative(userId, "userId cannot be null");
        final CompletableFuture backup = new CompletableFuture();
        PermissionControllerManager r1 = this.permissionControllerManager;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("permissionControllerManager");
        r1 = null;
    L5:
        r1.getRuntimePermissionBackup(UserHandle.of(userId), PermissionThread.getExecutor(), new AnonymousClass1(backup));
        return (byte[]) backup.get(BACKUP_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
    L8:
        e = move-exception;
        if ((e instanceof TimeoutException) == false) goto L12;
    L17:
        Slog.e(LOG_TAG, "Cannot create permission backup for user " + userId, e);
        return null;
    L12:
        if ((e instanceof InterruptedException) == true) goto L17;
        if ((e instanceof ExecutionException) == true) goto L17;
        throw e;
    }

    public void restoreRuntimePermissions(byte[] backup, int userId) {
        if (backup == null) goto L17;
        Preconditions.checkArgumentNonnegative(userId, "userId");
        SparseBooleanArray r0 = this.isDelayedPermissionBackupFinished;
        monitor-enter(r0);
        SparseBooleanArray $this$minusAssign$iv = this.isDelayedPermissionBackupFinished;     // Catch: Throwable -> L13
        $this$minusAssign$iv.delete(userId);     // Catch: Throwable -> L13
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        PermissionControllerManager r2 = this.permissionControllerManager;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("permissionControllerManager");
        r2 = null;
    L11:
        r2.stageAndApplyRuntimePermissionsBackup(backup, UserHandle.of(userId));
        return;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalArgumentException(HostingRecord.HOSTING_TYPE_BACKUP.toString());
    }

    public void restoreDelayedRuntimePermissions(String packageName, final int userId) {
        if (packageName == null) goto L22;
        Preconditions.checkArgumentNonnegative(userId, "userId");
        SparseBooleanArray r0 = this.isDelayedPermissionBackupFinished;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.isDelayedPermissionBackupFinished.get(userId, false) == false) goto L11;
        monitor-exit(r0);
        return;
    L11:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        PermissionControllerManager r2 = this.permissionControllerManager;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("permissionControllerManager");
        r2 = null;
    L16:
        r2.applyStagedRuntimePermissionBackup(packageName, UserHandle.of(userId), PermissionThread.getExecutor(), new AnonymousClass3(this, userId));
        return;
    L22:
        throw new IllegalArgumentException("packageName".toString());
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.context, LOG_TAG, pw) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter writer = new IndentingPrintWriter(pw, "  ");
        if (args != null) goto L8;
    L14:
        boolean r6 = true;
    L15:
        AccessState r7 = null;
        if (r6 == false) goto L18;
    L47:
        AccessCheckingService this_$iv = this.service;
        AccessState r9 = AccessCheckingService.access$getState$p(this_$iv);
        if (r9 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L51:
        GetStateScope $this$dump_u24lambda_u24142 = new GetStateScope(r7);
        dumpSystemState(writer, $this$dump_u24lambda_u24142.getState());
        IndexedMap<Integer, MutableIndexedSet<String>> r8 = getAllAppIdPackageNames($this$dump_u24lambda_u24142.getState());
        int index$iv = 0;
        int r11 = r8.getSize();
    L52:
        if (index$iv >= r11) goto L66;
        Integer r12 = r8.keyAt(index$iv);
        MutableIndexedSet<String> r13 = r8.valueAt(index$iv);
        int appId = r12.intValue();
        if (appId == (-1)) goto L56;
        dumpAppIdState(writer, appId, $this$dump_u24lambda_u24142.getState(), r13);
    L56:
        index$iv = index$iv + 1;
        goto L52
    L66:
        return;
    L50:
        r7 = r9;
        goto L51
    L18:
        if (Intrinsics.areEqual(args[0], "-a") == true) goto L47;
        if (Intrinsics.areEqual(args[0], "--app-id") == false) goto L34;
        if (args.length != 2) goto L34;
        int appId2 = Integer.parseInt(args[1]);
        AccessCheckingService this_$iv2 = this.service;
        AccessState r14 = AccessCheckingService.access$getState$p(this_$iv2);
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L28:
        GetStateScope $this$dump_u24lambda_u24143 = new GetStateScope(r7);
        IndexedMap<Integer, MutableIndexedSet<String>> r10 = getAllAppIdPackageNames($this$dump_u24lambda_u24143.getState());
        if (r10.contains(Integer.valueOf(appId2)) == false) goto L31;
        dumpAppIdState(writer, appId2, $this$dump_u24lambda_u24143.getState(), r10.get(Integer.valueOf(appId2)));
        return;
    L31:
        writer.println("Unknown app ID " + appId2 + ".");
        return;
    L27:
        r7 = r14;
    L34:
        if (Intrinsics.areEqual(args[0], "--package") == true) goto L36;
    L46:
        writer.println("Usage: dumpsys permissionmgr [--app-id <APP_ID>] [--package <PACKAGE_NAME>]");
        return;
    L36:
        if (args.length != 2) goto L46;
        String packageName = args[1];
        AccessCheckingService this_$iv3 = this.service;
        AccessState r15 = AccessCheckingService.access$getState$p(this_$iv3);
        if (r15 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L41:
        GetStateScope $this$dump_u24lambda_u24144 = new GetStateScope(r7);
        PackageState packageState = $this$dump_u24lambda_u24144.getState().getExternalState().getPackageStates().get(packageName);
        if (packageState == null) goto L44;
        dumpAppIdState(writer, packageState.getAppId(), $this$dump_u24lambda_u24144.getState(), IndexedSetExtensionsKt.indexedSetOf(new String[]{packageName}));
        return;
    L44:
        writer.println("Unknown package " + packageName + ".");
        return;
    L40:
        r7 = r15;
        goto L41
    L8:
        if (args.length != 0) goto L10;
        boolean r16 = true;
    L11:
        if (r16 == true) goto L14;
        r6 = false;
        goto L15
    L10:
        r16 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final IndexedMap<Integer, MutableIndexedSet<String>> getAllAppIdPackageNames(AccessState state) {
        MutableIndexedSet appIds = new MutableIndexedSet(null, 1, null);
        PackageManagerLocal r0 = this.packageManagerLocal;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerLocal");
        r0 = null;
    L5:
        PackageManagerLocal.UnfilteredSnapshot it = r0.withUnfilteredSnapshot();
        Map<String, PackageState> r7 = it.getPackageStates();     // Catch: Throwable -> L50
        AutoCloseableKt.closeFinally(it, null);
        IntReferenceMap<UserState, MutableUserState> r1 = state.getUserStates();
        int index$iv = 0;
        int r8 = r1.getSize();
    L8:
        if (index$iv >= r8) goto L29;
        r1.keyAt(index$iv);
        UserState userState = (UserState) r1.valueAt(index$iv);
        IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r11 = userState.getAppIdPermissionFlags();
        int index$iv2 = 0;
        int r14 = r11.getSize();
    L10:
        if (index$iv2 >= r14) goto L12;
        int appId = r11.keyAt(index$iv2);
        IndexedMap r16 = (IndexedMap) r11.valueAt(index$iv2);
        appIds.add(Integer.valueOf(appId));
        index$iv2 = index$iv2 + 1;
        goto L10
    L12:
        IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r2 = userState.getAppIdAppOpModes();
        int index$iv3 = 0;
        int r13 = r2.getSize();
    L13:
        if (index$iv3 >= r13) goto L15;
        int appId2 = r2.keyAt(index$iv3);
        IndexedMap r15 = (IndexedMap) r2.valueAt(index$iv3);
        appIds.add(Integer.valueOf(appId2));
        index$iv3 = index$iv3 + 1;
        goto L13
    L15:
        IndexedMap<String, Integer> r3 = userState.getPackageVersions();
        int index$iv4 = 0;
        int r12 = r3.getSize();
    L16:
        if (index$iv4 >= r12) goto L22;
        String r17 = r3.keyAt(index$iv4);
        r3.valueAt(index$iv4).intValue();
        String packageName = r17;
        PackageState r18 = r7.get(packageName);
        if (r18 == null) goto L21;
        int appId3 = r18.getAppId();
        appIds.add(Integer.valueOf(appId3));
    L21:
        index$iv4 = index$iv4 + 1;
        r1 = r1;
        goto L16
    L22:
        IntReferenceMap<UserState, MutableUserState> r19 = r1;
        IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r4 = userState.getPackageAppOpModes();
        int index$iv5 = 0;
        int r110 = r4.getSize();
    L23:
        if (index$iv5 >= r110) goto L28;
        String r111 = r4.keyAt(index$iv5);
        IndexedMap r112 = (IndexedMap) r4.valueAt(index$iv5);
        String packageName2 = r111;
        PackageState r113 = r7.get(packageName2);
        if (r113 == null) goto L27;
        int appId4 = r113.getAppId();
        appIds.add(Integer.valueOf(appId4));
    L27:
        index$iv5 = index$iv5 + 1;
        goto L23
    L28:
        index$iv = index$iv + 1;
        r1 = r19;
        goto L8
    L29:
        MutableIndexedMap appIdPackageNames = new MutableIndexedMap(null, 1, null);
        Iterator<Map.Entry<String, PackageState>> r5 = r7.entrySet().iterator();
    L31:
        if (r5.hasNext() == false) goto L41;
        PackageState packageState = r5.next().getValue();
        if (packageState.isApex() == false) goto L35;
        appIdPackageNames = appIdPackageNames;
    L40:
        appIdPackageNames = appIdPackageNames;
        goto L31
    L35:
        Integer r10 = Integer.valueOf(packageState.getAppId());
        MutableIndexedMap $this$getOrPut$iv = appIdPackageNames;
        Object r114 = $this$getOrPut$iv.get(r10);
        if (r114 != null) goto L39;
        MutableIndexedSet r115 = new MutableIndexedSet(null, 1, null);
        $this$getOrPut$iv.put(r10, r115);
        r114 = r115;
    L39:
        ((MutableIndexedSet) r114).add(packageState.getPackageName());
        goto L40
    L41:
        MutableIndexedMap appIdPackageNames2 = appIdPackageNames;
        int index$iv6 = 0;
        int r6 = appIds.getSize();
    L42:
        if (index$iv6 >= r6) goto L49;
        int appId5 = ((Number) appIds.elementAt(index$iv6)).intValue();
        Integer r9 = Integer.valueOf(appId5);
        if (appIdPackageNames2.get(r9) != 0) goto L47;
        appIdPackageNames2.put(r9, new MutableIndexedSet(null, 1, null));
    L47:
        index$iv6 = index$iv6 + 1;
        goto L42
    L49:
        return appIdPackageNames2;
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    private final void dumpSystemState(IndentingPrintWriter $this$dumpSystemState, AccessState state) {
        $this$dumpSystemState.println("Permissions:");
        IndentingPrintWriter $this$withIndent$iv = $this$dumpSystemState;
        PermissionService this_$iv = this;
        int $i$f$withIndent = 0;
        $this$withIndent$iv.increaseIndent();
        int r5 = 0;
        IndexedMap<String, Permission> r6 = state.getSystemState().getPermissions();
        int index$iv = 0;
        int r9 = r6.getSize();
    L4:
        if (index$iv >= r9) goto L6;
        String r11 = r6.keyAt(index$iv);
        Permission permission = r6.valueAt(index$iv);
        String protectionLevel = PermissionInfo.protectionToString(permission.getPermissionInfo().protectionLevel);
        IndentingPrintWriter $this$withIndent$iv2 = $this$withIndent$iv;
        String r1 = permission.getPermissionInfo().name;
        String r14 = Permission.Companion.typeToString(permission.getType());
        PermissionService this_$iv2 = this_$iv;
        String r2 = permission.getPermissionInfo().packageName;
        int r15 = permission.getAppId();
        int $i$f$withIndent2 = $i$f$withIndent;
        String r3 = Arrays.toString(permission.getGids());
        int r17 = r5;
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        $this$withIndent$iv.println(r1 + ": type=" + r14 + ", packageName=" + r2 + ", appId=" + r15 + ", gids=" + r3 + ", protectionLevel=[" + protectionLevel + "], flags=" + PermissionInfo.flagsToString(permission.getPermissionInfo().flags));
        index$iv = index$iv + 1;
        $this$withIndent$iv = $this$withIndent$iv2;
        r5 = r17;
        this_$iv = this_$iv2;
        $i$f$withIndent = $i$f$withIndent2;
        r6 = r6;
        goto L4
    L6:
        $this$withIndent$iv.decreaseIndent();
        $this$dumpSystemState.println("Permission groups:");
        IndentingPrintWriter $this$withIndent$iv3 = $this$dumpSystemState;
        $this$withIndent$iv3.increaseIndent();
        IndexedMap<String, PermissionGroupInfo> r7 = state.getSystemState().getPermissionGroups();
        int index$iv2 = 0;
        int r10 = r7.getSize();
    L8:
        if (index$iv2 >= r10) goto L10;
        String r12 = r7.keyAt(index$iv2);
        PermissionGroupInfo permissionGroup = r7.valueAt(index$iv2);
        $this$withIndent$iv3.println(permissionGroup.name + ": packageName=" + permissionGroup.packageName);
        index$iv2 = index$iv2 + 1;
        $this$withIndent$iv3 = $this$withIndent$iv3;
        goto L8
    L10:
        $this$withIndent$iv3.decreaseIndent();
        $this$dumpSystemState.println("Permission trees:");
        IndentingPrintWriter $this$withIndent$iv4 = $this$dumpSystemState;
        $this$withIndent$iv4.increaseIndent();
        IndexedMap<String, Permission> r8 = state.getSystemState().getPermissionTrees();
        int index$iv3 = 0;
        int r13 = r8.getSize();
    L11:
        if (index$iv3 >= r13) goto L13;
        String r16 = r8.keyAt(index$iv3);
        Permission permissionTree = r8.valueAt(index$iv3);
        IndentingPrintWriter $this$withIndent$iv5 = $this$withIndent$iv4;
        $this$withIndent$iv4.println(permissionTree.getPermissionInfo().name + ": packageName=" + permissionTree.getPermissionInfo().packageName + ", appId=" + permissionTree.getAppId());
        index$iv3 = index$iv3 + 1;
        $this$withIndent$iv4 = $this$withIndent$iv5;
        goto L11
    L13:
        $this$withIndent$iv4.decreaseIndent();
    }

    private final void dumpAppIdState(IndentingPrintWriter $this$dumpAppIdState, int appId, AccessState state, IndexedSet<String> r49) {
        int r0 = appId;
        $this$dumpAppIdState.println("App ID: " + r0);
        IndentingPrintWriter $this$withIndent$iv = $this$dumpAppIdState;
        PermissionService this_$iv = this;
        int $i$f$withIndent = 0;
        $this$withIndent$iv.increaseIndent();
        IndentingPrintWriter $this$dumpAppIdState_u24lambda_u24174 = $this$withIndent$iv;
        int r6 = 0;
        IntReferenceMap<UserState, MutableUserState> r7 = state.getUserStates();
        int index$iv = 0;
        int r10 = r7.getSize();
    L3:
        if (index$iv >= r10) goto L42;
        int userId = r7.keyAt(index$iv);
        UserState userState = (UserState) r7.valueAt(index$iv);
        $this$dumpAppIdState_u24lambda_u24174.println("User: " + userId);
        IndentingPrintWriter $this$withIndent$iv2 = $this$dumpAppIdState_u24lambda_u24174;
        $this$withIndent$iv2.increaseIndent();
        IndentingPrintWriter $this$withIndent$iv3 = $this$withIndent$iv;
        IndentingPrintWriter $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172 = $this$withIndent$iv2;
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.println("Permissions:");
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.increaseIndent();
        IndexedMap r1 = (IndexedMap) userState.getAppIdPermissionFlags().get(r0);
        PermissionService this_$iv2 = this_$iv;
        if (r1 == null) goto L10;
        IndexedMap $this$forEachIndexed$iv = r1;
        int $i$f$withIndent2 = $this$forEachIndexed$iv.getSize();
        int index$iv2 = 0;
    L7:
        if (index$iv2 >= $i$f$withIndent2) goto L9;
        int r27 = $i$f$withIndent2;
        IndexedMap $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
        Object r26 = $this$forEachIndexed$iv2.keyAt(index$iv2);
        int flags = ((Number) $this$forEachIndexed$iv2.valueAt(index$iv2)).intValue();
        String permissionName = (String) r26;
        int index$iv3 = index$iv2;
        boolean isGranted = PermissionFlags.INSTANCE.isPermissionGranted(flags);
        int r33 = r6;
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.println(permissionName + ": granted=" + isGranted + ", flags=" + PermissionFlags.INSTANCE.toString(flags));
        index$iv2 = index$iv3 + 1;
        $i$f$withIndent2 = r27;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
        r6 = r33;
        r7 = r7;
        goto L7
    L9:
        int r34 = r6;
        IntReferenceMap<UserState, MutableUserState> r35 = r7;
    L11:
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.decreaseIndent();
        IndexedReferenceMap $this$forEachIndexed$iv3 = (IndexedReferenceMap) userState.getAppIdDevicePermissionFlags().get(r0);
        if ($this$forEachIndexed$iv3 == null) goto L20;
        int $i$f$forEachIndexed = 0;
        int index$iv4 = 0;
        int r8 = $this$forEachIndexed$iv3.getSize();
    L14:
        if (index$iv4 >= r8) goto L20;
        Object r17 = $this$forEachIndexed$iv3.keyAt(index$iv4);
        IndexedMap devicePermissionFlags = (IndexedMap) $this$forEachIndexed$iv3.valueAt(index$iv4);
        IndexedReferenceMap $this$forEachIndexed$iv4 = $this$forEachIndexed$iv3;
        String deviceId = (String) r17;
        int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        StringBuilder r5 = new StringBuilder();
        int index$iv5 = index$iv4;
        r5.append("Permissions (Device ");
        r5.append(deviceId);
        r5.append("):");
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.println(r5.toString());
        PermissionService this_$iv3 = this;
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.increaseIndent();
        IndexedMap $this$forEachIndexed$iv5 = devicePermissionFlags;
        int r4 = $this$forEachIndexed$iv5.getSize();
        int index$iv6 = 0;
    L16:
        if (index$iv6 >= r4) goto L18;
        int r32 = r4;
        IndexedMap $this$forEachIndexed$iv6 = $this$forEachIndexed$iv5;
        Object r30 = $this$forEachIndexed$iv6.keyAt(index$iv6);
        int flags2 = ((Number) $this$forEachIndexed$iv6.valueAt(index$iv6)).intValue();
        int index$iv7 = index$iv6;
        String permissionName2 = (String) r30;
        PermissionService this_$iv4 = this_$iv3;
        boolean isGranted2 = PermissionFlags.INSTANCE.isPermissionGranted(flags2);
        int r40 = r8;
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.println(permissionName2 + ": granted=" + isGranted2 + ", flags=" + PermissionFlags.INSTANCE.toString(flags2));
        index$iv6 = index$iv7 + 1;
        r4 = r32;
        $this$forEachIndexed$iv5 = $this$forEachIndexed$iv6;
        this_$iv3 = this_$iv4;
        r8 = r40;
        goto L16
    L18:
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.decreaseIndent();
        index$iv4 = index$iv5 + 1;
        $this$forEachIndexed$iv3 = $this$forEachIndexed$iv4;
        $i$f$forEachIndexed = $i$f$forEachIndexed2;
        r8 = r8;
    L20:
        String r2 = "App ops:";
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.println("App ops:");
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.increaseIndent();
        IndexedMap $this$forEachIndexed$iv7 = (IndexedMap) userState.getAppIdAppOpModes().get(r0);
        String r3 = ": mode=";
        if ($this$forEachIndexed$iv7 == null) goto L27;
        int r9 = $this$forEachIndexed$iv7.getSize();
        int $i$f$withIndent3 = 0;
    L23:
        if ($i$f$withIndent3 >= r9) goto L27;
        Object r21 = $this$forEachIndexed$iv7.keyAt($i$f$withIndent3);
        int appOpMode = ((Number) $this$forEachIndexed$iv7.valueAt($i$f$withIndent3)).intValue();
        String appOpName = (String) r21;
        IndexedMap $this$forEachIndexed$iv8 = $this$forEachIndexed$iv7;
        String r11 = AppOpsManager.modeToName(appOpMode);
        int r31 = r9;
        StringBuilder r12 = new StringBuilder();
        int index$iv8 = $i$f$withIndent3;
        r12.append(appOpName);
        r12.append(": mode=");
        r12.append(r11);
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.println(r12.toString());
        $i$f$withIndent3 = index$iv8 + 1;
        $this$forEachIndexed$iv7 = $this$forEachIndexed$iv8;
        r9 = r31;
    L27:
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.decreaseIndent();
        if (r49 == null) goto L41;
        IndexedSet<String> r13 = r49;
        int $i$f$forEachIndexed3 = 0;
        int index$iv9 = 0;
        int r14 = r13.getSize();
    L30:
        if (index$iv9 >= r14) goto L41;
        String packageName = r13.elementAt(index$iv9);
        IndexedSet<String> r20 = r13;
        StringBuilder r15 = new StringBuilder();
        int $i$f$forEachIndexed4 = $i$f$forEachIndexed3;
        r15.append("Package: ");
        r15.append(packageName);
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172.println(r15.toString());
        IndentingPrintWriter $this$withIndent$iv4 = $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172;
        $this$withIndent$iv4.increaseIndent();
        IndentingPrintWriter $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24173 = $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172;
        $this$withIndent$iv4.println("version=" + userState.getPackageVersions().get(packageName));
        $this$withIndent$iv4.println(r2);
        $this$withIndent$iv4.increaseIndent();
        String r36 = r2;
        IndexedMap $this$forEachIndexed$iv9 = (IndexedMap) userState.getPackageAppOpModes().get(packageName);
        if ($this$forEachIndexed$iv9 == null) goto L37;
        int r16 = $this$forEachIndexed$iv9.getSize();
        int index$iv10 = 0;
    L34:
        if (index$iv10 >= r16) goto L36;
        Object r37 = $this$forEachIndexed$iv9.keyAt(index$iv10);
        int appOpMode2 = ((Number) $this$forEachIndexed$iv9.valueAt(index$iv10)).intValue();
        IndexedMap $this$forEachIndexed$iv10 = $this$forEachIndexed$iv9;
        String appOpName2 = (String) r37;
        int r42 = r16;
        String modeName = AppOpsManager.modeToName(appOpMode2);
        $this$withIndent$iv4.println(appOpName2 + r3 + modeName);
        index$iv10 = index$iv10 + 1;
        $this$forEachIndexed$iv9 = $this$forEachIndexed$iv10;
        r16 = r42;
        r3 = r3;
        goto L34
    L36:
        String r44 = r3;
    L38:
        $this$withIndent$iv4.decreaseIndent();
        $this$withIndent$iv4.decreaseIndent();
        index$iv9 = index$iv9 + 1;
        r13 = r20;
        $i$f$forEachIndexed3 = $i$f$forEachIndexed4;
        $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24172 = $this$dumpAppIdState_u24lambda_u24174_u24lambda_u24173_u24lambda_u24173;
        r2 = r36;
        r3 = r44;
        goto L30
    L37:
        r44 = r3;
    L41:
        $this$withIndent$iv2.decreaseIndent();
        index$iv = index$iv + 1;
        r0 = appId;
        $this$withIndent$iv = $this$withIndent$iv3;
        this_$iv = this_$iv2;
        $i$f$withIndent = $i$f$withIndent;
        $this$dumpAppIdState_u24lambda_u24174 = $this$dumpAppIdState_u24lambda_u24174;
        r6 = r34;
        r7 = r35;
        goto L3
    L10:
        r34 = r6;
        r35 = r7;
        goto L11
    L42:
        $this$withIndent$iv.decreaseIndent();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public com.android.server.pm.permission.Permission getPermissionTEMP(String permissionName) {
        AccessCheckingService this_$iv = this.service;
        AccessState r3 = AccessCheckingService.access$getState$p(this_$iv);
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r3 = null;
    L5:
        GetStateScope $this$getPermissionTEMP_u24lambda_u24176 = new GetStateScope(r3);
        AppIdPermissionPolicy $this$getPermissionTEMP_u24lambda_u24176_u24lambda_u24175 = this.policy;
        Permission permission = $this$getPermissionTEMP_u24lambda_u24176_u24lambda_u24175.getPermissions($this$getPermissionTEMP_u24lambda_u24176).get(permissionName);
        if (permission != null) goto L9;
        return null;
    L9:
        return new com.android.server.pm.permission.Permission(permission.getPermissionInfo(), permission.getType(), permission.isReconciled(), permission.getAppId(), permission.getGids(), permission.getAreGidsPerUser());
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<LegacyPermission> getLegacyPermissions() {
        AccessCheckingService this_$iv = this.service;
        AccessState r4 = AccessCheckingService.access$getState$p(this_$iv);
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r4 = null;
    L5:
        GetStateScope $this$getLegacyPermissions_u24lambda_u24178 = new GetStateScope(r4);
        AppIdPermissionPolicy $this$getLegacyPermissions_u24lambda_u24178_u24lambda_u24177 = this.policy;
        IndexedMap<String, Permission> r5 = $this$getLegacyPermissions_u24lambda_u24178_u24lambda_u24177.getPermissions($this$getLegacyPermissions_u24lambda_u24178);
        ArrayList r1 = new ArrayList();
        int $i$f$mapIndexedTo = 0;
        IndexedMap<String, Permission> r3 = r5;
        int index$iv$iv = 0;
        int r7 = r3.getSize();
    L6:
        if (index$iv$iv >= r7) goto L9;
        Object key$iv = r3.keyAt(index$iv$iv);
        Object value$iv = r3.valueAt(index$iv$iv);
        Permission permission = (Permission) value$iv;
        String r13 = (String) key$iv;
        PermissionInfo r15 = permission.getPermissionInfo();
        int r0 = permission.getType();
        int $i$f$mapIndexedTo2 = $i$f$mapIndexedTo;
        int $i$f$mapIndexedTo3 = permission.getAppId();
        IndexedMap<String, Permission> r17 = r3;
        r1.add(new LegacyPermission(r15, r0, $i$f$mapIndexedTo3, permission.getGids()));
        index$iv$iv = index$iv$iv + 1;
        $i$f$mapIndexedTo = $i$f$mapIndexedTo2;
        r3 = r17;
        goto L6
    L9:
        return r1;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        this.service.initialize();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        AccessCheckingService this_$iv = this.service;
        AccessState r3 = AccessCheckingService.access$getState$p(this_$iv);
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r3 = null;
    L5:
        GetStateScope $this$writeLegacyPermissionsTEMP_u24lambda_u24182 = new GetStateScope(r3);
        AppIdPermissionPolicy $this$writeLegacyPermissionsTEMP_u24lambda_u24182_u24lambda_u24180 = this.policy;
        legacyPermissionSettings.replacePermissions(toLegacyPermissions($this$writeLegacyPermissionsTEMP_u24lambda_u24182_u24lambda_u24180.getPermissions($this$writeLegacyPermissionsTEMP_u24lambda_u24182)));
        AppIdPermissionPolicy $this$writeLegacyPermissionsTEMP_u24lambda_u24182_u24lambda_u24181 = this.policy;
        legacyPermissionSettings.replacePermissionTrees(toLegacyPermissions($this$writeLegacyPermissionsTEMP_u24lambda_u24182_u24lambda_u24181.getPermissionTrees($this$writeLegacyPermissionsTEMP_u24lambda_u24182)));
    }

    private final List<LegacyPermission> toLegacyPermissions(IndexedMap<String, Permission> r19) {
        ArrayList r0 = new ArrayList();
        IndexedMap<String, Permission> r1 = r19;
        int $i$f$mapIndexedTo = 0;
        int index$iv$iv = 0;
        int r6 = r1.getSize();
    L3:
        if (index$iv$iv >= r6) goto L6;
        Object key$iv = r1.keyAt(index$iv$iv);
        Object value$iv = r1.valueAt(index$iv$iv);
        Permission permission = (Permission) value$iv;
        String r12 = (String) key$iv;
        int $i$f$mapIndexedTo2 = $i$f$mapIndexedTo;
        r0.add(new LegacyPermission(permission.getPermissionInfo(), permission.getType(), 0, EmptyArray.INT));
        index$iv$iv = index$iv$iv + 1;
        r1 = r1;
        $i$f$mapIndexedTo = $i$f$mapIndexedTo2;
        goto L3
    L6:
        return r0;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public LegacyPermissionState getLegacyPermissionState(int appId) {
        PermissionService r0 = this;
        LegacyPermissionState legacyState = new LegacyPermissionState();
        UserManagerService r2 = r0.userManagerService;
        AccessState r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerService");
        r2 = null;
    L5:
        int[] userIds = r2.getUserIdsIncludingPreCreated();
        AccessCheckingService this_$iv = r0.service;
        int $i$f$getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar = 0;
        AccessState r7 = AccessCheckingService.access$getState$p(this_$iv);
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L9:
        GetStateScope $this$getLegacyPermissionState_u24lambda_u24188 = new GetStateScope(r3);
        int r4 = 0;
        AppIdPermissionPolicy $this$getLegacyPermissionState_u24lambda_u24188_u24lambda_u24184 = r0.policy;
        IndexedMap<String, Permission> r8 = $this$getLegacyPermissionState_u24lambda_u24188_u24lambda_u24184.getPermissions($this$getLegacyPermissionState_u24lambda_u24188);
        int index$iv = 0;
        int r11 = userIds.length;
        int r13 = 0;
    L10:
        if (r13 >= r11) goto L28;
        int item$iv = userIds[r13];
        index$iv = index$iv + 1;
        AppIdPermissionPolicy $this$getLegacyPermissionState_u24lambda_u24188_u24lambda_u24187_u24lambda_u24185 = r0.policy;
        IndexedMap<String, Integer> r12 = $this$getLegacyPermissionState_u24lambda_u24188_u24lambda_u24187_u24lambda_u24185.getUidPermissionFlags($this$getLegacyPermissionState_u24lambda_u24188, appId, item$iv);
        if (r12 != null) goto L14;
        int r24 = r4;
        AccessCheckingService this_$iv2 = this_$iv;
        int $i$f$getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar2 = $i$f$getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar;
        GetStateScope $this$getLegacyPermissionState_u24lambda_u24189 = $this$getLegacyPermissionState_u24lambda_u24188;
    L26:
        r13 = r13 + 1;
        r0 = this;
        userIds = userIds;
        r4 = r24;
        $this$getLegacyPermissionState_u24lambda_u24188 = $this$getLegacyPermissionState_u24lambda_u24189;
        $i$f$getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar = $i$f$getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar2;
        this_$iv = this_$iv2;
        goto L10
    L14:
        IndexedMap<String, Integer> r17 = r12;
        int r1 = r17.getSize();
        int index$iv2 = 0;
    L15:
        if (index$iv2 >= r1) goto L25;
        int r19 = r1;
        IndexedMap<String, Integer> r5 = r17;
        String r18 = r5.keyAt(index$iv2);
        int flags = r5.valueAt(index$iv2).intValue();
        int index$iv3 = index$iv2;
        String permissionName = r18;
        Permission permission = r8.get(permissionName);
        if (permission == null) goto L24;
        boolean r6 = true;
        if (permission.getPermissionInfo().getProtection() == 1) goto L23;
        r6 = false;
    L23:
        LegacyPermissionState.PermissionState legacyPermissionState = new LegacyPermissionState.PermissionState(permissionName, r6, PermissionFlags.INSTANCE.isPermissionGranted(flags), PermissionFlags.INSTANCE.toApiFlags(flags));
        legacyState.putPermissionState(legacyPermissionState, item$iv);
    L24:
        index$iv2 = index$iv3 + 1;
        r1 = r19;
        r17 = r5;
        r4 = r4;
        $this$getLegacyPermissionState_u24lambda_u24188 = $this$getLegacyPermissionState_u24lambda_u24188;
        $i$f$getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar = $i$f$getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar;
        this_$iv = this_$iv;
        goto L15
    L25:
        r24 = r4;
        this_$iv2 = this_$iv;
        $i$f$getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar2 = $i$f$getState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar;
        $this$getLegacyPermissionState_u24lambda_u24189 = $this$getLegacyPermissionState_u24lambda_u24188;
        goto L26
    L28:
        return legacyState;
    L8:
        r3 = r7;
        goto L9
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionStateTEMP() {
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionStateTEMP() {
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String getDefaultPermissionGrantFingerprint(int userId) {
        AccessCheckingService this_$iv = this.service;
        AccessState r3 = AccessCheckingService.access$getState$p(this_$iv);
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r3 = null;
    L5:
        GetStateScope $this$getDefaultPermissionGrantFingerprint_u24lambda_u24189 = new GetStateScope(r3);
        Immutable r4 = $this$getDefaultPermissionGrantFingerprint_u24lambda_u24189.getState().getUserStates().get(userId);
        Intrinsics.checkNotNull(r4);
        return ((UserState) r4).getDefaultPermissionGrantFingerprint();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void setDefaultPermissionGrantFingerprint(String fingerprint, int userId) {
        AccessCheckingService this_$iv = this.service;
        Object r2 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r2);
        AccessState oldState$iv = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L8
        if (oldState$iv != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L8
        oldState$iv = null;
    L10:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L8
        MutateStateScope $this$setDefaultPermissionGrantFingerprint_u24lambda_u24190 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L8
        MutableUserState r5 = MutableAccessState.mutateUserState$default($this$setDefaultPermissionGrantFingerprint_u24lambda_u24190.getNewState(), userId, 0, 2, null);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L8
        r5.setDefaultPermissionGrantFingerprintPublic(fingerprint);     // Catch: Throwable -> L8
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L8
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L8
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L8
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L8
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r2);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onSystemReady() {
        this.service.onSystemReady$frameworks__base__services__permission__android_common__services_permission_pre_jarjar();
        this.virtualDeviceManagerInternal = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
        VirtualDeviceManagerInternal r0 = this.virtualDeviceManagerInternal;
        if (r0 == null) goto L19;
        Set<String> r1 = r0.getAllPersistentDeviceIds();
        if (r1 == null) goto L19;
        AccessCheckingService this_$iv = this.service;
        Object r4 = AccessCheckingService.access$getStateLock$p(this_$iv);
        monitor-enter(r4);
        AccessState oldState$iv = AccessCheckingService.access$getState$p(this_$iv);     // Catch: Throwable -> L12
        if (oldState$iv != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("state");     // Catch: Throwable -> L12
        oldState$iv = null;
    L14:
        MutableAccessState newState$iv = oldState$iv.toMutable();     // Catch: Throwable -> L12
        MutateStateScope $this$onSystemReady_u24lambda_u24193_u24lambda_u24192 = new MutateStateScope(oldState$iv, newState$iv);     // Catch: Throwable -> L12
        DevicePermissionPolicy $this$onSystemReady_u24lambda_u24193_u24lambda_u24192_u24lambda_u24191 = access$getDevicePolicy$p(this);     // Catch: Throwable -> L12
        $this$onSystemReady_u24lambda_u24193_u24lambda_u24192_u24lambda_u24191.trimDevicePermissionStates($this$onSystemReady_u24lambda_u24193_u24lambda_u24192, r1);     // Catch: Throwable -> L12
        AccessCheckingService.access$getPersistence$p(this_$iv).write(newState$iv);     // Catch: Throwable -> L12
        AccessCheckingService.access$setState$p(this_$iv, newState$iv);     // Catch: Throwable -> L12
        AccessPolicy $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv = AccessCheckingService.access$getPolicy$p(this_$iv);     // Catch: Throwable -> L12
        $this$mutateState_u24lambda_u2424_u24lambda_u2423$iv.onStateMutated(new GetStateScope(newState$iv));     // Catch: Throwable -> L12
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r4);
    L12:
        th = move-exception;
        throw th;
    L19:
        VirtualDeviceManagerInternal r2 = this.virtualDeviceManagerInternal;
        if (r2 == null) goto L22;
        r2.registerPersistentDeviceIdRemovedListener(new AnonymousClass2(this));
    L22:
        this.permissionControllerManager = new PermissionControllerManager(this.context, PermissionThread.getHandler());
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserCreated(int userId) {
        PackageManager.corkPackageInfoCache();
        this.service.onUserAdded$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(userId);     // Catch: Throwable -> L6
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L6
        PackageManager.uncorkPackageInfoCache();
        return;
    L6:
        th = move-exception;
        PackageManager.uncorkPackageInfoCache();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserRemoved(int userId) {
        this.service.onUserRemoved$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onStorageVolumeMounted(String volumeUuid, boolean fingerprintChanged) {
        Object r1 = this.storageVolumeLock;
        monitor-enter(r1);
        List<String> r3 = this.storageVolumePackageNames.remove(volumeUuid);     // Catch: Throwable -> L8
        if (r3 != null) goto L10;
        r3 = CollectionsKt.emptyList();     // Catch: Throwable -> L8
    L10:
        List<String> r0 = r3;
        this.mountedStorageVolumes.add(volumeUuid);     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r1);
        PackageManager.corkPackageInfoCache();
        this.service.onStorageVolumeMounted$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(volumeUuid, r0, fingerprintChanged);     // Catch: Throwable -> L16
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L16
        PackageManager.uncorkPackageInfoCache();
        return;
    L16:
        th = move-exception;
        PackageManager.uncorkPackageInfoCache();
        throw th;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageAdded(PackageState packageState, boolean isInstantApp, AndroidPackage oldPackage) {
        if (packageState.isApex() == false) goto L5;
        return;
    L5:
        Object r0 = this.storageVolumeLock;
        monitor-enter(r0);
        ArrayMap<String, List<String>> r2 = this.storageVolumePackageNames;     // Catch: Throwable -> L21
        String r3 = packageState.getVolumeUuid();     // Catch: Throwable -> L21
        Object it$iv = r2.get(r3);     // Catch: Throwable -> L21
        if (it$iv != null) goto L12;
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L21
        r2.put(r3, r6);     // Catch: Throwable -> L21
        it$iv = r6;
    L12:
        ((Collection) it$iv).add(packageState.getPackageName());     // Catch: Throwable -> L21
        if (this.mountedStorageVolumes.contains(packageState.getVolumeUuid()) == true) goto L17;
        monitor-exit(r0);
        return;
    L17:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r0);
        this.service.onPackageAdded$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(packageState.getPackageName());
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageRemoved(AndroidPackage androidPackage) {
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageInstalled(AndroidPackage androidPackage, int previousAppId, PermissionManagerServiceInternal.PackageInstalledParams params, int userId) {
        if (androidPackage.isApex() == false) goto L6;
        return;
    L6:
        if (params != PermissionManagerServiceInternal.PackageInstalledParams.DEFAULT) goto L8;
        return;
    L8:
        Object r3 = this.storageVolumeLock;
        monitor-enter(r3);
    L36:
        th = move-exception;
        throw th;
    L12:
        if (this.mountedStorageVolumes.contains(androidPackage.getVolumeUuid()) == true) goto L16;
        monitor-exit(r3);
        return;
    L16:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r3);
        int r6 = 0;
        if (userId != (-1)) goto L24;
        UserManagerService r4 = this.userManagerService;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerService");
        r4 = null;
    L23:
        int[] userIds = r4.getUserIdsIncludingPreCreated();
    L25:
        int[] $this$forEach$iv = userIds;
        int r9 = $this$forEach$iv.length;
        int r10 = 0;
    L26:
        if (r10 >= r9) goto L28;
        this.service.onPackageInstalled$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(androidPackage.getPackageName(), $this$forEach$iv[r10]);
        r10 = r10 + 1;
        goto L26
    L28:
        int[] $this$forEach$iv2 = userIds;
        int r11 = $this$forEach$iv2.length;
    L29:
        if (r6 >= r11) goto L35;
        int element$iv = $this$forEach$iv2[r6];
        PackageManagerInternal r13 = this.packageManagerInternal;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r13 = null;
    L33:
        PackageStateInternal packageState = r13.getPackageStateInternal(androidPackage.getPackageName());
        Intrinsics.checkNotNull(packageState);
        addAllowlistedRestrictedPermissionsUnchecked(androidPackage, packageState.getAppId(), params.getAllowlistedRestrictedPermissions(), element$iv);
        setRequestedPermissionStates(packageState, element$iv, params.getPermissionStates());
        r6 = r6 + 1;
        goto L29
    L35:
        return;
    L24:
        userIds = new int[]{userId};
        goto L25
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageUninstalled(String packageName, int appId, PackageState packageState, AndroidPackage androidPackage, List<? extends AndroidPackage> r16, int userId) {
        if (packageState.isApex() == false) goto L5;
        return;
    L5:
        int r2 = 0;
        PackageManagerInternal r3 = null;
        if (userId != (-1)) goto L11;
        UserManagerService r1 = this.userManagerService;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerService");
        r1 = null;
    L10:
        int[] userIds = r1.getUserIdsIncludingPreCreated();
    L12:
        int[] $this$forEach$iv = userIds;
        int r6 = $this$forEach$iv.length;
    L13:
        if (r2 >= r6) goto L15;
        int element$iv = $this$forEach$iv[r2];
        this.service.onPackageUninstalled$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(packageName, appId, element$iv);
        r2 = r2 + 1;
        goto L13
    L15:
        PackageManagerInternal r4 = this.packageManagerInternal;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
    L19:
        PackageStateInternal packageState2 = r3.getPackageStates().get(packageName);
        if (packageState2 != null) goto L24;
        this.service.onPackageRemoved$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(packageName, appId);
        return;
    L24:
        return;
    L18:
        r3 = r4;
        goto L19
    L11:
        userIds = new int[]{userId};
        goto L12
    }

    private final boolean isRootOrSystemUid(int uid) {
        switch(UserHandle.getAppId(uid)) {
            case 0: goto L5;
            case 1000: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        return true;
    }

    private final boolean isShellUid(int uid) {
        if (UserHandle.getAppId(uid) != 2000) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isRootOrSystemOrShellUid(int uid) {
        if (isRootOrSystemUid(uid) == false) goto L5;
    L8:
        return true;
    L5:
        if (isShellUid(uid) == true) goto L8;
        return false;
    }

    private final void killUid(int uid, String reason) {
        IActivityManager activityManager = ActivityManager.getService();
        if (activityManager == null) goto L15;
        int appId = UserHandle.getAppId(uid);
        int userId = UserHandle.getUserId(uid);
        long token$iv = Binder.clearCallingIdentity();
        activityManager.killUidForPermissionChange(appId, userId, reason);     // Catch: Throwable -> L7 RemoteException -> L9
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(token$iv);
        throw th;
    L11:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(token$iv);
        return;
    }

    private final PackageManagerLocal.FilteredSnapshot withFilteredSnapshot(PackageManagerLocal $this$withFilteredSnapshot, int callingUid, int userId) {
        return $this$withFilteredSnapshot.withFilteredSnapshot(callingUid, UserHandle.of(userId));
    }

    private final PackageState getPackageState(PackageManagerLocal.UnfilteredSnapshot $this$getPackageState, String packageName) {
        return $this$getPackageState.getPackageStates().get(packageName);
    }

    private final boolean isUidInstantApp(PackageManagerLocal.UnfilteredSnapshot $this$isUidInstantApp, int uid) {
        PackageManagerInternal r0 = this.packageManagerInternal;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("packageManagerInternal");
        r0 = null;
    L6:
        if (r0.getInstantAppPackageName(uid) == null) goto L8;
        return true;
    L8:
        return false;
    }

    private final boolean isPackageVisibleToUid(PackageManagerLocal.UnfilteredSnapshot $this$isPackageVisibleToUid, String packageName, int uid) {
        return isPackageVisibleToUid($this$isPackageVisibleToUid, packageName, UserHandle.getUserId(uid), uid);
    }

    private final boolean isPackageVisibleToUid(PackageManagerLocal.UnfilteredSnapshot $this$isPackageVisibleToUid, String packageName, int userId, int uid) {
        PackageManagerLocal.FilteredSnapshot it = filtered($this$isPackageVisibleToUid, uid, userId);
        if (it.getPackageState(packageName) == null) goto L6;
        boolean r3 = true;
    L7:
        AutoCloseableKt.closeFinally(it, null);
        return r3;
    L6:
        r3 = false;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        AutoCloseableKt.closeFinally(it, th);
        throw th;
    }

    private final PackageManagerLocal.FilteredSnapshot filtered(PackageManagerLocal.UnfilteredSnapshot $this$filtered, int callingUid, int userId) {
        return $this$filtered.filtered(callingUid, UserHandle.of(userId));
    }

    private final void enforceCallingOrSelfCrossUserPermission(int userId, boolean enforceFullPermission, boolean enforceShellRestriction, String message) {
        if (userId < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L33;
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        if (userId == callingUserId) goto L18;
        if (enforceFullPermission == false) goto L10;
        String permissionName = "android.permission.INTERACT_ACROSS_USERS_FULL";
    L12:
        if (this.context.checkCallingOrSelfPermission(permissionName) == 0) goto L18;
        StringBuilder $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206 = new StringBuilder();
        if (message == null) goto L16;
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206.append(message);
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206.append(": ");
    L16:
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206.append("Neither user ");
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206.append(callingUid);
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206.append(" nor current process has ");
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206.append(permissionName);
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206.append(" to access user ");
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206.append(userId);
        String exceptionMessage = $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24206.toString();
        throw new SecurityException(exceptionMessage);
    L10:
        permissionName = "android.permission.INTERACT_ACROSS_USERS";
    L18:
        if (enforceShellRestriction == true) goto L20;
        return;
    L20:
        if (isShellUid(callingUid) == false) goto L34;
        UserManagerInternal r3 = this.userManagerInternal;
        if (r3 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("userManagerInternal");
        r3 = null;
    L24:
        boolean isShellRestricted = r3.hasUserRestriction("no_debugging_features", userId);
        if (isShellRestricted == false) goto L35;
        StringBuilder $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24207 = new StringBuilder();
        if (message == null) goto L29;
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24207.append(message);
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24207.append(": ");
    L29:
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24207.append("Shell is disallowed to access user ");
        $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24207.append(userId);
        String exceptionMessage2 = $this$enforceCallingOrSelfCrossUserPermission_u24lambda_u24207.toString();
        throw new SecurityException(exceptionMessage2);
    L35:
        return;
    L34:
        return;
    L33:
        throw new IllegalArgumentException(("userId " + userId + " is invalid").toString());
    L4:
        r0 = false;
        goto L5
    }

    private final void enforceCallingOrSelfAnyPermission(String message, String... permissionNames) {
        int r3 = permissionNames.length;
        boolean hasAnyPermission = false;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L14;
        if (this.context.checkCallingOrSelfPermission(permissionNames[r5]) != 0) goto L7;
        boolean r10 = true;
    L9:
        if (r10 == true) goto L10;
        r5 = r5 + 1;
        goto L3
    L10:
        hasAnyPermission = true;
        goto L14
    L7:
        r10 = false;
    L14:
        if (hasAnyPermission == true) goto L20;
        StringBuilder $this$enforceCallingOrSelfAnyPermission_u24lambda_u24209 = new StringBuilder();
        if (message == null) goto L18;
        $this$enforceCallingOrSelfAnyPermission_u24lambda_u24209.append(message);
        $this$enforceCallingOrSelfAnyPermission_u24lambda_u24209.append(": ");
    L18:
        $this$enforceCallingOrSelfAnyPermission_u24lambda_u24209.append("Neither user ");
        $this$enforceCallingOrSelfAnyPermission_u24lambda_u24209.append(Binder.getCallingUid());
        $this$enforceCallingOrSelfAnyPermission_u24lambda_u24209.append(" nor current process has any of ");
        ArraysKt.joinTo$default(permissionNames, $this$enforceCallingOrSelfAnyPermission_u24lambda_u24209, ", ", null, null, 0, null, null, 124, null);
        String exceptionMessage = $this$enforceCallingOrSelfAnyPermission_u24lambda_u24209.toString();
        throw new SecurityException(exceptionMessage);
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = PermissionService.class.getSimpleName();
        BACKGROUND_RATIONALE_CHANGE_ID = 147316723;
        ArrayMap<String, String> r0 = new ArrayMap();
        r0.put("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
        r0.put("android.permission.INTERACT_ACROSS_USERS", "android.permission.INTERACT_ACROSS_USERS_FULL");
        FULLER_PERMISSIONS = r0;
        NOTIFICATIONS_PERMISSIONS = ArraySetExtensionsKt.arraySetOf(new String[]{"android.permission.POST_NOTIFICATIONS"});
        BACKUP_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    }
}
