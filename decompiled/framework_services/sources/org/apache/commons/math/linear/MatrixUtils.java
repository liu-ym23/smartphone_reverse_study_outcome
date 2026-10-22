package org.apache.commons.math.linear;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.fraction.BigFraction;
import org.apache.commons.math.fraction.Fraction;

/* JADX INFO: loaded from: classes3.dex */
public class MatrixUtils {

    private static class BigFractionMatrixConverter extends DefaultFieldMatrixPreservingVisitor<BigFraction> {
        private double[][] data;

        @Override // org.apache.commons.math.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math.linear.FieldMatrixPreservingVisitor
        public /* bridge */ /* synthetic */ void visit(int r1, int r2, FieldElement r3) throws MatrixVisitorException {
            visit(r1, r2, (BigFraction) r3);
        }

        public BigFractionMatrixConverter() {
            super(BigFraction.ZERO);
        }

        @Override // org.apache.commons.math.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math.linear.FieldMatrixPreservingVisitor
        public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
            this.data = (double[][]) Array.newInstance(Double.TYPE, new int[]{rows, columns});
        }

        public void visit(int row, int column, BigFraction value) {
            this.data[row][column] = value.doubleValue();
        }

        Array2DRowRealMatrix getConvertedMatrix() {
            return new Array2DRowRealMatrix(this.data, false);
        }
    }

    private static class FractionMatrixConverter extends DefaultFieldMatrixPreservingVisitor<Fraction> {
        private double[][] data;

        @Override // org.apache.commons.math.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math.linear.FieldMatrixPreservingVisitor
        public /* bridge */ /* synthetic */ void visit(int r1, int r2, FieldElement r3) throws MatrixVisitorException {
            visit(r1, r2, (Fraction) r3);
        }

        public FractionMatrixConverter() {
            super(Fraction.ZERO);
        }

        @Override // org.apache.commons.math.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math.linear.FieldMatrixPreservingVisitor
        public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
            this.data = (double[][]) Array.newInstance(Double.TYPE, new int[]{rows, columns});
        }

        public void visit(int row, int column, Fraction value) {
            this.data[row][column] = value.doubleValue();
        }

        Array2DRowRealMatrix getConvertedMatrix() {
            return new Array2DRowRealMatrix(this.data, false);
        }
    }

    private MatrixUtils() {
    }

    public static RealMatrix createRealMatrix(int rows, int columns) {
        if ((rows * columns) > 4096) goto L6;
        return new Array2DRowRealMatrix(rows, columns);
    L6:
        return new BlockRealMatrix(rows, columns);
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldMatrix(Field<T> field, int rows, int columns) {
        if ((rows * columns) > 4096) goto L6;
        return new Array2DRowFieldMatrix(field, rows, columns);
    L6:
        return new BlockFieldMatrix(field, rows, columns);
    }

    public static RealMatrix createRealMatrix(double[][] data) {
        if ((data.length * data[0].length) > 4096) goto L6;
        return new Array2DRowRealMatrix(data);
    L6:
        return new BlockRealMatrix(data);
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldMatrix(T[][] data) {
        if ((data.length * data[0].length) > 4096) goto L6;
        return new Array2DRowFieldMatrix(data);
    L6:
        return new BlockFieldMatrix(data);
    }

    public static RealMatrix createRealIdentityMatrix(int dimension) {
        RealMatrix m = createRealMatrix(dimension, dimension);
        int i = 0;
    L3:
        if (i >= dimension) goto L6;
        m.setEntry(i, i, 1.0d);
        i = i + 1;
        goto L3
    L6:
        return m;
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldIdentityMatrix(Field<T> field, int dimension) {
        T zero = field.getZero();
        T one = field.getOne();
        FieldElement[][] r2 = (FieldElement[][]) Array.newInstance(zero.getClass(), new int[]{dimension, dimension});
        int row = 0;
    L3:
        if (row >= dimension) goto L6;
        FieldElement[] r4 = r2[row];
        Arrays.fill(r4, zero);
        r4[row] = one;
        row = row + 1;
        goto L3
    L6:
        return new Array2DRowFieldMatrix(r2, false);
    }

    @Deprecated
    public static BigMatrix createBigIdentityMatrix(int dimension) {
        BigDecimal[][] d = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{dimension, dimension});
        int row = 0;
    L3:
        if (row >= dimension) goto L6;
        BigDecimal[] dRow = d[row];
        Arrays.fill(dRow, BigMatrixImpl.ZERO);
        dRow[row] = BigMatrixImpl.ONE;
        row = row + 1;
        goto L3
    L6:
        return new BigMatrixImpl(d, false);
    }

    public static RealMatrix createRealDiagonalMatrix(double[] diagonal) {
        RealMatrix m = createRealMatrix(diagonal.length, diagonal.length);
        int i = 0;
    L4:
        if (i >= diagonal.length) goto L7;
        m.setEntry(i, i, diagonal[i]);
        i = i + 1;
        goto L4
    L7:
        return m;
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldDiagonalMatrix(T[] diagonal) {
        FieldMatrix<T> m = createFieldMatrix(diagonal[0].getField(), diagonal.length, diagonal.length);
        int i = 0;
    L4:
        if (i >= diagonal.length) goto L7;
        m.setEntry(i, i, diagonal[i]);
        i = i + 1;
        goto L4
    L7:
        return m;
    }

    @Deprecated
    public static BigMatrix createBigMatrix(double[][] data) {
        return new BigMatrixImpl(data);
    }

    @Deprecated
    public static BigMatrix createBigMatrix(BigDecimal[][] data) {
        return new BigMatrixImpl(data);
    }

    @Deprecated
    public static BigMatrix createBigMatrix(BigDecimal[][] data, boolean copyArray) {
        return new BigMatrixImpl(data, copyArray);
    }

    @Deprecated
    public static BigMatrix createBigMatrix(String[][] data) {
        return new BigMatrixImpl(data);
    }

    public static RealVector createRealVector(double[] data) {
        return new ArrayRealVector(data, true);
    }

    public static <T extends FieldElement<T>> FieldVector<T> createFieldVector(T[] data) {
        return new ArrayFieldVector(data, true);
    }

    public static RealMatrix createRowRealMatrix(double[] rowData) {
        int nCols = rowData.length;
        RealMatrix m = createRealMatrix(1, nCols);
        int i = 0;
    L3:
        if (i >= nCols) goto L6;
        m.setEntry(0, i, rowData[i]);
        i = i + 1;
        goto L3
    L6:
        return m;
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createRowFieldMatrix(T[] rowData) {
        int nCols = rowData.length;
        if (nCols == 0) goto L10;
        FieldMatrix<T> m = createFieldMatrix(rowData[0].getField(), 1, nCols);
        int i = 0;
    L5:
        if (i >= nCols) goto L8;
        m.setEntry(0, i, rowData[i]);
        i = i + 1;
        goto L5
    L8:
        return m;
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    }

    @Deprecated
    public static BigMatrix createRowBigMatrix(double[] rowData) {
        int nCols = rowData.length;
        BigDecimal[][] data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{1, nCols});
        int i = 0;
    L3:
        if (i >= nCols) goto L6;
        data[0][i] = new BigDecimal(rowData[i]);
        i = i + 1;
        goto L3
    L6:
        return new BigMatrixImpl(data, false);
    }

    @Deprecated
    public static BigMatrix createRowBigMatrix(BigDecimal[] rowData) {
        int nCols = rowData.length;
        BigDecimal[][] data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{1, nCols});
        System.arraycopy(rowData, 0, data[0], 0, nCols);
        return new BigMatrixImpl(data, false);
    }

    @Deprecated
    public static BigMatrix createRowBigMatrix(String[] rowData) {
        int nCols = rowData.length;
        BigDecimal[][] data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{1, nCols});
        int i = 0;
    L3:
        if (i >= nCols) goto L6;
        data[0][i] = new BigDecimal(rowData[i]);
        i = i + 1;
        goto L3
    L6:
        return new BigMatrixImpl(data, false);
    }

    public static RealMatrix createColumnRealMatrix(double[] columnData) {
        int nRows = columnData.length;
        RealMatrix m = createRealMatrix(nRows, 1);
        int i = 0;
    L3:
        if (i >= nRows) goto L6;
        m.setEntry(i, 0, columnData[i]);
        i = i + 1;
        goto L3
    L6:
        return m;
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createColumnFieldMatrix(T[] columnData) {
        int nRows = columnData.length;
        if (nRows == 0) goto L10;
        FieldMatrix<T> m = createFieldMatrix(columnData[0].getField(), nRows, 1);
        int i = 0;
    L5:
        if (i >= nRows) goto L8;
        m.setEntry(i, 0, columnData[i]);
        i = i + 1;
        goto L5
    L8:
        return m;
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_ROW, new Object[0]);
    }

    @Deprecated
    public static BigMatrix createColumnBigMatrix(double[] columnData) {
        int nRows = columnData.length;
        BigDecimal[][] data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, 1});
        int row = 0;
    L3:
        if (row >= nRows) goto L6;
        data[row][0] = new BigDecimal(columnData[row]);
        row = row + 1;
        goto L3
    L6:
        return new BigMatrixImpl(data, false);
    }

    @Deprecated
    public static BigMatrix createColumnBigMatrix(BigDecimal[] columnData) {
        int nRows = columnData.length;
        BigDecimal[][] data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, 1});
        int row = 0;
    L3:
        if (row >= nRows) goto L6;
        data[row][0] = columnData[row];
        row = row + 1;
        goto L3
    L6:
        return new BigMatrixImpl(data, false);
    }

    @Deprecated
    public static BigMatrix createColumnBigMatrix(String[] columnData) {
        int nRows = columnData.length;
        BigDecimal[][] data = (BigDecimal[][]) Array.newInstance(BigDecimal.class, new int[]{nRows, 1});
        int row = 0;
    L3:
        if (row >= nRows) goto L6;
        data[row][0] = new BigDecimal(columnData[row]);
        row = row + 1;
        goto L3
    L6:
        return new BigMatrixImpl(data, false);
    }

    public static void checkRowIndex(AnyMatrix m, int row) {
        if (row < 0) goto L7;
        if (row >= m.getRowDimension()) goto L7;
        return;
    L7:
        throw new MatrixIndexException(LocalizedFormats.ROW_INDEX_OUT_OF_RANGE, new Object[]{Integer.valueOf(row), 0, Integer.valueOf(m.getRowDimension() - 1)});
    }

    public static void checkColumnIndex(AnyMatrix m, int column) throws MatrixIndexException {
        if (column < 0) goto L7;
        if (column >= m.getColumnDimension()) goto L7;
        return;
    L7:
        throw new MatrixIndexException(LocalizedFormats.COLUMN_INDEX_OUT_OF_RANGE, new Object[]{Integer.valueOf(column), 0, Integer.valueOf(m.getColumnDimension() - 1)});
    }

    public static void checkSubMatrixIndex(AnyMatrix m, int startRow, int endRow, int startColumn, int endColumn) {
        checkRowIndex(m, startRow);
        checkRowIndex(m, endRow);
        if (startRow > endRow) goto L10;
        checkColumnIndex(m, startColumn);
        checkColumnIndex(m, endColumn);
        if (startColumn > endColumn) goto L8;
        return;
    L8:
        throw new MatrixIndexException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, new Object[]{Integer.valueOf(startColumn), Integer.valueOf(endColumn)});
    L10:
        throw new MatrixIndexException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, new Object[]{Integer.valueOf(startRow), Integer.valueOf(endRow)});
    }

    public static void checkSubMatrixIndex(AnyMatrix m, int[] selectedRows, int[] selectedColumns) throws MatrixIndexException {
        int r1 = 0;
        if ((selectedRows.length * selectedColumns.length) == 0) goto L5;
        int r0 = selectedRows.length;
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L13;
        int row = selectedRows[r2];
        checkRowIndex(m, row);
        r2 = r2 + 1;
        goto L11
    L13:
        int r3 = selectedColumns.length;
    L14:
        if (r1 >= r3) goto L16;
        int column = selectedColumns[r1];
        checkColumnIndex(m, column);
        r1 = r1 + 1;
        goto L14
    L16:
        return;
    L5:
        if (selectedRows.length != 0) goto L9;
        throw new MatrixIndexException(LocalizedFormats.EMPTY_SELECTED_ROW_INDEX_ARRAY, new Object[0]);
    L9:
        throw new MatrixIndexException(LocalizedFormats.EMPTY_SELECTED_COLUMN_INDEX_ARRAY, new Object[0]);
    }

    public static void checkAdditionCompatible(AnyMatrix left, AnyMatrix right) throws IllegalArgumentException {
        if (left.getRowDimension() != right.getRowDimension()) goto L8;
        if (left.getColumnDimension() != right.getColumnDimension()) goto L8;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_ADDITION_COMPATIBLE_MATRICES, new Object[]{Integer.valueOf(left.getRowDimension()), Integer.valueOf(left.getColumnDimension()), Integer.valueOf(right.getRowDimension()), Integer.valueOf(right.getColumnDimension())});
    }

    public static void checkSubtractionCompatible(AnyMatrix left, AnyMatrix right) throws IllegalArgumentException {
        if (left.getRowDimension() != right.getRowDimension()) goto L8;
        if (left.getColumnDimension() != right.getColumnDimension()) goto L8;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_SUBTRACTION_COMPATIBLE_MATRICES, new Object[]{Integer.valueOf(left.getRowDimension()), Integer.valueOf(left.getColumnDimension()), Integer.valueOf(right.getRowDimension()), Integer.valueOf(right.getColumnDimension())});
    }

    public static void checkMultiplicationCompatible(AnyMatrix left, AnyMatrix right) throws IllegalArgumentException {
        if (left.getColumnDimension() != right.getRowDimension()) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_MULTIPLICATION_COMPATIBLE_MATRICES, new Object[]{Integer.valueOf(left.getRowDimension()), Integer.valueOf(left.getColumnDimension()), Integer.valueOf(right.getRowDimension()), Integer.valueOf(right.getColumnDimension())});
    }

    public static Array2DRowRealMatrix fractionMatrixToRealMatrix(FieldMatrix<Fraction> m) {
        FractionMatrixConverter converter = new FractionMatrixConverter();
        m.walkInOptimizedOrder(converter);
        return converter.getConvertedMatrix();
    }

    public static Array2DRowRealMatrix bigFractionMatrixToRealMatrix(FieldMatrix<BigFraction> m) {
        BigFractionMatrixConverter converter = new BigFractionMatrixConverter();
        m.walkInOptimizedOrder(converter);
        return converter.getConvertedMatrix();
    }

    public static void serializeRealVector(RealVector vector, ObjectOutputStream oos) throws IOException {
        int n = vector.getDimension();
        oos.writeInt(n);
        int i = 0;
    L3:
        if (i >= n) goto L6;
        oos.writeDouble(vector.getEntry(i));
        i = i + 1;
        goto L3
    }

    public static void deserializeRealVector(Object instance, String fieldName, ObjectInputStream ois) throws ClassNotFoundException, IOException {
        int n = ois.readInt();     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        double[] data = new double[n];     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        int i = 0;
    L3:
        if (i >= n) goto L9;
        data[i] = ois.readDouble();     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        i = i + 1;     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        goto L3
    L9:
        RealVector vector = new ArrayRealVector(data, false);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        java.lang.reflect.Field f = instance.getClass().getDeclaredField(fieldName);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        f.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        f.set(instance, vector);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        return;
    L5:
        iae = move-exception;
        IOException ioe = new IOException();
        ioe.initCause(iae);
        throw ioe;
    L7:
        nsfe = move-exception;
        IOException ioe2 = new IOException();
        ioe2.initCause(nsfe);
        throw ioe2;
    }

    public static void serializeRealMatrix(RealMatrix matrix, ObjectOutputStream oos) throws IOException {
        int n = matrix.getRowDimension();
        int m = matrix.getColumnDimension();
        oos.writeInt(n);
        oos.writeInt(m);
        int i = 0;
    L3:
        if (i >= n) goto L9;
        int j = 0;
    L5:
        if (j >= m) goto L7;
        oos.writeDouble(matrix.getEntry(i, j));
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    }

    public static void deserializeRealMatrix(Object instance, String fieldName, ObjectInputStream ois) throws ClassNotFoundException, IOException {
        int n = ois.readInt();     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        int m = ois.readInt();     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        double[][] data = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, m});     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        int i = 0;
    L3:
        if (i >= n) goto L12;
        double[] dataI = data[i];     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        int j = 0;
    L5:
        if (j >= m) goto L11;
        dataI[j] = ois.readDouble();     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        j = j + 1;     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        goto L5
    L11:
        i = i + 1;     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        goto L3
    L12:
        RealMatrix matrix = new Array2DRowRealMatrix(data, false);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        java.lang.reflect.Field f = instance.getClass().getDeclaredField(fieldName);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        f.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        f.set(instance, matrix);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        return;
    L7:
        iae = move-exception;
        IOException ioe = new IOException();
        ioe.initCause(iae);
        throw ioe;
    L9:
        nsfe = move-exception;
        IOException ioe2 = new IOException();
        ioe2.initCause(nsfe);
        throw ioe2;
    }
}
