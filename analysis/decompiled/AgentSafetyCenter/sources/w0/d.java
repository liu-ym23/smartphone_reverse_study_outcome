package w0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final float f15105a;

    public d(float f5) {
        this.f15105a = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && Float.compare(this.f15105a, ((d) obj).f15105a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f15105a);
    }

    public final String toString() {
        return k0.a.q(new StringBuilder("Vertical(bias="), this.f15105a, ')');
    }
}
