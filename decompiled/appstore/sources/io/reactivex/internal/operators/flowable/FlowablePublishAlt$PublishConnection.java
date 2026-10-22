package io.reactivex.internal.operators.flowable;

import androidx.lifecycle.p;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowablePublishAlt$PublishConnection<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
    static final FlowablePublishAlt$InnerSubscription[] EMPTY = null;
    static final FlowablePublishAlt$InnerSubscription[] TERMINATED = null;
    private static final long serialVersionUID = -1672047311619175801L;
    final int bufferSize;
    final AtomicBoolean connect;
    int consumed;
    final AtomicReference<FlowablePublishAlt$PublishConnection<T>> current;
    volatile boolean done;
    Throwable error;
    volatile SimpleQueue<T> queue;
    int sourceMode;
    final AtomicReference<FlowablePublishAlt$InnerSubscription<T>[]> subscribers;
    final AtomicReference<Subscription> upstream;

    static {
        EMPTY = new FlowablePublishAlt$InnerSubscription[0];
        TERMINATED = new FlowablePublishAlt$InnerSubscription[0];
    }

    public FlowablePublishAlt$PublishConnection(AtomicReference<FlowablePublishAlt$PublishConnection<T>> r10, int r11) {
        this.current = r10;
        this.upstream = new AtomicReference();
        this.connect = new AtomicBoolean();
        this.bufferSize = r11;
        this.subscribers = new AtomicReference(EMPTY);
    }

    public boolean add(FlowablePublishAlt$InnerSubscription<T> r10) {
    L2:
        FlowablePublishAlt$InnerSubscription<T>[] r11 = this.subscribers.get();
        if (r11 == TERMINATED) goto L4;
        int r12 = r11.length;
        FlowablePublishAlt$InnerSubscription[] r13 = new FlowablePublishAlt$InnerSubscription[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (p.a(this.subscribers, r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    public boolean checkTerminated(boolean r10, boolean r11) {
        int r12 = 0;
        if (r10 == false) goto L16;
        if (r11 == false) goto L16;
        Throwable r13 = this.error;
        if (r13 == null) goto L8;
        signalError(r13);
        return true;
    L8:
        FlowablePublishAlt$InnerSubscription<T>[] r14 = this.subscribers.getAndSet(TERMINATED);
        int r15 = r14.length;
    L9:
        if (r12 >= r15) goto L20;
        FlowablePublishAlt$InnerSubscription<T> r16 = r14[r12];
        if (r16.isCancelled() == true) goto L13;
        r16.downstream.onComplete();
    L13:
        r12 = r12 + 1;
        goto L9
    L20:
        return true;
    L16:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.subscribers.getAndSet(TERMINATED);
        p.a(this.current, this, null);
        SubscriptionHelper.cancel(this.upstream);
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        SimpleQueue<T> r10 = this.queue;
        int r11 = this.consumed;
        int r12 = this.bufferSize;
        int r13 = r12 - (r12 >> 2);
        if (this.sourceMode == 1) goto L8;
        boolean r14 = true;
    L9:
        int r15 = 1;
        SimpleQueue<T> r16 = r10;
        int r17 = r11;
    L10:
        if (r16 == null) goto L53;
        FlowablePublishAlt$InnerSubscription<T>[] r18 = this.subscribers.get();
        int r19 = r18.length;
        long r110 = Long.MAX_VALUE;
        int r111 = 0;
        boolean r112 = false;
    L12:
        if (r111 >= r19) goto L17;
        FlowablePublishAlt$InnerSubscription<T> r113 = r18[r111];
        long r114 = r113.get();
        if (r114 == Long.MIN_VALUE) goto L16;
        r110 = Math.min(r114 - r113.emitted, r110);
        r112 = true;
    L16:
        r111 = r111 + 1;
        goto L12
    L17:
        long r115 = 0;
        if (r112 == true) goto L21;
        r110 = 0;
    L21:
        if (r110 == r115) goto L51;
        boolean r20 = this.done;
        T r116 = r16.poll();     // Catch: Throwable -> L47
        if (r116 != null) goto L26;
        boolean r117 = true;
    L28:
        if (checkTerminated(r20, r117) == true) goto L29;
        if (r117 == true) goto L51;
        int r21 = r18.length;
        int r118 = 0;
    L34:
        if (r118 >= r21) goto L39;
        FlowablePublishAlt$InnerSubscription<T> r22 = r18[r118];
        if (r22.isCancelled() == true) goto L38;
        r22.downstream.onNext(r116);
        r22.emitted++;
    L38:
        r118 = r118 + 1;
        goto L34
    L39:
        if (r14 == false) goto L43;
        r17 = r17 + 1;
        if (r17 != r13) goto L43;
        this.upstream.get().request(r13);
        r17 = 0;
    L43:
        r110 = r110 - 1;
        if (r18 != this.subscribers.get()) goto L10;
        r115 = 0;
        goto L21
    L29:
        return;
    L26:
        r117 = false;
    L47:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.get().cancel();
        r16.clear();
        this.done = true;
        signalError(th);
        return;
    L51:
        if (checkTerminated(this.done, r16.isEmpty()) == false) goto L53;
        return;
    L53:
        this.consumed = r17;
        r15 = addAndGet(-r15);
        if (r15 == 0) goto L55;
        if (r16 != null) goto L10;
        r16 = this.queue;
        goto L10
    L55:
        return;
    L8:
        r14 = false;
        goto L9
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.subscribers.get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L5;
        qf.a.e(r10);
        return;
    L5:
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.sourceMode == 0) goto L5;
    L8:
        drain();
        return;
    L5:
        if (this.queue.offer(r10) == true) goto L8;
        onError(new MissingBackpressureException("Prefetch queue is full?!"));
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.setOnce(this.upstream, r10) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof QueueSubscription) == false) goto L14;
        QueueSubscription r11 = (QueueSubscription) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.sourceMode = r12;
        this.queue = r11;
        this.done = true;
        drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = r12;
        this.queue = r11;
        r10.request(this.bufferSize);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.bufferSize);
        r10.request(this.bufferSize);
    }

    public void remove(FlowablePublishAlt$InnerSubscription<T> r10) {
    L2:
        FlowablePublishAlt$InnerSubscription<T>[] r11 = this.subscribers.get();
        int r12 = r11.length;
        if (r12 == 0) goto L20;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        if (r11[r13] == r10) goto L12;
        r13 = r13 + 1;
    L12:
        if (r13 < 0) goto L13;
        if (r12 != 1) goto L17;
        FlowablePublishAlt$InnerSubscription[] r14 = EMPTY;
    L19:
        if (p.a(this.subscribers, r11, r14) == false) goto L2;
        return;
    L17:
        FlowablePublishAlt$InnerSubscription[] r15 = new FlowablePublishAlt$InnerSubscription[r12 - 1];
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

    public void signalError(Throwable r10) {
        FlowablePublishAlt$InnerSubscription<T>[] r11 = this.subscribers.getAndSet(TERMINATED);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        FlowablePublishAlt$InnerSubscription<T> r14 = r11[r13];
        if (r14.isCancelled() == true) goto L7;
        r14.downstream.onError(r10);
    L7:
        r13 = r13 + 1;
        goto L3
    }
}
