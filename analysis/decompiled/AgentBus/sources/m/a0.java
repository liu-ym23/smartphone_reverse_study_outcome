package m;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f6038a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6039b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6040c;

    public a0(float f10, float f11, long j2) {
        this.f6038a = f10;
        this.f6039b = f11;
        this.f6040c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Float.compare(this.f6038a, a0Var.f6038a) == 0 && Float.compare(this.f6039b, a0Var.f6039b) == 0 && this.f6040c == a0Var.f6040c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6040c) + x.d(this.f6039b, Float.hashCode(this.f6038a) * 31, 31);
    }

    public final String toString() {
        return "FlingInfo(initialVelocity=" + this.f6038a + ", distance=" + this.f6039b + ", duration=" + this.f6040c + ')';
    }
}
