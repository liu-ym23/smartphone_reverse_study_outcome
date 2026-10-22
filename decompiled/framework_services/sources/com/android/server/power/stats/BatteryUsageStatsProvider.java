package com.android.server.power.stats;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.BatteryStats;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.Handler;
import android.os.UidBatteryConsumer;
import android.os.UserHandle;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.Clock;
import com.android.internal.os.CpuScalingPolicies;
import com.android.internal.os.MonotonicClock;
import com.android.internal.os.PowerProfile;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryUsageStatsProvider {
    private static final boolean DEBUG = false;
    private static final String TAG = "BatteryUsageStatsProv";
    private final int mAccumulatedBatteryUsageStatsSpanSize;
    private final Clock mClock;
    private final Context mContext;
    private final CpuScalingPolicies mCpuScalingPolicies;
    private long mLastAccumulationMonotonicHistorySize;
    private final Object mLock;
    private final MonotonicClock mMonotonicClock;
    private final PowerAttributor mPowerAttributor;
    private List<PowerCalculator> mPowerCalculators;
    private final PowerProfile mPowerProfile;
    private final PowerStatsStore mPowerStatsStore;

    private static class AccumulatedBatteryUsageStats {
        public BatteryUsageStats.Builder builder;
        public long endMonotonicTime;
        public long startMonotonicTime;
        public long startWallClockTime;

        /* synthetic */ AccumulatedBatteryUsageStats(BatteryUsageStatsProviderIA r1) {
            this();
        }

        private AccumulatedBatteryUsageStats() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$rlWqUVwnllBfJlxnTRJ-GZmZAb0, reason: not valid java name */
    public static /* synthetic */ void m7838$r8$lambda$rlWqUVwnllBfJlxnTRJGZmZAb0(BatteryUsageStatsProvider r0, BatteryStatsImpl.BatteryStatsSession r1, Handler r2) {
        r0.lambda$accumulateBatteryUsageStatsAsync$0(r1, r2);
    }

    public BatteryUsageStatsProvider(Context context, PowerAttributor powerAttributor, PowerProfile powerProfile, CpuScalingPolicies cpuScalingPolicies, PowerStatsStore powerStatsStore, int accumulatedBatteryUsageStatsSpanSize, Clock clock, MonotonicClock monotonicClock) {
        this.mLock = new Object();
        this.mContext = context;
        this.mPowerAttributor = powerAttributor;
        this.mPowerStatsStore = powerStatsStore;
        this.mPowerProfile = powerProfile;
        this.mCpuScalingPolicies = cpuScalingPolicies;
        this.mAccumulatedBatteryUsageStatsSpanSize = accumulatedBatteryUsageStatsSpanSize;
        this.mClock = clock;
        this.mMonotonicClock = monotonicClock;
        this.mPowerStatsStore.addSectionReader(new BatteryUsageStatsSection.Reader());
        this.mPowerStatsStore.addSectionReader(new AccumulatedBatteryUsageStatsSection.Reader());
    }

    private List<PowerCalculator> getPowerCalculators() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPowerCalculators != null) goto L65;
        this.mPowerCalculators = new ArrayList();     // Catch: Throwable -> L9
        if (this.mPowerAttributor.isPowerComponentSupported(18) == true) goto L12;
        this.mPowerCalculators.add(new BatteryChargeCalculator());     // Catch: Throwable -> L9
    L12:
        if (this.mPowerAttributor.isPowerComponentSupported(1) == true) goto L15;
        this.mPowerCalculators.add(new CpuPowerCalculator(this.mCpuScalingPolicies, this.mPowerProfile));     // Catch: Throwable -> L9
    L15:
        if (this.mPowerAttributor.isPowerComponentSupported(13) == true) goto L18;
        this.mPowerCalculators.add(new MemoryPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L18:
        if (this.mPowerAttributor.isPowerComponentSupported(12) == true) goto L21;
        this.mPowerCalculators.add(new WakelockPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L21:
        if (BatteryStats.checkWifiOnly(this.mContext) == true) goto L29;
        if (this.mPowerAttributor.isPowerComponentSupported(8) == true) goto L26;
        this.mPowerCalculators.add(new MobileRadioPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L26:
        if (this.mPowerAttributor.isPowerComponentSupported(14) == true) goto L29;
        this.mPowerCalculators.add(new PhonePowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L29:
        if (this.mPowerAttributor.isPowerComponentSupported(11) == true) goto L32;
        this.mPowerCalculators.add(new WifiPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L32:
        if (this.mPowerAttributor.isPowerComponentSupported(2) == true) goto L35;
        this.mPowerCalculators.add(new BluetoothPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L35:
        if (this.mPowerAttributor.isPowerComponentSupported(9) == true) goto L38;
        this.mPowerCalculators.add(new SensorPowerCalculator((SensorManager) this.mContext.getSystemService(SensorManager.class)));     // Catch: Throwable -> L9
    L38:
        if (this.mPowerAttributor.isPowerComponentSupported(10) == true) goto L41;
        this.mPowerCalculators.add(new GnssPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L41:
        if (this.mPowerAttributor.isPowerComponentSupported(3) == true) goto L44;
        this.mPowerCalculators.add(new CameraPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L44:
        if (this.mPowerAttributor.isPowerComponentSupported(6) == true) goto L47;
        this.mPowerCalculators.add(new FlashlightPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L47:
        if (this.mPowerAttributor.isPowerComponentSupported(4) == true) goto L50;
        this.mPowerCalculators.add(new AudioPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L50:
        if (this.mPowerAttributor.isPowerComponentSupported(5) == true) goto L53;
        this.mPowerCalculators.add(new VideoPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L53:
        if (this.mPowerAttributor.isPowerComponentSupported(0) == true) goto L56;
        this.mPowerCalculators.add(new ScreenPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L56:
        if (this.mPowerAttributor.isPowerComponentSupported(15) == true) goto L59;
        this.mPowerCalculators.add(new AmbientDisplayPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L59:
        if (this.mPowerAttributor.isPowerComponentSupported(12) == true) goto L62;
        this.mPowerCalculators.add(new IdlePowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L62:
        if (this.mPowerAttributor.isPowerComponentSupported(-1) == true) goto L65;
        this.mPowerCalculators.add(new CustomEnergyConsumerPowerCalculator(this.mPowerProfile));     // Catch: Throwable -> L9
    L65:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return this.mPowerCalculators;
    }

    public void accumulateBatteryUsageStatsAsync(BatteryStatsImpl stats, final Handler handler) {
        monitor-enter(this);
        long historySize = stats.getHistory().getMonotonicHistorySize();     // Catch: Throwable -> L7
        if ((historySize - this.mLastAccumulationMonotonicHistorySize) >= this.mAccumulatedBatteryUsageStatsSpanSize) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mLastAccumulationMonotonicHistorySize = historySize;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        final BatteryStatsImpl.BatteryStatsSession session = stats.getBatteryStatsSession();
        handler.post(new BatteryUsageStatsProvider$$ExternalSyntheticLambda0(this, session, handler));
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$accumulateBatteryUsageStatsAsync$0(BatteryStatsImpl.BatteryStatsSession session, Handler handler) {
        accumulateBatteryUsageStats(session, handler);
    }

    public void accumulateBatteryUsageStats(BatteryStatsImpl.BatteryStatsSession session, Handler handler) {
        AccumulatedBatteryUsageStats accumulatedStats = loadAccumulatedBatteryUsageStats();
        updateAccumulatedBatteryUsageStats(accumulatedStats, session);
        PowerStatsSpan powerStatsSpan = new PowerStatsSpan(Long.MAX_VALUE);
        powerStatsSpan.addSection(new AccumulatedBatteryUsageStatsSection(accumulatedStats.builder));
        powerStatsSpan.addTimeFrame(accumulatedStats.startMonotonicTime, accumulatedStats.startWallClockTime, accumulatedStats.endMonotonicTime - accumulatedStats.startMonotonicTime);
        this.mMonotonicClock.write();
        if (handler.getLooper().isCurrentThread() == false) goto L5;
        this.mPowerStatsStore.storePowerStatsSpan(powerStatsSpan);
        accumulatedStats.builder.discard();
        return;
    L5:
        PowerStatsStore r1 = this.mPowerStatsStore;
        final BatteryUsageStats.Builder r2 = accumulatedStats.builder;
        r2.getClass();
        r1.storePowerStatsSpanAsync(powerStatsSpan, new BatteryUsageStatsProvider$$ExternalSyntheticLambda1(r2));
    }

    public static boolean shouldUpdateStats(List<BatteryUsageStatsQuery> queries, long elapsedRealtime, long lastUpdateTimeStampMs) {
        long allowableStatsAge = Long.MAX_VALUE;
        int i = queries.size() - 1;
    L3:
        if (i < 0) goto L6;
        BatteryUsageStatsQuery query = queries.get(i);
        allowableStatsAge = Math.min(allowableStatsAge, query.getMaxStatsAge());
        i = i - 1;
        goto L3
    L6:
        if ((elapsedRealtime - lastUpdateTimeStampMs) > allowableStatsAge) goto L11;
        return false;
    L11:
        return true;
    }

    public List<BatteryUsageStats> getBatteryUsageStats(BatteryStatsImpl stats, List<BatteryUsageStatsQuery> queries) {
        ArrayList<BatteryUsageStats> results = new ArrayList(queries.size());
        monitor-enter(stats);
        stats.prepareForDumpLocked();     // Catch: Throwable -> L12
        monitor-exit(stats);     // Catch: Throwable -> L12
        BatteryStatsImpl.BatteryStatsSession session = stats.getBatteryStatsSession();
        long currentTimeMillis = this.mClock.currentTimeMillis();
        int i = 0;
    L8:
        if (i >= queries.size()) goto L11;
        results.add(getBatteryUsageStats(session, queries.get(i), currentTimeMillis));
        i = i + 1;
        goto L8
    L11:
        return results;
    L12:
        th = move-exception;
        throw th;
    }

    public BatteryUsageStats getBatteryUsageStats(BatteryStatsImpl stats, BatteryUsageStatsQuery query) {
        return getBatteryUsageStats(stats.getBatteryStatsSession(), query, this.mClock.currentTimeMillis());
    }

    private BatteryUsageStats getBatteryUsageStats(BatteryStatsImpl.BatteryStatsSession session, BatteryUsageStatsQuery query, long currentTimeMs) {
        if ((query.getFlags() & 128) == 0) goto L6;
        BatteryUsageStats batteryUsageStats = getAccumulatedBatteryUsageStats(session, query);
        return batteryUsageStats;
    L6:
        if (query.getAggregatedToTimestamp() != 0) goto L8;
        BatteryUsageStats.Builder builder = computeBatteryUsageStats(session, query, query.getMonotonicStartTime(), query.getMonotonicEndTime(), currentTimeMs);
        BatteryUsageStats batteryUsageStats2 = builder.build();
        return batteryUsageStats2;
    L8:
        BatteryUsageStats batteryUsageStats3 = getAggregatedBatteryUsageStats(session, query);
        return batteryUsageStats3;
    }

    private BatteryUsageStats getAccumulatedBatteryUsageStats(BatteryStatsImpl.BatteryStatsSession session, BatteryUsageStatsQuery query) {
        AccumulatedBatteryUsageStats accumulatedStats = loadAccumulatedBatteryUsageStats();
        if (accumulatedStats.endMonotonicTime != (-1)) goto L5;
    L6:
        updateAccumulatedBatteryUsageStats(accumulatedStats, session);
    L8:
        return accumulatedStats.builder.build();
    L5:
        if ((this.mMonotonicClock.monotonicTime() - accumulatedStats.endMonotonicTime) <= query.getMaxStatsAge()) goto L8;
        goto L6
    }

    private AccumulatedBatteryUsageStats loadAccumulatedBatteryUsageStats() {
        AccumulatedBatteryUsageStats stats = new AccumulatedBatteryUsageStats(null);
        stats.startWallClockTime = 0;
        stats.startMonotonicTime = -1;
        stats.endMonotonicTime = -1;
        PowerStatsSpan powerStatsSpan = this.mPowerStatsStore.loadPowerStatsSpan(Long.MAX_VALUE, new String[]{AccumulatedBatteryUsageStatsSection.TYPE});
        if (powerStatsSpan == null) goto L10;
        List<PowerStatsSpan.Section> sections = powerStatsSpan.getSections();
        int i = sections.size() - 1;
    L5:
        if (i < 0) goto L10;
        PowerStatsSpan.Section section = sections.get(i);
        if (AccumulatedBatteryUsageStatsSection.TYPE.equals(section.getType()) == true) goto L8;
        i = i - 1;
        goto L5
    L8:
        stats.builder = ((AccumulatedBatteryUsageStatsSection) section).getBatteryUsageStatsBuilder();
        stats.startWallClockTime = powerStatsSpan.getMetadata().getStartTime();
        stats.startMonotonicTime = powerStatsSpan.getMetadata().getStartMonotonicTime();
        stats.endMonotonicTime = powerStatsSpan.getMetadata().getEndMonotonicTime();
    L10:
        return stats;
    }

    private void updateAccumulatedBatteryUsageStats(AccumulatedBatteryUsageStats accumulatedStats, BatteryStatsImpl.BatteryStatsSession session) {
        long startMonotonicTime = accumulatedStats.endMonotonicTime;
        if (startMonotonicTime != (-1)) goto L5;
        long startMonotonicTime2 = session.getMonotonicStartTime();
    L6:
        long endWallClockTime = this.mClock.currentTimeMillis();
        long endMonotonicTime = this.mMonotonicClock.monotonicTime();
        if (accumulatedStats.builder != null) goto L9;
        accumulatedStats.builder = new BatteryUsageStats.Builder(session.getCustomEnergyConsumerNames(), true, true, true, 0.0d);
        accumulatedStats.startWallClockTime = session.getStartClockTime();
        accumulatedStats.startMonotonicTime = session.getMonotonicStartTime();
        accumulatedStats.builder.setStatsStartTimestamp(accumulatedStats.startWallClockTime);
    L9:
        accumulatedStats.endMonotonicTime = endMonotonicTime;
        accumulatedStats.builder.setStatsEndTimestamp(endWallClockTime);
        accumulatedStats.builder.setStatsDuration(endMonotonicTime - startMonotonicTime2);
        this.mPowerAttributor.estimatePowerConsumption(accumulatedStats.builder, session.getHistory(), startMonotonicTime2, endMonotonicTime);
        populateBatterySessionInfo(accumulatedStats.builder, session);
        return;
    L5:
        startMonotonicTime2 = startMonotonicTime;
        goto L6
    }

    private BatteryUsageStats.Builder computeBatteryUsageStats(BatteryStatsImpl.BatteryStatsSession session, BatteryUsageStatsQuery query, long monotonicStartTime, long monotonicEndTime, long currentTimeMs) {
        boolean usePowerCalculators = false;
        if ((query.getFlags() & 8) == 0) goto L5;
        boolean r1 = true;
    L6:
        boolean includeProcessStateData = r1;
        if ((query.getFlags() & 16) == 0) goto L9;
        boolean includeVirtualUids = true;
    L10:
        double minConsumedPowerThreshold = query.getMinConsumedPowerThreshold();
        String[] customEnergyConsumerNames = session.getCustomEnergyConsumerNames();
        BatteryUsageStats.Builder batteryUsageStatsBuilder = new BatteryUsageStats.Builder(customEnergyConsumerNames, includeProcessStateData, query.isScreenStateDataNeeded(), query.isPowerStateDataNeeded(), minConsumedPowerThreshold);
        List<PowerCalculator> powerCalculators = getPowerCalculators();
        if (powerCalculators.isEmpty() == true) goto L13;
    L14:
        usePowerCalculators = true;
    L16:
        if (usePowerCalculators == false) goto L23;
        if (monotonicStartTime == (-1)) goto L20;
    L21:
        Slog.wtfStack(TAG, "BatteryUsageStatsQuery specifies a time range that is incompatible with PowerCalculators: " + powerCalculators);
        usePowerCalculators = false;
        goto L23
    L20:
        if (monotonicEndTime != (-1)) goto L21;
    L23:
        if (monotonicStartTime != (-1)) goto L25;
        long monotonicStartTime2 = session.getMonotonicStartTime();
    L26:
        batteryUsageStatsBuilder.setStatsStartTimestamp(session.getStartClockTime() + (monotonicStartTime2 - session.getMonotonicStartTime()));
        if (monotonicEndTime == (-1)) goto L29;
        batteryUsageStatsBuilder.setStatsEndTimestamp(session.getStartClockTime() + (monotonicEndTime - session.getMonotonicStartTime()));
    L30:
        if (usePowerCalculators == false) goto L32;
        BatteryStatsImpl stats = session.getBatteryStats();
        BatteryUsageStatsQuery r11 = query;
        applyPowerCalculators(batteryUsageStatsBuilder, stats, r11, includeVirtualUids);
    L34:
        if ((r11.getFlags() & 2) == 0) goto L37;
        batteryUsageStatsBuilder.setBatteryHistory(session.getHistory().copy(), r11.getPreferredHistoryDurationMs());
    L37:
        this.mPowerAttributor.estimatePowerConsumption(batteryUsageStatsBuilder, session.getHistory(), monotonicStartTime2, monotonicEndTime);
        buildUserBatteryConsumers(batteryUsageStatsBuilder, query.getUserIds());
        populateBatterySessionInfo(batteryUsageStatsBuilder, session);
        return batteryUsageStatsBuilder;
    L32:
        r11 = query;
        goto L34
    L29:
        batteryUsageStatsBuilder.setStatsEndTimestamp(currentTimeMs);
        goto L30
    L25:
        monotonicStartTime2 = monotonicStartTime;
        goto L26
    L13:
        if (query.isPowerCalculatorSupported() == false) goto L16;
    L9:
        includeVirtualUids = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private void applyPowerCalculators(BatteryUsageStats.Builder batteryUsageStatsBuilder, BatteryStatsImpl stats, BatteryUsageStatsQuery query, boolean includeVirtualUids) {
        monitor-enter(stats);
        List<PowerCalculator> powerCalculators = getPowerCalculators();     // Catch: Throwable -> L12
        long realtimeUs = this.mClock.elapsedRealtime() * 1000;     // Catch: Throwable -> L12
        long uptimeUs = this.mClock.uptimeMillis() * 1000;     // Catch: Throwable -> L12
        int[] powerComponents = query.getPowerComponents();     // Catch: Throwable -> L12
        SparseArray<? extends BatteryStats.Uid> uidStats = stats.getUidStats();     // Catch: Throwable -> L12
        int i = uidStats.size() - 1;
    L6:
        if (i < 0) goto L18;
        BatteryStats.Uid uid = uidStats.valueAt(i);     // Catch: Throwable -> L16
        if (includeVirtualUids == false) goto L10;
    L14:
        batteryUsageStatsBuilder.getOrCreateUidBatteryConsumerBuilder(uid);     // Catch: Throwable -> L12
    L15:
        i = i - 1;     // Catch: Throwable -> L12
        goto L6
    L10:
        if (uid.getUid() != 1090) goto L14;
    L16:
        th = th;
    L35:
        monitor-exit(stats);     // Catch: Throwable -> L12
        throw th;
    L18:
        int i2 = 0;
        int count = powerCalculators.size();     // Catch: Throwable -> L12
    L19:
        if (i2 >= count) goto L33;
        PowerCalculator powerCalculator = powerCalculators.get(i2);     // Catch: Throwable -> L12
        if (powerComponents == null) goto L30;
        boolean include = false;
        int r13 = powerComponents.length;     // Catch: Throwable -> L12
        int r14 = 0;
    L23:
        if (r14 >= r13) goto L28;
        int powerComponent = powerComponents[r14];     // Catch: Throwable -> L12
        if (powerCalculator.isPowerComponentSupported(powerComponent) == true) goto L26;
        r14 = r14 + 1;     // Catch: Throwable -> L12
        goto L23
    L26:
        include = true;
    L28:
        if (include == true) goto L30;
    L31:
        i2 = i2 + 1;     // Catch: Throwable -> L12
    L30:
        powerCalculator.calculate(batteryUsageStatsBuilder, stats, realtimeUs, uptimeUs, query);     // Catch: Throwable -> L12
        goto L31
    L33:
        monitor-exit(stats);     // Catch: Throwable -> L12
        return;
    L12:
        th = th;
        goto L35
    }

    private void populateBatterySessionInfo(BatteryUsageStats.Builder builder, BatteryStatsImpl.BatteryStatsSession session) {
        builder.setBatteryCapacity(session.getEstimatedBatteryCapacity());
        builder.setBatteryTimeRemainingMs(session.getBatteryTimeRemainingMs());
        builder.setChargeTimeRemainingMs(session.getChargeTimeRemainingMs());
    }

    private BatteryUsageStats getAggregatedBatteryUsageStats(BatteryStatsImpl.BatteryStatsSession stats, BatteryUsageStatsQuery query) {
        BatteryUsageStatsProvider r1 = this;
        if ((query.getFlags() & 8) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean includeProcessStateData = r0;
        double minConsumedPowerThreshold = query.getMinConsumedPowerThreshold();
        String[] customEnergyConsumerNames = stats.getCustomEnergyConsumerNames();
        BatteryUsageStats.Builder builder = new BatteryUsageStats.Builder(customEnergyConsumerNames, includeProcessStateData, query.isScreenStateDataNeeded(), query.isPowerStateDataNeeded(), minConsumedPowerThreshold);
        if (r1.mPowerStatsStore != null) goto L10;
        Log.e(TAG, "PowerStatsStore is unavailable");
        return builder.build();
    L10:
        List<PowerStatsSpan.Metadata> toc = r1.mPowerStatsStore.getTableOfContents();
        Iterator<PowerStatsSpan.Metadata> r2 = toc.iterator();
    L12:
        if (r2.hasNext() == false) goto L60;
        PowerStatsSpan.Metadata spanMetadata = r2.next();
        if (spanMetadata.getSections().contains(BatteryUsageStatsSection.TYPE) == false) goto L12;
        long minTime = Long.MAX_VALUE;
        Iterator<PowerStatsSpan.TimeFrame> r12 = spanMetadata.getTimeFrames().iterator();
        long maxTime = 0;
    L18:
        if (r12.hasNext() == false) goto L20;
        Iterator<PowerStatsSpan.Metadata> r19 = r2;
        PowerStatsSpan.TimeFrame timeFrame = r12.next();
        List<PowerStatsSpan.Metadata> toc2 = toc;
        long spanEndTime = timeFrame.startTime + timeFrame.duration;
        minTime = Math.min(minTime, spanEndTime);
        maxTime = Math.max(maxTime, spanEndTime);
        toc = toc2;
        r2 = r19;
        minConsumedPowerThreshold = minConsumedPowerThreshold;
        goto L18
    L20:
        Iterator<PowerStatsSpan.Metadata> r110 = r2;
        double minConsumedPowerThreshold2 = minConsumedPowerThreshold;
        List<PowerStatsSpan.Metadata> toc3 = toc;
        if (query.getAggregatedFromTimestamp() == 0) goto L25;
        if (minTime > query.getAggregatedFromTimestamp()) goto L25;
    L29:
        boolean r3 = false;
    L31:
        boolean isInRange = r3;
        if (isInRange == false) goto L33;
        PowerStatsSpan powerStatsSpan = r1.mPowerStatsStore.loadPowerStatsSpan(spanMetadata.getId(), new String[]{BatteryUsageStatsSection.TYPE});
        if (powerStatsSpan == null) goto L36;
        Iterator<PowerStatsSpan.Section> r4 = powerStatsSpan.getSections().iterator();     // Catch: Throwable -> L45
    L41:
        if (r4.hasNext() == false) goto L53;
        PowerStatsSpan.Section section = r4.next();     // Catch: Throwable -> L45
        BatteryUsageStats snapshot = ((BatteryUsageStatsSection) section).getBatteryUsageStats();     // Catch: Throwable -> L45
        if (Arrays.equals(snapshot.getCustomPowerComponentNames(), customEnergyConsumerNames) == false) goto L44;
        if (includeProcessStateData == false) goto L51;
        if (snapshot.isProcessStateDataIncluded() == true) goto L51;
        Log.w(TAG, "Ignoring older BatteryUsageStats snapshot, which  does not include process state data");     // Catch: Throwable -> L45
    L51:
        builder.add(snapshot);     // Catch: Throwable -> L45
        goto L41
    L44:
        Log.w(TAG, "Ignoring older BatteryUsageStats snapshot, which has different custom power components: " + Arrays.toString(snapshot.getCustomPowerComponentNames()));     // Catch: Throwable -> L45
        goto L41
    L53:
        powerStatsSpan.close();
        r1 = this;
        toc = toc3;
        r2 = r110;
        minConsumedPowerThreshold = minConsumedPowerThreshold2;
    L45:
        th = move-exception;
        powerStatsSpan.close();     // Catch: Throwable -> L56
        throw th;
    L56:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L36:
        if (powerStatsSpan == null) goto L38;
        powerStatsSpan.close();
    L38:
        r1 = this;
        toc = toc3;
        r2 = r110;
        minConsumedPowerThreshold = minConsumedPowerThreshold2;
        goto L12
    L33:
        toc = toc3;
        r2 = r110;
        minConsumedPowerThreshold = minConsumedPowerThreshold2;
    L25:
        if (query.getAggregatedToTimestamp() != 0) goto L27;
    L30:
        r3 = true;
        goto L31
    L27:
        if (maxTime > query.getAggregatedToTimestamp()) goto L29;
    L60:
        return builder.build();
    L5:
        r0 = false;
        goto L6
    }

    private void buildUserBatteryConsumers(BatteryUsageStats.Builder builder, int[] userIds) {
        if (ArrayUtils.contains(userIds, -1) == false) goto L5;
        return;
    L5:
        SparseArray<UidBatteryConsumer.Builder> uidBatteryConsumerBuilders = builder.getUidBatteryConsumerBuilders();
        int i = uidBatteryConsumerBuilders.size() - 1;
    L6:
        if (i < 0) goto L18;
        UidBatteryConsumer.Builder uidBuilder = uidBatteryConsumerBuilders.valueAt(i);
        if (uidBuilder.isVirtualUid() == true) goto L16;
        int uid = uidBuilder.getUid();
        if (UserHandle.getAppId(uid) < 10000) goto L16;
        int userId = UserHandle.getUserId(uid);
        if (ArrayUtils.contains(userIds, userId) == true) goto L16;
        uidBuilder.excludeFromBatteryUsageStats();
        builder.getOrCreateUserBatteryConsumerBuilder(userId).addUidBatteryConsumer(uidBuilder);
    L16:
        i = i - 1;
        goto L6
    }
}
