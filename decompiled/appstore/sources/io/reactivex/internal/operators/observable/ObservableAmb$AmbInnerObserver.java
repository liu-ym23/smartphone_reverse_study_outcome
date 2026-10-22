package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableAmb$AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
    private static final long serialVersionUID = -1185974347409665484L;
    final Observer<? super T> downstream;
    final int index;
    final b parent;
    boolean won;

    public ObservableAmb$AmbInnerObserver(b r10, int r11, Observer<? super T> r12) {
        this.index = r11;
        this.downstream = r12;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.won == false) goto L7;
        this.downstream.onComplete();
        return;
    L7:
        throw null;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.won == false) goto L7;
        this.downstream.onError(r10);
        return;
    L7:
        throw null;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (this.won == false) goto L7;
        this.downstream.onNext(r10);
        return;
    L7:
        throw null;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
