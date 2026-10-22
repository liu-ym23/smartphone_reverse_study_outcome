package com.android.server.power.stats.processor;

import android.util.IntArray;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.UsageBasedPowerEstimator;
import com.android.server.power.stats.format.BluetoothPowerStatsLayout;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class BluetoothPowerStatsProcessor extends PowerStatsProcessor {
    private final UsageBasedPowerEstimator mIdlePowerEstimator;
    private PowerStats.Descriptor mLastUsedDescriptor;
    private PowerStatsProcessor.PowerEstimationPlan mPlan;
    private final UsageBasedPowerEstimator mRxPowerEstimator;
    private BluetoothPowerStatsLayout mStatsLayout;
    private long[] mTmpDeviceStatsArray;
    private long[] mTmpUidStatsArray;
    private final UsageBasedPowerEstimator mTxPowerEstimator;

    private static class Intermediates {
        public long consumedEnergy;
        public double idlePower;
        public long rxBytes;
        public double rxPower;
        public long rxTime;
        public long scanTime;
        public long txBytes;
        public double txPower;
        public long txTime;

        /* synthetic */ Intermediates(BluetoothPowerStatsProcessorIA r1) {
            this();
        }

        private Intermediates() {
        }
    }

    BluetoothPowerStatsProcessor(PowerProfile powerProfile) {
        this.mRxPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("bluetooth.controller.rx"));
        this.mTxPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("bluetooth.controller.tx"));
        this.mIdlePowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("bluetooth.controller.idle"));
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void finish(PowerComponentAggregatedPowerStats stats, long timestampMs) {
        if (stats.getPowerStatsDescriptor() != null) goto L5;
        return;
    L5:
        unpackPowerStatsDescriptor(stats.getPowerStatsDescriptor());
        if (this.mPlan != null) goto L8;
        this.mPlan = new PowerStatsProcessor.PowerEstimationPlan(stats.getConfig());
    L8:
        int i = this.mPlan.deviceStateEstimations.size() - 1;
    L9:
        if (i < 0) goto L12;
        PowerStatsProcessor.DeviceStateEstimation estimation = this.mPlan.deviceStateEstimations.get(i);
        Intermediates intermediates = new Intermediates(null);
        estimation.intermediates = intermediates;
        computeDevicePowerEstimates(stats, estimation.stateValues, intermediates);
        i = i - 1;
        goto L9
    L12:
        if (this.mStatsLayout.getEnergyConsumerCount() == 0) goto L21;
        double ratio = computeEstimateAdjustmentRatioUsingConsumedEnergy();
        if (ratio == 1.0d) goto L22;
        int i2 = this.mPlan.deviceStateEstimations.size() - 1;
    L16:
        if (i2 < 0) goto L22;
        PowerStatsProcessor.DeviceStateEstimation estimation2 = this.mPlan.deviceStateEstimations.get(i2);
        adjustDevicePowerEstimates(stats, estimation2.stateValues, (Intermediates) estimation2.intermediates, ratio);
        i2 = i2 - 1;
    L22:
        combineDeviceStateEstimates();
        IntArray uids = stats.getActiveUids();
        if (uids.size() == 0) goto L38;
        int i3 = uids.size() - 1;
    L25:
        if (i3 < 0) goto L31;
        int uid = uids.get(i3);
        int j = 0;
    L28:
        if (j >= this.mPlan.uidStateEstimates.size()) goto L30;
        computeUidActivityTotals(stats, uid, this.mPlan.uidStateEstimates.get(j));
        j = j + 1;
        goto L28
    L30:
        i3 = i3 - 1;
        goto L25
    L31:
        int i4 = uids.size();
        int i5 = i4 - 1;
    L32:
        if (i5 < 0) goto L38;
        int uid2 = uids.get(i5);
        int j2 = 0;
    L35:
        if (j2 >= this.mPlan.uidStateEstimates.size()) goto L37;
        computeUidPowerEstimates(stats, uid2, this.mPlan.uidStateEstimates.get(j2));
        j2 = j2 + 1;
        goto L35
    L37:
        i5 = i5 - 1;
    L38:
        this.mPlan.resetIntermediates();
        return;
    L21:
        BluetoothPowerStatsProcessor this = this;
        stats = stats;
        goto L22
    }

    private void unpackPowerStatsDescriptor(PowerStats.Descriptor descriptor) {
        if (descriptor.equals(this.mLastUsedDescriptor) == false) goto L5;
        return;
    L5:
        this.mLastUsedDescriptor = descriptor;
        this.mStatsLayout = new BluetoothPowerStatsLayout(descriptor);
        this.mTmpDeviceStatsArray = new long[descriptor.statsArrayLength];
        this.mTmpUidStatsArray = new long[descriptor.uidStatsArrayLength];
    }

    private void computeDevicePowerEstimates(PowerComponentAggregatedPowerStats stats, int[] deviceStates, Intermediates intermediates) {
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, deviceStates) == true) goto L5;
        return;
    L5:
        int i = this.mStatsLayout.getEnergyConsumerCount() - 1;
    L6:
        if (i < 0) goto L8;
        intermediates.consumedEnergy += this.mStatsLayout.getConsumedEnergy(this.mTmpDeviceStatsArray, i);
        i = i - 1;
        goto L6
    L8:
        intermediates.rxTime = this.mStatsLayout.getDeviceRxTime(this.mTmpDeviceStatsArray);
        intermediates.txTime = this.mStatsLayout.getDeviceTxTime(this.mTmpDeviceStatsArray);
        intermediates.scanTime = this.mStatsLayout.getDeviceScanTime(this.mTmpDeviceStatsArray);
        long idleTime = this.mStatsLayout.getDeviceIdleTime(this.mTmpDeviceStatsArray);
        intermediates.rxPower = this.mRxPowerEstimator.calculatePower(intermediates.rxTime);
        intermediates.txPower = this.mTxPowerEstimator.calculatePower(intermediates.txTime);
        intermediates.idlePower = this.mIdlePowerEstimator.calculatePower(idleTime);
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, (intermediates.rxPower + intermediates.txPower) + intermediates.idlePower);
        stats.setDeviceStats(deviceStates, this.mTmpDeviceStatsArray);
    }

    private double computeEstimateAdjustmentRatioUsingConsumedEnergy() {
        long totalConsumedEnergy = 0;
        double totalPower = 0.0d;
        int i = this.mPlan.deviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L6;
        Intermediates intermediates = (Intermediates) this.mPlan.deviceStateEstimations.get(i).intermediates;
        totalPower = totalPower + ((intermediates.rxPower + intermediates.txPower) + intermediates.idlePower);
        totalConsumedEnergy = totalConsumedEnergy + intermediates.consumedEnergy;
        i = i - 1;
        goto L3
    L6:
        if (totalPower != 0.0d) goto L10;
        return 1.0d;
    L10:
        return PowerStatsProcessor.uCtoMah(totalConsumedEnergy) / totalPower;
    }

    private void adjustDevicePowerEstimates(PowerComponentAggregatedPowerStats stats, int[] deviceStates, Intermediates intermediates, double ratio) {
        intermediates.rxPower *= ratio;
        intermediates.txPower *= ratio;
        intermediates.idlePower *= ratio;
        double adjutedPower = (intermediates.rxPower + intermediates.txPower) + intermediates.idlePower;
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, deviceStates) == true) goto L5;
        return;
    L5:
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, adjutedPower);
        stats.setDeviceStats(deviceStates, this.mTmpDeviceStatsArray);
    }

    private void combineDeviceStateEstimates() {
        int i = this.mPlan.combinedDeviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L9;
        PowerStatsProcessor.CombinedDeviceStateEstimate cdse = this.mPlan.combinedDeviceStateEstimations.get(i);
        Intermediates cdseIntermediates = new Intermediates(null);
        cdse.intermediates = cdseIntermediates;
        List<PowerStatsProcessor.DeviceStateEstimation> deviceStateEstimations = cdse.deviceStateEstimations;
        int j = deviceStateEstimations.size() - 1;
    L5:
        if (j < 0) goto L7;
        PowerStatsProcessor.DeviceStateEstimation dse = deviceStateEstimations.get(j);
        Intermediates intermediates = (Intermediates) dse.intermediates;
        cdseIntermediates.rxTime += intermediates.rxTime;
        cdseIntermediates.rxBytes += intermediates.rxBytes;
        cdseIntermediates.rxPower += intermediates.rxPower;
        cdseIntermediates.txTime += intermediates.txTime;
        cdseIntermediates.txBytes += intermediates.txBytes;
        cdseIntermediates.txPower += intermediates.txPower;
        cdseIntermediates.idlePower += intermediates.idlePower;
        cdseIntermediates.scanTime += intermediates.scanTime;
        cdseIntermediates.consumedEnergy += intermediates.consumedEnergy;
        j = j - 1;
        goto L5
    L7:
        i = i - 1;
        goto L3
    }

    private void computeUidActivityTotals(PowerComponentAggregatedPowerStats stats, int uid, PowerStatsProcessor.UidStateEstimate uidStateEstimate) {
        Intermediates intermediates = (Intermediates) uidStateEstimate.combinedDeviceStateEstimate.intermediates;
        Iterator<PowerStatsProcessor.UidStateProportionalEstimate> r1 = uidStateEstimate.proportionalEstimates.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        PowerStatsProcessor.UidStateProportionalEstimate proportionalEstimate = r1.next();
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, proportionalEstimate.stateValues) == false) goto L4;
        intermediates.rxBytes += this.mStatsLayout.getUidRxBytes(this.mTmpUidStatsArray);
        intermediates.txBytes += this.mStatsLayout.getUidTxBytes(this.mTmpUidStatsArray);
        goto L4
    }

    private void computeUidPowerEstimates(PowerComponentAggregatedPowerStats stats, int uid, PowerStatsProcessor.UidStateEstimate uidStateEstimate) {
        Intermediates intermediates = (Intermediates) uidStateEstimate.combinedDeviceStateEstimate.intermediates;
        boolean normalizeTxByScanTime = false;
        if (intermediates.scanTime <= intermediates.rxTime) goto L5;
        boolean normalizeRxByScanTime = true;
    L7:
        if (intermediates.scanTime <= intermediates.txTime) goto L9;
        normalizeTxByScanTime = true;
    L9:
        Iterator<PowerStatsProcessor.UidStateProportionalEstimate> r7 = uidStateEstimate.proportionalEstimates.iterator();
    L11:
        if (r7.hasNext() == false) goto L35;
        PowerStatsProcessor.UidStateProportionalEstimate proportionalEstimate = r7.next();
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, proportionalEstimate.stateValues) == false) goto L11;
        double power = 0.0d;
        if (normalizeRxByScanTime == true) goto L18;
        long r16 = 0;
        if (intermediates.rxBytes == 0) goto L24;
        power = 0.0d + ((intermediates.rxPower * this.mStatsLayout.getUidRxBytes(this.mTmpUidStatsArray)) / intermediates.rxBytes);
    L24:
        if (normalizeTxByScanTime == false) goto L29;
        if (intermediates.scanTime == r16) goto L32;
        power = power + ((intermediates.txPower * this.mStatsLayout.getUidScanTime(this.mTmpUidStatsArray)) / intermediates.scanTime);
    L32:
        if (power == 0.0d) goto L11;
        this.mStatsLayout.setUidPowerEstimate(this.mTmpUidStatsArray, power);
        stats.setUidStats(uid, proportionalEstimate.stateValues, this.mTmpUidStatsArray);
        goto L11
    L29:
        if (intermediates.txBytes == r16) goto L32;
        power = power + ((intermediates.txPower * this.mStatsLayout.getUidTxBytes(this.mTmpUidStatsArray)) / intermediates.txBytes);
        goto L32
    L18:
        if (intermediates.scanTime == 0) goto L20;
        r16 = 0;
        power = 0.0d + ((intermediates.rxPower * this.mStatsLayout.getUidScanTime(this.mTmpUidStatsArray)) / intermediates.scanTime);
        goto L24
    L20:
        r16 = 0;
        goto L24
    L35:
        return;
    L5:
        normalizeRxByScanTime = false;
        goto L7
    }
}
