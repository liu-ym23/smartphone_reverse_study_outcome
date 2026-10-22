package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.downloader.IDownloadServiceLoader;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadServiceLoader implements IDownloadServiceLoader {
    private static final String TAG = "DownloadServiceLoader";
    private static boolean isLoaded = false;

    static {
    }

    public DownloadServiceLoader() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceLoader
    public void load() {
        monitor-enter(DownloadServiceManager.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (isLoaded == false) goto L8;
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L17
        return;
    L8:
        isLoaded = true;     // Catch: Throwable -> L17
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "load", "Load download service start");     // Catch: Throwable -> L17
    L11:
        DownloadServiceManager.registerService(IDownloadMonitorHelperService.class, new DownloadMonitorHelperService());     // Catch: Throwable -> L17
        DownloadServiceManager.registerService(IDownloadIdGeneratorService.class, new DownloadIdGeneratorService());     // Catch: Throwable -> L17
        DownloadServiceManager.registerService(IDownloadComponentManagerService.class, new DownloadComponentManagerService());     // Catch: Throwable -> L17
        DownloadServiceManager.registerService(IDownloadProcessDispatcherService.class, new DownloadProcessDispatcherService());     // Catch: Throwable -> L17
        DownloadServiceManager.registerService(IDownloadNetTrafficManagerService.class, new DownloadNetTrafficManagerService());     // Catch: Throwable -> L17
        DownloadServiceManager.registerService(IDownloadNotificationManagerService.class, new DownloadNotificationManagerService());     // Catch: Throwable -> L17
        DownloadServiceManager.registerService(IDownloadNetworkService.class, new DownloadNetworkService());     // Catch: Throwable -> L17
        DownloadServiceManager.registerService(IDownloadRetrySchedulerService.class, new DownloadRetrySchedulerService());     // Catch: Throwable -> L17
        DownloadServiceManager.registerService(IDownloadMultiProcService.class, new DownloadMultiProcService());     // Catch: Throwable -> L17
        DownloadServiceManager.registerService(IDownloadGlobalThrottleService.class, new DownloadGlobalThrottleService());     // Catch: Throwable -> L17
        DownloadServiceManager.setServiceLoaded();     // Catch: Throwable -> L17
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L17
        if (Logger.debug() == false) goto L21;
        Logger.globalDebug(TAG, "load", "Load download service end");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceLoader
    public void defaultLoadCallback(boolean r3, String r4) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "defaultLoadCallback", "Load status:" + r3 + " errorMsg:" + r4);
        return;
    }
}
