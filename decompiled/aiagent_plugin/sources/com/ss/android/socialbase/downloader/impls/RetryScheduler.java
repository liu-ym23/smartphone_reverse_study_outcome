package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class RetryScheduler implements IDownloadRetrySchedulerService {
    public static final int NET_TYPE_COMMON = 1;
    public static final int NET_TYPE_NONE = 0;
    public static final int NET_TYPE_WIFI = 2;
    private static volatile RetryScheduler sInstance;
    private IDownloadRetrySchedulerService service;

    public interface RetryScheduleHandler {
        void cancelRetry(int r1);

        void scheduleRetry(DownloadInfo r1, long r2, boolean r4, int r5);
    }

    private RetryScheduler() {
        this.service = (IDownloadRetrySchedulerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadRetrySchedulerService.class), IDownloadRetrySchedulerService.class, "com.obric.aiagent.plugin");
    }

    public static RetryScheduler getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(RetryScheduler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new RetryScheduler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RetryScheduler.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void setRetryScheduleHandler(RetryScheduleHandler r3) {
        RetryScheduleHandler r4 = (RetryScheduleHandler) ZeusTransformUtils.wrapperContextForParams(r3, RetryScheduleHandler.class, "com.obric.aiagent.plugin");
        this.service.setRetryScheduleHandler(r4);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryStartScheduleRetry(DownloadInfo r1) {
        this.service.tryStartScheduleRetry(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryCancelScheduleRetry(int r1) {
        this.service.tryCancelScheduleRetry(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void doSchedulerRetry(int r1) {
        this.service.doSchedulerRetry(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskSucceed() {
        this.service.scheduleRetryWhenHasTaskSucceed();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskConnected() {
        this.service.scheduleRetryWhenHasTaskConnected();
    }
}
