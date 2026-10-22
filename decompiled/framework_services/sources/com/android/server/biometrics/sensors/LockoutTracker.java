package com.android.server.biometrics.sensors;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public interface LockoutTracker {
    public static final int LOCKOUT_NONE = 0;
    public static final int LOCKOUT_PERMANENT = 2;
    public static final int LOCKOUT_TIMED = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LockoutMode {
    }

    int getLockoutModeForUser(int r1);

    void setLockoutModeForUser(int r1, int r2);

    default void resetFailedAttemptsForUser(boolean clearAttemptCounter, int userId) {
    }

    default void addFailedAttemptForUser(int userId) {
    }
}
