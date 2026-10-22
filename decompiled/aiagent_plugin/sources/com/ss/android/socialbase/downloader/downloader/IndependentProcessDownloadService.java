package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class IndependentProcessDownloadService extends DownloadService {
    public IndependentProcessDownloadService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
        if (DownloadComponentManager.getIndependentHolderCreator() != null) goto L5;
        DownloadComponentManager.setIndependentServiceCreator(new MultiProcCreater());
    L5:
        this.downloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        this.downloadServiceHandler.setDownloadService(new WeakReference(this));
    }
}
