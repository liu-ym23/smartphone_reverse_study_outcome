package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableTimeout$TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final ObservableTimeout$TimeoutSelectorSupport parent;

    public ObservableTimeout$TimeoutConsumer(long r10, ObservableTimeout$TimeoutSelectorSupport r11) {
        this.idx = r10;
        this.parent = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L5;
        lazySet(r12);
        this.parent.onTimeoutError(this.idx, r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        Disposable r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L6;
        r11.dispose();
        lazySet(r12);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
