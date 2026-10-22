package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
    private static final long serialVersionUID = -4255299542215038287L;
    volatile boolean cancelled;
    volatile InnerQueuedSubscriber<R> current;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final AtomicLong requested;
    final io.reactivex.internal.queue.a subscribers;
    Subscription upstream;

    public FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> r10, Function<? super T, ? extends Publisher<? extends R>> r11, int r12, int r13, ErrorMode r14) {
        this.downstream = r10;
        this.mapper = r11;
        this.maxConcurrency = r12;
        this.prefetch = r13;
        this.errorMode = r14;
        this.subscribers = new io.reactivex.internal.queue.a(Math.min(r13, r12));
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        this.upstream.cancel();
        drainAndCancel();
    }

    public void cancelAll() {
        InnerQueuedSubscriber<R> r10 = this.current;
        this.current = null;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        InnerQueuedSubscriber r11 = (InnerQueuedSubscriber) this.subscribers.poll();
        if (r11 == null) goto L8;
        r11.cancel();
        goto L5
    }

    @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        InnerQueuedSubscriber<R> r10 = this.current;
        Subscriber<? super R> r11 = this.downstream;
        ErrorMode r12 = this.errorMode;
        int r13 = 1;
    L6:
        long r14 = this.requested.get();
        if (r10 == null) goto L9;
        r10 = r10;
    L25:
        if (r10 == null) goto L72;
        SimpleQueue<R> r15 = r10.queue();
        if (r15 == null) goto L72;
        long r16 = 0;
    L29:
        int r17 = r13;
        if (r16 == r14) goto L55;
        if (this.cancelled == true) goto L33;
        if (r12 == ErrorMode.IMMEDIATE) goto L38;
    L41:
        boolean r18 = r10.isDone();
        R r19 = r15.poll();     // Catch: Throwable -> L52
        if (r19 != null) goto L45;
        boolean r110 = true;
    L46:
        if (r18 == false) goto L49;
        if (r110 == false) goto L49;
        this.current = null;
        this.upstream.request(1);
        r10 = null;
        boolean r20 = true;
    L56:
        if (r16 == r14) goto L58;
    L71:
        long r21 = 0;
    L74:
        if (r16 != r21) goto L76;
    L78:
        if (r20 == true) goto L79;
        r13 = addAndGet(-r17);
        if (r13 != 0) goto L6;
        return;
    L79:
        r13 = r17;
        goto L6
    L76:
        if (r14 == Long.MAX_VALUE) goto L78;
        this.requested.addAndGet(-r16);
        goto L78
    L58:
        if (this.cancelled == true) goto L59;
        if (r12 == ErrorMode.IMMEDIATE) goto L64;
    L67:
        boolean r22 = r10.isDone();
        boolean r111 = r15.isEmpty();
        if (r22 == false) goto L71;
        if (r111 == false) goto L71;
        this.current = null;
        this.upstream.request(1);
        r10 = null;
        r20 = true;
        goto L71
    L64:
        if (this.errors.get() == null) goto L67;
        this.current = null;
        r10.cancel();
        cancelAll();
        r11.onError(this.errors.terminate());
        return;
    L59:
        cancelAll();
        return;
    L49:
        if (r110 == true) goto L55;
        r11.onNext(r19);
        r16 = r16 + 1;
        r10.requestOne();
        r13 = r17;
        goto L29
    L45:
        r110 = false;
    L52:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.current = null;
        r10.cancel();
        cancelAll();
        r11.onError(th);
        return;
    L38:
        if (this.errors.get() == null) goto L41;
        this.current = null;
        r10.cancel();
        cancelAll();
        r11.onError(this.errors.terminate());
        return;
    L33:
        cancelAll();
        return;
    L55:
        r20 = false;
    L72:
        r17 = r13;
        r20 = false;
        r21 = 0;
        r16 = 0;
        goto L74
    L9:
        if (r12 != ErrorMode.END) goto L11;
    L14:
        boolean r23 = this.done;
        r10 = (InnerQueuedSubscriber) this.subscribers.poll();
        if (r23 == false) goto L22;
        if (r10 != null) goto L22;
        Throwable r24 = this.errors.terminate();
        if (r24 == null) goto L20;
        r11.onError(r24);
        return;
    L20:
        r11.onComplete();
        return;
    L22:
        if (r10 == null) goto L25;
        this.current = r10;
        goto L25
    L11:
        if (this.errors.get() == null) goto L14;
        cancelAll();
        r11.onError(this.errors.terminate());
    }

    public void drainAndCancel() {
        if (getAndIncrement() != 0) goto L6;
    L4:
        cancelAll();
        if (decrementAndGet() != 0) goto L4;
        return;
    }

    @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
    public void innerComplete(InnerQueuedSubscriber<R> r10) {
        r10.setDone();
        drain();
    }

    @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
    public void innerError(InnerQueuedSubscriber<R> r10, Throwable r11) {
        if (this.errors.addThrowable(r11) == false) goto L8;
        r10.setDone();
        if (this.errorMode == ErrorMode.END) goto L7;
        this.upstream.cancel();
    L7:
        drain();
        return;
    L8:
        qf.a.e(r11);
    }

    @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
    public void innerNext(InnerQueuedSubscriber<R> r10, R r11) {
        if (r10.queue().offer(r11) == false) goto L5;
        drain();
        return;
    L5:
        r10.cancel();
        innerError(r10, new MissingBackpressureException());
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        Publisher r11 = (Publisher) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null Publisher");     // Catch: Throwable -> L10
        InnerQueuedSubscriber r12 = new InnerQueuedSubscriber(this, this.prefetch);
        if (this.cancelled == false) goto L6;
        return;
    L6:
        this.subscribers.offer(r12);
        r11.subscribe(r12);
        if (this.cancelled == false) goto L15;
        r12.cancel();
        drainAndCancel();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L10;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        int r11 = this.maxConcurrency;
        if (r11 != Integer.MAX_VALUE) goto L7;
        long r12 = Long.MAX_VALUE;
    L8:
        r10.request(r12);
        return;
    L7:
        r12 = r11;
        goto L8
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
        return;
    }
}
