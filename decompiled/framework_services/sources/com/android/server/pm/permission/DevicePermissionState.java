package com.android.server.pm.permission;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public final class DevicePermissionState {
    private final SparseArray<UserPermissionState> mUserStates;

    public DevicePermissionState() {
        this.mUserStates = new SparseArray();
    }

    public UserPermissionState getUserState(int userId) {
        return this.mUserStates.get(userId);
    }

    public UserPermissionState getOrCreateUserState(int userId) {
        UserPermissionState userState = this.mUserStates.get(userId);
        if (userState != null) goto L6;
        UserPermissionState userState2 = new UserPermissionState();
        this.mUserStates.put(userId, userState2);
        return userState2;
    L6:
        return userState;
    }

    public void removeUserState(int userId) {
        this.mUserStates.delete(userId);
    }

    public int[] getUserIds() {
        int userStatesSize = this.mUserStates.size();
        int[] userIds = new int[userStatesSize];
        int i = 0;
    L3:
        if (i >= userStatesSize) goto L6;
        int userId = this.mUserStates.keyAt(i);
        userIds[i] = userId;
        i = i + 1;
        goto L3
    L6:
        return userIds;
    }
}
