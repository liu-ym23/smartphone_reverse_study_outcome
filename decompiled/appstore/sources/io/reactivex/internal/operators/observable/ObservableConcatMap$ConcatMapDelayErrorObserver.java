package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = -6951100001833242599L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable error;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final DelayErrorInnerObserver<R> observer;
    SimpleQueue<T> queue;
    int sourceMode;
    final boolean tillTheEnd;
    Disposable upstream;

    public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 2620149119579502636L;
        final Observer<? super R> downstream;
        final ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> parent;

        public DelayErrorInnerObserver(Observer<? super R> r10, ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> r11) {
            this.downstream = r10;
            this.parent = r11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> r10 = this.parent;
            r10.active = false;
            r10.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r10) {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> r11 = this.parent;
            if (r11.error.addThrowable(r10) == true) goto L5;
            qf.a.e(r10);
            return;
        L5:
            if (r11.tillTheEnd == true) goto L7;
            r11.upstream.dispose();
        L7:
            r11.active = false;
            r11.drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(R r10) {
            this.downstream.onNext(r10);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r10) {
            DisposableHelper.replace(this, r10);
        }
    }

    public ObservableConcatMap$ConcatMapDelayErrorObserver(Observer<? super R> r10, Function<? super T, ? extends ObservableSource<? extends R>> r11, int r12, boolean r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.bufferSize = r12;
        this.tillTheEnd = r13;
        this.error = new AtomicThrowable();
        this.observer = new DelayErrorInnerObserver(r10, this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.observer.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Observer<? super R> r10 = this.downstream;
        SimpleQueue<T> r11 = this.queue;
        AtomicThrowable r12 = this.error;
    L7:
        if (this.active == true) goto L49;
        if (this.cancelled == true) goto L10;
        if (this.tillTheEnd == false) goto L15;
    L18:
        boolean r13 = this.done;
        T r14 = r11.poll();     // Catch: Throwable -> L45
        if (r14 != null) goto L22;
        boolean r15 = true;
    L23:
        if (r13 == false) goto L30;
        if (r15 == false) goto L30;
        this.cancelled = true;
        Throwable r16 = r12.terminate();
        if (r16 == null) goto L28;
        r10.onError(r16);
        return;
    L28:
        r10.onComplete();
        return;
    L30:
        if (r15 == true) goto L49;
        ObservableSource r17 = (ObservableSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r14), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L42
        if ((r17 instanceof Callable) == false) goto L41;
        a2.a r18 = (Object) ((Callable) r17).call();
        if (r18 == null) goto L7;
        if (this.cancelled == true) goto L7;
        r10.onNext(r18);
    L39:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r12.addThrowable(th);
        goto L7
    L41:
        this.active = true;
        r17.subscribe(this.observer);
    L42:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.cancelled = true;
        this.upstream.dispose();
        r11.clear();
        r12.addThrowable(th);
        r10.onError(r12.terminate());
        return;
    L22:
        r15 = false;
    L45:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.cancelled = true;
        this.upstream.dispose();
        r12.addThrowable(th);
        r10.onError(r12.terminate());
        return;
    L15:
        if (r12.get() == null) goto L18;
        r11.clear();
        this.cancelled = true;
        r10.onError(r12.terminate());
        return;
    L10:
        r11.clear();
        return;
    L49:
        if (decrementAndGet() != 0) goto L7;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.error.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (this.sourceMode != 0) goto L5;
        this.queue.offer(r10);
    L5:
        drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof QueueDisposable) == false) goto L14;
        QueueDisposable r11 = (QueueDisposable) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.sourceMode = r12;
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = r12;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
        this.downstream.onSubscribe(this);
        return;
    }
}
