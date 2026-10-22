package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends q {

    /* renamed from: a, reason: collision with root package name */
    public String f15982a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o) && this.f15982a.equals(((o) obj).f15982a);
    }

    public final int hashCode() {
        return this.f15982a.hashCode();
    }

    public final String toString() {
        return k0.a.C("Fail(message=", this.f15982a, ")");
    }
}
