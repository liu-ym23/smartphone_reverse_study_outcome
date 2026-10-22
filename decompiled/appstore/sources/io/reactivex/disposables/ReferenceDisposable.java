package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    public ReferenceDisposable(T r10) {
        super(io.reactivex.internal.functions.a.b(r10, "value is null"));
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (get() == null) goto L8;
        T r10 = getAndSet(null);
        if (r10 == null) goto L9;
        onDisposed(r10);
        return;
    L9:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract void onDisposed(@NonNull T r10);
}
