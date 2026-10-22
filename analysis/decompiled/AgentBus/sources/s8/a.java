package s8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final l8.o f9511a;

    /* renamed from: b, reason: collision with root package name */
    public final q7.m f9512b;

    /* renamed from: c, reason: collision with root package name */
    public final r8.c f9513c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f9514d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f9515e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f9516f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [p7.k, q7.m] */
    /* JADX WARN: Type inference failed for: r6v6, types: [p7.k, q7.m] */
    public a(l8.o oVar, p7.k kVar) {
        q7.k.e(oVar, "jClass");
        this.f9511a = oVar;
        this.f9512b = (q7.m) kVar;
        r8.c cVar = new r8.c(5, this);
        this.f9513c = cVar;
        fa.f fVar = new fa.f(d7.r.H0(oVar.d()), true, cVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        fa.e eVar = new fa.e(fVar);
        while (eVar.hasNext()) {
            Object next = eVar.next();
            e9.f fVarC = ((l8.x) next).c();
            Object arrayList = linkedHashMap.get(fVarC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(fVarC, arrayList);
            }
            ((List) arrayList).add(next);
        }
        this.f9514d = linkedHashMap;
        fa.f fVar2 = new fa.f(d7.r.H0(this.f9511a.b()), true, this.f9512b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        fa.e eVar2 = new fa.e(fVar2);
        while (eVar2.hasNext()) {
            Object next2 = eVar2.next();
            linkedHashMap2.put(((l8.u) next2).c(), next2);
        }
        this.f9515e = linkedHashMap2;
        ArrayList arrayListE = this.f9511a.e();
        ?? r62 = this.f9512b;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayListE.iterator();
        while (it.hasNext()) {
            Object next3 = it.next();
            if (((Boolean) r62.invoke(next3)).booleanValue()) {
                arrayList2.add(next3);
            }
        }
        int iS = d7.e0.S(d7.t.A0(arrayList2, 10));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(iS < 16 ? 16 : iS);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Object next4 = it2.next();
            linkedHashMap3.put(((l8.a0) next4).c(), next4);
        }
        this.f9516f = linkedHashMap3;
    }

    @Override // s8.c
    public final Set a() {
        fa.f fVar = new fa.f(d7.r.H0(this.f9511a.d()), true, this.f9513c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        fa.e eVar = new fa.e(fVar);
        while (eVar.hasNext()) {
            linkedHashSet.add(((l8.x) eVar.next()).c());
        }
        return linkedHashSet;
    }

    @Override // s8.c
    public final Collection b(e9.f fVar) {
        q7.k.e(fVar, "name");
        List list = (List) this.f9514d.get(fVar);
        return list != null ? list : d7.z.f2978f;
    }

    @Override // s8.c
    public final Set c() {
        return this.f9516f.keySet();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [p7.k, q7.m] */
    @Override // s8.c
    public final Set d() {
        fa.f fVar = new fa.f(d7.r.H0(this.f9511a.b()), true, this.f9512b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        fa.e eVar = new fa.e(fVar);
        while (eVar.hasNext()) {
            linkedHashSet.add(((l8.u) eVar.next()).c());
        }
        return linkedHashSet;
    }

    @Override // s8.c
    public final l8.u e(e9.f fVar) {
        q7.k.e(fVar, "name");
        return (l8.u) this.f9515e.get(fVar);
    }

    @Override // s8.c
    public final l8.a0 f(e9.f fVar) {
        q7.k.e(fVar, "name");
        return (l8.a0) this.f9516f.get(fVar);
    }
}
