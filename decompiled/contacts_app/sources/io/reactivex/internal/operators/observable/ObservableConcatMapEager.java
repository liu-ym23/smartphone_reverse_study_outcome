package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        volatile boolean cancelled;
        InnerQueuedObserver<R> current;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable error;
        final ErrorMode errorMode;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final int maxConcurrency;
        final ArrayDeque<InnerQueuedObserver<R>> observers;
        final int prefetch;
        SimpleQueue<T> queue;
        int sourceMode;
        Disposable upstream;

        ConcatMapEagerMainObserver(Observer<? super R> r1, Function<? super T, ? extends ObservableSource<? extends R>> r2, int r3, int r4, ErrorMode r5) {
            this.downstream = r1;
            this.mapper = r2;
            this.maxConcurrency = r3;
            this.prefetch = r4;
            this.errorMode = r5;
            this.error = new AtomicThrowable();
            this.observers = new ArrayDeque();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.validate(this.upstream, r3) == false) goto L16;
            this.upstream = r3;
            if ((r3 instanceof QueueDisposable) == false) goto L14;
            QueueDisposable r4 = (QueueDisposable) r3;
            int r0 = r4.requestFusion(3);
            if (r0 != 1) goto L11;
            this.sourceMode = r0;
            this.queue = r4;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.sourceMode = r0;
            this.queue = r4;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new SpscLinkedArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.sourceMode != 0) goto L5;
            this.queue.offer(r2);
        L5:
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            this.upstream.dispose();
            drainAndDispose();
        }

        void drainAndDispose() {
            if (getAndIncrement() != 0) goto L6;
        L4:
            this.queue.clear();
            disposeAll();
            if (decrementAndGet() != 0) goto L4;
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void disposeAll() {
            InnerQueuedObserver<R> r0 = this.current;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            InnerQueuedObserver<R> r1 = this.observers.poll();
            if (r1 == null) goto L7;
            r1.dispose();
            goto L5
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerNext(InnerQueuedObserver<R> r1, R r2) {
            r1.queue().offer(r2);
            drain();
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerError(InnerQueuedObserver<R> r2, Throwable r3) {
            if (this.error.addThrowable(r3) == true) goto L5;
            RxJavaPlugins.onError(r3);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
            this.upstream.dispose();
        L7:
            r2.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerComplete(InnerQueuedObserver<R> r1) {
            r1.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            SimpleQueue<T> r0 = this.queue;
            ArrayDeque<InnerQueuedObserver<R>> r1 = this.observers;
            Observer<? super R> r2 = this.downstream;
            ErrorMode r3 = this.errorMode;
            int r5 = 1;
        L6:
            int r6 = this.activeCount;
        L8:
            if (r6 == this.maxConcurrency) goto L27;
            if (this.cancelled == true) goto L11;
            if (r3 == ErrorMode.IMMEDIATE) goto L16;
        L87:
            T r7 = r0.poll();     // Catch: Throwable -> L24
            if (r7 == null) goto L27;
            ObservableSource r8 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r7), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L24
            InnerQueuedObserver<R> r9 = new InnerQueuedObserver(this, this.prefetch);
            r1.offer(r9);
            r8.subscribe(r9);
            r6 = r6 + 1;
        L24:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            r0.clear();
            disposeAll();
            this.error.addThrowable(th);
            r2.onError(this.error.terminate());
            return;
        L16:
            if (this.error.get() == null) goto L87;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L11:
            r0.clear();
            disposeAll();
            return;
        L27:
            this.activeCount = r6;
            if (this.cancelled == true) goto L29;
            if (r3 == ErrorMode.IMMEDIATE) goto L34;
        L37:
            InnerQueuedObserver<R> r10 = this.current;
            if (r10 == null) goto L40;
        L59:
            if (r10 == null) goto L84;
            SimpleQueue<R> r11 = r10.queue();
        L62:
            if (this.cancelled == true) goto L63;
            boolean r12 = r10.isDone();
            if (r3 != ErrorMode.IMMEDIATE) goto L89;
            if (this.error.get() == null) goto L89;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L89:
            R r13 = r11.poll();     // Catch: Throwable -> L82
            if (r13 != null) goto L75;
            boolean r14 = true;
        L76:
            if (r12 == false) goto L79;
            if (r14 == false) goto L79;
            this.current = null;
            this.activeCount--;
        L79:
            if (r14 == true) goto L84;
            r2.onNext(r13);
            goto L62
        L75:
            r14 = false;
        L82:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.error.addThrowable(th);
            this.current = null;
            this.activeCount--;
            goto L6
        L63:
            r0.clear();
            disposeAll();
            return;
        L84:
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L6;
            return;
        L40:
            if (r3 == ErrorMode.BOUNDARY) goto L42;
        L45:
            boolean r15 = this.done;
            InnerQueuedObserver<R> r16 = r1.poll();
            if (r16 != null) goto L48;
            boolean r17 = true;
        L49:
            if (r15 == false) goto L56;
            if (r17 == false) goto L56;
            if (this.error.get() == null) goto L54;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L54:
            r2.onComplete();
            return;
        L56:
            if (r17 == true) goto L58;
            this.current = r16;
        L58:
            r10 = r16;
            goto L59
        L48:
            r17 = false;
            goto L49
        L42:
            if (this.error.get() == null) goto L45;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L34:
            if (this.error.get() == null) goto L37;
            r0.clear();
            disposeAll();
            r2.onError(this.error.terminate());
            return;
        L29:
            r0.clear();
            disposeAll();
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> r1, Function<? super T, ? extends ObservableSource<? extends R>> r2, ErrorMode r3, int r4, int r5) {
        super(r1);
        this.mapper = r2;
        this.errorMode = r3;
        this.maxConcurrency = r4;
        this.prefetch = r5;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r9) {
        this.source.subscribe(new ConcatMapEagerMainObserver(r9, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
