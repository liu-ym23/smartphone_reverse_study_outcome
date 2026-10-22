package com.jeffmony.async.future;

import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public interface Future<T> extends Cancellable, java.util.concurrent.Future<T> {
    static /* synthetic */ void a(Future r10, SimpleFuture r11) {
        r10.lambda$executorThread$0(r11);
    }

    private /* synthetic */ default void lambda$executorThread$0(SimpleFuture r10) {
        r10.G(this);
    }

    Future<T> done(DoneCallback<T> r10);

    @RequiresApi(api = 24)
    default Future<T> executorThread(Executor r10) {
        final SimpleFuture r11 = new SimpleFuture();
        r10.execute(new c(this, r11));
        return r11;
    }

    Future<T> fail(FailCallback r10);

    Future<T> failConvert(FailConvertCallback<T> r10);

    Future<T> failRecover(FailRecoverCallback<T> r10);

    void setCallback(FutureCallback<T> r10);

    Future<T> success(SuccessCallback<T> r10);

    <R> Future<R> then(ThenFutureCallback<R, T> r10);

    <R> Future<R> thenConvert(ThenCallback<R, T> r10);

    T tryGet();

    Exception tryGetException();
}
