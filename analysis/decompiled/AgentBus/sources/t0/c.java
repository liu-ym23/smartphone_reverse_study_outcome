package t0;

import m.x;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f9655e = new c(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f9656a;

    /* renamed from: b, reason: collision with root package name */
    public final float f9657b;

    /* renamed from: c, reason: collision with root package name */
    public final float f9658c;

    /* renamed from: d, reason: collision with root package name */
    public final float f9659d;

    public c(float f10, float f11, float f12, float f13) {
        this.f9656a = f10;
        this.f9657b = f11;
        this.f9658c = f12;
        this.f9659d = f13;
    }

    public final long a() {
        float f10 = this.f9658c;
        float f11 = this.f9656a;
        float f12 = ((f10 - f11) / 2.0f) + f11;
        float f13 = this.f9659d;
        float f14 = this.f9657b;
        return (Float.floatToRawIntBits(((f13 - f14) / 2.0f) + f14) & 4294967295L) | (Float.floatToRawIntBits(f12) << 32);
    }

    public final long b() {
        float f10 = this.f9658c - this.f9656a;
        float f11 = this.f9659d - this.f9657b;
        return (Float.floatToRawIntBits(f11) & 4294967295L) | (Float.floatToRawIntBits(f10) << 32);
    }

    public final c c(c cVar) {
        return new c(Math.max(this.f9656a, cVar.f9656a), Math.max(this.f9657b, cVar.f9657b), Math.min(this.f9658c, cVar.f9658c), Math.min(this.f9659d, cVar.f9659d));
    }

    public final c d(float f10, float f11) {
        return new c(this.f9656a + f10, this.f9657b + f11, this.f9658c + f10, this.f9659d + f11);
    }

    public final c e(long j2) {
        int i2 = (int) (j2 >> 32);
        int i10 = (int) (j2 & 4294967295L);
        return new c(Float.intBitsToFloat(i2) + this.f9656a, Float.intBitsToFloat(i10) + this.f9657b, Float.intBitsToFloat(i2) + this.f9658c, Float.intBitsToFloat(i10) + this.f9659d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Float.compare(this.f9656a, cVar.f9656a) == 0 && Float.compare(this.f9657b, cVar.f9657b) == 0 && Float.compare(this.f9658c, cVar.f9658c) == 0 && Float.compare(this.f9659d, cVar.f9659d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f9659d) + x.d(this.f9658c, x.d(this.f9657b, Float.hashCode(this.f9656a) * 31, 31), 31);
    }

    public final String toString() {
        return "Rect.fromLTRB(" + n7.a.D(this.f9656a) + ", " + n7.a.D(this.f9657b) + ", " + n7.a.D(this.f9658c) + ", " + n7.a.D(this.f9659d) + ')';
    }
}
