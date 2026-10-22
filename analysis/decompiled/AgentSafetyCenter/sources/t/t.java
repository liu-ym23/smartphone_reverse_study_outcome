package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t implements d1.j0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13064a;

    @Override // d1.j0
    public final d1.c0 a(long j10, o2.l lVar, o2.c cVar) {
        switch (this.f13064a) {
            case 0:
                float fE0 = cVar.e0(u.f13065a);
                return new d1.a0(new c1.c(0.0f, -fE0, c1.e.e(j10), c1.e.c(j10) + fE0));
            default:
                float fE02 = cVar.e0(u.f13065a);
                return new d1.a0(new c1.c(-fE02, 0.0f, c1.e.e(j10) + fE02, c1.e.c(j10)));
        }
    }
}
