package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d2 implements kc.t, a2 {

    /* renamed from: h, reason: collision with root package name */
    public static final h f6873h = new h();

    /* renamed from: c, reason: collision with root package name */
    public nb.g f6874c;

    /* renamed from: f, reason: collision with root package name */
    public d2 f6875f;

    /* renamed from: g, reason: collision with root package name */
    public volatile nb.g f6876g;

    @Override // k0.a2
    public final void a() {
        d();
    }

    @Override // k0.a2
    public final void b() {
        d();
    }

    public final void d() {
        synchronized (this.f6875f) {
            try {
                nb.g gVar = this.f6876g;
                if (gVar == null) {
                    this.f6876g = f6873h;
                } else {
                    kc.w.e(gVar, new n0(0));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kc.t
    public final nb.g n() {
        nb.g gVarPlus;
        nb.g gVar = this.f6876g;
        if (gVar == null || gVar == f6873h) {
            v0.b bVar = (v0.b) this.f6874c.get(v0.b.f14317f);
            nb.g c2Var = bVar != null ? new c2(bVar, this) : nb.h.f8811c;
            synchronized (this.f6875f) {
                try {
                    nb.g gVar2 = this.f6876g;
                    if (gVar2 == null) {
                        nb.g gVar3 = this.f6874c;
                        gVarPlus = gVar3.plus(new kc.z0((kc.x0) gVar3.get(kc.w0.f7498c))).plus(nb.h.f8811c).plus(c2Var);
                    } else if (gVar2 == f6873h) {
                        nb.g gVar4 = this.f6874c;
                        kc.z0 z0Var = new kc.z0((kc.x0) gVar4.get(kc.w0.f7498c));
                        z0Var.t(new n0(0));
                        gVarPlus = gVar4.plus(z0Var).plus(nb.h.f8811c).plus(c2Var);
                    } else {
                        gVarPlus = gVar2;
                    }
                    this.f6876g = gVarPlus;
                } catch (Throwable th) {
                    throw th;
                }
            }
            gVar = gVarPlus;
        }
        gVar.getClass();
        return gVar;
    }

    @Override // k0.a2
    public final void c() {
    }
}
