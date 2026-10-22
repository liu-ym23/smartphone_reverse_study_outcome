package n;

/* loaded from: classes.dex */
public final class s0 implements e {

    /* renamed from: a, reason: collision with root package name */
    public final h1 f6723a;

    /* renamed from: b, reason: collision with root package name */
    public final q6.b f6724b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6725c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6726d;

    /* renamed from: e, reason: collision with root package name */
    public final n f6727e;

    /* renamed from: f, reason: collision with root package name */
    public final n f6728f;

    /* renamed from: g, reason: collision with root package name */
    public final n f6729g;

    /* renamed from: h, reason: collision with root package name */
    public long f6730h;

    /* renamed from: i, reason: collision with root package name */
    public n f6731i;

    public s0(h hVar, q6.b bVar, Object obj, Object obj2, n nVar) {
        this.f6723a = hVar.a(bVar);
        this.f6724b = bVar;
        this.f6725c = obj2;
        this.f6726d = obj;
        p7.k kVar = (p7.k) bVar.f8788h;
        this.f6727e = (n) kVar.invoke(obj);
        this.f6728f = (n) kVar.invoke(obj2);
        this.f6729g = nVar != null ? d.e(nVar) : ((n) kVar.invoke(obj)).c();
        this.f6730h = -1L;
    }

    @Override // n.e
    public final boolean a() {
        return this.f6723a.a();
    }

    @Override // n.e
    public final Object c(long j2) {
        if (i(j2)) {
            return this.f6725c;
        }
        n nVarS = this.f6723a.s(j2, this.f6727e, this.f6728f, this.f6729g);
        int iB = nVarS.b();
        for (int i2 = 0; i2 < iB; i2++) {
            if (Float.isNaN(nVarS.a(i2))) {
                j0.b("AnimationVector cannot contain a NaN. " + nVarS + ". Animation: " + this + ", playTimeNanos: " + j2);
            }
        }
        return ((p7.k) this.f6724b.f8787g).invoke(nVarS);
    }

    @Override // n.e
    public final long d() {
        if (this.f6730h < 0) {
            this.f6730h = this.f6723a.c(this.f6727e, this.f6728f, this.f6729g);
        }
        return this.f6730h;
    }

    @Override // n.e
    public final q6.b e() {
        return this.f6724b;
    }

    @Override // n.e
    public final Object f() {
        return this.f6725c;
    }

    @Override // n.e
    public final n g(long j2) {
        if (!i(j2)) {
            return this.f6723a.r(j2, this.f6727e, this.f6728f, this.f6729g);
        }
        n nVar = this.f6731i;
        if (nVar != null) {
            return nVar;
        }
        n nVarO = this.f6723a.o(this.f6727e, this.f6728f, this.f6729g);
        this.f6731i = nVarO;
        return nVarO;
    }

    public final String toString() {
        return "TargetBasedAnimation: " + this.f6726d + " -> " + this.f6725c + ",initial velocity: " + this.f6729g + ", duration: " + (d() / 1000000) + " ms,animationSpec: " + this.f6723a;
    }
}
