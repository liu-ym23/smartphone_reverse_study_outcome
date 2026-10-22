package jg;

import rx.Subscription;
import rx.internal.util.SubscriptionList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SubscriptionList f21000a;

    public b() {
        this.f21000a = new SubscriptionList();
    }

    public final void a(Subscription r10) {
        this.f21000a.a(r10);
    }

    public abstract void b(Throwable r10);

    public abstract void c(Object r10);

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.f21000a.isUnsubscribed();
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.f21000a.unsubscribe();
    }
}
