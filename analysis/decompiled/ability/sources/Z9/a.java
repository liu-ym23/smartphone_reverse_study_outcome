package Z9;

import java.util.concurrent.Flow;
import reactor.core.publisher.BaseSubscriber;

/* loaded from: classes4.dex */
public final class a implements Flow.Subscriber {

    /* renamed from: a, reason: collision with root package name */
    public final BaseSubscriber f1620a;

    public a(BaseSubscriber baseSubscriber) {
        this.f1620a = baseSubscriber;
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onComplete() {
        this.f1620a.onComplete();
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onError(Throwable th) {
        this.f1620a.onError(th);
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onNext(Object obj) {
        this.f1620a.onNext(obj);
    }

    @Override // java.util.concurrent.Flow.Subscriber
    public final void onSubscribe(Flow.Subscription subscription) {
        this.f1620a.onSubscribe(subscription == null ? null : new b(subscription));
    }
}
