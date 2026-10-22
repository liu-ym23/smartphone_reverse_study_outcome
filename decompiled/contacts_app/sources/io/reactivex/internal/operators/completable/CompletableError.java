package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableError extends Completable {
    final Throwable error;

    public CompletableError(Throwable r1) {
        this.error = r1;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r1) {
        EmptyDisposable.error(this.error, r1);
    }
}
