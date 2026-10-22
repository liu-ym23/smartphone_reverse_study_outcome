package org.apache.commons.math.optimization.linear;

import com.android.server.wm.ActivityTaskManagerService;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
class SimplexTableau implements Serializable {
    private static final String NEGATIVE_VAR_COLUMN_LABEL = "x-";
    private static final long serialVersionUID = -1369660067587938365L;
    private final List<String> columnLabels;
    private final List<LinearConstraint> constraints;
    private final double epsilon;
    private final LinearObjectiveFunction f;
    private int numArtificialVariables;
    private final int numDecisionVariables;
    private final int numSlackVariables;
    private final boolean restrictToNonNegative;
    private transient RealMatrix tableau;

    SimplexTableau(LinearObjectiveFunction r3, Collection<LinearConstraint> r4, GoalType r5, boolean r6, double r7) {
        this.columnLabels = new ArrayList();
        this.f = r3;
        this.constraints = normalizeConstraints(r4);
        this.restrictToNonNegative = r6;
        this.epsilon = r7;
        this.numDecisionVariables = r3.getCoefficients().getDimension() + (!r6 ? 1 : 0);
        this.numSlackVariables = getConstraintTypeCounts(Relationship.LEQ) + getConstraintTypeCounts(Relationship.GEQ);
        this.numArtificialVariables = getConstraintTypeCounts(Relationship.EQ) + getConstraintTypeCounts(Relationship.GEQ);
        if (r5 != GoalType.MAXIMIZE) goto L5;
        boolean r0 = true;
    L6:
        this.tableau = createTableau(r0);
        initializeColumnLabels();
        return;
    L5:
        r0 = false;
        goto L6
    }

    protected void initializeColumnLabels() {
        if (getNumObjectiveFunctions() != 2) goto L5;
        this.columnLabels.add("W");
    L5:
        this.columnLabels.add("Z");
        int i = 0;
    L7:
        if (i >= getOriginalNumDecisionVariables()) goto L10;
        this.columnLabels.add("x" + i);
        i = i + 1;
        goto L7
    L10:
        if (this.restrictToNonNegative == true) goto L12;
        this.columnLabels.add(NEGATIVE_VAR_COLUMN_LABEL);
    L12:
        int i2 = 0;
    L14:
        if (i2 >= getNumSlackVariables()) goto L16;
        this.columnLabels.add("s" + i2);
        i2 = i2 + 1;
        goto L14
    L16:
        int i3 = 0;
    L18:
        if (i3 >= getNumArtificialVariables()) goto L20;
        this.columnLabels.add(ActivityTaskManagerService.DUMP_ACTIVITIES_SHORT_CMD + i3);
        i3 = i3 + 1;
        goto L18
    L20:
        this.columnLabels.add("RHS");
    }

    protected RealMatrix createTableau(boolean maximize) {
        boolean r2 = true;
        int width = (((this.numDecisionVariables + this.numSlackVariables) + this.numArtificialVariables) + getNumObjectiveFunctions()) + 1;
        int height = this.constraints.size() + getNumObjectiveFunctions();
        Array2DRowRealMatrix matrix = new Array2DRowRealMatrix(height, width);
        if (getNumObjectiveFunctions() != 2) goto L6;
        matrix.setEntry(0, 0, -1.0d);
    L6:
        if (getNumObjectiveFunctions() != 1) goto L8;
        int zIndex = 0;
    L9:
        double r10 = 1.0d;
        if (maximize == false) goto L12;
        double r12 = 1.0d;
    L13:
        matrix.setEntry(zIndex, zIndex, r12);
        RealVector objectiveCoefficients = this.f.getCoefficients();
        if (maximize == false) goto L16;
        objectiveCoefficients = objectiveCoefficients.mapMultiply(-1.0d);
    L16:
        copyArray(objectiveCoefficients.getData(), matrix.getDataRef()[zIndex]);
        int r13 = width - 1;
        double r14 = this.f.getConstantTerm();
        if (maximize == true) goto L20;
        r14 = r14 * (-1.0d);
    L20:
        matrix.setEntry(zIndex, r13, r14);
        if (this.restrictToNonNegative == true) goto L23;
        matrix.setEntry(zIndex, getSlackVariableOffset() - 1, getInvertedCoeffiecientSum(objectiveCoefficients));
    L23:
        int slackVar = 0;
        int artificialVar = 0;
        int i = 0;
    L25:
        if (i >= this.constraints.size()) goto L45;
        LinearConstraint constraint = this.constraints.get(i);
        boolean r17 = r2;
        int row = getNumObjectiveFunctions() + i;
        copyArray(constraint.getCoefficients().getData(), matrix.getDataRef()[row]);
        if (this.restrictToNonNegative == true) goto L29;
        matrix.setEntry(row, getSlackVariableOffset() - 1, getInvertedCoeffiecientSum(constraint.getCoefficients()));
    L29:
        matrix.setEntry(row, width - 1, constraint.getValue());
        if (constraint.getRelationship() != Relationship.LEQ) goto L33;
        matrix.setEntry(row, getSlackVariableOffset() + slackVar, r10);
        slackVar = slackVar + 1;
    L37:
        if (constraint.getRelationship() != Relationship.EQ) goto L39;
    L42:
        boolean r8 = false;
        r10 = 1.0d;
        matrix.setEntry(0, getArtificialVariableOffset() + artificialVar, 1.0d);
        matrix.setEntry(row, getArtificialVariableOffset() + artificialVar, 1.0d);
        matrix.setRowVector(0, matrix.getRowVector(0).subtract(matrix.getRowVector(row)));
        artificialVar = artificialVar + 1;
    L43:
        i = i + 1;
        r2 = r17;
        goto L25
    L39:
        if (constraint.getRelationship() == Relationship.GEQ) goto L42;
        r8 = false;
        r10 = 1.0d;
        goto L43
    L33:
        if (constraint.getRelationship() != Relationship.GEQ) goto L37;
        matrix.setEntry(row, getSlackVariableOffset() + slackVar, -1.0d);
        slackVar = slackVar + 1;
        goto L37
    L45:
        return matrix;
    L12:
        r12 = -1.0d;
        goto L13
    L8:
        zIndex = 1;
        goto L9
    }

    public List<LinearConstraint> normalizeConstraints(Collection<LinearConstraint> originalConstraints) {
        List<LinearConstraint> normalized = new ArrayList();
        Iterator<LinearConstraint> r1 = originalConstraints.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        LinearConstraint constraint = r1.next();
        normalized.add(normalize(constraint));
        goto L4
    L6:
        return normalized;
    }

    private LinearConstraint normalize(LinearConstraint constraint) {
        if (constraint.getValue() >= 0.0d) goto L7;
        return new LinearConstraint(constraint.getCoefficients().mapMultiply(-1.0d), constraint.getRelationship().oppositeRelationship(), constraint.getValue() * (-1.0d));
    L7:
        return new LinearConstraint(constraint.getCoefficients(), constraint.getRelationship(), constraint.getValue());
    }

    protected final int getNumObjectiveFunctions() {
        if (this.numArtificialVariables <= 0) goto L5;
        return 2;
    L5:
        return 1;
    }

    private int getConstraintTypeCounts(Relationship relationship) {
        int count = 0;
        Iterator<LinearConstraint> r1 = this.constraints.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        LinearConstraint constraint = r1.next();
        if (constraint.getRelationship() != relationship) goto L4;
        count = count + 1;
        goto L4
    L9:
        return count;
    }

    protected static double getInvertedCoeffiecientSum(RealVector coefficients) {
        double sum = 0.0d;
        double[] r2 = coefficients.getData();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        double coefficient = r2[r4];
        sum = sum - coefficient;
        r4 = r4 + 1;
        goto L3
    L5:
        return sum;
    }

    protected Integer getBasicRow(int col) {
        Integer row = null;
        int i = 0;
    L4:
        if (i >= getHeight()) goto L15;
        if (MathUtils.equals(getEntry(i, col), 1.0d, this.epsilon) == false) goto L10;
        if (row != null) goto L10;
        row = Integer.valueOf(i);
    L13:
        i = i + 1;
    L10:
        if (MathUtils.equals(getEntry(i, col), 0.0d, this.epsilon) == true) goto L13;
        return null;
    L15:
        return row;
    }

    protected void dropPhase1Objective() {
        if (getNumObjectiveFunctions() != 1) goto L5;
        return;
    L5:
        List<Integer> columnsToDrop = new ArrayList();
        columnsToDrop.add(0);
        int i = getNumObjectiveFunctions();
    L7:
        if (i >= getArtificialVariableOffset()) goto L12;
        if (MathUtils.compareTo(this.tableau.getEntry(0, i), 0.0d, this.epsilon) <= 0) goto L11;
        columnsToDrop.add(Integer.valueOf(i));
    L11:
        i = i + 1;
        goto L7
    L12:
        int i2 = 0;
    L14:
        if (i2 >= getNumArtificialVariables()) goto L19;
        int col = getArtificialVariableOffset() + i2;
        if (getBasicRow(col) != null) goto L18;
        columnsToDrop.add(Integer.valueOf(col));
    L18:
        i2 = i2 + 1;
        goto L14
    L19:
        int i3 = getHeight();
        double[][] matrix = (double[][]) Array.newInstance(Double.TYPE, new int[]{i3 - 1, getWidth() - columnsToDrop.size()});
        int i4 = 1;
    L21:
        if (i4 >= getHeight()) goto L30;
        int col2 = 0;
        int j = 0;
    L24:
        if (j >= getWidth()) goto L29;
        if (columnsToDrop.contains(Integer.valueOf(j)) == true) goto L28;
        matrix[i4 - 1][col2] = this.tableau.getEntry(i4, j);
        col2 = col2 + 1;
    L28:
        j = j + 1;
        goto L24
    L29:
        i4 = i4 + 1;
        goto L21
    L30:
        int i5 = columnsToDrop.size();
        int i6 = i5 - 1;
    L31:
        if (i6 < 0) goto L33;
        this.columnLabels.remove(columnsToDrop.get(i6).intValue());
        i6 = i6 - 1;
        goto L31
    L33:
        this.tableau = new Array2DRowRealMatrix(matrix);
        this.numArtificialVariables = 0;
    }

    private void copyArray(double[] src, double[] dest) {
        System.arraycopy(src, 0, dest, getNumObjectiveFunctions(), src.length);
    }

    boolean isOptimal() {
        int i = getNumObjectiveFunctions();
    L4:
        if (i >= (getWidth() - 1)) goto L10;
        if (MathUtils.compareTo(this.tableau.getEntry(0, i), 0.0d, this.epsilon) < 0) goto L7;
        i = i + 1;
        goto L4
    L7:
        return false;
    L10:
        return true;
    }

    protected RealPointValuePair getSolution() {
        int negativeVarColumn = this.columnLabels.indexOf(NEGATIVE_VAR_COLUMN_LABEL);
        if (negativeVarColumn <= 0) goto L5;
        Integer negativeVarBasicRow = getBasicRow(negativeVarColumn);
    L7:
        if (negativeVarBasicRow != null) goto L9;
        double mostNegative = 0.0d;
    L10:
        Set<Integer> basicRows = new HashSet();
        double[] coefficients = new double[getOriginalNumDecisionVariables()];
        int i = 0;
    L12:
        if (i >= coefficients.length) goto L30;
        int colIndex = this.columnLabels.indexOf("x" + i);
        if (colIndex >= 0) goto L16;
        coefficients[i] = 0.0d;
    L28:
        i = i + 1;
        goto L12
    L16:
        Integer basicRow = getBasicRow(colIndex);
        if (basicRows.contains(basicRow) == false) goto L19;
        coefficients[i] = 0.0d;
        goto L28
    L19:
        basicRows.add(basicRow);
        if (basicRow != null) goto L22;
        double r11 = 0.0d;
    L24:
        if (this.restrictToNonNegative == false) goto L26;
        double r13 = 0.0d;
    L27:
        coefficients[i] = r11 - r13;
        goto L28
    L26:
        r13 = mostNegative;
        goto L27
    L22:
        r11 = getEntry(basicRow.intValue(), getRhsOffset());
        goto L24
    L30:
        return new RealPointValuePair(coefficients, this.f.getValue(coefficients));
    L9:
        mostNegative = getEntry(negativeVarBasicRow.intValue(), getRhsOffset());
        goto L10
    L5:
        negativeVarBasicRow = null;
        goto L7
    }

    protected void divideRow(int dividendRow, double divisor) {
        int j = 0;
    L4:
        if (j >= getWidth()) goto L7;
        this.tableau.setEntry(dividendRow, j, this.tableau.getEntry(dividendRow, j) / divisor);
        j = j + 1;
        goto L4
    }

    protected void subtractRow(int minuendRow, int subtrahendRow, double multiple) {
        this.tableau.setRowVector(minuendRow, this.tableau.getRowVector(minuendRow).subtract(this.tableau.getRowVector(subtrahendRow).mapMultiply(multiple)));
    }

    protected final int getWidth() {
        return this.tableau.getColumnDimension();
    }

    protected final int getHeight() {
        return this.tableau.getRowDimension();
    }

    protected final double getEntry(int row, int column) {
        return this.tableau.getEntry(row, column);
    }

    protected final void setEntry(int row, int column, double value) {
        this.tableau.setEntry(row, column, value);
    }

    protected final int getSlackVariableOffset() {
        return getNumObjectiveFunctions() + this.numDecisionVariables;
    }

    protected final int getArtificialVariableOffset() {
        return (getNumObjectiveFunctions() + this.numDecisionVariables) + this.numSlackVariables;
    }

    protected final int getRhsOffset() {
        return getWidth() - 1;
    }

    protected final int getNumDecisionVariables() {
        return this.numDecisionVariables;
    }

    protected final int getOriginalNumDecisionVariables() {
        return this.f.getCoefficients().getDimension();
    }

    protected final int getNumSlackVariables() {
        return this.numSlackVariables;
    }

    protected final int getNumArtificialVariables() {
        return this.numArtificialVariables;
    }

    protected final double[][] getData() {
        return this.tableau.getData();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof SimplexTableau) == false) goto L26;
        SimplexTableau rhs = (SimplexTableau) other;
        if (this.restrictToNonNegative != rhs.restrictToNonNegative) goto L25;
        if (this.numDecisionVariables != rhs.numDecisionVariables) goto L25;
        if (this.numSlackVariables != rhs.numSlackVariables) goto L25;
        if (this.numArtificialVariables != rhs.numArtificialVariables) goto L25;
        if (this.epsilon != rhs.epsilon) goto L25;
        if (this.f.equals(rhs.f) == false) goto L25;
        if (this.constraints.equals(rhs.constraints) == false) goto L25;
        if (this.tableau.equals(rhs.tableau) == false) goto L25;
        return true;
    L25:
        return false;
    L26:
        return false;
    }

    public int hashCode() {
        return ((((((Boolean.valueOf(this.restrictToNonNegative).hashCode() ^ this.numDecisionVariables) ^ this.numSlackVariables) ^ this.numArtificialVariables) ^ Double.valueOf(this.epsilon).hashCode()) ^ this.f.hashCode()) ^ this.constraints.hashCode()) ^ this.tableau.hashCode();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        MatrixUtils.serializeRealMatrix(this.tableau, oos);
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        MatrixUtils.deserializeRealMatrix(this, "tableau", ois);
    }
}
