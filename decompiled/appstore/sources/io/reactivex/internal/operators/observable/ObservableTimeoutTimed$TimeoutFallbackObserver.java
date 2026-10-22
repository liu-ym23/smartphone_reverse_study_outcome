package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableTimeoutTimed$TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, ObservableTimeoutTimed$TimeoutSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    final Observer<? super T> downstream;
    ObservableSource<? extends T> fallback;
    final AtomicLong index;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<Disposable> upstream;
    final mf.f.a worker;

    public ObservableTimeoutTimed$TimeoutFallbackObserver(Observer<? super T> r10, long r11, TimeUnit r12, mf.f.a r13, ObservableSource<? extends T> r14) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.fallback = r14;
        this.task = new SequentialDisposable();
        this.index = new AtomicLong();
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
        throw null;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) goto L5;
        return;
    L5:
        this.task.dispose();
        this.downstream.onComplete();
        throw null;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.task.dispose();
        this.downstream.onError(r10);
        throw null;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        long r11 = this.index.get();
        if (r11 == Long.MAX_VALUE) goto L9;
        long r12 = 1 + r11;
        if (this.index.compareAndSet(r11, r12) == false) goto L10;
        this.task.get().dispose();
        this.downstream.onNext(r10);
        startTimeout(r12);
        return;
    L10:
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this.upstream, r10);
    }

    @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutSupport
    public void onTimeout(long r10) {
        if (this.index.compareAndSet(r10, Long.MAX_VALUE) == true) goto L5;
        return;
    L5:
        DisposableHelper.dispose(this.upstream);
        ObservableSource<? extends T> r11 = this.fallback;
        this.fallback = null;
        r11.subscribe(new i(this.downstream, this));
        throw null;
    }

    public void startTimeout(long r10) {
        new j(r10, this);
        throw null;
    }
}
