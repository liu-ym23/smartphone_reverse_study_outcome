package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableOnBackpressureLatest$BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 163080509307634843L;
    volatile boolean cancelled;
    final AtomicReference<T> current;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    Throwable error;
    final AtomicLong requested;
    Subscription upstream;

    public FlowableOnBackpressureLatest$BackpressureLatestSubscriber(Subscriber<? super T> r10) {
        this.requested = new AtomicLong();
        this.current = new AtomicReference();
        this.downstream = r10;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.current.lazySet(null);
        return;
    L9:
        return;
    }

    public boolean checkTerminated(boolean r10, boolean r11, Subscriber<?> r12, AtomicReference<T> r13) {
        if (this.cancelled == false) goto L6;
        r13.lazySet(null);
        return true;
    L6:
        if (r10 == false) goto L14;
        Throwable r14 = this.error;
        if (r14 == null) goto L11;
        r13.lazySet(null);
        r12.onError(r14);
        return true;
    L11:
        if (r11 == false) goto L16;
        r12.onComplete();
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super T> r10 = this.downstream;
        AtomicLong r11 = this.requested;
        AtomicReference<T> r12 = this.current;
        int r13 = 1;
    L6:
        long r14 = 0;
    L7:
        boolean r15 = false;
        if (r14 == r11.get()) goto L20;
        boolean r16 = this.done;
        T r17 = r12.getAndSet(null);
        if (r17 != null) goto L12;
        boolean r18 = true;
    L14:
        if (checkTerminated(r16, r18, r10, r12) == true) goto L15;
        if (r18 == true) goto L20;
        r10.onNext(r17);
        r14 = r14 + 1;
        goto L7
    L15:
        return;
    L12:
        r18 = false;
    L20:
        if (r14 != r11.get()) goto L28;
        boolean r19 = this.done;
        if (r12.get() != null) goto L25;
        r15 = true;
    L25:
        if (checkTerminated(r19, r15, r10, r12) == false) goto L28;
        return;
    L28:
        if (r14 == 0) goto L30;
        io.reactivex.internal.util.a.e(r11, r14);
    L30:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L6;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.current.lazySet(r10);
        drain();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
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
