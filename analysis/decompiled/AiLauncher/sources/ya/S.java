package ya;

import java.util.List;
import ra.InterfaceC5238k;
import za.C6469o;

/* loaded from: classes5.dex */
public abstract class S implements F9.a, Ca.g {

    /* renamed from: a, reason: collision with root package name */
    public int f44045a;

    public /* synthetic */ S(kotlin.jvm.internal.i iVar) {
        this();
    }

    public final int E0() {
        return W.a(this) ? super.hashCode() : (((H0().hashCode() * 31) + F0().hashCode()) * 31) + (I0() ? 1 : 0);
    }

    public abstract List<B0> F0();

    public abstract s0 G0();

    public abstract v0 H0();

    public abstract boolean I0();

    public abstract S J0(kotlin.reflect.jvm.internal.impl.types.checker.c cVar);

    public abstract K0 K0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S)) {
            return false;
        }
        S s10 = (S) obj;
        return I0() == s10.I0() && C6469o.f45423a.a(K0(), s10.K0());
    }

    @Override // F9.a
    public F9.g getAnnotations() {
        return C6012s.a(G0());
    }

    public final int hashCode() {
        int i10 = this.f44045a;
        if (i10 != 0) {
            return i10;
        }
        int iE0 = E0();
        this.f44045a = iE0;
        return iE0;
    }

    public abstract InterfaceC5238k m();

    public S() {
    }
}
