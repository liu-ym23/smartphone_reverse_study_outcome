package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeFlatMapCompletable$FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, CompletableObserver, Disposable {
    private static final long serialVersionUID = -2177128922851101253L;
    final CompletableObserver downstream;
    final Function<? super T, ? extends CompletableSource> mapper;

    public MaybeFlatMapCompletable$FlatMapCompletableObserver(CompletableObserver r10, Function<? super T, ? extends CompletableSource> r11) {
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
        DisposableHelper.replace(this, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        CompletableSource r11 = (CompletableSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L7
        if (isDisposed() == true) goto L12;
        r11.subscribe(this);
        return;
    L12:
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        onError(th);
    }
}
