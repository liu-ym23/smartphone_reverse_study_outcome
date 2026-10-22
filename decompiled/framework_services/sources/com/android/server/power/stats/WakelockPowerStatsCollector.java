package com.android.server.power.stats;

import android.os.BatteryConsumer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.SparseLongArray;
import com.android.internal.os.Clock;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.WakelockPowerStatsLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class WakelockPowerStatsCollector extends PowerStatsCollector {
    private PowerStats.Descriptor mDescriptor;
    private boolean mFirstCollection;
    private boolean mIsInitialized;
    private long mLastCollectionTime;
    private final SparseLongArray mLastUidWakelockDurations;
    private long mLastWakelockDurationMs;
    private PowerStats mPowerStats;
    private WakelockPowerStatsLayout mStatsLayout;
    private final WakelockDurationRetriever mWakelockDurationRetriever;

    public interface Injector {
        Clock getClock();

        Handler getHandler();

        long getPowerStatsCollectionThrottlePeriod(String r1);

        PowerStatsUidResolver getUidResolver();

        WakelockDurationRetriever getWakelockDurationRetriever();
    }

    public interface WakelockDurationRetriever {

        public interface Callback {
            void onUidWakelockDuration(int r1, long r2);
        }

        long getWakelockDurationMillis();

        void retrieveUidWakelockDuration(Callback r1);
    }

    public static /* synthetic */ void $r8$lambda$6beLFR_C40phG_UeVqzNOydosp8(WakelockPowerStatsCollector r0, int r1, long r2) {
        r0.lambda$collectStats$0(r1, r2);
    }

    WakelockPowerStatsCollector(Injector injector) {
        super(injector.getHandler(), injector.getPowerStatsCollectionThrottlePeriod(BatteryConsumer.powerComponentIdToString(12)), injector.getUidResolver(), injector.getClock());
        this.mFirstCollection = true;
        this.mLastUidWakelockDurations = new SparseLongArray();
        this.mWakelockDurationRetriever = injector.getWakelockDurationRetriever();
    }

    private boolean ensureInitialized() {
        if (this.mIsInitialized == false) goto L6;
        return true;
    L6:
        if (isEnabled() == true) goto L9;
        return false;
    L9:
        this.mStatsLayout = new WakelockPowerStatsLayout();
        PersistableBundle extras = new PersistableBundle();
        this.mStatsLayout.toExtras(extras);
        this.mDescriptor = new PowerStats.Descriptor(12, this.mStatsLayout.getDeviceStatsArrayLength(), null, 0, this.mStatsLayout.getUidStatsArrayLength(), extras);
        this.mPowerStats = new PowerStats(this.mDescriptor);
        this.mIsInitialized = true;
        return true;
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    protected PowerStats collectStats() {
        if (ensureInitialized() == true) goto L6;
        return null;
    L6:
        Arrays.fill(this.mPowerStats.stats, 0);
        this.mPowerStats.uidStats.clear();
        long elapsedRealtime = this.mClock.elapsedRealtime();
        PowerStats r0 = this.mPowerStats;
        r0.durationMs = elapsedRealtime - this.mLastCollectionTime;
        long wakelockDurationMillis = this.mWakelockDurationRetriever.getWakelockDurationMillis();
        if (this.mFirstCollection == true) goto L9;
        this.mStatsLayout.setUsageDuration(this.mPowerStats.stats, Math.max(0, wakelockDurationMillis - this.mLastWakelockDurationMs));
    L9:
        this.mLastWakelockDurationMs = wakelockDurationMillis;
        this.mWakelockDurationRetriever.retrieveUidWakelockDuration(new WakelockPowerStatsCollector$$ExternalSyntheticLambda0(this));
        this.mLastCollectionTime = elapsedRealtime;
        this.mFirstCollection = false;
        return this.mPowerStats;
    }

    private /* synthetic */ void lambda$collectStats$0(int uid, long durationMs) {
        if (this.mFirstCollection == true) goto L10;
        long diffMs = Math.max(0, durationMs - this.mLastUidWakelockDurations.get(uid));
        if (diffMs == 0) goto L10;
        long[] uidStats = (long[]) this.mPowerStats.uidStats.get(uid);
        if (uidStats != null) goto L9;
        uidStats = new long[this.mDescriptor.uidStatsArrayLength];
        this.mPowerStats.uidStats.put(uid, uidStats);
    L9:
        this.mStatsLayout.setUidUsageDuration(uidStats, diffMs);
    L10:
        this.mLastUidWakelockDurations.put(uid, durationMs);
    }
}
