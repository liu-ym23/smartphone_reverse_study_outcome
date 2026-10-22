package com.android.server.power.stats.processor;

import android.util.ArraySet;
import android.util.IntArray;
import android.util.Log;
import com.android.internal.os.CpuScalingPolicies;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.CpuPowerStatsLayout;
import com.android.server.power.stats.format.WakelockPowerStatsLayout;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
class CpuPowerStatsProcessor extends PowerStatsProcessor {
    private static final double HOUR_IN_MILLIS = 0.0d;
    private static final String TAG = "CpuPowerStatsProcessor";
    private static final int UNKNOWN = -1;
    private int[][] mCombinedEnergyConsumerToPowerBracketMap;
    private final int mCpuClusterCount;
    private final CpuScalingPolicies mCpuScalingPolicies;
    private final int mCpuScalingStepCount;
    private int[] mEnergyConsumerToCombinedEnergyConsumerMap;
    private PowerStats.Descriptor mLastUsedDescriptor;
    private PowerStatsProcessor.PowerEstimationPlan mPlan;
    private final double mPowerMultiplierForCpuActive;
    private final double[] mPowerMultipliersByCluster;
    private final double[] mPowerMultipliersByScalingStep;
    private final int[] mScalingStepToCluster;
    private CpuPowerStatsLayout mStatsLayout;
    private long[] mTmpDeviceStatsArray;
    private long[] mTmpUidStatsArray;
    private long[] mTmpWakelockDeviceStats;
    private long[] mTmpWakelockUidStats;
    private PowerStats.Descriptor mWakelockDescriptor;
    private WakelockPowerStatsLayout mWakelockPowerStatsLayout;

    private static class DeviceStatsIntermediates {
        public double power;
        public double[] powerByBracket;
        public long[] timeByBracket;

        /* synthetic */ DeviceStatsIntermediates(CpuPowerStatsProcessorIA r1) {
            this();
        }

        private DeviceStatsIntermediates() {
        }
    }

    private static final class Intermediates {
        public long cumulativeTime;
        public long[] cumulativeTimeByCluster;
        public double[] powerByCluster;
        public long[] powerByEnergyConsumer;
        public double[] powerByScalingStep;
        public long[] timeByCluster;
        public long[] timeByScalingStep;
        public long uptime;

        /* synthetic */ Intermediates(CpuPowerStatsProcessorIA r1) {
            this();
        }

        private Intermediates() {
        }
    }

    static {
        HOUR_IN_MILLIS = TimeUnit.HOURS.toMillis(1);
    }

    CpuPowerStatsProcessor(PowerProfile powerProfile, CpuScalingPolicies scalingPolicies) {
        this.mCpuScalingPolicies = scalingPolicies;
        this.mCpuScalingStepCount = scalingPolicies.getScalingStepCount();
        this.mScalingStepToCluster = new int[this.mCpuScalingStepCount];
        this.mPowerMultipliersByScalingStep = new double[this.mCpuScalingStepCount];
        int step = 0;
        int[] policies = scalingPolicies.getPolicies();
        this.mCpuClusterCount = policies.length;
        this.mPowerMultipliersByCluster = new double[this.mCpuClusterCount];
        int cluster = 0;
    L4:
        if (cluster >= this.mCpuClusterCount) goto L10;
        int policy = policies[cluster];
        this.mPowerMultipliersByCluster[cluster] = powerProfile.getAveragePowerForCpuScalingPolicy(policy) / HOUR_IN_MILLIS;
        int[] frequencies = scalingPolicies.getFrequencies(policy);
        int i = 0;
    L7:
        if (i >= frequencies.length) goto L9;
        this.mScalingStepToCluster[step] = cluster;
        this.mPowerMultipliersByScalingStep[step] = powerProfile.getAveragePowerForCpuScalingStep(policy, i) / HOUR_IN_MILLIS;
        step = step + 1;
        i = i + 1;
        goto L7
    L9:
        cluster = cluster + 1;
        goto L4
    L10:
        this.mPowerMultiplierForCpuActive = powerProfile.getAveragePower("cpu.active") / HOUR_IN_MILLIS;
    }

    private void unpackPowerStatsDescriptor(PowerStats.Descriptor descriptor) {
        if (descriptor.equals(this.mLastUsedDescriptor) == false) goto L5;
        return;
    L5:
        this.mLastUsedDescriptor = descriptor;
        this.mStatsLayout = new CpuPowerStatsLayout(descriptor);
        this.mTmpDeviceStatsArray = new long[descriptor.statsArrayLength];
        this.mTmpUidStatsArray = new long[descriptor.uidStatsArrayLength];
        this.mWakelockDescriptor = null;
        initEnergyConsumerToPowerBracketMaps();
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
        Intermediates intermediates = new Intermediates(null);
        int cpuScalingStepCount = this.mStatsLayout.getCpuScalingStepCount();
        if (cpuScalingStepCount == this.mCpuScalingStepCount) goto L12;
        Log.e(TAG, "Mismatched CPU scaling step count in PowerStats: " + cpuScalingStepCount + ", expected: " + this.mCpuScalingStepCount);
        return;
    L12:
        int clusterCount = this.mStatsLayout.getCpuClusterCount();
        if (clusterCount == this.mCpuClusterCount) goto L16;
        Log.e(TAG, "Mismatched CPU cluster count in PowerStats: " + clusterCount + ", expected: " + this.mCpuClusterCount);
        return;
    L16:
        computeTotals(stats, intermediates);
        if (intermediates.cumulativeTime != 0) goto L19;
        return;
    L19:
        estimatePowerByScalingStep(intermediates);
        PowerComponentAggregatedPowerStats wakelockStats = getWakelockStats(stats);
        estimatePowerByDeviceState(stats, intermediates, wakelockStats);
        combineDeviceStateEstimates();
        IntArray uids = stats.getActiveUids();
        if (uids.size() == 0) goto L28;
        int i = uids.size() - 1;
    L22:
        if (i < 0) goto L28;
        int uid = uids.get(i);
        int j = 0;
    L25:
        if (j >= this.mPlan.uidStateEstimates.size()) goto L27;
        estimateUidPowerConsumption(stats, uid, this.mPlan.uidStateEstimates.get(j), wakelockStats);
        j = j + 1;
        goto L25
    L27:
        i = i - 1;
    L28:
        this.mPlan.resetIntermediates();
    }

    private PowerComponentAggregatedPowerStats getWakelockStats(PowerComponentAggregatedPowerStats stats) {
        if (this.mStatsLayout.getEnergyConsumerCount() != 0) goto L5;
        return null;
    L5:
        PowerComponentAggregatedPowerStats wakelockStats = stats.getAggregatedPowerStats().getPowerComponentStats(12);
        if (wakelockStats != null) goto L8;
        return null;
    L8:
        PowerStats.Descriptor descriptor = wakelockStats.getPowerStatsDescriptor();
        if (descriptor != null) goto L12;
        return null;
    L12:
        if (this.mWakelockDescriptor != null) goto L14;
    L15:
        this.mWakelockDescriptor = descriptor;
        this.mWakelockPowerStatsLayout = new WakelockPowerStatsLayout(this.mWakelockDescriptor);
        this.mTmpWakelockDeviceStats = new long[this.mWakelockDescriptor.statsArrayLength];
        this.mTmpWakelockUidStats = new long[this.mWakelockDescriptor.uidStatsArrayLength];
    L16:
        return wakelockStats;
    L14:
        if (this.mWakelockDescriptor.equals(descriptor) == true) goto L16;
        goto L15
    }

    private void initEnergyConsumerToPowerBracketMaps() {
        int energyConsumerCount = this.mStatsLayout.getEnergyConsumerCount();
        if (energyConsumerCount != 0) goto L5;
        return;
    L5:
        int powerBracketCount = this.mStatsLayout.getCpuPowerBracketCount();
        this.mEnergyConsumerToCombinedEnergyConsumerMap = new int[energyConsumerCount];
        this.mCombinedEnergyConsumerToPowerBracketMap = new int[energyConsumerCount][];
        int[] policies = this.mCpuScalingPolicies.getPolicies();
        if (energyConsumerCount != policies.length) goto L36;
        int[] scalingStepToPowerBracketMap = this.mStatsLayout.getScalingStepToPowerBracketMap();
        ArraySet<? extends Integer>[] clusterToBrackets = new ArraySet[policies.length];
        int step = 0;
        int cluster = 0;
    L9:
        if (cluster >= policies.length) goto L15;
        int[] freqs = this.mCpuScalingPolicies.getFrequencies(policies[cluster]);
        clusterToBrackets[cluster] = new ArraySet(freqs.length);
        int j = 0;
    L12:
        if (j >= freqs.length) goto L14;
        clusterToBrackets[cluster].add(Integer.valueOf(scalingStepToPowerBracketMap[step]));
        j = j + 1;
        step = step + 1;
        goto L12
    L14:
        cluster = cluster + 1;
        goto L9
    L15:
        int cluster2 = policies.length;
        ArraySet<Integer>[] combinedEnergyConsumers = new ArraySet[cluster2];
        int combinedEnergyConsumersCount = 0;
        int cluster3 = 0;
    L17:
        if (cluster3 >= clusterToBrackets.length) goto L29;
        int combineWith = -1;
        int i = 0;
    L19:
        if (i >= combinedEnergyConsumersCount) goto L25;
        if (containsAny(combinedEnergyConsumers[i], clusterToBrackets[cluster3]) == true) goto L22;
        i = i + 1;
        goto L19
    L22:
        combineWith = i;
    L25:
        if (combineWith == (-1)) goto L27;
        this.mEnergyConsumerToCombinedEnergyConsumerMap[cluster3] = combineWith;
        combinedEnergyConsumers[combineWith].addAll(clusterToBrackets[cluster3]);
    L28:
        cluster3 = cluster3 + 1;
        goto L17
    L27:
        this.mEnergyConsumerToCombinedEnergyConsumerMap[cluster3] = combinedEnergyConsumersCount;
        combinedEnergyConsumers[combinedEnergyConsumersCount] = clusterToBrackets[cluster3];
        combinedEnergyConsumersCount = combinedEnergyConsumersCount + 1;
        goto L28
    L29:
        int cluster4 = combinedEnergyConsumers.length;
        int i2 = cluster4 - 1;
    L30:
        if (i2 < 0) goto L52;
        this.mCombinedEnergyConsumerToPowerBracketMap[i2] = new int[combinedEnergyConsumers[i2].size()];
        int j2 = combinedEnergyConsumers[i2].size() - 1;
    L32:
        if (j2 < 0) goto L34;
        this.mCombinedEnergyConsumerToPowerBracketMap[i2][j2] = combinedEnergyConsumers[i2].valueAt(j2).intValue();
        j2 = j2 - 1;
        goto L32
    L34:
        i2 = i2 - 1;
        goto L30
    L52:
        return;
    L36:
        int[] map = new int[powerBracketCount];
        int i3 = 0;
    L38:
        if (i3 >= map.length) goto L40;
        map[i3] = i3;
        i3 = i3 + 1;
        goto L38
    L40:
        this.mCombinedEnergyConsumerToPowerBracketMap[0] = map;
    }

    private static boolean containsAny(ArraySet<Integer> set1, ArraySet<Integer> set2) {
        int i = 0;
    L4:
        if (i >= set2.size()) goto L10;
        if (set1.contains(set2.valueAt(i)) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private void computeTotals(PowerComponentAggregatedPowerStats stats, Intermediates intermediates) {
        intermediates.timeByScalingStep = new long[this.mCpuScalingStepCount];
        intermediates.timeByCluster = new long[this.mCpuClusterCount];
        intermediates.cumulativeTimeByCluster = new long[this.mCpuClusterCount];
        List<PowerStatsProcessor.DeviceStateEstimation> deviceStateEstimations = this.mPlan.deviceStateEstimations;
        int i = deviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L17;
        PowerStatsProcessor.DeviceStateEstimation deviceStateEstimation = deviceStateEstimations.get(i);
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, deviceStateEstimation.stateValues) == false) goto L15;
        intermediates.uptime += this.mStatsLayout.getUsageDuration(this.mTmpDeviceStatsArray);
        int cluster = 0;
    L9:
        if (cluster >= this.mCpuClusterCount) goto L11;
        long[] r4 = intermediates.timeByCluster;
        r4[cluster] = r4[cluster] + this.mStatsLayout.getTimeByCluster(this.mTmpDeviceStatsArray, cluster);
        cluster = cluster + 1;
        goto L9
    L11:
        int step = 0;
    L13:
        if (step >= this.mCpuScalingStepCount) goto L15;
        long timeInStep = this.mStatsLayout.getTimeByScalingStep(this.mTmpDeviceStatsArray, step);
        intermediates.cumulativeTime += timeInStep;
        long[] r6 = intermediates.timeByScalingStep;
        r6[step] = r6[step] + timeInStep;
        long[] r7 = intermediates.cumulativeTimeByCluster;
        int r8 = this.mScalingStepToCluster[step];
        r7[r8] = r7[r8] + timeInStep;
        step = step + 1;
    L15:
        i = i - 1;
        goto L3
    }

    private void estimatePowerByScalingStep(Intermediates intermediates) {
        double cpuActivePower = this.mPowerMultiplierForCpuActive * intermediates.uptime;
        intermediates.powerByCluster = new double[this.mCpuClusterCount];
        int cluster = 0;
    L4:
        if (cluster >= this.mCpuClusterCount) goto L6;
        intermediates.powerByCluster[cluster] = this.mPowerMultipliersByCluster[cluster] * intermediates.timeByCluster[cluster];
        cluster = cluster + 1;
        goto L4
    L6:
        int cluster2 = this.mCpuScalingStepCount;
        intermediates.powerByScalingStep = new double[cluster2];
        int step = 0;
    L8:
        if (step >= this.mCpuScalingStepCount) goto L14;
        int cluster3 = this.mScalingStepToCluster[step];
        double power = (intermediates.timeByScalingStep[step] * cpuActivePower) / intermediates.cumulativeTime;
        long cumulativeTimeInCluster = intermediates.cumulativeTimeByCluster[cluster3];
        if (cumulativeTimeInCluster == 0) goto L12;
        power = power + ((intermediates.powerByCluster[cluster3] * intermediates.timeByScalingStep[step]) / cumulativeTimeInCluster);
    L12:
        intermediates.powerByScalingStep[step] = power + (this.mPowerMultipliersByScalingStep[step] * intermediates.timeByScalingStep[step]);
        step = step + 1;
        goto L8
    }

    private void estimatePowerByDeviceState(PowerComponentAggregatedPowerStats stats, Intermediates intermediates, PowerComponentAggregatedPowerStats wakelockStats) {
        int cpuScalingStepCount = this.mStatsLayout.getCpuScalingStepCount();
        int powerBracketCount = this.mStatsLayout.getCpuPowerBracketCount();
        int[] scalingStepToBracketMap = this.mStatsLayout.getScalingStepToPowerBracketMap();
        int energyConsumerCount = this.mStatsLayout.getEnergyConsumerCount();
        List<PowerStatsProcessor.DeviceStateEstimation> deviceStateEstimations = this.mPlan.deviceStateEstimations;
        int dse = deviceStateEstimations.size() - 1;
    L3:
        if (dse < 0) goto L30;
        PowerStatsProcessor.DeviceStateEstimation deviceStateEstimation = deviceStateEstimations.get(dse);
        deviceStateEstimation.intermediates = new DeviceStatsIntermediates(null);
        DeviceStatsIntermediates deviceStatsIntermediates = (DeviceStatsIntermediates) deviceStateEstimation.intermediates;
        deviceStatsIntermediates.timeByBracket = new long[powerBracketCount];
        deviceStatsIntermediates.powerByBracket = new double[powerBracketCount];
        if (stats.getDeviceStats(this.mTmpDeviceStatsArray, deviceStateEstimation.stateValues) == true) goto L7;
        int cpuScalingStepCount2 = cpuScalingStepCount;
        int powerBracketCount2 = powerBracketCount;
    L28:
        dse = dse - 1;
        cpuScalingStepCount = cpuScalingStepCount2;
        powerBracketCount = powerBracketCount2;
        goto L3
    L7:
        int step = 0;
    L8:
        if (step >= cpuScalingStepCount) goto L14;
        if (intermediates.timeByScalingStep[step] == 0) goto L13;
        long timeInStep = this.mStatsLayout.getTimeByScalingStep(this.mTmpDeviceStatsArray, step);
        double stepPower = (intermediates.powerByScalingStep[step] * timeInStep) / intermediates.timeByScalingStep[step];
        int bracket = scalingStepToBracketMap[step];
        long[] r5 = deviceStatsIntermediates.timeByBracket;
        r5[bracket] = r5[bracket] + timeInStep;
        double[] r6 = deviceStatsIntermediates.powerByBracket;
        r6[bracket] = r6[bracket] + stepPower;
    L13:
        step = step + 1;
        cpuScalingStepCount = cpuScalingStepCount;
        powerBracketCount = powerBracketCount;
        goto L8
    L14:
        cpuScalingStepCount2 = cpuScalingStepCount;
        powerBracketCount2 = powerBracketCount;
        if (energyConsumerCount == 0) goto L17;
        adjustEstimatesUsingEnergyConsumers(intermediates, deviceStatsIntermediates);
    L17:
        double power = 0.0d;
        int i = deviceStatsIntermediates.powerByBracket.length - 1;
    L18:
        if (i < 0) goto L21;
        power = power + deviceStatsIntermediates.powerByBracket[i];
        i = i - 1;
        goto L18
    L21:
        if (wakelockStats == 0) goto L26;
        if (wakelockStats.getDeviceStats(this.mTmpWakelockDeviceStats, deviceStateEstimation.stateValues) == false) goto L26;
        double wakelockPowerEstimate = this.mWakelockPowerStatsLayout.getDevicePowerEstimate(this.mTmpWakelockDeviceStats);
        power = Math.max(0.0d, power - wakelockPowerEstimate);
    L26:
        if (power == 0.0d) goto L28;
        deviceStatsIntermediates.power = power;
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStatsArray, power);
        stats.setDeviceStats(deviceStateEstimation.stateValues, this.mTmpDeviceStatsArray);
        goto L28
    }

    private void adjustEstimatesUsingEnergyConsumers(Intermediates intermediates, DeviceStatsIntermediates deviceStatsIntermediates) {
        int energyConsumerCount = this.mStatsLayout.getEnergyConsumerCount();
        if (energyConsumerCount != 0) goto L6;
        return;
    L6:
        if (intermediates.powerByEnergyConsumer != null) goto L8;
        intermediates.powerByEnergyConsumer = new long[energyConsumerCount];
    L9:
        int i = 0;
    L10:
        if (i >= energyConsumerCount) goto L12;
        long[] r2 = intermediates.powerByEnergyConsumer;
        int r3 = this.mEnergyConsumerToCombinedEnergyConsumerMap[i];
        r2[r3] = r2[r3] + this.mStatsLayout.getConsumedEnergy(this.mTmpDeviceStatsArray, i);
        i = i + 1;
        goto L10
    L12:
        int combinedConsumer = this.mCombinedEnergyConsumerToPowerBracketMap.length - 1;
    L13:
        if (combinedConsumer < 0) goto L29;
        int[] combinedEnergyConsumerToPowerBracketMap = this.mCombinedEnergyConsumerToPowerBracketMap[combinedConsumer];
        if (combinedEnergyConsumerToPowerBracketMap == null) goto L27;
        double consumedEnergy = PowerStatsProcessor.uCtoMah(intermediates.powerByEnergyConsumer[combinedConsumer]);
        double totalModeledPower = 0.0d;
        int r7 = combinedEnergyConsumerToPowerBracketMap.length;
        int r8 = 0;
        int r9 = 0;
    L18:
        if (r9 >= r7) goto L21;
        totalModeledPower = totalModeledPower + deviceStatsIntermediates.powerByBracket[combinedEnergyConsumerToPowerBracketMap[r9]];
        r9 = r9 + 1;
        goto L18
    L21:
        if (totalModeledPower == 0.0d) goto L27;
        int r10 = combinedEnergyConsumerToPowerBracketMap.length;
    L25:
        if (r8 >= r10) goto L27;
        int bracket = combinedEnergyConsumerToPowerBracketMap[r8];
        deviceStatsIntermediates.powerByBracket[bracket] = (deviceStatsIntermediates.powerByBracket[bracket] * consumedEnergy) / totalModeledPower;
        r8 = r8 + 1;
    L27:
        combinedConsumer = combinedConsumer - 1;
        goto L13
    L29:
        return;
    L8:
        Arrays.fill(intermediates.powerByEnergyConsumer, 0);
        goto L9
    }

    private void combineDeviceStateEstimates() {
        int i = this.mPlan.combinedDeviceStateEstimations.size() - 1;
    L3:
        if (i < 0) goto L12;
        PowerStatsProcessor.CombinedDeviceStateEstimate cdse = this.mPlan.combinedDeviceStateEstimations.get(i);
        DeviceStatsIntermediates cdseIntermediates = new DeviceStatsIntermediates(null);
        cdse.intermediates = cdseIntermediates;
        int bracketCount = this.mStatsLayout.getCpuPowerBracketCount();
        cdseIntermediates.timeByBracket = new long[bracketCount];
        cdseIntermediates.powerByBracket = new double[bracketCount];
        List<PowerStatsProcessor.DeviceStateEstimation> deviceStateEstimations = cdse.deviceStateEstimations;
        int j = deviceStateEstimations.size() - 1;
    L5:
        if (j < 0) goto L10;
        PowerStatsProcessor.DeviceStateEstimation dse = deviceStateEstimations.get(j);
        DeviceStatsIntermediates intermediates = (DeviceStatsIntermediates) dse.intermediates;
        cdseIntermediates.power += intermediates.power;
        int k = 0;
    L7:
        if (k >= bracketCount) goto L9;
        long[] r9 = cdseIntermediates.timeByBracket;
        r9[k] = r9[k] + intermediates.timeByBracket[k];
        double[] r10 = cdseIntermediates.powerByBracket;
        r10[k] = r10[k] + intermediates.powerByBracket[k];
        k = k + 1;
        goto L7
    L9:
        j = j - 1;
        goto L5
    L10:
        i = i - 1;
        goto L3
    }

    private void estimateUidPowerConsumption(PowerComponentAggregatedPowerStats stats, int uid, PowerStatsProcessor.UidStateEstimate uidStateEstimate, PowerComponentAggregatedPowerStats wakelockStats) {
        PowerStatsProcessor.CombinedDeviceStateEstimate combinedDeviceStateEstimate = uidStateEstimate.combinedDeviceStateEstimate;
        DeviceStatsIntermediates cdsIntermediates = (DeviceStatsIntermediates) combinedDeviceStateEstimate.intermediates;
        int i = 0;
    L4:
        if (i >= uidStateEstimate.proportionalEstimates.size()) goto L30;
        PowerStatsProcessor.UidStateProportionalEstimate proportionalEstimate = uidStateEstimate.proportionalEstimates.get(i);
        if (stats.getUidStats(this.mTmpUidStatsArray, uid, proportionalEstimate.stateValues) == false) goto L28;
        double power = 0.0d;
        int bracket = 0;
    L10:
        if (bracket >= this.mStatsLayout.getCpuPowerBracketCount()) goto L19;
        if (cdsIntermediates.timeByBracket[bracket] == 0) goto L18;
        long timeInBracket = this.mStatsLayout.getUidTimeByPowerBracket(this.mTmpUidStatsArray, bracket);
        if (timeInBracket == 0) goto L18;
        double power2 = power;
        double power3 = timeInBracket;
        power = power2 + ((cdsIntermediates.powerByBracket[bracket] * power3) / cdsIntermediates.timeByBracket[bracket]);
    L18:
        bracket = bracket + 1;
        goto L10
    L19:
        double power4 = power;
        if (wakelockStats != null) goto L22;
    L24:
        double power5 = power4;
    L26:
        if (power5 == 0.0d) goto L28;
        this.mStatsLayout.setUidPowerEstimate(this.mTmpUidStatsArray, power5);
        stats.setUidStats(uid, proportionalEstimate.stateValues, this.mTmpUidStatsArray);
        goto L28
    L22:
        if (wakelockStats.getUidStats(this.mTmpWakelockUidStats, uid, proportionalEstimate.stateValues) == false) goto L24;
        double wakelockPowerEstimate = this.mWakelockPowerStatsLayout.getUidPowerEstimate(this.mTmpWakelockUidStats);
        power5 = Math.max(0.0d, power4 - wakelockPowerEstimate);
    L28:
        i = i + 1;
        goto L4
    }
}
