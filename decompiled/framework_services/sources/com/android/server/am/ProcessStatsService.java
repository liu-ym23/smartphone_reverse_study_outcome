package com.android.server.am;

import android.os.Binder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.format.DateFormat;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.procstats.DumpUtils;
import com.android.internal.app.procstats.IProcessStats;
import com.android.internal.app.procstats.ProcessState;
import com.android.internal.app.procstats.ProcessStats;
import com.android.internal.app.procstats.ProcessStatsInternal;
import com.android.internal.app.procstats.ServiceState;
import com.android.internal.app.procstats.UidState;
import com.android.internal.os.BackgroundThread;
import com.android.server.LocalServices;
import dalvik.annotation.optimization.NeverCompile;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessStatsService extends IProcessStats.Stub {
    static final boolean DEBUG = false;
    static final int MAX_HISTORIC_STATES = 8;
    static final String STATE_FILE_CHECKIN_SUFFIX = ".ci";
    static final String STATE_FILE_PREFIX = "state-v2-";
    static final String STATE_FILE_SUFFIX = ".bin";
    static final String TAG = "ProcessStatsService";
    static long WRITE_PERIOD;
    final ActivityManagerService mAm;
    final File mBaseDir;
    boolean mCommitPending;
    AtomicFile mFile;
    final ReentrantLock mFileLock;
    Boolean mInjectedScreenState;
    int mLastMemOnlyState;
    long mLastWriteTime;
    final Object mLock;
    boolean mMemFactorLowered;
    IProcessStatsServiceOptEx mOptEx;
    Parcel mPendingWrite;
    boolean mPendingWriteCommitted;
    AtomicFile mPendingWriteFile;
    final Object mPendingWriteLock;
    final ProcessStats mProcessStats;
    boolean mShuttingDown;

    private final class LocalService extends ProcessStatsInternal {
        final /* synthetic */ ProcessStatsService this$0;

        /* synthetic */ LocalService(ProcessStatsService r1, ProcessStatsServiceIA r2) {
            this(r1);
        }

        private LocalService(ProcessStatsService r1) {
            this.this$0 = r1;
        }

        public SparseArray<long[]> getUidProcStateStatsOverTime(long minTime) {
            return ProcessStatsService.m1573$$Nest$mgetUidProcStateStatsOverTime(this.this$0, minTime);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$gFOgl7-fhr_FeWQN9TFsgKRPU8g, reason: not valid java name */
    public static /* synthetic */ void m1572$r8$lambda$gFOgl7fhr_FeWQN9TFsgKRPU8g(ProcessStatsService r0, boolean r1, boolean r2) {
        r0.lambda$scheduleRequestPssAllProcs$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUidProcStateStatsOverTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m1573$$Nest$mgetUidProcStateStatsOverTime(ProcessStatsService r0, long r1) {
        return r0.getUidProcStateStatsOverTime(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mperformWriteState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1574$$Nest$mperformWriteState(ProcessStatsService r0, long r1) {
        r0.performWriteState(r1);
    }

    static {
        WRITE_PERIOD = 1800000;
    }

    public ProcessStatsService(ActivityManagerService am, File file) {
        this.mLock = new Object();
        this.mPendingWriteLock = new Object();
        this.mFileLock = new ReentrantLock();
        this.mLastMemOnlyState = -1;
        this.mAm = am;
        this.mBaseDir = file;
        this.mBaseDir.mkdirs();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mProcessStats = new ProcessStats(true);     // Catch: Throwable -> L8
        updateFileLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        SystemProperties.addChangeCallback(new AnonymousClass1(this));
        this.mOptEx = SysMonitorSvcBridge.getFactory().getProcessStatsServiceOptEx();
        this.mOptEx.init(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    L4:
        e = move-exception;
        if ((e instanceof SecurityException) == true) goto L8;
        Slog.wtf(TAG, "Process Stats Crash", e);
    L8:
        throw e;
    }

    void updateProcessStateHolderLocked(ProcessStats.ProcessStateHolder holder, String packageName, int uid, long versionCode, String processName) {
        holder.pkg = this.mProcessStats.getPackageStateLocked(packageName, uid, versionCode);
        holder.state = this.mProcessStats.getProcessStateLocked(holder.pkg, processName);
    }

    ProcessState getProcessStateLocked(String packageName, int uid, long versionCode, String processName) {
        return this.mProcessStats.getProcessStateLocked(packageName, uid, versionCode, processName);
    }

    ServiceState getServiceState(String packageName, int uid, long versionCode, String processName, String className) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        ServiceState r10 = this.mProcessStats.getServiceStateLocked(packageName, uid, versionCode, processName, className);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r10;
    L9:
        th = move-exception;
        Throwable r11 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r11;
    L11:
        th = move-exception;
        r11 = th;
        goto L13
    }

    boolean isMemFactorLowered() {
        return this.mMemFactorLowered;
    }

    boolean setMemFactorLocked(int memFactor, boolean screenOn, long now) {
        if (memFactor >= this.mLastMemOnlyState) goto L5;
        boolean r0 = true;
    L6:
        this.mMemFactorLowered = r0;
        this.mLastMemOnlyState = memFactor;
        if (this.mInjectedScreenState == null) goto L9;
        screenOn = this.mInjectedScreenState.booleanValue();
    L9:
        if (screenOn == false) goto L12;
        memFactor = memFactor + 4;
    L12:
        if (memFactor != this.mProcessStats.mMemFactor) goto L14;
        return false;
    L14:
        if (this.mProcessStats.mMemFactor == (-1)) goto L16;
        long[] r1 = this.mProcessStats.mMemFactorDurations;
        int r2 = this.mProcessStats.mMemFactor;
        r1[r2] = r1[r2] + (now - this.mProcessStats.mStartTime);
    L16:
        this.mProcessStats.mMemFactor = memFactor;
        this.mProcessStats.mStartTime = now;
        ArrayMap<String, SparseArray<LongSparseArray<ProcessStats.PackageState>>> pmap = this.mProcessStats.mPackages.getMap();
        int ipkg = pmap.size() - 1;
    L17:
        if (ipkg < 0) goto L29;
        SparseArray<LongSparseArray<ProcessStats.PackageState>> uids = pmap.valueAt(ipkg);
        int iuid = uids.size() - 1;
    L19:
        if (iuid < 0) goto L27;
        LongSparseArray<ProcessStats.PackageState> vers = uids.valueAt(iuid);
        int iver = vers.size() - 1;
    L21:
        if (iver < 0) goto L26;
        ProcessStats.PackageState pkg = vers.valueAt(iver);
        ArrayMap<String, ServiceState> services = pkg.mServices;
        int isvc = services.size() - 1;
    L23:
        if (isvc < 0) goto L25;
        ServiceState service = services.valueAt(isvc);
        service.setMemFactor(memFactor, now);
        isvc = isvc - 1;
        goto L23
    L25:
        iver = iver - 1;
        goto L21
    L26:
        iuid = iuid - 1;
        goto L19
    L27:
        ipkg = ipkg - 1;
        goto L17
    L29:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    int getMemFactorLocked() {
        if (this.mProcessStats.mMemFactor != (-1)) goto L7;
        return 0;
    L7:
        return this.mProcessStats.mMemFactor;
    }

    public void addSysMemUsageLocked(long cachedMem, long freeMem, long zramMem, long kernelMem, long nativeMem, long ionHeapOtherMem, long usedRAMMem, long freeRAMMem, long javaTotalMem, long javaCachedMem) {
        this.mProcessStats.addSysMemUsage(cachedMem, freeMem, zramMem, kernelMem, nativeMem, ionHeapOtherMem, usedRAMMem, freeRAMMem, javaTotalMem, javaCachedMem);
    }

    void addSysMemUsageLocked(long cachedMem, long freeMem, long zramMem, long kernelMem, long nativeMem) {
        addSysMemUsageLocked(cachedMem, freeMem, zramMem, kernelMem, nativeMem, -1, -1, -1, -1, -1);
    }

    void updateTrackingAssociationsLocked(int curSeq, long now) {
        this.mProcessStats.updateTrackingAssociationsLocked(curSeq, now);
    }

    boolean shouldWriteNowLocked(long now) {
        if (now > (this.mLastWriteTime + WRITE_PERIOD)) goto L5;
        return false;
    L5:
        if (SystemClock.elapsedRealtime() > (this.mProcessStats.mTimePeriodStartRealtime + ProcessStats.COMMIT_PERIOD)) goto L7;
    L9:
        return true;
    L7:
        if (SystemClock.uptimeMillis() <= (this.mProcessStats.mTimePeriodStartUptime + ProcessStats.COMMIT_UPTIME_PERIOD)) goto L9;
        this.mCommitPending = true;
        goto L9
    }

    void shutdown() {
        Slog.w(TAG, "Writing process stats before shutdown...");
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mProcessStats.mFlags |= 2;     // Catch: Throwable -> L7
        writeStateSyncLocked();     // Catch: Throwable -> L7
        this.mShuttingDown = true;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void writeStateAsync() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        writeStateLocked(false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void writeStateSyncLocked() {
        writeStateLocked(true);
    }

    private void writeStateLocked(boolean sync) {
        if (this.mShuttingDown == false) goto L5;
        return;
    L5:
        boolean commitPending = this.mCommitPending;
        this.mCommitPending = false;
        writeStateLocked(sync, commitPending);
    }

    void writeStateLocked(boolean sync, boolean commit) {
        Object r0 = this.mPendingWriteLock;
        monitor-enter(r0);
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        if (this.mPendingWrite == null) goto L11;
        if (this.mPendingWriteCommitted == false) goto L11;
    L15:
        if (commit == false) goto L17;
        this.mOptEx.pendingCommit();     // Catch: Throwable -> L9
        this.mProcessStats.resetSafely();     // Catch: Throwable -> L9
        updateFileLocked();     // Catch: Throwable -> L9
        scheduleRequestPssAllProcs(true, false);     // Catch: Throwable -> L9
    L17:
        this.mLastWriteTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        final long totalTime = SystemClock.uptimeMillis() - now;     // Catch: Throwable -> L9
        if (sync == true) goto L23;
        BackgroundThread.getHandler().post(new AnonymousClass2(this, totalTime));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L9
        performWriteState(totalTime);
        return;
    L11:
        this.mPendingWrite = Parcel.obtain();     // Catch: Throwable -> L9
        this.mProcessStats.mTimePeriodEndRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        this.mProcessStats.mTimePeriodEndUptime = now;     // Catch: Throwable -> L9
        if (commit == false) goto L14;
        this.mProcessStats.mFlags |= 1;     // Catch: Throwable -> L9
    L14:
        this.mProcessStats.writeToParcel(this.mPendingWrite, 0);     // Catch: Throwable -> L9
        this.mPendingWriteFile = new AtomicFile(getCurrentFile());     // Catch: Throwable -> L9
        this.mPendingWriteCommitted = commit;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void scheduleRequestPssAllProcs(final boolean always, final boolean memLowered) {
        this.mAm.mHandler.post(new ProcessStatsService$$ExternalSyntheticLambda0(this, always, memLowered));
    }

    private /* synthetic */ void lambda$scheduleRequestPssAllProcs$0(boolean always, boolean memLowered) {
        ActivityManagerGlobalLock r0 = this.mAm.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        this.mAm.mAppProfiler.requestPssAllProcsLPr(SystemClock.uptimeMillis(), always, memLowered);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private void updateFileLocked() {
        this.mFileLock.lock();
        this.mFile = new AtomicFile(new File(this.mBaseDir, STATE_FILE_PREFIX + this.mProcessStats.mTimePeriodStartClockStr + STATE_FILE_SUFFIX));     // Catch: Throwable -> L6
        this.mFileLock.unlock();
        this.mLastWriteTime = SystemClock.uptimeMillis();
        return;
    L6:
        th = move-exception;
        this.mFileLock.unlock();
        throw th;
    }

    private File getCurrentFile() {
        this.mFileLock.lock();
        File r0 = this.mFile.getBaseFile();     // Catch: Throwable -> L6
        this.mFileLock.unlock();
        return r0;
    L6:
        th = move-exception;
        this.mFileLock.unlock();
        throw th;
    }

    private void performWriteState(long initialTime) {
        Object r0 = this.mPendingWriteLock;
        monitor-enter(r0);
        Parcel data = this.mPendingWrite;     // Catch: Throwable -> L8
        AtomicFile file = this.mPendingWriteFile;     // Catch: Throwable -> L8
        this.mPendingWriteCommitted = false;     // Catch: Throwable -> L8
        if (data != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mOptEx.saveData(data);     // Catch: Throwable -> L8
        this.mPendingWrite = null;     // Catch: Throwable -> L8
        this.mPendingWriteFile = null;     // Catch: Throwable -> L8
        this.mFileLock.lock();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        long startTime = SystemClock.uptimeMillis();
        FileOutputStream stream = null;
        stream = file.startWrite();     // Catch: Throwable -> L15 IOException -> L17
        stream.write(data.marshall());     // Catch: Throwable -> L15 IOException -> L17
        stream.flush();     // Catch: Throwable -> L15 IOException -> L17
        file.finishWrite(stream);     // Catch: Throwable -> L15 IOException -> L17
        com.android.internal.logging.EventLogTags.writeCommitSysConfigFile("procstats", (SystemClock.uptimeMillis() - startTime) + initialTime);     // Catch: Throwable -> L15 IOException -> L17
    L14:
        data.recycle();
        trimHistoricStatesWriteLF();
        this.mFileLock.unlock();
        return;
    L17:
        e = move-exception;
        Slog.w(TAG, "Error writing process statistics", e);     // Catch: Throwable -> L15
        file.failWrite(stream);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        data.recycle();
        trimHistoricStatesWriteLF();
        this.mFileLock.unlock();
        throw th;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean readLF(ProcessStats stats, AtomicFile file) {
        FileInputStream stream = file.openRead();     // Catch: Throwable -> L7
        stats.read(stream);     // Catch: Throwable -> L7
        stream.close();     // Catch: Throwable -> L7
        if (stats.mReadError == null) goto L9;
        Slog.w(TAG, "Ignoring existing stats; " + stats.mReadError);     // Catch: Throwable -> L7
        return false;
    L9:
        return true;
    L7:
        e = move-exception;
        stats.mReadError = "caught exception: " + e;
        Slog.e(TAG, "Error reading process statistics", e);
        return false;
    }

    private ArrayList<String> getCommittedFilesLF(int minNum, boolean inclCurrent, boolean inclCheckedIn) {
        File[] files = this.mBaseDir.listFiles();
        if (files != null) goto L5;
        return null;
    L5:
        if (files.length <= minNum) goto L32;
        ArrayList<String> filesArray = new ArrayList(files.length);
        String currentFile = this.mFile.getBaseFile().getPath();
        int i = 0;
    L9:
        if (i >= files.length) goto L23;
        File file = files[i];
        String fileStr = file.getPath();
        if (file.getName().startsWith(STATE_FILE_PREFIX) == false) goto L22;
        if (inclCheckedIn == false) goto L15;
    L17:
        if (inclCurrent == false) goto L19;
    L21:
        filesArray.add(fileStr);
        goto L22
    L19:
        if (fileStr.equals(currentFile) == false) goto L21;
    L15:
        if (fileStr.endsWith(STATE_FILE_CHECKIN_SUFFIX) == false) goto L17;
    L22:
        i = i + 1;
        goto L9
    L23:
        Collections.sort(filesArray);
        return filesArray;
    L32:
        return null;
    }

    private void trimHistoricStatesWriteLF() {
        File[] files = this.mBaseDir.listFiles();
        if (files == null) goto L11;
        int i = 0;
    L6:
        if (i >= files.length) goto L11;
        if (files[i].getName().startsWith(STATE_FILE_PREFIX) == true) goto L10;
        files[i].delete();
    L10:
        i = i + 1;
    L11:
        ArrayList<String> filesArray = getCommittedFilesLF(8, false, true);
        if (filesArray != null) goto L15;
        return;
    L15:
        if (filesArray.size() <= 8) goto L17;
        String file = filesArray.remove(0);
        Slog.i(TAG, "Pruning old procstats: " + file);
        new File(file).delete();
        goto L15
    }

    private boolean dumpFilteredProcessesCsvLocked(PrintWriter pw, String header, boolean sepScreenStates, int[] screenStates, boolean sepMemStates, int[] memStates, boolean sepProcStates, int[] procStates, long now, String reqPackage) {
        ArrayList<ProcessState> procs = this.mProcessStats.collectProcessesLocked(screenStates, memStates, procStates, procStates, now, reqPackage, false);
        if (procs.size() <= 0) goto L8;
        if (header == null) goto L6;
        pw.println(header);
    L6:
        DumpUtils.dumpProcessListCsv(pw, procs, sepScreenStates, screenStates, sepMemStates, memStates, sepProcStates, procStates, now);
        return true;
    L8:
        return false;
    }

    static int[] parseStateList(String[] states, int mult, String arg, boolean[] outSep, String[] outError) {
        ArrayList<Integer> res = new ArrayList();
        int lastPos = 0;
        int i = 0;
    L4:
        if (i > arg.length()) goto L42;
        if (i >= arg.length()) goto L8;
        char c = arg.charAt(i);
    L10:
        if (c != ',') goto L12;
    L17:
        if (c != ',') goto L19;
        boolean isSep = true;
    L21:
        if (lastPos != 0) goto L23;
        outSep[0] = isSep;
    L29:
        if (lastPos >= (i - 1)) goto L40;
        String str = arg.substring(lastPos, i);
        int j = 0;
    L32:
        if (j >= states.length) goto L37;
        if (str.equals(states[j]) == true) goto L35;
        j = j + 1;
        goto L32
    L35:
        res.add(Integer.valueOf(j));
        str = null;
    L37:
        if (str == null) goto L40;
        outError[0] = "invalid word \"" + str + "\"";
        return null;
    L40:
        lastPos = i + 1;
    L41:
        i = i + 1;
        goto L4
    L23:
        if (c == 0) goto L29;
        if (outSep[0] == isSep) goto L29;
        outError[0] = "inconsistent separators (can't mix ',' with '+')";
        return null;
    L19:
        isSep = false;
        goto L21
    L12:
        if (c == '+') goto L17;
        if (c == ' ') goto L17;
        if (c == 0) goto L17;
    L8:
        c = 0;
        goto L10
    L42:
        int i2 = res.size();
        int[] finalRes = new int[i2];
        int i3 = 0;
    L44:
        if (i3 >= res.size()) goto L47;
        finalRes[i3] = res.get(i3).intValue() * mult;
        i3 = i3 + 1;
        goto L44
    L47:
        return finalRes;
    }

    static int parseSectionOptions(String optionsStr) {
        String[] sectionsStr = optionsStr.split(",");
        if (sectionsStr.length != 0) goto L6;
        return 31;
    L6:
        int res = 0;
        List<String> optionStrList = Arrays.asList(ProcessStats.OPTIONS_STR);
        int r4 = sectionsStr.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L12;
        String sectionStr = sectionsStr[r5];
        int optionIndex = optionStrList.indexOf(sectionStr);
        if (optionIndex == (-1)) goto L11;
        res = res | ProcessStats.OPTIONS[optionIndex];
    L11:
        r5 = r5 + 1;
        goto L7
    L12:
        return res;
    }

    public byte[] getCurrentStats(List<ParcelFileDescriptor> historic) {
        super.getCurrentStats_enforcePermission();
        Parcel current = Parcel.obtain();
        Object r1 = this.mLock;
        monitor-enter(r1);
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L25
        this.mProcessStats.mTimePeriodEndRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L25
        this.mProcessStats.mTimePeriodEndUptime = now;     // Catch: Throwable -> L25
        this.mProcessStats.writeToParcel(current, now, 0);     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        this.mFileLock.lock();
        if (historic != null) goto L28;
    L23:
        this.mFileLock.unlock();
        return current.marshall();
    L28:
        ArrayList<String> files = getCommittedFilesLF(0, false, true);     // Catch: Throwable -> L16
        if (files == null) goto L23;
        int i = files.size() - 1;
    L13:
        if (i < 0) goto L23;
        ParcelFileDescriptor pfd = ParcelFileDescriptor.open(new File(files.get(i)), 268435456);     // Catch: Throwable -> L16 IOException -> L18
        historic.add(pfd);     // Catch: Throwable -> L16 IOException -> L18
    L20:
        i = i - 1;
    L18:
        e = move-exception;
        Slog.w(TAG, "Failure opening procstat file " + files.get(i), e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mFileLock.unlock();
        throw th;
    L25:
        th = move-exception;
        throw th;
    }

    public long getCommittedStats(long highWaterMarkMs, int section, boolean doAggregate, List<ParcelFileDescriptor> committedStats) {
        return getCommittedStatsMerged(highWaterMarkMs, section, doAggregate, committedStats, new ProcessStats(false));
    }

    public long getCommittedStatsMerged(long highWaterMarkMs, int section, boolean doAggregate, List<ParcelFileDescriptor> committedStats, ProcessStats mergedStats) {
        String r5 = STATE_FILE_PREFIX;
        String r6 = TAG;
        super.getCommittedStatsMerged_enforcePermission();
        long newHighWaterMark = highWaterMarkMs;
        this.mFileLock.lock();
        ArrayList<String> files = getCommittedFilesLF(0, false, true);     // Catch: Throwable -> L59 IOException -> L61
        if (files == null) goto L64;
        String highWaterMarkStr = DateFormat.format("yyyy-MM-dd-HH-mm-ss", highWaterMarkMs).toString();     // Catch: Throwable -> L20 IOException -> L49
        int i = files.size() - 1;     // Catch: Throwable -> L20 IOException -> L49
    L8:
        if (i < 0) goto L54;
        String fileName = files.get(i);     // Catch: Throwable -> L20 IOException -> L49
        String startTimeStr = fileName.substring(fileName.lastIndexOf(r5) + r5.length(), fileName.lastIndexOf(STATE_FILE_SUFFIX));     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L41 IOException -> L43
        if (startTimeStr.compareToIgnoreCase(highWaterMarkStr) <= 0) goto L45;
        ParcelFileDescriptor pfd = ParcelFileDescriptor.open(new File(fileName), 268435456);     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L41 IOException -> L43
        InputStream is = new ParcelFileDescriptor.AutoCloseInputStream(pfd);     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L41 IOException -> L43
        String r19 = r5;
        ProcessStats stats = new ProcessStats(false);     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L36 IOException -> L38
        stats.read(is);     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L36 IOException -> L38
        is.close();     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L36 IOException -> L38
        String r16 = r6;
        if (stats.mTimePeriodStartClock <= newHighWaterMark) goto L26;
        newHighWaterMark = stats.mTimePeriodStartClock;     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L22 IOException -> L24
    L26:
        if (doAggregate == false) goto L28;
        mergedStats.add(stats);     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L22 IOException -> L24
    L31:
        if (stats.mReadError != null) goto L33;
        r6 = r16;
    L52:
        i = i - 1;     // Catch: Throwable -> L20 IOException -> L49
        r5 = r19;
        goto L8
    L33:
        r6 = r16;
        Log.w(r6, "Failure reading process stats: " + stats.mReadError);     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L36 IOException -> L38
    L28:
        if (committedStats == null) goto L31;
        committedStats.add(protoToParcelFileDescriptor(stats, section));     // Catch: Throwable -> L20 IndexOutOfBoundsException -> L22 IOException -> L24
        goto L31
    L24:
        e = e;
        r6 = r16;
    L51:
        Slog.w(r6, "Failure opening procstat file " + fileName, e);     // Catch: Throwable -> L20 IOException -> L49
    L22:
        e = e;
        r6 = r16;
    L48:
        Slog.w(r6, "Failure to read and parse commit file " + fileName, e);     // Catch: Throwable -> L20 IOException -> L49
    L38:
        e = e;
    L36:
        e = e;
        goto L48
    L45:
        r19 = r5;
    L43:
        e = e;
        r19 = r5;
    L41:
        e = e;
        r19 = r5;
        goto L48
    L54:
        if (doAggregate == false) goto L57;
        if (committedStats == null) goto L57;
        committedStats.add(protoToParcelFileDescriptor(mergedStats, section));     // Catch: Throwable -> L20 IOException -> L49
    L57:
        this.mFileLock.unlock();
        return newHighWaterMark;
    L49:
        e = e;
    L66:
        Slog.w(r6, "Failure opening procstat file", e);     // Catch: Throwable -> L20
    L64:
        this.mFileLock.unlock();
        return newHighWaterMark;
    L20:
        th = th;
    L69:
        this.mFileLock.unlock();
        throw th;
    L61:
        e = e;
    L59:
        th = th;
        goto L69
    }

    public long getMinAssociationDumpDuration() {
        ActivityManagerConstants r0 = this.mAm.mConstants;
        return ActivityManagerConstants.MIN_ASSOC_LOG_DURATION;
    }

    private static ParcelFileDescriptor protoToParcelFileDescriptor(final ProcessStats stats, final int section) throws IOException {
        final ParcelFileDescriptor[] fds = ParcelFileDescriptor.createPipe();
        final String r2 = "ProcessStats pipe output";
        Thread thr = new AnonymousClass3(r2, fds, stats, section);
        thr.start();
        return fds[0];
    }

    public ParcelFileDescriptor getStatsOverTime(long minTime) {
        super.getStatsOverTime_enforcePermission();
        Parcel current = Parcel.obtain();
        Object r2 = this.mLock;
        monitor-enter(r2);
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L35
        this.mProcessStats.mTimePeriodEndRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L35
        this.mProcessStats.mTimePeriodEndUptime = now;     // Catch: Throwable -> L35
        this.mProcessStats.writeToParcel(current, now, 0);     // Catch: Throwable -> L35
        long curTime = this.mProcessStats.mTimePeriodEndRealtime - this.mProcessStats.mTimePeriodStartRealtime;     // Catch: Throwable -> L35
        monitor-exit(r2);     // Catch: Throwable -> L35
        this.mFileLock.lock();
        if (curTime < minTime) goto L38;
    L26:
        final byte[] outData = current.marshall();     // Catch: Throwable -> L20 IOException -> L22
        current.recycle();     // Catch: Throwable -> L20 IOException -> L22
        final ParcelFileDescriptor[] fds = ParcelFileDescriptor.createPipe();     // Catch: Throwable -> L20 IOException -> L22
        final String r4 = "ProcessStats pipe output";
        Thread thr = new AnonymousClass4(this, r4, fds, outData);     // Catch: Throwable -> L20 IOException -> L22
        thr.start();     // Catch: Throwable -> L20 IOException -> L22
        ParcelFileDescriptor r5 = fds[0];     // Catch: Throwable -> L20 IOException -> L22
        this.mFileLock.unlock();
        return r5;
    L22:
        e = move-exception;
        Slog.w(TAG, "Failed building output pipe", e);     // Catch: Throwable -> L20
        this.mFileLock.unlock();
        return null;
    L20:
        th = move-exception;
        this.mFileLock.unlock();
        throw th;
    L38:
        ArrayList<String> files = getCommittedFilesLF(0, false, true);     // Catch: Throwable -> L20 IOException -> L22
        if (files == null) goto L26;
        if (files.size() <= 0) goto L26;
        current.setDataPosition(0);     // Catch: Throwable -> L20 IOException -> L22
        ProcessStats stats = (ProcessStats) ProcessStats.CREATOR.createFromParcel(current);     // Catch: Throwable -> L20 IOException -> L22
        current.recycle();     // Catch: Throwable -> L20 IOException -> L22
        int i = files.size() - 1;     // Catch: Throwable -> L20 IOException -> L22
    L14:
        if (i < 0) goto L25;
        if ((stats.mTimePeriodEndRealtime - stats.mTimePeriodStartRealtime) >= minTime) goto L25;
        AtomicFile file = new AtomicFile(new File(files.get(i)));     // Catch: Throwable -> L20 IOException -> L22
        i = i - 1;     // Catch: Throwable -> L20 IOException -> L22
        ProcessStats moreStats = new ProcessStats(false);     // Catch: Throwable -> L20 IOException -> L22
        readLF(moreStats, file);     // Catch: Throwable -> L20 IOException -> L22
        if (moreStats.mReadError == null) goto L19;
        Slog.w(TAG, "Failure reading " + files.get(i + 1) + "; " + moreStats.mReadError);     // Catch: Throwable -> L20 IOException -> L22
        goto L14
    L19:
        stats.add(moreStats);     // Catch: Throwable -> L20 IOException -> L22
        StringBuilder sb = new StringBuilder();     // Catch: Throwable -> L20 IOException -> L22
        sb.append("Added stats: ");     // Catch: Throwable -> L20 IOException -> L22
        sb.append(moreStats.mTimePeriodStartClockStr);     // Catch: Throwable -> L20 IOException -> L22
        sb.append(", over ");     // Catch: Throwable -> L20 IOException -> L22
        TimeUtils.formatDuration(moreStats.mTimePeriodEndRealtime - moreStats.mTimePeriodStartRealtime, sb);     // Catch: Throwable -> L20 IOException -> L22
        Slog.i(TAG, sb.toString());     // Catch: Throwable -> L20 IOException -> L22
    L25:
        current = Parcel.obtain();     // Catch: Throwable -> L20 IOException -> L22
        stats.writeToParcel(current, 0);     // Catch: Throwable -> L20 IOException -> L22
    L35:
        th = move-exception;
        throw th;
    }

    public int getCurrentMemoryState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mLastMemOnlyState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private SparseArray<long[]> getUidProcStateStatsOverTime(long minTime) {
        ProcessStats stats = new ProcessStats();
        Object r1 = this.mLock;
        monitor-enter(r1);
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L31
        this.mProcessStats.mTimePeriodEndRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L31
        this.mProcessStats.mTimePeriodEndUptime = now;     // Catch: Throwable -> L31
        stats.add(this.mProcessStats);     // Catch: Throwable -> L31
        long curTime = this.mProcessStats.mTimePeriodEndRealtime - this.mProcessStats.mTimePeriodStartRealtime;     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        if (curTime < minTime) goto L34;
    L26:
        SparseArray<UidState> uidStates = stats.mUidStates;
        SparseArray<long[]> results = new SparseArray();
        int i = 0;
        int size = uidStates.size();
    L27:
        if (i >= size) goto L30;
        int uid = uidStates.keyAt(i);
        UidState uidState = uidStates.valueAt(i);
        results.put(uid, uidState.getAggregatedDurationsInStates());
        i = i + 1;
        goto L27
    L30:
        return results;
    L34:
        this.mFileLock.lock();     // Catch: Throwable -> L19
        ArrayList<String> files = getCommittedFilesLF(0, false, true);     // Catch: Throwable -> L19
        if (files != null) goto L11;
    L23:
        this.mFileLock.unlock();
        goto L26
    L11:
        if (files.size() <= 0) goto L23;
        int i2 = files.size() - 1;     // Catch: Throwable -> L19
    L13:
        if (i2 < 0) goto L23;
        if ((stats.mTimePeriodEndRealtime - stats.mTimePeriodStartRealtime) >= minTime) goto L23;
        AtomicFile file = new AtomicFile(new File(files.get(i2)));     // Catch: Throwable -> L19
        i2 = i2 - 1;     // Catch: Throwable -> L19
        ProcessStats moreStats = new ProcessStats(false);     // Catch: Throwable -> L19
        readLF(moreStats, file);     // Catch: Throwable -> L19
        if (moreStats.mReadError == null) goto L18;
        Slog.w(TAG, "Failure reading " + files.get(i2 + 1) + "; " + moreStats.mReadError);     // Catch: Throwable -> L19
        goto L13
    L18:
        stats.add(moreStats);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.mFileLock.unlock();
        throw th;
    L31:
        th = move-exception;
        throw th;
    }

    void publish() {
        LocalServices.addService(ProcessStatsInternal.class, new LocalService(this, null));
    }

    private void dumpAggregatedStats(PrintWriter pw, long aggregateHours, long now, String reqPackage, boolean isCompact, boolean dumpDetails, boolean dumpFullDetails, boolean dumpAll, boolean activeOnly, int section) {
        ParcelFileDescriptor pfd = getStatsOverTime((((aggregateHours * 60) * 60) * 1000) - (ProcessStats.COMMIT_PERIOD / 2));
        if (pfd != null) goto L6;
        pw.println("Unable to build stats!");
        return;
    L6:
        ProcessStats stats = new ProcessStats(false);
        InputStream stream = new ParcelFileDescriptor.AutoCloseInputStream(pfd);
        stats.read(stream);
        if (stats.mReadError == null) goto L10;
        pw.print("Failure reading: ");
        pw.println(stats.mReadError);
        return;
    L10:
        if (isCompact == false) goto L13;
        stats.dumpCheckinLocked(pw, reqPackage, section);
        return;
    L13:
        if (dumpDetails == true) goto L17;
        if (dumpFullDetails == true) goto L17;
        stats.dumpSummaryLocked(pw, reqPackage, now, activeOnly);
        return;
    L17:
        stats.dumpLocked(pw, reqPackage, now, !dumpFullDetails, dumpDetails, dumpAll, activeOnly, section);
    }

    private static void dumpHelp(PrintWriter pw) {
        pw.println("Process stats (procstats) dump options:");
        pw.println("    [--checkin|-c|--csv] [--csv-screen] [--csv-proc] [--csv-mem]");
        pw.println("    [--details] [--full-details] [--current] [--hours N] [--last N]");
        pw.println("    [--max N] --active] [--commit] [--reset] [--clear] [--write] [-h]");
        pw.println("    [--start-testing] [--stop-testing] ");
        pw.println("    [--pretend-screen-on] [--pretend-screen-off] [--stop-pretend-screen]");
        pw.println("    [<package.name>]");
        pw.println("  --checkin: perform a checkin: print and delete old committed states.");
        pw.println("  -c: print only state in checkin format.");
        pw.println("  --csv: output data suitable for putting in a spreadsheet.");
        pw.println("  --csv-screen: on, off.");
        pw.println("  --csv-mem: norm, mod, low, crit.");
        pw.println("  --csv-proc: pers, top, fore, vis, precept, backup,");
        pw.println("    service, home, prev, cached");
        pw.println("  --details: dump per-package details, not just summary.");
        pw.println("  --full-details: dump all timing and active state details.");
        pw.println("  --current: only dump current state.");
        pw.println("  --hours: aggregate over about N last hours.");
        pw.println("  --last: only show the last committed stats at index N (starting at 1).");
        pw.println("  --max: for -a, max num of historical batches to print.");
        pw.println("  --active: only show currently active processes/services.");
        pw.println("  --commit: commit current stats to disk and reset to start new stats.");
        pw.println("  --section: proc|pkg-proc|pkg-svc|pkg-asc|pkg-all|all ");
        pw.println("    options can be combined to select desired stats");
        pw.println("  --reset: reset current stats, without committing.");
        pw.println("  --clear: clear all stats; does both --reset and deletes old stats.");
        pw.println("  --write: write current in-memory stats to disk.");
        pw.println("  --read: replace current stats with last-written stats.");
        pw.println("  --start-testing: clear all stats and starting high frequency pss sampling.");
        pw.println("  --stop-testing: stop high frequency pss sampling.");
        pw.println("  --pretend-screen-on: pretend screen is on.");
        pw.println("  --pretend-screen-off: pretend screen is off.");
        pw.println("  --stop-pretend-screen: forget \"pretend screen\" and use the real state.");
        pw.println("  -a: print everything.");
        pw.println("  -h: print this help text.");
        pw.println("  <package.name>: optional name of package to filter output by.");
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (com.android.internal.util.DumpUtils.checkDumpAndUsageStatsPermission(this.mAm.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        long ident = Binder.clearCallingIdentity();
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L7:
        if (args.length > 0) goto L9;
    L20:
        dumpInner(pw, args);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return;
    L9:
        if ("--proto".equals(args[0]) == false) goto L16;
        dumpProto(fd);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return;
    L16:
        if ("--statsd".equals(args[0]) == false) goto L20;
        dumpProtoForStatsd(fd);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NeverCompile
    private void dumpInner(PrintWriter r41, String[] r42) {
        long r3 = SystemClock.uptimeMillis();
        boolean r7 = false;
        boolean r8 = false;
        boolean r9 = false;
        boolean r10 = false;
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
        int r15 = 2;
        boolean r16 = false;
        String r17 = null;
        boolean r18 = false;
        boolean r19 = false;
        int[] r21 = {0, 4};
        boolean r22 = false;
        int[] r23 = {3};
        boolean r24 = true;
        int[] r25 = ProcessStats.ALL_PROC_STATES;
        int r26 = 31;
        if (r42 == null) goto L217;
        char r28 = 0;
        int r5 = 0;
        boolean r20 = false;
        boolean r27 = false;
    L6:
        if (r5 >= r42.length) goto L216;
        String r6 = r42[r5];
        if ("--checkin".equals(r6) == false) goto L11;
        r20 = true;
        long r31 = r3;
    L215:
        r5 = r5 + 1;
        r3 = r31;
        r28 = 0;
        r20 = r20;
        r27 = r27;
        goto L6
    L11:
        if ("-c".equals(r6) == false) goto L14;
        r19 = true;
        r31 = r3;
        goto L215
    L14:
        if ("--csv".equals(r6) == false) goto L17;
        r27 = true;
        r31 = r3;
        goto L215
    L17:
        if ("--csv-screen".equals(r6) == false) goto L27;
        int r14 = r5 + 1;
        if (r14 >= r42.length) goto L20;
        r31 = r3;
        boolean[] r0 = new boolean[1];
        String[] r4 = new String[1];
        boolean r34 = r7;
        int[] r29 = parseStateList(DumpUtils.ADJ_SCREEN_NAMES_CSV, 4, r42[r14], r0, r4);
        if (r29 == null) goto L24;
        r18 = r0[r28];
        r21 = r29;
        r5 = r14;
        r7 = r34;
        goto L215
    L24:
        r41.println("Error in \"" + r42[r14] + "\": " + r4[r28]);
        dumpHelp(r41);
        return;
    L20:
        r41.println("Error: argument required for --csv-screen");
        dumpHelp(r41);
        return;
    L27:
        r31 = r3;
        boolean r35 = r7;
        if ("--csv-mem".equals(r6) == false) goto L39;
        int r30 = r5 + 1;
        if (r30 >= r42.length) goto L31;
        boolean[] r1 = new boolean[1];
        String[] r32 = new String[1];
        int[] r33 = parseStateList(DumpUtils.ADJ_MEM_NAMES_CSV, 1, r42[r30], r1, r32);
        if (r33 == null) goto L35;
        r22 = r1[r28];
        r23 = r33;
        r5 = r30;
        r7 = r35;
        goto L215
    L35:
        r41.println("Error in \"" + r42[r30] + "\": " + r32[r28]);
        dumpHelp(r41);
        return;
    L31:
        r41.println("Error: argument required for --csv-mem");
        dumpHelp(r41);
        return;
    L39:
        if ("--csv-proc".equals(r6) == false) goto L50;
        int r36 = r5 + 1;
        if (r36 >= r42.length) goto L42;
        boolean[] r2 = new boolean[1];
        String[] r37 = new String[1];
        int[] r38 = parseStateList(DumpUtils.STATE_NAMES_CSV, 1, r42[r36], r2, r37);
        if (r38 == null) goto L46;
        r24 = r2[r28];
        r25 = r38;
        r5 = r36;
        r7 = r35;
        goto L215
    L46:
        r41.println("Error in \"" + r42[r36] + "\": " + r37[r28]);
        dumpHelp(r41);
        return;
    L42:
        r41.println("Error: argument required for --csv-proc");
        dumpHelp(r41);
        return;
    L50:
        if ("--details".equals(r6) == false) goto L53;
        r8 = true;
        r7 = r35;
        goto L215
    L53:
        if ("--full-details".equals(r6) == false) goto L56;
        r9 = true;
        r7 = r35;
        goto L215
    L56:
        if ("--hours".equals(r6) == false) goto L67;
        r5 = r5 + 1;
        if (r5 >= r42.length) goto L59;
        r12 = Integer.parseInt(r42[r5]);     // Catch: NumberFormatException -> L63
        r7 = r35;
    L64:
        r41.println("Error: --hours argument not an int -- " + r42[r5]);
        dumpHelp(r41);
        return;
    L59:
        r41.println("Error: argument required for --hours");
        dumpHelp(r41);
        return;
    L67:
        if ("--last".equals(r6) == false) goto L78;
        r5 = r5 + 1;
        if (r5 >= r42.length) goto L70;
        r13 = Integer.parseInt(r42[r5]);     // Catch: NumberFormatException -> L74
        r7 = r35;
    L75:
        r41.println("Error: --last argument not an int -- " + r42[r5]);
        dumpHelp(r41);
        return;
    L70:
        r41.println("Error: argument required for --last");
        dumpHelp(r41);
        return;
    L78:
        if ("--max".equals(r6) == false) goto L89;
        r5 = r5 + 1;
        if (r5 >= r42.length) goto L81;
        r15 = Integer.parseInt(r42[r5]);     // Catch: NumberFormatException -> L85
        r7 = r35;
    L86:
        r41.println("Error: --max argument not an int -- " + r42[r5]);
        dumpHelp(r41);
        return;
    L81:
        r41.println("Error: argument required for --max");
        dumpHelp(r41);
        return;
    L89:
        if ("--active".equals(r6) == false) goto L92;
        r16 = true;
        r7 = true;
        goto L215
    L92:
        if ("--current".equals(r6) == false) goto L95;
        r7 = true;
        goto L215
    L95:
        if ("--commit".equals(r6) == false) goto L105;
        Object r39 = this.mLock;
        monitor-enter(r39);
        this.mProcessStats.mFlags |= 1;     // Catch: Throwable -> L101
        writeStateLocked(true, true);     // Catch: Throwable -> L101
        r41.println("Process stats committed.");     // Catch: Throwable -> L101
        r11 = true;
        monitor-exit(r39);     // Catch: Throwable -> L101
        r7 = r35;
    L101:
        th = move-exception;
        throw th;
    L105:
        if ("--section".equals(r6) == false) goto L112;
        r5 = r5 + 1;
        if (r5 >= r42.length) goto L108;
        r26 = parseSectionOptions(r42[r5]);
        r7 = r35;
        goto L215
    L108:
        r41.println("Error: argument required for --section");
        dumpHelp(r41);
        return;
    L112:
        if ("--clear".equals(r6) == false) goto L136;
        Object r40 = this.mLock;
        monitor-enter(r40);
        this.mProcessStats.resetSafely();     // Catch: Throwable -> L129
        boolean r43 = r28;
        scheduleRequestPssAllProcs(true, r43);     // Catch: Throwable -> L129
        this.mFileLock.lock();     // Catch: Throwable -> L129
        ArrayList<String> r44 = getCommittedFilesLF(r43 ? 1 : 0, true, true);     // Catch: Throwable -> L122
        if (r44 == null) goto L126;
        int r45 = r44.size() - 1;     // Catch: Throwable -> L122
    L119:
        if (r45 < 0) goto L126;
        ArrayList<String> r310 = r44;
        new File(r44.get(r45)).delete();     // Catch: Throwable -> L122
        r45 = r45 - 1;
        r44 = r310;
        goto L119
    L126:
        this.mFileLock.unlock();     // Catch: Throwable -> L129
        r41.println("All process stats cleared.");     // Catch: Throwable -> L129
        r11 = true;
        monitor-exit(r40);     // Catch: Throwable -> L129
        r7 = r35;
    L122:
        th = move-exception;
        this.mFileLock.unlock();     // Catch: Throwable -> L129
        throw th;     // Catch: Throwable -> L129
    L129:
        th = move-exception;
        throw th;
    L136:
        if ("--write".equals(r6) == false) goto L146;
        Object r46 = this.mLock;
        monitor-enter(r46);
        writeStateSyncLocked();     // Catch: Throwable -> L142
        r41.println("Process stats written.");     // Catch: Throwable -> L142
        r11 = true;
        monitor-exit(r46);     // Catch: Throwable -> L142
        r7 = r35;
    L142:
        th = move-exception;
        throw th;
    L146:
        if ("--read".equals(r6) == false) goto L163;
        Object r47 = this.mLock;
        monitor-enter(r47);
        this.mFileLock.lock();     // Catch: Throwable -> L155
        readLF(this.mProcessStats, this.mFile);     // Catch: Throwable -> L157
        r41.println("Process stats read.");     // Catch: Throwable -> L157
        r11 = true;
        this.mFileLock.unlock();     // Catch: Throwable -> L155
        monitor-exit(r47);     // Catch: Throwable -> L155
        r7 = r35;
        goto L215
    L157:
        th = move-exception;
        this.mFileLock.unlock();     // Catch: Throwable -> L155
        throw th;     // Catch: Throwable -> L155
    L155:
        th = move-exception;
        throw th;
    L163:
        if ("--start-testing".equals(r6) == false) goto L166;
        this.mAm.mAppProfiler.setTestPssMode(true);
        r41.println("Started high frequency sampling.");
        r11 = true;
        r7 = r35;
        goto L215
    L166:
        if ("--stop-testing".equals(r6) == false) goto L169;
        this.mAm.mAppProfiler.setTestPssMode(false);
        r41.println("Stopped high frequency sampling.");
        r11 = true;
        r7 = r35;
        goto L215
    L169:
        if ("--pretend-screen-on".equals(r6) == false) goto L180;
        Object r48 = this.mLock;
        monitor-enter(r48);
        this.mInjectedScreenState = true;     // Catch: Throwable -> L176
        monitor-exit(r48);     // Catch: Throwable -> L176
        r11 = true;
        r7 = r35;
    L176:
        th = move-exception;
        throw th;
    L180:
        if ("--pretend-screen-off".equals(r6) == false) goto L191;
        Object r49 = this.mLock;
        monitor-enter(r49);
        this.mInjectedScreenState = false;     // Catch: Throwable -> L187
        monitor-exit(r49);     // Catch: Throwable -> L187
        r11 = true;
        r7 = r35;
    L187:
        th = move-exception;
        throw th;
    L191:
        if ("--stop-pretend-screen".equals(r6) == false) goto L202;
        Object r50 = this.mLock;
        monitor-enter(r50);
        this.mInjectedScreenState = null;     // Catch: Throwable -> L198
        monitor-exit(r50);     // Catch: Throwable -> L198
        r11 = true;
        r7 = r35;
    L198:
        th = move-exception;
        throw th;
    L202:
        if ("-h".equals(r6) == true) goto L203;
        if ("-a".equals(r6) == false) goto L209;
        r8 = true;
        r10 = true;
        r7 = r35;
        goto L215
    L209:
        if (r6.length() > 0) goto L211;
    L214:
        r17 = r6;
        r8 = true;
        r7 = r35;
        goto L215
    L211:
        if (r6.charAt(0) != '-') goto L214;
        r41.println("Unknown option: " + r6);
        dumpHelp(r41);
        return;
    L203:
        dumpHelp(r41);
        return;
    L216:
        long r311 = r3;
        boolean r312 = r7;
        int r51 = r13;
        String r52 = r17;
        boolean r53 = r18;
        int[] r54 = r21;
        boolean r55 = r22;
        boolean r110 = r8;
        boolean r111 = r11;
        int r112 = r15;
        boolean r210 = r16;
        int[] r56 = r23;
        boolean r113 = r9;
        boolean r114 = r10;
        int[] r57 = r25;
        boolean r211 = r20;
        boolean r212 = r27;
    L218:
        if (r111 == false) goto L220;
        return;
    L220:
        if (r212 == false) goto L250;
        r41.print("Processes running summed over");
        if (r53 == true) goto L227;
        int r58 = 0;
    L225:
        if (r58 >= r54.length) goto L227;
        r41.print(" ");
        DumpUtils.printScreenLabelCsv(r41, r54[r58]);
        r58 = r58 + 1;
    L227:
        if (r55 == true) goto L232;
        int r59 = 0;
    L230:
        if (r59 >= r56.length) goto L232;
        r41.print(" ");
        DumpUtils.printMemLabelCsv(r41, r56[r59]);
        r59 = r59 + 1;
    L232:
        if (r24 == true) goto L237;
        int r60 = 0;
    L235:
        if (r60 >= r57.length) goto L237;
        r41.print(" ");
        r41.print(DumpUtils.STATE_NAMES_CSV[r57[r60]]);
        r60 = r60 + 1;
    L237:
        r41.println();
        Object r115 = this.mLock;
        monitor-enter(r115);
        dumpFilteredProcessesCsvLocked(r41, null, r53, r54, r55, r56, r24, r57, r311, r52);     // Catch: Throwable -> L246
        monitor-exit(r115);     // Catch: Throwable -> L244
        return;
    L244:
        th = th;
    L248:
        monitor-exit(r115);     // Catch: Throwable -> L244
        throw th;
    L246:
        th = th;
        goto L248
    L250:
        PrintWriter r61 = r41;
        int r116 = r51;
        String r62 = r52;
        boolean r213 = r113;
        long r63 = r311;
        int r117 = r12;
        if (r117 == 0) goto L254;
        r61.print("AGGREGATED OVER LAST ");
        r61.print(r117);
        r61.println(" HOURS:");
        dumpAggregatedStats(r61, r117, r63, r62, r19, r110, r213, r114, r210, r26);
        return;
    L254:
        boolean r64 = r110;
        boolean r118 = r114;
        boolean r65 = r210;
        int r119 = r26;
        if (r116 <= 0) goto L294;
        r61.print("LAST STATS AT INDEX ");
        r61.print(r116);
        r61.println(":");
        this.mFileLock.lock();
        ArrayList<String> r66 = getCommittedFilesLF(0, false, true);     // Catch: Throwable -> L290
        if (r116 >= r66.size()) goto L485;
        AtomicFile r67 = new AtomicFile(new File(r66.get(r116)));     // Catch: Throwable -> L290
        ProcessStats r68 = new ProcessStats(false);     // Catch: Throwable -> L290
        readLF(r68, r67);     // Catch: Throwable -> L290
        this.mFileLock.unlock();
        if (r68.mReadError == null) goto L272;
        if (r211 == true) goto L269;
        if (r19 == true) goto L269;
    L270:
        r61.print("Failure reading ");
        r61.print(r66.get(r116));
        r61.print("; ");
        r61.println(r68.mReadError);
        return;
    L269:
        r61.print("err,");
        goto L270
    L272:
        boolean r120 = r67.getBaseFile().getPath().endsWith(STATE_FILE_CHECKIN_SUFFIX);
        if (r211 == true) goto L288;
        if (r19 == true) goto L288;
        r61.print("COMMITTED STATS FROM ");
        r61.print(r68.mTimePeriodStartClockStr);
        if (r120 == false) goto L279;
        r61.print(" (checked in)");
    L279:
        r61.println(":");
        if (r64 == true) goto L284;
        if (r213 == true) goto L284;
        r68.dumpSummaryLocked(r61, r62, r63, r65);
        return;
    L284:
        r68.dumpLocked(r41, r62, r63, !r213, r64, r118, r65, r119);
        if (r118 == false) goto L571;
        r41.print("  mFile=");
        r41.println(getCurrentFile());
        return;
    L571:
        return;
    L288:
        r68.dumpCheckinLocked(r61, r62, r119);
        return;
    L485:
        r61.print("Only have ");     // Catch: Throwable -> L262
        r61.print(r66.size());     // Catch: Throwable -> L262
        r61.println(" data sets");     // Catch: Throwable -> L262
        this.mFileLock.unlock();
        return;
    L262:
        th = th;
    L292:
        this.mFileLock.unlock();
        throw th;
    L290:
        th = th;
        goto L292
    L294:
        boolean r69 = true;
        boolean r70 = false;
        if (r118 == true) goto L299;
        if (r211 == true) goto L299;
        boolean r214 = false;
    L393:
        boolean r121 = false;
    L394:
        if (r211 == true) goto L449;
        Object r122 = this.mLock;
        monitor-enter(r122);
        if (r19 == false) goto L401;
        this.mProcessStats.dumpCheckinLocked(r61, r62, r119);     // Catch: Throwable -> L399
        int r123 = r119;
        boolean r71 = r64;
        boolean r72 = r118;
        r63 = r63;
        boolean r124 = r121;
    L462:
        monitor-exit(r122);     // Catch: Throwable -> L436
        if (r312 == true) goto L573;
        if (r124 == false) goto L433;
        r61.println();
    L433:
        r61.println("AGGREGATED OVER LAST 24 HOURS:");
        long r313 = r63;
        boolean r125 = r65;
        boolean r126 = r72;
        boolean r73 = r19;
        PrintWriter r74 = r61;
        dumpAggregatedStats(r74, 24, r313, r62, r73, r71, r213, r126, r125, r123);
        r74.println();
        r74.println("AGGREGATED OVER LAST 3 HOURS:");
        dumpAggregatedStats(r74, 3, r313, r62, r73, r71, r213, r126, r125, r123);
    L573:
        return;
    L436:
        th = th;
    L509:
        monitor-exit(r122);     // Catch: Throwable -> L446
        throw th;
    L446:
        th = th;
        goto L509
    L401:
        if (r121 == false) goto L495;
        r61.println();     // Catch: Throwable -> L399
    L495:
        r61.println("CURRENT STATS:");     // Catch: Throwable -> L442
        if (r64 == true) goto L491;
        if (r213 == true) goto L491;
        r63 = r63;
        this.mProcessStats.dumpSummaryLocked(r61, r62, r63, r65);     // Catch: Throwable -> L411
        r61 = r41;
        r123 = r119;
        r71 = r64;
        r72 = r118;
    L428:
        r124 = true;
    L411:
        th = th;
    L413:
        th = th;
    L491:
        ProcessStats r75 = this.mProcessStats;     // Catch: Throwable -> L440
        if (r213 == false) goto L420;
        r69 = r214;
    L420:
        r61 = r41;
        boolean r76 = r65;
        r72 = r118;
        r75.dumpLocked(r61, r62, r63, r69, r64, r72, r76, r119);     // Catch: Throwable -> L438
        r65 = r76;
        r123 = r119;
        r71 = r64;
        if (r72 == false) goto L428;
        r61.print("  mFile=");     // Catch: Throwable -> L426
        r61.println(getCurrentFile());     // Catch: Throwable -> L426
    L426:
        th = th;
    L438:
        th = th;
    L440:
        th = th;
    L442:
        th = th;
    L399:
        th = th;
        goto L509
    L449:
        return;
    L299:
        if (r312 == true) goto L392;
        this.mFileLock.lock();
        if (r211 == true) goto L303;
        boolean r77 = true;
    L489:
        ArrayList<String> r78 = getCommittedFilesLF(0, false, r77);     // Catch: Throwable -> L386
        if (r78 == null) goto L388;
        if (r211 == false) goto L309;
        int r79 = 0;
    L310:
        if (r79 >= 0) goto L312;
        int r127 = 0;
    L313:
        int r128 = r127;
    L314:
        if (r128 >= r78.size()) goto L385;
        AtomicFile r80 = new AtomicFile(new File(r78.get(r128)));     // Catch: Throwable -> L372
        ProcessStats r81 = new ProcessStats(false);     // Catch: Throwable -> L376
        readLF(r81, r80);     // Catch: Throwable -> L376
        if (r81.mReadError == null) goto L330;
        if (r211 == true) goto L324;
        if (r19 == true) goto L324;
    L515:
        r61.print("Failure reading ");     // Catch: Throwable -> L327
        r61.print(r78.get(r128));     // Catch: Throwable -> L327
        r61.print("; ");     // Catch: Throwable -> L327
        r61.println(r81.mReadError);     // Catch: Throwable -> L327
        new File(r78.get(r128)).delete();     // Catch: Throwable -> L327
        r63 = r63;
        r127 = r127;
        boolean r314 = true;
    L382:
        r128 = r128 + 1;
        r69 = r314;
        r127 = r127;
        r63 = r63;
    L327:
        th = th;
        r63 = r63;
        r127 = r127;
        r314 = true;
    L472:
        r61.print("**** FAILURE DUMPING STATE: ");     // Catch: Throwable -> L383
        r61.println(r78.get(r128));     // Catch: Throwable -> L383
        th.printStackTrace(r61);     // Catch: Throwable -> L383
    L383:
        th = th;
    L390:
        this.mFileLock.unlock();
        throw th;
    L324:
        r61.print("err,");     // Catch: Throwable -> L327
        goto L515
    L330:
        String r82 = r80.getBaseFile().getPath();     // Catch: Throwable -> L372
        boolean r83 = r82.endsWith(STATE_FILE_CHECKIN_SUFFIX);     // Catch: Throwable -> L372
        if (r211 == true) goto L359;
        if (r19 == false) goto L335;
        r314 = true;
    L470:
        r81.dumpCheckinLocked(r61, r62, r119);     // Catch: Throwable -> L368
    L361:
        if (r211 == false) goto L370;
        File r84 = r80.getBaseFile();     // Catch: Throwable -> L368
        StringBuilder r85 = new StringBuilder();     // Catch: Throwable -> L368
        r85.append(r82);     // Catch: Throwable -> L368
        r63 = r63;
        r85.append(STATE_FILE_CHECKIN_SUFFIX);     // Catch: Throwable -> L366
        r84.renameTo(new File(r85.toString()));     // Catch: Throwable -> L366
    L366:
        th = th;
        goto L472
    L370:
        r63 = r63;
    L368:
        th = th;
        r63 = r63;
        goto L472
    L335:
        if (r70 == false) goto L338;
        r61.println();     // Catch: Throwable -> L327
        boolean r315 = r70;
    L477:
        r61.print("COMMITTED STATS FROM ");     // Catch: Throwable -> L357
        r61.print(r81.mTimePeriodStartClockStr);     // Catch: Throwable -> L357
        if (r83 == true) goto L450;
    L345:
        r61.println(":");     // Catch: Throwable -> L357
        if (r213 == false) goto L352;
        r81 = r81;
        boolean r86 = r65;
        r127 = r127;
        r82 = r82;
        r314 = true;
        r81.dumpLocked(r61, r62, r63, false, false, false, r86, r119);     // Catch: Throwable -> L350
        r65 = r86;
        r61 = r41;
    L354:
        r70 = r315;
    L350:
        th = th;
        r65 = r86;
        r61 = r41;
        r63 = r63;
        r70 = r315;
        goto L472
    L352:
        r127 = r127;
        r314 = true;
        r82 = r82;
        r81 = r81;
        r61 = r41;
        r81.dumpSummaryLocked(r61, r62, r63, r65);     // Catch: Throwable -> L355
    L355:
        th = th;
        r63 = r63;
        r70 = r315;
        goto L472
    L450:
        r61.print(" (checked in)");     // Catch: Throwable -> L343
    L343:
        th = th;
        r63 = r63;
        r127 = r127;
        r70 = r315;
        r314 = true;
    L357:
        th = th;
        r127 = r127;
        r314 = true;
        r63 = r63;
        r70 = r315;
        goto L472
    L338:
        r315 = true;
        goto L477
    L359:
        r314 = true;
    L376:
        th = th;
    L374:
        r314 = true;
    L372:
        th = th;
    L378:
        th = th;
        r63 = r63;
        r314 = r69;
        r127 = r127;
        goto L472
    L385:
        r63 = r63;
        r69 = r69;
        r214 = false;
    L389:
        this.mFileLock.unlock();
        r121 = r70;
        goto L394
    L312:
        r127 = r79;
        goto L313
    L309:
        r79 = r78.size() - r112;     // Catch: Throwable -> L386
        goto L310
    L388:
        r63 = r63;
        r69 = true;
        r214 = false;
    L386:
        th = th;
        goto L390
    L303:
        r77 = false;
        goto L489
    L392:
        r214 = false;
        goto L393
    L217:
        r311 = r3;
        r312 = false;
        r51 = 0;
        r52 = null;
        r53 = false;
        r54 = r21;
        r55 = false;
        r110 = false;
        r111 = false;
        r112 = 2;
        r210 = false;
        r56 = r23;
        r113 = false;
        r114 = false;
        r57 = r25;
        r211 = false;
        r212 = false;
        goto L218
    }

    private void dumpAggregatedStats(ProtoOutputStream proto, long fieldId, int aggregateHours, long now) {
        ParcelFileDescriptor pfd = getStatsOverTime(((long) (((aggregateHours * 60) * 60) * 1000)) - (ProcessStats.COMMIT_PERIOD / 2));
        if (pfd != null) goto L5;
        return;
    L5:
        ProcessStats stats = new ProcessStats(false);
        InputStream stream = new ParcelFileDescriptor.AutoCloseInputStream(pfd);
        stats.read(stream);
        if (stats.mReadError == null) goto L8;
        return;
    L8:
        long token = proto.start(fieldId);
        stats.dumpDebug(proto, now, 31);
        proto.end(token);
    }

    private void dumpProto(FileDescriptor fd) {
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        Object r1 = this.mLock;
        monitor-enter(r1);
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        long token = proto.start(1146756268033L);     // Catch: Throwable -> L8
        this.mProcessStats.dumpDebug(proto, now, 31);     // Catch: Throwable -> L8
        proto.end(token);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        dumpAggregatedStats(proto, 1146756268034L, 3, now);
        dumpAggregatedStats(proto, 1146756268035L, 24, now);
        proto.flush();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void dumpProtoForStatsd(FileDescriptor fd) {
        ProtoOutputStream[] protos = {new ProtoOutputStream(fd)};
        ProcessStats procStats = new ProcessStats(false);
        getCommittedStatsMerged(0, 0, true, null, procStats);
        procStats.dumpAggregatedProtoForStatsd(protos, 999999);
        protos[0].flush();
    }
}
