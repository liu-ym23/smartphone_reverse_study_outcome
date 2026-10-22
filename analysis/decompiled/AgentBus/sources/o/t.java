package o;

/* loaded from: classes.dex */
public final class t implements u0.c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7128a;

    @Override // u0.c0
    public final u0.w a(long j2, d2.l lVar, d2.c cVar) {
        switch (this.f7128a) {
            case 0:
                float fY = cVar.y(u.f7129a);
                return new u0.u(new t0.c(0.0f, -fY, t0.e.d(j2), t0.e.b(j2) + fY));
            default:
                float fY2 = cVar.y(u.f7129a);
                return new u0.u(new t0.c(-fY2, 0.0f, t0.e.d(j2) + fY2, t0.e.b(j2)));
        }
    }
}
