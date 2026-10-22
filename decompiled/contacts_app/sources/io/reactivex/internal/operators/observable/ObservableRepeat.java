package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {
    final long count;

    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Observer<? super T> downstream;
        long remaining;
        final SequentialDisposable sd;
        final ObservableSource<? extends T> source;

        RepeatObserver(Observer<? super T> r1, long r2, SequentialDisposable r4, ObservableSource<? extends T> r5) {
            this.downstream = r1;
            this.sd = r4;
            this.source = r5;
            this.remaining = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.sd.replace(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            long r0 = this.remaining;
            if (r0 == Long.MAX_VALUE) goto L6;
            this.remaining = r0 - 1;
        L6:
            if (r0 == 0) goto L8;
            subscribeNext();
            return;
        L8:
            this.downstream.onComplete();
        }

        void subscribeNext() {
            if (getAndIncrement() != 0) goto L10;
            int r0 = 1;
        L6:
            if (this.sd.isDisposed() == true) goto L7;
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L7:
            return;
        }
    }

    public ObservableRepeat(Observable<T> r1, long r2) {
        super(r1);
        this.count = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r8) {
        SequentialDisposable r4 = new SequentialDisposable();
        r8.onSubscribe(r4);
        long r0 = this.count;
        long r2 = Long.MAX_VALUE;
        if (r0 == Long.MAX_VALUE) goto L5;
        r2 = r0 - 1;
    L5:
        new RepeatObserver(r8, r2, r4, this.source).subscribeNext();
    }
}
