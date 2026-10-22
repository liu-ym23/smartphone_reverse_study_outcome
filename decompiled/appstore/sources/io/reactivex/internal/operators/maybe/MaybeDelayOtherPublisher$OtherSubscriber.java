package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeDelayOtherPublisher$OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = -1215060610805418006L;
    final MaybeObserver<? super T> downstream;
    Throwable error;
    T value;

    public MaybeDelayOtherPublisher$OtherSubscriber(MaybeObserver<? super T> r10) {
        this.downstream = r10;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Throwable r10 = this.error;
        if (r10 == null) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        T r11 = this.value;
        if (r11 == null) goto L8;
        this.downstream.onSuccess(r11);
        return;
    L8:
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        Throwable r11 = this.error;
        if (r11 != null) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        this.downstream.onError(new CompositeException(new Throwable[]{r11, r10}));
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        Subscription r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L6;
        lazySet(r12);
        r11.cancel();
        onComplete();
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
