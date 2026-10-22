package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final Subscriber<? super V> downstream;
    protected Throwable error;
    protected final SimplePlainQueue<U> queue;

    public boolean accept(Subscriber<? super V> r1, U r2) {
        return false;
    }

    public QueueDrainSubscriber(Subscriber<? super V> r1, SimplePlainQueue<U> r2) {
        this.downstream = r1;
        this.queue = r2;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean enter() {
        if (this.wip.getAndIncrement() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean fastEnter() {
        if (this.wip.get() == 0) goto L5;
        return false;
    L5:
        if (this.wip.compareAndSet(0, 1) == true) goto L7;
        return false;
    L7:
        return true;
    }

    protected final void fastPathEmitMax(U r7, boolean r8, Disposable r9) {
        Subscriber<? super V> r0 = this.downstream;
        SimplePlainQueue<U> r1 = this.queue;
        if (fastEnter() == false) goto L16;
        long r2 = this.requested.get();
        if (r2 != 0) goto L7;
        r9.dispose();
        r0.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
        return;
    L7:
        if (accept(r0, r7) == false) goto L12;
        if (r2 == Long.MAX_VALUE) goto L12;
        produced(1);
    L12:
        if (leave(-1) != 0) goto L19;
        return;
    L19:
        QueueDrainHelper.drainMaxLoop(r1, r0, r8, r9, this);
        return;
    L16:
        r1.offer(r7);
        if (enter() == true) goto L19;
    }

    protected final void fastPathOrderedEmitMax(U r7, boolean r8, Disposable r9) {
        Subscriber<? super V> r0 = this.downstream;
        SimplePlainQueue<U> r1 = this.queue;
        if (fastEnter() == false) goto L19;
        long r2 = this.requested.get();
        if (r2 != 0) goto L7;
        this.cancelled = true;
        r9.dispose();
        r0.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
        return;
    L7:
        if (r1.isEmpty() == true) goto L9;
        r1.offer(r7);
    L22:
        QueueDrainHelper.drainMaxLoop(r1, r0, r8, r9, this);
        return;
    L9:
        if (accept(r0, r7) == false) goto L14;
        if (r2 == Long.MAX_VALUE) goto L14;
        produced(1);
    L14:
        if (leave(-1) != 0) goto L22;
        return;
    L19:
        r1.offer(r7);
        if (enter() == true) goto L22;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final Throwable error() {
        return this.error;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final int leave(int r1) {
        return this.wip.addAndGet(r1);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long requested() {
        return this.requested.get();
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long produced(long r1) {
        return this.requested.addAndGet(-r1);
    }

    public final void requested(long r2) {
        if (SubscriptionHelper.validate(r2) == false) goto L6;
        BackpressureHelper.add(this.requested, r2);
        return;
    }
}
