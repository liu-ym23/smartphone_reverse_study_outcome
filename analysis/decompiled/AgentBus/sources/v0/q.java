package v0;

import java.util.Arrays;
import u0.z;

/* loaded from: classes.dex */
public final class q extends c {

    /* renamed from: r, reason: collision with root package name */
    public static final b4.b f10323r = new b4.b(19);

    /* renamed from: d, reason: collision with root package name */
    public final s f10324d;

    /* renamed from: e, reason: collision with root package name */
    public final float f10325e;

    /* renamed from: f, reason: collision with root package name */
    public final float f10326f;

    /* renamed from: g, reason: collision with root package name */
    public final r f10327g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f10328h;

    /* renamed from: i, reason: collision with root package name */
    public final float[] f10329i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f10330j;

    /* renamed from: k, reason: collision with root package name */
    public final i f10331k;

    /* renamed from: l, reason: collision with root package name */
    public final p f10332l;

    /* renamed from: m, reason: collision with root package name */
    public final m f10333m;

    /* renamed from: n, reason: collision with root package name */
    public final i f10334n;

    /* renamed from: o, reason: collision with root package name */
    public final p f10335o;

    /* renamed from: p, reason: collision with root package name */
    public final m f10336p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f10337q;

    public q(String str, float[] fArr, s sVar, final r rVar, int i2) {
        i iVar;
        i iVar2;
        double d6 = rVar.f10338a;
        boolean z4 = d6 == -3.0d;
        double d10 = rVar.f10344g;
        double d11 = rVar.f10343f;
        if (z4) {
            final int i10 = 4;
            iVar = new i() { // from class: v0.o
                @Override // v0.i
                public final double b(double d12) {
                    int i11 = i10;
                    r rVar2 = rVar;
                    switch (i11) {
                        case 0:
                            float[] fArr2 = d.f10272a;
                            return d.a(rVar2, d12);
                        case 1:
                            float[] fArr3 = d.f10272a;
                            return d.c(rVar2, d12);
                        case 2:
                            double d13 = rVar2.f10339b;
                            return d12 >= rVar2.f10342e ? Math.pow((d13 * d12) + rVar2.f10340c, rVar2.f10338a) : rVar2.f10341d * d12;
                        case 3:
                            double d14 = rVar2.f10339b;
                            double d15 = rVar2.f10340c;
                            double d16 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e ? Math.pow((d14 * d12) + d15, rVar2.f10338a) + rVar2.f10343f : (d16 * d12) + rVar2.f10344g;
                        case 4:
                            float[] fArr4 = d.f10272a;
                            return d.b(rVar2, d12);
                        case 5:
                            float[] fArr5 = d.f10272a;
                            return d.d(rVar2, d12);
                        case 6:
                            double d17 = rVar2.f10339b;
                            double d18 = rVar2.f10340c;
                            double d19 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d19 ? (Math.pow(d12, 1.0d / rVar2.f10338a) - d18) / d17 : d12 / d19;
                        default:
                            double d20 = rVar2.f10339b;
                            double d21 = rVar2.f10340c;
                            double d22 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d22 ? (Math.pow(d12 - rVar2.f10343f, 1.0d / rVar2.f10338a) - d21) / d20 : (d12 - rVar2.f10344g) / d22;
                    }
                }
            };
        } else if (d6 == -2.0d) {
            final int i11 = 5;
            iVar = new i() { // from class: v0.o
                @Override // v0.i
                public final double b(double d12) {
                    int i112 = i11;
                    r rVar2 = rVar;
                    switch (i112) {
                        case 0:
                            float[] fArr2 = d.f10272a;
                            return d.a(rVar2, d12);
                        case 1:
                            float[] fArr3 = d.f10272a;
                            return d.c(rVar2, d12);
                        case 2:
                            double d13 = rVar2.f10339b;
                            return d12 >= rVar2.f10342e ? Math.pow((d13 * d12) + rVar2.f10340c, rVar2.f10338a) : rVar2.f10341d * d12;
                        case 3:
                            double d14 = rVar2.f10339b;
                            double d15 = rVar2.f10340c;
                            double d16 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e ? Math.pow((d14 * d12) + d15, rVar2.f10338a) + rVar2.f10343f : (d16 * d12) + rVar2.f10344g;
                        case 4:
                            float[] fArr4 = d.f10272a;
                            return d.b(rVar2, d12);
                        case 5:
                            float[] fArr5 = d.f10272a;
                            return d.d(rVar2, d12);
                        case 6:
                            double d17 = rVar2.f10339b;
                            double d18 = rVar2.f10340c;
                            double d19 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d19 ? (Math.pow(d12, 1.0d / rVar2.f10338a) - d18) / d17 : d12 / d19;
                        default:
                            double d20 = rVar2.f10339b;
                            double d21 = rVar2.f10340c;
                            double d22 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d22 ? (Math.pow(d12 - rVar2.f10343f, 1.0d / rVar2.f10338a) - d21) / d20 : (d12 - rVar2.f10344g) / d22;
                    }
                }
            };
        } else if (d11 == 0.0d && d10 == 0.0d) {
            final int i12 = 6;
            iVar = new i() { // from class: v0.o
                @Override // v0.i
                public final double b(double d12) {
                    int i112 = i12;
                    r rVar2 = rVar;
                    switch (i112) {
                        case 0:
                            float[] fArr2 = d.f10272a;
                            return d.a(rVar2, d12);
                        case 1:
                            float[] fArr3 = d.f10272a;
                            return d.c(rVar2, d12);
                        case 2:
                            double d13 = rVar2.f10339b;
                            return d12 >= rVar2.f10342e ? Math.pow((d13 * d12) + rVar2.f10340c, rVar2.f10338a) : rVar2.f10341d * d12;
                        case 3:
                            double d14 = rVar2.f10339b;
                            double d15 = rVar2.f10340c;
                            double d16 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e ? Math.pow((d14 * d12) + d15, rVar2.f10338a) + rVar2.f10343f : (d16 * d12) + rVar2.f10344g;
                        case 4:
                            float[] fArr4 = d.f10272a;
                            return d.b(rVar2, d12);
                        case 5:
                            float[] fArr5 = d.f10272a;
                            return d.d(rVar2, d12);
                        case 6:
                            double d17 = rVar2.f10339b;
                            double d18 = rVar2.f10340c;
                            double d19 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d19 ? (Math.pow(d12, 1.0d / rVar2.f10338a) - d18) / d17 : d12 / d19;
                        default:
                            double d20 = rVar2.f10339b;
                            double d21 = rVar2.f10340c;
                            double d22 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d22 ? (Math.pow(d12 - rVar2.f10343f, 1.0d / rVar2.f10338a) - d21) / d20 : (d12 - rVar2.f10344g) / d22;
                    }
                }
            };
        } else {
            final int i13 = 7;
            iVar = new i() { // from class: v0.o
                @Override // v0.i
                public final double b(double d12) {
                    int i112 = i13;
                    r rVar2 = rVar;
                    switch (i112) {
                        case 0:
                            float[] fArr2 = d.f10272a;
                            return d.a(rVar2, d12);
                        case 1:
                            float[] fArr3 = d.f10272a;
                            return d.c(rVar2, d12);
                        case 2:
                            double d13 = rVar2.f10339b;
                            return d12 >= rVar2.f10342e ? Math.pow((d13 * d12) + rVar2.f10340c, rVar2.f10338a) : rVar2.f10341d * d12;
                        case 3:
                            double d14 = rVar2.f10339b;
                            double d15 = rVar2.f10340c;
                            double d16 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e ? Math.pow((d14 * d12) + d15, rVar2.f10338a) + rVar2.f10343f : (d16 * d12) + rVar2.f10344g;
                        case 4:
                            float[] fArr4 = d.f10272a;
                            return d.b(rVar2, d12);
                        case 5:
                            float[] fArr5 = d.f10272a;
                            return d.d(rVar2, d12);
                        case 6:
                            double d17 = rVar2.f10339b;
                            double d18 = rVar2.f10340c;
                            double d19 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d19 ? (Math.pow(d12, 1.0d / rVar2.f10338a) - d18) / d17 : d12 / d19;
                        default:
                            double d20 = rVar2.f10339b;
                            double d21 = rVar2.f10340c;
                            double d22 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d22 ? (Math.pow(d12 - rVar2.f10343f, 1.0d / rVar2.f10338a) - d21) / d20 : (d12 - rVar2.f10344g) / d22;
                    }
                }
            };
        }
        if (d6 == -3.0d) {
            final int i14 = 0;
            iVar2 = new i() { // from class: v0.o
                @Override // v0.i
                public final double b(double d12) {
                    int i112 = i14;
                    r rVar2 = rVar;
                    switch (i112) {
                        case 0:
                            float[] fArr2 = d.f10272a;
                            return d.a(rVar2, d12);
                        case 1:
                            float[] fArr3 = d.f10272a;
                            return d.c(rVar2, d12);
                        case 2:
                            double d13 = rVar2.f10339b;
                            return d12 >= rVar2.f10342e ? Math.pow((d13 * d12) + rVar2.f10340c, rVar2.f10338a) : rVar2.f10341d * d12;
                        case 3:
                            double d14 = rVar2.f10339b;
                            double d15 = rVar2.f10340c;
                            double d16 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e ? Math.pow((d14 * d12) + d15, rVar2.f10338a) + rVar2.f10343f : (d16 * d12) + rVar2.f10344g;
                        case 4:
                            float[] fArr4 = d.f10272a;
                            return d.b(rVar2, d12);
                        case 5:
                            float[] fArr5 = d.f10272a;
                            return d.d(rVar2, d12);
                        case 6:
                            double d17 = rVar2.f10339b;
                            double d18 = rVar2.f10340c;
                            double d19 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d19 ? (Math.pow(d12, 1.0d / rVar2.f10338a) - d18) / d17 : d12 / d19;
                        default:
                            double d20 = rVar2.f10339b;
                            double d21 = rVar2.f10340c;
                            double d22 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d22 ? (Math.pow(d12 - rVar2.f10343f, 1.0d / rVar2.f10338a) - d21) / d20 : (d12 - rVar2.f10344g) / d22;
                    }
                }
            };
        } else if (d6 == -2.0d) {
            final int i15 = 1;
            iVar2 = new i() { // from class: v0.o
                @Override // v0.i
                public final double b(double d12) {
                    int i112 = i15;
                    r rVar2 = rVar;
                    switch (i112) {
                        case 0:
                            float[] fArr2 = d.f10272a;
                            return d.a(rVar2, d12);
                        case 1:
                            float[] fArr3 = d.f10272a;
                            return d.c(rVar2, d12);
                        case 2:
                            double d13 = rVar2.f10339b;
                            return d12 >= rVar2.f10342e ? Math.pow((d13 * d12) + rVar2.f10340c, rVar2.f10338a) : rVar2.f10341d * d12;
                        case 3:
                            double d14 = rVar2.f10339b;
                            double d15 = rVar2.f10340c;
                            double d16 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e ? Math.pow((d14 * d12) + d15, rVar2.f10338a) + rVar2.f10343f : (d16 * d12) + rVar2.f10344g;
                        case 4:
                            float[] fArr4 = d.f10272a;
                            return d.b(rVar2, d12);
                        case 5:
                            float[] fArr5 = d.f10272a;
                            return d.d(rVar2, d12);
                        case 6:
                            double d17 = rVar2.f10339b;
                            double d18 = rVar2.f10340c;
                            double d19 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d19 ? (Math.pow(d12, 1.0d / rVar2.f10338a) - d18) / d17 : d12 / d19;
                        default:
                            double d20 = rVar2.f10339b;
                            double d21 = rVar2.f10340c;
                            double d22 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d22 ? (Math.pow(d12 - rVar2.f10343f, 1.0d / rVar2.f10338a) - d21) / d20 : (d12 - rVar2.f10344g) / d22;
                    }
                }
            };
        } else if (d11 == 0.0d && d10 == 0.0d) {
            final int i16 = 2;
            iVar2 = new i() { // from class: v0.o
                @Override // v0.i
                public final double b(double d12) {
                    int i112 = i16;
                    r rVar2 = rVar;
                    switch (i112) {
                        case 0:
                            float[] fArr2 = d.f10272a;
                            return d.a(rVar2, d12);
                        case 1:
                            float[] fArr3 = d.f10272a;
                            return d.c(rVar2, d12);
                        case 2:
                            double d13 = rVar2.f10339b;
                            return d12 >= rVar2.f10342e ? Math.pow((d13 * d12) + rVar2.f10340c, rVar2.f10338a) : rVar2.f10341d * d12;
                        case 3:
                            double d14 = rVar2.f10339b;
                            double d15 = rVar2.f10340c;
                            double d16 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e ? Math.pow((d14 * d12) + d15, rVar2.f10338a) + rVar2.f10343f : (d16 * d12) + rVar2.f10344g;
                        case 4:
                            float[] fArr4 = d.f10272a;
                            return d.b(rVar2, d12);
                        case 5:
                            float[] fArr5 = d.f10272a;
                            return d.d(rVar2, d12);
                        case 6:
                            double d17 = rVar2.f10339b;
                            double d18 = rVar2.f10340c;
                            double d19 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d19 ? (Math.pow(d12, 1.0d / rVar2.f10338a) - d18) / d17 : d12 / d19;
                        default:
                            double d20 = rVar2.f10339b;
                            double d21 = rVar2.f10340c;
                            double d22 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d22 ? (Math.pow(d12 - rVar2.f10343f, 1.0d / rVar2.f10338a) - d21) / d20 : (d12 - rVar2.f10344g) / d22;
                    }
                }
            };
        } else {
            final int i17 = 3;
            iVar2 = new i() { // from class: v0.o
                @Override // v0.i
                public final double b(double d12) {
                    int i112 = i17;
                    r rVar2 = rVar;
                    switch (i112) {
                        case 0:
                            float[] fArr2 = d.f10272a;
                            return d.a(rVar2, d12);
                        case 1:
                            float[] fArr3 = d.f10272a;
                            return d.c(rVar2, d12);
                        case 2:
                            double d13 = rVar2.f10339b;
                            return d12 >= rVar2.f10342e ? Math.pow((d13 * d12) + rVar2.f10340c, rVar2.f10338a) : rVar2.f10341d * d12;
                        case 3:
                            double d14 = rVar2.f10339b;
                            double d15 = rVar2.f10340c;
                            double d16 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e ? Math.pow((d14 * d12) + d15, rVar2.f10338a) + rVar2.f10343f : (d16 * d12) + rVar2.f10344g;
                        case 4:
                            float[] fArr4 = d.f10272a;
                            return d.b(rVar2, d12);
                        case 5:
                            float[] fArr5 = d.f10272a;
                            return d.d(rVar2, d12);
                        case 6:
                            double d17 = rVar2.f10339b;
                            double d18 = rVar2.f10340c;
                            double d19 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d19 ? (Math.pow(d12, 1.0d / rVar2.f10338a) - d18) / d17 : d12 / d19;
                        default:
                            double d20 = rVar2.f10339b;
                            double d21 = rVar2.f10340c;
                            double d22 = rVar2.f10341d;
                            return d12 >= rVar2.f10342e * d22 ? (Math.pow(d12 - rVar2.f10343f, 1.0d / rVar2.f10338a) - d21) / d20 : (d12 - rVar2.f10344g) / d22;
                    }
                }
            };
        }
        this(str, fArr, sVar, null, iVar, iVar2, 0.0f, 1.0f, rVar, i2);
    }

    @Override // v0.c
    public final float a(int i2) {
        return this.f10326f;
    }

    @Override // v0.c
    public final float b(int i2) {
        return this.f10325e;
    }

    @Override // v0.c
    public final boolean c() {
        return this.f10337q;
    }

    @Override // v0.c
    public final long d(float f10, float f11, float f12) {
        double d6 = f10;
        m mVar = this.f10336p;
        float fB = (float) mVar.b(d6);
        float fB2 = (float) mVar.b(f11);
        float fB3 = (float) mVar.b(f12);
        float[] fArr = this.f10329i;
        if (fArr.length < 9) {
            return 0L;
        }
        float f13 = (fArr[6] * fB3) + (fArr[3] * fB2) + (fArr[0] * fB);
        float f14 = (fArr[7] * fB3) + (fArr[4] * fB2) + (fArr[1] * fB);
        return (Float.floatToRawIntBits(f13) << 32) | (4294967295L & Float.floatToRawIntBits(f14));
    }

    @Override // v0.c
    public final float e(float f10, float f11, float f12) {
        double d6 = f10;
        m mVar = this.f10336p;
        float fB = (float) mVar.b(d6);
        float fB2 = (float) mVar.b(f11);
        float fB3 = (float) mVar.b(f12);
        float[] fArr = this.f10329i;
        return (fArr[8] * fB3) + (fArr[5] * fB2) + (fArr[2] * fB);
    }

    @Override // v0.c
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        q qVar = (q) obj;
        r rVar = qVar.f10327g;
        if (Float.compare(qVar.f10325e, this.f10325e) != 0 || Float.compare(qVar.f10326f, this.f10326f) != 0 || !q7.k.a(this.f10324d, qVar.f10324d) || !Arrays.equals(this.f10328h, qVar.f10328h)) {
            return false;
        }
        r rVar2 = this.f10327g;
        if (rVar2 != null) {
            return q7.k.a(rVar2, rVar);
        }
        if (rVar == null) {
            return true;
        }
        if (q7.k.a(this.f10331k, qVar.f10331k)) {
            return q7.k.a(this.f10334n, qVar.f10334n);
        }
        return false;
    }

    @Override // v0.c
    public final long f(float f10, float f11, float f12, float f13, c cVar) {
        float[] fArr = this.f10330j;
        float f14 = (fArr[6] * f12) + (fArr[3] * f11) + (fArr[0] * f10);
        float f15 = (fArr[7] * f12) + (fArr[4] * f11) + (fArr[1] * f10);
        float f16 = (fArr[8] * f12) + (fArr[5] * f11) + (fArr[2] * f10);
        m mVar = this.f10333m;
        return z.a((float) mVar.b(f14), (float) mVar.b(f15), (float) mVar.b(f16), f13, cVar);
    }

    @Override // v0.c
    public final int hashCode() {
        int iHashCode = (Arrays.hashCode(this.f10328h) + ((this.f10324d.hashCode() + (super.hashCode() * 31)) * 31)) * 31;
        float f10 = this.f10325e;
        int iFloatToIntBits = (iHashCode + (f10 == 0.0f ? 0 : Float.floatToIntBits(f10))) * 31;
        float f11 = this.f10326f;
        int iFloatToIntBits2 = (iFloatToIntBits + (f11 == 0.0f ? 0 : Float.floatToIntBits(f11))) * 31;
        r rVar = this.f10327g;
        int iHashCode2 = iFloatToIntBits2 + (rVar != null ? rVar.hashCode() : 0);
        if (rVar != null) {
            return iHashCode2;
        }
        return this.f10334n.hashCode() + ((this.f10331k.hashCode() + (iHashCode2 * 31)) * 31);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0263 A[EDGE_INSN: B:68:0x0263->B:69:0x0265 BREAK  A[LOOP:1: B:61:0x022b->B:67:0x025c], EDGE_INSN: B:75:0x0263->B:68:0x0263 BREAK  A[LOOP:0: B:46:0x01f4->B:52:0x0211]] */
    /* JADX WARN: Type inference failed for: r41v1 */
    /* JADX WARN: Type inference failed for: r41v2 */
    /* JADX WARN: Type inference failed for: r41v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q(java.lang.String r33, float[] r34, v0.s r35, float[] r36, v0.i r37, v0.i r38, float r39, float r40, v0.r r41, int r42) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.q.<init>(java.lang.String, float[], v0.s, float[], v0.i, v0.i, float, float, v0.r, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public q(String str, float[] fArr, s sVar, final double d6, float f10, float f11, int i2) {
        i iVar;
        i iVar2 = f10323r;
        if (d6 == 1.0d) {
            iVar = iVar2;
        } else {
            final int i10 = 0;
            iVar = new i() { // from class: v0.n
                @Override // v0.i
                public final double b(double d10) {
                    switch (i10) {
                        case 0:
                            if (d10 < 0.0d) {
                                d10 = 0.0d;
                            }
                            return Math.pow(d10, 1.0d / d6);
                        default:
                            if (d10 < 0.0d) {
                                d10 = 0.0d;
                            }
                            return Math.pow(d10, d6);
                    }
                }
            };
        }
        if (d6 != 1.0d) {
            final int i11 = 1;
            iVar2 = new i() { // from class: v0.n
                @Override // v0.i
                public final double b(double d10) {
                    switch (i11) {
                        case 0:
                            if (d10 < 0.0d) {
                                d10 = 0.0d;
                            }
                            return Math.pow(d10, 1.0d / d6);
                        default:
                            if (d10 < 0.0d) {
                                d10 = 0.0d;
                            }
                            return Math.pow(d10, d6);
                    }
                }
            };
        }
        this(str, fArr, sVar, null, iVar, iVar2, f10, f11, new r(d6, 1.0d, 0.0d, 0.0d, 0.0d), i2);
    }
}
