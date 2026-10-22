package rx.internal.util;

import rx.Observer;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends Subscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer f24416a;

    public c(Observer r10) {
        this.f24416a = r10;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.f24416a.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        this.f24416a.onError(r10);
    }

    @Override // rx.Observer
    public void onNext(Object r10) {
        this.f24416a.onNext(r10);
    }
}
