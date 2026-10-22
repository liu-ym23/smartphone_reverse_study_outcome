package y;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final long f11540a = u0.m.f9916f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            return u0.m.c(this.f11540a, ((z) obj).f11540a);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = u0.m.f9917g;
        return Long.hashCode(this.f11540a) * 31;
    }

    public final String toString() {
        return "RippleConfiguration(color=" + ((Object) u0.m.i(this.f11540a)) + ", rippleAlpha=null)";
    }
}
