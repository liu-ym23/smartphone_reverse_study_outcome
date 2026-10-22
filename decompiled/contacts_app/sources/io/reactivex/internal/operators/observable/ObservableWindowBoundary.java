package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int capacityHint;
    final ObservableSource<B> other;

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
            this.parent.innerNext();
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
        static final Object NEXT_WINDOW = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final WindowBoundaryInnerObserver<T, B> boundaryObserver;
        final int capacityHint;
        volatile boolean done;
        final Observer<? super Observable<T>> downstream;
        final AtomicThrowable errors;
        final MpscLinkedQueue<Object> queue;
        final AtomicBoolean stopWindows;
        final AtomicReference<Disposable> upstream;
        UnicastSubject<T> window;
        final AtomicInteger windows;

        static {
            NEXT_WINDOW = new Object();
        }

        WindowBoundaryMainObserver(Observer<? super Observable<T>> r1, int r2) {
            this.downstream = r1;
            this.capacityHint = r2;
            this.boundaryObserver = new WindowBoundaryInnerObserver(this);
            this.upstream = new AtomicReference();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.setOnce(this.upstream, r2) == false) goto L6;
            innerNext();
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.boundaryObserver.dispose();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
            this.boundaryObserver.dispose();
            if (this.windows.decrementAndGet() != 0) goto L9;
            DisposableHelper.dispose(this.upstream);
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() != 0) goto L6;
            DisposableHelper.dispose(this.upstream);
            return;
        }

        void innerNext() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        void innerError(Throwable r2) {
            DisposableHelper.dispose(this.upstream);
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        void innerComplete() {
            DisposableHelper.dispose(this.upstream);
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
            r0.onNext(r6);
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
            Throwable r10 = r2.terminate();
            if (r5 == null) goto L17;
            this.window = null;
            r5.onError(r10);
        L17:
            r0.onError(r10);
            return;
        L8:
            r1.clear();
            this.window = null;
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> r1, ObservableSource<B> r2, int r3) {
        super(r1);
        this.other = r2;
        this.capacityHint = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> r3) {
        WindowBoundaryMainObserver r0 = new WindowBoundaryMainObserver(r3, this.capacityHint);
        r3.onSubscribe(r0);
        this.other.subscribe(r0.boundaryObserver);
        this.source.subscribe(r0);
    }
}
