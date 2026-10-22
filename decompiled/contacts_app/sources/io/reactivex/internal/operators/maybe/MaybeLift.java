package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOperator;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeLift<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final MaybeOperator<? extends R, ? super T> operator;

    public MaybeLift(MaybeSource<T> r1, MaybeOperator<? extends R, ? super T> r2) {
        super(r1);
        this.operator = r2;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super R> r3) {
        MaybeObserver<? super T> r0 = (MaybeObserver) ObjectHelper.requireNonNull(this.operator.apply(r3), "The operator returned a null MaybeObserver");     // Catch: Throwable -> L5
        this.source.subscribe(r0);
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r3);
    }
}
