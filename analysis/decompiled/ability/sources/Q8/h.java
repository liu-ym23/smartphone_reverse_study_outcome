package Q8;

import h8.InterfaceC1501I;
import java.util.Collection;
import java.util.List;
import k8.AbstractC1633b;
import k8.K;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public abstract class h extends p {
    public static final /* synthetic */ Z7.t[] d;
    public final AbstractC1633b b;
    public final W8.h c;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        d = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(h.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    public h(W8.i storageManager, AbstractC1633b abstractC1633b) {
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        this.b = abstractC1633b;
        this.c = new W8.h(storageManager, new I8.e(this, 2));
    }

    @Override // Q8.p, Q8.q
    public final Collection c(f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        if (!kindFilter.a(f.n.b)) {
            return EmptyList.f4893a;
        }
        return (List) S0.b.g1(this.c, d[0]);
    }

    @Override // Q8.p, Q8.o
    public final Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        Collection collection;
        kotlin.jvm.internal.k.f(name, "name");
        List list = (List) S0.b.g1(this.c, d[0]);
        if (list.isEmpty()) {
            collection = EmptyList.f4893a;
        } else {
            g9.f fVar = new g9.f();
            for (Object obj : list) {
                if ((obj instanceof InterfaceC1501I) && kotlin.jvm.internal.k.b(((InterfaceC1501I) obj).getName(), name)) {
                    fVar.add(obj);
                }
            }
            collection = fVar;
        }
        return collection;
    }

    @Override // Q8.p, Q8.o
    public final Collection f(G8.f name, p8.a aVar) {
        Collection collection;
        kotlin.jvm.internal.k.f(name, "name");
        List list = (List) S0.b.g1(this.c, d[0]);
        if (list.isEmpty()) {
            collection = EmptyList.f4893a;
        } else {
            g9.f fVar = new g9.f();
            for (Object obj : list) {
                if ((obj instanceof K) && kotlin.jvm.internal.k.b(((K) obj).getName(), name)) {
                    fVar.add(obj);
                }
            }
            collection = fVar;
        }
        return collection;
    }

    public abstract List g();
}
