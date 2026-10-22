package o2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements p2.a {

    /* renamed from: a, reason: collision with root package name */
    public float f9126a;

    @Override // p2.a
    public final float a(float f5) {
        return f5 / this.f9126a;
    }

    @Override // p2.a
    public final float b(float f5) {
        return f5 * this.f9126a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && Float.compare(this.f9126a, ((m) obj).f9126a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f9126a);
    }

    public final String toString() {
        return k0.a.q(new StringBuilder("LinearFontScaleConverter(fontScale="), this.f9126a, ')');
    }
}
