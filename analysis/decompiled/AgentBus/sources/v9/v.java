package v9;

import java.util.List;

/* loaded from: classes.dex */
public abstract class v implements g8.a, y9.h {

    /* renamed from: f, reason: collision with root package name */
    public int f10594f;

    public abstract List C0();

    public abstract i0 D0();

    public abstract m0 E0();

    public abstract boolean F0();

    public abstract v G0(w9.g gVar);

    public abstract z0 H0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (F0() == vVar.F0()) {
            return c.t(w9.f.f10932g, H0(), vVar.H0());
        }
        return false;
    }

    @Override // g8.a
    public final g8.j getAnnotations() {
        return h.a(D0());
    }

    public final int hashCode() {
        int iHashCode;
        int i2 = this.f10594f;
        if (i2 != 0) {
            return i2;
        }
        if (c.i(this)) {
            iHashCode = super.hashCode();
        } else {
            iHashCode = (F0() ? 1 : 0) + ((C0().hashCode() + (E0().hashCode() * 31)) * 31);
        }
        this.f10594f = iHashCode;
        return iHashCode;
    }

    public abstract o9.n v0();
}
