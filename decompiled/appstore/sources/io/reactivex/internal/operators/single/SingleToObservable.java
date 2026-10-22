package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import mf.e;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleToObservable extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SingleSource f20703a;

    public static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        Disposable upstream;

        public SingleToObservableObserver(Observer<? super T> r10) {
            super(r10);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r10) {
            error(r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r10) {
            if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
            this.upstream = r10;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r10) {
            complete(r10);
        }
    }

    public SingleToObservable(SingleSource r10) {
        this.f20703a = r10;
    }

    public static SingleObserver c(Observer r10) {
        return new SingleToObservableObserver(r10);
    }

    @Override // mf.e
    public void b(Observer r10) {
        this.f20703a.subscribe(c(r10));
    }
}
