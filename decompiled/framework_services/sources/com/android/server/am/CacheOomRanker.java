package com.android.server.am;

import android.os.Process;
import android.os.SystemClock;
import android.provider.DeviceConfig;
import android.util.Slog;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class CacheOomRanker {
    private static final Comparator<RankedProcessRecord> CACHE_USE_COMPARATOR = null;
    static final float DEFAULT_OOM_RE_RANKING_LRU_WEIGHT = 0.35f;
    static final int DEFAULT_OOM_RE_RANKING_NUMBER_TO_RE_RANK = 8;
    static final float DEFAULT_OOM_RE_RANKING_RSS_WEIGHT = 0.15f;
    static final float DEFAULT_OOM_RE_RANKING_USES_WEIGHT = 0.5f;
    static final int DEFAULT_PRESERVE_TOP_N_APPS = 3;
    static final long DEFAULT_RSS_UPDATE_RATE_MS = 10000;
    static final boolean DEFAULT_USE_FREQUENT_RSS = true;
    private static final boolean DEFAULT_USE_OOM_RE_RANKING = false;
    static final String KEY_OOM_RE_RANKING_LRU_WEIGHT = "oom_re_ranking_lru_weight";
    static final String KEY_OOM_RE_RANKING_NUMBER_TO_RE_RANK = "oom_re_ranking_number_to_re_rank";
    static final String KEY_OOM_RE_RANKING_PRESERVE_TOP_N_APPS = "oom_re_ranking_preserve_top_n_apps";
    static final String KEY_OOM_RE_RANKING_RSS_UPDATE_RATE_MS = "oom_re_ranking_rss_update_rate_ms";
    static final String KEY_OOM_RE_RANKING_RSS_WEIGHT = "oom_re_ranking_rss_weight";
    static final String KEY_OOM_RE_RANKING_USES_WEIGHT = "oom_re_ranking_uses_weight";
    static final String KEY_OOM_RE_RANKING_USE_FREQUENT_RSS = "oom_re_ranking_rss_use_frequent_rss";
    static final String KEY_USE_OOM_RE_RANKING = "use_oom_re_ranking";
    private static final Comparator<RankedProcessRecord> LAST_ACTIVITY_TIME_COMPARATOR = null;
    private static final Comparator<RankedProcessRecord> LAST_RSS_COMPARATOR = null;
    private static final Comparator<RankedProcessRecord> RSS_COMPARATOR = null;
    private static final Comparator<RankedProcessRecord> SCORED_PROCESS_RECORD_COMPARATOR = null;
    private int[] mLruPositions;
    float mLruWeight;
    private final DeviceConfig.OnPropertiesChangedListener mOnFlagsChangedListener;
    private final Object mPhenotypeFlagLock;
    int mPreserveTopNApps;
    private final ActivityManagerGlobalLock mProcLock;
    private final ProcessDependencies mProcessDependencies;
    private final Object mProfilerLock;
    long mRssUpdateRateMs;
    float mRssWeight;
    private RankedProcessRecord[] mScoredProcessRecords;
    private final ActivityManagerService mService;
    boolean mUseFrequentRss;
    private boolean mUseOomReRanking;
    float mUsesWeight;

    private static class CacheUseComparator implements Comparator<RankedProcessRecord> {
        /* synthetic */ CacheUseComparator(CacheOomRankerIA r1) {
            this();
        }

        private CacheUseComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(RankedProcessRecord r1, RankedProcessRecord r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(RankedProcessRecord o1, RankedProcessRecord o2) {
            return Long.compare(o1.proc.mState.getCacheOomRankerUseCount(), o2.proc.mState.getCacheOomRankerUseCount());
        }
    }

    private static class LastActivityTimeComparator implements Comparator<RankedProcessRecord> {
        /* synthetic */ LastActivityTimeComparator(CacheOomRankerIA r1) {
            this();
        }

        private LastActivityTimeComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(RankedProcessRecord r1, RankedProcessRecord r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(RankedProcessRecord o1, RankedProcessRecord o2) {
            return Long.compare(o1.proc.getLastActivityTime(), o2.proc.getLastActivityTime());
        }
    }

    private static class LastRssComparator implements Comparator<RankedProcessRecord> {
        /* synthetic */ LastRssComparator(CacheOomRankerIA r1) {
            this();
        }

        private LastRssComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(RankedProcessRecord r1, RankedProcessRecord r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(RankedProcessRecord o1, RankedProcessRecord o2) {
            return Long.compare(o2.proc.mProfile.getLastRss(), o1.proc.mProfile.getLastRss());
        }
    }

    interface ProcessDependencies {
        long[] getRss(int r1);
    }

    private static class ProcessDependenciesImpl implements ProcessDependencies {
        /* synthetic */ ProcessDependenciesImpl(CacheOomRankerIA r1) {
            this();
        }

        private ProcessDependenciesImpl() {
        }

        @Override // com.android.server.am.CacheOomRanker.ProcessDependencies
        public long[] getRss(int pid) {
            return Process.getRss(pid);
        }
    }

    private static class RankedProcessRecord {
        public ProcessRecord proc;
        public float score;

        /* synthetic */ RankedProcessRecord(CacheOomRankerIA r1) {
            this();
        }

        private RankedProcessRecord() {
        }
    }

    private static class RssComparator implements Comparator<RankedProcessRecord> {
        /* synthetic */ RssComparator(CacheOomRankerIA r1) {
            this();
        }

        private RssComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(RankedProcessRecord r1, RankedProcessRecord r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(RankedProcessRecord o1, RankedProcessRecord o2) {
            return Long.compare(o2.proc.mState.getCacheOomRankerRss(), o1.proc.mState.getCacheOomRankerRss());
        }
    }

    private static class ScoreComparator implements Comparator<RankedProcessRecord> {
        /* synthetic */ ScoreComparator(CacheOomRankerIA r1) {
            this();
        }

        private ScoreComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(RankedProcessRecord r1, RankedProcessRecord r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(RankedProcessRecord o1, RankedProcessRecord o2) {
            return Float.compare(o1.score, o2.score);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPhenotypeFlagLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1444$$Nest$fgetmPhenotypeFlagLock(CacheOomRanker r0) {
        return r0.mPhenotypeFlagLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateLruWeight, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1445$$Nest$mupdateLruWeight(CacheOomRanker r0) {
        r0.updateLruWeight();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNumberToReRank, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1446$$Nest$mupdateNumberToReRank(CacheOomRanker r0) {
        r0.updateNumberToReRank();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePreserveTopNApps, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1447$$Nest$mupdatePreserveTopNApps(CacheOomRanker r0) {
        r0.updatePreserveTopNApps();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRssUpdateRateMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1448$$Nest$mupdateRssUpdateRateMs(CacheOomRanker r0) {
        r0.updateRssUpdateRateMs();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRssWeight, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1449$$Nest$mupdateRssWeight(CacheOomRanker r0) {
        r0.updateRssWeight();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateUseFrequentRss, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1450$$Nest$mupdateUseFrequentRss(CacheOomRanker r0) {
        r0.updateUseFrequentRss();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateUseOomReranking, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1451$$Nest$mupdateUseOomReranking(CacheOomRanker r0) {
        r0.updateUseOomReranking();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateUsesWeight, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1452$$Nest$mupdateUsesWeight(CacheOomRanker r0) {
        r0.updateUsesWeight();
    }

    static {
        CacheOomRankerIA r1 = null;
        SCORED_PROCESS_RECORD_COMPARATOR = new ScoreComparator(r1);
        CACHE_USE_COMPARATOR = new CacheUseComparator(r1);
        RSS_COMPARATOR = new RssComparator(r1);
        LAST_RSS_COMPARATOR = new LastRssComparator(r1);
        LAST_ACTIVITY_TIME_COMPARATOR = new LastActivityTimeComparator(r1);
    }

    CacheOomRanker(ActivityManagerService service) {
        this(service, new ProcessDependenciesImpl(null));
    }

    CacheOomRanker(ActivityManagerService service, ProcessDependencies processDependencies) {
        this.mPhenotypeFlagLock = new Object();
        this.mUseOomReRanking = false;
        this.mPreserveTopNApps = 3;
        this.mUseFrequentRss = true;
        this.mRssUpdateRateMs = 10000;
        this.mLruWeight = DEFAULT_OOM_RE_RANKING_LRU_WEIGHT;
        this.mUsesWeight = DEFAULT_OOM_RE_RANKING_USES_WEIGHT;
        this.mRssWeight = DEFAULT_OOM_RE_RANKING_RSS_WEIGHT;
        this.mOnFlagsChangedListener = new AnonymousClass1(this);
        this.mService = service;
        this.mProcLock = service.mProcLock;
        this.mProfilerLock = service.mAppProfiler.mProfilerLock;
        this.mProcessDependencies = processDependencies;
    }

    public void init(Executor executor) {
        DeviceConfig.addOnPropertiesChangedListener("activity_manager", executor, this.mOnFlagsChangedListener);
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
        updateUseOomReranking();     // Catch: Throwable -> L7
        updateNumberToReRank();     // Catch: Throwable -> L7
        updateLruWeight();     // Catch: Throwable -> L7
        updateUsesWeight();     // Catch: Throwable -> L7
        updateRssWeight();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean useOomReranking() {
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
        boolean r1 = this.mUseOomReRanking;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateUseOomReranking() {
        this.mUseOomReRanking = DeviceConfig.getBoolean("activity_manager", KEY_USE_OOM_RE_RANKING, false);
    }

    private void updateNumberToReRank() {
        int previousNumberToReRank = getNumberToReRank();
        int numberToReRank = DeviceConfig.getInt("activity_manager", KEY_OOM_RE_RANKING_NUMBER_TO_RE_RANK, 8);
        if (previousNumberToReRank == numberToReRank) goto L11;
        this.mScoredProcessRecords = new RankedProcessRecord[numberToReRank];
        int i = 0;
    L6:
        if (i >= this.mScoredProcessRecords.length) goto L8;
        this.mScoredProcessRecords[i] = new RankedProcessRecord(null);
        i = i + 1;
        goto L6
    L8:
        this.mLruPositions = new int[numberToReRank];
        return;
    }

    int getNumberToReRank() {
        if (this.mScoredProcessRecords != null) goto L6;
        return 0;
    L6:
        return this.mScoredProcessRecords.length;
    }

    private void updatePreserveTopNApps() {
        int preserveTopNApps = DeviceConfig.getInt("activity_manager", KEY_OOM_RE_RANKING_PRESERVE_TOP_N_APPS, 3);
        if (preserveTopNApps >= 0) goto L5;
        Slog.w("OomAdjuster", "Found negative value for preserveTopNApps, setting to default: " + preserveTopNApps);
        preserveTopNApps = 3;
    L5:
        this.mPreserveTopNApps = preserveTopNApps;
    }

    private void updateRssUpdateRateMs() {
        this.mRssUpdateRateMs = DeviceConfig.getLong("activity_manager", KEY_OOM_RE_RANKING_RSS_UPDATE_RATE_MS, 10000);
    }

    private void updateUseFrequentRss() {
        this.mUseFrequentRss = DeviceConfig.getBoolean("activity_manager", KEY_OOM_RE_RANKING_USE_FREQUENT_RSS, true);
    }

    private void updateLruWeight() {
        this.mLruWeight = DeviceConfig.getFloat("activity_manager", KEY_OOM_RE_RANKING_LRU_WEIGHT, DEFAULT_OOM_RE_RANKING_LRU_WEIGHT);
    }

    private void updateUsesWeight() {
        this.mUsesWeight = DeviceConfig.getFloat("activity_manager", KEY_OOM_RE_RANKING_USES_WEIGHT, DEFAULT_OOM_RE_RANKING_USES_WEIGHT);
    }

    private void updateRssWeight() {
        this.mRssWeight = DeviceConfig.getFloat("activity_manager", KEY_OOM_RE_RANKING_RSS_WEIGHT, DEFAULT_OOM_RE_RANKING_RSS_WEIGHT);
    }

    void reRankLruCachedAppsLSP(ArrayList<ProcessRecord> lruList, int lruProcessServiceStart) {
        Object r4 = this.mPhenotypeFlagLock;
        monitor-enter(r4);
        float lruWeight = this.mLruWeight;     // Catch: Throwable -> L85
        float usesWeight = this.mUsesWeight;     // Catch: Throwable -> L85
        float rssWeight = this.mRssWeight;     // Catch: Throwable -> L85
        int preserveTopNApps = this.mPreserveTopNApps;     // Catch: Throwable -> L85
        boolean useFrequentRss = this.mUseFrequentRss;     // Catch: Throwable -> L85
        long rssUpdateRateMs = this.mRssUpdateRateMs;     // Catch: Throwable -> L85
        int[] lruPositions = this.mLruPositions;     // Catch: Throwable -> L85
        RankedProcessRecord[] scoredProcessRecords = this.mScoredProcessRecords;     // Catch: Throwable -> L85
        monitor-exit(r4);     // Catch: Throwable -> L85
        if (lruPositions == null) goto L84;
        if (scoredProcessRecords == null) goto L115;
        int numProcessesEvaluated = 0;
        int numProcessesReRanked = 0;
    L10:
        if (numProcessesEvaluated >= lruProcessServiceStart) goto L18;
        if (numProcessesReRanked >= scoredProcessRecords.length) goto L18;
        ProcessRecord process = lruList.get(numProcessesEvaluated);
        if (appCanBeReRanked(process) == false) goto L16;
        scoredProcessRecords[numProcessesReRanked].proc = process;
        int numProcessesEvaluated2 = numProcessesEvaluated;
        scoredProcessRecords[numProcessesReRanked].score = 0.0f;
        lruPositions[numProcessesReRanked] = numProcessesEvaluated2;
        numProcessesReRanked = numProcessesReRanked + 1;
    L17:
        numProcessesEvaluated = numProcessesEvaluated2 + 1;
        goto L10
    L16:
        numProcessesEvaluated2 = numProcessesEvaluated;
    L18:
        int numProcessesNotReRanked = 0;
        int numProcessesEvaluated3 = numProcessesEvaluated;
    L19:
        if (numProcessesEvaluated3 >= lruProcessServiceStart) goto L25;
        if (numProcessesNotReRanked >= preserveTopNApps) goto L25;
        if (appCanBeReRanked(lruList.get(numProcessesEvaluated3)) == false) goto L24;
        numProcessesNotReRanked = numProcessesNotReRanked + 1;
    L24:
        numProcessesEvaluated3 = numProcessesEvaluated3 + 1;
    L25:
        if (numProcessesNotReRanked >= preserveTopNApps) goto L29;
        numProcessesReRanked = numProcessesReRanked - (preserveTopNApps - numProcessesNotReRanked);
        if (numProcessesReRanked >= 0) goto L29;
        numProcessesReRanked = 0;
    L29:
        if (useFrequentRss == false) goto L48;
        int r17 = 0;
        long nowMs = SystemClock.elapsedRealtime();
        int i = 0;
    L31:
        if (i >= numProcessesReRanked) goto L47;
        int i2 = i;
        RankedProcessRecord scoredProcessRecord = scoredProcessRecords[i2];
        int preserveTopNApps2 = preserveTopNApps;
        long sinceUpdateMs = nowMs - scoredProcessRecord.proc.mState.getCacheOomRankerRssTimeMs();
        if (scoredProcessRecord.proc.mState.getCacheOomRankerRss() != 0) goto L35;
    L37:
        long[] rss = this.mProcessDependencies.getRss(scoredProcessRecord.proc.getPid());
        if (rss == null) goto L45;
        if (rss.length == 0) goto L45;
        scoredProcessRecord.proc.mState.setCacheOomRankerRss(rss[0], nowMs);
        scoredProcessRecord.proc.mProfile.setLastRss(rss[0]);
    L43:
        i = i2 + 1;
        preserveTopNApps = preserveTopNApps2;
        useFrequentRss = useFrequentRss;
        rssUpdateRateMs = rssUpdateRateMs;
        lruPositions = lruPositions;
    L45:
        Slog.e("OomAdjuster", "Process.getRss returned bad value, not re-ranking: " + Arrays.toString(rss));
        return;
    L35:
        if (sinceUpdateMs >= rssUpdateRateMs) goto L37;
    L47:
        boolean useFrequentRss2 = useFrequentRss;
        int[] lruPositions2 = lruPositions;
        CacheOomRanker r8 = this;
    L50:
        if (lruWeight <= 0.0f) goto L53;
        Arrays.sort(scoredProcessRecords, r17, numProcessesReRanked, LAST_ACTIVITY_TIME_COMPARATOR);
        addToScore(scoredProcessRecords, lruWeight);
    L53:
        if (rssWeight <= 0.0f) goto L65;
        if (useFrequentRss2 == false) goto L56;
        Arrays.sort(scoredProcessRecords, 0, numProcessesReRanked, RSS_COMPARATOR);
    L60:
        addToScore(scoredProcessRecords, rssWeight);
        goto L65
    L56:
        Object r1 = r8.mService.mAppProfiler.mProfilerLock;
        monitor-enter(r1);
        Arrays.sort(scoredProcessRecords, 0, numProcessesReRanked, LAST_RSS_COMPARATOR);     // Catch: Throwable -> L61
        monitor-exit(r1);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;
    L65:
        if (usesWeight <= 0.0f) goto L67;
        int r2 = 0;
        Arrays.sort(scoredProcessRecords, 0, numProcessesReRanked, CACHE_USE_COMPARATOR);
        addToScore(scoredProcessRecords, usesWeight);
    L68:
        Arrays.sort(scoredProcessRecords, r2, numProcessesReRanked, SCORED_PROCESS_RECORD_COMPARATOR);
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L78;
        boolean printedHeader = false;
        int i3 = 0;
    L71:
        if (i3 >= numProcessesReRanked) goto L78;
        if (scoredProcessRecords[i3].proc.getPid() == lruList.get(lruPositions2[i3]).getPid()) goto L77;
        if (printedHeader == true) goto L76;
        Slog.i("OomAdjuster", "reRankLruCachedApps");
        printedHeader = true;
    L76:
        Slog.i("OomAdjuster", "  newPos=" + lruPositions2[i3] + " " + scoredProcessRecords[i3].proc);
    L77:
        i3 = i3 + 1;
    L78:
        int i4 = 0;
    L79:
        if (i4 >= numProcessesReRanked) goto L82;
        lruList.set(lruPositions2[i4], scoredProcessRecords[i4].proc);
        scoredProcessRecords[i4].proc = null;
        i4 = i4 + 1;
        goto L79
    L82:
        return;
    L67:
        r2 = 0;
        goto L68
    L48:
        useFrequentRss2 = useFrequentRss;
        lruPositions2 = lruPositions;
        r17 = 0;
        r8 = this;
        goto L50
    L115:
        return;
    L84:
        return;
    L85:
        th = th;
    L91:
        throw th;
    L89:
        th = th;
        goto L91
    }

    private static boolean appCanBeReRanked(ProcessRecord process) {
        if (process.isKilledByAm() == false) goto L5;
    L9:
        return false;
    L5:
        if (process.getThread() == null) goto L9;
        if (process.mState.getCurAdj() < 1001) goto L9;
        return true;
    }

    private static void addToScore(RankedProcessRecord[] scores, float weight) {
        int i = 1;
    L4:
        if (i >= scores.length) goto L7;
        scores[i].score += i * weight;
        i = i + 1;
        goto L4
    }

    void dump(PrintWriter pw) {
        pw.println("CacheOomRanker settings");
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
        pw.println("  use_oom_re_ranking=" + this.mUseOomReRanking);     // Catch: Throwable -> L7
        pw.println("  oom_re_ranking_number_to_re_rank=" + getNumberToReRank());     // Catch: Throwable -> L7
        pw.println("  oom_re_ranking_lru_weight=" + this.mLruWeight);     // Catch: Throwable -> L7
        pw.println("  oom_re_ranking_uses_weight=" + this.mUsesWeight);     // Catch: Throwable -> L7
        pw.println("  oom_re_ranking_rss_weight=" + this.mRssWeight);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
