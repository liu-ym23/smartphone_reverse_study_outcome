package V8;

import D7.z;
import h8.InterfaceC1506N;
import h8.InterfaceC1524g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public abstract class p extends Q8.p {
    public static final /* synthetic */ Z7.t[] f;
    public final T8.m b;
    public final o c;
    public final W8.h d;
    public final kotlin.reflect.jvm.internal.impl.storage.a e;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        f = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(p.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), nVar.g(new PropertyReference1Impl(nVar.b(p.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public p(T8.m c, List functionList, List propertyList, List typeAliasList, S7.a aVar) {
        kotlin.jvm.internal.k.f(c, "c");
        kotlin.jvm.internal.k.f(functionList, "functionList");
        kotlin.jvm.internal.k.f(propertyList, "propertyList");
        kotlin.jvm.internal.k.f(typeAliasList, "typeAliasList");
        this.b = c;
        T8.k kVar = c.f1228a;
        kVar.c.getClass();
        this.c = new o(this, functionList, propertyList, typeAliasList);
        W8.i iVar = kVar.f1222a;
        Q8.j jVar = new Q8.j(1, aVar);
        iVar.getClass();
        this.d = new W8.h(iVar, jVar);
        I8.e eVar = new I8.e(this, 7);
        iVar.getClass();
        this.e = new kotlin.reflect.jvm.internal.impl.storage.a(iVar, eVar);
    }

    @Override // Q8.p, Q8.o
    public final Set a() {
        return (Set) S0.b.g1(this.c.g, o.f1400j[0]);
    }

    @Override // Q8.p, Q8.q
    public InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        if (p(name)) {
            return this.b.f1228a.b(k(name));
        }
        o oVar = this.c;
        if (!oVar.c.keySet().contains(name)) {
            return null;
        }
        oVar.getClass();
        return (InterfaceC1506N) oVar.f.invoke(name);
    }

    @Override // Q8.p, Q8.o
    public Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        return this.c.b(name, noLookupLocation);
    }

    @Override // Q8.p, Q8.o
    public final Set e() {
        Z7.t p = f[1];
        kotlin.reflect.jvm.internal.impl.storage.a aVar = this.e;
        kotlin.jvm.internal.k.f(aVar, "<this>");
        kotlin.jvm.internal.k.f(p, "p");
        return (Set) aVar.invoke();
    }

    @Override // Q8.p, Q8.o
    public Collection f(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        return this.c.a(name, aVar);
    }

    public abstract void g(ArrayList arrayList, S7.k kVar);

    @Override // Q8.p, Q8.o
    public final Set getVariableNames() {
        return (Set) S0.b.g1(this.c.h, o.f1400j[1]);
    }

    public final Collection h(Q8.f kindFilter, S7.k kVar) {
        NoLookupLocation noLookupLocation = NoLookupLocation.d;
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        ArrayList arrayList = new ArrayList(0);
        if (kindFilter.a(Q8.f.f)) {
            g(arrayList, kVar);
        }
        o oVar = this.c;
        oVar.getClass();
        boolean zA = kindFilter.a(Q8.f.f1121j);
        J8.h hVar = J8.h.b;
        if (zA) {
            Set<G8.f> set = (Set) S0.b.g1(oVar.h, o.f1400j[1]);
            ArrayList arrayList2 = new ArrayList();
            for (G8.f fVar : set) {
                if (((Boolean) kVar.invoke(fVar)).booleanValue()) {
                    arrayList2.addAll(oVar.b(fVar, noLookupLocation));
                }
            }
            z.d0(hVar, arrayList2);
            arrayList.addAll(arrayList2);
        }
        if (kindFilter.a(Q8.f.i)) {
            Set<G8.f> set2 = (Set) S0.b.g1(oVar.g, o.f1400j[0]);
            ArrayList arrayList3 = new ArrayList();
            for (G8.f fVar2 : set2) {
                if (((Boolean) kVar.invoke(fVar2)).booleanValue()) {
                    arrayList3.addAll(oVar.a(fVar2, noLookupLocation));
                }
            }
            z.d0(hVar, arrayList3);
            arrayList.addAll(arrayList3);
        }
        if (kindFilter.a(Q8.f.l)) {
            for (G8.f fVar3 : l()) {
                if (((Boolean) kVar.invoke(fVar3)).booleanValue()) {
                    g9.l.b(arrayList, this.b.f1228a.b(k(fVar3)));
                }
            }
        }
        if (kindFilter.a(Q8.f.g)) {
            for (Object name : oVar.c.keySet()) {
                if (((Boolean) kVar.invoke(name)).booleanValue()) {
                    oVar.getClass();
                    kotlin.jvm.internal.k.f(name, "name");
                    g9.l.b(arrayList, (InterfaceC1506N) oVar.f.invoke(name));
                }
            }
        }
        return g9.l.e(arrayList);
    }

    public void i(G8.f name, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(name, "name");
    }

    public void j(G8.f name, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(name, "name");
    }

    public abstract G8.b k(G8.f fVar);

    public final Set l() {
        return (Set) S0.b.g1(this.d, f[0]);
    }

    public abstract Set m();

    public abstract Set n();

    public abstract Set o();

    public boolean p(G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
        return l().contains(name);
    }

    public boolean q(s sVar) {
        return true;
    }
}
