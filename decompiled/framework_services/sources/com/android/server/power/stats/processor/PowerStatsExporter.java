package com.android.server.power.stats.processor;

import android.os.AggregateBatteryConsumer;
import android.os.BatteryConsumer;
import android.os.BatteryUsageStats;
import android.os.UidBatteryConsumer;
import android.util.IntArray;
import android.util.Slog;
import com.android.internal.os.BatteryStatsHistory;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.PowerStatsSpan;
import com.android.server.power.stats.PowerStatsStore;
import com.android.server.power.stats.format.BasePowerStatsLayout;
import com.android.server.power.stats.format.PowerStatsLayout;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
class PowerStatsExporter {
    private static final long BATTERY_SESSION_TIME_SPAN_SLACK_MILLIS = 0;
    private static final String TAG = "PowerStatsExporter";
    private static final BasePowerStatsLayout sBasePowerStatsLayout = null;
    private final long mBatterySessionTimeSpanSlackMillis;
    private final PowerStatsAggregator mPowerStatsAggregator;
    private final PowerStatsStore mPowerStatsStore;

    private static class BatteryLevelInfo {
        public long batteryDischargeDurationMs;
        public double batteryDischargeMah;
        public double batteryDischargePct;

        /* synthetic */ BatteryLevelInfo(PowerStatsExporterIA r1) {
            this();
        }

        private BatteryLevelInfo() {
        }
    }

    public static /* synthetic */ void $r8$lambda$iKXb3jwJEiQ4S6b3NKDtSadkbS0(PowerStatsExporter r0, BatteryUsageStats.Builder r1, AggregatedPowerStats r2) {
        r0.lambda$exportAggregatedPowerStats$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$pNT5uGKVgvyOpk7fJ8PTGvMFxnE(PowerStatsExporter r0, int r1, int r2, PowerComponentAggregatedPowerStats r3, long[] r4, double[] r5, PowerStatsLayout r6, long[] r7, boolean r8, BatteryLevelInfo r9, int[] r10) {
        r0.lambda$populateAggregatedBatteryConsumer$1(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void $r8$lambda$q_0fFBL0SpJgc9zuomLvKMCMfxk(int r0, int r1, PowerComponentAggregatedPowerStats r2, long[] r3, int r4, PowerStatsLayout r5, boolean r6, double[] r7, long[] r8, int[] r9) {
        lambda$populateUidBatteryConsumers$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    static {
        BATTERY_SESSION_TIME_SPAN_SLACK_MILLIS = TimeUnit.MINUTES.toMillis(2);
        sBasePowerStatsLayout = new BasePowerStatsLayout();
    }

    PowerStatsExporter(PowerStatsStore powerStatsStore, PowerStatsAggregator powerStatsAggregator) {
        this(powerStatsStore, powerStatsAggregator, BATTERY_SESSION_TIME_SPAN_SLACK_MILLIS);
    }

    PowerStatsExporter(PowerStatsStore powerStatsStore, PowerStatsAggregator powerStatsAggregator, long batterySessionTimeSpanSlackMillis) {
        this.mPowerStatsStore = powerStatsStore;
        this.mPowerStatsAggregator = powerStatsAggregator;
        this.mBatterySessionTimeSpanSlackMillis = batterySessionTimeSpanSlackMillis;
    }

    void exportAggregatedPowerStats(final BatteryUsageStats.Builder batteryUsageStatsBuilder, BatteryStatsHistory history, long monotonicStartTime, long monotonicEndTime) {
        PowerStatsAggregator r3 = this.mPowerStatsAggregator;
        monitor-enter(r3);
        List<PowerStatsSpan.Metadata> spans = this.mPowerStatsStore.getTableOfContents();     // Catch: Throwable -> L20
        int i = spans.size() - 1;     // Catch: Throwable -> L20
        long maxEndTime = monotonicStartTime;
        boolean hasStoredSpans = false;
    L6:
        if (i < 0) goto L54;
        PowerStatsSpan.Metadata metadata = spans.get(i);     // Catch: Throwable -> L20
        if (metadata.getSections().contains(AggregatedPowerStatsSection.TYPE) == true) goto L10;
        List<PowerStatsSpan.Metadata> spans2 = spans;
        int i2 = i;
    L52:
        i = i2 - 1;     // Catch: Throwable -> L20
        spans = spans2;
        goto L6
    L10:
        List<PowerStatsSpan.TimeFrame> timeFrames = metadata.getTimeFrames();     // Catch: Throwable -> L20
        long spanMinTime = Long.MAX_VALUE;
        long spanMaxTime = Long.MIN_VALUE;
        int j = 0;
    L12:
        if (j >= timeFrames.size()) goto L22;
        PowerStatsSpan.TimeFrame timeFrame = timeFrames.get(j);     // Catch: Throwable -> L20
        List<PowerStatsSpan.Metadata> spans3 = spans;
        int i3 = i;
        long startMonotonicTime = timeFrame.startMonotonicTime;     // Catch: Throwable -> L20
        long endMonotonicTime = startMonotonicTime + timeFrame.duration;     // Catch: Throwable -> L20
        if (startMonotonicTime >= spanMinTime) goto L17;
        spanMinTime = startMonotonicTime;
    L17:
        if (endMonotonicTime <= spanMaxTime) goto L19;
        spanMaxTime = endMonotonicTime;
    L19:
        j = j + 1;     // Catch: Throwable -> L20
        spans = spans3;
        i = i3;
        goto L12
    L22:
        spans2 = spans;
        i2 = i;
        if (spanMinTime < monotonicStartTime) goto L52;
        if (spanMaxTime >= monotonicEndTime) goto L52;
        if (spanMaxTime <= maxEndTime) goto L30;
        maxEndTime = spanMaxTime;
    L30:
        PowerStatsSpan span = this.mPowerStatsStore.loadPowerStatsSpan(metadata.getId(), new String[]{AggregatedPowerStatsSection.TYPE});     // Catch: Throwable -> L20
        if (span == null) goto L63;
        List<PowerStatsSpan.Section> sections = span.getSections();     // Catch: Throwable -> L37
        int k = 0;
    L41:
        if (k >= sections.size()) goto L35;
        hasStoredSpans = true;
        PowerStatsSpan.Section section = sections.get(k);     // Catch: Throwable -> L37
        List<PowerStatsSpan.Section> sections2 = sections;
        populateBatteryUsageStatsBuilder(batteryUsageStatsBuilder, ((AggregatedPowerStatsSection) section).getAggregatedPowerStats());     // Catch: Throwable -> L37
        k = k + 1;
        sections = sections2;
    L35:
        span.close();     // Catch: Throwable -> L20
        goto L52
    L63:
        Slog.e(TAG, "Could not read PowerStatsStore section " + metadata);     // Catch: Throwable -> L37
        if (span == null) goto L52;
    L37:
        th = move-exception;
        if (span == null) goto L78;
        span.close();     // Catch: Throwable -> L48
    L79:
        throw th;     // Catch: Throwable -> L20
    L48:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L78:
        throw th;     // Catch: Throwable -> L20
    L54:
        if (hasStoredSpans == true) goto L56;
    L57:
        this.mPowerStatsAggregator.aggregatePowerStats(history, maxEndTime, monotonicEndTime, new PowerStatsExporter$$ExternalSyntheticLambda0(this, batteryUsageStatsBuilder));     // Catch: Throwable -> L20
    L58:
        this.mPowerStatsAggregator.reset();     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        return;
    L56:
        if (maxEndTime >= (monotonicEndTime - this.mBatterySessionTimeSpanSlackMillis)) goto L58;
    L20:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$exportAggregatedPowerStats$0(BatteryUsageStats.Builder batteryUsageStatsBuilder, AggregatedPowerStats stats) {
        populateBatteryUsageStatsBuilder(batteryUsageStatsBuilder, stats);
    }

    void populateBatteryUsageStatsBuilder(BatteryUsageStats.Builder batteryUsageStatsBuilder, AggregatedPowerStats stats) {
        List<PowerComponentAggregatedPowerStats> powerComponentStats = stats.getPowerComponentStats();
        int i = powerComponentStats.size() - 1;
    L3:
        if (i < 0) goto L6;
        populateBatteryUsageStatsBuilder(batteryUsageStatsBuilder, powerComponentStats.get(i));
        i = i - 1;
        goto L3
    }

    private void populateBatteryUsageStatsBuilder(BatteryUsageStats.Builder batteryUsageStatsBuilder, PowerComponentAggregatedPowerStats powerComponentStats) {
        PowerStats.Descriptor descriptor = powerComponentStats.getPowerStatsDescriptor();
        if (descriptor != null) goto L6;
        return;
    L6:
        if (batteryUsageStatsBuilder.isSupportedPowerComponent(descriptor.powerComponentId) == true) goto L8;
        return;
    L8:
        PowerStatsLayout layout = new PowerStatsLayout(descriptor);
        long[] deviceStats = new long[descriptor.statsArrayLength];
        BatteryLevelInfo batteryLevelInfo = new BatteryLevelInfo(null);
        int screenState = 0;
    L10:
        if (screenState >= 3) goto L31;
        if (batteryUsageStatsBuilder.isScreenStateDataNeeded() == false) goto L15;
        if (screenState == 0) goto L30;
    L17:
        int powerState = 0;
    L18:
        if (powerState >= 3) goto L30;
        if (batteryUsageStatsBuilder.isPowerStateDataNeeded() == false) goto L24;
        if (powerState == 0) goto L23;
        BatteryUsageStats.Builder batteryUsageStatsBuilder2 = batteryUsageStatsBuilder;
        PowerComponentAggregatedPowerStats powerComponentStats2 = powerComponentStats;
        populateAggregatedBatteryConsumer(batteryUsageStatsBuilder2, powerComponentStats2, layout, deviceStats, batteryLevelInfo, screenState, powerState);
    L28:
        powerState = powerState + 1;
        batteryUsageStatsBuilder = batteryUsageStatsBuilder2;
        powerComponentStats = powerComponentStats2;
        goto L18
    L23:
        batteryUsageStatsBuilder2 = batteryUsageStatsBuilder;
        powerComponentStats2 = powerComponentStats;
        goto L28
    L24:
        batteryUsageStatsBuilder2 = batteryUsageStatsBuilder;
        powerComponentStats2 = powerComponentStats;
        if (powerState != 1) goto L28;
        populateAggregatedBatteryConsumer(batteryUsageStatsBuilder2, powerComponentStats2, layout, deviceStats, batteryLevelInfo, screenState, powerState);
    L30:
        screenState = screenState + 1;
        batteryUsageStatsBuilder = batteryUsageStatsBuilder;
        powerComponentStats = powerComponentStats;
        goto L10
    L15:
        if (screenState == 0) goto L17;
    L31:
        BatteryUsageStats.Builder batteryUsageStatsBuilder3 = batteryUsageStatsBuilder;
        PowerComponentAggregatedPowerStats powerComponentStats3 = powerComponentStats;
        if (layout.isUidPowerAttributionSupported() == false) goto L34;
        populateBatteryConsumers(batteryUsageStatsBuilder3, powerComponentStats3, layout);
    L34:
        populateBatteryLevelInfo(batteryUsageStatsBuilder3, batteryLevelInfo);
    }

    private void populateAggregatedBatteryConsumer(BatteryUsageStats.Builder batteryUsageStatsBuilder, final PowerComponentAggregatedPowerStats powerComponentStats, final PowerStatsLayout layout, final long[] deviceStats, final BatteryLevelInfo batteryLevelInfo, final int screenState, int powerState) {
        int powerComponentId = powerComponentStats.powerComponentId;
        if (powerComponentId != 18) goto L7;
        final int r3 = powerState;
        if (r3 != 1) goto L8;
        final boolean hasBatteryLevelProperties = true;
    L9:
        final double[] totalPower = new double[1];
        final long[] durationMs = new long[1];
        MultiStateStats.States.forEachTrackedStateCombination(powerComponentStats.getConfig().getDeviceStateConfig(), new PowerStatsExporter$$ExternalSyntheticLambda1(this, screenState, r3, powerComponentStats, deviceStats, totalPower, layout, durationMs, hasBatteryLevelProperties, batteryLevelInfo));
        AggregateBatteryConsumer.Builder deviceScope = batteryUsageStatsBuilder.getAggregateBatteryConsumerBuilder(0);
        BatteryConsumer.Key key = getKeyForPartialTotal(batteryUsageStatsBuilder, deviceScope, powerComponentId, screenState, powerState);
        if (key == null) goto L12;
        deviceScope.addConsumedPower(key, totalPower[0]);
        deviceScope.addUsageDurationMillis(key, durationMs[0]);
    L12:
        BatteryConsumer.Key key2 = deviceScope.getKey(powerComponentId, 0);
        if (key2 == null) goto L16;
        deviceScope.addConsumedPower(key2, totalPower[0]);
        deviceScope.addUsageDurationMillis(key2, durationMs[0]);
        return;
    L16:
        return;
    L8:
        hasBatteryLevelProperties = false;
        goto L9
    L7:
        r3 = powerState;
        goto L8
    }

    private /* synthetic */ void lambda$populateAggregatedBatteryConsumer$1(int screenState, int powerState, PowerComponentAggregatedPowerStats powerComponentStats, long[] deviceStats, double[] totalPower, PowerStatsLayout layout, long[] durationMs, boolean hasBatteryLevelProperties, BatteryLevelInfo batteryLevelInfo, int[] states) {
        if (areMatchingStates(states, screenState, powerState) == true) goto L6;
        return;
    L6:
        if (powerComponentStats.getDeviceStats(deviceStats, states) == true) goto L8;
        return;
    L8:
        totalPower[0] = totalPower[0] + layout.getDevicePowerEstimate(deviceStats);
        durationMs[0] = durationMs[0] + layout.getUsageDuration(deviceStats);
        if (hasBatteryLevelProperties == false) goto L12;
        gatherBatteryLevelInfo(batteryLevelInfo, deviceStats);
        return;
    }

    private void gatherBatteryLevelInfo(BatteryLevelInfo batteryLevelInfo, long[] deviceStats) {
        batteryLevelInfo.batteryDischargePct += sBasePowerStatsLayout.getBatteryDischargePercent(deviceStats);
        batteryLevelInfo.batteryDischargeMah += sBasePowerStatsLayout.getBatteryDischargeUah(deviceStats) / 1000.0d;
        batteryLevelInfo.batteryDischargeDurationMs += sBasePowerStatsLayout.getBatteryDischargeDuration(deviceStats);
    }

    private void populateBatteryLevelInfo(BatteryUsageStats.Builder builder, BatteryLevelInfo batteryLevelInfo) {
        builder.addDischargePercentage((int) Math.round(batteryLevelInfo.batteryDischargePct)).addDischargedPowerRange(batteryLevelInfo.batteryDischargeMah, batteryLevelInfo.batteryDischargeMah).addDischargeDurationMs(batteryLevelInfo.batteryDischargeDurationMs).getAggregateBatteryConsumerBuilder(0).addConsumedPower(batteryLevelInfo.batteryDischargeMah);
    }

    private void populateBatteryConsumers(BatteryUsageStats.Builder batteryUsageStatsBuilder, PowerComponentAggregatedPowerStats powerComponentStats, PowerStatsLayout layout) {
        IntArray uids = powerComponentStats.getUids();
        if (uids.size() != 0) goto L5;
        return;
    L5:
        AggregatedPowerStatsConfig.PowerComponent powerComponent = powerComponentStats.getConfig();
        PowerStats.Descriptor descriptor = powerComponentStats.getPowerStatsDescriptor();
        long[] uidStats = new long[descriptor.uidStatsArrayLength];
        if (powerComponent.getPowerComponentId() != 18) goto L8;
        boolean breakDownByProcState = true;
    L12:
        int screenState = 0;
    L14:
        if (screenState >= 3) goto L35;
        if (batteryUsageStatsBuilder.isScreenStateDataNeeded() == false) goto L19;
        if (screenState == 0) goto L33;
    L21:
        int powerState = 0;
    L22:
        if (powerState >= 3) goto L33;
        if (batteryUsageStatsBuilder.isPowerStateDataNeeded() == false) goto L28;
        if (powerState != 0) goto L30;
        BatteryUsageStats.Builder batteryUsageStatsBuilder2 = batteryUsageStatsBuilder;
        PowerComponentAggregatedPowerStats powerComponentStats2 = powerComponentStats;
        PowerStatsLayout layout2 = layout;
    L31:
        powerState = powerState + 1;
        batteryUsageStatsBuilder = batteryUsageStatsBuilder2;
        powerComponentStats = powerComponentStats2;
        layout = layout2;
    L30:
        batteryUsageStatsBuilder2 = batteryUsageStatsBuilder;
        powerComponentStats2 = powerComponentStats;
        layout2 = layout;
        populateUidBatteryConsumers(batteryUsageStatsBuilder2, powerComponentStats2, layout2, uids, powerComponent, uidStats, breakDownByProcState, screenState, powerState);
        goto L31
    L28:
        if (powerState == 1) goto L30;
        batteryUsageStatsBuilder2 = batteryUsageStatsBuilder;
        powerComponentStats2 = powerComponentStats;
        layout2 = layout;
    L33:
        screenState = screenState + 1;
        batteryUsageStatsBuilder = batteryUsageStatsBuilder;
        powerComponentStats = powerComponentStats;
        layout = layout;
        goto L14
    L19:
        if (screenState == 0) goto L21;
    L35:
        return;
    L8:
        boolean breakDownByProcState2 = batteryUsageStatsBuilder.isProcessStateDataNeeded();
        if (breakDownByProcState2 == false) goto L11;
        breakDownByProcState = powerComponent.getUidStateConfig()[2].isTracked();
        goto L12
    L11:
        breakDownByProcState = false;
        goto L12
    }

    private void populateUidBatteryConsumers(BatteryUsageStats.Builder batteryUsageStatsBuilder, PowerComponentAggregatedPowerStats powerComponentStats, final PowerStatsLayout layout, IntArray uids, AggregatedPowerStatsConfig.PowerComponent powerComponent, final long[] uidStats, final boolean breakDownByProcState, final int screenState, int powerState) {
        if (batteryUsageStatsBuilder.isPowerStateDataNeeded() == true) goto L7;
        final int r5 = powerState;
        if (r5 == 1) goto L8;
        return;
    L8:
        final PowerComponentAggregatedPowerStats r6 = powerComponentStats;
        int powerComponentId = r6.powerComponentId;
        int r3 = 5;
        if (breakDownByProcState == false) goto L11;
        int r4 = 5;
    L12:
        final double[] powerByProcState = new double[r4];
        if (breakDownByProcState == true) goto L16;
        r3 = 1;
    L16:
        final long[] durationByProcState = new long[r3];
        double powerAllApps = 0.0d;
        int i = uids.size() - 1;
    L17:
        if (i < 0) goto L47;
        final int uid = uids.get(i);
        UidBatteryConsumer.Builder builder = batteryUsageStatsBuilder.getOrCreateUidBatteryConsumerBuilder(uid);
        Arrays.fill(powerByProcState, 0.0d);
        Arrays.fill(durationByProcState, 0);
        int i2 = i;
        MultiStateStats.States.forEachTrackedStateCombination(powerComponent.getUidStateConfig(), new PowerStatsExporter$$ExternalSyntheticLambda2(screenState, r5, r6, uidStats, uid, layout, breakDownByProcState, powerByProcState, durationByProcState));
        if (batteryUsageStatsBuilder.isScreenStateDataNeeded() == false) goto L21;
        int resultScreenState = screenState;
    L23:
        if (batteryUsageStatsBuilder.isPowerStateDataNeeded() == false) goto L25;
        int resultPowerState = powerState;
    L26:
        int procState = 0;
    L28:
        if (procState >= powerByProcState.length) goto L39;
        double power = powerByProcState[procState];
        int procState2 = procState;
        long duration = durationByProcState[procState2];
        if (power == 0.0d) goto L32;
    L34:
        BatteryConsumer.Key key = builder.getKey(powerComponentId, procState2, resultScreenState, resultPowerState);
        if (key == null) goto L37;
        builder.addConsumedPower(key, power);
        builder.addUsageDurationMillis(key, duration);
    L37:
        procState = procState2 + 1;
        goto L28
    L32:
        if (duration != 0) goto L34;
    L39:
        if (resultScreenState != 0) goto L43;
        if (resultPowerState != 0) goto L43;
        char r7 = 0;
    L46:
        powerAllApps = powerAllApps + powerByProcState[r7];
        i = i2 - 1;
        r6 = powerComponentStats;
        r5 = powerState;
    L43:
        r7 = 0;
        BatteryConsumer.Key key2 = builder.getKey(powerComponentId, 0);
        if (key2 == null) goto L46;
        builder.addConsumedPower(key2, powerByProcState[0]);
        builder.addUsageDurationMillis(key2, durationByProcState[0]);
        goto L46
    L25:
        resultPowerState = 0;
        goto L26
    L21:
        resultScreenState = 0;
        goto L23
    L47:
        AggregateBatteryConsumer.Builder allAppsScope = batteryUsageStatsBuilder.getAggregateBatteryConsumerBuilder(1);
        BatteryConsumer.Key key3 = getKeyForPartialTotal(batteryUsageStatsBuilder, allAppsScope, powerComponentId, screenState, powerState);
        if (key3 == null) goto L50;
        allAppsScope.addConsumedPower(key3, powerAllApps);
    L50:
        allAppsScope.addConsumedPower(powerComponentId, powerAllApps);
        return;
    L11:
        r4 = 1;
        goto L12
    L7:
        r5 = powerState;
        goto L8
    }

    private static /* synthetic */ void lambda$populateUidBatteryConsumers$2(int screenState, int powerState, PowerComponentAggregatedPowerStats powerComponentStats, long[] uidStats, int uid, PowerStatsLayout layout, boolean breakDownByProcState, double[] powerByProcState, long[] durationByProcState, int[] states) {
        if (areMatchingStates(states, screenState, powerState) == true) goto L6;
        return;
    L6:
        if (powerComponentStats.getUidStats(uidStats, uid, states) == true) goto L8;
        return;
    L8:
        double power = layout.getUidPowerEstimate(uidStats);
        long duration = layout.getUidUsageDuration(uidStats);
        if (breakDownByProcState == false) goto L14;
        int procState = states[2];
        if (procState != 0) goto L13;
        procState = 2;
    L13:
        powerByProcState[procState] = powerByProcState[procState] + power;
        durationByProcState[procState] = durationByProcState[procState] + duration;
    L14:
        powerByProcState[0] = powerByProcState[0] + power;
        durationByProcState[0] = durationByProcState[0] + duration;
    }

    private BatteryConsumer.Key getKeyForPartialTotal(BatteryUsageStats.Builder batteryUsageStatsBuilder, AggregateBatteryConsumer.Builder builder, int powerComponentId, int screenState, int powerState) {
        if (batteryUsageStatsBuilder.isScreenStateDataNeeded() == true) goto L6;
        screenState = 0;
    L6:
        if (batteryUsageStatsBuilder.isPowerStateDataNeeded() == true) goto L8;
        powerState = 0;
    L8:
        if (screenState != 0) goto L13;
        if (powerState != 0) goto L13;
        return null;
    L13:
        return builder.getKey(powerComponentId, 0, screenState, powerState);
    }

    private static boolean areMatchingStates(int[] states, int screenState, int powerState) {
        switch(screenState) {
            case 1: goto L9;
            case 2: goto L6;
            default: goto L11;
        };
    L11:
        switch(powerState) {
            case 1: goto L17;
            case 2: goto L14;
            default: goto L19;
        };
    L19:
        return true;
    L14:
        if (states[0] == 1) goto L19;
        return false;
    L17:
        if (states[0] == 0) goto L19;
        return false;
    L6:
        if (states[1] == 1) goto L11;
        return false;
    L9:
        if (states[1] == 0) goto L11;
        return false;
    }

    public void setPowerComponentEnabled(int powerComponentId, boolean enabled) {
        this.mPowerStatsAggregator.setPowerComponentEnabled(powerComponentId, enabled);
    }
}
