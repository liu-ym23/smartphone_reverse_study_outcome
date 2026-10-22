package f3;

import android.graphics.Path;
import android.util.Log;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public char f3904a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f3905b;

    public static void a(Path path, float f5, float f10, float f11, float f12, float f13, float f14, float f15, boolean z10, boolean z11) {
        double d7;
        double d10;
        double radians = Math.toRadians(f15);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d11 = f5;
        double d12 = f10;
        double d13 = f13;
        double d14 = ((d12 * dSin) + (d11 * dCos)) / d13;
        double d15 = f14;
        double d16 = ((d12 * dCos) + ((-f5) * dSin)) / d15;
        double d17 = f12;
        double d18 = ((d17 * dSin) + (f11 * dCos)) / d13;
        double d19 = ((d17 * dCos) + ((-f11) * dSin)) / d15;
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
            a(path, f5, f10, f11, f12, f13 * fSqrt, fSqrt * f14, f15, z10, z11);
            return;
        }
        double dSqrt = Math.sqrt(d25);
        double d26 = dSqrt * d20;
        double d27 = dSqrt * d21;
        if (z10 == z11) {
            d7 = d22 - d27;
            d10 = d23 + d26;
        } else {
            d7 = d22 + d27;
            d10 = d23 - d26;
        }
        double dAtan2 = Math.atan2(d16 - d10, d14 - d7);
        double dAtan22 = Math.atan2(d19 - d10, d18 - d7) - dAtan2;
        if (z11 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d28 = d7 * d13;
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
        int i = 0;
        double d42 = dAtan2;
        while (i < iCeil) {
            double d43 = d42 + d38;
            double dSin4 = Math.sin(d43);
            double dCos4 = Math.cos(d43);
            int i3 = iCeil;
            double d44 = (((d13 * dCos2) * dCos4) + d30) - (d34 * dSin4);
            double d45 = (d37 * dSin4) + (d13 * dSin2 * dCos4) + d31;
            double d46 = (d33 * dSin4) - (d34 * dCos4);
            double d47 = (dCos4 * d37) + (dSin4 * d36);
            double d48 = d43 - d42;
            double dTan = Math.tan(d48 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d48)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d35 * dSqrt2) + d40), (float) ((d39 * dSqrt2) + d41), (float) (d44 - (dSqrt2 * d46)), (float) (d45 - (dSqrt2 * d47)), (float) d44, (float) d45);
            i++;
            d41 = d45;
            dCos2 = dCos2;
            d36 = d36;
            d42 = d43;
            d39 = d47;
            d40 = d44;
            iCeil = i3;
            d35 = d46;
            d38 = d38;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(c[] cVarArr, Path path) {
        int i;
        float[] fArr;
        int i3;
        c cVar;
        int i10;
        char c9;
        float f5;
        float f10;
        c cVar2;
        boolean z10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        c[] cVarArr2 = cVarArr;
        Path path2 = path;
        float[] fArr2 = new float[6];
        int length = cVarArr2.length;
        int i11 = 0;
        int i12 = 0;
        char c10 = 'm';
        while (i12 < length) {
            c cVar3 = cVarArr2[i12];
            char c11 = cVar3.f3904a;
            float[] fArr3 = cVar3.f3905b;
            float f19 = fArr2[i11];
            float f20 = fArr2[1];
            float f21 = fArr2[2];
            float f22 = fArr2[3];
            float f23 = fArr2[4];
            int i13 = i11;
            float f24 = fArr2[5];
            switch (c11) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f23, f24);
                    f19 = f23;
                    f21 = f19;
                    f20 = f24;
                    f22 = f20;
                default:
                    i = 2;
                    break;
            }
            float f25 = f23;
            float f26 = f24;
            float f27 = f19;
            float f28 = f20;
            int i14 = i13;
            while (i14 < fArr3.length) {
                if (c11 == 'A') {
                    fArr = fArr3;
                    i3 = i14;
                    cVar = cVar3;
                    float f29 = f27;
                    float f30 = f28;
                    i10 = i12;
                    c9 = c11;
                    int i15 = i3 + 5;
                    int i16 = i3 + 6;
                    a(path, f29, f30, fArr[i15], fArr[i16], fArr[i3], fArr[i3 + 1], fArr[i3 + 2], fArr[i3 + 3] != 0.0f ? 1 : i13, fArr[i3 + 4] != 0.0f ? 1 : i13);
                    f21 = fArr[i15];
                    f5 = fArr[i16];
                    f22 = f5;
                    f10 = f21;
                } else if (c11 == 'C') {
                    fArr = fArr3;
                    i3 = i14;
                    i10 = i12;
                    cVar = cVar3;
                    c9 = c11;
                    int i17 = i3 + 2;
                    int i18 = i3 + 3;
                    int i19 = i3 + 4;
                    int i20 = i3 + 5;
                    path2.cubicTo(fArr[i3], fArr[i3 + 1], fArr[i17], fArr[i18], fArr[i19], fArr[i20]);
                    float f31 = fArr[i19];
                    float f32 = fArr[i20];
                    f21 = fArr[i17];
                    f22 = fArr[i18];
                    f5 = f32;
                    f10 = f31;
                } else if (c11 == 'H') {
                    fArr = fArr3;
                    i3 = i14;
                    cVar = cVar3;
                    c9 = c11;
                    f5 = f28;
                    i10 = i12;
                    path2.lineTo(fArr[i3], f5);
                    f10 = fArr[i3];
                } else if (c11 == 'Q') {
                    fArr = fArr3;
                    i3 = i14;
                    i10 = i12;
                    cVar = cVar3;
                    c9 = c11;
                    int i21 = i3 + 1;
                    int i22 = i3 + 2;
                    int i23 = i3 + 3;
                    path2.quadTo(fArr[i3], fArr[i21], fArr[i22], fArr[i23]);
                    float f33 = fArr[i3];
                    float f34 = fArr[i21];
                    float f35 = fArr[i22];
                    float f36 = fArr[i23];
                    f21 = f33;
                    f22 = f34;
                    f10 = f35;
                    f5 = f36;
                } else if (c11 == 'V') {
                    fArr = fArr3;
                    i3 = i14;
                    i10 = i12;
                    cVar = cVar3;
                    f10 = f27;
                    c9 = c11;
                    path2.lineTo(f10, fArr[i3]);
                    f5 = fArr[i3];
                } else if (c11 != 'a') {
                    if (c11 == 'c') {
                        fArr = fArr3;
                        i3 = i14;
                        int i24 = i3 + 2;
                        int i25 = i3 + 3;
                        int i26 = i3 + 4;
                        int i27 = i3 + 5;
                        path2.rCubicTo(fArr[i3], fArr[i3 + 1], fArr[i24], fArr[i25], fArr[i26], fArr[i27]);
                        float f37 = fArr[i24] + f27;
                        float f38 = fArr[i25] + f28;
                        f27 += fArr[i26];
                        f28 += fArr[i27];
                        f21 = f37;
                        f22 = f38;
                    } else if (c11 != 'h') {
                        if (c11 != 'q') {
                            if (c11 != 'v') {
                                if (c11 == 'L') {
                                    fArr = fArr3;
                                    i3 = i14;
                                    int i28 = i3 + 1;
                                    path2.lineTo(fArr[i3], fArr[i28]);
                                    f10 = fArr[i3];
                                    f5 = fArr[i28];
                                } else if (c11 == 'M') {
                                    fArr = fArr3;
                                    i3 = i14;
                                    f10 = fArr[i3];
                                    f5 = fArr[i3 + 1];
                                    if (i3 > 0) {
                                        path2.lineTo(f10, f5);
                                    } else {
                                        path2.moveTo(f10, f5);
                                        f25 = f10;
                                        f26 = f5;
                                    }
                                } else if (c11 != 'S') {
                                    if (c11 == 'T') {
                                        fArr = fArr3;
                                        i3 = i14;
                                        if (c10 == 'q' || c10 == 't' || c10 == 'Q' || c10 == 'T') {
                                            f27 = (f27 * 2.0f) - f21;
                                            f28 = (f28 * 2.0f) - f22;
                                        }
                                        int i29 = i3 + 1;
                                        path2.quadTo(f27, f28, fArr[i3], fArr[i29]);
                                        f10 = fArr[i3];
                                        f5 = fArr[i29];
                                        cVar = cVar3;
                                        f21 = f27;
                                        f22 = f28;
                                    } else if (c11 == 'l') {
                                        fArr = fArr3;
                                        i3 = i14;
                                        int i30 = i3 + 1;
                                        path2.rLineTo(fArr[i3], fArr[i30]);
                                        f27 += fArr[i3];
                                        f14 = fArr[i30];
                                    } else if (c11 == 'm') {
                                        fArr = fArr3;
                                        i3 = i14;
                                        float f39 = fArr[i3];
                                        f27 += f39;
                                        float f40 = fArr[i3 + 1];
                                        f28 += f40;
                                        if (i3 > 0) {
                                            path2.rLineTo(f39, f40);
                                        } else {
                                            path2.rMoveTo(f39, f40);
                                            cVar = cVar3;
                                            f10 = f27;
                                            f25 = f10;
                                            f5 = f28;
                                            f26 = f5;
                                        }
                                    } else if (c11 != 's') {
                                        if (c11 != 't') {
                                            fArr = fArr3;
                                            i3 = i14;
                                            cVar = cVar3;
                                            f10 = f27;
                                        } else {
                                            if (c10 == 'q' || c10 == 't' || c10 == 'Q' || c10 == 'T') {
                                                f17 = f27 - f21;
                                                f18 = f28 - f22;
                                            } else {
                                                f18 = 0.0f;
                                                f17 = 0.0f;
                                            }
                                            int i31 = i14 + 1;
                                            path2.rQuadTo(f17, f18, fArr3[i14], fArr3[i31]);
                                            float f41 = f17 + f27;
                                            float f42 = f18 + f28;
                                            float f43 = f27 + fArr3[i14];
                                            f28 += fArr3[i31];
                                            f22 = f42;
                                            fArr = fArr3;
                                            i3 = i14;
                                            cVar = cVar3;
                                            f10 = f43;
                                            f21 = f41;
                                        }
                                        f5 = f28;
                                    } else {
                                        if (c10 == 'c' || c10 == 's' || c10 == 'C' || c10 == 'S') {
                                            f15 = f28 - f22;
                                            f16 = f27 - f21;
                                        } else {
                                            f16 = 0.0f;
                                            f15 = 0.0f;
                                        }
                                        int i32 = i14;
                                        int i33 = i32 + 1;
                                        int i34 = i32 + 2;
                                        int i35 = i32 + 3;
                                        fArr = fArr3;
                                        i3 = i32;
                                        path2.rCubicTo(f16, f15, fArr3[i32], fArr3[i33], fArr3[i34], fArr3[i35]);
                                        f11 = fArr[i3] + f27;
                                        f12 = fArr[i33] + f28;
                                        f27 += fArr[i34];
                                        f13 = fArr[i35];
                                    }
                                    i10 = i12;
                                    c9 = c11;
                                } else {
                                    fArr = fArr3;
                                    i3 = i14;
                                    if (c10 == 'c' || c10 == 's' || c10 == 'C' || c10 == 'S') {
                                        f27 = (f27 * 2.0f) - f21;
                                        f28 = (f28 * 2.0f) - f22;
                                    }
                                    float f44 = f27;
                                    float f45 = f28;
                                    int i36 = i3 + 1;
                                    int i37 = i3 + 2;
                                    int i38 = i3 + 3;
                                    path2.cubicTo(f44, f45, fArr[i3], fArr[i36], fArr[i37], fArr[i38]);
                                    f21 = fArr[i3];
                                    f22 = fArr[i36];
                                    f10 = fArr[i37];
                                    f5 = fArr[i38];
                                }
                                i10 = i12;
                                cVar = cVar3;
                                c9 = c11;
                            } else {
                                fArr = fArr3;
                                i3 = i14;
                                path2.rLineTo(0.0f, fArr[i3]);
                                f14 = fArr[i3];
                            }
                            f28 += f14;
                        } else {
                            fArr = fArr3;
                            i3 = i14;
                            int i39 = i3 + 1;
                            int i40 = i3 + 2;
                            int i41 = i3 + 3;
                            path2.rQuadTo(fArr[i3], fArr[i39], fArr[i40], fArr[i41]);
                            f11 = fArr[i3] + f27;
                            f12 = fArr[i39] + f28;
                            f27 += fArr[i40];
                            f13 = fArr[i41];
                        }
                        f28 += f13;
                        f21 = f11;
                        f22 = f12;
                    } else {
                        fArr = fArr3;
                        i3 = i14;
                        path2.rLineTo(fArr[i3], 0.0f);
                        f27 += fArr[i3];
                    }
                    cVar = cVar3;
                    f10 = f27;
                    f5 = f28;
                    i10 = i12;
                    c9 = c11;
                } else {
                    fArr = fArr3;
                    i3 = i14;
                    int i42 = i3 + 5;
                    float f46 = fArr[i42] + f27;
                    int i43 = i3 + 6;
                    float f47 = fArr[i43] + f28;
                    float f48 = fArr[i3];
                    float f49 = fArr[i3 + 1];
                    float f50 = fArr[i3 + 2];
                    if (fArr[i3 + 3] != 0.0f) {
                        cVar2 = cVar3;
                        z10 = 1;
                    } else {
                        cVar2 = cVar3;
                        z10 = i13;
                    }
                    cVar = cVar2;
                    float f51 = f27;
                    c9 = c11;
                    float f52 = f28;
                    i10 = i12;
                    a(path, f51, f52, f46, f47, f48, f49, f50, z10, fArr[i3 + 4] != 0.0f ? 1 : i13);
                    f10 = f51 + fArr[i42];
                    f5 = f52 + fArr[i43];
                    f21 = f10;
                    f22 = f5;
                }
                i14 = i3 + i;
                path2 = path;
                cVar3 = cVar;
                c11 = c9;
                i12 = i10;
                f27 = f10;
                f28 = f5;
                c10 = c11;
                fArr3 = fArr;
            }
            fArr2[i13] = f27;
            fArr2[1] = f28;
            fArr2[2] = f21;
            fArr2[3] = f22;
            fArr2[4] = f25;
            fArr2[5] = f26;
            c10 = cVar3.f3904a;
            i12++;
            cVarArr2 = cVarArr;
            path2 = path;
            i11 = i13;
        }
    }
}
