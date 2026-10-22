package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableWithLatestFromMany$WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
    private static final long serialVersionUID = 1577321883966341961L;
    final Function<? super Object[], R> combiner;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicThrowable error;
    final AtomicLong requested;
    final FlowableWithLatestFromMany$WithLatestInnerSubscriber[] subscribers;
    final AtomicReference<Subscription> upstream;
    final AtomicReferenceArray<Object> values;

    public FlowableWithLatestFromMany$WithLatestFromSubscriber(Subscriber<? super R> r10, Function<? super Object[], R> r11, int r12) {
        this.downstream = r10;
        this.combiner = r11;
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] r13 = new FlowableWithLatestFromMany$WithLatestInnerSubscriber[r12];
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13[r14] = new FlowableWithLatestFromMany$WithLatestInnerSubscriber(this, r14);
        r14 = r14 + 1;
        goto L3
    L5:
        this.subscribers = r13;
        this.values = new AtomicReferenceArray(r12);
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].dispose();
        r12 = r12 + 1;
        goto L3
    }

    public void cancelAllBut(int r10) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] r11 = this.subscribers;
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L8;
        if (r12 == r10) goto L7;
        r11[r12].dispose();
    L7:
        r12 = r12 + 1;
        goto L4
    }

    public void innerComplete(int r10, boolean r11) {
        if (r11 == true) goto L5;
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        cancelAllBut(r10);
        io.reactivex.internal.util.d.b(this.downstream, this, this.error);
        return;
    }

    public void innerError(int r10, Throwable r11) {
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        cancelAllBut(r10);
        io.reactivex.internal.util.d.d(this.downstream, r11, this, this.error);
    }

    public void innerNext(int r10, Object r11) {
        this.values.set(r10, r11);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        cancelAllBut(-1);
        io.reactivex.internal.util.d.b(this.downstream, this, this.error);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        cancelAllBut(-1);
        io.reactivex.internal.util.d.d(this.downstream, r10, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (tryOnNext(r10) == false) goto L5;
        return;
    L5:
        if (this.done == true) goto L9;
        this.upstream.get().request(1);
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }

    public void subscribe(Publisher<?>[] r10, int r11) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] r12 = this.subscribers;
        AtomicReference<Subscription> r13 = this.upstream;
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L8;
        if (r13.get() == SubscriptionHelper.CANCELLED) goto L6;
        r10[r14].subscribe(r12[r14]);
        r14 = r14 + 1;
        goto L3
    L6:
        return;
    }

    @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
    public boolean tryOnNext(T r10) {
        if (this.done == false) goto L5;
        return false;
    L5:
        AtomicReferenceArray<Object> r11 = this.values;
        int r12 = r11.length();
        Object[] r13 = new Object[r12 + 1];
        r13[0] = r10;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L17;
        Object r15 = r11.get(r14);
        if (r15 == null) goto L9;
        r14 = r14 + 1;
        r13[r14] = r15;
        goto L6
    L9:
        return false;
    L17:
        io.reactivex.internal.util.d.f(this.downstream, io.reactivex.internal.functions.a.b(this.combiner.apply(r13), "The combiner returned a null value"), this, this.error);
        return true;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        onError(th);
        return false;
    }
}
