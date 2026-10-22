package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public float f8644a;

    public final boolean equals(Object obj) {
        return (obj instanceof a) && Float.compare(this.f8644a, ((a) obj).f8644a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f8644a);
    }

    public final String toString() {
        return "BaselineShift(multiplier=" + this.f8644a + ')';
    }
}
