package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableThrottleLatest<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean emitLast;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final Observer<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest;
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        Disposable upstream;
        final Scheduler.Worker worker;

        ThrottleLatestObserver(Observer<? super T> r1, long r2, TimeUnit r4, Scheduler.Worker r5, boolean r6) {
            this.downstream = r1;
            this.timeout = r2;
            this.unit = r4;
            this.worker = r5;
            this.emitLast = r6;
            this.latest = new AtomicReference();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            this.latest.set(r2);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.latest.lazySet(null);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicReference<T> r0 = this.latest;
            Observer<? super T> r1 = this.downstream;
            int r3 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r4 = this.done;
            if (r4 == false) goto L17;
            if (this.error == null) goto L17;
            r0.lazySet(null);
            r1.onError(this.error);
            this.worker.dispose();
            return;
        L17:
            if (r0.get() != null) goto L19;
            boolean r6 = true;
        L20:
            if (r4 == true) goto L21;
            if (r6 == true) goto L30;
            if (this.timerRunning == false) goto L40;
            if (this.timerFired == true) goto L40;
        L37:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L7;
            return;
        L40:
            r1.onNext(r0.getAndSet(null));
            this.timerFired = false;
            this.timerRunning = true;
            this.worker.schedule(this, this.timeout, this.unit);
            goto L7
        L30:
            if (this.timerFired == false) goto L37;
            this.timerRunning = false;
            this.timerFired = false;
            goto L37
        L21:
            T r2 = r0.getAndSet(null);
            if (r6 == false) goto L24;
        L26:
            r1.onComplete();
            this.worker.dispose();
            return;
        L24:
            if (this.emitLast == false) goto L26;
            r1.onNext(r2);
            goto L26
        L19:
            r6 = false;
            goto L20
        L8:
            r0.lazySet(null);
        }
    }

    public ObservableThrottleLatest(Observable<T> r1, long r2, TimeUnit r4, Scheduler r5, boolean r6) {
        super(r1);
        this.timeout = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.emitLast = r6;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r10) {
        this.source.subscribe(new ThrottleLatestObserver(r10, this.timeout, this.unit, this.scheduler.createWorker(), this.emitLast));
    }
}
