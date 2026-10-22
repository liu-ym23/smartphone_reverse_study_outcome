package e1;

import d1.f0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3379d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i, int i3, long j10, String str) {
        super(str, j10, i);
        this.f3379d = i3;
    }

    @Override // e1.c
    public final float a(int i) {
        switch (this.f3379d) {
            case 0:
                return i == 0 ? 100.0f : 128.0f;
            default:
                return 2.0f;
        }
    }

    @Override // e1.c
    public final float b(int i) {
        switch (this.f3379d) {
            case 0:
                return i == 0 ? 0.0f : -128.0f;
            default:
                return -2.0f;
        }
    }

    @Override // e1.c
    public final long d(float f5, float f10, float f11) {
        long jFloatToRawIntBits;
        long jFloatToRawIntBits2;
        switch (this.f3379d) {
            case 0:
                if (f5 < 0.0f) {
                    f5 = 0.0f;
                }
                if (f5 > 100.0f) {
                    f5 = 100.0f;
                }
                if (f10 < -128.0f) {
                    f10 = -128.0f;
                }
                if (f10 > 128.0f) {
                    f10 = 128.0f;
                }
                float f12 = (f5 + 16.0f) / 116.0f;
                float f13 = (f10 * 0.002f) + f12;
                float f14 = f13 > 0.20689656f ? f13 * f13 * f13 : (f13 - 0.13793103f) * 0.12841855f;
                float f15 = f12 > 0.20689656f ? f12 * f12 * f12 : (f12 - 0.13793103f) * 0.12841855f;
                float[] fArr = j.f3378e;
                float f16 = f14 * fArr[0];
                float f17 = f15 * fArr[1];
                long jFloatToRawIntBits3 = Float.floatToRawIntBits(f16);
                long jFloatToRawIntBits4 = Float.floatToRawIntBits(f17);
                jFloatToRawIntBits = jFloatToRawIntBits3 << 32;
                jFloatToRawIntBits2 = 4294967295L & jFloatToRawIntBits4;
                break;
            default:
                if (f5 < -2.0f) {
                    f5 = -2.0f;
                }
                if (f5 > 2.0f) {
                    f5 = 2.0f;
                }
                if (f10 < -2.0f) {
                    f10 = -2.0f;
                }
                float f18 = f10 <= 2.0f ? f10 : 2.0f;
                jFloatToRawIntBits = Float.floatToRawIntBits(f5) << 32;
                jFloatToRawIntBits2 = Float.floatToRawIntBits(f18) & 4294967295L;
                break;
        }
        return jFloatToRawIntBits | jFloatToRawIntBits2;
    }

    @Override // e1.c
    public final float e(float f5, float f10, float f11) {
        switch (this.f3379d) {
            case 0:
                if (f5 < 0.0f) {
                    f5 = 0.0f;
                }
                if (f5 > 100.0f) {
                    f5 = 100.0f;
                }
                if (f11 < -128.0f) {
                    f11 = -128.0f;
                }
                if (f11 > 128.0f) {
                    f11 = 128.0f;
                }
                float f12 = ((f5 + 16.0f) / 116.0f) - (f11 * 0.005f);
                return (f12 > 0.20689656f ? f12 * f12 * f12 : 0.12841855f * (f12 - 0.13793103f)) * j.f3378e[2];
            default:
                if (f11 < -2.0f) {
                    f11 = -2.0f;
                }
                if (f11 > 2.0f) {
                    return 2.0f;
                }
                return f11;
        }
    }

    @Override // e1.c
    public final long f(float f5, float f10, float f11, float f12, c cVar) {
        switch (this.f3379d) {
            case 0:
                float[] fArr = j.f3378e;
                float f13 = f5 / fArr[0];
                float f14 = f10 / fArr[1];
                float f15 = f11 / fArr[2];
                float fCbrt = f13 > 0.008856452f ? (float) Math.cbrt(f13) : (f13 * 7.787037f) + 0.13793103f;
                float fCbrt2 = f14 > 0.008856452f ? (float) Math.cbrt(f14) : (f14 * 7.787037f) + 0.13793103f;
                float fCbrt3 = f15 > 0.008856452f ? (float) Math.cbrt(f15) : (f15 * 7.787037f) + 0.13793103f;
                float f16 = (116.0f * fCbrt2) - 16.0f;
                float f17 = (fCbrt - fCbrt2) * 500.0f;
                float f18 = (fCbrt2 - fCbrt3) * 200.0f;
                if (f16 < 0.0f) {
                    f16 = 0.0f;
                }
                if (f16 > 100.0f) {
                    f16 = 100.0f;
                }
                if (f17 < -128.0f) {
                    f17 = -128.0f;
                }
                if (f17 > 128.0f) {
                    f17 = 128.0f;
                }
                if (f18 < -128.0f) {
                    f18 = -128.0f;
                }
                return f0.a(f16, f17, f18 <= 128.0f ? f18 : 128.0f, f12, cVar);
            default:
                if (f5 < -2.0f) {
                    f5 = -2.0f;
                }
                if (f5 > 2.0f) {
                    f5 = 2.0f;
                }
                if (f10 < -2.0f) {
                    f10 = -2.0f;
                }
                if (f10 > 2.0f) {
                    f10 = 2.0f;
                }
                if (f11 < -2.0f) {
                    f11 = -2.0f;
                }
                return f0.a(f5, f10, f11 <= 2.0f ? f11 : 2.0f, f12, cVar);
        }
    }
}
