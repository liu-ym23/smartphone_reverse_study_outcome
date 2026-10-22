package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class PDF417Writer implements Writer {
    static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
    static final int WHITE_SPACE = 30;

    public PDF417Writer() {
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10, Map<EncodeHintType, ?> r11) throws WriterException {
        if (r8 != BarcodeFormat.PDF_417) goto L27;
        PDF417 r0 = new PDF417();
        int r6 = 30;
        int r12 = 2;
        if (r11 == null) goto L25;
        if (r11.containsKey(EncodeHintType.PDF417_COMPACT) == false) goto L10;
        r0.setCompact(Boolean.valueOf(r11.get(EncodeHintType.PDF417_COMPACT).toString()).booleanValue());
    L10:
        if (r11.containsKey(EncodeHintType.PDF417_COMPACTION) == false) goto L13;
        r0.setCompaction(Compaction.valueOf(r11.get(EncodeHintType.PDF417_COMPACTION).toString()));
    L13:
        if (r11.containsKey(EncodeHintType.PDF417_DIMENSIONS) == false) goto L16;
        Dimensions r1 = (Dimensions) r11.get(EncodeHintType.PDF417_DIMENSIONS);
        r0.setDimensions(r1.getMaxCols(), r1.getMinCols(), r1.getMaxRows(), r1.getMinRows());
    L16:
        if (r11.containsKey(EncodeHintType.MARGIN) == false) goto L19;
        r6 = Integer.parseInt(r11.get(EncodeHintType.MARGIN).toString());
    L19:
        if (r11.containsKey(EncodeHintType.ERROR_CORRECTION) == false) goto L22;
        r12 = Integer.parseInt(r11.get(EncodeHintType.ERROR_CORRECTION).toString());
    L22:
        if (r11.containsKey(EncodeHintType.CHARACTER_SET) == false) goto L25;
        r0.setEncoding(Charset.forName(r11.get(EncodeHintType.CHARACTER_SET).toString()));
    L25:
        return bitMatrixFromEncoder(r0, r7, r12, r9, r10, r6);
    L27:
        throw new IllegalArgumentException("Can only encode PDF_417, but got " + r8);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) throws WriterException {
        return encode(r7, r8, r9, r10, null);
    }

    private static BitMatrix bitMatrixFromEncoder(PDF417 r4, String r5, int r6, int r7, int r8, int r9) throws WriterException {
        r4.generateBarcodeLogic(r5, r6);
        byte[][] r10 = r4.getBarcodeMatrix().getScaledMatrix(1, 4);
        if (r8 <= r7) goto L5;
        boolean r1 = true;
    L7:
        if (r10[0].length >= r10.length) goto L9;
        boolean r2 = true;
    L11:
        if ((r1 ^ r2) == false) goto L13;
        r10 = rotateArray(r10);
        boolean r3 = true;
    L14:
        int r11 = r7 / r10[0].length;
        int r12 = r8 / r10.length;
        if (r11 < r12) goto L18;
        r11 = r12;
    L18:
        if (r11 <= 1) goto L25;
        byte[][] r13 = r4.getBarcodeMatrix().getScaledMatrix(r11, r11 << 2);
        if (r3 == false) goto L23;
        r13 = rotateArray(r13);
    L23:
        return bitMatrixFrombitArray(r13, r9);
    L25:
        return bitMatrixFrombitArray(r10, r9);
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    private static BitMatrix bitMatrixFrombitArray(byte[][] r7, int r8) {
        int r3 = r8 * 2;
        BitMatrix r0 = new BitMatrix(r7[0].length + r3, r7.length + r3);
        r0.clear();
        int r2 = (r0.getHeight() - r8) - 1;
        int r4 = 0;
    L4:
        if (r4 >= r7.length) goto L13;
        int r5 = 0;
    L7:
        if (r5 >= r7[0].length) goto L12;
        if (r7[r4][r5] != 1) goto L11;
        r0.set(r5 + r8, r2);
    L11:
        r5 = r5 + 1;
        goto L7
    L12:
        r4 = r4 + 1;
        r2 = r2 - 1;
        goto L4
    L13:
        return r0;
    }

    private static byte[][] rotateArray(byte[][] r8) {
        byte[][] r1 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r8[0].length, r8.length});
        int r2 = 0;
    L4:
        if (r2 >= r8.length) goto L10;
        int r3 = (r8.length - r2) - 1;
        int r5 = 0;
    L7:
        if (r5 >= r8[0].length) goto L9;
        r1[r5][r3] = r8[r2][r5];
        r5 = r5 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        return r1;
    }
}
