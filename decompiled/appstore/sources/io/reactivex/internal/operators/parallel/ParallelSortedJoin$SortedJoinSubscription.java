package io.reactivex.internal.operators.parallel;

import androidx.lifecycle.p;
import io.reactivex.exceptions.a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class ParallelSortedJoin$SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = 3481980673745556697L;
    volatile boolean cancelled;
    final Comparator<? super T> comparator;
    final Subscriber<? super T> downstream;
    final AtomicReference<Throwable> error;
    final int[] indexes;
    final List<T>[] lists;
    final AtomicInteger remaining;
    final AtomicLong requested;
    final ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] subscribers;

    public ParallelSortedJoin$SortedJoinSubscription(Subscriber<? super T> r10, int r11, Comparator<? super T> r12) {
        this.requested = new AtomicLong();
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference();
        this.downstream = r10;
        this.comparator = r12;
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] r13 = new ParallelSortedJoin$SortedJoinInnerSubscriber[r11];
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13[r14] = new ParallelSortedJoin$SortedJoinInnerSubscriber(this, r14);
        r14 = r14 + 1;
        goto L3
    L5:
        this.subscribers = r13;
        this.lists = new List[r11];
        this.indexes = new int[r11];
        this.remaining.lazySet(r11);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) goto L9;
        Arrays.fill(this.lists, null);
        return;
    L9:
        return;
    }

    public void cancelAll() {
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].cancel();
        r12 = r12 + 1;
        goto L3
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super T> r10 = this.downstream;
        List<T>[] r11 = this.lists;
        int[] r12 = this.indexes;
        int r13 = r12.length;
        int r14 = 1;
    L6:
        long r15 = this.requested.get();
        long r16 = 0;
    L7:
        int r17 = 0;
        if (r16 == r15) goto L40;
        if (this.cancelled == true) goto L11;
        Throwable r18 = this.error.get();
        if (r18 != null) goto L15;
        int r19 = -1;
        T r20 = null;
    L18:
        if (r17 >= r13) goto L35;
        List<T> r110 = r11[r17];
        int r21 = r12[r17];
        if (r110.size() == r21) goto L34;
        if (r20 != null) goto L24;
        r20 = r110.get(r21);
    L23:
        r19 = r17;
        goto L34
    L24:
        T r22 = r110.get(r21);
        if (this.comparator.compare(r20, r22) <= 0) goto L34;
        r20 = r22;
    L28:
        th = move-exception;
        a.a(th);
        cancelAll();
        Arrays.fill(r11, null);
        if (p.a(this.error, null, th) == true) goto L32;
        qf.a.e(th);
    L32:
        r10.onError(this.error.get());
        return;
    L34:
        r17 = r17 + 1;
        goto L18
    L35:
        if (r20 == null) goto L36;
        r10.onNext(r20);
        r12[r19] = r12[r19] + 1;
        r16 = r16 + 1;
        goto L7
    L36:
        Arrays.fill(r11, null);
        r10.onComplete();
        return;
    L15:
        cancelAll();
        Arrays.fill(r11, null);
        r10.onError(r18);
        return;
    L11:
        Arrays.fill(r11, null);
        return;
    L40:
        if (r16 != r15) goto L57;
        if (this.cancelled == true) goto L43;
        Throwable r111 = this.error.get();
        if (r111 != null) goto L47;
    L49:
        if (r17 >= r13) goto L54;
        if (r12[r17] != r11[r17].size()) goto L57;
        r17 = r17 + 1;
        goto L49
    L54:
        Arrays.fill(r11, null);
        r10.onComplete();
        return;
    L47:
        cancelAll();
        Arrays.fill(r11, null);
        r10.onError(r111);
        return;
    L43:
        Arrays.fill(r11, null);
        return;
    L57:
        if (r16 != 0) goto L59;
    L61:
        int r23 = get();
        if (r23 != r14) goto L66;
        r23 = addAndGet(-r14);
        if (r23 != 0) goto L66;
        return;
    L66:
        r14 = r23;
        goto L6
    L59:
        if (r15 == Long.MAX_VALUE) goto L61;
        this.requested.addAndGet(-r16);
        goto L61
    }

    public void innerError(Throwable r10) {
        if (p.a(this.error, null, r10) == false) goto L6;
        drain();
        return;
    L6:
        if (r10 == this.error.get()) goto L10;
        qf.a.e(r10);
        return;
    }

    public void innerNext(List<T> r10, int r11) {
        this.lists[r11] = r10;
        if (this.remaining.decrementAndGet() != 0) goto L6;
        drain();
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L8;
        io.reactivex.internal.util.a.a(this.requested, r10);
        if (this.remaining.get() != 0) goto L9;
        drain();
        return;
    L9:
        return;
    }
}
