package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleNever extends Single<Object> {
    public static final Single<Object> INSTANCE = null;

    static {
        INSTANCE = new SingleNever();
    }

    private SingleNever() {
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Object> r1) {
        r1.onSubscribe(EmptyDisposable.NEVER);
    }
}
