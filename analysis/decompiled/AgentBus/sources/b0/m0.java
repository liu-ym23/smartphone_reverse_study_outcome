package b0;

/* loaded from: classes.dex */
public final class m0 implements e3 {

    /* renamed from: a, reason: collision with root package name */
    public final o1 f1240a;

    public m0(o1 o1Var) {
        this.f1240a = o1Var;
    }

    @Override // b0.e3
    public final Object a(t1 t1Var) {
        return this.f1240a.getValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m0) && this.f1240a.equals(((m0) obj).f1240a);
    }

    public final int hashCode() {
        return this.f1240a.hashCode();
    }

    public final String toString() {
        return "DynamicValueHolder(state=" + this.f1240a + ')';
    }
}
