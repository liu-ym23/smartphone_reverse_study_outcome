package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.CompletableSubscriber;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends Subscriber {

    public final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
        private static final long serialVersionUID = 7233503139645205620L;
        final /* synthetic */ CompletableOnSubscribeConcat$CompletableConcatSubscriber this$0;

        public ConcatInnerSubscriber(CompletableOnSubscribeConcat$CompletableConcatSubscriber r10) {
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
            throw null;
        }
    }
}
