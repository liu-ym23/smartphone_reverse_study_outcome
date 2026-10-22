package io.reactivex.internal.operators.flowable;

import androidx.lifecycle.p;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableFlatMap$MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    static final FlowableFlatMap$InnerSubscriber<?, ?>[] CANCELLED = null;
    static final FlowableFlatMap$InnerSubscriber<?, ?>[] EMPTY = null;
    private static final long serialVersionUID = -2117620485640801370L;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super U> downstream;
    final AtomicThrowable errs;
    long lastId;
    int lastIndex;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;
    volatile SimplePlainQueue<U> queue;
    final AtomicLong requested;
    int scalarEmitted;
    final int scalarLimit;
    final AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> subscribers;
    long uniqueId;
    Subscription upstream;

    static {
        EMPTY = new FlowableFlatMap$InnerSubscriber[0];
        CANCELLED = new FlowableFlatMap$InnerSubscriber[0];
    }

    public FlowableFlatMap$MergeSubscriber(Subscriber<? super U> r10, Function<? super T, ? extends Publisher<? extends U>> r11, boolean r12, int r13, int r14) {
        this.errs = new AtomicThrowable();
        AtomicReference<FlowableFlatMap$InnerSubscriber<?, ?>[]> r15 = new AtomicReference();
        this.subscribers = r15;
        this.requested = new AtomicLong();
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.maxConcurrency = r13;
        this.bufferSize = r14;
        this.scalarLimit = Math.max(1, r13 >> 1);
        r15.lazySet(EMPTY);
    }

    public boolean addInner(FlowableFlatMap$InnerSubscriber<T, U> r10) {
    L2:
        FlowableFlatMap$InnerSubscriber<?, ?>[] r11 = this.subscribers.get();
        if (r11 == CANCELLED) goto L4;
        int r12 = r11.length;
        FlowableFlatMap$InnerSubscriber[] r13 = new FlowableFlatMap$InnerSubscriber[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (p.a(this.subscribers, r11, r13) == false) goto L2;
        return true;
    L4:
        r10.dispose();
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L10;
        this.cancelled = true;
        this.upstream.cancel();
        disposeAll();
        if (getAndIncrement() != 0) goto L11;
        SimplePlainQueue<U> r10 = this.queue;
        if (r10 == null) goto L12;
        r10.clear();
        return;
    L12:
        return;
    L11:
        return;
    }

    public boolean checkTerminate() {
        if (this.cancelled == false) goto L7;
        clearScalarQueue();
        return true;
    L7:
        if (this.delayErrors == false) goto L9;
        return false;
    L9:
        if (this.errs.get() == null) goto L16;
        clearScalarQueue();
        Throwable r10 = this.errs.terminate();
        if (r10 == ExceptionHelper.f20726a) goto L13;
        this.downstream.onError(r10);
    L13:
        return true;
    L16:
        return false;
    }

    public void clearScalarQueue() {
        SimplePlainQueue<U> r10 = this.queue;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    public void disposeAll() {
        FlowableFlatMap$InnerSubscriber<?, ?>[] r10 = this.subscribers.get();
        FlowableFlatMap$InnerSubscriber<?, ?>[] r11 = CANCELLED;
        if (r10 == r11) goto L16;
        FlowableFlatMap$InnerSubscriber<?, ?>[] r12 = this.subscribers.getAndSet(r11);
        if (r12 == r11) goto L17;
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r12[r14].dispose();
        r14 = r14 + 1;
        goto L7
    L9:
        Throwable r15 = this.errs.terminate();
        if (r15 != null) goto L12;
        return;
    L12:
        if (r15 == ExceptionHelper.f20726a) goto L19;
        qf.a.e(r15);
        return;
    L19:
        return;
    L17:
        return;
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drainLoop() {
        Subscriber<? super U> r10 = this.downstream;
        int r11 = 1;
    L4:
        if (checkTerminate() == true) goto L5;
        SimplePlainQueue<U> r12 = this.queue;
        long r13 = this.requested.get();
        if (r13 != Long.MAX_VALUE) goto L9;
        boolean r14 = true;
    L10:
        long r15 = 0;
        long r16 = 0;
        if (r12 == null) goto L31;
    L12:
        long r17 = 0;
        Object r18 = null;
    L14:
        if (r13 == 0) goto L22;
        U r19 = r12.poll();
        if (checkTerminate() == true) goto L17;
        if (r19 == null) goto L19;
        r10.onNext(r19);
        r16 = r16 + 1;
        r17 = r17 + 1;
        r13 = r13 - 1;
        r18 = r19;
        goto L14
    L19:
        r18 = r19;
        goto L22
    L17:
        return;
    L22:
        if (r17 == 0) goto L27;
        if (r14 == false) goto L25;
        r13 = Long.MAX_VALUE;
        goto L27
    L25:
        r13 = this.requested.addAndGet(-r17);
    L27:
        if (r13 == 0) goto L31;
        if (r18 != null) goto L12;
    L31:
        boolean r20 = this.done;
        SimplePlainQueue<U> r21 = this.queue;
        FlowableFlatMap$InnerSubscriber<?, ?>[] r22 = this.subscribers.get();
        int r110 = r22.length;
        if (r20 == false) goto L43;
        if (r21 != null) goto L35;
    L36:
        if (r110 != 0) goto L43;
        Throwable r23 = this.errs.terminate();
        if (r23 == ExceptionHelper.f20726a) goto L168;
        if (r23 != null) goto L41;
        r10.onComplete();
        return;
    L41:
        r10.onError(r23);
        return;
    L168:
        return;
    L35:
        if (r21.isEmpty() == true) goto L36;
    L43:
        int r111 = r11;
        if (r110 == 0) goto L124;
        long r24 = this.lastId;
        int r25 = this.lastIndex;
        if (r110 > r25) goto L48;
    L49:
        if (r110 > r25) goto L51;
        r25 = 0;
    L51:
        int r26 = 0;
    L52:
        if (r26 >= r110) goto L60;
        if (r22[r25].f20623id == r24) goto L60;
        r25 = r25 + 1;
        if (r25 != r110) goto L59;
        r25 = 0;
    L59:
        r26 = r26 + 1;
    L60:
        this.lastIndex = r25;
        this.lastId = r22[r25].f20623id;
    L61:
        int r27 = r25;
        boolean r28 = false;
        int r29 = 0;
    L62:
        if (r29 >= r110) goto L122;
        if (checkTerminate() == true) goto L65;
        FlowableFlatMap$InnerSubscriber<T, U> r30 = r22[r27];
        Object r112 = null;
    L68:
        if (checkTerminate() == true) goto L69;
        SimpleQueue<U> r113 = r30.queue;
        if (r113 == null) goto L72;
        int r114 = r110;
        Object r210 = r112;
        long r115 = r15;
    L75:
        if (r13 == r15) goto L92;
        U r116 = r113.poll();     // Catch: Throwable -> L83
        if (r116 == null) goto L78;
        r10.onNext(r116);
        if (checkTerminate() == true) goto L81;
        r13 = r13 - 1;
        r115 = r115 + 1;
        r210 = r116;
        r15 = 0;
        goto L75
    L81:
        return;
    L78:
        r210 = r116;
        r15 = 0;
    L83:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r30.dispose();
        this.errs.addThrowable(th);
        if (this.delayErrors == true) goto L88;
        this.upstream.cancel();
    L88:
        if (checkTerminate() == true) goto L89;
        removeInner(r30);
        r29 = r29 + 1;
        r28 = true;
        int r31 = 1;
    L121:
        r29 = r29 + r31;
        r110 = r114;
        r15 = 0;
        goto L62
    L89:
        return;
    L92:
        if (r115 == r15) goto L97;
        if (r14 == true) goto L95;
        r13 = this.requested.addAndGet(-r115);
    L96:
        r30.requestMore(r115);
        long r117 = 0;
    L99:
        if (r13 == r117) goto L103;
        if (r210 == null) goto L103;
        r110 = r114;
        r112 = r210;
        r15 = 0;
    L103:
        boolean r118 = r30.done;
        SimpleQueue<U> r119 = r30.queue;
        if (r118 == false) goto L115;
        if (r119 != null) goto L107;
    L110:
        removeInner(r30);
        if (checkTerminate() == true) goto L112;
        r16 = r16 + 1;
        r28 = true;
        goto L115
    L112:
        return;
    L107:
        if (r119.isEmpty() == true) goto L110;
    L115:
        if (r13 == 0) goto L116;
        r27 = r27 + 1;
        if (r27 != r114) goto L120;
        r27 = 0;
    L120:
        r31 = 1;
        goto L121
    L116:
        boolean r120 = r28;
    L123:
        this.lastIndex = r27;
        this.lastId = r22[r27].f20623id;
        long r32 = r16;
        long r33 = 0;
    L126:
        if (r32 != r33) goto L128;
    L130:
        if (r120 == true) goto L131;
        r11 = addAndGet(-r111);
        if (r11 != 0) goto L4;
        return;
    L131:
        r11 = r111;
        goto L4
    L128:
        if (this.cancelled == true) goto L130;
        this.upstream.request(r32);
        goto L130
    L95:
        r13 = Long.MAX_VALUE;
        goto L96
    L97:
        r117 = r15;
        goto L99
    L72:
        r114 = r110;
        goto L103
    L69:
        return;
    L65:
        return;
    L122:
        r120 = r28;
        goto L123
    L48:
        if (r22[r25].f20623id == r24) goto L61;
    L124:
        r33 = 0;
        r32 = r16;
        r120 = false;
        goto L126
    L9:
        r14 = false;
        goto L10
    }

    public SimpleQueue<U> getInnerQueue(FlowableFlatMap$InnerSubscriber<T, U> r10) {
        SimpleQueue<U> r11 = r10.queue;
        if (r11 != null) goto L6;
        SpscArrayQueue r12 = new SpscArrayQueue(this.bufferSize);
        r10.queue = r12;
        return r12;
    L6:
        return r11;
    }

    public SimpleQueue<U> getMainQueue() {
        SimplePlainQueue<U> r10 = this.queue;
        if (r10 == null) goto L5;
    L9:
        return r10;
    L5:
        if (this.maxConcurrency != Integer.MAX_VALUE) goto L7;
        r10 = new io.reactivex.internal.queue.a(this.bufferSize);
    L8:
        this.queue = r10;
        goto L9
    L7:
        r10 = new SpscArrayQueue(this.maxConcurrency);
        goto L8
    }

    public void innerError(FlowableFlatMap$InnerSubscriber<T, U> r10, Throwable r11) {
        if (this.errs.addThrowable(r11) == false) goto L10;
        r10.done = true;
        if (this.delayErrors == true) goto L9;
        this.upstream.cancel();
        FlowableFlatMap$InnerSubscriber<?, ?>[] r12 = this.subscribers.getAndSet(CANCELLED);
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r12[r14].dispose();
        r14 = r14 + 1;
    L9:
        drain();
        return;
    L10:
        qf.a.e(r11);
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
        if (this.done == false) goto L7;
        qf.a.e(r10);
        return;
    L7:
        if (this.errs.addThrowable(r10) == false) goto L9;
        this.done = true;
        drain();
        return;
    L9:
        qf.a.e(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L30;
        return;
    L30:
        Publisher r11 = (Publisher) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null Publisher");     // Catch: Throwable -> L25
        if ((r11 instanceof Callable) == true) goto L28;
        long r12 = this.uniqueId;
        this.uniqueId = 1 + r12;
        FlowableFlatMap$InnerSubscriber r13 = new FlowableFlatMap$InnerSubscriber(this, r12);
        if (addInner(r13) == false) goto L37;
        r11.subscribe(r13);
        return;
    L37:
        return;
    L28:
        Object r14 = ((Callable) r11).call();     // Catch: Throwable -> L18
        if (r14 == null) goto L12;
        tryEmitScalar(r14);
        return;
    L12:
        if (this.maxConcurrency != Integer.MAX_VALUE) goto L14;
        return;
    L14:
        if (this.cancelled == true) goto L34;
        int r15 = this.scalarEmitted + 1;
        this.scalarEmitted = r15;
        int r16 = this.scalarLimit;
        if (r15 != r16) goto L35;
        this.scalarEmitted = 0;
        this.upstream.request(r16);
        return;
    L35:
        return;
    L34:
        return;
    L18:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errs.addThrowable(th);
        drain();
        return;
    L25:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L11;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        if (this.cancelled == true) goto L12;
        int r11 = this.maxConcurrency;
        if (r11 != Integer.MAX_VALUE) goto L9;
        r10.request(Long.MAX_VALUE);
        return;
    L9:
        r10.request(r11);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeInner(FlowableFlatMap$InnerSubscriber<T, U> r10) {
    L2:
        FlowableFlatMap$InnerSubscriber<?, ?>[] r11 = this.subscribers.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        if (r11[r13] == r10) goto L12;
        r13 = r13 + 1;
    L12:
        if (r13 < 0) goto L13;
        if (r12 != 1) goto L17;
        FlowableFlatMap$InnerSubscriber<?, ?>[] r14 = EMPTY;
    L19:
        if (p.a(this.subscribers, r11, r14) == false) goto L2;
        return;
    L17:
        FlowableFlatMap$InnerSubscriber<?, ?>[] r15 = new FlowableFlatMap$InnerSubscriber[r12 - 1];
        System.arraycopy(r11, 0, r15, 0, r13);
        System.arraycopy(r11, r13 + 1, r15, r13, (r12 - r13) - 1);
        r14 = r15;
        goto L19
    L13:
        return;
    L11:
        r13 = -1;
        goto L12
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
        return;
    }

    public void tryEmit(U r10, FlowableFlatMap$InnerSubscriber<T, U> r11) {
        if (get() == 0) goto L5;
    L24:
        SimpleQueue r12 = r11.queue;
        if (r12 != null) goto L28;
        r12 = new SpscArrayQueue(this.bufferSize);
        r11.queue = r12;
    L28:
        if (r12.offer(r10) == true) goto L32;
        onError(new MissingBackpressureException("Inner queue full?!"));
        return;
    L32:
        if (getAndIncrement() == 0) goto L34;
        return;
    L34:
        drainLoop();
        return;
    L5:
        if (compareAndSet(0, 1) == false) goto L24;
        long r13 = this.requested.get();
        SimpleQueue<U> r14 = r11.queue;
        if (r13 == 0) goto L15;
        if (r14 != null) goto L10;
    L11:
        this.downstream.onNext(r10);
        if (r13 == Long.MAX_VALUE) goto L14;
        this.requested.decrementAndGet();
    L14:
        r11.requestMore(1);
    L22:
        if (decrementAndGet() != 0) goto L34;
        return;
    L10:
        if (r14.isEmpty() == true) goto L11;
    L15:
        if (r14 != null) goto L18;
        r14 = getInnerQueue(r11);
    L18:
        if (r14.offer(r10) == true) goto L22;
        onError(new MissingBackpressureException("Inner queue full?!"));
    }

    public void tryEmitScalar(U r10) {
        if (get() != 0) goto L31;
        if (compareAndSet(0, 1) == false) goto L31;
        long r11 = this.requested.get();
        SimpleQueue<U> r12 = this.queue;
        if (r11 == 0) goto L21;
        if (r12 != null) goto L10;
    L11:
        this.downstream.onNext(r10);
        if (r11 == Long.MAX_VALUE) goto L15;
        this.requested.decrementAndGet();
    L15:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L28;
        if (this.cancelled == true) goto L28;
        int r13 = this.scalarEmitted + 1;
        this.scalarEmitted = r13;
        int r14 = this.scalarLimit;
        if (r13 != r14) goto L28;
        this.scalarEmitted = 0;
        this.upstream.request(r14);
    L28:
        if (decrementAndGet() != 0) goto L37;
        return;
    L37:
        drainLoop();
        return;
    L10:
        if (r12.isEmpty() == true) goto L11;
    L21:
        if (r12 != null) goto L24;
        r12 = getMainQueue();
    L24:
        if (r12.offer(r10) == true) goto L28;
        onError(new IllegalStateException("Scalar queue full?!"));
        return;
    L31:
        if (getMainQueue().offer(r10) == true) goto L35;
        onError(new IllegalStateException("Scalar queue full?!"));
        return;
    L35:
        if (getAndIncrement() == 0) goto L37;
    }
}
