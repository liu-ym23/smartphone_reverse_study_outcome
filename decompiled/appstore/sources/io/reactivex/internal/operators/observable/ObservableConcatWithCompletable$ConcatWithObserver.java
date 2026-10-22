package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableConcatWithCompletable$ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {
    private static final long serialVersionUID = -1953724749712440952L;
    final Observer<? super T> downstream;
    boolean inCompletable;
    CompletableSource other;

    public ObservableConcatWithCompletable$ConcatWithObserver(Observer<? super T> r10, CompletableSource r11) {
        this.downstream = r10;
        this.other = r11;
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
        if (this.inCompletable == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.inCompletable = true;
        DisposableHelper.replace(this, null);
        CompletableSource r10 = this.other;
        this.other = null;
        r10.subscribe(this);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if (this.inCompletable == true) goto L9;
        this.downstream.onSubscribe(this);
        return;
    }
}
