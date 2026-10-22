package io.reactivex.internal.operators.flowable;

import androidx.lifecycle.p;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowablePublish$PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
    static final FlowablePublish$InnerSubscriber[] EMPTY = null;
    static final FlowablePublish$InnerSubscriber[] TERMINATED = null;
    private static final long serialVersionUID = -202316842419149694L;
    final int bufferSize;
    final AtomicReference<FlowablePublish$PublishSubscriber<T>> current;
    volatile SimpleQueue<T> queue;
    final AtomicBoolean shouldConnect;
    int sourceMode;
    final AtomicReference<FlowablePublish$InnerSubscriber<T>[]> subscribers;
    volatile Object terminalEvent;
    final AtomicReference<Subscription> upstream;

    static {
        EMPTY = new FlowablePublish$InnerSubscriber[0];
        TERMINATED = new FlowablePublish$InnerSubscriber[0];
    }

    public FlowablePublish$PublishSubscriber(AtomicReference<FlowablePublish$PublishSubscriber<T>> r10, int r11) {
        this.upstream = new AtomicReference();
        this.subscribers = new AtomicReference(EMPTY);
        this.current = r10;
        this.shouldConnect = new AtomicBoolean();
        this.bufferSize = r11;
    }

    public boolean add(FlowablePublish$InnerSubscriber<T> r10) {
    L2:
        FlowablePublish$InnerSubscriber<T>[] r11 = this.subscribers.get();
        if (r11 == TERMINATED) goto L4;
        int r12 = r11.length;
        FlowablePublish$InnerSubscriber[] r13 = new FlowablePublish$InnerSubscriber[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (p.a(this.subscribers, r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    public boolean checkTerminated(Object r10, boolean r11) {
        int r12 = 0;
        if (r10 != null) goto L5;
    L18:
        return false;
    L5:
        if (NotificationLite.isComplete(r10) == false) goto L11;
        if (r11 == false) goto L18;
        p.a(this.current, this, null);
        FlowablePublish$InnerSubscriber<T>[] r13 = this.subscribers.getAndSet(TERMINATED);
        int r14 = r13.length;
    L8:
        if (r12 >= r14) goto L10;
        r13[r12].child.onComplete();
        r12 = r12 + 1;
        goto L8
    L10:
        return true;
    L11:
        Throwable r15 = NotificationLite.getError(r10);
        p.a(this.current, this, null);
        FlowablePublish$InnerSubscriber<T>[] r16 = this.subscribers.getAndSet(TERMINATED);
        if (r16.length == 0) goto L16;
        int r17 = r16.length;
    L14:
        if (r12 >= r17) goto L17;
        r16[r12].child.onError(r15);
        r12 = r12 + 1;
    L17:
        return true;
    L16:
        qf.a.e(r15);
        goto L17
    }

    public void dispatch() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<FlowablePublish$InnerSubscriber<T>[]> r10 = this.subscribers;
        boolean r11 = true;
        FlowablePublish$InnerSubscriber<T>[] r12 = r10.get();
        int r13 = 1;
    L6:
        Object r14 = this.terminalEvent;
        SimpleQueue<T> r15 = this.queue;
        if (r15 != null) goto L9;
    L12:
        boolean r16 = r11;
    L14:
        if (checkTerminated(r14, r16) == true) goto L15;
        if (r16 == true) goto L87;
        int r17 = r12.length;
        int r18 = r12.length;
        int r19 = 0;
        int r110 = 0;
        long r111 = Long.MAX_VALUE;
    L19:
        if (r19 >= r18) goto L26;
        FlowablePublish$InnerSubscriber<T> r20 = r12[r19];
        long r112 = r20.get();
        if (r112 == Long.MIN_VALUE) goto L23;
        r111 = Math.min(r111, r112 - r20.emitted);
    L24:
        r19 = r19 + 1;
        goto L19
    L23:
        r110 = r110 + 1;
        goto L24
    L26:
        if (r17 == r110) goto L27;
        int r113 = 0;
    L42:
        long r114 = r113;
        if (r114 >= r111) goto L78;
        Object r21 = this.terminalEvent;
        T r22 = r15.poll();     // Catch: Throwable -> L47
    L49:
        if (r22 != null) goto L51;
        boolean r23 = r11;
    L53:
        if (checkTerminated(r21, r23) == true) goto L54;
        if (r23 == true) goto L56;
        Object r24 = NotificationLite.getValue(r22);
        int r25 = r12.length;
        int r115 = 0;
        boolean r116 = false;
    L58:
        if (r115 >= r25) goto L68;
        FlowablePublish$InnerSubscriber<T> r26 = r12[r115];
        long r27 = r26.get();
        if (r27 != Long.MIN_VALUE) goto L62;
        r15 = r15;
        r23 = r23;
        r116 = true;
    L67:
        r115 = r115 + 1;
        r15 = r15;
        r23 = r23;
        goto L58
    L62:
        if (r27 == Long.MAX_VALUE) goto L65;
        r26.emitted++;
    L65:
        r26.child.onNext(r24);
        goto L67
    L68:
        SimpleQueue<T> r28 = r15;
        boolean r29 = r23;
        r113 = r113 + 1;
        FlowablePublish$InnerSubscriber<T>[] r30 = r10.get();
        if (r116 == true) goto L73;
        if (r30 != r12) goto L73;
        r15 = r28;
        r16 = r29;
        r11 = true;
    L73:
        if (r113 != 0) goto L75;
    L77:
        r12 = r30;
        r11 = true;
        goto L6
    L75:
        if (this.sourceMode == 1) goto L77;
        this.upstream.get().request(r113);
        goto L77
    L56:
        r16 = r23;
        goto L78
    L54:
        return;
    L51:
        r23 = false;
    L47:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.get().cancel();
        r21 = NotificationLite.error(th);
        this.terminalEvent = r21;
        r22 = null;
    L78:
        if (r113 == 0) goto L82;
        r11 = true;
        if (this.sourceMode == 1) goto L84;
        this.upstream.get().request(r114);
    L84:
        if (r111 == 0) goto L87;
        if (r16 == true) goto L87;
    L82:
        r11 = true;
        goto L84
    L27:
        Object r31 = this.terminalEvent;
        T r32 = r15.poll();     // Catch: Throwable -> L30
    L32:
        if (r32 != null) goto L34;
        boolean r33 = r11;
    L36:
        if (checkTerminated(r31, r33) == true) goto L37;
        if (this.sourceMode == r11) goto L6;
        this.upstream.get().request(1);
        goto L6
    L37:
        return;
    L34:
        r33 = false;
    L30:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.get().cancel();
        r31 = NotificationLite.error(th);
        this.terminalEvent = r31;
        r32 = null;
    L87:
        r13 = addAndGet(-r13);
        if (r13 == 0) goto L89;
        r12 = r10.get();
        goto L6
    L89:
        return;
    L15:
        return;
    L9:
        if (r15.isEmpty() == true) goto L12;
        r16 = false;
        goto L14
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        FlowablePublish$InnerSubscriber<T>[] r10 = this.subscribers.get();
        FlowablePublish$InnerSubscriber<T>[] r11 = TERMINATED;
        if (r10 != r11) goto L5;
        return;
    L5:
        if (this.subscribers.getAndSet(r11) == r11) goto L9;
        p.a(this.current, this, null);
        SubscriptionHelper.cancel(this.upstream);
        return;
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
        if (this.terminalEvent != null) goto L6;
        this.terminalEvent = NotificationLite.complete();
        dispatch();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.terminalEvent != null) goto L5;
        this.terminalEvent = NotificationLite.error(r10);
        dispatch();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.sourceMode == 0) goto L5;
    L8:
        dispatch();
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
        this.terminalEvent = NotificationLite.complete();
        dispatch();
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

    public void remove(FlowablePublish$InnerSubscriber<T> r10) {
    L2:
        FlowablePublish$InnerSubscriber<T>[] r11 = this.subscribers.get();
        int r12 = r11.length;
        if (r12 == 0) goto L20;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        if (r11[r13].equals(r10) == true) goto L12;
        r13 = r13 + 1;
    L12:
        if (r13 < 0) goto L13;
        if (r12 != 1) goto L17;
        FlowablePublish$InnerSubscriber[] r14 = EMPTY;
    L19:
        if (p.a(this.subscribers, r11, r14) == false) goto L2;
        return;
    L17:
        FlowablePublish$InnerSubscriber[] r15 = new FlowablePublish$InnerSubscriber[r12 - 1];
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
}
