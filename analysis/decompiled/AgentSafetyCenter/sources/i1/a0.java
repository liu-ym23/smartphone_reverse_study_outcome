package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f5602c;

    public a0(float f5) {
        super(3);
        this.f5602c = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a0) && Float.compare(this.f5602c, ((a0) obj).f5602c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5602c);
    }

    public final String toString() {
        return k0.a.q(new StringBuilder("VerticalTo(y="), this.f5602c, ')');
    }
}
