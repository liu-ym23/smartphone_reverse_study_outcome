package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadHttpService {
    IDownloadHttpConnection downloadWithConnection(int r1, String r2, List<HttpHeader> r3);
}
