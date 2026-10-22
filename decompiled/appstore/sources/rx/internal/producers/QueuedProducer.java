package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.a;
import rx.internal.util.atomic.e;
import rx.internal.util.unsafe.e0;
import rx.internal.util.unsafe.x;

/* JADX INFO: loaded from: classes4.dex */
public final class QueuedProducer<T> extends AtomicLong implements Producer, Observer<T> {
    static final Object NULL_SENTINEL = null;
    private static final long serialVersionUID = 7277121710709137047L;
    final Subscriber child;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    static {
        NULL_SENTINEL = new Object();
    }

    public QueuedProducer(Subscriber r10) {
        if (e0.b() == false) goto L5;
        Queue r11 = new x();
    L6:
        this(r10, r11);
        return;
    L5:
        r11 = new e();
        goto L6
    }

    private boolean checkTerminated(boolean r10, boolean r11) {
        if (this.child.isUnsubscribed() == false) goto L5;
        return true;
    L5:
        if (r10 == false) goto L13;
        Throwable r12 = this.error;
        if (r12 == null) goto L10;
        this.queue.clear();
        this.child.onError(r12);
        return true;
    L10:
        if (r11 == false) goto L15;
        this.child.onCompleted();
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void drain() {
        if (this.wip.getAndIncrement() != 0) goto L41;
        Subscriber r10 = this.child;
        Queue<Object> r11 = this.queue;
    L6:
        if (checkTerminated(this.done, r11.isEmpty()) == true) goto L7;
        this.wip.lazySet(1);
        long r12 = get();
        long r13 = 0;
    L10:
        if (r12 == 0) goto L35;
        boolean r14 = this.done;
        Object r15 = r11.poll();
        if (r15 != null) goto L14;
        boolean r16 = true;
    L16:
        if (checkTerminated(r14, r16) == true) goto L17;
        if (r15 == null) goto L35;
        if (r15 != NULL_SENTINEL) goto L26;
        r10.onNext(null);     // Catch: Throwable -> L24
    L27:
        r12 = r12 - 1;
        r13 = r13 + 1;
        goto L10
    L26:
        r10.onNext(r15);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        if (r15 != NULL_SENTINEL) goto L32;
        r15 = null;
    L32:
        a.g(th, r10, r15);
        return;
    L17:
        return;
    L14:
        r16 = false;
    L35:
        if (r13 == 0) goto L40;
        if (get() == Long.MAX_VALUE) goto L40;
        addAndGet(-r13);
    L40:
        if (this.wip.decrementAndGet() != 0) goto L6;
        return;
    L7:
        return;
    }

    public boolean offer(T r10) {
        if (r10 != null) goto L8;
        if (this.queue.offer(NULL_SENTINEL) == true) goto L10;
        return false;
    L10:
        drain();
        return true;
    L8:
        if (this.queue.offer(r10) == true) goto L10;
        return false;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onNext(T r10) {
        if (offer(r10) == true) goto L6;
        onError(new MissingBackpressureException());
        return;
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 < 0) goto L8;
        if (r10 <= 0) goto L9;
        rx.internal.operators.a.b(this, r10);
        drain();
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedProducer(Subscriber r10, Queue<Object> r11) {
        this.child = r10;
        this.queue = r11;
        this.wip = new AtomicInteger();
    }
}
