package H9;

import E9.InterfaceC0803h;
import E9.InterfaceC0819y;
import Z8.C1173v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p9.InterfaceC5074l;
import ra.AbstractC5230c;
import ra.AbstractC5239l;
import ra.C5231d;

/* loaded from: classes5.dex */
public class P extends AbstractC5239l {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0819y f3071b;

    /* renamed from: c, reason: collision with root package name */
    public final ga.c f3072c;

    public P(InterfaceC0819y moduleDescriptor, ga.c fqName) {
        kotlin.jvm.internal.p.i(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.p.i(fqName, "fqName");
        this.f3071b = moduleDescriptor;
        this.f3072c = fqName;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        if (!kindFilter.a(C5231d.f38857c.f())) {
            return C1173v.m();
        }
        if (this.f3072c.c() && kindFilter.l().contains(AbstractC5230c.b.f38856a)) {
            return C1173v.m();
        }
        Collection<ga.c> collectionK = this.f3071b.k(this.f3072c, nameFilter);
        ArrayList arrayList = new ArrayList(collectionK.size());
        Iterator<ga.c> it = collectionK.iterator();
        while (it.hasNext()) {
            ga.e eVarF = it.next().f();
            if (nameFilter.invoke(eVarF).booleanValue()) {
                Ia.a.a(arrayList, g(eVarF));
            }
        }
        return arrayList;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<ga.e> f() {
        return Z8.Y.e();
    }

    public final E9.L g(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        if (name.k()) {
            return null;
        }
        E9.L lF0 = this.f3071b.f0(this.f3072c.b(name));
        if (lF0.isEmpty()) {
            return null;
        }
        return lF0;
    }

    public String toString() {
        return "subpackages of " + this.f3072c + " from " + this.f3071b;
    }
}
