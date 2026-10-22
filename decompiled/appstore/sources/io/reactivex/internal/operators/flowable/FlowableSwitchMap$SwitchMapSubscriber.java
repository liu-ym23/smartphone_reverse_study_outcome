package io.reactivex.internal.operators.flowable;

import androidx.lifecycle.p;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableSwitchMap$SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    static final FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> CANCELLED = null;
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> active;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicThrowable error;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final AtomicLong requested;
    volatile long unique;
    Subscription upstream;

    static {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> r10 = new FlowableSwitchMap$SwitchMapInnerSubscriber(null, -1, 1);
        CANCELLED = r10;
        r10.cancel();
    }

    public FlowableSwitchMap$SwitchMapSubscriber(Subscriber<? super R> r10, Function<? super T, ? extends Publisher<? extends R>> r11, int r12, boolean r13) {
        this.active = new AtomicReference();
        this.requested = new AtomicLong();
        this.downstream = r10;
        this.mapper = r11;
        this.bufferSize = r12;
        this.delayErrors = r13;
        this.error = new AtomicThrowable();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.upstream.cancel();
        disposeInner();
        return;
    }

    public void disposeInner() {
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r10 = this.active.get();
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> r11 = CANCELLED;
        if (r10 == r11) goto L9;
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r12 = this.active.getAndSet((FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>) r11);
        if (r12 == r11) goto L10;
        if (r12 == null) goto L11;
        r12.cancel();
        return;
    L11:
        return;
    L10:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super R> r10 = this.downstream;
        int r11 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (this.done == true) goto L13;
    L29:
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r12 = this.active.get();
        if (r12 == null) goto L32;
        SimpleQueue<R> r13 = r12.queue;
    L33:
        if (r13 == null) goto L89;
        if (r12.done == false) goto L48;
        if (this.delayErrors == false) goto L39;
        if (r13.isEmpty() == false) goto L48;
        p.a(this.active, r12, null);
        goto L7
    L39:
        if (this.error.get() != null) goto L40;
        if (r13.isEmpty() == false) goto L48;
        p.a(this.active, r12, null);
        goto L7
    L40:
        disposeInner();
        r10.onError(this.error.terminate());
        return;
    L48:
        long r14 = this.requested.get();
        long r15 = 0;
    L49:
        boolean r16 = false;
        if (r15 == r14) goto L80;
        if (this.cancelled == true) goto L53;
        boolean r17 = r12.done;
        a3.a r18 = r13.poll();     // Catch: Throwable -> L57
    L59:
        if (r18 != null) goto L61;
        boolean r19 = true;
    L63:
        if (r12 != this.active.get()) goto L64;
        if (r17 == true) goto L67;
    L76:
        if (r19 == true) goto L80;
        r10.onNext(r18);
        r15 = r15 + 1;
        goto L49
    L67:
        if (this.delayErrors == false) goto L69;
        if (r19 == false) goto L76;
        p.a(this.active, r12, null);
        goto L64
    L69:
        if (this.error.get() != null) goto L70;
        if (r19 == false) goto L76;
        p.a(this.active, r12, null);
        goto L64
    L70:
        r10.onError(this.error.terminate());
        return;
    L64:
        r16 = true;
        goto L80
    L61:
        r19 = false;
    L57:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r12.cancel();
        this.error.addThrowable(th);
        r18 = null;
        r17 = true;
        goto L59
    L53:
        return;
    L80:
        if (r15 != 0) goto L82;
    L87:
        if (r16 == false) goto L89;
    L82:
        if (this.cancelled == true) goto L87;
        if (r14 == Long.MAX_VALUE) goto L86;
        this.requested.addAndGet(-r15);
    L86:
        r12.request(r15);
    L89:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L7;
        return;
    L32:
        r13 = null;
        goto L33
    L13:
        if (this.delayErrors == false) goto L22;
        if (this.active.get() != null) goto L29;
        if (this.error.get() == null) goto L19;
        r10.onError(this.error.terminate());
        return;
    L19:
        r10.onComplete();
        return;
    L22:
        if (this.error.get() != null) goto L23;
        if (this.active.get() != null) goto L29;
        r10.onComplete();
        return;
    L23:
        disposeInner();
        r10.onError(this.error.terminate());
        return;
    L8:
        this.active.lazySet(null);
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
        if (this.done == false) goto L5;
    L10:
        qf.a.e(r10);
        return;
    L5:
        if (this.error.addThrowable(r10) == false) goto L10;
        if (this.delayErrors == true) goto L9;
        disposeInner();
    L9:
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r11 = this.unique + 1;
        this.unique = r11;
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r12 = this.active.get();
        if (r12 == null) goto L20;
        r12.cancel();
    L20:
        Publisher r13 = (Publisher) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The publisher returned is null");     // Catch: Throwable -> L17
        FlowableSwitchMap$SwitchMapInnerSubscriber r14 = new FlowableSwitchMap$SwitchMapInnerSubscriber(this, r11, this.bufferSize);
    L10:
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> r15 = this.active.get();
        if (r15 == CANCELLED) goto L25;
        if (p.a(this.active, r15, r14) == false) goto L10;
        r13.subscribe(r14);
        return;
    L25:
        return;
    L17:
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
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L9;
        io.reactivex.internal.util.a.a(this.requested, r10);
        if (this.unique != 0) goto L7;
        this.upstream.request(Long.MAX_VALUE);
        return;
    L7:
        drain();
        return;
    }
}
