package n;

/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6741a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6742b;

    public v0(Object obj, Object obj2) {
        this.f6741a = obj;
        this.f6742b = obj2;
    }

    public final boolean a(m.n nVar, m.n nVar2) {
        return nVar.equals(this.f6741a) && nVar2.equals(this.f6742b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return q7.k.a(this.f6741a, v0Var.f6741a) && q7.k.a(this.f6742b, v0Var.f6742b);
    }

    public final int hashCode() {
        Object obj = this.f6741a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f6742b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }
}
