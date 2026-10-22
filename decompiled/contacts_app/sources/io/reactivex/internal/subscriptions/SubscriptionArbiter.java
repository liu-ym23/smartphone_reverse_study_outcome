package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    Subscription actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    final AtomicLong missedProduced;
    final AtomicLong missedRequested;
    final AtomicReference<Subscription> missedSubscription;
    long requested;
    protected boolean unbounded;

    public SubscriptionArbiter(boolean r1) {
        this.cancelOnReplace = r1;
        this.missedSubscription = new AtomicReference();
        this.missedRequested = new AtomicLong();
        this.missedProduced = new AtomicLong();
    }

    public final void setSubscription(Subscription r5) {
        if (this.cancelled == false) goto L6;
        r5.cancel();
        return;
    L6:
        ObjectHelper.requireNonNull(r5, "s is null");
        if (get() == 0) goto L9;
    L22:
        Subscription r6 = this.missedSubscription.getAndSet(r5);
        if (r6 != null) goto L25;
    L27:
        drain();
        return;
    L25:
        if (this.cancelOnReplace == false) goto L27;
        r6.cancel();
        goto L27
    L9:
        if (compareAndSet(0, 1) == false) goto L22;
        Subscription r0 = this.actual;
        if (r0 != null) goto L13;
    L15:
        this.actual = r5;
        long r1 = this.requested;
        if (decrementAndGet() == 0) goto L19;
        drainLoop();
    L19:
        if (r1 == 0) goto L29;
        r5.request(r1);
        return;
    L29:
        return;
    L13:
        if (this.cancelOnReplace == false) goto L15;
        r0.cancel();
        goto L15
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long r7) {
        if (SubscriptionHelper.validate(r7) == true) goto L5;
        return;
    L5:
        if (this.unbounded == false) goto L8;
        return;
    L8:
        if (get() == 0) goto L10;
    L22:
        BackpressureHelper.add(this.missedRequested, r7);
        drain();
        return;
    L10:
        if (compareAndSet(0, 1) == false) goto L22;
        long r2 = this.requested;
        if (r2 == Long.MAX_VALUE) goto L16;
        long r3 = BackpressureHelper.addCap(r2, r7);
        this.requested = r3;
        if (r3 != Long.MAX_VALUE) goto L16;
        this.unbounded = true;
    L16:
        Subscription r0 = this.actual;
        if (decrementAndGet() == 0) goto L19;
        drainLoop();
    L19:
        if (r0 == null) goto L24;
        r0.request(r7);
        return;
    }

    public final void produced(long r5) {
        if (this.unbounded == false) goto L6;
        return;
    L6:
        if (get() == 0) goto L8;
    L20:
        BackpressureHelper.add(this.missedProduced, r5);
        drain();
        return;
    L8:
        if (compareAndSet(0, 1) == false) goto L20;
        long r0 = this.requested;
        if (r0 == Long.MAX_VALUE) goto L16;
        long r1 = r0 - r5;
        if (r1 >= 0) goto L14;
        SubscriptionHelper.reportMoreProduced(r1);
        r1 = 0;
    L14:
        this.requested = r1;
    L16:
        if (decrementAndGet() != 0) goto L18;
        return;
    L18:
        drainLoop();
    }

    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        drain();
        return;
    }

    final void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        drainLoop();
    }

    final void drainLoop() {
        int r1 = 1;
        long r5 = 0;
        Subscription r7 = null;
    L3:
        Subscription r8 = this.missedSubscription.get();
        if (r8 == null) goto L6;
        r8 = this.missedSubscription.getAndSet(null);
    L6:
        long r9 = this.missedRequested.get();
        if (r9 == 0) goto L9;
        r9 = this.missedRequested.getAndSet(0);
    L9:
        long r11 = this.missedProduced.get();
        if (r11 == 0) goto L12;
        r11 = this.missedProduced.getAndSet(0);
    L12:
        Subscription r13 = this.actual;
        if (this.cancelled == false) goto L18;
        if (r13 == null) goto L16;
        r13.cancel();
        this.actual = null;
    L16:
        if (r8 == null) goto L38;
        r8.cancel();
    L38:
        r1 = addAndGet(-r1);
        if (r1 != 0) goto L3;
        if (r5 == 0) goto L46;
        r7.request(r5);
        return;
    L46:
        return;
    L18:
        long r14 = this.requested;
        if (r14 == Long.MAX_VALUE) goto L26;
        r14 = BackpressureHelper.addCap(r14, r9);
        if (r14 == Long.MAX_VALUE) goto L25;
        r14 = r14 - r11;
        if (r14 >= 0) goto L25;
        SubscriptionHelper.reportMoreProduced(r14);
        r14 = 0;
    L25:
        this.requested = r14;
    L26:
        if (r8 == null) goto L34;
        if (r13 != null) goto L29;
    L31:
        this.actual = r8;
        if (r14 == 0) goto L38;
        r5 = BackpressureHelper.addCap(r5, r14);
        r7 = r8;
        goto L38
    L29:
        if (this.cancelOnReplace == false) goto L31;
        r13.cancel();
        goto L31
    L34:
        if (r13 == null) goto L38;
        if (r9 == 0) goto L38;
        r5 = BackpressureHelper.addCap(r5, r9);
        r7 = r13;
        goto L38
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }
}
