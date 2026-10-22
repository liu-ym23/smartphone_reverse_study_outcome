package com.android.server.power.stats.processor;

import android.util.IntArray;
import android.util.Slog;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.UsageBasedPowerEstimator;
import com.android.server.power.stats.format.ScreenPowerStatsLayout;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class ScreenPowerStatsProcessor extends PowerStatsProcessor {
    private static final String TAG = "ScreenPowerStatsProcessor";
    private final int mDisplayCount;
    private PowerStats.Descriptor mLastUsedDescriptor;
    private PowerStatsProcessor.PowerEstimationPlan mPlan;
    private final UsageBasedPowerEstimator[][] mScreenBrightnessLevelPowerEstimators;
    private final UsageBasedPowerEstimator[] mScreenDozePowerEstimators;
    private final UsageBasedPowerEstimator[] mScreenOnPowerEstimators;
    private ScreenPowerStatsLayout mStatsLayout;
    private long[] mTmpDeviceStatsArray;
    private long[] mTmpUidStatsArray;

    private static class Intermediates {
        public double power;

        /* synthetic */ Intermediates(ScreenPowerStatsProcessorIA r1) {
            this();
        }

        private Intermediates() {
        }
    }

    ScreenPowerStatsProcessor(PowerProfile powerProfile) {
        this.mDisplayCount = powerProfile.getNumDisplays();
        this.mScreenOnPowerEstimators = new UsageBasedPowerEstimator[this.mDisplayCount];
        this.mScreenDozePowerEstimators = new UsageBasedPowerEstimator[this.mDisplayCount];
        this.mScreenBrightnessLevelPowerEstimators = new UsageBasedPowerEstimator[this.mDisplayCount][];
        int display = 0;
    L4:
        if (display >= this.mDisplayCount) goto L10;
        this.mScreenOnPowerEstimators[display] = new UsageBasedPowerEstimator(powerProfile.getAveragePowerForOrdinal("screen.on.display", display));
        double averagePowerFullBrightness = powerProfile.getAveragePowerForOrdinal("screen.full.display", display);
        this.mScreenBrightnessLevelPowerEstimators[display] = new UsageBasedPowerEstimator[5];
        int bin = 0;
    L6:
        if (bin >= 5) goto L8;
        double binPowerMah = ((((double) bin) + 0.5d) * averagePowerFullBrightness) / 5.0d;
        this.mScreenBrightnessLevelPowerEstimators[display][bin] = new UsageBasedPowerEstimator(binPowerMah);
        bin = bin + 1;
        goto L6
    L8:
        this.mScreenDozePowerEstimators[display] = new UsageBasedPowerEstimator(powerProfile.getAveragePowerForOrdinal("ambient.on.display", display));
        display = display + 1;
        goto L4
    }

    private boolean unpackPowerStatsDescriptor(PowerStats.Descriptor descriptor) {
        if (descriptor != null) goto L6;
        return false;
    L6:
        if (descriptor.equals(this.mLastUsedDescriptor) == false) goto L8;
        return true;
    L8:
        ScreenPowerStatsLayout statsLayout = new ScreenPowerStatsLayout(descriptor);
        if (statsLayout.getDisplayCount() == this.mDisplayCount) goto L12;
        Slog.e(TAG, "Incompatible number of displays: " + statsLayout.getDisplayCount() + ", expected: " + this.mDisplayCount);
        return false;
    L12:
        this.mLastUsedDescriptor = descriptor;
        this.mStatsLayout = statsLayout;
        this.mTmpDeviceStatsArray = new long[descriptor.statsArrayLength];
        this.mTmpUidStatsArray = new long[descriptor.uidStatsArrayLength];
        return true;
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void finish(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        if (unpackPowerStatsDescriptor(stats.getPowerStatsDescriptor()) == true) goto L6;
        return;
    L6:
        if (this.mPlan != null) goto L8;
        this.mPlan = new PowerStatsProcessor.PowerEstimationPlan(stats.getConfig());
    L8:
        computeDevicePowerEstimates(stats);
        combineDeviceStateEstimates();
        IntArray uids = stats.getActiveUids();
        if (uids.size() == 0) goto L11;
        computeUidPowerEstimates(stats, uids);
    L11:
        this.mPlan.resetIntermediates();
    }

    private void computeDevicePowerEstimates(PowerComponentAggregatedPowerStats stats) {
        int i = this.mPlan.deviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L29;
        PowerStatsProcessor.DeviceStateEstimation estimation = this.mPlan.deviceStateEstimations.get(i);
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, estimation.stateValues) == false) goto L27;
        if (estimation.stateValues[1] == 0) goto L10;
        double power = 0.0d;
        if (this.mStatsLayout.getEnergyConsumerCount() <= 0) goto L20;
        double power2 = PowerStatsProcessor.uCtoMah(this.mStatsLayout.getConsumedEnergy(this.mTmpDeviceStatsArray, 0));
    L25:
        this.mStatsLayout.setScreenDozePowerEstimate(this.mTmpDeviceStatsArray, power2);
    L26:
        stats.setDeviceStats(estimation.stateValues, this.mTmpDeviceStatsArray);
        goto L27
    L20:
        int display = 0;
    L22:
        if (display >= this.mStatsLayout.getDisplayCount()) goto L24;
        power = power + this.mScreenDozePowerEstimators[display].calculatePower(this.mStatsLayout.getScreenDozeDuration(this.mTmpDeviceStatsArray, display));
        display = display + 1;
        goto L22
    L24:
        power2 = power;
        goto L25
    L10:
        if (this.mStatsLayout.getEnergyConsumerCount() <= 0) goto L12;
        double power3 = PowerStatsProcessor.uCtoMah(this.mStatsLayout.getConsumedEnergy(this.mTmpDeviceStatsArray, 0));
    L16:
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, power3);
        Intermediates intermediates = new Intermediates(null);
        intermediates.power = power3;
        estimation.intermediates = intermediates;
        goto L26
    L12:
        power3 = 0.0d;
        int display2 = 0;
    L14:
        if (display2 >= this.mStatsLayout.getDisplayCount()) goto L16;
        power3 = power3 + computeDisplayPower(this.mTmpDeviceStatsArray, display2);
        display2 = display2 + 1;
    L27:
        i = i - 1;
        goto L3
    }

    private double computeDisplayPower(long[] stats, int display) {
        double power = this.mScreenOnPowerEstimators[display].calculatePower(this.mStatsLayout.getScreenOnDuration(stats, display));
        int bin = 0;
    L4:
        if (bin >= 5) goto L7;
        power = power + this.mScreenBrightnessLevelPowerEstimators[display][bin].calculatePower(this.mStatsLayout.getBrightnessLevelDuration(stats, display, bin));
        bin = bin + 1;
        goto L4
    L7:
        return power;
    }

    private void combineDeviceStateEstimates() {
        int i = this.mPlan.combinedDeviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L15;
        PowerStatsProcessor.CombinedDeviceStateEstimate cdse = this.mPlan.combinedDeviceStateEstimations.get(i);
        List<PowerStatsProcessor.DeviceStateEstimation> deviceStateEstimations = cdse.deviceStateEstimations;
        double power = 0.0d;
        int j = deviceStateEstimations.size() - 1;
    L5:
        if (j < 0) goto L11;
        PowerStatsProcessor.DeviceStateEstimation dse = deviceStateEstimations.get(j);
        Intermediates intermediates = (Intermediates) dse.intermediates;
        if (intermediates == null) goto L9;
        power = power + intermediates.power;
    L9:
        j = j - 1;
        goto L5
    L11:
        if (power == 0.0d) goto L13;
        Intermediates cdseIntermediates = new Intermediates(null);
        cdseIntermediates.power = power;
        cdse.intermediates = cdseIntermediates;
    L13:
        i = i - 1;
        goto L3
    }

    private void computeUidPowerEstimates(PowerComponentAggregatedPowerStats stats, IntArray uids) {
        int[] uidStateValues = new int[stats.getConfig().getUidStateConfig().length];
        int r4 = 1;
        char r5 = 0;
        uidStateValues[1] = 0;
        uidStateValues[2] = 0;
        int i = this.mPlan.uidStateEstimates.size() - 1;
    L3:
        if (i < 0) goto L31;
        PowerStatsProcessor.UidStateEstimate uidStateEstimate = this.mPlan.uidStateEstimates.get(i);
        Intermediates intermediates = (Intermediates) uidStateEstimate.combinedDeviceStateEstimate.intermediates;
        int[] deviceStateValues = uidStateEstimate.combinedDeviceStateEstimate.stateValues;
        if (deviceStateValues[r4] != 0) goto L28;
        if (intermediates != null) goto L8;
        int i2 = i;
    L29:
        i = i2 - 1;
        r4 = 1;
        r5 = 0;
        goto L3
    L8:
        uidStateValues[r5] = deviceStateValues[r5];
        long totalTopActivityDuration = 0;
        int j = uids.size() - r4;
    L9:
        if (j < 0) goto L14;
        if (stats.getUidStats(this.mTmpUidStatsArray, uids.get(j), uidStateValues) == false) goto L13;
        totalTopActivityDuration = totalTopActivityDuration + this.mStatsLayout.getUidTopActivityDuration(this.mTmpUidStatsArray);
    L13:
        j = j - 1;
        goto L9
    L14:
        long r12 = 0;
        if (totalTopActivityDuration == 0) goto L16;
        int j2 = uids.size() - r4;
    L18:
        if (j2 < 0) goto L27;
        int uid = uids.get(j2);
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, uidStateValues) == false) goto L26;
        long duration = this.mStatsLayout.getUidTopActivityDuration(this.mTmpUidStatsArray);
        if (duration == r12) goto L26;
        double power = (intermediates.power * duration) / totalTopActivityDuration;
        this.mStatsLayout.setUidPowerEstimate(this.mTmpUidStatsArray, power);
        stats.setUidStats(uid, uidStateValues, this.mTmpUidStatsArray);
    L26:
        j2 = j2 - 1;
        i = i;
        uidStateEstimate = uidStateEstimate;
        r12 = 0;
        goto L18
    L27:
        i2 = i;
        goto L29
    L16:
        return;
    L28:
        i2 = i;
        goto L29
    }
}
