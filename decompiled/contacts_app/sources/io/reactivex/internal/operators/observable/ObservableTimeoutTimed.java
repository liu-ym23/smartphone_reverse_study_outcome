package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> other;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    static final class FallbackObserver<T> implements Observer<T> {
        final AtomicReference<Disposable> arbiter;
        final Observer<? super T> downstream;

        FallbackObserver(Observer<? super T> r1, AtomicReference<Disposable> r2) {
            this.downstream = r1;
            this.arbiter = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.replace(this.arbiter, r1);
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
            this.downstream.onComplete();
        }
    }

    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Observer<? super T> downstream;
        ObservableSource<? extends T> fallback;
        final AtomicLong index;
        final SequentialDisposable task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<Disposable> upstream;
        final Scheduler.Worker worker;

        TimeoutFallbackObserver(Observer<? super T> r1, long r2, TimeUnit r4, Scheduler.Worker r5, ObservableSource<? extends T> r6) {
            this.downstream = r1;
            this.timeout = r2;
            this.unit = r4;
            this.worker = r5;
            this.fallback = r6;
            this.task = new SequentialDisposable();
            this.index = new AtomicLong();
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r6) {
            long r0 = this.index.get();
            if (r0 == Long.MAX_VALUE) goto L9;
            long r3 = 1 + r0;
            if (this.index.compareAndSet(r0, r3) == false) goto L10;
            this.task.get().dispose();
            this.downstream.onNext(r6);
            startTimeout(r3);
            return;
        L10:
            return;
        }

        void startTimeout(long r4) {
            this.task.replace(this.worker.schedule(new TimeoutTask(r4, this), this.timeout, this.unit));
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r6) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r6);
            this.worker.dispose();
            return;
        L5:
            RxJavaPlugins.onError(r6);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void onTimeout(long r4) {
            if (this.index.compareAndSet(r4, Long.MAX_VALUE) == false) goto L6;
            DisposableHelper.dispose(this.upstream);
            ObservableSource<? extends T> r5 = this.fallback;
            this.fallback = null;
            r5.subscribe(new FallbackObserver(this.downstream, this));
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Observer<? super T> downstream;
        final SequentialDisposable task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<Disposable> upstream;
        final Scheduler.Worker worker;

        TimeoutObserver(Observer<? super T> r1, long r2, TimeUnit r4, Scheduler.Worker r5) {
            this.downstream = r1;
            this.timeout = r2;
            this.unit = r4;
            this.worker = r5;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r5) {
            long r0 = get();
            if (r0 == Long.MAX_VALUE) goto L9;
            long r2 = 1 + r0;
            if (compareAndSet(r0, r2) == false) goto L10;
            this.task.get().dispose();
            this.downstream.onNext(r5);
            startTimeout(r2);
            return;
        L10:
            return;
        }

        void startTimeout(long r4) {
            this.task.replace(this.worker.schedule(new TimeoutTask(r4, this), this.timeout, this.unit));
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r5) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r5);
            this.worker.dispose();
            return;
        L5:
            RxJavaPlugins.onError(r5);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void onTimeout(long r4) {
            if (compareAndSet(r4, Long.MAX_VALUE) == false) goto L6;
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.timeout, this.unit)));
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }
    }

    interface TimeoutSupport {
        void onTimeout(long r1);
    }

    static final class TimeoutTask implements Runnable {
        final long idx;
        final TimeoutSupport parent;

        TimeoutTask(long r1, TimeoutSupport r3) {
            this.idx = r1;
            this.parent = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.onTimeout(this.idx);
        }
    }

    public ObservableTimeoutTimed(Observable<T> r1, long r2, TimeUnit r4, Scheduler r5, ObservableSource<? extends T> r6) {
        super(r1);
        this.timeout = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.other = r6;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r11) {
        if (this.other != null) goto L5;
        TimeoutObserver r0 = new TimeoutObserver(r11, this.timeout, this.unit, this.scheduler.createWorker());
        r11.onSubscribe(r0);
        r0.startTimeout(0);
        this.source.subscribe(r0);
        return;
    L5:
        TimeoutFallbackObserver r1 = new TimeoutFallbackObserver(r11, this.timeout, this.unit, this.scheduler.createWorker(), this.other);
        r11.onSubscribe(r1);
        r1.startTimeout(0);
        this.source.subscribe(r1);
    }
}
