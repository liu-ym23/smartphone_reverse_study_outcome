package ra;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.O;
import java.util.Collection;
import java.util.Set;
import p9.InterfaceC5074l;

/* renamed from: ra.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5228a implements InterfaceC5238k {
    @Override // ra.InterfaceC5238k
    public Collection<O> a(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return h().a(name, location);
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> b() {
        return h().b();
    }

    @Override // ra.InterfaceC5238k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return h().c(name, location);
    }

    @Override // ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return h().d(name, location);
    }

    @Override // ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        return h().e(kindFilter, nameFilter);
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> f() {
        return h().f();
    }

    public final InterfaceC5238k g() {
        if (!(h() instanceof AbstractC5228a)) {
            return h();
        }
        InterfaceC5238k interfaceC5238kH = h();
        kotlin.jvm.internal.p.g(interfaceC5238kH, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((AbstractC5228a) interfaceC5238kH).g();
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> getVariableNames() {
        return h().getVariableNames();
    }

    public abstract InterfaceC5238k h();
}
