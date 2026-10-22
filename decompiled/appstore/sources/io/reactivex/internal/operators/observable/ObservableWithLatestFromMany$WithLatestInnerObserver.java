package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableWithLatestFromMany$WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final ObservableWithLatestFromMany$WithLatestFromObserver<?, ?> parent;

    public ObservableWithLatestFromMany$WithLatestInnerObserver(ObservableWithLatestFromMany$WithLatestFromObserver<?, ?> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.parent.innerError(this.index, r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        if (this.hasValue == true) goto L5;
        this.hasValue = true;
    L5:
        this.parent.innerNext(this.index, r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
