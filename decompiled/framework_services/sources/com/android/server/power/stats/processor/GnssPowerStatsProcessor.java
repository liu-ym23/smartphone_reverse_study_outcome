package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.PowerStats;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.power.stats.UsageBasedPowerEstimator;
import com.android.server.power.stats.format.GnssPowerStatsLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class GnssPowerStatsProcessor extends BinaryStatePowerStatsProcessor {
    private static final GnssPowerStatsLayout sStatsLayout = null;
    private final long[] mGnssSignalDurations;
    private int mGnssSignalLevel;
    private long mGnssSignalLevelTimestamp;
    private final UsageBasedPowerEstimator[] mSignalLevelEstimators;
    private long[] mTmpDeviceStatsArray;
    private final boolean mUseSignalLevelEstimators;

    static {
        sStatsLayout = new GnssPowerStatsLayout();
    }

    GnssPowerStatsProcessor(PowerProfile powerProfile) {
        super(10, powerProfile.getAveragePower("gps.on"), sStatsLayout);
        this.mSignalLevelEstimators = new UsageBasedPowerEstimator[2];
        this.mGnssSignalDurations = new long[2];
        boolean useSignalLevelEstimators = false;
        int level = 0;
    L3:
        if (level >= 2) goto L8;
        double power = powerProfile.getAveragePower("gps.signalqualitybased", level);
        if (power == 0.0d) goto L7;
        useSignalLevelEstimators = true;
    L7:
        this.mSignalLevelEstimators[level] = new UsageBasedPowerEstimator(power);
        level = level + 1;
        goto L3
    L8:
        this.mUseSignalLevelEstimators = useSignalLevelEstimators;
    }

    @Override // com.android.server.power.stats.processor.BinaryStatePowerStatsProcessor, com.android.server.power.stats.processor.PowerStatsProcessor
    void start(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        super.start(stats, timestampMs);
        this.mGnssSignalLevelTimestamp = timestampMs;
        this.mGnssSignalLevel = -1;
        Arrays.fill(this.mGnssSignalDurations, 0);
    }

    @Override // com.android.server.power.stats.processor.BinaryStatePowerStatsProcessor
    protected int getBinaryState(BatteryStats.HistoryItem item) {
        if ((item.states & 536870912) == 0) goto L5;
        return 1;
    L5:
        return 0;
    }

    @Override // com.android.server.power.stats.processor.BinaryStatePowerStatsProcessor, com.android.server.power.stats.processor.PowerStatsProcessor
    void noteStateChange(PowerComponentAggregatedPowerStats stats, BatteryStats.HistoryItem item) {
        super.noteStateChange(stats, item);
        if ((item.states & 536870912) == 0) goto L7;
        int signalLevel = (item.states2 & FrameworkStatsLog.NON_A11Y_TOOL_SERVICE_WARNING_REPORT) >> 7;
        if (signalLevel < 2) goto L9;
        signalLevel = 1;
    L9:
        if (signalLevel != this.mGnssSignalLevel) goto L12;
        return;
    L12:
        if (this.mGnssSignalLevel == (-1)) goto L14;
        long[] r1 = this.mGnssSignalDurations;
        int r2 = this.mGnssSignalLevel;
        r1[r2] = r1[r2] + (item.time - this.mGnssSignalLevelTimestamp);
    L14:
        this.mGnssSignalLevel = signalLevel;
        this.mGnssSignalLevelTimestamp = item.time;
        return;
    L7:
        signalLevel = -1;
        goto L9
    }

    @Override // com.android.server.power.stats.processor.BinaryStatePowerStatsProcessor
    protected void recordUsageDuration(PowerStats powerStats, int uid, long time) {
        super.recordUsageDuration(powerStats, uid, time);
        if (this.mGnssSignalLevel == (-1)) goto L6;
        long[] r0 = this.mGnssSignalDurations;
        int r2 = this.mGnssSignalLevel;
        r0[r2] = r0[r2] + (time - this.mGnssSignalLevelTimestamp);
    L8:
        int level = 0;
    L10:
        if (level >= 2) goto L18;
        long duration = this.mGnssSignalDurations[level];
        sStatsLayout.setDeviceSignalLevelTime(powerStats.stats, level, duration);
        if (uid == (-1)) goto L17;
        long[] uidStats = (long[]) powerStats.uidStats.get(uid);
        if (uidStats != null) goto L16;
        long[] uidStats2 = new long[powerStats.descriptor.uidStatsArrayLength];
        powerStats.uidStats.put(uid, uidStats2);
        sStatsLayout.setUidSignalLevelTime(uidStats2, level, duration);
        goto L17
    L16:
        sStatsLayout.setUidSignalLevelTime(uidStats, level, sStatsLayout.getUidSignalLevelTime(uidStats, level) + duration);
    L17:
        level = level + 1;
        goto L10
    L18:
        this.mGnssSignalLevelTimestamp = time;
        Arrays.fill(this.mGnssSignalDurations, 0);
        return;
    L6:
        if (this.mUseSignalLevelEstimators == false) goto L8;
        long[] r1 = this.mGnssSignalDurations;
        r1[1] = r1[1] + (time - this.mGnssSignalLevelTimestamp);
        goto L8
    }

    @Override // com.android.server.power.stats.processor.BinaryStatePowerStatsProcessor
    protected void computeDevicePowerEstimates(PowerComponentAggregatedPowerStats stats, PowerStatsProcessor.PowerEstimationPlan plan, boolean energyConsumerSupported) {
        if (this.mUseSignalLevelEstimators == false) goto L22;
        if (energyConsumerSupported == true) goto L22;
        if (this.mTmpDeviceStatsArray != null) goto L9;
        this.mTmpDeviceStatsArray = new long[stats.getPowerStatsDescriptor().statsArrayLength];
    L9:
        int i = plan.deviceStateEstimations.size() - 1;
    L10:
        if (i < 0) goto L21;
        PowerStatsProcessor.DeviceStateEstimation estimation = plan.deviceStateEstimations.get(i);
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, estimation.stateValues) == false) goto L19;
        double power = 0.0d;
        int level = 0;
    L16:
        if (level >= 2) goto L18;
        long duration = sStatsLayout.getDeviceSignalLevelTime(this.mTmpDeviceStatsArray, level);
        power = power + this.mSignalLevelEstimators[level].calculatePower(duration);
        level = level + 1;
        goto L16
    L18:
        sStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, power);
        stats.setDeviceStats(estimation.stateValues, this.mTmpDeviceStatsArray);
    L19:
        i = i - 1;
        goto L10
    L21:
        return;
    L22:
        super.computeDevicePowerEstimates(stats, plan, energyConsumerSupported);
    }
}
