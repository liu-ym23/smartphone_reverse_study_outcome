package v9;

/* loaded from: classes.dex */
public abstract class p0 implements y9.l {
    public abstract int a();

    public abstract v b();

    public abstract boolean c();

    public abstract p0 d(w9.g gVar);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return c() == p0Var.c() && a() == p0Var.a() && b().equals(p0Var.b());
    }

    public final int hashCode() {
        int iD = n.f.d(a());
        if (x0.l(b())) {
            return (iD * 31) + 19;
        }
        return (iD * 31) + (c() ? 17 : b().hashCode());
    }

    public final String toString() {
        if (c()) {
            return "*";
        }
        if (a() == 1) {
            return b().toString();
        }
        return m.x.z(a()) + " " + b();
    }
}
