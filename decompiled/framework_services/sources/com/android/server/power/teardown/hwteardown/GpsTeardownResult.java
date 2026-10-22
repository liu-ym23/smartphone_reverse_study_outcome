package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public class GpsTeardownResult extends ComponentResult {
    public static final int GNSS_SIGNAL_QUALITY_GOOD = 1;
    public static final int GNSS_SIGNAL_QUALITY_NOGPS = 2;
    public static final int GNSS_SIGNAL_QUALITY_POOR = 0;
    public static final int NUM_GPS_SIGNAL_QUALITY_LEVELS = 3;
    public GpsPowerState mGpsPowerState;

    public static class GpsPowerState {
        public long[] mGpsSignalQualityTime;

        public GpsPowerState(long[] signalQualityTime) {
            this.mGpsSignalQualityTime = signalQualityTime;
        }

        public GpsPowerState() {
            this.mGpsSignalQualityTime = new long[3];
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("signalQualityTime=[");
            int i = 0;
        L4:
            if (i >= this.mGpsSignalQualityTime.length) goto L8;
            if (i == 0) goto L7;
            sb.append("s, ");
        L7:
            sb.append(this.mGpsSignalQualityTime[i] / 1000);
            i = i + 1;
            goto L4
        L8:
            sb.append("s]");
            return sb.toString();
        }
    }

    public GpsTeardownResult(int gpsCurrent, long[] signalQualityTime) {
        this.mCurrent = gpsCurrent;
        this.mGpsPowerState = new GpsPowerState(signalQualityTime);
    }

    public String toString() {
        return "[GPS] gps current=" + this.mCurrent + "mA, " + this.mGpsPowerState.toString() + "\n";
    }
}
