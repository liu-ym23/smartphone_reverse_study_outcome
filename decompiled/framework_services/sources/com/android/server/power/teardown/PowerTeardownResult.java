package com.android.server.power.teardown;

import com.android.server.power.teardown.hwteardown.HwTeardownResult;
import com.android.server.power.teardown.swteardown.SwTeardownResult;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class PowerTeardownResult {
    public int mBatteryLevel;
    public int mDeviceCurrent;
    public long mEndTime;
    public LinkedList<HwTeardownResult> mHwResults;
    public long mStartTime;
    public LinkedList<SwTeardownResult> mSwResults;

    public PowerTeardownResult(long startTime, long endTime, int batteryLevel, int deviceCurrent, LinkedList<HwTeardownResult> hwResults, LinkedList<SwTeardownResult> swResults) {
        this.mStartTime = startTime;
        this.mEndTime = endTime;
        this.mBatteryLevel = batteryLevel;
        this.mDeviceCurrent = deviceCurrent;
        this.mHwResults = hwResults;
        this.mSwResults = swResults;
    }

    public double calculateConfidence() {
        return 1.0d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("startTime=");
        sb.append(this.mStartTime);
        sb.append(", endTime=");
        sb.append(this.mEndTime);
        sb.append(", batteryLevel=");
        sb.append(this.mBatteryLevel);
        sb.append(", deviceCurrent=");
        sb.append(this.mDeviceCurrent);
        sb.append(", hwResult=[");
        if (this.mHwResults == null) goto L8;
        Iterator<HwTeardownResult> r1 = this.mHwResults.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        HwTeardownResult hwResult = r1.next();
        sb.append("[");
        sb.append(hwResult.toString());
        sb.append("], ");
    L8:
        sb.append("], swResult=[");
        if (this.mSwResults == null) goto L14;
        Iterator<SwTeardownResult> r2 = this.mSwResults.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        SwTeardownResult swResult = r2.next();
        sb.append("[");
        sb.append(swResult.toString());
        sb.append("], ");
    L14:
        sb.append("]");
        return sb.toString();
    }
}
