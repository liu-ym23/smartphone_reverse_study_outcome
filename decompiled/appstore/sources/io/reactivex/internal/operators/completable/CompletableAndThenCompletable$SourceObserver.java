package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableAndThenCompletable$SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    private static final long serialVersionUID = -4101678820158072998L;
    final CompletableObserver actualObserver;
    final CompletableSource next;

    public CompletableAndThenCompletable$SourceObserver(CompletableObserver r10, CompletableSource r11) {
        this.actualObserver = r10;
        this.next = r11;
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
        this.next.subscribe(new a(this, this.actualObserver));
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        this.actualObserver.onError(r10);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.actualObserver.onSubscribe(this);
        return;
    }
}
