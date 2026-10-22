package D;

import android.graphics.Path;
import android.util.Log;
import com.baidu.entity.pb.PoiResult;
import com.baidu.location.LocationConst;
import com.stepos.alphame.utils.Property;
import net.zetetic.database.DatabaseUtils;
import t0.J;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public char f362a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f363b;

    public f(char c4, float[] fArr) {
        this.f362a = c4;
        this.f363b = fArr;
    }

    public static void a(Path path, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z4, boolean z5) {
        double d4;
        double d5;
        double radians = Math.toRadians(f10);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d6 = f4;
        double d7 = f5;
        double d8 = (d7 * dSin) + (d6 * dCos);
        double d9 = d6;
        double d10 = f8;
        double d11 = d8 / d10;
        double d12 = f9;
        double d13 = ((d7 * dCos) + ((-f4) * dSin)) / d12;
        double d14 = d7;
        double d15 = f7;
        double d16 = ((d15 * dSin) + (f6 * dCos)) / d10;
        double d17 = ((d15 * dCos) + ((-f6) * dSin)) / d12;
        double d18 = d11 - d16;
        double d19 = d13 - d17;
        double d20 = (d11 + d16) / 2.0d;
        double d21 = (d13 + d17) / 2.0d;
        double d22 = (d19 * d19) + (d18 * d18);
        if (d22 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d23 = (1.0d / d22) - 0.25d;
        if (d23 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d22);
            float fSqrt = (float) (Math.sqrt(d22) / 1.99999d);
            a(path, f4, f5, f6, f7, f8 * fSqrt, f9 * fSqrt, f10, z4, z5);
            return;
        }
        double dSqrt = Math.sqrt(d23);
        double d24 = d18 * dSqrt;
        double d25 = dSqrt * d19;
        if (z4 == z5) {
            d4 = d20 - d25;
            d5 = d21 + d24;
        } else {
            d4 = d20 + d25;
            d5 = d21 - d24;
        }
        double dAtan2 = Math.atan2(d13 - d5, d11 - d4);
        double dAtan22 = Math.atan2(d17 - d5, d16 - d4) - dAtan2;
        if (z5 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d26 = d4 * d10;
        double d27 = d5 * d12;
        double d28 = (d26 * dCos) - (d27 * dSin);
        double d29 = (d27 * dCos) + (d26 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d30 = -d10;
        double d31 = d30 * dCos2;
        double d32 = d12 * dSin2;
        double d33 = (d31 * dSin3) - (d32 * dCos3);
        double d34 = d30 * dSin2;
        double d35 = d12 * dCos2;
        double d36 = (dCos3 * d35) + (dSin3 * d34);
        double d37 = d35;
        double d38 = dAtan22 / iCeil;
        int i4 = 0;
        while (i4 < iCeil) {
            double d39 = dAtan2 + d38;
            double dSin4 = Math.sin(d39);
            double dCos4 = Math.cos(d39);
            double d40 = d38;
            double d41 = (((d10 * dCos2) * dCos4) + d28) - (d32 * dSin4);
            double d42 = d37;
            double d43 = d28;
            double d44 = (d42 * dSin4) + (d10 * dSin2 * dCos4) + d29;
            double d45 = (d31 * dSin4) - (d32 * dCos4);
            double d46 = (dCos4 * d42) + (dSin4 * d34);
            double d47 = d39 - dAtan2;
            double dTan = Math.tan(d47 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d47)) / 3.0d;
            path.rLineTo(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
            path.cubicTo((float) ((d33 * dSqrt2) + d9), (float) ((d36 * dSqrt2) + d14), (float) (d41 - (dSqrt2 * d45)), (float) (d44 - (dSqrt2 * d46)), (float) d41, (float) d44);
            i4++;
            dAtan2 = d39;
            d34 = d34;
            dCos2 = dCos2;
            iCeil = iCeil;
            d36 = d46;
            d10 = d10;
            d33 = d45;
            d9 = d41;
            d14 = d44;
            d28 = d43;
            d38 = d40;
            d37 = d42;
        }
    }

    public static void b(f[] fVarArr, Path path) {
        int i4;
        int i5;
        char c4;
        int i6;
        int i7;
        f fVar;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        f[] fVarArr2 = fVarArr;
        int i8 = 6;
        float[] fArr = new float[6];
        int length = fVarArr2.length;
        int i9 = 0;
        char c5 = 'm';
        while (i9 < length) {
            f fVar2 = fVarArr2[i9];
            char c6 = fVar2.f362a;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            float f19 = fArr[3];
            float f20 = fArr[4];
            float f21 = fArr[5];
            switch (c6) {
                case 'A':
                case 'a':
                    i4 = 7;
                    break;
                case 'C':
                case DatabaseUtils.STATEMENT_OTHER /* 99 */:
                    i4 = i8;
                    break;
                case 'H':
                case PoiResult.Contents.BOUND_FIELD_NUMBER /* 86 */:
                case 'h':
                case 'v':
                    i4 = 1;
                    break;
                case 'Q':
                case 'S':
                case LocationConst.TrafficStatus.TRAFFIC_ERROR_PREDICT_MODEL_CUL_FAILED /* 113 */:
                case 's':
                    i4 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f20, f21);
                    f16 = f20;
                    f18 = f16;
                    f17 = f21;
                    f19 = f17;
                default:
                    i4 = 2;
                    break;
            }
            float f22 = f20;
            float f23 = f21;
            float f24 = f16;
            float f25 = f17;
            int i10 = 0;
            while (true) {
                float[] fArr2 = fVar2.f363b;
                if (i10 < fArr2.length) {
                    if (c6 != 'A') {
                        if (c6 != 'C') {
                            if (c6 == 'H') {
                                i5 = i10;
                                c4 = c6;
                                i6 = i9;
                                i7 = length;
                                fVar = fVar2;
                                path.lineTo(fArr2[i5], f25);
                                f24 = fArr2[i5];
                            } else if (c6 == 'Q') {
                                i5 = i10;
                                c4 = c6;
                                i6 = i9;
                                i7 = length;
                                fVar = fVar2;
                                float f26 = fArr2[i5];
                                int i11 = i5 + 1;
                                float f27 = fArr2[i11];
                                int i12 = i5 + 2;
                                int i13 = i5 + 3;
                                path.quadTo(f26, f27, fArr2[i12], fArr2[i13]);
                                f4 = fArr2[i5];
                                f5 = fArr2[i11];
                                f24 = fArr2[i12];
                                f25 = fArr2[i13];
                            } else if (c6 == 'V') {
                                i5 = i10;
                                c4 = c6;
                                i6 = i9;
                                i7 = length;
                                fVar = fVar2;
                                path.lineTo(f24, fArr2[i5]);
                                f25 = fArr2[i5];
                            } else if (c6 != 'a') {
                                if (c6 != 'c') {
                                    if (c6 != 'h') {
                                        if (c6 == 'q') {
                                            i5 = i10;
                                            float f28 = f25;
                                            float f29 = f24;
                                            int i14 = i5 + 1;
                                            int i15 = i5 + 2;
                                            int i16 = i5 + 3;
                                            path.rQuadTo(fArr2[i5], fArr2[i14], fArr2[i15], fArr2[i16]);
                                            float f30 = f29 + fArr2[i5];
                                            float f31 = fArr2[i14] + f28;
                                            float f32 = f29 + fArr2[i15];
                                            f25 = f28 + fArr2[i16];
                                            f19 = f31;
                                            f18 = f30;
                                            c4 = c6;
                                            i6 = i9;
                                            i7 = length;
                                            f24 = f32;
                                        } else if (c6 == 'v') {
                                            i5 = i10;
                                            path.rLineTo(Property.DEFAULT_FLOAT_VALUE, fArr2[i5]);
                                            f25 += fArr2[i5];
                                        } else if (c6 == 'L') {
                                            i5 = i10;
                                            int i17 = i5 + 1;
                                            path.lineTo(fArr2[i5], fArr2[i17]);
                                            f24 = fArr2[i5];
                                            f25 = fArr2[i17];
                                        } else if (c6 == 'M') {
                                            i5 = i10;
                                            f24 = fArr2[i5];
                                            f25 = fArr2[i5 + 1];
                                            if (i5 > 0) {
                                                path.lineTo(f24, f25);
                                            } else {
                                                path.moveTo(f24, f25);
                                                f23 = f25;
                                                f22 = f24;
                                            }
                                        } else if (c6 == 'S') {
                                            i5 = i10;
                                            float f33 = f25;
                                            float f34 = f24;
                                            if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                                f10 = (f33 * 2.0f) - f19;
                                                f11 = (f34 * 2.0f) - f18;
                                            } else {
                                                f11 = f34;
                                                f10 = f33;
                                            }
                                            int i18 = i5 + 1;
                                            int i19 = i5 + 2;
                                            int i20 = i5 + 3;
                                            path.cubicTo(f11, f10, fArr2[i5], fArr2[i18], fArr2[i19], fArr2[i20]);
                                            float f35 = fArr2[i5];
                                            float f36 = fArr2[i18];
                                            f24 = fArr2[i19];
                                            f25 = fArr2[i20];
                                            f19 = f36;
                                            f18 = f35;
                                        } else if (c6 == 'T') {
                                            i5 = i10;
                                            float f37 = f25;
                                            float f38 = f24;
                                            if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                                f6 = (f38 * 2.0f) - f18;
                                                f7 = (f37 * 2.0f) - f19;
                                            } else {
                                                f6 = f38;
                                                f7 = f37;
                                            }
                                            int i21 = i5 + 1;
                                            path.quadTo(f6, f7, fArr2[i5], fArr2[i21]);
                                            f8 = fArr2[i5];
                                            f9 = fArr2[i21];
                                        } else if (c6 == 'l') {
                                            i5 = i10;
                                            int i22 = i5 + 1;
                                            path.rLineTo(fArr2[i5], fArr2[i22]);
                                            f24 += fArr2[i5];
                                            f25 += fArr2[i22];
                                        } else if (c6 == 'm') {
                                            i5 = i10;
                                            float f39 = fArr2[i5];
                                            f24 += f39;
                                            float f40 = fArr2[i5 + 1];
                                            f25 += f40;
                                            if (i5 > 0) {
                                                path.rLineTo(f39, f40);
                                            } else {
                                                path.rMoveTo(f39, f40);
                                                f23 = f25;
                                                f22 = f24;
                                            }
                                        } else if (c6 == 's') {
                                            if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                                float f41 = f24 - f18;
                                                f12 = f25 - f19;
                                                f13 = f41;
                                            } else {
                                                f12 = Property.DEFAULT_FLOAT_VALUE;
                                                f13 = Property.DEFAULT_FLOAT_VALUE;
                                            }
                                            int i23 = i10 + 1;
                                            int i24 = i10 + 2;
                                            int i25 = i10 + 3;
                                            i5 = i10;
                                            float f42 = f25;
                                            float f43 = f24;
                                            path.rCubicTo(f13, f12, fArr2[i10], fArr2[i23], fArr2[i24], fArr2[i25]);
                                            f6 = f43 + fArr2[i5];
                                            f7 = f42 + fArr2[i23];
                                            f8 = f43 + fArr2[i24];
                                            f9 = fArr2[i25] + f42;
                                        } else if (c6 != 't') {
                                            i5 = i10;
                                        } else {
                                            if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                                f14 = f24 - f18;
                                                f15 = f25 - f19;
                                            } else {
                                                f15 = Property.DEFAULT_FLOAT_VALUE;
                                                f14 = Property.DEFAULT_FLOAT_VALUE;
                                            }
                                            int i26 = i10 + 1;
                                            path.rQuadTo(f14, f15, fArr2[i10], fArr2[i26]);
                                            float f44 = f14 + f24;
                                            float f45 = f15 + f25;
                                            f24 += fArr2[i10];
                                            f25 += fArr2[i26];
                                            f19 = f45;
                                            i5 = i10;
                                            c4 = c6;
                                            i6 = i9;
                                            i7 = length;
                                            f18 = f44;
                                        }
                                        fVar = fVar2;
                                    } else {
                                        i5 = i10;
                                        path.rLineTo(fArr2[i5], Property.DEFAULT_FLOAT_VALUE);
                                        f24 += fArr2[i5];
                                    }
                                    c4 = c6;
                                    i6 = i9;
                                    i7 = length;
                                    fVar = fVar2;
                                } else {
                                    i5 = i10;
                                    float f46 = f25;
                                    float f47 = f24;
                                    int i27 = i5 + 2;
                                    int i28 = i5 + 3;
                                    int i29 = i5 + 4;
                                    int i30 = i5 + 5;
                                    path.rCubicTo(fArr2[i5], fArr2[i5 + 1], fArr2[i27], fArr2[i28], fArr2[i29], fArr2[i30]);
                                    f6 = f47 + fArr2[i27];
                                    f7 = f46 + fArr2[i28];
                                    f8 = f47 + fArr2[i29];
                                    f9 = fArr2[i30] + f46;
                                }
                                f19 = f7;
                                f18 = f6;
                                c4 = c6;
                                i6 = i9;
                                i7 = length;
                                f24 = f8;
                                f25 = f9;
                                fVar = fVar2;
                            } else {
                                i5 = i10;
                                float f48 = f25;
                                float f49 = f24;
                                int i31 = i5 + 5;
                                int i32 = i5 + 6;
                                c4 = c6;
                                i7 = length;
                                fVar = fVar2;
                                i6 = i9;
                                a(path, f49, f48, fArr2[i31] + f49, fArr2[i32] + f48, fArr2[i5], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3] != Property.DEFAULT_FLOAT_VALUE, fArr2[i5 + 4] != Property.DEFAULT_FLOAT_VALUE);
                                f24 = f49 + fArr2[i31];
                                f25 = f48 + fArr2[i32];
                            }
                            i10 = i5 + i4;
                            fVar2 = fVar;
                            length = i7;
                            c5 = c4;
                            c6 = c5;
                            i9 = i6;
                        } else {
                            i5 = i10;
                            c4 = c6;
                            i6 = i9;
                            i7 = length;
                            fVar = fVar2;
                            int i33 = i5 + 2;
                            int i34 = i5 + 3;
                            int i35 = i5 + 4;
                            int i36 = i5 + 5;
                            path.cubicTo(fArr2[i5], fArr2[i5 + 1], fArr2[i33], fArr2[i34], fArr2[i35], fArr2[i36]);
                            f24 = fArr2[i35];
                            f25 = fArr2[i36];
                            f4 = fArr2[i33];
                            f5 = fArr2[i34];
                        }
                        f18 = f4;
                        f19 = f5;
                        i10 = i5 + i4;
                        fVar2 = fVar;
                        length = i7;
                        c5 = c4;
                        c6 = c5;
                        i9 = i6;
                    } else {
                        i5 = i10;
                        c4 = c6;
                        i6 = i9;
                        i7 = length;
                        fVar = fVar2;
                        int i37 = i5 + 5;
                        int i38 = i5 + 6;
                        a(path, f24, f25, fArr2[i37], fArr2[i38], fArr2[i5], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3] != Property.DEFAULT_FLOAT_VALUE, fArr2[i5 + 4] != Property.DEFAULT_FLOAT_VALUE);
                        f24 = fArr2[i37];
                        f25 = fArr2[i38];
                    }
                    f19 = f25;
                    f18 = f24;
                    i10 = i5 + i4;
                    fVar2 = fVar;
                    length = i7;
                    c5 = c4;
                    c6 = c5;
                    i9 = i6;
                }
            }
            fArr[0] = f24;
            fArr[1] = f25;
            fArr[2] = f18;
            fArr[3] = f19;
            fArr[4] = f22;
            fArr[5] = f23;
            c5 = fVar2.f362a;
            i9++;
            fVarArr2 = fVarArr;
            length = length;
            i8 = 6;
        }
    }

    public f(f fVar) {
        this.f362a = fVar.f362a;
        float[] fArr = fVar.f363b;
        this.f363b = J.p(fArr, fArr.length);
    }
}
