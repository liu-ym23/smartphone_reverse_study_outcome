package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableSkipLastTimed$SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final Observer<? super T> downstream;
    Throwable error;
    final io.reactivex.internal.queue.a queue;
    final mf.f scheduler;
    final long time;
    final TimeUnit unit;
    Disposable upstream;

    public ObservableSkipLastTimed$SkipLastTimedObserver(Observer<? super T> r10, long r11, TimeUnit r12, mf.f r13, int r14, boolean r15) {
        this.downstream = r10;
        this.time = r11;
        this.unit = r12;
        this.queue = new io.reactivex.internal.queue.a(r14);
        this.delayError = r15;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.dispose();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.a r10 = this.queue;
        if (this.cancelled == false) goto L9;
        this.queue.clear();
        return;
    L9:
        Long r11 = (Long) r10.peek();
        throw null;
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
