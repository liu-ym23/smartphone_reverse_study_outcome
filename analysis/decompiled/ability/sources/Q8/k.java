package Q8;

import D7.v;
import h8.InterfaceC1519b;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public final class k implements o {
    public final /* synthetic */ int b = 1;
    public final Object c;

    public k(o oVar) {
        this.c = oVar;
    }

    @Override // Q8.o
    public final Set a() {
        return k().a();
    }

    @Override // Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        return k().b(name, location);
    }

    @Override // Q8.q
    public Collection c(f kindFilter, S7.k kVar) {
        switch (this.b) {
            case 1:
                kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
                Collection collectionH = h(kindFilter, kVar);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : collectionH) {
                    if (((InterfaceC1527j) obj) instanceof InterfaceC1519b) {
                        arrayList.add(obj);
                    } else {
                        arrayList2.add(obj);
                    }
                }
                return v.Q0(arrayList2, J8.m.o(arrayList, l.e));
            default:
                return h(kindFilter, kVar);
        }
    }

    @Override // Q8.o
    public Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        switch (this.b) {
            case 1:
                kotlin.jvm.internal.k.f(name, "name");
                return J8.m.o(j(name, noLookupLocation), l.d);
            default:
                return j(name, noLookupLocation);
        }
    }

    @Override // Q8.o
    public final Set e() {
        return k().e();
    }

    @Override // Q8.o
    public Collection f(G8.f name, p8.a aVar) {
        switch (this.b) {
            case 1:
                kotlin.jvm.internal.k.f(name, "name");
                return J8.m.o(i(name, aVar), l.c);
            default:
                return i(name, aVar);
        }
    }

    public final o g() {
        if (!(k() instanceof k)) {
            return k();
        }
        o oVarK = k();
        kotlin.jvm.internal.k.d(oVarK, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((k) oVarK).g();
    }

    @Override // Q8.o
    public final Set getVariableNames() {
        return k().getVariableNames();
    }

    public final Collection h(f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        return k().c(kindFilter, kVar);
    }

    public final Collection i(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        return k().f(name, aVar);
    }

    public final Collection j(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        return k().d(name, noLookupLocation);
    }

    public final o k() {
        switch (this.b) {
            case 0:
                return (o) ((W8.h) this.c).invoke();
            default:
                return (o) this.c;
        }
    }

    public k(W8.l storageManager, S7.a aVar) {
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        this.c = new W8.h((W8.i) storageManager, new j(0, aVar));
    }
}
