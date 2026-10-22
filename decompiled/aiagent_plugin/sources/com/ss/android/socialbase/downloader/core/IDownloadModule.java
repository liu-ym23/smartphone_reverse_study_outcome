package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadModule {
    void cancel();

    IDownloadModule init(DownloadCommonParams r1);

    void pause();

    void proceed(IDownloadModuleChain r1);

    void setThrottleNetSpeed(long r1, int r3);
}
