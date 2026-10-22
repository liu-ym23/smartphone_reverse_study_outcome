package org.apache.commons.math.linear;

/* JADX INFO: loaded from: classes3.dex */
public interface RealMatrix extends AnyMatrix {
    RealMatrix add(RealMatrix r1) throws IllegalArgumentException;

    void addToEntry(int r1, int r2, double r3) throws MatrixIndexException;

    RealMatrix copy();

    void copySubMatrix(int r1, int r2, int r3, int r4, double[][] r5) throws MatrixIndexException, IllegalArgumentException;

    void copySubMatrix(int[] r1, int[] r2, double[][] r3) throws MatrixIndexException, IllegalArgumentException;

    RealMatrix createMatrix(int r1, int r2);

    double[] getColumn(int r1) throws MatrixIndexException;

    RealMatrix getColumnMatrix(int r1) throws MatrixIndexException;

    RealVector getColumnVector(int r1) throws MatrixIndexException;

    double[][] getData();

    @Deprecated
    double getDeterminant();

    double getEntry(int r1, int r2) throws MatrixIndexException;

    double getFrobeniusNorm();

    double getNorm();

    double[] getRow(int r1) throws MatrixIndexException;

    RealMatrix getRowMatrix(int r1) throws MatrixIndexException;

    RealVector getRowVector(int r1) throws MatrixIndexException;

    RealMatrix getSubMatrix(int r1, int r2, int r3, int r4) throws MatrixIndexException;

    RealMatrix getSubMatrix(int[] r1, int[] r2) throws MatrixIndexException;

    double getTrace() throws NonSquareMatrixException;

    @Deprecated
    RealMatrix inverse() throws InvalidMatrixException;

    @Deprecated
    boolean isSingular();

    RealMatrix multiply(RealMatrix r1) throws IllegalArgumentException;

    void multiplyEntry(int r1, int r2, double r3) throws MatrixIndexException;

    RealVector operate(RealVector r1) throws IllegalArgumentException;

    double[] operate(double[] r1) throws IllegalArgumentException;

    RealMatrix preMultiply(RealMatrix r1) throws IllegalArgumentException;

    RealVector preMultiply(RealVector r1) throws IllegalArgumentException;

    double[] preMultiply(double[] r1) throws IllegalArgumentException;

    RealMatrix scalarAdd(double r1);

    RealMatrix scalarMultiply(double r1);

    void setColumn(int r1, double[] r2) throws MatrixIndexException, InvalidMatrixException;

    void setColumnMatrix(int r1, RealMatrix r2) throws MatrixIndexException, InvalidMatrixException;

    void setColumnVector(int r1, RealVector r2) throws MatrixIndexException, InvalidMatrixException;

    void setEntry(int r1, int r2, double r3) throws MatrixIndexException;

    void setRow(int r1, double[] r2) throws MatrixIndexException, InvalidMatrixException;

    void setRowMatrix(int r1, RealMatrix r2) throws MatrixIndexException, InvalidMatrixException;

    void setRowVector(int r1, RealVector r2) throws MatrixIndexException, InvalidMatrixException;

    void setSubMatrix(double[][] r1, int r2, int r3) throws MatrixIndexException;

    @Deprecated
    RealMatrix solve(RealMatrix r1) throws IllegalArgumentException, InvalidMatrixException;

    @Deprecated
    double[] solve(double[] r1) throws IllegalArgumentException, InvalidMatrixException;

    RealMatrix subtract(RealMatrix r1) throws IllegalArgumentException;

    RealMatrix transpose();

    double walkInColumnOrder(RealMatrixChangingVisitor r1) throws MatrixVisitorException;

    double walkInColumnOrder(RealMatrixChangingVisitor r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    double walkInColumnOrder(RealMatrixPreservingVisitor r1) throws MatrixVisitorException;

    double walkInColumnOrder(RealMatrixPreservingVisitor r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    double walkInOptimizedOrder(RealMatrixChangingVisitor r1) throws MatrixVisitorException;

    double walkInOptimizedOrder(RealMatrixChangingVisitor r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    double walkInOptimizedOrder(RealMatrixPreservingVisitor r1) throws MatrixVisitorException;

    double walkInOptimizedOrder(RealMatrixPreservingVisitor r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    double walkInRowOrder(RealMatrixChangingVisitor r1) throws MatrixVisitorException;

    double walkInRowOrder(RealMatrixChangingVisitor r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    double walkInRowOrder(RealMatrixPreservingVisitor r1) throws MatrixVisitorException;

    double walkInRowOrder(RealMatrixPreservingVisitor r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;
}
