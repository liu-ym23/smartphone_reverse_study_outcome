package d2;

/* loaded from: classes.dex */
public final class f implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public final float f2784f;

    public static final boolean a(float f10, float f11) {
        return Float.compare(f10, f11) == 0;
    }

    public static String b(float f10) {
        if (Float.isNaN(f10)) {
            return "Dp.Unspecified";
        }
        return f10 + ".dp";
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Float.compare(this.f2784f, ((f) obj).f2784f);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return Float.compare(this.f2784f, ((f) obj).f2784f) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.f2784f);
    }

    public final String toString() {
        return b(this.f2784f);
    }
}
