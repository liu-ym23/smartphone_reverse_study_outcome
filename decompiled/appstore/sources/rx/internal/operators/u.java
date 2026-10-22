package rx.internal.operators;

import rx.Subscriber;
import rx.internal.producers.SingleProducer;

/* JADX INFO: loaded from: classes4.dex */
public final class u extends jg.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Subscriber f24280b;

    public u(Subscriber r10) {
        this.f24280b = r10;
    }

    @Override // jg.b
    public void b(Throwable r10) {
        this.f24280b.onError(r10);
    }

    @Override // jg.b
    public void c(Object r10) {
        this.f24280b.setProducer(new SingleProducer(this.f24280b, r10));
    }
}
