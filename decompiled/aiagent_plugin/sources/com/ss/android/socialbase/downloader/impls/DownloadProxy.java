package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadProxy {
    private static volatile IDownloadProxy downloadIndependentProxy;
    private static volatile IDownloadProxy downloadProxy;

    public DownloadProxy() {
    }

    public static IDownloadProxy get(boolean r1) {
        if (r1 == false) goto L20;
        if (DownloadComponentManager.supportMultiProc() == false) goto L20;
        if (downloadIndependentProxy != null) goto L18;
        monitor-enter(DownloadProxy.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (downloadIndependentProxy != null) goto L12;
        downloadIndependentProxy = DownloadComponentManager.getIndependentHolderCreator().createProxy();     // Catch: Throwable -> L14
    L12:
        monitor-exit(DownloadProxy.class);     // Catch: Throwable -> L14
    L18:
        return downloadIndependentProxy;
    L20:
        if (downloadProxy != null) goto L31;
        monitor-enter(DownloadProxy.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (downloadProxy != null) goto L25;
        downloadProxy = new ProcessDownloadHandler();     // Catch: Throwable -> L27
    L25:
        monitor-exit(DownloadProxy.class);     // Catch: Throwable -> L27
    L31:
        return downloadProxy;
    }
}
