package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y0 implements nb.f {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ y0 f7136f = new y0(0);

    /* renamed from: g, reason: collision with root package name */
    public static final y0 f7137g = new y0(1);

    /* renamed from: h, reason: collision with root package name */
    public static final y0 f7138h = new y0(2);
    public static final y0 i = new y0(3);

    /* renamed from: j, reason: collision with root package name */
    public static final y0 f7139j = new y0(4);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7140c;

    public /* synthetic */ y0(int i3) {
        this.f7140c = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [pc.t] */
    public static final void a(y0 y0Var) {
        nc.t0 t0Var;
        q0.b bVar;
        q0.b bVar2;
        nc.t0 t0Var2 = z1.f7153x;
        do {
            t0Var = z1.f7153x;
            bVar = (q0.b) t0Var.getValue();
            p0.b bVarA = bVar.f10071h;
            q0.a aVar = (q0.a) bVarA.get(y0Var);
            if (aVar == null) {
                bVar2 = bVar;
            } else {
                Object obj = aVar.f10067a;
                Object obj2 = aVar.f10068b;
                p0.j jVar = bVarA.f9658c;
                p0.j jVarV = jVar.v(y0Var != null ? y0Var.hashCode() : 0, 0, y0Var);
                if (jVar != jVarV) {
                    bVarA = jVarV == null ? p0.b.f9657g : new p0.b(jVarV, bVarA.f9659f - 1);
                }
                r0.b bVar3 = r0.b.f10363a;
                if (obj != bVar3) {
                    Object obj3 = bVarA.get(obj);
                    obj3.getClass();
                    bVarA = bVarA.a(obj, new q0.a(((q0.a) obj3).f10067a, obj2));
                }
                if (obj2 != bVar3) {
                    Object obj4 = bVarA.get(obj2);
                    obj4.getClass();
                    bVarA = bVarA.a(obj2, new q0.a(obj, ((q0.a) obj4).f10068b));
                }
                Object obj5 = obj != bVar3 ? bVar.f10069f : obj2;
                if (obj2 != bVar3) {
                    obj = bVar.f10070g;
                }
                bVar2 = new q0.b(obj5, obj, bVarA);
            }
            if (bVar == bVar2) {
                return;
            }
            ?? r22 = oc.c.f9367b;
            if (bVar == null) {
                bVar = r22;
            }
        } while (!t0Var.g(bVar, bVar2));
    }

    public boolean b(Object obj, Object obj2) {
        switch (this.f7140c) {
            case 1:
                return false;
            case 2:
                return obj == obj2;
            default:
                return yb.k.a(obj, obj2);
        }
    }

    public String toString() {
        switch (this.f7140c) {
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
}
