package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class OperatorGroupBy$State<T, K> extends AtomicInteger implements Producer, Subscription, Observable.OnSubscribe<T> {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<Subscriber> actual;
    final AtomicBoolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once;
    final k parent;
    final Queue<Object> queue;
    final AtomicLong requested;

    public OperatorGroupBy$State(int r10, k r11, K r12, boolean r13) {
        this.queue = new ConcurrentLinkedQueue();
        this.key = r12;
        this.delayError = r13;
        this.cancelled = new AtomicBoolean();
        this.actual = new AtomicReference();
        this.once = new AtomicBoolean();
        this.requested = new AtomicLong();
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    public boolean checkTerminated(boolean r10, boolean r11, Subscriber r12, boolean r13) {
        if (this.cancelled.get() == true) goto L22;
        if (r10 == true) goto L6;
        return false;
    L6:
        if (r13 == false) goto L13;
        if (r11 == false) goto L24;
        Throwable r14 = this.error;
        if (r14 == null) goto L11;
        r12.onError(r14);
    L12:
        return true;
    L11:
        r12.onCompleted();
        goto L12
    L24:
        return false;
    L13:
        Throwable r15 = this.error;
        if (r15 == null) goto L17;
        this.queue.clear();
        r12.onError(r15);
        return true;
    L17:
        if (r11 == false) goto L25;
        r12.onCompleted();
        return true;
    L25:
        return false;
    L22:
        this.queue.clear();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Queue<Object> r10 = this.queue;
        boolean r11 = this.delayError;
        Subscriber r12 = this.actual.get();
        int r13 = 1;
    L6:
        if (r12 != 0) goto L8;
    L30:
        r13 = addAndGet(-r13);
        if (r13 == 0) goto L32;
        if (r12 != 0) goto L6;
        r12 = this.actual.get();
        goto L6
    L32:
        return;
    L8:
        if (checkTerminated(this.done, r10.isEmpty(), r12, r11) == true) goto L9;
        long r14 = this.requested.get();
        long r15 = 0;
    L12:
        if (r15 == r14) goto L24;
        boolean r16 = this.done;
        Object r17 = r10.poll();
        if (r17 != null) goto L16;
        boolean r18 = true;
    L18:
        if (checkTerminated(r16, r18, r12, r11) == true) goto L19;
        if (r18 == true) goto L24;
        r12.onNext(NotificationLite.d(r17));
        r15 = r15 + 1;
        goto L12
    L19:
        return;
    L16:
        r18 = false;
    L24:
        if (r15 == 0) goto L30;
        if (r14 == Long.MAX_VALUE) goto L29;
        a.c(this.requested, r15);
    L29:
        throw null;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.cancelled.get();
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
        if (r10 != null) goto L4;
        this.error = new NullPointerException();
        this.done = true;
    L5:
        drain();
        return;
    L4:
        this.queue.offer(NotificationLite.g(r10));
        goto L5
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 < 0) goto L8;
        if (r10 == 0) goto L9;
        a.b(this.requested, r10);
        drain();
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("n >= required but it was " + r10);
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.cancelled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (getAndIncrement() == 0) goto L8;
        return;
    L8:
        throw null;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(Subscriber r10) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        r10.add(this);
        r10.setProducer(this);
        this.actual.lazySet(r10);
        drain();
        return;
    L5:
        r10.onError(new IllegalStateException("Only one Subscriber allowed!"));
    }
}
