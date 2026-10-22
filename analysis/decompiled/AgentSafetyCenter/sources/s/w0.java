package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w0 implements e {

    /* renamed from: a, reason: collision with root package name */
    public final j1 f11154a;

    /* renamed from: b, reason: collision with root package name */
    public final n6.a f11155b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11156c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f11157d;

    /* renamed from: e, reason: collision with root package name */
    public final n f11158e;

    /* renamed from: f, reason: collision with root package name */
    public final n f11159f;

    /* renamed from: g, reason: collision with root package name */
    public final n f11160g;

    /* renamed from: h, reason: collision with root package name */
    public long f11161h;
    public n i;

    /* JADX WARN: Type inference failed for: r1v3, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r1v7, types: [xb.l, yb.l] */
    public w0(h hVar, n6.a aVar, Object obj, Object obj2, n nVar) {
        this.f11154a = hVar.a(aVar);
        this.f11155b = aVar;
        this.f11156c = obj2;
        this.f11157d = obj;
        this.f11158e = (n) ((yb.l) aVar.f8776c).invoke(obj);
        ?? r12 = (yb.l) aVar.f8776c;
        this.f11159f = (n) r12.invoke(obj2);
        this.f11160g = nVar != null ? d.h(nVar) : ((n) r12.invoke(obj)).c();
        this.f11161h = -1L;
    }

    @Override // s.e
    public final boolean a() {
        return this.f11154a.a();
    }

    @Override // s.e
    public final long b() {
        if (this.f11161h < 0) {
            this.f11161h = this.f11154a.b(this.f11158e, this.f11159f, this.f11160g);
        }
        return this.f11161h;
    }

    @Override // s.e
    public final n6.a c() {
        return this.f11155b;
    }

    @Override // s.e
    public final n d(long j10) {
        if (!e(j10)) {
            return this.f11154a.h(j10, this.f11158e, this.f11159f, this.f11160g);
        }
        n nVar = this.i;
        if (nVar != null) {
            return nVar;
        }
        n nVarS = this.f11154a.s(this.f11158e, this.f11159f, this.f11160g);
        this.i = nVarS;
        return nVarS;
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [xb.l, yb.l] */
    @Override // s.e
    public final Object f(long j10) {
        if (e(j10)) {
            return this.f11156c;
        }
        n nVarK = this.f11154a.k(j10, this.f11158e, this.f11159f, this.f11160g);
        int iB = nVarK.b();
        for (int i = 0; i < iB; i++) {
            if (Float.isNaN(nVarK.a(i))) {
                m0.b("AnimationVector cannot contain a NaN. " + nVarK + ". Animation: " + this + ", playTimeNanos: " + j10);
            }
        }
        return ((yb.l) this.f11155b.f8777f).invoke(nVarK);
    }

    @Override // s.e
    public final Object g() {
        return this.f11156c;
    }

    public final String toString() {
        return "TargetBasedAnimation: " + this.f11157d + " -> " + this.f11156c + ",initial velocity: " + this.f11160g + ", duration: " + (b() / 1000000) + " ms,animationSpec: " + this.f11154a;
    }
}
