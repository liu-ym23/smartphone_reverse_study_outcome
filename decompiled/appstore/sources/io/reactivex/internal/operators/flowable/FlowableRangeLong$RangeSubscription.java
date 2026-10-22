package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableRangeLong$RangeSubscription extends FlowableRangeLong$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final Subscriber<? super Long> downstream;

    public FlowableRangeLong$RangeSubscription(Subscriber<? super Long> r10, long r11, long r12) {
        super(r11, r12);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void fastPath() {
        long r10 = this.end;
        Subscriber<? super Long> r11 = this.downstream;
        long r12 = this.index;
    L4:
        if (r12 == r10) goto L10;
        if (this.cancelled == true) goto L7;
        r11.onNext(Long.valueOf(r12));
        r12 = r12 + 1;
        goto L4
    L7:
        return;
    L10:
        if (this.cancelled == false) goto L12;
        return;
    L12:
        r11.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void slowPath(long r12) {
        long r10 = this.end;
        long r11 = this.index;
        Subscriber<? super Long> r13 = this.downstream;
    L3:
        long r14 = 0;
    L5:
        if (r14 == r12) goto L13;
        if (r11 == r10) goto L13;
        if (this.cancelled == true) goto L10;
        r13.onNext(Long.valueOf(r11));
        r14 = r14 + 1;
        r11 = r11 + 1;
        goto L5
    L10:
        return;
    L13:
        if (r11 == r10) goto L15;
        r12 = get();
        if (r14 != r12) goto L5;
        this.index = r11;
        r12 = addAndGet(-r14);
        if (r12 != 0) goto L3;
        return;
    L15:
        if (this.cancelled == true) goto L34;
        r13.onComplete();
        return;
    }
}
