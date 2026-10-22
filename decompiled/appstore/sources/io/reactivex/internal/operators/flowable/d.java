package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends nf.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowableGroupBy$State f20638c;

    public d(Object r10, FlowableGroupBy$State r11) {
        super(r10);
        this.f20638c = r11;
    }

    public static d d(Object r10, int r11, FlowableGroupBy$GroupBySubscriber r12, boolean r13) {
        return new d(r10, new FlowableGroupBy$State(r11, r12, r10, r13));
    }

    @Override // mf.b
    public void c(Subscriber r10) {
        this.f20638c.subscribe(r10);
    }

    public void onComplete() {
        this.f20638c.onComplete();
    }

    public void onError(Throwable r10) {
        this.f20638c.onError(r10);
    }

    public void onNext(Object r10) {
        this.f20638c.onNext(r10);
    }
}
