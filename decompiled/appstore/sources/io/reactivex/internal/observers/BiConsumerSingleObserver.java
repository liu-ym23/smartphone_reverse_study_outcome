package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = 4943102778943297569L;
    final BiConsumer<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> r10) {
        this.onCallback = r10;
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

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r10) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(null, r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(r10, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
    }
}
