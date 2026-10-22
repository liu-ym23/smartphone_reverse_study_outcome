package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadTaskExecuteListener {
    void onFinish(DownloadTask r1, int r2);

    void onStart(DownloadTask r1, int r2);
}
