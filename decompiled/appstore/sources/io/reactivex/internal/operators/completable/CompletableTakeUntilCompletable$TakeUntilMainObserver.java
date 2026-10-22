package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableTakeUntilCompletable$TakeUntilMainObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 3533011714830024923L;
    final CompletableObserver downstream;
    final AtomicBoolean once;
    final OtherObserver other;

    public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
        private static final long serialVersionUID = 5176264485428790318L;
        final CompletableTakeUntilCompletable$TakeUntilMainObserver parent;

        public OtherObserver(CompletableTakeUntilCompletable$TakeUntilMainObserver r10) {
            this.parent = r10;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r10) {
            this.parent.innerError(r10);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    public CompletableTakeUntilCompletable$TakeUntilMainObserver(CompletableObserver r10) {
        this.downstream = r10;
        this.other = new OtherObserver(this);
        this.once = new AtomicBoolean();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
        return;
    }

    public void innerComplete() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
        return;
    }

    public void innerError(Throwable r10) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        DisposableHelper.dispose(this);
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.once.get();
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        DisposableHelper.dispose(this.other);
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        DisposableHelper.dispose(this.other);
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
