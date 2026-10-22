package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableFromAction extends Completable {
    final Action run;

    public CompletableFromAction(Action r1) {
        this.run = r1;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r2) {
        Disposable r0 = Disposables.empty();
        r2.onSubscribe(r0);
        this.run.run();     // Catch: Throwable -> L8
        if (r0.isDisposed() == true) goto L16;
        r2.onComplete();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r0.isDisposed() == true) goto L12;
        r2.onError(th);
        return;
    L12:
        RxJavaPlugins.onError(th);
    }
}
