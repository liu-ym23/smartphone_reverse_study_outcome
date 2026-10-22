package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class OperatorPublish$InnerProducer<T> extends AtomicLong implements Producer, Subscription {
    static final long NOT_REQUESTED = -4611686018427387904L;
    static final long UNSUBSCRIBED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    final Subscriber child;
    final p parent;

    public OperatorPublish$InnerProducer(p r10, Subscriber r11) {
        this.child = r11;
        lazySet(NOT_REQUESTED);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (get() != UNSUBSCRIBED) goto L5;
        return true;
    L5:
        return false;
    }

    public long produced(long r10) {
        if (r10 <= 0) goto L19;
    L4:
        long r11 = get();
        if (r11 == NOT_REQUESTED) goto L17;
        if (r11 == UNSUBSCRIBED) goto L8;
        long r12 = r11 - r10;
        if (r12 < 0) goto L15;
        if (compareAndSet(r11, r12) == false) goto L4;
        return r12;
    L15:
        throw new IllegalStateException("More produced (" + r10 + ") than requested (" + r11 + ")");
    L8:
        return UNSUBSCRIBED;
    L17:
        throw new IllegalStateException("Produced without request");
    L19:
        throw new IllegalArgumentException("Cant produce zero or less");
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 >= 0) goto L5;
        return;
    L5:
        long r11 = get();
        if (r11 == UNSUBSCRIBED) goto L7;
        if (r11 < 0) goto L13;
        if (r10 != 0) goto L13;
        return;
    L13:
        if (r11 != NOT_REQUESTED) goto L15;
        long r12 = r10;
    L19:
        if (compareAndSet(r11, r12) == false) goto L5;
        throw null;
    L15:
        r12 = r11 + r10;
        if (r12 >= 0) goto L19;
        r12 = Long.MAX_VALUE;
        goto L19
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (get() != UNSUBSCRIBED) goto L5;
        return;
    L5:
        if (getAndSet(UNSUBSCRIBED) != UNSUBSCRIBED) goto L8;
        return;
    L8:
        throw null;
    }
}
