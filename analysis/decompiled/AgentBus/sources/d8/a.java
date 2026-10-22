package d8;

import d7.b0;
import f8.z;
import ga.r;
import i8.a0;
import i8.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import u9.k;

/* loaded from: classes.dex */
public final class a implements h8.c {

    /* renamed from: a, reason: collision with root package name */
    public final k f2979a;

    /* renamed from: b, reason: collision with root package name */
    public final z f2980b;

    public a(k kVar, a0 a0Var) {
        q7.k.e(a0Var, "module");
        this.f2979a = kVar;
        this.f2980b = a0Var;
    }

    @Override // h8.c
    public final boolean a(e9.c cVar, e9.f fVar) {
        q7.k.e(cVar, "packageFqName");
        q7.k.e(fVar, "name");
        String strB = fVar.b();
        q7.k.d(strB, "name.asString()");
        if (r.g0(strB, "Function", false) || r.g0(strB, "KFunction", false) || r.g0(strB, "SuspendFunction", false) || r.g0(strB, "KSuspendFunction", false)) {
            e.f2993h.getClass();
            if (s9.d.m(strB, cVar) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // h8.c
    public final Collection b(e9.c cVar) {
        q7.k.e(cVar, "packageFqName");
        return b0.f2947f;
    }

    @Override // h8.c
    public final f8.e c(e9.b bVar) {
        q7.k.e(bVar, "classId");
        if (bVar.f3186c || !bVar.f3185b.e().d()) {
            return null;
        }
        String strB = bVar.h().b();
        if (!ga.k.k0(strB, "Function", false)) {
            return null;
        }
        e9.c cVarG = bVar.g();
        q7.k.d(cVarG, "classId.packageFqName");
        e.f2993h.getClass();
        d dVarM = s9.d.m(strB, cVarG);
        if (dVarM == null) {
            return null;
        }
        e eVar = dVarM.f2991a;
        int i2 = dVarM.f2992b;
        List list = (List) n7.b.q(((x) this.f2980b.z(cVarG)).f4898j, x.f4895m[0]);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof s9.c) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (d7.r.P0(arrayList2) != null) {
            throw new ClassCastException();
        }
        return new c(this.f2979a, (s9.c) d7.r.N0(arrayList), eVar, i2);
    }
}
