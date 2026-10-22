package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    final long count;
    final Predicate<? super Throwable> predicate;

    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Observer<? super T> downstream;
        final Predicate<? super Throwable> predicate;
        long remaining;
        final ObservableSource<? extends T> source;
        final SequentialDisposable upstream;

        RepeatObserver(Observer<? super T> r1, long r2, Predicate<? super Throwable> r4, SequentialDisposable r5, ObservableSource<? extends T> r6) {
            this.downstream = r1;
            this.upstream = r5;
            this.source = r6;
            this.predicate = r4;
            this.remaining = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.upstream.replace(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r5) {
            long r0 = this.remaining;
            if (r0 == Long.MAX_VALUE) goto L6;
            this.remaining = r0 - 1;
        L6:
            if (r0 != 0) goto L17;
            this.downstream.onError(r5);
            return;
        L17:
            if (this.predicate.test(r5) == true) goto L12;
            this.downstream.onError(r5);
            return;
        L12:
            subscribeNext();
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        void subscribeNext() {
            if (getAndIncrement() != 0) goto L10;
            int r0 = 1;
        L6:
            if (this.upstream.isDisposed() == true) goto L7;
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L7:
            return;
        }
    }

    public ObservableRetryPredicate(Observable<T> r1, long r2, Predicate<? super Throwable> r4) {
        super(r1);
        this.predicate = r4;
        this.count = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r9) {
        SequentialDisposable r5 = new SequentialDisposable();
        r9.onSubscribe(r5);
        new RepeatObserver(r9, this.count, this.predicate, r5, this.source).subscribeNext();
    }
}
