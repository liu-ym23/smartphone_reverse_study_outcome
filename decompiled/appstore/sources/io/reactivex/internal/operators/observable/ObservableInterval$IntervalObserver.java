package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableInterval$IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
    private static final long serialVersionUID = 346773832286157679L;
    long count;
    final Observer<? super Long> downstream;

    public ObservableInterval$IntervalObserver(Observer<? super Long> r10) {
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
        if (get() == DisposableHelper.DISPOSED) goto L6;
        Observer<? super Long> r10 = this.downstream;
        long r11 = this.count;
        this.count = 1 + r11;
        r10.onNext(Long.valueOf(r11));
        return;
    }

    public void setResource(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
