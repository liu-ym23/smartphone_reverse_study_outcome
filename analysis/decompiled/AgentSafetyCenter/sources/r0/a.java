package r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f10362a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f10362a == ((a) obj).f10362a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f10362a);
    }

    public final String toString() {
        return androidx.activity.b.l(new StringBuilder("DeltaCounter(count="), this.f10362a, ')');
    }
}
