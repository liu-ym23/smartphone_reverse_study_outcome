package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadServiceHandler<T extends DownloadService> {
    boolean isServiceAlive();

    IBinder onBind(Intent r1);

    void onDestroy();

    void onStartCommand(Intent r1, int r2, int r3);

    void onStartCommandOnMainThread();

    void pendDownloadTask(DownloadTask r1);

    void setDownloadService(WeakReference<T> r1);

    void setLogLevel(int r1);

    void setServiceConnectionListener(IDownloadServiceConnectionListener r1);

    void startService();

    void tryDownload(DownloadTask r1);

    void tryDownloadWithEngine(DownloadTask r1);
}
