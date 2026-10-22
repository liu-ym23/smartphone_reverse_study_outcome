package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableConcatWithSingle$ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {
    private static final long serialVersionUID = -1953724749712440952L;
    final Observer<? super T> downstream;
    boolean inSingle;
    SingleSource<? extends T> other;

    public ObservableConcatWithSingle$ConcatWithObserver(Observer<? super T> r10, SingleSource<? extends T> r11) {
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
        this.inSingle = true;
        DisposableHelper.replace(this, null);
        SingleSource<? extends T> r10 = this.other;
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
        if (this.inSingle == true) goto L9;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        this.downstream.onNext(r10);
        this.downstream.onComplete();
    }
}
