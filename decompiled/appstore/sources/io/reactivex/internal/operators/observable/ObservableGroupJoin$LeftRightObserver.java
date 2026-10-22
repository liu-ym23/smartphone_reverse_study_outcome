package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableGroupJoin$LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
    private static final long serialVersionUID = 1883890389173668373L;
    final boolean isLeft;
    final ObservableGroupJoin$JoinSupport parent;

    public ObservableGroupJoin$LeftRightObserver(ObservableGroupJoin$JoinSupport r10, boolean r11) {
        this.parent = r10;
        this.isLeft = r11;
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
        this.parent.innerComplete(this);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.parent.innerError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        this.parent.innerValue(this.isLeft, r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
