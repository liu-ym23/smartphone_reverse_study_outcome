package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class CancellableDisposable extends AtomicReference<Cancellable> implements Disposable {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(Cancellable r1) {
        super(r1);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (get() == null) goto L13;
        Cancellable r1 = getAndSet(null);
        if (r1 == null) goto L14;
        r1.cancel();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Exceptions.throwIfFatal(e);
        RxJavaPlugins.onError(e);
        return;
    L14:
        return;
    }
}
