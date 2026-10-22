package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements e {

    /* renamed from: a, reason: collision with root package name */
    public p5.i f11111a;

    /* renamed from: b, reason: collision with root package name */
    public n6.a f11112b;

    /* renamed from: c, reason: collision with root package name */
    public Object f11113c;

    /* renamed from: d, reason: collision with root package name */
    public n f11114d;

    /* renamed from: e, reason: collision with root package name */
    public n f11115e;

    /* renamed from: f, reason: collision with root package name */
    public n f11116f;

    /* renamed from: g, reason: collision with root package name */
    public Object f11117g;

    /* renamed from: h, reason: collision with root package name */
    public long f11118h;

    @Override // s.e
    public final boolean a() {
        return false;
    }

    @Override // s.e
    public final long b() {
        return this.f11118h;
    }

    @Override // s.e
    public final n6.a c() {
        return this.f11112b;
    }

    @Override // s.e
    public final n d(long j10) {
        return !e(j10) ? this.f11111a.x(j10, this.f11114d, this.f11115e) : this.f11116f;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [xb.l, yb.l] */
    @Override // s.e
    public final Object f(long j10) {
        if (e(j10)) {
            return this.f11117g;
        }
        ?? r12 = (yb.l) this.f11112b.f8777f;
        p5.i iVar = this.f11111a;
        n nVar = this.f11114d;
        n nVar2 = this.f11115e;
        if (((n) iVar.f9731f) == null) {
            iVar.f9731f = nVar.c();
        }
        n nVar3 = (n) iVar.f9731f;
        if (nVar3 == null) {
            yb.k.f("valueVector");
            throw null;
        }
        int iB = nVar3.b();
        int i = 0;
        while (true) {
            n nVar4 = (n) iVar.f9731f;
            if (i >= iB) {
                if (nVar4 != null) {
                    return r12.invoke(nVar4);
                }
                yb.k.f("valueVector");
                throw null;
            }
            if (nVar4 == null) {
                yb.k.f("valueVector");
                throw null;
            }
            a1.g gVar = (a1.g) iVar.f9730c;
            float fA = nVar.a(i);
            long j11 = j10 / 1000000;
            r.k0 k0VarA = ((r.l0) gVar.f19f).a(nVar2.a(i));
            long j12 = k0VarA.f10311c;
            nVar4.e((Math.signum(k0VarA.f10309a) * k0VarA.f10310b * r.b.a(j12 > 0 ? j11 / j12 : 1.0f).f10241a) + fA, i);
            i++;
        }
    }

    @Override // s.e
    public final Object g() {
        return this.f11117g;
    }
}
