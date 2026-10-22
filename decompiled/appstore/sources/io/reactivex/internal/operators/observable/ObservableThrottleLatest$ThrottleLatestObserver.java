package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableThrottleLatest$ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final Observer<? super T> downstream;
    final boolean emitLast;
    Throwable error;
    final AtomicReference<T> latest;
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    Disposable upstream;
    final mf.f.a worker;

    public ObservableThrottleLatest$ThrottleLatestObserver(Observer<? super T> r10, long r11, TimeUnit r12, mf.f.a r13, boolean r14) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.emitLast = r14;
        this.latest = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        throw null;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<T> r10 = this.latest;
        Observer<? super T> r11 = this.downstream;
        int r12 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r13 = this.done;
        if (r13 == false) goto L18;
        if (this.error == null) goto L18;
        r10.lazySet(null);
        r11.onError(this.error);
        throw null;
    L18:
        if (r10.get() != null) goto L20;
        boolean r14 = true;
    L21:
        if (r13 == true) goto L22;
        if (r14 == false) goto L34;
        if (this.timerFired == false) goto L37;
        this.timerRunning = false;
        this.timerFired = false;
    L37:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L34:
        if (this.timerRunning == false) goto L40;
        if (this.timerFired == false) goto L37;
    L40:
        r11.onNext(r10.getAndSet(null));
        this.timerFired = false;
        this.timerRunning = true;
        throw null;
    L22:
        T r15 = r10.getAndSet(null);
        if (r14 == false) goto L25;
    L27:
        r11.onComplete();
        throw null;
    L25:
        if (this.emitLast == false) goto L27;
        r11.onNext(r15);
        goto L27
    L20:
        r14 = false;
        goto L21
    L8:
        r10.lazySet(null);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        this.latest.set(r10);
        drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.timerFired = true;
        drain();
    }
}
