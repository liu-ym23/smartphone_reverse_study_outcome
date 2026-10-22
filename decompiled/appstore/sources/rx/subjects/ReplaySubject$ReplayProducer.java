package rx.subjects;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements Producer, Subscription {
    private static final long serialVersionUID = -5006209596735204567L;
    final Subscriber actual;
    int index;
    Object node;
    final AtomicLong requested;
    final ReplaySubject$ReplayState<T> state;
    int tailIndex;

    public ReplaySubject$ReplayProducer(Subscriber r10, ReplaySubject$ReplayState<T> r11) {
        this.actual = r10;
        this.requested = new AtomicLong();
        this.state = r11;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 <= 0) goto L5;
        rx.internal.operators.a.b(this.requested, r10);
        this.state.buffer.drain(this);
        return;
    L5:
        if (r10 < 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("n >= required but it was " + r10);
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.state.remove(this);
    }
}
