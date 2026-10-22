package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableMergeArray$InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
    private static final long serialVersionUID = -8360547806504310570L;
    final CompletableObserver downstream;
    final AtomicBoolean once;
    final io.reactivex.disposables.a set;

    public CompletableMergeArray$InnerCompletableObserver(CompletableObserver r10, AtomicBoolean r11, io.reactivex.disposables.a r12, int r13) {
        this.downstream = r10;
        this.once = r11;
        this.set = r12;
        lazySet(r13);
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        if (decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (this.once.compareAndSet(false, true) == false) goto L9;
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        this.set.dispose();
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        this.set.add(r10);
    }
}
