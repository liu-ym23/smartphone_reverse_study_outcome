package z7;

/* loaded from: classes.dex */
public class d1 extends k1 implements p7.n {

    /* renamed from: q, reason: collision with root package name */
    public final Object f11859q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(e0 e0Var, f8.l0 l0Var) {
        super(e0Var, l0Var);
        q7.k.e(l0Var, "descriptor");
        c7.h hVar = c7.h.f1970f;
        this.f11859q = s7.a.G(hVar, new c1(this, 0));
        s7.a.G(hVar, new c1(this, 1));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // z7.k1
    public final g1 G() {
        return (b1) this.f11859q.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // w7.t
    public final w7.o b() {
        return (b1) this.f11859q.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((b1) this.f11859q.getValue()).h(obj, obj2);
    }
}
