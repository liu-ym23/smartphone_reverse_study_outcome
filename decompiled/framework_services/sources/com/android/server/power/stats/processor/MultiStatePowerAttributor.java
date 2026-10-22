package com.android.server.power.stats.processor;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.BatteryUsageStats;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.os.BatteryStatsHistory;
import com.android.internal.os.CpuScalingPolicies;
import com.android.internal.os.PowerProfile;
import com.android.server.power.stats.PowerAttributor;
import com.android.server.power.stats.PowerStatsSpan;
import com.android.server.power.stats.PowerStatsStore;
import java.util.Iterator;
import java.util.List;
import java.util.function.DoubleSupplier;

/* JADX INFO: loaded from: classes3.dex */
public class MultiStatePowerAttributor implements PowerAttributor {
    private static final String TAG = "MultiStatePowerAttributor";
    private final PowerStatsAggregator mPowerStatsAggregator;
    private final PowerStatsExporter mPowerStatsExporter;
    private final SparseBooleanArray mPowerStatsExporterEnabled;
    private final PowerStatsStore mPowerStatsStore;

    public static /* synthetic */ void $r8$lambda$1PNKYkCVv8W0KQfNrVHkcLFwoQo(IndentingPrintWriter r0, AggregatedPowerStats r1) {
        lambda$dumpEstimatedPowerConsumption$14(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$2lUOUDlJTWlJOEtxYVOy_maL-mc, reason: not valid java name */
    public static /* synthetic */ PowerStatsProcessor m7858$r8$lambda$2lUOUDlJTWlJOEtxYVOy_maLmc(Context r0) {
        return lambda$createAggregatedPowerStatsConfig$13(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$5-NDaBkXDxtfmlcXO5Mi6TAiDeM, reason: not valid java name */
    public static /* synthetic */ PowerStatsProcessor m7859$r8$lambda$5NDaBkXDxtfmlcXO5Mi6TAiDeM(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$11(r0);
    }

    public static /* synthetic */ PowerStatsProcessor $r8$lambda$55t4Zzm05ncx0W1YgnaCUrFLzJY(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$8(r0);
    }

    public static /* synthetic */ void $r8$lambda$70DTmGBx9LG3owXrv6hrK5RNa54(MultiStatePowerAttributor r0, long[] r1, AggregatedPowerStats r2) {
        r0.lambda$storeEstimatedPowerConsumption$15(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$C67sk-eRLG4_SDkOzr97hAq8FAU, reason: not valid java name */
    public static /* synthetic */ PowerStatsProcessor m7860$r8$lambda$C67skeRLG4_SDkOzr97hAq8FAU(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$1(r0);
    }

    public static /* synthetic */ PowerStatsProcessor $r8$lambda$D1N6x10mQCnihZ1AFl0lEN6faPM(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Gabh_wS9BwnY1CxJQlA-pVuOeYw, reason: not valid java name */
    public static /* synthetic */ PowerStatsProcessor m7861$r8$lambda$Gabh_wS9BwnY1CxJQlApVuOeYw(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$6(r0);
    }

    public static /* synthetic */ PowerStatsProcessor $r8$lambda$HupV73DXNt1muGGqeEn16l97Wsk(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$7(r0);
    }

    public static /* synthetic */ PowerStatsProcessor $r8$lambda$PUPeEfqqpmkpWSL858pKG_sXHrI(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$5(r0);
    }

    public static /* synthetic */ PowerStatsProcessor $r8$lambda$TT4c4y9zWE9QBwROEGZdDrozxb0(DoubleSupplier r0) {
        return lambda$createAggregatedPowerStatsConfig$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$WuvQKBwRfUJl4E-Jzwyx0kVNf9s, reason: not valid java name */
    public static /* synthetic */ PowerStatsProcessor m7862$r8$lambda$WuvQKBwRfUJl4EJzwyx0kVNf9s(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$4(r0);
    }

    public static /* synthetic */ PowerStatsProcessor $r8$lambda$dv30Q_VR9NUIlNenm3lSon2QyqQ(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$9(r0);
    }

    public static /* synthetic */ PowerStatsProcessor $r8$lambda$kZpVspbFxjUHJVpatfPqZwCtuTw(PowerProfile r0, CpuScalingPolicies r1) {
        return lambda$createAggregatedPowerStatsConfig$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$mQgGilTiebtIN-66-Js1k3uiw8c, reason: not valid java name */
    public static /* synthetic */ SensorManager m7863$r8$lambda$mQgGilTiebtIN66Js1k3uiw8c(Context r0) {
        return lambda$createAggregatedPowerStatsConfig$12(r0);
    }

    public static /* synthetic */ PowerStatsProcessor $r8$lambda$w6EL18IggZuZAG7I0JGpTKsf49I(PowerProfile r0) {
        return lambda$createAggregatedPowerStatsConfig$10(r0);
    }

    public MultiStatePowerAttributor(Context context, PowerStatsStore powerStatsStore, PowerProfile powerProfile, CpuScalingPolicies cpuScalingPolicies, DoubleSupplier batteryCapacitySupplier) {
        this(powerStatsStore, new PowerStatsAggregator(createAggregatedPowerStatsConfig(context, powerProfile, cpuScalingPolicies, batteryCapacitySupplier)));
    }

    MultiStatePowerAttributor(PowerStatsStore powerStatsStore, PowerStatsAggregator powerStatsAggregator) {
        this.mPowerStatsExporterEnabled = new SparseBooleanArray();
        this.mPowerStatsStore = powerStatsStore;
        this.mPowerStatsAggregator = powerStatsAggregator;
        this.mPowerStatsStore.addSectionReader(new AggregatedPowerStatsSection.Reader(this.mPowerStatsAggregator.getConfig()));
        this.mPowerStatsExporter = new PowerStatsExporter(this.mPowerStatsStore, this.mPowerStatsAggregator);
        setPowerComponentSupported(18, true);
    }

    private static AggregatedPowerStatsConfig createAggregatedPowerStatsConfig(final Context context, final PowerProfile powerProfile, final CpuScalingPolicies cpuScalingPolicies, final DoubleSupplier batteryCapacitySupplier) {
        AggregatedPowerStatsConfig config = new AggregatedPowerStatsConfig();
        config.trackPowerComponent(18).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda0(batteryCapacitySupplier));
        config.trackPowerComponent(12).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda7(powerProfile));
        config.trackPowerComponent(1, 12).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda8(powerProfile, cpuScalingPolicies));
        config.trackPowerComponent(0).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda9(powerProfile));
        config.trackPowerComponent(15, 0).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda10());
        config.trackPowerComponent(8).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda11(powerProfile));
        config.trackPowerComponent(14, 8).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda12());
        config.trackPowerComponent(11).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda13(powerProfile));
        config.trackPowerComponent(2).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda14(powerProfile));
        config.trackPowerComponent(4).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda15(powerProfile));
        config.trackPowerComponent(5).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda1(powerProfile));
        config.trackPowerComponent(6).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda2(powerProfile));
        config.trackPowerComponent(3).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda3(powerProfile));
        config.trackPowerComponent(10).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda4(powerProfile));
        config.trackPowerComponent(9).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2}).setProcessorSupplier(new MultiStatePowerAttributor$$ExternalSyntheticLambda5(context));
        config.trackCustomPowerComponents(new MultiStatePowerAttributor$$ExternalSyntheticLambda6()).trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2});
        return config;
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$0(DoubleSupplier batteryCapacitySupplier) {
        return new BasePowerStatsProcessor(batteryCapacitySupplier);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$1(PowerProfile powerProfile) {
        return new WakelockPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$2(PowerProfile powerProfile, CpuScalingPolicies cpuScalingPolicies) {
        return new CpuPowerStatsProcessor(powerProfile, cpuScalingPolicies);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$3(PowerProfile powerProfile) {
        return new ScreenPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$4(PowerProfile powerProfile) {
        return new MobileRadioPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$5(PowerProfile powerProfile) {
        return new WifiPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$6(PowerProfile powerProfile) {
        return new BluetoothPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$7(PowerProfile powerProfile) {
        return new AudioPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$8(PowerProfile powerProfile) {
        return new VideoPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$9(PowerProfile powerProfile) {
        return new FlashlightPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$10(PowerProfile powerProfile) {
        return new CameraPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$11(PowerProfile powerProfile) {
        return new GnssPowerStatsProcessor(powerProfile);
    }

    private static /* synthetic */ PowerStatsProcessor lambda$createAggregatedPowerStatsConfig$13(final Context context) {
        return new SensorPowerStatsProcessor(new MultiStatePowerAttributor$$ExternalSyntheticLambda18(context));
    }

    private static /* synthetic */ SensorManager lambda$createAggregatedPowerStatsConfig$12(Context context) {
        return (SensorManager) context.getSystemService(SensorManager.class);
    }

    public void setPowerComponentSupported(int powerComponentId, boolean enabled) {
        this.mPowerStatsExporterEnabled.put(powerComponentId, enabled);
        this.mPowerStatsExporter.setPowerComponentEnabled(powerComponentId, enabled);
    }

    @Override // com.android.server.power.stats.PowerAttributor
    public boolean isPowerComponentSupported(int powerComponentId) {
        return this.mPowerStatsExporterEnabled.get(powerComponentId);
    }

    @Override // com.android.server.power.stats.PowerAttributor
    public void estimatePowerConsumption(BatteryUsageStats.Builder batteryUsageStatsBuilder, BatteryStatsHistory batteryHistory, long monotonicStartTime, long monotonicEndTime) {
        this.mPowerStatsExporter.exportAggregatedPowerStats(batteryUsageStatsBuilder, batteryHistory, monotonicStartTime, monotonicEndTime);
    }

    @Override // com.android.server.power.stats.PowerAttributor
    public void dumpEstimatedPowerConsumption(final IndentingPrintWriter ipw, BatteryStatsHistory batteryStatsHistory, long startTime, long endTime) {
        this.mPowerStatsAggregator.aggregatePowerStats(batteryStatsHistory, startTime, endTime, new MultiStatePowerAttributor$$ExternalSyntheticLambda17(ipw));
    }

    private static /* synthetic */ void lambda$dumpEstimatedPowerConsumption$14(IndentingPrintWriter ipw, AggregatedPowerStats stats) {
        PowerStatsSpan span = createPowerStatsSpan(stats);
        if (span == null) goto L6;
        span.dump(ipw);
        return;
    }

    @Override // com.android.server.power.stats.PowerAttributor
    public long storeEstimatedPowerConsumption(BatteryStatsHistory batteryStatsHistory, long startTime, long endTimeMs) {
        final long[] lastSavedMonotonicTime = new long[1];
        this.mPowerStatsAggregator.aggregatePowerStats(batteryStatsHistory, startTime, endTimeMs, new MultiStatePowerAttributor$$ExternalSyntheticLambda16(this, lastSavedMonotonicTime));
        return lastSavedMonotonicTime[0];
    }

    private /* synthetic */ void lambda$storeEstimatedPowerConsumption$15(long[] lastSavedMonotonicTime, AggregatedPowerStats stats) {
        storeAggregatedPowerStats(stats);
        lastSavedMonotonicTime[0] = stats.getStartTime() + stats.getDuration();
    }

    void storeAggregatedPowerStats(AggregatedPowerStats stats) {
        PowerStatsSpan span = createPowerStatsSpan(stats);
        if (span != null) goto L5;
        return;
    L5:
        this.mPowerStatsStore.storePowerStatsSpan(span);
    }

    private static PowerStatsSpan createPowerStatsSpan(AggregatedPowerStats stats) {
        List<AggregatedPowerStats.ClockUpdate> clockUpdates = stats.getClockUpdates();
        if (clockUpdates.isEmpty() == false) goto L6;
        Slog.w(TAG, "No clock updates in aggregated power stats " + stats);
        return null;
    L6:
        long monotonicTime = clockUpdates.get(0).monotonicTime;
        long durationSum = 0;
        PowerStatsSpan span = new PowerStatsSpan(monotonicTime);
        int i = 0;
    L8:
        if (i >= clockUpdates.size()) goto L14;
        AggregatedPowerStats.ClockUpdate clockUpdate = clockUpdates.get(i);
        if (i != (clockUpdates.size() - 1)) goto L12;
        long r7 = stats.getDuration() - durationSum;
    L13:
        long duration = r7;
        span.addTimeFrame(clockUpdate.monotonicTime, clockUpdate.currentTime, duration);
        monotonicTime = clockUpdate.monotonicTime;
        durationSum = durationSum + duration;
        i = i + 1;
        goto L8
    L12:
        r7 = clockUpdate.monotonicTime - monotonicTime;
        goto L13
    L14:
        span.addSection(new AggregatedPowerStatsSection(stats));
        return span;
    }

    @Override // com.android.server.power.stats.PowerAttributor
    public long getLastSavedEstimatesPowerConsumptionTimestamp() {
        long timestamp = -1;
        Iterator<PowerStatsSpan.Metadata> r2 = this.mPowerStatsStore.getTableOfContents().iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        PowerStatsSpan.Metadata metadata = r2.next();
        if (metadata.getSections().contains(AggregatedPowerStatsSection.TYPE) == false) goto L4;
        Iterator<PowerStatsSpan.TimeFrame> r4 = metadata.getTimeFrames().iterator();
    L9:
        if (r4.hasNext() == false) goto L4;
        PowerStatsSpan.TimeFrame timeFrame = r4.next();
        long endMonotonicTime = timeFrame.startMonotonicTime + timeFrame.duration;
        if (endMonotonicTime <= timestamp) goto L9;
        timestamp = endMonotonicTime;
        goto L9
    L15:
        return timestamp;
    }
}
