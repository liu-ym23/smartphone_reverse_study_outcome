package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableRepeatUntil$RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Observer<? super T> downstream;
    final ObservableSource<? extends T> source;
    final BooleanSupplier stop;
    final SequentialDisposable upstream;

    public ObservableRepeatUntil$RepeatUntilObserver(Observer<? super T> r10, BooleanSupplier r11, SequentialDisposable r12, ObservableSource<? extends T> r13) {
        this.downstream = r10;
        this.upstream = r12;
        this.source = r13;
        this.stop = r11;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.stop.getAsBoolean() == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        subscribeNext();
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
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
        this.upstream.replace(r10);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L7;
        int r10 = 1;
    L5:
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L5;
        return;
    }
}
