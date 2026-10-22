package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableBufferBoundary$BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final FlowableBufferBoundary$BufferBoundarySubscriber<T, C, ?, ?> parent;

    public FlowableBufferBoundary$BufferCloseSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber<T, C, ?, ?> r10, long r11) {
        this.parent = r10;
        this.index = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        this.parent.close(this, this.index);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        Subscription r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L5;
        lazySet(r12);
        this.parent.boundaryError(this, r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        Subscription r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L6;
        lazySet(r12);
        r11.cancel();
        this.parent.close(this, this.index);
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
