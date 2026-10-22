package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mf.f;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeDelay$DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
    private static final long serialVersionUID = 5566860102500855068L;
    final long delay;
    final MaybeObserver<? super T> downstream;
    Throwable error;
    final f scheduler;
    final TimeUnit unit;
    T value;

    public MaybeDelay$DelayMaybeObserver(MaybeObserver<? super T> r10, long r11, TimeUnit r12, f r13) {
        this.downstream = r10;
        this.delay = r11;
        this.unit = r12;
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
        schedule();
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.error = r10;
        schedule();
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        this.value = r10;
        schedule();
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r10 = this.error;
        if (r10 == null) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        T r11 = this.value;
        if (r11 == null) goto L8;
        this.downstream.onSuccess(r11);
        return;
    L8:
        this.downstream.onComplete();
    }

    public void schedule() {
        throw null;
    }
}
