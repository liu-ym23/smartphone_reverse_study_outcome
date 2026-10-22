package ra;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0800e;
import E9.InterfaceC0803h;
import E9.a0;
import Z8.C1173v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import p9.InterfaceC5074l;

/* renamed from: ra.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5234g extends AbstractC5239l {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5238k f38891b;

    public C5234g(InterfaceC5238k workerScope) {
        kotlin.jvm.internal.p.i(workerScope, "workerScope");
        this.f38891b = workerScope;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<ga.e> b() {
        return this.f38891b.b();
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        InterfaceC0799d interfaceC0799dD = this.f38891b.d(name, location);
        if (interfaceC0799dD != null) {
            InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
            if (interfaceC0797b != null) {
                return interfaceC0797b;
            }
            if (interfaceC0799dD instanceof a0) {
                return (a0) interfaceC0799dD;
            }
        }
        return null;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<ga.e> f() {
        return this.f38891b.f();
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public List<InterfaceC0799d> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        C5231d c5231dN = kindFilter.n(C5231d.f38857c.c());
        if (c5231dN == null) {
            return C1173v.m();
        }
        Collection<InterfaceC0803h> collectionE = this.f38891b.e(c5231dN, nameFilter);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionE) {
            if (obj instanceof InterfaceC0800e) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<ga.e> getVariableNames() {
        return this.f38891b.getVariableNames();
    }

    public String toString() {
        return "Classes from " + this.f38891b;
    }
}
