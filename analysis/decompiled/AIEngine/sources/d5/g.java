package d5;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends u<AtomicLong> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f8351a;

    public g(u uVar) {
        this.f8351a = uVar;
    }

    @Override // d5.u
    public final AtomicLong a(k5.a aVar) {
        return new AtomicLong(((Number) this.f8351a.a(aVar)).longValue());
    }

    @Override // d5.u
    public final void b(k5.b bVar, AtomicLong atomicLong) {
        this.f8351a.b(bVar, Long.valueOf(atomicLong.get()));
    }
}
