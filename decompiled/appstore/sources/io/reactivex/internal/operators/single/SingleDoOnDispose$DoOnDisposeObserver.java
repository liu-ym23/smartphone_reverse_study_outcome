package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class SingleDoOnDispose$DoOnDisposeObserver<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = -8583764624474935784L;
    final SingleObserver<? super T> downstream;
    Disposable upstream;

    public SingleDoOnDispose$DoOnDisposeObserver(SingleObserver<? super T> r10, Action r11) {
        this.downstream = r10;
        lazySet(r11);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Action r10 = getAndSet(null);
        if (r10 == null) goto L12;
        r10.run();     // Catch: Throwable -> L6
    L8:
        this.upstream.dispose();
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        goto L8
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }
}
