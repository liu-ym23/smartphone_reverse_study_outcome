package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final LatestCoordinator<T, R> parent;

        CombinerObserver(LatestCoordinator<T, R> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            this.parent.innerNext(this.index, r2);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.parent.innerError(this.index, r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable errors;
        Object[] latest;
        final CombinerObserver<T, R>[] observers;
        final SpscLinkedArrayQueue<Object[]> queue;

        LatestCoordinator(Observer<? super R> r2, Function<? super Object[], ? extends R> r3, int r4, int r5, boolean r6) {
            this.errors = new AtomicThrowable();
            this.downstream = r2;
            this.combiner = r3;
            this.delayError = r6;
            this.latest = new Object[r4];
            CombinerObserver<T, R>[] r7 = new CombinerObserver[r4];
            int r8 = 0;
        L3:
            if (r8 >= r4) goto L5;
            r7[r8] = new CombinerObserver(this, r8);
            r8 = r8 + 1;
            goto L3
        L5:
            this.observers = r7;
            this.queue = new SpscLinkedArrayQueue(r5);
        }

        public void subscribe(ObservableSource<? extends T>[] r6) {
            CombinerObserver<T, R>[] r0 = this.observers;
            int r1 = r0.length;
            this.downstream.onSubscribe(this);
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            if (this.done == true) goto L14;
            if (this.cancelled == true) goto L15;
            r6[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L3
        L15:
            return;
        L14:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() != 0) goto L9;
            clear(this.queue);
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancelSources() {
            CombinerObserver<T, R>[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }

        void clear(SpscLinkedArrayQueue<?> r2) {
            monitor-enter(this);
            this.latest = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            r2.clear();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            SpscLinkedArrayQueue<Object[]> r0 = this.queue;
            Observer<? super R> r1 = this.downstream;
            boolean r2 = this.delayError;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (r2 == false) goto L12;
        L15:
            boolean r5 = this.done;
            Object[] r6 = r0.poll();
            if (r6 != null) goto L18;
            boolean r7 = true;
        L19:
            if (r5 == false) goto L26;
            if (r7 == false) goto L26;
            clear(r0);
            Throwable r8 = this.errors.terminate();
            if (r8 != null) goto L24;
            r1.onComplete();
            return;
        L24:
            r1.onError(r8);
            return;
        L26:
            if (r7 == true) goto L27;
            r1.onNext((Object) ObjectHelper.requireNonNull(this.combiner.apply(r6), "The combiner returned a null value"));
        L32:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.errors.addThrowable(th);
            cancelSources();
            clear(r0);
            r1.onError(this.errors.terminate());
            return;
        L27:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L18:
            r7 = false;
            goto L19
        L12:
            if (this.errors.get() == null) goto L15;
            cancelSources();
            clear(r0);
            r1.onError(this.errors.terminate());
            return;
        L8:
            clear(r0);
        }

        void innerNext(int r4, T r5) {
            monitor-enter(this);
            Object[] r0 = this.latest;     // Catch: Throwable -> L18
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L18
            return;
        L7:
            Object r1 = r0[r4];     // Catch: Throwable -> L18
            int r2 = this.active;     // Catch: Throwable -> L18
            if (r1 != null) goto L10;
            r2 = r2 + 1;     // Catch: Throwable -> L18
            this.active = r2;     // Catch: Throwable -> L18
        L10:
            r0[r4] = r5;     // Catch: Throwable -> L18
            if (r2 != r0.length) goto L13;
            this.queue.offer((Object[]) r0.clone());     // Catch: Throwable -> L18
            boolean r6 = true;
        L14:
            monitor-exit(this);     // Catch: Throwable -> L18
            if (r6 == false) goto L22;
            drain();
            return;
        L22:
            return;
        L13:
            r6 = false;
        L18:
            th = move-exception;
            throw th;
        }

        void innerError(int r3, Throwable r4) {
            if (this.errors.addThrowable(r4) == false) goto L27;
            boolean r0 = true;
            if (this.delayError == false) goto L24;
            monitor-enter(this);
            Object[] r5 = this.latest;     // Catch: Throwable -> L21
            if (r5 != null) goto L12;
            monitor-exit(this);     // Catch: Throwable -> L21
            return;
        L12:
            if (r5[r3] != null) goto L14;
            boolean r6 = true;
        L15:
            if (r6 == true) goto L18;
            int r1 = this.complete + 1;     // Catch: Throwable -> L21
            this.complete = r1;     // Catch: Throwable -> L21
            if (r1 == r5.length) goto L18;
        L19:
            monitor-exit(this);     // Catch: Throwable -> L21
            r0 = r6;
        L18:
            this.done = true;     // Catch: Throwable -> L21
            goto L19
        L14:
            r6 = false;
        L21:
            th = move-exception;
            throw th;
        L24:
            if (r0 == false) goto L26;
            cancelSources();
        L26:
            drain();
            return;
        L27:
            RxJavaPlugins.onError(r4);
        }

        void innerComplete(int r4) {
            monitor-enter(this);
            Object[] r0 = this.latest;     // Catch: Throwable -> L20
            if (r0 != null) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L8:
            if (r0[r4] != null) goto L10;
            boolean r5 = true;
        L11:
            if (r5 == true) goto L14;
            int r2 = this.complete + 1;     // Catch: Throwable -> L20
            this.complete = r2;     // Catch: Throwable -> L20
            if (r2 == r0.length) goto L14;
        L15:
            monitor-exit(this);     // Catch: Throwable -> L20
            if (r5 == false) goto L18;
            cancelSources();
        L18:
            drain();
            return;
        L14:
            this.done = true;     // Catch: Throwable -> L20
            goto L15
        L10:
            r5 = false;
        L20:
            th = move-exception;
            throw th;
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] r1, Iterable<? extends ObservableSource<? extends T>> r2, Function<? super Object[], ? extends R> r3, int r4, boolean r5) {
        this.sources = r1;
        this.sourcesIterable = r2;
        this.combiner = r3;
        this.bufferSize = r4;
        this.delayError = r5;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> r9) {
        ObservableSource<? extends T>[] r0 = this.sources;
        if (r0 != null) goto L11;
        r0 = new Observable[8];
        Iterator<? extends ObservableSource<? extends T>> r1 = this.sourcesIterable.iterator();
        int r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L12;
        ObservableSource<? extends T> r4 = r1.next();
        if (r3 != r0.length) goto L10;
        ObservableSource<? extends T>[] r5 = new ObservableSource[(r3 >> 2) + r3];
        System.arraycopy(r0, 0, r5, 0, r3);
        r0 = r5;
    L10:
        r0[r3] = r4;
        r3 = r3 + 1;
    L12:
        int r6 = r3;
        if (r6 != 0) goto L16;
        EmptyDisposable.complete(r9);
        return;
    L16:
        new LatestCoordinator(r9, this.combiner, r6, this.bufferSize, this.delayError).subscribe(r0);
        return;
    L11:
        r3 = r0.length;
        goto L12
    }
}
