package tc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.EmptyList;
import rc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class f0 implements rc.e {

    /* renamed from: a, reason: collision with root package name */
    public final rc.e f12978a;

    public f0(rc.e eVar) {
        this.f12978a = eVar;
    }

    @Override // rc.e
    public final boolean b() {
        return false;
    }

    @Override // rc.e
    public final int c(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        Integer numC0 = gc.n.c0(name);
        if (numC0 != null) {
            return numC0.intValue();
        }
        throw new IllegalArgumentException(name.concat(" is not a valid list index"));
    }

    @Override // rc.e
    public final rc.i d() {
        return j.b.f11802a;
    }

    @Override // rc.e
    public final int e() {
        return 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return kotlin.jvm.internal.g.b(this.f12978a, f0Var.f12978a) && kotlin.jvm.internal.g.b(i(), f0Var.i());
    }

    @Override // rc.e
    public final String f(int i10) {
        return String.valueOf(i10);
    }

    @Override // rc.e
    public final List<Annotation> g(int i10) {
        if (i10 >= 0) {
            return EmptyList.f10001a;
        }
        StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Illegal index ", ", ");
        sbK.append(i());
        sbK.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbK.toString().toString());
    }

    @Override // rc.e
    public final List<Annotation> getAnnotations() {
        return EmptyList.f10001a;
    }

    @Override // rc.e
    public final rc.e h(int i10) {
        if (i10 >= 0) {
            return this.f12978a;
        }
        StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Illegal index ", ", ");
        sbK.append(i());
        sbK.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbK.toString().toString());
    }

    public final int hashCode() {
        return i().hashCode() + (this.f12978a.hashCode() * 31);
    }

    @Override // rc.e
    public final boolean isInline() {
        return false;
    }

    @Override // rc.e
    public final boolean j(int i10) {
        if (i10 >= 0) {
            return false;
        }
        StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Illegal index ", ", ");
        sbK.append(i());
        sbK.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbK.toString().toString());
    }

    public final String toString() {
        return i() + '(' + this.f12978a + ')';
    }
}
