package com.android.server.am;

import android.os.Handler;
import android.os.Process;
import android.os.StrictMode;
import android.util.FeatureFlagUtils;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.ProcStatsUtil;
import com.android.internal.os.ProcessCpuTracker;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
public final class PhantomProcessList {
    static final String TAG = "ActivityManager";
    final SparseArray<SparseArray<PhantomProcessRecord>> mAppPhantomProcessMap;
    private final SparseArray<InputStream> mCgroupProcsFds;
    private final byte[] mDataBuffer;
    Injector mInjector;
    private final Handler mKillHandler;
    final Object mLock;
    final SparseArray<PhantomProcessRecord> mPhantomProcesses;
    final SparseArray<PhantomProcessRecord> mPhantomProcessesPidFds;
    private final SparseArray<ProcessRecord> mPhantomToAppProcessMap;
    private final ActivityManagerService mService;
    private final ArrayList<PhantomProcessRecord> mTempPhantomProcesses;
    private boolean mTrimPhantomProcessScheduled;
    int mUpdateSeq;
    final SparseArray<PhantomProcessRecord> mZombiePhantomProcesses;

    static class Injector {
        Injector() {
        }

        InputStream openCgroupProcs(String path) throws FileNotFoundException, SecurityException {
            return new FileInputStream(path);
        }

        int readCgroupProcs(InputStream input, byte[] buf, int offset, int len) throws IOException {
            return input.read(buf, offset, len);
        }

        String getProcessName(int pid) {
            return PhantomProcessList.getProcessName(pid);
        }
    }

    public static /* synthetic */ int $r8$lambda$K2qOooafJjVfXzmG2th1X66pCMg(PhantomProcessList r0, FileDescriptor r1, int r2) {
        return r0.onPhantomProcessFdEvent(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$N7SwL_pByAFT7sgXncsbcUgdS-o, reason: not valid java name */
    public static /* synthetic */ void m1549$r8$lambda$N7SwL_pByAFT7sgXncsbcUgdSo(PhantomProcessList r0, PhantomProcessRecord r1) {
        r0.onPhantomProcessKilledLocked(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$te76WicnMtQQTu_mz9uIam9K-b8, reason: not valid java name */
    public static /* synthetic */ int m1550$r8$lambda$te76WicnMtQQTu_mz9uIam9Kb8(PhantomProcessList r0, PhantomProcessRecord r1, PhantomProcessRecord r2) {
        return r0.lambda$trimPhantomProcessesIfNecessary$0(r1, r2);
    }

    private static native String nativeGetCgroupProcsPath(int r0, int r1) throws IllegalArgumentException;

    PhantomProcessList(ActivityManagerService service) {
        this.mLock = new Object();
        this.mPhantomProcesses = new SparseArray();
        this.mAppPhantomProcessMap = new SparseArray();
        this.mPhantomProcessesPidFds = new SparseArray();
        this.mZombiePhantomProcesses = new SparseArray();
        this.mTempPhantomProcesses = new ArrayList();
        this.mPhantomToAppProcessMap = new SparseArray();
        this.mCgroupProcsFds = new SparseArray();
        this.mDataBuffer = new byte[4096];
        this.mTrimPhantomProcessScheduled = false;
        this.mService = service;
        ProcessList r0 = service.mProcessList;
        this.mKillHandler = ProcessList.sKillHandler;
        this.mInjector = new Injector();
    }

    void lookForPhantomProcessesLocked() {
        this.mPhantomToAppProcessMap.clear();
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        ActivityManagerService.PidMap r1 = this.mService.mPidsSelfLocked;     // Catch: Throwable -> L16
        monitor-enter(r1);     // Catch: Throwable -> L16
        int i = this.mService.mPidsSelfLocked.size() - 1;     // Catch: Throwable -> L8
    L6:
        if (i < 0) goto L11;
        ProcessRecord app = this.mService.mPidsSelfLocked.valueAt(i);     // Catch: Throwable -> L8
        lookForPhantomProcessesLocked(app);     // Catch: Throwable -> L8
        i = i - 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        StrictMode.setThreadPolicy(oldPolicy);
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        StrictMode.setThreadPolicy(oldPolicy);
        throw th;
    }

    private void lookForPhantomProcessesLocked(ProcessRecord app) {
        if (app.appZygote == false) goto L5;
        return;
    L5:
        if (app.isKilled() == false) goto L7;
        return;
    L7:
        if (app.isKilledByAm() == true) goto L62;
        int appPid = app.getPid();
        InputStream input = this.mCgroupProcsFds.get(appPid);
        if (input != null) goto L26;
        String path = null;
        path = getCgroupFilePath(app.info.uid, appPid);     // Catch: Throwable -> L14 IllegalArgumentException -> L16
        input = this.mInjector.openCgroupProcs(path);     // Catch: Throwable -> L14 IllegalArgumentException -> L16
        this.mCgroupProcsFds.put(appPid, input);
        goto L26
    L14:
        e = move-exception;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L58;
        Slog.w(TAG, "Unable to open " + path, e);
        return;
    L58:
        return;
    L16:
        e = move-exception;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L59;
        Slog.w(TAG, "Unable to obtain cgroup.procs path ", e);
        return;
    L59:
        return;
    L26:
        byte[] buf = this.mDataBuffer;
        int pid = 0;
        long totalRead = 0;
    L48:
        int read = this.mInjector.readCgroupProcs(input, buf, 0, buf.length);     // Catch: IOException -> L35
        if (read == (-1)) goto L41;
        totalRead = totalRead + ((long) read);     // Catch: IOException -> L35
        int i = 0;
    L31:
        if (i >= read) goto L39;
        byte b = buf[i];     // Catch: IOException -> L35
        if (b != 10) goto L37;
        addChildPidLocked(app, pid, appPid);     // Catch: IOException -> L35
        pid = 0;
    L38:
        i = i + 1;     // Catch: IOException -> L35
        goto L31
    L37:
        pid = (pid * 10) + (b - 48);     // Catch: IOException -> L35
        goto L38
    L39:
        int i2 = buf.length;     // Catch: IOException -> L35
        if (read >= i2) goto L48;
    L41:
        if (pid == 0) goto L43;
        addChildPidLocked(app, pid, appPid);     // Catch: IOException -> L35
    L43:
        input.skip(-totalRead);     // Catch: IOException -> L35
        return;
    L35:
        e = move-exception;
        Slog.e(TAG, "Error in reading cgroup procs from " + app, e);
        IoUtils.closeQuietly(input);
        this.mCgroupProcsFds.delete(appPid);
        return;
    }

    String getCgroupFilePath(int uid, int pid) {
        return nativeGetCgroupProcsPath(uid, pid);
    }

    static String getProcessName(int pid) {
        String procName = ProcStatsUtil.readTerminatedProcFile("/proc/" + pid + "/cmdline", (byte) 0);
        if (procName != null) goto L6;
        return null;
    L6:
        int l = procName.lastIndexOf(47);
        if (l > 0) goto L9;
        return procName;
    L9:
        if (l < (procName.length() - 1)) goto L11;
        return procName;
    L11:
        return procName.substring(l + 1);
    }

    private void addChildPidLocked(ProcessRecord app, int pid, int appPid) {
        if (appPid == pid) goto L24;
        ProcessRecord r = this.mService.mPidsSelfLocked.get(pid);
        if (r != null) goto L6;
        int index = this.mPhantomToAppProcessMap.indexOfKey(pid);
        if (index < 0) goto L16;
        ProcessRecord current = this.mPhantomToAppProcessMap.valueAt(index);
        if (app != current) goto L15;
        return;
    L15:
        this.mPhantomToAppProcessMap.setValueAt(index, app);
    L17:
        int uid = Process.getUidForPid(pid);
        String procName = this.mInjector.getProcessName(pid);
        if (procName == null) goto L22;
        if (uid < 0) goto L22;
        getOrCreatePhantomProcessIfNeededLocked(procName, uid, pid, true);
        return;
    L22:
        this.mPhantomToAppProcessMap.delete(pid);
        return;
    L16:
        this.mPhantomToAppProcessMap.put(pid, app);
        goto L17
    L6:
        if (r.appZygote == false) goto L8;
        return;
    L8:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L26;
        Slog.w(TAG, "Unexpected: " + r + " appears in the cgroup.procs of " + app);
        return;
    L26:
        return;
    }

    void onAppDied(int pid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = this.mCgroupProcsFds.indexOfKey(pid);     // Catch: Throwable -> L7
        if (index < 0) goto L9;
        InputStream inputStream = this.mCgroupProcsFds.valueAt(index);     // Catch: Throwable -> L7
        this.mCgroupProcsFds.removeAt(index);     // Catch: Throwable -> L7
        IoUtils.closeQuietly(inputStream);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    PhantomProcessRecord getOrCreatePhantomProcessIfNeededLocked(String processName, int uid, int pid, boolean createIfNeeded) {
        if (isAppProcess(pid) == false) goto L5;
        return null;
    L5:
        int index = this.mPhantomProcesses.indexOfKey(pid);
        if (index < 0) goto L11;
        PhantomProcessRecord proc = this.mPhantomProcesses.valueAt(index);
        if (proc.equals(processName, uid, pid) == false) goto L10;
        return proc;
    L10:
        Slog.w(TAG, "Stale " + proc + ", removing");
        onPhantomProcessKilledLocked(proc);
    L17:
        if (createIfNeeded == true) goto L19;
        return null;
    L19:
        ProcessRecord r = this.mPhantomToAppProcessMap.get(pid);
        if (r != null) goto L38;
        return null;
    L38:
        int appPid = r.getPid();     // Catch: IllegalStateException -> L33
        PhantomProcessRecord proc2 = new PhantomProcessRecord(processName, uid, pid, appPid, this.mService, new PhantomProcessList$$ExternalSyntheticLambda0(this));     // Catch: IllegalStateException -> L26
        proc2.mUpdateSeq = this.mUpdateSeq;     // Catch: IllegalStateException -> L26
        this.mPhantomProcesses.put(pid, proc2);     // Catch: IllegalStateException -> L26
        SparseArray<PhantomProcessRecord> array = this.mAppPhantomProcessMap.get(appPid);     // Catch: IllegalStateException -> L26
        if (array != null) goto L28;
        array = new SparseArray();     // Catch: IllegalStateException -> L26
        this.mAppPhantomProcessMap.put(appPid, array);     // Catch: IllegalStateException -> L26
    L28:
        array.put(pid, proc2);     // Catch: IllegalStateException -> L26
        if (proc2.mPidFd == null) goto L31;
        this.mKillHandler.getLooper().getQueue().addOnFileDescriptorEventListener(proc2.mPidFd, 5, new PhantomProcessList$$ExternalSyntheticLambda1(this));     // Catch: IllegalStateException -> L26
        this.mPhantomProcessesPidFds.put(proc2.mPidFd.getInt$(), proc2);     // Catch: IllegalStateException -> L26
    L31:
        scheduleTrimPhantomProcessesLocked();     // Catch: IllegalStateException -> L26
        return proc2;
    L36:
        return null;
    L11:
        int idx = this.mZombiePhantomProcesses.indexOfKey(pid);
        if (idx < 0) goto L17;
        PhantomProcessRecord proc3 = this.mZombiePhantomProcesses.valueAt(idx);
        if (proc3.equals(processName, uid, pid) == false) goto L16;
        return proc3;
    L16:
        this.mZombiePhantomProcesses.removeAt(idx);
        goto L17
    }

    private boolean isAppProcess(int pid) {
        ActivityManagerService.PidMap r0 = this.mService.mPidsSelfLocked;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mService.mPidsSelfLocked.get(pid) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private int onPhantomProcessFdEvent(FileDescriptor fd, int events) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PhantomProcessRecord proc = this.mPhantomProcessesPidFds.get(fd.getInt$());     // Catch: Throwable -> L8
        if (proc != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L11:
        if ((events & 1) == 0) goto L13;
        proc.onProcDied(true);     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L13:
        proc.killLocked("Process error", true);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void onPhantomProcessKilledLocked(PhantomProcessRecord proc) {
        if (proc.mPidFd != null) goto L5;
    L7:
        this.mPhantomProcesses.remove(proc.mPid);
        int index = this.mAppPhantomProcessMap.indexOfKey(proc.mPpid);
        if (index >= 0) goto L10;
        return;
    L10:
        SparseArray<PhantomProcessRecord> array = this.mAppPhantomProcessMap.valueAt(index);
        array.remove(proc.mPid);
        if (array.size() != 0) goto L14;
        this.mAppPhantomProcessMap.removeAt(index);
    L14:
        if (proc.mZombie == false) goto L16;
        this.mZombiePhantomProcesses.put(proc.mPid, proc);
        return;
    L16:
        this.mZombiePhantomProcesses.remove(proc.mPid);
        return;
    L5:
        if (proc.mPidFd.valid() == false) goto L7;
        this.mKillHandler.getLooper().getQueue().removeOnFileDescriptorEventListener(proc.mPidFd);
        this.mPhantomProcessesPidFds.remove(proc.mPidFd.getInt$());
        IoUtils.closeQuietly(proc.mPidFd);
        goto L7
    }

    private void scheduleTrimPhantomProcessesLocked() {
        if (this.mTrimPhantomProcessScheduled == true) goto L6;
        this.mTrimPhantomProcessScheduled = true;
        this.mService.mHandler.post(new ActivityManagerConstants$$ExternalSyntheticLambda0(this));
        return;
    }

    void trimPhantomProcessesIfNecessary() {
        if (this.mService.mSystemReady == true) goto L5;
        return;
    L5:
        if (FeatureFlagUtils.isEnabled(this.mService.mContext, "settings_enable_monitor_phantom_procs") == false) goto L50;
        ActivityManagerGlobalLock r0 = this.mService.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        Object r1 = this.mLock;     // Catch: Throwable -> L36
        monitor-enter(r1);     // Catch: Throwable -> L36
        this.mTrimPhantomProcessScheduled = false;     // Catch: Throwable -> L17
        if (this.mService.mConstants.MAX_PHANTOM_PROCESSES >= this.mPhantomProcesses.size()) goto L32;
        int i = this.mPhantomProcesses.size() - 1;     // Catch: Throwable -> L17
    L15:
        if (i < 0) goto L19;
        this.mTempPhantomProcesses.add(this.mPhantomProcesses.valueAt(i));     // Catch: Throwable -> L17
        i = i - 1;     // Catch: Throwable -> L17
        goto L15
    L19:
        ActivityManagerService.PidMap r2 = this.mService.mPidsSelfLocked;     // Catch: Throwable -> L17
        monitor-enter(r2);     // Catch: Throwable -> L17
        Collections.sort(this.mTempPhantomProcesses, new PhantomProcessList$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        int i2 = this.mTempPhantomProcesses.size() - 1;     // Catch: Throwable -> L17
    L25:
        if (i2 < this.mService.mConstants.MAX_PHANTOM_PROCESSES) goto L27;
        PhantomProcessRecord proc = this.mTempPhantomProcesses.get(i2);     // Catch: Throwable -> L17
        proc.killLocked("Trimming phantom processes", true);     // Catch: Throwable -> L17
        i2 = i2 - 1;     // Catch: Throwable -> L17
        goto L25
    L27:
        this.mTempPhantomProcesses.clear();     // Catch: Throwable -> L17
        goto L32
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L32:
        monitor-exit(r1);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L36
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private /* synthetic */ int lambda$trimPhantomProcessesIfNecessary$0(PhantomProcessRecord a, PhantomProcessRecord b) {
        ProcessRecord ra = this.mService.mPidsSelfLocked.get(a.mPpid);
        ProcessRecord rb = this.mService.mPidsSelfLocked.get(b.mPpid);
        if (ra != null) goto L6;
        if (rb != null) goto L6;
        Slog.v(TAG, "ra and rb are all null");
    L15:
        if (a.mKnownSince != b.mKnownSince) goto L17;
        return 0;
    L17:
        if (a.mKnownSince < b.mKnownSince) goto L19;
        return -1;
    L19:
        return 1;
    L6:
        if (ra != null) goto L8;
        return 1;
    L8:
        if (rb != null) goto L11;
        return -1;
    L11:
        if (ra.mState.getCurAdj() == rb.mState.getCurAdj()) goto L15;
        return ra.mState.getCurAdj() - rb.mState.getCurAdj();
    }

    void pruneStaleProcessesLocked() {
        int i = this.mPhantomProcesses.size() - 1;
    L4:
        if (i < 0) goto L12;
        PhantomProcessRecord proc = this.mPhantomProcesses.valueAt(i);
        if (proc.mUpdateSeq >= this.mUpdateSeq) goto L11;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L10;
        Slog.v(TAG, "Pruning " + proc + " as it should have been dead.");
    L10:
        proc.killLocked("Stale process", true);
    L11:
        i = i - 1;
        goto L4
    L12:
        int i2 = this.mZombiePhantomProcesses.size() - 1;
    L13:
        if (i2 < 0) goto L21;
        PhantomProcessRecord proc2 = this.mZombiePhantomProcesses.valueAt(i2);
        if (proc2.mUpdateSeq >= this.mUpdateSeq) goto L19;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L19;
        Slog.v(TAG, "Pruning " + proc2 + " as it should have been dead.");
    L19:
        i2 = i2 - 1;
        goto L13
    }

    void killPhantomProcessGroupLocked(ProcessRecord app, PhantomProcessRecord proc, int reasonCode, int subReason, String msg) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = this.mAppPhantomProcessMap.indexOfKey(proc.mPpid);     // Catch: Throwable -> L11
        if (index < 0) goto L15;
        SparseArray<PhantomProcessRecord> array = this.mAppPhantomProcessMap.valueAt(index);     // Catch: Throwable -> L11
        int i = array.size() - 1;     // Catch: Throwable -> L11
    L7:
        if (i < 0) goto L15;
        PhantomProcessRecord r = array.valueAt(i);     // Catch: Throwable -> L11
        if (r != proc) goto L13;
        r.killLocked(msg, true);     // Catch: Throwable -> L11
    L14:
        i = i - 1;     // Catch: Throwable -> L11
        goto L7
    L13:
        r.killLocked("Caused by siling process: " + msg, false);     // Catch: Throwable -> L11
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        app.killLocked("Caused by child process: " + msg, reasonCode, subReason, true);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private SparseArray<PhantomProcessRecord> getPhantomProcessOfAppLocked(ProcessRecord app) {
        int index = this.mAppPhantomProcessMap.indexOfKey(app.getPid());
        if (index >= 0) goto L5;
        return null;
    L5:
        return this.mAppPhantomProcessMap.valueAt(index);
    }

    void forEachPhantomProcessOfApp(ProcessRecord app, Function<PhantomProcessRecord, Boolean> callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<PhantomProcessRecord> array = getPhantomProcessOfAppLocked(app);     // Catch: Throwable -> L8
        if (array != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int i = array.size() - 1;     // Catch: Throwable -> L8
    L11:
        if (i < 0) goto L16;
        PhantomProcessRecord r = array.valueAt(i);     // Catch: Throwable -> L8
        if (callback.apply(r).booleanValue() == false) goto L16;
        i = i - 1;     // Catch: Throwable -> L8
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setProcessGroupForPhantomProcessOfApp(ProcessRecord app, int group) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        lookForPhantomProcessesLocked(app);     // Catch: Throwable -> L8
        SparseArray<PhantomProcessRecord> array = getPhantomProcessOfAppLocked(app);     // Catch: Throwable -> L8
        if (array != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int i = array.size() - 1;     // Catch: Throwable -> L8
    L11:
        if (i < 0) goto L14;
        PhantomProcessRecord r = array.valueAt(i);     // Catch: Throwable -> L8
        this.mService.mOomAdjuster.setProcessGroup(r.mPid, group, r.mProcessName);     // Catch: Throwable -> L8
        i = i - 1;     // Catch: Throwable -> L8
        goto L11
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void updateProcessCpuStatesLocked(ProcessCpuTracker tracker) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUpdateSeq++;     // Catch: Throwable -> L11
        lookForPhantomProcessesLocked();     // Catch: Throwable -> L11
        int i = tracker.countStats() - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L15;
        ProcessCpuTracker.Stats st = tracker.getStats(i);     // Catch: Throwable -> L11
        PhantomProcessRecord r = getOrCreatePhantomProcessIfNeededLocked(st.name, st.uid, st.pid, false);     // Catch: Throwable -> L11
        if (r == null) goto L14;
        r.mUpdateSeq = this.mUpdateSeq;     // Catch: Throwable -> L11
        r.mCurrentCputime += (long) (st.rel_utime + st.rel_stime);     // Catch: Throwable -> L11
        if (r.mLastCputime != 0) goto L13;
        r.mLastCputime = r.mCurrentCputime;     // Catch: Throwable -> L11
    L13:
        r.updateAdjLocked();     // Catch: Throwable -> L11
    L14:
        i = i - 1;     // Catch: Throwable -> L11
        goto L5
    L15:
        pruneStaleProcessesLocked();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw, String prefix) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        dumpPhantomeProcessLocked(pw, prefix, "All Active App Child Processes:", this.mPhantomProcesses);     // Catch: Throwable -> L7
        dumpPhantomeProcessLocked(pw, prefix, "All Zombie App Child Processes:", this.mZombiePhantomProcesses);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void dumpPhantomeProcessLocked(PrintWriter pw, String prefix, String headline, SparseArray<PhantomProcessRecord> list) {
        int size = list.size();
        if (size != 0) goto L5;
        return;
    L5:
        pw.println();
        pw.print(prefix);
        pw.println(headline);
        int i = 0;
    L6:
        if (i >= size) goto L9;
        PhantomProcessRecord proc = list.valueAt(i);
        pw.print(prefix);
        pw.print("  proc #");
        pw.print(i);
        pw.print(": ");
        pw.println(proc.toString());
        proc.dump(pw, prefix + "    ");
        i = i + 1;
        goto L6
    }
}
