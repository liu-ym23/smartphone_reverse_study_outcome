package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableSingleSingle<T> extends Single<T> {
    final T defaultValue;
    final ObservableSource<? extends T> source;

    static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        final T defaultValue;
        boolean done;
        final SingleObserver<? super T> downstream;
        Disposable upstream;
        T value;

        SingleElementObserver(SingleObserver<? super T> r1, T r2) {
            this.downstream = r1;
            this.defaultValue = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.value == null) goto L9;
            this.done = true;
            this.upstream.dispose();
            this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        L9:
            this.value = r2;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            T r0 = this.value;
            this.value = null;
            if (r0 != null) goto L8;
            r0 = this.defaultValue;
        L8:
            if (r0 == null) goto L10;
            this.downstream.onSuccess(r0);
            return;
        L10:
            this.downstream.onError(new NoSuchElementException());
        }
    }

    public ObservableSingleSingle(ObservableSource<? extends T> r1, T r2) {
        this.source = r1;
        this.defaultValue = r2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new SingleElementObserver(r3, this.defaultValue));
    }
}
