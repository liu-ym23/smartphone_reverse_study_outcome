package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements Producer {
    private static final long serialVersionUID = 3534218984725836979L;
    final T[] array;
    final Subscriber child;
    int index;

    public OnSubscribeFromArray$FromArrayProducer(Subscriber r10, T[] r11) {
        this.child = r10;
        this.array = r11;
    }

    public void fastPath() {
        Subscriber r10 = this.child;
        T[] r11 = this.array;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        T r14 = r11[r13];
        if (r10.isUnsubscribed() == true) goto L6;
        r10.onNext(r14);
        r13 = r13 + 1;
        goto L3
    L6:
        return;
    L9:
        if (r10.isUnsubscribed() == false) goto L11;
        return;
    L11:
        r10.onCompleted();
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 < 0) goto L15;
        if (r10 == Long.MAX_VALUE) goto L7;
        if (r10 != 0) goto L11;
        return;
    L11:
        if (a.b(this, r10) != 0) goto L19;
        slowPath(r10);
        return;
    L19:
        return;
    L7:
        if (a.b(this, r10) != 0) goto L16;
        fastPath();
        return;
    L16:
        return;
    L15:
        throw new IllegalArgumentException("n >= 0 required but it was " + r10);
    }

    public void slowPath(long r11) {
        Subscriber r10 = this.child;
        T[] r12 = this.array;
        int r13 = r12.length;
        int r14 = this.index;
    L3:
        long r15 = 0;
    L5:
        if (r11 == 0) goto L17;
        if (r14 == r13) goto L17;
        if (r10.isUnsubscribed() == true) goto L9;
        r10.onNext(r12[r14]);
        r14 = r14 + 1;
        if (r14 == r13) goto L13;
        r11 = r11 - 1;
        r15 = r15 - 1;
        goto L5
    L13:
        if (r10.isUnsubscribed() == true) goto L33;
        r10.onCompleted();
        return;
    L33:
        return;
    L9:
        return;
    L17:
        r11 = get() + r15;
        if (r11 != 0) goto L5;
        this.index = r14;
        r11 = addAndGet(r15);
        if (r11 != 0) goto L3;
    }
}
