package com.android.server.pm.permission;

/* JADX INFO: loaded from: classes2.dex */
public final class PermissionState {
    private int mFlags;
    private boolean mGranted;
    private final Object mLock;
    private final Permission mPermission;

    public PermissionState(Permission permission) {
        this.mLock = new Object();
        this.mPermission = permission;
    }

    public PermissionState(PermissionState other) {
        this(other.mPermission);
        this.mGranted = other.mGranted;
        this.mFlags = other.mFlags;
    }

    public Permission getPermission() {
        return this.mPermission;
    }

    public String getName() {
        return this.mPermission.getName();
    }

    public int[] computeGids(int userId) {
        return this.mPermission.computeGids(userId);
    }

    public boolean isGranted() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mGranted;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean grant() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mGranted == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        this.mGranted = true;     // Catch: Throwable -> L9
        UidPermissionState.invalidateCache();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    }

    public boolean revoke() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mGranted == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        this.mGranted = false;     // Catch: Throwable -> L8
        UidPermissionState.invalidateCache();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    }

    public int getFlags() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mFlags;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean updateFlags(int flagMask, int flagValues) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int newFlags = flagValues & flagMask;
        UidPermissionState.invalidateCache();     // Catch: Throwable -> L11
        int oldFlags = this.mFlags;     // Catch: Throwable -> L11
        this.mFlags = (this.mFlags & (~flagMask)) | newFlags;     // Catch: Throwable -> L11
        if (this.mFlags == oldFlags) goto L8;
        boolean r3 = true;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L8:
        r3 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean isDefault() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mGranted == false) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mFlags != 0) goto L11;
        r1 = true;
        goto L12
    }
}
