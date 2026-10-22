package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public class FanTeardownResult extends ComponentResult {
    int mBoxFanCurrent;
    long[] mBoxRpmDuration;
    int mHmdFanCurrent;
    long[] mHmdRpmDuration;
    long mTotalDuration;

    public FanTeardownResult(int hmdFanCurrent, int boxFanCurrent, long[] hmdRpmDuration, long[] boxRpmDuration, long duration) {
        this.mHmdFanCurrent = hmdFanCurrent;
        this.mBoxFanCurrent = boxFanCurrent;
        this.mCurrent = this.mHmdFanCurrent + this.mBoxFanCurrent;
        this.mHmdRpmDuration = hmdRpmDuration;
        this.mBoxRpmDuration = boxRpmDuration;
        this.mTotalDuration = duration;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[FAN] fan current: ");
        sb.append(this.mCurrent);
        sb.append("mA, hmd current: ");
        sb.append(this.mHmdFanCurrent);
        sb.append("mA, box current: ");
        sb.append(this.mBoxFanCurrent);
        sb.append("mA, hmd duration=[");
        boolean isFirst = true;
        int i = 0;
    L4:
        if (i >= this.mHmdRpmDuration.length) goto L13;
        if (this.mHmdRpmDuration[i] < 1000) goto L12;
        if (isFirst == true) goto L10;
        sb.append(", ");
    L11:
        sb.append("(");
        sb.append(i);
        sb.append(", ");
        sb.append(this.mHmdRpmDuration[i] / 1000);
        sb.append("s");
        sb.append(")");
        goto L12
    L10:
        isFirst = false;
    L12:
        i = i + 1;
        goto L4
    L13:
        sb.append("], box duration=[");
        boolean isFirst2 = true;
        int i2 = 0;
    L15:
        if (i2 >= this.mBoxRpmDuration.length) goto L24;
        if (this.mBoxRpmDuration[i2] < 1000) goto L23;
        if (isFirst2 == true) goto L21;
        sb.append(", ");
    L22:
        sb.append("(");
        sb.append(i2);
        sb.append(", ");
        sb.append(this.mBoxRpmDuration[i2] / 1000);
        sb.append("s");
        sb.append(")");
        goto L23
    L21:
        isFirst2 = false;
    L23:
        i2 = i2 + 1;
        goto L15
    L24:
        sb.append("]\n");
        return sb.toString();
    }
}
