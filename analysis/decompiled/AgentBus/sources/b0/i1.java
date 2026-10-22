package b0;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1188a;

    public i1(String str) {
        this.f1188a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i1) && q7.k.a(this.f1188a, ((i1) obj).f1188a);
    }

    public final int hashCode() {
        return this.f1188a.hashCode();
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("OpaqueKey(key="), this.f1188a, ')');
    }
}
