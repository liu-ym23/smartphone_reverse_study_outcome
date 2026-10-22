package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableFromIterable$IteratorConditionalSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    private static final long serialVersionUID = -6022804456014692607L;
    final ConditionalSubscriber<? super T> downstream;

    public FlowableFromIterable$IteratorConditionalSubscription(ConditionalSubscriber<? super T> r10, Iterator<? extends T> r11) {
        super(r11);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void fastPath() {
        Iterator<? extends T> r10 = this.it;
        ConditionalSubscriber<? super T> r11 = this.downstream;
    L4:
        if (this.cancelled == true) goto L5;
        T r12 = r10.next();     // Catch: Throwable -> L25
        if (this.cancelled == true) goto L9;
        if (r12 == null) goto L11;
        r11.tryOnNext(r12);
        if (this.cancelled == true) goto L15;
        if (r10.hasNext() == true) goto L4;
        if (this.cancelled == true) goto L38;
        r11.onComplete();
        return;
    L38:
        return;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r11.onError(th);
        return;
    L15:
        return;
    L11:
        r11.onError(new NullPointerException("Iterator.next() returned a null value"));
        return;
    L9:
        return;
    L25:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r11.onError(th);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
    public void slowPath(long r10) {
        Iterator<? extends T> r11 = this.it;
        ConditionalSubscriber<? super T> r12 = this.downstream;
    L3:
        long r13 = 0;
    L5:
        if (r13 != r10) goto L7;
        r10 = get();
        if (r13 != r10) goto L5;
        r10 = addAndGet(-r13);
        if (r10 != 0) goto L3;
        return;
    L7:
        if (this.cancelled == true) goto L8;
        T r14 = r11.next();     // Catch: Throwable -> L30
        if (this.cancelled == true) goto L12;
        if (r14 == null) goto L14;
        boolean r15 = r12.tryOnNext(r14);
        if (this.cancelled == true) goto L18;
        if (r11.hasNext() == false) goto L22;
        if (r15 == false) goto L5;
        r13 = r13 + 1;
        goto L5
    L22:
        if (this.cancelled == true) goto L57;
        r12.onComplete();
        return;
    L57:
        return;
    L27:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r12.onError(th);
        return;
    L18:
        return;
    L14:
        r12.onError(new NullPointerException("Iterator.next() returned a null value"));
        return;
    L12:
        return;
    L30:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r12.onError(th);
        return;
    }
}
