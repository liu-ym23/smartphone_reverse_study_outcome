package o;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final u0.e0 f7097a;

    public o(u0.e0 e0Var) {
        float f10 = a0.e.f38a;
        this.f7097a = e0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        float f10 = a0.e.f38a;
        return d2.f.a(f10, f10) && this.f7097a.equals(((o) obj).f7097a);
    }

    public final int hashCode() {
        return this.f7097a.hashCode() + (Float.hashCode(a0.e.f38a) * 31);
    }

    public final String toString() {
        return "BorderStroke(width=" + ((Object) d2.f.b(a0.e.f38a)) + ", brush=" + this.f7097a + ')';
    }
}
