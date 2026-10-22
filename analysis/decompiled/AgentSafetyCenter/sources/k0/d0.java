package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 implements a2 {

    /* renamed from: c, reason: collision with root package name */
    public final kc.t f6872c;

    public d0(kc.t tVar) {
        this.f6872c = tVar;
    }

    @Override // k0.a2
    public final void a() {
        kc.t tVar = this.f6872c;
        if (tVar instanceof d2) {
            ((d2) tVar).d();
        } else {
            kc.w.d(tVar, new n0(1));
        }
    }

    @Override // k0.a2
    public final void b() {
        kc.t tVar = this.f6872c;
        if (tVar instanceof d2) {
            ((d2) tVar).d();
        } else {
            kc.w.d(tVar, new n0(1));
        }
    }

    @Override // k0.a2
    public final void c() {
    }
}
