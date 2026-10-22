package com.android.server.am.compaction;

import android.util.Slog;
import com.android.server.am.CachedAppOptimizer;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class CompactionStatsManager {
    public static final int COMPACT_THROTTLE_REASON_DELTA_RSS = 4;
    public static final int COMPACT_THROTTLE_REASON_NO_PID = 0;
    public static final int COMPACT_THROTTLE_REASON_OOM_ADJ = 1;
    public static final int COMPACT_THROTTLE_REASON_PROC_STATE = 3;
    public static final int COMPACT_THROTTLE_REASON_TIME_TOO_SOON = 2;
    static final int LAST_COMPACTED_ANY_PROCESS_STATS_HISTORY_SIZE = 20;
    static final int LAST_COMPACTION_FOR_PROCESS_STATS_SIZE = 256;
    private static String TAG;
    private static CompactionStatsManager sInstance;
    LinkedList<SingleCompactionStats> mCompactionStatsHistory;
    LinkedHashMap<Integer, SingleCompactionStats> mLastCompactionStats;
    private final LinkedHashMap<String, AggregatedProcessCompactionStats> mPerProcessCompactStats;
    private final EnumMap<CachedAppOptimizer.CompactSource, AggregatedSourceCompactionStats> mPerSourceCompactStats;
    private long mSystemCompactionsPerformed;
    private long mSystemTotalMemFreed;
    private long mTotalCompactionDowngrades;
    private EnumMap<CachedAppOptimizer.CancelCompactReason, Integer> mTotalCompactionsCancelled;

    /* JADX INFO: renamed from: com.android.server.am.compaction.CompactionStatsManager$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$am$CachedAppOptimizer$CompactProfile = null;

        static {
            $SwitchMap$com$android$server$am$CachedAppOptimizer$CompactProfile = new int[CachedAppOptimizer.CompactProfile.values().length];
            $SwitchMap$com$android$server$am$CachedAppOptimizer$CompactProfile[CachedAppOptimizer.CompactProfile.SOME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L12:
            $SwitchMap$com$android$server$am$CachedAppOptimizer$CompactProfile[CachedAppOptimizer.CompactProfile.FULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            return;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompactThrottleReason {
    }

    public CompactionStatsManager() {
        this.mPerProcessCompactStats = new LinkedHashMap(256);
        this.mPerSourceCompactStats = new EnumMap(CachedAppOptimizer.CompactSource.class);
        this.mTotalCompactionsCancelled = new EnumMap(CachedAppOptimizer.CancelCompactReason.class);
        this.mLastCompactionStats = new AnonymousClass1(this);
        this.mCompactionStatsHistory = new AnonymousClass2(this);
    }

    static {
        TAG = "CompactionStatsManager";
    }

    public static CompactionStatsManager getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new CompactionStatsManager();
    L6:
        return sInstance;
    }

    public SingleCompactionStats getLastCompactionStats(int pid) {
        return this.mLastCompactionStats.get(Integer.valueOf(pid));
    }

    public LinkedHashMap<Integer, SingleCompactionStats> getLastCompactionStats() {
        return this.mLastCompactionStats;
    }

    public void reinit() {
        sInstance = new CompactionStatsManager();
    }

    public void logCompactionRequested(CachedAppOptimizer.CompactSource source, CachedAppOptimizer.CompactProfile compactProfile, String processName) {
        AggregatedSourceCompactionStats perSourceStats = getPerSourceAggregatedCompactStat(source);
        AggregatedCompactionStats perProcStats = getPerProcessAggregatedCompactStat(processName);
        switch(AnonymousClass3.$SwitchMap$com$android$server$am$CachedAppOptimizer$CompactProfile[compactProfile.ordinal()]) {
            case 1: goto L6;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Stats cannot be logged for compaction type." + compactProfile);
        return;
    L5:
        perProcStats.mFullCompactRequested++;
        perSourceStats.mFullCompactRequested++;
        return;
    L6:
        perProcStats.mSomeCompactRequested++;
        perSourceStats.mSomeCompactRequested++;
    }

    public void logCompactionThrottled(int reason, CachedAppOptimizer.CompactSource source, String processName) {
        AggregatedSourceCompactionStats perSourceStats = getPerSourceAggregatedCompactStat(source);
        AggregatedProcessCompactionStats perProcessStats = getPerProcessAggregatedCompactStat(processName);
        switch(reason) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            default: goto L15;
        };
    L5:
        perProcessStats.mProcCompactionsRSSThrottled++;
        perSourceStats.mProcCompactionsRSSThrottled++;
        return;
    L6:
        perProcessStats.mProcCompactionsMiscThrottled++;
        perSourceStats.mProcCompactionsMiscThrottled++;
        return;
    L7:
        perProcessStats.mProcCompactionsTimeThrottled++;
        perSourceStats.mProcCompactionsTimeThrottled++;
        return;
    L8:
        perProcessStats.mProcCompactionsOomAdjThrottled++;
        perSourceStats.mProcCompactionsOomAdjThrottled++;
        return;
    L9:
        perSourceStats.mProcCompactionsNoPidThrottled++;
        perProcessStats.mProcCompactionsNoPidThrottled++;
        return;
    }

    public void logSomeCompactionPerformed(CachedAppOptimizer.CompactSource source, String processName) {
        AggregatedSourceCompactionStats perSourceStats = getPerSourceAggregatedCompactStat(source);
        AggregatedProcessCompactionStats perProcessStats = getPerProcessAggregatedCompactStat(processName);
        perSourceStats.mSomeCompactPerformed++;
        perProcessStats.mSomeCompactPerformed++;
    }

    public void logFullCompactionPerformed(CachedAppOptimizer.CompactSource source, String processName, long anonRssSavings, long zramConsumed, long memFreed, long origAnonRss, long totalCpuTimeMillis, long[] rssAfterCompact, int procState, int newOomAdj, int oomAdjReason, int uid, int pid, boolean logFieldMetric) {
        AggregatedSourceCompactionStats perSourceStats = getPerSourceAggregatedCompactStat(source);
        AggregatedProcessCompactionStats perProcessStats = getPerProcessAggregatedCompactStat(processName);
        perSourceStats.mFullCompactPerformed++;
        perProcessStats.mFullCompactPerformed++;
        if (anonRssSavings <= 0) goto L5;
        long anonRssSavings2 = anonRssSavings;
    L7:
        if (zramConsumed <= 0) goto L9;
        long zramConsumed2 = zramConsumed;
    L11:
        if (memFreed <= 0) goto L13;
        long memFreed2 = memFreed;
    L14:
        perProcessStats.addMemStats(anonRssSavings2, zramConsumed2, memFreed2, origAnonRss, totalCpuTimeMillis);
        perSourceStats.addMemStats(anonRssSavings2, zramConsumed2, memFreed2, origAnonRss, totalCpuTimeMillis);
        SingleCompactionStats memStats = new SingleCompactionStats(rssAfterCompact, source, processName, anonRssSavings2, zramConsumed2, memFreed2, origAnonRss, totalCpuTimeMillis, procState, newOomAdj, oomAdjReason, uid);
        this.mLastCompactionStats.remove(Integer.valueOf(pid));
        this.mLastCompactionStats.put(Integer.valueOf(pid), memStats);
        this.mCompactionStatsHistory.add(memStats);
        if (logFieldMetric == true) goto L18;
        memStats.sendStat();
        return;
    L18:
        return;
    L13:
        memFreed2 = 0;
        goto L14
    L9:
        zramConsumed2 = 0;
        goto L11
    L5:
        anonRssSavings2 = 0;
        goto L7
    }

    public void logCompactionDowngrade() {
        this.mTotalCompactionDowngrades++;
    }

    public void logSystemCompactionPerformed(long memFreed) {
        this.mSystemCompactionsPerformed++;
        this.mSystemTotalMemFreed += memFreed;
    }

    public void logCompactionCancelled(CachedAppOptimizer.CancelCompactReason cancelReason) {
        if (this.mTotalCompactionsCancelled.containsKey(cancelReason) == false) goto L5;
        int count = this.mTotalCompactionsCancelled.get(cancelReason).intValue();
        this.mTotalCompactionsCancelled.put(cancelReason, Integer.valueOf(count + 1));
        return;
    L5:
        this.mTotalCompactionsCancelled.put(cancelReason, 1);
    }

    private AggregatedProcessCompactionStats getPerProcessAggregatedCompactStat(String processName) {
        if (processName != null) goto L4;
        processName = "";
    L4:
        AggregatedProcessCompactionStats stats = this.mPerProcessCompactStats.get(processName);
        if (stats != null) goto L8;
        AggregatedProcessCompactionStats stats2 = new AggregatedProcessCompactionStats(processName);
        this.mPerProcessCompactStats.put(processName, stats2);
        return stats2;
    L8:
        return stats;
    }

    private AggregatedSourceCompactionStats getPerSourceAggregatedCompactStat(CachedAppOptimizer.CompactSource source) {
        AggregatedSourceCompactionStats stats = this.mPerSourceCompactStats.get(source);
        if (stats != null) goto L6;
        AggregatedSourceCompactionStats stats2 = new AggregatedSourceCompactionStats(source);
        this.mPerSourceCompactStats.put(source, stats2);
        return stats2;
    L6:
        return stats;
    }

    @NeverCompile
    public void dump(PrintWriter pw) {
        pw.println(" Per-Process Compaction Stats");
        long totalCompactPerformedSome = 0;
        long totalCompactPerformedFull = 0;
        Iterator<AggregatedProcessCompactionStats> r4 = this.mPerProcessCompactStats.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        AggregatedProcessCompactionStats stats = r4.next();
        pw.println("-----" + stats.mProcessName + "-----");
        totalCompactPerformedSome = totalCompactPerformedSome + stats.mSomeCompactPerformed;
        totalCompactPerformedFull = totalCompactPerformedFull + stats.mFullCompactPerformed;
        stats.dump(pw);
        pw.println();
        goto L4
    L6:
        pw.println();
        pw.println(" Per-Source Compaction Stats");
        Iterator<AggregatedSourceCompactionStats> r5 = this.mPerSourceCompactStats.values().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        AggregatedSourceCompactionStats stats2 = r5.next();
        pw.println("-----" + stats2.mSourceType + "-----");
        stats2.dump(pw);
        pw.println();
        goto L8
    L10:
        pw.println();
        pw.println("Total Compactions Performed by profile: " + totalCompactPerformedSome + " some, " + totalCompactPerformedFull + " full");
        StringBuilder r6 = new StringBuilder();
        r6.append("Total compactions downgraded: ");
        r6.append(this.mTotalCompactionDowngrades);
        pw.println(r6.toString());
        pw.println("Total compactions cancelled by reason: ");
        Iterator r7 = this.mTotalCompactionsCancelled.keySet().iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        CachedAppOptimizer.CancelCompactReason reason = (CachedAppOptimizer.CancelCompactReason) r7.next();
        pw.println("    " + reason + ": " + this.mTotalCompactionsCancelled.get(reason));
        goto L12
    L14:
        pw.println();
        pw.println(" System Compaction Memory Stats");
        pw.println("    Compactions Performed: " + this.mSystemCompactionsPerformed);
        pw.println("    Total Memory Freed (KB): " + this.mSystemTotalMemFreed);
        if (this.mSystemCompactionsPerformed <= 0) goto L17;
        double avgKBsPerSystemCompact = this.mSystemTotalMemFreed / this.mSystemCompactionsPerformed;
    L18:
        pw.println("    Avg Mem Freed per Compact (KB): " + avgKBsPerSystemCompact);
        pw.println();
        pw.println("  Tracking last compaction stats for " + this.mLastCompactionStats.size() + " processes.");
        pw.println("Last Compaction per process stats:");
        pw.println("    (ProcessName,Source,DeltaAnonRssKBs,ZramConsumedKBs,AnonMemFreedKBs,SwapEfficiency,CompactEfficiency,CompactCost(ms/MB),procState,oomAdj,oomAdjReason)");
        Iterator<Map.Entry<Integer, SingleCompactionStats>> r8 = this.mLastCompactionStats.entrySet().iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        Map.Entry<Integer, SingleCompactionStats> entry = r8.next();
        SingleCompactionStats stats3 = entry.getValue();
        stats3.dump(pw);
        goto L20
    L22:
        pw.println();
        pw.println("Last 20 Compactions Stats:");
        pw.println("    (ProcessName,Source,DeltaAnonRssKBs,ZramConsumedKBs,AnonMemFreedKBs,SwapEfficiency,CompactEfficiency,CompactCost(ms/MB),procState,oomAdj,oomAdjReason)");
        Iterator<SingleCompactionStats> r9 = this.mCompactionStatsHistory.iterator();
    L24:
        if (r9.hasNext() == false) goto L26;
        SingleCompactionStats stats4 = r9.next();
        stats4.dump(pw);
        goto L24
    L26:
        return;
    L17:
        avgKBsPerSystemCompact = 0.0d;
        goto L18
    }
}
