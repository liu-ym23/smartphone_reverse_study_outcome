package d7;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2951a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2952b;

    public c0(int i2, Object obj) {
        this.f2951a = i2;
        this.f2952b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f2951a == c0Var.f2951a && q7.k.a(this.f2952b, c0Var.f2952b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f2951a) * 31;
        Object obj = this.f2952b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f2951a + ", value=" + this.f2952b + ')';
    }
}
