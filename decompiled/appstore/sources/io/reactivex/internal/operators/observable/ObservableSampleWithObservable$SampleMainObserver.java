package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
abstract class ObservableSampleWithObservable$SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -3517602651313910099L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> other;
    final ObservableSource<?> sampler;
    Disposable upstream;

    public ObservableSampleWithObservable$SampleMainObserver(Observer<? super T> r10, ObservableSource<?> r11) {
        this.other = new AtomicReference();
        this.downstream = r10;
        this.sampler = r11;
    }

    public void complete() {
        this.upstream.dispose();
        completion();
    }

    public abstract void completion();

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.other);
        this.upstream.dispose();
    }

    public void emit() {
        T r10 = getAndSet(null);
        if (r10 == null) goto L6;
        this.downstream.onNext(r10);
        return;
    }

    public void error(Throwable r10) {
        this.upstream.dispose();
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.other.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        completion();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        lazySet(r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L8;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        if (this.other.get() != null) goto L9;
        this.sampler.subscribe(new f(this));
        return;
    L9:
        return;
    }

    public abstract void run();

    public boolean setOther(Disposable r10) {
        return DisposableHelper.setOnce(this.other, r10);
    }
}
