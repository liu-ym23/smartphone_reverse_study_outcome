package com.ss.android.socialbase.downloader.network;

import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadHttpConnection extends IDownloadHeadHttpConnection {
    void end();

    InputStream getInputStream();
}
