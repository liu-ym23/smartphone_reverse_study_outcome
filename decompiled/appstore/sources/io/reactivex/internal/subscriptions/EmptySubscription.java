package io.reactivex.internal.subscriptions;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.QueueSubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final enum EmptySubscription extends Enum<EmptySubscription> implements QueueSubscription<Object> {
    private static final /* synthetic */ EmptySubscription[] $VALUES = null;
    public static final EmptySubscription INSTANCE = null;

    static {
        EmptySubscription r10 = new EmptySubscription("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new EmptySubscription[]{r10};
    }

    private EmptySubscription(String r10, int r11) {
        super(r10, r11);
    }

    public static void complete(Subscriber<?> r10) {
        r10.onSubscribe(INSTANCE);
        r10.onComplete();
    }

    public static void error(Throwable r10, Subscriber<?> r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }

    public static EmptySubscription valueOf(String r10) {
        return (EmptySubscription) Enum.valueOf(EmptySubscription.class, r10);
    }

    public static EmptySubscription[] values() {
        return (EmptySubscription[]) $VALUES.clone();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public Object poll() {
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.validate(r10);
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        return r10 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r10, Object r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
