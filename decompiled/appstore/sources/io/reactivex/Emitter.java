package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(@NonNull Throwable r10);

    void onNext(@NonNull T r10);
}
