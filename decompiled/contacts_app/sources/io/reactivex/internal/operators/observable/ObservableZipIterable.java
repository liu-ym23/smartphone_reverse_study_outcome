package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableZipIterable<T, U, V> extends Observable<V> {
    final Iterable<U> other;
    final Observable<? extends T> source;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {
        boolean done;
        final Observer<? super V> downstream;
        final Iterator<U> iterator;
        Disposable upstream;
        final BiFunction<? super T, ? super U, ? extends V> zipper;

        ZipIterableObserver(Observer<? super V> r1, Iterator<U> r2, BiFunction<? super T, ? super U, ? extends V> r3) {
            this.downstream = r1;
            this.iterator = r2;
            this.zipper = r3;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            if (this.done == false) goto L25;
            return;
        L25:
            Object r0 = ObjectHelper.requireNonNull(this.iterator.next(), "The iterator returned a null value");     // Catch: Throwable -> L18
            Object r4 = ObjectHelper.requireNonNull(this.zipper.apply(r3, r0), "The zipper function returned a null value");     // Catch: Throwable -> L15
            this.downstream.onNext(r4);
            if (this.iterator.hasNext() == true) goto L27;
            this.done = true;
            this.upstream.dispose();
            this.downstream.onComplete();
            return;
        L27:
            return;
        L12:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            error(th);
            return;
        L15:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            error(th);
            return;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            error(th);
        }

        void error(Throwable r2) {
            this.done = true;
            this.upstream.dispose();
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }
    }

    public ObservableZipIterable(Observable<? extends T> r1, Iterable<U> r2, BiFunction<? super T, ? super U, ? extends V> r3) {
        this.source = r1;
        this.other = r2;
        this.zipper = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super V> r4) {
        Iterator r0 = (Iterator) ObjectHelper.requireNonNull(this.other.iterator(), "The iterator returned by other is null");     // Catch: Throwable -> L12
        if (r0.hasNext() == true) goto L7;
        EmptyDisposable.complete(r4);
        return;
    L7:
        this.source.subscribe(new ZipIterableObserver(r4, r0, this.zipper));
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r4);
        return;
    L12:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r4);
    }
}
