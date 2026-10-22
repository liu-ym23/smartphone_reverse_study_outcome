package org.apache.commons.math.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.TrivariateRealFunction;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NoDataException;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TricubicSplineInterpolator implements TrivariateRealGridInterpolator {
    public TricubicSplineInterpolator() {
    }

    @Override // org.apache.commons.math.analysis.interpolation.TrivariateRealGridInterpolator
    public /* bridge */ /* synthetic */ TrivariateRealFunction interpolate(double[] r1, double[] r2, double[] r3, double[][][] r4) throws MathException {
        return interpolate(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.math.analysis.interpolation.TrivariateRealGridInterpolator
    public TricubicSplineInterpolatingFunction interpolate(double[] r36, double[] r37, double[] r38, double[][][] r39) throws MathException {
        if (r36.length == 0) goto L79;
        if (r37.length == 0) goto L79;
        if (r38.length == 0) goto L79;
        if (r39.length == 0) goto L79;
        if (r36.length != r39.length) goto L77;
        MathUtils.checkOrder(r36);
        MathUtils.checkOrder(r37);
        MathUtils.checkOrder(r38);
        int r13 = r36.length;
        int r14 = r37.length;
        int r15 = r38.length;
        char r7 = 2;
        boolean r8 = true;
        double[][][] r16 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r15, r13, r14});
        double[][][] r17 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r14, r15, r13});
        int r6 = 0;
    L13:
        if (r6 >= r13) goto L29;
        if (r39[r6].length != r14) goto L28;
        int r10 = 0;
    L17:
        if (r10 >= r14) goto L26;
        if (r39[r6][r10].length != r15) goto L25;
        int r11 = 0;
    L21:
        if (r11 >= r15) goto L23;
        double r18 = r39[r6][r10][r11];
        r16[r11][r6][r10] = r18;
        r17[r10][r11][r6] = r18;
        r11 = r11 + 1;
        goto L21
    L23:
        r10 = r10 + 1;
        goto L17
    L25:
        throw new DimensionMismatchException(r39[r6][r10].length, r15);
    L26:
        r6 = r6 + 1;
        goto L13
    L28:
        throw new DimensionMismatchException(r39[r6].length, r14);
    L29:
        BicubicSplineInterpolator r9 = new BicubicSplineInterpolator();
        BicubicSplineInterpolatingFunction[] r12 = new BicubicSplineInterpolatingFunction[r13];
        int r19 = 0;
    L30:
        if (r19 >= r13) goto L32;
        r12[r19] = r9.interpolate(r37, r38, r39[r19]);
        r19 = r19 + 1;
        goto L30
    L32:
        BicubicSplineInterpolatingFunction[] r110 = new BicubicSplineInterpolatingFunction[r14];
        int r111 = 0;
    L33:
        if (r111 >= r14) goto L35;
        r110[r111] = r9.interpolate(r38, r36, r17[r111]);
        r111 = r111 + 1;
        r7 = r7;
        goto L33
    L35:
        char r112 = r7;
        BicubicSplineInterpolatingFunction[] r20 = new BicubicSplineInterpolatingFunction[r15];
        int r113 = 0;
    L36:
        if (r113 >= r15) goto L38;
        r20[r113] = r9.interpolate(r36, r37, r16[r113]);
        r113 = r113 + 1;
        r8 = r8;
        goto L36
    L38:
        boolean r114 = r8;
        int[] r21 = new int[3];
        r21[r112] = r15;
        r21[r114 ? 1 : 0] = r14;
        r21[0] = r13;
        double[][][] r22 = (double[][][]) Array.newInstance(Double.TYPE, r21);
        int[] r115 = new int[3];
        r115[r112] = r15;
        r115[r114 ? 1 : 0] = r14;
        r115[0] = r13;
        double[][][] r23 = (double[][][]) Array.newInstance(Double.TYPE, r115);
        int[] r116 = new int[3];
        r116[r112] = r15;
        r116[r114 ? 1 : 0] = r14;
        r116[0] = r13;
        double[][][] r1 = (double[][][]) Array.newInstance(Double.TYPE, r116);
        int r117 = 0;
    L39:
        if (r117 >= r15) goto L47;
        double[][][] r24 = r1;
        BicubicSplineInterpolatingFunction r2 = r20[r117];
        int r3 = 0;
    L41:
        if (r3 >= r13) goto L46;
        int r25 = r3;
        double r4 = r36[r25];
        int r5 = 0;
    L43:
        if (r5 >= r14) goto L45;
        int r26 = r5;
        double r27 = r37[r26];
        r22[r25][r26][r117] = r2.partialDerivativeX(r4, r27);
        r23[r25][r26][r117] = r2.partialDerivativeY(r4, r27);
        r24[r25][r26][r117] = r2.partialDerivativeXY(r4, r27);
        r5 = r26 + 1;
        goto L43
    L45:
        r3 = r25 + 1;
        goto L41
    L46:
        r117 = r117 + 1;
        r1 = r24;
        goto L39
    L47:
        double[][][] r28 = r1;
        int[] r29 = new int[3];
        r29[r112] = r15;
        r29[r114 ? 1 : 0] = r14;
        r29[0] = r13;
        double[][][] r30 = (double[][][]) Array.newInstance(Double.TYPE, r29);
        int[] r31 = new int[3];
        r31[r112] = r15;
        r31[r114 ? 1 : 0] = r14;
        r31[0] = r13;
        double[][][] r32 = (double[][][]) Array.newInstance(Double.TYPE, r31);
        int r33 = 0;
    L48:
        if (r33 >= r13) goto L56;
        BicubicSplineInterpolatingFunction r34 = r12[r33];
        int r35 = 0;
    L50:
        if (r35 >= r14) goto L55;
        double[][][] r210 = r32;
        double[][][] r118 = r30;
        double r40 = r37[r35];
        int r211 = r33;
        int r41 = 0;
    L52:
        if (r41 >= r15) goto L54;
        int r212 = r35;
        double r42 = r38[r41];
        r118[r211][r212][r41] = r34.partialDerivativeY(r40, r42);
        r210[r211][r212][r41] = r34.partialDerivativeXY(r40, r42);
        r41 = r41 + 1;
        r9 = r9;
        r35 = r212;
        goto L52
    L54:
        r35 = r35 + 1;
        r30 = r118;
        r32 = r210;
        r33 = r211;
        goto L50
    L55:
        r33 = r33 + 1;
        goto L48
    L56:
        double[][][] r213 = r32;
        double[][][] r119 = r30;
        int[] r43 = new int[3];
        r43[r112] = r15;
        r43[r114 ? 1 : 0] = r14;
        r43[0] = r13;
        double[][][] r44 = (double[][][]) Array.newInstance(Double.TYPE, r43);
        int r45 = 0;
    L57:
        if (r45 >= r14) goto L65;
        BicubicSplineInterpolatingFunction r46 = r110[r45];
        int r47 = 0;
    L59:
        if (r47 >= r15) goto L64;
        double r48 = r38[r47];
        double[][][] r214 = r44;
        int r49 = 0;
    L61:
        if (r49 >= r13) goto L63;
        int r215 = r49;
        int r216 = r45;
        r214[r215][r216][r47] = r46.partialDerivativeXY(r48, r36[r215]);
        r49 = r215 + 1;
        r45 = r216;
        goto L61
    L63:
        r47 = r47 + 1;
        r44 = r214;
        goto L59
    L64:
        r45 = r45 + 1;
        goto L57
    L65:
        double[][][] r217 = r44;
        int[] r50 = new int[3];
        r50[r112] = r15;
        r50[r114 ? 1 : 0] = r14;
        r50[0] = r13;
        double[][][] r51 = (double[][][]) Array.newInstance(Double.TYPE, r50);
        int r52 = 0;
    L66:
        if (r52 >= r13) goto L75;
        int r53 = nextIndex(r52, r13);
        int r54 = previousIndex(r52);
        int r55 = 0;
    L68:
        if (r55 >= r14) goto L73;
        int r56 = nextIndex(r55, r14);
        int r120 = previousIndex(r55);
        double[][][] r218 = r51;
        int r57 = 0;
    L70:
        if (r57 >= r15) goto L72;
        int r121 = nextIndex(r57, r15);
        int r219 = previousIndex(r57);
        r218[r52][r55][r57] = (((((((r39[r53][r56][r121] - r39[r53][r120][r121]) - r39[r54][r56][r121]) + r39[r54][r120][r121]) - r39[r53][r56][r219]) + r39[r53][r120][r219]) + r39[r54][r56][r219]) - r39[r54][r120][r219]) / (((r36[r53] - r36[r54]) * (r37[r56] - r37[r120])) * (r38[r121] - r38[r219]));
        r57 = r57 + 1;
        goto L70
    L72:
        r55 = r55 + 1;
        r51 = r218;
        goto L68
    L73:
        r52 = r52 + 1;
        goto L66
    L75:
        return new TricubicSplineInterpolatingFunction(r36, r37, r38, r39, r22, r23, r119, r28, r217, r213, r51);
    L77:
        throw new DimensionMismatchException(r36.length, r39.length);
    L79:
        throw new NoDataException();
    }

    private int nextIndex(int i, int max) {
        int index = i + 1;
        if (index >= max) goto L6;
        return index;
    L6:
        return index - 1;
    }

    private int previousIndex(int i) {
        int index = i - 1;
        if (index >= 0) goto L7;
        return 0;
    L7:
        return index;
    }
}
