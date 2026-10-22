package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> valueSupplier;

    static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> downstream;
        Disposable upstream;
        final Function<? super Throwable, ? extends T> valueSupplier;

        OnErrorReturnObserver(Observer<? super T> r1, Function<? super Throwable, ? extends T> r2) {
            this.downstream = r1;
            this.valueSupplier = r2;
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
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r5) {
            T r0 = this.valueSupplier.apply(r5);     // Catch: Throwable -> L8
            if (r0 != null) goto L6;
            NullPointerException r1 = new NullPointerException("The supplied value is null");
            r1.initCause(r5);
            this.downstream.onError(r1);
            return;
        L6:
            this.downstream.onNext(r0);
            this.downstream.onComplete();
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }
    }

    public ObservableOnErrorReturn(ObservableSource<T> r1, Function<? super Throwable, ? extends T> r2) {
        super(r1);
        this.valueSupplier = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        this.source.subscribe(new OnErrorReturnObserver(r3, this.valueSupplier));
    }
}
