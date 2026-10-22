package c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f2166e = new c(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f2167a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2168b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2169c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2170d;

    public c(float f5, float f10, float f11, float f12) {
        this.f2167a = f5;
        this.f2168b = f10;
        this.f2169c = f11;
        this.f2170d = f12;
    }

    public final long a() {
        float f5 = this.f2169c;
        float f10 = this.f2167a;
        float f11 = ((f5 - f10) / 2.0f) + f10;
        float f12 = this.f2170d;
        float f13 = this.f2168b;
        return (Float.floatToRawIntBits(((f12 - f13) / 2.0f) + f13) & 4294967295L) | (Float.floatToRawIntBits(f11) << 32);
    }

    public final long b() {
        float f5 = this.f2169c - this.f2167a;
        float f10 = this.f2170d - this.f2168b;
        return (Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32);
    }

    public final c c(c cVar) {
        return new c(Math.max(this.f2167a, cVar.f2167a), Math.max(this.f2168b, cVar.f2168b), Math.min(this.f2169c, cVar.f2169c), Math.min(this.f2170d, cVar.f2170d));
    }

    public final c d(float f5, float f10) {
        return new c(this.f2167a + f5, this.f2168b + f10, this.f2169c + f5, this.f2170d + f10);
    }

    public final c e(long j10) {
        int i = (int) (j10 >> 32);
        int i3 = (int) (j10 & 4294967295L);
        return new c(Float.intBitsToFloat(i) + this.f2167a, Float.intBitsToFloat(i3) + this.f2168b, Float.intBitsToFloat(i) + this.f2169c, Float.intBitsToFloat(i3) + this.f2170d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Float.compare(this.f2167a, cVar.f2167a) == 0 && Float.compare(this.f2168b, cVar.f2168b) == 0 && Float.compare(this.f2169c, cVar.f2169c) == 0 && Float.compare(this.f2170d, cVar.f2170d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f2170d) + k0.a.g(k0.a.g(Float.hashCode(this.f2167a) * 31, this.f2168b, 31), this.f2169c, 31);
    }

    public final String toString() {
        return "Rect.fromLTRB(" + id.c.L(this.f2167a) + ", " + id.c.L(this.f2168b) + ", " + id.c.L(this.f2169c) + ", " + id.c.L(this.f2170d) + ')';
    }
}
