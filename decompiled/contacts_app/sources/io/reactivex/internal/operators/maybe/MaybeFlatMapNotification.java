package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeFlatMapNotification<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        final MaybeObserver<? super R> downstream;
        final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
        final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
        final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;
        Disposable upstream;

        final class InnerObserver implements MaybeObserver<R> {
            final /* synthetic */ FlatMapMaybeObserver this$0;

            InnerObserver(FlatMapMaybeObserver r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this.this$0, r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r1) {
                this.this$0.downstream.onSuccess(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable r1) {
                this.this$0.downstream.onError(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.this$0.downstream.onComplete();
            }
        }

        FlatMapMaybeObserver(MaybeObserver<? super R> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, Function<? super Throwable, ? extends MaybeSource<? extends R>> r3, Callable<? extends MaybeSource<? extends R>> r4) {
            this.downstream = r1;
            this.onSuccessMapper = r2;
            this.onErrorMapper = r3;
            this.onCompleteSupplier = r4;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            MaybeSource r3 = (MaybeSource) ObjectHelper.requireNonNull(this.onSuccessMapper.apply(r2), "The onSuccessMapper returned a null MaybeSource");     // Catch: Exception -> L5
            r3.subscribe(new InnerObserver(this));
            return;
        L5:
            e = move-exception;
            Exceptions.throwIfFatal(e);
            this.downstream.onError(e);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r5) {
            ((MaybeSource) ObjectHelper.requireNonNull(this.onErrorMapper.apply(r5), "The onErrorMapper returned a null MaybeSource")).subscribe(new InnerObserver(this));
            return;
        L5:
            e = move-exception;
            Exceptions.throwIfFatal(e);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, e}));
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            MaybeSource r0 = (MaybeSource) ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource");     // Catch: Exception -> L5
            r0.subscribe(new InnerObserver(this));
            return;
        L5:
            e = move-exception;
            Exceptions.throwIfFatal(e);
            this.downstream.onError(e);
        }
    }

    public MaybeFlatMapNotification(MaybeSource<T> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, Function<? super Throwable, ? extends MaybeSource<? extends R>> r3, Callable<? extends MaybeSource<? extends R>> r4) {
        super(r1);
        this.onSuccessMapper = r2;
        this.onErrorMapper = r3;
        this.onCompleteSupplier = r4;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super R> r5) {
        this.source.subscribe(new FlatMapMaybeObserver(r5, this.onSuccessMapper, this.onErrorMapper, this.onCompleteSupplier));
    }
}
