package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableThrottleFirstTimed$DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
    private static final long serialVersionUID = 786994795061867455L;
    boolean done;
    final Observer<? super T> downstream;
    volatile boolean gate;
    final long timeout;
    final TimeUnit unit;
    Disposable upstream;
    final mf.f.a worker;

    public ObservableThrottleFirstTimed$DebounceTimedObserver(Observer<? super T> r10, long r11, TimeUnit r12, mf.f.a r13) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        throw null;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        throw null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
        throw null;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
        throw null;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (this.gate == false) goto L5;
        return;
    L5:
        if (this.done == true) goto L12;
        this.gate = true;
        this.downstream.onNext(r10);
        Disposable r11 = get();
        if (r11 == null) goto L10;
        r11.dispose();
    L10:
        throw null;
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
        this.gate = false;
    }
}
