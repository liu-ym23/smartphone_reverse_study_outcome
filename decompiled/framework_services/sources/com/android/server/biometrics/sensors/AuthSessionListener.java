package com.android.server.biometrics.sensors;

/* JADX INFO: loaded from: classes.dex */
interface AuthSessionListener {
    void authEndedFor(int r1, int r2, int r3, long r4, boolean r6);

    void authStartedFor(int r1, int r2, long r3);

    void lockOutTimed(int r1, int r2, int r3, long r4, long r6);

    void lockedOutFor(int r1, int r2, int r3, long r4);

    void resetLockoutFor(int r1, int r2, long r3);
}
