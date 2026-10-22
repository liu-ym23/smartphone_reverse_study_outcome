package com.android.server.power;

import android.os.Message;
import android.util.IntArray;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswPowerManagerService {
    public static final int INTERVAL_NOTIFY_USER_OPERATE = 100;

    public interface PrivateMethodCaller {
        void goToSleepInternal(IntArray r1, long r2, int r4, int r5);

        void updatePowerStateLocked(int r1);

        boolean userActivityNoUpdateLocked(long r1, int r3, int r4, int r5);

        void wakePowerGroupLocked(int r1, long r2, int r4, String r5, int r6, String r7, int r8);
    }

    void checkCpuFreezerWakeLockInternal(int r1, boolean r2);

    void checkCpuFreezerWakeLockInternalAsyn(Message r1);

    void enterFakeSleep();

    void exitFakeSleep(int r1);

    float getFakeSleepBrightness();

    boolean isInFakeSleep();

    void onSystemReady();

    void registerPowerGroupListener(int r1, PowerGroup r2);

    void reportUserOperateStateIfNeeded(int r1);

    boolean useFakeSleepBrightness(int r1);
}
