package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableCreate$LatestAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 4023437720691792495L;
    volatile boolean done;
    Throwable error;
    final AtomicReference<T> queue;
    final AtomicInteger wip;

    public FlowableCreate$LatestAsyncEmitter(Subscriber<? super T> r10) {
        super(r10);
        this.queue = new AtomicReference();
        this.wip = new AtomicInteger();
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super T> r10 = this.downstream;
        AtomicReference<T> r11 = this.queue;
        int r12 = 1;
    L6:
        long r13 = get();
        long r14 = 0;
    L7:
        boolean r15 = false;
        if (r14 == r13) goto L27;
        if (isCancelled() == true) goto L11;
        boolean r16 = this.done;
        T r17 = r11.getAndSet(null);
        if (r17 != null) goto L16;
        boolean r18 = true;
    L17:
        if (r16 == false) goto L24;
        if (r18 == false) goto L24;
        Throwable r19 = this.error;
        if (r19 == null) goto L22;
        error(r19);
        return;
    L22:
        complete();
        return;
    L24:
        if (r18 == true) goto L27;
        r10.onNext(r17);
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
        if (isCancelled() == true) goto L30;
        boolean r20 = this.done;
        if (r11.get() != null) goto L35;
        r15 = true;
    L35:
        if (r20 == false) goto L43;
        if (r15 == false) goto L43;
        Throwable r21 = this.error;
        if (r21 == null) goto L40;
        error(r21);
        return;
    L40:
        complete();
        return;
    L30:
        r11.lazySet(null);
        return;
    L43:
        if (r14 == 0) goto L45;
        io.reactivex.internal.util.a.e(this, r14);
    L45:
        r12 = this.wip.addAndGet(-r12);
        if (r12 != 0) goto L6;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, io.reactivex.Emitter
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Emitter
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        if (isCancelled() == true) goto L13;
        if (r10 != null) goto L10;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L10:
        this.queue.set(r10);
        drain();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onRequested() {
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
    public void onUnsubscribed() {
        if (this.wip.getAndIncrement() != 0) goto L6;
        this.queue.lazySet(null);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, io.reactivex.FlowableEmitter
    public boolean tryOnError(Throwable r10) {
        if (this.done == false) goto L5;
        return false;
    L5:
        if (isCancelled() == true) goto L13;
        if (r10 != null) goto L9;
        onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
    L9:
        this.error = r10;
        this.done = true;
        drain();
        return true;
    L13:
        return false;
    }
}
