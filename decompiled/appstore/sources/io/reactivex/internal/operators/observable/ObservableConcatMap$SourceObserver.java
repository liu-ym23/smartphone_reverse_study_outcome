package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableConcatMap$SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = 8828587559905699186L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean disposed;
    volatile boolean done;
    final Observer<? super U> downstream;
    int fusionMode;
    final InnerObserver<U> inner;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    SimpleQueue<T> queue;
    Disposable upstream;

    public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -7449079488798789337L;
        final Observer<? super U> downstream;
        final ObservableConcatMap$SourceObserver<?, ?> parent;

        public InnerObserver(Observer<? super U> r10, ObservableConcatMap$SourceObserver<?, ?> r11) {
            this.downstream = r10;
            this.parent = r11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r10) {
            this.parent.dispose();
            this.downstream.onError(r10);
        }

        @Override // io.reactivex.Observer
        public void onNext(U r10) {
            this.downstream.onNext(r10);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r10) {
            DisposableHelper.replace(this, r10);
        }
    }

    public ObservableConcatMap$SourceObserver(Observer<? super U> r10, Function<? super T, ? extends ObservableSource<? extends U>> r11, int r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.bufferSize = r12;
        this.inner = new InnerObserver(r10, this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposed = true;
        this.inner.dispose();
        this.upstream.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.disposed == true) goto L7;
        if (this.active == true) goto L31;
        boolean r10 = this.done;
        T r11 = this.queue.poll();     // Catch: Throwable -> L27
        if (r11 != null) goto L16;
        boolean r12 = true;
    L17:
        if (r10 == false) goto L21;
        if (r12 == false) goto L21;
        this.disposed = true;
        this.downstream.onComplete();
        return;
    L21:
        if (r12 == true) goto L31;
        ObservableSource r13 = (ObservableSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r11), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L24
        this.active = true;
        r13.subscribe(this.inner);
    L24:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dispose();
        this.queue.clear();
        this.downstream.onError(th);
        return;
    L16:
        r12 = false;
    L27:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dispose();
        this.queue.clear();
        this.downstream.onError(th);
        return;
    L31:
        if (decrementAndGet() != 0) goto L6;
        return;
    L7:
        this.queue.clear();
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        dispose();
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.fusionMode != 0) goto L8;
        this.queue.offer(r10);
    L8:
        drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof QueueDisposable) == false) goto L14;
        QueueDisposable r11 = (QueueDisposable) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.fusionMode = r12;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
        this.downstream.onSubscribe(this);
        return;
    }
}
