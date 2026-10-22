package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableRange$RangeSubscription extends FlowableRange$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final Subscriber<? super Integer> downstream;

    public FlowableRange$RangeSubscription(Subscriber<? super Integer> r10, int r11, int r12) {
        super(r11, r12);
        this.downstream = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void fastPath() {
        int r10 = this.end;
        Subscriber<? super Integer> r11 = this.downstream;
        int r12 = this.index;
    L3:
        if (r12 == r10) goto L9;
        if (this.cancelled == true) goto L6;
        r11.onNext(Integer.valueOf(r12));
        r12 = r12 + 1;
        goto L3
    L6:
        return;
    L9:
        if (this.cancelled == false) goto L11;
        return;
    L11:
        r11.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void slowPath(long r10) {
        int r11 = this.end;
        int r12 = this.index;
        Subscriber<? super Integer> r13 = this.downstream;
    L3:
        long r14 = 0;
    L5:
        if (r14 == r10) goto L11;
        if (r12 == r11) goto L11;
        if (this.cancelled == true) goto L9;
        r13.onNext(Integer.valueOf(r12));
        r14 = r14 + 1;
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    L11:
        if (r12 == r11) goto L13;
        r10 = get();
        if (r14 != r10) goto L5;
        this.index = r12;
        r10 = addAndGet(-r14);
        if (r10 != 0) goto L3;
        return;
    L13:
        if (this.cancelled == true) goto L32;
        r13.onComplete();
        return;
    }
}
