package z2;

/* loaded from: classes2.dex */
public final class P8 extends R8 {

    /* renamed from: a, reason: collision with root package name */
    public final float f44766a;

    /* renamed from: b, reason: collision with root package name */
    public final float f44767b;

    /* renamed from: c, reason: collision with root package name */
    public final float f44768c;

    /* renamed from: d, reason: collision with root package name */
    public final float f44769d;

    public P8(float f10, float f11, float f12, float f13, float f14) {
        this.f44766a = f10;
        this.f44767b = f11;
        this.f44768c = f12;
        this.f44769d = f13;
    }

    @Override // z2.R8
    public final float a() {
        return 0.0f;
    }

    @Override // z2.R8
    public final float b() {
        return this.f44768c;
    }

    @Override // z2.R8
    public final float c() {
        return this.f44766a;
    }

    @Override // z2.R8
    public final float d() {
        return this.f44769d;
    }

    @Override // z2.R8
    public final float e() {
        return this.f44767b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof R8) {
            R8 r82 = (R8) obj;
            if (Float.floatToIntBits(this.f44766a) == Float.floatToIntBits(r82.c()) && Float.floatToIntBits(this.f44767b) == Float.floatToIntBits(r82.e()) && Float.floatToIntBits(this.f44768c) == Float.floatToIntBits(r82.b()) && Float.floatToIntBits(this.f44769d) == Float.floatToIntBits(r82.d())) {
                int iFloatToIntBits = Float.floatToIntBits(0.0f);
                r82.a();
                if (iFloatToIntBits == Float.floatToIntBits(0.0f)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iFloatToIntBits = ((((Float.floatToIntBits(this.f44766a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.f44767b)) * 1000003) ^ Float.floatToIntBits(this.f44768c);
        return ((Float.floatToIntBits(this.f44769d) ^ (iFloatToIntBits * 1000003)) * 1000003) ^ Float.floatToIntBits(0.0f);
    }

    public final String toString() {
        return "PredictedArea{xMin=" + this.f44766a + ", yMin=" + this.f44767b + ", xMax=" + this.f44768c + ", yMax=" + this.f44769d + ", confidenceScore=0.0}";
    }
}
