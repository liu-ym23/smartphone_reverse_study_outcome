package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableUsing<T, D> extends Observable<T> {
    final Consumer<? super D> disposer;
    final boolean eager;
    final Callable<? extends D> resourceSupplier;
    final Function<? super D, ? extends ObservableSource<? extends T>> sourceSupplier;

    static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5904473792286235046L;
        final Consumer<? super D> disposer;
        final Observer<? super T> downstream;
        final boolean eager;
        final D resource;
        Disposable upstream;

        UsingObserver(Observer<? super T> r1, D r2, Consumer<? super D> r3, boolean r4) {
            this.downstream = r1;
            this.resource = r2;
            this.disposer = r3;
            this.eager = r4;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r6) {
            if (this.eager == true) goto L5;
            this.downstream.onError(r6);
            this.upstream.dispose();
            disposeAfter();
            return;
        L5:
            if (compareAndSet(false, true) == true) goto L13;
        L10:
            this.upstream.dispose();
            this.downstream.onError(r6);
            return;
        L13:
            this.disposer.accept(this.resource);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r6 = new CompositeException(new Throwable[]{r6, th});
            goto L10
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.eager == true) goto L5;
            this.downstream.onComplete();
            this.upstream.dispose();
            disposeAfter();
            return;
        L5:
            if (compareAndSet(false, true) == true) goto L14;
        L11:
            this.upstream.dispose();
            this.downstream.onComplete();
            return;
        L14:
            this.disposer.accept(this.resource);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            disposeAfter();
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        void disposeAfter() {
            if (compareAndSet(false, true) == false) goto L11;
            this.disposer.accept(this.resource);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        }
    }

    public ObservableUsing(Callable<? extends D> r1, Function<? super D, ? extends ObservableSource<? extends T>> r2, Consumer<? super D> r3, boolean r4) {
        this.resourceSupplier = r1;
        this.sourceSupplier = r2;
        this.disposer = r3;
        this.eager = r4;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r5) {
        D r0 = this.resourceSupplier.call();     // Catch: Throwable -> L14
        ((ObservableSource) ObjectHelper.requireNonNull(this.sourceSupplier.apply(r0), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(r5, r0, this.disposer, this.eager));
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.disposer.accept(r0);     // Catch: Throwable -> L11
        EmptyDisposable.error(th, r5);
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(new CompositeException(new Throwable[]{th, th}), r5);
        return;
    L14:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r5);
    }
}
