package z7;

/* loaded from: classes.dex */
public class x0 extends k1 implements w7.q {

    /* renamed from: q, reason: collision with root package name */
    public final Object f11988q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(e0 e0Var, f8.l0 l0Var) {
        super(e0Var, l0Var);
        q7.k.e(l0Var, "descriptor");
        c7.h hVar = c7.h.f1970f;
        this.f11988q = s7.a.G(hVar, new w0(this, 0));
        s7.a.G(hVar, new w0(this, 1));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // z7.k1
    public final g1 G() {
        return (v0) this.f11988q.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // w7.t
    public final w7.o b() {
        return (v0) this.f11988q.getValue();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [c7.f, java.lang.Object] */
    @Override // p7.a
    public final Object c() {
        return ((v0) this.f11988q.getValue()).h(new Object[0]);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // w7.t
    public final w7.p b() {
        return (v0) this.f11988q.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(e0 e0Var, String str, String str2, Object obj) {
        super(e0Var, str, str2, obj);
        q7.k.e(str, "name");
        q7.k.e(str2, "signature");
        c7.h hVar = c7.h.f1970f;
        this.f11988q = s7.a.G(hVar, new w0(this, 0));
        s7.a.G(hVar, new w0(this, 1));
    }
}
