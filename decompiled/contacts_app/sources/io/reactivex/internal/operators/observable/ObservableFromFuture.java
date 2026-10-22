package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableFromFuture<T> extends Observable<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public ObservableFromFuture(Future<? extends T> r1, long r2, TimeUnit r4) {
        this.future = r1;
        this.timeout = r2;
        this.unit = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r6) {
        DeferredScalarDisposable r0 = new DeferredScalarDisposable(r6);
        r6.onSubscribe(r0);
        if (r0.isDisposed() == true) goto L17;
        TimeUnit r1 = this.unit;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        T r5 = this.future.get(this.timeout, r1);     // Catch: Throwable -> L10
    L8:
        r0.complete(ObjectHelper.requireNonNull(r5, "Future returned null"));
        return;
    L7:
        r5 = this.future.get();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r0.isDisposed() == true) goto L19;
        r6.onError(th);
        return;
    L19:
        return;
    }
}
