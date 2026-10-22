package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableEmpty extends Flowable<Object> implements ScalarCallable<Object> {
    public static final Flowable<Object> INSTANCE = null;

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    static {
        INSTANCE = new FlowableEmpty();
    }

    private FlowableEmpty() {
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Object> r1) {
        EmptySubscription.complete(r1);
    }
}
