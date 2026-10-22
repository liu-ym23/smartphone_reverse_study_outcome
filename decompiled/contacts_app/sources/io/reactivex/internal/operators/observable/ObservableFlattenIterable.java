package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;

    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super R> downstream;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        Disposable upstream;

        FlattenIterableObserver(Observer<? super R> r1, Function<? super T, ? extends Iterable<? extends R>> r2) {
            this.downstream = r1;
            this.mapper = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r4) {
            if (this.upstream != DisposableHelper.DISPOSED) goto L20;
            return;
        L20:
            Iterator<? extends R> r5 = this.mapper.apply(r4).iterator();     // Catch: Throwable -> L17
            Observer<? super R> r0 = this.downstream;
        L22:
            if (r5.hasNext() == false) goto L27;
            r0.onNext((Object) ObjectHelper.requireNonNull(r5.next(), "The iterator returned a null value"));
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
            return;
        L27:
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
            return;
        L17:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            if (this.upstream != DisposableHelper.DISPOSED) goto L6;
            RxJavaPlugins.onError(r3);
            return;
        L6:
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(r3);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.upstream != DisposableHelper.DISPOSED) goto L5;
            return;
        L5:
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }
    }

    public ObservableFlattenIterable(ObservableSource<T> r1, Function<? super T, ? extends Iterable<? extends R>> r2) {
        super(r1);
        this.mapper = r2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r3) {
        this.source.subscribe(new FlattenIterableObserver(r3, this.mapper));
    }
}
