package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mf.f;

/* JADX INFO: loaded from: classes4.dex */
final class SingleObserveOn$ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
    private static final long serialVersionUID = 3528003840217436037L;
    final SingleObserver<? super T> downstream;
    Throwable error;
    final f scheduler;
    T value;

    public SingleObserveOn$ObserveOnSingleObserver(SingleObserver<? super T> r10, f r11) {
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        this.error = r10;
        throw null;
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        this.value = r10;
        throw null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r10 = this.error;
        if (r10 == null) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        this.downstream.onSuccess(this.value);
    }
}
