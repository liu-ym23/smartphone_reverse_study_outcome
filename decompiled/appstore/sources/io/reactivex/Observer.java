package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public interface Observer<T> {
    void onComplete();

    void onError(@NonNull Throwable r10);

    void onNext(@NonNull T r10);

    void onSubscribe(@NonNull Disposable r10);
}
