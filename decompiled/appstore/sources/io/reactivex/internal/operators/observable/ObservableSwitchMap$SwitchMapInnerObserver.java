package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableSwitchMap$SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    final long index;
    final ObservableSwitchMap$SwitchMapObserver<T, R> parent;
    volatile SimpleQueue<R> queue;

    public ObservableSwitchMap$SwitchMapInnerObserver(ObservableSwitchMap$SwitchMapObserver<T, R> r10, long r11, int r12) {
        this.parent = r10;
        this.index = r11;
        this.bufferSize = r12;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.index != this.parent.unique) goto L6;
        this.done = true;
        this.parent.drain();
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.parent.innerError(this, r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(R r10) {
        if (this.index != this.parent.unique) goto L8;
        if (r10 == null) goto L6;
        this.queue.offer(r10);
    L6:
        this.parent.drain();
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof QueueDisposable) == false) goto L14;
        QueueDisposable r11 = (QueueDisposable) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.queue = r11;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.queue = r11;
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
    }
}
