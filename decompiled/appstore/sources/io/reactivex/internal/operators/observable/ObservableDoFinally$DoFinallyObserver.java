package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableDoFinally$DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    final Observer<? super T> downstream;
    final Action onFinally;

    /* JADX INFO: renamed from: qd, reason: collision with root package name */
    QueueDisposable<T> f20664qd;
    boolean syncFused;
    Disposable upstream;

    public ObservableDoFinally$DoFinallyObserver(Observer<? super T> r10, Action r11) {
        this.downstream = r10;
        this.onFinally = r11;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.f20664qd.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        runFinally();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.f20664qd.isEmpty();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        runFinally();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L9;
        this.upstream = r10;
        if ((r10 instanceof QueueDisposable) == false) goto L7;
        this.f20664qd = (QueueDisposable) r10;
    L7:
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() throws Exception {
        T r10 = this.f20664qd.poll();
        if (r10 == null) goto L5;
    L7:
        return r10;
    L5:
        if (this.syncFused == false) goto L7;
        runFinally();
        goto L7
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        QueueDisposable<T> r11 = this.f20664qd;
        boolean r12 = false;
        if (r11 != null) goto L5;
    L13:
        return 0;
    L5:
        if ((r10 & 4) != 0) goto L13;
        int r13 = r11.requestFusion(r10);
        if (r13 != 0) goto L9;
    L12:
        return r13;
    L9:
        if (r13 != 1) goto L11;
        r12 = true;
    L11:
        this.syncFused = r12;
        goto L12
    }

    public void runFinally() {
        if (compareAndSet(0, 1) == false) goto L11;
        this.onFinally.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        return;
    }
}
