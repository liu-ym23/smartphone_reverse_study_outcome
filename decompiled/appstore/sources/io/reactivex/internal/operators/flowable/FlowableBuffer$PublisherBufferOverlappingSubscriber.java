package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableBuffer$PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
    private static final long serialVersionUID = -7370244972039324525L;
    final Callable<C> bufferSupplier;
    final ArrayDeque<C> buffers;
    volatile boolean cancelled;
    boolean done;
    final Subscriber<? super C> downstream;
    int index;
    final AtomicBoolean once;
    long produced;
    final int size;
    final int skip;
    Subscription upstream;

    public FlowableBuffer$PublisherBufferOverlappingSubscriber(Subscriber<? super C> r10, int r11, int r12, Callable<C> r13) {
        this.downstream = r10;
        this.size = r11;
        this.skip = r12;
        this.bufferSupplier = r13;
        this.once = new AtomicBoolean();
        this.buffers = new ArrayDeque();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    @Override // io.reactivex.functions.BooleanSupplier
    public boolean getAsBoolean() {
        return this.cancelled;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        long r10 = this.produced;
        if (r10 == 0) goto L8;
        io.reactivex.internal.util.a.e(this, r10);
    L8:
        io.reactivex.internal.util.g.c(this.downstream, this.buffers, this, this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        this.buffers.clear();
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        ArrayDeque<C> r11 = this.buffers;
        int r12 = this.index;
        int r13 = r12 + 1;
        if (r12 == 0) goto L26;
    L12:
        C r14 = r11.peek();
        if (r14 != null) goto L15;
    L17:
        Iterator<C> r15 = r11.iterator();
    L19:
        if (r15.hasNext() == false) goto L22;
        r15.next().add(r10);
        goto L19
    L22:
        if (r13 != this.skip) goto L24;
        r13 = 0;
    L24:
        this.index = r13;
        return;
    L15:
        if ((r14.size() + 1) != this.size) goto L17;
        r11.poll();
        r14.add(r10);
        this.produced++;
        this.downstream.onNext(r14);
        goto L17
    L26:
        r11.offer((C) ((Collection) io.reactivex.internal.functions.a.b(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer")));
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        onError(th);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        if (io.reactivex.internal.util.g.e(r10, this.downstream, this.buffers, this, this) == false) goto L8;
        return;
    L8:
        if (this.once.get() == false) goto L10;
    L12:
        this.upstream.request(io.reactivex.internal.util.a.d(this.skip, r10));
        return;
    L10:
        if (this.once.compareAndSet(false, true) == false) goto L12;
        this.upstream.request(io.reactivex.internal.util.a.c(this.size, io.reactivex.internal.util.a.d(this.skip, r10 - 1)));
    }
}
