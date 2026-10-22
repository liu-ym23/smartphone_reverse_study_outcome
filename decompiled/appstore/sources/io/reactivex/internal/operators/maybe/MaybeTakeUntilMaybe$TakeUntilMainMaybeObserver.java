package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = -2187421758664251153L;
    final MaybeObserver<? super T> downstream;
    final TakeUntilOtherMaybeObserver<U> other;

    public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Disposable> implements MaybeObserver<U> {
        private static final long serialVersionUID = -1266041316834525931L;
        final MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver<?, U> parent;

        public TakeUntilOtherMaybeObserver(MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver<?, U> r10) {
            this.parent = r10;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r10) {
            this.parent.otherError(r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object r10) {
            this.parent.otherComplete();
        }
    }

    public MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver(MaybeObserver<? super T> r10) {
        this.downstream = r10;
        this.other = new TakeUntilOtherMaybeObserver(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        DisposableHelper.dispose(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L6;
        this.downstream.onSuccess(r10);
        return;
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this) == false) goto L6;
        this.downstream.onComplete();
        return;
    }

    public void otherError(Throwable r10) {
        if (DisposableHelper.dispose(this) == false) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }
}
