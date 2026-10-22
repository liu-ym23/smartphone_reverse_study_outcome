package io.reactivex.internal.operators.single;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class SingleCreate$Emitter<T> extends AtomicReference<Disposable> implements SingleEmitter<T>, Disposable {
    private static final long serialVersionUID = -2467358622224974244L;
    final SingleObserver<? super T> downstream;

    public SingleCreate$Emitter(SingleObserver<? super T> r10) {
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.SingleEmitter, io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.SingleEmitter
    public void onError(Throwable r10) {
        if (tryOnError(r10) == true) goto L6;
        qf.a.e(r10);
        return;
    }

    @Override // io.reactivex.SingleEmitter
    public void onSuccess(T r10) {
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L16;
        Disposable r13 = getAndSet(r12);
        if (r13 == r12) goto L19;
        if (r10 != null) goto L10;
        this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));     // Catch: Throwable -> L8
    L11:
        if (r13 == null) goto L20;
        r13.dispose();
        return;
    L20:
        return;
    L10:
        this.downstream.onSuccess(r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (r13 == null) goto L15;
        r13.dispose();
    L15:
        throw th;
    L19:
        return;
    }

    @Override // io.reactivex.SingleEmitter
    public void setCancellable(Cancellable r10) {
        setDisposable(new CancellableDisposable(r10));
    }

    @Override // io.reactivex.SingleEmitter
    public void setDisposable(Disposable r10) {
        DisposableHelper.set(this, r10);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return String.format("%s{%s}", new Object[]{SingleCreate$Emitter.class.getSimpleName(), super.toString()});
    }

    @Override // io.reactivex.SingleEmitter
    public boolean tryOnError(Throwable r10) {
        if (r10 != null) goto L4;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L4:
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L17;
        Disposable r13 = getAndSet(r12);
        if (r13 == r12) goto L22;
        this.downstream.onError(r10);     // Catch: Throwable -> L13
        if (r13 == null) goto L21;
        r13.dispose();
        return true;
    L21:
        return true;
    L13:
        th = move-exception;
        if (r13 == null) goto L16;
        r13.dispose();
    L16:
        throw th;
    L22:
        return false;
    L17:
        return false;
    }
}
