package f8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public static final x f3516a = new x("InvalidModuleNotifier", 0);

    public static final i5.l a(v9.z zVar, h hVar, int i2) {
        if (hVar == null || x9.i.f(hVar)) {
            return null;
        }
        int size = hVar.s().size() + i2;
        if (hVar.m()) {
            List listSubList = zVar.C0().subList(i2, size);
            j jVarP = hVar.p();
            return new i5.l(hVar, listSubList, a(zVar, jVarP instanceof h ? (h) jVarP : null, size));
        }
        if (size != zVar.C0().size()) {
            h9.f.o(hVar);
        }
        return new i5.l(hVar, zVar.C0().subList(i2, zVar.C0().size()), (i5.l) null);
    }

    public static final void b(h0 h0Var, e9.c cVar, ArrayList arrayList) {
        q7.k.e(h0Var, "<this>");
        q7.k.e(cVar, "fqName");
        h0Var.b(cVar, arrayList);
    }

    public static final List c(h hVar) {
        List parameters;
        Object next;
        v9.m0 m0VarH;
        List listS = hVar.s();
        q7.k.d(listS, "declaredTypeParameters");
        if (!hVar.m() && !(hVar.p() instanceof b)) {
            return listS;
        }
        int i2 = l9.d.f5893a;
        l9.c cVar = l9.c.f5892g;
        List listV0 = fa.l.v0(new fa.g(new fa.f(new d7.q(3, fa.l.q0(fa.l.s0(hVar, cVar), 1)), true, r.f3510j), r.f3511k, fa.n.f3639n));
        Iterator it = fa.l.q0(fa.l.s0(hVar, cVar), 1).iterator();
        while (true) {
            parameters = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next instanceof e) {
                break;
            }
        }
        e eVar = (e) next;
        if (eVar != null && (m0VarH = eVar.h()) != null) {
            parameters = m0VarH.getParameters();
        }
        if (parameters == null) {
            parameters = d7.z.f2978f;
        }
        if (listV0.isEmpty() && parameters.isEmpty()) {
            List listS2 = hVar.s();
            q7.k.d(listS2, "declaredTypeParameters");
            return listS2;
        }
        ArrayList arrayListC1 = d7.r.c1(listV0, parameters);
        ArrayList arrayList = new ArrayList(d7.t.A0(arrayListC1, 10));
        Iterator it2 = arrayListC1.iterator();
        while (it2.hasNext()) {
            q0 q0Var = (q0) it2.next();
            q7.k.d(q0Var, "it");
            arrayList.add(new d(q0Var, hVar, listS.size()));
        }
        return d7.r.c1(listS, arrayList);
    }

    public static final e d(z zVar, e9.b bVar) {
        q7.k.e(zVar, "<this>");
        q7.k.e(bVar, "classId");
        g gVarE = e(zVar, bVar);
        if (gVarE instanceof e) {
            return (e) gVarE;
        }
        return null;
    }

    public static final g e(z zVar, e9.b bVar) {
        q7.k.e(zVar, "<this>");
        q7.k.e(bVar, "classId");
        if (zVar.s0(h9.m.f4246a) != null) {
            throw new ClassCastException();
        }
        e9.c cVarG = bVar.g();
        q7.k.d(cVarG, "classId.packageFqName");
        i0 i0VarZ = zVar.z(cVarG);
        List listE = bVar.h().f3188a.e();
        o9.j jVar = ((i8.x) i0VarZ).f4900l;
        Object objN0 = d7.r.N0(listE);
        q7.k.d(objN0, "segments.first()");
        n8.c cVar = n8.c.f6883l;
        g gVarB = jVar.b((e9.f) objN0, cVar);
        if (gVarB != null) {
            for (e9.f fVar : listE.subList(1, listE.size())) {
                if (gVarB instanceof e) {
                    o9.n nVarH0 = ((e) gVarB).h0();
                    q7.k.d(fVar, "name");
                    g gVarB2 = nVarH0.b(fVar, cVar);
                    gVarB = gVarB2 instanceof e ? (e) gVarB2 : null;
                    if (gVarB != null) {
                    }
                }
            }
            return gVarB;
        }
        return null;
    }

    public static final e f(z zVar, e9.b bVar, i5.f fVar) {
        q7.k.e(zVar, "<this>");
        q7.k.e(bVar, "classId");
        q7.k.e(fVar, "notFoundClasses");
        e eVarD = d(zVar, bVar);
        return eVarD != null ? eVarD : fVar.I(bVar, fa.l.v0(fa.l.t0(fa.l.s0(bVar, q.f3507n), r.f3508h)));
    }

    public static final g g(j jVar) {
        j jVarP = jVar.p();
        if (jVarP == null || (jVar instanceof e0)) {
            return null;
        }
        if (!(jVarP.p() instanceof e0)) {
            return g(jVarP);
        }
        if (jVarP instanceof g) {
            return (g) jVarP;
        }
        return null;
    }

    public static final boolean h(h0 h0Var, e9.c cVar) {
        q7.k.e(h0Var, "<this>");
        q7.k.e(cVar, "fqName");
        return h0Var.a(cVar);
    }

    public static final ArrayList i(h0 h0Var, e9.c cVar) {
        q7.k.e(h0Var, "<this>");
        q7.k.e(cVar, "fqName");
        ArrayList arrayList = new ArrayList();
        b(h0Var, cVar, arrayList);
        return arrayList;
    }

    public static final e j(z zVar, e9.c cVar) {
        g gVarB;
        o9.n nVarH0;
        q7.k.e(zVar, "<this>");
        q7.k.e(cVar, "fqName");
        if (!cVar.d()) {
            o9.j jVar = ((i8.x) zVar.z(cVar.e())).f4900l;
            e9.f fVarF = cVar.f();
            q7.k.d(fVarF, "fqName.shortName()");
            n8.c cVar2 = n8.c.f6877f;
            g gVarB2 = jVar.b(fVarF, cVar2);
            e eVar = gVarB2 instanceof e ? (e) gVarB2 : null;
            if (eVar != null) {
                return eVar;
            }
            e eVarJ = j(zVar, cVar.e());
            if (eVarJ == null || (nVarH0 = eVarJ.h0()) == null) {
                gVarB = null;
            } else {
                e9.f fVarF2 = cVar.f();
                q7.k.d(fVarF2, "fqName.shortName()");
                gVarB = nVarH0.b(fVarF2, cVar2);
            }
            if (gVarB instanceof e) {
                return (e) gVarB;
            }
        }
        return null;
    }
}
