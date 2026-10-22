package s8;

import f8.n0;

/* loaded from: classes.dex */
public final class r extends i8.c0 {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f9598r;

    /* renamed from: l, reason: collision with root package name */
    public final l8.y f9599l;

    /* renamed from: m, reason: collision with root package name */
    public final a3.b f9600m;

    /* renamed from: n, reason: collision with root package name */
    public final u9.i f9601n;

    /* renamed from: o, reason: collision with root package name */
    public final d f9602o;

    /* renamed from: p, reason: collision with root package name */
    public final u9.c f9603p;

    /* renamed from: q, reason: collision with root package name */
    public final g8.j f9604q;

    static {
        q7.x xVar = q7.w.f8821a;
        f9598r = new w7.t[]{xVar.f(new q7.p(xVar.b(r.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), xVar.f(new q7.p(xVar.b(r.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public r(a3.b bVar, l8.y yVar) {
        q7.k.e(bVar, "outerContext");
        r8.a aVar = (r8.a) bVar.f162f;
        super(aVar.f9016o, yVar.f5887a);
        this.f9599l = yVar;
        a3.b bVarI = n7.m.i(bVar, this, null, 6);
        this.f9600m = bVarI;
        q7.k.e(aVar.f9005d.c().f9049c, "<this>");
        d9.f fVar = d9.f.f3008g;
        r8.a aVar2 = (r8.a) bVarI.f162f;
        u9.n nVar = aVar2.f9002a;
        q qVar = new q(this, 0);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        this.f9601n = new u9.i(kVar, qVar);
        this.f9602o = new d(bVarI, yVar, this);
        q qVar2 = new q(this, 2);
        u9.k kVar2 = (u9.k) nVar;
        kVar2.getClass();
        this.f9603p = new u9.c(kVar2, qVar2);
        this.f9604q = aVar2.f9023v.f7850b ? g8.h.f3888a : n7.o.x(bVarI, yVar);
        ((u9.k) nVar).a(new q(this, 1));
    }

    @Override // a4.d, g8.a
    public final g8.j getAnnotations() {
        return this.f9604q;
    }

    @Override // i8.c0, i8.n, f8.k
    public final n0 q() {
        return new o4.d0(19, this);
    }

    @Override // i8.c0, i8.m
    public final String toString() {
        return "Lazy Java package fragment: " + this.f4758j + " of module " + ((r8.a) this.f9600m.f162f).f9016o;
    }

    @Override // f8.e0
    public final o9.n v0() {
        return this.f9602o;
    }
}
