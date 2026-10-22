package z7;

/* loaded from: classes.dex */
public class a1 extends k1 implements w7.s {

    /* renamed from: q, reason: collision with root package name */
    public final Object f11834q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(e0 e0Var, String str, String str2, Object obj) {
        super(e0Var, str, str2, obj);
        q7.k.e(str, "name");
        q7.k.e(str2, "signature");
        c7.h hVar = c7.h.f1970f;
        this.f11834q = s7.a.G(hVar, new z0(this, 0));
        s7.a.G(hVar, new z0(this, 1));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // z7.k1
    public final g1 G() {
        return (y0) this.f11834q.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // w7.t
    public final w7.o b() {
        return (y0) this.f11834q.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // w7.s
    public final Object get(Object obj) {
        return ((y0) this.f11834q.getValue()).h(obj);
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        return get(obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // w7.t
    public final w7.r b() {
        return (y0) this.f11834q.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(e0 e0Var, f8.l0 l0Var) {
        super(e0Var, l0Var);
        q7.k.e(l0Var, "descriptor");
        c7.h hVar = c7.h.f1970f;
        this.f11834q = s7.a.G(hVar, new z0(this, 0));
        s7.a.G(hVar, new z0(this, 1));
    }
}
