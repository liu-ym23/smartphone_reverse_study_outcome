package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableRetryBiPredicate$RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Observer<? super T> downstream;
    final BiPredicate<? super Integer, ? super Throwable> predicate;
    int retries;
    final ObservableSource<? extends T> source;
    final SequentialDisposable upstream;

    public ObservableRetryBiPredicate$RetryBiObserver(Observer<? super T> r10, BiPredicate<? super Integer, ? super Throwable> r11, SequentialDisposable r12, ObservableSource<? extends T> r13) {
        this.downstream = r10;
        this.upstream = r12;
        this.source = r13;
        this.predicate = r11;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        BiPredicate<? super Integer, ? super Throwable> r11 = this.predicate;     // Catch: Throwable -> L8
        int r12 = this.retries + 1;     // Catch: Throwable -> L8
        this.retries = r12;     // Catch: Throwable -> L8
        if (r11.test(Integer.valueOf(r12), r10) == true) goto L6;
        this.downstream.onError(r10);
        return;
    L6:
        subscribeNext();
        return;
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
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
        if (getAndIncrement() != 0) goto L10;
        int r10 = 1;
    L6:
        if (this.upstream.isDisposed() == true) goto L7;
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
