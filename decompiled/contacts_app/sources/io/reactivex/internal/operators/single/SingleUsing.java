package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleUsing<T, U> extends Single<T> {
    final Consumer<? super U> disposer;
    final boolean eager;
    final Callable<U> resourceSupplier;
    final Function<? super U, ? extends SingleSource<? extends T>> singleFunction;

    static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5331524057054083935L;
        final Consumer<? super U> disposer;
        final SingleObserver<? super T> downstream;
        final boolean eager;
        Disposable upstream;

        UsingSingleObserver(SingleObserver<? super T> r1, U r2, boolean r3, Consumer<? super U> r4) {
            super(r2);
            this.downstream = r1;
            this.eager = r3;
            this.disposer = r4;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            disposeAfter();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r3) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager == false) goto L11;
            Object r0 = getAndSet(this);
            if (r0 == this) goto L17;
            this.disposer.accept(r0);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        L17:
            return;
        L11:
            this.downstream.onSuccess(r3);
            if (this.eager == true) goto L18;
            disposeAfter();
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r5) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager == false) goto L11;
            Object r0 = getAndSet(this);
            if (r0 != this) goto L15;
            return;
        L15:
            this.disposer.accept(r0);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r5 = new CompositeException(new Throwable[]{r5, th});
        L11:
            this.downstream.onError(r5);
            if (this.eager == true) goto L17;
            disposeAfter();
            return;
        }

        void disposeAfter() {
            Object r0 = getAndSet(this);
            if (r0 == this) goto L11;
            this.disposer.accept(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        }
    }

    public SingleUsing(Callable<U> r1, Function<? super U, ? extends SingleSource<? extends T>> r2, Consumer<? super U> r3, boolean r4) {
        this.resourceSupplier = r1;
        this.singleFunction = r2;
        this.disposer = r3;
        this.eager = r4;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r7) {
        U r0 = this.resourceSupplier.call();     // Catch: Throwable -> L20
        ((SingleSource) ObjectHelper.requireNonNull(this.singleFunction.apply(r0), "The singleFunction returned a null SingleSource")).subscribe(new UsingSingleObserver(r7, r0, this.eager, this.disposer));
        return;
    L6:
        th = th;
        Exceptions.throwIfFatal(th);
        if (this.eager == true) goto L29;
    L13:
        EmptyDisposable.error(th, r7);
        if (this.eager == true) goto L31;
        this.disposer.accept(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        return;
    L31:
        return;
    L29:
        this.disposer.accept(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        th = new CompositeException(new Throwable[]{th, th});
    L20:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r7);
    }
}
