package t;

/* loaded from: classes.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final float f9644a;

    public c(float f10) {
        this.f9644a = f10;
        if (f10 < 0.0f || f10 > 100.0f) {
            throw new IllegalArgumentException("The percent should be in the range of [0, 100]");
        }
    }

    @Override // t.a
    public final float a(long j2, d2.c cVar) {
        return (this.f9644a / 100.0f) * t0.e.c(j2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Float.compare(this.f9644a, ((c) obj).f9644a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f9644a);
    }

    public final String toString() {
        return "CornerSize(size = " + this.f9644a + "%)";
    }
}
