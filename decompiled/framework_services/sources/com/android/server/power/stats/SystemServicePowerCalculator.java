package com.android.server.power.stats;

import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.UidBatteryConsumer;
import android.util.SparseArray;
import com.android.internal.os.CpuScalingPolicies;
import com.android.internal.os.PowerProfile;

/* JADX INFO: loaded from: classes3.dex */
public class SystemServicePowerCalculator extends PowerCalculator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SystemServicePowerCalc";
    private final CpuPowerCalculator mCpuPowerCalculator;
    private final UsageBasedPowerEstimator[] mPowerEstimators;

    public SystemServicePowerCalculator(CpuScalingPolicies cpuScalingPolicies, PowerProfile powerProfile) {
        this.mCpuPowerCalculator = new CpuPowerCalculator(cpuScalingPolicies, powerProfile);
        this.mPowerEstimators = new UsageBasedPowerEstimator[cpuScalingPolicies.getScalingStepCount()];
        int index = 0;
        int[] policies = cpuScalingPolicies.getPolicies();
        int r2 = policies.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        int policy = policies[r3];
        int numSpeeds = cpuScalingPolicies.getFrequencies(policy).length;
        int speed = 0;
    L5:
        if (speed >= numSpeeds) goto L7;
        this.mPowerEstimators[index] = new UsageBasedPowerEstimator(powerProfile.getAveragePowerForCpuScalingStep(policy, speed));
        speed = speed + 1;
        index = index + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public boolean isPowerComponentSupported(int powerComponent) {
        if (powerComponent != 7) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.power.stats.PowerCalculator
    public void calculate(BatteryUsageStats.Builder builder, BatteryStats batteryStats, long rawRealtimeUs, long rawUptimeUs, BatteryUsageStatsQuery query) {
        BatteryStats.Uid systemUid = (BatteryStats.Uid) batteryStats.getUidStats().get(1000);
        if (systemUid != null) goto L5;
        return;
    L5:
        long consumptionUC = systemUid.getCpuEnergyConsumptionUC();
        int powerModel = PowerCalculator.getPowerModel(consumptionUC, query);
        if (powerModel != 2) goto L8;
        double systemServicePowerMah = calculatePowerUsingEnergyConsumption(batteryStats, systemUid, consumptionUC);
    L9:
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        UidBatteryConsumer.Builder systemServerConsumer = uidBatteryConsumerBuilders.get(1000);
        if (systemServerConsumer == null) goto L12;
        systemServicePowerMah = Math.min(systemServicePowerMah, systemServerConsumer.getTotalPower());
        systemServerConsumer.setConsumedPower(17, -systemServicePowerMah, powerModel);
    L12:
        int i = uidBatteryConsumerBuilders.size() - 1;
    L14:
        if (i < 0) goto L20;
        UidBatteryConsumer.Builder app = uidBatteryConsumerBuilders.valueAt(i);
        if (app == systemServerConsumer) goto L19;
        BatteryStats.Uid uid = app.getBatteryStatsUid();
        app.setConsumedPower(7, systemServicePowerMah * uid.getProportionalSystemServiceUsage(), powerModel);
    L19:
        i = i - 1;
        systemUid = systemUid;
        goto L14
    L20:
        builder.getAggregateBatteryConsumerBuilder(0).setConsumedPower(7, systemServicePowerMah);
        builder.getAggregateBatteryConsumerBuilder(1).setConsumedPower(7, systemServicePowerMah);
        return;
    L8:
        systemServicePowerMah = calculatePowerUsingPowerProfile(batteryStats);
        goto L9
    }

    private double calculatePowerUsingEnergyConsumption(BatteryStats batteryStats, BatteryStats.Uid systemUid, long consumptionUC) {
        double systemServiceModeledPowerMah = calculatePowerUsingPowerProfile(batteryStats);
        double systemUidModeledPowerMah = this.mCpuPowerCalculator.calculateUidModeledPowerMah(systemUid, 0);
        if (systemUidModeledPowerMah > 0.0d) goto L5;
        return 0.0d;
    L5:
        return (PowerCalculator.uCtoMah(consumptionUC) * systemServiceModeledPowerMah) / systemUidModeledPowerMah;
    }

    private double calculatePowerUsingPowerProfile(BatteryStats batteryStats) {
        long[] systemServiceTimeAtCpuSpeeds = batteryStats.getSystemServiceTimeAtCpuSpeeds();
        if (systemServiceTimeAtCpuSpeeds != null) goto L6;
        return 0.0d;
    L6:
        double powerMah = 0.0d;
        int size = Math.min(this.mPowerEstimators.length, systemServiceTimeAtCpuSpeeds.length);
        int i = 0;
    L7:
        if (i >= size) goto L10;
        powerMah = powerMah + this.mPowerEstimators[i].calculatePower(systemServiceTimeAtCpuSpeeds[i] / 1000);
        i = i + 1;
        goto L7
    L10:
        return powerMah;
    }
}
