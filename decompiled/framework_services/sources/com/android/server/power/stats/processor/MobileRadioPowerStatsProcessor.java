package com.android.server.power.stats.processor;

import android.telephony.CellSignalStrength;
import android.telephony.ModemActivityInfo;
import android.util.IntArray;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.PowerStats;
import com.android.internal.power.ModemPowerProfile;
import com.android.server.power.stats.UsageBasedPowerEstimator;
import com.android.server.power.stats.format.MobileRadioPowerStatsLayout;
import java.util.Iterator;
import java.util.List;
import org.tukaani.xz.LZMA2Options;

/* JADX INFO: loaded from: classes3.dex */
class MobileRadioPowerStatsProcessor extends PowerStatsProcessor {
    private static final boolean DEBUG = false;
    private static final int IGNORE = -1;
    private static final int NUM_SIGNAL_STRENGTH_LEVELS = 0;
    private static final String TAG = "MobileRadioPowerStats";
    private final UsageBasedPowerEstimator mCallPowerEstimator;
    private final UsageBasedPowerEstimator mIdlePowerEstimator;
    private PowerStats.Descriptor mLastUsedDescriptor;
    private PowerStatsProcessor.PowerEstimationPlan mPlan;
    private final SparseArray<RxTxPowerEstimators> mRxTxPowerEstimators;
    private final UsageBasedPowerEstimator mScanPowerEstimator;
    private final UsageBasedPowerEstimator mSleepPowerEstimator;
    private MobileRadioPowerStatsLayout mStatsLayout;
    private long[] mTmpDeviceStatsArray;
    private long[] mTmpStateStatsArray;
    private long[] mTmpUidStatsArray;

    private static class Intermediates {
        public double callPower;
        public long consumedEnergy;
        public double inactivePower;
        public long rxPackets;
        public double rxPower;
        public long txPackets;
        public double txPower;

        /* synthetic */ Intermediates(MobileRadioPowerStatsProcessorIA r1) {
            this();
        }

        private Intermediates() {
        }
    }

    private static class RxTxPowerEstimators {
        UsageBasedPowerEstimator mRxPowerEstimator;
        UsageBasedPowerEstimator[] mTxPowerEstimators;

        /* synthetic */ RxTxPowerEstimators(MobileRadioPowerStatsProcessorIA r1) {
            this();
        }

        private RxTxPowerEstimators() {
            this.mTxPowerEstimators = new UsageBasedPowerEstimator[ModemActivityInfo.getNumTxPowerLevels()];
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$gPkk12Bu4BvFaxvJ-CjPOs0s1BE, reason: not valid java name */
    public static /* synthetic */ void m7857$r8$lambda$gPkk12Bu4BvFaxvJCjPOs0s1BE(MobileRadioPowerStatsProcessor r0, PowerComponentAggregatedPowerStats r1, int[] r2, Intermediates r3, int r4) {
        r0.lambda$computeDevicePowerEstimates$0(r1, r2, r3, r4);
    }

    static {
        NUM_SIGNAL_STRENGTH_LEVELS = CellSignalStrength.getNumSignalStrengthLevels();
    }

    MobileRadioPowerStatsProcessor(PowerProfile powerProfile) {
        this.mRxTxPowerEstimators = new SparseArray();
        double sleepDrainRateMa = powerProfile.getAverageBatteryDrainOrDefaultMa(4294967296L, Double.NaN);
        if (Double.isNaN(sleepDrainRateMa) == false) goto L5;
        this.mSleepPowerEstimator = null;
    L6:
        double idleDrainRateMa = powerProfile.getAverageBatteryDrainOrDefaultMa(4563402752L, Double.NaN);
        if (Double.isNaN(idleDrainRateMa) == false) goto L9;
        this.mIdlePowerEstimator = null;
    L10:
        double powerRadioActiveMa = powerProfile.getAveragePowerOrDefault("radio.active", Double.NaN);
        if (Double.isNaN(powerRadioActiveMa) == false) goto L17;
        double sum = 0.0d + powerProfile.getAveragePower("modem.controller.rx");
        int i = 0;
    L14:
        if (i >= NUM_SIGNAL_STRENGTH_LEVELS) goto L16;
        sum = sum + powerProfile.getAveragePower("modem.controller.tx", i);
        i = i + 1;
        goto L14
    L16:
        int i2 = NUM_SIGNAL_STRENGTH_LEVELS;
        powerRadioActiveMa = sum / ((double) (i2 + 1));
    L17:
        this.mCallPowerEstimator = new UsageBasedPowerEstimator(powerRadioActiveMa);
        this.mScanPowerEstimator = new UsageBasedPowerEstimator(powerProfile.getAveragePowerOrDefault("radio.scanning", 0.0d));
        int rat = 0;
    L19:
        if (rat >= 3) goto L29;
        if (rat != 2) goto L23;
        int freqCount = 5;
    L24:
        int freqRange = 0;
    L25:
        if (freqRange >= freqCount) goto L27;
        this.mRxTxPowerEstimators.put(MobileRadioPowerStatsLayout.makeStateKey(rat, freqRange), buildRxTxPowerEstimators(powerProfile, rat, freqRange));
        freqRange = freqRange + 1;
        goto L25
    L27:
        rat = rat + 1;
        goto L19
    L23:
        freqCount = 1;
        goto L24
    L29:
        return;
    L9:
        this.mIdlePowerEstimator = new UsageBasedPowerEstimator(idleDrainRateMa);
        goto L10
    L5:
        this.mSleepPowerEstimator = new UsageBasedPowerEstimator(sleepDrainRateMa);
        goto L6
    }

    private static RxTxPowerEstimators buildRxTxPowerEstimators(PowerProfile powerProfile, int rat, int freqRange) {
        PowerProfile r0 = powerProfile;
        RxTxPowerEstimators estimators = new RxTxPowerEstimators(null);
        long rxKey = ModemPowerProfile.getAverageBatteryDrainKey(536870912, rat, freqRange, -1);
        double r6 = Double.NaN;
        double rxDrainRateMa = r0.getAverageBatteryDrainOrDefaultMa(rxKey, Double.NaN);
        if (Double.isNaN(rxDrainRateMa) == false) goto L5;
        Log.w(TAG, "Unavailable Power Profile constant for key 0x" + Long.toHexString(rxKey));
        rxDrainRateMa = 0.0d;
    L5:
        estimators.mRxPowerEstimator = new UsageBasedPowerEstimator(rxDrainRateMa);
        int txLevel = 0;
    L7:
        if (txLevel >= ModemActivityInfo.getNumTxPowerLevels()) goto L14;
        long txKey = ModemPowerProfile.getAverageBatteryDrainKey(LZMA2Options.DICT_SIZE_MAX, rat, freqRange, txLevel);
        double txDrainRateMa = r0.getAverageBatteryDrainOrDefaultMa(txKey, r6);
        if (Double.isNaN(txDrainRateMa) == false) goto L12;
        Log.w(TAG, "Unavailable Power Profile constant for key 0x" + Long.toHexString(txKey));
        txDrainRateMa = 0.0d;
    L12:
        estimators.mTxPowerEstimators[txLevel] = new UsageBasedPowerEstimator(txDrainRateMa);
        txLevel = txLevel + 1;
        r6 = Double.NaN;
        r0 = powerProfile;
        goto L7
    L14:
        return estimators;
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
        if (ratio == 1.0d) goto L21;
        int i2 = this.mPlan.deviceStateEstimations.size() - 1;
    L16:
        if (i2 < 0) goto L21;
        PowerStatsProcessor.DeviceStateEstimation estimation2 = this.mPlan.deviceStateEstimations.get(i2);
        adjustDevicePowerEstimates(stats, estimation2.stateValues, (Intermediates) estimation2.intermediates, ratio);
        i2 = i2 - 1;
    L21:
        combineDeviceStateEstimates();
        IntArray uids = stats.getActiveUids();
        if (uids.size() == 0) goto L37;
        int i3 = uids.size() - 1;
    L24:
        if (i3 < 0) goto L30;
        int uid = uids.get(i3);
        int j = 0;
    L27:
        if (j >= this.mPlan.uidStateEstimates.size()) goto L29;
        computeUidRxTxTotals(stats, uid, this.mPlan.uidStateEstimates.get(j));
        j = j + 1;
        goto L27
    L29:
        i3 = i3 - 1;
        goto L24
    L30:
        int i4 = uids.size();
        int i5 = i4 - 1;
    L31:
        if (i5 < 0) goto L37;
        int uid2 = uids.get(i5);
        int j2 = 0;
    L34:
        if (j2 >= this.mPlan.uidStateEstimates.size()) goto L36;
        computeUidPowerEstimates(stats, uid2, this.mPlan.uidStateEstimates.get(j2));
        j2 = j2 + 1;
        goto L34
    L36:
        i5 = i5 - 1;
    L37:
        this.mPlan.resetIntermediates();
    }

    private void unpackPowerStatsDescriptor(PowerStats.Descriptor descriptor) {
        if (descriptor.equals(this.mLastUsedDescriptor) == false) goto L5;
        return;
    L5:
        this.mLastUsedDescriptor = descriptor;
        this.mStatsLayout = new MobileRadioPowerStatsLayout(descriptor);
        this.mTmpDeviceStatsArray = new long[descriptor.statsArrayLength];
        this.mTmpStateStatsArray = new long[descriptor.stateStatsArrayLength];
        this.mTmpUidStatsArray = new long[descriptor.uidStatsArrayLength];
    }

    private void computeDevicePowerEstimates(final PowerComponentAggregatedPowerStats stats, final int[] deviceStates, final Intermediates intermediates) {
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, deviceStates) == true) goto L5;
        return;
    L5:
        int i = this.mStatsLayout.getEnergyConsumerCount() - 1;
    L6:
        if (i < 0) goto L9;
        intermediates.consumedEnergy += this.mStatsLayout.getConsumedEnergy(this.mTmpDeviceStatsArray, i);
        i = i - 1;
        goto L6
    L9:
        if (this.mSleepPowerEstimator == null) goto L12;
        intermediates.inactivePower += this.mSleepPowerEstimator.calculatePower(this.mStatsLayout.getDeviceSleepTime(this.mTmpDeviceStatsArray));
    L12:
        if (this.mIdlePowerEstimator == null) goto L15;
        intermediates.inactivePower += this.mIdlePowerEstimator.calculatePower(this.mStatsLayout.getDeviceIdleTime(this.mTmpDeviceStatsArray));
    L15:
        if (this.mScanPowerEstimator == null) goto L17;
        intermediates.inactivePower += this.mScanPowerEstimator.calculatePower(this.mStatsLayout.getDeviceScanTime(this.mTmpDeviceStatsArray));
    L17:
        stats.forEachStateStatsKey(new MobileRadioPowerStatsProcessor$$ExternalSyntheticLambda0(this, stats, deviceStates, intermediates));
        if (this.mCallPowerEstimator == null) goto L20;
        intermediates.callPower = this.mCallPowerEstimator.calculatePower(this.mStatsLayout.getDeviceCallTime(this.mTmpDeviceStatsArray));
    L20:
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, (intermediates.rxPower + intermediates.txPower) + intermediates.inactivePower);
        this.mStatsLayout.setDeviceCallPowerEstimate(this.mTmpDeviceStatsArray, intermediates.callPower);
        stats.setDeviceStats(deviceStates, this.mTmpDeviceStatsArray);
    }

    private /* synthetic */ void lambda$computeDevicePowerEstimates$0(PowerComponentAggregatedPowerStats stats, int[] deviceStates, Intermediates intermediates, int key) {
        RxTxPowerEstimators estimators = this.mRxTxPowerEstimators.get(key);
        if (stats.getStateStats(this.mTmpStateStatsArray, key, deviceStates) == true) goto L5;
        return;
    L5:
        long rxTime = this.mStatsLayout.getStateRxTime(this.mTmpStateStatsArray);
        intermediates.rxPower += estimators.mRxPowerEstimator.calculatePower(rxTime);
        int txLevel = 0;
    L7:
        if (txLevel >= ModemActivityInfo.getNumTxPowerLevels()) goto L10;
        long txTime = this.mStatsLayout.getStateTxTime(this.mTmpStateStatsArray, txLevel);
        intermediates.txPower += estimators.mTxPowerEstimators[txLevel].calculatePower(txTime);
        txLevel = txLevel + 1;
        goto L7
    }

    private double computeEstimateAdjustmentRatioUsingConsumedEnergy() {
        long totalConsumedEnergy = 0;
        double totalPower = 0.0d;
        int i = this.mPlan.deviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L6;
        Intermediates intermediates = (Intermediates) this.mPlan.deviceStateEstimations.get(i).intermediates;
        totalPower = totalPower + (((intermediates.rxPower + intermediates.txPower) + intermediates.inactivePower) + intermediates.callPower);
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
        intermediates.inactivePower *= ratio;
        intermediates.callPower *= ratio;
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, deviceStates) == true) goto L5;
        return;
    L5:
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, (intermediates.rxPower + intermediates.txPower) + intermediates.inactivePower);
        this.mStatsLayout.setDeviceCallPowerEstimate(this.mTmpDeviceStatsArray, intermediates.callPower);
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
        cdseIntermediates.rxPower += intermediates.rxPower;
        cdseIntermediates.txPower += intermediates.txPower;
        cdseIntermediates.inactivePower += intermediates.inactivePower;
        cdseIntermediates.consumedEnergy += intermediates.consumedEnergy;
        j = j - 1;
        goto L5
    L7:
        i = i - 1;
        goto L3
    }

    private void computeUidRxTxTotals(PowerComponentAggregatedPowerStats stats, int uid, PowerStatsProcessor.UidStateEstimate uidStateEstimate) {
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
        Iterator<PowerStatsProcessor.UidStateProportionalEstimate> r1 = uidStateEstimate.proportionalEstimates.iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        PowerStatsProcessor.UidStateProportionalEstimate proportionalEstimate = r1.next();
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, proportionalEstimate.stateValues) == false) goto L4;
        double power = 0.0d;
        if (intermediates.rxPackets == 0) goto L12;
        power = 0.0d + ((intermediates.rxPower * this.mStatsLayout.getUidRxPackets(this.mTmpUidStatsArray)) / intermediates.rxPackets);
    L12:
        if (intermediates.txPackets == 0) goto L15;
        power = power + ((intermediates.txPower * this.mStatsLayout.getUidTxPackets(this.mTmpUidStatsArray)) / intermediates.txPackets);
    L15:
        if (power == 0.0d) goto L4;
        this.mStatsLayout.setUidPowerEstimate(this.mTmpUidStatsArray, power);
        stats.setUidStats(uid, proportionalEstimate.stateValues, this.mTmpUidStatsArray);
        goto L4
    }
}
