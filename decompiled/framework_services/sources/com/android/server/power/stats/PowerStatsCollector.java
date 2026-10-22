package com.android.server.power.stats;

import android.hardware.power.stats.EnergyConsumer;
import android.hardware.power.stats.EnergyConsumerAttribution;
import android.hardware.power.stats.EnergyConsumerResult;
import android.os.ConditionVariable;
import android.os.Handler;
import android.power.PowerStatsInternal;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseLongArray;
import com.android.internal.os.Clock;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.PowerStatsLayout;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.IntSupplier;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PowerStatsCollector {
    private static final long ENERGY_UNSPECIFIED = -1;
    private static final int MILLIVOLTS_PER_VOLT = 1000;
    private static final long POWER_STATS_ENERGY_CONSUMERS_TIMEOUT = 20000;
    private static final String TAG = "PowerStatsCollector";
    protected final Clock mClock;
    private final Runnable mCollectAndDeliverStats;
    private volatile List<Consumer<PowerStats>> mConsumerList;
    private boolean mEnabled;
    private final Handler mHandler;
    private long mLastScheduledUpdateMs;
    private final long mThrottlePeriodMs;
    protected final PowerStatsUidResolver mUidResolver;

    /* JADX INFO: renamed from: com.android.server.power.stats.PowerStatsCollector$1, reason: invalid class name */
    class AnonymousClass1 implements PowerStatsUidResolver.Listener {
        final /* synthetic */ PowerStatsCollector this$0;

        public static /* synthetic */ void $r8$lambda$VHeUHnX1F0pyi88eqk7Lt8RRwPY(AnonymousClass1 r0, int r1) {
            r0.lambda$onAfterIsolatedUidRemoved$0(r1);
        }

        AnonymousClass1(PowerStatsCollector this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.power.stats.PowerStatsUidResolver.Listener
        public void onIsolatedUidAdded(int isolatedUid, int parentUid) {
        }

        @Override // com.android.server.power.stats.PowerStatsUidResolver.Listener
        public void onBeforeIsolatedUidRemoved(int isolatedUid, int parentUid) {
        }

        private /* synthetic */ void lambda$onAfterIsolatedUidRemoved$0(int isolatedUid) {
            this.this$0.onUidRemoved(isolatedUid);
        }

        @Override // com.android.server.power.stats.PowerStatsUidResolver.Listener
        public void onAfterIsolatedUidRemoved(final int isolatedUid, int parentUid) {
            PowerStatsCollector.m7839$$Nest$fgetmHandler(this.this$0).post(new PowerStatsCollector$1$$ExternalSyntheticLambda0(this, isolatedUid));
        }
    }

    class ConsumedEnergyHelper implements PowerStatsUidResolver.Listener {
        private final ConsumedEnergyRetriever mConsumedEnergyRetriever;
        private int[] mEnergyConsumerIds;
        private final int mEnergyConsumerType;
        private boolean mFirstCollection;
        private boolean mIsInitialized;
        private long[] mLastConsumedEnergyUws;
        private final SparseLongArray mLastConsumerEnergyPerUid;
        private int mLastVoltageMv;
        private final boolean mPerUidAttributionSupported;
        final /* synthetic */ PowerStatsCollector this$0;

        public static /* synthetic */ void $r8$lambda$fE2HIS54stOPSgrdk0vdo4mgHPs(ConsumedEnergyHelper r0, int r1) {
            r0.lambda$onAfterIsolatedUidRemoved$0(r1);
        }

        ConsumedEnergyHelper(PowerStatsCollector this$0, ConsumedEnergyRetriever consumedEnergyRetriever, int energyConsumerType) {
            this.this$0 = this$0;
            this.mFirstCollection = true;
            this.mConsumedEnergyRetriever = consumedEnergyRetriever;
            this.mEnergyConsumerType = energyConsumerType;
            this.mPerUidAttributionSupported = false;
            this.mLastConsumerEnergyPerUid = null;
        }

        ConsumedEnergyHelper(PowerStatsCollector this$0, ConsumedEnergyRetriever consumedEnergyRetriever, int energyConsumerId, boolean perUidAttributionSupported) {
            this.this$0 = this$0;
            this.mFirstCollection = true;
            this.mConsumedEnergyRetriever = consumedEnergyRetriever;
            this.mEnergyConsumerType = 0;
            this.mEnergyConsumerIds = new int[]{energyConsumerId};
            this.mPerUidAttributionSupported = perUidAttributionSupported;
            if (this.mPerUidAttributionSupported == false) goto L5;
            SparseLongArray r0 = new SparseLongArray();
        L6:
            this.mLastConsumerEnergyPerUid = r0;
            return;
        L5:
            r0 = null;
            goto L6
        }

        private void ensureInitialized() {
            if (this.mIsInitialized == false) goto L5;
            return;
        L5:
            if (this.mEnergyConsumerIds != null) goto L7;
            this.mEnergyConsumerIds = this.mConsumedEnergyRetriever.getEnergyConsumerIds(this.mEnergyConsumerType);
        L7:
            this.mLastConsumedEnergyUws = new long[this.mEnergyConsumerIds.length];
            Arrays.fill(this.mLastConsumedEnergyUws, -1);
            this.this$0.mUidResolver.addListener(this);
            this.mIsInitialized = true;
        }

        int getEnergyConsumerCount() {
            ensureInitialized();
            return this.mEnergyConsumerIds.length;
        }

        boolean collectConsumedEnergy(PowerStats powerStats, PowerStatsLayout layout) {
            ensureInitialized();
            if (this.mEnergyConsumerIds.length != 0) goto L5;
            return false;
        L5:
            int voltageMv = this.mConsumedEnergyRetriever.getVoltageMv();
            if (this.mLastVoltageMv == 0) goto L8;
            int r2 = (this.mLastVoltageMv + voltageMv) / 2;
        L9:
            int averageVoltage = r2;
            if (averageVoltage > 0) goto L13;
            Slog.wtf(PowerStatsCollector.TAG, "Unexpected battery voltage (" + voltageMv + " mV) when querying energy consumers");
            return false;
        L13:
            this.mLastVoltageMv = voltageMv;
            EnergyConsumerResult[] energy = this.mConsumedEnergyRetriever.getConsumedEnergy(this.mEnergyConsumerIds);
            if (energy != null) goto L16;
            return false;
        L16:
            int i = 0;
        L18:
            if (i >= this.mEnergyConsumerIds.length) goto L20;
            populatePowerStats(powerStats, layout, energy, i, averageVoltage);
            i = i + 1;
            goto L18
        L20:
            this.mFirstCollection = false;
            return true;
        L8:
            r2 = voltageMv;
            goto L9
        }

        private void populatePowerStats(PowerStats powerStats, PowerStatsLayout layout, EnergyConsumerResult[] energy, int energyConsumerIndex, int averageVoltage) {
            ConsumedEnergyHelper r0 = this;
            PowerStats r1 = powerStats;
            long consumedEnergy = energy[energyConsumerIndex].energyUWs;
            long r11 = 0;
            if (r0.mLastConsumedEnergyUws[energyConsumerIndex] == (-1)) goto L5;
            long energyDelta = consumedEnergy - r0.mLastConsumedEnergyUws[energyConsumerIndex];
        L6:
            r0.mLastConsumedEnergyUws[energyConsumerIndex] = consumedEnergy;
            if (energyDelta >= 0) goto L10;
            energyDelta = 0;
        L10:
            if (energyDelta == 0) goto L12;
        L14:
            layout.setConsumedEnergy(r1.stats, energyConsumerIndex, PowerStatsCollector.uJtoUc(energyDelta, averageVoltage));
            if (r0.mPerUidAttributionSupported == true) goto L17;
            return;
        L17:
            EnergyConsumerAttribution[] perUid = energy[energyConsumerIndex].attribution;
            if (perUid != null) goto L20;
            return;
        L20:
            int r14 = perUid.length;
            int r15 = 0;
        L21:
            if (r15 >= r14) goto L33;
            long r16 = r11;
            EnergyConsumerAttribution attribution = perUid[r15];
            int uid = r0.this$0.mUidResolver.mapUid(attribution.uid);
            long consumedEnergy2 = consumedEnergy;
            long lastEnergy = r0.mLastConsumerEnergyPerUid.get(uid, -1);
            r0.mLastConsumerEnergyPerUid.put(uid, attribution.energyUWs);
            if (lastEnergy == (-1)) goto L32;
            long deltaEnergy = attribution.energyUWs - lastEnergy;
            if (deltaEnergy <= r16) goto L32;
            long[] uidStats = (long[]) r1.uidStats.get(uid);
            if (uidStats != null) goto L31;
            uidStats = new long[layout.getUidStatsArrayLength()];
            r1.uidStats.put(uid, uidStats);
        L31:
            layout.setUidConsumedEnergy(uidStats, energyConsumerIndex, layout.getUidConsumedEnergy(uidStats, energyConsumerIndex) + PowerStatsCollector.uJtoUc(deltaEnergy, averageVoltage));
        L32:
            r15 = r15 + 1;
            r0 = this;
            r1 = powerStats;
            r11 = r16;
            consumedEnergy = consumedEnergy2;
            goto L21
        L33:
            return;
        L12:
            if (r0.mFirstCollection == true) goto L14;
            return;
        L5:
            energyDelta = 0;
            goto L6
        }

        @Override // com.android.server.power.stats.PowerStatsUidResolver.Listener
        public void onAfterIsolatedUidRemoved(final int isolatedUid, int parentUid) {
            if (this.mLastConsumerEnergyPerUid == null) goto L6;
            PowerStatsCollector.m7839$$Nest$fgetmHandler(this.this$0).post(new PowerStatsCollector$ConsumedEnergyHelper$$ExternalSyntheticLambda0(this, isolatedUid));
            return;
        }

        private /* synthetic */ void lambda$onAfterIsolatedUidRemoved$0(int isolatedUid) {
            this.mLastConsumerEnergyPerUid.delete(isolatedUid);
        }

        @Override // com.android.server.power.stats.PowerStatsUidResolver.Listener
        public void onIsolatedUidAdded(int isolatedUid, int parentUid) {
        }

        @Override // com.android.server.power.stats.PowerStatsUidResolver.Listener
        public void onBeforeIsolatedUidRemoved(int isolatedUid, int parentUid) {
        }
    }

    public interface ConsumedEnergyRetriever {
        EnergyConsumerResult[] getConsumedEnergy(int[] r1);

        int[] getEnergyConsumerIds(int r1);

        String getEnergyConsumerName(int r1);

        int getVoltageMv();
    }

    static class ConsumedEnergyRetrieverImpl implements ConsumedEnergyRetriever {
        private EnergyConsumer[] mEnergyConsumers;
        private final PowerStatsInternal mPowerStatsInternal;
        private final IntSupplier mVoltageSupplier;

        /* JADX INFO: renamed from: $r8$lambda$-ZKAzyj1NdB_Q-Ya6UvyUD3H7sk, reason: not valid java name */
        public static /* synthetic */ Integer m7840$r8$lambda$ZKAzyj1NdB_QYa6UvyUD3H7sk(EnergyConsumer r0) {
            return lambda$getEnergyConsumerIds$0(r0);
        }

        ConsumedEnergyRetrieverImpl(PowerStatsInternal powerStatsInternal, IntSupplier voltageSupplier) {
            this.mPowerStatsInternal = powerStatsInternal;
            this.mVoltageSupplier = voltageSupplier;
        }

        private void ensureEnergyConsumers() {
            if (this.mEnergyConsumers == null) goto L6;
            return;
        L6:
            if (this.mPowerStatsInternal != null) goto L9;
            this.mEnergyConsumers = new EnergyConsumer[0];
            return;
        L9:
            this.mEnergyConsumers = this.mPowerStatsInternal.getEnergyConsumerInfo();
            if (this.mEnergyConsumers != null) goto L13;
            this.mEnergyConsumers = new EnergyConsumer[0];
            return;
        }

        @Override // com.android.server.power.stats.PowerStatsCollector.ConsumedEnergyRetriever
        public int[] getEnergyConsumerIds(int energyConsumerType) {
            ensureEnergyConsumers();
            if (this.mEnergyConsumers.length == 0) goto L5;
            List<EnergyConsumer> energyConsumers = new ArrayList();
            EnergyConsumer[] r2 = this.mEnergyConsumers;
            int r3 = r2.length;
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L13;
            EnergyConsumer energyConsumer = r2[r4];
            if (energyConsumer.type != energyConsumerType) goto L11;
            energyConsumers.add(energyConsumer);
        L11:
            r4 = r4 + 1;
            goto L7
        L13:
            if (energyConsumers.isEmpty() == true) goto L15;
            energyConsumers.sort(Comparator.comparing(new PowerStatsCollector$ConsumedEnergyRetrieverImpl$$ExternalSyntheticLambda0()));
            int[] ids = new int[energyConsumers.size()];
            int i = 0;
        L18:
            if (i >= ids.length) goto L21;
            ids[i] = energyConsumers.get(i).id;
            i = i + 1;
            goto L18
        L21:
            return ids;
        L15:
            return new int[0];
        L5:
            return new int[0];
        }

        private static /* synthetic */ Integer lambda$getEnergyConsumerIds$0(EnergyConsumer c) {
            return Integer.valueOf(c.ordinal);
        }

        @Override // com.android.server.power.stats.PowerStatsCollector.ConsumedEnergyRetriever
        public EnergyConsumerResult[] getConsumedEnergy(int[] energyConsumerIds) {
            CompletableFuture<EnergyConsumerResult[]> future = this.mPowerStatsInternal.getEnergyConsumedAsync(energyConsumerIds);
            return future.get(PowerStatsCollector.POWER_STATS_ENERGY_CONSUMERS_TIMEOUT, TimeUnit.MILLISECONDS);
        L5:
            e = move-exception;
            Slog.e(PowerStatsCollector.TAG, "Could not obtain energy consumers from PowerStatsService", e);
            return null;
        }

        @Override // com.android.server.power.stats.PowerStatsCollector.ConsumedEnergyRetriever
        public int getVoltageMv() {
            return this.mVoltageSupplier.getAsInt();
        }

        @Override // com.android.server.power.stats.PowerStatsCollector.ConsumedEnergyRetriever
        public String getEnergyConsumerName(int energyConsumerId) {
            ensureEnergyConsumers();
            EnergyConsumer[] r0 = this.mEnergyConsumers;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            EnergyConsumer energyConsumer = r0[r2];
            if (energyConsumer.id == energyConsumerId) goto L7;
            r2 = r2 + 1;
            goto L3
        L7:
            return sanitizeCustomPowerComponentName(energyConsumer);
        L9:
            Slog.e(PowerStatsCollector.TAG, "Unsupported energy consumer ID " + energyConsumerId);
            return "unsupported";
        }

        private String sanitizeCustomPowerComponentName(EnergyConsumer energyConsumer) {
            String name = energyConsumer.name;
            if (name != null) goto L5;
        L6:
            name = "CUSTOM_" + energyConsumer.id;
        L7:
            int length = name.length();
            StringBuilder sb = new StringBuilder(length);
            int i = 0;
        L8:
            if (i >= length) goto L18;
            char c = name.charAt(i);
            if (Character.isWhitespace(c) == false) goto L13;
            sb.append(' ');
        L16:
            i = i + 1;
            goto L8
        L13:
            if (Character.isISOControl(c) == false) goto L15;
            sb.append('_');
            goto L16
        L15:
            sb.append(c);
            goto L16
        L18:
            return sb.toString();
        L5:
            if (name.isBlank() == false) goto L7;
            goto L6
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7839$$Nest$fgetmHandler(PowerStatsCollector r0) {
        return r0.mHandler;
    }

    public PowerStatsCollector(Handler handler, long throttlePeriodMs, PowerStatsUidResolver uidResolver, Clock clock) {
        this.mCollectAndDeliverStats = new PowerStatsCollector$$ExternalSyntheticLambda0(this);
        this.mLastScheduledUpdateMs = -1;
        this.mConsumerList = Collections.emptyList();
        this.mHandler = handler;
        this.mThrottlePeriodMs = throttlePeriodMs;
        this.mUidResolver = uidResolver;
        this.mUidResolver.addListener(new AnonymousClass1(this));
        this.mClock = clock;
    }

    public void addConsumer(Consumer<PowerStats> consumer) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mConsumerList.contains(consumer) == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        List<Consumer<PowerStats>> newList = new ArrayList(this.mConsumerList);     // Catch: Throwable -> L7
        newList.add(consumer);     // Catch: Throwable -> L7
        this.mConsumerList = Collections.unmodifiableList(newList);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    public void removeConsumer(Consumer<PowerStats> consumer) {
        monitor-enter(this);
        List<Consumer<PowerStats>> newList = new ArrayList(this.mConsumerList);     // Catch: Throwable -> L6
        newList.remove(consumer);     // Catch: Throwable -> L6
        this.mConsumerList = Collections.unmodifiableList(newList);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setEnabled(boolean enabled) {
        this.mEnabled = enabled;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean schedule() {
        if (this.mEnabled == true) goto L5;
        return false;
    L5:
        long uptimeMillis = this.mClock.uptimeMillis();
        if ((uptimeMillis - this.mLastScheduledUpdateMs) < this.mThrottlePeriodMs) goto L8;
    L10:
        this.mLastScheduledUpdateMs = uptimeMillis;
        this.mHandler.post(this.mCollectAndDeliverStats);
        return true;
    L8:
        if (this.mLastScheduledUpdateMs < 0) goto L10;
        return false;
    }

    public boolean forceSchedule() {
        if (this.mEnabled == true) goto L6;
        return false;
    L6:
        this.mHandler.removeCallbacks(this.mCollectAndDeliverStats);
        this.mHandler.postAtFrontOfQueue(this.mCollectAndDeliverStats);
        return true;
    }

    public void collectAndDeliverStats() {
        deliverStats(collectStats());
    }

    protected PowerStats collectStats() {
        return null;
    }

    protected void deliverStats(PowerStats stats) {
        if (stats != null) goto L4;
        return;
    L4:
        List<Consumer<PowerStats>> consumerList = this.mConsumerList;
        int i = consumerList.size() - 1;
    L5:
        if (i < 0) goto L8;
        consumerList.get(i).accept(stats);
        i = i - 1;
        goto L5
    }

    public void collectAndDump(PrintWriter pw) {
        if (Thread.currentThread() == this.mHandler.getLooper().getThread()) goto L23;
        IndentingPrintWriter out = new IndentingPrintWriter(pw);
        if (isEnabled() == true) goto L8;
        out.print(getClass().getSimpleName());
        out.println(": disabled");
        return;
    L8:
        final ArrayList<PowerStats> collected = new ArrayList();
        Consumer<PowerStats> consumer = new PowerStatsCollector$$ExternalSyntheticLambda1(collected);
        addConsumer(consumer);
    L13:
        th = move-exception;
        removeConsumer(consumer);
        throw th;
    L10:
        if (forceSchedule() == false) goto L15;
        awaitCompletion();     // Catch: Throwable -> L13
    L15:
        removeConsumer(consumer);
        Iterator<PowerStats> r3 = collected.iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        PowerStats stats = r3.next();
        stats.dump(out);
        goto L17
    L19:
        return;
    L23:
        throw new RuntimeException("Calling this method from the handler thread would cause a deadlock");
    }

    private void awaitCompletion() {
        ConditionVariable done = new ConditionVariable();
        this.mHandler.post(new BatteryStatsImpl$$ExternalSyntheticLambda8(done));
        done.block();
    }

    protected void onUidRemoved(int uid) {
    }

    protected static long uJtoUc(long deltaEnergyUj, int avgVoltageMv) {
        return ((1000 * deltaEnergyUj) + ((long) (avgVoltageMv / 2))) / ((long) avgVoltageMv);
    }
}
