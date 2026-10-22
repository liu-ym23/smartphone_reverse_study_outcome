package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeSwitchIfEmptySingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {
    final SingleSource<? extends T> other;
    final MaybeSource<T> source;

    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4603919676453758899L;
        final SingleObserver<? super T> downstream;
        final SingleSource<? extends T> other;

        static final class OtherSingleObserver<T> implements SingleObserver<T> {
            final SingleObserver<? super T> downstream;
            final AtomicReference<Disposable> parent;

            OtherSingleObserver(SingleObserver<? super T> r1, AtomicReference<Disposable> r2) {
                this.downstream = r1;
                this.parent = r2;
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this.parent, r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T r1) {
                this.downstream.onSuccess(r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable r1) {
                this.downstream.onError(r1);
            }
        }

        SwitchIfEmptyMaybeObserver(SingleObserver<? super T> r1, SingleSource<? extends T> r2) {
            this.downstream = r1;
            this.other = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Disposable r0 = get();
            if (r0 != DisposableHelper.DISPOSED) goto L5;
            return;
        L5:
            if (compareAndSet(r0, null) == false) goto L9;
            this.other.subscribe(new OtherSingleObserver(this.downstream, this));
            return;
        }
    }

    public MaybeSwitchIfEmptySingle(MaybeSource<T> r1, SingleSource<? extends T> r2) {
        this.source = r1;
        this.other = r2;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new SwitchIfEmptyMaybeObserver(r3, this.other));
    }
}
