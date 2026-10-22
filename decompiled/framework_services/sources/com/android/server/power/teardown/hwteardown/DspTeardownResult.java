package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DspTeardownResult extends ComponentResult {
    public int mCoreClock;
    public int[] mDspCurrent;
    public double mHmxLoad;
    public double mHvxLoad;
    public double mQ6Load;

    public DspTeardownResult(int[] dspCurrent, int coreClock, double q6Load, double hvxLoad, double hmxLoad) {
        this.mDspCurrent = dspCurrent;
        int i = 0;
    L4:
        if (i >= dspCurrent.length) goto L6;
        this.mCurrent += dspCurrent[i];
        i = i + 1;
        goto L4
    L6:
        this.mCoreClock = coreClock;
        this.mQ6Load = q6Load;
        this.mHvxLoad = hvxLoad;
        this.mHmxLoad = hmxLoad;
    }

    public String toString() {
        return "[Dsp] current: " + this.mCurrent + "mA, dsp current: " + Arrays.toString(this.mDspCurrent) + "mA, core clock: " + this.mCoreClock + ", q6 load: " + this.mQ6Load + ", hvx load: " + this.mHvxLoad + ", hmx load: " + this.mHmxLoad + "\n";
    }
}
