package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadCompleteHandler {
    void handle(DownloadInfo r1);

    boolean needHandle(DownloadInfo r1);
}
