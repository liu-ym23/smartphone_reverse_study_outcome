package com.android.server.power.stats.format;

import android.os.PersistableBundle;
import android.telephony.ModemActivityInfo;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.PowerStats;

/* JADX INFO: loaded from: classes3.dex */
public class MobileRadioPowerStatsLayout extends PowerStatsLayout {
    private static final String EXTRA_DEVICE_CALL_POWER_POSITION = "dp-call";
    private static final String EXTRA_DEVICE_CALL_TIME_POSITION = "dt-call";
    private static final String EXTRA_DEVICE_IDLE_TIME_POSITION = "dt-idle";
    private static final String EXTRA_DEVICE_SCAN_TIME_POSITION = "dt-scan";
    private static final String EXTRA_DEVICE_SLEEP_TIME_POSITION = "dt-sleep";
    private static final String EXTRA_STATE_RX_TIME_POSITION = "srx";
    private static final String EXTRA_STATE_TX_TIMES_COUNT = "stxc";
    private static final String EXTRA_STATE_TX_TIMES_POSITION = "stx";
    private static final String EXTRA_UID_RX_BYTES_POSITION = "urxb";
    private static final String EXTRA_UID_RX_PACKETS_POSITION = "urxp";
    private static final String EXTRA_UID_TX_BYTES_POSITION = "utxb";
    private static final String EXTRA_UID_TX_PACKETS_POSITION = "utxp";
    private static final String TAG = "MobileRadioPowerStatsLayout";
    private int mDeviceCallPowerPosition;
    private int mDeviceCallTimePosition;
    private int mDeviceIdleTimePosition;
    private int mDeviceScanTimePosition;
    private int mDeviceSleepTimePosition;
    private int mStateRxTimePosition;
    private int mStateTxTimesCount;
    private int mStateTxTimesPosition;
    private int mUidRxBytesPosition;
    private int mUidRxPacketsPosition;
    private int mUidTxBytesPosition;
    private int mUidTxPacketsPosition;

    public MobileRadioPowerStatsLayout(int energyConsumerCount) {
        addDeviceMobileActivity();
        addDeviceSectionEnergyConsumers(energyConsumerCount);
        addStateStats();
        addUidNetworkStats();
        addDeviceSectionUsageDuration();
        addDeviceSectionPowerEstimate();
        addUidSectionPowerEstimate();
    }

    public MobileRadioPowerStatsLayout(PowerStats.Descriptor descriptor) {
        super(descriptor);
        PersistableBundle extras = descriptor.extras;
        this.mDeviceSleepTimePosition = extras.getInt(EXTRA_DEVICE_SLEEP_TIME_POSITION);
        this.mDeviceIdleTimePosition = extras.getInt(EXTRA_DEVICE_IDLE_TIME_POSITION);
        this.mDeviceScanTimePosition = extras.getInt(EXTRA_DEVICE_SCAN_TIME_POSITION);
        this.mDeviceCallTimePosition = extras.getInt(EXTRA_DEVICE_CALL_TIME_POSITION);
        this.mDeviceCallPowerPosition = extras.getInt(EXTRA_DEVICE_CALL_POWER_POSITION);
        this.mStateRxTimePosition = extras.getInt(EXTRA_STATE_RX_TIME_POSITION);
        this.mStateTxTimesPosition = extras.getInt(EXTRA_STATE_TX_TIMES_POSITION);
        this.mStateTxTimesCount = extras.getInt(EXTRA_STATE_TX_TIMES_COUNT);
        this.mUidRxBytesPosition = extras.getInt(EXTRA_UID_RX_BYTES_POSITION);
        this.mUidTxBytesPosition = extras.getInt(EXTRA_UID_TX_BYTES_POSITION);
        this.mUidRxPacketsPosition = extras.getInt(EXTRA_UID_RX_PACKETS_POSITION);
        this.mUidTxPacketsPosition = extras.getInt(EXTRA_UID_TX_PACKETS_POSITION);
    }

    @Override // com.android.server.power.stats.format.PowerStatsLayout
    public void toExtras(PersistableBundle extras) {
        super.toExtras(extras);
        extras.putInt(EXTRA_DEVICE_SLEEP_TIME_POSITION, this.mDeviceSleepTimePosition);
        extras.putInt(EXTRA_DEVICE_IDLE_TIME_POSITION, this.mDeviceIdleTimePosition);
        extras.putInt(EXTRA_DEVICE_SCAN_TIME_POSITION, this.mDeviceScanTimePosition);
        extras.putInt(EXTRA_DEVICE_CALL_TIME_POSITION, this.mDeviceCallTimePosition);
        extras.putInt(EXTRA_DEVICE_CALL_POWER_POSITION, this.mDeviceCallPowerPosition);
        extras.putInt(EXTRA_STATE_RX_TIME_POSITION, this.mStateRxTimePosition);
        extras.putInt(EXTRA_STATE_TX_TIMES_POSITION, this.mStateTxTimesPosition);
        extras.putInt(EXTRA_STATE_TX_TIMES_COUNT, this.mStateTxTimesCount);
        extras.putInt(EXTRA_UID_RX_BYTES_POSITION, this.mUidRxBytesPosition);
        extras.putInt(EXTRA_UID_TX_BYTES_POSITION, this.mUidTxBytesPosition);
        extras.putInt(EXTRA_UID_RX_PACKETS_POSITION, this.mUidRxPacketsPosition);
        extras.putInt(EXTRA_UID_TX_PACKETS_POSITION, this.mUidTxPacketsPosition);
    }

    public static int makeStateKey(int rat, int freqRange) {
        if (rat == 2) goto L5;
        return rat;
    L5:
        return (freqRange << 8) | rat;
    }

    public static int mapRadioAccessNetworkTypeToRadioAccessTechnology(int networkType) {
        switch(networkType) {
            case 0: goto L10;
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Unhandled RadioAccessNetworkType (" + networkType + "), mapping to OTHER");
        return 0;
    L6:
        return 2;
    L8:
        return 1;
    L10:
        return 0;
    }

    private void addDeviceMobileActivity() {
        this.mDeviceSleepTimePosition = addDeviceSection(1, "sleep");
        this.mDeviceIdleTimePosition = addDeviceSection(1, "idle");
        this.mDeviceScanTimePosition = addDeviceSection(1, "scan");
        this.mDeviceCallTimePosition = addDeviceSection(1, "call", 1);
    }

    private void addStateStats() {
        this.mStateRxTimePosition = addStateSection(1, "rx");
        this.mStateTxTimesCount = ModemActivityInfo.getNumTxPowerLevels();
        this.mStateTxTimesPosition = addStateSection(this.mStateTxTimesCount, "tx");
    }

    private void addUidNetworkStats() {
        this.mUidRxPacketsPosition = addUidSection(1, "rx-pkts");
        this.mUidRxBytesPosition = addUidSection(1, "rx-B");
        this.mUidTxPacketsPosition = addUidSection(1, "tx-pkts");
        this.mUidTxBytesPosition = addUidSection(1, "tx-B");
    }

    @Override // com.android.server.power.stats.format.PowerStatsLayout
    protected void addDeviceSectionPowerEstimate() {
        super.addDeviceSectionPowerEstimate();
        this.mDeviceCallPowerPosition = addDeviceSection(1, "call-power", 2);
    }

    public void setDeviceSleepTime(long[] stats, long durationMillis) {
        stats[this.mDeviceSleepTimePosition] = durationMillis;
    }

    public long getDeviceSleepTime(long[] stats) {
        return stats[this.mDeviceSleepTimePosition];
    }

    public void setDeviceIdleTime(long[] stats, long durationMillis) {
        stats[this.mDeviceIdleTimePosition] = durationMillis;
    }

    public long getDeviceIdleTime(long[] stats) {
        return stats[this.mDeviceIdleTimePosition];
    }

    public void setDeviceScanTime(long[] stats, long durationMillis) {
        stats[this.mDeviceScanTimePosition] = durationMillis;
    }

    public long getDeviceScanTime(long[] stats) {
        return stats[this.mDeviceScanTimePosition];
    }

    public void setDeviceCallTime(long[] stats, long durationMillis) {
        stats[this.mDeviceCallTimePosition] = durationMillis;
    }

    public long getDeviceCallTime(long[] stats) {
        return stats[this.mDeviceCallTimePosition];
    }

    public void setDeviceCallPowerEstimate(long[] stats, double power) {
        stats[this.mDeviceCallPowerPosition] = (long) (1000000.0d * power);
    }

    public double getDeviceCallPowerEstimate(long[] stats) {
        return stats[this.mDeviceCallPowerPosition] / 1000000.0d;
    }

    public void setStateRxTime(long[] stats, long durationMillis) {
        stats[this.mStateRxTimePosition] = durationMillis;
    }

    public long getStateRxTime(long[] stats) {
        return stats[this.mStateRxTimePosition];
    }

    public void setStateTxTime(long[] stats, int level, int durationMillis) {
        stats[this.mStateTxTimesPosition + level] = durationMillis;
    }

    public long getStateTxTime(long[] stats, int level) {
        return stats[this.mStateTxTimesPosition + level];
    }

    public void setUidRxBytes(long[] stats, long count) {
        stats[this.mUidRxBytesPosition] = count;
    }

    public long getUidRxBytes(long[] stats) {
        return stats[this.mUidRxBytesPosition];
    }

    public void setUidTxBytes(long[] stats, long count) {
        stats[this.mUidTxBytesPosition] = count;
    }

    public long getUidTxBytes(long[] stats) {
        return stats[this.mUidTxBytesPosition];
    }

    public void setUidRxPackets(long[] stats, long count) {
        stats[this.mUidRxPacketsPosition] = count;
    }

    public long getUidRxPackets(long[] stats) {
        return stats[this.mUidRxPacketsPosition];
    }

    public void setUidTxPackets(long[] stats, long count) {
        stats[this.mUidTxPacketsPosition] = count;
    }

    public long getUidTxPackets(long[] stats) {
        return stats[this.mUidTxPacketsPosition];
    }

    public void addRxTxTimesForRat(SparseArray<long[]> stateStats, int networkType, int freqRange, long rxTime, int[] txTime) {
        if (txTime.length == this.mStateTxTimesCount) goto L6;
        Slog.wtf(TAG, "Invalid TX time array size: " + txTime.length);
        return;
    L6:
        boolean nonZero = false;
        if (rxTime == 0) goto L9;
        nonZero = true;
    L15:
        if (nonZero == true) goto L17;
        return;
    L17:
        int rat = mapRadioAccessNetworkTypeToRadioAccessTechnology(networkType);
        int stateKey = makeStateKey(rat, freqRange);
        long[] stats = stateStats.get(stateKey);
        if (stats != null) goto L20;
        stats = new long[getStateStatsArrayLength()];
        stateStats.put(stateKey, stats);
    L20:
        int r5 = this.mStateRxTimePosition;
        stats[r5] = stats[r5] + rxTime;
        int i = this.mStateTxTimesCount - 1;
    L21:
        if (i < 0) goto L24;
        int r6 = this.mStateTxTimesPosition + i;
        stats[r6] = stats[r6] + ((long) txTime[i]);
        i = i - 1;
        goto L21
    L24:
        return;
    L9:
        int i2 = txTime.length - 1;
    L10:
        if (i2 < 0) goto L15;
        if (txTime[i2] != 0) goto L13;
        i2 = i2 - 1;
        goto L10
    L13:
        nonZero = true;
        goto L15
    }
}
