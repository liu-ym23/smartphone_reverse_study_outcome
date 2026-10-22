package com.android.server.security;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Slog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class UpdateCertificateRevocationStatusJobService extends JobService {
    private static final String TAG = "AVF_CRL";
    private ExecutorService mExecutorService;

    public static /* synthetic */ void $r8$lambda$FQ5pfV6Ncw9NXU64tx3c0B_7Qp4(UpdateCertificateRevocationStatusJobService r0, JobParameters r1) {
        r0.lambda$onStartJob$0(r1);
    }

    public UpdateCertificateRevocationStatusJobService() {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mExecutorService = Executors.newSingleThreadExecutor();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        this.mExecutorService.execute(new UpdateCertificateRevocationStatusJobService$$ExternalSyntheticLambda0(this, params));
        return true;
    }

    private /* synthetic */ void lambda$onStartJob$0(JobParameters params) {
        CertificateRevocationStatusManager certificateRevocationStatusManager = new CertificateRevocationStatusManager(this);     // Catch: Throwable -> L5
        Slog.d(TAG, "Starting to fetch remote CRL from job service.");     // Catch: Throwable -> L5
        byte[] revocationList = certificateRevocationStatusManager.fetchRemoteRevocationListBytes();     // Catch: Throwable -> L5
        certificateRevocationStatusManager.silentlyStoreRevocationList(revocationList);     // Catch: Throwable -> L5
    L7:
        jobFinished(params, false);
        return;
    L5:
        t = move-exception;
        Slog.e(TAG, "Unable to update the stored revocation list.", t);
        goto L7
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mExecutorService.shutdown();
    }
}
