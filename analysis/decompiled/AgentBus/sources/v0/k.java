package v0;

import u0.z;

/* loaded from: classes.dex */
public final class k extends c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10310d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i2, int i10, long j2, String str) {
        super(str, j2, i2);
        this.f10310d = i10;
    }

    @Override // v0.c
    public final float a(int i2) {
        switch (this.f10310d) {
            case 0:
                return i2 == 0 ? 100.0f : 128.0f;
            default:
                return 2.0f;
        }
    }

    @Override // v0.c
    public final float b(int i2) {
        switch (this.f10310d) {
            case 0:
                return i2 == 0 ? 0.0f : -128.0f;
            default:
                return -2.0f;
        }
    }

    @Override // v0.c
    public final long d(float f10, float f11, float f12) {
        long jFloatToRawIntBits;
        long jFloatToRawIntBits2;
        switch (this.f10310d) {
            case 0:
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                if (f10 > 100.0f) {
                    f10 = 100.0f;
                }
                if (f11 < -128.0f) {
                    f11 = -128.0f;
                }
                if (f11 > 128.0f) {
                    f11 = 128.0f;
                }
                float f13 = (f10 + 16.0f) / 116.0f;
                float f14 = (f11 * 0.002f) + f13;
                float f15 = f14 > 0.20689656f ? f14 * f14 * f14 : (f14 - 0.13793103f) * 0.12841855f;
                float f16 = f13 > 0.20689656f ? f13 * f13 * f13 : (f13 - 0.13793103f) * 0.12841855f;
                float[] fArr = j.f10309e;
                float f17 = f15 * fArr[0];
                float f18 = f16 * fArr[1];
                long jFloatToRawIntBits3 = Float.floatToRawIntBits(f17);
                long jFloatToRawIntBits4 = Float.floatToRawIntBits(f18);
                jFloatToRawIntBits = jFloatToRawIntBits3 << 32;
                jFloatToRawIntBits2 = 4294967295L & jFloatToRawIntBits4;
                break;
            default:
                if (f10 < -2.0f) {
                    f10 = -2.0f;
                }
                if (f10 > 2.0f) {
                    f10 = 2.0f;
                }
                if (f11 < -2.0f) {
                    f11 = -2.0f;
                }
                float f19 = f11 <= 2.0f ? f11 : 2.0f;
                jFloatToRawIntBits = Float.floatToRawIntBits(f10) << 32;
                jFloatToRawIntBits2 = Float.floatToRawIntBits(f19) & 4294967295L;
                break;
        }
        return jFloatToRawIntBits | jFloatToRawIntBits2;
    }

    @Override // v0.c
    public final float e(float f10, float f11, float f12) {
        switch (this.f10310d) {
            case 0:
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                if (f10 > 100.0f) {
                    f10 = 100.0f;
                }
                if (f12 < -128.0f) {
                    f12 = -128.0f;
                }
                if (f12 > 128.0f) {
                    f12 = 128.0f;
                }
                float f13 = ((f10 + 16.0f) / 116.0f) - (f12 * 0.005f);
                return (f13 > 0.20689656f ? f13 * f13 * f13 : 0.12841855f * (f13 - 0.13793103f)) * j.f10309e[2];
            default:
                if (f12 < -2.0f) {
                    f12 = -2.0f;
                }
                if (f12 > 2.0f) {
                    return 2.0f;
                }
                return f12;
        }
    }

    @Override // v0.c
    public final long f(float f10, float f11, float f12, float f13, c cVar) {
        switch (this.f10310d) {
            case 0:
                float[] fArr = j.f10309e;
                float f14 = f10 / fArr[0];
                float f15 = f11 / fArr[1];
                float f16 = f12 / fArr[2];
                float fCbrt = f14 > 0.008856452f ? (float) Math.cbrt(f14) : (f14 * 7.787037f) + 0.13793103f;
                float fCbrt2 = f15 > 0.008856452f ? (float) Math.cbrt(f15) : (f15 * 7.787037f) + 0.13793103f;
                float fCbrt3 = f16 > 0.008856452f ? (float) Math.cbrt(f16) : (f16 * 7.787037f) + 0.13793103f;
                float f17 = (116.0f * fCbrt2) - 16.0f;
                float f18 = (fCbrt - fCbrt2) * 500.0f;
                float f19 = (fCbrt2 - fCbrt3) * 200.0f;
                if (f17 < 0.0f) {
                    f17 = 0.0f;
                }
                if (f17 > 100.0f) {
                    f17 = 100.0f;
                }
                if (f18 < -128.0f) {
                    f18 = -128.0f;
                }
                if (f18 > 128.0f) {
                    f18 = 128.0f;
                }
                if (f19 < -128.0f) {
                    f19 = -128.0f;
                }
                return z.a(f17, f18, f19 <= 128.0f ? f19 : 128.0f, f13, cVar);
            default:
                if (f10 < -2.0f) {
                    f10 = -2.0f;
                }
                if (f10 > 2.0f) {
                    f10 = 2.0f;
                }
                if (f11 < -2.0f) {
                    f11 = -2.0f;
                }
                if (f11 > 2.0f) {
                    f11 = 2.0f;
                }
                if (f12 < -2.0f) {
                    f12 = -2.0f;
                }
                return z.a(f10, f11, f12 <= 2.0f ? f12 : 2.0f, f13, cVar);
        }
    }
}
