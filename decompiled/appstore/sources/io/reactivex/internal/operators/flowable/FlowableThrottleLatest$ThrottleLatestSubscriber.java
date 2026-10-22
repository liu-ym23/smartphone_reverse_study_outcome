package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableThrottleLatest$ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    final boolean emitLast;
    long emitted;
    Throwable error;
    final AtomicReference<T> latest;
    final AtomicLong requested;
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    Subscription upstream;
    final mf.f.a worker;

    public FlowableThrottleLatest$ThrottleLatestSubscriber(Subscriber<? super T> r10, long r11, TimeUnit r12, mf.f.a r13, boolean r14) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.emitLast = r14;
        this.latest = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        throw null;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<T> r10 = this.latest;
        AtomicLong r11 = this.requested;
        Subscriber<? super T> r12 = this.downstream;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r14 = this.done;
        if (r14 == false) goto L18;
        if (this.error == null) goto L18;
        r10.lazySet(null);
        r12.onError(this.error);
        throw null;
    L18:
        if (r10.get() != null) goto L20;
        boolean r15 = true;
    L22:
        if (r14 == true) goto L23;
        if (r15 == false) goto L37;
        if (this.timerFired == false) goto L41;
        this.timerRunning = false;
        this.timerFired = false;
    L41:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L37:
        if (this.timerRunning == false) goto L44;
        if (this.timerFired == false) goto L41;
    L44:
        T r16 = r10.getAndSet(null);
        long r17 = this.emitted;
        if (r17 == r11.get()) goto L48;
        r12.onNext(r16);
        this.emitted = r17 + 1;
        this.timerFired = false;
        this.timerRunning = true;
        throw null;
    L48:
        this.upstream.cancel();
        r12.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        throw null;
    L23:
        if (r15 == false) goto L25;
    L30:
        r10.lazySet(null);
        r12.onComplete();
        throw null;
    L25:
        if (this.emitLast == false) goto L30;
        T r18 = r10.getAndSet(null);
        long r19 = this.emitted;
        if (r19 == r11.get()) goto L29;
        this.emitted = r19 + 1;
        r12.onNext(r18);
        r12.onComplete();
        throw null;
    L29:
        r12.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
        throw null;
    L20:
        r15 = false;
        goto L22
    L8:
        r10.lazySet(null);
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
        this.latest.set(r10);
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
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.timerFired = true;
        drain();
    }
}
