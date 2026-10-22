package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<nf.a> implements FlowableSubscriber<T> {
    static final Object NULL_KEY = null;
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled;
    final boolean delayError;
    boolean done;
    final Subscriber<? super nf.a> downstream;
    Throwable error;
    final Queue<d> evictedGroups;
    volatile boolean finished;
    final AtomicInteger groupCount;
    final Map<Object, d> groups;
    final Function<? super T, ? extends K> keySelector;
    boolean outputFused;
    final io.reactivex.internal.queue.a queue;
    final AtomicLong requested;
    Subscription upstream;
    final Function<? super T, ? extends V> valueSelector;

    static {
        NULL_KEY = new Object();
    }

    public FlowableGroupBy$GroupBySubscriber(Subscriber<? super nf.a> r10, Function<? super T, ? extends K> r11, Function<? super T, ? extends V> r12, int r13, boolean r14, Map<Object, d> r15, Queue<d> r16) {
        this.cancelled = new AtomicBoolean();
        this.requested = new AtomicLong();
        this.groupCount = new AtomicInteger(1);
        this.downstream = r10;
        this.keySelector = r11;
        this.valueSelector = r12;
        this.bufferSize = r13;
        this.delayError = r14;
        this.groups = r15;
        this.evictedGroups = r16;
        this.queue = new io.reactivex.internal.queue.a(r13);
    }

    private void completeEvictions() {
        if (this.evictedGroups == null) goto L12;
        int r10 = 0;
    L5:
        d r11 = this.evictedGroups.poll();
        if (r11 == null) goto L8;
        r11.onComplete();
        r10 = r10 + 1;
        goto L5
    L8:
        if (r10 == 0) goto L13;
        this.groupCount.addAndGet(-r10);
        return;
    L13:
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true) == false) goto L8;
        completeEvictions();
        if (this.groupCount.decrementAndGet() != 0) goto L9;
        this.upstream.cancel();
        return;
    L9:
        return;
    }

    public boolean checkTerminated(boolean r10, boolean r11, Subscriber<?> r12, io.reactivex.internal.queue.a r13) {
        if (this.cancelled.get() == false) goto L7;
        r13.clear();
        return true;
    L7:
        if (this.delayError == false) goto L15;
        if (r10 == false) goto L23;
        if (r11 == false) goto L25;
        Throwable r14 = this.error;
        if (r14 == null) goto L13;
        r12.onError(r14);
    L14:
        return true;
    L13:
        r12.onComplete();
        goto L14
    L25:
        return false;
    L23:
        return false;
    L15:
        if (r10 == false) goto L26;
        Throwable r15 = this.error;
        if (r15 == null) goto L20;
        r13.clear();
        r12.onError(r15);
        return true;
    L20:
        if (r11 == false) goto L27;
        r12.onComplete();
        return true;
    L27:
        return false;
    L26:
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.outputFused == false) goto L8;
        drainFused();
        return;
    L8:
        drainNormal();
    }

    public void drainFused() {
        io.reactivex.internal.queue.a r10 = this.queue;
        Subscriber<? super nf.a> r11 = this.downstream;
        int r12 = 1;
    L4:
        if (this.cancelled.get() == true) goto L5;
        boolean r13 = this.finished;
        if (r13 == true) goto L10;
    L15:
        r11.onNext(null);
        if (r13 == true) goto L17;
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L17:
        Throwable r14 = this.error;
        if (r14 == null) goto L20;
        r11.onError(r14);
        return;
    L20:
        r11.onComplete();
        return;
    L10:
        if (this.delayError == true) goto L15;
        Throwable r15 = this.error;
        if (r15 == null) goto L15;
        r10.clear();
        r11.onError(r15);
        return;
    L5:
        r10.clear();
    }

    public void drainNormal() {
        io.reactivex.internal.queue.a r10 = this.queue;
        Subscriber<? super nf.a> r11 = this.downstream;
        int r12 = 1;
    L3:
        long r13 = this.requested.get();
        long r14 = 0;
    L5:
        if (r14 == r13) goto L16;
        boolean r15 = this.finished;
        nf.a r16 = (nf.a) r10.poll();
        if (r16 != null) goto L9;
        boolean r17 = true;
    L11:
        if (checkTerminated(r15, r17, r11, r10) == true) goto L12;
        if (r17 == true) goto L16;
        r11.onNext(r16);
        r14 = r14 + 1;
        goto L5
    L12:
        return;
    L9:
        r17 = false;
    L16:
        if (r14 != r13) goto L21;
        if (checkTerminated(this.finished, r10.isEmpty(), r11, r10) == false) goto L21;
        return;
    L21:
        if (r14 != 0) goto L23;
    L26:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L3;
        return;
    L23:
        if (r13 == Long.MAX_VALUE) goto L25;
        this.requested.addAndGet(-r14);
    L25:
        this.upstream.request(r14);
        goto L26
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == true) goto L14;
        Iterator<d> r10 = this.groups.values().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        r10.next().onComplete();
        goto L6
    L8:
        this.groups.clear();
        Queue<d> r11 = this.evictedGroups;
        if (r11 == null) goto L11;
        r11.clear();
    L11:
        this.done = true;
        this.finished = true;
        drain();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.done = true;
        Iterator<d> r11 = this.groups.values().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r11.next().onError(r10);
        goto L8
    L10:
        this.groups.clear();
        Queue<d> r12 = this.evictedGroups;
        if (r12 == null) goto L13;
        r12.clear();
    L13:
        this.error = r10;
        this.finished = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.a r11 = this.queue;
        K r12 = this.keySelector.apply(r10);     // Catch: Throwable -> L25
        if (r12 == null) goto L9;
        Object r13 = r12;
    L10:
        d r14 = this.groups.get(r13);
        if (r14 == null) goto L13;
        boolean r15 = false;
    L30:
        r14.onNext(io.reactivex.internal.functions.a.b(this.valueSelector.apply(r10), "The valueSelector returned null"));
        completeEvictions();
        if (r15 == false) goto L32;
        r11.offer(r14);
        drain();
        return;
    L32:
        return;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
        return;
    L13:
        if (this.cancelled.get() == false) goto L15;
        return;
    L15:
        r14 = d.d(r12, this.bufferSize, this, this.delayError);
        this.groups.put(r13, r14);
        this.groupCount.getAndIncrement();
        r15 = true;
        goto L30
    L9:
        r13 = NULL_KEY;
    L25:
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
        r10.request(this.bufferSize);
        return;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public /* bridge */ /* synthetic */ Object poll() throws Exception {
        return poll();
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
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public nf.a poll() {
        return (nf.a) this.queue.poll();
    }

    public void cancel(K r10) {
        if (r10 != null) goto L5;
        r10 = (K) NULL_KEY;
    L5:
        this.groups.remove(r10);
        if (this.groupCount.decrementAndGet() != 0) goto L11;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L12;
        this.queue.clear();
        return;
    L12:
        return;
    }
}
