package org.apache.commons.math.linear;

import java.io.Serializable;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class BlockFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> implements Serializable {
    public static final int BLOCK_SIZE = 36;
    private static final long serialVersionUID = -4602336630143123183L;
    private final int blockColumns;
    private final int blockRows;
    private final T[][] blocks;
    private final int columns;
    private final int rows;

    public BlockFieldMatrix(Field<T> r2, int r3, int r4) throws IllegalArgumentException {
        super(r2, r3, r4);
        this.rows = r3;
        this.columns = r4;
        this.blockRows = ((r3 + 36) - 1) / 36;
        this.blockColumns = ((r4 + 36) - 1) / 36;
        this.blocks = (T[][]) createBlocksLayout(r2, r3, r4);
    }

    public BlockFieldMatrix(T[][] rawData) throws IllegalArgumentException {
        this(rawData.length, rawData[0].length, toBlocksLayout(rawData), false);
    }

    public BlockFieldMatrix(int r8, int r9, T[][] r10, boolean r11) throws IllegalArgumentException {
        super(AbstractFieldMatrix.extractField(r10), r8, r9);
        this.rows = r8;
        this.columns = r9;
        this.blockRows = ((r8 + 36) - 1) / 36;
        this.blockColumns = ((r9 + 36) - 1) / 36;
        if (r11 == false) goto L5;
        this.blocks = (T[][]) AbstractFieldMatrix.buildArray(getField(), this.blockRows * this.blockColumns, -1);
    L6:
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r1 >= this.blockRows) goto L21;
        int r2 = blockHeight(r1);
        int r3 = 0;
    L11:
        if (r3 >= this.blockColumns) goto L19;
        if (r10[r0].length != (blockWidth(r3) * r2)) goto L18;
        if (r11 == false) goto L16;
        ((T[][]) this.blocks)[r0] = (FieldElement[]) r10[r0].clone();
    L16:
        r3 = r3 + 1;
        r0 = r0 + 1;
        goto L11
    L18:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.WRONG_BLOCK_LENGTH, new Object[]{Integer.valueOf(r10[r0].length), Integer.valueOf(blockWidth(r3) * r2)});
    L19:
        r1 = r1 + 1;
        goto L8
    L21:
        return;
    L5:
        this.blocks = r10;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends FieldElement<T>> T[][] toBlocksLayout(T[][] r19) throws IllegalArgumentException {
        int r1 = r19.length;
        int r2 = r19[0].length;
        int r3 = ((r1 + 36) - 1) / 36;
        int r4 = ((r2 + 36) - 1) / 36;
        int r5 = 0;
    L4:
        if (r5 >= r19.length) goto L10;
        int r6 = r19[r5].length;
        if (r6 != r2) goto L9;
        r5 = r5 + 1;
        goto L4
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(r2), Integer.valueOf(r6)});
    L10:
        Field r7 = AbstractFieldMatrix.extractField(r19);
        T[][] r8 = (T[][]) AbstractFieldMatrix.buildArray(r7, r3 * r4, -1);
        int r9 = 0;
        int r10 = 0;
    L11:
        if (r10 >= r3) goto L20;
        int r11 = r10 * 36;
        int r12 = FastMath.min(r11 + 36, r1);
        int r13 = r12 - r11;
        int r14 = 0;
    L13:
        if (r14 >= r4) goto L18;
        int r15 = r14 * 36;
        int r16 = FastMath.min(r15 + 36, r2) - r15;
        FieldElement[] r0 = AbstractFieldMatrix.buildArray(r7, r13 * r16);
        r8[r9] = r0;
        int r18 = r1;
        int r17 = 0;
        int r110 = r2;
        int r20 = r11;
    L15:
        if (r20 >= r12) goto L17;
        int r111 = r20;
        System.arraycopy(r19[r111], r15, r0, r17, r16);
        r17 = r17 + r16;
        r20 = r111 + 1;
        goto L15
    L17:
        r9 = r9 + 1;
        r14 = r14 + 1;
        r2 = r110;
        r1 = r18;
        goto L13
    L18:
        r10 = r10 + 1;
        goto L11
    L20:
        return r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends FieldElement<T>> T[][] createBlocksLayout(Field<T> r13, int r14, int r15) {
        int r0 = ((r14 + 36) - 1) / 36;
        int r1 = ((r15 + 36) - 1) / 36;
        T[][] r2 = (T[][]) AbstractFieldMatrix.buildArray(r13, r0 * r1, -1);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L9;
        int r5 = r4 * 36;
        int r7 = FastMath.min(r5 + 36, r14) - r5;
        int r8 = 0;
    L5:
        if (r8 >= r1) goto L7;
        int r9 = r8 * 36;
        r2[r3] = AbstractFieldMatrix.buildArray(r13, r7 * (FastMath.min(r9 + 36, r15) - r9));
        r3 = r3 + 1;
        r8 = r8 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L9:
        return r2;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> createMatrix(int rowDimension, int columnDimension) throws IllegalArgumentException {
        return new BlockFieldMatrix(getField(), rowDimension, columnDimension);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> copy() {
        BlockFieldMatrix<T> copied = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int i = 0;
    L4:
        if (i >= this.blocks.length) goto L7;
        System.arraycopy(this.blocks[i], 0, copied.blocks[i], 0, this.blocks[i].length);
        i = i + 1;
        goto L4
    L7:
        return copied;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> add(FieldMatrix<T> r18) throws IllegalArgumentException {
        BlockFieldMatrix<T> r1 = this;
        return r1.add((BlockFieldMatrix) r18);
    L5:
        e = e;
        checkAdditionCompatible(r18);
        BlockFieldMatrix r3 = new BlockFieldMatrix(r1.getField(), r1.rows, r1.columns);
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r5 >= r3.blockRows) goto L21;
        int r6 = 0;
    L11:
        if (r6 >= r3.blockColumns) goto L19;
        FieldElement[] r7 = ((T[][]) r3.blocks)[r4];
        T[] r8 = r1.blocks[r4];
        int r9 = r5 * 36;
        int r10 = FastMath.min(r9 + 36, r1.rows);
        int r11 = r6 * 36;
        int r12 = FastMath.min(r11 + 36, r1.columns);
        int r13 = 0;
        int r14 = r9;
    L13:
        if (r14 >= r10) goto L18;
        int r15 = r11;
    L15:
        if (r15 >= r12) goto L17;
        ClassCastException r16 = e;
        r7[r13] = (FieldElement) r8[r13].add(r18.getEntry(r14, r15));
        r13 = r13 + 1;
        r15 = r15 + 1;
        e = r16;
        goto L15
    L17:
        r14 = r14 + 1;
        goto L13
    L18:
        r4 = r4 + 1;
        r6 = r6 + 1;
        r1 = this;
        goto L11
    L19:
        r5 = r5 + 1;
        r1 = this;
        goto L8
    L21:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockFieldMatrix<T> add(BlockFieldMatrix<T> r9) throws IllegalArgumentException {
        checkAdditionCompatible(r9);
        BlockFieldMatrix<T> r0 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r1 = 0;
    L4:
        if (r1 >= r0.blocks.length) goto L11;
        FieldElement[] r2 = ((T[][]) r0.blocks)[r1];
        T[] r3 = this.blocks[r1];
        T[] r4 = r9.blocks[r1];
        int r5 = 0;
    L7:
        if (r5 >= r2.length) goto L9;
        r2[r5] = (FieldElement) r3[r5].add(r4[r5]);
        r5 = r5 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> subtract(FieldMatrix<T> r18) throws IllegalArgumentException {
        BlockFieldMatrix<T> r1 = this;
        return r1.subtract((BlockFieldMatrix) r18);
    L5:
        e = e;
        checkSubtractionCompatible(r18);
        BlockFieldMatrix r3 = new BlockFieldMatrix(r1.getField(), r1.rows, r1.columns);
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r5 >= r3.blockRows) goto L21;
        int r6 = 0;
    L11:
        if (r6 >= r3.blockColumns) goto L19;
        FieldElement[] r7 = ((T[][]) r3.blocks)[r4];
        T[] r8 = r1.blocks[r4];
        int r9 = r5 * 36;
        int r10 = FastMath.min(r9 + 36, r1.rows);
        int r11 = r6 * 36;
        int r12 = FastMath.min(r11 + 36, r1.columns);
        int r13 = 0;
        int r14 = r9;
    L13:
        if (r14 >= r10) goto L18;
        int r15 = r11;
    L15:
        if (r15 >= r12) goto L17;
        ClassCastException r16 = e;
        r7[r13] = (FieldElement) r8[r13].subtract(r18.getEntry(r14, r15));
        r13 = r13 + 1;
        r15 = r15 + 1;
        e = r16;
        goto L15
    L17:
        r14 = r14 + 1;
        goto L13
    L18:
        r4 = r4 + 1;
        r6 = r6 + 1;
        r1 = this;
        goto L11
    L19:
        r5 = r5 + 1;
        r1 = this;
        goto L8
    L21:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockFieldMatrix<T> subtract(BlockFieldMatrix<T> r9) throws IllegalArgumentException {
        checkSubtractionCompatible(r9);
        BlockFieldMatrix<T> r0 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r1 = 0;
    L4:
        if (r1 >= r0.blocks.length) goto L11;
        FieldElement[] r2 = ((T[][]) r0.blocks)[r1];
        T[] r3 = this.blocks[r1];
        T[] r4 = r9.blocks[r1];
        int r5 = 0;
    L7:
        if (r5 >= r2.length) goto L9;
        r2[r5] = (FieldElement) r3[r5].subtract(r4[r5]);
        r5 = r5 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> scalarAdd(T r7) throws IllegalArgumentException {
        BlockFieldMatrix r0 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r1 = 0;
    L4:
        if (r1 >= r0.blocks.length) goto L11;
        FieldElement[] r2 = ((T[][]) r0.blocks)[r1];
        T[] r3 = this.blocks[r1];
        int r4 = 0;
    L7:
        if (r4 >= r2.length) goto L9;
        r2[r4] = (FieldElement) r3[r4].add(r7);
        r4 = r4 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> scalarMultiply(T r7) throws IllegalArgumentException {
        BlockFieldMatrix r0 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r1 = 0;
    L4:
        if (r1 >= r0.blocks.length) goto L11;
        FieldElement[] r2 = ((T[][]) r0.blocks)[r1];
        T[] r3 = this.blocks[r1];
        int r4 = 0;
    L7:
        if (r4 >= r2.length) goto L9;
        r2[r4] = (FieldElement) r3[r4].multiply(r7);
        r4 = r4 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> multiply(FieldMatrix<T> m) throws IllegalArgumentException {
        BlockFieldMatrix<T> r1 = this;
        return r1.multiply((BlockFieldMatrix) m);
    L5:
        cce = e;
        checkMultiplicationCompatible(m);
        BlockFieldMatrix<T> out = new BlockFieldMatrix(r1.getField(), r1.rows, m.getColumnDimension());
        T zero = r1.getField().getZero();
        int blockIndex = 0;
        int iBlock = 0;
    L8:
        if (iBlock >= out.blockRows) goto L28;
        int pStart = iBlock * 36;
        int pEnd = FastMath.min(pStart + 36, r1.rows);
        int jBlock = 0;
    L11:
        if (jBlock >= out.blockColumns) goto L26;
        int qStart = jBlock * 36;
        int qEnd = FastMath.min(qStart + 36, m.getColumnDimension());
        FieldElement[] r12 = out.blocks[blockIndex];
        int kBlock = 0;
    L14:
        if (kBlock >= r1.blockColumns) goto L25;
        int kWidth = r1.blockWidth(kBlock);
        ClassCastException cce = cce;
        T[] tBlock = r1.blocks[(r1.blockColumns * iBlock) + kBlock];
        int rStart = kBlock * 36;
        int k = 0;
        int lEnd = pStart;
    L16:
        if (lEnd >= pEnd) goto L24;
        int lStart = (lEnd - pStart) * kWidth;
        int p = lEnd;
        int lEnd2 = lStart + kWidth;
        int q = qStart;
    L18:
        if (q >= qEnd) goto L23;
        T sum = zero;
        BlockFieldMatrix<T> out2 = out;
        FieldElement r3 = sum;
        int r = rStart;
        int r2 = blockIndex;
        int blockIndex2 = lStart;
    L20:
        if (blockIndex2 >= lEnd2) goto L22;
        int lEnd3 = lEnd2;
        int l = blockIndex2;
        r3 = (FieldElement) r3.add((FieldElement) tBlock[blockIndex2].multiply(m.getEntry(r, q)));
        r = r + 1;
        blockIndex2 = l + 1;
        lEnd2 = lEnd3;
        goto L20
    L22:
        int lEnd4 = lEnd2;
        r12[k] = (FieldElement) r12[k].add(r3);
        k = k + 1;
        q = q + 1;
        zero = sum;
        blockIndex = r2;
        lEnd2 = lEnd4;
        out = out2;
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

    public BlockFieldMatrix<T> multiply(BlockFieldMatrix<T> m) throws IllegalArgumentException {
        BlockFieldMatrix<T> r0 = this;
        BlockFieldMatrix<T> r1 = m;
        checkMultiplicationCompatible(m);
        BlockFieldMatrix<T> out = new BlockFieldMatrix(r0.getField(), r0.rows, r1.columns);
        T zero = r0.getField().getZero();
        int blockIndex = 0;
        int iBlock = 0;
    L4:
        if (iBlock >= out.blockRows) goto L28;
        int pStart = iBlock * 36;
        int pEnd = FastMath.min(pStart + 36, r0.rows);
        int jBlock = 0;
    L7:
        if (jBlock >= out.blockColumns) goto L26;
        int jWidth = out.blockWidth(jBlock);
        int jWidth2 = jWidth + jWidth;
        int jWidth3 = jWidth2 + jWidth;
        int jWidth4 = jWidth3 + jWidth;
        FieldElement[] r13 = out.blocks[blockIndex];
        int kBlock = 0;
    L10:
        if (kBlock >= r0.blockColumns) goto L25;
        int kWidth = r0.blockWidth(kBlock);
        BlockFieldMatrix<T> out2 = out;
        T[] tBlock = r0.blocks[(r0.blockColumns * iBlock) + kBlock];
        T[] mBlock = r1.blocks[(r1.blockColumns * kBlock) + jBlock];
        int k = 0;
        int lEnd = pStart;
    L12:
        if (lEnd >= pEnd) goto L24;
        int lStart = (lEnd - pStart) * kWidth;
        int p = lEnd;
        int lEnd2 = lStart + kWidth;
        int nStart = 0;
    L14:
        if (nStart >= jWidth) goto L23;
        T sum = zero;
        int n = nStart;
        int nStart2 = nStart;
        FieldElement r2 = sum;
        T[] tBlock2 = tBlock;
        int l = lStart;
    L16:
        T zero2 = zero;
        if (l >= (lEnd2 - 3)) goto L20;
        int l2 = l;
        FieldElement r3 = (FieldElement) r2.add((FieldElement) tBlock2[l].multiply(mBlock[n]));
        T r4 = tBlock2[l2 + 1];
        T sum2 = mBlock[n + jWidth];
        r2 = (FieldElement) ((FieldElement) ((FieldElement) r3.add((FieldElement) r4.multiply(sum2))).add((FieldElement) tBlock2[l2 + 2].multiply(mBlock[n + jWidth2]))).add((FieldElement) tBlock2[l2 + 3].multiply(mBlock[n + jWidth3]));
        l = l2 + 4;
        n = n + jWidth4;
        zero = zero2;
    L20:
        if (l >= lEnd2) goto L22;
        r2 = (FieldElement) r2.add((FieldElement) tBlock2[l].multiply(mBlock[n]));
        n = n + jWidth;
        l = l + 1;
        lEnd2 = lEnd2;
        goto L20
    L22:
        r13[k] = (FieldElement) r13[k].add(r2);
        k = k + 1;
        nStart = nStart2 + 1;
        tBlock = tBlock2;
        zero = zero2;
        lEnd2 = lEnd2;
        goto L14
    L23:
        lEnd = p + 1;
        goto L12
    L24:
        kBlock = kBlock + 1;
        r0 = this;
        r1 = m;
        out = out2;
        goto L10
    L25:
        blockIndex = blockIndex + 1;
        jBlock = jBlock + 1;
        r0 = this;
        r1 = m;
        goto L7
    L26:
        iBlock = iBlock + 1;
        r0 = this;
        r1 = m;
        goto L4
    L28:
        return out;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T[][] getData() {
        T[][] r0 = (T[][]) AbstractFieldMatrix.buildArray(getField(), getRowDimension(), getColumnDimension());
        int r1 = this.columns - ((this.blockColumns - 1) * 36);
        int r2 = 0;
    L4:
        if (r2 >= this.blockRows) goto L14;
        int r4 = r2 * 36;
        int r5 = FastMath.min(r4 + 36, this.rows);
        int r6 = 0;
        int r7 = 0;
        int r8 = r4;
    L6:
        if (r8 >= r5) goto L12;
        T[] r9 = r0[r8];
        int r10 = this.blockColumns * r2;
        int r11 = 0;
        int r12 = 0;
    L9:
        if (r12 >= (this.blockColumns - 1)) goto L11;
        System.arraycopy(this.blocks[r10], r6, r9, r11, 36);
        r11 = r11 + 36;
        r12 = r12 + 1;
        r10 = r10 + 1;
        goto L9
    L11:
        System.arraycopy(this.blocks[r10], r7, r9, r11, r1);
        r6 = r6 + 36;
        r7 = r7 + r1;
        r8 = r8 + 1;
        goto L6
    L12:
        r2 = r2 + 1;
        goto L4
    L14:
        return r0;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> getSubMatrix(int startRow, int endRow, int startColumn, int endColumn) throws MatrixIndexException {
        BlockFieldMatrix<T> r0 = this;
        checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
        BlockFieldMatrix<T> out = new BlockFieldMatrix(r0.getField(), (endRow - startRow) + 1, (endColumn - startColumn) + 1);
        int blockStartRow = startRow / 36;
        int rowsShift = startRow % 36;
        int blockStartColumn = startColumn / 36;
        int columnsShift = startColumn % 36;
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
        T[] outBlock = out.blocks[outIndex];
        int index = (r0.blockColumns * pBlock) + qBlock;
        int jBlock2 = jBlock;
        int width = r0.blockWidth(qBlock);
        int heightExcess = (iHeight + rowsShift) - 36;
        int widthExcess = (jWidth + columnsShift) - 36;
        if (heightExcess <= 0) goto L13;
        if (widthExcess <= 0) goto L12;
        int width2 = r0.blockWidth(qBlock + 1);
        int jBlock3 = jBlock2;
        int qBlock2 = qBlock;
        r0.copyBlockPart(r0.blocks[index], width, rowsShift, 36, columnsShift, 36, outBlock, jWidth, 0, 0);
        int columnsShift2 = columnsShift;
        r0.copyBlockPart(r0.blocks[index + 1], width2, rowsShift, 36, 0, widthExcess, outBlock, jWidth, 0, jWidth - widthExcess);
        r0.copyBlockPart(r0.blocks[index + r0.blockColumns], width, 0, heightExcess, columnsShift2, 36, outBlock, jWidth, iHeight - heightExcess, 0);
        r0.copyBlockPart(r0.blocks[(index + r0.blockColumns) + 1], width2, 0, heightExcess, 0, widthExcess, outBlock, jWidth, iHeight - heightExcess, jWidth - widthExcess);
        rowsShift = rowsShift;
        columnsShift = columnsShift2;
    L17:
        qBlock = qBlock2 + 1;
        jBlock = jBlock3 + 1;
        r0 = this;
        goto L7
    L12:
        qBlock2 = qBlock;
        jBlock3 = jBlock2;
        r0.copyBlockPart(r0.blocks[index], width, rowsShift, 36, columnsShift, jWidth + columnsShift, outBlock, jWidth, 0, 0);
        r0.copyBlockPart(r0.blocks[index + r0.blockColumns], width, 0, heightExcess, columnsShift, jWidth + columnsShift, outBlock, jWidth, iHeight - heightExcess, 0);
        rowsShift = rowsShift;
        goto L17
    L13:
        qBlock2 = qBlock;
        jBlock3 = jBlock2;
        int widthExcess2 = rowsShift;
        if (widthExcess <= 0) goto L16;
        int width3 = r0.blockWidth(qBlock2 + 1);
        rowsShift = widthExcess2;
        r0.copyBlockPart(r0.blocks[index], width, rowsShift, iHeight + widthExcess2, columnsShift, 36, outBlock, jWidth, 0, 0);
        r0.copyBlockPart(r0.blocks[index + 1], width3, rowsShift, iHeight + rowsShift, 0, widthExcess, outBlock, jWidth, 0, jWidth - widthExcess);
        columnsShift = columnsShift;
        goto L17
    L16:
        rowsShift = widthExcess2;
        int rowsShift2 = columnsShift;
        r0.copyBlockPart(r0.blocks[index], width, rowsShift, iHeight + rowsShift, columnsShift, jWidth + rowsShift2, outBlock, jWidth, 0, 0);
        goto L17
    L18:
        pBlock = pBlock + 1;
        iBlock = iBlock + 1;
        r0 = this;
        goto L3
    L20:
        return out;
    }

    private void copyBlockPart(T[] srcBlock, int srcWidth, int srcStartRow, int srcEndRow, int srcStartColumn, int srcEndColumn, T[] dstBlock, int dstWidth, int dstStartRow, int dstStartColumn) {
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

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setSubMatrix(T[][] subMatrix, int row, int column) throws MatrixIndexException {
        BlockFieldMatrix<T> r0 = this;
        int r2 = row;
        int r3 = column;
        int r4 = 0;
        int refLength = subMatrix[0].length;
        if (refLength < 1) goto L23;
        int endRow = (subMatrix.length + r2) - 1;
        int endColumn = (r3 + refLength) - 1;
        r0.checkSubMatrixIndex(r2, endRow, r3, endColumn);
        int r6 = subMatrix.length;
    L5:
        if (r4 >= r6) goto L11;
        T[] subRow = subMatrix[r4];
        if (subRow.length != refLength) goto L10;
        r4 = r4 + 1;
        goto L5
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(refLength), Integer.valueOf(subRow.length)});
    L11:
        int blockStartRow = r2 / 36;
        int blockEndRow = (endRow + 36) / 36;
        int blockStartColumn = r3 / 36;
        int blockEndColumn = (endColumn + 36) / 36;
        int iBlock = blockStartRow;
    L12:
        if (iBlock >= blockEndRow) goto L21;
        int iHeight = r0.blockHeight(iBlock);
        int firstRow = iBlock * 36;
        int iStart = FastMath.max(r2, firstRow);
        int iEnd = FastMath.min(endRow + 1, firstRow + iHeight);
        int jBlock = blockStartColumn;
    L14:
        if (jBlock >= blockEndColumn) goto L19;
        int jWidth = r0.blockWidth(jBlock);
        int firstColumn = jBlock * 36;
        int jStart = FastMath.max(r3, firstColumn);
        int jEnd = FastMath.min(endColumn + 1, firstColumn + jWidth);
        int jLength = jEnd - jStart;
        T[] block = r0.blocks[(r0.blockColumns * iBlock) + jBlock];
        int i = iStart;
    L16:
        if (i >= iEnd) goto L18;
        int i2 = i;
        T[] r1 = subMatrix[i - row];
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

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> getRowMatrix(int row) throws MatrixIndexException {
        checkRowIndex(row);
        BlockFieldMatrix<T> out = new BlockFieldMatrix(getField(), 1, this.columns);
        int iBlock = row / 36;
        int iRow = row - (iBlock * 36);
        int outBlockIndex = 0;
        int outIndex = 0;
        T[] outBlock = out.blocks[0];
        int jBlock = 0;
    L4:
        if (jBlock >= this.blockColumns) goto L11;
        int jWidth = blockWidth(jBlock);
        T[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
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

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setRowMatrix(int row, FieldMatrix<T> matrix) throws MatrixIndexException, InvalidMatrixException {
        setRowMatrix(row, (BlockFieldMatrix) matrix);     // Catch: ClassCastException -> L4
        return;
    L5:
        super.setRowMatrix(row, matrix);
    }

    public void setRowMatrix(int row, BlockFieldMatrix<T> matrix) throws MatrixIndexException, InvalidMatrixException {
        checkRowIndex(row);
        int nCols = getColumnDimension();
        if (matrix.getRowDimension() != 1) goto L17;
        if (matrix.getColumnDimension() != nCols) goto L17;
        int iBlock = row / 36;
        int iRow = row - (iBlock * 36);
        int mBlockIndex = 0;
        int mIndex = 0;
        T[] mBlock = matrix.blocks[0];
        int jBlock = 0;
    L8:
        if (jBlock >= this.blockColumns) goto L15;
        int jWidth = blockWidth(jBlock);
        T[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
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

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> getColumnMatrix(int column) throws MatrixIndexException {
        checkColumnIndex(column);
        BlockFieldMatrix<T> out = new BlockFieldMatrix(getField(), this.rows, 1);
        int jBlock = column / 36;
        int jColumn = column - (jBlock * 36);
        int jWidth = blockWidth(jBlock);
        int outBlockIndex = 0;
        int outIndex = 0;
        T[] outBlock = out.blocks[0];
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L13;
        int iHeight = blockHeight(iBlock);
        T[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
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

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setColumnMatrix(int column, FieldMatrix<T> matrix) throws MatrixIndexException, InvalidMatrixException {
        setColumnMatrix(column, (BlockFieldMatrix) matrix);     // Catch: ClassCastException -> L4
        return;
    L5:
        super.setColumnMatrix(column, matrix);
    }

    void setColumnMatrix(int column, BlockFieldMatrix<T> matrix) throws MatrixIndexException, InvalidMatrixException {
        checkColumnIndex(column);
        int nRows = getRowDimension();
        if (matrix.getRowDimension() != nRows) goto L19;
        if (matrix.getColumnDimension() != 1) goto L19;
        int jBlock = column / 36;
        int jColumn = column - (jBlock * 36);
        int jWidth = blockWidth(jBlock);
        int mBlockIndex = 0;
        int mIndex = 0;
        T[] mBlock = matrix.blocks[0];
        int iBlock = 0;
    L8:
        if (iBlock >= this.blockRows) goto L17;
        int iHeight = blockHeight(iBlock);
        T[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int i = 0;
    L10:
        if (i >= iHeight) goto L15;
        if (mIndex < mBlock.length) goto L14;
        mBlockIndex = mBlockIndex + 1;
        mBlock = matrix.blocks[mBlockIndex];
        mIndex = 0;
    L14:
        int mIndex2 = mIndex + 1;
        block[(i * jWidth) + jColumn] = mBlock[mIndex];
        i = i + 1;
        mIndex = mIndex2;
        goto L10
    L15:
        iBlock = iBlock + 1;
        goto L8
    L17:
        return;
    L19:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(matrix.getRowDimension()), Integer.valueOf(matrix.getColumnDimension()), Integer.valueOf(nRows), 1});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldVector<T> getRowVector(int row) throws MatrixIndexException {
        checkRowIndex(row);
        FieldElement[] r0 = AbstractFieldMatrix.buildArray(getField(), this.columns);
        int iBlock = row / 36;
        int iRow = row - (iBlock * 36);
        int outIndex = 0;
        int jBlock = 0;
    L4:
        if (jBlock >= this.blockColumns) goto L7;
        int jWidth = blockWidth(jBlock);
        T[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        System.arraycopy(block, iRow * jWidth, r0, outIndex, jWidth);
        outIndex = outIndex + jWidth;
        jBlock = jBlock + 1;
        goto L4
    L7:
        return new ArrayFieldVector(r0, false);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setRowVector(int row, FieldVector<T> vector) throws MatrixIndexException, InvalidMatrixException {
        setRow(row, ((ArrayFieldVector) vector).getDataRef());     // Catch: ClassCastException -> L4
        return;
    L5:
        super.setRowVector(row, vector);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldVector<T> getColumnVector(int column) throws MatrixIndexException {
        checkColumnIndex(column);
        FieldElement[] r0 = AbstractFieldMatrix.buildArray(getField(), this.rows);
        int jBlock = column / 36;
        int jColumn = column - (jBlock * 36);
        int jWidth = blockWidth(jBlock);
        int outIndex = 0;
        int iBlock = 0;
    L4:
        if (iBlock >= this.blockRows) goto L10;
        int iHeight = blockHeight(iBlock);
        T[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int i = 0;
    L6:
        if (i >= iHeight) goto L8;
        r0[outIndex] = block[(i * jWidth) + jColumn];
        i = i + 1;
        outIndex = outIndex + 1;
        goto L6
    L8:
        iBlock = iBlock + 1;
        goto L4
    L10:
        return new ArrayFieldVector(r0, false);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setColumnVector(int column, FieldVector<T> vector) throws MatrixIndexException, InvalidMatrixException {
        setColumn(column, ((ArrayFieldVector) vector).getDataRef());     // Catch: ClassCastException -> L4
        return;
    L5:
        super.setColumnVector(column, vector);
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T[] getRow(int r9) throws MatrixIndexException {
        checkRowIndex(r9);
        T[] r0 = (T[]) AbstractFieldMatrix.buildArray(getField(), this.columns);
        int r1 = r9 / 36;
        int r2 = r9 - (r1 * 36);
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r4 >= this.blockColumns) goto L7;
        int r5 = blockWidth(r4);
        System.arraycopy(this.blocks[(this.blockColumns * r1) + r4], r2 * r5, r0, r3, r5);
        r3 = r3 + r5;
        r4 = r4 + 1;
        goto L4
    L7:
        return r0;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setRow(int row, T[] array) throws MatrixIndexException, InvalidMatrixException {
        checkRowIndex(row);
        int nCols = getColumnDimension();
        if (array.length != nCols) goto L11;
        int iBlock = row / 36;
        int iRow = row - (iBlock * 36);
        int outIndex = 0;
        int jBlock = 0;
    L6:
        if (jBlock >= this.blockColumns) goto L9;
        int jWidth = blockWidth(jBlock);
        T[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        System.arraycopy(array, outIndex, block, iRow * jWidth, jWidth);
        outIndex = outIndex + jWidth;
        jBlock = jBlock + 1;
        goto L6
    L9:
        return;
    L11:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{1, Integer.valueOf(array.length), 1, Integer.valueOf(nCols)});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T[] getColumn(int r12) throws MatrixIndexException {
        checkColumnIndex(r12);
        T[] r0 = (T[]) AbstractFieldMatrix.buildArray(getField(), this.rows);
        int r1 = r12 / 36;
        int r2 = r12 - (r1 * 36);
        int r3 = blockWidth(r1);
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r5 >= this.blockRows) goto L10;
        int r6 = blockHeight(r5);
        T[] r7 = this.blocks[(this.blockColumns * r5) + r1];
        int r8 = 0;
    L6:
        if (r8 >= r6) goto L8;
        r0[r4] = r7[(r8 * r3) + r2];
        r8 = r8 + 1;
        r4 = r4 + 1;
        goto L6
    L8:
        r5 = r5 + 1;
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setColumn(int column, T[] array) throws MatrixIndexException, InvalidMatrixException {
        checkColumnIndex(column);
        int nRows = getRowDimension();
        if (array.length != nRows) goto L14;
        int jBlock = column / 36;
        int jColumn = column - (jBlock * 36);
        int jWidth = blockWidth(jBlock);
        int outIndex = 0;
        int iBlock = 0;
    L6:
        if (iBlock >= this.blockRows) goto L12;
        int iHeight = blockHeight(iBlock);
        T[] block = this.blocks[(this.blockColumns * iBlock) + jBlock];
        int i = 0;
    L8:
        if (i >= iHeight) goto L10;
        int outIndex2 = outIndex + 1;
        block[(i * jWidth) + jColumn] = array[outIndex];
        i = i + 1;
        outIndex = outIndex2;
        goto L8
    L10:
        iBlock = iBlock + 1;
        goto L6
    L12:
        return;
    L14:
        throw new InvalidMatrixException(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Object[]{Integer.valueOf(array.length), 1, Integer.valueOf(nRows), 1});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T getEntry(int row, int column) throws MatrixIndexException {
        int iBlock = row / 36;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int jBlock = column / 36;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int k = ((row - (iBlock * 36)) * blockWidth(jBlock)) + (column - (jBlock * 36));     // Catch: ArrayIndexOutOfBoundsException -> L4
        return this.blocks[(this.blockColumns * iBlock) + jBlock][k];
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void setEntry(int row, int column, T value) throws MatrixIndexException {
        int iBlock = row / 36;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int jBlock = column / 36;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int k = ((row - (iBlock * 36)) * blockWidth(jBlock)) + (column - (jBlock * 36));     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.blocks[(this.blockColumns * iBlock) + jBlock][k] = value;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void addToEntry(int row, int column, T increment) throws MatrixIndexException {
        int iBlock = row / 36;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int jBlock = column / 36;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int k = ((row - (iBlock * 36)) * blockWidth(jBlock)) + (column - (jBlock * 36));     // Catch: ArrayIndexOutOfBoundsException -> L4
        FieldElement[] r3 = this.blocks[(this.blockColumns * iBlock) + jBlock];     // Catch: ArrayIndexOutOfBoundsException -> L4
        r3[k] = (FieldElement) r3[k].add(increment);     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public void multiplyEntry(int row, int column, T factor) throws MatrixIndexException {
        int iBlock = row / 36;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int jBlock = column / 36;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int k = ((row - (iBlock * 36)) * blockWidth(jBlock)) + (column - (jBlock * 36));     // Catch: ArrayIndexOutOfBoundsException -> L4
        FieldElement[] r3 = this.blocks[(this.blockColumns * iBlock) + jBlock];     // Catch: ArrayIndexOutOfBoundsException -> L4
        r3[k] = (FieldElement) r3[k].multiply(factor);     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L6:
        throw new MatrixIndexException(LocalizedFormats.NO_SUCH_MATRIX_ENTRY, new Object[]{Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension())});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public FieldMatrix<T> transpose() {
        BlockFieldMatrix<T> r0 = this;
        int nRows = r0.getRowDimension();
        int nCols = r0.getColumnDimension();
        BlockFieldMatrix<T> out = new BlockFieldMatrix(r0.getField(), nCols, nRows);
        int blockIndex = 0;
        int iBlock = 0;
    L4:
        if (iBlock >= r0.blockColumns) goto L17;
        int jBlock = 0;
    L7:
        if (jBlock >= r0.blockRows) goto L15;
        T[] outBlock = out.blocks[blockIndex];
        T[] tBlock = r0.blocks[(r0.blockColumns * jBlock) + iBlock];
        int pStart = iBlock * 36;
        int pEnd = FastMath.min(pStart + 36, r0.columns);
        int qStart = jBlock * 36;
        int qEnd = FastMath.min(qStart + 36, r0.rows);
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

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T[] operate(T[] r20) throws IllegalArgumentException {
        if (r20.length != this.columns) goto L25;
        FieldElement[] r2 = AbstractFieldMatrix.buildArray(getField(), this.rows);
        T r3 = getField().getZero();
        int r4 = 0;
    L6:
        if (r4 >= this.blockRows) goto L23;
        int r5 = r4 * 36;
        int r6 = FastMath.min(r5 + 36, this.rows);
        int r7 = 0;
    L9:
        if (r7 >= this.blockColumns) goto L21;
        T[] r8 = this.blocks[(this.blockColumns * r4) + r7];
        int r9 = r7 * 36;
        int r10 = FastMath.min(r9 + 36, this.columns);
        int r11 = 0;
        int r12 = r5;
    L11:
        if (r12 >= r6) goto L20;
        FieldElement r13 = r3;
        int r14 = r9;
    L14:
        if (r14 >= (r10 - 3)) goto L16;
        r13 = (FieldElement) ((FieldElement) ((FieldElement) ((FieldElement) r13.add((FieldElement) r8[r11].multiply(r20[r14]))).add((FieldElement) r8[r11 + 1].multiply(r20[r14 + 1]))).add((FieldElement) r8[r11 + 2].multiply(r20[r14 + 2]))).add((FieldElement) r8[r11 + 3].multiply(r20[r14 + 3]));
        r11 = r11 + 4;
        r14 = r14 + 4;
        r2 = r2;
        r3 = r3;
        goto L14
    L16:
        FieldElement[] r16 = r2;
        T r18 = r3;
    L17:
        if (r14 >= r10) goto L19;
        int r15 = r11 + 1;
        T r17 = r8[r11];
        r13 = (FieldElement) r13.add((FieldElement) r17.multiply(r20[r14]));
        r14 = r14 + 1;
        r11 = r15;
        goto L17
    L19:
        r16[r12] = (FieldElement) r16[r12].add(r13);
        r12 = r12 + 1;
        r2 = r16;
        r3 = r18;
        goto L11
    L20:
        r7 = r7 + 1;
        goto L9
    L21:
        r4 = r4 + 1;
        goto L6
    L23:
        return (T[]) r2;
    L25:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(r20.length), Integer.valueOf(this.columns)});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T[] preMultiply(T[] r25) throws IllegalArgumentException {
        if (r25.length != this.rows) goto L25;
        FieldElement[] r2 = AbstractFieldMatrix.buildArray(getField(), this.columns);
        T r3 = getField().getZero();
        int r4 = 0;
    L6:
        if (r4 >= this.blockColumns) goto L23;
        int r5 = blockWidth(r4);
        int r6 = r5 + r5;
        int r7 = r6 + r5;
        int r8 = r7 + r5;
        int r9 = r4 * 36;
        int r10 = FastMath.min(r9 + 36, this.columns);
        int r11 = 0;
    L9:
        if (r11 >= this.blockRows) goto L21;
        T[] r12 = this.blocks[(this.blockColumns * r11) + r4];
        int r13 = r11 * 36;
        int r14 = FastMath.min(r13 + 36, this.rows);
        int r15 = r9;
    L11:
        if (r15 >= r10) goto L20;
        int r16 = r15 - r9;
        FieldElement[] r17 = r2;
        FieldElement r18 = r3;
        T r19 = r3;
        int r20 = r13;
    L13:
        int r110 = r4;
        if (r20 >= (r14 - 3)) goto L17;
        int r21 = r20;
        r18 = (FieldElement) ((FieldElement) ((FieldElement) ((FieldElement) r18.add((FieldElement) r12[r16].multiply(r25[r21]))).add((FieldElement) r12[r16 + r5].multiply(r25[r21 + 1]))).add((FieldElement) r12[r16 + r6].multiply(r25[r21 + 2]))).add((FieldElement) r12[r16 + r7].multiply(r25[r21 + 3]));
        r16 = r16 + r8;
        r20 = r21 + 4;
        r4 = r110;
    L17:
        if (r20 >= r14) goto L19;
        r18 = (FieldElement) r18.add((FieldElement) r12[r16].multiply(r25[r20]));
        r16 = r16 + r5;
        r20 = r20 + 1;
        goto L17
    L19:
        r17[r15] = (FieldElement) r17[r15].add(r18);
        r15 = r15 + 1;
        r2 = r17;
        r3 = r19;
        r4 = r110;
        goto L11
    L20:
        r11 = r11 + 1;
        goto L9
    L21:
        r4 = r4 + 1;
        goto L6
    L23:
        return (T[]) r2;
    L25:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.VECTOR_LENGTH_MISMATCH, new Object[]{Integer.valueOf(r25.length), Integer.valueOf(this.rows)});
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r13) throws MatrixVisitorException {
        r13.start(this.rows, this.columns, 0, this.rows - 1, 0, this.columns - 1);
        int r14 = 0;
    L4:
        if (r14 >= this.blockRows) goto L17;
        int r1 = r14 * 36;
        int r2 = FastMath.min(r1 + 36, this.rows);
        int r3 = r1;
    L6:
        if (r3 >= r2) goto L15;
        int r4 = 0;
    L9:
        if (r4 >= this.blockColumns) goto L14;
        int r5 = blockWidth(r4);
        int r6 = r4 * 36;
        int r7 = FastMath.min(r6 + 36, this.columns);
        Object[] r8 = this.blocks[(this.blockColumns * r14) + r4];
        int r9 = (r3 - r1) * r5;
        int r10 = r6;
    L11:
        if (r10 >= r7) goto L13;
        r8[r9] = r13.visit(r3, r10, r8[r9]);
        r9 = r9 + 1;
        r10 = r10 + 1;
        goto L11
    L13:
        r4 = r4 + 1;
        goto L9
    L14:
        r3 = r3 + 1;
        goto L6
    L15:
        r14 = r14 + 1;
        goto L4
    L17:
        return (T) r13.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r13) throws MatrixVisitorException {
        r13.start(this.rows, this.columns, 0, this.rows - 1, 0, this.columns - 1);
        int r14 = 0;
    L4:
        if (r14 >= this.blockRows) goto L17;
        int r1 = r14 * 36;
        int r2 = FastMath.min(r1 + 36, this.rows);
        int r3 = r1;
    L6:
        if (r3 >= r2) goto L15;
        int r4 = 0;
    L9:
        if (r4 >= this.blockColumns) goto L14;
        int r5 = blockWidth(r4);
        int r6 = r4 * 36;
        int r7 = FastMath.min(r6 + 36, this.columns);
        T[] r8 = this.blocks[(this.blockColumns * r14) + r4];
        int r9 = (r3 - r1) * r5;
        int r10 = r6;
    L11:
        if (r10 >= r7) goto L13;
        r13.visit(r3, r10, r8[r9]);
        r9 = r9 + 1;
        r10 = r10 + 1;
        goto L11
    L13:
        r4 = r4 + 1;
        goto L9
    L14:
        r3 = r3 + 1;
        goto L6
    L15:
        r14 = r14 + 1;
        goto L4
    L17:
        return (T) r13.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r18, int r19, int r20, int r21, int r22) throws MatrixIndexException, MatrixVisitorException {
        BlockFieldMatrix<T> r0 = this;
        r0.checkSubMatrixIndex(r19, r20, r21, r22);
        r18.start(r0.rows, r0.columns, r19, r20, r21, r22);
        int r1 = r19 / 36;
    L4:
        if (r1 >= ((r20 / 36) + 1)) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.max(r19, r2);
        int r5 = FastMath.min((r1 + 1) * 36, r20 + 1);
        int r7 = r3;
    L6:
        if (r7 >= r5) goto L15;
        int r8 = r21 / 36;
    L9:
        if (r8 >= ((r22 / 36) + 1)) goto L14;
        int r9 = r0.blockWidth(r8);
        int r10 = r8 * 36;
        int r11 = FastMath.max(r21, r10);
        int r12 = FastMath.min((r8 + 1) * 36, r22 + 1);
        Object[] r13 = r0.blocks[(r0.blockColumns * r1) + r8];
        int r14 = (((r7 - r2) * r9) + r11) - r10;
        int r15 = r11;
    L11:
        if (r15 >= r12) goto L13;
        r13[r14] = r18.visit(r7, r15, r13[r14]);
        r14 = r14 + 1;
        r15 = r15 + 1;
        r1 = r1;
        goto L11
    L13:
        r8 = r8 + 1;
        r0 = this;
        r1 = r1;
        goto L9
    L14:
        r7 = r7 + 1;
        r0 = this;
        r1 = r1;
        goto L6
    L15:
        r1 = r1 + 1;
        r0 = this;
        goto L4
    L17:
        return (T) r18.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r18, int r19, int r20, int r21, int r22) throws MatrixIndexException, MatrixVisitorException {
        BlockFieldMatrix<T> r0 = this;
        r0.checkSubMatrixIndex(r19, r20, r21, r22);
        r18.start(r0.rows, r0.columns, r19, r20, r21, r22);
        int r1 = r19 / 36;
    L4:
        if (r1 >= ((r20 / 36) + 1)) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.max(r19, r2);
        int r5 = FastMath.min((r1 + 1) * 36, r20 + 1);
        int r7 = r3;
    L6:
        if (r7 >= r5) goto L15;
        int r8 = r21 / 36;
    L9:
        if (r8 >= ((r22 / 36) + 1)) goto L14;
        int r9 = r0.blockWidth(r8);
        int r10 = r8 * 36;
        int r11 = FastMath.max(r21, r10);
        int r12 = FastMath.min((r8 + 1) * 36, r22 + 1);
        T[] r13 = r0.blocks[(r0.blockColumns * r1) + r8];
        int r14 = (((r7 - r2) * r9) + r11) - r10;
        int r15 = r11;
    L11:
        if (r15 >= r12) goto L13;
        r18.visit(r7, r15, r13[r14]);
        r14 = r14 + 1;
        r15 = r15 + 1;
        r1 = r1;
        goto L11
    L13:
        r8 = r8 + 1;
        r0 = this;
        r1 = r1;
        goto L9
    L14:
        r7 = r7 + 1;
        r0 = this;
        r1 = r1;
        goto L6
    L15:
        r1 = r1 + 1;
        r0 = this;
        goto L4
    L17:
        return (T) r18.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r13) throws MatrixVisitorException {
        r13.start(this.rows, this.columns, 0, this.rows - 1, 0, this.columns - 1);
        int r14 = 0;
        int r1 = 0;
    L4:
        if (r1 >= this.blockRows) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.min(r2 + 36, this.rows);
        int r4 = 0;
    L7:
        if (r4 >= this.blockColumns) goto L15;
        int r5 = r4 * 36;
        int r6 = FastMath.min(r5 + 36, this.columns);
        Object[] r7 = this.blocks[r14];
        int r8 = 0;
        int r9 = r2;
    L9:
        if (r9 >= r3) goto L14;
        int r10 = r5;
    L11:
        if (r10 >= r6) goto L13;
        r7[r8] = r13.visit(r9, r10, r7[r8]);
        r8 = r8 + 1;
        r10 = r10 + 1;
        goto L11
    L13:
        r9 = r9 + 1;
        goto L9
    L14:
        r14 = r14 + 1;
        r4 = r4 + 1;
        goto L7
    L15:
        r1 = r1 + 1;
        goto L4
    L17:
        return (T) r13.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r13) throws MatrixVisitorException {
        r13.start(this.rows, this.columns, 0, this.rows - 1, 0, this.columns - 1);
        int r14 = 0;
        int r1 = 0;
    L4:
        if (r1 >= this.blockRows) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.min(r2 + 36, this.rows);
        int r4 = 0;
    L7:
        if (r4 >= this.blockColumns) goto L15;
        int r5 = r4 * 36;
        int r6 = FastMath.min(r5 + 36, this.columns);
        T[] r7 = this.blocks[r14];
        int r8 = 0;
        int r9 = r2;
    L9:
        if (r9 >= r3) goto L14;
        int r10 = r5;
    L11:
        if (r10 >= r6) goto L13;
        r13.visit(r9, r10, r7[r8]);
        r8 = r8 + 1;
        r10 = r10 + 1;
        goto L11
    L13:
        r9 = r9 + 1;
        goto L9
    L14:
        r14 = r14 + 1;
        r4 = r4 + 1;
        goto L7
    L15:
        r1 = r1 + 1;
        goto L4
    L17:
        return (T) r13.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r18, int r19, int r20, int r21, int r22) throws MatrixIndexException, MatrixVisitorException {
        BlockFieldMatrix<T> r0 = this;
        r0.checkSubMatrixIndex(r19, r20, r21, r22);
        r18.start(r0.rows, r0.columns, r19, r20, r21, r22);
        int r1 = r19 / 36;
    L4:
        if (r1 >= ((r20 / 36) + 1)) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.max(r19, r2);
        int r5 = FastMath.min((r1 + 1) * 36, r20 + 1);
        int r7 = r21 / 36;
    L7:
        if (r7 >= ((r22 / 36) + 1)) goto L15;
        int r8 = r0.blockWidth(r7);
        int r9 = r7 * 36;
        int r10 = FastMath.max(r21, r9);
        int r11 = FastMath.min((r7 + 1) * 36, r22 + 1);
        Object[] r12 = r0.blocks[(r0.blockColumns * r1) + r7];
        int r13 = r3;
    L9:
        if (r13 >= r5) goto L14;
        int r14 = (((r13 - r2) * r8) + r10) - r9;
        int r15 = r10;
    L11:
        if (r15 >= r11) goto L13;
        r12[r14] = r18.visit(r13, r15, r12[r14]);
        r14 = r14 + 1;
        r15 = r15 + 1;
        r1 = r1;
        goto L11
    L13:
        r13 = r13 + 1;
        r1 = r1;
        goto L9
    L14:
        r7 = r7 + 1;
        r0 = this;
        r1 = r1;
        goto L7
    L15:
        r1 = r1 + 1;
        r0 = this;
        goto L4
    L17:
        return (T) r18.end();
    }

    @Override // org.apache.commons.math.linear.AbstractFieldMatrix, org.apache.commons.math.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r18, int r19, int r20, int r21, int r22) throws MatrixIndexException, MatrixVisitorException {
        BlockFieldMatrix<T> r0 = this;
        r0.checkSubMatrixIndex(r19, r20, r21, r22);
        r18.start(r0.rows, r0.columns, r19, r20, r21, r22);
        int r1 = r19 / 36;
    L4:
        if (r1 >= ((r20 / 36) + 1)) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.max(r19, r2);
        int r5 = FastMath.min((r1 + 1) * 36, r20 + 1);
        int r7 = r21 / 36;
    L7:
        if (r7 >= ((r22 / 36) + 1)) goto L15;
        int r8 = r0.blockWidth(r7);
        int r9 = r7 * 36;
        int r10 = FastMath.max(r21, r9);
        int r11 = FastMath.min((r7 + 1) * 36, r22 + 1);
        T[] r12 = r0.blocks[(r0.blockColumns * r1) + r7];
        int r13 = r3;
    L9:
        if (r13 >= r5) goto L14;
        int r14 = (((r13 - r2) * r8) + r10) - r9;
        int r15 = r10;
    L11:
        if (r15 >= r11) goto L13;
        r18.visit(r13, r15, r12[r14]);
        r14 = r14 + 1;
        r15 = r15 + 1;
        r1 = r1;
        goto L11
    L13:
        r13 = r13 + 1;
        r1 = r1;
        goto L9
    L14:
        r7 = r7 + 1;
        r0 = this;
        r1 = r1;
        goto L7
    L15:
        r1 = r1 + 1;
        r0 = this;
        goto L4
    L17:
        return (T) r18.end();
    }

    private int blockHeight(int blockRow) {
        if (blockRow == (this.blockRows - 1)) goto L7;
        return 36;
    L7:
        return this.rows - (blockRow * 36);
    }

    private int blockWidth(int blockColumn) {
        if (blockColumn == (this.blockColumns - 1)) goto L7;
        return 36;
    L7:
        return this.columns - (blockColumn * 36);
    }
}
