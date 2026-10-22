package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Subscriber;
import rx.internal.util.unsafe.e0;
import rx.internal.util.unsafe.y;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeCreate$BufferEmitter<T> extends OnSubscribeCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 2427151001689639875L;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public OnSubscribeCreate$BufferEmitter(Subscriber r10, int r11) {
        super(r10);
        if (e0.b() == false) goto L5;
        Queue<Object> r12 = new y(r11);
    L6:
        this.queue = r12;
        this.wip = new AtomicInteger();
        return;
    L5:
        r12 = new rx.internal.util.atomic.f(r11);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber r10 = this.actual;
        Queue<Object> r11 = this.queue;
        int r12 = 1;
    L6:
        long r13 = get();
        long r14 = 0;
    L8:
        if (r14 == r13) goto L27;
        if (r10.isUnsubscribed() == true) goto L11;
        boolean r15 = this.done;
        Object r16 = r11.poll();
        if (r16 != null) goto L16;
        boolean r17 = true;
    L17:
        if (r15 == false) goto L24;
        if (r17 == false) goto L24;
        Throwable r18 = this.error;
        if (r18 == null) goto L22;
        super.onError(r18);
        return;
    L22:
        super.onCompleted();
        return;
    L24:
        if (r17 == true) goto L27;
        r10.onNext(NotificationLite.d(r16));
        r14 = r14 + 1;
        goto L8
    L16:
        r17 = false;
        goto L17
    L11:
        r11.clear();
        return;
    L27:
        if (r14 != r13) goto L41;
        if (r10.isUnsubscribed() == true) goto L30;
        boolean r19 = this.done;
        boolean r20 = r11.isEmpty();
        if (r19 == false) goto L41;
        if (r20 == false) goto L41;
        Throwable r21 = this.error;
        if (r21 == null) goto L38;
        super.onError(r21);
        return;
    L38:
        super.onCompleted();
        return;
    L30:
        r11.clear();
        return;
    L41:
        if (r14 == 0) goto L43;
        a.c(this, r14);
    L43:
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
        this.queue.offer(NotificationLite.g(r10));
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeCreate$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // rx.internal.operators.OnSubscribeCreate$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }
}
