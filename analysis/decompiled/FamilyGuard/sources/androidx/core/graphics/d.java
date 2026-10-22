package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import com.stepos.digitalwellbeing.server.net.category.CategoryEntity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d {

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        int f9647a;

        /* renamed from: b, reason: collision with root package name */
        boolean f9648b;

        a() {
        }
    }

    private static void a(ArrayList<b> arrayList, char c6, float[] fArr) {
        arrayList.add(new b(c6, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < bVarArr.length; i5++) {
            if (bVarArr[i5].f9649a != bVarArr2[i5].f9649a || bVarArr[i5].f9650b.length != bVarArr2[i5].f9650b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i5, int i6) {
        if (i5 > i6) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i5 < 0 || i5 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i7 = i6 - i5;
        int iMin = Math.min(i7, length - i5);
        float[] fArr2 = new float[i7];
        System.arraycopy(fArr, i5, fArr2, 0, iMin);
        return fArr2;
    }

    public static b[] d(String str) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 1;
        while (i6 < str.length()) {
            int i7 = i(str, i6);
            String strTrim = str.substring(i5, i7).trim();
            if (!strTrim.isEmpty()) {
                a(arrayList, strTrim.charAt(0), h(strTrim));
            }
            i5 = i7;
            i6 = i7 + 1;
        }
        if (i6 - i5 == 1 && i5 < str.length()) {
            a(arrayList, str.charAt(i5), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[0]);
    }

    public static Path e(String str) {
        Path path = new Path();
        try {
            b.h(d(str), path);
            return path;
        } catch (RuntimeException e6) {
            throw new RuntimeException("Error in parsing " + str, e6);
        }
    }

    public static b[] f(b[] bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i5 = 0; i5 < bVarArr.length; i5++) {
            bVarArr2[i5] = new b(bVarArr[i5]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void g(java.lang.String r8, int r9, androidx.core.graphics.d.a r10) {
        /*
            r0 = 0
            r10.f9648b = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L36
        L27:
            r10.f9648b = r7
        L29:
            r2 = r0
            r4 = r7
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.f9648b = r7
            goto L29
        L33:
            r2 = r0
            goto L36
        L35:
            r2 = r7
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.f9647a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.d.g(java.lang.String, int, androidx.core.graphics.d$a):void");
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i5 = 1;
            int i6 = 0;
            while (i5 < length) {
                g(str, i5, aVar);
                int i7 = aVar.f9647a;
                if (i5 < i7) {
                    fArr[i6] = Float.parseFloat(str.substring(i5, i7));
                    i6++;
                }
                i5 = aVar.f9648b ? i7 : i7 + 1;
            }
            return c(fArr, 0, i6);
        } catch (NumberFormatException e6) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e6);
        }
    }

    private static int i(String str, int i5) {
        while (i5 < str.length()) {
            char cCharAt = str.charAt(i5);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i5++;
        }
        return i5;
    }

    public static void j(b[] bVarArr, Path path) {
        float[] fArr = new float[6];
        char c6 = 'm';
        for (b bVar : bVarArr) {
            b.e(path, fArr, c6, bVar.f9649a, bVar.f9650b);
            c6 = bVar.f9649a;
        }
    }

    public static void k(b[] bVarArr, b[] bVarArr2) {
        for (int i5 = 0; i5 < bVarArr2.length; i5++) {
            bVarArr[i5].f9649a = bVarArr2[i5].f9649a;
            for (int i6 = 0; i6 < bVarArr2[i5].f9650b.length; i6++) {
                bVarArr[i5].f9650b[i6] = bVarArr2[i5].f9650b[i6];
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private char f9649a;

        /* renamed from: b, reason: collision with root package name */
        private final float[] f9650b;

        b(char c6, float[] fArr) {
            this.f9649a = c6;
            this.f9650b = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void e(Path path, float[] fArr, char c6, char c7, float[] fArr2) {
            int i5;
            int i6;
            boolean z5;
            boolean z6;
            char c8;
            char c9;
            int i7;
            float f5;
            boolean z7;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            boolean z8;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float f20;
            Path path2 = path;
            boolean z9 = false;
            float f21 = fArr[0];
            boolean z10 = true;
            float f22 = fArr[1];
            char c10 = 2;
            float f23 = fArr[2];
            char c11 = 3;
            float f24 = fArr[3];
            float f25 = fArr[4];
            float f26 = fArr[5];
            switch (c7) {
                case 'A':
                case 'a':
                    i5 = 7;
                    i6 = i5;
                    break;
                case 'C':
                case 'c':
                    i5 = 6;
                    i6 = i5;
                    break;
                case 'H':
                case 'V':
                case CategoryEntity.LIFE /* 104 */:
                case 'v':
                    i6 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i6 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i6 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f25, f26);
                    f21 = f25;
                    f23 = f21;
                    f22 = f26;
                    f24 = f22;
                    i6 = 2;
                    break;
            }
            float f27 = f21;
            float f28 = f22;
            float f29 = f25;
            float f30 = f26;
            int i8 = 0;
            char c12 = c6;
            while (i8 < fArr2.length) {
                if (c7 == 'A') {
                    float f31 = f27;
                    float f32 = f28;
                    z5 = z9;
                    z6 = z10;
                    c8 = c10;
                    c9 = c11;
                    i7 = i8;
                    int i9 = i7 + 5;
                    float f33 = fArr2[i9];
                    int i10 = i7 + 6;
                    float f34 = fArr2[i10];
                    float f35 = fArr2[i7];
                    float f36 = fArr2[i7 + 1];
                    float f37 = fArr2[i7 + 2];
                    if (fArr2[i7 + 3] != 0.0f) {
                        f5 = 0.0f;
                        z7 = z6;
                    } else {
                        f5 = 0.0f;
                        z7 = z5;
                    }
                    g(path, f31, f32, f33, f34, f35, f36, f37, z7, fArr2[i7 + 4] != f5 ? z6 : z5);
                    f23 = fArr2[i9];
                    f27 = f23;
                    f24 = fArr2[i10];
                    f28 = f24;
                } else if (c7 == 'C') {
                    z5 = z9;
                    z6 = z10;
                    c8 = c10;
                    c9 = c11;
                    i7 = i8;
                    int i11 = i7 + 2;
                    int i12 = i7 + 3;
                    int i13 = i7 + 4;
                    int i14 = i7 + 5;
                    path2.cubicTo(fArr2[i7], fArr2[i7 + 1], fArr2[i11], fArr2[i12], fArr2[i13], fArr2[i14]);
                    float f38 = fArr2[i13];
                    float f39 = fArr2[i14];
                    float f40 = fArr2[i11];
                    float f41 = fArr2[i12];
                    f27 = f38;
                    f28 = f39;
                    f24 = f41;
                    f23 = f40;
                } else if (c7 != 'H') {
                    if (c7 != 'Q') {
                        z5 = z9;
                        if (c7 == 'V') {
                            z6 = z10;
                            c8 = c10;
                            c9 = c11;
                            i7 = i8;
                            path2.lineTo(f27, fArr2[i7]);
                            f8 = fArr2[i7];
                        } else if (c7 != 'a') {
                            if (c7 != 'c') {
                                z6 = z10;
                                if (c7 != 'h') {
                                    if (c7 != 'q') {
                                        c8 = c10;
                                        if (c7 != 'v') {
                                            if (c7 != 'L') {
                                                if (c7 != 'M') {
                                                    c9 = c11;
                                                    if (c7 == 'S') {
                                                        if (c12 == 'c' || c12 == 's' || c12 == 'C' || c12 == 'S') {
                                                            f27 = (f27 * 2.0f) - f23;
                                                            f28 = (f28 * 2.0f) - f24;
                                                        }
                                                        float f42 = f27;
                                                        float f43 = f28;
                                                        int i15 = i8 + 1;
                                                        int i16 = i8 + 2;
                                                        int i17 = i8 + 3;
                                                        path2.cubicTo(f42, f43, fArr2[i8], fArr2[i15], fArr2[i16], fArr2[i17]);
                                                        f6 = fArr2[i8];
                                                        f7 = fArr2[i15];
                                                        f27 = fArr2[i16];
                                                        f28 = fArr2[i17];
                                                        i7 = i8;
                                                    } else if (c7 == 'T') {
                                                        if (c12 == 'q' || c12 == 't' || c12 == 'Q' || c12 == 'T') {
                                                            f27 = (f27 * 2.0f) - f23;
                                                            f28 = (f28 * 2.0f) - f24;
                                                        }
                                                        int i18 = i8 + 1;
                                                        path2.quadTo(f27, f28, fArr2[i8], fArr2[i18]);
                                                        float f44 = fArr2[i8];
                                                        f8 = fArr2[i18];
                                                        f23 = f27;
                                                        f24 = f28;
                                                        i7 = i8;
                                                        f27 = f44;
                                                    } else if (c7 == 'l') {
                                                        int i19 = i8 + 1;
                                                        path2.rLineTo(fArr2[i8], fArr2[i19]);
                                                        f27 += fArr2[i8];
                                                        f14 = fArr2[i19];
                                                    } else if (c7 == 'm') {
                                                        float f45 = fArr2[i8];
                                                        f27 += f45;
                                                        float f46 = fArr2[i8 + 1];
                                                        f28 += f46;
                                                        if (i8 > 0) {
                                                            path2.rLineTo(f45, f46);
                                                        } else {
                                                            path2.rMoveTo(f45, f46);
                                                            f29 = f27;
                                                        }
                                                    } else if (c7 == 's') {
                                                        if (c12 == 'c' || c12 == 's' || c12 == 'C' || c12 == 'S') {
                                                            f17 = f28 - f24;
                                                            f18 = f27 - f23;
                                                        } else {
                                                            f18 = 0.0f;
                                                            f17 = 0.0f;
                                                        }
                                                        int i20 = i8 + 1;
                                                        int i21 = i8 + 2;
                                                        int i22 = i8 + 3;
                                                        path2.rCubicTo(f18, f17, fArr2[i8], fArr2[i20], fArr2[i21], fArr2[i22]);
                                                        f11 = fArr2[i8] + f27;
                                                        f12 = fArr2[i20] + f28;
                                                        f27 += fArr2[i21];
                                                        f13 = fArr2[i22];
                                                    } else if (c7 == 't') {
                                                        if (c12 == 'q' || c12 == 't' || c12 == 'Q' || c12 == 'T') {
                                                            f19 = f27 - f23;
                                                            f20 = f28 - f24;
                                                        } else {
                                                            f20 = 0.0f;
                                                            f19 = 0.0f;
                                                        }
                                                        int i23 = i8 + 1;
                                                        path2.rQuadTo(f19, f20, fArr2[i8], fArr2[i23]);
                                                        float f47 = f19 + f27;
                                                        float f48 = f20 + f28;
                                                        f27 += fArr2[i8];
                                                        f28 += fArr2[i23];
                                                        f24 = f48;
                                                        f23 = f47;
                                                    }
                                                } else {
                                                    c9 = c11;
                                                    f15 = fArr2[i8];
                                                    f16 = fArr2[i8 + 1];
                                                    if (i8 > 0) {
                                                        path2.lineTo(f15, f16);
                                                    } else {
                                                        path2.moveTo(f15, f16);
                                                        f27 = f15;
                                                        f29 = f27;
                                                        f28 = f16;
                                                    }
                                                }
                                                f30 = f28;
                                            } else {
                                                c9 = c11;
                                                int i24 = i8 + 1;
                                                path2.lineTo(fArr2[i8], fArr2[i24]);
                                                f15 = fArr2[i8];
                                                f16 = fArr2[i24];
                                            }
                                            f27 = f15;
                                            f28 = f16;
                                        } else {
                                            c9 = c11;
                                            path2.rLineTo(0.0f, fArr2[i8]);
                                            f14 = fArr2[i8];
                                        }
                                        f28 += f14;
                                    } else {
                                        c8 = c10;
                                        c9 = c11;
                                        int i25 = i8 + 1;
                                        int i26 = i8 + 2;
                                        int i27 = i8 + 3;
                                        path2.rQuadTo(fArr2[i8], fArr2[i25], fArr2[i26], fArr2[i27]);
                                        f11 = fArr2[i8] + f27;
                                        f12 = fArr2[i25] + f28;
                                        f27 += fArr2[i26];
                                        f13 = fArr2[i27];
                                    }
                                    f28 += f13;
                                    f23 = f11;
                                    f24 = f12;
                                } else {
                                    c8 = c10;
                                    c9 = c11;
                                    path2.rLineTo(fArr2[i8], 0.0f);
                                    f27 += fArr2[i8];
                                }
                            } else {
                                z6 = z10;
                                c8 = c10;
                                c9 = c11;
                                int i28 = i8 + 2;
                                int i29 = i8 + 3;
                                int i30 = i8 + 4;
                                int i31 = i8 + 5;
                                path2.rCubicTo(fArr2[i8], fArr2[i8 + 1], fArr2[i28], fArr2[i29], fArr2[i30], fArr2[i31]);
                                float f49 = fArr2[i28] + f27;
                                float f50 = fArr2[i29] + f28;
                                f27 += fArr2[i30];
                                f28 += fArr2[i31];
                                f23 = f49;
                                f24 = f50;
                            }
                            i7 = i8;
                        } else {
                            z6 = z10;
                            c8 = c10;
                            c9 = c11;
                            int i32 = i8 + 5;
                            float f51 = fArr2[i32] + f27;
                            int i33 = i8 + 6;
                            float f52 = fArr2[i33] + f28;
                            float f53 = fArr2[i8];
                            float f54 = fArr2[i8 + 1];
                            float f55 = fArr2[i8 + 2];
                            if (fArr2[i8 + 3] != 0.0f) {
                                f9 = 0.0f;
                                f10 = f28;
                                z8 = z6;
                            } else {
                                f9 = 0.0f;
                                f10 = f28;
                                z8 = z5;
                            }
                            i7 = i8;
                            boolean z11 = fArr2[i8 + 4] != f9 ? z6 : z5;
                            float f56 = f27;
                            g(path, f56, f10, f51, f52, f53, f54, f55, z8, z11);
                            f27 = f56 + fArr2[i32];
                            f28 = f10 + fArr2[i33];
                            f23 = f27;
                            f24 = f28;
                        }
                        f28 = f8;
                    } else {
                        z5 = z9;
                        z6 = z10;
                        c8 = c10;
                        c9 = c11;
                        i7 = i8;
                        int i34 = i7 + 1;
                        int i35 = i7 + 2;
                        int i36 = i7 + 3;
                        path2.quadTo(fArr2[i7], fArr2[i34], fArr2[i35], fArr2[i36]);
                        f6 = fArr2[i7];
                        f7 = fArr2[i34];
                        f27 = fArr2[i35];
                        f28 = fArr2[i36];
                    }
                    f23 = f6;
                    f24 = f7;
                } else {
                    z5 = z9;
                    z6 = z10;
                    c8 = c10;
                    c9 = c11;
                    i7 = i8;
                    path2.lineTo(fArr2[i7], f28);
                    f27 = fArr2[i7];
                }
                i8 = i7 + i6;
                path2 = path;
                c12 = c7;
                z9 = z5;
                z10 = z6;
                c10 = c8;
                c11 = c9;
            }
            fArr[z9 ? 1 : 0] = f27;
            fArr[z10 ? 1 : 0] = f28;
            fArr[c10] = f23;
            fArr[c11] = f24;
            fArr[4] = f29;
            fArr[5] = f30;
        }

        private static void f(Path path, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14) {
            double d15 = d8;
            int iCeil = (int) Math.ceil(Math.abs((d14 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d12);
            double dSin = Math.sin(d12);
            double dCos2 = Math.cos(d13);
            double dSin2 = Math.sin(d13);
            double d16 = -d15;
            double d17 = d16 * dCos;
            double d18 = d9 * dSin;
            double d19 = (d17 * dSin2) - (d18 * dCos2);
            double d20 = d16 * dSin;
            double d21 = d9 * dCos;
            double d22 = (dSin2 * d20) + (dCos2 * d21);
            double d23 = d14 / iCeil;
            double d24 = d22;
            double d25 = d19;
            int i5 = 0;
            double d26 = d10;
            double d27 = d11;
            double d28 = d13;
            while (i5 < iCeil) {
                double d29 = d28 + d23;
                double dSin3 = Math.sin(d29);
                double dCos3 = Math.cos(d29);
                double d30 = (d6 + ((d15 * dCos) * dCos3)) - (d18 * dSin3);
                int i6 = i5;
                double d31 = d7 + (d8 * dSin * dCos3) + (d21 * dSin3);
                double d32 = (d17 * dSin3) - (d18 * dCos3);
                double d33 = (dSin3 * d20) + (dCos3 * d21);
                double d34 = d29 - d28;
                double dTan = Math.tan(d34 / 2.0d);
                double dSin4 = (Math.sin(d34) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d35 = d26 + (d25 * dSin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d35, (float) (d27 + (d24 * dSin4)), (float) (d30 - (dSin4 * d32)), (float) (d31 - (dSin4 * d33)), (float) d30, (float) d31);
                dSin = dSin;
                d23 = d23;
                d26 = d30;
                d20 = d20;
                d28 = d29;
                d24 = d33;
                dCos = dCos;
                d15 = d8;
                d27 = d31;
                i5 = i6 + 1;
                iCeil = iCeil;
                d25 = d32;
            }
        }

        private static void g(Path path, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean z5, boolean z6) {
            double d6;
            double d7;
            double radians = Math.toRadians(f11);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d8 = f5;
            double d9 = f6;
            double d10 = f9;
            double d11 = ((d8 * dCos) + (d9 * dSin)) / d10;
            double d12 = f10;
            double d13 = (((-f5) * dSin) + (d9 * dCos)) / d12;
            double d14 = f8;
            double d15 = ((f7 * dCos) + (d14 * dSin)) / d10;
            double d16 = (((-f7) * dSin) + (d14 * dCos)) / d12;
            double d17 = d11 - d15;
            double d18 = d13 - d16;
            double d19 = (d11 + d15) / 2.0d;
            double d20 = (d13 + d16) / 2.0d;
            double d21 = (d17 * d17) + (d18 * d18);
            if (d21 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d22 = (1.0d / d21) - 0.25d;
            if (d22 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d21);
                float fSqrt = (float) (Math.sqrt(d21) / 1.99999d);
                g(path, f5, f6, f7, f8, f9 * fSqrt, fSqrt * f10, f11, z5, z6);
                return;
            }
            double dSqrt = Math.sqrt(d22);
            double d23 = d17 * dSqrt;
            double d24 = dSqrt * d18;
            if (z5 == z6) {
                d6 = d19 - d24;
                d7 = d20 + d23;
            } else {
                d6 = d19 + d24;
                d7 = d20 - d23;
            }
            double dAtan2 = Math.atan2(d13 - d7, d11 - d6);
            double dAtan22 = Math.atan2(d16 - d7, d15 - d6) - dAtan2;
            if (z6 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d25 = d6 * d10;
            double d26 = d7 * d12;
            f(path, (d25 * dCos) - (d26 * dSin), (d25 * dSin) + (d26 * dCos), d10, d12, d8, d9, radians, dAtan2, dAtan22);
        }

        @Deprecated
        public static void h(b[] bVarArr, Path path) {
            d.j(bVarArr, path);
        }

        b(b bVar) {
            this.f9649a = bVar.f9649a;
            float[] fArr = bVar.f9650b;
            this.f9650b = d.c(fArr, 0, fArr.length);
        }
    }
}
