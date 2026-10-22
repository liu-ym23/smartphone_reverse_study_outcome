package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeCreate$Emitter<T> extends AtomicReference<Disposable> implements MaybeEmitter<T>, Disposable {
    private static final long serialVersionUID = -2467358622224974244L;
    final MaybeObserver<? super T> downstream;

    public MaybeCreate$Emitter(MaybeObserver<? super T> r10) {
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.MaybeEmitter, io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.MaybeEmitter
    public void onComplete() {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L13;
        Disposable r12 = getAndSet(r11);
        if (r12 == r11) goto L16;
        this.downstream.onComplete();     // Catch: Throwable -> L9
        if (r12 == null) goto L17;
        r12.dispose();
        return;
    L17:
        return;
    L9:
        th = move-exception;
        if (r12 == null) goto L12;
        r12.dispose();
    L12:
        throw th;
    L16:
        return;
    }

    @Override // io.reactivex.MaybeEmitter
    public void onError(Throwable r10) {
        if (tryOnError(r10) == true) goto L6;
        qf.a.e(r10);
        return;
    }

    @Override // io.reactivex.MaybeEmitter
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

    @Override // io.reactivex.MaybeEmitter
    public void setCancellable(Cancellable r10) {
        setDisposable(new CancellableDisposable(r10));
    }

    @Override // io.reactivex.MaybeEmitter
    public void setDisposable(Disposable r10) {
        DisposableHelper.set(this, r10);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return String.format("%s{%s}", new Object[]{MaybeCreate$Emitter.class.getSimpleName(), super.toString()});
    }

    @Override // io.reactivex.MaybeEmitter
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
