package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class CachedObservable$ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
    private static final long serialVersionUID = -2557562030197141021L;
    final Subscriber child;
    Object[] currentBuffer;
    int currentIndexInBuffer;
    boolean emitting;
    int index;
    boolean missed;
    final b state;

    public CachedObservable$ReplayProducer(Subscriber r10, b r11) {
        this.child = r10;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (get() >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long produced(long r10) {
        return addAndGet(-r10);
    }

    public void replay() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.emitting == false) goto L10;
        this.missed = true;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.emitting = true;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L17:
        th = move-exception;
        monitor-enter(this);
        this.emitting = false;     // Catch: Throwable -> L23
        throw th;
    L23:
        th = move-exception;
        throw th;
    L13:
        if (get() >= 0) goto L16;
        return;
    L16:
        throw null;     // Catch: Throwable -> L17
    }

    @Override // rx.Producer
    public void request(long r10) {
    L2:
        long r11 = get();
        if (r11 < 0) goto L4;
        long r12 = r11 + r10;
        if (r12 >= 0) goto L9;
        r12 = Long.MAX_VALUE;
    L9:
        if (compareAndSet(r11, r12) == false) goto L2;
        replay();
        return;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (get() >= 0) goto L5;
        return;
    L5:
        if (getAndSet(-1) >= 0) goto L8;
        return;
    L8:
        throw null;
    }
}
