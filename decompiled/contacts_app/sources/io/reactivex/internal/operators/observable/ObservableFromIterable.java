package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableFromIterable<T> extends Observable<T> {
    final Iterable<? extends T> source;

    static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {
        boolean checkNext;
        volatile boolean disposed;
        boolean done;
        final Observer<? super T> downstream;
        boolean fusionMode;
        final Iterator<? extends T> it;

        FromIterableDisposable(Observer<? super T> r1, Iterator<? extends T> r2) {
            this.downstream = r1;
            this.it = r2;
        }

        void run() {
        L3:
            if (isDisposed() == true) goto L4;
            Object r0 = ObjectHelper.requireNonNull(this.it.next(), "The iterator returned a null value");     // Catch: Throwable -> L18
            this.downstream.onNext(r0);
            if (isDisposed() == true) goto L8;
            if (this.it.hasNext() == true) goto L3;
            if (isDisposed() == true) goto L29;
            this.downstream.onComplete();
            return;
        L29:
            return;
        L15:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        L8:
            return;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 1) == 0) goto L6;
            this.fusionMode = true;
            return 1;
        L6:
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            if (this.done == false) goto L6;
            return null;
        L6:
            if (this.checkNext == true) goto L8;
            this.checkNext = true;
        L13:
            return (T) ObjectHelper.requireNonNull(this.it.next(), "The iterator returned a null value");
        L8:
            if (this.it.hasNext() == true) goto L13;
            this.done = true;
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.done;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.done = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    public ObservableFromIterable(Iterable<? extends T> r1) {
        this.source = r1;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r2) {
        Iterator<? extends T> r1 = this.source.iterator();     // Catch: Throwable -> L14
        if (r1.hasNext() == true) goto L7;
        EmptyDisposable.complete(r2);
        return;
    L7:
        FromIterableDisposable r0 = new FromIterableDisposable(r2, r1);
        r2.onSubscribe(r0);
        if (r0.fusionMode == true) goto L21;
        r0.run();
        return;
    L21:
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r2);
        return;
    L14:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r2);
    }
}
