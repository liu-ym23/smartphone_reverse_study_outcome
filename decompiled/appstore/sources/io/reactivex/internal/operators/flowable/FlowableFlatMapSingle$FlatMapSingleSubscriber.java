package io.reactivex.internal.operators.flowable;

import androidx.lifecycle.p;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableFlatMapSingle$FlatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final boolean delayErrors;
    final Subscriber<? super R> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int maxConcurrency;
    final AtomicReference<io.reactivex.internal.queue.a> queue;
    final AtomicLong requested;
    final io.reactivex.disposables.a set;
    Subscription upstream;

    public final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
        private static final long serialVersionUID = -502562646270949838L;
        final /* synthetic */ FlowableFlatMapSingle$FlatMapSingleSubscriber this$0;

        public InnerObserver(FlowableFlatMapSingle$FlatMapSingleSubscriber r10) {
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

    public FlowableFlatMapSingle$FlatMapSingleSubscriber(Subscriber<? super R> r10, Function<? super T, ? extends SingleSource<? extends R>> r11, boolean r12, int r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.maxConcurrency = r13;
        this.requested = new AtomicLong();
        this.set = new io.reactivex.disposables.a();
        this.errors = new AtomicThrowable();
        this.active = new AtomicInteger(1);
        this.queue = new AtomicReference();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    public void clear() {
        io.reactivex.internal.queue.a r10 = this.queue.get();
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    public void drainLoop() {
        Subscriber<? super R> r10 = this.downstream;
        AtomicInteger r11 = this.active;
        AtomicReference<io.reactivex.internal.queue.a> r12 = this.queue;
        int r13 = 1;
    L3:
        long r14 = this.requested.get();
        long r15 = 0;
    L4:
        boolean r16 = false;
        if (r15 == r14) goto L37;
        if (this.cancelled == true) goto L8;
        if (this.delayErrors == true) goto L17;
        if (this.errors.get() == null) goto L17;
        Throwable r17 = this.errors.terminate();
        clear();
        r10.onError(r17);
        return;
    L17:
        if (r11.get() != 0) goto L19;
        boolean r18 = true;
    L20:
        io.reactivex.internal.queue.a r19 = r12.get();
        if (r19 == null) goto L23;
        Object r110 = r19.poll();
    L24:
        if (r110 != null) goto L26;
        boolean r111 = true;
    L27:
        if (r18 == false) goto L34;
        if (r111 == false) goto L34;
        Throwable r20 = this.errors.terminate();
        if (r20 == null) goto L32;
        r10.onError(r20);
        return;
    L32:
        r10.onComplete();
        return;
    L34:
        if (r111 == true) goto L37;
        r10.onNext(r110);
        r15 = r15 + 1;
        goto L4
    L26:
        r111 = false;
        goto L27
    L23:
        r110 = null;
        goto L24
    L19:
        r18 = false;
        goto L20
    L8:
        clear();
        return;
    L37:
        if (r15 != r14) goto L65;
        if (this.cancelled == true) goto L40;
        if (this.delayErrors == true) goto L49;
        if (this.errors.get() == null) goto L49;
        Throwable r21 = this.errors.terminate();
        clear();
        r10.onError(r21);
        return;
    L49:
        if (r11.get() != 0) goto L51;
        boolean r22 = true;
    L52:
        io.reactivex.internal.queue.a r23 = r12.get();
        if (r23 != null) goto L55;
    L56:
        r16 = true;
    L57:
        if (r22 == false) goto L65;
        if (r16 == false) goto L65;
        Throwable r24 = this.errors.terminate();
        if (r24 == null) goto L62;
        r10.onError(r24);
        return;
    L62:
        r10.onComplete();
        return;
    L55:
        if (r23.isEmpty() == false) goto L57;
    L51:
        r22 = false;
        goto L52
    L40:
        clear();
        return;
    L65:
        if (r15 == 0) goto L69;
        io.reactivex.internal.util.a.e(this.requested, r15);
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L69;
        this.upstream.request(r15);
    L69:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L3;
    }

    public io.reactivex.internal.queue.a getOrCreateQueue() {
    L2:
        io.reactivex.internal.queue.a r10 = this.queue.get();
        if (r10 != null) goto L4;
        io.reactivex.internal.queue.a r11 = new io.reactivex.internal.queue.a(mf.b.a());
        if (p.a(this.queue, null, r11) == false) goto L2;
        return r11;
    L4:
        return r10;
    }

    public void innerError(FlowableFlatMapSingle$FlatMapSingleSubscriber<T, R>.InnerObserver r10, Throwable r11) {
        this.set.delete(r10);
        if (this.errors.addThrowable(r11) == true) goto L5;
        qf.a.e(r11);
        return;
    L5:
        if (this.delayErrors == true) goto L8;
        this.upstream.cancel();
        this.set.dispose();
    L10:
        this.active.decrementAndGet();
        drain();
        return;
    L8:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L10;
        this.upstream.request(1);
        goto L10
    }

    public void innerSuccess(FlowableFlatMapSingle$FlatMapSingleSubscriber<T, R>.InnerObserver r10, R r11) {
        this.set.delete(r10);
        if (get() != 0) goto L34;
        boolean r12 = false;
        if (compareAndSet(0, 1) == false) goto L34;
        if (this.active.decrementAndGet() != 0) goto L10;
        r12 = true;
    L10:
        if (this.requested.get() == 0) goto L24;
        this.downstream.onNext(r11);
        io.reactivex.internal.queue.a r13 = this.queue.get();
        if (r12 == false) goto L21;
        if (r13 != null) goto L15;
    L16:
        Throwable r14 = this.errors.terminate();
        if (r14 == null) goto L19;
        this.downstream.onError(r14);
        return;
    L19:
        this.downstream.onComplete();
        return;
    L15:
        if (r13.isEmpty() == true) goto L16;
    L21:
        io.reactivex.internal.util.a.e(this.requested, 1);
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L29;
        this.upstream.request(1);
    L29:
        if (decrementAndGet() != 0) goto L41;
        return;
    L41:
        drainLoop();
        return;
    L24:
        io.reactivex.internal.queue.a r15 = getOrCreateQueue();
        monitor-enter(r15);
        r15.offer(r11);     // Catch: Throwable -> L31
        monitor-exit(r15);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L34:
        io.reactivex.internal.queue.a r16 = getOrCreateQueue();
        monitor-enter(r16);
        r16.offer(r11);     // Catch: Throwable -> L43
        monitor-exit(r16);     // Catch: Throwable -> L43
        this.active.decrementAndGet();
        if (getAndIncrement() == 0) goto L41;
        return;
    L43:
        th = move-exception;
        throw th;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
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

    @Override // org.reactivestreams.Subscriber
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
        this.upstream.cancel();
        onError(th);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L9;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        int r11 = this.maxConcurrency;
        if (r11 != Integer.MAX_VALUE) goto L7;
        r10.request(Long.MAX_VALUE);
        return;
    L7:
        r10.request(r11);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
        return;
    }
}
