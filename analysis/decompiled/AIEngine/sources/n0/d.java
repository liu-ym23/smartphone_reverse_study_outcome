package n0;

import android.graphics.Path;
import android.util.Log;
import com.stepos.core.data.base.Content;
import com.stepos.core.ota.crypto.FekEnvelope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {
    public static float[] a(float[] fArr, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i10, length);
        float[] fArr2 = new float[i10];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:44:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static n0.d.a[] b(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.d.b(java.lang.String):n0.d$a[]");
    }

    public static a[] c(a[] aVarArr) {
        a[] aVarArr2 = new a[aVarArr.length];
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            aVarArr2[i10] = new a(aVarArr[i10]);
        }
        return aVarArr2;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public char f10593a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f10594b;

        public a(char c9, float[] fArr) {
            this.f10593a = c9;
            this.f10594b = fArr;
        }

        public static void a(Path path, float f8, float f9, float f10, float f11, float f12, float f13, float f14, boolean z, boolean z3) {
            double d8;
            double d10;
            double radians = Math.toRadians(f14);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d11 = f8;
            double d12 = f9;
            double d13 = f12;
            double d14 = ((d12 * dSin) + (d11 * dCos)) / d13;
            double d15 = f13;
            double d16 = ((d12 * dCos) + ((-f8) * dSin)) / d15;
            double d17 = f11;
            double d18 = ((d17 * dSin) + (f10 * dCos)) / d13;
            double d19 = ((d17 * dCos) + ((-f10) * dSin)) / d15;
            double d20 = d14 - d18;
            double d21 = d16 - d19;
            double d22 = (d14 + d18) / 2.0d;
            double d23 = (d16 + d19) / 2.0d;
            double d24 = (d21 * d21) + (d20 * d20);
            if (d24 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d25 = (1.0d / d24) - 0.25d;
            if (d25 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d24);
                float fSqrt = (float) (Math.sqrt(d24) / 1.99999d);
                a(path, f8, f9, f10, f11, f12 * fSqrt, fSqrt * f13, f14, z, z3);
                return;
            }
            double dSqrt = Math.sqrt(d25);
            double d26 = dSqrt * d20;
            double d27 = dSqrt * d21;
            if (z == z3) {
                d8 = d22 - d27;
                d10 = d23 + d26;
            } else {
                d8 = d22 + d27;
                d10 = d23 - d26;
            }
            double dAtan2 = Math.atan2(d16 - d10, d14 - d8);
            double dAtan22 = Math.atan2(d19 - d10, d18 - d8) - dAtan2;
            if (z3 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d28 = d8 * d13;
            double d29 = d10 * d15;
            double d30 = (d28 * dCos) - (d29 * dSin);
            double d31 = (d29 * dCos) + (d28 * dSin);
            int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
            double dCos2 = Math.cos(radians);
            double dSin2 = Math.sin(radians);
            double dCos3 = Math.cos(dAtan2);
            double dSin3 = Math.sin(dAtan2);
            double d32 = -d13;
            double d33 = d32 * dCos2;
            double d34 = d15 * dSin2;
            double d35 = (d33 * dSin3) - (d34 * dCos3);
            double d36 = d32 * dSin2;
            double d37 = d15 * dCos2;
            double d38 = dAtan22 / iCeil;
            double d39 = (dCos3 * d37) + (dSin3 * d36);
            double d40 = d11;
            double d41 = d12;
            int i10 = 0;
            double d42 = dAtan2;
            while (i10 < iCeil) {
                double d43 = d42 + d38;
                double dSin4 = Math.sin(d43);
                double dCos4 = Math.cos(d43);
                int i11 = iCeil;
                double d44 = (((d13 * dCos2) * dCos4) + d30) - (d34 * dSin4);
                double d45 = (d37 * dSin4) + (d13 * dSin2 * dCos4) + d31;
                double d46 = (d33 * dSin4) - (d34 * dCos4);
                double d47 = (dCos4 * d37) + (dSin4 * d36);
                double d48 = d43 - d42;
                double dTan = Math.tan(d48 / 2.0d);
                double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d48)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d35 * dSqrt2) + d40), (float) ((d39 * dSqrt2) + d41), (float) (d44 - (dSqrt2 * d46)), (float) (d45 - (dSqrt2 * d47)), (float) d44, (float) d45);
                i10++;
                d41 = d45;
                dCos2 = dCos2;
                d36 = d36;
                d42 = d43;
                d39 = d47;
                d40 = d44;
                iCeil = i11;
                d35 = d46;
                d38 = d38;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated
        public static void b(a[] aVarArr, Path path) {
            int i10;
            float[] fArr;
            int i11;
            a aVar;
            int i12;
            char c9;
            float f8;
            float f9;
            a aVar2;
            boolean z;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            a[] aVarArr2 = aVarArr;
            Path path2 = path;
            float[] fArr2 = new float[6];
            int length = aVarArr2.length;
            int i13 = 0;
            int i14 = 0;
            char c10 = 'm';
            while (i14 < length) {
                a aVar3 = aVarArr2[i14];
                char c11 = aVar3.f10593a;
                float[] fArr3 = aVar3.f10594b;
                float f18 = fArr2[i13];
                float f19 = fArr2[1];
                float f20 = fArr2[2];
                float f21 = fArr2[3];
                float f22 = fArr2[4];
                int i15 = i13;
                float f23 = fArr2[5];
                switch (c11) {
                    case 'A':
                    case 'a':
                        i10 = 7;
                        break;
                    case 'C':
                    case 'c':
                        i10 = 6;
                        break;
                    case 'H':
                    case 'V':
                    case Content.Types.TYPE_BOOLEAN /* 104 */:
                    case 'v':
                        i10 = 1;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i10 = 4;
                        break;
                    case 'Z':
                    case FekEnvelope.EXPECTED_EPK_CHARS /* 122 */:
                        path2.close();
                        path2.moveTo(f22, f23);
                        f18 = f22;
                        f20 = f18;
                        f19 = f23;
                        f21 = f19;
                    default:
                        i10 = 2;
                        break;
                }
                float f24 = f22;
                float f25 = f23;
                float f26 = f18;
                float f27 = f19;
                int i16 = i15;
                while (i16 < fArr3.length) {
                    if (c11 == 'A') {
                        fArr = fArr3;
                        i11 = i16;
                        aVar = aVar3;
                        float f28 = f26;
                        float f29 = f27;
                        i12 = i14;
                        c9 = c11;
                        int i17 = i11 + 5;
                        int i18 = i11 + 6;
                        a(path, f28, f29, fArr[i17], fArr[i18], fArr[i11], fArr[i11 + 1], fArr[i11 + 2], fArr[i11 + 3] != 0.0f ? 1 : i15, fArr[i11 + 4] != 0.0f ? 1 : i15);
                        f20 = fArr[i17];
                        f8 = fArr[i18];
                        f21 = f8;
                        f9 = f20;
                    } else if (c11 == 'C') {
                        fArr = fArr3;
                        i11 = i16;
                        i12 = i14;
                        aVar = aVar3;
                        c9 = c11;
                        int i19 = i11 + 2;
                        int i20 = i11 + 3;
                        int i21 = i11 + 4;
                        int i22 = i11 + 5;
                        path2.cubicTo(fArr[i11], fArr[i11 + 1], fArr[i19], fArr[i20], fArr[i21], fArr[i22]);
                        float f30 = fArr[i21];
                        float f31 = fArr[i22];
                        f20 = fArr[i19];
                        f21 = fArr[i20];
                        f8 = f31;
                        f9 = f30;
                    } else if (c11 == 'H') {
                        fArr = fArr3;
                        i11 = i16;
                        aVar = aVar3;
                        c9 = c11;
                        f8 = f27;
                        i12 = i14;
                        path2.lineTo(fArr[i11], f8);
                        f9 = fArr[i11];
                    } else if (c11 == 'Q') {
                        fArr = fArr3;
                        i11 = i16;
                        i12 = i14;
                        aVar = aVar3;
                        c9 = c11;
                        int i23 = i11 + 1;
                        int i24 = i11 + 2;
                        int i25 = i11 + 3;
                        path2.quadTo(fArr[i11], fArr[i23], fArr[i24], fArr[i25]);
                        float f32 = fArr[i11];
                        float f33 = fArr[i23];
                        float f34 = fArr[i24];
                        float f35 = fArr[i25];
                        f20 = f32;
                        f21 = f33;
                        f9 = f34;
                        f8 = f35;
                    } else if (c11 == 'V') {
                        fArr = fArr3;
                        i11 = i16;
                        i12 = i14;
                        aVar = aVar3;
                        f9 = f26;
                        c9 = c11;
                        path2.lineTo(f9, fArr[i11]);
                        f8 = fArr[i11];
                    } else if (c11 != 'a') {
                        if (c11 == 'c') {
                            fArr = fArr3;
                            i11 = i16;
                            int i26 = i11 + 2;
                            int i27 = i11 + 3;
                            int i28 = i11 + 4;
                            int i29 = i11 + 5;
                            path2.rCubicTo(fArr[i11], fArr[i11 + 1], fArr[i26], fArr[i27], fArr[i28], fArr[i29]);
                            float f36 = fArr[i26] + f26;
                            float f37 = fArr[i27] + f27;
                            f26 += fArr[i28];
                            f27 += fArr[i29];
                            f20 = f36;
                            f21 = f37;
                        } else if (c11 != 'h') {
                            if (c11 != 'q') {
                                if (c11 != 'v') {
                                    if (c11 == 'L') {
                                        fArr = fArr3;
                                        i11 = i16;
                                        int i30 = i11 + 1;
                                        path2.lineTo(fArr[i11], fArr[i30]);
                                        f9 = fArr[i11];
                                        f8 = fArr[i30];
                                    } else if (c11 == 'M') {
                                        fArr = fArr3;
                                        i11 = i16;
                                        f9 = fArr[i11];
                                        f8 = fArr[i11 + 1];
                                        if (i11 > 0) {
                                            path2.lineTo(f9, f8);
                                        } else {
                                            path2.moveTo(f9, f8);
                                            f24 = f9;
                                            f25 = f8;
                                        }
                                    } else if (c11 != 'S') {
                                        if (c11 == 'T') {
                                            fArr = fArr3;
                                            i11 = i16;
                                            if (c10 == 'q' || c10 == 't' || c10 == 'Q' || c10 == 'T') {
                                                f26 = (f26 * 2.0f) - f20;
                                                f27 = (f27 * 2.0f) - f21;
                                            }
                                            int i31 = i11 + 1;
                                            path2.quadTo(f26, f27, fArr[i11], fArr[i31]);
                                            f9 = fArr[i11];
                                            f8 = fArr[i31];
                                            aVar = aVar3;
                                            f20 = f26;
                                            f21 = f27;
                                        } else if (c11 == 'l') {
                                            fArr = fArr3;
                                            i11 = i16;
                                            int i32 = i11 + 1;
                                            path2.rLineTo(fArr[i11], fArr[i32]);
                                            f26 += fArr[i11];
                                            f13 = fArr[i32];
                                        } else if (c11 == 'm') {
                                            fArr = fArr3;
                                            i11 = i16;
                                            float f38 = fArr[i11];
                                            f26 += f38;
                                            float f39 = fArr[i11 + 1];
                                            f27 += f39;
                                            if (i11 > 0) {
                                                path2.rLineTo(f38, f39);
                                            } else {
                                                path2.rMoveTo(f38, f39);
                                                aVar = aVar3;
                                                f9 = f26;
                                                f24 = f9;
                                                f8 = f27;
                                                f25 = f8;
                                            }
                                        } else if (c11 != 's') {
                                            if (c11 != 't') {
                                                fArr = fArr3;
                                                i11 = i16;
                                                aVar = aVar3;
                                                f9 = f26;
                                            } else {
                                                if (c10 == 'q' || c10 == 't' || c10 == 'Q' || c10 == 'T') {
                                                    f16 = f26 - f20;
                                                    f17 = f27 - f21;
                                                } else {
                                                    f17 = 0.0f;
                                                    f16 = 0.0f;
                                                }
                                                int i33 = i16 + 1;
                                                path2.rQuadTo(f16, f17, fArr3[i16], fArr3[i33]);
                                                float f40 = f16 + f26;
                                                float f41 = f17 + f27;
                                                float f42 = f26 + fArr3[i16];
                                                f27 += fArr3[i33];
                                                f21 = f41;
                                                fArr = fArr3;
                                                i11 = i16;
                                                aVar = aVar3;
                                                f9 = f42;
                                                f20 = f40;
                                            }
                                            f8 = f27;
                                        } else {
                                            if (c10 == 'c' || c10 == 's' || c10 == 'C' || c10 == 'S') {
                                                f14 = f27 - f21;
                                                f15 = f26 - f20;
                                            } else {
                                                f15 = 0.0f;
                                                f14 = 0.0f;
                                            }
                                            int i34 = i16;
                                            int i35 = i34 + 1;
                                            int i36 = i34 + 2;
                                            int i37 = i34 + 3;
                                            fArr = fArr3;
                                            i11 = i34;
                                            path2.rCubicTo(f15, f14, fArr3[i34], fArr3[i35], fArr3[i36], fArr3[i37]);
                                            f10 = fArr[i11] + f26;
                                            f11 = fArr[i35] + f27;
                                            f26 += fArr[i36];
                                            f12 = fArr[i37];
                                        }
                                        i12 = i14;
                                        c9 = c11;
                                    } else {
                                        fArr = fArr3;
                                        i11 = i16;
                                        if (c10 == 'c' || c10 == 's' || c10 == 'C' || c10 == 'S') {
                                            f26 = (f26 * 2.0f) - f20;
                                            f27 = (f27 * 2.0f) - f21;
                                        }
                                        float f43 = f26;
                                        float f44 = f27;
                                        int i38 = i11 + 1;
                                        int i39 = i11 + 2;
                                        int i40 = i11 + 3;
                                        path2.cubicTo(f43, f44, fArr[i11], fArr[i38], fArr[i39], fArr[i40]);
                                        f20 = fArr[i11];
                                        f21 = fArr[i38];
                                        f9 = fArr[i39];
                                        f8 = fArr[i40];
                                    }
                                    i12 = i14;
                                    aVar = aVar3;
                                    c9 = c11;
                                } else {
                                    fArr = fArr3;
                                    i11 = i16;
                                    path2.rLineTo(0.0f, fArr[i11]);
                                    f13 = fArr[i11];
                                }
                                f27 += f13;
                            } else {
                                fArr = fArr3;
                                i11 = i16;
                                int i41 = i11 + 1;
                                int i42 = i11 + 2;
                                int i43 = i11 + 3;
                                path2.rQuadTo(fArr[i11], fArr[i41], fArr[i42], fArr[i43]);
                                f10 = fArr[i11] + f26;
                                f11 = fArr[i41] + f27;
                                f26 += fArr[i42];
                                f12 = fArr[i43];
                            }
                            f27 += f12;
                            f20 = f10;
                            f21 = f11;
                        } else {
                            fArr = fArr3;
                            i11 = i16;
                            path2.rLineTo(fArr[i11], 0.0f);
                            f26 += fArr[i11];
                        }
                        aVar = aVar3;
                        f9 = f26;
                        f8 = f27;
                        i12 = i14;
                        c9 = c11;
                    } else {
                        fArr = fArr3;
                        i11 = i16;
                        int i44 = i11 + 5;
                        float f45 = fArr[i44] + f26;
                        int i45 = i11 + 6;
                        float f46 = fArr[i45] + f27;
                        float f47 = fArr[i11];
                        float f48 = fArr[i11 + 1];
                        float f49 = fArr[i11 + 2];
                        if (fArr[i11 + 3] != 0.0f) {
                            aVar2 = aVar3;
                            z = 1;
                        } else {
                            aVar2 = aVar3;
                            z = i15;
                        }
                        aVar = aVar2;
                        float f50 = f26;
                        c9 = c11;
                        float f51 = f27;
                        i12 = i14;
                        a(path, f50, f51, f45, f46, f47, f48, f49, z, fArr[i11 + 4] != 0.0f ? 1 : i15);
                        f9 = f50 + fArr[i44];
                        f8 = f51 + fArr[i45];
                        f20 = f9;
                        f21 = f8;
                    }
                    i16 = i11 + i10;
                    path2 = path;
                    aVar3 = aVar;
                    c11 = c9;
                    i14 = i12;
                    f26 = f9;
                    f27 = f8;
                    c10 = c11;
                    fArr3 = fArr;
                }
                fArr2[i15] = f26;
                fArr2[1] = f27;
                fArr2[2] = f20;
                fArr2[3] = f21;
                fArr2[4] = f24;
                fArr2[5] = f25;
                c10 = aVar3.f10593a;
                i14++;
                aVarArr2 = aVarArr;
                path2 = path;
                i13 = i15;
            }
        }

        public a(a aVar) {
            this.f10593a = aVar.f10593a;
            float[] fArr = aVar.f10594b;
            this.f10594b = d.a(fArr, fArr.length);
        }
    }
}
