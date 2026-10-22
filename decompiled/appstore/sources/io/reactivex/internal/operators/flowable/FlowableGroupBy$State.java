package io.reactivex.internal.operators.flowable;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableGroupBy$State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<Subscriber<? super T>> actual;
    final AtomicBoolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once;
    boolean outputFused;
    final FlowableGroupBy$GroupBySubscriber<?, K, T> parent;
    int produced;
    final io.reactivex.internal.queue.a queue;
    final AtomicLong requested;

    public FlowableGroupBy$State(int r10, FlowableGroupBy$GroupBySubscriber<?, K, T> r11, K r12, boolean r13) {
        this.requested = new AtomicLong();
        this.cancelled = new AtomicBoolean();
        this.actual = new AtomicReference();
        this.once = new AtomicBoolean();
        this.queue = new io.reactivex.internal.queue.a(r10);
        this.parent = r11;
        this.key = r12;
        this.delayError = r13;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true) == false) goto L6;
        this.parent.cancel(this.key);
        return;
    }

    public boolean checkTerminated(boolean r10, boolean r11, Subscriber<? super T> r12, boolean r13) {
        if (this.cancelled.get() == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r10 == false) goto L21;
        if (r13 == false) goto L14;
        if (r11 == false) goto L23;
        Throwable r14 = this.error;
        if (r14 == null) goto L12;
        r12.onError(r14);
    L13:
        return true;
    L12:
        r12.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r15 = this.error;
        if (r15 == null) goto L18;
        this.queue.clear();
        r12.onError(r15);
        return true;
    L18:
        if (r11 == false) goto L24;
        r12.onComplete();
        return true;
    L24:
        return false;
    L21:
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
        Subscriber<? super T> r11 = this.actual.get();
        int r12 = 1;
    L3:
        if (r11 != null) goto L5;
    L23:
        r12 = addAndGet(-r12);
        if (r12 == 0) goto L25;
        if (r11 != null) goto L3;
        r11 = this.actual.get();
        goto L3
    L25:
        return;
    L5:
        if (this.cancelled.get() == true) goto L6;
        boolean r13 = this.done;
        if (r13 == true) goto L11;
    L16:
        r11.onNext(null);
        if (r13 == false) goto L23;
        Throwable r14 = this.error;
        if (r14 == null) goto L21;
        r11.onError(r14);
        return;
    L21:
        r11.onComplete();
        return;
    L11:
        if (this.delayError == true) goto L16;
        Throwable r15 = this.error;
        if (r15 == null) goto L16;
        r10.clear();
        r11.onError(r15);
        return;
    L6:
        r10.clear();
    }

    public void drainNormal() {
        io.reactivex.internal.queue.a r10 = this.queue;
        boolean r11 = this.delayError;
        Subscriber<? super T> r12 = this.actual.get();
        int r13 = 1;
    L3:
        if (r12 == null) goto L27;
        long r14 = this.requested.get();
        long r15 = 0;
    L6:
        if (r15 == r14) goto L17;
        boolean r16 = this.done;
        Object r17 = r10.poll();
        if (r17 != null) goto L10;
        boolean r18 = true;
    L12:
        if (checkTerminated(r16, r18, r12, r11) == true) goto L13;
        if (r18 == true) goto L17;
        r12.onNext(r17);
        r15 = r15 + 1;
        goto L6
    L13:
        return;
    L10:
        r18 = false;
    L17:
        if (r15 != r14) goto L22;
        if (checkTerminated(this.done, r10.isEmpty(), r12, r11) == false) goto L22;
        return;
    L22:
        if (r15 == 0) goto L27;
        if (r14 == Long.MAX_VALUE) goto L26;
        this.requested.addAndGet(-r15);
    L26:
        this.parent.upstream.request(r15);
    L27:
        r13 = addAndGet(-r13);
        if (r13 == 0) goto L29;
        if (r12 != null) goto L3;
        r12 = this.actual.get();
        goto L3
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    public void onNext(T r10) {
        this.queue.offer(r10);
        drain();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        T r10 = (T) this.queue.poll();
        if (r10 == null) goto L6;
        this.produced++;
        return r10;
    L6:
        int r11 = this.produced;
        if (r11 == 0) goto L11;
        this.produced = 0;
        this.parent.upstream.request(r11);
        return null;
    L11:
        return null;
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

    @Override // org.reactivestreams.Publisher
    public void subscribe(Subscriber<? super T> r10) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        r10.onSubscribe(this);
        this.actual.lazySet(r10);
        drain();
        return;
    L5:
        EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), r10);
    }
}
