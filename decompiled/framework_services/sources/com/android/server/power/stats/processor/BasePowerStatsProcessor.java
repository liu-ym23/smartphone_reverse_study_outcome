package com.android.server.power.stats.processor;

import android.os.PersistableBundle;
import android.util.IntArray;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.BasePowerStatsLayout;
import java.util.Arrays;
import java.util.function.DoubleSupplier;

/* JADX INFO: loaded from: classes3.dex */
class BasePowerStatsProcessor extends PowerStatsProcessor {
    private static final int UNSPECIFIED = -1;
    private static final BasePowerStatsLayout sStatsLayout = null;
    private final DoubleSupplier mBatteryCapacitySupplier;
    private double mBatteryCapacityUah;
    private int mBatteryChargeUah;
    private int mBatteryLevel;
    private long mBatteryLevelTimestampMs;
    private long mCumulativeDischargeDurationMs;
    private int mCumulativeDischargePct;
    private long mCumulativeDischargeUah;
    private PowerStatsProcessor.PowerEstimationPlan mPlan;
    private final PowerStats mPowerStats;
    private final PowerStats.Descriptor mPowerStatsDescriptor;
    private long mStartTimestamp;
    private final long[] mTmpUidStatsArray;

    static {
        sStatsLayout = new BasePowerStatsLayout();
    }

    BasePowerStatsProcessor(DoubleSupplier batteryCapacitySupplier) {
        this.mBatteryCapacitySupplier = batteryCapacitySupplier;
        PersistableBundle extras = new PersistableBundle();
        sStatsLayout.toExtras(extras);
        this.mPowerStatsDescriptor = new PowerStats.Descriptor(18, sStatsLayout.getDeviceStatsArrayLength(), null, 0, sStatsLayout.getUidStatsArrayLength(), extras);
        this.mTmpUidStatsArray = new long[sStatsLayout.getUidStatsArrayLength()];
        this.mPowerStats = new PowerStats(this.mPowerStatsDescriptor);
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void start(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        this.mStartTimestamp = timestampMs;
        stats.setPowerStatsDescriptor(this.mPowerStatsDescriptor);
        this.mBatteryCapacityUah = this.mBatteryCapacitySupplier.getAsDouble() * 1000.0d;
        this.mBatteryLevel = -1;
        this.mBatteryChargeUah = -1;
        this.mBatteryLevelTimestampMs = -1;
        this.mCumulativeDischargeUah = 0;
        this.mCumulativeDischargePct = 0;
        this.mCumulativeDischargeDurationMs = 0;
        stats.addProcessedPowerStats(this.mPowerStats, timestampMs);
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    public void noteBatteryLevel(int batteryLevel, int batteryChargeUah, long timestampMs) {
        boolean discharging = false;
        if (this.mBatteryLevel == (-1)) goto L8;
        if (batteryLevel >= this.mBatteryLevel) goto L8;
        this.mCumulativeDischargePct += this.mBatteryLevel - batteryLevel;
        discharging = true;
    L8:
        if (this.mBatteryChargeUah == (-1)) goto L13;
        if (batteryChargeUah == 0) goto L13;
        if (batteryChargeUah >= this.mBatteryChargeUah) goto L13;
        this.mCumulativeDischargeUah += (long) (this.mBatteryChargeUah - batteryChargeUah);
        discharging = true;
    L13:
        if (discharging == true) goto L15;
    L17:
        this.mBatteryLevel = batteryLevel;
        this.mBatteryChargeUah = batteryChargeUah;
        this.mBatteryLevelTimestampMs = timestampMs;
        return;
    L15:
        if (this.mBatteryLevelTimestampMs == (-1)) goto L17;
        this.mCumulativeDischargeDurationMs += timestampMs - this.mBatteryLevelTimestampMs;
        goto L17
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void finish(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        if (this.mPlan != null) goto L5;
        this.mPlan = new PowerStatsProcessor.PowerEstimationPlan(stats.getConfig());
    L5:
        sStatsLayout.setUsageDuration(this.mPowerStats.stats, timestampMs - this.mStartTimestamp);
        sStatsLayout.addBatteryDischargePercent(this.mPowerStats.stats, this.mCumulativeDischargePct);
        if (this.mCumulativeDischargeUah == 0) goto L8;
        sStatsLayout.addBatteryDischargeUah(this.mPowerStats.stats, this.mCumulativeDischargeUah);
    L9:
        sStatsLayout.addBatteryDischargeDuration(this.mPowerStats.stats, this.mCumulativeDischargeDurationMs);
        int r4 = 0;
        this.mCumulativeDischargePct = 0;
        this.mCumulativeDischargeUah = 0;
        this.mCumulativeDischargeDurationMs = 0;
        IntArray uids = stats.getUids();
        if (uids.size() == 0) goto L14;
        long durationMs = timestampMs - this.mStartTimestamp;
        int i = uids.size() - 1;
    L12:
        if (i < 0) goto L14;
        long[] uidStats = new long[sStatsLayout.getUidStatsArrayLength()];
        sStatsLayout.setUidUsageDuration(uidStats, durationMs);
        this.mPowerStats.uidStats.put(uids.get(i), uidStats);
        i = i - 1;
    L14:
        stats.addPowerStats(this.mPowerStats, timestampMs);
        int i2 = this.mPlan.uidStateEstimates.size() - 1;
    L15:
        if (i2 < 0) goto L25;
        PowerStatsProcessor.UidStateEstimate uidStateEstimate = this.mPlan.uidStateEstimates.get(i2);
        int[] uidStateValues = new int[stats.getConfig().getUidStateConfig().length];
        uidStateValues[2] = r4;
        int j = uids.size() - 1;
    L17:
        if (j < 0) goto L24;
        int uid = uids.get(j);
        int[] stateValues = uidStateEstimate.combinedDeviceStateEstimate.stateValues;
        uidStateValues[1] = stateValues[1];
        uidStateValues[r4] = stateValues[r4];
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, uidStateValues) == false) goto L23;
        if (sStatsLayout.getUidUsageDuration(this.mTmpUidStatsArray) == 0) goto L23;
        sStatsLayout.setUidUsageDuration(this.mTmpUidStatsArray, 0);
        stats.setUidStats(uid, uidStateValues, this.mTmpUidStatsArray);
    L23:
        j = j - 1;
        r4 = 0;
        goto L17
    L24:
        i2 = i2 - 1;
        r4 = 0;
        goto L15
    L25:
        this.mStartTimestamp = timestampMs;
        Arrays.fill(this.mPowerStats.stats, 0);
        this.mPowerStats.uidStats.clear();
        return;
    L8:
        sStatsLayout.addBatteryDischargeUah(this.mPowerStats.stats, (long) ((((double) this.mCumulativeDischargePct) * this.mBatteryCapacityUah) / 100.0d));
        goto L9
    }
}
