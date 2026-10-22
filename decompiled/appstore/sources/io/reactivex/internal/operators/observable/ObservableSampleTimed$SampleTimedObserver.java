package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
abstract class ObservableSampleTimed$SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final Observer<? super T> downstream;
    final long period;
    final mf.f scheduler;
    final AtomicReference<Disposable> timer;
    final TimeUnit unit;
    Disposable upstream;

    public ObservableSampleTimed$SampleTimedObserver(Observer<? super T> r10, long r11, TimeUnit r12, mf.f r13) {
        this.timer = new AtomicReference();
        this.downstream = r10;
        this.period = r11;
        this.unit = r12;
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        cancelTimer();
        this.upstream.dispose();
    }

    public void emit() {
        T r10 = getAndSet(null);
        if (r10 == null) goto L6;
        this.downstream.onNext(r10);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        cancelTimer();
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        lazySet(r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == true) goto L5;
        return;
    L5:
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        throw null;
    }
}
