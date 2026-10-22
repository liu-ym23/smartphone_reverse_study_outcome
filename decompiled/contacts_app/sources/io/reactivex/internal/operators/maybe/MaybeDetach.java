package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeDetach<T> extends AbstractMaybeWithUpstream<T, T> {

    static final class DetachMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        MaybeObserver<? super T> downstream;
        Disposable upstream;

        DetachMaybeObserver(MaybeObserver<? super T> r1) {
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

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r3) {
            this.upstream = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> r0 = this.downstream;
            if (r0 == null) goto L6;
            this.downstream = null;
            r0.onSuccess(r3);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r3) {
            this.upstream = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> r0 = this.downstream;
            if (r0 == null) goto L6;
            this.downstream = null;
            r0.onError(r3);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> r0 = this.downstream;
            if (r0 == null) goto L6;
            this.downstream = null;
            r0.onComplete();
            return;
        }
    }

    public MaybeDetach(MaybeSource<T> r1) {
        super(r1);
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r2) {
        this.source.subscribe(new DetachMaybeObserver(r2));
    }
}
