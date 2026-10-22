package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
    private static final long serialVersionUID = -2897979525538174559L;
    final MaybeObserver<? super R> downstream;
    final BiFunction<? super T, ? super U, ? extends R> resultSelector;
    T value;

    public MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver(MaybeObserver<? super R> r10, BiFunction<? super T, ? super U, ? extends R> r11) {
        this.downstream = r10;
        this.resultSelector = r11;
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(U r10) {
        T r11 = this.value;
        this.value = null;
        Object r12 = io.reactivex.internal.functions.a.b(this.resultSelector.apply(r11, r10), "The resultSelector returned a null value");     // Catch: Throwable -> L6
        this.downstream.onSuccess(r12);
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }
}
