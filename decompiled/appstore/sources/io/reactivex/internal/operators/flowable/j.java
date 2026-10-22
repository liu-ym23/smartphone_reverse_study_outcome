package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends io.reactivex.subscribers.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowableWindowBoundary$WindowBoundaryMainSubscriber f20645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20646c;

    public j(FlowableWindowBoundary$WindowBoundaryMainSubscriber r10) {
        this.f20645b = r10;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f20646c == false) goto L5;
        return;
    L5:
        this.f20646c = true;
        this.f20645b.innerComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.f20646c == false) goto L6;
        qf.a.e(r10);
        return;
    L6:
        this.f20646c = true;
        this.f20645b.innerError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        if (this.f20646c == false) goto L5;
        return;
    L5:
        this.f20645b.innerNext();
    }
}
