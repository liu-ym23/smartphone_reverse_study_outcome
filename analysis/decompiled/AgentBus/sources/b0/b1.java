package b0;

/* loaded from: classes.dex */
public final class b1 implements g7.k, x2 {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ b1 f1107g = new b1(0);

    /* renamed from: h, reason: collision with root package name */
    public static final b1 f1108h = new b1(1);

    /* renamed from: i, reason: collision with root package name */
    public static final b1 f1109i = new b1(2);

    /* renamed from: j, reason: collision with root package name */
    public static final b1 f1110j = new b1(3);

    /* renamed from: k, reason: collision with root package name */
    public static final b1 f1111k = new b1(4);

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1112f;

    public /* synthetic */ b1(int i2) {
        this.f1112f = i2;
    }

    public static final void b(b1 b1Var) {
        la.u0 u0Var;
        Object obj;
        h0.b bVar;
        la.u0 u0Var2 = j2.f1204x;
        do {
            u0Var = j2.f1204x;
            obj = (e0.b) u0Var.getValue();
            bVar = (h0.b) obj;
            g0.c cVarA = bVar.f4064h;
            h0.a aVar = (h0.a) cVarA.get(b1Var);
            if (aVar != null) {
                Object obj2 = aVar.f4059a;
                Object obj3 = aVar.f4060b;
                g0.k kVar = cVarA.f3673f;
                g0.k kVarV = kVar.v(b1Var != null ? b1Var.hashCode() : 0, 0, b1Var);
                if (kVar != kVarV) {
                    cVarA = kVarV == null ? g0.c.f3672h : new g0.c(kVarV, cVarA.f3674g - 1);
                }
                i0.b bVar2 = i0.b.f4394a;
                if (obj2 != bVar2) {
                    Object obj4 = cVarA.get(obj2);
                    q7.k.b(obj4);
                    cVarA = cVarA.a(obj2, new h0.a(((h0.a) obj4).f4059a, obj3));
                }
                if (obj3 != bVar2) {
                    Object obj5 = cVarA.get(obj3);
                    q7.k.b(obj5);
                    cVarA = cVarA.a(obj3, new h0.a(obj2, ((h0.a) obj5).f4060b));
                }
                Object obj6 = obj2 != bVar2 ? bVar.f4062f : obj3;
                if (obj3 != bVar2) {
                    obj2 = bVar.f4063g;
                }
                bVar = new h0.b(obj6, obj2, cVarA);
            }
            if (obj == bVar) {
                return;
            }
            Object obj7 = ma.c.f6481b;
            if (obj == null) {
                obj = obj7;
            }
        } while (!u0Var.g(obj, bVar));
    }

    @Override // b0.x2
    public boolean a(Object obj, Object obj2) {
        switch (this.f1112f) {
            case 1:
                return false;
            case 2:
                return obj == obj2;
            default:
                return q7.k.a(obj, obj2);
        }
    }

    public String toString() {
        switch (this.f1112f) {
            case 1:
                return "NeverEqualPolicy";
            case 2:
                return "ReferentialEqualityPolicy";
            case 3:
            case 5:
            default:
                return super.toString();
            case 4:
                return "StructuralEqualityPolicy";
            case 6:
                return "Empty";
        }
    }

    public b1(u uVar) {
        this.f1112f = 7;
    }
}
