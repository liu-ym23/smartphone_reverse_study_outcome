package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import qf.a;

/* JADX INFO: loaded from: classes4.dex */
final class ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7954444275102466525L;
    boolean done;
    final ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parent;
    final BiFunction<T, T, T> reducer;
    T value;

    public ParallelReduceFull$ParallelReduceFullInnerSubscriber(ParallelReduceFull$ParallelReduceFullMainSubscriber<T> r10, BiFunction<T, T, T> r11) {
        this.parent = r10;
        this.reducer = r11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.parent.innerComplete(this.value);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        a.e(r10);
        return;
    L6:
        this.done = true;
        this.parent.innerError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == true) goto L14;
        T r11 = this.value;
        if (r11 != null) goto L12;
        this.value = r10;
        return;
    L12:
        this.value = (T) io.reactivex.internal.functions.a.b(this.reducer.apply(r11, r10), "The reducer returned a null value");
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        get().cancel();
        onError(th);
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
