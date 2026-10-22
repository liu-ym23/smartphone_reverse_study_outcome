package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {
    volatile boolean cancelled;
    Throwable error;
    Subscription upstream;
    T value;

    public BlockingBaseSubscriber() {
        super(1);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription r3) {
        if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L10;
        this.upstream = r3;
        if (this.cancelled == true) goto L11;
        r3.request(Long.MAX_VALUE);
        if (this.cancelled == false) goto L12;
        this.upstream = SubscriptionHelper.CANCELLED;
        r3.cancel();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        countDown();
    }

    public final T blockingGet() {
        if (getCount() != 0) goto L18;
    L12:
        Throwable r0 = this.error;
        if (r0 != null) goto L17;
        return this.value;
    L17:
        throw ExceptionHelper.wrapOrThrow(r0);
    L18:
        BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L6
        await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        Subscription r1 = this.upstream;
        this.upstream = SubscriptionHelper.CANCELLED;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        throw ExceptionHelper.wrapOrThrow(e);
    }
}
