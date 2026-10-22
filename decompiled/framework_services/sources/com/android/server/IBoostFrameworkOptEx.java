package com.android.server;

/* JADX INFO: loaded from: classes.dex */
public interface IBoostFrameworkOptEx {
    void bindCoreAcquire(int r1);

    void bindCoreRelease(int r1);

    int configBoostParams(int r1);

    int configBoostParams(int r1, int r2, int r3, int r4);

    void disableBoost();

    void enableBoost(int r1);

    void enableBoost(int r1, int r2);

    void initBoost();

    void perfDozeMode(int r1);

    void perfEnableACL(boolean r1);

    void perfEntryPCMode(boolean r1);

    int perfFanOffset(int r1);

    void perfInCallMode(boolean r1);

    void perfLockAcquire(int r1, int... r2);

    void perfLockRelease();

    void perfLockUseProfile(int r1);

    void perfPerformanceMode(boolean r1);
}
