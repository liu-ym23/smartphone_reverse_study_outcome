package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class OperatorOnBackpressureLatest$LatestEmitter<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
    static final Object EMPTY = null;
    static final long NOT_REQUESTED = -4611686018427387904L;
    private static final long serialVersionUID = -1364393685005146274L;
    final Subscriber child;
    volatile boolean done;
    boolean emitting;
    boolean missed;
    o parent;
    Throwable terminal;
    final AtomicReference<Object> value;

    static {
        EMPTY = new Object();
    }

    public OperatorOnBackpressureLatest$LatestEmitter(Subscriber r10) {
        this.child = r10;
        this.value = new AtomicReference(EMPTY);
        lazySet(NOT_REQUESTED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void emit() {
        monitor-enter(this);
        boolean r10 = true;
        if (this.emitting == false) goto L10;
        this.missed = true;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.emitting = true;     // Catch: Throwable -> L8
        this.missed = false;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L66:
        long r11 = get();     // Catch: Throwable -> L20
        if (r11 == Long.MIN_VALUE) goto L70;
        Object r12 = this.value.get();     // Catch: Throwable -> L20
        if (r11 <= 0) goto L23;
        Object r13 = EMPTY;     // Catch: Throwable -> L20
        if (r12 == r13) goto L23;
        this.child.onNext(r12);     // Catch: Throwable -> L20
        androidx.lifecycle.p.a(this.value, r12, r13);     // Catch: Throwable -> L20
        produced(1);     // Catch: Throwable -> L20
        r12 = r13;
    L23:
        if (r12 == EMPTY) goto L25;
    L58:
        monitor-enter(this);     // Catch: Throwable -> L20
    L38:
        th = th;
        r10 = false;
    L43:
        monitor-exit(this);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        boolean r14 = r10;
        th = th;
    L47:
        if (r14 == true) goto L55;
        monitor-enter(this);
        this.emitting = false;     // Catch: Throwable -> L52
        monitor-exit(this);     // Catch: Throwable -> L52
        throw th;
    L52:
        th = move-exception;
        throw th;
    L55:
        throw th;
    L32:
        if (this.missed == false) goto L33;
        this.missed = false;     // Catch: Throwable -> L38
        monitor-exit(this);     // Catch: Throwable -> L38
        goto L66
    L33:
        this.emitting = false;     // Catch: Throwable -> L38
        monitor-exit(this);     // Catch: Throwable -> L36
        return;
    L36:
        th = th;
        goto L43
    L25:
        if (this.done == false) goto L58;
        Throwable r15 = this.terminal;     // Catch: Throwable -> L20
        if (r15 == null) goto L29;
        this.child.onError(r15);     // Catch: Throwable -> L20
        goto L58
    L29:
        this.child.onCompleted();     // Catch: Throwable -> L20
        goto L58
    L70:
        return;
    L20:
        th = th;
        r14 = false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (get() != Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.done = true;
        emit();
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        this.terminal = r10;
        this.done = true;
        emit();
    }

    @Override // rx.Observer
    public void onNext(T r10) {
        this.value.lazySet(r10);
        emit();
    }

    public long produced(long r10) {
    L2:
        long r11 = get();
        if (r11 < 0) goto L4;
        long r12 = r11 - r10;
        if (compareAndSet(r11, r12) == false) goto L2;
        return r12;
    L4:
        return r11;
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 < 0) goto L20;
    L4:
        long r11 = get();
        if (r11 == Long.MIN_VALUE) goto L6;
        if (r11 != NOT_REQUESTED) goto L10;
        long r12 = r10;
    L14:
        if (compareAndSet(r11, r12) == false) goto L4;
        if (r11 == NOT_REQUESTED) goto L19;
        emit();
        return;
    L19:
        throw null;
    L10:
        r12 = r11 + r10;
        if (r12 >= 0) goto L14;
        r12 = Long.MAX_VALUE;
        goto L14
    L6:
        return;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (get() < 0) goto L6;
        getAndSet(Long.MIN_VALUE);
        return;
    }
}
