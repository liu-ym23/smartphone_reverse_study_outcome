package com.android.server.accessibility;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.os.UserManager;
import com.android.server.am.ProcessList;
import com.android.settingslib.RestrictedLockUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedLockUtilsInternal {
    public RestrictedLockUtilsInternal() {
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfAccessibilityServiceDisallowed(Context context, String packageName, int userId) {
        DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        if (dpm != null) goto L5;
        return null;
    L5:
        RestrictedLockUtils.EnforcedAdmin admin = RestrictedLockUtils.getProfileOrDeviceOwner(context, getUserHandleOf(userId));
        boolean permitted = true;
        if (admin == null) goto L8;
        permitted = dpm.isAccessibilityServicePermittedByAdmin(admin.component, packageName, userId);
    L8:
        int managedProfileId = getManagedProfileId(context, userId);
        RestrictedLockUtils.EnforcedAdmin profileAdmin = RestrictedLockUtils.getProfileOrDeviceOwner(context, getUserHandleOf(managedProfileId));
        boolean permittedByProfileAdmin = true;
        if (profileAdmin == null) goto L11;
        permittedByProfileAdmin = dpm.isAccessibilityServicePermittedByAdmin(profileAdmin.component, packageName, managedProfileId);
    L11:
        if (permitted == true) goto L15;
        if (permittedByProfileAdmin == true) goto L15;
        return RestrictedLockUtils.EnforcedAdmin.MULTIPLE_ENFORCED_ADMIN;
    L15:
        if (permitted == true) goto L17;
        return admin;
    L17:
        if (permittedByProfileAdmin == true) goto L19;
        return profileAdmin;
    L19:
        return null;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfInputMethodDisallowed(Context context, String packageName, int userId) {
        DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        if (dpm != null) goto L5;
        return null;
    L5:
        RestrictedLockUtils.EnforcedAdmin admin = RestrictedLockUtils.getProfileOrDeviceOwner(context, getUserHandleOf(userId));
        boolean permitted = true;
        if (admin == null) goto L8;
        permitted = dpm.isInputMethodPermittedByAdmin(admin.component, packageName, userId);
    L8:
        boolean permittedByParentAdmin = true;
        RestrictedLockUtils.EnforcedAdmin profileAdmin = null;
        int managedProfileId = getManagedProfileId(context, userId);
        if (managedProfileId == (-10000)) goto L15;
        profileAdmin = RestrictedLockUtils.getProfileOrDeviceOwner(context, getUserHandleOf(managedProfileId));
        if (profileAdmin == null) goto L15;
        if (dpm.isOrganizationOwnedDeviceWithManagedProfile() == false) goto L15;
        DevicePolicyManager parentDpm = dpm.getParentProfileInstance(UserManager.get(context).getUserInfo(managedProfileId));
        permittedByParentAdmin = parentDpm.isInputMethodPermittedByAdmin(profileAdmin.component, packageName, managedProfileId);
    L15:
        if (permitted == true) goto L19;
        if (permittedByParentAdmin == true) goto L19;
        return RestrictedLockUtils.EnforcedAdmin.MULTIPLE_ENFORCED_ADMIN;
    L19:
        if (permitted == true) goto L21;
        return admin;
    L21:
        if (permittedByParentAdmin == true) goto L23;
        return profileAdmin;
    L23:
        return null;
    }

    private static int getManagedProfileId(Context context, int userId) {
        UserManager um = (UserManager) context.getSystemService(UserManager.class);
        List<UserInfo> userProfiles = um.getProfiles(userId);
        Iterator<UserInfo> r2 = userProfiles.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        UserInfo uInfo = r2.next();
        if (uInfo.id == userId) goto L4;
        if (uInfo.isManagedProfile() == false) goto L4;
        return uInfo.id;
    L13:
        return ProcessList.INVALID_ADJ;
    }

    private static UserHandle getUserHandleOf(int userId) {
        if (userId != (-10000)) goto L7;
        return null;
    L7:
        return UserHandle.of(userId);
    }
}
