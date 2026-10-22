package d2;

/* loaded from: classes.dex */
public final class m implements e2.a {

    /* renamed from: a, reason: collision with root package name */
    public final float f2796a;

    public m(float f10) {
        this.f2796a = f10;
    }

    @Override // e2.a
    public final float a(float f10) {
        return f10 / this.f2796a;
    }

    @Override // e2.a
    public final float b(float f10) {
        return f10 * this.f2796a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && Float.compare(this.f2796a, ((m) obj).f2796a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f2796a);
    }

    public final String toString() {
        return "LinearFontScaleConverter(fontScale=" + this.f2796a + ')';
    }
}
