package com.android.server.companion.utils;

import android.companion.AssociationRequest;
import android.content.Context;
import android.os.Binder;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.android.internal.app.IAppOpsService;
import com.android.server.slice.SliceClientPermissions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionsUtils {
    private static final Map<String, String> DEVICE_PROFILE_TO_PERMISSION = null;
    private static final Set<String> SYSTEM_ONLY_DEVICE_PROFILES = null;
    private static IAppOpsService sAppOpsService;

    public static /* synthetic */ Boolean $r8$lambda$kjl392eA0MpvY98_k9mTV7k0nV0(Context r0, int r1, String r2) {
        return lambda$hasRequirePermissions$0(r0, r1, r2);
    }

    static {
        Set<String> set = new ArraySet();
        set.add("android.companion.COMPANION_DEVICE_WEARABLE_SENSING");
        SYSTEM_ONLY_DEVICE_PROFILES = Collections.unmodifiableSet(set);
        Map<String, String> map = new ArrayMap();
        map.put("android.app.role.COMPANION_DEVICE_WATCH", "android.permission.REQUEST_COMPANION_PROFILE_WATCH");
        map.put("android.app.role.COMPANION_DEVICE_APP_STREAMING", "android.permission.REQUEST_COMPANION_PROFILE_APP_STREAMING");
        map.put("android.app.role.SYSTEM_AUTOMOTIVE_PROJECTION", "android.permission.REQUEST_COMPANION_PROFILE_AUTOMOTIVE_PROJECTION");
        map.put("android.app.role.COMPANION_DEVICE_COMPUTER", "android.permission.REQUEST_COMPANION_PROFILE_COMPUTER");
        map.put("android.app.role.COMPANION_DEVICE_GLASSES", "android.permission.REQUEST_COMPANION_PROFILE_GLASSES");
        map.put("android.app.role.COMPANION_DEVICE_NEARBY_DEVICE_STREAMING", "android.permission.REQUEST_COMPANION_PROFILE_NEARBY_DEVICE_STREAMING");
        map.put("android.app.role.COMPANION_DEVICE_VIRTUAL_DEVICE", "android.permission.REQUEST_COMPANION_PROFILE_VIRTUAL_DEVICE");
        DEVICE_PROFILE_TO_PERMISSION = Collections.unmodifiableMap(map);
        sAppOpsService = null;
    }

    public static void enforcePermissionForCreatingAssociation(Context context, AssociationRequest request, int packageUid) {
        enforcePermissionForRequestingProfile(context, request.getDeviceProfile(), packageUid);
        if (request.isSelfManaged() == false) goto L5;
    L6:
        enforcePermissionForRequestingSelfManaged(context, packageUid);
        return;
    L5:
        if (request.getDeviceIcon() != null) goto L6;
    }

    public static void enforcePermissionForRequestingProfile(Context context, String deviceProfile, int packageUid) {
        if (deviceProfile != null) goto L5;
        return;
    L5:
        if (DEVICE_PROFILE_TO_PERMISSION.containsKey(deviceProfile) == true) goto L12;
        if (SYSTEM_ONLY_DEVICE_PROFILES.contains(deviceProfile) == true) goto L12;
        throw new IllegalArgumentException("Unsupported device profile: " + deviceProfile);
    L12:
        if (SYSTEM_ONLY_DEVICE_PROFILES.contains(deviceProfile) == true) goto L14;
    L18:
        String permission = DEVICE_PROFILE_TO_PERMISSION.getOrDefault(deviceProfile, null);
        if (permission != null) goto L21;
        return;
    L21:
        if (context.checkPermission(permission, Binder.getCallingPid(), packageUid) != 0) goto L24;
        return;
    L24:
        throw new SecurityException("Application must hold " + permission + " to associate with a device with " + deviceProfile + " profile.");
    L14:
        if (Binder.getCallingUid() == 1000) goto L18;
        throw new SecurityException("Caller must be system to associate with a device with " + deviceProfile + " profile.");
    }

    public static void enforcePermissionForRequestingSelfManaged(Context context, int packageUid) {
        if (context.checkPermission("android.permission.REQUEST_COMPANION_SELF_MANAGED", Binder.getCallingPid(), packageUid) != 0) goto L6;
        return;
    L6:
        throw new SecurityException("Application does not hold android.permission.REQUEST_COMPANION_SELF_MANAGED");
    }

    public static boolean checkCallerCanInteractWithUserId(Context context, int userId) {
        if (UserHandle.getCallingUserId() != userId) goto L6;
        return true;
    L6:
        if (context.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS") == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static void enforceCallerCanInteractWithUserId(Context context, int userId) {
        if (UserHandle.getCallingUserId() != userId) goto L5;
        return;
    L5:
        context.enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS", null);
    }

    public static void enforceCallerIsSystemOrCanInteractWithUserId(Context context, int userId) {
        if (Binder.getCallingUid() != 1000) goto L5;
        return;
    L5:
        enforceCallerCanInteractWithUserId(context, userId);
    }

    public static void enforceCallerIsSystemOr(int userId, String packageName) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 1000) goto L5;
        return;
    L5:
        int callingUserId = UserHandle.getCallingUserId();
        if (UserHandle.getCallingUserId() != userId) goto L13;
        if (checkPackage(callingUid, packageName) == false) goto L11;
        return;
    L11:
        throw new SecurityException(packageName + " doesn't belong to calling uid (" + callingUid + ")");
    L13:
        throw new SecurityException("Calling UserId (" + callingUserId + ") does not match the expected UserId (" + userId + ")");
    }

    public static void enforceCallerCanManageAssociationsForPackage(Context context, int userId, String packageName, String actionDescription) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 1000) goto L5;
        return;
    L5:
        boolean canManageCompanionDevices = false;
        if (context.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS") != 0) goto L8;
        boolean canInteractAcrossUsers = true;
    L10:
        if (context.checkCallingPermission("android.permission.MANAGE_COMPANION_DEVICES") != 0) goto L13;
        canManageCompanionDevices = true;
    L13:
        if (UserHandle.getCallingUserId() == userId) goto L15;
        if (canInteractAcrossUsers == false) goto L21;
        if (canManageCompanionDevices == false) goto L21;
        return;
    L21:
        StringBuilder r4 = new StringBuilder();
        r4.append("Caller (uid=");
        r4.append(Binder.getCallingUid());
        r4.append(") does not have permissions to ");
        if (actionDescription == null) goto L24;
        String r5 = actionDescription;
    L25:
        r4.append(r5);
        r4.append(" for u");
        r4.append(userId);
        r4.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        r4.append(packageName);
        throw new SecurityException(r4.toString());
    L24:
        r5 = "manage associations";
        goto L25
    L15:
        if (checkPackage(callingUid, packageName) == true) goto L17;
        if (canManageCompanionDevices == false) goto L21;
        return;
    L17:
        return;
    L8:
        canInteractAcrossUsers = false;
        goto L10
    }

    public static void enforceCallerCanObserveDevicePresenceByUuid(Context context, String packageName, int userId) {
        if (hasRequirePermissions(context, packageName, userId) == false) goto L6;
        return;
    L6:
        throw new SecurityException("Caller (uid=" + Binder.getCallingUid() + ") does not have permissions to request observing device presence base on the UUID");
    }

    private static boolean checkPackage(int uid, String packageName) {
        if (getAppOpsService().checkPackage(uid, packageName) == 0) goto L12;
        return false;
    L12:
        return true;
    L9:
        return true;
    }

    private static IAppOpsService getAppOpsService() {
        if (sAppOpsService != null) goto L16;
        monitor-enter(PermissionsUtils.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sAppOpsService != null) goto L11;
        sAppOpsService = IAppOpsService.Stub.asInterface(ServiceManager.getService("appops"));     // Catch: Throwable -> L9
    L11:
        monitor-exit(PermissionsUtils.class);     // Catch: Throwable -> L9
    L16:
        return sAppOpsService;
    }

    private static boolean hasRequirePermissions(final Context context, final String packageName, final int userId) {
        if (context.checkCallingPermission("android.permission.REQUEST_OBSERVE_DEVICE_UUID_PRESENCE") == 0) goto L5;
    L11:
        return false;
    L5:
        if (context.checkCallingPermission("android.permission.BLUETOOTH_SCAN") != 0) goto L11;
        if (context.checkCallingPermission("android.permission.BLUETOOTH_CONNECT") != 0) goto L11;
        if (Boolean.TRUE.equals(Binder.withCleanCallingIdentity(new PermissionsUtils$$ExternalSyntheticLambda0(context, userId, packageName))) == false) goto L11;
        return true;
    }

    private static /* synthetic */ Boolean lambda$hasRequirePermissions$0(Context context, int userId, String packageName) throws Exception {
        return Boolean.valueOf(RolesUtils.isRoleHolder(context, userId, packageName, "android.app.role.SYSTEM_AUTOMOTIVE_PROJECTION"));
    }

    private PermissionsUtils() {
    }
}
