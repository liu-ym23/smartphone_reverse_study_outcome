package com.android.server.pm.permission;

import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyPermissionState {
    private final SparseBooleanArray mMissing;
    private final SparseArray<UserState> mUserStates;

    public static final class PermissionState {
        private final int mFlags;
        private final boolean mGranted;
        private final String mName;
        private final boolean mRuntime;

        /* synthetic */ PermissionState(PermissionState r1, LegacyPermissionStateIA r2) {
            this(r1);
        }

        public PermissionState(String name, boolean runtime, boolean granted, int flags) {
            this.mName = name;
            this.mRuntime = runtime;
            this.mGranted = granted;
            this.mFlags = flags;
        }

        private PermissionState(PermissionState other) {
            this.mName = other.mName;
            this.mRuntime = other.mRuntime;
            this.mGranted = other.mGranted;
            this.mFlags = other.mFlags;
        }

        public String getName() {
            return this.mName;
        }

        public boolean isRuntime() {
            return this.mRuntime;
        }

        public boolean isGranted() {
            return this.mGranted;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean equals(Object object) {
            if (this != object) goto L6;
            return true;
        L6:
            if (object != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != object.getClass()) goto L21;
            PermissionState that = (PermissionState) object;
            if (this.mRuntime != that.mRuntime) goto L20;
            if (this.mGranted != that.mGranted) goto L20;
            if (this.mFlags != that.mFlags) goto L20;
            if (Objects.equals(this.mName, that.mName) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mName, Boolean.valueOf(this.mRuntime), Boolean.valueOf(this.mGranted), Integer.valueOf(this.mFlags)});
        }
    }

    private static final class UserState {
        private final ArrayMap<String, PermissionState> mPermissionStates;

        public UserState() {
            this.mPermissionStates = new ArrayMap();
        }

        public UserState(UserState other) {
            this.mPermissionStates = new ArrayMap();
            int permissionStatesSize = other.mPermissionStates.size();
            int i = 0;
        L3:
            if (i >= permissionStatesSize) goto L6;
            this.mPermissionStates.put(other.mPermissionStates.keyAt(i), new PermissionState(other.mPermissionStates.valueAt(i), null));
            i = i + 1;
            goto L3
        }

        public PermissionState getPermissionState(String permissionName) {
            return this.mPermissionStates.get(permissionName);
        }

        public void putPermissionState(PermissionState permissionState) {
            this.mPermissionStates.put(permissionState.getName(), permissionState);
        }

        public Collection<PermissionState> getPermissionStates() {
            return Collections.unmodifiableCollection(this.mPermissionStates.values());
        }
    }

    public LegacyPermissionState() {
        this.mUserStates = new SparseArray();
        this.mMissing = new SparseBooleanArray();
    }

    public void copyFrom(LegacyPermissionState other) {
        if (other != this) goto L4;
        return;
    L4:
        this.mUserStates.clear();
        int userStatesSize = other.mUserStates.size();
        int i = 0;
    L5:
        if (i >= userStatesSize) goto L7;
        this.mUserStates.put(other.mUserStates.keyAt(i), new UserState(other.mUserStates.valueAt(i)));
        i = i + 1;
        goto L5
    L7:
        this.mMissing.clear();
        int missingSize = other.mMissing.size();
        int i2 = 0;
    L8:
        if (i2 >= missingSize) goto L11;
        this.mMissing.put(other.mMissing.keyAt(i2), other.mMissing.valueAt(i2));
        i2 = i2 + 1;
        goto L8
    }

    public void reset() {
        this.mUserStates.clear();
        this.mMissing.clear();
    }

    public boolean equals(Object object) {
        if (this != object) goto L6;
        return true;
    L6:
        if (object != null) goto L9;
        return false;
    L9:
        if (getClass() == object.getClass()) goto L11;
        return false;
    L11:
        LegacyPermissionState other = (LegacyPermissionState) object;
        int userStatesSize = this.mUserStates.size();
        if (userStatesSize == other.mUserStates.size()) goto L14;
        return false;
    L14:
        int i = 0;
    L15:
        if (i >= userStatesSize) goto L21;
        int userId = this.mUserStates.keyAt(i);
        if (Objects.equals(this.mUserStates.get(userId), other.mUserStates.get(userId)) == false) goto L18;
        i = i + 1;
        goto L15
    L18:
        return false;
    L21:
        return Objects.equals(this.mMissing, other.mMissing);
    }

    public PermissionState getPermissionState(String permissionName, int userId) {
        checkUserId(userId);
        UserState userState = this.mUserStates.get(userId);
        if (userState != null) goto L7;
        return null;
    L7:
        return userState.getPermissionState(permissionName);
    }

    public void putPermissionState(PermissionState permissionState, int userId) {
        checkUserId(userId);
        UserState userState = this.mUserStates.get(userId);
        if (userState != null) goto L5;
        userState = new UserState();
        this.mUserStates.put(userId, userState);
    L5:
        userState.putPermissionState(permissionState);
    }

    public boolean hasPermissionState(Collection<String> permissionNames) {
        int userStatesSize = this.mUserStates.size();
        int i = 0;
    L3:
        if (i >= userStatesSize) goto L13;
        UserState userState = this.mUserStates.valueAt(i);
        Iterator<String> r3 = permissionNames.iterator();
    L6:
        if (r3.hasNext() == false) goto L12;
        String permissionName = r3.next();
        if (userState.getPermissionState(permissionName) == null) goto L6;
        return true;
    L12:
        i = i + 1;
        goto L3
    L13:
        return false;
    }

    public Collection<PermissionState> getPermissionStates(int userId) {
        checkUserId(userId);
        UserState userState = this.mUserStates.get(userId);
        if (userState != null) goto L7;
        return Collections.emptyList();
    L7:
        return userState.getPermissionStates();
    }

    public boolean isMissing(int userId) {
        checkUserId(userId);
        return this.mMissing.get(userId);
    }

    public void setMissing(boolean missing, int userId) {
        checkUserId(userId);
        if (missing == false) goto L5;
        this.mMissing.put(userId, true);
        return;
    L5:
        this.mMissing.delete(userId);
    }

    private static void checkUserId(int userId) {
        if (userId < 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Invalid user ID " + userId);
    }
}
