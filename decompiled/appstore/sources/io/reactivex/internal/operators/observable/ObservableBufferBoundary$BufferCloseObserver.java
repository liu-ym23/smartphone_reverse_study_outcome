package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableBufferBoundary$BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final ObservableBufferBoundary$BufferBoundaryObserver<T, C, ?, ?> parent;

    public ObservableBufferBoundary$BufferCloseObserver(ObservableBufferBoundary$BufferBoundaryObserver<T, C, ?, ?> r10, long r11) {
        this.parent = r10;
        this.index = r11;
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

    @Override // io.reactivex.Observer
    public void onComplete() {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        this.parent.close(this, this.index);
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L5;
        lazySet(r12);
        this.parent.boundaryError(this, r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L6;
        lazySet(r12);
        r11.dispose();
        this.parent.close(this, this.index);
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
