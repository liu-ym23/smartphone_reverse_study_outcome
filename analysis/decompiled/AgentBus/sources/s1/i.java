package s1;

/* loaded from: classes.dex */
public final class i extends k {

    /* renamed from: a, reason: collision with root package name */
    public final String f9275a;

    /* renamed from: b, reason: collision with root package name */
    public final f0 f9276b;

    public i(String str, f0 f0Var) {
        this.f9275a = str;
        this.f9276b = f0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return q7.k.a(this.f9275a, iVar.f9275a) && q7.k.a(this.f9276b, iVar.f9276b);
    }

    public final int hashCode() {
        int iHashCode = this.f9275a.hashCode() * 31;
        f0 f0Var = this.f9276b;
        return (iHashCode + (f0Var != null ? f0Var.hashCode() : 0)) * 31;
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("LinkAnnotation.Clickable(tag="), this.f9275a, ')');
    }
}
