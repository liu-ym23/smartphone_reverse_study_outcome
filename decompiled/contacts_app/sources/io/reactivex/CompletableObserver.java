package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public interface CompletableObserver {
    void onComplete();

    void onError(Throwable r1);

    void onSubscribe(Disposable r1);
}
