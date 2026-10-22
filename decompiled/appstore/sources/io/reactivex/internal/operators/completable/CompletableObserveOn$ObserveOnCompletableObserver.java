package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mf.f;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableObserveOn$ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    final CompletableObserver downstream;
    Throwable error;
    final f scheduler;

    public CompletableObserveOn$ObserveOnCompletableObserver(CompletableObserver r10, f r11) {
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
        if (r10 == null) goto L5;
        this.error = null;
        this.downstream.onError(r10);
        return;
    L5:
        this.downstream.onComplete();
    }
}
