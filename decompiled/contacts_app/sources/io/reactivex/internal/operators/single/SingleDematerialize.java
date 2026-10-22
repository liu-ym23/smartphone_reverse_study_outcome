package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleDematerialize<T, R> extends Maybe<R> {
    final Function<? super T, Notification<R>> selector;
    final Single<T> source;

    static final class DematerializeObserver<T, R> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super R> downstream;
        final Function<? super T, Notification<R>> selector;
        Disposable upstream;

        DematerializeObserver(MaybeObserver<? super R> r1, Function<? super T, Notification<R>> r2) {
            this.downstream = r1;
            this.selector = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
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
        public void onSuccess(T r2) {
            Notification r3 = (Notification) ObjectHelper.requireNonNull(this.selector.apply(r2), "The selector returned a null Notification");     // Catch: Throwable -> L11
            if (r3.isOnNext() == false) goto L7;
            this.downstream.onSuccess((Object) r3.getValue());
            return;
        L7:
            if (r3.isOnComplete() == false) goto L9;
            this.downstream.onComplete();
            return;
        L9:
            this.downstream.onError(r3.getError());
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }
    }

    public SingleDematerialize(Single<T> r1, Function<? super T, Notification<R>> r2) {
        this.source = r1;
        this.selector = r2;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super R> r3) {
        this.source.subscribe(new DematerializeObserver(r3, this.selector));
    }
}
