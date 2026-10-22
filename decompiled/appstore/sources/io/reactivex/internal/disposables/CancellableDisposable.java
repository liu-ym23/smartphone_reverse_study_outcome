package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.a;
import io.reactivex.functions.Cancellable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class CancellableDisposable extends AtomicReference<Cancellable> implements Disposable {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(Cancellable r10) {
        super(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (get() == null) goto L13;
        Cancellable r10 = getAndSet(null);
        if (r10 == null) goto L14;
        r10.cancel();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a.a(e);
        qf.a.e(e);
        return;
    L14:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
