package io.reactivex.internal.operators.flowable;

import androidx.lifecycle.p;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableReplay$ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
    static final FlowableReplay$InnerSubscription[] EMPTY = null;
    static final FlowableReplay$InnerSubscription[] TERMINATED = null;
    private static final long serialVersionUID = 7224554242710036740L;
    final FlowableReplay$ReplayBuffer<T> buffer;
    boolean done;
    final AtomicInteger management;
    long maxChildRequested;
    long maxUpstreamRequested;
    final AtomicBoolean shouldConnect;
    final AtomicReference<FlowableReplay$InnerSubscription<T>[]> subscribers;

    static {
        EMPTY = new FlowableReplay$InnerSubscription[0];
        TERMINATED = new FlowableReplay$InnerSubscription[0];
    }

    public FlowableReplay$ReplaySubscriber(FlowableReplay$ReplayBuffer<T> r10) {
        this.buffer = r10;
        this.management = new AtomicInteger();
        this.subscribers = new AtomicReference(EMPTY);
        this.shouldConnect = new AtomicBoolean();
    }

    public boolean add(FlowableReplay$InnerSubscription<T> r10) {
        if (r10 == null) goto L11;
    L3:
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        if (r11 == TERMINATED) goto L5;
        int r12 = r11.length;
        FlowableReplay$InnerSubscription[] r13 = new FlowableReplay$InnerSubscription[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (p.a(this.subscribers, r11, r13) == false) goto L3;
        return true;
    L5:
        return false;
    L11:
        throw null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.subscribers.set(TERMINATED);
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.subscribers.get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    public void manageRequests() {
        if (this.management.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r10 = 1;
    L7:
        if (isDisposed() == true) goto L8;
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        long r12 = this.maxChildRequested;
        int r13 = r11.length;
        int r14 = 0;
        long r15 = r12;
    L10:
        if (r14 >= r13) goto L12;
        r15 = Math.max(r15, r11[r14].totalRequested.get());
        r14 = r14 + 1;
        goto L10
    L12:
        long r16 = this.maxUpstreamRequested;
        Subscription r17 = get();
        long r18 = r15 - r12;
        if (r18 == 0) goto L25;
        this.maxChildRequested = r15;
        if (r17 != null) goto L17;
        long r19 = r16 + r18;
        if (r19 >= 0) goto L23;
        r19 = Long.MAX_VALUE;
    L23:
        this.maxUpstreamRequested = r19;
    L28:
        r10 = this.management.addAndGet(-r10);
        if (r10 != 0) goto L7;
        return;
    L17:
        if (r16 == 0) goto L19;
        this.maxUpstreamRequested = 0;
        r17.request(r16 + r18);
        goto L28
    L19:
        r17.request(r18);
        goto L28
    L25:
        if (r16 == 0) goto L28;
        if (r17 == null) goto L28;
        this.maxUpstreamRequested = 0;
        r17.request(r16);
        goto L28
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == true) goto L7;
        this.done = true;
        this.buffer.complete();
        FlowableReplay$InnerSubscription<T>[] r10 = this.subscribers.getAndSet(TERMINATED);
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        FlowableReplay$InnerSubscription<T> r13 = r10[r12];
        this.buffer.replay(r13);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == true) goto L7;
        this.done = true;
        this.buffer.error(r10);
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.getAndSet(TERMINATED);
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        FlowableReplay$InnerSubscription<T> r14 = r11[r13];
        this.buffer.replay(r14);
        r13 = r13 + 1;
        goto L5
    L10:
        return;
    L7:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == true) goto L7;
        this.buffer.next(r10);
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        FlowableReplay$InnerSubscription<T> r14 = r11[r13];
        this.buffer.replay(r14);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.setOnce(this, r10) == false) goto L7;
        manageRequests();
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        FlowableReplay$InnerSubscription<T> r14 = r11[r13];
        this.buffer.replay(r14);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void remove(FlowableReplay$InnerSubscription<T> r10) {
    L2:
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        if (r11[r13].equals(r10) == true) goto L12;
        r13 = r13 + 1;
    L12:
        if (r13 < 0) goto L13;
        if (r12 != 1) goto L17;
        FlowableReplay$InnerSubscription[] r14 = EMPTY;
    L19:
        if (p.a(this.subscribers, r11, r14) == false) goto L2;
        return;
    L17:
        FlowableReplay$InnerSubscription[] r15 = new FlowableReplay$InnerSubscription[r12 - 1];
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
