package b0;

/* loaded from: classes.dex */
public final class d3 implements e3 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1130a;

    public d3(Object obj) {
        this.f1130a = obj;
    }

    @Override // b0.e3
    public final Object a(t1 t1Var) {
        return this.f1130a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d3) && q7.k.a(this.f1130a, ((d3) obj).f1130a);
    }

    public final int hashCode() {
        Object obj = this.f1130a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "StaticValueHolder(value=" + this.f1130a + ')';
    }
}
