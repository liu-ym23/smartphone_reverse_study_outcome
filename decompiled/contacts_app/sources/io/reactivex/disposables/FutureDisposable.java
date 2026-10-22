package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    FutureDisposable(Future<?> r1, boolean r2) {
        super(r1);
        this.allowInterrupt = r2;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Future<?> r0 = get();
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isDone() == true) goto L8;
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Future<?> r0 = getAndSet(null);
        if (r0 == null) goto L6;
        r0.cancel(this.allowInterrupt);
        return;
    }
}
