package com.android.ttcjpaysdk.base.network;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayNetWorkCallback<T> {
    void onFailure(String r100, String r101);

    void onSuccess(T r100);
}
