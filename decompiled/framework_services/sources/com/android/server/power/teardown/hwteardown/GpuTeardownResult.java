package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public final class GpuTeardownResult extends ComponentResult {
    public long[] mFreqTimeDuration;
    public long mTotalDuration;

    public GpuTeardownResult(int gpuCurrent, long[] freqTimeDuration, long totalduration) {
        this.mCurrent = gpuCurrent;
        this.mFreqTimeDuration = freqTimeDuration;
        this.mTotalDuration = totalduration;
    }

    public GpuTeardownResult(GpuTeardownResult result) {
        this.mCurrent = result.mCurrent;
        this.mFreqTimeDuration = result.mFreqTimeDuration;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[GPU] gpu current = ");
        sb.append(this.mCurrent);
        sb.append("mA, gpu usage = [");
        int i = this.mFreqTimeDuration.length - 1;
    L3:
        if (i < 0) goto L8;
        sb.append(String.format("%.2f", new Object[]{Double.valueOf(((this.mFreqTimeDuration[i] * 100.0d) / this.mTotalDuration) / 1000.0d)}));
        if (i == 0) goto L7;
        sb.append("%, ");
    L7:
        i = i - 1;
        goto L3
    L8:
        sb.append("%]\n");
        return sb.toString();
    }
}
