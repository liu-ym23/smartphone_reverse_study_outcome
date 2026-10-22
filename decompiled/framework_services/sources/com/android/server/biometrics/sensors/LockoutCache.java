package com.android.server.biometrics.sensors;

import android.util.Slog;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public class LockoutCache implements LockoutTracker {
    private static final String TAG = "LockoutCache";
    private final SparseIntArray mUserLockoutStates;

    public LockoutCache() {
        this.mUserLockoutStates = new SparseIntArray();
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public void setLockoutModeForUser(int userId, int mode) {
        Slog.d(TAG, "Lockout for user: " + userId + " is " + mode);
        monitor-enter(this);
        this.mUserLockoutStates.put(userId, mode);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public int getLockoutModeForUser(int userId) {
        monitor-enter(this);
        int r0 = this.mUserLockoutStates.get(userId, 0);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
