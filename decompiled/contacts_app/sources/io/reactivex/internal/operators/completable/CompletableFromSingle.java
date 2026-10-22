package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> single;

    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {
        final CompletableObserver co;

        CompletableFromSingleObserver(CompletableObserver r1) {
            this.co = r1;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r1) {
            this.co.onError(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.co.onSubscribe(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r1) {
            this.co.onComplete();
        }
    }

    public CompletableFromSingle(SingleSource<T> r1) {
        this.single = r1;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r2) {
        this.single.subscribe(new CompletableFromSingleObserver(r2));
    }
}
