package b0;

/* loaded from: classes.dex */
public final class f0 implements e3 {

    /* renamed from: a, reason: collision with root package name */
    public final q7.m f1145a;

    /* JADX WARN: Multi-variable type inference failed */
    public f0(p7.k kVar) {
        this.f1145a = (q7.m) kVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [p7.k, q7.m] */
    @Override // b0.e3
    public final Object a(t1 t1Var) {
        return this.f1145a.invoke(t1Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f0) && this.f1145a.equals(((f0) obj).f1145a);
    }

    public final int hashCode() {
        return this.f1145a.hashCode();
    }

    public final String toString() {
        return "ComputedValueHolder(compute=" + this.f1145a + ')';
    }
}
