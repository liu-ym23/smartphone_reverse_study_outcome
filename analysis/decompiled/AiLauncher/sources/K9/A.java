package K9;

import Z8.C1173v;
import Z9.InterfaceC1178a;
import java.util.Collection;
import java.util.List;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final class A extends t implements Z9.u {

    /* renamed from: a, reason: collision with root package name */
    public final ga.c f4141a;

    public A(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        this.f4141a = fqName;
    }

    @Override // Z9.d
    public boolean A() {
        return false;
    }

    @Override // Z9.u
    public Collection<Z9.g> H(InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        return C1173v.m();
    }

    @Override // Z9.d
    public InterfaceC1178a d(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof A) && kotlin.jvm.internal.p.d(f(), ((A) obj).f());
    }

    @Override // Z9.u
    public ga.c f() {
        return this.f4141a;
    }

    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return A.class.getName() + ": " + f();
    }

    @Override // Z9.u
    public Collection<Z9.u> u() {
        return C1173v.m();
    }

    @Override // Z9.d
    public List<InterfaceC1178a> getAnnotations() {
        return C1173v.m();
    }
}
