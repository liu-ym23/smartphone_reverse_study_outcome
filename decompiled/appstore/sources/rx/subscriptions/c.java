package rx.subscriptions;

import rx.Subscription;
import rx.internal.subscriptions.SequentialSubscription;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SequentialSubscription f24475a;

    public c() {
        this.f24475a = new SequentialSubscription();
    }

    public void a(Subscription r10) {
        if (r10 == null) goto L6;
        this.f24475a.replace(r10);
        return;
    L6:
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.f24475a.isUnsubscribed();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.f24475a.unsubscribe();
    }
}
