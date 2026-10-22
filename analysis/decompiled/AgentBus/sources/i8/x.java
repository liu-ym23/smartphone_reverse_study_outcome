package i8;

/* loaded from: classes.dex */
public final class x extends m implements f8.i0 {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f4895m;

    /* renamed from: h, reason: collision with root package name */
    public final a0 f4896h;

    /* renamed from: i, reason: collision with root package name */
    public final e9.c f4897i;

    /* renamed from: j, reason: collision with root package name */
    public final u9.i f4898j;

    /* renamed from: k, reason: collision with root package name */
    public final u9.i f4899k;

    /* renamed from: l, reason: collision with root package name */
    public final o9.j f4900l;

    static {
        q7.x xVar = q7.w.f8821a;
        f4895m = new w7.t[]{xVar.f(new q7.p(xVar.b(x.class), "fragments", "getFragments()Ljava/util/List;")), xVar.f(new q7.p(xVar.b(x.class), "empty", "getEmpty()Z"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(a0 a0Var, e9.c cVar, u9.k kVar) {
        super(g8.h.f3888a, cVar.g());
        q7.k.e(cVar, "fqName");
        q7.k.e(kVar, "storageManager");
        this.f4896h = a0Var;
        this.f4897i = cVar;
        this.f4898j = new u9.i(kVar, new w(this, 1));
        this.f4899k = new u9.i(kVar, new w(this, 0));
        this.f4900l = new o9.j(kVar, new w(this, 2));
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.e(this, obj);
    }

    public final boolean equals(Object obj) {
        f8.i0 i0Var = obj instanceof f8.i0 ? (f8.i0) obj : null;
        if (i0Var == null) {
            return false;
        }
        x xVar = (x) i0Var;
        return q7.k.a(this.f4897i, xVar.f4897i) && q7.k.a(this.f4896h, xVar.f4896h);
    }

    public final int hashCode() {
        return this.f4897i.hashCode() + (this.f4896h.hashCode() * 31);
    }

    @Override // f8.j
    public final f8.j p() {
        e9.c cVar = this.f4897i;
        if (cVar.d()) {
            return null;
        }
        return this.f4896h.z(cVar.e());
    }
}
