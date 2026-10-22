package rx.internal.operators;

import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends Subscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator f24197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24199c;

    public d(OnSubscribeCombineLatest$LatestCoordinator r10, int r11) {
        this.f24197a = r10;
        this.f24198b = r11;
        request(r10.bufferSize);
    }

    public void b(long r10) {
        request(r10);
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.f24199c == false) goto L5;
        return;
    L5:
        this.f24199c = true;
        this.f24197a.combine(null, this.f24198b);
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        if (this.f24199c == false) goto L6;
        og.c.j(r10);
        return;
    L6:
        this.f24197a.onError(r10);
        this.f24199c = true;
        this.f24197a.combine(null, this.f24198b);
    }

    @Override // rx.Observer
    public void onNext(Object r10) {
        if (this.f24199c == false) goto L5;
        return;
    L5:
        this.f24197a.combine(NotificationLite.g(r10), this.f24198b);
    }
}
