package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public class WifiTeardownResult extends ComponentResult {
    public static final int NETWORK_TYPE_NUM = 4;
    public static final int NUM_WIFI_SIGNAL_STRENGTH_BINS = 5;
    public final int mActiveCurrent;
    public final int mOldModelCurrent;
    public final int mScanCurrent;
    public final int mWifiApCurrent;
    public final WifiPowerState mWifiPowerState;

    public static class WifiPowerState {
        public long mActiveTime;
        public long mNumBytesRx;
        public long mNumBytesTx;
        public long mNumPacketsRx;
        public long mNumPacketsTx;
        public long mScanTime;
        public long[] mSignalStrengthTime;
        public long[] mWifiApTime;

        public WifiPowerState(long scanTimeMs, long activeTime, long[] wifiApTime, long numPacketsRx, long numPacketsTx, long numBytesRx, long numBytesTx, long[] signalQualityTime) {
            this.mScanTime = scanTimeMs;
            this.mActiveTime = activeTime;
            this.mWifiApTime = wifiApTime;
            this.mNumPacketsRx = numPacketsRx;
            this.mNumPacketsTx = numPacketsTx;
            this.mNumBytesRx = numBytesRx;
            this.mNumBytesTx = numBytesTx;
            this.mSignalStrengthTime = signalQualityTime;
        }

        public WifiPowerState() {
            this.mSignalStrengthTime = new long[5];
            this.mWifiApTime = new long[4];
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("scanTime=");
            sb.append(this.mScanTime / 1000);
            sb.append("s, activeTime=");
            sb.append(this.mActiveTime / 1000);
            sb.append("s, wifiApTime=[");
            int i = 0;
        L4:
            if (i >= this.mWifiApTime.length) goto L8;
            if (i == 0) goto L7;
            sb.append("s, ");
        L7:
            sb.append(this.mWifiApTime[i] / 1000);
            i = i + 1;
            goto L4
        L8:
            sb.append("s], signalStrengthTime=[");
            int i2 = 0;
        L10:
            if (i2 >= this.mSignalStrengthTime.length) goto L14;
            if (i2 == 0) goto L13;
            sb.append("s, ");
        L13:
            sb.append(this.mSignalStrengthTime[i2] / 1000);
            i2 = i2 + 1;
            goto L10
        L14:
            sb.append("s], numPacketsRx=");
            sb.append(this.mNumPacketsRx);
            sb.append(", numPacketsTx=");
            sb.append(this.mNumPacketsTx);
            sb.append(", numBytesRx=");
            sb.append(this.mNumBytesRx);
            sb.append(", numBytesTx=");
            sb.append(this.mNumBytesTx);
            return sb.toString();
        }
    }

    public WifiTeardownResult(int wifiCurrent, int oldCurrent, int scanCurrent, int activeCurrent, int wifiApCurrent, WifiPowerState wifiPowerState) {
        this.mCurrent = wifiCurrent;
        this.mOldModelCurrent = oldCurrent;
        this.mScanCurrent = scanCurrent;
        this.mActiveCurrent = activeCurrent;
        this.mWifiApCurrent = wifiApCurrent;
        this.mWifiPowerState = wifiPowerState;
    }

    public String toString() {
        return "[WIFI] wifi current=" + this.mCurrent + "mA, oldModelCurrent = " + this.mOldModelCurrent + "mA, scanCurrent=" + this.mScanCurrent + "mA, activeCurrent=" + this.mActiveCurrent + "mA, wifiApCurrent:" + this.mWifiApCurrent + "mA, " + this.mWifiPowerState.toString() + "\n";
    }
}
