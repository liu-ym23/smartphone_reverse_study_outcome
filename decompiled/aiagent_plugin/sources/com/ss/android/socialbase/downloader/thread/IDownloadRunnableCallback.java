package com.ss.android.socialbase.downloader.thread;

import android.util.Pair;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadRunnableCallback {
    void checkMaxBytes(long r1, int r3);

    void handleFirstConnection(String r1, IDownloadHeadHttpConnection r2, long r3);

    boolean onProgress(long r1);

    void onReceiveData(byte[] r1, int r2);

    void onReceiveHeader(List<Pair<String, String>> r1);

    void onReceiveRequestLog(String r1);
}
