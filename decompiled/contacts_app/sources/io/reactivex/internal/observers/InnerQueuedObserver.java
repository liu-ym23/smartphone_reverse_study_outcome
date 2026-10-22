package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final InnerQueuedObserverSupport<T> parent;
    final int prefetch;
    SimpleQueue<T> queue;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> r1, int r2) {
        this.parent = r1;
        this.prefetch = r2;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r3) {
        if (DisposableHelper.setOnce(this, r3) == true) goto L5;
        return;
    L5:
        if ((r3 instanceof QueueDisposable) == false) goto L14;
        QueueDisposable r4 = (QueueDisposable) r3;
        int r0 = r4.requestFusion(3);
        if (r0 != 1) goto L11;
        this.fusionMode = r0;
        this.queue = r4;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r0 != 2) goto L14;
        this.fusionMode = r0;
        this.queue = r4;
        return;
    L14:
        this.queue = QueueDrainHelper.createQueue(-this.prefetch);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r2) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r2);
        return;
    L5:
        this.parent.drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r2) {
        this.parent.innerError(this, r2);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone() {
        this.done = true;
    }

    public SimpleQueue<T> queue() {
        return this.queue;
    }

    public int fusionMode() {
        return this.fusionMode;
    }
}
