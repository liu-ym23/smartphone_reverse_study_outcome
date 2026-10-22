package com.media.cache.listener;

import q9.a;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadTaskListener {
    void onLocalProxyReady(String r10);

    void onTaskFailed(Throwable r10);

    void onTaskFinished(long r10);

    void onTaskPaused();

    void onTaskProgress(float r10, long r11, a r12);

    void onTaskSpeedChanged(float r10);

    void onTaskStart(String r10);
}
