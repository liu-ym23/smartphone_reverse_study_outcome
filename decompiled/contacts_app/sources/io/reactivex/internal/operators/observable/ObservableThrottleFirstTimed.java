package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        boolean done;
        final Observer<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        Disposable upstream;
        final Scheduler.Worker worker;

        DebounceTimedObserver(Observer<? super T> r1, long r2, TimeUnit r4, Scheduler.Worker r5) {
            this.downstream = r1;
            this.timeout = r2;
            this.unit = r4;
            this.worker = r5;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r4) {
            if (this.gate == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L12;
            this.gate = true;
            this.downstream.onNext(r4);
            Disposable r5 = get();
            if (r5 == null) goto L9;
            r5.dispose();
        L9:
            DisposableHelper.replace(this, this.worker.schedule(this, this.timeout, this.unit));
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            this.done = true;
            this.downstream.onError(r2);
            this.worker.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> r1, long r2, TimeUnit r4, Scheduler r5) {
        super(r1);
        this.timeout = r2;
        this.unit = r4;
        this.scheduler = r5;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r9) {
        this.source.subscribe(new DebounceTimedObserver(new SerializedObserver(r9), this.timeout, this.unit, this.scheduler.createWorker()));
    }
}
