package z7;

/* loaded from: classes.dex */
public final class k0 extends a1 implements w7.j {

    /* renamed from: r, reason: collision with root package name */
    public final Object f11892r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(e0 e0Var, String str, String str2, Object obj) {
        super(e0Var, str, str2, obj);
        q7.k.e(str, "name");
        q7.k.e(str2, "signature");
        this.f11892r = s7.a.G(c7.h.f1970f, new t9.h(17, this));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // w7.j
    public final void e(Object obj, Object obj2) {
        ((j0) this.f11892r.getValue()).h(obj, obj2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // w7.k
    public final w7.h g() {
        return (j0) this.f11892r.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // w7.j, w7.k
    public final w7.i g() {
        return (j0) this.f11892r.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(e0 e0Var, f8.l0 l0Var) {
        super(e0Var, l0Var);
        q7.k.e(l0Var, "descriptor");
        this.f11892r = s7.a.G(c7.h.f1970f, new t9.h(17, this));
    }
}
