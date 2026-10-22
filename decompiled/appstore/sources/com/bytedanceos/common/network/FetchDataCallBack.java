package com.bytedanceos.common.network;

/* JADX INFO: loaded from: classes2.dex */
public interface FetchDataCallBack {
    void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13);

    void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14);
}
