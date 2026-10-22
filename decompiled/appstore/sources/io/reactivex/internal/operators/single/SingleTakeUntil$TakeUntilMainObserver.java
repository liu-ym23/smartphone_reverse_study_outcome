package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class SingleTakeUntil$TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = -622603812305745221L;
    final SingleObserver<? super T> downstream;
    final SingleTakeUntil$TakeUntilOtherSubscriber other;

    public SingleTakeUntil$TakeUntilMainObserver(SingleObserver<? super T> r10) {
        this.downstream = r10;
        this.other = new SingleTakeUntil$TakeUntilOtherSubscriber(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        this.other.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.other.dispose();
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 != r12) goto L5;
    L8:
        qf.a.e(r10);
        return;
    L5:
        if (getAndSet(r12) == r12) goto L8;
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        this.other.dispose();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L6;
        this.downstream.onSuccess(r10);
        return;
    }

    public void otherError(Throwable r10) {
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L10;
        Disposable r13 = getAndSet(r12);
        if (r13 == r12) goto L10;
        if (r13 == null) goto L8;
        r13.dispose();
    L8:
        this.downstream.onError(r10);
        return;
    L10:
        qf.a.e(r10);
    }
}
