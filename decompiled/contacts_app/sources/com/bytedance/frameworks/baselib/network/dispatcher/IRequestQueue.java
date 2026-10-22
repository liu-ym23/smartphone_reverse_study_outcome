package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public interface IRequestQueue {
    void add(ApiThread r1);

    void add(IApiTask r1);

    void addDownload(ApiThread r1);

    void addDownload(IApiTask r1);
}
