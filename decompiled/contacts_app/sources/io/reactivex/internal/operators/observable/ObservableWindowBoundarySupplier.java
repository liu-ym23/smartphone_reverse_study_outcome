package io.reactivex.internal.operators.observable;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int capacityHint;
    final Callable<? extends ObservableSource<B>> other;

    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        boolean done;
        final WindowBoundaryMainObserver<T, B> parent;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> r1) {
            this.parent = r1;
        }

        @Override // io.reactivex.Observer
        public void onNext(B r1) {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            dispose();
            this.parent.innerNext(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.parent.innerError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.parent.innerComplete();
        }
    }

    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        static final WindowBoundaryInnerObserver<Object, Object> BOUNDARY_DISPOSED = null;
        static final Object NEXT_WINDOW = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final AtomicReference<WindowBoundaryInnerObserver<T, B>> boundaryObserver;
        final int capacityHint;
        volatile boolean done;
        final Observer<? super Observable<T>> downstream;
        final AtomicThrowable errors;
        final Callable<? extends ObservableSource<B>> other;
        final MpscLinkedQueue<Object> queue;
        final AtomicBoolean stopWindows;
        Disposable upstream;
        UnicastSubject<T> window;
        final AtomicInteger windows;

        static {
            BOUNDARY_DISPOSED = new WindowBoundaryInnerObserver(null);
            NEXT_WINDOW = new Object();
        }

        WindowBoundaryMainObserver(Observer<? super Observable<T>> r1, int r2, Callable<? extends ObservableSource<B>> r3) {
            this.downstream = r1;
            this.capacityHint = r2;
            this.boundaryObserver = new AtomicReference();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
            this.other = r3;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            this.queue.offer(NEXT_WINDOW);
            drain();
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            disposeBoundary();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
            disposeBoundary();
            if (this.windows.decrementAndGet() != 0) goto L9;
            this.upstream.dispose();
            return;
        L9:
            return;
        }

        void disposeBoundary() {
            AtomicReference<WindowBoundaryInnerObserver<T, B>> r1 = this.boundaryObserver;
            WindowBoundaryInnerObserver<Object, Object> r0 = BOUNDARY_DISPOSED;
            WindowBoundaryInnerObserver<T, B> r2 = r1.getAndSet((WindowBoundaryInnerObserver<T, B>) r0);
            if (r2 == null) goto L7;
            if (r2 == r0) goto L8;
            r2.dispose();
            return;
        L8:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() != 0) goto L6;
            this.upstream.dispose();
            return;
        }

        void innerNext(WindowBoundaryInnerObserver<T, B> r3) {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.boundaryObserver, r3, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        void innerError(Throwable r2) {
            this.upstream.dispose();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        void innerComplete() {
            this.upstream.dispose();
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super Observable<T>> r0 = this.downstream;
            MpscLinkedQueue<Object> r1 = this.queue;
            AtomicThrowable r2 = this.errors;
            int r4 = 1;
        L7:
            if (this.windows.get() == 0) goto L8;
            UnicastSubject<T> r5 = this.window;
            boolean r7 = this.done;
            if (r7 == true) goto L13;
        L19:
            Object r8 = r1.poll();
            if (r8 != null) goto L22;
            boolean r9 = true;
        L23:
            if (r7 == false) goto L34;
            if (r9 == false) goto L34;
            Throwable r3 = r2.terminate();
            if (r3 != null) goto L30;
            if (r5 == null) goto L29;
            this.window = null;
            r5.onComplete();
        L29:
            r0.onComplete();
            return;
        L30:
            if (r5 == null) goto L32;
            this.window = null;
            r5.onError(r3);
        L32:
            r0.onError(r3);
            return;
        L34:
            if (r9 == true) goto L35;
            if (r8 != NEXT_WINDOW) goto L40;
            if (r5 == null) goto L44;
            this.window = null;
            r5.onComplete();
        L44:
            if (this.stopWindows.get() == true) goto L7;
            UnicastSubject<T> r6 = UnicastSubject.create(this.capacityHint, this);
            this.window = r6;
            this.windows.getAndIncrement();
            ObservableSource r10 = (ObservableSource) ObjectHelper.requireNonNull(this.other.call(), "The other Callable returned a null ObservableSource");     // Catch: Throwable -> L50
            WindowBoundaryInnerObserver r11 = new WindowBoundaryInnerObserver(this);
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.boundaryObserver, null, r11) == false) goto L7;
            r10.subscribe(r11);
            r0.onNext(r6);
        L50:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2.addThrowable(th);
            this.done = true;
            goto L7
        L40:
            r5.onNext((T) r8);
            goto L7
        L35:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L22:
            r9 = false;
            goto L23
        L13:
            if (r2.get() == null) goto L19;
            r1.clear();
            Throwable r12 = r2.terminate();
            if (r5 == null) goto L17;
            this.window = null;
            r5.onError(r12);
        L17:
            r0.onError(r12);
            return;
        L8:
            r1.clear();
            this.window = null;
        }
    }

    public ObservableWindowBoundarySupplier(ObservableSource<T> r1, Callable<? extends ObservableSource<B>> r2, int r3) {
        super(r1);
        this.other = r2;
        this.capacityHint = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> r4) {
        WindowBoundaryMainObserver r0 = new WindowBoundaryMainObserver(r4, this.capacityHint, this.other);
        this.source.subscribe(r0);
    }
}
