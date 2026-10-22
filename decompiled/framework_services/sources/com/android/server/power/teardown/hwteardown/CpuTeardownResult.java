package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class CpuTeardownResult extends ComponentResult {
    public long[] mCoreIdleDuration;
    public long[] mCoreTotalDuration;
    public int[] mCpuCurrent;
    public int[][] mFreqTable;
    public long[][] mFreqTimeDuration;

    public CpuTeardownResult(int[] cpuCurrent, long[][] freqTimeDuration, long[] coreTotalDuration, long[] coreIdleDuration, int[][] freqTable) {
        this.mCpuCurrent = cpuCurrent;
        this.mFreqTimeDuration = freqTimeDuration;
        this.mCoreTotalDuration = coreTotalDuration;
        this.mCoreIdleDuration = coreIdleDuration;
        this.mFreqTable = freqTable;
        this.mCurrent = 0;
        int i = 0;
    L4:
        if (i >= cpuCurrent.length) goto L7;
        this.mCurrent += cpuCurrent[i];
        i = i + 1;
        goto L4
    }

    public CpuTeardownResult(CpuTeardownResult result) {
        this.mCurrent = result.mCurrent;
        this.mCpuCurrent = result.mCpuCurrent;
        this.mFreqTimeDuration = result.mFreqTimeDuration;
        this.mCoreTotalDuration = result.mCoreTotalDuration;
        this.mCoreIdleDuration = result.mCoreIdleDuration;
        this.mFreqTable = result.mFreqTable;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[CPU] cpu current=");
        sb.append(this.mCurrent);
        sb.append("mA, cpuCurrent=");
        sb.append(Arrays.toString(this.mCpuCurrent));
        sb.append(", cpuLoad=[");
        int i = 0;
    L4:
        if (i >= this.mCoreTotalDuration.length) goto L8;
        if (i == 0) goto L7;
        sb.append("%, ");
    L7:
        sb.append(String.format("%.2f", new Object[]{Double.valueOf(((this.mCoreTotalDuration[i] - this.mCoreIdleDuration[i]) * 100.0d) / this.mCoreTotalDuration[i])}));
        i = i + 1;
        goto L4
    L8:
        sb.append("%]\n");
        int clusterNum = this.mFreqTimeDuration.length;
        int i2 = 0;
    L9:
        if (i2 >= clusterNum) goto L22;
        sb.append("[CPU] cluster");
        sb.append(i2);
        sb.append(" freqTimeDuration=[");
        long totalFreqDuration = 0;
        int j = 0;
    L12:
        if (j >= this.mFreqTimeDuration[i2].length) goto L14;
        totalFreqDuration = totalFreqDuration + this.mFreqTimeDuration[i2][j];
        j = j + 1;
        goto L12
    L14:
        int j2 = 0;
    L16:
        if (j2 >= this.mFreqTimeDuration[i2].length) goto L20;
        if (j2 == 0) goto L19;
        sb.append("%, ");
    L19:
        sb.append(String.format("%.2f", new Object[]{Double.valueOf((this.mFreqTimeDuration[i2][j2] * 100.0d) / totalFreqDuration)}));
        j2 = j2 + 1;
        goto L16
    L20:
        sb.append("%]\n");
        i2 = i2 + 1;
        goto L9
    L22:
        return sb.toString();
    }
}
