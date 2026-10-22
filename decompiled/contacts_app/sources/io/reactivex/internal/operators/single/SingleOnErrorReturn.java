package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleOnErrorReturn<T> extends Single<T> {
    final SingleSource<? extends T> source;
    final T value;
    final Function<? super Throwable, ? extends T> valueSupplier;

    final class OnErrorReturn implements SingleObserver<T> {
        private final SingleObserver<? super T> observer;
        final /* synthetic */ SingleOnErrorReturn this$0;

        OnErrorReturn(SingleOnErrorReturn r1, SingleObserver<? super T> r2) {
            this.this$0 = r1;
            this.observer = r2;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r5) {
            if (this.this$0.valueSupplier != null) goto L15;
            T r0 = this.this$0.value;
        L10:
            if (r0 != null) goto L13;
            NullPointerException r1 = new NullPointerException("Value supplied was null");
            r1.initCause(r5);
            this.observer.onError(r1);
            return;
        L13:
            this.observer.onSuccess(r0);
            return;
        L15:
            r0 = this.this$0.valueSupplier.apply(r5);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.observer.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.observer.onSubscribe(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r1) {
            this.observer.onSuccess(r1);
        }
    }

    public SingleOnErrorReturn(SingleSource<? extends T> r1, Function<? super Throwable, ? extends T> r2, T r3) {
        this.source = r1;
        this.valueSupplier = r2;
        this.value = r3;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new OnErrorReturn(this, r3));
    }
}
