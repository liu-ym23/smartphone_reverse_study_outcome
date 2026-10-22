package com.android.server.am;

import android.os.Handler;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Slog;
import android.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class PhantomProcessRecord {
    static final int[] LONG_FORMAT = null;
    static final long[] LONG_OUT = null;
    static final String TAG = "ActivityManager";
    int mAdj;
    long mCurrentCputime;
    final Handler mKillHandler;
    boolean mKilled;
    final long mKnownSince;
    long mLastCputime;
    final Object mLock;
    final Consumer<PhantomProcessRecord> mOnKillListener;
    final int mPid;
    final FileDescriptor mPidFd;
    final int mPpid;
    private Runnable mProcKillTimer;
    final String mProcessName;
    final ActivityManagerService mService;
    String mStringName;
    final int mUid;
    int mUpdateSeq;
    boolean mZombie;

    static {
        LONG_OUT = new long[1];
        LONG_FORMAT = new int[]{8202};
    }

    PhantomProcessRecord(String processName, int uid, int pid, int ppid, ActivityManagerService service, Consumer<PhantomProcessRecord> onKillListener) throws IllegalStateException {
        this.mProcKillTimer = new AnonymousClass1(this);
        this.mProcessName = processName;
        this.mUid = uid;
        this.mPid = pid;
        this.mPpid = ppid;
        this.mKilled = false;
        this.mAdj = -1000;
        this.mKnownSince = SystemClock.elapsedRealtime();
        this.mService = service;
        this.mLock = service.mPhantomProcessList.mLock;
        this.mOnKillListener = onKillListener;
        this.mKillHandler = ProcessList.sKillHandler;
        if (Process.supportsPidFd() == false) goto L17;
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        this.mPidFd = Process.openPidFd(pid, 0);     // Catch: Throwable -> L10 IOException -> L12
        if (this.mPidFd == null) goto L9;
        StrictMode.setThreadPolicy(oldPolicy);
        return;
    L9:
        throw new IllegalStateException();     // Catch: Throwable -> L10 IOException -> L12
    L10:
        th = move-exception;
        StrictMode.setThreadPolicy(oldPolicy);
        throw th;
    L12:
        e = move-exception;
        Slog.w(TAG, "Unable to open process " + pid + ", it might be gone");     // Catch: Throwable -> L10
        IllegalStateException ex = new IllegalStateException();     // Catch: Throwable -> L10
        ex.initCause(e);     // Catch: Throwable -> L10
        throw ex;     // Catch: Throwable -> L10
    L17:
        this.mPidFd = null;
    }

    public long getRss(int pid) {
        long[] rss = Process.getRss(pid);
        if (rss != null) goto L5;
    L7:
        return 0;
    L5:
        if (rss.length <= 0) goto L7;
        return rss[0];
    }

    void killLocked(String reason, boolean noisy) {
        if (this.mKilled == true) goto L19;
        Trace.traceBegin(64, "kill");
        if (noisy == false) goto L7;
    L8:
        this.mService.reportUidInfoMessageLocked(TAG, "Killing " + toString() + ": " + reason, this.mUid);
    L10:
        if (this.mPid <= 0) goto L17;
        EventLog.writeEvent(EventLogTags.AM_KILL, new Object[]{Integer.valueOf(UserHandle.getUserId(this.mUid)), Integer.valueOf(this.mPid), this.mProcessName, Integer.valueOf(this.mAdj), reason, Long.valueOf(getRss(this.mPid))});
        if (Process.supportsPidFd() == true) goto L14;
        onProcDied(false);
    L15:
        Process.killProcessQuiet(this.mPid);
        ProcessList.killProcessGroup(this.mUid, this.mPid);
        goto L17
    L14:
        this.mKillHandler.postDelayed(this.mProcKillTimer, this, this.mService.mConstants.mProcessKillTimeoutMs);
    L17:
        this.mKilled = true;
        Trace.traceEnd(64);
        return;
    L7:
        if (this.mUid != this.mService.mCurOomAdjUid) goto L10;
    }

    void updateAdjLocked() {
        if (Process.readProcFile("/proc/" + this.mPid + "/oom_score_adj", LONG_FORMAT, null, LONG_OUT, null) == false) goto L6;
        this.mAdj = (int) LONG_OUT[0];
        return;
    }

    void onProcDied(boolean reallyDead) {
        if (reallyDead == false) goto L4;
        Slog.i(TAG, "Process " + toString() + " died");
    L4:
        this.mKillHandler.removeCallbacks(this.mProcKillTimer, this);
        if (this.mOnKillListener == null) goto L8;
        this.mOnKillListener.accept(this);
        return;
    }

    public String toString() {
        if (this.mStringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("PhantomProcessRecord {");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        sb.append(this.mPid);
        sb.append(':');
        sb.append(this.mPpid);
        sb.append(':');
        sb.append(this.mProcessName);
        sb.append('/');
        if (this.mUid >= 10000) goto L9;
        sb.append(this.mUid);
    L18:
        sb.append('}');
        String r1 = sb.toString();
        this.mStringName = r1;
        return r1;
    L9:
        sb.append('u');
        sb.append(UserHandle.getUserId(this.mUid));
        int appId = UserHandle.getAppId(this.mUid);
        if (appId < 10000) goto L12;
        sb.append('a');
        sb.append(appId + ProcessList.INVALID_ADJ);
    L14:
        if (appId < 99000) goto L18;
        if (appId > 99999) goto L18;
        sb.append('i');
        sb.append(appId - 99000);
        goto L18
    L12:
        sb.append('s');
        sb.append(appId);
        goto L14
    L5:
        return this.mStringName;
    }

    void dump(PrintWriter pw, String prefix) {
        long now = SystemClock.elapsedRealtime();
        pw.print(prefix);
        pw.print("user #");
        pw.print(UserHandle.getUserId(this.mUid));
        pw.print(" uid=");
        pw.print(this.mUid);
        pw.print(" pid=");
        pw.print(this.mPid);
        pw.print(" ppid=");
        pw.print(this.mPpid);
        pw.print(" knownSince=");
        TimeUtils.formatDuration(this.mKnownSince, now, pw);
        pw.print(" killed=");
        pw.println(this.mKilled);
        pw.print(prefix);
        pw.print("lastCpuTime=");
        pw.print(this.mLastCputime);
        if (this.mLastCputime <= 0) goto L5;
        pw.print(" timeUsed=");
        TimeUtils.formatDuration(this.mCurrentCputime - this.mLastCputime, pw);
    L5:
        pw.print(" oom adj=");
        pw.print(this.mAdj);
        pw.print(" seq=");
        pw.println(this.mUpdateSeq);
    }

    boolean equals(String processName, int uid, int pid) {
        if (this.mUid == uid) goto L5;
    L9:
        return false;
    L5:
        if (this.mPid != pid) goto L9;
        if (TextUtils.equals(this.mProcessName, processName) == false) goto L9;
        return true;
    }
}
