package d1;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    public static final long f3019b = f0.c(4278190080L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f3020c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f3021d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f3022e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f3023f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f3024g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f3025h = 0;

    /* renamed from: a, reason: collision with root package name */
    public long f3026a;

    static {
        f0.c(4282664004L);
        f0.c(4287137928L);
        f0.c(4291611852L);
        f3020c = f0.c(4294967295L);
        f3021d = f0.c(4294901760L);
        f0.c(4278255360L);
        f3022e = f0.c(4278190335L);
        f0.c(4294967040L);
        f0.c(4278255615L);
        f0.c(4294902015L);
        f3023f = f0.b(0);
        f3024g = f0.a(0.0f, 0.0f, 0.0f, 0.0f, e1.d.f3361u);
    }

    public static final /* synthetic */ p a(long j10) {
        p pVar = new p();
        pVar.f3026a = j10;
        VarHandle.storeStoreFence();
        return pVar;
    }

    public static final long b(long j10, e1.c cVar) {
        e1.g gVarE;
        e1.c cVarG = g(j10);
        int i = cVarG.f3341c;
        int i3 = cVar.f3341c;
        if ((i | i3) < 0) {
            gVarE = e1.j.e(cVarG, cVar);
        } else {
            p.u uVar = e1.h.f3373a;
            int i10 = i | (i3 << 6);
            Object objB = uVar.b(i10);
            if (objB == null) {
                objB = e1.j.e(cVarG, cVar);
                uVar.h(i10, objB);
            }
            gVarE = (e1.g) objB;
        }
        return gVarE.a(j10);
    }

    public static long c(float f5, long j10) {
        return f0.a(i(j10), h(j10), f(j10), f5, g(j10));
    }

    public static final boolean d(long j10, long j11) {
        return j10 == j11;
    }

    public static final float e(long j10) {
        float fU;
        float f5;
        if ((63 & j10) == 0) {
            fU = (float) id.k.U((j10 >>> 56) & 255);
            f5 = 255.0f;
        } else {
            fU = (float) id.k.U((j10 >>> 6) & 1023);
            f5 = 1023.0f;
        }
        return fU / f5;
    }

    public static final float f(long j10) {
        int i;
        int i3;
        int i10;
        if ((63 & j10) == 0) {
            return ((float) id.k.U((j10 >>> 32) & 255)) / 255.0f;
        }
        short s6 = (short) ((j10 >>> 16) & 65535);
        int i11 = Short.MIN_VALUE & s6;
        int i12 = ((65535 & s6) >>> 10) & 31;
        int i13 = s6 & 1023;
        if (i12 != 0) {
            int i14 = i13 << 13;
            if (i12 == 31) {
                i = 255;
                if (i14 != 0) {
                    i14 |= 4194304;
                }
            } else {
                i = i12 + 112;
            }
            int i15 = i;
            i3 = i14;
            i10 = i15;
        } else {
            if (i13 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i13 + 1056964608) - t.f3029a;
                return i11 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i10 = 0;
            i3 = 0;
        }
        return Float.intBitsToFloat((i10 << 23) | (i11 << 16) | i3);
    }

    public static final e1.c g(long j10) {
        float[] fArr = e1.d.f3342a;
        return e1.d.f3365y[(int) (j10 & 63)];
    }

    public static final float h(long j10) {
        int i;
        int i3;
        int i10;
        if ((63 & j10) == 0) {
            return ((float) id.k.U((j10 >>> 40) & 255)) / 255.0f;
        }
        short s6 = (short) ((j10 >>> 32) & 65535);
        int i11 = Short.MIN_VALUE & s6;
        int i12 = ((65535 & s6) >>> 10) & 31;
        int i13 = s6 & 1023;
        if (i12 != 0) {
            int i14 = i13 << 13;
            if (i12 == 31) {
                i = 255;
                if (i14 != 0) {
                    i14 |= 4194304;
                }
            } else {
                i = i12 + 112;
            }
            int i15 = i;
            i3 = i14;
            i10 = i15;
        } else {
            if (i13 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i13 + 1056964608) - t.f3029a;
                return i11 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i10 = 0;
            i3 = 0;
        }
        return Float.intBitsToFloat((i10 << 23) | (i11 << 16) | i3);
    }

    public static final float i(long j10) {
        int i;
        int i3;
        int i10;
        if ((63 & j10) == 0) {
            return ((float) id.k.U((j10 >>> 48) & 255)) / 255.0f;
        }
        short s6 = (short) ((j10 >>> 48) & 65535);
        int i11 = Short.MIN_VALUE & s6;
        int i12 = ((65535 & s6) >>> 10) & 31;
        int i13 = s6 & 1023;
        if (i12 != 0) {
            int i14 = i13 << 13;
            if (i12 == 31) {
                i = 255;
                if (i14 != 0) {
                    i14 |= 4194304;
                }
            } else {
                i = i12 + 112;
            }
            int i15 = i;
            i3 = i14;
            i10 = i15;
        } else {
            if (i13 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i13 + 1056964608) - t.f3029a;
                return i11 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i10 = 0;
            i3 = 0;
        }
        return Float.intBitsToFloat((i10 << 23) | (i11 << 16) | i3);
    }

    public static String j(long j10) {
        StringBuilder sb2 = new StringBuilder("Color(");
        sb2.append(i(j10));
        sb2.append(", ");
        sb2.append(h(j10));
        sb2.append(", ");
        sb2.append(f(j10));
        sb2.append(", ");
        sb2.append(e(j10));
        sb2.append(", ");
        return k0.a.s(sb2, g(j10).f3339a, ')');
    }

    public final boolean equals(Object obj) {
        return (obj instanceof p) && this.f3026a == ((p) obj).f3026a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f3026a);
    }

    public final String toString() {
        return j(this.f3026a);
    }
}
