package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadGlobalThrottleService {

    public static class DefaultDownloadGlobalThrottleService implements IDownloadGlobalThrottleService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void end(DownloadTask r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void setGlobalThrottle(int r1, int r2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void start(DownloadTask r1) {
        }

        public DefaultDownloadGlobalThrottleService() {
        }
    }

    void end(DownloadTask r1);

    void setGlobalThrottle(int r1, int r2);

    void start(DownloadTask r1);
}
