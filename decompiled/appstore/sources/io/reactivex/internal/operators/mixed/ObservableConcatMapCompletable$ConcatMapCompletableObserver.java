package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.a;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    volatile boolean disposed;
    volatile boolean done;
    final CompletableObserver downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapInnerObserver inner;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int prefetch;
    SimpleQueue<T> queue;
    Disposable upstream;

    public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
        private static final long serialVersionUID = 5638352172918776687L;
        final ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        public ConcatMapInnerObserver(ObservableConcatMapCompletable$ConcatMapCompletableObserver<?> r10) {
            this.parent = r10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r10) {
            this.parent.innerError(r10);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.replace(this, r10);
        }
    }

    public ObservableConcatMapCompletable$ConcatMapCompletableObserver(CompletableObserver r10, Function<? super T, ? extends CompletableSource> r11, ErrorMode r12, int r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.errorMode = r12;
        this.prefetch = r13;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapInnerObserver(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.inner.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicThrowable r10 = this.errors;
        ErrorMode r11 = this.errorMode;
    L7:
        if (this.disposed == true) goto L8;
        if (this.active == true) goto L38;
        if (r11 == ErrorMode.BOUNDARY) goto L15;
    L18:
        boolean r12 = this.done;
        T r13 = this.queue.poll();     // Catch: Throwable -> L23
        if (r13 == null) goto L25;
        CompletableSource r14 = (CompletableSource) a.b(this.mapper.apply(r13), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L23
        boolean r15 = false;
    L26:
        if (r12 == false) goto L33;
        if (r15 == false) goto L33;
        this.disposed = true;
        Throwable r16 = r10.terminate();
        if (r16 == null) goto L31;
        this.downstream.onError(r16);
        return;
    L31:
        this.downstream.onComplete();
        return;
    L33:
        if (r15 == true) goto L38;
        this.active = true;
        r14.subscribe(this.inner);
        goto L38
    L25:
        r14 = null;
        r15 = true;
    L23:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.disposed = true;
        this.queue.clear();
        this.upstream.dispose();
        r10.addThrowable(th);
        this.downstream.onError(r10.terminate());
        return;
    L15:
        if (r10.get() == null) goto L18;
        this.disposed = true;
        this.queue.clear();
        this.downstream.onError(r10.terminate());
        return;
    L38:
        if (decrementAndGet() != 0) goto L7;
        return;
    L8:
        this.queue.clear();
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        qf.a.e(r10);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.disposed = true;
        this.upstream.dispose();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f20726a) goto L10;
        this.downstream.onError(r11);
    L10:
        if (getAndIncrement() != 0) goto L15;
        this.queue.clear();
        return;
    L15:
        return;
    L12:
        this.active = false;
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        qf.a.e(r10);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.disposed = true;
        this.inner.dispose();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f20726a) goto L10;
        this.downstream.onError(r11);
    L10:
        if (getAndIncrement() != 0) goto L15;
        this.queue.clear();
        return;
    L15:
        return;
    L12:
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (r10 == null) goto L4;
        this.queue.offer(r10);
    L4:
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
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.a(this.prefetch);
        this.downstream.onSubscribe(this);
        return;
    }
}
