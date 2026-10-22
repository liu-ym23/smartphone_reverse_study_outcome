package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

/* JADX INFO: loaded from: classes4.dex */
public interface SingleEmitter<T> {
    boolean isDisposed();

    void onError(@NonNull Throwable r10);

    void onSuccess(@NonNull T r10);

    void setCancellable(@Nullable Cancellable r10);

    void setDisposable(@Nullable Disposable r10);

    boolean tryOnError(@NonNull Throwable r10);
}
