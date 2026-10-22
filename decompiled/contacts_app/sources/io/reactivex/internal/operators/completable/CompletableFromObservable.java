package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> observable;

    static final class CompletableFromObservableObserver<T> implements Observer<T> {
        final CompletableObserver co;

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
        }

        CompletableFromObservableObserver(CompletableObserver r1) {
            this.co = r1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.co.onSubscribe(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.co.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.co.onComplete();
        }
    }

    public CompletableFromObservable(ObservableSource<T> r1) {
        this.observable = r1;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r2) {
        this.observable.subscribe(new CompletableFromObservableObserver(r2));
    }
}
