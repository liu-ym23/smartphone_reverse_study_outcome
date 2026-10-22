package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class DataMatrixWriter implements Writer {
    public DataMatrixWriter() {
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) {
        return encode(r7, r8, r9, r10, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r1, BarcodeFormat r2, int r3, int r4, Map<EncodeHintType, ?> r5) {
        if (r1.isEmpty() == true) goto L30;
        if (r2 != BarcodeFormat.DATA_MATRIX) goto L28;
        if (r3 < 0) goto L26;
        if (r4 < 0) goto L26;
        SymbolShapeHint r0 = SymbolShapeHint.FORCE_NONE;
        Dimension r6 = null;
        if (r5 == null) goto L22;
        SymbolShapeHint r7 = (SymbolShapeHint) r5.get(EncodeHintType.DATA_MATRIX_SHAPE);
        if (r7 == null) goto L13;
        r0 = r7;
    L13:
        Dimension r8 = (Dimension) r5.get(EncodeHintType.MIN_SIZE);
        if (r8 != null) goto L17;
        r8 = null;
    L17:
        Dimension r9 = (Dimension) r5.get(EncodeHintType.MAX_SIZE);
        if (r9 != null) goto L21;
        r9 = null;
    L21:
        r6 = r8;
    L23:
        String r10 = HighLevelEncoder.encodeHighLevel(r1, r0, r6, r9);
        SymbolInfo r11 = SymbolInfo.lookup(r10.length(), r0, r6, r9, true);
        DefaultPlacement r12 = new DefaultPlacement(ErrorCorrection.encodeECC200(r10, r11), r11.getSymbolDataWidth(), r11.getSymbolDataHeight());
        r12.place();
        return encodeLowLevel(r12, r11);
    L22:
        r9 = null;
    L26:
        throw new IllegalArgumentException("Requested dimensions are too small: " + r3 + 'x' + r4);
    L28:
        throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + r2);
    L30:
        throw new IllegalArgumentException("Found empty contents");
    }

    private static BitMatrix encodeLowLevel(DefaultPlacement r11, SymbolInfo r12) {
        int r0 = r12.getSymbolDataWidth();
        int r1 = r12.getSymbolDataHeight();
        ByteMatrix r2 = new ByteMatrix(r12.getSymbolWidth(), r12.getSymbolHeight());
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r1) goto L37;
        if ((r4 % r12.matrixHeight) != 0) goto L15;
        int r6 = 0;
        int r8 = 0;
    L8:
        if (r6 >= r12.getSymbolWidth()) goto L14;
        if ((r6 % 2) != 0) goto L12;
        boolean r9 = true;
    L13:
        r2.set(r8, r5, r9);
        r8 = r8 + 1;
        r6 = r6 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L14:
        r5 = r5 + 1;
    L15:
        int r7 = 0;
        int r10 = 0;
    L16:
        if (r7 >= r0) goto L28;
        if ((r7 % r12.matrixWidth) != 0) goto L20;
        r2.set(r10, r5, true);
        r10 = r10 + 1;
    L20:
        r2.set(r10, r5, r11.getBit(r7, r4));
        r10 = r10 + 1;
        if ((r7 % r12.matrixWidth) != (r12.matrixWidth - 1)) goto L27;
        if ((r4 % 2) != 0) goto L25;
        boolean r13 = true;
    L26:
        r2.set(r10, r5, r13);
        r10 = r10 + 1;
        goto L27
    L25:
        r13 = false;
    L27:
        r7 = r7 + 1;
        goto L16
    L28:
        r5 = r5 + 1;
        if ((r4 % r12.matrixHeight) != (r12.matrixHeight - 1)) goto L35;
        int r14 = 0;
        int r15 = 0;
    L32:
        if (r14 >= r12.getSymbolWidth()) goto L34;
        r2.set(r15, r5, true);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L32
    L34:
        r5 = r5 + 1;
    L35:
        r4 = r4 + 1;
        goto L3
    L37:
        return convertByteMatrixToBitMatrix(r2);
    }

    private static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix r8) {
        int r0 = r8.getWidth();
        int r1 = r8.getHeight();
        BitMatrix r2 = new BitMatrix(r0, r1);
        r2.clear();
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L11;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L10;
        if (r8.get(r4, r5) != 1) goto L9;
        r2.set(r4, r5);
    L9:
        r5 = r5 + 1;
        goto L5
    L10:
        r4 = r4 + 1;
        goto L3
    L11:
        return r2;
    }
}
