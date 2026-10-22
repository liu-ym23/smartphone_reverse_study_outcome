package t9;

import d7.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import q7.w;
import q7.x;

/* loaded from: classes.dex */
public abstract class o extends o9.o {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f9834f;

    /* renamed from: b, reason: collision with root package name */
    public final r9.k f9835b;

    /* renamed from: c, reason: collision with root package name */
    public final n f9836c;

    /* renamed from: d, reason: collision with root package name */
    public final u9.i f9837d;

    /* renamed from: e, reason: collision with root package name */
    public final u9.h f9838e;

    static {
        x xVar = w.f8821a;
        f9834f = new w7.t[]{xVar.f(new q7.p(xVar.b(o.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), xVar.f(new q7.p(xVar.b(o.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public o(r9.k kVar, List list, List list2, List list3, p7.a aVar) {
        q7.k.e(kVar, "c");
        q7.k.e(list, "functionList");
        q7.k.e(list2, "propertyList");
        q7.k.e(list3, "typeAliasList");
        this.f9835b = kVar;
        r9.i iVar = (r9.i) kVar.f9070f;
        iVar.f9049c.getClass();
        this.f9836c = new n(this, list, list2, list3);
        u9.k kVar2 = iVar.f9047a;
        ab.k kVar3 = new ab.k(aVar, 1);
        kVar2.getClass();
        this.f9837d = new u9.i(kVar2, kVar3);
        h hVar = new h(1, this);
        kVar2.getClass();
        this.f9838e = new u9.h(kVar2, hVar);
    }

    @Override // o9.o, o9.n
    public Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        n nVar = this.f9836c;
        nVar.getClass();
        q7.k.e(fVar, "name");
        return !((Set) n7.b.q(nVar.f9832h, n.f9824j[1])).contains(fVar) ? z.f2978f : (Collection) nVar.f9829e.invoke(fVar);
    }

    @Override // o9.o, o9.q
    public f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        if (q(fVar)) {
            return ((r9.i) this.f9835b.f9070f).b(l(fVar));
        }
        n nVar = this.f9836c;
        if (!nVar.f9827c.keySet().contains(fVar)) {
            return null;
        }
        nVar.getClass();
        return (s) nVar.f9830f.invoke(fVar);
    }

    @Override // o9.o, o9.n
    public final Set c() {
        return (Set) n7.b.q(this.f9836c.f9831g, n.f9824j[0]);
    }

    @Override // o9.o, o9.n
    public final Set d() {
        return (Set) n7.b.q(this.f9836c.f9832h, n.f9824j[1]);
    }

    @Override // o9.o, o9.q
    public Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        n nVar = this.f9836c;
        nVar.getClass();
        q7.k.e(fVar, "name");
        return !((Set) n7.b.q(nVar.f9831g, n.f9824j[0])).contains(fVar) ? z.f2978f : (Collection) nVar.f9828d.invoke(fVar);
    }

    @Override // o9.o, o9.n
    public final Set g() {
        w7.t tVar = f9834f[1];
        u9.h hVar = this.f9838e;
        q7.k.e(hVar, "<this>");
        q7.k.e(tVar, "p");
        return (Set) hVar.c();
    }

    public abstract void h(ArrayList arrayList, p7.k kVar);

    public final List i(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        ArrayList arrayList = new ArrayList(0);
        if (fVar.a(o9.f.f7903f)) {
            h(arrayList, kVar);
        }
        n nVar = this.f9836c;
        nVar.getClass();
        u9.i iVar = nVar.f9831g;
        u9.i iVar2 = nVar.f9832h;
        boolean zA = fVar.a(o9.f.f7907j);
        z zVar = z.f2978f;
        h9.i iVar3 = h9.i.f4237b;
        if (zA) {
            Set<e9.f> set = (Set) n7.b.q(iVar2, n.f9824j[1]);
            ArrayList arrayList2 = new ArrayList();
            for (e9.f fVar2 : set) {
                if (((Boolean) kVar.invoke(fVar2)).booleanValue()) {
                    q7.k.e(fVar2, "name");
                    arrayList2.addAll(!((Set) n7.b.q(iVar2, n.f9824j[1])).contains(fVar2) ? zVar : (Collection) nVar.f9829e.invoke(fVar2));
                }
            }
            d7.w.C0(arrayList2, iVar3);
            arrayList.addAll(arrayList2);
        }
        if (fVar.a(o9.f.f7906i)) {
            Set<e9.f> set2 = (Set) n7.b.q(iVar, n.f9824j[0]);
            ArrayList arrayList3 = new ArrayList();
            for (e9.f fVar3 : set2) {
                if (((Boolean) kVar.invoke(fVar3)).booleanValue()) {
                    q7.k.e(fVar3, "name");
                    arrayList3.addAll(!((Set) n7.b.q(iVar, n.f9824j[0])).contains(fVar3) ? zVar : (Collection) nVar.f9828d.invoke(fVar3));
                }
            }
            d7.w.C0(arrayList3, iVar3);
            arrayList.addAll(arrayList3);
        }
        if (fVar.a(o9.f.f7909l)) {
            for (e9.f fVar4 : m()) {
                if (((Boolean) kVar.invoke(fVar4)).booleanValue()) {
                    ea.k.a(arrayList, ((r9.i) this.f9835b.f9070f).b(l(fVar4)));
                }
            }
        }
        if (fVar.a(o9.f.f7904g)) {
            for (e9.f fVar5 : nVar.f9827c.keySet()) {
                if (((Boolean) kVar.invoke(fVar5)).booleanValue()) {
                    nVar.getClass();
                    q7.k.e(fVar5, "name");
                    ea.k.a(arrayList, (s) nVar.f9830f.invoke(fVar5));
                }
            }
        }
        return ea.k.d(arrayList);
    }

    public void j(e9.f fVar, ArrayList arrayList) {
        q7.k.e(fVar, "name");
    }

    public void k(e9.f fVar, ArrayList arrayList) {
        q7.k.e(fVar, "name");
    }

    public abstract e9.b l(e9.f fVar);

    public final Set m() {
        return (Set) n7.b.q(this.f9837d, f9834f[0]);
    }

    public abstract Set n();

    public abstract Set o();

    public abstract Set p();

    public boolean q(e9.f fVar) {
        q7.k.e(fVar, "name");
        return m().contains(fVar);
    }

    public boolean r(r rVar) {
        return true;
    }
}
