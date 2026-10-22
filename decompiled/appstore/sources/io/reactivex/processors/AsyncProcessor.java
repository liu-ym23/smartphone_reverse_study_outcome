package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AsyncProcessor extends a {

    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor parent;

        public AsyncSubscription(Subscriber<? super T> r10, AsyncProcessor r11) {
            super(r10);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (super.tryCancel() == true) goto L6;
            return;
        L6:
            throw null;
        }

        public void onComplete() {
            if (isCancelled() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r10) {
            if (isCancelled() == false) goto L5;
            qf.a.e(r10);
            return;
        L5:
            this.downstream.onError(r10);
        }
    }
}
