package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableTakeLast$TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
    private static final long serialVersionUID = 7240042530241604978L;
    volatile boolean cancelled;
    final int count;
    final Observer<? super T> downstream;
    Disposable upstream;

    public ObservableTakeLast$TakeLastObserver(Observer<? super T> r10, int r11) {
        this.downstream = r10;
        this.count = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.upstream.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Observer<? super T> r10 = this.downstream;
    L4:
        if (this.cancelled == true) goto L5;
        T r11 = poll();
        if (r11 == null) goto L9;
        r10.onNext(r11);
        goto L4
    L9:
        if (this.cancelled == true) goto L15;
        r10.onComplete();
        return;
    L15:
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (this.count != size()) goto L5;
        poll();
    L5:
        offer(r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
