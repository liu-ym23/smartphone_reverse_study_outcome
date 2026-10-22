package com.ss.android.socialbase.downloader.downloader;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl;
import com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ISqlDownloadCache extends IDownloadCache {
    void init(SparseArray<DownloadInfo> r1, HashMap<Integer, Integer> r2, List<DownloadInfo> r3, List<String> r4, SqlCacheLoadCompleteCallback r5);

    void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r1);
}
