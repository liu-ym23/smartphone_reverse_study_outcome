package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FlowableCache extends io.reactivex.internal.operators.flowable.a implements FlowableSubscriber {

    public static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        final Subscriber<? super T> downstream;
        long index;
        a node;
        int offset;
        final FlowableCache parent;
        final AtomicLong requested;

        public CacheSubscription(Subscriber<? super T> r10, FlowableCache r11) {
            this.downstream = r10;
            throw null;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == true) goto L5;
            return;
        L5:
            io.reactivex.internal.util.a.b(this.requested, r10);
            throw null;
        }
    }

    public static final class a {
    }
}
