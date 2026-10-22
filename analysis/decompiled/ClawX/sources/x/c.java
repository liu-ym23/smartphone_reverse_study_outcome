package x;

import android.graphics.Path;
import android.util.Log;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final char f6235a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f6236b;

    public c(char c3, float[] fArr) {
        this.f6235a = c3;
        this.f6236b = fArr;
    }

    public static void a(Path path, float f3, float f7, float f9, float f10, float f11, float f12, float f13, boolean z, boolean z2) {
        double d;
        double d9;
        double radians = Math.toRadians(f13);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d10 = f3;
        double d11 = f7;
        double d12 = f11;
        double d13 = ((d11 * dSin) + (d10 * dCos)) / d12;
        double d14 = f12;
        double d15 = ((d11 * dCos) + ((-f3) * dSin)) / d14;
        double d16 = f10;
        double d17 = ((d16 * dSin) + (f9 * dCos)) / d12;
        double d18 = ((d16 * dCos) + ((-f9) * dSin)) / d14;
        double d19 = d13 - d17;
        double d20 = d15 - d18;
        double d21 = (d13 + d17) / 2.0d;
        double d22 = (d15 + d18) / 2.0d;
        double d23 = (d20 * d20) + (d19 * d19);
        if (d23 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d24 = (1.0d / d23) - 0.25d;
        if (d24 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d23);
            float fSqrt = (float) (Math.sqrt(d23) / 1.99999d);
            a(path, f3, f7, f9, f10, f11 * fSqrt, fSqrt * f12, f13, z, z2);
            return;
        }
        double dSqrt = Math.sqrt(d24);
        double d25 = dSqrt * d19;
        double d26 = dSqrt * d20;
        if (z == z2) {
            d = d21 - d26;
            d9 = d22 + d25;
        } else {
            d = d21 + d26;
            d9 = d22 - d25;
        }
        double dAtan2 = Math.atan2(d15 - d9, d13 - d);
        double dAtan22 = Math.atan2(d18 - d9, d17 - d) - dAtan2;
        if (z2 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d27 = d * d12;
        double d28 = d9 * d14;
        double d29 = (d27 * dCos) - (d28 * dSin);
        double d30 = (d28 * dCos) + (d27 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d31 = -d12;
        double d32 = d31 * dCos2;
        double d33 = d14 * dSin2;
        double d34 = (d32 * dSin3) - (d33 * dCos3);
        double d35 = d31 * dSin2;
        double d36 = d14 * dCos2;
        double d37 = dAtan22 / iCeil;
        double d38 = (dCos3 * d36) + (dSin3 * d35);
        double d39 = d10;
        double d40 = d11;
        int i8 = 0;
        double d41 = dAtan2;
        while (i8 < iCeil) {
            double d42 = d41 + d37;
            double dSin4 = Math.sin(d42);
            double dCos4 = Math.cos(d42);
            int i9 = iCeil;
            double d43 = (((d12 * dCos2) * dCos4) + d29) - (d33 * dSin4);
            double d44 = (d36 * dSin4) + (d12 * dSin2 * dCos4) + d30;
            double d45 = (d32 * dSin4) - (d33 * dCos4);
            double d46 = (dCos4 * d36) + (dSin4 * d35);
            double d47 = d42 - d41;
            double dTan = Math.tan(d47 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d47)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d34 * dSqrt2) + d39), (float) ((d38 * dSqrt2) + d40), (float) (d43 - (dSqrt2 * d45)), (float) (d44 - (dSqrt2 * d46)), (float) d43, (float) d44);
            i8++;
            d40 = d44;
            dCos2 = dCos2;
            d35 = d35;
            d41 = d42;
            d38 = d46;
            d39 = d43;
            iCeil = i9;
            d34 = d45;
            d37 = d37;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(c[] cVarArr, Path path) {
        int i8;
        float[] fArr;
        int i9;
        c cVar;
        int i10;
        char c3;
        float f3;
        float f7;
        c cVar2;
        boolean z;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        c[] cVarArr2 = cVarArr;
        Path path2 = path;
        float[] fArr2 = new float[6];
        int length = cVarArr2.length;
        int i11 = 0;
        int i12 = 0;
        char c8 = 'm';
        while (i12 < length) {
            c cVar3 = cVarArr2[i12];
            char c9 = cVar3.f6235a;
            float[] fArr3 = cVar3.f6236b;
            float f17 = fArr2[i11];
            float f18 = fArr2[1];
            float f19 = fArr2[2];
            float f20 = fArr2[3];
            float f21 = fArr2[4];
            int i13 = i11;
            float f22 = fArr2[5];
            switch (c9) {
                case 'A':
                case 'a':
                    i8 = 7;
                    break;
                case 'C':
                case 'c':
                    i8 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i8 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i8 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f21, f22);
                    f17 = f21;
                    f19 = f17;
                    f18 = f22;
                    f20 = f18;
                default:
                    i8 = 2;
                    break;
            }
            float f23 = f21;
            float f24 = f22;
            float f25 = f17;
            float f26 = f18;
            int i14 = i13;
            while (i14 < fArr3.length) {
                if (c9 == 'A') {
                    fArr = fArr3;
                    i9 = i14;
                    cVar = cVar3;
                    float f27 = f25;
                    float f28 = f26;
                    i10 = i12;
                    c3 = c9;
                    int i15 = i9 + 5;
                    int i16 = i9 + 6;
                    a(path, f27, f28, fArr[i15], fArr[i16], fArr[i9], fArr[i9 + 1], fArr[i9 + 2], fArr[i9 + 3] != 0.0f ? 1 : i13, fArr[i9 + 4] != 0.0f ? 1 : i13);
                    f19 = fArr[i15];
                    f3 = fArr[i16];
                    f20 = f3;
                    f7 = f19;
                } else if (c9 == 'C') {
                    fArr = fArr3;
                    i9 = i14;
                    i10 = i12;
                    cVar = cVar3;
                    c3 = c9;
                    int i17 = i9 + 2;
                    int i18 = i9 + 3;
                    int i19 = i9 + 4;
                    int i20 = i9 + 5;
                    path2.cubicTo(fArr[i9], fArr[i9 + 1], fArr[i17], fArr[i18], fArr[i19], fArr[i20]);
                    float f29 = fArr[i19];
                    float f30 = fArr[i20];
                    f19 = fArr[i17];
                    f20 = fArr[i18];
                    f3 = f30;
                    f7 = f29;
                } else if (c9 == 'H') {
                    fArr = fArr3;
                    i9 = i14;
                    cVar = cVar3;
                    c3 = c9;
                    f3 = f26;
                    i10 = i12;
                    path2.lineTo(fArr[i9], f3);
                    f7 = fArr[i9];
                } else if (c9 == 'Q') {
                    fArr = fArr3;
                    i9 = i14;
                    i10 = i12;
                    cVar = cVar3;
                    c3 = c9;
                    int i21 = i9 + 1;
                    int i22 = i9 + 2;
                    int i23 = i9 + 3;
                    path2.quadTo(fArr[i9], fArr[i21], fArr[i22], fArr[i23]);
                    float f31 = fArr[i9];
                    float f32 = fArr[i21];
                    float f33 = fArr[i22];
                    float f34 = fArr[i23];
                    f19 = f31;
                    f20 = f32;
                    f7 = f33;
                    f3 = f34;
                } else if (c9 == 'V') {
                    fArr = fArr3;
                    i9 = i14;
                    i10 = i12;
                    cVar = cVar3;
                    f7 = f25;
                    c3 = c9;
                    path2.lineTo(f7, fArr[i9]);
                    f3 = fArr[i9];
                } else if (c9 != 'a') {
                    if (c9 == 'c') {
                        fArr = fArr3;
                        i9 = i14;
                        int i24 = i9 + 2;
                        int i25 = i9 + 3;
                        int i26 = i9 + 4;
                        int i27 = i9 + 5;
                        path2.rCubicTo(fArr[i9], fArr[i9 + 1], fArr[i24], fArr[i25], fArr[i26], fArr[i27]);
                        float f35 = fArr[i24] + f25;
                        float f36 = fArr[i25] + f26;
                        f25 += fArr[i26];
                        f26 += fArr[i27];
                        f19 = f35;
                        f20 = f36;
                    } else if (c9 != 'h') {
                        if (c9 != 'q') {
                            if (c9 != 'v') {
                                if (c9 == 'L') {
                                    fArr = fArr3;
                                    i9 = i14;
                                    int i28 = i9 + 1;
                                    path2.lineTo(fArr[i9], fArr[i28]);
                                    f7 = fArr[i9];
                                    f3 = fArr[i28];
                                } else if (c9 == 'M') {
                                    fArr = fArr3;
                                    i9 = i14;
                                    f7 = fArr[i9];
                                    f3 = fArr[i9 + 1];
                                    if (i9 > 0) {
                                        path2.lineTo(f7, f3);
                                    } else {
                                        path2.moveTo(f7, f3);
                                        f23 = f7;
                                        f24 = f3;
                                    }
                                } else if (c9 != 'S') {
                                    if (c9 == 'T') {
                                        fArr = fArr3;
                                        i9 = i14;
                                        if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                            f25 = (f25 * 2.0f) - f19;
                                            f26 = (f26 * 2.0f) - f20;
                                        }
                                        int i29 = i9 + 1;
                                        path2.quadTo(f25, f26, fArr[i9], fArr[i29]);
                                        f7 = fArr[i9];
                                        f3 = fArr[i29];
                                        cVar = cVar3;
                                        f19 = f25;
                                        f20 = f26;
                                    } else if (c9 == 'l') {
                                        fArr = fArr3;
                                        i9 = i14;
                                        int i30 = i9 + 1;
                                        path2.rLineTo(fArr[i9], fArr[i30]);
                                        f25 += fArr[i9];
                                        f12 = fArr[i30];
                                    } else if (c9 == 'm') {
                                        fArr = fArr3;
                                        i9 = i14;
                                        float f37 = fArr[i9];
                                        f25 += f37;
                                        float f38 = fArr[i9 + 1];
                                        f26 += f38;
                                        if (i9 > 0) {
                                            path2.rLineTo(f37, f38);
                                        } else {
                                            path2.rMoveTo(f37, f38);
                                            cVar = cVar3;
                                            f7 = f25;
                                            f23 = f7;
                                            f3 = f26;
                                            f24 = f3;
                                        }
                                    } else if (c9 != 's') {
                                        if (c9 != 't') {
                                            fArr = fArr3;
                                            i9 = i14;
                                            cVar = cVar3;
                                            f7 = f25;
                                        } else {
                                            if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                f15 = f25 - f19;
                                                f16 = f26 - f20;
                                            } else {
                                                f16 = 0.0f;
                                                f15 = 0.0f;
                                            }
                                            int i31 = i14 + 1;
                                            path2.rQuadTo(f15, f16, fArr3[i14], fArr3[i31]);
                                            float f39 = f15 + f25;
                                            float f40 = f16 + f26;
                                            float f41 = f25 + fArr3[i14];
                                            f26 += fArr3[i31];
                                            f20 = f40;
                                            fArr = fArr3;
                                            i9 = i14;
                                            cVar = cVar3;
                                            f7 = f41;
                                            f19 = f39;
                                        }
                                        f3 = f26;
                                    } else {
                                        if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                            f13 = f26 - f20;
                                            f14 = f25 - f19;
                                        } else {
                                            f14 = 0.0f;
                                            f13 = 0.0f;
                                        }
                                        int i32 = i14;
                                        int i33 = i32 + 1;
                                        int i34 = i32 + 2;
                                        int i35 = i32 + 3;
                                        fArr = fArr3;
                                        i9 = i32;
                                        path2.rCubicTo(f14, f13, fArr3[i32], fArr3[i33], fArr3[i34], fArr3[i35]);
                                        f9 = fArr[i9] + f25;
                                        f10 = fArr[i33] + f26;
                                        f25 += fArr[i34];
                                        f11 = fArr[i35];
                                    }
                                    i10 = i12;
                                    c3 = c9;
                                } else {
                                    fArr = fArr3;
                                    i9 = i14;
                                    if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                        f25 = (f25 * 2.0f) - f19;
                                        f26 = (f26 * 2.0f) - f20;
                                    }
                                    float f42 = f25;
                                    float f43 = f26;
                                    int i36 = i9 + 1;
                                    int i37 = i9 + 2;
                                    int i38 = i9 + 3;
                                    path2.cubicTo(f42, f43, fArr[i9], fArr[i36], fArr[i37], fArr[i38]);
                                    f19 = fArr[i9];
                                    f20 = fArr[i36];
                                    f7 = fArr[i37];
                                    f3 = fArr[i38];
                                }
                                i10 = i12;
                                cVar = cVar3;
                                c3 = c9;
                            } else {
                                fArr = fArr3;
                                i9 = i14;
                                path2.rLineTo(0.0f, fArr[i9]);
                                f12 = fArr[i9];
                            }
                            f26 += f12;
                        } else {
                            fArr = fArr3;
                            i9 = i14;
                            int i39 = i9 + 1;
                            int i40 = i9 + 2;
                            int i41 = i9 + 3;
                            path2.rQuadTo(fArr[i9], fArr[i39], fArr[i40], fArr[i41]);
                            f9 = fArr[i9] + f25;
                            f10 = fArr[i39] + f26;
                            f25 += fArr[i40];
                            f11 = fArr[i41];
                        }
                        f26 += f11;
                        f19 = f9;
                        f20 = f10;
                    } else {
                        fArr = fArr3;
                        i9 = i14;
                        path2.rLineTo(fArr[i9], 0.0f);
                        f25 += fArr[i9];
                    }
                    cVar = cVar3;
                    f7 = f25;
                    f3 = f26;
                    i10 = i12;
                    c3 = c9;
                } else {
                    fArr = fArr3;
                    i9 = i14;
                    int i42 = i9 + 5;
                    float f44 = fArr[i42] + f25;
                    int i43 = i9 + 6;
                    float f45 = fArr[i43] + f26;
                    float f46 = fArr[i9];
                    float f47 = fArr[i9 + 1];
                    float f48 = fArr[i9 + 2];
                    if (fArr[i9 + 3] != 0.0f) {
                        cVar2 = cVar3;
                        z = 1;
                    } else {
                        cVar2 = cVar3;
                        z = i13;
                    }
                    cVar = cVar2;
                    float f49 = f25;
                    c3 = c9;
                    float f50 = f26;
                    i10 = i12;
                    a(path, f49, f50, f44, f45, f46, f47, f48, z, fArr[i9 + 4] != 0.0f ? 1 : i13);
                    f7 = f49 + fArr[i42];
                    f3 = f50 + fArr[i43];
                    f19 = f7;
                    f20 = f3;
                }
                i14 = i9 + i8;
                path2 = path;
                cVar3 = cVar;
                c9 = c3;
                i12 = i10;
                f25 = f7;
                f26 = f3;
                c8 = c9;
                fArr3 = fArr;
            }
            fArr2[i13] = f25;
            fArr2[1] = f26;
            fArr2[2] = f19;
            fArr2[3] = f20;
            fArr2[4] = f23;
            fArr2[5] = f24;
            c8 = cVar3.f6235a;
            i12++;
            cVarArr2 = cVarArr;
            path2 = path;
            i11 = i13;
        }
    }
}
