package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableUsing$UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
    private static final long serialVersionUID = -674404550052917487L;
    final Consumer<? super R> disposer;
    final CompletableObserver downstream;
    final boolean eager;
    Disposable upstream;

    public CompletableUsing$UsingObserver(CompletableObserver r10, R r11, Consumer<? super R> r12, boolean r13) {
        super(r11);
        this.downstream = r10;
        this.disposer = r12;
        this.eager = r13;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        disposeResourceAfter();
    }

    public void disposeResourceAfter() {
        Object r10 = getAndSet(this);
        if (r10 == this) goto L11;
        this.disposer.accept(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager == false) goto L11;
        Object r10 = getAndSet(this);
        if (r10 == this) goto L17;
        this.disposer.accept(r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    L17:
        return;
    L11:
        this.downstream.onComplete();
        if (this.eager == true) goto L18;
        disposeResourceAfter();
        return;
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        this.upstream = DisposableHelper.DISPOSED;
        if (this.eager == false) goto L11;
        Object r11 = getAndSet(this);
        if (r11 != this) goto L15;
        return;
    L15:
        this.disposer.accept(r11);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r10 = new CompositeException(new Throwable[]{r10, th});
    L11:
        this.downstream.onError(r10);
        if (this.eager == true) goto L17;
        disposeResourceAfter();
        return;
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
