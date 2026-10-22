package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mf.f;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeObserveOn$ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    final MaybeObserver<? super T> downstream;
    Throwable error;
    final f scheduler;
    T value;

    public MaybeObserveOn$ObserveOnMaybeObserver(MaybeObserver<? super T> r10, f r11) {
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

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        throw null;
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        this.error = r10;
        throw null;
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        this.value = r10;
        throw null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r10 = this.error;
        if (r10 == null) goto L5;
        this.error = null;
        this.downstream.onError(r10);
        return;
    L5:
        T r11 = this.value;
        if (r11 == null) goto L8;
        this.value = null;
        this.downstream.onSuccess(r11);
        return;
    L8:
        this.downstream.onComplete();
    }
}
