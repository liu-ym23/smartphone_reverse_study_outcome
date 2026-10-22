package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadRetrySchedulerService {

    public static class DefaultDownloadRetrySchedulerService implements IDownloadRetrySchedulerService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void doSchedulerRetry(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void scheduleRetryWhenHasTaskConnected() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void scheduleRetryWhenHasTaskSucceed() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler r2) {
            RetryScheduler.RetryScheduleHandler r1 = (RetryScheduler.RetryScheduleHandler) ZeusTransformUtils.wrapperContextForParams(r2, RetryScheduler.RetryScheduleHandler.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void tryCancelScheduleRetry(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void tryStartScheduleRetry(DownloadInfo r1) {
        }

        public DefaultDownloadRetrySchedulerService() {
        }
    }

    void doSchedulerRetry(int r1);

    void scheduleRetryWhenHasTaskConnected();

    void scheduleRetryWhenHasTaskSucceed();

    void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler r1);

    void tryCancelScheduleRetry(int r1);

    void tryStartScheduleRetry(DownloadInfo r1);
}
