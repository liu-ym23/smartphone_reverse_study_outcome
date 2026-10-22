package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableFlattenIterable$FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -3096000382929934955L;
    volatile boolean cancelled;
    int consumed;
    Iterator<? extends R> current;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicReference<Throwable> error;
    int fusionMode;
    final int limit;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    SimpleQueue<T> queue;
    final AtomicLong requested;
    Subscription upstream;

    public FlowableFlattenIterable$FlattenIterableSubscriber(Subscriber<? super R> r10, Function<? super T, ? extends Iterable<? extends R>> r11, int r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.prefetch = r12;
        this.limit = r12 - (r12 >> 2);
        this.error = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    public boolean checkTerminated(boolean r10, boolean r11, Subscriber<?> r12, SimpleQueue<?> r13) {
        if (this.cancelled == false) goto L6;
        this.current = null;
        r13.clear();
        return true;
    L6:
        if (r10 == true) goto L8;
        return false;
    L8:
        if (this.error.get() == null) goto L11;
        Throwable r14 = ExceptionHelper.b(this.error);
        this.current = null;
        r13.clear();
        r12.onError(r14);
        return true;
    L11:
        if (r11 == false) goto L16;
        r12.onComplete();
        return true;
    L16:
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.current = null;
        this.queue.clear();
    }

    public void consumedOne(boolean r10) {
        if (r10 == false) goto L8;
        int r11 = this.consumed + 1;
        if (r11 != this.limit) goto L6;
        this.consumed = 0;
        this.upstream.request(r11);
        return;
    L6:
        this.consumed = r11;
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<?> r10 = this.downstream;
        SimpleQueue<T> r11 = this.queue;
        boolean r12 = true;
        if (this.fusionMode == 1) goto L8;
        boolean r13 = true;
    L9:
        Iterator<? extends R> r14 = this.current;
        int r15 = 1;
    L11:
        if (r14 != null) goto L31;
        boolean r16 = this.done;
        T r17 = r11.poll();     // Catch: Throwable -> L28
        if (r17 != null) goto L16;
        boolean r18 = r12;
    L18:
        if (checkTerminated(r16, r18, r10, r11) == true) goto L19;
        if (r17 == null) goto L31;
        r14 = this.mapper.apply(r17).iterator();     // Catch: Throwable -> L25
        if (r14.hasNext() == false) goto L23;
        this.current = r14;
        goto L31
    L23:
        consumedOne(r13);
        r14 = null;
    L25:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        ExceptionHelper.a(this.error, th);
        r10.onError(ExceptionHelper.b(this.error));
        return;
    L19:
        return;
    L16:
        r18 = false;
    L28:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        ExceptionHelper.a(this.error, th);
        Throwable r19 = ExceptionHelper.b(this.error);
        this.current = null;
        r11.clear();
        r10.onError(r19);
        return;
    L31:
        if (r14 == null) goto L70;
        long r20 = this.requested.get();
        long r110 = 0;
    L34:
        if (r110 == r20) goto L54;
        if (checkTerminated(this.done, false, r10, r11) == true) goto L37;
        r10.onNext((Object) io.reactivex.internal.functions.a.b(r14.next(), "The iterator returned a null value"));
        if (checkTerminated(this.done, false, r10, r11) == true) goto L41;
        r110 = r110 + 1;
        if (r14.hasNext() == true) goto L34;
        consumedOne(r13);
        this.current = null;
        r14 = null;
    L47:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.current = null;
        this.upstream.cancel();
        ExceptionHelper.a(this.error, th);
        r10.onError(ExceptionHelper.b(this.error));
        return;
    L41:
        return;
    L50:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.current = null;
        this.upstream.cancel();
        ExceptionHelper.a(this.error, th);
        r10.onError(ExceptionHelper.b(this.error));
        return;
    L37:
        return;
    L54:
        if (r110 != r20) goto L64;
        boolean r21 = this.done;
        if (r11.isEmpty() == false) goto L59;
        if (r14 != null) goto L59;
        boolean r22 = true;
    L61:
        if (checkTerminated(r21, r22, r10, r11) == false) goto L64;
        return;
    L59:
        r22 = false;
    L64:
        if (r110 != 0) goto L66;
    L68:
        if (r14 != null) goto L70;
    L69:
        r12 = true;
        goto L11
    L66:
        if (r20 == Long.MAX_VALUE) goto L68;
        this.requested.addAndGet(-r110);
    L70:
        r15 = addAndGet(-r15);
        if (r15 != 0) goto L69;
        return;
    L8:
        r13 = false;
        goto L9
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (this.current == null) goto L5;
    L7:
        return false;
    L5:
        if (this.queue.isEmpty() == false) goto L7;
        return true;
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
    L7:
        qf.a.e(r10);
        return;
    L5:
        if (ExceptionHelper.a(this.error, r10) == false) goto L7;
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.fusionMode == 0) goto L8;
    L11:
        drain();
        return;
    L8:
        if (this.queue.offer(r10) == true) goto L11;
        onError(new MissingBackpressureException("Queue is full?!"));
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof QueueSubscription) == false) goto L14;
        QueueSubscription r11 = (QueueSubscription) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        return;
    L11:
        if (r12 != 2) goto L14;
        this.fusionMode = r12;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public R poll() throws Exception {
        Iterator<? extends R> r10 = this.current;
    L4:
        if (r10 != null) goto L12;
        T r11 = this.queue.poll();
        if (r11 == null) goto L7;
        r10 = this.mapper.apply(r11).iterator();
        if (r10.hasNext() == true) goto L11;
        r10 = null;
        goto L4
    L11:
        this.current = r10;
        goto L12
    L7:
        return null;
    L12:
        R r12 = (R) io.reactivex.internal.functions.a.b(r10.next(), "The iterator returned a null value");
        if (r10.hasNext() == true) goto L15;
        this.current = null;
    L15:
        return r12;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
        return;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        if ((r10 & 1) != 0) goto L5;
        return 0;
    L5:
        if (this.fusionMode != 1) goto L9;
        return 1;
    L9:
        return 0;
    }
}
