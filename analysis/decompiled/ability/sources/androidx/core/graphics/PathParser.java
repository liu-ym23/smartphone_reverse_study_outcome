package androidx.core.graphics;

import B7.a;
import android.graphics.Path;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i6) {
        if (i > i6) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i10 = i6 - i;
        int iMin = Math.min(i10, length - i);
        float[] fArr2 = new float[i10];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i6 = 1;
        while (i6 < str.length()) {
            int iNextStart = nextStart(str, i6);
            String strTrim = str.substring(i, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i = iNextStart;
            i6 = iNextStart + 1;
        }
        if (i6 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(a.k("Error in parsing ", str), e);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
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
            r10.mEndWithNegOrDot = r7
        L29:
            r2 = r0
            r4 = r7
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.mEndWithNegOrDot = r7
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
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i6 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i10 = extractFloatResult.mEndPosition;
                if (i < i10) {
                    fArr[i6] = Float.parseFloat(str.substring(i, i10));
                    i6++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i10 : i10 + 1;
            }
            return copyOfRange(fArr, 0, i6);
        } catch (NumberFormatException e) {
            throw new RuntimeException(a.m("error in parsing \"", str, "\""), e);
        }
    }

    public static void interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, float f, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                }
                i++;
            }
            if (cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
            c = pathDataNode.mType;
        }
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i6 = 0; i6 < pathDataNodeArr2[i].mParams.length; i6++) {
                pathDataNodeArr[i].mParams[i6] = pathDataNodeArr2[i].mParams[i6];
            }
        }
    }

    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i6;
            boolean z10;
            boolean z11;
            char c5;
            char c10;
            int i10;
            float f;
            boolean z12;
            float f7;
            float f9;
            float f10;
            float f11;
            float f12;
            boolean z13;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float f20;
            float f21;
            float f22;
            Path path2 = path;
            boolean z14 = false;
            float f23 = fArr[0];
            boolean z15 = true;
            float f24 = fArr[1];
            char c11 = 2;
            float f25 = fArr[2];
            char c12 = 3;
            float f26 = fArr[3];
            float f27 = fArr[4];
            float f28 = fArr[5];
            switch (c2) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case 'a':
                    i = 7;
                    i6 = i;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                case 'c':
                    i = 6;
                    i6 = i;
                    break;
                case 'H':
                case 'V':
                case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                case 'v':
                    i6 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
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
                    path2.moveTo(f27, f28);
                    f23 = f27;
                    f25 = f23;
                    f24 = f28;
                    f26 = f24;
                    i6 = 2;
                    break;
            }
            float f29 = f23;
            float f30 = f24;
            float f31 = f27;
            float f32 = f28;
            int i11 = 0;
            char c13 = c;
            while (i11 < fArr2.length) {
                if (c2 == 'A') {
                    float f33 = f29;
                    float f34 = f30;
                    z10 = z14;
                    z11 = z15;
                    c5 = c11;
                    c10 = c12;
                    i10 = i11;
                    int i12 = i10 + 5;
                    float f35 = fArr2[i12];
                    int i13 = i10 + 6;
                    float f36 = fArr2[i13];
                    float f37 = fArr2[i10];
                    float f38 = fArr2[i10 + 1];
                    float f39 = fArr2[i10 + 2];
                    if (fArr2[i10 + 3] != 0.0f) {
                        f = 0.0f;
                        z12 = z11;
                    } else {
                        f = 0.0f;
                        z12 = z10;
                    }
                    drawArc(path, f33, f34, f35, f36, f37, f38, f39, z12, fArr2[i10 + 4] != f ? z11 : z10);
                    f25 = fArr2[i12];
                    f29 = f25;
                    f26 = fArr2[i13];
                    f30 = f26;
                } else if (c2 == 'C') {
                    z10 = z14;
                    z11 = z15;
                    c5 = c11;
                    c10 = c12;
                    i10 = i11;
                    int i14 = i10 + 2;
                    int i15 = i10 + 3;
                    int i16 = i10 + 4;
                    int i17 = i10 + 5;
                    path2.cubicTo(fArr2[i10], fArr2[i10 + 1], fArr2[i14], fArr2[i15], fArr2[i16], fArr2[i17]);
                    float f40 = fArr2[i16];
                    float f41 = fArr2[i17];
                    float f42 = fArr2[i14];
                    float f43 = fArr2[i15];
                    f29 = f40;
                    f30 = f41;
                    f26 = f43;
                    f25 = f42;
                } else if (c2 != 'H') {
                    if (c2 != 'Q') {
                        z10 = z14;
                        if (c2 == 'V') {
                            z11 = z15;
                            c5 = c11;
                            c10 = c12;
                            i10 = i11;
                            path2.lineTo(f29, fArr2[i10]);
                            f10 = fArr2[i10];
                        } else if (c2 != 'a') {
                            if (c2 != 'c') {
                                z11 = z15;
                                if (c2 != 'h') {
                                    if (c2 != 'q') {
                                        c5 = c11;
                                        if (c2 != 'v') {
                                            if (c2 != 'L') {
                                                if (c2 != 'M') {
                                                    c10 = c12;
                                                    if (c2 == 'S') {
                                                        if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                                            f29 = (f29 * 2.0f) - f25;
                                                            f30 = (f30 * 2.0f) - f26;
                                                        }
                                                        float f44 = f29;
                                                        float f45 = f30;
                                                        int i18 = i11 + 1;
                                                        int i19 = i11 + 2;
                                                        int i20 = i11 + 3;
                                                        path2.cubicTo(f44, f45, fArr2[i11], fArr2[i18], fArr2[i19], fArr2[i20]);
                                                        f7 = fArr2[i11];
                                                        f9 = fArr2[i18];
                                                        f29 = fArr2[i19];
                                                        f30 = fArr2[i20];
                                                        i10 = i11;
                                                    } else if (c2 == 'T') {
                                                        if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                                            f29 = (f29 * 2.0f) - f25;
                                                            f30 = (f30 * 2.0f) - f26;
                                                        }
                                                        int i21 = i11 + 1;
                                                        path2.quadTo(f29, f30, fArr2[i11], fArr2[i21]);
                                                        float f46 = fArr2[i11];
                                                        f10 = fArr2[i21];
                                                        f25 = f29;
                                                        f26 = f30;
                                                        i10 = i11;
                                                        f29 = f46;
                                                    } else if (c2 == 'l') {
                                                        int i22 = i11 + 1;
                                                        path2.rLineTo(fArr2[i11], fArr2[i22]);
                                                        f29 += fArr2[i11];
                                                        f16 = fArr2[i22];
                                                    } else if (c2 == 'm') {
                                                        float f47 = fArr2[i11];
                                                        f29 += f47;
                                                        float f48 = fArr2[i11 + 1];
                                                        f30 += f48;
                                                        if (i11 > 0) {
                                                            path2.rLineTo(f47, f48);
                                                        } else {
                                                            path2.rMoveTo(f47, f48);
                                                            f31 = f29;
                                                        }
                                                    } else if (c2 == 's') {
                                                        if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                                            f19 = f30 - f26;
                                                            f20 = f29 - f25;
                                                        } else {
                                                            f20 = 0.0f;
                                                            f19 = 0.0f;
                                                        }
                                                        int i23 = i11 + 1;
                                                        int i24 = i11 + 2;
                                                        int i25 = i11 + 3;
                                                        path2.rCubicTo(f20, f19, fArr2[i11], fArr2[i23], fArr2[i24], fArr2[i25]);
                                                        f13 = fArr2[i11] + f29;
                                                        f14 = fArr2[i23] + f30;
                                                        f29 += fArr2[i24];
                                                        f15 = fArr2[i25];
                                                    } else if (c2 == 't') {
                                                        if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                                            f21 = f29 - f25;
                                                            f22 = f30 - f26;
                                                        } else {
                                                            f22 = 0.0f;
                                                            f21 = 0.0f;
                                                        }
                                                        int i26 = i11 + 1;
                                                        path2.rQuadTo(f21, f22, fArr2[i11], fArr2[i26]);
                                                        float f49 = f21 + f29;
                                                        float f50 = f22 + f30;
                                                        f29 += fArr2[i11];
                                                        f30 += fArr2[i26];
                                                        f26 = f50;
                                                        f25 = f49;
                                                    }
                                                } else {
                                                    c10 = c12;
                                                    f17 = fArr2[i11];
                                                    f18 = fArr2[i11 + 1];
                                                    if (i11 > 0) {
                                                        path2.lineTo(f17, f18);
                                                    } else {
                                                        path2.moveTo(f17, f18);
                                                        f29 = f17;
                                                        f31 = f29;
                                                        f30 = f18;
                                                    }
                                                }
                                                f32 = f30;
                                            } else {
                                                c10 = c12;
                                                int i27 = i11 + 1;
                                                path2.lineTo(fArr2[i11], fArr2[i27]);
                                                f17 = fArr2[i11];
                                                f18 = fArr2[i27];
                                            }
                                            f29 = f17;
                                            f30 = f18;
                                        } else {
                                            c10 = c12;
                                            path2.rLineTo(0.0f, fArr2[i11]);
                                            f16 = fArr2[i11];
                                        }
                                        f30 += f16;
                                    } else {
                                        c5 = c11;
                                        c10 = c12;
                                        int i28 = i11 + 1;
                                        int i29 = i11 + 2;
                                        int i30 = i11 + 3;
                                        path2.rQuadTo(fArr2[i11], fArr2[i28], fArr2[i29], fArr2[i30]);
                                        f13 = fArr2[i11] + f29;
                                        f14 = fArr2[i28] + f30;
                                        f29 += fArr2[i29];
                                        f15 = fArr2[i30];
                                    }
                                    f30 += f15;
                                    f25 = f13;
                                    f26 = f14;
                                } else {
                                    c5 = c11;
                                    c10 = c12;
                                    path2.rLineTo(fArr2[i11], 0.0f);
                                    f29 += fArr2[i11];
                                }
                            } else {
                                z11 = z15;
                                c5 = c11;
                                c10 = c12;
                                int i31 = i11 + 2;
                                int i32 = i11 + 3;
                                int i33 = i11 + 4;
                                int i34 = i11 + 5;
                                path2.rCubicTo(fArr2[i11], fArr2[i11 + 1], fArr2[i31], fArr2[i32], fArr2[i33], fArr2[i34]);
                                float f51 = fArr2[i31] + f29;
                                float f52 = fArr2[i32] + f30;
                                f29 += fArr2[i33];
                                f30 += fArr2[i34];
                                f25 = f51;
                                f26 = f52;
                            }
                            i10 = i11;
                        } else {
                            z11 = z15;
                            c5 = c11;
                            c10 = c12;
                            int i35 = i11 + 5;
                            float f53 = fArr2[i35] + f29;
                            int i36 = i11 + 6;
                            float f54 = fArr2[i36] + f30;
                            float f55 = fArr2[i11];
                            float f56 = fArr2[i11 + 1];
                            float f57 = fArr2[i11 + 2];
                            if (fArr2[i11 + 3] != 0.0f) {
                                f11 = 0.0f;
                                f12 = f30;
                                z13 = z11;
                            } else {
                                f11 = 0.0f;
                                f12 = f30;
                                z13 = z10;
                            }
                            i10 = i11;
                            boolean z16 = fArr2[i11 + 4] != f11 ? z11 : z10;
                            float f58 = f29;
                            drawArc(path, f58, f12, f53, f54, f55, f56, f57, z13, z16);
                            f29 = f58 + fArr2[i35];
                            f30 = f12 + fArr2[i36];
                            f25 = f29;
                            f26 = f30;
                        }
                        f30 = f10;
                    } else {
                        z10 = z14;
                        z11 = z15;
                        c5 = c11;
                        c10 = c12;
                        i10 = i11;
                        int i37 = i10 + 1;
                        int i38 = i10 + 2;
                        int i39 = i10 + 3;
                        path2.quadTo(fArr2[i10], fArr2[i37], fArr2[i38], fArr2[i39]);
                        f7 = fArr2[i10];
                        f9 = fArr2[i37];
                        f29 = fArr2[i38];
                        f30 = fArr2[i39];
                    }
                    f25 = f7;
                    f26 = f9;
                } else {
                    z10 = z14;
                    z11 = z15;
                    c5 = c11;
                    c10 = c12;
                    i10 = i11;
                    path2.lineTo(fArr2[i10], f30);
                    f29 = fArr2[i10];
                }
                i11 = i10 + i6;
                path2 = path;
                c13 = c2;
                z14 = z10;
                z15 = z11;
                c11 = c5;
                c12 = c10;
            }
            fArr[z14 ? 1 : 0] = f29;
            fArr[z15 ? 1 : 0] = f30;
            fArr[c11] = f25;
            fArr[c12] = f26;
            fArr[4] = f31;
            fArr[5] = f32;
        }

        private static void arcToBezier(Path path, double d, double d6, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
            double d17 = d10;
            int iCeil = (int) Math.ceil(Math.abs((d16 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d14);
            double dSin = Math.sin(d14);
            double dCos2 = Math.cos(d15);
            double dSin2 = Math.sin(d15);
            double d18 = -d17;
            double d19 = d18 * dCos;
            double d20 = d11 * dSin;
            double d21 = (d19 * dSin2) - (d20 * dCos2);
            double d22 = d18 * dSin;
            double d23 = d11 * dCos;
            double d24 = (dCos2 * d23) + (dSin2 * d22);
            double d25 = d16 / iCeil;
            double d26 = d24;
            double d27 = d21;
            int i = 0;
            double d28 = d12;
            double d29 = d13;
            double d30 = d15;
            while (i < iCeil) {
                double d31 = d30 + d25;
                double dSin3 = Math.sin(d31);
                double dCos3 = Math.cos(d31);
                double d32 = (((d17 * dCos) * dCos3) + d) - (d20 * dSin3);
                int i6 = i;
                double d33 = (d23 * dSin3) + (d10 * dSin * dCos3) + d6;
                double d34 = (d19 * dSin3) - (d20 * dCos3);
                double d35 = (dCos3 * d23) + (dSin3 * d22);
                double d36 = d31 - d30;
                double dTan = Math.tan(d36 / 2.0d);
                double dSqrt = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d36)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d27 * dSqrt) + d28), (float) ((d26 * dSqrt) + d29), (float) (d32 - (dSqrt * d34)), (float) (d33 - (dSqrt * d35)), (float) d32, (float) d33);
                dSin = dSin;
                d25 = d25;
                d28 = d32;
                d22 = d22;
                dCos = dCos;
                d26 = d35;
                d27 = d34;
                d17 = d10;
                d29 = d33;
                i = i6 + 1;
                iCeil = iCeil;
                d30 = d31;
            }
        }

        private static void drawArc(Path path, float f, float f7, float f9, float f10, float f11, float f12, float f13, boolean z10, boolean z11) {
            double d;
            double d6;
            double radians = Math.toRadians(f13);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d10 = f;
            double d11 = f7;
            double d12 = f11;
            double d13 = ((d11 * dSin) + (d10 * dCos)) / d12;
            double d14 = f12;
            double d15 = ((d11 * dCos) + ((-f) * dSin)) / d14;
            double d16 = f10;
            double d17 = ((d16 * dSin) + (f9 * dCos)) / d12;
            double d18 = ((d16 * dCos) + ((-f9) * dSin)) / d14;
            double d19 = d13 - d17;
            double d20 = d15 - d18;
            double d21 = (d13 + d17) / 2.0d;
            double d22 = (d15 + d18) / 2.0d;
            double d23 = (d20 * d20) + (d19 * d19);
            if (d23 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d24 = (1.0d / d23) - 0.25d;
            if (d24 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d23);
                float fSqrt = (float) (Math.sqrt(d23) / 1.99999d);
                drawArc(path, f, f7, f9, f10, f11 * fSqrt, fSqrt * f12, f13, z10, z11);
                return;
            }
            double dSqrt = Math.sqrt(d24);
            double d25 = dSqrt * d19;
            double d26 = dSqrt * d20;
            if (z10 == z11) {
                d = d21 - d26;
                d6 = d22 + d25;
            } else {
                d = d21 + d26;
                d6 = d22 - d25;
            }
            double dAtan2 = Math.atan2(d15 - d6, d13 - d);
            double dAtan22 = Math.atan2(d18 - d6, d17 - d) - dAtan2;
            if (z11 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d27 = d * d12;
            double d28 = d6 * d14;
            arcToBezier(path, (d27 * dCos) - (d28 * dSin), (d28 * dCos) + (d27 * dSin), d12, d14, d10, d11, radians, dAtan2, dAtan22);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i >= fArr.length) {
                    return;
                }
                this.mParams[i] = (pathDataNode2.mParams[i] * f) + ((1.0f - f) * fArr[i]);
                i++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}
