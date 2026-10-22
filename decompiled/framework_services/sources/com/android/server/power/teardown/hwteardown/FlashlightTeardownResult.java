package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public class FlashlightTeardownResult extends ComponentResult {
    public long mFlashlightActiveTime;

    public FlashlightTeardownResult(int FlashlightCurrent, long flashlightActiveTime) {
        this.mCurrent = FlashlightCurrent;
        this.mFlashlightActiveTime = flashlightActiveTime;
    }

    public String toString() {
        long activeTimeToSecond = this.mFlashlightActiveTime / 1000;
        return "[Flashlight] Flashlight current=" + this.mCurrent + "mA, flashlightActiveTime=" + activeTimeToSecond + "s\n";
    }
}
