package com.android.server.power.stats;

import android.os.AggregateBatteryConsumer;
import android.os.BatteryConsumer;
import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.os.CpuScalingPolicies;
import com.android.internal.os.PowerProfile;
import com.android.server.am.SettingsToPropertiesMapper;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class CpuPowerCalculator extends PowerCalculator {
    private static final boolean DEBUG = false;
    private static final String TAG = "CpuPowerCalculator";
    private static final BatteryConsumer.Key[] UNINITIALIZED_KEYS = null;
    private final UsageBasedPowerEstimator mCpuActivePowerEstimator;
    private final CpuScalingPolicies mCpuScalingPolicies;
    private final int mNumCpuClusters;
    private final UsageBasedPowerEstimator[] mPerClusterPowerEstimators;
    private final UsageBasedPowerEstimator[] mPerCpuFreqPowerEstimators;
    private final UsageBasedPowerEstimator[][] mPerCpuFreqPowerEstimatorsByCluster;

    private static class Result {
        public long[] cpuFreqTimes;
        public long durationFgMs;
        public long durationMs;
        public String packageWithHighestDrain;
        public double[] perProcStatePowerMah;
        public double powerMah;

        /* synthetic */ Result(CpuPowerCalculatorIA r1) {
            this();
        }

        private Result() {
        }
    }

    static {
        UNINITIALIZED_KEYS = new BatteryConsumer.Key[0];
    }

    public CpuPowerCalculator(CpuScalingPolicies cpuScalingPolicies, PowerProfile profile) {
        this.mCpuScalingPolicies = cpuScalingPolicies;
        int[] policies = this.mCpuScalingPolicies.getPolicies();
        this.mNumCpuClusters = policies.length;
        this.mCpuActivePowerEstimator = new UsageBasedPowerEstimator(profile.getAveragePower("cpu.active"));
        this.mPerClusterPowerEstimators = new UsageBasedPowerEstimator[policies.length];
        int i = 0;
    L4:
        if (i >= policies.length) goto L6;
        this.mPerClusterPowerEstimators[i] = new UsageBasedPowerEstimator(profile.getAveragePowerForCpuScalingPolicy(policies[i]));
        i = i + 1;
        goto L4
    L6:
        this.mPerCpuFreqPowerEstimators = new UsageBasedPowerEstimator[cpuScalingPolicies.getScalingStepCount()];
        this.mPerCpuFreqPowerEstimatorsByCluster = new UsageBasedPowerEstimator[this.mNumCpuClusters][];
        int index = 0;
        int cluster = 0;
    L8:
        if (cluster >= policies.length) goto L15;
        int policy = policies[cluster];
        int[] freqs = cpuScalingPolicies.getFrequencies(policy);
        this.mPerCpuFreqPowerEstimatorsByCluster[cluster] = new UsageBasedPowerEstimator[freqs.length];
        int step = 0;
    L11:
        if (step >= freqs.length) goto L13;
        UsageBasedPowerEstimator estimator = new UsageBasedPowerEstimator(profile.getAveragePowerForCpuScalingStep(policy, step));
        this.mPerCpuFreqPowerEstimatorsByCluster[cluster][step] = estimator;
        this.mPerCpuFreqPowerEstimators[index] = estimator;
        step = step + 1;
        index = index + 1;
        goto L11
    L13:
        cluster = cluster + 1;
        goto L8
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        double totalPowerMah = 0.0d;
        BatteryConsumer.Key[] keys = UNINITIALIZED_KEYS;
        Result result = new Result(null);
        if (query.isProcessStateDataNeeded() == false) goto L5;
        result.cpuFreqTimes = new long[this.mCpuScalingPolicies.getScalingStepCount()];
    L5:
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
    L6:
        if (i < 0) goto L18;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        if (keys == UNINITIALIZED_KEYS) goto L10;
        BatteryConsumer.Key[] keys2 = keys;
    L14:
        calculateApp(app, app.getBatteryStatsUid(), query, result, keys2);
        if (app.isVirtualUid() == true) goto L17;
        totalPowerMah = totalPowerMah + result.powerMah;
    L17:
        i = i - 1;
        keys = keys2;
        goto L6
    L10:
        if (query.isProcessStateDataNeeded() == false) goto L12;
        BatteryConsumer.Key[] keys3 = app.getKeys(1);
        keys2 = keys3;
        goto L14
    L12:
        keys2 = null;
        goto L14
    L18:
        long consumptionUC = batteryStats.getCpuEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumptionUC, query);
        builder.getAggregateBatteryConsumerBuilder(1).setConsumedPower(1, totalPowerMah);
        AggregateBatteryConsumer.Builder r8 = builder.getAggregateBatteryConsumerBuilder(0);
        if (powerModel != 2) goto L21;
        double r13 = PowerCalculator.uCtoMah(consumptionUC);
    L22:
        r8.setConsumedPower(1, r13, powerModel);
        return;
    L21:
        r13 = totalPowerMah;
        goto L22
    }

    private void calculateApp(UidBatteryConsumer.Builder app, BatteryStats.Uid u, BatteryUsageStatsQuery query, Result result, BatteryConsumer.Key[] keys) {
        long consumptionUC = u.getCpuEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumptionUC, query);
        calculatePowerAndDuration(u, powerModel, consumptionUC, 0, result);
        app.setConsumedPower(1, result.powerMah, powerModel).setUsageDurationMillis(1, result.durationMs).setPackageWithHighestDrain(result.packageWithHighestDrain);
        if (query.isProcessStateDataNeeded() == false) goto L9;
        BatteryConsumer.Key key = app.getKey(1, 1);
        if (key == null) goto L7;
        app.setUsageDurationMillis(key, result.durationFgMs);
        goto L9
    L7:
        Log.d(TAG, "UID " + u.getUid() + ": CPU fg time=" + result.durationFgMs + "ms. key is null");
    L9:
        if (query.isProcessStateDataNeeded() == false) goto L16;
        if (keys == null) goto L17;
        switch(powerModel) {
            case 1: goto L14;
            case 2: goto L13;
            default: goto L19;
        };
    L13:
        calculateEnergyConsumptionPerProcessState(app, u, keys);
        return;
    L14:
        calculateModeledPowerPerProcessState(app, u, keys, result);
        return;
    L19:
        return;
    L17:
        return;
    }

    private void calculateEnergyConsumptionPerProcessState(UidBatteryConsumer.Builder app, BatteryStats.Uid u, BatteryConsumer.Key[] keys) {
        int r0 = keys.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        BatteryConsumer.Key key = keys[r1];
        if (key.processState == 0) goto L10;
        long consumptionUC = u.getCpuEnergyConsumptionUC(key.processState);
        if (consumptionUC == 0) goto L10;
        app.setConsumedPower(key, PowerCalculator.uCtoMah(consumptionUC), 2);
    L10:
        r1 = r1 + 1;
        goto L3
    }

    private void calculateModeledPowerPerProcessState(UidBatteryConsumer.Builder app, BatteryStats.Uid u, BatteryConsumer.Key[] keys, Result result) {
        if (result.perProcStatePowerMah != null) goto L5;
        result.perProcStatePowerMah = new double[5];
    L6:
        int uidProcState = 0;
    L8:
        if (uidProcState >= 7) goto L17;
        int procState = BatteryStats.mapUidProcessStateToBatteryConsumerProcessState(uidProcState);
        if (procState == 0) goto L16;
        boolean hasCpuFreqTimes = u.getCpuFreqTimes(result.cpuFreqTimes, uidProcState);
        if (0 != 0) goto L15;
        if (hasCpuFreqTimes == false) goto L16;
    L15:
        double[] r11 = result.perProcStatePowerMah;
        r11[procState] = r11[procState] + calculateUidModeledPowerMah(u, 0, null, result.cpuFreqTimes);
    L16:
        uidProcState = uidProcState + 1;
        goto L8
    L17:
        int r2 = keys.length;
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L24;
        BatteryConsumer.Key key = keys[r3];
        if (key.processState == 0) goto L23;
        long cpuActiveTime = u.getCpuActiveTime(key.processState);
        double powerMah = result.perProcStatePowerMah[key.processState];
        app.setConsumedPower(key, powerMah + this.mCpuActivePowerEstimator.calculatePower(cpuActiveTime), 1).setUsageDurationMillis(key, cpuActiveTime);
    L23:
        r3 = r3 + 1;
        goto L18
    L24:
        return;
    L5:
        Arrays.fill(result.perProcStatePowerMah, 0.0d);
        goto L6
    }

    private void calculatePowerAndDuration(BatteryStats.Uid u, int powerModel, long consumptionUC, int statsType, Result result) {
        int r1 = statsType;
        long durationMs = (u.getUserCpuTimeUs(r1) + u.getSystemCpuTimeUs(r1)) / 1000;
        switch(powerModel) {
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        double powerMah = calculateUidModeledPowerMah(u, r1);
    L6:
        double highestDrain = 0.0d;
        String packageWithHighestDrain = null;
        long durationFgMs = 0;
        ArrayMap<String, ? extends BatteryStats.Uid.Proc> processStats = u.getProcessStats();
        int processStatsCount = processStats.size();
        int i = 0;
    L7:
        if (i >= processStatsCount) goto L22;
        BatteryStats.Uid.Proc ps = (BatteryStats.Uid.Proc) processStats.valueAt(i);
        long durationMs2 = durationMs;
        String processName = processStats.keyAt(i);
        durationFgMs = durationFgMs + ps.getForegroundTime(r1);
        long costValue = (ps.getUserTime(r1) + ps.getSystemTime(r1)) + ps.getForegroundTime(r1);
        if (packageWithHighestDrain == null) goto L20;
        if (packageWithHighestDrain.startsWith(SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER) == true) goto L20;
        double highestDrain2 = highestDrain;
        double highestDrain3 = costValue;
        if (highestDrain2 < highestDrain3) goto L16;
    L18:
        highestDrain = highestDrain2;
    L21:
        i = i + 1;
        r1 = statsType;
        durationMs = durationMs2;
        goto L7
    L16:
        if (processName.startsWith(SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER) == true) goto L18;
        highestDrain = costValue;
        packageWithHighestDrain = processName;
    L20:
        highestDrain = costValue;
        packageWithHighestDrain = processName;
        goto L21
    L22:
        long durationMs3 = durationMs;
        if (durationFgMs <= durationMs3) goto L25;
        long durationMs4 = durationFgMs;
    L26:
        result.durationMs = durationMs4;
        result.durationFgMs = durationFgMs;
        result.powerMah = powerMah;
        result.packageWithHighestDrain = packageWithHighestDrain;
        return;
    L25:
        durationMs4 = durationMs3;
        goto L26
    L5:
        powerMah = PowerCalculator.uCtoMah(consumptionUC);
        goto L6
    }

    public double calculateUidModeledPowerMah(BatteryStats.Uid u, int statsType) {
        return calculateUidModeledPowerMah(u, u.getCpuActiveTime(), u.getCpuClusterTimes(), u.getCpuFreqTimes(statsType));
    }

    private double calculateUidModeledPowerMah(BatteryStats.Uid u, long cpuActiveTime, long[] cpuClusterTimes, long[] cpuFreqTimes) {
        double powerMah = calculateActiveCpuPowerMah(cpuActiveTime);
        if (cpuClusterTimes != null) goto L5;
    L12:
        if (cpuFreqTimes != null) goto L14;
    L21:
        return powerMah;
    L14:
        if (cpuFreqTimes.length != this.mPerCpuFreqPowerEstimators.length) goto L20;
        int i = 0;
    L17:
        if (i >= cpuFreqTimes.length) goto L21;
        powerMah = powerMah + this.mPerCpuFreqPowerEstimators[i].calculatePower(cpuFreqTimes[i]);
        i = i + 1;
        goto L17
    L20:
        Log.w(TAG, "UID " + u.getUid() + " CPU freq # mismatch: Power Profile # " + this.mPerCpuFreqPowerEstimators.length + " actual # " + cpuFreqTimes.length);
        goto L21
    L5:
        if (cpuClusterTimes.length != this.mNumCpuClusters) goto L11;
        int cluster = 0;
    L8:
        if (cluster >= this.mNumCpuClusters) goto L12;
        double power = this.mPerClusterPowerEstimators[cluster].calculatePower(cpuClusterTimes[cluster]);
        powerMah = powerMah + power;
        cluster = cluster + 1;
        goto L8
    L11:
        Log.w(TAG, "UID " + u.getUid() + " CPU cluster # mismatch: Power Profile # " + this.mNumCpuClusters + " actual # " + cpuClusterTimes.length);
        goto L12
    }

    private double calculateActiveCpuPowerMah(long durationsMs) {
        return this.mCpuActivePowerEstimator.calculatePower(durationsMs);
    }

    public double calculatePerCpuClusterPowerMah(int cluster, long clusterDurationMs) {
        return this.mPerClusterPowerEstimators[cluster].calculatePower(clusterDurationMs);
    }

    public double calculatePerCpuFreqPowerMah(int cluster, int speedStep, long clusterSpeedDurationsMs) {
        return this.mPerCpuFreqPowerEstimatorsByCluster[cluster][speedStep].calculatePower(clusterSpeedDurationsMs);
    }
}
