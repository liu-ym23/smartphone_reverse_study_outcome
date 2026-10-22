package com.android.server.display;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswDisplayPowerController {
    float getFakeSleepBrightness();

    boolean skipAnimateBrightness();

    void updatePowerStateInternalForPerfCube(int r1);

    boolean useFakeSleepBrightness();

    boolean useFakeSleepBrightness(int r1);
}
