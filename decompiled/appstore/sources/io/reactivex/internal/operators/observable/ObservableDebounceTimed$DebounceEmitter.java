package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableDebounceTimed$DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once;
    final c parent;
    final T value;

    public ObservableDebounceTimed$DebounceEmitter(T r10, long r11, c r12) {
        this.once = new AtomicBoolean();
        this.value = r10;
        this.idx = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.once.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        throw null;
    }

    public void setResource(Disposable r10) {
        DisposableHelper.replace(this, r10);
    }
}
