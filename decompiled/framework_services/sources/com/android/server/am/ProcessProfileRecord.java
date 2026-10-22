package com.android.server.am;

import android.app.IApplicationThread;
import android.content.pm.ApplicationInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.DebugUtils;
import android.util.TimeUtils;
import com.android.internal.app.procstats.ProcessState;
import com.android.internal.app.procstats.ProcessStats;
import com.android.server.power.stats.BatteryStatsImpl;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
final class ProcessProfileRecord {
    final ProcessRecord mApp;
    private ProcessState mBaseProcessTracker;
    final AtomicLong mCurCpuTime;
    private BatteryStatsImpl.Uid.Proc mCurProcBatteryStats;
    private int mCurRawAdj;
    private AtomicInteger mCurrentHostingComponentTypes;
    private AtomicInteger mHistoricalHostingComponentTypes;
    private long mInitialIdlePssOrRss;
    private long mLastCachedPss;
    private long mLastCachedRss;
    private long mLastCachedSwapPss;
    final AtomicLong mLastCpuDelayTime;
    final AtomicLong mLastCpuTime;
    private long mLastLowMemory;
    private Debug.MemoryInfo mLastMemInfo;
    private long mLastMemInfoTime;
    private long mLastPss;
    private long mLastPssTime;
    private long mLastRequestedGc;
    private long mLastRss;
    private long mLastStateTime;
    private long mLastSwapPss;
    private long mNextPssTime;
    private boolean mPendingUiClean;
    private int mPid;
    private final ActivityManagerGlobalLock mProcLock;
    private final ProcessList.ProcStateMemTracker mProcStateMemTracker;
    final Object mProfilerLock;
    private int mPssProcState;
    private int mPssStatType;
    private boolean mReportLowMemory;
    private final ActivityManagerService mService;
    private int mSetAdj;
    private int mSetProcState;
    private IApplicationThread mThread;
    private int mTrimMemoryLevel;

    public static /* synthetic */ void $r8$lambda$IUdC3S34rs87Xa1P5tzUxV1FgmY(ProcessProfileRecord r0, ProcessState r1, ProcessStatsService r2, int r3, ProcessState r4, String r5, ProcessStats.ProcessStateHolder r6) {
        r0.lambda$onProcessActive$0(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$JxHNnB95IHo4uPFFKjkpWwJexpY(ProcessState r0, ProcessStats.ProcessStateHolder r1) {
        lambda$onProcessInactive$1(r0, r1);
    }

    ProcessProfileRecord(ProcessRecord app) {
        this.mProcStateMemTracker = new ProcessList.ProcStateMemTracker();
        this.mPssProcState = 20;
        this.mLastCpuTime = new AtomicLong(0);
        this.mCurCpuTime = new AtomicLong(0);
        this.mLastCpuDelayTime = new AtomicLong(0);
        this.mCurrentHostingComponentTypes = new AtomicInteger(0);
        this.mHistoricalHostingComponentTypes = new AtomicInteger(0);
        this.mApp = app;
        this.mService = app.mService;
        this.mProcLock = this.mService.mProcLock;
        this.mProfilerLock = this.mService.mAppProfiler.mProfilerLock;
    }

    void init(long now) {
        this.mNextPssTime = now;
        this.mLastPssTime = now;
    }

    ProcessState getBaseProcessTracker() {
        return this.mBaseProcessTracker;
    }

    void setBaseProcessTracker(ProcessState baseProcessTracker) {
        this.mBaseProcessTracker = baseProcessTracker;
    }

    void onProcessFrozen() {
        Object r0 = this.mService.mProcessStats.mLock;
        monitor-enter(r0);
        ProcessState tracker = this.mBaseProcessTracker;     // Catch: Throwable -> L14
        if (tracker == null) goto L16;
        PackageList pkgList = this.mApp.getPkgList();     // Catch: Throwable -> L14
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
        monitor-enter(pkgList);     // Catch: Throwable -> L14
        tracker.onProcessFrozen(now, pkgList.getPackageListLocked());     // Catch: Throwable -> L11
        monitor-exit(pkgList);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void onProcessUnfrozen() {
        Object r0 = this.mService.mProcessStats.mLock;
        monitor-enter(r0);
        ProcessState tracker = this.mBaseProcessTracker;     // Catch: Throwable -> L14
        if (tracker == null) goto L16;
        PackageList pkgList = this.mApp.getPkgList();     // Catch: Throwable -> L14
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
        monitor-enter(pkgList);     // Catch: Throwable -> L14
        tracker.onProcessUnfrozen(now, pkgList.getPackageListLocked());     // Catch: Throwable -> L11
        monitor-exit(pkgList);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void onProcessActive(IApplicationThread thread, final ProcessStatsService tracker) {
        if (this.mThread != null) goto L36;
        Object r7 = this.mProfilerLock;
        monitor-enter(r7);
        Object r14 = tracker.mLock;     // Catch: Throwable -> L30
        monitor-enter(r14);     // Catch: Throwable -> L30
        final ProcessState origBase = getBaseProcessTracker();     // Catch: Throwable -> L18
        PackageList pkgList = this.mApp.getPkgList();     // Catch: Throwable -> L18
        if (origBase == null) goto L26;
        monitor-enter(pkgList);     // Catch: Throwable -> L18
    L20:
        th = th;
    L24:
        monitor-exit(pkgList);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L18
    L48:
        origBase.setState(-1, tracker.getMemFactorLocked(), SystemClock.uptimeMillis(), pkgList.getPackageListLocked());     // Catch: Throwable -> L22
        monitor-exit(pkgList);     // Catch: Throwable -> L20
        origBase.makeInactive();     // Catch: Throwable -> L18
    L22:
        th = th;
    L26:
        ApplicationInfo info = this.mApp.info;     // Catch: Throwable -> L18
        final int attributionUid = getUidForAttribution(this.mApp);     // Catch: Throwable -> L18
        final ProcessState baseProcessTracker = tracker.getProcessStateLocked(info.packageName, attributionUid, info.longVersionCode, this.mApp.processName);     // Catch: Throwable -> L18
        setBaseProcessTracker(baseProcessTracker);     // Catch: Throwable -> L18
        baseProcessTracker.makeActive();     // Catch: Throwable -> L18
        pkgList.forEachPackage(new ProcessProfileRecord$$ExternalSyntheticLambda1(this, origBase, tracker, attributionUid, baseProcessTracker));     // Catch: Throwable -> L18
        this.mThread = thread;     // Catch: Throwable -> L18
        monitor-exit(r14);     // Catch: Throwable -> L18
        monitor-exit(r7);     // Catch: Throwable -> L30
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L36:
        Object r2 = this.mProfilerLock;
        monitor-enter(r2);
        this.mThread = thread;     // Catch: Throwable -> L41
        monitor-exit(r2);     // Catch: Throwable -> L41
        return;
    L41:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onProcessActive$0(ProcessState origBase, ProcessStatsService tracker, int attributionUid, ProcessState baseProcessTracker, String pkgName, ProcessStats.ProcessStateHolder holder) {
        if (holder.state != null) goto L5;
    L7:
        tracker.updateProcessStateHolderLocked(holder, pkgName, attributionUid, this.mApp.info.longVersionCode, this.mApp.processName);
        if (holder.state == baseProcessTracker) goto L11;
        holder.state.makeActive();
        return;
    L11:
        return;
    L5:
        if (holder.state == origBase) goto L7;
        holder.state.makeInactive();
        goto L7
    }

    void onProcessInactive(ProcessStatsService tracker) {
        Object r1 = this.mProfilerLock;
        monitor-enter(r1);
        Object r2 = tracker.mLock;     // Catch: Throwable -> L24
        monitor-enter(r2);     // Catch: Throwable -> L24
        final ProcessState origBase = getBaseProcessTracker();     // Catch: Throwable -> L14
        if (origBase == null) goto L19;
        PackageList pkgList = this.mApp.getPkgList();     // Catch: Throwable -> L14
        monitor-enter(pkgList);     // Catch: Throwable -> L14
        origBase.setState(-1, tracker.getMemFactorLocked(), SystemClock.uptimeMillis(), pkgList.getPackageListLocked());     // Catch: Throwable -> L16
        monitor-exit(pkgList);     // Catch: Throwable -> L16
        origBase.makeInactive();     // Catch: Throwable -> L14
        setBaseProcessTracker(null);     // Catch: Throwable -> L14
        pkgList.forEachPackageProcessStats(new ProcessProfileRecord$$ExternalSyntheticLambda0(origBase));     // Catch: Throwable -> L14
        goto L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L19:
        this.mThread = null;     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L24
        this.mCurrentHostingComponentTypes.set(0);
        this.mHistoricalHostingComponentTypes.set(0);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$onProcessInactive$1(ProcessState origBase, ProcessStats.ProcessStateHolder holder) {
        if (holder.state != null) goto L5;
    L7:
        holder.pkg = null;
        holder.state = null;
        return;
    L5:
        if (holder.state == origBase) goto L7;
        holder.state.makeInactive();
        goto L7
    }

    long getLastPssTime() {
        return this.mLastPssTime;
    }

    void setLastPssTime(long lastPssTime) {
        this.mLastPssTime = lastPssTime;
    }

    long getNextPssTime() {
        return this.mNextPssTime;
    }

    void setNextPssTime(long nextPssTime) {
        this.mNextPssTime = nextPssTime;
    }

    long getInitialIdlePssOrRss() {
        return this.mInitialIdlePssOrRss;
    }

    void setInitialIdlePssOrRss(long initialIdlePssOrRss) {
        this.mInitialIdlePssOrRss = initialIdlePssOrRss;
    }

    long getLastPss() {
        return this.mLastPss;
    }

    void setLastPss(long lastPss) {
        this.mLastPss = lastPss;
    }

    long getLastCachedPss() {
        return this.mLastCachedPss;
    }

    void setLastCachedPss(long lastCachedPss) {
        this.mLastCachedPss = lastCachedPss;
    }

    long getLastCachedRss() {
        return this.mLastCachedRss;
    }

    void setLastCachedRss(long lastCachedRss) {
        this.mLastCachedRss = lastCachedRss;
    }

    long getLastSwapPss() {
        return this.mLastSwapPss;
    }

    void setLastSwapPss(long lastSwapPss) {
        this.mLastSwapPss = lastSwapPss;
    }

    long getLastCachedSwapPss() {
        return this.mLastCachedSwapPss;
    }

    void setLastCachedSwapPss(long lastCachedSwapPss) {
        this.mLastCachedSwapPss = lastCachedSwapPss;
    }

    long getLastRss() {
        return this.mLastRss;
    }

    void setLastRss(long lastRss) {
        this.mLastRss = lastRss;
    }

    Debug.MemoryInfo getLastMemInfo() {
        return this.mLastMemInfo;
    }

    void setLastMemInfo(Debug.MemoryInfo lastMemInfo) {
        this.mLastMemInfo = lastMemInfo;
    }

    long getLastMemInfoTime() {
        return this.mLastMemInfoTime;
    }

    void setLastMemInfoTime(long lastMemInfoTime) {
        this.mLastMemInfoTime = lastMemInfoTime;
    }

    int getPssProcState() {
        return this.mPssProcState;
    }

    void setPssProcState(int pssProcState) {
        this.mPssProcState = pssProcState;
    }

    int getPssStatType() {
        return this.mPssStatType;
    }

    void setPssStatType(int pssStatType) {
        this.mPssStatType = pssStatType;
    }

    int getTrimMemoryLevel() {
        return this.mTrimMemoryLevel;
    }

    void setTrimMemoryLevel(int trimMemoryLevel) {
        this.mTrimMemoryLevel = trimMemoryLevel;
    }

    boolean hasPendingUiClean() {
        return this.mPendingUiClean;
    }

    void setPendingUiClean(boolean pendingUiClean) {
        this.mPendingUiClean = pendingUiClean;
        this.mApp.getWindowProcessController().setPendingUiClean(pendingUiClean);
    }

    BatteryStatsImpl.Uid.Proc getCurProcBatteryStats() {
        return this.mCurProcBatteryStats;
    }

    void setCurProcBatteryStats(BatteryStatsImpl.Uid.Proc curProcBatteryStats) {
        this.mCurProcBatteryStats = curProcBatteryStats;
    }

    long getLastRequestedGc() {
        return this.mLastRequestedGc;
    }

    void setLastRequestedGc(long lastRequestedGc) {
        this.mLastRequestedGc = lastRequestedGc;
    }

    long getLastLowMemory() {
        return this.mLastLowMemory;
    }

    void setLastLowMemory(long lastLowMemory) {
        this.mLastLowMemory = lastLowMemory;
    }

    boolean getReportLowMemory() {
        return this.mReportLowMemory;
    }

    void setReportLowMemory(boolean reportLowMemory) {
        this.mReportLowMemory = reportLowMemory;
    }

    void addPss(long pss, long uss, long rss, boolean always, int type, long duration) {
        Object r2 = this.mService.mProcessStats.mLock;
        monitor-enter(r2);
        ProcessState tracker = this.mBaseProcessTracker;     // Catch: Throwable -> L14
        if (tracker == null) goto L16;
        PackageList pkgList = this.mApp.getPkgList();     // Catch: Throwable -> L14
        monitor-enter(pkgList);     // Catch: Throwable -> L14
        tracker.addPss(pss, uss, rss, always, type, duration, pkgList.getPackageListLocked());     // Catch: Throwable -> L11
        monitor-exit(pkgList);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void reportExcessiveCpu() {
        Object r0 = this.mService.mProcessStats.mLock;
        monitor-enter(r0);
        ProcessState tracker = this.mBaseProcessTracker;     // Catch: Throwable -> L14
        if (tracker == null) goto L16;
        PackageList pkgList = this.mApp.getPkgList();     // Catch: Throwable -> L14
        monitor-enter(pkgList);     // Catch: Throwable -> L14
        tracker.reportExcessiveCpu(pkgList.getPackageListLocked());     // Catch: Throwable -> L11
        monitor-exit(pkgList);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void setProcessTrackerState(int procState, int memFactor) {
        Object r1 = this.mService.mProcessStats.mLock;
        monitor-enter(r1);
        ProcessState tracker = this.mBaseProcessTracker;     // Catch: Throwable -> L23
        if (tracker == null) goto L27;
        if (procState == 20) goto L27;
        PackageList pkgList = this.mApp.getPkgList();     // Catch: Throwable -> L23
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L23
        monitor-enter(pkgList);     // Catch: Throwable -> L23
        tracker.setState(procState, memFactor, now, pkgList.getPackageListLocked());     // Catch: Throwable -> L15
        monitor-exit(pkgList);     // Catch: Throwable -> L15
    L17:
        th = move-exception;
        Throwable r10 = th;
    L19:
        monitor-exit(pkgList);     // Catch: Throwable -> L15
        throw r10;     // Catch: Throwable -> L21
    L15:
        th = move-exception;
        r10 = th;
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        Throwable r11 = th;
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L21
        throw r11;
    L23:
        th = move-exception;
        r11 = th;
        goto L29
    }

    void commitNextPssTime() {
        commitNextPssTime(this.mProcStateMemTracker);
    }

    void abortNextPssTime() {
        abortNextPssTime(this.mProcStateMemTracker);
    }

    long computeNextPssTime(int procState, boolean test, boolean sleeping, long now) {
        return ProcessList.computeNextPssTime(procState, this.mProcStateMemTracker, test, sleeping, now, Math.max(this.mService.mBootCompletedTimestamp, this.mService.mLastIdleTime) + this.mService.mConstants.FULL_PSS_MIN_INTERVAL);
    }

    private static void commitNextPssTime(ProcessList.ProcStateMemTracker tracker) {
        if (tracker.mPendingMemState < 0) goto L6;
        tracker.mHighestMem[tracker.mPendingMemState] = tracker.mPendingHighestMemState;
        tracker.mScalingFactor[tracker.mPendingMemState] = tracker.mPendingScalingFactor;
        tracker.mTotalHighestMem = tracker.mPendingHighestMemState;
        tracker.mPendingMemState = -1;
        return;
    }

    private static void abortNextPssTime(ProcessList.ProcStateMemTracker tracker) {
        tracker.mPendingMemState = -1;
    }

    private static int getUidForAttribution(ProcessRecord processRecord) {
        if (Process.isIsolatedUid(processRecord.uid) == false) goto L7;
        return processRecord.info.uid;
    L7:
        return processRecord.uid;
    }

    int getPid() {
        return this.mPid;
    }

    void setPid(int pid) {
        this.mPid = pid;
    }

    IApplicationThread getThread() {
        return this.mThread;
    }

    int getSetProcState() {
        return this.mSetProcState;
    }

    int getSetAdj() {
        return this.mSetAdj;
    }

    int getCurRawAdj() {
        return this.mCurRawAdj;
    }

    long getLastStateTime() {
        return this.mLastStateTime;
    }

    void updateProcState(ProcessStateRecord state) {
        this.mSetProcState = state.getCurProcState();
        this.mSetAdj = state.getCurAdj();
        this.mCurRawAdj = state.getCurRawAdj();
        this.mLastStateTime = state.getLastStateTime();
    }

    void addHostingComponentType(int type) {
        this.mCurrentHostingComponentTypes.set(this.mCurrentHostingComponentTypes.get() | type);
        this.mHistoricalHostingComponentTypes.set(this.mHistoricalHostingComponentTypes.get() | type);
    }

    void clearHostingComponentType(int type) {
        this.mCurrentHostingComponentTypes.set(this.mCurrentHostingComponentTypes.get() & (~type));
    }

    int getCurrentHostingComponentTypes() {
        return this.mCurrentHostingComponentTypes.get();
    }

    int getHistoricalHostingComponentTypes() {
        return this.mHistoricalHostingComponentTypes.get();
    }

    void dumpPss(PrintWriter pw, String prefix, long nowUptime) {
        Object r0 = this.mProfilerLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mService.mAppProfiler.isProfilingPss() == false) goto L9;
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("lastPssTime=");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mLastPssTime, nowUptime, pw);     // Catch: Throwable -> L7
        pw.print(" pssProcState=");     // Catch: Throwable -> L7
        pw.print(this.mPssProcState);     // Catch: Throwable -> L7
        pw.print(" pssStatType=");     // Catch: Throwable -> L7
        pw.print(this.mPssStatType);     // Catch: Throwable -> L7
        pw.print(" nextPssTime=");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mNextPssTime, nowUptime, pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("lastPss=");     // Catch: Throwable -> L7
        DebugUtils.printSizeValue(pw, this.mLastPss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: Throwable -> L7
        pw.print(" lastSwapPss=");     // Catch: Throwable -> L7
        DebugUtils.printSizeValue(pw, this.mLastSwapPss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: Throwable -> L7
        pw.print(" lastCachedPss=");     // Catch: Throwable -> L7
        DebugUtils.printSizeValue(pw, this.mLastCachedPss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: Throwable -> L7
        pw.print(" lastCachedSwapPss=");     // Catch: Throwable -> L7
        DebugUtils.printSizeValue(pw, this.mLastCachedSwapPss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: Throwable -> L7
        pw.print(" lastRss=");     // Catch: Throwable -> L7
        DebugUtils.printSizeValue(pw, this.mLastRss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: Throwable -> L7
    L10:
        pw.println();     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("trimMemoryLevel=");     // Catch: Throwable -> L7
        pw.println(this.mTrimMemoryLevel);     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("procStateMemTracker: ");     // Catch: Throwable -> L7
        this.mProcStateMemTracker.dumpLine(pw);     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("lastRequestedGc=");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mLastRequestedGc, nowUptime, pw);     // Catch: Throwable -> L7
        pw.print(" lastLowMemory=");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mLastLowMemory, nowUptime, pw);     // Catch: Throwable -> L7
        pw.print(" reportLowMemory=");     // Catch: Throwable -> L7
        pw.println(this.mReportLowMemory);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        pw.print(prefix);
        pw.print("currentHostingComponentTypes=0x");
        pw.print(Integer.toHexString(getCurrentHostingComponentTypes()));
        pw.print(" historicalHostingComponentTypes=0x");
        pw.println(Integer.toHexString(getHistoricalHostingComponentTypes()));
        return;
    L9:
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("lastRssTime=");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mLastPssTime, nowUptime, pw);     // Catch: Throwable -> L7
        pw.print(" rssProcState=");     // Catch: Throwable -> L7
        pw.print(this.mPssProcState);     // Catch: Throwable -> L7
        pw.print(" rssStatType=");     // Catch: Throwable -> L7
        pw.print(this.mPssStatType);     // Catch: Throwable -> L7
        pw.print(" nextRssTime=");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mNextPssTime, nowUptime, pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("lastRss=");     // Catch: Throwable -> L7
        DebugUtils.printSizeValue(pw, this.mLastRss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: Throwable -> L7
        pw.print(" lastCachedRss=");     // Catch: Throwable -> L7
        DebugUtils.printSizeValue(pw, this.mLastCachedRss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: Throwable -> L7
        goto L10
    }

    void dumpCputime(PrintWriter pw, String prefix) {
        long lastCpuTime = this.mLastCpuTime.get();
        pw.print(prefix);
        pw.print("lastCpuTime=");
        pw.print(lastCpuTime);
        if (lastCpuTime <= 0) goto L5;
        pw.print(" timeUsed=");
        TimeUtils.formatDuration(this.mCurCpuTime.get() - lastCpuTime, pw);
    L5:
        pw.println();
    }
}
