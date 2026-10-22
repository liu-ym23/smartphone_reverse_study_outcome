package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleJust<T> extends Single<T> {
    final T value;

    public SingleJust(T r1) {
        this.value = r1;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r2) {
        r2.onSubscribe(Disposables.disposed());
        r2.onSuccess(this.value);
    }
}
