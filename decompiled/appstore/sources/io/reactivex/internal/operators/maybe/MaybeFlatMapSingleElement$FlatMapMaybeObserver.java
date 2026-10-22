package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeFlatMapSingleElement$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 4827726964688405508L;
    final MaybeObserver<? super R> downstream;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;

    public MaybeFlatMapSingleElement$FlatMapMaybeObserver(MaybeObserver<? super R> r10, Function<? super T, ? extends SingleSource<? extends R>> r11) {
        this.downstream = r10;
        this.mapper = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
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
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        SingleSource r11 = (SingleSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null SingleSource");     // Catch: Throwable -> L5
        r11.subscribe(new c(this, this.downstream));
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        onError(th);
    }
}
