package e8;

import d7.b0;
import d7.s;
import f8.v;
import i8.a0;
import i8.l0;
import i8.r0;
import i8.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import q7.w;
import q7.x;
import t9.r;
import v9.s0;
import v9.v0;
import v9.z;
import w7.t;

/* loaded from: classes.dex */
public final class o implements h8.b, h8.d {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ t[] f3165g;

    /* renamed from: a, reason: collision with root package name */
    public final a0 f3166a;

    /* renamed from: b, reason: collision with root package name */
    public final u9.i f3167b;

    /* renamed from: c, reason: collision with root package name */
    public final z f3168c;

    /* renamed from: d, reason: collision with root package name */
    public final u9.i f3169d;

    /* renamed from: e, reason: collision with root package name */
    public final u9.e f3170e;

    /* renamed from: f, reason: collision with root package name */
    public final u9.i f3171f;

    static {
        x xVar = w.f8821a;
        f3165g = new t[]{xVar.f(new q7.p(xVar.b(o.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), xVar.f(new q7.p(xVar.b(o.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), xVar.f(new q7.p(xVar.b(o.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public o(a0 a0Var, u9.k kVar, a8.c cVar) {
        this.f3166a = a0Var;
        this.f3167b = new u9.i(kVar, cVar);
        i8.k kVar2 = new i8.k(new k(a0Var, new e9.c("java.io"), 0), e9.f.e("Serializable"), 4, 2, a.a.S(new v9.x(kVar, new l(this, 0))), kVar);
        kVar2.C0(o9.m.f7933b, b0.f2947f, null);
        this.f3168c = kVar2.k();
        this.f3169d = new u9.i(kVar, new a8.e(4, this, kVar));
        this.f3170e = new u9.e(kVar, new ConcurrentHashMap(3, 1.0f, 2), new u9.f(), 0);
        this.f3171f = new u9.i(kVar, new l(this, 1));
    }

    @Override // h8.b
    public final Collection a(f8.e eVar) {
        e9.e eVarH = l9.d.h(eVar);
        LinkedHashSet linkedHashSet = q.f3176a;
        e9.e eVar2 = c8.m.f2036g;
        boolean zEquals = eVarH.equals(eVar2);
        boolean zIsAssignableFrom = false;
        z zVar = this.f3168c;
        if (!zEquals) {
            HashMap map = c8.m.f2032c0;
            if (map.get(eVarH) == null) {
                if (eVarH.equals(eVar2) || map.get(eVarH) != null) {
                    zIsAssignableFrom = true;
                } else {
                    String str = d.f3123a;
                    e9.b bVarF = d.f(eVarH);
                    if (bVarF != null) {
                        try {
                            zIsAssignableFrom = Serializable.class.isAssignableFrom(Class.forName(bVarF.b().b()));
                        } catch (ClassNotFoundException unused) {
                        }
                    }
                }
                return zIsAssignableFrom ? a.a.S(zVar) : d7.z.f2978f;
            }
        }
        z zVar2 = (z) n7.b.q(this.f3169d, f3165g[1]);
        q7.k.d(zVar2, "cloneableType");
        return s.u0(zVar2, zVar);
    }

    @Override // h8.d
    public final boolean b(f8.e eVar, r rVar) {
        q7.k.e(eVar, "classDescriptor");
        s8.j jVarF = f(eVar);
        if (jVarF == null || !rVar.getAnnotations().g(h8.e.f4227a)) {
            return true;
        }
        g().getClass();
        String strM = nb.i.m(rVar, 3);
        s8.p pVarC0 = jVarF.C0();
        e9.f name = rVar.getName();
        q7.k.d(name, "functionDescriptor.name");
        Collection collectionF = pVarC0.f(name, n8.c.f6877f);
        if ((collectionF instanceof Collection) && collectionF.isEmpty()) {
            return false;
        }
        Iterator it = collectionF.iterator();
        while (it.hasNext()) {
            if (nb.i.m((l0) it.next(), 3).equals(strM)) {
                return true;
            }
        }
        return false;
    }

    @Override // h8.b
    public final Collection c(f8.e eVar) {
        f8.e eVarC;
        if (eVar.B() == 1) {
            g().getClass();
            s8.j jVarF = f(eVar);
            if (jVarF != null && (eVarC = e.c(l9.d.g(jVarF), b.f3119f)) != null) {
                v0 v0Var = new v0(s7.a.n(eVarC, jVarF));
                List list = (List) jVarF.f9569v.f9591q.c();
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    i8.i iVar = (i8.i) next;
                    i8.i iVar2 = iVar;
                    if (iVar2.c().f3485a.f3476b) {
                        Collection collectionE = eVarC.E();
                        q7.k.d(collectionE, "defaultKotlinVersion.constructors");
                        Collection<i8.i> collection = collectionE;
                        if (!(collection instanceof Collection) || !collection.isEmpty()) {
                            for (i8.i iVar3 : collection) {
                                q7.k.d(iVar3, "it");
                                if (h9.l.j(iVar3, iVar.d(v0Var)) == 1) {
                                    break;
                                }
                            }
                        }
                        if (iVar2.x0().size() == 1) {
                            List listX0 = iVar2.x0();
                            q7.k.d(listX0, "valueParameters");
                            f8.g gVarC = ((r0) d7.r.f1(listX0)).getType().E0().c();
                            if (q7.k.a(gVarC != null ? l9.d.h(gVarC) : null, l9.d.h(eVar))) {
                            }
                        }
                        if (!c8.h.C(iVar) && !q.f3180e.contains(n7.o.A(jVarF, nb.i.m(iVar, 3)))) {
                            arrayList.add(next);
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    i8.i iVar4 = (i8.i) it2.next();
                    i8.i iVar5 = iVar4;
                    iVar5.getClass();
                    i8.t tVarM0 = iVar5.M0(v0.f10595b);
                    tVarM0.f4853g = eVar;
                    tVarM0.w(eVar.k());
                    tVarM0.f4866t = true;
                    s0 s0VarF = v0Var.f();
                    if (s0VarF == null) {
                        i8.t.e(37);
                        throw null;
                    }
                    tVarM0.f4852f = s0VarF;
                    if (!q.f3181f.contains(n7.o.A(jVarF, nb.i.m(iVar4, 3)))) {
                        tVarM0.b((g8.j) n7.b.q(this.f3171f, f3165g[2]));
                    }
                    u uVarJ0 = tVarM0.C.J0(tVarM0);
                    q7.k.c(uVarJ0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                    arrayList2.add((i8.i) uVarJ0);
                }
                return arrayList2;
            }
        }
        return d7.z.f2978f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c2 A[EDGE_INSN: B:127:0x01c2->B:59:0x01c2 BREAK  A[LOOP:4: B:72:0x01ef->B:77:0x020f]] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0247  */
    @Override // h8.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection d(e9.f r17, f8.e r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 781
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e8.o.d(e9.f, f8.e):java.util.Collection");
    }

    @Override // h8.b
    public final Collection e(f8.e eVar) {
        Set setC;
        q7.k.e(eVar, "classDescriptor");
        g().getClass();
        s8.j jVarF = f(eVar);
        if (jVarF == null || (setC = jVarF.C0().c()) == null) {
            setC = b0.f2947f;
        }
        return setC;
    }

    public final s8.j f(f8.e eVar) {
        if (eVar == null) {
            c8.h.a(108);
            throw null;
        }
        e9.f fVar = c8.h.f1999e;
        if (!c8.h.b(eVar, c8.m.f2027a) && c8.h.I(eVar)) {
            e9.e eVarH = l9.d.h(eVar);
            if (eVarH.d()) {
                String str = d.f3123a;
                e9.b bVarF = d.f(eVarH);
                if (bVarF != null) {
                    f8.e eVarJ = v.j(g().f3148a, bVarF.b());
                    if (eVarJ instanceof s8.j) {
                        return (s8.j) eVarJ;
                    }
                }
            }
        }
        return null;
    }

    public final h g() {
        return (h) n7.b.q(this.f3167b, f3165g[0]);
    }
}
