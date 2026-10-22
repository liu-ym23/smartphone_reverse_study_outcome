package com.android.server.power.stats;

import android.app.StatsManager;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.util.StatsEvent;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class WakelockStatsFrameworkEvents {
    public static final String HARD_CAP_TAG = "*overflow hard cap*";
    public static final int HARD_CAP_UID = -1;
    public static final int MAX_WAKELOCK_DIMENSIONS = 1000;
    public static final int OVERFLOW_LEVEL = 1;
    public static final String OVERFLOW_TAG = "*overflow*";
    public static final int SUMMARY_THRESHOLD = 500;
    private static final String TAG = "BatteryStatsPulledMetrics";
    private boolean mIsInitialized;
    private final Object mLock;
    private final Map<WakeLockKey, WakeLockData> mOpenWakeLocks;
    private final StatsPullCallbackHandler mStatsPullCallbackHandler;
    private final Map<WakeLockKey, WakeLockStats> mWakeLockStats;

    public interface EventLogger {
        void logResult(int r1, String r2, int r3, long r4, long r6);
    }

    private class StatsPullCallbackHandler implements StatsManager.StatsPullAtomCallback {
        final /* synthetic */ WakelockStatsFrameworkEvents this$0;

        /* synthetic */ StatsPullCallbackHandler(WakelockStatsFrameworkEvents r1, WakelockStatsFrameworkEventsIA r2) {
            this(r1);
        }

        private StatsPullCallbackHandler(WakelockStatsFrameworkEvents r1) {
            this.this$0 = r1;
        }

        public int onPullAtom(int atomTag, List<StatsEvent> data) {
            List<StatsEvent> events = pullEvents(atomTag);
            if (events != null) goto L6;
            return 1;
        L6:
            data.addAll(events);
            return 0;
        }

        private List<StatsEvent> pullEvents(int atomTag) {
            switch(atomTag) {
                case 10230: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return this.this$0.pullFrameworkWakelockInfoAtoms();
        }
    }

    private static class WakeLockData {
        public long acquireUptimeMillis;
        public int refCount;

        WakeLockData(long uptimeMillis) {
            this.acquireUptimeMillis = 0;
            this.refCount = 0;
            this.acquireUptimeMillis = uptimeMillis;
        }
    }

    private static class WakeLockKey {
        private int hashCode;
        private int powerManagerWakeLockLevel;
        private String tag;
        private int uid;

        WakeLockKey(int uid, String tag, int powerManagerWakeLockLevel) {
            this.uid = uid;
            this.tag = new String(tag);
            this.powerManagerWakeLockLevel = powerManagerWakeLockLevel;
            this.hashCode = Objects.hash(new Object[]{Integer.valueOf(uid), tag, Integer.valueOf(powerManagerWakeLockLevel)});
        }

        int getUid() {
            return this.uid;
        }

        String getTag() {
            return this.tag;
        }

        int getPowerManagerWakeLockLevel() {
            return this.powerManagerWakeLockLevel;
        }

        void setOverflow() {
            this.tag = WakelockStatsFrameworkEvents.OVERFLOW_TAG;
            this.powerManagerWakeLockLevel = 1;
            this.hashCode = Objects.hash(new Object[]{Integer.valueOf(this.uid), this.tag, Integer.valueOf(this.powerManagerWakeLockLevel)});
        }

        void setHardCap() {
            this.uid = -1;
            this.tag = WakelockStatsFrameworkEvents.HARD_CAP_TAG;
            this.powerManagerWakeLockLevel = 1;
            this.hashCode = Objects.hash(new Object[]{Integer.valueOf(this.uid), this.tag, Integer.valueOf(this.powerManagerWakeLockLevel)});
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L19:
            return false;
        L8:
            if ((o instanceof WakeLockKey) == false) goto L19;
            WakeLockKey that = (WakeLockKey) o;
            if (this.uid != that.uid) goto L18;
            if (this.tag.equals(that.tag) == false) goto L18;
            if (this.powerManagerWakeLockLevel != that.powerManagerWakeLockLevel) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    private static class WakeLockStats {
        public long completedCount;
        public long uptimeMillis;

        /* synthetic */ WakeLockStats(WakelockStatsFrameworkEventsIA r1) {
            this();
        }

        private WakeLockStats() {
            this.uptimeMillis = 0;
            this.completedCount = 0;
        }
    }

    public static /* synthetic */ WakeLockData $r8$lambda$AtV_1LGVyaohwoFf9kkapV7I5IY(long r0, WakeLockKey r2) {
        return lambda$noteStartWakeLock$0(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Fds4fnTXtO1xF-OgWWVuZ3qDVKs, reason: not valid java name */
    public static /* synthetic */ WakeLockStats m7849$r8$lambda$Fds4fnTXtO1xFOgWWVuZ3qDVKs(WakeLockKey r0) {
        return lambda$pullFrameworkWakelockInfoAtoms$4(r0);
    }

    public static /* synthetic */ WakeLockStats $r8$lambda$_eI9M4itj9AElL0QLHvCcZ6S53I(WakeLockKey r0) {
        return lambda$pullFrameworkWakelockInfoAtoms$3(r0);
    }

    public static /* synthetic */ WakeLockStats $r8$lambda$fgzsMdzA2m8ygC8lBUBJcEA8eis(WakeLockKey r0) {
        return lambda$pullFrameworkWakelockInfoAtoms$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$iC66w-mkFRw3OjMek3zncId5-1U, reason: not valid java name */
    public static /* synthetic */ WakeLockStats m7850$r8$lambda$iC66wmkFRw3OjMek3zncId51U(WakeLockKey r0) {
        return lambda$noteStopWakeLock$1(r0);
    }

    public WakelockStatsFrameworkEvents() {
        this.mLock = new Object();
        this.mWakeLockStats = new HashMap();
        this.mOpenWakeLocks = new HashMap();
        this.mStatsPullCallbackHandler = new StatsPullCallbackHandler(this, null);
        this.mIsInitialized = false;
    }

    public void noteStartWakeLock(int uid, String tag, int powerManagerWakeLockLevel, final long eventUptimeMillis) {
        WakeLockKey key = new WakeLockKey(uid, tag, powerManagerWakeLockLevel);
        Object r1 = this.mLock;
        monitor-enter(r1);
        WakeLockData data = this.mOpenWakeLocks.computeIfAbsent(key, new WakelockStatsFrameworkEvents$$ExternalSyntheticLambda3(eventUptimeMillis));     // Catch: Throwable -> L7
        data.refCount++;     // Catch: Throwable -> L7
        this.mOpenWakeLocks.put(key, data);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ WakeLockData lambda$noteStartWakeLock$0(long eventUptimeMillis, WakeLockKey k) {
        return new WakeLockData(eventUptimeMillis);
    }

    public boolean inOverflow() {
        if (this.mWakeLockStats.size() < 500) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean inHardCap() {
        if (this.mWakeLockStats.size() < 1000) goto L5;
        return true;
    L5:
        return false;
    }

    public void noteStopWakeLock(int uid, String tag, int powerManagerWakeLockLevel, long eventUptimeMillis) {
        WakeLockKey key = new WakeLockKey(uid, tag, powerManagerWakeLockLevel);
        Object r1 = this.mLock;
        monitor-enter(r1);
        WakeLockData data = this.mOpenWakeLocks.get(key);     // Catch: Throwable -> L9
        if (data != null) goto L12;
        Log.e(TAG, "WakeLock not found when stopping: " + uid + " " + tag);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        if (data.refCount != 1) goto L23;
        this.mOpenWakeLocks.remove(key);     // Catch: Throwable -> L9
        long wakeLockDur = eventUptimeMillis - data.acquireUptimeMillis;     // Catch: Throwable -> L9
        if (inOverflow() == true) goto L16;
    L22:
        WakeLockStats stats = this.mWakeLockStats.computeIfAbsent(key, new WakelockStatsFrameworkEvents$$ExternalSyntheticLambda4());     // Catch: Throwable -> L9
        stats.uptimeMillis += wakeLockDur;     // Catch: Throwable -> L9
        stats.completedCount++;     // Catch: Throwable -> L9
        this.mWakeLockStats.put(key, stats);     // Catch: Throwable -> L9
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L16:
        if (this.mWakeLockStats.containsKey(key) == true) goto L22;
        key.setOverflow();     // Catch: Throwable -> L9
        if (inHardCap() == false) goto L22;
        if (this.mWakeLockStats.containsKey(key) == true) goto L22;
        key.setHardCap();     // Catch: Throwable -> L9
        goto L22
    L23:
        data.refCount--;     // Catch: Throwable -> L9
        this.mOpenWakeLocks.put(key, data);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ WakeLockStats lambda$noteStopWakeLock$1(WakeLockKey k) {
        return new WakeLockStats(null);
    }

    public List<StatsEvent> pullFrameworkWakelockInfoAtoms() {
        final List<StatsEvent> result = new ArrayList();
        EventLogger logger = new AnonymousClass1(this, result);
        pullFrameworkWakelockInfoAtoms(SystemClock.uptimeMillis(), logger);
        return result;
    }

    public void pullFrameworkWakelockInfoAtoms(long nowMillis, EventLogger logger) {
        HashSet<WakeLockKey> keys = new HashSet();
        HashMap<WakeLockKey, WakeLockStats> openOverflowStats = new HashMap();
        Object r4 = this.mLock;
        monitor-enter(r4);
        keys.addAll(this.mWakeLockStats.keySet());     // Catch: Throwable -> L16
        if (inOverflow() == false) goto L21;
        Iterator<WakeLockKey> r0 = this.mOpenWakeLocks.keySet().iterator();     // Catch: Throwable -> L16
    L8:
        if (r0.hasNext() == false) goto L22;
        WakeLockKey key = r0.next();     // Catch: Throwable -> L16
        if (this.mWakeLockStats.containsKey(key) == true) goto L8;
        WakeLockData data = this.mOpenWakeLocks.get(key);     // Catch: Throwable -> L16
        key.setOverflow();     // Catch: Throwable -> L16
        if (inHardCap() == true) goto L14;
    L18:
        keys.add(key);     // Catch: Throwable -> L16
        WakeLockStats stats = openOverflowStats.computeIfAbsent(key, new WakelockStatsFrameworkEvents$$ExternalSyntheticLambda0());     // Catch: Throwable -> L16
        stats.uptimeMillis += nowMillis - data.acquireUptimeMillis;     // Catch: Throwable -> L16
        openOverflowStats.put(key, stats);     // Catch: Throwable -> L16
        goto L8
    L14:
        if (this.mWakeLockStats.containsKey(key) == true) goto L18;
        key.setHardCap();     // Catch: Throwable -> L16
    L22:
        Iterator<WakeLockKey> r1 = keys.iterator();     // Catch: Throwable -> L16
    L24:
        if (r1.hasNext() == false) goto L29;
        WakeLockKey key2 = r1.next();     // Catch: Throwable -> L16
        long openWakeLockUptime = 0;
        WakeLockData data2 = this.mOpenWakeLocks.get(key2);     // Catch: Throwable -> L16
        if (data2 == null) goto L28;
        openWakeLockUptime = nowMillis - data2.acquireUptimeMillis;     // Catch: Throwable -> L16
    L28:
        WakeLockStats stats2 = this.mWakeLockStats.computeIfAbsent(key2, new WakelockStatsFrameworkEvents$$ExternalSyntheticLambda1());     // Catch: Throwable -> L16
        WakeLockStats extraTime = openOverflowStats.computeIfAbsent(key2, new WakelockStatsFrameworkEvents$$ExternalSyntheticLambda2());     // Catch: Throwable -> L16
        long totalUpdate = (stats2.uptimeMillis + openWakeLockUptime) + extraTime.uptimeMillis;     // Catch: Throwable -> L16
        long totalCount = stats2.completedCount + extraTime.completedCount;     // Catch: Throwable -> L16
        logger.logResult(key2.getUid(), key2.getTag(), key2.getPowerManagerWakeLockLevel(), totalUpdate, totalCount);     // Catch: Throwable -> L16
        goto L24
    L29:
        monitor-exit(r4);     // Catch: Throwable -> L16
        return;
    L21:
        keys.addAll(this.mOpenWakeLocks.keySet());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ WakeLockStats lambda$pullFrameworkWakelockInfoAtoms$2(WakeLockKey k) {
        return new WakeLockStats(null);
    }

    private static /* synthetic */ WakeLockStats lambda$pullFrameworkWakelockInfoAtoms$3(WakeLockKey k) {
        return new WakeLockStats(null);
    }

    private static /* synthetic */ WakeLockStats lambda$pullFrameworkWakelockInfoAtoms$4(WakeLockKey k) {
        return new WakeLockStats(null);
    }

    public void initialize(Context context) {
        if (this.mIsInitialized == false) goto L5;
        return;
    L5:
        StatsManager statsManager = (StatsManager) context.getSystemService(StatsManager.class);
        if (statsManager != null) goto L8;
        Log.e(TAG, "Error retrieving StatsManager. Cannot initialize BatteryStatsPulledMetrics.");
        return;
    L8:
        Log.d(TAG, "Registering callback with StatsManager");
        statsManager.setPullAtomCallback(FrameworkStatsLog.FRAMEWORK_WAKELOCK_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsPullCallbackHandler);
        this.mIsInitialized = true;
    }
}
