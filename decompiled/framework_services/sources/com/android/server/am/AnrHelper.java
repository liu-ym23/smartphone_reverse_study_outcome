package com.android.server.am;

import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ProfilingServiceHelper;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.Log;
import android.util.Slog;
import com.android.internal.os.TimeoutRecord;
import com.android.server.FgThread;
import com.android.server.wm.WindowProcessController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class AnrHelper {
    static final int APP_NOT_RESPONDING_DEFER_MSG = 4;
    static final int APP_NOT_RESPONDING_DEFER_TIMEOUT_MILLIS = 10000;
    private static final long CONSECUTIVE_ANR_TIME_MS = 0;
    private static final int DEFAULT_THREAD_KEEP_ALIVE_SECOND = 10;
    private static final long EXPIRED_REPORT_TIME_MS = 0;
    private static final long SELF_ONLY_AFTER_BOOT_MS = 0;
    private static final String TAG = "ActivityManager";
    private static final ThreadFactory sDefaultThreadFactory = null;
    private final ArrayList<AnrRecord> mAnrRecords;
    private final ExecutorService mAuxiliaryTaskExecutor;
    private Handler mFgHandler;
    private long mLastAnrTimeMs;
    private int mProcessingPid;
    private final AtomicBoolean mRunning;
    private final ActivityManagerService mService;

    private class AnrConsumerThread extends Thread {
        final /* synthetic */ AnrHelper this$0;

        AnrConsumerThread(AnrHelper r1) {
            this.this$0 = r1;
            super("AnrConsumer");
        }

        private AnrRecord next() {
            ArrayList r0 = AnrHelper.m1272$$Nest$fgetmAnrRecords(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (AnrHelper.m1272$$Nest$fgetmAnrRecords(this.this$0).isEmpty() == false) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L11:
            AnrRecord record = (AnrRecord) AnrHelper.m1272$$Nest$fgetmAnrRecords(this.this$0).remove(0);     // Catch: Throwable -> L9
            AnrHelper.m1276$$Nest$fputmProcessingPid(this.this$0, record.mPid);     // Catch: Throwable -> L9
            record.mTimeoutRecord.mLatencyTracker.anrRecordsQueueSizeWhenPopped(AnrHelper.m1272$$Nest$fgetmAnrRecords(this.this$0).size());     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return record;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L2:
            AnrRecord r = next();
            boolean onlyDumpSelf = false;
            if (r == null) goto L24;
            AnrHelper.m1278$$Nest$mscheduleBinderHeavyHitterAutoSamplerIfNecessary(this.this$0);
            int currentPid = r.mApp.mPid;
            if (currentPid != r.mPid) goto L6;
            long startTime = SystemClock.uptimeMillis();
            long reportLatency = startTime - r.mTimestamp;
            if (reportLatency <= AnrHelper.m1280$$Nest$sfgetEXPIRED_REPORT_TIME_MS()) goto L10;
        L11:
            onlyDumpSelf = true;
        L12:
            r.appNotResponding(onlyDumpSelf);
            long endTime = SystemClock.uptimeMillis();
            if (android.internal.os.profiling.Flags.systemTriggeredProfilingNew() == true) goto L15;
        L19:
            StringBuilder r10 = new StringBuilder();
            r10.append("Completed ANR of ");
            r10.append(r.mApp.processName);
            r10.append(" in ");
            r10.append(endTime - startTime);
            r10.append("ms, latency ");
            r10.append(reportLatency);
            if (onlyDumpSelf == false) goto L22;
            String r11 = "ms (expired, only dump ANR app)";
        L23:
            r10.append(r11);
            Slog.d(AnrHelper.TAG, r10.toString());
            goto L2
        L22:
            r11 = "ms";
            goto L23
        L15:
            if (r.mAppInfo == null) goto L19;
            if (r.mAppInfo.packageName == null) goto L19;
            ProfilingServiceHelper.getInstance().onProfilingTriggerOccurred(r.mUid, r.mAppInfo.packageName, 2);
            goto L19
        L10:
            if (startTime >= AnrHelper.m1281$$Nest$sfgetSELF_ONLY_AFTER_BOOT_MS()) goto L12;
        L6:
            Slog.i(AnrHelper.TAG, "Skip ANR with mismatched pid=" + r.mPid + ", current pid=" + currentPid);
            goto L2
        L24:
            AnrHelper.m1274$$Nest$fgetmRunning(this.this$0).set(false);
            ArrayList r0 = AnrHelper.m1272$$Nest$fgetmAnrRecords(this.this$0);
            monitor-enter(r0);
            AnrHelper.m1276$$Nest$fputmProcessingPid(this.this$0, -1);     // Catch: Throwable -> L29
            if (AnrHelper.m1272$$Nest$fgetmAnrRecords(this.this$0).isEmpty() == true) goto L31;
            AnrHelper.m1279$$Nest$mstartAnrConsumerIfNeeded(this.this$0);     // Catch: Throwable -> L29
        L31:
            monitor-exit(r0);     // Catch: Throwable -> L29
            return;
        L29:
            th = move-exception;
            throw th;
        }
    }

    private class AnrRecord {
        final boolean mAboveSystem;
        final String mActivityShortComponentName;
        final ProcessRecord mApp;
        final ApplicationInfo mAppInfo;
        final boolean mIsContinuousAnr;
        final WindowProcessController mParentProcess;
        final String mParentShortComponentName;
        final int mPid;
        final TimeoutRecord mTimeoutRecord;
        final long mTimestamp;
        final int mUid;
        final /* synthetic */ AnrHelper this$0;

        AnrRecord(AnrHelper r3, ProcessRecord anrProcess, String activityShortComponentName, ApplicationInfo aInfo, String parentShortComponentName, WindowProcessController parentProcess, boolean aboveSystem, TimeoutRecord timeoutRecord, boolean isContinuousAnr) {
            this.this$0 = r3;
            this.mTimestamp = SystemClock.uptimeMillis();
            this.mApp = anrProcess;
            this.mPid = anrProcess.mPid;
            this.mUid = anrProcess.uid;
            this.mActivityShortComponentName = activityShortComponentName;
            this.mParentShortComponentName = parentShortComponentName;
            this.mTimeoutRecord = timeoutRecord;
            this.mAppInfo = aInfo;
            this.mParentProcess = parentProcess;
            this.mAboveSystem = aboveSystem;
            this.mIsContinuousAnr = isContinuousAnr;
        }

        void appNotResponding(boolean onlyDumpSelf) {
            AnrHelper.m1275$$Nest$fgetmService(this.this$0).mWindowManager.getObricExt().reportError(this.mParentProcess, 1);     // Catch: Throwable -> L9
            this.mTimeoutRecord.mLatencyTracker.anrProcessingStarted();     // Catch: Throwable -> L9
            this.mApp.mErrorState.appNotResponding(this.mActivityShortComponentName, this.mAppInfo, this.mParentShortComponentName, this.mParentProcess, this.mAboveSystem, this.mTimeoutRecord, AnrHelper.m1273$$Nest$fgetmAuxiliaryTaskExecutor(this.this$0), onlyDumpSelf, this.mIsContinuousAnr);     // Catch: Throwable -> L7
            this.mTimeoutRecord.mLatencyTracker.anrProcessingEnded();
            return;
        L7:
            th = move-exception;
            Throwable r12 = th;
        L11:
            this.mTimeoutRecord.mLatencyTracker.anrProcessingEnded();
            throw r12;
        L9:
            th = move-exception;
            r12 = th;
            goto L11
        }
    }

    public static /* synthetic */ Thread $r8$lambda$y7RFlsVN6Rac_UO6nHdK_btKHW0(Runnable r0) {
        return lambda$static$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAnrRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m1272$$Nest$fgetmAnrRecords(AnrHelper r0) {
        return r0.mAnrRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAuxiliaryTaskExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExecutorService m1273$$Nest$fgetmAuxiliaryTaskExecutor(AnrHelper r0) {
        return r0.mAuxiliaryTaskExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRunning, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m1274$$Nest$fgetmRunning(AnrHelper r0) {
        return r0.mRunning;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1275$$Nest$fgetmService(AnrHelper r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProcessingPid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1276$$Nest$fputmProcessingPid(AnrHelper r0, int r1) {
        r0.mProcessingPid = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mappNotResponding, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1277$$Nest$mappNotResponding(AnrHelper r0, AnrRecord r1) {
        r0.appNotResponding(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleBinderHeavyHitterAutoSamplerIfNecessary, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1278$$Nest$mscheduleBinderHeavyHitterAutoSamplerIfNecessary(AnrHelper r0) {
        r0.scheduleBinderHeavyHitterAutoSamplerIfNecessary();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartAnrConsumerIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1279$$Nest$mstartAnrConsumerIfNeeded(AnrHelper r0) {
        r0.startAnrConsumerIfNeeded();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetEXPIRED_REPORT_TIME_MS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1280$$Nest$sfgetEXPIRED_REPORT_TIME_MS() {
        return EXPIRED_REPORT_TIME_MS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSELF_ONLY_AFTER_BOOT_MS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1281$$Nest$sfgetSELF_ONLY_AFTER_BOOT_MS() {
        return SELF_ONLY_AFTER_BOOT_MS;
    }

    static {
        EXPIRED_REPORT_TIME_MS = TimeUnit.SECONDS.toMillis(10);
        CONSECUTIVE_ANR_TIME_MS = TimeUnit.MINUTES.toMillis(2);
        SELF_ONLY_AFTER_BOOT_MS = TimeUnit.MINUTES.toMillis(10);
        sDefaultThreadFactory = new AnrHelper$$ExternalSyntheticLambda0();
    }

    private static /* synthetic */ Thread lambda$static$0(Runnable r) {
        return new Thread(r, "AnrAuxiliaryTaskExecutor");
    }

    AnrHelper(ActivityManagerService service) {
        this(service, makeExpiringThreadPoolWithSize(1, sDefaultThreadFactory));
    }

    AnrHelper(ActivityManagerService service, ExecutorService auxExecutor) {
        this.mAnrRecords = new ArrayList();
        this.mRunning = new AtomicBoolean(false);
        this.mLastAnrTimeMs = 0;
        this.mProcessingPid = -1;
        final Looper r1 = FgThread.getHandler().getLooper();
        this.mFgHandler = new AnonymousClass1(this, r1);
        this.mService = service;
        this.mAuxiliaryTaskExecutor = auxExecutor;
    }

    void appNotResponding(ProcessRecord anrProcess, TimeoutRecord timeoutRecord) {
        appNotResponding(anrProcess, null, null, null, null, false, null, timeoutRecord, false);
    }

    void appNotResponding(ProcessRecord anrProcess, String activityShortComponentName, ApplicationInfo aInfo, String parentShortComponentName, WindowProcessController parentProcess, boolean aboveSystem, ExecutorService auxiliaryTaskExecutor, TimeoutRecord timeoutRecord, boolean isContinuousAnr) {
        if (auxiliaryTaskExecutor != null) goto L6;
        ExecutorService r0 = this.mAuxiliaryTaskExecutor;
    L6:
        anrProcess.mCrashPid = anrProcess.getPid();
        String annotation = timeoutRecord.mReason;
        Log.i(TAG, "appNotResponding:pid=" + anrProcess.mPid + " procname=" + anrProcess.processName + " reason=" + annotation);
        SystemProperties.set("debug.stabd.anr.pid", String.valueOf(anrProcess.mPid));     // Catch: Exception -> L18
        StringBuilder sb = new StringBuilder();     // Catch: Exception -> L18
        if (annotation != null) goto L10;
    L30:
        sb.append(annotation);     // Catch: Exception -> L18
    L31:
        SystemProperties.set("debug.stabd.anr.reason", sb.toString());     // Catch: Exception -> L18
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Exception -> L18
        long currentTimeMillis = System.currentTimeMillis();     // Catch: Exception -> L18
        String formattedDate = sdf.format(new Date(currentTimeMillis));     // Catch: Exception -> L18
        SystemProperties.set("debug.stabd.anr.time", formattedDate);     // Catch: Exception -> L18
    L34:
        SysMonitorSvcBridge.getFactory().getAnrMonitor().anrOccured(timeoutRecord.mReason, anrProcess.mPid, anrProcess.processName);
        appNotResponding(new AnrRecord(this, anrProcess, activityShortComponentName, aInfo, parentShortComponentName, parentProcess, aboveSystem, timeoutRecord, isContinuousAnr));
        return;
    L10:
        if (annotation.length() < 90) goto L30;
        if (annotation.contains("executing service") == false) goto L22;
        String subReason = annotation.substring(0, 80);     // Catch: Exception -> L18
        sb.append(subReason);     // Catch: Exception -> L18
        int index = annotation.indexOf("FG=");     // Catch: Exception -> L18
        if (index <= 0) goto L31;
        sb.append(" ");     // Catch: Exception -> L18
        sb.append(annotation.substring(index));     // Catch: Exception -> L18
        goto L31
    L22:
        if (annotation.contains("Input dispatching timed out") == false) goto L28;
        String subReason2 = annotation.substring(0, 74);     // Catch: Exception -> L18
        sb.append(subReason2);     // Catch: Exception -> L18
        int index2 = annotation.indexOf("seq=");     // Catch: Exception -> L18
        if (index2 <= 0) goto L31;
        sb.append(" ");     // Catch: Exception -> L18
        sb.append(annotation.substring(index2));     // Catch: Exception -> L18
        goto L31
    L28:
        if (annotation.contains("Broadcast of Intent") == false) goto L31;
        String subReason3 = annotation.substring(0, 66);     // Catch: Exception -> L18
        sb.append(subReason3);     // Catch: Exception -> L18
        sb.append(" ");     // Catch: Exception -> L18
        sb.append(annotation.substring(annotation.length() - 22));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Log.i(TAG, "set anr info error:" + e);
        goto L34
    }

    void deferAppNotResponding(ProcessRecord anrProcess, String activityShortComponentName, ApplicationInfo aInfo, String parentShortComponentName, WindowProcessController parentProcess, boolean aboveSystem, ExecutorService auxiliaryTaskExecutor, TimeoutRecord timeoutRecord, long delayInMillis, boolean isContinuousAnr) {
        if (auxiliaryTaskExecutor != null) goto L5;
        ExecutorService r0 = this.mAuxiliaryTaskExecutor;
    L5:
        AnrRecord anrRecord = new AnrRecord(this, anrProcess, activityShortComponentName, aInfo, parentShortComponentName, parentProcess, aboveSystem, timeoutRecord, isContinuousAnr);
        Message msg = Message.obtain();
        msg.what = 4;
        msg.obj = anrRecord;
        this.mFgHandler.sendMessageDelayed(msg, delayInMillis);
    }

    private void appNotResponding(AnrRecord anrRecord) {
        anrRecord.mTimeoutRecord.mLatencyTracker.appNotRespondingStarted();     // Catch: Throwable -> L37
        int incomingPid = anrRecord.mPid;     // Catch: Throwable -> L37
        anrRecord.mTimeoutRecord.mLatencyTracker.waitingOnAnrRecordLockStarted();     // Catch: Throwable -> L37
        ArrayList<AnrRecord> r1 = this.mAnrRecords;     // Catch: Throwable -> L37
        monitor-enter(r1);     // Catch: Throwable -> L37
        if (incomingPid != 0) goto L12;
        ProcessRecord anrProcess = anrRecord.mApp;     // Catch: Throwable -> L9
        Slog.i(TAG, "Skip zero pid ANR, process=" + anrProcess.processName);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        anrRecord.mTimeoutRecord.mLatencyTracker.appNotRespondingEnded();
        return;
    L12:
        if (this.mProcessingPid != incomingPid) goto L17;
        Slog.i(TAG, "Skip duplicated ANR, pid=" + incomingPid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        anrRecord.mTimeoutRecord.mLatencyTracker.appNotRespondingEnded();
        return;
    L17:
        int i = this.mAnrRecords.size() - 1;     // Catch: Throwable -> L9
    L18:
        if (i < 0) goto L32;
        if (this.mAnrRecords.get(i).mPid == incomingPid) goto L21;
        if (this.mProcessingPid == incomingPid) goto L27;
        anrRecord.mTimeoutRecord.mLatencyTracker.anrRecordPlacingOnQueueWithSize(this.mAnrRecords.size());     // Catch: Throwable -> L9
        i = i - 1;     // Catch: Throwable -> L9
        goto L18
    L27:
        Slog.i(TAG, "Skip duplicated ANR, pid=" + incomingPid + " " + anrRecord.mTimeoutRecord.mReason);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        anrRecord.mTimeoutRecord.mLatencyTracker.appNotRespondingEnded();
        return;
    L21:
        Slog.i(TAG, "Skip queued ANR, pid=" + incomingPid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        anrRecord.mTimeoutRecord.mLatencyTracker.appNotRespondingEnded();
        return;
    L32:
        this.mAnrRecords.add(anrRecord);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        startAnrConsumerIfNeeded();     // Catch: Throwable -> L37
        anrRecord.mTimeoutRecord.mLatencyTracker.appNotRespondingEnded();
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        anrRecord.mTimeoutRecord.mLatencyTracker.appNotRespondingEnded();
        throw th;
    }

    private void startAnrConsumerIfNeeded() {
        if (this.mRunning.compareAndSet(false, true) == false) goto L6;
        new AnrConsumerThread(this).start();
        return;
    }

    private static ThreadPoolExecutor makeExpiringThreadPoolWithSize(int size, ThreadFactory factory) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(size, size, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), factory);
        pool.allowCoreThreadTimeOut(true);
        return pool;
    }

    private void scheduleBinderHeavyHitterAutoSamplerIfNecessary() {
        Trace.traceBegin(64, "scheduleBinderHeavyHitterAutoSamplerIfNecessary()");     // Catch: Throwable -> L6
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L6
        if ((this.mLastAnrTimeMs + CONSECUTIVE_ANR_TIME_MS) <= now) goto L8;
        this.mService.scheduleBinderHeavyHitterAutoSampler();     // Catch: Throwable -> L6
    L8:
        this.mLastAnrTimeMs = now;     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }
}
