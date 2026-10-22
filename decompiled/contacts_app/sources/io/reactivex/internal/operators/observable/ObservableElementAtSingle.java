package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {
    final T defaultValue;
    final long index;
    final ObservableSource<T> source;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        long count;
        final T defaultValue;
        boolean done;
        final SingleObserver<? super T> downstream;
        final long index;
        Disposable upstream;

        ElementAtObserver(SingleObserver<? super T> r1, long r2, T r4) {
            this.downstream = r1;
            this.index = r2;
            this.defaultValue = r4;
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
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.count;
            if (r0 != this.index) goto L9;
            this.done = true;
            this.upstream.dispose();
            this.downstream.onSuccess(r5);
            return;
        L9:
            this.count = r0 + 1;
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
            if (this.done == true) goto L9;
            this.done = true;
            T r0 = this.defaultValue;
            if (r0 == null) goto L7;
            this.downstream.onSuccess(r0);
            return;
        L7:
            this.downstream.onError(new NoSuchElementException());
            return;
        }
    }

    public ObservableElementAtSingle(ObservableSource<T> r1, long r2, T r4) {
        this.source = r1;
        this.index = r2;
        this.defaultValue = r4;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> r5) {
        this.source.subscribe(new ElementAtObserver(r5, this.index, this.defaultValue));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.source, this.index, this.defaultValue, true));
    }
}
