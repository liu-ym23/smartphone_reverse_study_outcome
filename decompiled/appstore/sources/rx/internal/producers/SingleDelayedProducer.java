package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.a;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements Producer {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    final Subscriber child;
    T value;

    public SingleDelayedProducer(Subscriber r10) {
        this.child = r10;
    }

    private static <T> void emit(Subscriber r10, T r11) {
        if (r10.isUnsubscribed() == false) goto L14;
        return;
    L14:
        r10.onNext(r11);     // Catch: Throwable -> L11
        if (r10.isUnsubscribed() == false) goto L9;
        return;
    L9:
        r10.onCompleted();
        return;
    L11:
        th = move-exception;
        a.g(th, r10, r11);
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 < 0) goto L18;
        if (r10 != 0) goto L6;
        return;
    L6:
        int r11 = get();
        if (r11 != 0) goto L12;
        if (compareAndSet(0, 2) == false) goto L6;
        return;
    L12:
        if (r11 == 1) goto L14;
        return;
    L14:
        if (compareAndSet(1, 3) == false) goto L23;
        emit(this.child, this.value);
        return;
    L23:
        return;
    L18:
        throw new IllegalArgumentException("n >= 0 required");
    }

    public void setValue(T r10) {
    L2:
        int r11 = get();
        if (r11 != 0) goto L8;
        this.value = r10;
        if (compareAndSet(0, 1) == false) goto L2;
        return;
    L8:
        if (r11 == 2) goto L10;
        return;
    L10:
        if (compareAndSet(2, 3) == false) goto L17;
        emit(this.child, r10);
        return;
    }
}
