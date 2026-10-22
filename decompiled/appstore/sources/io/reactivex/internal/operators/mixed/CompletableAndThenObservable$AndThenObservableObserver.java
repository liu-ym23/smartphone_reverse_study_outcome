package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableAndThenObservable$AndThenObservableObserver<R> extends AtomicReference<Disposable> implements Observer<R>, CompletableObserver, Disposable {
    private static final long serialVersionUID = -8948264376121066672L;
    final Observer<? super R> downstream;
    ObservableSource<? extends R> other;

    public CompletableAndThenObservable$AndThenObservableObserver(Observer<? super R> r10, ObservableSource<? extends R> r11) {
        this.other = r11;
        this.downstream = r10;
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
        ObservableSource<? extends R> r10 = this.other;
        if (r10 != null) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.other = null;
        r10.subscribe(this);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(R r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.replace(this, r10);
    }
}
