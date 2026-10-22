package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements v {

    /* renamed from: a, reason: collision with root package name */
    public final float f11101a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11102b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11103c;

    /* renamed from: d, reason: collision with root package name */
    public final float f11104d;

    /* renamed from: e, reason: collision with root package name */
    public final float f11105e;

    public r(float f5, float f10, float f11) {
        int iW;
        this.f11101a = f5;
        this.f11102b = f10;
        this.f11103c = f11;
        if (Float.isNaN(f5) || Float.isNaN(f10) || Float.isNaN(f11) || Float.isNaN(1.0f)) {
            m0.a("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f5 + ", " + f10 + ", " + f11 + ", 1.0.");
        }
        float[] fArr = new float[5];
        float f12 = (f10 - 0.0f) * 3.0f;
        float f13 = (1.0f - f10) * 3.0f;
        double d7 = f12;
        double d10 = f13;
        double d11 = 0.0f;
        double d12 = d10 * 2.0d;
        double d13 = (d7 - d12) + d11;
        if (d13 == 0.0d) {
            iW = d10 == d11 ? 0 : d1.f0.w((float) ((d12 - d11) / (d12 - (d11 * 2.0d))), fArr, 0);
        } else {
            double d14 = -Math.sqrt((d10 * d10) - (d11 * d7));
            double d15 = (-d7) + d10;
            int iW2 = d1.f0.w((float) ((-(d14 + d15)) / d13), fArr, 0);
            iW = d1.f0.w((float) ((d14 - d15) / d13), fArr, iW2) + iW2;
            if (iW > 1) {
                float f14 = fArr[0];
                float f15 = fArr[1];
                if (f14 > f15) {
                    fArr[0] = f15;
                    fArr[1] = f14;
                } else if (f14 == f15) {
                    iW--;
                }
            }
        }
        float f16 = (f13 - f12) * 2.0f;
        int iW3 = d1.f0.w((-f16) / (((0.0f - f13) * 2.0f) - f16), fArr, iW) + iW;
        float fMin = Math.min(0.0f, 1.0f);
        float fMax = Math.max(0.0f, 1.0f);
        for (int i = 0; i < iW3; i++) {
            float f17 = fArr[i];
            float f18 = (((((((((f10 - 1.0f) * 3.0f) + 1.0f) - 0.0f) * f17) + (((1.0f - (f10 * 2.0f)) + 0.0f) * 3.0f)) * f17) + f12) * f17) + 0.0f;
            fMin = Math.min(fMin, f18);
            fMax = Math.max(fMax, f18);
        }
        long jFloatToRawIntBits = (Float.floatToRawIntBits(fMin) << 32) | (Float.floatToRawIntBits(fMax) & 4294967295L);
        this.f11104d = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
        this.f11105e = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089 A[PHI: r16
      0x0089: PHI (r16v13 float) = (r16v2 float), (r16v6 float), (r16v10 float), (r16v15 float), (r16v19 float) binds: [B:123:0x0222, B:113:0x01f5, B:89:0x01ad, B:45:0x00da, B:21:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0157 A[PHI: r12
      0x0157: PHI (r12v41 float) = (r12v25 float), (r12v36 float) binds: [B:66:0x0155, B:79:0x0186] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // s.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r27) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.r.a(float):float");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f11101a == rVar.f11101a && this.f11102b == rVar.f11102b && this.f11103c == rVar.f11103c;
    }

    public final int hashCode() {
        return Float.hashCode(1.0f) + k0.a.g(k0.a.g(Float.hashCode(this.f11101a) * 31, this.f11102b, 31), this.f11103c, 31);
    }

    public final String toString() {
        return "CubicBezierEasing(a=" + this.f11101a + ", b=" + this.f11102b + ", c=" + this.f11103c + ", d=1.0)";
    }
}
