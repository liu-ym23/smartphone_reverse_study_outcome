package t9;

import d7.x;
import d7.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import v9.v;

/* loaded from: classes.dex */
public final class f extends o {

    /* renamed from: g, reason: collision with root package name */
    public final w9.g f9794g;

    /* renamed from: h, reason: collision with root package name */
    public final u9.i f9795h;

    /* renamed from: i, reason: collision with root package name */
    public final u9.i f9796i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ i f9797j;

    public f(i iVar, w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        this.f9797j = iVar;
        r9.k kVar = iVar.f9809q;
        z8.i iVar2 = iVar.f9802j;
        List list = iVar2.f12201v;
        q7.k.d(list, "classProto.functionList");
        List list2 = iVar2.f12202w;
        q7.k.d(list2, "classProto.propertyList");
        List list3 = iVar2.f12203x;
        q7.k.d(list3, "classProto.typeAliasList");
        List list4 = iVar2.f12195p;
        q7.k.d(list4, "classProto.nestedClassNameList");
        b9.f fVar = (b9.f) iVar.f9809q.f9071g;
        ArrayList arrayList = new ArrayList(d7.t.A0(list4, 10));
        Iterator it = list4.iterator();
        while (it.hasNext()) {
            arrayList.add(nb.i.y(fVar, ((Number) it.next()).intValue()));
        }
        super(kVar, list, list2, list3, new d(0, arrayList));
        r9.i iVar3 = (r9.i) kVar.f9070f;
        this.f9794g = gVar;
        u9.k kVar2 = iVar3.f9047a;
        e eVar = new e(this, 0);
        kVar2.getClass();
        this.f9795h = new u9.i(kVar2, eVar);
        u9.k kVar3 = iVar3.f9047a;
        e eVar2 = new e(this, 1);
        kVar3.getClass();
        this.f9796i = new u9.i(kVar3, eVar2);
    }

    @Override // t9.o, o9.o, o9.n
    public final Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        s(fVar, cVar);
        return super.a(fVar, cVar);
    }

    @Override // t9.o, o9.o, o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        f8.e eVar;
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        s(fVar, aVar);
        i5.f fVar2 = this.f9797j.f9813u;
        return (fVar2 == null || (eVar = (f8.e) ((b0.e) fVar2.f4654h).invoke(fVar)) == null) ? super.b(fVar, aVar) : eVar;
    }

    @Override // o9.o, o9.q
    public final Collection e(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        return (Collection) this.f9795h.c();
    }

    @Override // t9.o, o9.o, o9.q
    public final Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        s(fVar, aVar);
        return super.f(fVar, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v4, types: [d7.z] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    @Override // t9.o
    public final void h(ArrayList arrayList, p7.k kVar) {
        ?? arrayList2;
        q7.k.e(kVar, "nameFilter");
        i5.f fVar = this.f9797j.f9813u;
        if (fVar != null) {
            Set<e9.f> setKeySet = ((LinkedHashMap) fVar.f4653g).keySet();
            arrayList2 = new ArrayList();
            for (e9.f fVar2 : setKeySet) {
                q7.k.e(fVar2, "name");
                f8.e eVar = (f8.e) ((b0.e) fVar.f4654h).invoke(fVar2);
                if (eVar != null) {
                    arrayList2.add(eVar);
                }
            }
        } else {
            arrayList2 = 0;
        }
        if (arrayList2 == 0) {
            arrayList2 = z.f2978f;
        }
        arrayList.addAll(arrayList2);
    }

    @Override // t9.o
    public final void j(e9.f fVar, ArrayList arrayList) {
        q7.k.e(fVar, "name");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ((Collection) this.f9796i.c()).iterator();
        while (it.hasNext()) {
            arrayList2.addAll(((v) it.next()).v0().f(fVar, n8.c.f6879h));
        }
        r9.k kVar = this.f9835b;
        arrayList.addAll(((r9.i) kVar.f9070f).f9060n.d(fVar, this.f9797j));
        ArrayList arrayList3 = new ArrayList(arrayList);
        ((w9.m) ((r9.i) kVar.f9070f).f9063q).f10950d.h(fVar, arrayList2, arrayList3, this.f9797j, new i8.p(arrayList, 1));
    }

    @Override // t9.o
    public final void k(e9.f fVar, ArrayList arrayList) {
        q7.k.e(fVar, "name");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ((Collection) this.f9796i.c()).iterator();
        while (it.hasNext()) {
            arrayList2.addAll(((v) it.next()).v0().a(fVar, n8.c.f6879h));
        }
        ArrayList arrayList3 = new ArrayList(arrayList);
        ((w9.m) ((r9.i) this.f9835b.f9070f).f9063q).f10950d.h(fVar, arrayList2, arrayList3, this.f9797j, new i8.p(arrayList, 1));
    }

    @Override // t9.o
    public final e9.b l(e9.f fVar) {
        q7.k.e(fVar, "name");
        return this.f9797j.f9805m.d(fVar);
    }

    @Override // t9.o
    public final Set n() {
        List listD = this.f9797j.f9811s.d();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            Set setG = ((v) it.next()).v0().g();
            if (setG == null) {
                return null;
            }
            x.D0(linkedHashSet, setG);
        }
        return linkedHashSet;
    }

    @Override // t9.o
    public final Set o() {
        i iVar = this.f9797j;
        List listD = iVar.f9811s.d();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            x.D0(linkedHashSet, ((v) it.next()).v0().c());
        }
        linkedHashSet.addAll(((r9.i) this.f9835b.f9070f).f9060n.e(iVar));
        return linkedHashSet;
    }

    @Override // t9.o
    public final Set p() {
        List listD = this.f9797j.f9811s.d();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            x.D0(linkedHashSet, ((v) it.next()).v0().d());
        }
        return linkedHashSet;
    }

    @Override // t9.o
    public final boolean r(r rVar) {
        return ((r9.i) this.f9835b.f9070f).f9061o.b(this.f9797j, rVar);
    }

    public final void s(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        q7.k.e(((r9.i) this.f9835b.f9070f).f9055i, "<this>");
        q7.k.e(this.f9797j, "scopeOwner");
    }
}
