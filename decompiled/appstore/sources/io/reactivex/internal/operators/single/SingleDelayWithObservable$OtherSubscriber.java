package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class SingleDelayWithObservable$OtherSubscriber<T, U> extends AtomicReference<Disposable> implements Observer<U>, Disposable {
    private static final long serialVersionUID = -8565274649390031272L;
    boolean done;
    final SingleObserver<? super T> downstream;
    final SingleSource<T> source;

    public SingleDelayWithObservable$OtherSubscriber(SingleObserver<? super T> r10, SingleSource<T> r11) {
        this.downstream = r10;
        this.source = r11;
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
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.source.subscribe(new io.reactivex.internal.observers.a(this, this.downstream));
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(U r10) {
        get().dispose();
        onComplete();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.set(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }
}
