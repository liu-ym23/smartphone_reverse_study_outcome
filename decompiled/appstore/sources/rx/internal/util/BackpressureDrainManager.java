package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* JADX INFO: loaded from: classes4.dex */
public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    final BackpressureQueueCallback actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    public interface BackpressureQueueCallback {
        boolean accept(Object r10);

        void complete(Throwable r10);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback r10) {
        this.actual = r10;
    }

    public void drain() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.emitting == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        boolean r10 = true;
        this.emitting = true;     // Catch: Throwable -> L7
        boolean r11 = this.terminated;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        long r12 = get();
        BackpressureQueueCallback r13 = this.actual;     // Catch: Throwable -> L26
    L13:
        int r14 = 0;
    L85:
        if (r12 > 0) goto L17;
        if (r11 == true) goto L17;
    L86:
        monitor-enter(this);     // Catch: Throwable -> L26
        r11 = this.terminated;     // Catch: Throwable -> L56
        if (r13.peek() == null) goto L34;
        boolean r15 = true;
    L37:
        if (get() != Long.MAX_VALUE) goto L47;
        if (r15 == true) goto L45;
        if (r11 == true) goto L45;
        this.emitting = false;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return;
    L45:
        r12 = Long.MAX_VALUE;
    L54:
        monitor-exit(this);     // Catch: Throwable -> L56
        goto L13
    L47:
        long r16 = addAndGet(-r14);     // Catch: Throwable -> L56
        if (r16 == 0) goto L50;
        if (r15 == false) goto L50;
    L53:
        r12 = r16;
    L50:
        if (r11 == false) goto L58;
        if (r15 == false) goto L53;
    L58:
        this.emitting = false;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return;
    L34:
        r15 = false;
    L56:
        th = th;
    L61:
        monitor-exit(this);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L22
    L43:
        th = th;
    L17:
        if (r11 == true) goto L19;
    L28:
        Object r17 = r13.poll();     // Catch: Throwable -> L26
        if (r17 == null) goto L86;
        if (r13.accept(r17) == true) goto L65;
        r12 = r12 - 1;
        r14 = r14 + 1;
        goto L85
    L65:
        return;
    L19:
        if (r13.peek() == null) goto L20;
        if (r12 != 0) goto L28;
    L20:
        r13.complete(this.exception);     // Catch: Throwable -> L22
        return;
    L22:
        th = th;
    L67:
        if (r10 == true) goto L75;
        monitor-enter(this);
        this.emitting = false;     // Catch: Throwable -> L72
        monitor-exit(this);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        throw th;
    L75:
        throw th;
    L26:
        th = th;
        r10 = false;
        goto L67
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    @Override // rx.Producer
    public void request(long r11) {
        if (r11 != 0) goto L5;
        return;
    L5:
        long r10 = get();
        boolean r12 = true;
        if (r10 != 0) goto L8;
        boolean r13 = true;
    L9:
        long r14 = Long.MAX_VALUE;
        if (r10 == Long.MAX_VALUE) goto L22;
        if (r11 != Long.MAX_VALUE) goto L16;
        r14 = r11;
    L20:
        if (compareAndSet(r10, r14) == false) goto L5;
        r13 = r12;
        goto L22
    L16:
        if (r10 <= (Long.MAX_VALUE - r11)) goto L18;
    L17:
        r12 = r13;
        goto L20
    L18:
        r14 = r10 + r11;
    L22:
        if (r13 == false) goto L28;
        drain();
        return;
    L28:
        return;
    L8:
        r13 = false;
        goto L9
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminate(Throwable r10) {
        if (this.terminated == true) goto L6;
        this.exception = r10;
        this.terminated = true;
        return;
    }

    public void terminateAndDrain(Throwable r10) {
        if (this.terminated == true) goto L6;
        this.exception = r10;
        this.terminated = true;
        drain();
        return;
    }
}
