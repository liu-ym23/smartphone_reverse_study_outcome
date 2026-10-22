package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public class VibratorTeardownResult extends ComponentResult {
    public int mCount;
    public long mVibratorActiveTime;

    public VibratorTeardownResult(int vibratorCurrent, long vibratorActiveTime, int count) {
        this.mCurrent = vibratorCurrent;
        this.mVibratorActiveTime = vibratorActiveTime;
        this.mCount = count;
    }

    public String toString() {
        long activeTimeToSecond = this.mVibratorActiveTime / 1000;
        return "[Vibrator] Vibrator current=" + this.mCurrent + "mA, vibratorActiveTime =" + activeTimeToSecond + "s, count =" + this.mCount + "\n";
    }
}
