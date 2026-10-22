package org.apache.commons.math.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math.DimensionMismatchException;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.BivariateRealFunction;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SmoothingBicubicSplineInterpolator implements BivariateRealGridInterpolator {
    public SmoothingBicubicSplineInterpolator() {
    }

    @Override // org.apache.commons.math.analysis.interpolation.BivariateRealGridInterpolator
    public BivariateRealFunction interpolate(double[] r29, double[] r30, double[][] r31) throws MathException, IllegalArgumentException {
        boolean r4 = false;
        if (r29.length == 0) goto L61;
        if (r30.length == 0) goto L61;
        if (r31.length == 0) goto L61;
        if (r29.length != r31.length) goto L59;
        boolean r5 = true;
        MathUtils.checkOrder(r29, MathUtils.OrderDirection.INCREASING, true);
        MathUtils.checkOrder(r30, MathUtils.OrderDirection.INCREASING, true);
        int r9 = r29.length;
        int r10 = r30.length;
        double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, r9});
        int r6 = 0;
    L11:
        if (r6 >= r9) goto L20;
        if (r31[r6].length != r10) goto L19;
        int r7 = 0;
    L15:
        if (r7 >= r10) goto L17;
        r11[r7][r6] = r31[r6][r7];
        r7 = r7 + 1;
        goto L15
    L17:
        r6 = r6 + 1;
        goto L11
    L19:
        throw new DimensionMismatchException(r31[r6].length, r10);
    L20:
        SplineInterpolator r8 = new SplineInterpolator();
        PolynomialSplineFunction[] r13 = new PolynomialSplineFunction[r10];
        int r12 = 0;
    L21:
        if (r12 >= r10) goto L23;
        r13[r12] = r8.interpolate(r29, r11[r12]);
        r12 = r12 + 1;
        goto L21
    L23:
        double[][] r14 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r9, r10});
        int r15 = 0;
    L24:
        if (r15 >= r10) goto L29;
        PolynomialSplineFunction r16 = r13[r15];
        int r17 = 0;
    L26:
        if (r17 >= r9) goto L28;
        int r18 = r15;
        r14[r17][r18] = r16.value(r29[r17]);
        r17 = r17 + 1;
        r5 = r5;
        r15 = r18;
        goto L26
    L28:
        r15 = r15 + 1;
        goto L24
    L29:
        boolean r19 = r5;
        PolynomialSplineFunction[] r110 = new PolynomialSplineFunction[r9];
        int r20 = 0;
    L30:
        if (r20 >= r9) goto L32;
        r110[r20] = r8.interpolate(r30, r14[r20]);
        r20 = r20 + 1;
        goto L30
    L32:
        int[] r21 = new int[2];
        r21[r19 ? 1 : 0] = r10;
        r21[0] = r9;
        double[][] r22 = (double[][]) Array.newInstance(Double.TYPE, r21);
        int r23 = 0;
    L33:
        if (r23 >= r9) goto L38;
        PolynomialSplineFunction r24 = r110[r23];
        boolean r111 = r4;
        int r25 = 0;
    L35:
        if (r25 >= r10) goto L37;
        r22[r23][r25] = r24.value(r30[r25]);
        r25 = r25 + 1;
        goto L35
    L37:
        r23 = r23 + 1;
        r4 = r111;
        goto L33
    L38:
        boolean r112 = r4;
        int[] r2 = new int[2];
        r2[r19 ? 1 : 0] = r10;
        r2[r112 ? 1 : 0] = r9;
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, r2);
        int r3 = 0;
    L39:
        if (r3 >= r10) goto L44;
        UnivariateRealFunction r26 = r13[r3].derivative();
        int r27 = 0;
    L41:
        if (r27 >= r9) goto L43;
        int r28 = r3;
        r1[r27][r28] = r26.value(r29[r27]);
        r27 = r27 + 1;
        r1 = r1;
        r3 = r28;
        goto L41
    L43:
        r3 = r3 + 1;
        goto L39
    L44:
        double[][] r113 = r1;
        int[] r32 = new int[2];
        r32[r19 ? 1 : 0] = r10;
        r32[r112 ? 1 : 0] = r9;
        double[][] r33 = (double[][]) Array.newInstance(Double.TYPE, r32);
        int r34 = 0;
    L45:
        if (r34 >= r9) goto L50;
        UnivariateRealFunction r35 = r110[r34].derivative();
        int r36 = 0;
    L47:
        if (r36 >= r10) goto L49;
        int r210 = r36;
        r33[r34][r210] = r35.value(r30[r210]);
        r36 = r210 + 1;
        goto L47
    L49:
        r34 = r34 + 1;
        goto L45
    L50:
        int[] r37 = new int[2];
        r37[r19 ? 1 : 0] = r10;
        r37[r112 ? 1 : 0] = r9;
        double[][] r38 = (double[][]) Array.newInstance(Double.TYPE, r37);
        int r39 = 0;
    L51:
        if (r39 >= r9) goto L57;
        int r40 = nextIndex(r39, r9);
        int r41 = previousIndex(r39);
        int r42 = 0;
    L53:
        if (r42 >= r10) goto L55;
        int r114 = nextIndex(r42, r10);
        int r115 = previousIndex(r42);
        r38[r39][r42] = (((r22[r40][r114] - r22[r40][r115]) - r22[r41][r114]) + r22[r41][r115]) / ((r29[r40] - r29[r41]) * (r30[r114] - r30[r115]));
        r42 = r42 + 1;
        goto L53
    L55:
        r39 = r39 + 1;
        goto L51
    L57:
        return new BicubicSplineInterpolatingFunction(r29, r30, r22, r113, r33, r38);
    L59:
        throw new DimensionMismatchException(r29.length, r31.length);
    L61:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NO_DATA, new Object[0]);
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
