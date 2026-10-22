package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsDownloadInterceptor implements IDownloadInterceptor {
    public boolean intercept(DownloadInfo r1) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
    @Deprecated
    public boolean intercepte() {
        return false;
    }

    public AbsDownloadInterceptor() {
    }
}
