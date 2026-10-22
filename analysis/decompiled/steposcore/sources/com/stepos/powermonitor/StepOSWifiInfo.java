package com.stepos.powermonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.connectivity.WifiBatteryStats;

/* loaded from: classes.dex */
public class StepOSWifiInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSWifiInfo> CREATOR = new Parcelable.Creator<StepOSWifiInfo>() { // from class: com.stepos.powermonitor.StepOSWifiInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSWifiInfo createFromParcel(Parcel in) {
            return new StepOSWifiInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSWifiInfo[] newArray(int size) {
            return new StepOSWifiInfo[size];
        }
    };
    public long appScanRequestCount;
    public long energyConsumedMaMillis;
    public long idleTimeMillis;
    public long kernelActiveTimeMillis;
    public long loggingDurationMillis;
    public long monitoredRailChargeConsumedMaMillis;
    public long numBytesRx;
    public long numBytesTx;
    public long numPacketsRx;
    public long numPacketsTx;
    public long rxTimeMillis;
    public long scanTimeMillis;
    public long sleepTimeMillis;
    public long[] timeInRxSignalStrengthLevelMillis;
    public long[] timeInStateMillis;
    public long[] timeInSupplicantStateMillis;
    public long txTimeMillis;

    public StepOSWifiInfo() {
    }

    public StepOSWifiInfo(long loggingDurationMillis, long kernelActiveTimeMillis, long numPacketsTx, long numBytesTx, long numPacketsRx, long numBytesRx, long sleepTimeMillis, long scanTimeMillis, long idleTimeMillis, long rxTimeMillis, long txTimeMillis, long energyConsumedMaMillis, long appScanRequestCount, long[] timeInStateMillis, long[] timeInRxSignalStrengthLevelMillis, long[] timeInSupplicantStateMillis, long monitoredRailChargeConsumedMaMillis) {
        this.loggingDurationMillis = loggingDurationMillis;
        this.kernelActiveTimeMillis = kernelActiveTimeMillis;
        this.numPacketsTx = numPacketsTx;
        this.numBytesTx = numBytesTx;
        this.numPacketsRx = numPacketsRx;
        this.numBytesRx = numBytesRx;
        this.sleepTimeMillis = sleepTimeMillis;
        this.scanTimeMillis = scanTimeMillis;
        this.idleTimeMillis = idleTimeMillis;
        this.rxTimeMillis = rxTimeMillis;
        this.txTimeMillis = txTimeMillis;
        this.energyConsumedMaMillis = energyConsumedMaMillis;
        this.appScanRequestCount = appScanRequestCount;
        this.timeInStateMillis = timeInStateMillis;
        this.timeInRxSignalStrengthLevelMillis = timeInRxSignalStrengthLevelMillis;
        this.timeInSupplicantStateMillis = timeInSupplicantStateMillis;
        this.monitoredRailChargeConsumedMaMillis = monitoredRailChargeConsumedMaMillis;
    }

    public static StepOSWifiInfo newWifiBatteryStats(WifiBatteryStats stats) {
        if (stats == null) {
            return null;
        }
        Parcel p = Parcel.obtain();
        try {
            stats.writeToParcel(p, 0);
            p.setDataPosition(0);
            long loggingDurationMillis = p.readLong();
            long kernelActiveTimeMillis = p.readLong();
            long numPacketsTx = p.readLong();
            long numBytesTx = p.readLong();
            long numPacketsRx = p.readLong();
            long numBytesRx = p.readLong();
            long sleepTimeMillis = p.readLong();
            long scanTimeMillis = p.readLong();
            long idleTimeMillis = p.readLong();
            long rxTimeMillis = p.readLong();
            long txTimeMillis = p.readLong();
            long energyConsumedMaMillis = p.readLong();
            long appScanRequestCount = p.readLong();
            long[] timeInStateMillis = p.createLongArray();
            long[] timeInRxSignalStrengthLevelMillis = p.createLongArray();
            long[] timeInSupplicantStateMillis = p.createLongArray();
            long monitoredRailChargeConsumedMaMillis = p.readLong();
            return new StepOSWifiInfo(loggingDurationMillis, kernelActiveTimeMillis, numPacketsTx, numBytesTx, numPacketsRx, numBytesRx, sleepTimeMillis, scanTimeMillis, idleTimeMillis, rxTimeMillis, txTimeMillis, energyConsumedMaMillis, appScanRequestCount, timeInStateMillis, timeInRxSignalStrengthLevelMillis, timeInSupplicantStateMillis, monitoredRailChargeConsumedMaMillis);
        } finally {
            p.recycle();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.loggingDurationMillis);
        dest.writeLong(this.kernelActiveTimeMillis);
        dest.writeLong(this.numPacketsTx);
        dest.writeLong(this.numBytesTx);
        dest.writeLong(this.numPacketsRx);
        dest.writeLong(this.numBytesRx);
        dest.writeLong(this.sleepTimeMillis);
        dest.writeLong(this.scanTimeMillis);
        dest.writeLong(this.idleTimeMillis);
        dest.writeLong(this.rxTimeMillis);
        dest.writeLong(this.txTimeMillis);
        dest.writeLong(this.energyConsumedMaMillis);
        dest.writeLong(this.appScanRequestCount);
        dest.writeLongArray(this.timeInStateMillis);
        dest.writeLongArray(this.timeInRxSignalStrengthLevelMillis);
        dest.writeLongArray(this.timeInSupplicantStateMillis);
        dest.writeLong(this.monitoredRailChargeConsumedMaMillis);
    }

    private StepOSWifiInfo(Parcel in) {
        this.loggingDurationMillis = in.readLong();
        this.kernelActiveTimeMillis = in.readLong();
        this.numPacketsTx = in.readLong();
        this.numBytesTx = in.readLong();
        this.numPacketsRx = in.readLong();
        this.numBytesRx = in.readLong();
        this.sleepTimeMillis = in.readLong();
        this.scanTimeMillis = in.readLong();
        this.idleTimeMillis = in.readLong();
        this.rxTimeMillis = in.readLong();
        this.txTimeMillis = in.readLong();
        this.energyConsumedMaMillis = in.readLong();
        this.appScanRequestCount = in.readLong();
        this.timeInStateMillis = in.createLongArray();
        this.timeInRxSignalStrengthLevelMillis = in.createLongArray();
        this.timeInSupplicantStateMillis = in.createLongArray();
        this.monitoredRailChargeConsumedMaMillis = in.readLong();
    }
}
