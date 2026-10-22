package com.ss.android.socialbase.downloader.network;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadHeadHttpConnection {
    void cancel();

    int getResponseCode();

    String getResponseHeaderField(String r1);
}
