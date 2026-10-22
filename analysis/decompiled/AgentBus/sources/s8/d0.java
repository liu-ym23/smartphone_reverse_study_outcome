package s8;

import f8.l0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class d0 extends e0 {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f9539p = 0;

    /* renamed from: n, reason: collision with root package name */
    public final l8.o f9540n;

    /* renamed from: o, reason: collision with root package name */
    public final j f9541o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(a3.b bVar, l8.o oVar, j jVar) {
        super(bVar, null);
        q7.k.e(oVar, "jClass");
        this.f9540n = oVar;
        this.f9541o = jVar;
    }

    public static l0 v(l0 l0Var) {
        if (l0Var.getKind() != 2) {
            return l0Var;
        }
        Collection collectionR = l0Var.r();
        q7.k.d(collectionR, "this.overriddenDescriptors");
        Collection<l0> collection = collectionR;
        ArrayList arrayList = new ArrayList(d7.t.A0(collection, 10));
        for (l0 l0Var2 : collection) {
            q7.k.d(l0Var2, "it");
            arrayList.add(v(l0Var2));
        }
        return (l0) d7.r.f1(d7.r.J0(arrayList));
    }

    @Override // o9.o, o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        return null;
    }

    @Override // s8.a0
    public final Set h(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        return d7.b0.f2947f;
    }

    @Override // s8.a0
    public final Set i(o9.f fVar, o9.k kVar) {
        q7.k.e(fVar, "kindFilter");
        Set setP1 = d7.r.p1(((c) this.f9521e.c()).a());
        j jVar = this.f9541o;
        d0 d0VarL = n7.a.l(jVar);
        Set setC = d0VarL != null ? d0VarL.c() : null;
        if (setC == null) {
            setC = d7.b0.f2947f;
        }
        setP1.addAll(setC);
        if (this.f9540n.f5878a.isEnum()) {
            setP1.addAll(d7.s.u0(c8.n.f2058c, c8.n.f2056a));
        }
        a3.b bVar = this.f9518b;
        ((m9.a) ((r8.a) bVar.f162f).f9025x).getClass();
        q7.k.e(bVar, "_context_receiver_0");
        q7.k.e(jVar, "thisDescriptor");
        setP1.addAll(new ArrayList());
        return setP1;
    }

    @Override // s8.a0
    public final void j(e9.f fVar, ArrayList arrayList) {
        q7.k.e(fVar, "name");
        a3.b bVar = this.f9518b;
        ((m9.a) ((r8.a) bVar.f162f).f9025x).getClass();
        q7.k.e(bVar, "_context_receiver_0");
        q7.k.e(this.f9541o, "thisDescriptor");
        q7.k.e(fVar, "name");
    }

    @Override // s8.a0
    public final c k() {
        return new a(this.f9540n, k.f9576j);
    }

    @Override // s8.a0
    public final void m(LinkedHashSet linkedHashSet, e9.f fVar) {
        q7.k.e(fVar, "name");
        j jVar = this.f9541o;
        d0 d0VarL = n7.a.l(jVar);
        Collection collectionQ1 = d0VarL == null ? d7.b0.f2947f : d7.r.q1(d0VarL.f(fVar, n8.c.f6881j));
        r8.a aVar = (r8.a) this.f9518b.f162f;
        linkedHashSet.addAll(nb.i.I(fVar, collectionQ1, linkedHashSet, this.f9541o, aVar.f9007f, ((w9.m) aVar.f9022u).f10950d));
        if (this.f9540n.f5878a.isEnum()) {
            if (fVar.equals(c8.n.f2058c)) {
                linkedHashSet.add(h9.m.i(jVar));
            } else if (fVar.equals(c8.n.f2056a)) {
                linkedHashSet.add(h9.m.j(jVar));
            }
        }
    }

    @Override // s8.e0, s8.a0
    public final void n(e9.f fVar, ArrayList arrayList) {
        q7.k.e(fVar, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        e8.m mVar = new e8.m(fVar, 1);
        j jVar = this.f9541o;
        ea.k.e(a.a.S(jVar), b0.f9530f, new c0(jVar, linkedHashSet, mVar));
        boolean zIsEmpty = arrayList.isEmpty();
        a3.b bVar = this.f9518b;
        if (zIsEmpty) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : linkedHashSet) {
                l0 l0VarV = v((l0) obj);
                Object arrayList2 = linkedHashMap.get(l0VarV);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(l0VarV, arrayList2);
                }
                ((List) arrayList2).add(obj);
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) ((Map.Entry) it.next()).getValue();
                r8.a aVar = (r8.a) bVar.f162f;
                d7.x.D0(arrayList3, nb.i.I(fVar, collection, arrayList, this.f9541o, aVar.f9007f, ((w9.m) aVar.f9022u).f10950d));
            }
            arrayList.addAll(arrayList3);
        } else {
            r8.a aVar2 = (r8.a) bVar.f162f;
            arrayList.addAll(nb.i.I(fVar, linkedHashSet, arrayList, this.f9541o, aVar2.f9007f, ((w9.m) aVar2.f9022u).f10950d));
        }
        if (this.f9540n.f5878a.isEnum() && fVar.equals(c8.n.f2057b)) {
            ea.k.a(arrayList, h9.m.h(jVar));
        }
    }

    @Override // s8.a0
    public final Set o(o9.f fVar) {
        q7.k.e(fVar, "kindFilter");
        Set setP1 = d7.r.p1(((c) this.f9521e.c()).d());
        k kVar = k.f9577k;
        j jVar = this.f9541o;
        ea.k.e(a.a.S(jVar), b0.f9530f, new c0(jVar, setP1, kVar));
        if (this.f9540n.f5878a.isEnum()) {
            setP1.add(c8.n.f2057b);
        }
        return setP1;
    }

    @Override // s8.a0
    public final f8.j q() {
        return this.f9541o;
    }
}
