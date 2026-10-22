package org.apache.commons.math.ode.nonstiff;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math.fraction.BigFraction;
import org.apache.commons.math.linear.Array2DRowFieldMatrix;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.FieldDecompositionSolver;
import org.apache.commons.math.linear.FieldLUDecompositionImpl;
import org.apache.commons.math.linear.FieldMatrix;
import org.apache.commons.math.linear.MatrixUtils;

/* JADX INFO: loaded from: classes3.dex */
public class AdamsNordsieckTransformer {
    private static final Map<Integer, AdamsNordsieckTransformer> CACHE = null;
    private final double[] c1;
    private final Array2DRowRealMatrix initialization;
    private final Array2DRowRealMatrix update;

    static {
        CACHE = new HashMap();
    }

    private AdamsNordsieckTransformer(int nSteps) {
        FieldMatrix<BigFraction> bigP = buildP(nSteps);
        FieldDecompositionSolver<BigFraction> pSolver = new FieldLUDecompositionImpl(bigP).getSolver();
        BigFraction[] u = new BigFraction[nSteps];
        Arrays.fill(u, BigFraction.ONE);
        BigFraction[] bigC1 = (BigFraction[]) pSolver.solve(u);
        BigFraction[][] shiftedP = (BigFraction[][]) bigP.getData();
        int i = shiftedP.length - 1;
    L3:
        if (i <= 0) goto L5;
        shiftedP[i] = shiftedP[i - 1];
        i = i - 1;
        goto L3
    L5:
        shiftedP[0] = new BigFraction[nSteps];
        Arrays.fill(shiftedP[0], BigFraction.ZERO);
        FieldMatrix r5 = pSolver.solve(new Array2DRowFieldMatrix(shiftedP, false));
        final BigFraction r7 = BigFraction.ZERO;
        bigP.walkInOptimizedOrder(new AnonymousClass1(this, r7));
        FieldMatrix<BigFraction> bigRInverse = new FieldLUDecompositionImpl(bigP).getSolver().getInverse();
        this.initialization = MatrixUtils.bigFractionMatrixToRealMatrix(bigRInverse);
        this.update = MatrixUtils.bigFractionMatrixToRealMatrix(r5);
        this.c1 = new double[nSteps];
        int i2 = 0;
    L6:
        if (i2 >= nSteps) goto L9;
        this.c1[i2] = bigC1[i2].doubleValue();
        i2 = i2 + 1;
        goto L6
    }

    public static AdamsNordsieckTransformer getInstance(int nSteps) {
        Map<Integer, AdamsNordsieckTransformer> r0 = CACHE;
        monitor-enter(r0);
        AdamsNordsieckTransformer t = CACHE.get(Integer.valueOf(nSteps));     // Catch: Throwable -> L7
        if (t != null) goto L9;
        t = new AdamsNordsieckTransformer(nSteps);     // Catch: Throwable -> L7
        CACHE.put(Integer.valueOf(nSteps), t);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return t;
    L7:
        th = move-exception;
        throw th;
    }

    public int getNSteps() {
        return this.c1.length;
    }

    private FieldMatrix<BigFraction> buildP(int nSteps) {
        BigFraction[][] pData = (BigFraction[][]) Array.newInstance(BigFraction.class, new int[]{nSteps, nSteps});
        int i = 0;
    L4:
        if (i >= pData.length) goto L11;
        BigFraction[] pI = pData[i];
        int factor = -(i + 1);
        int aj = factor;
        int j = 0;
    L7:
        if (j >= pI.length) goto L9;
        pI[j] = new BigFraction((j + 2) * aj);
        aj = aj * factor;
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    L11:
        return new Array2DRowFieldMatrix(pData, false);
    }

    public Array2DRowRealMatrix initializeHighOrderDerivatives(double[] first, double[][] multistep) {
        int i = 0;
    L4:
        if (i >= multistep.length) goto L11;
        double[] msI = multistep[i];
        int j = 0;
    L7:
        if (j >= first.length) goto L9;
        msI[j] = msI[j] - first[j];
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    L11:
        return this.initialization.multiply(new Array2DRowRealMatrix(multistep, false));
    }

    public Array2DRowRealMatrix updateHighOrderDerivativesPhase1(Array2DRowRealMatrix highOrder) {
        return this.update.multiply(highOrder);
    }

    public void updateHighOrderDerivativesPhase2(double[] start, double[] end, Array2DRowRealMatrix highOrder) {
        double[][] data = highOrder.getDataRef();
        int i = 0;
    L4:
        if (i >= data.length) goto L11;
        double[] dataI = data[i];
        double c1I = this.c1[i];
        int j = 0;
    L7:
        if (j >= dataI.length) goto L9;
        dataI[j] = dataI[j] + ((start[j] - end[j]) * c1I);
        j = j + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    }
}
