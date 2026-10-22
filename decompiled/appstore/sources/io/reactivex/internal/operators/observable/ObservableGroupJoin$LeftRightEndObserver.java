package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableGroupJoin$LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
    private static final long serialVersionUID = 1883890389173668373L;
    final int index;
    final boolean isLeft;
    final ObservableGroupJoin$JoinSupport parent;

    public ObservableGroupJoin$LeftRightEndObserver(ObservableGroupJoin$JoinSupport r10, boolean r11, int r12) {
        this.parent = r10;
        this.isLeft = r11;
        this.index = r12;
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
        this.parent.innerClose(this.isLeft, this);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.parent.innerCloseError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        if (DisposableHelper.dispose(this) == false) goto L6;
        this.parent.innerClose(this.isLeft, this);
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
