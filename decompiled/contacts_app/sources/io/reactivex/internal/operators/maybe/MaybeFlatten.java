package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeFlatten<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        final MaybeObserver<? super R> downstream;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
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

        FlatMapMaybeObserver(MaybeObserver<? super R> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2) {
            this.downstream = r1;
            this.mapper = r2;
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
            MaybeSource r3 = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper returned a null MaybeSource");     // Catch: Exception -> L7
            if (isDisposed() == true) goto L12;
            r3.subscribe(new InnerObserver(this));
            return;
        L12:
            return;
        L7:
            e = move-exception;
            Exceptions.throwIfFatal(e);
            this.downstream.onError(e);
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

    public MaybeFlatten(MaybeSource<T> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2) {
        super(r1);
        this.mapper = r2;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super R> r3) {
        this.source.subscribe(new FlatMapMaybeObserver(r3, this.mapper));
    }
}
