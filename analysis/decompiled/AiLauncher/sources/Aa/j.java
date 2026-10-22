package Aa;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.O;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import p9.InterfaceC5074l;
import ra.C5231d;

/* loaded from: classes5.dex */
public final class j extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(ErrorScopeKind kind, String... formatParams) {
        super(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
        p.i(kind, "kind");
        p.i(formatParams, "formatParams");
    }

    @Override // Aa.f, ra.InterfaceC5238k
    public Set<ga.e> b() {
        throw new IllegalStateException();
    }

    @Override // Aa.f, ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        throw new IllegalStateException(i() + ", required name: " + name);
    }

    @Override // Aa.f, ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        p.i(kindFilter, "kindFilter");
        p.i(nameFilter, "nameFilter");
        throw new IllegalStateException(i());
    }

    @Override // Aa.f, ra.InterfaceC5238k
    public Set<ga.e> f() {
        throw new IllegalStateException();
    }

    @Override // Aa.f, ra.InterfaceC5238k
    /* renamed from: g */
    public Set<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        throw new IllegalStateException(i() + ", required name: " + name);
    }

    @Override // Aa.f, ra.InterfaceC5238k
    public Set<ga.e> getVariableNames() {
        throw new IllegalStateException();
    }

    @Override // Aa.f, ra.InterfaceC5238k
    /* renamed from: h */
    public Set<O> a(ga.e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        throw new IllegalStateException(i() + ", required name: " + name);
    }

    @Override // Aa.f
    public String toString() {
        return "ThrowingScope{" + i() + '}';
    }
}
