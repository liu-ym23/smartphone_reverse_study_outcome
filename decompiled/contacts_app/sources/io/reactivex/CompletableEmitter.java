package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

/* JADX INFO: loaded from: classes4.dex */
public interface CompletableEmitter {
    boolean isDisposed();

    void onComplete();

    void onError(Throwable r1);

    void setCancellable(Cancellable r1);

    void setDisposable(Disposable r1);

    boolean tryOnError(Throwable r1);
}
