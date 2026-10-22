package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import android.util.Log;
import com.android.internal.os.PowerStats;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class PowerStatsProcessor {
    private static final double MILLIAMPHOUR_PER_MICROCOULOMB = 2.777777777777778E-7d;
    private static final String TAG = "PowerStatsProcessor";

    protected static class CombinedDeviceStateEstimate {
        public List<DeviceStateEstimation> deviceStateEstimations;
        public final String id;
        public Object intermediates;
        public final int[] stateValues;

        public CombinedDeviceStateEstimate(MultiStateStats.States[] config, int[] stateValues) {
            this.deviceStateEstimations = new ArrayList();
            this.stateValues = Arrays.copyOf(stateValues, stateValues.length);
            this.id = PowerStatsProcessor.m7865$$Nest$smconcatLabels(config, stateValues);
        }
    }

    protected static class DeviceStateEstimation {
        public final String id;
        public Object intermediates;
        public final int[] stateValues;

        public DeviceStateEstimation(MultiStateStats.States[] config, int[] stateValues) {
            this.id = PowerStatsProcessor.m7865$$Nest$smconcatLabels(config, stateValues);
            this.stateValues = stateValues;
        }
    }

    protected static class PowerEstimationPlan {
        public List<CombinedDeviceStateEstimate> combinedDeviceStateEstimations;
        public List<DeviceStateEstimation> deviceStateEstimations;
        private final AggregatedPowerStatsConfig.PowerComponent mConfig;
        public List<UidStateEstimate> uidStateEstimates;

        public PowerEstimationPlan(AggregatedPowerStatsConfig.PowerComponent config) {
            this.deviceStateEstimations = new ArrayList();
            this.combinedDeviceStateEstimations = new ArrayList();
            this.uidStateEstimates = new ArrayList();
            this.mConfig = config;
            addDeviceStateEstimations();
            combineDeviceStateEstimations();
            addUidStateEstimations();
        }

        private void addDeviceStateEstimations() {
            MultiStateStats.States[] config = this.mConfig.getDeviceStateConfig();
            int[][] deviceStateCombinations = PowerStatsProcessor.m7866$$Nest$smgetAllTrackedStateCombinations(config);
            int r2 = deviceStateCombinations.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L5;
            int[] deviceStateCombination = deviceStateCombinations[r3];
            this.deviceStateEstimations.add(new DeviceStateEstimation(config, deviceStateCombination));
            r3 = r3 + 1;
            goto L3
        }

        private void combineDeviceStateEstimations() {
            MultiStateStats.States[] deviceStateConfig = this.mConfig.getDeviceStateConfig();
            MultiStateStats.States[] uidStateConfig = this.mConfig.getUidStateConfig();
            MultiStateStats.States[] deviceStatesTrackedPerUid = new MultiStateStats.States[deviceStateConfig.length];
            int i = 0;
        L4:
            if (i >= deviceStateConfig.length) goto L14;
            if (deviceStateConfig[i].isTracked() == false) goto L13;
            int index = MultiStateStats.States.findTrackedStateByName(uidStateConfig, deviceStateConfig[i].getName());
            if (index == (-1)) goto L13;
            if (uidStateConfig[index].isTracked() == false) goto L13;
            deviceStatesTrackedPerUid[i] = deviceStateConfig[i];
        L13:
            i = i + 1;
            goto L4
        L14:
            int i2 = deviceStateConfig.length;
            combineDeviceStateEstimationsRecursively(deviceStateConfig, deviceStatesTrackedPerUid, new int[i2], 0);
        }

        private void combineDeviceStateEstimationsRecursively(MultiStateStats.States[] deviceStateConfig, MultiStateStats.States[] deviceStatesTrackedPerUid, int[] stateValues, int state) {
            if (state < deviceStateConfig.length) goto L10;
            DeviceStateEstimation dse = getDeviceStateEstimate(stateValues);
            CombinedDeviceStateEstimate cdse = getCombinedDeviceStateEstimate(deviceStatesTrackedPerUid, stateValues);
            if (cdse != null) goto L7;
            cdse = new CombinedDeviceStateEstimate(deviceStatesTrackedPerUid, stateValues);
            this.combinedDeviceStateEstimations.add(cdse);
        L7:
            cdse.deviceStateEstimations.add(dse);
            return;
        L10:
            if (deviceStateConfig[state].isTracked() == false) goto L16;
            int stateValue = 0;
        L13:
            if (stateValue >= deviceStateConfig[state].getLabels().length) goto L19;
            stateValues[state] = stateValue;
            combineDeviceStateEstimationsRecursively(deviceStateConfig, deviceStatesTrackedPerUid, stateValues, state + 1);
            stateValue = stateValue + 1;
            goto L13
        L19:
            return;
        L16:
            combineDeviceStateEstimationsRecursively(deviceStateConfig, deviceStatesTrackedPerUid, stateValues, state + 1);
        }

        private void addUidStateEstimations() {
            MultiStateStats.States[] deviceStateConfig = this.mConfig.getDeviceStateConfig();
            MultiStateStats.States[] uidStateConfig = this.mConfig.getUidStateConfig();
            MultiStateStats.States[] uidStatesTrackedForDevice = new MultiStateStats.States[uidStateConfig.length];
            MultiStateStats.States[] uidStatesNotTrackedForDevice = new MultiStateStats.States[uidStateConfig.length];
            int i = 0;
        L4:
            if (i >= uidStateConfig.length) goto L15;
            if (uidStateConfig[i].isTracked() == false) goto L14;
            int index = MultiStateStats.States.findTrackedStateByName(deviceStateConfig, uidStateConfig[i].getName());
            if (index != (-1)) goto L11;
        L13:
            uidStatesNotTrackedForDevice[i] = uidStateConfig[i];
            goto L14
        L11:
            if (deviceStateConfig[index].isTracked() == false) goto L13;
            uidStatesTrackedForDevice[i] = uidStateConfig[i];
        L14:
            i = i + 1;
            goto L4
        L15:
            int[][] uidStateCombinations = PowerStatsProcessor.m7866$$Nest$smgetAllTrackedStateCombinations(uidStateConfig);
            int r5 = uidStateCombinations.length;
            int r6 = 0;
        L16:
            if (r6 >= r5) goto L25;
            int[] stateValues = uidStateCombinations[r6];
            CombinedDeviceStateEstimate combined = getCombinedDeviceStateEstimate(uidStatesTrackedForDevice, stateValues);
            if (combined != null) goto L20;
            Log.wtf(PowerStatsProcessor.TAG, "Mismatch in UID and combined device states: " + PowerStatsProcessor.m7865$$Nest$smconcatLabels(uidStatesTrackedForDevice, stateValues));
        L24:
            r6 = r6 + 1;
            goto L16
        L20:
            UidStateEstimate uidStateEstimate = getUidStateEstimate(combined);
            if (uidStateEstimate != null) goto L23;
            uidStateEstimate = new UidStateEstimate(combined, uidStatesNotTrackedForDevice);
            this.uidStateEstimates.add(uidStateEstimate);
        L23:
            uidStateEstimate.proportionalEstimates.add(new UidStateProportionalEstimate(stateValues));
            goto L24
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Step 1. Compute device-wide power estimates for state combinations:\n");
            Iterator<DeviceStateEstimation> r1 = this.deviceStateEstimations.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            DeviceStateEstimation deviceStateEstimation = r1.next();
            sb.append("    ");
            sb.append(deviceStateEstimation.id);
            sb.append("\n");
            goto L4
        L6:
            sb.append("Step 2. Combine device-wide estimates that are untracked per UID:\n");
            boolean any = false;
            Iterator<CombinedDeviceStateEstimate> r2 = this.combinedDeviceStateEstimations.iterator();
        L8:
            if (r2.hasNext() == false) goto L19;
            CombinedDeviceStateEstimate cdse = r2.next();
            if (cdse.deviceStateEstimations.size() <= 1) goto L8;
            any = true;
            sb.append("    ");
            sb.append(cdse.id);
            sb.append(": ");
            int i = 0;
        L14:
            if (i >= cdse.deviceStateEstimations.size()) goto L18;
            if (i == 0) goto L17;
            sb.append(" + ");
        L17:
            sb.append(cdse.deviceStateEstimations.get(i).id);
            i = i + 1;
            goto L14
        L18:
            sb.append("\n");
            goto L8
        L19:
            if (any == true) goto L21;
            sb.append("    N/A\n");
        L21:
            sb.append("Step 3. Proportionally distribute power estimates to UIDs:\n");
            Iterator<UidStateEstimate> r3 = this.uidStateEstimates.iterator();
        L23:
            if (r3.hasNext() == false) goto L33;
            UidStateEstimate uidStateEstimate = r3.next();
            sb.append("    ");
            sb.append(uidStateEstimate.combinedDeviceStateEstimate.id);
            sb.append("\n        among: ");
            int i2 = 0;
        L26:
            if (i2 >= uidStateEstimate.proportionalEstimates.size()) goto L31;
            UidStateProportionalEstimate uspe = uidStateEstimate.proportionalEstimates.get(i2);
            if (i2 == 0) goto L30;
            sb.append(", ");
        L30:
            sb.append(PowerStatsProcessor.m7865$$Nest$smconcatLabels(uidStateEstimate.states, uspe.stateValues));
            i2 = i2 + 1;
            goto L26
        L31:
            sb.append("\n");
            goto L23
        L33:
            return sb.toString();
        }

        public DeviceStateEstimation getDeviceStateEstimate(int[] stateValues) {
            String label = PowerStatsProcessor.m7865$$Nest$smconcatLabels(this.mConfig.getDeviceStateConfig(), stateValues);
            int i = 0;
        L4:
            if (i >= this.deviceStateEstimations.size()) goto L9;
            DeviceStateEstimation deviceStateEstimation = this.deviceStateEstimations.get(i);
            if (deviceStateEstimation.id.equals(label) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            return deviceStateEstimation;
        L9:
            return null;
        }

        public CombinedDeviceStateEstimate getCombinedDeviceStateEstimate(MultiStateStats.States[] deviceStates, int[] stateValues) {
            String label = PowerStatsProcessor.m7865$$Nest$smconcatLabels(deviceStates, stateValues);
            int i = 0;
        L4:
            if (i >= this.combinedDeviceStateEstimations.size()) goto L9;
            CombinedDeviceStateEstimate cdse = this.combinedDeviceStateEstimations.get(i);
            if (cdse.id.equals(label) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            return cdse;
        L9:
            return null;
        }

        public UidStateEstimate getUidStateEstimate(CombinedDeviceStateEstimate combined) {
            int i = 0;
        L4:
            if (i >= this.uidStateEstimates.size()) goto L9;
            UidStateEstimate uidStateEstimate = this.uidStateEstimates.get(i);
            if (uidStateEstimate.combinedDeviceStateEstimate == combined) goto L7;
            i = i + 1;
            goto L4
        L7:
            return uidStateEstimate;
        L9:
            return null;
        }

        public void resetIntermediates() {
            int i = this.deviceStateEstimations.size();
        L3:
            i = i - 1;
            if (i < 0) goto L6;
            this.deviceStateEstimations.get(i).intermediates = null;
            goto L3
        L6:
            int i2 = this.combinedDeviceStateEstimations.size() - 1;
        L7:
            if (i2 < 0) goto L9;
            this.combinedDeviceStateEstimations.get(i2).intermediates = null;
            i2 = i2 - 1;
            goto L7
        L9:
            int i3 = this.uidStateEstimates.size() - 1;
        L10:
            if (i3 < 0) goto L16;
            UidStateEstimate uidStateEstimate = this.uidStateEstimates.get(i3);
            List<UidStateProportionalEstimate> proportionalEstimates = uidStateEstimate.proportionalEstimates;
            int j = proportionalEstimates.size() - 1;
        L12:
            if (j < 0) goto L14;
            proportionalEstimates.get(j).intermediates = null;
            j = j - 1;
            goto L12
        L14:
            i3 = i3 - 1;
            goto L10
        }
    }

    protected static class UidStateEstimate {
        public CombinedDeviceStateEstimate combinedDeviceStateEstimate;
        public List<UidStateProportionalEstimate> proportionalEstimates;
        public final MultiStateStats.States[] states;

        public UidStateEstimate(CombinedDeviceStateEstimate combined, MultiStateStats.States[] states) {
            this.proportionalEstimates = new ArrayList();
            this.combinedDeviceStateEstimate = combined;
            this.states = states;
        }
    }

    protected static class UidStateProportionalEstimate {
        public Object intermediates;
        public final int[] stateValues;

        protected UidStateProportionalEstimate(int[] stateValues) {
            this.stateValues = stateValues;
        }
    }

    public static /* synthetic */ void $r8$lambda$i372F_C3eS3_IAG4Sadr6UR4rVY(List r0, int[] r1) {
        lambda$getAllTrackedStateCombinations$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smconcatLabels, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7865$$Nest$smconcatLabels(MultiStateStats.States[] r0, int[] r1) {
        return concatLabels(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetAllTrackedStateCombinations, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[][] m7866$$Nest$smgetAllTrackedStateCombinations(MultiStateStats.States[] r0) {
        return getAllTrackedStateCombinations(r0);
    }

    abstract void finish(PowerComponentAggregatedPowerStats r1, long r2);

    PowerStatsProcessor() {
    }

    void start(PowerComponentAggregatedPowerStats stats, long timestampMs) {
    }

    void noteStateChange(PowerComponentAggregatedPowerStats stats, BatteryStats.HistoryItem item) {
    }

    public void noteBatteryLevel(int batteryLevel, int batteryChargeUah, long timestampMs) {
    }

    public void setUidState(PowerComponentAggregatedPowerStats stats, int uid, int stateId, int state, long timestampMs) {
        stats.setProcessedUidState(uid, stateId, state, timestampMs);
    }

    void addPowerStats(PowerComponentAggregatedPowerStats stats, PowerStats powerStats, long timestampMs) {
        stats.addProcessedPowerStats(powerStats, timestampMs);
    }

    private static String concatLabels(MultiStateStats.States[] config, int[] stateValues) {
        List<String> labels = new ArrayList();
        int state = 0;
    L4:
        if (state >= config.length) goto L11;
        if (config[state] == null) goto L10;
        if (config[state].isTracked() == false) goto L10;
        labels.add(config[state].getName() + "=" + config[state].getLabels()[stateValues[state]]);
    L10:
        state = state + 1;
        goto L4
    L11:
        Collections.sort(labels);
        return labels.toString();
    }

    private static int[][] getAllTrackedStateCombinations(MultiStateStats.States[] states) {
        final List<int[]> combinations = new ArrayList();
        MultiStateStats.States.forEachTrackedStateCombination(states, new PowerStatsProcessor$$ExternalSyntheticLambda0(combinations));
        return (int[][]) combinations.toArray((int[][]) Array.newInstance(Integer.TYPE, new int[]{combinations.size(), 0}));
    }

    private static /* synthetic */ void lambda$getAllTrackedStateCombinations$0(List combinations, int[] stateValues) {
        combinations.add(Arrays.copyOf(stateValues, stateValues.length));
    }

    public static double uCtoMah(long chargeUC) {
        return chargeUC * MILLIAMPHOUR_PER_MICROCOULOMB;
    }
}
