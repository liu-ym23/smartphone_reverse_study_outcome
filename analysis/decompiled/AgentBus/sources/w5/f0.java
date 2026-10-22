package w5;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f10707a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10708b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10709c;

    public f0(c0 c0Var, String str, String str2) {
        q7.k.e(c0Var, "cause");
        this.f10707a = c0Var;
        this.f10708b = str;
        this.f10709c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f10707a == f0Var.f10707a && q7.k.a(this.f10708b, f0Var.f10708b) && q7.k.a(this.f10709c, f0Var.f10709c);
    }

    public final int hashCode() {
        return this.f10709c.hashCode() + m.x.g(this.f10708b, this.f10707a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RootCauseInfo(cause=");
        sb2.append(this.f10707a);
        sb2.append(", description=");
        sb2.append(this.f10708b);
        sb2.append(", action=");
        return a1.a.m(sb2, this.f10709c, ")");
    }
}
