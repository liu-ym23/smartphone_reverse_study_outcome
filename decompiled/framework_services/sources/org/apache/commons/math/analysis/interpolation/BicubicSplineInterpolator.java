package org.apache.commons.math.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math.DimensionMismatchException;
import org.apache.commons.math.MathException;
import org.apache.commons.math.analysis.BivariateRealFunction;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math.exception.NoDataException;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BicubicSplineInterpolator implements BivariateRealGridInterpolator {
    public BicubicSplineInterpolator() {
    }

    @Override // org.apache.commons.math.analysis.interpolation.BivariateRealGridInterpolator
    public /* bridge */ /* synthetic */ BivariateRealFunction interpolate(double[] r1, double[] r2, double[][] r3) throws MathException {
        return interpolate(r1, r2, r3);
    }

    @Override // org.apache.commons.math.analysis.interpolation.BivariateRealGridInterpolator
    public BicubicSplineInterpolatingFunction interpolate(double[] r28, double[] r29, double[][] r30) throws MathException, IllegalArgumentException {
        if (r28.length == 0) goto L50;
        if (r29.length == 0) goto L50;
        if (r30.length == 0) goto L50;
        if (r28.length != r30.length) goto L48;
        MathUtils.checkOrder(r28);
        MathUtils.checkOrder(r29);
        int r8 = r28.length;
        int r9 = r29.length;
        boolean r6 = true;
        boolean r7 = false;
        double[][] r10 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r9, r8});
        int r5 = 0;
    L11:
        if (r5 >= r8) goto L20;
        if (r30[r5].length != r9) goto L19;
        int r11 = 0;
    L15:
        if (r11 >= r9) goto L17;
        r10[r11][r5] = r30[r5][r11];
        r11 = r11 + 1;
        goto L15
    L17:
        r5 = r5 + 1;
        goto L11
    L19:
        throw new DimensionMismatchException(r30[r5].length, r9);
    L20:
        SplineInterpolator r12 = new SplineInterpolator();
        PolynomialSplineFunction[] r13 = new PolynomialSplineFunction[r9];
        int r14 = 0;
    L21:
        if (r14 >= r9) goto L23;
        r13[r14] = r12.interpolate(r28, r10[r14]);
        r14 = r14 + 1;
        goto L21
    L23:
        PolynomialSplineFunction[] r15 = new PolynomialSplineFunction[r8];
        int r16 = 0;
    L24:
        if (r16 >= r8) goto L26;
        r15[r16] = r12.interpolate(r29, r30[r16]);
        r16 = r16 + 1;
        goto L24
    L26:
        double[][] r17 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r8, r9});
        int r18 = 0;
    L27:
        if (r18 >= r9) goto L32;
        UnivariateRealFunction r19 = r13[r18].derivative();
        boolean r110 = r6;
        int r20 = 0;
    L29:
        if (r20 >= r8) goto L31;
        r17[r20][r18] = r19.value(r28[r20]);
        r20 = r20 + 1;
        r8 = r8;
        r7 = r7;
        goto L29
    L31:
        r18 = r18 + 1;
        r6 = r110;
        goto L27
    L32:
        boolean r111 = r6;
        boolean r112 = r7;
        int r113 = r8;
        int[] r21 = new int[2];
        r21[r111 ? 1 : 0] = r9;
        r21[r112 ? 1 : 0] = r113;
        double[][] r22 = (double[][]) Array.newInstance(Double.TYPE, r21);
        int r23 = 0;
    L33:
        int r24 = r113;
        if (r23 >= r24) goto L39;
        UnivariateRealFunction r114 = r15[r23].derivative();
        int r115 = 0;
    L36:
        if (r115 >= r9) goto L38;
        r22[r23][r115] = r114.value(r29[r115]);
        r115 = r115 + 1;
        goto L36
    L38:
        r23 = r23 + 1;
        r113 = r24;
        goto L33
    L39:
        int[] r1 = new int[2];
        r1[r111 ? 1 : 0] = r9;
        r1[r112 ? 1 : 0] = r24;
        double[][] r25 = (double[][]) Array.newInstance(Double.TYPE, r1);
        int r2 = 0;
    L40:
        if (r2 >= r24) goto L46;
        int r3 = nextIndex(r2, r24);
        int r116 = previousIndex(r2);
        int r117 = 0;
    L42:
        if (r117 >= r9) goto L44;
        int r118 = nextIndex(r117, r9);
        int r119 = previousIndex(r117);
        r25[r2][r117] = (((r30[r3][r118] - r30[r3][r119]) - r30[r116][r118]) + r30[r116][r119]) / ((r28[r3] - r28[r116]) * (r29[r118] - r29[r119]));
        r117 = r117 + 1;
        goto L42
    L44:
        r2 = r2 + 1;
        goto L40
    L46:
        return new BicubicSplineInterpolatingFunction(r28, r29, r30, r17, r22, r25);
    L48:
        throw new DimensionMismatchException(r28.length, r30.length);
    L50:
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
