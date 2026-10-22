package n;

import b0.o1;
import j1.h2;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final q6.b f6557a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6558b;

    /* renamed from: c, reason: collision with root package name */
    public final i f6559c;

    /* renamed from: d, reason: collision with root package name */
    public final o1 f6560d;

    /* renamed from: e, reason: collision with root package name */
    public final o1 f6561e;

    /* renamed from: f, reason: collision with root package name */
    public final i0 f6562f;

    /* renamed from: g, reason: collision with root package name */
    public final n f6563g;

    /* renamed from: h, reason: collision with root package name */
    public final n f6564h;

    /* renamed from: i, reason: collision with root package name */
    public final n f6565i;

    /* renamed from: j, reason: collision with root package name */
    public final n f6566j;

    public c(Comparable comparable, q6.b bVar, Float f10, int i2) {
        f10 = (i2 & 4) != 0 ? null : f10;
        this.f6557a = bVar;
        this.f6558b = f10;
        i iVar = new i(bVar, comparable, null, 60);
        this.f6559c = iVar;
        this.f6560d = b0.b.n(Boolean.FALSE);
        this.f6561e = b0.b.n(comparable);
        this.f6562f = new i0();
        new l0(1500.0f, f10);
        n nVar = iVar.f6633h;
        boolean z4 = nVar instanceof j;
        n nVar2 = z4 ? d.f6592e : nVar instanceof k ? d.f6593f : nVar instanceof l ? d.f6594g : d.f6595h;
        this.f6563g = nVar2;
        n nVar3 = z4 ? d.f6588a : nVar instanceof k ? d.f6589b : nVar instanceof l ? d.f6590c : d.f6591d;
        this.f6564h = nVar3;
        this.f6565i = nVar2;
        this.f6566j = nVar3;
    }

    public static final Object a(c cVar, Object obj) {
        q6.b bVar = cVar.f6557a;
        n nVar = cVar.f6566j;
        n nVar2 = cVar.f6565i;
        if (!q7.k.a(nVar2, cVar.f6563g) || !q7.k.a(nVar, cVar.f6564h)) {
            n nVar3 = (n) ((p7.k) bVar.f8788h).invoke(obj);
            int iB = nVar3.b();
            boolean z4 = false;
            for (int i2 = 0; i2 < iB; i2++) {
                if (nVar3.a(i2) < nVar2.a(i2) || nVar3.a(i2) > nVar.a(i2)) {
                    nVar3.e(i2, nb.i.j(nVar3.a(i2), nVar2.a(i2), nVar.a(i2)));
                    z4 = true;
                }
            }
            if (z4) {
                return ((p7.k) bVar.f8787g).invoke(nVar3);
            }
        }
        return obj;
    }

    public static Object b(c cVar, Comparable comparable, h hVar, i7.i iVar) {
        Object objInvoke = ((p7.k) cVar.f6557a.f8787g).invoke(cVar.f6559c.f6633h);
        Object objC = cVar.c();
        q6.b bVar = cVar.f6557a;
        s0 s0Var = new s0(hVar, bVar, objC, comparable, (n) ((p7.k) bVar.f8788h).invoke(objInvoke));
        long j2 = cVar.f6559c.f6634i;
        i0 i0Var = cVar.f6562f;
        a aVar = new a(cVar, objInvoke, s0Var, j2, null);
        i0Var.getClass();
        return ia.d0.f(new h2(i0Var, aVar, null), iVar);
    }

    public final Object c() {
        return this.f6559c.f6632g.getValue();
    }
}
