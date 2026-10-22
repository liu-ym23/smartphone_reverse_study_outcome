package com.android.server.power.teardown.hwteardown;

import android.telephony.CellSignalStrength;
import android.telephony.ModemActivityInfo;
import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public final class ModemTeardownResult extends ComponentResult {
    public static final int NUM_SIGNAL_STRENGTH_LEVELS = 0;
    public static final int NUM_TX_POWER_LEVELS = 0;
    public int mActiveCurrent;
    public ModemPowerState mModemPowerState;
    public int mScanCurrent;

    public static class ModemPowerState {
        public long mActiveTime;
        public long mNumBytesRx;
        public long mNumBytesTx;
        public long mNumPacketsRx;
        public long mNumPacketsTx;
        public long[] mRxTime;
        public long mScanTime;
        public long[] mTxTime;

        public ModemPowerState(long scanTime, long activeTime, long[] rxTime, long[] txTime, long numPacketsRx, long numPacketsTx, long numBytesRx, long numBytesTx) {
            this.mScanTime = scanTime;
            this.mActiveTime = activeTime;
            this.mRxTime = rxTime;
            this.mTxTime = txTime;
            this.mNumPacketsRx = numPacketsRx;
            this.mNumPacketsTx = numPacketsTx;
            this.mNumBytesRx = numBytesRx;
            this.mNumBytesTx = numBytesTx;
        }

        public ModemPowerState() {
            this.mRxTime = new long[ModemTeardownResult.NUM_SIGNAL_STRENGTH_LEVELS];
            this.mTxTime = new long[ModemTeardownResult.NUM_TX_POWER_LEVELS];
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("scanTime=");
            sb.append(this.mScanTime / 1000);
            sb.append("s, activeTime=");
            sb.append(this.mActiveTime / 1000);
            sb.append("s, rxTime=[");
            int i = 0;
        L4:
            if (i >= this.mRxTime.length) goto L8;
            if (i == 0) goto L7;
            sb.append("s, ");
        L7:
            sb.append(this.mRxTime[i] / 1000);
            i = i + 1;
            goto L4
        L8:
            sb.append("s], txTime=[");
            int i2 = 0;
        L10:
            if (i2 >= this.mTxTime.length) goto L14;
            if (i2 == 0) goto L13;
            sb.append("s, ");
        L13:
            sb.append(this.mTxTime[i2] / 1000);
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

    static {
        NUM_SIGNAL_STRENGTH_LEVELS = CellSignalStrength.getNumSignalStrengthLevels();
        NUM_TX_POWER_LEVELS = ModemActivityInfo.getNumTxPowerLevels();
    }

    public ModemTeardownResult(int modemCurrent, int scanCurrent, int activeCurrent, ModemPowerState modemPowerState) {
        this.mCurrent = modemCurrent;
        this.mScanCurrent = scanCurrent;
        this.mActiveCurrent = activeCurrent;
        this.mModemPowerState = modemPowerState;
    }

    public String toString() {
        return "[Modem] Modem current=" + this.mCurrent + "mA, scanCurrent=" + this.mScanCurrent + "mA, activeCurrent=" + this.mActiveCurrent + "mA, " + this.mModemPowerState.toString() + "\n";
    }
}
