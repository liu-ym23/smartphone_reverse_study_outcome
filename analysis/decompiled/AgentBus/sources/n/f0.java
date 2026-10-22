package n;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final Float f6607a;

    /* renamed from: b, reason: collision with root package name */
    public t f6608b;

    public f0(Float f10, t tVar) {
        this.f6607a = f10;
        this.f6608b = tVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return f0Var.f6607a.equals(this.f6607a) && q7.k.a(f0Var.f6608b, this.f6608b);
    }

    public final int hashCode() {
        return this.f6608b.hashCode() + f.b(0, this.f6607a.hashCode() * 31, 31);
    }
}
