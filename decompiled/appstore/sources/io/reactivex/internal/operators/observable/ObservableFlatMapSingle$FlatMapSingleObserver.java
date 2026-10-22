package io.reactivex.internal.operators.observable;

import androidx.lifecycle.p;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableFlatMapSingle$FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final boolean delayErrors;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final AtomicReference<io.reactivex.internal.queue.a> queue;
    final io.reactivex.disposables.a set;
    Disposable upstream;

    public final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
        private static final long serialVersionUID = -502562646270949838L;
        final /* synthetic */ ObservableFlatMapSingle$FlatMapSingleObserver this$0;

        public InnerObserver(ObservableFlatMapSingle$FlatMapSingleObserver r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r10) {
            this.this$0.innerError(this, r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(R r10) {
            this.this$0.innerSuccess(this, r10);
        }
    }

    public ObservableFlatMapSingle$FlatMapSingleObserver(Observer<? super R> r10, Function<? super T, ? extends SingleSource<? extends R>> r11, boolean r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.set = new io.reactivex.disposables.a();
        this.errors = new AtomicThrowable();
        this.active = new AtomicInteger(1);
        this.queue = new AtomicReference();
    }

    public void clear() {
        io.reactivex.internal.queue.a r10 = this.queue.get();
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    public void drainLoop() {
        Observer<? super R> r10 = this.downstream;
        AtomicInteger r11 = this.active;
        AtomicReference<io.reactivex.internal.queue.a> r12 = this.queue;
        int r13 = 1;
    L4:
        if (this.cancelled == true) goto L5;
        if (this.delayErrors == false) goto L10;
    L13:
        boolean r14 = false;
        if (r11.get() != 0) goto L16;
        boolean r15 = true;
    L17:
        io.reactivex.internal.queue.a r16 = r12.get();
        if (r16 == null) goto L20;
        Object r17 = r16.poll();
    L21:
        if (r17 != null) goto L23;
        r14 = true;
    L23:
        if (r15 == false) goto L30;
        if (r14 == false) goto L30;
        Throwable r18 = this.errors.terminate();
        if (r18 == null) goto L28;
        r10.onError(r18);
        return;
    L28:
        r10.onComplete();
        return;
    L30:
        if (r14 == true) goto L31;
        r10.onNext(r17);
        goto L4
    L31:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L4;
        return;
    L20:
        r17 = null;
        goto L21
    L16:
        r15 = false;
        goto L17
    L10:
        if (this.errors.get() == null) goto L13;
        Throwable r19 = this.errors.terminate();
        clear();
        r10.onError(r19);
        return;
    L5:
        clear();
    }

    public io.reactivex.internal.queue.a getOrCreateQueue() {
    L2:
        io.reactivex.internal.queue.a r10 = this.queue.get();
        if (r10 != null) goto L4;
        io.reactivex.internal.queue.a r11 = new io.reactivex.internal.queue.a(mf.e.a());
        if (p.a(this.queue, null, r11) == false) goto L2;
        return r11;
    L4:
        return r10;
    }

    public void innerError(ObservableFlatMapSingle$FlatMapSingleObserver<T, R>.InnerObserver r10, Throwable r11) {
        this.set.delete(r10);
        if (this.errors.addThrowable(r11) == true) goto L5;
        qf.a.e(r11);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        this.upstream.dispose();
        this.set.dispose();
    L7:
        this.active.decrementAndGet();
        drain();
    }

    public void innerSuccess(ObservableFlatMapSingle$FlatMapSingleObserver<T, R>.InnerObserver r10, R r11) {
        this.set.delete(r10);
        if (get() != 0) goto L22;
        boolean r12 = false;
        if (compareAndSet(0, 1) == false) goto L22;
        this.downstream.onNext(r11);
        if (this.active.decrementAndGet() != 0) goto L9;
        r12 = true;
    L9:
        io.reactivex.internal.queue.a r13 = this.queue.get();
        if (r12 == false) goto L20;
        if (r13 != null) goto L13;
    L14:
        Throwable r14 = this.errors.terminate();
        if (r14 == null) goto L17;
        this.downstream.onError(r14);
        return;
    L17:
        this.downstream.onComplete();
        return;
    L13:
        if (r13.isEmpty() == true) goto L14;
    L20:
        if (decrementAndGet() != 0) goto L29;
        return;
    L29:
        drainLoop();
        return;
    L22:
        io.reactivex.internal.queue.a r15 = getOrCreateQueue();
        monitor-enter(r15);
        r15.offer(r11);     // Catch: Throwable -> L31
        monitor-exit(r15);     // Catch: Throwable -> L31
        this.active.decrementAndGet();
        if (getAndIncrement() == 0) goto L29;
        return;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.active.decrementAndGet();
        if (this.errors.addThrowable(r10) == true) goto L5;
        qf.a.e(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        this.set.dispose();
    L7:
        drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        SingleSource r11 = (SingleSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null SingleSource");     // Catch: Throwable -> L9
        this.active.getAndIncrement();
        InnerObserver r12 = new InnerObserver(this);
        if (this.cancelled == false) goto L6;
        return;
    L6:
        if (this.set.add(r12) == false) goto L15;
        r11.subscribe(r12);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
