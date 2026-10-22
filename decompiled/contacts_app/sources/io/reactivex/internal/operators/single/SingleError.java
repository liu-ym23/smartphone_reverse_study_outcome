package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleError<T> extends Single<T> {
    final Callable<? extends Throwable> errorSupplier;

    public SingleError(Callable<? extends Throwable> r1) {
        this.errorSupplier = r1;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r2) {
        th = (Throwable) ObjectHelper.requireNonNull(this.errorSupplier.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L4
    L6:
        EmptyDisposable.error(th, r2);
        return;
    L4:
        th = th;
        Exceptions.throwIfFatal(th);
        goto L6
    }
}
