package qd;

import java.lang.invoke.VarHandle;
import java.util.concurrent.Flow;
import reactor.core.publisher.BaseSubscriber;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Flow.Subscriber {

    /* renamed from: c, reason: collision with root package name */
    public BaseSubscriber f10216c;

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onComplete() {
        this.f10216c.onComplete();
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onError(Throwable th) {
        this.f10216c.onError(th);
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onNext(Object obj) {
        this.f10216c.onNext(obj);
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onSubscribe(Flow.Subscription subscription) {
        b bVar;
        BaseSubscriber baseSubscriber = this.f10216c;
        if (subscription == null) {
            bVar = null;
        } else {
            b bVar2 = new b();
            bVar2.f10217c = subscription;
            VarHandle.storeStoreFence();
            bVar = bVar2;
        }
        baseSubscriber.onSubscribe(bVar);
    }
}
