package d5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import la.e0;
import la.f0;
import la.j0;
import la.k0;
import la.u0;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2887a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final j0 f2888b;

    /* renamed from: c, reason: collision with root package name */
    public final u0 f2889c;

    /* renamed from: d, reason: collision with root package name */
    public final e0 f2890d;

    /* renamed from: e, reason: collision with root package name */
    public final f0 f2891e;

    public l() {
        j0 j0VarB = k0.b(0, 32, 5);
        this.f2888b = j0VarB;
        u0 u0VarC = k0.c(d7.z.f2978f);
        this.f2889c = u0VarC;
        this.f2890d = new e0(j0VarB);
        this.f2891e = new f0(u0VarC);
    }

    public final ArrayList a(m mVar) {
        q7.k.e(mVar, "role");
        Collection collectionValues = this.f2887a.values();
        q7.k.d(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((e) obj).f() == mVar) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final ArrayList b(String str, m mVar, String str2) {
        q7.k.e(mVar, "role");
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = this.f2887a;
        Collection collectionValues = concurrentHashMap.values();
        q7.k.d(collectionValues, "<get-values>(...)");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionValues) {
            e eVar = (e) obj;
            if (q7.k.a(eVar.e(), str) && eVar.f() == mVar && !q7.k.a(eVar.getId(), str2)) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            e eVar2 = (e) it.next();
            if (concurrentHashMap.remove(eVar2.getId(), eVar2)) {
                arrayList.add(eVar2);
                this.f2888b.M(new h(eVar2));
            }
        }
        if (!arrayList.isEmpty()) {
            e();
        }
        return arrayList;
    }

    public final e c(String str) {
        q7.k.e(str, "id");
        return (e) this.f2887a.get(str);
    }

    public final ArrayList d(m mVar) {
        q7.k.e(mVar, "role");
        ArrayList arrayListA = a(mVar);
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((e) next).h().getValue() instanceof q) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final void e() {
        Collection collectionValues = this.f2887a.values();
        q7.k.d(collectionValues, "<get-values>(...)");
        List listM1 = d7.r.m1(collectionValues);
        u0 u0Var = this.f2889c;
        u0Var.getClass();
        u0Var.g(null, listM1);
    }

    public final void f(e eVar) {
        q7.k.e(eVar, "conn");
        if (this.f2887a.putIfAbsent(eVar.getId(), eVar) == null) {
            e();
            this.f2888b.M(new g(eVar));
        }
    }

    public final void g(e eVar, String str) {
        q7.k.e(str, "id");
        q7.k.e(eVar, "expected");
        if (this.f2887a.remove(str, eVar)) {
            e();
            this.f2888b.M(new h(eVar));
        }
    }

    public final void h(String str) {
        q7.k.e(str, "id");
        e eVar = (e) this.f2887a.remove(str);
        if (eVar != null) {
            e();
            this.f2888b.M(new h(eVar));
        }
    }
}
