package s1;

/* loaded from: classes.dex */
public final class k0 implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f9280a;

    public k0(String str) {
        this.f9280a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k0) {
            return q7.k.a(this.f9280a, ((k0) obj).f9280a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9280a.hashCode();
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("VerbatimTtsAnnotation(verbatim="), this.f9280a, ')');
    }
}
