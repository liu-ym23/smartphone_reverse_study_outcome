package eb;

import c7.r;
import f9.w;
import i1.d1;
import i1.h0;
import j1.b0;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Type;
import java.util.NoSuchElementException;
import l8.u;
import o4.d0;
import p.g1;
import q7.v;
import s8.a0;
import s8.y;
import u0.c0;
import w7.e0;
import z7.x;
import z7.x1;

/* loaded from: classes.dex */
public final class k extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3289g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f3290h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f3291i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f3292j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(Object obj, Object obj2, Object obj3, int i2) {
        super(0);
        this.f3289g = i2;
        this.f3290h = obj;
        this.f3291i = obj2;
        this.f3292j = obj3;
    }

    /* JADX WARN: Type inference failed for: r8v18, types: [p7.a, q7.m] */
    @Override // p7.a
    public final Object c() {
        r rVar;
        switch (this.f3289g) {
            case 0:
                e0 e0Var = ((ab.e) this.f3290h).f527b;
                q7.k.b(e0Var);
                return e0Var.h(((ab.a) this.f3292j).f493h.f591d, ((ab.l) this.f3291i).a());
            case 1:
                j1.b bVar = (j1.b) this.f3290h;
                bVar.removeOnAttachStateChangeListener((b0) this.f3291i);
                b4.b bVar2 = (b4.b) this.f3292j;
                q7.k.e(bVar2, "listener");
                n7.a.m(bVar).f8969a.remove(bVar2);
                return r.f1986a;
            case 2:
                v vVar = (v) this.f3290h;
                c0 c0Var = ((o.i) this.f3291i).f7058u;
                h0 h0Var = (h0) this.f3292j;
                vVar.f8820f = c0Var.a(h0Var.f4489f.d(), h0Var.f(), h0Var);
                return r.f1986a;
            case 3:
                p.i iVar = (p.i) this.f3290h;
                d0 d0Var = iVar.f8120w;
                while (true) {
                    d0.e eVar = (d0.e) d0Var.f7326g;
                    int i2 = eVar.f2751h;
                    rVar = r.f1986a;
                    if (i2 != 0) {
                        if (i2 == 0) {
                            throw new NoSuchElementException("MutableVector is empty.");
                        }
                        t0.c cVar = (t0.c) ((p.h) eVar.f2749f[i2 - 1]).f8111a.c();
                        if (cVar == null ? true : iVar.n0(cVar, iVar.A)) {
                            d0.e eVar2 = (d0.e) d0Var.f7326g;
                            ((p.h) eVar2.j(eVar2.f2751h - 1)).f8112b.resumeWith(rVar);
                        }
                    }
                }
                if (iVar.f8123z) {
                    t0.c cVarM0 = iVar.m0();
                    if (cVarM0 != null && iVar.n0(cVarM0, iVar.A)) {
                        iVar.f8123z = false;
                    }
                }
                ((g1) this.f3291i).f8110e = p.i.l0(iVar, (p.d) this.f3292j);
                return rVar;
            case 4:
                s.d dVar = (s.d) this.f3290h;
                t0.c cVarL0 = s.d.l0(dVar, (d1) this.f3291i, (q7.m) this.f3292j);
                if (cVarL0 == null) {
                    return null;
                }
                p.i iVar2 = dVar.f9159t;
                if (d2.k.a(iVar2.A, 0L)) {
                    throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.");
                }
                return cVarL0.e(iVar2.p0(cVarL0, iVar2.A) ^ (-9223372034707292160L));
            case 5:
                a0 a0Var = (a0) this.f3290h;
                u9.n nVar = ((r8.a) a0Var.f9518b.f162f).f9002a;
                y yVar = new y(a0Var, (u) this.f3291i, (q8.f) this.f3292j);
                u9.k kVar = (u9.k) nVar;
                kVar.getClass();
                return new u9.h(kVar, yVar);
            case 6:
                return ((f9.b) ((w) this.f3290h)).b((ByteArrayInputStream) this.f3291i, ((r9.i) ((t9.o) this.f3292j).f9835b.f9070f).f9062p);
            default:
                x xVar = (x) this.f3291i;
                z7.a0 a0Var2 = (z7.a0) this.f3292j;
                f8.g gVarC = ((v9.v) this.f3290h).E0().c();
                if (!(gVarC instanceof f8.e)) {
                    throw new c7.i("Supertype not a class: " + gVarC, 3);
                }
                Class clsJ = x1.j((f8.e) gVarC);
                if (clsJ == null) {
                    throw new c7.i("Unsupported superclass of " + xVar + ": " + gVarC, 3);
                }
                Class cls = a0Var2.f11832g;
                if (q7.k.a(cls.getSuperclass(), clsJ)) {
                    Type genericSuperclass = cls.getGenericSuperclass();
                    q7.k.d(genericSuperclass, "{\n                      …ass\n                    }");
                    return genericSuperclass;
                }
                Class<?>[] interfaces = cls.getInterfaces();
                q7.k.d(interfaces, "jClass.interfaces");
                int iL0 = d7.n.l0(interfaces, clsJ);
                if (iL0 >= 0) {
                    Type type = cls.getGenericInterfaces()[iL0];
                    q7.k.d(type, "{\n                      …ex]\n                    }");
                    return type;
                }
                throw new c7.i("No superclass of " + xVar + " in Java reflection for " + gVarC, 3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(s.d dVar, d1 d1Var, p7.a aVar) {
        super(0);
        this.f3289g = 4;
        this.f3290h = dVar;
        this.f3291i = d1Var;
        this.f3292j = (q7.m) aVar;
    }
}
