package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableNever extends Completable {
    public static final Completable INSTANCE = null;

    static {
        INSTANCE = new CompletableNever();
    }

    private CompletableNever() {
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r1) {
        r1.onSubscribe(EmptyDisposable.NEVER);
    }
}
