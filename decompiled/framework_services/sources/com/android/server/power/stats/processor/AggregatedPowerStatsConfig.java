package com.android.server.power.stats.processor;

import android.os.BatteryConsumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class AggregatedPowerStatsConfig {
    private static final PowerStatsProcessor NO_OP_PROCESSOR = null;
    static final int POWER_STATE_BATTERY = 0;
    static final int POWER_STATE_OTHER = 1;
    static final int SCREEN_STATE_ON = 0;
    static final int SCREEN_STATE_OTHER = 1;
    static final String[] STATE_LABELS_POWER = null;
    static final String[] STATE_LABELS_PROCESS_STATE = null;
    static final String[] STATE_LABELS_SCREEN = null;
    static final String STATE_NAME_POWER = "pwr";
    static final String STATE_NAME_PROCESS_STATE = "ps";
    static final String STATE_NAME_SCREEN = "scr";
    public static final int STATE_POWER = 0;
    public static final int STATE_PROCESS_STATE = 2;
    public static final int STATE_SCREEN = 1;
    private PowerComponent mCustomPowerComponent;
    private Supplier<PowerStatsProcessor> mCustomPowerStatsProcessorFactory;
    private final List<PowerComponent> mPowerComponents;

    static class PowerComponent {
        private final int mPowerComponentId;
        private Supplier<PowerStatsProcessor> mProcessorSupplier;
        private int[] mTrackedDeviceStates;
        private int[] mTrackedUidStates;

        /* JADX INFO: renamed from: -$$Nest$fgetmTrackedDeviceStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ int[] m7853$$Nest$fgetmTrackedDeviceStates(PowerComponent r0) {
            return r0.mTrackedDeviceStates;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTrackedUidStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ int[] m7854$$Nest$fgetmTrackedUidStates(PowerComponent r0) {
            return r0.mTrackedUidStates;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmTrackedDeviceStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7855$$Nest$fputmTrackedDeviceStates(PowerComponent r0, int[] r1) {
            r0.mTrackedDeviceStates = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmTrackedUidStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7856$$Nest$fputmTrackedUidStates(PowerComponent r0, int[] r1) {
            r0.mTrackedUidStates = r1;
        }

        PowerComponent(int powerComponentId) {
            this.mPowerComponentId = powerComponentId;
        }

        public PowerComponent trackDeviceStates(int... states) {
            if (this.mTrackedDeviceStates != null) goto L7;
            this.mTrackedDeviceStates = states;
            return this;
        L7:
            throw new IllegalStateException("Component is already configured");
        }

        public PowerComponent trackUidStates(int... states) {
            if (this.mTrackedUidStates != null) goto L7;
            this.mTrackedUidStates = states;
            return this;
        L7:
            throw new IllegalStateException("Component is already configured");
        }

        public PowerComponent setProcessorSupplier(Supplier<PowerStatsProcessor> processorSupplier) {
            this.mProcessorSupplier = processorSupplier;
            return this;
        }

        public int getPowerComponentId() {
            return this.mPowerComponentId;
        }

        public MultiStateStats.States[] getDeviceStateConfig() {
            return new MultiStateStats.States[]{new MultiStateStats.States(AggregatedPowerStatsConfig.STATE_NAME_POWER, isTracked(this.mTrackedDeviceStates, 0), AggregatedPowerStatsConfig.STATE_LABELS_POWER), new MultiStateStats.States(AggregatedPowerStatsConfig.STATE_NAME_SCREEN, isTracked(this.mTrackedDeviceStates, 1), AggregatedPowerStatsConfig.STATE_LABELS_SCREEN)};
        }

        public MultiStateStats.States[] getUidStateConfig() {
            return new MultiStateStats.States[]{new MultiStateStats.States(AggregatedPowerStatsConfig.STATE_NAME_POWER, isTracked(this.mTrackedUidStates, 0), AggregatedPowerStatsConfig.STATE_LABELS_POWER), new MultiStateStats.States(AggregatedPowerStatsConfig.STATE_NAME_SCREEN, isTracked(this.mTrackedUidStates, 1), AggregatedPowerStatsConfig.STATE_LABELS_SCREEN), new MultiStateStats.States(AggregatedPowerStatsConfig.STATE_NAME_PROCESS_STATE, isTracked(this.mTrackedUidStates, 2), AggregatedPowerStatsConfig.STATE_LABELS_PROCESS_STATE)};
        }

        PowerStatsProcessor createProcessor() {
            if (this.mProcessorSupplier != null) goto L7;
            return AggregatedPowerStatsConfig.m7852$$Nest$sfgetNO_OP_PROCESSOR();
        L7:
            return this.mProcessorSupplier.get();
        }

        private boolean isTracked(int[] trackedStates, int state) {
            if (trackedStates != null) goto L5;
            return false;
        L5:
            int r1 = trackedStates.length;
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L12;
            int trackedState = trackedStates[r2];
            if (trackedState == state) goto L9;
            r2 = r2 + 1;
            goto L6
        L9:
            return true;
        L12:
            return false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TrackedState {
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetNO_OP_PROCESSOR, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerStatsProcessor m7852$$Nest$sfgetNO_OP_PROCESSOR() {
        return NO_OP_PROCESSOR;
    }

    AggregatedPowerStatsConfig() {
        this.mPowerComponents = new ArrayList();
    }

    static {
        STATE_LABELS_POWER = new String[]{"pwr-battery", "pwr-other"};
        STATE_LABELS_SCREEN = new String[]{"scr-on", "scr-other"};
        String[] procStateLabels = new String[5];
        int i = 0;
    L3:
        if (i >= 5) goto L5;
        procStateLabels[i] = BatteryConsumer.processStateToString(i);
        i = i + 1;
        goto L3
    L5:
        STATE_LABELS_PROCESS_STATE = procStateLabels;
        NO_OP_PROCESSOR = new AnonymousClass1();
    }

    PowerComponent trackPowerComponent(int powerComponentId) {
        PowerComponent builder = new PowerComponent(powerComponentId);
        this.mPowerComponents.add(builder);
        return builder;
    }

    PowerComponent trackPowerComponent(int powerComponentId, int dependsOnPowerComponentId) {
        PowerComponent dependsOnPowerComponent = null;
        int i = 0;
    L4:
        if (i >= this.mPowerComponents.size()) goto L9;
        PowerComponent powerComponent = this.mPowerComponents.get(i);
        if (powerComponent.getPowerComponentId() == dependsOnPowerComponentId) goto L7;
        i = i + 1;
        goto L4
    L7:
        dependsOnPowerComponent = powerComponent;
    L9:
        if (dependsOnPowerComponent == null) goto L13;
        PowerComponent powerComponent2 = trackPowerComponent(powerComponentId);
        PowerComponent.m7855$$Nest$fputmTrackedDeviceStates(powerComponent2, PowerComponent.m7853$$Nest$fgetmTrackedDeviceStates(dependsOnPowerComponent));
        PowerComponent.m7856$$Nest$fputmTrackedUidStates(powerComponent2, PowerComponent.m7854$$Nest$fgetmTrackedUidStates(dependsOnPowerComponent));
        return powerComponent2;
    L13:
        throw new IllegalArgumentException("Required component " + dependsOnPowerComponentId + " is not configured");
    }

    PowerComponent trackCustomPowerComponents(Supplier<PowerStatsProcessor> processorFactory) {
        this.mCustomPowerStatsProcessorFactory = processorFactory;
        this.mCustomPowerComponent = new PowerComponent(-1);
        return this.mCustomPowerComponent;
    }

    List<PowerComponent> getPowerComponentsAggregatedStatsConfigs() {
        return this.mPowerComponents;
    }

    PowerComponent createPowerComponent(int powerComponentId) {
        if (this.mCustomPowerComponent != null) goto L6;
        return null;
    L6:
        PowerComponent powerComponent = new PowerComponent(powerComponentId);
        powerComponent.trackDeviceStates(PowerComponent.m7853$$Nest$fgetmTrackedDeviceStates(this.mCustomPowerComponent));
        powerComponent.trackUidStates(PowerComponent.m7854$$Nest$fgetmTrackedUidStates(this.mCustomPowerComponent));
        if (this.mCustomPowerStatsProcessorFactory == null) goto L9;
        powerComponent.setProcessorSupplier(this.mCustomPowerStatsProcessorFactory);
    L9:
        return powerComponent;
    }
}
