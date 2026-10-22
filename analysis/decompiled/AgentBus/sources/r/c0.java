package r;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f8850a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8851b;

    /* renamed from: c, reason: collision with root package name */
    public final float f8852c;

    /* renamed from: d, reason: collision with root package name */
    public final float f8853d;

    public c0(float f10, float f11, float f12, float f13) {
        this.f8850a = f10;
        this.f8851b = f11;
        this.f8852c = f12;
        this.f8853d = f13;
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Start padding must be non-negative");
        }
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Top padding must be non-negative");
        }
        if (f12 < 0.0f) {
            throw new IllegalArgumentException("End padding must be non-negative");
        }
        if (f13 < 0.0f) {
            throw new IllegalArgumentException("Bottom padding must be non-negative");
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return d2.f.a(this.f8850a, c0Var.f8850a) && d2.f.a(this.f8851b, c0Var.f8851b) && d2.f.a(this.f8852c, c0Var.f8852c) && d2.f.a(this.f8853d, c0Var.f8853d);
    }

    public final int hashCode() {
        return Float.hashCode(this.f8853d) + m.x.d(this.f8852c, m.x.d(this.f8851b, Float.hashCode(this.f8850a) * 31, 31), 31);
    }

    public final String toString() {
        return "PaddingValues(start=" + ((Object) d2.f.b(this.f8850a)) + ", top=" + ((Object) d2.f.b(this.f8851b)) + ", end=" + ((Object) d2.f.b(this.f8852c)) + ", bottom=" + ((Object) d2.f.b(this.f8853d)) + ')';
    }
}
