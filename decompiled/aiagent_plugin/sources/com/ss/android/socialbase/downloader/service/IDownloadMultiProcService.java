package com.ss.android.socialbase.downloader.service;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadMultiProcService {

    public static class DefaultDownloadMultiProcService implements IDownloadMultiProcService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadMultiProcService
        public void registerIndependentServiceCreator() {
        }

        public DefaultDownloadMultiProcService() {
        }
    }

    void registerIndependentServiceCreator();
}
