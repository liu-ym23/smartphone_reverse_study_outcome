package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableConcatArray$ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
    private static final long serialVersionUID = -7965400327305809232L;
    final CompletableObserver downstream;
    int index;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    final SequentialDisposable f20613sd;
    final CompletableSource[] sources;

    public CompletableConcatArray$ConcatInnerObserver(CompletableObserver r10, CompletableSource[] r11) {
        this.downstream = r10;
        this.sources = r11;
        this.f20613sd = new SequentialDisposable();
    }

    public void next() {
        if (this.f20613sd.isDisposed() == false) goto L6;
        return;
    L6:
        if (getAndIncrement() == 0) goto L8;
        return;
    L8:
        CompletableSource[] r10 = this.sources;
    L10:
        if (this.f20613sd.isDisposed() == true) goto L11;
        int r11 = this.index;
        this.index = r11 + 1;
        if (r11 == r10.length) goto L14;
        r10[r11].subscribe(this);
        if (decrementAndGet() != 0) goto L10;
        return;
    L14:
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        next();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        this.f20613sd.replace(r10);
    }
}
