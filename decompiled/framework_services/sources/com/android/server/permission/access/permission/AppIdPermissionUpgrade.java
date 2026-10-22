package com.android.server.permission.access.permission;

import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.permission.access.GetStateScope;
import com.android.server.permission.access.MutateStateScope;
import com.android.server.permission.access.immutable.IndexedSet;
import com.android.server.permission.access.immutable.IndexedSetExtensionsKt;
import com.android.server.permission.access.util.IntExtensionsKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: AppIdPermissionUpgrade.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIdPermissionUpgrade {
    private static final IndexedSet<String> AURAL_VISUAL_MEDIA_PERMISSIONS = null;
    public static final Companion Companion = null;
    private static final IndexedSet<String> LEGACY_RESTRICTED_PERMISSIONS = null;
    private static final String LOG_TAG = null;
    private static final IndexedSet<String> STORAGE_PERMISSIONS = null;
    private static final IndexedSet<String> VISUAL_MEDIA_PERMISSIONS = null;
    private final AppIdPermissionPolicy policy;

    /* JADX INFO: compiled from: AppIdPermissionUpgrade.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public AppIdPermissionUpgrade(AppIdPermissionPolicy policy) {
        this.policy = policy;
    }

    public final void upgradePackageState(MutateStateScope $this$upgradePackageState, PackageState packageState, int userId, int version) {
        String packageName = packageState.getPackageName();
        if (version > 3) goto L6;
        Slog.v(LOG_TAG, "Allowlisting and upgrading background location permission for package: " + packageName + ", version: " + version + ", user:" + userId);
        allowlistRestrictedPermissions($this$upgradePackageState, packageState, userId);
        upgradeBackgroundLocationPermission($this$upgradePackageState, packageState, userId);
    L6:
        if (version > 10) goto L9;
        Slog.v(LOG_TAG, "Upgrading access media location permission for package: " + packageName + ", version: " + version + ", user: " + userId);
        upgradeAccessMediaLocationPermission($this$upgradePackageState, packageState, userId);
    L9:
        if (version > 12) goto L12;
        Slog.v(LOG_TAG, "Upgrading scoped media and body sensor permissions for package: " + packageName + ", version: " + version + ", user: " + userId);
        upgradeAuralVisualMediaPermissions($this$upgradePackageState, packageState, userId);
        upgradeBodySensorBackgroundPermissions($this$upgradePackageState, packageState, userId);
    L12:
        if (version > 14) goto L15;
        Slog.v(LOG_TAG, "Upgrading visual media permission for package: " + packageName + ", version: " + version + ", user: " + userId);
        upgradeUserSelectedVisualMediaPermission($this$upgradePackageState, packageState, userId);
    L15:
        if (version > 16) goto L18;
        Slog.v(LOG_TAG, "Upgrading body sensor / read heart rate permissions for package: " + packageName + ", version: " + version + ", user: " + userId);
        upgradeBodySensorReadHeartRatePermissions($this$upgradePackageState, packageState, userId);
        return;
    }

    private final void allowlistRestrictedPermissions(MutateStateScope $this$allowlistRestrictedPermissions, PackageState packageState, int userId) {
        AndroidPackage r0 = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(r0);
        Iterable $this$forEach$iv = r0.getRequestedPermissions();
        Iterator r2 = $this$forEach$iv.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Object element$iv = r2.next();
        String permissionName = (String) element$iv;
        if (LEGACY_RESTRICTED_PERMISSIONS.contains(permissionName) == false) goto L4;
        AppIdPermissionPolicy $this$allowlistRestrictedPermissions_u24lambda_u241_u24lambda_u240 = this.policy;
        $this$allowlistRestrictedPermissions_u24lambda_u241_u24lambda_u240.updatePermissionFlags($this$allowlistRestrictedPermissions, packageState.getAppId(), userId, permissionName, 131072, 131072);
        goto L4
    }

    private final void upgradeBackgroundLocationPermission(MutateStateScope $this$upgradeBackgroundLocationPermission, PackageState packageState, int userId) {
        AndroidPackage r0 = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(r0);
        if (r0.getRequestedPermissions().contains("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L15;
        int appId = packageState.getAppId();
        AppIdPermissionPolicy $this$upgradeBackgroundLocationPermission_u24lambda_u242 = this.policy;
        int accessFineLocationFlags = $this$upgradeBackgroundLocationPermission_u24lambda_u242.getPermissionFlags($this$upgradeBackgroundLocationPermission, appId, userId, "android.permission.ACCESS_FINE_LOCATION");
        AppIdPermissionPolicy $this$upgradeBackgroundLocationPermission_u24lambda_u243 = this.policy;
        int accessCoarseLocationFlags = $this$upgradeBackgroundLocationPermission_u24lambda_u243.getPermissionFlags($this$upgradeBackgroundLocationPermission, appId, userId, "android.permission.ACCESS_COARSE_LOCATION");
        if (PermissionFlags.INSTANCE.isAppOpGranted(accessFineLocationFlags) == false) goto L7;
    L10:
        boolean isForegroundLocationGranted = true;
    L12:
        if (isForegroundLocationGranted == false) goto L16;
        grantRuntimePermission($this$upgradeBackgroundLocationPermission, packageState, userId, "android.permission.ACCESS_BACKGROUND_LOCATION");
        return;
    L16:
        return;
    L7:
        if (PermissionFlags.INSTANCE.isAppOpGranted(accessCoarseLocationFlags) == true) goto L10;
        isForegroundLocationGranted = false;
        goto L12
    }

    private final void upgradeAccessMediaLocationPermission(MutateStateScope $this$upgradeAccessMediaLocationPermission, PackageState packageState, int userId) {
        AndroidPackage r0 = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(r0);
        if (r0.getRequestedPermissions().contains("android.permission.ACCESS_MEDIA_LOCATION") == false) goto L8;
        AppIdPermissionPolicy $this$upgradeAccessMediaLocationPermission_u24lambda_u244 = this.policy;
        int flags = $this$upgradeAccessMediaLocationPermission_u24lambda_u244.getPermissionFlags($this$upgradeAccessMediaLocationPermission, packageState.getAppId(), userId, "android.permission.READ_EXTERNAL_STORAGE");
        if (PermissionFlags.INSTANCE.isAppOpGranted(flags) == false) goto L9;
        grantRuntimePermission($this$upgradeAccessMediaLocationPermission, packageState, userId, "android.permission.ACCESS_MEDIA_LOCATION");
        return;
    L9:
        return;
    }

    private final void upgradeAuralVisualMediaPermissions(MutateStateScope $this$upgradeAuralVisualMediaPermissions, PackageState packageState, int userId) {
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(androidPackage);
        if (androidPackage.getTargetSdkVersion() >= 33) goto L5;
        return;
    L5:
        Set requestedPermissionNames = androidPackage.getRequestedPermissions();
        IndexedSet<String> r5 = STORAGE_PERMISSIONS;
        int index$iv$iv = 0;
        int r10 = r5.getSize();
    L6:
        if (index$iv$iv >= r10) goto L19;
        Object element$iv = r5.elementAt(index$iv$iv);
        String permissionName = (String) element$iv;
        if (requestedPermissionNames.contains(permissionName) == true) goto L10;
        AndroidPackage androidPackage2 = androidPackage;
        boolean r11 = false;
    L16:
        if (r11 == true) goto L17;
        index$iv$iv = index$iv$iv + 1;
        androidPackage = androidPackage2;
        goto L6
    L17:
        boolean isStorageUserGranted = true;
    L21:
        if (isStorageUserGranted == false) goto L31;
        IndexedSet<String> r3 = AURAL_VISUAL_MEDIA_PERMISSIONS;
        int index$iv = 0;
        int r7 = r3.getSize();
    L23:
        if (index$iv >= r7) goto L37;
        String permissionName2 = r3.elementAt(index$iv);
        if (requestedPermissionNames.contains(permissionName2) == false) goto L28;
        grantRuntimePermission($this$upgradeAuralVisualMediaPermissions, packageState, userId, permissionName2);
    L28:
        index$iv = index$iv + 1;
        goto L23
    L37:
        return;
    L31:
        return;
    L10:
        AppIdPermissionPolicy $this$upgradeAuralVisualMediaPermissions_u24lambda_u246_u24lambda_u245 = this.policy;
        androidPackage2 = androidPackage;
        int flags = $this$upgradeAuralVisualMediaPermissions_u24lambda_u246_u24lambda_u245.getPermissionFlags($this$upgradeAuralVisualMediaPermissions, packageState.getAppId(), userId, permissionName);
        if (PermissionFlags.INSTANCE.isAppOpGranted(flags) == true) goto L13;
    L15:
        r11 = false;
        goto L16
    L13:
        if (IntExtensionsKt.hasBits(flags, 32) == false) goto L15;
        r11 = true;
        goto L16
    L19:
        isStorageUserGranted = false;
        goto L21
    }

    private final void upgradeBodySensorBackgroundPermissions(MutateStateScope $this$upgradeBodySensorBackgroundPermissions, PackageState packageState, int userId) {
        AndroidPackage r0 = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(r0);
        if (r0.getRequestedPermissions().contains("android.permission.BODY_SENSORS_BACKGROUND") == true) goto L5;
        return;
    L5:
        int appId = packageState.getAppId();
        AppIdPermissionPolicy $this$upgradeBodySensorBackgroundPermissions_u24lambda_u248 = this.policy;
        int backgroundBodySensorsFlags = $this$upgradeBodySensorBackgroundPermissions_u24lambda_u248.getPermissionFlags($this$upgradeBodySensorBackgroundPermissions, appId, userId, "android.permission.BODY_SENSORS_BACKGROUND");
        if (IntExtensionsKt.hasAnyBit(backgroundBodySensorsFlags, 229376) == false) goto L8;
        return;
    L8:
        AppIdPermissionPolicy $this$upgradeBodySensorBackgroundPermissions_u24lambda_u249 = this.policy;
        $this$upgradeBodySensorBackgroundPermissions_u24lambda_u249.updatePermissionFlags($this$upgradeBodySensorBackgroundPermissions, appId, userId, "android.permission.BODY_SENSORS_BACKGROUND", 131072, 131072);
        AppIdPermissionPolicy $this$upgradeBodySensorBackgroundPermissions_u24lambda_u2410 = this.policy;
        int bodySensorsFlags = $this$upgradeBodySensorBackgroundPermissions_u24lambda_u2410.getPermissionFlags($this$upgradeBodySensorBackgroundPermissions, appId, userId, "android.permission.BODY_SENSORS");
        boolean isForegroundBodySensorsGranted = PermissionFlags.INSTANCE.isAppOpGranted(bodySensorsFlags);
        if (isForegroundBodySensorsGranted == false) goto L12;
        grantRuntimePermission($this$upgradeBodySensorBackgroundPermissions, packageState, userId, "android.permission.BODY_SENSORS_BACKGROUND");
        return;
    }

    private final void upgradeUserSelectedVisualMediaPermission(MutateStateScope $this$upgradeUserSelectedVisualMediaPermission, PackageState packageState, int userId) {
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(androidPackage);
        if (androidPackage.getTargetSdkVersion() >= 33) goto L5;
        return;
    L5:
        Set requestedPermissionNames = androidPackage.getRequestedPermissions();
        IndexedSet<String> r5 = VISUAL_MEDIA_PERMISSIONS;
        int index$iv$iv = 0;
        int r10 = r5.getSize();
    L6:
        if (index$iv$iv >= r10) goto L19;
        Object element$iv = r5.elementAt(index$iv$iv);
        String permissionName = (String) element$iv;
        if (requestedPermissionNames.contains(permissionName) == true) goto L10;
        AndroidPackage androidPackage2 = androidPackage;
        boolean r11 = false;
    L16:
        if (r11 == true) goto L17;
        index$iv$iv = index$iv$iv + 1;
        androidPackage = androidPackage2;
        goto L6
    L17:
        boolean isVisualMediaUserGranted = true;
    L21:
        if (isVisualMediaUserGranted == false) goto L27;
        if (requestedPermissionNames.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L31;
        grantRuntimePermission($this$upgradeUserSelectedVisualMediaPermission, packageState, userId, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
        return;
    L31:
        return;
    L27:
        return;
    L10:
        AppIdPermissionPolicy $this$upgradeUserSelectedVisualMediaPermission_u24lambda_u2412_u24lambda_u2411 = this.policy;
        androidPackage2 = androidPackage;
        int flags = $this$upgradeUserSelectedVisualMediaPermission_u24lambda_u2412_u24lambda_u2411.getPermissionFlags($this$upgradeUserSelectedVisualMediaPermission, packageState.getAppId(), userId, permissionName);
        if (PermissionFlags.INSTANCE.isAppOpGranted(flags) == true) goto L13;
    L15:
        r11 = false;
        goto L16
    L13:
        if (IntExtensionsKt.hasBits(flags, 32) == false) goto L15;
        r11 = true;
        goto L16
    L19:
        isVisualMediaUserGranted = false;
        goto L21
    }

    private final void upgradeBodySensorReadHeartRatePermissions(MutateStateScope $this$upgradeBodySensorReadHeartRatePermissions, PackageState packageState, int userId) {
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(androidPackage);
        if (androidPackage.getTargetSdkVersion() < 36) goto L5;
        return;
    L5:
        boolean isBodySensorsRequested = androidPackage.getRequestedPermissions().contains("android.permission.BODY_SENSORS");
        boolean isReadHeartRateRequested = androidPackage.getRequestedPermissions().contains("android.permission.health.READ_HEART_RATE");
        boolean isBodySensorsGranted = isRuntimePermissionGranted($this$upgradeBodySensorReadHeartRatePermissions, packageState, userId, "android.permission.BODY_SENSORS");
        if (isBodySensorsRequested == false) goto L16;
        if (isReadHeartRateRequested == false) goto L16;
        boolean isReadHeartRateGranted = isRuntimePermissionGranted($this$upgradeBodySensorReadHeartRatePermissions, packageState, userId, "android.permission.health.READ_HEART_RATE");
        if (isBodySensorsGranted == isReadHeartRateGranted) goto L16;
        if (isBodySensorsGranted == true) goto L12;
    L14:
        if (isReadHeartRateGranted == false) goto L16;
        revokeRuntimePermission($this$upgradeBodySensorReadHeartRatePermissions, packageState, userId, "android.permission.health.READ_HEART_RATE");
        goto L16
    L12:
        if (revokeRuntimePermission($this$upgradeBodySensorReadHeartRatePermissions, packageState, userId, "android.permission.BODY_SENSORS") == false) goto L14;
        isBodySensorsGranted = false;
    L16:
        boolean isBodySensorsBackgroundGranted = isRuntimePermissionGranted($this$upgradeBodySensorReadHeartRatePermissions, packageState, userId, "android.permission.BODY_SENSORS_BACKGROUND");
        if (isBodySensorsGranted == true) goto L22;
        if (isBodySensorsBackgroundGranted == false) goto L22;
        if (revokeRuntimePermission($this$upgradeBodySensorReadHeartRatePermissions, packageState, userId, "android.permission.BODY_SENSORS_BACKGROUND") == false) goto L22;
        isBodySensorsBackgroundGranted = false;
    L22:
        boolean isBodySensorsBackgroundRequested = androidPackage.getRequestedPermissions().contains("android.permission.BODY_SENSORS_BACKGROUND");
        boolean isReadHealthDataInBackgroundRequested = androidPackage.getRequestedPermissions().contains("android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND");
        if (isBodySensorsBackgroundRequested == false) goto L32;
        if (isReadHealthDataInBackgroundRequested == false) goto L33;
        boolean isReadHealthDataInBackgroundGranted = isRuntimePermissionGranted($this$upgradeBodySensorReadHeartRatePermissions, packageState, userId, "android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND");
        if (isBodySensorsBackgroundGranted == isReadHealthDataInBackgroundGranted) goto L34;
        if (isBodySensorsBackgroundGranted == false) goto L29;
        revokeRuntimePermission($this$upgradeBodySensorReadHeartRatePermissions, packageState, userId, "android.permission.BODY_SENSORS_BACKGROUND");
    L29:
        if (isReadHealthDataInBackgroundGranted == false) goto L35;
        revokeRuntimePermission($this$upgradeBodySensorReadHeartRatePermissions, packageState, userId, "android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND");
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    }

    private final boolean isRuntimePermissionGranted(GetStateScope $this$isRuntimePermissionGranted, PackageState packageState, int userId, String permissionName) {
        AppIdPermissionPolicy $this$isRuntimePermissionGranted_u24lambda_u2413 = this.policy;
        int permissionFlags = $this$isRuntimePermissionGranted_u24lambda_u2413.getPermissionFlags($this$isRuntimePermissionGranted, packageState.getAppId(), userId, permissionName);
        return PermissionFlags.INSTANCE.isAppOpGranted(permissionFlags);
    }

    private final void grantRuntimePermission(MutateStateScope $this$grantRuntimePermission, PackageState packageState, int userId, String permissionName) {
        Slog.v(LOG_TAG, "Granting runtime permission for package: " + packageState.getPackageName() + ", permission: " + permissionName + ", userId: " + userId);
        Permission r0 = $this$grantRuntimePermission.getNewState().getSystemState().getPermissions().get(permissionName);
        Intrinsics.checkNotNull(r0);
        Permission permission = r0;
        if (packageState.getUserStateOrDefault(userId).isInstantApp() == true) goto L5;
    L7:
        int appId = packageState.getAppId();
        AppIdPermissionPolicy $this$grantRuntimePermission_u24lambda_u2414 = this.policy;
        int flags = $this$grantRuntimePermission_u24lambda_u2414.getPermissionFlags($this$grantRuntimePermission, appId, userId, permissionName);
        if (IntExtensionsKt.hasAnyBit(flags, 2097632) == false) goto L11;
        Slog.v(LOG_TAG, "Not allowed to grant " + permissionName + " to package " + packageState.getPackageName());
        return;
    L11:
        int flags2 = IntExtensionsKt.andInv(flags | 16, 7345152);
        AppIdPermissionPolicy $this$grantRuntimePermission_u24lambda_u2415 = this.policy;
        $this$grantRuntimePermission_u24lambda_u2415.setPermissionFlags($this$grantRuntimePermission, appId, userId, permissionName, flags2);
        return;
    L5:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 4096) == true) goto L7;
    }

    private final boolean revokeRuntimePermission(MutateStateScope $this$revokeRuntimePermission, PackageState packageState, int userId, String permissionName) {
        Slog.v(LOG_TAG, "Revoking runtime permission for package: " + packageState.getPackageName() + ", permission: " + permissionName + ", userId: " + userId);
        int appId = packageState.getAppId();
        AppIdPermissionPolicy $this$revokeRuntimePermission_u24lambda_u2416 = this.policy;
        int flags = $this$revokeRuntimePermission_u24lambda_u2416.getPermissionFlags($this$revokeRuntimePermission, appId, userId, permissionName);
        if (IntExtensionsKt.hasAnyBit(flags, FrameworkStatsLog.NON_A11Y_TOOL_SERVICE_WARNING_REPORT) == false) goto L6;
        Slog.v(LOG_TAG, "Cannot revoke fixed runtime permission from package: " + packageState.getPackageName() + ", permission: " + permissionName + ", userId: " + userId);
        return false;
    L6:
        int flags2 = IntExtensionsKt.andInv(flags, 15729272);
        AppIdPermissionPolicy $this$revokeRuntimePermission_u24lambda_u2417 = this.policy;
        $this$revokeRuntimePermission_u24lambda_u2417.setPermissionFlags($this$revokeRuntimePermission, appId, userId, permissionName, flags2);
        return true;
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = AppIdPermissionUpgrade.class.getSimpleName();
        LEGACY_RESTRICTED_PERMISSIONS = IndexedSetExtensionsKt.indexedSetOf(new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS", "android.permission.READ_CELL_BROADCASTS", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "android.permission.PROCESS_OUTGOING_CALLS"});
        STORAGE_PERMISSIONS = IndexedSetExtensionsKt.indexedSetOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
        AURAL_VISUAL_MEDIA_PERMISSIONS = IndexedSetExtensionsKt.indexedSetOf(new String[]{"android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.ACCESS_MEDIA_LOCATION", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"});
        VISUAL_MEDIA_PERMISSIONS = IndexedSetExtensionsKt.indexedSetOf(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.ACCESS_MEDIA_LOCATION"});
    }
}
