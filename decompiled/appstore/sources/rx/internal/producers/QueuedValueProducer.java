package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.a;
import rx.internal.util.atomic.e;
import rx.internal.util.unsafe.e0;
import rx.internal.util.unsafe.x;

/* JADX INFO: loaded from: classes4.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements Producer {
    static final Object NULL_SENTINEL = null;
    private static final long serialVersionUID = 7277121710709137047L;
    final Subscriber child;
    final Queue<Object> queue;
    final AtomicInteger wip;

    static {
        NULL_SENTINEL = new Object();
    }

    public QueuedValueProducer(Subscriber r10) {
        if (e0.b() == false) goto L5;
        Queue r11 = new x();
    L6:
        this(r10, r11);
        return;
    L5:
        r11 = new e();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void drain() {
        if (this.wip.getAndIncrement() != 0) goto L37;
        Subscriber r10 = this.child;
        Queue<Object> r11 = this.queue;
    L6:
        if (r10.isUnsubscribed() == true) goto L7;
        this.wip.lazySet(1);
        long r12 = get();
        long r13 = 0;
    L10:
        if (r12 == 0) goto L31;
        Object r14 = r11.poll();
        if (r14 == null) goto L31;
        if (r14 != NULL_SENTINEL) goto L19;
        r10.onNext(null);     // Catch: Throwable -> L17
    L21:
        if (r10.isUnsubscribed() == true) goto L22;
        r12 = r12 - 1;
        r13 = r13 + 1;
        goto L10
    L22:
        return;
    L19:
        r10.onNext(r14);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r14 != NULL_SENTINEL) goto L28;
        r14 = null;
    L28:
        a.g(th, r10, r14);
        return;
    L31:
        if (r13 == 0) goto L36;
        if (get() == Long.MAX_VALUE) goto L36;
        addAndGet(-r13);
    L36:
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

    public QueuedValueProducer(Subscriber r10, Queue<Object> r11) {
        this.child = r10;
        this.queue = r11;
        this.wip = new AtomicInteger();
    }
}
