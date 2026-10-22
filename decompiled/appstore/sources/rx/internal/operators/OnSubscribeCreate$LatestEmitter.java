package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeCreate$LatestEmitter<T> extends OnSubscribeCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 4023437720691792495L;
    volatile boolean done;
    Throwable error;
    final AtomicReference<Object> queue;
    final AtomicInteger wip;

    public OnSubscribeCreate$LatestEmitter(Subscriber r10) {
        super(r10);
        this.queue = new AtomicReference();
        this.wip = new AtomicInteger();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber r10 = this.actual;
        AtomicReference<Object> r11 = this.queue;
        int r12 = 1;
    L6:
        long r13 = get();
        long r14 = 0;
    L7:
        boolean r15 = false;
        if (r14 == r13) goto L27;
        if (r10.isUnsubscribed() == true) goto L11;
        boolean r16 = this.done;
        Object r17 = r11.getAndSet(null);
        if (r17 != null) goto L16;
        boolean r18 = true;
    L17:
        if (r16 == false) goto L24;
        if (r18 == false) goto L24;
        Throwable r19 = this.error;
        if (r19 == null) goto L22;
        super.onError(r19);
        return;
    L22:
        super.onCompleted();
        return;
    L24:
        if (r18 == true) goto L27;
        r10.onNext(NotificationLite.d(r17));
        r14 = r14 + 1;
        goto L7
    L16:
        r18 = false;
        goto L17
    L11:
        r11.lazySet(null);
        return;
    L27:
        if (r14 != r13) goto L43;
        if (r10.isUnsubscribed() == true) goto L30;
        boolean r20 = this.done;
        if (r11.get() != null) goto L35;
        r15 = true;
    L35:
        if (r20 == false) goto L43;
        if (r15 == false) goto L43;
        Throwable r21 = this.error;
        if (r21 == null) goto L40;
        super.onError(r21);
        return;
    L40:
        super.onCompleted();
        return;
    L30:
        r11.lazySet(null);
        return;
    L43:
        if (r14 == 0) goto L45;
        a.c(this, r14);
    L45:
        r12 = this.wip.addAndGet(-r12);
        if (r12 != 0) goto L6;
    }

    @Override // rx.internal.operators.OnSubscribeCreate$BaseEmitter, rx.Observer
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeCreate$BaseEmitter, rx.Observer
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onNext(T r10) {
        this.queue.set(NotificationLite.g(r10));
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeCreate$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeCreate$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() != 0) goto L6;
        this.queue.lazySet(null);
        return;
    }
}
