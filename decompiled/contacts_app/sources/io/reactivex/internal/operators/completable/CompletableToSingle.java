package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableToSingle<T> extends Single<T> {
    final T completionValue;
    final Callable<? extends T> completionValueSupplier;
    final CompletableSource source;

    final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> observer;
        final /* synthetic */ CompletableToSingle this$0;

        ToSingle(CompletableToSingle r1, SingleObserver<? super T> r2) {
            this.this$0 = r1;
            this.observer = r2;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.this$0.completionValueSupplier != null) goto L14;
            T r0 = this.this$0.completionValue;
        L10:
            if (r0 != null) goto L12;
            this.observer.onError(new NullPointerException("The value supplied is null"));
            return;
        L12:
            this.observer.onSuccess(r0);
            return;
        L14:
            r0 = this.this$0.completionValueSupplier.call();     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.observer.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r1) {
            this.observer.onError(r1);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.observer.onSubscribe(r1);
        }
    }

    public CompletableToSingle(CompletableSource r1, Callable<? extends T> r2, T r3) {
        this.source = r1;
        this.completionValue = r3;
        this.completionValueSupplier = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new ToSingle(this, r3));
    }
}
