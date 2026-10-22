package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeDoFinally$DoFinallyObserver<T> extends AtomicInteger implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;
    final MaybeObserver<? super T> downstream;
    final Action onFinally;
    Disposable upstream;

    public MaybeDoFinally$DoFinallyObserver(MaybeObserver<? super T> r10, Action r11) {
        this.downstream = r10;
        this.onFinally = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        runFinally();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        runFinally();
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
        runFinally();
    }

    public void runFinally() {
        if (compareAndSet(0, 1) == false) goto L11;
        this.onFinally.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        return;
    }
}
