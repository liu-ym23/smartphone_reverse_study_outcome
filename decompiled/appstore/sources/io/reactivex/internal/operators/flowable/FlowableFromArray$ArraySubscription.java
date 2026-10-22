package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableFromArray$ArraySubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    private static final long serialVersionUID = 2587302975077663557L;
    final Subscriber<? super T> downstream;

    public FlowableFromArray$ArraySubscription(Subscriber<? super T> r10, T[] r11) {
        super(r11);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void fastPath() {
        T[] r10 = this.array;
        int r11 = r10.length;
        Subscriber<? super T> r12 = this.downstream;
        int r13 = this.index;
    L3:
        if (r13 == r11) goto L13;
        if (this.cancelled == true) goto L6;
        T r14 = r10[r13];
        if (r14 == null) goto L9;
        r12.onNext(r14);
        r13 = r13 + 1;
        goto L3
    L9:
        r12.onError(new NullPointerException("The element at index " + r13 + " is null"));
        return;
    L6:
        return;
    L13:
        if (this.cancelled == false) goto L15;
        return;
    L15:
        r12.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void slowPath(long r11) {
        T[] r10 = this.array;
        int r12 = r10.length;
        int r13 = this.index;
        Subscriber<? super T> r14 = this.downstream;
    L3:
        long r15 = 0;
    L5:
        if (r15 == r11) goto L15;
        if (r13 == r12) goto L15;
        if (this.cancelled == true) goto L9;
        T r16 = r10[r13];
        if (r16 == null) goto L12;
        r14.onNext(r16);
        r15 = r15 + 1;
        r13 = r13 + 1;
        goto L5
    L12:
        r14.onError(new NullPointerException("The element at index " + r13 + " is null"));
        return;
    L9:
        return;
    L15:
        if (r13 == r12) goto L17;
        r11 = get();
        if (r15 != r11) goto L5;
        this.index = r13;
        r11 = addAndGet(-r15);
        if (r11 != 0) goto L3;
        return;
    L17:
        if (this.cancelled == true) goto L37;
        r14.onComplete();
        return;
    }
}
