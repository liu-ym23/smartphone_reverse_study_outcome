package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f15952a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15953b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return yb.k.a(this.f15952a, b0Var.f15952a) && yb.k.a(this.f15953b, b0Var.f15953b);
    }

    public final int hashCode() {
        Object obj = this.f15952a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f15953b;
        return (obj2 != null ? obj2.hashCode() : 0) + iHashCode;
    }

    public final String toString() {
        return androidx.activity.b.k("LedgerSyncAllResult(rules=", jb.i.c(this.f15952a), ", grants=", jb.i.c(this.f15953b), ")");
    }
}
