package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once;
        final DebounceTimedObserver<T> parent;
        final T value;

        DebounceEmitter(T r2, long r3, DebounceTimedObserver<T> r5) {
            this.once = new AtomicBoolean();
            this.value = r2;
            this.idx = r3;
            this.parent = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            this.parent.emit(this.idx, this.value, this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        public void setResource(Disposable r1) {
            DisposableHelper.replace(this, r1);
        }
    }

    static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {
        boolean done;
        final Observer<? super T> downstream;
        volatile long index;
        final long timeout;
        Disposable timer;
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
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.index + 1;
            this.index = r0;
            Disposable r2 = this.timer;
            if (r2 == null) goto L8;
            r2.dispose();
        L8:
            DebounceEmitter r3 = new DebounceEmitter(r5, r0, this);
            this.timer = r3;
            r3.setResource(this.worker.schedule(r3, this.timeout, this.unit));
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            Disposable r0 = this.timer;
            if (r0 == null) goto L9;
            r0.dispose();
        L9:
            this.done = true;
            this.downstream.onError(r2);
            this.worker.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            Disposable r0 = this.timer;
            if (r0 == null) goto L8;
            r0.dispose();
        L8:
            DebounceEmitter r1 = (DebounceEmitter) r0;
            if (r1 == null) goto L11;
            r1.run();
        L11:
            this.downstream.onComplete();
            this.worker.dispose();
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

        void emit(long r3, T r5, DebounceEmitter<T> r6) {
            if (r3 != this.index) goto L6;
            this.downstream.onNext(r5);
            r6.dispose();
            return;
        }
    }

    public ObservableDebounceTimed(ObservableSource<T> r1, long r2, TimeUnit r4, Scheduler r5) {
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
