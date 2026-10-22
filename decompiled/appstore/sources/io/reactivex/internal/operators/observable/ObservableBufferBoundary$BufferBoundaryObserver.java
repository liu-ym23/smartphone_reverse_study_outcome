package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableBufferBoundary$BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
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
    final io.reactivex.disposables.a observers;
    final io.reactivex.internal.queue.a queue;
    final AtomicReference<Disposable> upstream;

    public static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> parent;

        public BufferOpenObserver(ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> r10) {
            this.parent = r10;
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

        @Override // io.reactivex.Observer
        public void onComplete() {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.openComplete(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r10) {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.boundaryError(this, r10);
        }

        @Override // io.reactivex.Observer
        public void onNext(Open r10) {
            this.parent.open(r10);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    public ObservableBufferBoundary$BufferBoundaryObserver(Observer<? super C> r10, ObservableSource<? extends Open> r11, Function<? super Open, ? extends ObservableSource<? extends Close>> r12, Callable<C> r13) {
        this.downstream = r10;
        this.bufferSupplier = r13;
        this.bufferOpen = r11;
        this.bufferClose = r12;
        this.queue = new io.reactivex.internal.queue.a(mf.e.a());
        this.observers = new io.reactivex.disposables.a();
        this.upstream = new AtomicReference();
        this.buffers = new LinkedHashMap();
        this.errors = new AtomicThrowable();
    }

    public void boundaryError(Disposable r10, Throwable r11) {
        DisposableHelper.dispose(this.upstream);
        this.observers.delete(r10);
        onError(r11);
    }

    public void close(ObservableBufferBoundary$BufferCloseObserver<T, C> r10, long r11) {
        this.observers.delete(r10);
        if (this.observers.b() != 0) goto L5;
        DisposableHelper.dispose(this.upstream);
        boolean r12 = true;
    L6:
        monitor-enter(this);
        Map<Long, C> r13 = this.buffers;     // Catch: Throwable -> L11
        if (r13 != null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        this.queue.offer(r13.remove(Long.valueOf(r11)));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r12 == false) goto L17;
        this.done = true;
    L17:
        drain();
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r12 = false;
        goto L6
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

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Observer<? super C> r10 = this.downstream;
        io.reactivex.internal.queue.a r11 = this.queue;
        int r12 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r13 = this.done;
        if (r13 == true) goto L13;
    L16:
        Collection r14 = (Collection) r11.poll();
        if (r14 != null) goto L19;
        boolean r15 = true;
    L20:
        if (r13 == false) goto L24;
        if (r15 == false) goto L24;
        r10.onComplete();
        return;
    L24:
        if (r15 == true) goto L25;
        r10.onNext(r14);
        goto L7
    L25:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L19:
        r15 = false;
        goto L20
    L13:
        if (this.errors.get() == null) goto L16;
        r11.clear();
        r10.onError(this.errors.terminate());
        return;
    L8:
        r11.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.observers.dispose();
        monitor-enter(this);
        Map<Long, C> r10 = this.buffers;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator<C> r11 = r10.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r11.hasNext() == false) goto L14;
        C r12 = r11.next();     // Catch: Throwable -> L8
        this.queue.offer(r12);     // Catch: Throwable -> L8
        goto L12
    L14:
        this.buffers = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.done = true;
        drain();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L13;
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
        qf.a.e(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        monitor-enter(this);
        Map<Long, C> r11 = this.buffers;     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        Iterator<C> r12 = r11.values().iterator();     // Catch: Throwable -> L7
    L11:
        if (r12.hasNext() == false) goto L13;
        r12.next().add(r10);     // Catch: Throwable -> L7
        goto L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this.upstream, r10) == false) goto L6;
        BufferOpenObserver r11 = new BufferOpenObserver(this);
        this.observers.add(r11);
        this.bufferOpen.subscribe(r11);
        return;
    }

    public void open(Open r10) {
        Collection r11 = (Collection) io.reactivex.internal.functions.a.b(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");     // Catch: Throwable -> L17
        ObservableSource r12 = (ObservableSource) io.reactivex.internal.functions.a.b(this.bufferClose.apply(r10), "The bufferClose returned a null ObservableSource");     // Catch: Throwable -> L17
        long r13 = this.index;
        this.index = 1 + r13;
        monitor-enter(this);
        Map<Long, C> r14 = this.buffers;     // Catch: Throwable -> L9
        if (r14 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        r14.put(Long.valueOf(r13), (C) r11);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        ObservableBufferBoundary$BufferCloseObserver r15 = new ObservableBufferBoundary$BufferCloseObserver(this, r13);
        this.observers.add(r15);
        r12.subscribe(r15);
        return;
    L9:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        DisposableHelper.dispose(this.upstream);
        onError(th);
    }

    public void openComplete(BufferOpenObserver<Open> r10) {
        this.observers.delete(r10);
        if (this.observers.b() != 0) goto L6;
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        drain();
        return;
    }
}
