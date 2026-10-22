package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableScanSeed$ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -1776795561228106469L;
    final BiFunction<R, ? super T, R> accumulator;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    Throwable error;
    final int limit;
    final int prefetch;
    final SimplePlainQueue<R> queue;
    final AtomicLong requested;
    Subscription upstream;
    R value;

    public FlowableScanSeed$ScanSeedSubscriber(Subscriber<? super R> r10, BiFunction<R, ? super T, R> r11, R r12, int r13) {
        this.downstream = r10;
        this.accumulator = r11;
        this.value = r12;
        this.prefetch = r13;
        this.limit = r13 - (r13 >> 2);
        SpscArrayQueue r14 = new SpscArrayQueue(r13);
        this.queue = r14;
        r14.offer(r12);
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super R> r10 = this.downstream;
        SimplePlainQueue<R> r11 = this.queue;
        int r12 = this.limit;
        int r13 = this.consumed;
        int r14 = 1;
    L6:
        long r15 = this.requested.get();
        long r16 = 0;
    L8:
        if (r16 == r15) goto L32;
        if (this.cancelled == true) goto L11;
        boolean r17 = this.done;
        if (r17 == false) goto L19;
        Throwable r18 = this.error;
        if (r18 == null) goto L19;
        r11.clear();
        r10.onError(r18);
        return;
    L19:
        R r19 = r11.poll();
        if (r19 != null) goto L22;
        boolean r110 = true;
    L23:
        if (r17 == false) goto L27;
        if (r110 == false) goto L27;
        r10.onComplete();
        return;
    L27:
        if (r110 == true) goto L32;
        r10.onNext(r19);
        r16 = r16 + 1;
        r13 = r13 + 1;
        if (r13 != r12) goto L8;
        this.upstream.request(r12);
        r13 = 0;
        goto L8
    L22:
        r110 = false;
        goto L23
    L11:
        r11.clear();
        return;
    L32:
        if (r16 != r15) goto L44;
        if (this.done == false) goto L44;
        Throwable r20 = this.error;
        if (r20 != null) goto L37;
        if (r11.isEmpty() == false) goto L44;
        r10.onComplete();
        return;
    L37:
        r11.clear();
        r10.onError(r20);
        return;
    L44:
        if (r16 == 0) goto L46;
        io.reactivex.internal.util.a.e(this.requested, r16);
    L46:
        this.consumed = r13;
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L6;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.error = r10;
        this.done = true;
        drain();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        R r11 = this.value;
        R r12 = (R) io.reactivex.internal.functions.a.b(this.accumulator.apply(r11, r10), "The accumulator returned a null value");
        this.value = r12;
        this.queue.offer(r12);
        drain();
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch - 1);
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
