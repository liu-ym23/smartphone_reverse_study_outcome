package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableCombineLatest$CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
    private static final long serialVersionUID = -4823716997131257941L;
    final int index;
    final ObservableCombineLatest$LatestCoordinator<T, R> parent;

    public ObservableCombineLatest$CombinerObserver(ObservableCombineLatest$LatestCoordinator<T, R> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.parent.innerError(this.index, r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        this.parent.innerNext(this.index, r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
