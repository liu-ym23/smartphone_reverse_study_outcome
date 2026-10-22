package com.android.server.pm.permission;

import android.os.UserHandle;
import android.util.ArraySet;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public final class UserPermissionState {
    private final ArraySet<String> mInstallPermissionsFixed;
    private final SparseArray<UidPermissionState> mUidStates;

    public UserPermissionState() {
        this.mInstallPermissionsFixed = new ArraySet();
        this.mUidStates = new SparseArray();
    }

    public boolean areInstallPermissionsFixed(String packageName) {
        return this.mInstallPermissionsFixed.contains(packageName);
    }

    public void setInstallPermissionsFixed(String packageName, boolean fixed) {
        if (fixed == false) goto L4;
        this.mInstallPermissionsFixed.add(packageName);
        return;
    L4:
        this.mInstallPermissionsFixed.remove(packageName);
    }

    public UidPermissionState getUidState(int appId) {
        checkAppId(appId);
        return this.mUidStates.get(appId);
    }

    public UidPermissionState getOrCreateUidState(int appId) {
        checkAppId(appId);
        UidPermissionState uidState = this.mUidStates.get(appId);
        if (uidState != null) goto L6;
        UidPermissionState uidState2 = new UidPermissionState();
        this.mUidStates.put(appId, uidState2);
        return uidState2;
    L6:
        return uidState;
    }

    UidPermissionState createUidStateWithExisting(int appId, UidPermissionState other) {
        checkAppId(appId);
        UidPermissionState uidState = new UidPermissionState(other);
        this.mUidStates.put(appId, uidState);
        return uidState;
    }

    public void removeUidState(int appId) {
        checkAppId(appId);
        this.mUidStates.delete(appId);
    }

    private void checkAppId(int appId) {
        if (UserHandle.getUserId(appId) != 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Invalid app ID " + appId);
    }
}
