package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableCreate<T> extends Observable<T> {
    final ObservableOnSubscribe<T> source;

    static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long serialVersionUID = -3434801548987643227L;
        final Observer<? super T> observer;

        CreateEmitter(Observer<? super T> r1) {
            this.observer = r1;
        }

        @Override // io.reactivex.Emitter
        public void onNext(T r2) {
            if (r2 != null) goto L6;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L6:
            if (isDisposed() == true) goto L9;
            this.observer.onNext(r2);
            return;
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable r1) {
            if (tryOnError(r1) == true) goto L6;
            RxJavaPlugins.onError(r1);
            return;
        }

        @Override // io.reactivex.ObservableEmitter
        public boolean tryOnError(Throwable r2) {
            if (r2 != null) goto L5;
            r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L5:
            if (isDisposed() == false) goto L14;
            return false;
        L14:
            this.observer.onError(r2);     // Catch: Throwable -> L9
            dispose();
            return true;
        L9:
            th = move-exception;
            dispose();
            throw th;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (isDisposed() == false) goto L10;
            return;
        L10:
            this.observer.onComplete();     // Catch: Throwable -> L6
            dispose();
            return;
        L6:
            th = move-exception;
            dispose();
            throw th;
        }

        @Override // io.reactivex.ObservableEmitter
        public void setDisposable(Disposable r1) {
            DisposableHelper.set(this, r1);
        }

        @Override // io.reactivex.ObservableEmitter
        public void setCancellable(Cancellable r2) {
            setDisposable(new CancellableDisposable(r2));
        }

        @Override // io.reactivex.ObservableEmitter
        public ObservableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.ObservableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    static final class SerializedEmitter<T> extends AtomicInteger implements ObservableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final ObservableEmitter<T> emitter;
        final AtomicThrowable error;
        final SpscLinkedArrayQueue<T> queue;

        @Override // io.reactivex.ObservableEmitter
        public ObservableEmitter<T> serialize() {
            return this;
        }

        SerializedEmitter(ObservableEmitter<T> r2) {
            this.emitter = r2;
            this.error = new AtomicThrowable();
            this.queue = new SpscLinkedArrayQueue(16);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T r3) {
            if (this.emitter.isDisposed() == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L32;
            if (r3 != null) goto L11;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L11:
            if (get() == 0) goto L13;
        L17:
            SpscLinkedArrayQueue<T> r0 = this.queue;
            monitor-enter(r0);
            r0.offer(r3);     // Catch: Throwable -> L26
            monitor-exit(r0);     // Catch: Throwable -> L26
            if (getAndIncrement() == 0) goto L24;
            return;
        L24:
            drainLoop();
            return;
        L26:
            th = move-exception;
            throw th;
        L13:
            if (compareAndSet(0, 1) == false) goto L17;
            this.emitter.onNext(r3);
            if (decrementAndGet() != 0) goto L24;
            return;
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable r1) {
            if (tryOnError(r1) == true) goto L6;
            RxJavaPlugins.onError(r1);
            return;
        }

        @Override // io.reactivex.ObservableEmitter
        public boolean tryOnError(Throwable r3) {
            if (this.emitter.isDisposed() == false) goto L5;
        L13:
            return false;
        L5:
            if (this.done == true) goto L13;
            if (r3 != null) goto L10;
            r3 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L10:
            if (this.error.addThrowable(r3) == false) goto L13;
            this.done = true;
            drain();
            return true;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.emitter.isDisposed() == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L10;
            this.done = true;
            drain();
            return;
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void drainLoop() {
            ObservableEmitter<T> r0 = this.emitter;
            SpscLinkedArrayQueue<T> r1 = this.queue;
            AtomicThrowable r2 = this.error;
            int r4 = 1;
        L4:
            if (r0.isDisposed() == true) goto L5;
            if (r2.get() != null) goto L9;
            boolean r5 = this.done;
            T r6 = r1.poll();
            if (r6 != null) goto L14;
            boolean r7 = true;
        L15:
            if (r5 == false) goto L19;
            if (r7 == false) goto L19;
            r0.onComplete();
            return;
        L19:
            if (r7 == true) goto L20;
            r0.onNext(r6);
            goto L4
        L20:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L4;
            return;
        L14:
            r7 = false;
            goto L15
        L9:
            r1.clear();
            r0.onError(r2.terminate());
            return;
        L5:
            r1.clear();
        }

        @Override // io.reactivex.ObservableEmitter
        public void setDisposable(Disposable r1) {
            this.emitter.setDisposable(r1);
        }

        @Override // io.reactivex.ObservableEmitter
        public void setCancellable(Cancellable r1) {
            this.emitter.setCancellable(r1);
        }

        @Override // io.reactivex.ObservableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }
    }

    public ObservableCreate(ObservableOnSubscribe<T> r1) {
        this.source = r1;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r2) {
        CreateEmitter r0 = new CreateEmitter(r2);
        r2.onSubscribe(r0);
        this.source.subscribe(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r0.onError(th);
    }
}
