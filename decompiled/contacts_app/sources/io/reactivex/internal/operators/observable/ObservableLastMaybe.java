package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableLastMaybe<T> extends Maybe<T> {
    final ObservableSource<T> source;

    static final class LastObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        T item;
        Disposable upstream;

        LastObserver(MaybeObserver<? super T> r1) {
            this.downstream = r1;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.upstream != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.item = r1;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.upstream = DisposableHelper.DISPOSED;
            this.item = null;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            T r0 = this.item;
            if (r0 == null) goto L5;
            this.item = null;
            this.downstream.onSuccess(r0);
            return;
        L5:
            this.downstream.onComplete();
        }
    }

    public ObservableLastMaybe(ObservableSource<T> r1) {
        this.source = r1;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r2) {
        this.source.subscribe(new LastObserver(r2));
    }
}
