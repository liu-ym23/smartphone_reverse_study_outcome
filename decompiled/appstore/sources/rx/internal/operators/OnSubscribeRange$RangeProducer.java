package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeRange$RangeProducer extends AtomicLong implements Producer {
    private static final long serialVersionUID = 4114392207069098388L;
    private final Subscriber childSubscriber;
    private long currentIndex;
    private final int endOfRange;

    public OnSubscribeRange$RangeProducer(Subscriber r10, int r11, int r12) {
        this.childSubscriber = r10;
        this.currentIndex = r11;
        this.endOfRange = r12;
    }

    public void fastPath() {
        long r10 = ((long) this.endOfRange) + 1;
        Subscriber r11 = this.childSubscriber;
        long r12 = this.currentIndex;
    L4:
        if (r12 == r10) goto L10;
        if (r11.isUnsubscribed() == true) goto L7;
        r11.onNext(Integer.valueOf((int) r12));
        r12 = r12 + 1;
        goto L4
    L7:
        return;
    L10:
        if (r11.isUnsubscribed() == true) goto L15;
        r11.onCompleted();
        return;
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (get() != Long.MAX_VALUE) goto L6;
        return;
    L6:
        if (r10 != Long.MAX_VALUE) goto L11;
        if (compareAndSet(0, Long.MAX_VALUE) == false) goto L11;
        fastPath();
        return;
    L11:
        if (r10 > 0) goto L13;
        return;
    L13:
        if (a.b(this, r10) != 0) goto L18;
        slowPath(r10);
        return;
    }

    public void slowPath(long r13) {
        long r10 = ((long) this.endOfRange) + 1;
        long r11 = this.currentIndex;
        Subscriber r12 = this.childSubscriber;
    L3:
        long r14 = 0;
    L5:
        if (r14 == r13) goto L13;
        if (r11 == r10) goto L13;
        if (r12.isUnsubscribed() == true) goto L10;
        r12.onNext(Integer.valueOf((int) r11));
        r11 = r11 + 1;
        r14 = r14 + 1;
        goto L5
    L10:
        return;
    L13:
        if (r12.isUnsubscribed() == true) goto L14;
        if (r11 == r10) goto L17;
        r13 = get();
        if (r13 != r14) goto L5;
        this.currentIndex = r11;
        r13 = addAndGet(-r14);
        if (r13 != 0) goto L3;
        return;
    L17:
        r12.onCompleted();
        return;
    }
}
