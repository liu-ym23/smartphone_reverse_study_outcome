package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 implements b {

    /* renamed from: a, reason: collision with root package name */
    public String f3148a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n0) && this.f3148a.equals(((n0) obj).f3148a);
    }

    public final int hashCode() {
        return this.f3148a.hashCode();
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("VerbatimTtsAnnotation(verbatim="), this.f3148a, ')');
    }
}
