package com.android.server.devicepolicy;

import android.content.ComponentName;
import com.android.internal.util.Preconditions;
import com.android.server.am.ProcessList;

/* JADX INFO: loaded from: classes2.dex */
final class OwnerShellData {
    public final ComponentName admin;
    public boolean isAffiliated;
    public final boolean isDeviceOwner;
    public final boolean isManagedProfileOwner;
    public final boolean isProfileOwner;
    public final int parentUserId;
    public final int userId;

    private OwnerShellData(int userId, int parentUserId, ComponentName admin, boolean isDeviceOwner, boolean isProfileOwner, boolean isManagedProfileOwner) {
        boolean r0 = false;
        if (userId == (-10000)) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkArgument(r3, "userId cannot be USER_NULL");
        this.userId = userId;
        this.parentUserId = parentUserId;
        admin.getClass();
        this.admin = admin;
        this.isDeviceOwner = isDeviceOwner;
        this.isProfileOwner = isProfileOwner;
        this.isManagedProfileOwner = isManagedProfileOwner;
        if (isManagedProfileOwner == false) goto L16;
        if (parentUserId == (-10000)) goto L10;
        boolean r2 = true;
    L11:
        Preconditions.checkArgument(r2, "parentUserId cannot be USER_NULL for managed profile owner");
        if (parentUserId == userId) goto L14;
        r0 = true;
    L14:
        Preconditions.checkArgument(r0, "cannot be parent of itself (%d)", new Object[]{Integer.valueOf(userId)});
        return;
    L10:
        r2 = false;
        goto L11
    L16:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(getClass().getSimpleName());
        r0.append("[userId=");
        r0.append(this.userId);
        r0.append(",admin=");
        StringBuilder sb = r0.append(this.admin.flattenToShortString());
        if (this.isDeviceOwner == false) goto L6;
        sb.append(",deviceOwner");
    L6:
        if (this.isProfileOwner == false) goto L9;
        sb.append(",isProfileOwner");
    L9:
        if (this.isManagedProfileOwner == false) goto L12;
        sb.append(",isManagedProfileOwner");
    L12:
        if (this.parentUserId == (-10000)) goto L15;
        sb.append(",parentUserId=");
        sb.append(this.parentUserId);
    L15:
        if (this.isAffiliated == false) goto L17;
        sb.append(",isAffiliated");
    L17:
        sb.append(']');
        return sb.toString();
    }

    static OwnerShellData forDeviceOwner(int userId, ComponentName admin) {
        return new OwnerShellData(userId, ProcessList.INVALID_ADJ, admin, true, false, false);
    }

    static OwnerShellData forUserProfileOwner(int userId, ComponentName admin) {
        return new OwnerShellData(userId, ProcessList.INVALID_ADJ, admin, false, true, false);
    }

    static OwnerShellData forManagedProfileOwner(int userId, int parentUserId, ComponentName admin) {
        return new OwnerShellData(userId, parentUserId, admin, false, false, true);
    }
}
