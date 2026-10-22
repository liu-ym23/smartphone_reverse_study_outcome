package org.apache.commons.math.linear;

import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;

/* JADX INFO: loaded from: classes3.dex */
public interface FieldMatrix<T extends FieldElement<T>> extends AnyMatrix {
    FieldMatrix<T> add(FieldMatrix<T> r1) throws IllegalArgumentException;

    void addToEntry(int r1, int r2, T r3) throws MatrixIndexException;

    FieldMatrix<T> copy();

    void copySubMatrix(int r1, int r2, int r3, int r4, T[][] r5) throws MatrixIndexException, IllegalArgumentException;

    void copySubMatrix(int[] r1, int[] r2, T[][] r3) throws MatrixIndexException, IllegalArgumentException;

    FieldMatrix<T> createMatrix(int r1, int r2);

    T[] getColumn(int r1) throws MatrixIndexException;

    FieldMatrix<T> getColumnMatrix(int r1) throws MatrixIndexException;

    FieldVector<T> getColumnVector(int r1) throws MatrixIndexException;

    T[][] getData();

    T getEntry(int r1, int r2) throws MatrixIndexException;

    Field<T> getField();

    T[] getRow(int r1) throws MatrixIndexException;

    FieldMatrix<T> getRowMatrix(int r1) throws MatrixIndexException;

    FieldVector<T> getRowVector(int r1) throws MatrixIndexException;

    FieldMatrix<T> getSubMatrix(int r1, int r2, int r3, int r4) throws MatrixIndexException;

    FieldMatrix<T> getSubMatrix(int[] r1, int[] r2) throws MatrixIndexException;

    T getTrace() throws NonSquareMatrixException;

    FieldMatrix<T> multiply(FieldMatrix<T> r1) throws IllegalArgumentException;

    void multiplyEntry(int r1, int r2, T r3) throws MatrixIndexException;

    FieldVector<T> operate(FieldVector<T> r1) throws IllegalArgumentException;

    T[] operate(T[] r1) throws IllegalArgumentException;

    FieldMatrix<T> preMultiply(FieldMatrix<T> r1) throws IllegalArgumentException;

    FieldVector<T> preMultiply(FieldVector<T> r1) throws IllegalArgumentException;

    T[] preMultiply(T[] r1) throws IllegalArgumentException;

    FieldMatrix<T> scalarAdd(T r1);

    FieldMatrix<T> scalarMultiply(T r1);

    void setColumn(int r1, T[] r2) throws MatrixIndexException, InvalidMatrixException;

    void setColumnMatrix(int r1, FieldMatrix<T> r2) throws MatrixIndexException, InvalidMatrixException;

    void setColumnVector(int r1, FieldVector<T> r2) throws MatrixIndexException, InvalidMatrixException;

    void setEntry(int r1, int r2, T r3) throws MatrixIndexException;

    void setRow(int r1, T[] r2) throws MatrixIndexException, InvalidMatrixException;

    void setRowMatrix(int r1, FieldMatrix<T> r2) throws MatrixIndexException, InvalidMatrixException;

    void setRowVector(int r1, FieldVector<T> r2) throws MatrixIndexException, InvalidMatrixException;

    void setSubMatrix(T[][] r1, int r2, int r3) throws MatrixIndexException;

    FieldMatrix<T> subtract(FieldMatrix<T> r1) throws IllegalArgumentException;

    FieldMatrix<T> transpose();

    T walkInColumnOrder(FieldMatrixChangingVisitor<T> r1) throws MatrixVisitorException;

    T walkInColumnOrder(FieldMatrixChangingVisitor<T> r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r1) throws MatrixVisitorException;

    T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r1) throws MatrixVisitorException;

    T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r1) throws MatrixVisitorException;

    T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    T walkInRowOrder(FieldMatrixChangingVisitor<T> r1) throws MatrixVisitorException;

    T walkInRowOrder(FieldMatrixChangingVisitor<T> r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;

    T walkInRowOrder(FieldMatrixPreservingVisitor<T> r1) throws MatrixVisitorException;

    T walkInRowOrder(FieldMatrixPreservingVisitor<T> r1, int r2, int r3, int r4, int r5) throws MatrixIndexException, MatrixVisitorException;
}
