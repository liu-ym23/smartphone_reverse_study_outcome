package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableDebounceTimed$DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once;
    final FlowableDebounceTimed$DebounceTimedSubscriber<T> parent;
    final T value;

    public FlowableDebounceTimed$DebounceEmitter(T r10, long r11, FlowableDebounceTimed$DebounceTimedSubscriber<T> r12) {
        this.once = new AtomicBoolean();
        this.value = r10;
        this.idx = r11;
        this.parent = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void emit() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        this.parent.emit(this.idx, this.value, this);
        return;
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
        emit();
    }

    public void setResource(Disposable r10) {
        DisposableHelper.replace(this, r10);
    }
}
