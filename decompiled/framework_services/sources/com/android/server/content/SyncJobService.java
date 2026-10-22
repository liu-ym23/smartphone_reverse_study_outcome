package com.android.server.content;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import com.android.server.slice.SliceClientPermissions;

/* JADX INFO: loaded from: classes.dex */
public class SyncJobService extends JobService {
    private static final String TAG = "SyncManager";
    private static SyncJobService sInstance;
    private static final SparseArray<JobParameters> sJobParamsMap = null;
    private static final SparseLongArray sJobStartUptimes = null;
    private static final Object sLock = null;
    private static final SyncLogger sLogger = null;
    private static final SparseBooleanArray sStartedSyncs = null;

    public SyncJobService() {
    }

    static {
        sLock = new Object();
        sJobParamsMap = new SparseArray();
        sStartedSyncs = new SparseBooleanArray();
        sJobStartUptimes = new SparseLongArray();
        sLogger = SyncLogger.getInstance();
    }

    private void updateInstance() {
        monitor-enter(SyncJobService.class);
        sInstance = this;     // Catch: Throwable -> L7
        monitor-exit(SyncJobService.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static SyncJobService getInstance() {
        Object r0 = sLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        Slog.wtf("SyncManager", "sInstance == null");     // Catch: Throwable -> L7
    L9:
        SyncJobService r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    public static boolean isReady() {
        Object r0 = sLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        updateInstance();
        sLogger.purgeOldLogs();
        SyncOperation op = SyncOperation.maybeCreateFromJobExtras(params.getExtras());
        if (op != null) goto L6;
        Slog.wtf("SyncManager", "Got invalid job " + params.getJobId());
        return false;
    L6:
        boolean readyToSync = SyncManager.readyToSync(op.target.userId);
        sLogger.log(new Object[]{"onStartJob() jobid=", Integer.valueOf(params.getJobId()), " op=", op, " readyToSync", Boolean.valueOf(readyToSync)});
        if (readyToSync == true) goto L10;
        boolean wantsReschedule = !op.isPeriodic;
        jobFinished(params, wantsReschedule);
        return true;
    L10:
        boolean isLoggable = Log.isLoggable("SyncManager", 2);
        Object r2 = sLock;
        monitor-enter(r2);
        int jobId = params.getJobId();     // Catch: Throwable -> L19
        sJobParamsMap.put(jobId, params);     // Catch: Throwable -> L19
        sStartedSyncs.delete(jobId);     // Catch: Throwable -> L19
        sJobStartUptimes.put(jobId, SystemClock.uptimeMillis());     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        Message m = Message.obtain();
        m.what = 10;
        if (isLoggable == false) goto L17;
        Slog.v("SyncManager", "Got start job message " + op.target);
    L17:
        m.obj = op;
        SyncManager.sendMessage(m);
        return true;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        if (Log.isLoggable("SyncManager", 2) == false) goto L5;
        Slog.v("SyncManager", "onStopJob called " + params.getJobId() + ", reason: " + params.getInternalStopReasonCode());
    L5:
        SyncOperation op = SyncOperation.maybeCreateFromJobExtras(params.getExtras());
        if (op != null) goto L9;
        Slog.wtf("SyncManager", "Got invalid job " + params.getJobId());
        return false;
    L9:
        boolean readyToSync = SyncManager.readyToSync(op.target.userId);
        sLogger.log(new Object[]{"onStopJob() ", sLogger.jobParametersToString(params), " readyToSync=", Boolean.valueOf(readyToSync)});
        Object r3 = sLock;
        monitor-enter(r3);
        int jobId = params.getJobId();     // Catch: Throwable -> L17
        sJobParamsMap.remove(jobId);     // Catch: Throwable -> L17
        long startUptime = sJobStartUptimes.get(jobId);     // Catch: Throwable -> L17
        long nowUptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L17
        long runtime = nowUptime - startUptime;     // Catch: Throwable -> L17
        if (runtime <= 60000) goto L19;
        if (readyToSync == false) goto L19;
        if (sStartedSyncs.get(jobId) == true) goto L19;
        wtf("Job " + jobId + " didn't start:  startUptime=" + startUptime + " nowUptime=" + nowUptime + " params=" + jobParametersToString(params));     // Catch: Throwable -> L17
    L19:
        sStartedSyncs.delete(jobId);     // Catch: Throwable -> L17
        sJobStartUptimes.delete(jobId);     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        Message m = Message.obtain();
        m.what = 11;
        m.obj = op;
        int r5 = 1;
        if (params.getInternalStopReasonCode() == 0) goto L24;
        int r4 = 1;
    L25:
        m.arg1 = r4;
        if (params.getInternalStopReasonCode() == 3) goto L29;
        r5 = 0;
    L29:
        m.arg2 = r5;
        SyncManager.sendMessage(m);
        return false;
    L24:
        r4 = 0;
    L17:
        th = move-exception;
        throw th;
    }

    public static void callJobFinished(int jobId, boolean needsReschedule, String why) {
        SyncJobService instance = getInstance();
        if (instance == null) goto L6;
        instance.callJobFinishedInner(jobId, needsReschedule, why);
        return;
    }

    public void callJobFinishedInner(int jobId, boolean needsReschedule, String why) {
        Object r1 = sLock;
        monitor-enter(r1);
        JobParameters params = sJobParamsMap.get(jobId);     // Catch: Throwable -> L14
        sLogger.log(new Object[]{"callJobFinished()", " jobid=", Integer.valueOf(jobId), " needsReschedule=", Boolean.valueOf(needsReschedule), " ", sLogger.jobParametersToString(params), " why=", why});     // Catch: Throwable -> L9
        if (params == null) goto L11;
        jobFinished(params, needsReschedule);     // Catch: Throwable -> L9
        sJobParamsMap.remove(jobId);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.e("SyncManager", "Job params not found for " + String.valueOf(jobId));     // Catch: Throwable -> L9
    L14:
        th = move-exception;
        Throwable r15 = th;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r15;
    L9:
        th = move-exception;
        r15 = th;
        goto L16
    }

    public static void markSyncStarted(int jobId) {
        Object r0 = sLock;
        monitor-enter(r0);
        sStartedSyncs.put(jobId, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String jobParametersToString(JobParameters params) {
        if (params != null) goto L6;
        return "job:null";
    L6:
        return "job:#" + params.getJobId() + ":sr=[" + params.getInternalStopReasonCode() + SliceClientPermissions.SliceAuthority.DELIMITER + params.getDebugStopReason() + "]:" + SyncOperation.maybeCreateFromJobExtras(params.getExtras());
    }

    private static void wtf(String message) {
        sLogger.log(new Object[]{message});
        Slog.wtf("SyncManager", message);
    }
}
