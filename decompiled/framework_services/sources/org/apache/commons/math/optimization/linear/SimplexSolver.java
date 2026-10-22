package org.apache.commons.math.optimization.linear;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SimplexSolver extends AbstractLinearOptimizer {
    private static final double DEFAULT_EPSILON = 1.0E-6d;
    protected final double epsilon;

    public SimplexSolver() {
        this(1.0E-6d);
    }

    public SimplexSolver(double epsilon) {
        this.epsilon = epsilon;
    }

    private Integer getPivotColumn(SimplexTableau tableau) {
        Integer minPos = null;
        int i = tableau.getNumObjectiveFunctions();
        double minValue = 0.0d;
    L4:
        if (i >= (tableau.getWidth() - 1)) goto L10;
        if (MathUtils.compareTo(tableau.getEntry(0, i), minValue, this.epsilon) >= 0) goto L8;
        double minValue2 = tableau.getEntry(0, i);
        minPos = Integer.valueOf(i);
        minValue = minValue2;
    L8:
        i = i + 1;
        goto L4
    L10:
        return minPos;
    }

    private Integer getPivotRow(SimplexTableau tableau, int col) {
        List<Integer> minRatioPositions = new ArrayList();
        int i = tableau.getNumObjectiveFunctions();
        double minRatio = Double.MAX_VALUE;
    L4:
        if (i >= tableau.getHeight()) goto L15;
        double rhs = tableau.getEntry(i, tableau.getWidth() - 1);
        double entry = tableau.getEntry(i, col);
        if (MathUtils.compareTo(entry, 0.0d, this.epsilon) <= 0) goto L13;
        double ratio = rhs / entry;
        if (MathUtils.equals(ratio, minRatio, this.epsilon) == false) goto L11;
        minRatioPositions.add(Integer.valueOf(i));
        goto L13
    L11:
        if (ratio >= minRatio) goto L13;
        minRatio = ratio;
        List<Integer> minRatioPositions2 = new ArrayList();
        minRatioPositions2.add(Integer.valueOf(i));
        minRatioPositions = minRatioPositions2;
    L13:
        i = i + 1;
        goto L4
    L15:
        if (minRatioPositions.size() != 0) goto L19;
        return null;
    L19:
        if (minRatioPositions.size() <= 1) goto L34;
        Iterator<Integer> r3 = minRatioPositions.iterator();
    L22:
        if (r3.hasNext() == false) goto L34;
        Integer row = r3.next();
        int i2 = 0;
    L25:
        if (i2 >= tableau.getNumArtificialVariables()) goto L22;
        int column = tableau.getArtificialVariableOffset() + i2;
        if (MathUtils.equals(tableau.getEntry(row.intValue(), column), 1.0d, this.epsilon) == false) goto L31;
        if (row.equals(tableau.getBasicRow(column)) == false) goto L31;
        return row;
    L31:
        i2 = i2 + 1;
    L34:
        return minRatioPositions.get(0);
    }

    protected void doIteration(SimplexTableau tableau) throws OptimizationException {
        incrementIterationsCounter();
        Integer pivotCol = getPivotColumn(tableau);
        Integer pivotRow = getPivotRow(tableau, pivotCol.intValue());
        if (pivotRow == null) goto L14;
        double pivotVal = tableau.getEntry(pivotRow.intValue(), pivotCol.intValue());
        tableau.divideRow(pivotRow.intValue(), pivotVal);
        int i = 0;
    L6:
        if (i >= tableau.getHeight()) goto L12;
        if (i == pivotRow.intValue()) goto L10;
        double multiplier = tableau.getEntry(i, pivotCol.intValue());
        tableau.subtractRow(i, pivotRow.intValue(), multiplier);
    L10:
        i = i + 1;
        goto L6
    L12:
        return;
    L14:
        throw new UnboundedSolutionException();
    }

    protected void solvePhase1(SimplexTableau tableau) throws OptimizationException {
        if (tableau.getNumArtificialVariables() != 0) goto L6;
        return;
    L6:
        if (tableau.isOptimal() == true) goto L9;
        doIteration(tableau);
        goto L6
    L9:
        if (MathUtils.equals(tableau.getEntry(0, tableau.getRhsOffset()), 0.0d, this.epsilon) == false) goto L12;
        return;
    L12:
        throw new NoFeasibleSolutionException();
    }

    @Override // org.apache.commons.math.optimization.linear.AbstractLinearOptimizer
    public RealPointValuePair doOptimize() throws OptimizationException {
        SimplexTableau tableau = new SimplexTableau(this.function, this.linearConstraints, this.goal, this.nonNegative, this.epsilon);
        solvePhase1(tableau);
        tableau.dropPhase1Objective();
    L4:
        if (tableau.isOptimal() == true) goto L7;
        doIteration(tableau);
        goto L4
    L7:
        return tableau.getSolution();
    }
}
