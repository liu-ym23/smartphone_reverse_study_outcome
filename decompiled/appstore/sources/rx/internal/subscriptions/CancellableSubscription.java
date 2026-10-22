package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import og.c;
import rx.Subscription;
import rx.exceptions.a;
import rx.functions.Cancellable;

/* JADX INFO: loaded from: classes4.dex */
public final class CancellableSubscription extends AtomicReference<Cancellable> implements Subscription {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(Cancellable r10) {
        super(r10);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (get() == null) goto L13;
        Cancellable r10 = getAndSet(null);
        if (r10 == null) goto L14;
        r10.cancel();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a.e(e);
        c.j(e);
        return;
    L14:
        return;
    }
}
