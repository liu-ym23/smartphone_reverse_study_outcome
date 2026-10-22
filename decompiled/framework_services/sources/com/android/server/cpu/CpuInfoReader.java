package com.android.server.cpu;

import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.LongSparseLongArray;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.server.utils.Slogf;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class CpuInfoReader {
    private static final String AFFECTED_CPUS_FILE = "affected_cpus";
    private static final String CPUFREQ_DIR_PATH = "/sys/devices/system/cpu/cpufreq";
    private static final String CPUSET_BACKGROUND_DIR = "background";
    private static final String CPUSET_DIR_PATH = "/dev/cpuset";
    private static final String CPUSET_TOP_APP_DIR = "top-app";
    private static final String CPUS_FILE = "cpus";
    private static final String CUR_SCALING_FREQ_FILE = "scaling_cur_freq";
    static final int FLAG_CPUSET_CATEGORY_BACKGROUND = 2;
    static final int FLAG_CPUSET_CATEGORY_TOP_APP = 1;
    private static final String MAX_SCALING_FREQ_FILE = "scaling_max_freq";
    private static final long MILLIS_PER_CLOCK_TICK = 0;
    private static final long MIN_READ_INTERVAL_MILLISECONDS = 500;
    private static final String POLICY_DIR_PREFIX = "policy";
    private static final String PROC_STAT_FILE_PATH = "/proc/stat";
    private static final Pattern PROC_STAT_PATTERN = null;
    private static final String RELATED_CPUS_FILE = "related_cpus";
    private static final String TIME_IN_STATE_FILE = "stats/time_in_state";
    private static final Pattern TIME_IN_STATE_PATTERN = null;
    private File mCpuFreqDir;
    private final SparseArray<File> mCpuFreqPolicyDirsById;
    private final SparseIntArray mCpusetCategoriesByCpus;
    private File mCpusetDir;
    private SparseArray<CpuUsageStats> mCumulativeCpuUsageStats;
    private int mCurrentBackgroundCPUMask;
    private int mCurrentTopCPUMask;
    private boolean mHasTimeInStateFile;
    private boolean mIsEnabled;
    private SparseArray<CpuInfo> mLastReadCpuInfos;
    private long mLastReadUptimeMillis;
    private final Object mLock;
    private final long mMinReadIntervalMillis;
    private File mProcStatFile;
    private final AtomicBoolean mShouldReadCpusetCategories;
    private final SparseArray<StaticPolicyInfo> mStaticPolicyInfoById;
    private final SparseArray<LongSparseLongArray> mTimeInStateByPolicyId;

    public static final class CpuInfo {
        public static final long MISSING_FREQUENCY = 0;
        public final long avgTimeInStateCpuFreqKHz;
        public final int cpuCore;
        public final int cpusetCategories;
        public final long curCpuFreqKHz;
        public final boolean isOnline;
        public final CpuUsageStats latestCpuUsageStats;
        private long mNormalizedAvailableCpuFreqKHz;
        public final long maxCpuFreqKHz;

        CpuInfo(int cpuCore, int cpusetCategories, boolean isOnline, long curCpuFreqKHz, long maxCpuFreqKHz, long avgTimeInStateCpuFreqKHz, CpuUsageStats latestCpuUsageStats) {
            this(cpuCore, cpusetCategories, isOnline, curCpuFreqKHz, maxCpuFreqKHz, avgTimeInStateCpuFreqKHz, 0, latestCpuUsageStats);
            this.mNormalizedAvailableCpuFreqKHz = computeNormalizedAvailableCpuFreqKHz();
        }

        CpuInfo(int cpuCore, int cpusetCategories, boolean isOnline, long curCpuFreqKHz, long maxCpuFreqKHz, long avgTimeInStateCpuFreqKHz, long normalizedAvailableCpuFreqKHz, CpuUsageStats latestCpuUsageStats) {
            this.cpuCore = cpuCore;
            this.cpusetCategories = cpusetCategories;
            this.isOnline = isOnline;
            this.curCpuFreqKHz = curCpuFreqKHz;
            this.maxCpuFreqKHz = maxCpuFreqKHz;
            this.avgTimeInStateCpuFreqKHz = avgTimeInStateCpuFreqKHz;
            this.latestCpuUsageStats = latestCpuUsageStats;
            this.mNormalizedAvailableCpuFreqKHz = normalizedAvailableCpuFreqKHz;
        }

        public long getNormalizedAvailableCpuFreqKHz() {
            return this.mNormalizedAvailableCpuFreqKHz;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("CpuInfo{ cpuCore = ");
            r0.append(this.cpuCore);
            r0.append(", cpusetCategories = [");
            r0.append(CpuInfoReader.m3260$$Nest$smtoCpusetCategoriesStr(this.cpusetCategories));
            r0.append("], isOnline = ");
            if (this.isOnline == false) goto L5;
            String r1 = "Yes";
        L6:
            r0.append(r1);
            r0.append(", curCpuFreqKHz = ");
            Object r2 = "missing";
            if (this.curCpuFreqKHz != 0) goto L9;
            Object r3 = "missing";
        L10:
            r0.append(r3);
            r0.append(", maxCpuFreqKHz = ");
            if (this.maxCpuFreqKHz != 0) goto L13;
            Object r4 = "missing";
        L14:
            r0.append(r4);
            r0.append(", avgTimeInStateCpuFreqKHz = ");
            if (this.avgTimeInStateCpuFreqKHz == 0) goto L18;
            r2 = Long.valueOf(this.avgTimeInStateCpuFreqKHz);
        L18:
            r0.append(r2);
            r0.append(", latestCpuUsageStats = ");
            r0.append(this.latestCpuUsageStats);
            r0.append(", mNormalizedAvailableCpuFreqKHz = ");
            r0.append(this.mNormalizedAvailableCpuFreqKHz);
            r0.append(" }");
            return r0.toString();
        L13:
            r4 = Long.valueOf(this.maxCpuFreqKHz);
            goto L14
        L9:
            r3 = Long.valueOf(this.curCpuFreqKHz);
            goto L10
        L5:
            r1 = "No";
            goto L6
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if ((obj instanceof CpuInfo) == true) goto L8;
            return false;
        L8:
            CpuInfo other = (CpuInfo) obj;
            if (this.cpuCore != other.cpuCore) goto L26;
            if (this.cpusetCategories != other.cpusetCategories) goto L26;
            if (this.isOnline != other.isOnline) goto L26;
            if (this.curCpuFreqKHz != other.curCpuFreqKHz) goto L26;
            if (this.maxCpuFreqKHz != other.maxCpuFreqKHz) goto L26;
            if (this.avgTimeInStateCpuFreqKHz != other.avgTimeInStateCpuFreqKHz) goto L26;
            if (this.latestCpuUsageStats.equals(other.latestCpuUsageStats) == false) goto L26;
            if (this.mNormalizedAvailableCpuFreqKHz != other.mNormalizedAvailableCpuFreqKHz) goto L26;
            return true;
        L26:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.cpuCore), Integer.valueOf(this.cpusetCategories), Boolean.valueOf(this.isOnline), Long.valueOf(this.curCpuFreqKHz), Long.valueOf(this.maxCpuFreqKHz), Long.valueOf(this.avgTimeInStateCpuFreqKHz), this.latestCpuUsageStats, Long.valueOf(this.mNormalizedAvailableCpuFreqKHz)});
        }

        private long computeNormalizedAvailableCpuFreqKHz() {
            if (this.isOnline == true) goto L5;
            return 0;
        L5:
            long totalTimeMillis = this.latestCpuUsageStats.getTotalTimeMillis();
            if (totalTimeMillis != 0) goto L9;
            Slogf.wtf(CpuMonitorService.TAG, "Total CPU time millis is 0. This shouldn't happen unless stats are polled too frequently");
            return 0;
        L9:
            double nonIdlePercent = ((totalTimeMillis - this.latestCpuUsageStats.idleTimeMillis) * 100.0d) / totalTimeMillis;
            if (this.avgTimeInStateCpuFreqKHz != 0) goto L12;
            long curFreqKHz = this.curCpuFreqKHz;
        L13:
            double availablePercent = 100.0d - ((curFreqKHz * nonIdlePercent) / this.maxCpuFreqKHz);
            return (long) ((this.maxCpuFreqKHz * availablePercent) / 100.0d);
        L12:
            curFreqKHz = this.avgTimeInStateCpuFreqKHz;
            goto L13
        }
    }

    public static final class CpuUsageStats {
        public final long guestNiceTimeMillis;
        public final long guestTimeMillis;
        public final long idleTimeMillis;
        public final long iowaitTimeMillis;
        public final long irqTimeMillis;
        public final long niceTimeMillis;
        public final long softirqTimeMillis;
        public final long stealTimeMillis;
        public final long systemTimeMillis;
        public final long userTimeMillis;

        public CpuUsageStats(long userTimeMillis, long niceTimeMillis, long systemTimeMillis, long idleTimeMillis, long iowaitTimeMillis, long irqTimeMillis, long softirqTimeMillis, long stealTimeMillis, long guestTimeMillis, long guestNiceTimeMillis) {
            this.userTimeMillis = userTimeMillis;
            this.niceTimeMillis = niceTimeMillis;
            this.systemTimeMillis = systemTimeMillis;
            this.idleTimeMillis = idleTimeMillis;
            this.iowaitTimeMillis = iowaitTimeMillis;
            this.irqTimeMillis = irqTimeMillis;
            this.softirqTimeMillis = softirqTimeMillis;
            this.stealTimeMillis = stealTimeMillis;
            this.guestTimeMillis = guestTimeMillis;
            this.guestNiceTimeMillis = guestNiceTimeMillis;
        }

        public long getTotalTimeMillis() {
            return ((((((((this.userTimeMillis + this.niceTimeMillis) + this.systemTimeMillis) + this.idleTimeMillis) + this.iowaitTimeMillis) + this.irqTimeMillis) + this.softirqTimeMillis) + this.stealTimeMillis) + this.guestTimeMillis) + this.guestNiceTimeMillis;
        }

        public String toString() {
            return "CpuUsageStats{ userTimeMillis = " + this.userTimeMillis + ", niceTimeMillis = " + this.niceTimeMillis + ", systemTimeMillis = " + this.systemTimeMillis + ", idleTimeMillis = " + this.idleTimeMillis + ", iowaitTimeMillis = " + this.iowaitTimeMillis + ", irqTimeMillis = " + this.irqTimeMillis + ", softirqTimeMillis = " + this.softirqTimeMillis + ", stealTimeMillis = " + this.stealTimeMillis + ", guestTimeMillis = " + this.guestTimeMillis + ", guestNiceTimeMillis = " + this.guestNiceTimeMillis + " }";
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if ((obj instanceof CpuUsageStats) == true) goto L8;
            return false;
        L8:
            CpuUsageStats other = (CpuUsageStats) obj;
            if (this.userTimeMillis != other.userTimeMillis) goto L30;
            if (this.niceTimeMillis != other.niceTimeMillis) goto L30;
            if (this.systemTimeMillis != other.systemTimeMillis) goto L30;
            if (this.idleTimeMillis != other.idleTimeMillis) goto L30;
            if (this.iowaitTimeMillis != other.iowaitTimeMillis) goto L30;
            if (this.irqTimeMillis != other.irqTimeMillis) goto L30;
            if (this.softirqTimeMillis != other.softirqTimeMillis) goto L30;
            if (this.stealTimeMillis != other.stealTimeMillis) goto L30;
            if (this.guestTimeMillis != other.guestTimeMillis) goto L30;
            if (this.guestNiceTimeMillis != other.guestNiceTimeMillis) goto L30;
            return true;
        L30:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Long.valueOf(this.userTimeMillis), Long.valueOf(this.niceTimeMillis), Long.valueOf(this.systemTimeMillis), Long.valueOf(this.idleTimeMillis), Long.valueOf(this.iowaitTimeMillis), Long.valueOf(this.irqTimeMillis), Long.valueOf(this.softirqTimeMillis), Long.valueOf(this.stealTimeMillis), Long.valueOf(this.guestTimeMillis), Long.valueOf(this.guestNiceTimeMillis)});
        }

        CpuUsageStats delta(CpuUsageStats rhs) {
            return new CpuUsageStats(diff(this.userTimeMillis, rhs.userTimeMillis), diff(this.niceTimeMillis, rhs.niceTimeMillis), diff(this.systemTimeMillis, rhs.systemTimeMillis), diff(this.idleTimeMillis, rhs.idleTimeMillis), diff(this.iowaitTimeMillis, rhs.iowaitTimeMillis), diff(this.irqTimeMillis, rhs.irqTimeMillis), diff(this.softirqTimeMillis, rhs.softirqTimeMillis), diff(this.stealTimeMillis, rhs.stealTimeMillis), diff(this.guestTimeMillis, rhs.guestTimeMillis), diff(this.guestNiceTimeMillis, rhs.guestNiceTimeMillis));
        }

        private static long diff(long lhs, long rhs) {
            if (lhs > rhs) goto L7;
            return 0;
        L7:
            return lhs - rhs;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface CpusetCategory {
    }

    private static final class DynamicPolicyInfo {
        public final IntArray affectedCpuCores;
        public final long avgTimeInStateCpuFreqKHz;
        public final long curCpuFreqKHz;
        public final long maxCpuFreqKHz;

        DynamicPolicyInfo(long curCpuFreqKHz, long maxCpuFreqKHz, long avgTimeInStateCpuFreqKHz, IntArray affectedCpuCores) {
            this.curCpuFreqKHz = curCpuFreqKHz;
            this.maxCpuFreqKHz = maxCpuFreqKHz;
            this.avgTimeInStateCpuFreqKHz = avgTimeInStateCpuFreqKHz;
            this.affectedCpuCores = affectedCpuCores;
        }

        public String toString() {
            return "DynamicPolicyInfo{curCpuFreqKHz = " + this.curCpuFreqKHz + ", maxCpuFreqKHz = " + this.maxCpuFreqKHz + ", avgTimeInStateCpuFreqKHz = " + this.avgTimeInStateCpuFreqKHz + ", affectedCpuCores = " + this.affectedCpuCores + '}';
        }
    }

    private static final class StaticPolicyInfo {
        public final IntArray relatedCpuCores;

        StaticPolicyInfo(IntArray relatedCpuCores) {
            this.relatedCpuCores = relatedCpuCores;
        }

        public String toString() {
            return "StaticPolicyInfo{relatedCpuCores = " + this.relatedCpuCores + '}';
        }
    }

    public static /* synthetic */ boolean $r8$lambda$jQBUynzxWR2ZUcdjqmjLMG5hjjk(File r0) {
        return lambda$init$0(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$roIUmCaCkWNgL7Rd3oIho7Rd6uk(File r0) {
        return lambda$setCpuFreqDir$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smtoCpusetCategoriesStr, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3260$$Nest$smtoCpusetCategoriesStr(int r0) {
        return toCpusetCategoriesStr(r0);
    }

    static {
        PROC_STAT_PATTERN = Pattern.compile("cpu(?<core>[0-9]+)\\s(?<userClockTicks>[0-9]+)\\s(?<niceClockTicks>[0-9]+)\\s(?<sysClockTicks>[0-9]+)\\s(?<idleClockTicks>[0-9]+)\\s(?<iowaitClockTicks>[0-9]+)\\s(?<irqClockTicks>[0-9]+)\\s(?<softirqClockTicks>[0-9]+)\\s(?<stealClockTicks>[0-9]+)\\s(?<guestClockTicks>[0-9]+)\\s(?<guestNiceClockTicks>[0-9]+)");
        TIME_IN_STATE_PATTERN = Pattern.compile("(?<freqKHz>[0-9]+)\\s(?<time>[0-9]+)");
        MILLIS_PER_CLOCK_TICK = 1000 / Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    public CpuInfoReader() {
        this(new File(CPUSET_DIR_PATH), new File(CPUFREQ_DIR_PATH), new File(PROC_STAT_FILE_PATH), 500);
    }

    CpuInfoReader(File cpusetDir, File cpuFreqDir, File procStatFile, long minReadIntervalMillis) {
        this.mLock = new Object();
        this.mCpusetCategoriesByCpus = new SparseIntArray();
        this.mCpuFreqPolicyDirsById = new SparseArray();
        this.mStaticPolicyInfoById = new SparseArray();
        this.mTimeInStateByPolicyId = new SparseArray();
        this.mCumulativeCpuUsageStats = new SparseArray();
        this.mCpusetDir = cpusetDir;
        this.mCpuFreqDir = cpuFreqDir;
        this.mProcStatFile = procStatFile;
        this.mMinReadIntervalMillis = minReadIntervalMillis;
        this.mShouldReadCpusetCategories = new AtomicBoolean(true);
    }

    public boolean init() {
        if (this.mCpuFreqPolicyDirsById.size() <= 0) goto L6;
        Slogf.w(CpuMonitorService.TAG, "Ignoring duplicate CpuInfoReader init request");
        return this.mIsEnabled;
    L6:
        File[] policyDirs = this.mCpuFreqDir.listFiles(new CpuInfoReader$$ExternalSyntheticLambda1());
        if (policyDirs != null) goto L9;
    L46:
        Slogf.w(CpuMonitorService.TAG, "Missing CPU frequency policy directories at %s", new Object[]{this.mCpuFreqDir.getAbsolutePath()});
        return false;
    L9:
        if (policyDirs.length == 0) goto L46;
        populateCpuFreqPolicyDirsById(policyDirs);
        if (this.mCpuFreqPolicyDirsById.size() != 0) goto L15;
        Slogf.e(CpuMonitorService.TAG, "Failed to parse CPU frequency policy directory paths: %s", new Object[]{Arrays.toString(policyDirs)});
        return false;
    L15:
        readStaticPolicyInfo();
        if (this.mStaticPolicyInfoById.size() != 0) goto L20;
        Slogf.e(CpuMonitorService.TAG, "Failed to read static CPU frequency policy info from policy dirs: %s", new Object[]{Arrays.toString(policyDirs)});
        return false;
    L20:
        if (this.mProcStatFile.exists() == true) goto L23;
        Slogf.e(CpuMonitorService.TAG, "Missing proc stat file at %s", new Object[]{this.mProcStatFile.getAbsolutePath()});
        return false;
    L23:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L30:
        th = move-exception;
        throw th;
    L26:
        if (readCpusetCategories() == true) goto L32;
        Slogf.e(CpuMonitorService.TAG, "Failed to read cpuset information from %s", new Object[]{this.mCpusetDir.getAbsolutePath()});     // Catch: Throwable -> L30
        monitor-exit(r2);     // Catch: Throwable -> L30
        return false;
    L32:
        monitor-exit(r2);     // Catch: Throwable -> L30
        int i = 0;
    L35:
        if (i >= this.mCpuFreqPolicyDirsById.size()) goto L40;
        if (this.mHasTimeInStateFile == true) goto L40;
        this.mHasTimeInStateFile |= new File(this.mCpuFreqPolicyDirsById.valueAt(i), TIME_IN_STATE_FILE).exists();
        i = i + 1;
    L40:
        if (this.mHasTimeInStateFile == true) goto L42;
        Slogf.e(CpuMonitorService.TAG, "Time in state file not available for any cpufreq policy");
    L42:
        this.mIsEnabled = true;
        return true;
    }

    private static /* synthetic */ boolean lambda$init$0(File file) {
        if (file.isDirectory() == true) goto L5;
    L7:
        return false;
    L5:
        if (file.getName().startsWith(POLICY_DIR_PREFIX) == false) goto L7;
        return true;
    }

    public void stopPeriodicCpusetReading() {
        this.mShouldReadCpusetCategories.set(false);
        if (readCpusetCategories() == true) goto L6;
        Slogf.e(CpuMonitorService.TAG, "Failed to read cpuset information from %s", new Object[]{this.mCpusetDir.getAbsolutePath()});
        this.mIsEnabled = false;
        return;
    }

    public SparseArray<CpuInfo> readCpuInfos() {
        if (this.mIsEnabled == true) goto L5;
        return null;
    L5:
        long uptimeMillis = SystemClock.uptimeMillis();
        long r7 = 0;
        if (this.mLastReadUptimeMillis > 0) goto L8;
    L11:
        this.mLastReadUptimeMillis = uptimeMillis;
        this.mLastReadCpuInfos = null;
        if (this.mShouldReadCpusetCategories.get() == true) goto L14;
    L17:
        SparseArray<CpuUsageStats> cpuUsageStatsByCpus = readLatestCpuUsageStats();
        if (cpuUsageStatsByCpus == null) goto L76;
        if (cpuUsageStatsByCpus.size() == 0) goto L76;
        SparseArray<DynamicPolicyInfo> dynamicPolicyInfoById = readDynamicPolicyInfo();
        if (dynamicPolicyInfoById.size() != 0) goto L26;
        Slogf.e(CpuMonitorService.TAG, "Failed to read dynamic policy infos");
        return null;
    L26:
        SparseArray<CpuInfo> cpuInfoByCpus = new SparseArray();
        int i = 0;
    L28:
        if (i >= this.mStaticPolicyInfoById.size()) goto L73;
        int policyId = this.mStaticPolicyInfoById.keyAt(i);
        StaticPolicyInfo staticPolicyInfo = this.mStaticPolicyInfoById.valueAt(i);
        DynamicPolicyInfo dynamicPolicyInfo = dynamicPolicyInfoById.get(policyId);
        if (dynamicPolicyInfo != null) goto L33;
        Slogf.w(CpuMonitorService.TAG, "Missing dynamic policy info for policy ID %d", new Object[]{Integer.valueOf(policyId)});
        uptimeMillis = uptimeMillis;
    L72:
        i = i + 1;
        uptimeMillis = uptimeMillis;
        r7 = 0;
        goto L28
    L33:
        if (dynamicPolicyInfo.curCpuFreqKHz == r7) goto L71;
        if (dynamicPolicyInfo.maxCpuFreqKHz == r7) goto L71;
        if (dynamicPolicyInfo.curCpuFreqKHz <= dynamicPolicyInfo.maxCpuFreqKHz) goto L40;
        Slogf.w(CpuMonitorService.TAG, "Current CPU frequency (%d) is greater than maximum CPU frequency (%d) for policy ID (%d). Skipping CPU frequency policy", new Object[]{Long.valueOf(dynamicPolicyInfo.curCpuFreqKHz), Long.valueOf(dynamicPolicyInfo.maxCpuFreqKHz), Integer.valueOf(policyId)});
        uptimeMillis = uptimeMillis;
        goto L72
    L40:
        int coreIdx = 0;
    L42:
        if (coreIdx >= staticPolicyInfo.relatedCpuCores.size()) goto L69;
        int relatedCpuCore = staticPolicyInfo.relatedCpuCores.get(coreIdx);
        CpuInfo prevCpuInfo = cpuInfoByCpus.get(relatedCpuCore);
        if (prevCpuInfo == null) goto L48;
        Slogf.wtf(CpuMonitorService.TAG, "CPU info already available for the CPU core %d", new Object[]{Integer.valueOf(relatedCpuCore)});
        if (prevCpuInfo.isOnline == false) goto L48;
        long uptimeMillis2 = uptimeMillis;
    L62:
        coreIdx = coreIdx + 1;
        uptimeMillis = uptimeMillis2;
    L48:
        Object r14 = this.mLock;
        monitor-enter(r14);
        int cpusetCategories = this.mCpusetCategoriesByCpus.get(relatedCpuCore, -1);     // Catch: Throwable -> L63
        monitor-exit(r14);     // Catch: Throwable -> L63
        if (cpusetCategories >= 0) goto L54;
        Slogf.w(CpuMonitorService.TAG, "Missing cpuset information for the CPU core %d", new Object[]{Integer.valueOf(relatedCpuCore)});
        uptimeMillis2 = uptimeMillis;
        goto L62
    L54:
        CpuUsageStats usageStats = cpuUsageStatsByCpus.get(relatedCpuCore);
        if (dynamicPolicyInfo.affectedCpuCores.indexOf(relatedCpuCore) >= 0) goto L57;
        cpuInfoByCpus.append(relatedCpuCore, new CpuInfo(relatedCpuCore, cpusetCategories, false, 0, dynamicPolicyInfo.maxCpuFreqKHz, 0, usageStats));
        uptimeMillis2 = uptimeMillis;
        goto L62
    L57:
        if (usageStats != null) goto L59;
        Slogf.w(CpuMonitorService.TAG, "Missing CPU usage information for online CPU core %d", new Object[]{Integer.valueOf(relatedCpuCore)});
        uptimeMillis2 = uptimeMillis;
        goto L62
    L59:
        uptimeMillis2 = uptimeMillis;
        CpuInfo cpuInfo = new CpuInfo(relatedCpuCore, cpusetCategories, true, dynamicPolicyInfo.curCpuFreqKHz, dynamicPolicyInfo.maxCpuFreqKHz, dynamicPolicyInfo.avgTimeInStateCpuFreqKHz, usageStats);
        cpuInfoByCpus.append(relatedCpuCore, cpuInfo);
        if (CpuMonitorService.DEBUG == false) goto L62;
        Slogf.d(CpuMonitorService.TAG, "Added %s for CPU core %d", new Object[]{cpuInfo, Integer.valueOf(relatedCpuCore)});
    L63:
        th = th;
    L80:
        throw th;
    L67:
        th = th;
        goto L80
    L69:
        uptimeMillis = uptimeMillis;
    L71:
        Slogf.w(CpuMonitorService.TAG, "Current and maximum CPU frequency information mismatch/missing for policy ID %d", new Object[]{Integer.valueOf(policyId)});
        goto L72
    L73:
        this.mLastReadCpuInfos = cpuInfoByCpus;
        return cpuInfoByCpus;
    L76:
        Slogf.e(CpuMonitorService.TAG, "Failed to read latest CPU usage stats");
        return null;
    L14:
        if (readCpusetCategories() == true) goto L17;
        Slogf.e(CpuMonitorService.TAG, "Failed to read cpuset information from %s", new Object[]{this.mCpusetDir.getAbsolutePath()});
        this.mIsEnabled = false;
        return null;
    L8:
        if ((uptimeMillis - this.mLastReadUptimeMillis) >= this.mMinReadIntervalMillis) goto L11;
        Slogf.w(CpuMonitorService.TAG, "Skipping reading from device and returning the last read CpuInfos. Last read was %d ms ago, min read interval is %d ms", new Object[]{Long.valueOf(uptimeMillis - this.mLastReadUptimeMillis), Long.valueOf(this.mMinReadIntervalMillis)});
        return this.mLastReadCpuInfos;
    }

    public void dump(IndentingPrintWriter writer) {
        writer.printf("*%s*\n", new Object[]{getClass().getSimpleName()});
        writer.increaseIndent();
        writer.printf("mCpusetDir = %s\n", new Object[]{this.mCpusetDir.getAbsolutePath()});
        writer.printf("mCpuFreqDir = %s\n", new Object[]{this.mCpuFreqDir.getAbsolutePath()});
        writer.printf("mProcStatFile = %s\n", new Object[]{this.mProcStatFile.getAbsolutePath()});
        writer.printf("mIsEnabled = %s\n", new Object[]{Boolean.valueOf(this.mIsEnabled)});
        writer.printf("mHasTimeInStateFile = %s\n", new Object[]{Boolean.valueOf(this.mHasTimeInStateFile)});
        writer.printf("mLastReadUptimeMillis = %d\n", new Object[]{Long.valueOf(this.mLastReadUptimeMillis)});
        writer.printf("mMinReadIntervalMillis = %d\n", new Object[]{Long.valueOf(this.mMinReadIntervalMillis)});
        writer.printf("Cpuset categories by CPU core:\n", new Object[0]);
        writer.increaseIndent();
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L36:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mCpusetCategoriesByCpus.size()) goto L11;
        writer.printf("CPU core id = %d, %s\n", new Object[]{Integer.valueOf(this.mCpusetCategoriesByCpus.keyAt(i)), toCpusetCategoriesStr(this.mCpusetCategoriesByCpus.valueAt(i))});     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L36
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        writer.decreaseIndent();
        writer.println("Cpu frequency policy directories by policy id:");
        writer.increaseIndent();
        int i2 = 0;
    L14:
        if (i2 >= this.mCpuFreqPolicyDirsById.size()) goto L16;
        writer.printf("Policy id = %d, Dir = %s\n", new Object[]{Integer.valueOf(this.mCpuFreqPolicyDirsById.keyAt(i2)), this.mCpuFreqPolicyDirsById.valueAt(i2)});
        i2 = i2 + 1;
        goto L14
    L16:
        writer.decreaseIndent();
        writer.println("Static cpu frequency policy infos by policy id:");
        writer.increaseIndent();
        int i3 = 0;
    L18:
        if (i3 >= this.mStaticPolicyInfoById.size()) goto L20;
        writer.printf("Policy id = %d, %s\n", new Object[]{Integer.valueOf(this.mStaticPolicyInfoById.keyAt(i3)), this.mStaticPolicyInfoById.valueAt(i3)});
        i3 = i3 + 1;
        goto L18
    L20:
        writer.decreaseIndent();
        writer.println("Cpu time in frequency state by policy id:");
        writer.increaseIndent();
        int i4 = 0;
    L22:
        if (i4 >= this.mTimeInStateByPolicyId.size()) goto L24;
        writer.printf("Policy id = %d, Time(millis) in state by CPU frequency(KHz) = %s\n", new Object[]{Integer.valueOf(this.mTimeInStateByPolicyId.keyAt(i4)), this.mTimeInStateByPolicyId.valueAt(i4)});
        i4 = i4 + 1;
        goto L22
    L24:
        writer.decreaseIndent();
        writer.println("Last read CPU infos:");
        writer.increaseIndent();
        int i5 = 0;
    L26:
        if (i5 >= this.mLastReadCpuInfos.size()) goto L28;
        writer.printf("%s\n", new Object[]{this.mLastReadCpuInfos.valueAt(i5)});
        i5 = i5 + 1;
        goto L26
    L28:
        writer.decreaseIndent();
        writer.println("Latest cumulative CPU usage stats by CPU core:");
        writer.increaseIndent();
        int i6 = 0;
    L30:
        if (i6 >= this.mCumulativeCpuUsageStats.size()) goto L32;
        writer.printf("CPU core id = %d, %s\n", new Object[]{Integer.valueOf(this.mCumulativeCpuUsageStats.keyAt(i6)), this.mCumulativeCpuUsageStats.valueAt(i6)});
        i6 = i6 + 1;
        goto L30
    L32:
        writer.decreaseIndent();
        writer.decreaseIndent();
    }

    boolean setCpuFreqDir(File cpuFreqDir) {
        File[] cpuFreqPolicyDirs = cpuFreqDir.listFiles(new CpuInfoReader$$ExternalSyntheticLambda0());
        if (cpuFreqPolicyDirs != null) goto L5;
    L15:
        Slogf.w(CpuMonitorService.TAG, "Failed to set CPU frequency directory. Missing policy directories at %s", new Object[]{cpuFreqDir.getAbsolutePath()});
        return false;
    L5:
        if (cpuFreqPolicyDirs.length == 0) goto L15;
        populateCpuFreqPolicyDirsById(cpuFreqPolicyDirs);
        int numCpuFreqPolicyDirs = this.mCpuFreqPolicyDirsById.size();
        int numStaticPolicyInfos = this.mStaticPolicyInfoById.size();
        if (numCpuFreqPolicyDirs == 0) goto L13;
        if (numCpuFreqPolicyDirs != numStaticPolicyInfos) goto L13;
        this.mCpuFreqDir = cpuFreqDir;
        return true;
    L13:
        Slogf.e(CpuMonitorService.TAG, "Failed to set CPU frequency directory to %s. Total CPU frequency policies (%d) under new path is either 0 or not equal to initial total CPU frequency policies. Clearing CPU frequency policy directories", new Object[]{cpuFreqDir.getAbsolutePath(), Integer.valueOf(numCpuFreqPolicyDirs), Integer.valueOf(numStaticPolicyInfos)});
        this.mCpuFreqPolicyDirsById.clear();
        return false;
    }

    private static /* synthetic */ boolean lambda$setCpuFreqDir$1(File file) {
        if (file.isDirectory() == true) goto L5;
    L7:
        return false;
    L5:
        if (file.getName().startsWith(POLICY_DIR_PREFIX) == false) goto L7;
        return true;
    }

    boolean setProcStatFile(File procStatFile) {
        if (procStatFile.exists() == true) goto L6;
        Slogf.e(CpuMonitorService.TAG, "Missing proc stat file at %s", new Object[]{procStatFile.getAbsolutePath()});
        return false;
    L6:
        this.mProcStatFile = procStatFile;
        return true;
    }

    boolean setCpusetDir(File cpusetDir) {
        if (cpusetDir.exists() == false) goto L5;
    L8:
        this.mCpusetDir = cpusetDir;
        return true;
    L5:
        if (cpusetDir.isDirectory() == true) goto L8;
        Slogf.e(CpuMonitorService.TAG, "Missing or invalid cpuset directory at %s", new Object[]{cpusetDir.getAbsolutePath()});
        return false;
    }

    private void populateCpuFreqPolicyDirsById(File[] policyDirs) {
        this.mCpuFreqPolicyDirsById.clear();
        int i = 0;
    L4:
        if (i >= policyDirs.length) goto L13;
        File policyDir = policyDirs[i];
        String policyIdStr = policyDir.getName().substring(POLICY_DIR_PREFIX.length());
        if (policyIdStr.isEmpty() == true) goto L11;
        this.mCpuFreqPolicyDirsById.append(Integer.parseInt(policyIdStr), policyDir);
        if (CpuMonitorService.DEBUG == false) goto L11;
        Slogf.d(CpuMonitorService.TAG, "Cached policy directory %s for policy id %s", new Object[]{policyDir, policyIdStr});
    L11:
        i = i + 1;
        goto L4
    }

    public boolean isCpusetConfigurationChanged() {
        int prevTopCPUMask = this.mCurrentTopCPUMask;
        int prevBackgroundCPUMask = this.mCurrentBackgroundCPUMask;
        readCpusetCategories();
        if (prevTopCPUMask == this.mCurrentTopCPUMask) goto L5;
    L8:
        return true;
    L5:
        if (prevBackgroundCPUMask != this.mCurrentBackgroundCPUMask) goto L8;
        return false;
    }

    private boolean readCpusetCategories() {
        File[] cpusetDirs = this.mCpusetDir.listFiles(new CpuInfoReader$$ExternalSyntheticLambda2());
        if (cpusetDirs != null) goto L6;
        Slogf.e(CpuMonitorService.TAG, "Missing cpuset directories at %s", new Object[]{this.mCpusetDir.getAbsolutePath()});
        return false;
    L6:
        this.mCurrentTopCPUMask = 0;
        this.mCurrentBackgroundCPUMask = 0;
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCpusetCategoriesByCpus.clear();     // Catch: Throwable -> L59
        monitor-exit(r2);     // Catch: Throwable -> L59
        int i = 0;
    L12:
        if (i >= cpusetDirs.length) goto L56;
        File dir = cpusetDirs[i];
        String r5 = dir.getName();
        switch(r5.hashCode()) {
            case -1332194002: goto L20;
            case -1141047895: goto L17;
            default: goto L22;
        };
    L22:
        byte r6 = -1;
    L23:
        switch(r6) {
            case 0: goto L26;
            case 1: goto L25;
            default: goto L54;
        };
    L25:
        int cpusetCategory = 2;
    L27:
        File cpuCoresFile = new File(dir.getPath(), CPUS_FILE);
        IntArray cpuCores = readCpuCores(cpuCoresFile);
        if (cpuCores != null) goto L30;
    L53:
        Slogf.e(CpuMonitorService.TAG, "Failed to read CPU cores from %s", new Object[]{cpuCoresFile.getAbsolutePath()});
        goto L54
    L30:
        if (cpuCores.size() == 0) goto L53;
        Object r8 = this.mLock;
        monitor-enter(r8);
        int j = 0;
    L62:
        if (j >= cpuCores.size()) goto L49;
        int categories = this.mCpusetCategoriesByCpus.get(cpuCores.get(j)) | cpusetCategory;     // Catch: Throwable -> L40
        this.mCpusetCategoriesByCpus.append(cpuCores.get(j), categories);     // Catch: Throwable -> L40
        if (CpuMonitorService.DEBUG == false) goto L42;
        Slogf.d(CpuMonitorService.TAG, "Mapping CPU core id %d with cpuset categories [%s]", new Object[]{Integer.valueOf(cpuCores.get(j)), toCpusetCategoriesStr(categories)});     // Catch: Throwable -> L40
    L42:
        if (cpusetCategory != 1) goto L45;
        this.mCurrentTopCPUMask |= 1 << cpuCores.get(j);     // Catch: Throwable -> L40
    L47:
        j = j + 1;     // Catch: Throwable -> L40
        goto L62
    L45:
        if (cpusetCategory != 2) goto L47;
        this.mCurrentBackgroundCPUMask |= 1 << cpuCores.get(j);     // Catch: Throwable -> L40
        goto L47
    L49:
        monitor-exit(r8);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    L26:
        cpusetCategory = 1;
    L54:
        i = i + 1;
        goto L12
    L17:
        if (r5.equals(CPUSET_TOP_APP_DIR) == false) goto L22;
        r6 = 0;
        goto L23
    L20:
        if (r5.equals(CPUSET_BACKGROUND_DIR) == false) goto L22;
        r6 = 1;
        goto L23
    L56:
        if (this.mCpusetCategoriesByCpus.size() > 0) goto L58;
        return false;
    L58:
        return true;
    L59:
        th = move-exception;
        throw th;
    }

    private void readStaticPolicyInfo() {
        int i = 0;
    L4:
        if (i >= this.mCpuFreqPolicyDirsById.size()) goto L16;
        int policyId = this.mCpuFreqPolicyDirsById.keyAt(i);
        File policyDir = this.mCpuFreqPolicyDirsById.valueAt(i);
        File cpuCoresFile = new File(policyDir, RELATED_CPUS_FILE);
        IntArray relatedCpuCores = readCpuCores(cpuCoresFile);
        if (relatedCpuCores != null) goto L8;
    L13:
        Slogf.e(CpuMonitorService.TAG, "Failed to read related CPU cores from %s", new Object[]{cpuCoresFile.getAbsolutePath()});
    L14:
        i = i + 1;
        goto L4
    L8:
        if (relatedCpuCores.size() == 0) goto L13;
        StaticPolicyInfo staticPolicyInfo = new StaticPolicyInfo(relatedCpuCores);
        this.mStaticPolicyInfoById.append(policyId, staticPolicyInfo);
        if (CpuMonitorService.DEBUG == false) goto L14;
        Slogf.d(CpuMonitorService.TAG, "Added static policy info %s for policy id %d", new Object[]{staticPolicyInfo, Integer.valueOf(policyId)});
        goto L14
    }

    private SparseArray<DynamicPolicyInfo> readDynamicPolicyInfo() {
        SparseArray<DynamicPolicyInfo> dynamicPolicyInfoById = new SparseArray();
        int i = 0;
    L4:
        if (i >= this.mCpuFreqPolicyDirsById.size()) goto L22;
        int policyId = this.mCpuFreqPolicyDirsById.keyAt(i);
        File policyDir = this.mCpuFreqPolicyDirsById.valueAt(i);
        long curCpuFreqKHz = readCpuFreqKHz(new File(policyDir, CUR_SCALING_FREQ_FILE));
        if (curCpuFreqKHz != 0) goto L8;
        Slogf.w(CpuMonitorService.TAG, "Missing current frequency information at %s", new Object[]{policyDir.getAbsolutePath()});
    L20:
        i = i + 1;
        goto L4
    L8:
        long avgTimeInStateCpuFreqKHz = readAvgTimeInStateCpuFrequency(policyId, policyDir);
        File cpuCoresFile = new File(policyDir, AFFECTED_CPUS_FILE);
        IntArray affectedCpuCores = readCpuCores(cpuCoresFile);
        if (affectedCpuCores != null) goto L11;
    L19:
        Slogf.e(CpuMonitorService.TAG, "Failed to read CPU cores from %s", new Object[]{cpuCoresFile.getAbsolutePath()});
        goto L20
    L11:
        if (affectedCpuCores.size() == 0) goto L19;
        long maxCpuFreqKHz = readCpuFreqKHz(new File(policyDir, MAX_SCALING_FREQ_FILE));
        if (maxCpuFreqKHz != 0) goto L16;
        Slogf.w(CpuMonitorService.TAG, "Missing max CPU frequency information at %s", new Object[]{policyDir.getAbsolutePath()});
        goto L20
    L16:
        DynamicPolicyInfo dynamicPolicyInfo = new DynamicPolicyInfo(curCpuFreqKHz, maxCpuFreqKHz, avgTimeInStateCpuFreqKHz, affectedCpuCores);
        dynamicPolicyInfoById.append(policyId, dynamicPolicyInfo);
        if (CpuMonitorService.DEBUG == false) goto L20;
        Slogf.d(CpuMonitorService.TAG, "Read dynamic policy info %s for policy id %d", new Object[]{dynamicPolicyInfo, Integer.valueOf(policyId)});
        goto L20
    L22:
        return dynamicPolicyInfoById;
    }

    private long readAvgTimeInStateCpuFrequency(int policyId, File policyDir) {
        LongSparseLongArray latestTimeInState = readTimeInState(policyDir);
        if (latestTimeInState != null) goto L5;
        return 0;
    L5:
        if (latestTimeInState.size() == 0) goto L21;
        LongSparseLongArray prevTimeInState = this.mTimeInStateByPolicyId.get(policyId);
        if (prevTimeInState != null) goto L14;
        this.mTimeInStateByPolicyId.put(policyId, latestTimeInState);
        if (CpuMonitorService.DEBUG == false) goto L13;
        Slogf.d(CpuMonitorService.TAG, "Added aggregated time in state info for policy id %d", new Object[]{Integer.valueOf(policyId)});
    L13:
        return calculateAvgCpuFreq(latestTimeInState);
    L14:
        LongSparseLongArray deltaTimeInState = calculateDeltaTimeInState(prevTimeInState, latestTimeInState);
        this.mTimeInStateByPolicyId.put(policyId, latestTimeInState);
        if (CpuMonitorService.DEBUG == false) goto L18;
        Slogf.d(CpuMonitorService.TAG, "Added latest delta time in state info for policy id %d", new Object[]{Integer.valueOf(policyId)});
    L18:
        return calculateAvgCpuFreq(deltaTimeInState);
    L21:
        return 0;
    }

    private LongSparseLongArray readTimeInState(File policyDir) {
        if (this.mHasTimeInStateFile == true) goto L5;
        return null;
    L5:
        File timeInStateFile = new File(policyDir, TIME_IN_STATE_FILE);
        List<String> lines = Files.readAllLines(timeInStateFile.toPath());     // Catch: Exception -> L10
        if (lines.isEmpty() == false) goto L12;
        Slogf.w(CpuMonitorService.TAG, "Empty time in state file at %s", new Object[]{timeInStateFile.getAbsolutePath()});     // Catch: Exception -> L10
        return null;
    L12:
        LongSparseLongArray cpuTimeByFrequencies = new LongSparseLongArray();     // Catch: Exception -> L10
        int i = 0;
    L14:
        if (i >= lines.size()) goto L21;
        Matcher m = TIME_IN_STATE_PATTERN.matcher(lines.get(i).trim());     // Catch: Exception -> L10
        if (m.find() == false) goto L19;
        cpuTimeByFrequencies.put(Long.parseLong(m.group("freqKHz")), clockTickStrToMillis(m.group("time")));     // Catch: Exception -> L10
    L19:
        i = i + 1;
        goto L14
    L21:
        return cpuTimeByFrequencies;
    L10:
        e = move-exception;
        Slogf.e(CpuMonitorService.TAG, e, "Failed to read CPU time in state from file: %s", new Object[]{timeInStateFile.getAbsolutePath()});
        return null;
    }

    private static long readCpuFreqKHz(File file) {
        if (file.exists() == true) goto L18;
        Slogf.e(CpuMonitorService.TAG, "CPU frequency file %s doesn't exist", new Object[]{file.getAbsolutePath()});
        return 0;
    L18:
        List<String> lines = Files.readAllLines(file.toPath());     // Catch: Exception -> L13
        if (lines.isEmpty() == true) goto L17;
        long frequency = Long.parseLong(lines.get(0).trim());     // Catch: Exception -> L13
        if (frequency > 0) goto L12;
        return 0;
    L12:
        return frequency;
    L17:
        return 0;
    L13:
        e = move-exception;
        Slogf.e(CpuMonitorService.TAG, e, "Failed to read integer content from file: %s", new Object[]{file.getAbsolutePath()});
        goto L17
    }

    private static LongSparseLongArray calculateDeltaTimeInState(LongSparseLongArray prevTimeInState, LongSparseLongArray latestTimeInState) {
        int numTimeInStateEntries = latestTimeInState.size();
        LongSparseLongArray deltaTimeInState = new LongSparseLongArray(numTimeInStateEntries);
        int i = 0;
    L3:
        if (i >= numTimeInStateEntries) goto L10;
        long freq = latestTimeInState.keyAt(i);
        long durationMillis = latestTimeInState.valueAt(i);
        long prevDurationMillis = prevTimeInState.get(freq);
        if (durationMillis < prevDurationMillis) goto L7;
        long r9 = durationMillis - prevDurationMillis;
    L8:
        deltaTimeInState.put(freq, r9);
        i = i + 1;
        goto L3
    L7:
        r9 = durationMillis;
        goto L8
    L10:
        return deltaTimeInState;
    }

    private static long calculateAvgCpuFreq(LongSparseLongArray timeInState) {
        double totalTimeInState = 0.0d;
        int i = 0;
    L4:
        if (i >= timeInState.size()) goto L7;
        totalTimeInState = totalTimeInState + timeInState.valueAt(i);
        i = i + 1;
        goto L4
    L7:
        if (totalTimeInState != 0.0d) goto L10;
        return 0;
    L10:
        double avgFreqKHz = 0.0d;
        int i2 = 0;
    L12:
        if (i2 >= timeInState.size()) goto L15;
        avgFreqKHz = avgFreqKHz + ((timeInState.keyAt(i2) * timeInState.valueAt(i2)) / totalTimeInState);
        i2 = i2 + 1;
        goto L12
    L15:
        return (long) avgFreqKHz;
    }

    private static IntArray readCpuCores(File file) {
        if (file.exists() == true) goto L43;
        Slogf.e(CpuMonitorService.TAG, "Failed to read CPU cores as the file '%s' doesn't exist", new Object[]{file.getAbsolutePath()});
        return null;
    L43:
        List<String> lines = Files.readAllLines(file.toPath());     // Catch: Exception -> L15 NumberFormatException -> L17
        IntArray cpuCores = new IntArray(0);     // Catch: Exception -> L15 NumberFormatException -> L17
        int i = 0;
    L7:
        if (i >= lines.size()) goto L39;
        String line = lines.get(i).trim();     // Catch: Exception -> L15 NumberFormatException -> L17
        if (line.isEmpty() == false) goto L13;
    L37:
        i = i + 1;
        goto L7
    L13:
        if (line.contains(",") == false) goto L19;
        String[] pairs = line.split(",");     // Catch: Exception -> L15 NumberFormatException -> L17
    L20:
        int j = 0;
    L22:
        if (j >= pairs.length) goto L37;
        String[] minMaxPairs = pairs[j].split("-");     // Catch: Exception -> L15 NumberFormatException -> L17
        if (minMaxPairs.length < 2) goto L33;
        int min = Integer.parseInt(minMaxPairs[0]);     // Catch: Exception -> L15 NumberFormatException -> L17
        int max = Integer.parseInt(minMaxPairs[1]);     // Catch: Exception -> L15 NumberFormatException -> L17
        if (min > max) goto L36;
        int id = min;
    L29:
        if (id > max) goto L36;
        cpuCores.add(id);     // Catch: Exception -> L15 NumberFormatException -> L17
        id = id + 1;     // Catch: Exception -> L15 NumberFormatException -> L17
    L36:
        j = j + 1;
        goto L22
    L33:
        if (minMaxPairs.length != 1) goto L35;
        cpuCores.add(Integer.parseInt(minMaxPairs[0]));     // Catch: Exception -> L15 NumberFormatException -> L17
        goto L36
    L35:
        Slogf.w(CpuMonitorService.TAG, "Invalid CPU core range format %s", new Object[]{pairs[j]});     // Catch: Exception -> L15 NumberFormatException -> L17
        goto L36
    L19:
        pairs = line.split(" ");     // Catch: Exception -> L15 NumberFormatException -> L17
        goto L20
    L39:
        return cpuCores;
    L17:
        e = move-exception;
        Slogf.e(CpuMonitorService.TAG, e, "Failed to read CPU cores from %s due to incorrect file format", new Object[]{file.getAbsolutePath()});
    L42:
        return null;
    L15:
        e = move-exception;
        Slogf.e(CpuMonitorService.TAG, e, "Failed to read CPU cores from %s", new Object[]{file.getAbsolutePath()});
        goto L42
    }

    private SparseArray<CpuUsageStats> readLatestCpuUsageStats() {
        SparseArray<CpuUsageStats> cumulativeCpuUsageStats = readCumulativeCpuUsageStats();
        if (cumulativeCpuUsageStats.size() != 0) goto L6;
        Slogf.e(CpuMonitorService.TAG, "Failed to read cumulative CPU usage stats");
        return null;
    L6:
        SparseArray<CpuUsageStats> deltaCpuUsageStats = new SparseArray();
        int i = 0;
    L8:
        if (i >= cumulativeCpuUsageStats.size()) goto L14;
        int cpu = cumulativeCpuUsageStats.keyAt(i);
        CpuUsageStats newStats = cumulativeCpuUsageStats.valueAt(i);
        CpuUsageStats oldStats = this.mCumulativeCpuUsageStats.get(cpu);
        if (oldStats != null) goto L12;
        CpuUsageStats r6 = newStats;
    L13:
        deltaCpuUsageStats.append(cpu, r6);
        i = i + 1;
        goto L8
    L12:
        r6 = newStats.delta(oldStats);
        goto L13
    L14:
        this.mCumulativeCpuUsageStats = cumulativeCpuUsageStats;
        return deltaCpuUsageStats;
    }

    private SparseArray<CpuUsageStats> readCumulativeCpuUsageStats() {
        SparseArray<CpuUsageStats> cpuUsageStats = new SparseArray();
        List<String> lines = Files.readAllLines(this.mProcStatFile.toPath());     // Catch: Exception -> L11
        int i = 0;
    L5:
        if (i >= lines.size()) goto L15;
        Matcher m = PROC_STAT_PATTERN.matcher(lines.get(i).trim());     // Catch: Exception -> L11
        if (m.find() == false) goto L10;
        cpuUsageStats.append(Integer.parseInt(m.group("core")), new CpuUsageStats(clockTickStrToMillis(m.group("userClockTicks")), clockTickStrToMillis(m.group("niceClockTicks")), clockTickStrToMillis(m.group("sysClockTicks")), clockTickStrToMillis(m.group("idleClockTicks")), clockTickStrToMillis(m.group("iowaitClockTicks")), clockTickStrToMillis(m.group("irqClockTicks")), clockTickStrToMillis(m.group("softirqClockTicks")), clockTickStrToMillis(m.group("stealClockTicks")), clockTickStrToMillis(m.group("guestClockTicks")), clockTickStrToMillis(m.group("guestNiceClockTicks"))));     // Catch: Exception -> L11
    L10:
        i = i + 1;
        lines = lines;
    L15:
        return cpuUsageStats;
    L11:
        e = move-exception;
        Slogf.e(CpuMonitorService.TAG, e, "Failed to read cpu usage stats from %s", new Object[]{this.mProcStatFile.getAbsolutePath()});
        goto L15
    }

    private static long clockTickStrToMillis(String jiffyStr) {
        return Long.parseLong(jiffyStr) * MILLIS_PER_CLOCK_TICK;
    }

    private static String toCpusetCategoriesStr(int cpusetCategories) {
        StringBuilder builder = new StringBuilder();
        if ((cpusetCategories & 1) == 0) goto L6;
        builder.append("FLAG_CPUSET_CATEGORY_TOP_APP");
    L6:
        if ((cpusetCategories & 2) == 0) goto L12;
        if (builder.length() <= 0) goto L10;
        builder.append('|');
    L10:
        builder.append("FLAG_CPUSET_CATEGORY_BACKGROUND");
    L12:
        return builder.toString();
    }
}
