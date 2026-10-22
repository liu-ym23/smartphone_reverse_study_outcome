package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.impls.RetrySchedulerImpl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadRetrySchedulerService implements IDownloadRetrySchedulerService {
    public DownloadRetrySchedulerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler r2) {
        RetrySchedulerImpl.setRetryScheduleHandler((RetryScheduler.RetryScheduleHandler) ZeusTransformUtils.wrapperContextForParams(r2, RetryScheduler.RetryScheduleHandler.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryStartScheduleRetry(DownloadInfo r1) {
        RetrySchedulerImpl.getInstance().tryStartScheduleRetry(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryCancelScheduleRetry(int r1) {
        RetrySchedulerImpl.getInstance().tryCancelScheduleRetry(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void doSchedulerRetry(int r1) {
        RetrySchedulerImpl.getInstance().doSchedulerRetry(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskSucceed() {
        RetrySchedulerImpl.getInstance().scheduleRetryWhenHasTaskSucceed();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskConnected() {
        RetrySchedulerImpl.getInstance().scheduleRetryWhenHasTaskConnected();
    }
}
