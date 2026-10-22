package com.android.server.power.stats.processor;

import android.util.IntArray;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.EnergyConsumerPowerStatsLayout;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class CustomEnergyConsumerPowerStatsProcessor extends PowerStatsProcessor {
    private static final EnergyConsumerPowerStatsLayout sLayout = null;
    private PowerStatsProcessor.PowerEstimationPlan mPlan;
    private long[] mTmpDeviceStatsArray;
    private long[] mTmpUidStatsArray;

    CustomEnergyConsumerPowerStatsProcessor() {
    }

    static {
        sLayout = new EnergyConsumerPowerStatsLayout();
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void finish(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        PowerStats.Descriptor descriptor = stats.getPowerStatsDescriptor();
        this.mTmpDeviceStatsArray = new long[descriptor.statsArrayLength];
        this.mTmpUidStatsArray = new long[descriptor.uidStatsArrayLength];
        if (this.mPlan != null) goto L5;
        this.mPlan = new PowerStatsProcessor.PowerEstimationPlan(stats.getConfig());
    L5:
        computeDevicePowerEstimates(stats);
        IntArray uids = stats.getActiveUids();
        if (uids.size() == 0) goto L9;
        computeUidPowerEstimates(stats, uids);
        return;
    }

    private void computeDevicePowerEstimates(PowerComponentAggregatedPowerStats stats) {
        int i = this.mPlan.deviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L10;
        PowerStatsProcessor.DeviceStateEstimation estimation = this.mPlan.deviceStateEstimations.get(i);
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, estimation.stateValues) == false) goto L8;
        sLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, PowerStatsProcessor.uCtoMah(sLayout.getConsumedEnergy(this.mTmpDeviceStatsArray, 0)));
        stats.setDeviceStats(estimation.stateValues, this.mTmpDeviceStatsArray);
    L8:
        i = i - 1;
        goto L3
    }

    private void computeUidPowerEstimates(PowerComponentAggregatedPowerStats stats, IntArray uids) {
        int i = this.mPlan.uidStateEstimates.size() - 1;
    L3:
        if (i < 0) goto L17;
        PowerStatsProcessor.UidStateEstimate uidStateEstimate = this.mPlan.uidStateEstimates.get(i);
        List<PowerStatsProcessor.UidStateProportionalEstimate> proportionalEstimates = uidStateEstimate.proportionalEstimates;
        int j = proportionalEstimates.size() - 1;
    L5:
        if (j < 0) goto L15;
        PowerStatsProcessor.UidStateProportionalEstimate proportionalEstimate = proportionalEstimates.get(j);
        int k = uids.size() - 1;
    L7:
        if (k < 0) goto L14;
        int uid = uids.get(k);
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, proportionalEstimate.stateValues) == false) goto L13;
        double power = PowerStatsProcessor.uCtoMah(sLayout.getUidConsumedEnergy(this.mTmpUidStatsArray, 0));
        if (power == 0.0d) goto L13;
        sLayout.setUidPowerEstimate(this.mTmpUidStatsArray, power);
        stats.setUidStats(uid, proportionalEstimate.stateValues, this.mTmpUidStatsArray);
    L13:
        k = k - 1;
        goto L7
    L14:
        j = j - 1;
        goto L5
    L15:
        i = i - 1;
        goto L3
    }
}
