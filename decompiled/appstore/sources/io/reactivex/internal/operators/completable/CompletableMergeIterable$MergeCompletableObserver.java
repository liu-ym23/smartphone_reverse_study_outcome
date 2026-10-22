package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableMergeIterable$MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {
    private static final long serialVersionUID = -7730517613164279224L;
    final CompletableObserver downstream;
    final io.reactivex.disposables.a set;
    final AtomicInteger wip;

    public CompletableMergeIterable$MergeCompletableObserver(CompletableObserver r10, io.reactivex.disposables.a r11, AtomicInteger r12) {
        this.downstream = r10;
        this.set = r11;
        this.wip = r12;
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        if (this.wip.decrementAndGet() == 0) goto L5;
        return;
    L5:
        if (compareAndSet(false, true) == false) goto L9;
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        this.set.dispose();
        if (compareAndSet(false, true) == false) goto L5;
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
