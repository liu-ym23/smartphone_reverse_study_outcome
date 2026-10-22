package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableConcatIterable$ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
    private static final long serialVersionUID = -7965400327305809232L;
    final CompletableObserver downstream;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    final SequentialDisposable f20614sd;
    final Iterator<? extends CompletableSource> sources;

    public CompletableConcatIterable$ConcatInnerObserver(CompletableObserver r10, Iterator<? extends CompletableSource> r11) {
        this.downstream = r10;
        this.sources = r11;
        this.f20614sd = new SequentialDisposable();
    }

    public void next() {
        if (this.f20614sd.isDisposed() == false) goto L6;
        return;
    L6:
        if (getAndIncrement() == 0) goto L8;
        return;
    L8:
        Iterator<? extends CompletableSource> r10 = this.sources;
    L10:
        if (this.f20614sd.isDisposed() == true) goto L11;
        if (r10.hasNext() == false) goto L14;
        ((CompletableSource) io.reactivex.internal.functions.a.b(r10.next(), "The CompletableSource returned is null")).subscribe(this);
        if (decrementAndGet() != 0) goto L10;
        return;
    L20:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    L14:
        this.downstream.onComplete();
        return;
    L23:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
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
        this.f20614sd.replace(r10);
    }
}
