package com.media.cache.listener;

import s9.b;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadListener {
    void onDownloadDefault(b r10);

    void onDownloadError(b r10);

    void onDownloadPause(b r10);

    void onDownloadPending(b r10);

    void onDownloadPrepare(b r10);

    void onDownloadProgress(b r10);

    void onDownloadProxyForbidden(b r10);

    void onDownloadProxyReady(b r10);

    void onDownloadSpeed(b r10);

    void onDownloadStart(b r10);

    void onDownloadSuccess(b r10);
}
