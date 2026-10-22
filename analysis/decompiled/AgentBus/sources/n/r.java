package n;

/* loaded from: classes.dex */
public final class r implements t {

    /* renamed from: a, reason: collision with root package name */
    public final float f6713a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6714b;

    /* renamed from: c, reason: collision with root package name */
    public final float f6715c;

    /* renamed from: d, reason: collision with root package name */
    public final float f6716d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6717e;

    public r(float f10, float f11, float f12) {
        int iS;
        this.f6713a = f10;
        this.f6714b = f11;
        this.f6715c = f12;
        if (Float.isNaN(f10) || Float.isNaN(f11) || Float.isNaN(f12) || Float.isNaN(1.0f)) {
            j0.a("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f10 + ", " + f11 + ", " + f12 + ", 1.0.");
        }
        float[] fArr = new float[5];
        float f13 = (f11 - 0.0f) * 3.0f;
        float f14 = (1.0f - f11) * 3.0f;
        double d6 = f13;
        double d10 = f14;
        double d11 = 0.0f;
        double d12 = d10 * 2.0d;
        double d13 = (d6 - d12) + d11;
        if (d13 == 0.0d) {
            iS = d10 == d11 ? 0 : u0.z.s((float) ((d12 - d11) / (d12 - (d11 * 2.0d))), fArr, 0);
        } else {
            double d14 = -Math.sqrt((d10 * d10) - (d11 * d6));
            double d15 = (-d6) + d10;
            int iS2 = u0.z.s((float) ((-(d14 + d15)) / d13), fArr, 0);
            iS = u0.z.s((float) ((d14 - d15) / d13), fArr, iS2) + iS2;
            if (iS > 1) {
                float f15 = fArr[0];
                float f16 = fArr[1];
                if (f15 > f16) {
                    fArr[0] = f16;
                    fArr[1] = f15;
                } else if (f15 == f16) {
                    iS--;
                }
            }
        }
        float f17 = (f14 - f13) * 2.0f;
        int iS3 = u0.z.s((-f17) / (((0.0f - f14) * 2.0f) - f17), fArr, iS) + iS;
        float fMin = Math.min(0.0f, 1.0f);
        float fMax = Math.max(0.0f, 1.0f);
        for (int i2 = 0; i2 < iS3; i2++) {
            float f18 = fArr[i2];
            float f19 = (((((((((f11 - 1.0f) * 3.0f) + 1.0f) - 0.0f) * f18) + (((1.0f - (f11 * 2.0f)) + 0.0f) * 3.0f)) * f18) + f13) * f18) + 0.0f;
            fMin = Math.min(fMin, f19);
            fMax = Math.max(fMax, f19);
        }
        long jFloatToRawIntBits = (Float.floatToRawIntBits(fMin) << 32) | (Float.floatToRawIntBits(fMax) & 4294967295L);
        this.f6716d = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
        this.f6717e = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089 A[PHI: r16
      0x0089: PHI (r16v13 float) = (r16v2 float), (r16v6 float), (r16v10 float), (r16v15 float), (r16v19 float) binds: [B:123:0x0222, B:113:0x01f5, B:89:0x01ad, B:45:0x00da, B:21:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0157 A[PHI: r12
      0x0157: PHI (r12v41 float) = (r12v25 float), (r12v36 float) binds: [B:66:0x0155, B:79:0x0186] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // n.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r27) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.r.a(float):float");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f6713a == rVar.f6713a && this.f6714b == rVar.f6714b && this.f6715c == rVar.f6715c;
    }

    public final int hashCode() {
        return Float.hashCode(1.0f) + m.x.d(this.f6715c, m.x.d(this.f6714b, Float.hashCode(this.f6713a) * 31, 31), 31);
    }

    public final String toString() {
        return "CubicBezierEasing(a=" + this.f6713a + ", b=" + this.f6714b + ", c=" + this.f6715c + ", d=1.0)";
    }
}
