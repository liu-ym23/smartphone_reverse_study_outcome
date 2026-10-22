package com.ss.android.socialbase.downloader.downloader;

import android.os.IBinder;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadServiceConnectionListener {
    void onServiceConnection(IBinder r1);

    void onServiceDisConnection();
}
