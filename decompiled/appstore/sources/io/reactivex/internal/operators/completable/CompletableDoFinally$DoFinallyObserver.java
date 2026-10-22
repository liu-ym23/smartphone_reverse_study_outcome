package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableDoFinally$DoFinallyObserver extends AtomicInteger implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;
    final CompletableObserver downstream;
    final Action onFinally;
    Disposable upstream;

    public CompletableDoFinally$DoFinallyObserver(CompletableObserver r10, Action r11) {
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

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        runFinally();
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
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
