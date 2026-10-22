package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableRepeat$RepeatObserver<T> extends AtomicInteger implements Observer<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Observer<? super T> downstream;
    long remaining;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    final SequentialDisposable f20666sd;
    final ObservableSource<? extends T> source;

    public ObservableRepeat$RepeatObserver(Observer<? super T> r10, long r11, SequentialDisposable r12, ObservableSource<? extends T> r13) {
        this.downstream = r10;
        this.f20666sd = r12;
        this.source = r13;
        this.remaining = r11;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        long r10 = this.remaining;
        if (r10 == Long.MAX_VALUE) goto L6;
        this.remaining = r10 - 1;
    L6:
        if (r10 == 0) goto L8;
        subscribeNext();
        return;
    L8:
        this.downstream.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        this.f20666sd.replace(r10);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L10;
        int r10 = 1;
    L6:
        if (this.f20666sd.isDisposed() == true) goto L7;
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
