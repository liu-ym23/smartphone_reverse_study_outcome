package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean allowFatal;
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;

    static final class OnErrorNextObserver<T> implements Observer<T> {
        final boolean allowFatal;
        final SequentialDisposable arbiter;
        boolean done;
        final Observer<? super T> downstream;
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;
        boolean once;

        OnErrorNextObserver(Observer<? super T> r1, Function<? super Throwable, ? extends ObservableSource<? extends T>> r2, boolean r3) {
            this.downstream = r1;
            this.nextSupplier = r2;
            this.allowFatal = r3;
            this.arbiter = new SequentialDisposable();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.arbiter.replace(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.done == false) goto L5;
            return;
        L5:
            this.downstream.onNext(r2);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r6) {
            if (this.once == true) goto L5;
            this.once = true;
            if (this.allowFatal == true) goto L13;
        L25:
            ObservableSource<? extends T> r1 = this.nextSupplier.apply(r6);     // Catch: Throwable -> L22
            if (r1 != null) goto L20;
            NullPointerException r0 = new NullPointerException("Observable is null");
            r0.initCause(r6);
            this.downstream.onError(r0);
            return;
        L20:
            r1.subscribe(this);
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r6, th}));
            return;
        L13:
            if ((r6 instanceof Exception) == true) goto L25;
            this.downstream.onError(r6);
            return;
        L5:
            if (this.done == false) goto L8;
            RxJavaPlugins.onError(r6);
            return;
        L8:
            this.downstream.onError(r6);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> r1, Function<? super Throwable, ? extends ObservableSource<? extends T>> r2, boolean r3) {
        super(r1);
        this.nextSupplier = r2;
        this.allowFatal = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r4) {
        OnErrorNextObserver r0 = new OnErrorNextObserver(r4, this.nextSupplier, this.allowFatal);
        r4.onSubscribe(r0.arbiter);
        this.source.subscribe(r0);
    }
}
