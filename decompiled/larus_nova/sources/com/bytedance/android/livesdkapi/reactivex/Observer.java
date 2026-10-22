package com.bytedance.android.livesdkapi.reactivex;

/* JADX INFO: loaded from: classes12.dex */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable r100);

    void onNext(T r100);

    void onSubscribe(Object r100);
}
