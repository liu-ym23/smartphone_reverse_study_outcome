package com.android.settingslib;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.os.UserManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class RestrictedLockUtils {

    public static class EnforcedAdmin {
        public static final EnforcedAdmin MULTIPLE_ENFORCED_ADMIN = null;
        public ComponentName component;
        public String enforcedRestriction;
        public UserHandle user;

        static {
            MULTIPLE_ENFORCED_ADMIN = new EnforcedAdmin();
        }

        public static EnforcedAdmin createDefaultEnforcedAdminWithRestriction(String enforcedRestriction) {
            EnforcedAdmin enforcedAdmin = new EnforcedAdmin();
            enforcedAdmin.enforcedRestriction = enforcedRestriction;
            return enforcedAdmin;
        }

        public EnforcedAdmin(ComponentName component, UserHandle user) {
            this.component = null;
            this.enforcedRestriction = null;
            this.user = null;
            this.component = component;
            this.user = user;
        }

        public EnforcedAdmin(ComponentName component, String enforcedRestriction, UserHandle user) {
            this.component = null;
            this.enforcedRestriction = null;
            this.user = null;
            this.component = component;
            this.enforcedRestriction = enforcedRestriction;
            this.user = user;
        }

        public EnforcedAdmin(EnforcedAdmin other) {
            this.component = null;
            this.enforcedRestriction = null;
            this.user = null;
            if (other == null) goto L7;
            this.component = other.component;
            this.enforcedRestriction = other.enforcedRestriction;
            this.user = other.user;
            return;
        L7:
            throw new IllegalArgumentException();
        }

        public EnforcedAdmin() {
            this.component = null;
            this.enforcedRestriction = null;
            this.user = null;
        }

        public static EnforcedAdmin combine(EnforcedAdmin admin1, EnforcedAdmin admin2) {
            if (admin1 != null) goto L4;
            return admin2;
        L4:
            if (admin2 != null) goto L7;
            return admin1;
        L7:
            if (admin1.equals(admin2) == false) goto L10;
            return admin1;
        L10:
            if (admin1.enforcedRestriction.equals(admin2.enforcedRestriction) == false) goto L14;
            return MULTIPLE_ENFORCED_ADMIN;
        L14:
            throw new IllegalArgumentException("Admins with different restriction cannot be combined");
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L19;
            EnforcedAdmin that = (EnforcedAdmin) o;
            if (Objects.equals(this.user, that.user) == false) goto L18;
            if (Objects.equals(this.component, that.component) == false) goto L18;
            if (Objects.equals(this.enforcedRestriction, that.enforcedRestriction) == false) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.component, this.enforcedRestriction, this.user});
        }

        public String toString() {
            return "EnforcedAdmin{component=" + this.component + ", enforcedRestriction='" + this.enforcedRestriction + ", user=" + this.user + '}';
        }
    }

    public RestrictedLockUtils() {
    }

    public static EnforcedAdmin getProfileOrDeviceOwner(Context context, UserHandle user) {
        return getProfileOrDeviceOwner(context, null, user);
    }

    public static EnforcedAdmin getProfileOrDeviceOwner(Context context, String enforcedRestriction, UserHandle user) {
        if (user != null) goto L5;
        return null;
    L5:
        DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService("device_policy");
        if (dpm != null) goto L23;
        return null;
    L23:
        Context userContext = context.createPackageContextAsUser(context.getPackageName(), 0, user);     // Catch: PackageManager.NameNotFoundException -> L20
        ComponentName adminComponent = ((DevicePolicyManager) userContext.getSystemService(DevicePolicyManager.class)).getProfileOwner();
        if (adminComponent == null) goto L14;
        return new EnforcedAdmin(adminComponent, enforcedRestriction, user);
    L14:
        if (Objects.equals(dpm.getDeviceOwnerUser(), user) == false) goto L19;
        ComponentName adminComponent2 = dpm.getDeviceOwnerComponentOnAnyUser();
        if (adminComponent2 == null) goto L19;
        return new EnforcedAdmin(adminComponent2, enforcedRestriction, user);
    L19:
        return null;
    L20:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static void sendShowAdminSupportDetailsIntent(Context context, EnforcedAdmin admin) {
        Intent intent = getShowAdminSupportDetailsIntent(admin);
        int targetUserId = UserHandle.myUserId();
        if (admin != null) goto L5;
    L10:
        context.startActivityAsUser(intent, UserHandle.of(targetUserId));
        return;
    L5:
        if (admin.user != null) goto L7;
    L9:
        intent.putExtra("android.app.extra.RESTRICTION", admin.enforcedRestriction);
        goto L10
    L7:
        if (isCurrentUserOrProfile(context, admin.user.getIdentifier()) == false) goto L9;
        targetUserId = admin.user.getIdentifier();
        goto L9
    }

    public static Intent getShowAdminSupportDetailsIntent(Context context, EnforcedAdmin admin) {
        return getShowAdminSupportDetailsIntent(admin);
    }

    public static Intent getShowAdminSupportDetailsIntent(EnforcedAdmin admin) {
        Intent intent = new Intent("android.settings.SHOW_ADMIN_SUPPORT_DETAILS");
        if (admin != null) goto L5;
    L8:
        return intent;
    L5:
        if (admin.component == null) goto L7;
        intent.putExtra("android.app.extra.DEVICE_ADMIN", admin.component);
    L7:
        intent.putExtra("android.intent.extra.USER", admin.user);
        goto L8
    }

    public static boolean isCurrentUserOrProfile(Context context, int userId) {
        UserManager um = (UserManager) context.getSystemService(UserManager.class);
        return um.getUserProfiles().contains(UserHandle.of(userId));
    }

    @Deprecated
    public static void sendShowRestrictedSettingDialogIntent(Context context, String packageName, int uid) {
        Intent intent = getShowRestrictedSettingsIntent(packageName, uid);
        context.startActivity(intent);
    }

    @Deprecated
    private static Intent getShowRestrictedSettingsIntent(String packageName, int uid) {
        Intent intent = new Intent("android.settings.SHOW_RESTRICTED_SETTING_DIALOG");
        intent.putExtra("android.intent.extra.PACKAGE_NAME", packageName);
        intent.putExtra("android.intent.extra.UID", uid);
        return intent;
    }
}
