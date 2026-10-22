package s1;

/* loaded from: classes.dex */
public final class j0 implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f9279a;

    public j0(String str) {
        this.f9279a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j0) {
            return q7.k.a(this.f9279a, ((j0) obj).f9279a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9279a.hashCode();
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("UrlAnnotation(url="), this.f9279a, ')');
    }
}
