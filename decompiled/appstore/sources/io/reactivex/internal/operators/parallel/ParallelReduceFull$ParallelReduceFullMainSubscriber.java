package io.reactivex.internal.operators.parallel;

import androidx.lifecycle.p;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.a;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class ParallelReduceFull$ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
    private static final long serialVersionUID = -5370107872170712765L;
    final AtomicReference<ParallelReduceFull$SlotPair<T>> current;
    final AtomicReference<Throwable> error;
    final BiFunction<T, T, T> reducer;
    final AtomicInteger remaining;
    final ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] subscribers;

    public ParallelReduceFull$ParallelReduceFullMainSubscriber(Subscriber<? super T> r10, int r11, BiFunction<T, T, T> r12) {
        super(r10);
        this.current = new AtomicReference();
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference();
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] r13 = new ParallelReduceFull$ParallelReduceFullInnerSubscriber[r11];
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13[r14] = new ParallelReduceFull$ParallelReduceFullInnerSubscriber(this, r12);
        r14 = r14 + 1;
        goto L3
    L5:
        this.subscribers = r13;
        this.reducer = r12;
        this.remaining.lazySet(r11);
    }

    public ParallelReduceFull$SlotPair<T> addValue(T r10) {
    L2:
        ParallelReduceFull$SlotPair<T> r11 = this.current.get();
        if (r11 != null) goto L7;
        r11 = new ParallelReduceFull$SlotPair();
        if (p.a(this.current, null, r11) == false) goto L2;
    L7:
        int r12 = r11.tryAcquireSlot();
        if (r12 >= 0) goto L10;
        p.a(this.current, r11, null);
        goto L2
    L10:
        if (r12 != 0) goto L12;
        r11.first = r10;
    L14:
        if (r11.releaseSlot() == false) goto L17;
        p.a(this.current, r11, null);
        return r11;
    L17:
        return null;
    L12:
        r11.second = r10;
        goto L14
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].cancel();
        r12 = r12 + 1;
        goto L3
    }

    public void innerComplete(T r10) {
        if (r10 == null) goto L11;
    L3:
        ParallelReduceFull$SlotPair<T> r11 = addValue(r10);
        if (r11 == null) goto L11;
        r10 = (T) a.b(this.reducer.apply(r11.first, r11.second), "The reducer returned a null value");
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        innerError(th);
        return;
    L11:
        if (this.remaining.decrementAndGet() != 0) goto L21;
        ParallelReduceFull$SlotPair<T> r12 = this.current.get();
        this.current.lazySet(null);
        if (r12 == null) goto L15;
        complete(r12.first);
        return;
    L15:
        this.downstream.onComplete();
        return;
    }

    public void innerError(Throwable r10) {
        if (p.a(this.error, null, r10) == false) goto L6;
        cancel();
        this.downstream.onError(r10);
        return;
    L6:
        if (r10 == this.error.get()) goto L10;
        qf.a.e(r10);
        return;
    }
}
