package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.MultiProcCreater;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadMultiProcService implements IDownloadMultiProcService {
    public DownloadMultiProcService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMultiProcService
    public void registerIndependentServiceCreator() {
        DownloadComponentManager.setIndependentServiceCreator(new MultiProcCreater());
    }
}
