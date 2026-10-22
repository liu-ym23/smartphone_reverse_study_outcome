package ra;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.O;
import Z8.C1173v;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import p9.InterfaceC5074l;

/* renamed from: ra.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5239l implements InterfaceC5238k {
    @Override // ra.InterfaceC5238k
    public Collection<? extends O> a(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return C1173v.m();
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> b() {
        Collection<InterfaceC0803h> collectionE = e(C5231d.f38876v, Ia.i.k());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionE) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) {
                ga.e name = ((kotlin.reflect.jvm.internal.impl.descriptors.g) obj).getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // ra.InterfaceC5238k
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return C1173v.m();
    }

    @Override // ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return null;
    }

    @Override // ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        return C1173v.m();
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> f() {
        return null;
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> getVariableNames() {
        Collection<InterfaceC0803h> collectionE = e(C5231d.f38877w, Ia.i.k());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionE) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) {
                ga.e name = ((kotlin.reflect.jvm.internal.impl.descriptors.g) obj).getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }
}
