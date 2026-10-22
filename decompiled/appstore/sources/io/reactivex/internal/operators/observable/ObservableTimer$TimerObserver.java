package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableTimer$TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    final Observer<? super Long> downstream;

    public ObservableTimer$TimerObserver(Observer<? super Long> r10) {
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isDisposed() == true) goto L6;
        this.downstream.onNext(0L);
        lazySet(EmptyDisposable.INSTANCE);
        this.downstream.onComplete();
        return;
    }

    public void setResource(Disposable r10) {
        DisposableHelper.trySet(this, r10);
    }
}
