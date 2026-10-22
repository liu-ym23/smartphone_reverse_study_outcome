package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleDetach<T> extends Single<T> {
    final SingleSource<T> source;

    static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        SingleObserver<? super T> downstream;
        Disposable upstream;

        DetachSingleObserver(SingleObserver<? super T> r1) {
            this.downstream = r1;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.downstream = null;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
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
        public void onSuccess(T r3) {
            this.upstream = DisposableHelper.DISPOSED;
            SingleObserver<? super T> r0 = this.downstream;
            if (r0 == null) goto L6;
            this.downstream = null;
            r0.onSuccess(r3);
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r3) {
            this.upstream = DisposableHelper.DISPOSED;
            SingleObserver<? super T> r0 = this.downstream;
            if (r0 == null) goto L6;
            this.downstream = null;
            r0.onError(r3);
            return;
        }
    }

    public SingleDetach(SingleSource<T> r1) {
        this.source = r1;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r2) {
        this.source.subscribe(new DetachSingleObserver(r2));
    }
}
