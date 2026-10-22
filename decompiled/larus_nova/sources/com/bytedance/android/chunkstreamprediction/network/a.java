package com.bytedance.android.chunkstreamprediction.network;

/* JADX INFO: loaded from: classes43.dex */
public interface a<T> {
    void onComplete();

    void onFailed(Throwable r100);

    void onNext(T r100);
}
