package com.android.server.power.stats;

import android.os.BatteryConsumer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.SparseLongArray;
import com.android.internal.os.Clock;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.ScreenPowerStatsLayout;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenPowerStatsCollector extends PowerStatsCollector {
    private static final String TAG = "ScreenPowerStatsCollector";
    private PowerStatsCollector.ConsumedEnergyHelper mConsumedEnergyHelper;
    private int mDisplayCount;
    private boolean mFirstSample;
    private final Injector mInjector;
    private boolean mIsInitialized;
    private long[][] mLastBrightnessLevelTime;
    private long mLastCollectionTime;
    private long[] mLastDozeTime;
    private long[] mLastScreenOnTime;
    private final SparseLongArray mLastTopActivityTime;
    private ScreenPowerStatsLayout mLayout;
    private PowerStats mPowerStats;
    private ScreenUsageTimeRetriever mScreenUsageTimeRetriever;

    public interface Injector {
        Clock getClock();

        PowerStatsCollector.ConsumedEnergyRetriever getConsumedEnergyRetriever();

        int getDisplayCount();

        Handler getHandler();

        long getPowerStatsCollectionThrottlePeriod(String r1);

        ScreenUsageTimeRetriever getScreenUsageTimeRetriever();

        PowerStatsUidResolver getUidResolver();
    }

    public interface ScreenUsageTimeRetriever {

        public interface Callback {
            void onUidTopActivityTime(int r1, long r2);
        }

        long getBrightnessLevelTimeMs(int r1, int r2);

        long getScreenDozeTimeMs(int r1);

        long getScreenOnTimeMs(int r1);

        void retrieveTopActivityTimes(Callback r1);
    }

    public static /* synthetic */ void $r8$lambda$0HnneE1S37oMrEUeOB2Kv1WtWBY(ScreenPowerStatsCollector r0, int r1, long r2) {
        r0.lambda$collectStats$0(r1, r2);
    }

    public ScreenPowerStatsCollector(Injector injector) {
        super(injector.getHandler(), injector.getPowerStatsCollectionThrottlePeriod(BatteryConsumer.powerComponentIdToString(0)), injector.getUidResolver(), injector.getClock());
        this.mFirstSample = true;
        this.mLastTopActivityTime = new SparseLongArray();
        this.mInjector = injector;
    }

    private boolean ensureInitialized() {
        if (this.mIsInitialized == false) goto L6;
        return true;
    L6:
        if (isEnabled() == true) goto L8;
        return false;
    L8:
        this.mDisplayCount = this.mInjector.getDisplayCount();
        this.mScreenUsageTimeRetriever = this.mInjector.getScreenUsageTimeRetriever();
        this.mConsumedEnergyHelper = new PowerStatsCollector.ConsumedEnergyHelper(this, this.mInjector.getConsumedEnergyRetriever(), 3);
        this.mLayout = new ScreenPowerStatsLayout(this.mConsumedEnergyHelper.getEnergyConsumerCount(), this.mInjector.getDisplayCount());
        PersistableBundle extras = new PersistableBundle();
        this.mLayout.toExtras(extras);
        PowerStats.Descriptor powerStatsDescriptor = new PowerStats.Descriptor(0, this.mLayout.getDeviceStatsArrayLength(), null, 0, this.mLayout.getUidStatsArrayLength(), extras);
        this.mLastScreenOnTime = new long[this.mDisplayCount];
        this.mLastBrightnessLevelTime = (long[][]) Array.newInstance(Long.TYPE, new int[]{this.mDisplayCount, 5});
        this.mLastDozeTime = new long[this.mDisplayCount];
        this.mPowerStats = new PowerStats(powerStatsDescriptor);
        this.mIsInitialized = true;
        return true;
    }

    public void onScreenStateChange() {
        if (ensureInitialized() == true) goto L5;
    L8:
        schedule();
        return;
    L5:
        if (this.mConsumedEnergyHelper.getEnergyConsumerCount() == 0) goto L8;
        forceSchedule();
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    public PowerStats collectStats() {
        if (ensureInitialized() == true) goto L6;
        return null;
    L6:
        Arrays.fill(this.mPowerStats.stats, 0);
        this.mPowerStats.uidStats.clear();
        this.mConsumedEnergyHelper.collectConsumedEnergy(this.mPowerStats, this.mLayout);
        int display = 0;
    L8:
        if (display >= this.mDisplayCount) goto L23;
        long screenOnTimeMs = this.mScreenUsageTimeRetriever.getScreenOnTimeMs(display);
        if (this.mFirstSample == true) goto L12;
        this.mLayout.setScreenOnDuration(this.mPowerStats.stats, display, Math.max(0, screenOnTimeMs - this.mLastScreenOnTime[display]));
    L12:
        this.mLastScreenOnTime[display] = screenOnTimeMs;
        int level = 0;
    L14:
        if (level >= 5) goto L19;
        long brightnessLevelTimeMs = this.mScreenUsageTimeRetriever.getBrightnessLevelTimeMs(display, level);
        if (this.mFirstSample == true) goto L18;
        this.mLayout.setBrightnessLevelDuration(this.mPowerStats.stats, display, level, Math.max(0, brightnessLevelTimeMs - this.mLastBrightnessLevelTime[display][level]));
    L18:
        this.mLastBrightnessLevelTime[display][level] = brightnessLevelTimeMs;
        level = level + 1;
        goto L14
    L19:
        long screenDozeTimeMs = this.mScreenUsageTimeRetriever.getScreenDozeTimeMs(display);
        if (this.mFirstSample == true) goto L22;
        this.mLayout.setScreenDozeDuration(this.mPowerStats.stats, display, Math.max(0, screenDozeTimeMs - this.mLastDozeTime[display]));
    L22:
        this.mLastDozeTime[display] = screenDozeTimeMs;
        display = display + 1;
        goto L8
    L23:
        this.mScreenUsageTimeRetriever.retrieveTopActivityTimes(new ScreenPowerStatsCollector$$ExternalSyntheticLambda0(this));
        long elapsedRealtime = this.mClock.elapsedRealtime();
        this.mPowerStats.durationMs = elapsedRealtime - this.mLastCollectionTime;
        this.mLastCollectionTime = elapsedRealtime;
        this.mFirstSample = false;
        return this.mPowerStats;
    }

    private /* synthetic */ void lambda$collectStats$0(int uid, long topActivityTimeMs) {
        long topActivityDuration = topActivityTimeMs - this.mLastTopActivityTime.get(uid);
        if (topActivityDuration != 0) goto L5;
        return;
    L5:
        this.mLastTopActivityTime.put(uid, topActivityTimeMs);
        int mappedUid = this.mUidResolver.mapUid(uid);
        long[] uidStats = (long[]) this.mPowerStats.uidStats.get(mappedUid);
        if (uidStats != null) goto L8;
        uidStats = new long[this.mLayout.getUidStatsArrayLength()];
        this.mPowerStats.uidStats.put(mappedUid, uidStats);
    L8:
        this.mLayout.setUidTopActivityDuration(uidStats, Math.max(0, this.mLayout.getUidTopActivityDuration(uidStats) + topActivityDuration));
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    protected void onUidRemoved(int uid) {
        this.mLastTopActivityTime.delete(uid);
    }
}
