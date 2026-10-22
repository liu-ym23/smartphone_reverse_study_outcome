package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.CompletableSubscriber;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OnSubscribeFlatMapCompletable$FlatMapCompletableSubscriber extends Subscriber {

    public final class InnerSubscriber extends AtomicReference<Subscription> implements CompletableSubscriber, Subscription {
        private static final long serialVersionUID = -8588259593722659900L;
        final /* synthetic */ OnSubscribeFlatMapCompletable$FlatMapCompletableSubscriber this$0;

        public InnerSubscriber(OnSubscribeFlatMapCompletable$FlatMapCompletableSubscriber r10) {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() != this) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // rx.CompletableSubscriber
        public void onCompleted() {
            throw null;
        }

        @Override // rx.CompletableSubscriber
        public void onError(Throwable r10) {
            throw null;
        }

        @Override // rx.CompletableSubscriber
        public void onSubscribe(Subscription r10) {
            if (compareAndSet(null, r10) == true) goto L8;
            r10.unsubscribe();
            if (get() == this) goto L9;
            og.c.j(new IllegalStateException("Subscription already set!"));
            return;
        L9:
            return;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            Subscription r10 = getAndSet(this);
            if (r10 == null) goto L7;
            if (r10 == this) goto L8;
            r10.unsubscribe();
            return;
        L8:
            return;
        }
    }
}
