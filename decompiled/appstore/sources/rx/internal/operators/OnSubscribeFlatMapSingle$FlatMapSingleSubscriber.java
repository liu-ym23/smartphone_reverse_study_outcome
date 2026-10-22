package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OnSubscribeFlatMapSingle$FlatMapSingleSubscriber extends Subscriber {

    public final class Requested extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -887187595446742742L;
        final /* synthetic */ OnSubscribeFlatMapSingle$FlatMapSingleSubscriber this$0;

        public Requested(OnSubscribeFlatMapSingle$FlatMapSingleSubscriber r10) {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            throw null;
        }

        public void produced(long r10) {
            a.c(this, r10);
        }

        @Override // rx.Producer
        public void request(long r10) {
            if (r10 > 0) goto L5;
            return;
        L5:
            a.b(this, r10);
            throw null;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            throw null;
        }
    }
}
