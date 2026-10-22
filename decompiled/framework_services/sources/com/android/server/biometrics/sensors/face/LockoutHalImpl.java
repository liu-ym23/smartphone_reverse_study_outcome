package com.android.server.biometrics.sensors.face;

import com.android.server.biometrics.sensors.LockoutTracker;

/* JADX INFO: loaded from: classes.dex */
public class LockoutHalImpl implements LockoutTracker {
    private int mCurrentUserLockoutMode;

    public LockoutHalImpl() {
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public int getLockoutModeForUser(int userId) {
        return this.mCurrentUserLockoutMode;
    }

    @Override // com.android.server.biometrics.sensors.LockoutTracker
    public void setLockoutModeForUser(int userId, int mode) {
        setCurrentUserLockoutMode(mode);
    }

    public void setCurrentUserLockoutMode(int lockoutMode) {
        this.mCurrentUserLockoutMode = lockoutMode;
    }
}
