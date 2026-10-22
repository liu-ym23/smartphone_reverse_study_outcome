package org.apache.commons.math.linear;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface BigMatrix extends AnyMatrix {
    BigMatrix add(BigMatrix r1) throws IllegalArgumentException;

    BigMatrix copy();

    BigDecimal[] getColumn(int r1) throws MatrixIndexException;

    double[] getColumnAsDoubleArray(int r1) throws MatrixIndexException;

    BigMatrix getColumnMatrix(int r1) throws MatrixIndexException;

    BigDecimal[][] getData();

    double[][] getDataAsDoubleArray();

    BigDecimal getDeterminant() throws InvalidMatrixException;

    BigDecimal getEntry(int r1, int r2) throws MatrixIndexException;

    double getEntryAsDouble(int r1, int r2) throws MatrixIndexException;

    BigDecimal getNorm();

    int getRoundingMode();

    BigDecimal[] getRow(int r1) throws MatrixIndexException;

    double[] getRowAsDoubleArray(int r1) throws MatrixIndexException;

    BigMatrix getRowMatrix(int r1) throws MatrixIndexException;

    BigMatrix getSubMatrix(int r1, int r2, int r3, int r4) throws MatrixIndexException;

    BigMatrix getSubMatrix(int[] r1, int[] r2) throws MatrixIndexException;

    BigDecimal getTrace();

    BigMatrix inverse() throws InvalidMatrixException;

    BigMatrix multiply(BigMatrix r1) throws IllegalArgumentException;

    BigDecimal[] operate(BigDecimal[] r1) throws IllegalArgumentException;

    BigMatrix preMultiply(BigMatrix r1) throws IllegalArgumentException;

    BigDecimal[] preMultiply(BigDecimal[] r1) throws IllegalArgumentException;

    BigMatrix scalarAdd(BigDecimal r1);

    BigMatrix scalarMultiply(BigDecimal r1);

    BigMatrix solve(BigMatrix r1) throws IllegalArgumentException, InvalidMatrixException;

    BigDecimal[] solve(BigDecimal[] r1) throws IllegalArgumentException, InvalidMatrixException;

    BigMatrix subtract(BigMatrix r1) throws IllegalArgumentException;

    BigMatrix transpose();
}
