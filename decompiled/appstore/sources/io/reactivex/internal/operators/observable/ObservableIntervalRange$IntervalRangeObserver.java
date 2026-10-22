package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableIntervalRange$IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
    private static final long serialVersionUID = 1891866368734007884L;
    long count;
    final Observer<? super Long> downstream;
    final long end;

    public ObservableIntervalRange$IntervalRangeObserver(Observer<? super Long> r10, long r11, long r12) {
        this.downstream = r10;
        this.count = r11;
        this.end = r12;
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
        if (isDisposed() == true) goto L10;
        long r10 = this.count;
        this.downstream.onNext(Long.valueOf(r10));
        if (r10 != this.end) goto L8;
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
        return;
    L8:
        this.count = r10 + 1;
        return;
    }

    public void setResource(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
