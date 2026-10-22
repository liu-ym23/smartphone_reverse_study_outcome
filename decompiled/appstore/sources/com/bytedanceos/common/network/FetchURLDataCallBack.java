package com.bytedanceos.common.network;

/* JADX INFO: loaded from: classes2.dex */
public interface FetchURLDataCallBack {
    void OnFetchURLDataFailed(String r10, Throwable r11, String r12, Object r13);

    void OnFetchURLDataSuccess(String r10, int r11, String r12, Object r13);
}
