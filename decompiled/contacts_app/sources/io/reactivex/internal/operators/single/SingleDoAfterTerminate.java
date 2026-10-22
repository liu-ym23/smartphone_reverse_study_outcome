package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleDoAfterTerminate<T> extends Single<T> {
    final Action onAfterTerminate;
    final SingleSource<T> source;

    static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> downstream;
        final Action onAfterTerminate;
        Disposable upstream;

        DoAfterTerminateObserver(SingleObserver<? super T> r1, Action r2) {
            this.downstream = r1;
            this.onAfterTerminate = r2;
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
            this.downstream.onSuccess(r2);
            onAfterTerminate();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            onAfterTerminate();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        private void onAfterTerminate() {
            this.onAfterTerminate.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    public SingleDoAfterTerminate(SingleSource<T> r1, Action r2) {
        this.source = r1;
        this.onAfterTerminate = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new DoAfterTerminateObserver(r3, this.onAfterTerminate));
    }
}
