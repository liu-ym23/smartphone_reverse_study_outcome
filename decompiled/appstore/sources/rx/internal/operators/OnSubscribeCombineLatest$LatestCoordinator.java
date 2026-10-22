package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements Producer, Subscription {
    static final Object MISSING = null;
    private static final long serialVersionUID = 8567835998786448817L;
    int active;
    final Subscriber actual;
    final int bufferSize;
    volatile boolean cancelled;
    final FuncN<? extends R> combiner;
    int complete;
    final boolean delayError;
    volatile boolean done;
    final AtomicReference<Throwable> error;
    final Object[] latest;
    final rx.internal.util.atomic.d queue;
    final AtomicLong requested;
    final d[] subscribers;

    static {
        MISSING = new Object();
    }

    public OnSubscribeCombineLatest$LatestCoordinator(Subscriber r10, FuncN<? extends R> r11, int r12, int r13, boolean r14) {
        this.actual = r10;
        this.combiner = r11;
        this.bufferSize = r13;
        this.delayError = r14;
        Object[] r15 = new Object[r12];
        this.latest = r15;
        Arrays.fill(r15, MISSING);
        this.subscribers = new d[r12];
        this.queue = new rx.internal.util.atomic.d(r13);
        this.requested = new AtomicLong();
        this.error = new AtomicReference();
    }

    public void cancel(Queue<?> r10) {
        r10.clear();
        d[] r11 = this.subscribers;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13].unsubscribe();
        r13 = r13 + 1;
        goto L3
    }

    public boolean checkTerminated(boolean r10, boolean r11, Subscriber r12, Queue<?> r13, boolean r14) {
        if (this.cancelled == false) goto L6;
        cancel(r13);
        return true;
    L6:
        if (r10 == false) goto L21;
        if (r14 == false) goto L14;
        if (r11 == false) goto L23;
        Throwable r15 = this.error.get();
        if (r15 == null) goto L12;
        r12.onError(r15);
    L13:
        return true;
    L12:
        r12.onCompleted();
        goto L13
    L23:
        return false;
    L14:
        Throwable r16 = this.error.get();
        if (r16 == null) goto L18;
        cancel(r13);
        r12.onError(r16);
        return true;
    L18:
        if (r11 == false) goto L24;
        r12.onCompleted();
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    public void combine(Object r10, int r11) {
        d r12 = this.subscribers[r11];
        monitor-enter(this);
        Object[] r13 = this.latest;     // Catch: Throwable -> L7
        int r14 = r13.length;     // Catch: Throwable -> L7
        Object r15 = r13[r11];     // Catch: Throwable -> L7
        int r16 = this.active;     // Catch: Throwable -> L7
        Object r17 = MISSING;     // Catch: Throwable -> L7
        if (r15 != r17) goto L9;
        r16 = r16 + 1;     // Catch: Throwable -> L7
        this.active = r16;     // Catch: Throwable -> L7
    L9:
        int r18 = this.complete;     // Catch: Throwable -> L7
        if (r10 != null) goto L12;
        r18 = r18 + 1;     // Catch: Throwable -> L7
        this.complete = r18;     // Catch: Throwable -> L7
    L14:
        if (r16 != r14) goto L16;
        boolean r19 = true;
    L17:
        if (r18 == r14) goto L31;
        if (r10 != null) goto L21;
        if (r15 == r17) goto L31;
    L21:
        if (r10 == null) goto L24;
        if (r19 == false) goto L24;
        this.queue.l(r12, this.latest.clone());     // Catch: Throwable -> L7
    L32:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r19 == true) goto L37;
        if (r10 == null) goto L37;
        r12.b(1);
        return;
    L37:
        drain();
        return;
    L24:
        if (r10 != null) goto L32;
        if (this.error.get() == null) goto L32;
        if (r15 != r17) goto L29;
    L30:
        this.done = true;     // Catch: Throwable -> L7
        goto L32
    L29:
        if (this.delayError == true) goto L32;
    L31:
        this.done = true;     // Catch: Throwable -> L7
        goto L32
    L16:
        r19 = false;
        goto L17
    L12:
        r13[r11] = NotificationLite.d(r10);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        rx.internal.util.atomic.d r10 = this.queue;
        Subscriber r11 = this.actual;
        boolean r12 = this.delayError;
        AtomicLong r13 = this.requested;
        int r14 = 1;
    L7:
        if (checkTerminated(this.done, r10.isEmpty(), r11, r10, r12) == true) goto L8;
        long r15 = r13.get();
        long r16 = 0;
    L11:
        if (r16 == r15) goto L31;
        boolean r17 = this.done;
        d r18 = (d) r10.peek();
        if (r18 != null) goto L15;
        boolean r19 = true;
    L16:
        long r110 = r16;
        if (checkTerminated(r17, r19, r11, r10, r12) == true) goto L18;
        if (r19 == true) goto L20;
        r10.poll();
        Object[] r20 = (Object[]) r10.poll();
        if (r20 == null) goto L24;
        r11.onNext(this.combiner.call(r20));
        r18.b(1);
        r16 = r110 + 1;
    L28:
        th = move-exception;
        this.cancelled = true;
        cancel(r10);
        r11.onError(th);
        return;
    L24:
        this.cancelled = true;
        cancel(r10);
        r11.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
        return;
    L20:
        long r21 = r110;
    L33:
        if (r21 != 0) goto L35;
    L37:
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L7;
        return;
    L35:
        if (r15 == Long.MAX_VALUE) goto L37;
        a.c(r13, r21);
        goto L37
    L18:
        return;
    L15:
        r19 = false;
        goto L16
    L31:
        r21 = r16;
        goto L33
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.cancelled;
    }

    public void onError(Throwable r10) {
        AtomicReference<Throwable> r11 = this.error;
    L3:
        Throwable r12 = r11.get();
        if (r12 != null) goto L6;
        Throwable r13 = r10;
    L11:
        if (androidx.lifecycle.p.a(r11, r12, r13) == false) goto L3;
        return;
    L6:
        if ((r12 instanceof CompositeException) == false) goto L8;
        ArrayList r14 = new ArrayList(((CompositeException) r12).getExceptions());
        r14.add(r10);
        r13 = new CompositeException(r14);
        goto L11
    L8:
        r13 = new CompositeException(Arrays.asList(new Throwable[]{r12, r10}));
        goto L11
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

    public void subscribe(Observable[] r10) {
        d[] r11 = this.subscribers;
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r11[r14] = new d(this, r14);
        r14 = r14 + 1;
        goto L3
    L5:
        lazySet(0);
        this.actual.add(this);
        this.actual.setProducer(this);
    L6:
        if (r13 >= r12) goto L11;
        if (this.cancelled == true) goto L9;
        r10[r13].q(r11[r13]);
        r13 = r13 + 1;
        goto L6
    L9:
        return;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        if (getAndIncrement() != 0) goto L9;
        cancel(this.queue);
        return;
    L9:
        return;
    }
}
