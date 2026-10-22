package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public interface SingleObserver<T> {
    void onError(@NonNull Throwable r10);

    void onSubscribe(@NonNull Disposable r10);

    void onSuccess(@NonNull T r10);
}
