package com.android.server.power.stats.processor;

import android.util.IntArray;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.UsageBasedPowerEstimator;
import com.android.server.power.stats.format.WifiPowerStatsLayout;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class WifiPowerStatsProcessor extends PowerStatsProcessor {
    private static final boolean DEBUG = false;
    private static final String TAG = "WifiPowerStatsProcessor";
    private final UsageBasedPowerEstimator mActivePowerEstimator;
    private final UsageBasedPowerEstimator mBatchedScanPowerEstimator;
    private boolean mHasWifiPowerController;
    private final UsageBasedPowerEstimator mIdlePowerEstimator;
    private PowerStats.Descriptor mLastUsedDescriptor;
    private PowerStatsProcessor.PowerEstimationPlan mPlan;
    private final UsageBasedPowerEstimator mRxPowerEstimator;
    private final UsageBasedPowerEstimator mScanPowerEstimator;
    private WifiPowerStatsLayout mStatsLayout;
    private long[] mTmpDeviceStatsArray;
    private long[] mTmpUidStatsArray;
    private final UsageBasedPowerEstimator mTxPowerEstimator;

    private static class Intermediates {
        public double activePower;
        public long basicScanDuration;
        public double basicScanPower;
        public long batchedScanDuration;
        public double batchedScanPower;
        public long consumedEnergy;
        public double idlePower;
        public long rxPackets;
        public double rxPower;
        public double scanPower;
        public long txPackets;
        public double txPower;

        /* synthetic */ Intermediates(WifiPowerStatsProcessorIA r1) {
            this();
        }

        private Intermediates() {
        }
    }

    WifiPowerStatsProcessor(PowerProfile powerProfile) {
        this.mRxPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("wifi.controller.rx"));
        this.mTxPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("wifi.controller.tx"));
        this.mIdlePowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("wifi.controller.idle"));
        this.mActivePowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("wifi.active"));
        this.mScanPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("wifi.scan"));
        this.mBatchedScanPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePower("wifi.batchedscan"));
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
        WifiPowerStatsProcessor this = this;
        stats = stats;
        goto L22
    }

    private void unpackPowerStatsDescriptor(PowerStats.Descriptor descriptor) {
        if (descriptor.equals(this.mLastUsedDescriptor) == false) goto L5;
        return;
    L5:
        this.mLastUsedDescriptor = descriptor;
        this.mStatsLayout = new WifiPowerStatsLayout(descriptor);
        this.mTmpDeviceStatsArray = new long[descriptor.statsArrayLength];
        this.mTmpUidStatsArray = new long[descriptor.uidStatsArrayLength];
        this.mHasWifiPowerController = this.mStatsLayout.isPowerReportingSupported();
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
        intermediates.basicScanDuration = this.mStatsLayout.getDeviceBasicScanTime(this.mTmpDeviceStatsArray);
        intermediates.batchedScanDuration = this.mStatsLayout.getDeviceBatchedScanTime(this.mTmpDeviceStatsArray);
        if (this.mHasWifiPowerController == false) goto L11;
        intermediates.rxPower = this.mRxPowerEstimator.calculatePower(this.mStatsLayout.getDeviceRxTime(this.mTmpDeviceStatsArray));
        intermediates.txPower = this.mTxPowerEstimator.calculatePower(this.mStatsLayout.getDeviceTxTime(this.mTmpDeviceStatsArray));
        intermediates.scanPower = this.mScanPowerEstimator.calculatePower(this.mStatsLayout.getDeviceScanTime(this.mTmpDeviceStatsArray));
        intermediates.idlePower = this.mIdlePowerEstimator.calculatePower(this.mStatsLayout.getDeviceIdleTime(this.mTmpDeviceStatsArray));
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, ((intermediates.rxPower + intermediates.txPower) + intermediates.scanPower) + intermediates.idlePower);
    L12:
        stats.setDeviceStats(deviceStates, this.mTmpDeviceStatsArray);
        return;
    L11:
        intermediates.activePower = this.mActivePowerEstimator.calculatePower(this.mStatsLayout.getDeviceActiveTime(this.mTmpDeviceStatsArray));
        intermediates.basicScanPower = this.mScanPowerEstimator.calculatePower(intermediates.basicScanDuration);
        intermediates.batchedScanPower = this.mBatchedScanPowerEstimator.calculatePower(intermediates.batchedScanDuration);
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, (intermediates.activePower + intermediates.basicScanPower) + intermediates.batchedScanPower);
        goto L12
    }

    private double computeEstimateAdjustmentRatioUsingConsumedEnergy() {
        long totalConsumedEnergy = 0;
        double totalPower = 0.0d;
        int i = this.mPlan.deviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L10;
        Intermediates intermediates = (Intermediates) this.mPlan.deviceStateEstimations.get(i).intermediates;
        if (this.mHasWifiPowerController == false) goto L7;
        double r6 = (intermediates.rxPower + intermediates.txPower) + intermediates.scanPower;
        double r8 = intermediates.idlePower;
    L8:
        totalPower = totalPower + (r6 + r8);
        totalConsumedEnergy = totalConsumedEnergy + intermediates.consumedEnergy;
        i = i - 1;
        goto L3
    L7:
        r6 = intermediates.activePower + intermediates.basicScanPower;
        r8 = intermediates.batchedScanPower;
        goto L8
    L10:
        if (totalPower != 0.0d) goto L14;
        return 1.0d;
    L14:
        return PowerStatsProcessor.uCtoMah(totalConsumedEnergy) / totalPower;
    }

    private void adjustDevicePowerEstimates(PowerComponentAggregatedPowerStats stats, int[] deviceStates, Intermediates intermediates, double ratio) {
        if (this.mHasWifiPowerController == false) goto L5;
        intermediates.rxPower *= ratio;
        intermediates.txPower *= ratio;
        intermediates.scanPower *= ratio;
        intermediates.idlePower *= ratio;
        double adjutedPower = ((intermediates.rxPower + intermediates.txPower) + intermediates.scanPower) + intermediates.idlePower;
    L7:
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, deviceStates) == true) goto L9;
        return;
    L9:
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, adjutedPower);
        stats.setDeviceStats(deviceStates, this.mTmpDeviceStatsArray);
        return;
    L5:
        double adjutedPower2 = intermediates.activePower;
        intermediates.activePower = adjutedPower2 * ratio;
        intermediates.basicScanPower *= ratio;
        intermediates.batchedScanPower *= ratio;
        adjutedPower = (intermediates.activePower + intermediates.basicScanPower) + intermediates.batchedScanPower;
        goto L7
    }

    private void combineDeviceStateEstimates() {
        int i = this.mPlan.combinedDeviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L13;
        PowerStatsProcessor.CombinedDeviceStateEstimate cdse = this.mPlan.combinedDeviceStateEstimations.get(i);
        Intermediates cdseIntermediates = new Intermediates(null);
        cdse.intermediates = cdseIntermediates;
        List<PowerStatsProcessor.DeviceStateEstimation> deviceStateEstimations = cdse.deviceStateEstimations;
        int j = deviceStateEstimations.size() - 1;
    L5:
        if (j < 0) goto L11;
        PowerStatsProcessor.DeviceStateEstimation dse = deviceStateEstimations.get(j);
        Intermediates intermediates = (Intermediates) dse.intermediates;
        if (this.mHasWifiPowerController == false) goto L9;
        cdseIntermediates.rxPower += intermediates.rxPower;
        cdseIntermediates.txPower += intermediates.txPower;
        cdseIntermediates.scanPower += intermediates.scanPower;
        cdseIntermediates.idlePower += intermediates.idlePower;
    L10:
        cdseIntermediates.basicScanDuration += intermediates.basicScanDuration;
        cdseIntermediates.batchedScanDuration += intermediates.batchedScanDuration;
        cdseIntermediates.consumedEnergy += intermediates.consumedEnergy;
        j = j - 1;
        goto L5
    L9:
        cdseIntermediates.activePower += intermediates.activePower;
        cdseIntermediates.basicScanPower += intermediates.basicScanPower;
        cdseIntermediates.batchedScanPower += intermediates.batchedScanPower;
        goto L10
    L11:
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
        intermediates.rxPackets += this.mStatsLayout.getUidRxPackets(this.mTmpUidStatsArray);
        intermediates.txPackets += this.mStatsLayout.getUidTxPackets(this.mTmpUidStatsArray);
        goto L4
    }

    private void computeUidPowerEstimates(PowerComponentAggregatedPowerStats stats, int uid, PowerStatsProcessor.UidStateEstimate uidStateEstimate) {
        Intermediates intermediates = (Intermediates) uidStateEstimate.combinedDeviceStateEstimate.intermediates;
        Iterator<PowerStatsProcessor.UidStateProportionalEstimate> r5 = uidStateEstimate.proportionalEstimates.iterator();
    L4:
        if (r5.hasNext() == false) goto L37;
        PowerStatsProcessor.UidStateProportionalEstimate proportionalEstimate = r5.next();
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, proportionalEstimate.stateValues) == false) goto L4;
        double power = 0.0d;
        if (this.mHasWifiPowerController == true) goto L11;
        long totalPackets = intermediates.rxPackets + intermediates.txPackets;
        if (totalPackets == 0) goto L26;
        long packets = this.mStatsLayout.getUidRxPackets(this.mTmpUidStatsArray) + this.mStatsLayout.getUidTxPackets(this.mTmpUidStatsArray);
        power = 0.0d + ((intermediates.activePower * packets) / totalPackets);
    L26:
        if (intermediates.basicScanDuration == r10) goto L30;
        long scanDuration = this.mStatsLayout.getUidScanTime(this.mTmpUidStatsArray);
        power = power + ((intermediates.basicScanPower * scanDuration) / intermediates.basicScanDuration);
    L30:
        if (intermediates.batchedScanDuration == 0) goto L34;
        long batchedScanDuration = this.mStatsLayout.getUidBatchedScanTime(this.mTmpUidStatsArray);
        power = power + ((intermediates.batchedScanPower * batchedScanDuration) / intermediates.batchedScanDuration);
    L34:
        if (power == 0.0d) goto L4;
        this.mStatsLayout.setUidPowerEstimate(this.mTmpUidStatsArray, power);
        stats.setUidStats(uid, proportionalEstimate.stateValues, this.mTmpUidStatsArray);
        goto L4
    L11:
        if (intermediates.rxPackets == 0) goto L14;
        power = 0.0d + ((intermediates.rxPower * this.mStatsLayout.getUidRxPackets(this.mTmpUidStatsArray)) / intermediates.rxPackets);
    L14:
        if (intermediates.txPackets == 0) goto L16;
        power = power + ((intermediates.txPower * this.mStatsLayout.getUidTxPackets(this.mTmpUidStatsArray)) / intermediates.txPackets);
    L16:
        long totalScanDuration = intermediates.basicScanDuration + intermediates.batchedScanDuration;
        if (totalScanDuration == 0) goto L34;
        long scanDuration2 = this.mStatsLayout.getUidScanTime(this.mTmpUidStatsArray) + this.mStatsLayout.getUidBatchedScanTime(this.mTmpUidStatsArray);
        power = power + ((intermediates.scanPower * scanDuration2) / totalScanDuration);
        goto L34
    }
}
