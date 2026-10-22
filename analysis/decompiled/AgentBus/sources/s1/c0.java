package s1;

/* loaded from: classes.dex */
public final class c0 implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f9233a;

    public final boolean equals(Object obj) {
        if (obj instanceof c0) {
            return q7.k.a(this.f9233a, ((c0) obj).f9233a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9233a.hashCode();
    }

    public final String toString() {
        return a1.a.e(')', "StringAnnotation(value=", this.f9233a);
    }
}
