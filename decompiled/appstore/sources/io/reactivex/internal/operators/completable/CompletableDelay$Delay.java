package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mf.f;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableDelay$Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
    private static final long serialVersionUID = 465972761105851022L;
    final long delay;
    final boolean delayError;
    final CompletableObserver downstream;
    Throwable error;
    final f scheduler;
    final TimeUnit unit;

    public CompletableDelay$Delay(CompletableObserver r10, long r11, TimeUnit r12, f r13, boolean r14) {
        this.downstream = r10;
        this.delay = r11;
        this.unit = r12;
        this.delayError = r14;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        throw null;
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        this.error = r10;
        throw null;
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r10 = this.error;
        this.error = null;
        if (r10 == null) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        this.downstream.onComplete();
    }
}
