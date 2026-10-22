package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
    final ObservableSource<? extends Open> bufferOpen;
    final Callable<U> bufferSupplier;

    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8466418554264089604L;
        final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
        final ObservableSource<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        Map<Long, C> buffers;
        volatile boolean cancelled;
        volatile boolean done;
        final Observer<? super C> downstream;
        final AtomicThrowable errors;
        long index;
        final CompositeDisposable observers;
        final SpscLinkedArrayQueue<C> queue;
        final AtomicReference<Disposable> upstream;

        static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundaryObserver<?, ?, Open, ?> parent;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.Observer
            public void onNext(Open r1) {
                this.parent.open(r1);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r2) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.boundaryError(this, r2);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.openComplete(this);
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
        }

        BufferBoundaryObserver(Observer<? super C> r1, ObservableSource<? extends Open> r2, Function<? super Open, ? extends ObservableSource<? extends Close>> r3, Callable<C> r4) {
            this.downstream = r1;
            this.bufferSupplier = r4;
            this.bufferOpen = r2;
            this.bufferClose = r3;
            this.queue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.observers = new CompositeDisposable();
            this.upstream = new AtomicReference();
            this.buffers = new LinkedHashMap();
            this.errors = new AtomicThrowable();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.setOnce(this.upstream, r2) == false) goto L6;
            BufferOpenObserver r3 = new BufferOpenObserver(this);
            this.observers.add(r3);
            this.bufferOpen.subscribe(r3);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            monitor-enter(this);
            Map<Long, C> r0 = this.buffers;     // Catch: Throwable -> L13
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            Iterator<C> r1 = r0.values().iterator();     // Catch: Throwable -> L13
        L9:
            if (r1.hasNext() == false) goto L11;
            r1.next().add(r3);     // Catch: Throwable -> L13
            goto L9
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L13;
            this.observers.dispose();
            monitor-enter(this);
            this.buffers = null;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            this.done = true;
            drain();
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.observers.dispose();
            monitor-enter(this);
            Map<Long, C> r0 = this.buffers;     // Catch: Throwable -> L16
            if (r0 != null) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L16
            return;
        L8:
            Iterator<C> r1 = r0.values().iterator();     // Catch: Throwable -> L16
        L10:
            if (r1.hasNext() == false) goto L12;
            C r2 = r1.next();     // Catch: Throwable -> L16
            this.queue.offer(r2);     // Catch: Throwable -> L16
            goto L10
        L12:
            this.buffers = null;     // Catch: Throwable -> L16
            monitor-exit(this);     // Catch: Throwable -> L16
            this.done = true;
            drain();
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (DisposableHelper.dispose(this.upstream) == false) goto L15;
            this.cancelled = true;
            this.observers.dispose();
            monitor-enter(this);
            this.buffers = null;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            if (getAndIncrement() == 0) goto L18;
            this.queue.clear();
            return;
        L18:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        void open(Open r6) {
            Collection r0 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");     // Catch: Throwable -> L16
            ObservableSource r7 = (ObservableSource) ObjectHelper.requireNonNull(this.bufferClose.apply(r6), "The bufferClose returned a null ObservableSource");     // Catch: Throwable -> L16
            long r1 = this.index;
            this.index = 1 + r1;
            monitor-enter(this);
            Map<Long, C> r3 = this.buffers;     // Catch: Throwable -> L13
            if (r3 != null) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L9:
            r3.put(Long.valueOf(r1), (C) r0);     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            BufferCloseObserver r2 = new BufferCloseObserver(this, r1);
            this.observers.add(r2);
            r7.subscribe(r2);
            return;
        L13:
            th = move-exception;
            throw th;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            DisposableHelper.dispose(this.upstream);
            onError(th);
        }

        void openComplete(BufferOpenObserver<Open> r2) {
            this.observers.delete(r2);
            if (this.observers.size() != 0) goto L6;
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            drain();
            return;
        }

        void close(BufferCloseObserver<T, C> r4, long r5) {
            this.observers.delete(r4);
            if (this.observers.size() != 0) goto L5;
            DisposableHelper.dispose(this.upstream);
            boolean r6 = true;
        L6:
            monitor-enter(this);
            Map<Long, C> r1 = this.buffers;     // Catch: Throwable -> L17
            if (r1 != null) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L17
            return;
        L11:
            this.queue.offer(r1.remove(Long.valueOf(r5)));     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
            if (r6 == false) goto L15;
            this.done = true;
        L15:
            drain();
            return;
        L17:
            th = move-exception;
            throw th;
        L5:
            r6 = false;
            goto L6
        }

        void boundaryError(Disposable r2, Throwable r3) {
            DisposableHelper.dispose(this.upstream);
            this.observers.delete(r2);
            onError(r3);
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super C> r0 = this.downstream;
            SpscLinkedArrayQueue<C> r1 = this.queue;
            int r3 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r4 = this.done;
            if (r4 == true) goto L13;
        L16:
            C r5 = r1.poll();
            if (r5 != null) goto L19;
            boolean r6 = true;
        L20:
            if (r4 == false) goto L24;
            if (r6 == false) goto L24;
            r0.onComplete();
            return;
        L24:
            if (r6 == true) goto L25;
            r0.onNext(r5);
            goto L7
        L25:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L7;
            return;
        L19:
            r6 = false;
            goto L20
        L13:
            if (this.errors.get() == null) goto L16;
            r1.clear();
            r0.onError(this.errors.terminate());
            return;
        L8:
            r1.clear();
        }
    }

    static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundaryObserver<T, C, ?, ?> parent;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> r1, long r2) {
            this.parent = r1;
            this.index = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r3) {
            Disposable r4 = get();
            if (r4 == DisposableHelper.DISPOSED) goto L6;
            lazySet(DisposableHelper.DISPOSED);
            r4.dispose();
            this.parent.close(this, this.index);
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            if (get() == DisposableHelper.DISPOSED) goto L5;
            lazySet(DisposableHelper.DISPOSED);
            this.parent.boundaryError(this, r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (get() == DisposableHelper.DISPOSED) goto L6;
            lazySet(DisposableHelper.DISPOSED);
            this.parent.close(this, this.index);
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
    }

    public ObservableBufferBoundary(ObservableSource<T> r1, ObservableSource<? extends Open> r2, Function<? super Open, ? extends ObservableSource<? extends Close>> r3, Callable<U> r4) {
        super(r1);
        this.bufferOpen = r2;
        this.bufferClose = r3;
        this.bufferSupplier = r4;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> r5) {
        BufferBoundaryObserver r0 = new BufferBoundaryObserver(r5, this.bufferOpen, this.bufferClose, this.bufferSupplier);
        r5.onSubscribe(r0);
        this.source.subscribe(r0);
    }
}
