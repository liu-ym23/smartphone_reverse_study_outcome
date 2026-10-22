package Z9;

import java.util.concurrent.Flow;

/* loaded from: classes4.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Flow.Subscription f1621a;

    public b(Flow.Subscription subscription) {
        this.f1621a = subscription;
    }

    @Override // Z9.e
    public final void cancel() {
        this.f1621a.cancel();
    }

    @Override // Z9.e
    public final void request(long j5) {
        this.f1621a.request(j5);
    }
}
