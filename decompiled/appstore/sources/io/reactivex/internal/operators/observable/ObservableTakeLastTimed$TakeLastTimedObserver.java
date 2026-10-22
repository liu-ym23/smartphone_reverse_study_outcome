package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableTakeLastTimed$TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final long count;
    final boolean delayError;
    final Observer<? super T> downstream;
    Throwable error;
    final io.reactivex.internal.queue.a queue;
    final mf.f scheduler;
    final long time;
    final TimeUnit unit;
    Disposable upstream;

    public ObservableTakeLastTimed$TakeLastTimedObserver(Observer<? super T> r10, long r11, long r12, TimeUnit r13, mf.f r14, int r15, boolean r16) {
        this.downstream = r10;
        this.count = r11;
        this.time = r12;
        this.unit = r13;
        this.queue = new io.reactivex.internal.queue.a(r15);
        this.delayError = r16;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.dispose();
        if (compareAndSet(false, true) == false) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    public void drain() {
        if (compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Observer<? super T> r10 = this.downstream;
        io.reactivex.internal.queue.a r11 = this.queue;
        boolean r12 = this.delayError;
        if (this.cancelled == false) goto L9;
        r11.clear();
        return;
    L9:
        if (r12 == true) goto L14;
        Throwable r13 = this.error;
        if (r13 == null) goto L14;
        r11.clear();
        r10.onError(r13);
        return;
    L14:
        Object r14 = r11.poll();
        if (r14 != null) goto L21;
        Throwable r15 = this.error;
        if (r15 == null) goto L19;
        r10.onError(r15);
        return;
    L19:
        r10.onComplete();
        return;
    L21:
        r11.poll();
        ((Long) r14).longValue();
        throw null;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.error = r10;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        throw null;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
