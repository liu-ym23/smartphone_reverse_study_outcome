package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeOnErrorNext<T> extends AbstractMaybeWithUpstream<T, T> {
    final boolean allowFatal;
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

    static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 2026620218879969836L;
        final boolean allowFatal;
        final MaybeObserver<? super T> downstream;
        final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

        static final class NextMaybeObserver<T> implements MaybeObserver<T> {
            final MaybeObserver<? super T> downstream;
            final AtomicReference<Disposable> upstream;

            NextMaybeObserver(MaybeObserver<? super T> r1, AtomicReference<Disposable> r2) {
                this.downstream = r1;
                this.upstream = r2;
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this.upstream, r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(T r1) {
                this.downstream.onSuccess(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable r1) {
                this.downstream.onError(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.downstream.onComplete();
            }
        }

        OnErrorNextMaybeObserver(MaybeObserver<? super T> r1, Function<? super Throwable, ? extends MaybeSource<? extends T>> r2, boolean r3) {
            this.downstream = r1;
            this.resumeFunction = r2;
            this.allowFatal = r3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r5) {
            if (this.allowFatal == false) goto L5;
        L14:
            MaybeSource r0 = (MaybeSource) ObjectHelper.requireNonNull(this.resumeFunction.apply(r5), "The resumeFunction returned a null MaybeSource");     // Catch: Throwable -> L11
            DisposableHelper.replace(this, null);
            r0.subscribe(new NextMaybeObserver(this.downstream, this));
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
            return;
        L5:
            if ((r5 instanceof Exception) == true) goto L14;
            this.downstream.onError(r5);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }
    }

    public MaybeOnErrorNext(MaybeSource<T> r1, Function<? super Throwable, ? extends MaybeSource<? extends T>> r2, boolean r3) {
        super(r1);
        this.resumeFunction = r2;
        this.allowFatal = r3;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r4) {
        this.source.subscribe(new OnErrorNextMaybeObserver(r4, this.resumeFunction, this.allowFatal));
    }
}
