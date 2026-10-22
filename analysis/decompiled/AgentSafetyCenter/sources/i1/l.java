package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f5733c;

    public l(float f5) {
        super(3);
        this.f5733c = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && Float.compare(this.f5733c, ((l) obj).f5733c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5733c);
    }

    public final String toString() {
        return k0.a.q(new StringBuilder("HorizontalTo(x="), this.f5733c, ')');
    }
}
