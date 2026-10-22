package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableFlatMap$InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
    private static final long serialVersionUID = -4606175640614850599L;
    volatile boolean done;
    int fusionMode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    final long f20665id;
    final ObservableFlatMap$MergeObserver<T, U> parent;
    volatile SimpleQueue<U> queue;

    public ObservableFlatMap$InnerObserver(ObservableFlatMap$MergeObserver<T, U> r10, long r11) {
        this.f20665id = r11;
        this.parent = r10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.parent.errors.addThrowable(r10) == false) goto L8;
        ObservableFlatMap$MergeObserver<T, U> r11 = this.parent;
        if (r11.delayErrors == true) goto L7;
        r11.disposeAll();
    L7:
        this.done = true;
        this.parent.drain();
        return;
    L8:
        qf.a.e(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(U r10) {
        if (this.fusionMode != 0) goto L5;
        this.parent.tryEmit(r10, this);
        return;
    L5:
        this.parent.drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof QueueDisposable) == false) goto L15;
        QueueDisposable r11 = (QueueDisposable) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.parent.drain();
        return;
    L11:
        if (r12 != 2) goto L16;
        this.fusionMode = r12;
        this.queue = r11;
        return;
    L16:
        return;
    }
}
