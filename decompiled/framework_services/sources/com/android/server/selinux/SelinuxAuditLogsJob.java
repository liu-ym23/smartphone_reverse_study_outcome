package com.android.server.selinux;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Slog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class SelinuxAuditLogsJob {
    private static final String TAG = "SelinuxAuditLogs";
    private final SelinuxAuditLogsCollector mAuditLogsCollector;
    private final AtomicBoolean mIsRunning;

    SelinuxAuditLogsJob(SelinuxAuditLogsCollector auditLogsCollector) {
        this.mIsRunning = new AtomicBoolean(false);
        this.mAuditLogsCollector = auditLogsCollector;
    }

    void requestStop() {
        this.mAuditLogsCollector.mStopRequested.set(true);
    }

    boolean isRunning() {
        return this.mIsRunning.get();
    }

    public void start(JobService jobService, JobParameters params) {
        this.mAuditLogsCollector.mStopRequested.set(false);
        if (this.mIsRunning.get() == false) goto L6;
        Slog.i(TAG, "Selinux audit job is already running, ignore start request.");
        return;
    L6:
        this.mIsRunning.set(true);
        boolean done = this.mAuditLogsCollector.collect(SelinuxAuditLogsService.AUDITD_TAG_CODE);     // Catch: QuotaExceededException -> L11
        if (done == false) goto L15;
        jobService.jobFinished(params, false);     // Catch: QuotaExceededException -> L11
    L15:
        this.mIsRunning.set(false);
        return;
    L14:
        jobService.jobFinished(params, false);
        goto L15
    }
}
