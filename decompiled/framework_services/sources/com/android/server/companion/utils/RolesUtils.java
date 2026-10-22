package com.android.server.companion.utils;

import android.app.role.RoleManager;
import android.companion.AssociationInfo;
import android.content.Context;
import android.os.Binder;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.Slog;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class RolesUtils {
    public static final Set<String> NLS_PROFILES = null;
    private static final Set<String> ROLELESS_DEVICE_PROFILES = null;
    private static final String TAG = "CDM_RolesUtils";

    public static /* synthetic */ void $r8$lambda$AjJMRFjMalh_JxSpGaxd4sYb6Dk(int r0, String r1, String r2, Boolean r3) {
        lambda$removeRoleHolderForAssociation$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$LNHD2GShUmGeLv7P1aREeZgT58o(RoleManager r0, String r1, String r2, UserHandle r3, Context r4, int r5) {
        lambda$removeRoleHolderForAssociation$1(r0, r1, r2, r3, r4, r5);
    }

    static {
        NLS_PROFILES = Set.of("android.app.role.COMPANION_DEVICE_WATCH", "android.app.role.COMPANION_DEVICE_GLASSES", "android.app.role.COMPANION_DEVICE_APP_STREAMING", "android.app.role.COMPANION_DEVICE_COMPUTER");
        Set<String> profiles = new ArraySet();
        profiles.add("android.companion.COMPANION_DEVICE_WEARABLE_SENSING");
        ROLELESS_DEVICE_PROFILES = Collections.unmodifiableSet(profiles);
    }

    public static boolean isRoleHolder(Context context, int userId, String packageName, String role) {
        RoleManager roleManager = (RoleManager) context.getSystemService(RoleManager.class);
        List<String> roleHolders = roleManager.getRoleHoldersAsUser(role, UserHandle.of(userId));
        return roleHolders.contains(packageName);
    }

    public static void addRoleHolderForAssociation(Context context, AssociationInfo associationInfo, Consumer<Boolean> roleGrantResult) {
        String deviceProfile = associationInfo.getDeviceProfile();
        if (deviceProfile != null) goto L6;
        roleGrantResult.accept(true);
        return;
    L6:
        RoleManager roleManager = (RoleManager) context.getSystemService(RoleManager.class);
        String packageName = associationInfo.getPackageName();
        int userId = associationInfo.getUserId();
        UserHandle userHandle = UserHandle.of(userId);
        roleManager.addRoleHolderAsUser(deviceProfile, packageName, 1, userHandle, context.getMainExecutor(), roleGrantResult);
    }

    public static void removeRoleHolderForAssociation(final Context context, final int userId, final String packageName, final String deviceProfile) {
        if (deviceProfile != null) goto L4;
        return;
    L4:
        final RoleManager roleManager = (RoleManager) context.getSystemService(RoleManager.class);
        final UserHandle userHandle = UserHandle.of(userId);
        Slog.i(TAG, "Removing CDM role=" + deviceProfile + " for userId=" + userId + ", packageName=" + packageName);
        Binder.withCleanCallingIdentity(new RolesUtils$$ExternalSyntheticLambda0(roleManager, deviceProfile, packageName, userHandle, context, userId));
    }

    private static /* synthetic */ void lambda$removeRoleHolderForAssociation$1(RoleManager roleManager, final String deviceProfile, final String packageName, UserHandle userHandle, Context context, final int userId) throws Exception {
        roleManager.removeRoleHolderAsUser(deviceProfile, packageName, 1, userHandle, context.getMainExecutor(), new RolesUtils$$ExternalSyntheticLambda1(userId, packageName, deviceProfile));
    }

    private static /* synthetic */ void lambda$removeRoleHolderForAssociation$0(int userId, String packageName, String deviceProfile, Boolean success) {
        if (success.booleanValue() == true) goto L6;
        Slog.e(TAG, "Failed to remove userId=" + userId + ", packageName=" + packageName + " from the list of " + deviceProfile + " holders.");
        return;
    }

    public static boolean isRolelessProfile(String deviceProfile) {
        return ROLELESS_DEVICE_PROFILES.contains(deviceProfile);
    }

    private RolesUtils() {
    }
}
