package u0;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final long f9912b = z.c(4278190080L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f9913c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f9914d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f9915e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f9916f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f9917g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f9918a;

    static {
        z.c(4282664004L);
        z.c(4287137928L);
        z.c(4291611852L);
        z.c(4294967295L);
        f9913c = z.c(4294901760L);
        z.c(4278255360L);
        f9914d = z.c(4278190335L);
        z.c(4294967040L);
        z.c(4278255615L);
        z.c(4294902015L);
        f9915e = z.b(0);
        f9916f = z.a(0.0f, 0.0f, 0.0f, 0.0f, v0.d.f10292u);
    }

    public /* synthetic */ m(long j2) {
        this.f9918a = j2;
    }

    public static final long a(long j2, v0.c cVar) {
        v0.g gVarE;
        v0.c cVarF = f(j2);
        int i2 = cVarF.f10271c;
        int i10 = cVar.f10271c;
        if ((i2 | i10) < 0) {
            gVarE = v0.j.e(cVarF, cVar);
        } else {
            k.t tVar = v0.h.f10304a;
            int i11 = i2 | (i10 << 6);
            Object objB = tVar.b(i11);
            if (objB == null) {
                objB = v0.j.e(cVarF, cVar);
                tVar.g(i11, objB);
            }
            gVarE = (v0.g) objB;
        }
        return gVarE.a(j2);
    }

    public static long b(float f10, long j2) {
        return z.a(h(j2), g(j2), e(j2), f10, f(j2));
    }

    public static final boolean c(long j2, long j4) {
        return j2 == j4;
    }

    public static final float d(long j2) {
        float fO;
        float f10;
        if ((63 & j2) == 0) {
            fO = (float) ib.c.O((j2 >>> 56) & 255);
            f10 = 255.0f;
        } else {
            fO = (float) ib.c.O((j2 >>> 6) & 1023);
            f10 = 1023.0f;
        }
        return fO / f10;
    }

    public static final float e(long j2) {
        int i2;
        int i10;
        int i11;
        if ((63 & j2) == 0) {
            return ((float) ib.c.O((j2 >>> 32) & 255)) / 255.0f;
        }
        short s10 = (short) ((j2 >>> 16) & 65535);
        int i12 = Short.MIN_VALUE & s10;
        int i13 = ((65535 & s10) >>> 10) & 31;
        int i14 = s10 & 1023;
        if (i13 != 0) {
            int i15 = i14 << 13;
            if (i13 == 31) {
                i2 = 255;
                if (i15 != 0) {
                    i15 |= 4194304;
                }
            } else {
                i2 = i13 + 112;
            }
            int i16 = i2;
            i10 = i15;
            i11 = i16;
        } else {
            if (i14 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i14 + 1056964608) - o.f9921a;
                return i12 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i11 = 0;
            i10 = 0;
        }
        return Float.intBitsToFloat((i11 << 23) | (i12 << 16) | i10);
    }

    public static final v0.c f(long j2) {
        float[] fArr = v0.d.f10272a;
        return v0.d.f10296y[(int) (j2 & 63)];
    }

    public static final float g(long j2) {
        int i2;
        int i10;
        int i11;
        if ((63 & j2) == 0) {
            return ((float) ib.c.O((j2 >>> 40) & 255)) / 255.0f;
        }
        short s10 = (short) ((j2 >>> 32) & 65535);
        int i12 = Short.MIN_VALUE & s10;
        int i13 = ((65535 & s10) >>> 10) & 31;
        int i14 = s10 & 1023;
        if (i13 != 0) {
            int i15 = i14 << 13;
            if (i13 == 31) {
                i2 = 255;
                if (i15 != 0) {
                    i15 |= 4194304;
                }
            } else {
                i2 = i13 + 112;
            }
            int i16 = i2;
            i10 = i15;
            i11 = i16;
        } else {
            if (i14 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i14 + 1056964608) - o.f9921a;
                return i12 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i11 = 0;
            i10 = 0;
        }
        return Float.intBitsToFloat((i11 << 23) | (i12 << 16) | i10);
    }

    public static final float h(long j2) {
        int i2;
        int i10;
        int i11;
        if ((63 & j2) == 0) {
            return ((float) ib.c.O((j2 >>> 48) & 255)) / 255.0f;
        }
        short s10 = (short) ((j2 >>> 48) & 65535);
        int i12 = Short.MIN_VALUE & s10;
        int i13 = ((65535 & s10) >>> 10) & 31;
        int i14 = s10 & 1023;
        if (i13 != 0) {
            int i15 = i14 << 13;
            if (i13 == 31) {
                i2 = 255;
                if (i15 != 0) {
                    i15 |= 4194304;
                }
            } else {
                i2 = i13 + 112;
            }
            int i16 = i2;
            i10 = i15;
            i11 = i16;
        } else {
            if (i14 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i14 + 1056964608) - o.f9921a;
                return i12 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i11 = 0;
            i10 = 0;
        }
        return Float.intBitsToFloat((i11 << 23) | (i12 << 16) | i10);
    }

    public static String i(long j2) {
        StringBuilder sb2 = new StringBuilder("Color(");
        sb2.append(h(j2));
        sb2.append(", ");
        sb2.append(g(j2));
        sb2.append(", ");
        sb2.append(e(j2));
        sb2.append(", ");
        sb2.append(d(j2));
        sb2.append(", ");
        return a1.a.l(sb2, f(j2).f10269a, ')');
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f9918a == ((m) obj).f9918a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9918a);
    }

    public final String toString() {
        return i(this.f9918a);
    }
}
