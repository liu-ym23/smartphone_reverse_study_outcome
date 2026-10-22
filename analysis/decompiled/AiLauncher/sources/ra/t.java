package ra;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.O;
import E9.Y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import la.C4882e;
import p9.InterfaceC5074l;
import ra.InterfaceC5241n;
import ya.E0;

/* loaded from: classes5.dex */
public final class t implements InterfaceC5238k {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5238k f38908b;

    /* renamed from: c, reason: collision with root package name */
    public final Y8.h f38909c;

    /* renamed from: d, reason: collision with root package name */
    public final TypeSubstitutor f38910d;

    /* renamed from: e, reason: collision with root package name */
    public Map<InterfaceC0803h, InterfaceC0803h> f38911e;

    /* renamed from: f, reason: collision with root package name */
    public final Y8.h f38912f;

    public t(InterfaceC5238k workerScope, TypeSubstitutor givenSubstitutor) {
        kotlin.jvm.internal.p.i(workerScope, "workerScope");
        kotlin.jvm.internal.p.i(givenSubstitutor, "givenSubstitutor");
        this.f38908b = workerScope;
        this.f38909c = C4848b.b(new C5245r(givenSubstitutor));
        E0 e0K = givenSubstitutor.k();
        kotlin.jvm.internal.p.h(e0K, "getSubstitution(...)");
        this.f38910d = C4882e.h(e0K, false, 1, null).c();
        this.f38912f = C4848b.b(new s(this));
    }

    public static final Collection g(t tVar) {
        return tVar.l(InterfaceC5241n.a.a(tVar.f38908b, null, null, 3, null));
    }

    public static final TypeSubstitutor m(TypeSubstitutor typeSubstitutor) {
        return typeSubstitutor.k().c();
    }

    @Override // ra.InterfaceC5238k
    public Collection<? extends O> a(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return l(this.f38908b.a(name, location));
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> b() {
        return this.f38908b.b();
    }

    @Override // ra.InterfaceC5238k
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return l(this.f38908b.c(name, location));
    }

    @Override // ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        InterfaceC0799d interfaceC0799dD = this.f38908b.d(name, location);
        if (interfaceC0799dD != null) {
            return (InterfaceC0799d) k(interfaceC0799dD);
        }
        return null;
    }

    @Override // ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        return j();
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> f() {
        return this.f38908b.f();
    }

    @Override // ra.InterfaceC5238k
    public Set<ga.e> getVariableNames() {
        return this.f38908b.getVariableNames();
    }

    public final Collection<InterfaceC0803h> j() {
        return (Collection) this.f38912f.getValue();
    }

    public final <D extends InterfaceC0803h> D k(D d10) {
        if (this.f38910d.l()) {
            return d10;
        }
        if (this.f38911e == null) {
            this.f38911e = new HashMap();
        }
        Map<InterfaceC0803h, InterfaceC0803h> map = this.f38911e;
        kotlin.jvm.internal.p.f(map);
        InterfaceC0803h interfaceC0803hC = map.get(d10);
        if (interfaceC0803hC == null) {
            if (!(d10 instanceof Y)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + d10).toString());
            }
            interfaceC0803hC = ((Y) d10).c(this.f38910d);
            if (interfaceC0803hC == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d10 + " substitution fails");
            }
            map.put(d10, interfaceC0803hC);
        }
        D d11 = (D) interfaceC0803hC;
        kotlin.jvm.internal.p.g(d11, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return d11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends InterfaceC0803h> Collection<D> l(Collection<? extends D> collection) {
        if (this.f38910d.l() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetG = Ia.a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetG.add(k((InterfaceC0803h) it.next()));
        }
        return linkedHashSetG;
    }
}
