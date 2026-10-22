package v9;

/* loaded from: classes.dex */
public final class e0 extends p0 {

    /* renamed from: a, reason: collision with root package name */
    public final f8.q0 f10545a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10546b;

    public e0(f8.q0 q0Var) {
        q7.k.e(q0Var, "typeParameter");
        this.f10545a = q0Var;
        this.f10546b = s7.a.G(c7.h.f1970f, new t9.h(6, this));
    }

    @Override // v9.p0
    public final int a() {
        return 3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // v9.p0
    public final v b() {
        return (v) this.f10546b.getValue();
    }

    @Override // v9.p0
    public final boolean c() {
        return true;
    }

    @Override // v9.p0
    public final p0 d(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        return this;
    }
}
