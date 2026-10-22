package com.android.server.power.stats.format;

import android.os.PersistableBundle;
import com.android.internal.os.PowerStats;

/* JADX INFO: loaded from: classes3.dex */
public class CpuPowerStatsLayout extends PowerStatsLayout {
    private static final String EXTRA_DEVICE_TIME_BY_CLUSTER_COUNT = "dcc";
    private static final String EXTRA_DEVICE_TIME_BY_CLUSTER_POSITION = "dc";
    private static final String EXTRA_DEVICE_TIME_BY_SCALING_STEP_COUNT = "dtc";
    private static final String EXTRA_DEVICE_TIME_BY_SCALING_STEP_POSITION = "dt";
    private static final String EXTRA_UID_BRACKETS_POSITION = "ub";
    private static final String EXTRA_UID_STATS_SCALING_STEP_TO_POWER_BRACKET = "us";
    private int mDeviceCpuTimeByClusterCount;
    private int mDeviceCpuTimeByClusterPosition;
    private int mDeviceCpuTimeByScalingStepCount;
    private int mDeviceCpuTimeByScalingStepPosition;
    private int[] mScalingStepToPowerBracketMap;
    private int mUidPowerBracketCount;
    private int mUidPowerBracketsPosition;

    public CpuPowerStatsLayout(int energyConsumerCount, int cpuScalingPolicyCount, int[] scalingStepToPowerBracketMap) {
        addDeviceSectionCpuTimeByScalingStep(scalingStepToPowerBracketMap.length);
        addDeviceSectionCpuTimeByCluster(cpuScalingPolicyCount);
        addDeviceSectionUsageDuration();
        addDeviceSectionEnergyConsumers(energyConsumerCount);
        addDeviceSectionPowerEstimate();
        addUidSectionCpuTimeByPowerBracket(scalingStepToPowerBracketMap);
        addUidSectionPowerEstimate();
    }

    public CpuPowerStatsLayout(PowerStats.Descriptor descriptor) {
        super(descriptor);
        PersistableBundle extras = descriptor.extras;
        this.mDeviceCpuTimeByScalingStepPosition = extras.getInt(EXTRA_DEVICE_TIME_BY_SCALING_STEP_POSITION);
        this.mDeviceCpuTimeByScalingStepCount = extras.getInt(EXTRA_DEVICE_TIME_BY_SCALING_STEP_COUNT);
        this.mDeviceCpuTimeByClusterPosition = extras.getInt(EXTRA_DEVICE_TIME_BY_CLUSTER_POSITION);
        this.mDeviceCpuTimeByClusterCount = extras.getInt(EXTRA_DEVICE_TIME_BY_CLUSTER_COUNT);
        this.mUidPowerBracketsPosition = extras.getInt(EXTRA_UID_BRACKETS_POSITION);
        this.mScalingStepToPowerBracketMap = getIntArray(extras, EXTRA_UID_STATS_SCALING_STEP_TO_POWER_BRACKET);
        if (this.mScalingStepToPowerBracketMap != null) goto L5;
        this.mScalingStepToPowerBracketMap = new int[this.mDeviceCpuTimeByScalingStepCount];
    L5:
        updatePowerBracketCount();
    }

    @Override // com.android.server.power.stats.format.PowerStatsLayout
    public void toExtras(PersistableBundle extras) {
        super.toExtras(extras);
        extras.putInt(EXTRA_DEVICE_TIME_BY_SCALING_STEP_POSITION, this.mDeviceCpuTimeByScalingStepPosition);
        extras.putInt(EXTRA_DEVICE_TIME_BY_SCALING_STEP_COUNT, this.mDeviceCpuTimeByScalingStepCount);
        extras.putInt(EXTRA_DEVICE_TIME_BY_CLUSTER_POSITION, this.mDeviceCpuTimeByClusterPosition);
        extras.putInt(EXTRA_DEVICE_TIME_BY_CLUSTER_COUNT, this.mDeviceCpuTimeByClusterCount);
        extras.putInt(EXTRA_UID_BRACKETS_POSITION, this.mUidPowerBracketsPosition);
        putIntArray(extras, EXTRA_UID_STATS_SCALING_STEP_TO_POWER_BRACKET, this.mScalingStepToPowerBracketMap);
    }

    private void addDeviceSectionCpuTimeByScalingStep(int scalingStepCount) {
        this.mDeviceCpuTimeByScalingStepPosition = addDeviceSection(scalingStepCount, "steps");
        this.mDeviceCpuTimeByScalingStepCount = scalingStepCount;
    }

    public int getCpuScalingStepCount() {
        return this.mDeviceCpuTimeByScalingStepCount;
    }

    public void setTimeByScalingStep(long[] stats, int step, long value) {
        stats[this.mDeviceCpuTimeByScalingStepPosition + step] = value;
    }

    public long getTimeByScalingStep(long[] stats, int step) {
        return stats[this.mDeviceCpuTimeByScalingStepPosition + step];
    }

    private void addDeviceSectionCpuTimeByCluster(int clusterCount) {
        this.mDeviceCpuTimeByClusterPosition = addDeviceSection(clusterCount, "clusters");
        this.mDeviceCpuTimeByClusterCount = clusterCount;
    }

    public int getCpuClusterCount() {
        return this.mDeviceCpuTimeByClusterCount;
    }

    public void setTimeByCluster(long[] stats, int cluster, long value) {
        stats[this.mDeviceCpuTimeByClusterPosition + cluster] = value;
    }

    public long getTimeByCluster(long[] stats, int cluster) {
        return stats[this.mDeviceCpuTimeByClusterPosition + cluster];
    }

    private void addUidSectionCpuTimeByPowerBracket(int[] scalingStepToPowerBracketMap) {
        this.mScalingStepToPowerBracketMap = scalingStepToPowerBracketMap;
        updatePowerBracketCount();
        this.mUidPowerBracketsPosition = addUidSection(this.mUidPowerBracketCount, "time");
    }

    private void updatePowerBracketCount() {
        this.mUidPowerBracketCount = 1;
        int[] r0 = this.mScalingStepToPowerBracketMap;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int bracket = r0[r2];
        if (bracket < this.mUidPowerBracketCount) goto L7;
        this.mUidPowerBracketCount = bracket + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    }

    public int[] getScalingStepToPowerBracketMap() {
        return this.mScalingStepToPowerBracketMap;
    }

    public int getCpuPowerBracketCount() {
        return this.mUidPowerBracketCount;
    }

    public void setUidTimeByPowerBracket(long[] stats, int bracket, long value) {
        stats[this.mUidPowerBracketsPosition + bracket] = value;
    }

    public long getUidTimeByPowerBracket(long[] stats, int bracket) {
        return stats[this.mUidPowerBracketsPosition + bracket];
    }
}
