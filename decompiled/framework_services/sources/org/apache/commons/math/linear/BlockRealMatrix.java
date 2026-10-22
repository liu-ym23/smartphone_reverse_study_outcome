package org.apache.commons.math.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class BlockRealMatrix extends AbstractRealMatrix implements Serializable {
    public static final int BLOCK_SIZE = 52;
    private static final long serialVersionUID = 4991895511313664478L;
    private final int blockColumns;
    private final int blockRows;
    private final double[][] blocks;
    private final int columns;
    private final int rows;

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix add(RealMatrix r1) throws IllegalArgumentException {
        return add(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix copy() {
        return copy();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix createMatrix(int r1, int r2) throws IllegalArgumentException {
        return createMatrix(r1, r2);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix getColumnMatrix(int r1) throws MatrixIndexException {
        return getColumnMatrix(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix getRowMatrix(int r1) throws MatrixIndexException {
        return getRowMatrix(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix getSubMatrix(int r1, int r2, int r3, int r4) throws MatrixIndexException {
        return getSubMatrix(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix multiply(RealMatrix r1) throws IllegalArgumentException {
        return multiply(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix scalarAdd(double r1) {
        return scalarAdd(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix subtract(RealMatrix r1) throws IllegalArgumentException {
        return subtract(r1);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix transpose() {
        return transpose();
    }

    public BlockRealMatrix(int rows, int columns) throws IllegalArgumentException {
        super(rows, columns);
        this.rows = rows;
        this.columns = columns;
        this.blockRows = ((rows + 52) - 1) / 52;
        this.blockColumns = ((columns + 52) - 1) / 52;
        this.blocks = createBlocksLayout(rows, columns);
    }

    public BlockRealMatrix(double[][] rawData) throws IllegalArgumentException {
        this(rawData.length, rawData[0].length, toBlocksLayout(rawData), false);
    }

    public BlockRealMatrix(int rows, int columns, double[][] blockData, boolean copyArray) throws IllegalArgumentException {
        super(rows, columns);
        this.rows = rows;
        this.columns = columns;
        this.blockRows = ((rows + 52) - 1) / 52;
        this.blockColumns = ((columns + 52) - 1) / 52;
        if (copyArray == false) goto L5;
        this.blocks = new double[this.blockRows * this.blockColumns][];
    L6:
        int index = 0;
        int iBlock = 0;
    L8:
        if (iBlock >= this.blockRows) goto L21;
        int iHeight = blockHeight(iBlock);
        int jBlock = 0;
    L11:
        if (jBlock >= this.blockColumns) goto L19;
        if (blockData[index].length != (blockWidth(jBlock) * iHeight)) goto L18;
        if (copyArray == false) goto L16;
        this.blocks[index] = (double[]) blockData[index].clone();
    L16:
        jBlock = jBlock + 1;
        index = index + 1;
        goto L11
    L18:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.WRONG_BLOCK_LENGTH, new Object[]{Integer.valueOf(blockData[index].length), Integer.valueOf(blockWidth(jBlock) * iHeight)});
    L19:
        iBlock = iBlock + 1;
        goto L8
    L21:
        return;
    L5:
        this.blocks = blockData;
        goto L6
    }

    public static double[][] toBlocksLayout(double[][] rawData) throws IllegalArgumentException {
        int rows = rawData.length;
        int columns = rawData[0].length;
        int blockRows = ((rows + 52) - 1) / 52;
        int blockColumns = ((columns + 52) - 1) / 52;
        int i = 0;
    L4:
        if (i >= rawData.length) goto L10;
        int length = rawData[i].length;
        if (length != columns) goto L9;
        i = i + 1;
        goto L4
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(columns), Integer.valueOf(length)});
    L10:
        int i2 = blockRows * blockColumns;
        double[][] blocks = new double[i2][];
        int blockIndex = 0;
        int iBlock = 0;
    L11:
        if (iBlock >= blockRows) goto L20;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, rows);
        int iHeight = pEnd - pStart;
        int jBlock = 0;
    L13:
        if (jBlock >= blockColumns) goto L18;
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, columns);
        int jWidth = qEnd - qStart;
        double[] block = new double[iHeight * jWidth];
        blocks[blockIndex] = block;
        int index = 0;
        int index2 = rows;
        int rows2 = pStart;
    L15:
        if (rows2 >= pEnd) goto L17;
        int p = rows2;
        System.arraycopy(rawData[p], qStart, block, index, jWidth);
        index = index + jWidth;
        rows2 = p + 1;
        goto L15
    L17:
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        rows = index2;
        goto L13
    L18:
        iBlock = iBlock + 1;
        goto L11
    L20:
        return blocks;
    }

    public static double[][] createBlocksLayout(int rows, int columns) {
        int blockRows = ((rows + 52) - 1) / 52;
        int blockColumns = ((columns + 52) - 1) / 52;
        double[][] blocks = new double[blockRows * blockColumns][];
        int blockIndex = 0;
        int iBlock = 0;
    L3:
        if (iBlock >= blockRows) goto L9;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, rows);
        int iHeight = pEnd - pStart;
        int jBlock = 0;
    L5:
        if (jBlock >= blockColumns) goto L7;
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, columns);
        int jWidth = qEnd - qStart;
        blocks[blockIndex] = new double[iHeight * jWidth];
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        goto L5
    L7:
        iBlock = iBlock + 1;
        goto L3
    L9:
        return blocks;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix createMatrix(int rowDimension, int columnDimension) throws IllegalArgumentException {
        return new BlockRealMatrix(rowDimension, columnDimension);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix copy() {
        BlockRealMatrix copied = new BlockRealMatrix(this.rows, this.columns);
        int i = 0;
    L4:
        if (i >= this.blocks.length) goto L7;
        System.arraycopy(this.blocks[i], 0, copied.blocks[i], 0, this.blocks[i].length);
        i = i + 1;
        goto L4
    L7:
        return copied;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix add(RealMatrix m) throws IllegalArgumentException {
        return add((BlockRealMatrix) m);
    L6:
        MatrixUtils.checkAdditionCompatible(this, m);
        BlockRealMatrix out = new BlockRealMatrix(this.rows, this.columns);
        int blockIndex = 0;
        int iBlock = 0;
    L8:
        if (iBlock >= out.blockRows) goto L21;
        int jBlock = 0;
    L11:
        if (jBlock >= out.blockColumns) goto L19;
        double[] outBlock = out.blocks[blockIndex];
        double[] tBlock = this.blocks[blockIndex];
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, this.rows);
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, this.columns);
        int k = 0;
        int p = pStart;
    L13:
        if (p >= pEnd) goto L18;
        int q = qStart;
    L15:
        if (q >= qEnd) goto L17;
        outBlock[k] = tBlock[k] + m.getEntry(p, q);
        k = k + 1;
        q = q + 1;
        goto L15
    L17:
        p = p + 1;
        goto L13
    L18:
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        goto L11
    L19:
        iBlock = iBlock + 1;
        goto L8
    L21:
        return out;
    }

    public BlockRealMatrix add(BlockRealMatrix m) throws IllegalArgumentException {
        MatrixUtils.checkAdditionCompatible(this, m);
        BlockRealMatrix out = new BlockRealMatrix(this.rows, this.columns);
        int blockIndex = 0;
    L4:
        if (blockIndex >= out.blocks.length) goto L11;
        double[] outBlock = out.blocks[blockIndex];
        double[] tBlock = this.blocks[blockIndex];
        double[] mBlock = m.blocks[blockIndex];
        int k = 0;
    L7:
        if (k >= outBlock.length) goto L9;
        outBlock[k] = tBlock[k] + mBlock[k];
        k = k + 1;
        goto L7
    L9:
        blockIndex = blockIndex + 1;
        goto L4
    L11:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix subtract(RealMatrix m) throws IllegalArgumentException {
        return subtract((BlockRealMatrix) m);
    L6:
        MatrixUtils.checkSubtractionCompatible(this, m);
        BlockRealMatrix out = new BlockRealMatrix(this.rows, this.columns);
        int blockIndex = 0;
        int iBlock = 0;
    L8:
        if (iBlock >= out.blockRows) goto L21;
        int jBlock = 0;
    L11:
        if (jBlock >= out.blockColumns) goto L19;
        double[] outBlock = out.blocks[blockIndex];
        double[] tBlock = this.blocks[blockIndex];
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, this.rows);
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, this.columns);
        int k = 0;
        int p = pStart;
    L13:
        if (p >= pEnd) goto L18;
        int q = qStart;
    L15:
        if (q >= qEnd) goto L17;
        outBlock[k] = tBlock[k] - m.getEntry(p, q);
        k = k + 1;
        q = q + 1;
        goto L15
    L17:
        p = p + 1;
        goto L13
    L18:
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        goto L11
    L19:
        iBlock = iBlock + 1;
        goto L8
    L21:
        return out;
    }

    public BlockRealMatrix subtract(BlockRealMatrix m) throws IllegalArgumentException {
        MatrixUtils.checkSubtractionCompatible(this, m);
        BlockRealMatrix out = new BlockRealMatrix(this.rows, this.columns);
        int blockIndex = 0;
    L4:
        if (blockIndex >= out.blocks.length) goto L11;
        double[] outBlock = out.blocks[blockIndex];
        double[] tBlock = this.blocks[blockIndex];
        double[] mBlock = m.blocks[blockIndex];
        int k = 0;
    L7:
        if (k >= outBlock.length) goto L9;
        outBlock[k] = tBlock[k] - mBlock[k];
        k = k + 1;
        goto L7
    L9:
        blockIndex = blockIndex + 1;
        goto L4
    L11:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix scalarAdd(double d) throws IllegalArgumentException {
        BlockRealMatrix out = new BlockRealMatrix(this.rows, this.columns);
        int blockIndex = 0;
    L4:
        if (blockIndex >= out.blocks.length) goto L11;
        double[] outBlock = out.blocks[blockIndex];
        double[] tBlock = this.blocks[blockIndex];
        int k = 0;
    L7:
        if (k >= outBlock.length) goto L9;
        outBlock[k] = tBlock[k] + d;
        k = k + 1;
        goto L7
    L9:
        blockIndex = blockIndex + 1;
        goto L4
    L11:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public RealMatrix scalarMultiply(double d) throws IllegalArgumentException {
        BlockRealMatrix out = new BlockRealMatrix(this.rows, this.columns);
        int blockIndex = 0;
    L4:
        if (blockIndex >= out.blocks.length) goto L11;
        double[] outBlock = out.blocks[blockIndex];
        double[] tBlock = this.blocks[blockIndex];
        int k = 0;
    L7:
        if (k >= outBlock.length) goto L9;
        outBlock[k] = tBlock[k] * d;
        k = k + 1;
        goto L7
    L9:
        blockIndex = blockIndex + 1;
        goto L4
    L11:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix multiply(RealMatrix m) throws IllegalArgumentException {
        BlockRealMatrix r1 = this;
        return r1.multiply((BlockRealMatrix) m);
    L5:
        cce = e;
        MatrixUtils.checkMultiplicationCompatible(this, m);
        BlockRealMatrix out = new BlockRealMatrix(r1.rows, m.getColumnDimension());
        int blockIndex = 0;
        int iBlock = 0;
    L8:
        if (iBlock >= out.blockRows) goto L28;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, r1.rows);
        int jBlock = 0;
    L11:
        if (jBlock >= out.blockColumns) goto L26;
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, m.getColumnDimension());
        double[] outBlock = out.blocks[blockIndex];
        int kBlock = 0;
    L14:
        if (kBlock >= r1.blockColumns) goto L25;
        int kWidth = r1.blockWidth(kBlock);
        double[] tBlock = r1.blocks[(r1.blockColumns * iBlock) + kBlock];
        int rStart = kBlock * 52;
        int k = 0;
        ClassCastException cce = cce;
        int lEnd = pStart;
    L16:
        if (lEnd >= pEnd) goto L24;
        int lStart = (lEnd - pStart) * kWidth;
        int p = lEnd;
        int p2 = lStart + kWidth;
        int q = qStart;
    L18:
        if (q >= qEnd) goto L23;
        double sum = 0.0d;
        BlockRealMatrix out2 = out;
        int r = rStart;
        int blockIndex2 = blockIndex;
        int blockIndex3 = lStart;
    L20:
        if (blockIndex3 >= p2) goto L22;
        sum = sum + (tBlock[blockIndex3] * m.getEntry(r, q));
        r = r + 1;
        blockIndex3 = blockIndex3 + 1;
        goto L20
    L22:
        outBlock[k] = outBlock[k] + sum;
        k = k + 1;
        q = q + 1;
        out = out2;
        blockIndex = blockIndex2;
        goto L18
    L23:
        lEnd = p + 1;
        goto L16
    L24:
        kBlock = kBlock + 1;
        r1 = this;
        cce = cce;
        goto L14
    L25:
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        r1 = this;
        goto L11
    L26:
        iBlock = iBlock + 1;
        r1 = this;
        goto L8
    L28:
        return out;
    }

    public BlockRealMatrix multiply(BlockRealMatrix m) throws IllegalArgumentException {
        BlockRealMatrix r0 = this;
        BlockRealMatrix r1 = m;
        MatrixUtils.checkMultiplicationCompatible(this, m);
        BlockRealMatrix out = new BlockRealMatrix(r0.rows, r1.columns);
        int blockIndex = 0;
        int iBlock = 0;
    L4:
        if (iBlock >= out.blockRows) goto L27;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, r0.rows);
        int jBlock = 0;
    L7:
        if (jBlock >= out.blockColumns) goto L25;
        int jWidth = out.blockWidth(jBlock);
        int jWidth2 = jWidth + jWidth;
        int jWidth3 = jWidth2 + jWidth;
        int jWidth4 = jWidth3 + jWidth;
        double[] outBlock = out.blocks[blockIndex];
        int kBlock = 0;
    L10:
        if (kBlock >= r0.blockColumns) goto L24;
        int kWidth = r0.blockWidth(kBlock);
        BlockRealMatrix out2 = out;
        double[] tBlock = r0.blocks[(r0.blockColumns * iBlock) + kBlock];
        double[] mBlock = r1.blocks[(r1.blockColumns * kBlock) + jBlock];
        int k = 0;
        int lEnd = pStart;
    L12:
        if (lEnd >= pEnd) goto L23;
        int lStart = (lEnd - pStart) * kWidth;
        int p = lEnd;
        int p2 = lStart + kWidth;
        int nStart = 0;
    L14:
        if (nStart >= jWidth) goto L22;
        double sum = 0.0d;
        int n = nStart;
        int l = nStart;
        int nStart2 = lStart;
    L16:
        double[] tBlock2 = tBlock;
        if (nStart2 >= (p2 - 3)) goto L19;
        sum = sum + ((((tBlock2[nStart2] * mBlock[n]) + (tBlock2[nStart2 + 1] * mBlock[n + jWidth])) + (tBlock2[nStart2 + 2] * mBlock[n + jWidth2])) + (tBlock2[nStart2 + 3] * mBlock[n + jWidth3]));
        nStart2 = nStart2 + 4;
        n = n + jWidth4;
        tBlock = tBlock2;
    L19:
        if (nStart2 >= p2) goto L21;
        int l2 = nStart2 + 1;
        sum = sum + (tBlock2[nStart2] * mBlock[n]);
        n = n + jWidth;
        nStart2 = l2;
        goto L19
    L21:
        outBlock[k] = outBlock[k] + sum;
        k = k + 1;
        nStart = l + 1;
        tBlock = tBlock2;
        goto L14
    L22:
        lEnd = p + 1;
        goto L12
    L23:
        kBlock = kBlock + 1;
        r0 = this;
        r1 = m;
        out = out2;
        goto L10
    L24:
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        r0 = this;
        r1 = m;
        goto L7
    L25:
        iBlock = iBlock + 1;
        r0 = this;
        r1 = m;
        goto L4
    L27:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double[][] getData() {
        double[][] data = (double[][]) Array.newInstance(Double.TYPE, new int[]{getRowDimension(), getColumnDimension()});
        int lastColumns = this.columns - ((this.blockColumns - 1) * 52);
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L14;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, this.rows);
        int regularPos = 0;
        int lastPos = 0;
        int p = pStart;
    L6:
        if (p >= pEnd) goto L12;
        double[] dataP = data[p];
        int blockIndex = this.blockColumns * iBlock;
        int dataPos = 0;
        int jBlock = 0;
    L9:
        if (jBlock >= (this.blockColumns - 1)) goto L11;
        System.arraycopy(this.blocks[blockIndex], regularPos, dataP, dataPos, 52);
        dataPos = dataPos + 52;
        jBlock = jBlock + 1;
        blockIndex = blockIndex + 1;
        goto L9
    L11:
        System.arraycopy(this.blocks[blockIndex], lastPos, dataP, dataPos, lastColumns);
        regularPos = regularPos + 52;
        lastPos = lastPos + lastColumns;
        p = p + 1;
        goto L6
    L12:
        iBlock = iBlock + 1;
        goto L4
    L14:
        return data;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double getNorm() {
        double[] colSums = new double[52];
        double maxColSum = 0.0d;
        int jBlock = 0;
    L4:
        if (jBlock >= this.blockColumns) goto L20;
        int jWidth = blockWidth(jBlock);
        Arrays.fill(colSums, 0, jWidth, 0.0d);
        int iBlock = 0;
    L7:
        if (iBlock >= this.blockRows) goto L15;
        int iHeight = blockHeight(iBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int j = 0;
    L9:
        if (j >= jWidth) goto L14;
        double sum = 0.0d;
        int i = 0;
    L11:
        if (i >= iHeight) goto L13;
        sum = sum + FastMath.abs(block[(i * jWidth) + j]);
        i = i + 1;
        goto L11
    L13:
        colSums[j] = colSums[j] + sum;
        j = j + 1;
        goto L9
    L14:
        iBlock = iBlock + 1;
        goto L7
    L15:
        int j2 = 0;
    L16:
        if (j2 >= jWidth) goto L18;
        maxColSum = FastMath.max(maxColSum, colSums[j2]);
        j2 = j2 + 1;
        goto L16
    L18:
        jBlock = jBlock + 1;
        goto L4
    L20:
        return maxColSum;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double getFrobeniusNorm() {
        double sum2 = 0.0d;
        int blockIndex = 0;
    L4:
        if (blockIndex >= this.blocks.length) goto L10;
        double[] r3 = this.blocks[blockIndex];
        int r4 = r3.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L8;
        double entry = r3[r5];
        sum2 = sum2 + (entry * entry);
        r5 = r5 + 1;
        goto L6
    L8:
        blockIndex = blockIndex + 1;
        goto L4
    L10:
        return FastMath.sqrt(sum2);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix getSubMatrix(int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException {
        MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
        BlockRealMatrix out = new BlockRealMatrix((endRow - startRow) + 1, (endColumn - startColumn) + 1);
        int blockStartRow = startRow / 52;
        int rowsShift = startRow % 52;
        int blockStartColumn = startColumn / 52;
        int columnsShift = startColumn % 52;
        int pBlock = blockStartRow;
        int iBlock = 0;
    L3:
        int pBlock2 = out.blockRows;
        if (iBlock >= pBlock2) goto L20;
        int iHeight = out.blockHeight(iBlock);
        int qBlock = blockStartColumn;
        int jBlock = 0;
    L7:
        if (jBlock >= out.blockColumns) goto L18;
        int jWidth = out.blockWidth(jBlock);
        int outIndex = (out.blockColumns * iBlock) + jBlock;
        double[] outBlock = out.blocks[outIndex];
        int index = (this.blockColumns * pBlock) + qBlock;
        int jBlock2 = jBlock;
        int width = this.blockWidth(qBlock);
        int heightExcess = (iHeight + rowsShift) - 52;
        int widthExcess = (jWidth + columnsShift) - 52;
        if (heightExcess <= 0) goto L13;
        if (widthExcess <= 0) goto L12;
        int width2 = this.blockWidth(qBlock + 1);
        int jBlock3 = jBlock2;
        int qBlock2 = qBlock;
        this.copyBlockPart(this.blocks[index], width, rowsShift, 52, columnsShift, 52, outBlock, jWidth, 0, 0);
        int columnsShift2 = columnsShift;
        this.copyBlockPart(this.blocks[index + 1], width2, rowsShift, 52, 0, widthExcess, outBlock, jWidth, 0, jWidth - widthExcess);
        this.copyBlockPart(this.blocks[index + this.blockColumns], width, 0, heightExcess, columnsShift2, 52, outBlock, jWidth, iHeight - heightExcess, 0);
        this.copyBlockPart(this.blocks[(index + this.blockColumns) + 1], width2, 0, heightExcess, 0, widthExcess, outBlock, jWidth, iHeight - heightExcess, jWidth - widthExcess);
        rowsShift = rowsShift;
        columnsShift = columnsShift2;
    L17:
        qBlock = qBlock2 + 1;
        jBlock = jBlock3 + 1;
        BlockRealMatrix this = this;
        goto L7
    L12:
        qBlock2 = qBlock;
        jBlock3 = jBlock2;
        this.copyBlockPart(this.blocks[index], width, rowsShift, 52, columnsShift, jWidth + columnsShift, outBlock, jWidth, 0, 0);
        this.copyBlockPart(this.blocks[index + this.blockColumns], width, 0, heightExcess, columnsShift, jWidth + columnsShift, outBlock, jWidth, iHeight - heightExcess, 0);
        rowsShift = rowsShift;
        goto L17
    L13:
        qBlock2 = qBlock;
        jBlock3 = jBlock2;
        int widthExcess2 = rowsShift;
        if (widthExcess <= 0) goto L16;
        int width3 = this.blockWidth(qBlock2 + 1);
        rowsShift = widthExcess2;
        this.copyBlockPart(this.blocks[index], width, rowsShift, iHeight + widthExcess2, columnsShift, 52, outBlock, jWidth, 0, 0);
        this.copyBlockPart(this.blocks[index + 1], width3, rowsShift, iHeight + rowsShift, 0, widthExcess, outBlock, jWidth, 0, jWidth - widthExcess);
        columnsShift = columnsShift;
        goto L17
    L16:
        rowsShift = widthExcess2;
        int rowsShift2 = columnsShift;
        this.copyBlockPart(this.blocks[index], width, rowsShift, iHeight + rowsShift, columnsShift, jWidth + rowsShift2, outBlock, jWidth, 0, 0);
        goto L17
    L18:
        pBlock = pBlock + 1;
        iBlock = iBlock + 1;
        goto L3
    L20:
        return out;
    }

    private void copyBlockPart(double[] srcBlock, int srcWidth, int srcStartRow, int srcEndRow, int srcStartColumn, int srcEndColumn, double[] dstBlock, int dstWidth, int dstStartRow, int dstStartColumn) {
        int length = srcEndColumn - srcStartColumn;
        int srcPos = (srcStartRow * srcWidth) + srcStartColumn;
        int dstPos = (dstStartRow * dstWidth) + dstStartColumn;
        int srcRow = srcStartRow;
    L3:
        if (srcRow >= srcEndRow) goto L6;
        System.arraycopy(srcBlock, srcPos, dstBlock, dstPos, length);
        srcPos = srcPos + srcWidth;
        dstPos = dstPos + dstWidth;
        srcRow = srcRow + 1;
        goto L3
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setSubMatrix(double[][] subMatrix, int row, int column) throws MatrixIndexException {
        BlockRealMatrix r0 = this;
        int r2 = row;
        int r3 = column;
        int r4 = 0;
        int refLength = subMatrix[0].length;
        if (refLength < 1) goto L23;
        int endRow = (subMatrix.length + r2) - 1;
        int endColumn = (r3 + refLength) - 1;
        MatrixUtils.checkSubMatrixIndex(r0, r2, endRow, r3, endColumn);
        int r6 = subMatrix.length;
    L5:
        if (r4 >= r6) goto L11;
        double[] subRow = subMatrix[r4];
        if (subRow.length != refLength) goto L10;
        r4 = r4 + 1;
        goto L5
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(refLength), Integer.valueOf(subRow.length)});
    L11:
        int blockStartRow = r2 / 52;
        int blockEndRow = (endRow + 52) / 52;
        int blockStartColumn = r3 / 52;
        int blockEndColumn = (endColumn + 52) / 52;
        int iBlock = blockStartRow;
    L12:
        if (iBlock >= blockEndRow) goto L21;
        int iHeight = r0.blockHeight(iBlock);
        int firstRow = iBlock * 52;
        int iStart = FastMath.max(r2, firstRow);
        int iEnd = FastMath.min(endRow + 1, firstRow + iHeight);
        int jBlock = blockStartColumn;
    L14:
        if (jBlock >= blockEndColumn) goto L19;
        int jWidth = r0.blockWidth(jBlock);
        int firstColumn = jBlock * 52;
        int jStart = FastMath.max(r3, firstColumn);
        int jEnd = FastMath.min(endColumn + 1, firstColumn + jWidth);
        int jLength = jEnd - jStart;
        double[] block = r0.blocks[(r0.blockColumns * iBlock) + jBlock];
        int i = iStart;
    L16:
        if (i >= iEnd) goto L18;
        int i2 = i;
        double[] r1 = subMatrix[i - row];
        int iEnd2 = iEnd;
        int iEnd3 = jStart - column;
        int blockStartRow2 = blockStartRow;
        System.arraycopy(r1, iEnd3, block, ((i2 - firstRow) * jWidth) + (jStart - firstColumn), jLength);
        i = i2 + 1;
        iEnd = iEnd2;
        blockStartRow = blockStartRow2;
        goto L16
    L18:
        jBlock = jBlock + 1;
        r0 = this;
        r3 = column;
        goto L14
    L19:
        iBlock = iBlock + 1;
        r0 = this;
        r2 = row;
        r3 = column;
        goto L12
    L21:
        return;
    L23:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.AT_LEAST_ONE_COLUMN, new Object[0]);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix getRowMatrix(int row) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        BlockRealMatrix out = new BlockRealMatrix(1, this.columns);
        int iBlock = row / 52;
        int iRow = row - (iBlock * 52);
        int outBlockIndex = 0;
        int outIndex = 0;
        double[] outBlock = out.blocks[0];
        int jBlock = 0;
    L4:
        if (jBlock >= this.blockColumns) goto L11;
        int jWidth = blockWidth(jBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int available = outBlock.length - outIndex;
        if (jWidth <= available) goto L8;
        System.arraycopy(block, iRow * jWidth, outBlock, outIndex, available);
        outBlockIndex = outBlockIndex + 1;
        outBlock = out.blocks[outBlockIndex];
        System.arraycopy(block, iRow * jWidth, outBlock, 0, jWidth - available);
        outIndex = jWidth - available;
    L9:
        jBlock = jBlock + 1;
        goto L4
    L8:
        System.arraycopy(block, iRow * jWidth, outBlock, outIndex, jWidth);
        outIndex = outIndex + jWidth;
        goto L9
    L11:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setRowMatrix(int row, RealMatrix matrix) throws MatrixIndexException, InvalidMatrixException {
        setRowMatrix(row, (BlockRealMatrix) matrix);     // Catch: ClassCastException -> L4
        return;
    L5:
        super.setRowMatrix(row, matrix);
    }

    public void setRowMatrix(int row, BlockRealMatrix matrix) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkRowIndex(this, row);
        int nCols = getColumnDimension();
        if (matrix.getRowDimension() != 1) goto L17;
        if (matrix.getColumnDimension() != nCols) goto L17;
        int iBlock = row / 52;
        int iRow = row - (iBlock * 52);
        int mBlockIndex = 0;
        int mIndex = 0;
        double[] mBlock = matrix.blocks[0];
        int jBlock = 0;
    L8:
        if (jBlock >= this.blockColumns) goto L15;
        int jWidth = blockWidth(jBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int available = mBlock.length - mIndex;
        if (jWidth <= available) goto L12;
        System.arraycopy(mBlock, mIndex, block, iRow * jWidth, available);
        mBlockIndex = mBlockIndex + 1;
        mBlock = matrix.blocks[mBlockIndex];
        System.arraycopy(mBlock, 0, block, iRow * jWidth, jWidth - available);
        mIndex = jWidth - available;
    L13:
        jBlock = jBlock + 1;
        goto L8
    L12:
        System.arraycopy(mBlock, mIndex, block, iRow * jWidth, jWidth);
        mIndex = mIndex + jWidth;
        goto L13
    L15:
        return;
    L17:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(matrix.getRowDimension()), Integer.valueOf(matrix.getColumnDimension()), 1, Integer.valueOf(nCols)});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix getColumnMatrix(int column) throws MatrixIndexException {
        MatrixUtils.checkColumnIndex(this, column);
        BlockRealMatrix out = new BlockRealMatrix(this.rows, 1);
        int jBlock = column / 52;
        int jColumn = column - (jBlock * 52);
        int jWidth = blockWidth(jBlock);
        int outBlockIndex = 0;
        int outIndex = 0;
        double[] outBlock = out.blocks[0];
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L13;
        int iHeight = blockHeight(iBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int i = 0;
    L6:
        if (i >= iHeight) goto L11;
        if (outIndex < outBlock.length) goto L10;
        outBlockIndex = outBlockIndex + 1;
        outBlock = out.blocks[outBlockIndex];
        outIndex = 0;
    L10:
        outBlock[outIndex] = block[(i * jWidth) + jColumn];
        i = i + 1;
        outIndex = outIndex + 1;
        goto L6
    L11:
        iBlock = iBlock + 1;
        goto L4
    L13:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setColumnMatrix(int column, RealMatrix matrix) throws MatrixIndexException, InvalidMatrixException {
        setColumnMatrix(column, (BlockRealMatrix) matrix);     // Catch: ClassCastException -> L4
        return;
    L5:
        super.setColumnMatrix(column, matrix);
    }

    void setColumnMatrix(int column, BlockRealMatrix matrix) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkColumnIndex(this, column);
        int nRows = getRowDimension();
        if (matrix.getRowDimension() != nRows) goto L19;
        if (matrix.getColumnDimension() != 1) goto L19;
        int jBlock = column / 52;
        int jColumn = column - (jBlock * 52);
        int jWidth = blockWidth(jBlock);
        int mBlockIndex = 0;
        int mIndex = 0;
        double[] mBlock = matrix.blocks[0];
        int iBlock = 0;
    L8:
        if (iBlock >= this.blockRows) goto L17;
        int iHeight = blockHeight(iBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int i = 0;
    L10:
        if (i >= iHeight) goto L15;
        if (mIndex < mBlock.length) goto L14;
        mBlockIndex = mBlockIndex + 1;
        mBlock = matrix.blocks[mBlockIndex];
        mIndex = 0;
    L14:
        block[(i * jWidth) + jColumn] = mBlock[mIndex];
        i = i + 1;
        mIndex = mIndex + 1;
        goto L10
    L15:
        iBlock = iBlock + 1;
        goto L8
    L17:
        return;
    L19:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(matrix.getRowDimension()), Integer.valueOf(matrix.getColumnDimension()), Integer.valueOf(nRows), 1});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public RealVector getRowVector(int row) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        double[] outData = new double[this.columns];
        int iBlock = row / 52;
        int iRow = row - (iBlock * 52);
        int outIndex = 0;
        int jBlock = 0;
    L4:
        if (jBlock >= this.blockColumns) goto L7;
        int jWidth = blockWidth(jBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        System.arraycopy(block, iRow * jWidth, outData, outIndex, jWidth);
        outIndex = outIndex + jWidth;
        jBlock = jBlock + 1;
        goto L4
    L7:
        return new ArrayRealVector(outData, false);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setRowVector(int row, RealVector vector) throws MatrixIndexException, InvalidMatrixException {
        setRow(row, ((ArrayRealVector) vector).getDataRef());     // Catch: ClassCastException -> L4
        return;
    L5:
        super.setRowVector(row, vector);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public RealVector getColumnVector(int column) throws MatrixIndexException {
        MatrixUtils.checkColumnIndex(this, column);
        double[] outData = new double[this.rows];
        int jBlock = column / 52;
        int jColumn = column - (jBlock * 52);
        int jWidth = blockWidth(jBlock);
        int outIndex = 0;
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L10;
        int iHeight = blockHeight(iBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int i = 0;
    L6:
        if (i >= iHeight) goto L8;
        outData[outIndex] = block[(i * jWidth) + jColumn];
        i = i + 1;
        outIndex = outIndex + 1;
        goto L6
    L8:
        iBlock = iBlock + 1;
        goto L4
    L10:
        return new ArrayRealVector(outData, false);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setColumnVector(int column, RealVector vector) throws MatrixIndexException, InvalidMatrixException {
        setColumn(column, ((ArrayRealVector) vector).getDataRef());     // Catch: ClassCastException -> L4
        return;
    L5:
        super.setColumnVector(column, vector);
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double[] getRow(int row) throws MatrixIndexException {
        MatrixUtils.checkRowIndex(this, row);
        double[] out = new double[this.columns];
        int iBlock = row / 52;
        int iRow = row - (iBlock * 52);
        int outIndex = 0;
        int jBlock = 0;
    L4:
        if (jBlock >= this.blockColumns) goto L7;
        int jWidth = blockWidth(jBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        System.arraycopy(block, iRow * jWidth, out, outIndex, jWidth);
        outIndex = outIndex + jWidth;
        jBlock = jBlock + 1;
        goto L4
    L7:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setRow(int row, double[] array) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkRowIndex(this, row);
        int nCols = getColumnDimension();
        if (array.length != nCols) goto L11;
        int iBlock = row / 52;
        int iRow = row - (iBlock * 52);
        int outIndex = 0;
        int jBlock = 0;
    L6:
        if (jBlock >= this.blockColumns) goto L9;
        int jWidth = blockWidth(jBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        System.arraycopy(array, outIndex, block, iRow * jWidth, jWidth);
        outIndex = outIndex + jWidth;
        jBlock = jBlock + 1;
        goto L6
    L9:
        return;
    L11:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{1, Integer.valueOf(array.length), 1, Integer.valueOf(nCols)});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double[] getColumn(int column) throws MatrixIndexException {
        MatrixUtils.checkColumnIndex(this, column);
        double[] out = new double[this.rows];
        int jBlock = column / 52;
        int jColumn = column - (jBlock * 52);
        int jWidth = blockWidth(jBlock);
        int outIndex = 0;
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L10;
        int iHeight = blockHeight(iBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int i = 0;
    L6:
        if (i >= iHeight) goto L8;
        out[outIndex] = block[(i * jWidth) + jColumn];
        i = i + 1;
        outIndex = outIndex + 1;
        goto L6
    L8:
        iBlock = iBlock + 1;
        goto L4
    L10:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setColumn(int column, double[] array) throws MatrixIndexException, InvalidMatrixException {
        MatrixUtils.checkColumnIndex(this, column);
        int nRows = getRowDimension();
        if (array.length != nRows) goto L14;
        int jBlock = column / 52;
        int jColumn = column - (jBlock * 52);
        int jWidth = blockWidth(jBlock);
        int outIndex = 0;
        int iBlock = 0;
    L6:
        if (iBlock >= this.blockRows) goto L12;
        int iHeight = blockHeight(iBlock);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int i = 0;
    L8:
        if (i >= iHeight) goto L10;
        block[(i * jWidth) + jColumn] = array[outIndex];
        i = i + 1;
        outIndex = outIndex + 1;
        goto L8
    L10:
        iBlock = iBlock + 1;
        goto L6
    L12:
        return;
    L14:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(array.length), 1, Integer.valueOf(nRows), 1});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double getEntry(int row, int column) throws MatrixIndexException {
        int iBlock = row / 52;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int jBlock = column / 52;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int k = ((row - (iBlock * 52)) * blockWidth(jBlock)) + (column - (jBlock * 52));     // Catch: ArrayIndexOutOfBoundsException -> L4
        return this.blocks[(this.blockColumns * iBlock) + jBlock][k];
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void setEntry(int row, int column, double value) throws MatrixIndexException {
        int iBlock = row / 52;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int jBlock = column / 52;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int k = ((row - (iBlock * 52)) * blockWidth(jBlock)) + (column - (jBlock * 52));     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.blocks[(this.blockColumns * iBlock) + jBlock][k] = value;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void addToEntry(int row, int column, double increment) throws MatrixIndexException {
        int iBlock = row / 52;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int jBlock = column / 52;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int k = ((row - (iBlock * 52)) * blockWidth(jBlock)) + (column - (jBlock * 52));     // Catch: ArrayIndexOutOfBoundsException -> L4
        double[] r3 = this.blocks[(this.blockColumns * iBlock) + jBlock];     // Catch: ArrayIndexOutOfBoundsException -> L4
        r3[k] = r3[k] + increment;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public void multiplyEntry(int row, int column, double factor) throws MatrixIndexException {
        int iBlock = row / 52;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int jBlock = column / 52;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int k = ((row - (iBlock * 52)) * blockWidth(jBlock)) + (column - (jBlock * 52));     // Catch: ArrayIndexOutOfBoundsException -> L4
        double[] r3 = this.blocks[(this.blockColumns * iBlock) + jBlock];     // Catch: ArrayIndexOutOfBoundsException -> L4
        r3[k] = r3[k] * factor;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public BlockRealMatrix transpose() {
        BlockRealMatrix r0 = this;
        int nRows = r0.getRowDimension();
        int nCols = r0.getColumnDimension();
        BlockRealMatrix out = new BlockRealMatrix(nCols, nRows);
        int blockIndex = 0;
        int iBlock = 0;
    L4:
        if (iBlock >= r0.blockColumns) goto L17;
        int jBlock = 0;
    L7:
        if (jBlock >= r0.blockRows) goto L15;
        double[] outBlock = out.blocks[blockIndex];
        double[] tBlock = r0.blocks[(r0.blockColumns * jBlock) + iBlock];
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, r0.columns);
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, r0.rows);
        int k = 0;
        int p = pStart;
    L9:
        if (p >= pEnd) goto L14;
        int lInc = pEnd - pStart;
        int l = p - pStart;
        int q = qStart;
    L11:
        if (q >= qEnd) goto L13;
        outBlock[k] = tBlock[l];
        k = k + 1;
        l = l + lInc;
        q = q + 1;
        goto L11
    L13:
        p = p + 1;
        goto L9
    L14:
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        r0 = this;
        goto L7
    L15:
        iBlock = iBlock + 1;
        r0 = this;
        goto L4
    L17:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double[] operate(double[] v) throws IllegalArgumentException {
        if (v.length != this.columns) goto L24;
        double[] out = new double[this.rows];
        int iBlock = 0;
    L6:
        if (iBlock >= this.blockRows) goto L22;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, this.rows);
        int jBlock = 0;
    L9:
        if (jBlock >= this.blockColumns) goto L20;
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, this.columns);
        int k = 0;
        int p = pStart;
    L11:
        if (p >= pEnd) goto L19;
        double sum = 0.0d;
        int q = qStart;
    L14:
        if (q >= (qEnd - 3)) goto L16;
        sum = sum + ((((block[k] * v[q]) + (block[k + 1] * v[q + 1])) + (block[k + 2] * v[q + 2])) + (block[k + 3] * v[q + 3]));
        k = k + 4;
        q = q + 4;
    L16:
        if (q >= qEnd) goto L18;
        sum = sum + (block[k] * v[q]);
        q = q + 1;
        k = k + 1;
        goto L16
    L18:
        out[p] = out[p] + sum;
        p = p + 1;
        goto L11
    L19:
        jBlock = jBlock + 1;
        goto L9
    L20:
        iBlock = iBlock + 1;
        goto L6
    L22:
        return out;
    L24:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(v.length), Integer.valueOf(this.columns)});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double[] preMultiply(double[] v) throws IllegalArgumentException {
        if (v.length != this.rows) goto L24;
        double[] out = new double[this.columns];
        int jBlock = 0;
    L6:
        if (jBlock >= this.blockColumns) goto L22;
        int jWidth = blockWidth(jBlock);
        int jWidth2 = jWidth + jWidth;
        int jWidth3 = jWidth2 + jWidth;
        int jWidth4 = jWidth3 + jWidth;
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, this.columns);
        int iBlock = 0;
    L9:
        if (iBlock >= this.blockRows) goto L20;
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, this.rows);
        int q = qStart;
    L11:
        if (q >= qEnd) goto L19;
        int k = q - qStart;
        double sum = 0.0d;
        double[] out2 = out;
        int p = pStart;
    L13:
        int jBlock2 = jBlock;
        int jBlock3 = pEnd - 3;
        if (p >= jBlock3) goto L16;
        sum = sum + ((((block[k] * v[p]) + (block[k + jWidth] * v[p + 1])) + (block[k + jWidth2] * v[p + 2])) + (block[k + jWidth3] * v[p + 3]));
        k = k + jWidth4;
        p = p + 4;
        jBlock = jBlock2;
    L16:
        if (p >= pEnd) goto L18;
        sum = sum + (block[k] * v[p]);
        k = k + jWidth;
        p = p + 1;
        goto L16
    L18:
        out2[q] = out2[q] + sum;
        q = q + 1;
        out = out2;
        jBlock = jBlock2;
        goto L11
    L19:
        iBlock = iBlock + 1;
        goto L9
    L20:
        jBlock = jBlock + 1;
        goto L6
    L22:
        return out;
    L24:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(v.length), Integer.valueOf(this.rows)});
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor visitor) throws MatrixVisitorException {
        visitor.start(this.rows, this.columns, 0, this.rows - 1, 0, this.columns - 1);
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L17;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, this.rows);
        int p = pStart;
    L6:
        if (p >= pEnd) goto L15;
        int jBlock = 0;
    L9:
        if (jBlock >= this.blockColumns) goto L14;
        int jWidth = blockWidth(jBlock);
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, this.columns);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int k = (p - pStart) * jWidth;
        int q = qStart;
    L11:
        if (q >= qEnd) goto L13;
        block[k] = visitor.visit(p, q, block[k]);
        k = k + 1;
        q = q + 1;
        goto L11
    L13:
        jBlock = jBlock + 1;
        goto L9
    L14:
        p = p + 1;
        goto L6
    L15:
        iBlock = iBlock + 1;
        goto L4
    L17:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor visitor) throws MatrixVisitorException {
        visitor.start(this.rows, this.columns, 0, this.rows - 1, 0, this.columns - 1);
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L17;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, this.rows);
        int p = pStart;
    L6:
        if (p >= pEnd) goto L15;
        int jBlock = 0;
    L9:
        if (jBlock >= this.blockColumns) goto L14;
        int jWidth = blockWidth(jBlock);
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, this.columns);
        double[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int k = (p - pStart) * jWidth;
        int q = qStart;
    L11:
        if (q >= qEnd) goto L13;
        visitor.visit(p, q, block[k]);
        k = k + 1;
        q = q + 1;
        goto L11
    L13:
        jBlock = jBlock + 1;
        goto L9
    L14:
        p = p + 1;
        goto L6
    L15:
        iBlock = iBlock + 1;
        goto L4
    L17:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        BlockRealMatrix r0 = this;
        MatrixUtils.checkSubMatrixIndex(r0, startRow, endRow, startColumn, endColumn);
        visitor.start(r0.rows, r0.columns, startRow, endRow, startColumn, endColumn);
        int iBlock = startRow / 52;
    L4:
        if (iBlock >= ((endRow / 52) + 1)) goto L17;
        int p0 = iBlock * 52;
        int pStart = FastMath.max(startRow, p0);
        int pEnd = FastMath.min((iBlock + 1) * 52, endRow + 1);
        int p = pStart;
    L6:
        if (p >= pEnd) goto L15;
        int jBlock = startColumn / 52;
    L9:
        if (jBlock >= ((endColumn / 52) + 1)) goto L14;
        int jWidth = r0.blockWidth(jBlock);
        int q0 = jBlock * 52;
        int qStart = FastMath.max(startColumn, q0);
        int qEnd = FastMath.min((jBlock + 1) * 52, endColumn + 1);
        double[] block = r0.blocks[(r0.blockColumns * iBlock) + jBlock];
        int k = (((p - p0) * jWidth) + qStart) - q0;
        int q = qStart;
    L11:
        if (q >= qEnd) goto L13;
        block[k] = visitor.visit(p, q, block[k]);
        k = k + 1;
        q = q + 1;
        iBlock = iBlock;
        p0 = p0;
        goto L11
    L13:
        jBlock = jBlock + 1;
        r0 = this;
        p0 = p0;
        goto L9
    L14:
        p = p + 1;
        r0 = this;
        p0 = p0;
        goto L6
    L15:
        iBlock = iBlock + 1;
        r0 = this;
        goto L4
    L17:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        BlockRealMatrix r0 = this;
        MatrixUtils.checkSubMatrixIndex(r0, startRow, endRow, startColumn, endColumn);
        visitor.start(r0.rows, r0.columns, startRow, endRow, startColumn, endColumn);
        int iBlock = startRow / 52;
    L4:
        if (iBlock >= ((endRow / 52) + 1)) goto L17;
        int p0 = iBlock * 52;
        int pStart = FastMath.max(startRow, p0);
        int pEnd = FastMath.min((iBlock + 1) * 52, endRow + 1);
        int p = pStart;
    L6:
        if (p >= pEnd) goto L15;
        int jBlock = startColumn / 52;
    L9:
        if (jBlock >= ((endColumn / 52) + 1)) goto L14;
        int jWidth = r0.blockWidth(jBlock);
        int q0 = jBlock * 52;
        int qStart = FastMath.max(startColumn, q0);
        int qEnd = FastMath.min((jBlock + 1) * 52, endColumn + 1);
        double[] block = r0.blocks[(r0.blockColumns * iBlock) + jBlock];
        int k = (((p - p0) * jWidth) + qStart) - q0;
        int q = qStart;
    L11:
        if (q >= qEnd) goto L13;
        visitor.visit(p, q, block[k]);
        k = k + 1;
        q = q + 1;
        iBlock = iBlock;
        p0 = p0;
        goto L11
    L13:
        jBlock = jBlock + 1;
        r0 = this;
        p0 = p0;
        goto L9
    L14:
        p = p + 1;
        r0 = this;
        p0 = p0;
        goto L6
    L15:
        iBlock = iBlock + 1;
        r0 = this;
        goto L4
    L17:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor visitor) throws MatrixVisitorException {
        visitor.start(this.rows, this.columns, 0, this.rows - 1, 0, this.columns - 1);
        int blockIndex = 0;
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L17;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, this.rows);
        int jBlock = 0;
    L7:
        if (jBlock >= this.blockColumns) goto L15;
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, this.columns);
        double[] block = this.blocks[blockIndex];
        int k = 0;
        int p = pStart;
    L9:
        if (p >= pEnd) goto L14;
        int q = qStart;
    L11:
        if (q >= qEnd) goto L13;
        block[k] = visitor.visit(p, q, block[k]);
        k = k + 1;
        q = q + 1;
        goto L11
    L13:
        p = p + 1;
        goto L9
    L14:
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        goto L7
    L15:
        iBlock = iBlock + 1;
        goto L4
    L17:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor visitor) throws MatrixVisitorException {
        visitor.start(this.rows, this.columns, 0, this.rows - 1, 0, this.columns - 1);
        int blockIndex = 0;
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L17;
        int pStart = iBlock * 52;
        int pEnd = FastMath.min(pStart + 52, this.rows);
        int jBlock = 0;
    L7:
        if (jBlock >= this.blockColumns) goto L15;
        int qStart = jBlock * 52;
        int qEnd = FastMath.min(qStart + 52, this.columns);
        double[] block = this.blocks[blockIndex];
        int k = 0;
        int p = pStart;
    L9:
        if (p >= pEnd) goto L14;
        int q = qStart;
    L11:
        if (q >= qEnd) goto L13;
        visitor.visit(p, q, block[k]);
        k = k + 1;
        q = q + 1;
        goto L11
    L13:
        p = p + 1;
        goto L9
    L14:
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        goto L7
    L15:
        iBlock = iBlock + 1;
        goto L4
    L17:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        BlockRealMatrix r0 = this;
        MatrixUtils.checkSubMatrixIndex(r0, startRow, endRow, startColumn, endColumn);
        visitor.start(r0.rows, r0.columns, startRow, endRow, startColumn, endColumn);
        int iBlock = startRow / 52;
    L4:
        if (iBlock >= ((endRow / 52) + 1)) goto L17;
        int p0 = iBlock * 52;
        int pStart = FastMath.max(startRow, p0);
        int pEnd = FastMath.min((iBlock + 1) * 52, endRow + 1);
        int jBlock = startColumn / 52;
    L7:
        if (jBlock >= ((endColumn / 52) + 1)) goto L15;
        int jWidth = r0.blockWidth(jBlock);
        int q0 = jBlock * 52;
        int qStart = FastMath.max(startColumn, q0);
        int qEnd = FastMath.min((jBlock + 1) * 52, endColumn + 1);
        double[] block = r0.blocks[(r0.blockColumns * iBlock) + jBlock];
        int p = pStart;
    L9:
        if (p >= pEnd) goto L14;
        int k = (((p - p0) * jWidth) + qStart) - q0;
        int q = qStart;
    L11:
        if (q >= qEnd) goto L13;
        block[k] = visitor.visit(p, q, block[k]);
        k = k + 1;
        q = q + 1;
        iBlock = iBlock;
        p0 = p0;
        goto L11
    L13:
        p = p + 1;
        p0 = p0;
        goto L9
    L14:
        jBlock = jBlock + 1;
        r0 = this;
        p0 = p0;
        goto L7
    L15:
        iBlock = iBlock + 1;
        r0 = this;
        goto L4
    L17:
        return visitor.end();
    }

    @Override // org.apache.commons.math.linear.AbstractRealMatrix, org.apache.commons.math.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException, MatrixVisitorException {
        BlockRealMatrix r0 = this;
        MatrixUtils.checkSubMatrixIndex(r0, startRow, endRow, startColumn, endColumn);
        visitor.start(r0.rows, r0.columns, startRow, endRow, startColumn, endColumn);
        int iBlock = startRow / 52;
    L4:
        if (iBlock >= ((endRow / 52) + 1)) goto L17;
        int p0 = iBlock * 52;
        int pStart = FastMath.max(startRow, p0);
        int pEnd = FastMath.min((iBlock + 1) * 52, endRow + 1);
        int jBlock = startColumn / 52;
    L7:
        if (jBlock >= ((endColumn / 52) + 1)) goto L15;
        int jWidth = r0.blockWidth(jBlock);
        int q0 = jBlock * 52;
        int qStart = FastMath.max(startColumn, q0);
        int qEnd = FastMath.min((jBlock + 1) * 52, endColumn + 1);
        double[] block = r0.blocks[(r0.blockColumns * iBlock) + jBlock];
        int p = pStart;
    L9:
        if (p >= pEnd) goto L14;
        int k = (((p - p0) * jWidth) + qStart) - q0;
        int q = qStart;
    L11:
        if (q >= qEnd) goto L13;
        visitor.visit(p, q, block[k]);
        k = k + 1;
        q = q + 1;
        iBlock = iBlock;
        p0 = p0;
        goto L11
    L13:
        p = p + 1;
        p0 = p0;
        goto L9
    L14:
        jBlock = jBlock + 1;
        r0 = this;
        p0 = p0;
        goto L7
    L15:
        iBlock = iBlock + 1;
        r0 = this;
        goto L4
    L17:
        return visitor.end();
    }

    private int blockHeight(int blockRow) {
        if (blockRow == (this.blockRows - 1)) goto L7;
        return 52;
    L7:
        return this.rows - (blockRow * 52);
    }

    private int blockWidth(int blockColumn) {
        if (blockColumn == (this.blockColumns - 1)) goto L7;
        return 52;
    L7:
        return this.columns - (blockColumn * 52);
    }
}
