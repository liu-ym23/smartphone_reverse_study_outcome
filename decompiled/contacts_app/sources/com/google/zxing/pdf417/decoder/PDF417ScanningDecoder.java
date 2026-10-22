package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* JADX INFO: loaded from: classes3.dex */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = null;

    private static boolean checkCodewordSkew(int r0, int r1, int r2) {
        if ((r1 - 2) <= r0) goto L5;
        return false;
    L5:
        if (r0 > (r2 + 2)) goto L10;
        return true;
    L10:
        return false;
    }

    private static int getNumberOfECCodeWords(int r1) {
        return 2 << r1;
    }

    static {
        errorCorrection = new ErrorCorrection();
    }

    private PDF417ScanningDecoder() {
    }

    public static DecoderResult decode(BitMatrix r22, ResultPoint r23, ResultPoint r24, ResultPoint r25, ResultPoint r26, int r27, int r28) throws NotFoundException, FormatException, ChecksumException {
        DetectionResultRowIndicatorColumn r0 = null;
        DetectionResultRowIndicatorColumn r2 = null;
        DetectionResult r3 = null;
        int r11 = 0;
        BoundingBox r10 = new BoundingBox(r22, r23, r24, r25, r26);
    L4:
        if (r11 >= 2) goto L22;
        if (r23 == null) goto L7;
        r0 = getRowIndicatorColumn(r22, r10, r23, true, r27, r28);
    L7:
        if (r25 == null) goto L9;
        r2 = getRowIndicatorColumn(r22, r10, r25, false, r27, r28);
    L9:
        r3 = merge(r0, r2);
        if (r3 == null) goto L21;
        if (r11 != 0) goto L19;
        if (r3.getBoundingBox() == null) goto L19;
        if (r3.getBoundingBox().getMinY() < r10.getMinY()) goto L18;
        if (r3.getBoundingBox().getMaxY() <= r10.getMaxY()) goto L19;
    L18:
        r10 = r3.getBoundingBox();
        r11 = r11 + 1;
    L19:
        r3.setBoundingBox(r10);
        goto L22
    L21:
        throw NotFoundException.getNotFoundInstance();
    L22:
        int r4 = r3.getBarcodeColumnCount() + 1;
        r3.setDetectionResultColumn(0, r0);
        r3.setDetectionResultColumn(r4, r2);
        if (r0 == null) goto L25;
        boolean r1 = true;
    L26:
        int r5 = r27;
        int r6 = r28;
        int r7 = 1;
    L27:
        if (r7 > r4) goto L61;
        if (r1 == false) goto L30;
        int r8 = r7;
    L32:
        if (r3.getDetectionResultColumn(r8) != null) goto L59;
        if (r8 == 0) goto L38;
        if (r8 == r4) goto L38;
        DetectionResultColumn r9 = new DetectionResultColumn(r10);
    L42:
        r3.setDetectionResultColumn(r8, r9);
        int r15 = -1;
        int r14 = r10.getMinY();
        int r13 = -1;
    L44:
        if (r14 > r10.getMaxY()) goto L59;
        int r12 = getStartColumn(r3, r8, r14, r1);
        if (r12 >= 0) goto L48;
    L51:
        if (r13 == r15) goto L56;
        int r19 = r13;
    L53:
        int r29 = r14;
        int r21 = r15;
        Codeword r16 = detectCodeword(r22, r10.getMinX(), r10.getMaxX(), r1, r19, r29, r5, r6);
        int r17 = r29;
        if (r16 == null) goto L57;
        r9.setCodeword(r17, r16);
        r5 = Math.min(r5, r16.getWidth());
        r6 = Math.max(r6, r16.getWidth());
        r13 = r19;
    L58:
        r14 = r17 + 1;
        r15 = r21;
    L57:
        r13 = r13;
        goto L58
    L56:
        r17 = r14;
        r21 = r15;
        goto L57
    L48:
        if (r12 > r10.getMaxX()) goto L51;
        r19 = r12;
    L38:
        if (r8 != 0) goto L40;
        boolean r18 = true;
    L41:
        r9 = new DetectionResultRowIndicatorColumn(r10, r18);
        goto L42
    L40:
        r18 = false;
    L59:
        r7 = r7 + 1;
        goto L27
    L30:
        r8 = r4 - r7;
        goto L32
    L61:
        return createDecoderResult(r3);
    L25:
        r1 = false;
        goto L26
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn r2, DetectionResultRowIndicatorColumn r3) throws NotFoundException {
        if (r2 != null) goto L6;
        if (r3 != null) goto L6;
        return null;
    L6:
        BarcodeMetadata r1 = getBarcodeMetadata(r2, r3);
        if (r1 != null) goto L10;
        return null;
    L10:
        return new DetectionResult(r1, BoundingBox.merge(adjustBoundingBox(r2), adjustBoundingBox(r3)));
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn r8) throws NotFoundException {
        if (r8 != null) goto L5;
        return null;
    L5:
        int[] r1 = r8.getRowHeights();
        if (r1 != null) goto L8;
        return null;
    L8:
        int r0 = getMax(r1);
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L9:
        if (r4 >= r2) goto L13;
        int r6 = r1[r4];
        r5 = r5 + (r0 - r6);
        if (r6 > 0) goto L13;
        r4 = r4 + 1;
    L13:
        Codeword[] r7 = r8.getCodewords();
        int r9 = 0;
    L14:
        if (r5 <= 0) goto L18;
        if (r7[r9] != null) goto L18;
        r5 = r5 - 1;
        r9 = r9 + 1;
    L18:
        int r10 = r1.length - 1;
    L19:
        if (r10 < 0) goto L23;
        int r11 = r1[r10];
        r3 = r3 + (r0 - r11);
        if (r11 > 0) goto L23;
        r10 = r10 - 1;
    L23:
        int r12 = r7.length - 1;
    L24:
        if (r3 <= 0) goto L29;
        if (r7[r12] != null) goto L29;
        r3 = r3 - 1;
        r12 = r12 - 1;
    L29:
        return r8.getBoundingBox().addMissingRows(r5, r3, r8.isLeft());
    }

    private static int getMax(int[] r4) {
        int r0 = r4.length;
        int r1 = -1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = Math.max(r1, r4[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn r3, DetectionResultRowIndicatorColumn r4) {
        if (r3 == null) goto L19;
        BarcodeMetadata r5 = r3.getBarcodeMetadata();
        if (r5 == null) goto L19;
        if (r4 == null) goto L18;
        BarcodeMetadata r6 = r4.getBarcodeMetadata();
        if (r6 == null) goto L18;
        if (r5.getColumnCount() == r6.getColumnCount()) goto L18;
        if (r5.getErrorCorrectionLevel() == r6.getErrorCorrectionLevel()) goto L18;
        if (r5.getRowCount() == r6.getRowCount()) goto L18;
        return null;
    L18:
        return r5;
    L19:
        if (r4 != null) goto L22;
        return null;
    L22:
        return r4.getBarcodeMetadata();
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix r15, BoundingBox r16, ResultPoint r17, boolean r18, int r19, int r20) {
        DetectionResultRowIndicatorColumn r9 = new DetectionResultRowIndicatorColumn(r16, r18);
        int r11 = 0;
    L4:
        if (r11 >= 2) goto L22;
        if (r11 != 0) goto L7;
        int r0 = 1;
    L8:
        int r12 = r0;
        int r13 = (int) r17.getX();
        int r14 = (int) r17.getY();
    L10:
        if (r14 > r16.getMaxY()) goto L21;
        if (r14 < r16.getMinY()) goto L21;
        Codeword r1 = detectCodeword(r15, 0, r15.getWidth(), r18, r13, r14, r19, r20);
        if (r1 == null) goto L20;
        r9.setCodeword(r14, r1);
        if (r18 == false) goto L18;
        int r2 = r1.getStartX();
    L19:
        r13 = r2;
        goto L20
    L18:
        r2 = r1.getEndX();
    L20:
        r14 = r14 + r12;
    L21:
        r11 = r11 + 1;
        goto L4
    L7:
        r0 = -1;
        goto L8
    L22:
        return r9;
    }

    private static void adjustCodewordCount(DetectionResult r5, BarcodeValue[][] r6) throws NotFoundException {
        int[] r1 = r6[0][1].getValue();
        int r3 = (r5.getBarcodeColumnCount() * r5.getBarcodeRowCount()) - getNumberOfECCodeWords(r5.getBarcodeECLevel());
        if (r1.length != 0) goto L12;
        if (r3 <= 0) goto L10;
        if (r3 > 928) goto L10;
        r6[0][1].setValue(r3);
        return;
    L10:
        throw NotFoundException.getNotFoundInstance();
    L12:
        if (r1[0] == r3) goto L15;
        r6[0][1].setValue(r3);
        return;
    }

    private static DecoderResult createDecoderResult(DetectionResult r12) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] r0 = createBarcodeMatrix(r12);
        adjustCodewordCount(r12, r0);
        ArrayList r1 = new ArrayList();
        int[] r2 = new int[r12.getBarcodeRowCount() * r12.getBarcodeColumnCount()];
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r6 >= r12.getBarcodeRowCount()) goto L17;
        int r7 = 0;
    L7:
        if (r7 >= r12.getBarcodeColumnCount()) goto L16;
        int r9 = r7 + 1;
        int[] r8 = r0[r6][r9].getValue();
        int r10 = (r12.getBarcodeColumnCount() * r6) + r7;
        if (r8.length != 0) goto L12;
        r1.add(Integer.valueOf(r10));
    L15:
        r7 = r9;
        goto L7
    L12:
        if (r8.length != 1) goto L14;
        r2[r10] = r8[0];
        goto L15
    L14:
        r4.add(Integer.valueOf(r10));
        r3.add(r8);
        goto L15
    L16:
        r6 = r6 + 1;
        goto L4
    L17:
        int r11 = r3.size();
        int[][] r13 = new int[r11][];
    L18:
        if (r5 >= r11) goto L21;
        r13[r5] = (int[]) r3.get(r5);
        r5 = r5 + 1;
        goto L18
    L21:
        return createDecoderResultFromAmbiguousValues(r12.getBarcodeECLevel(), r2, PDF417Common.toIntArray(r1), PDF417Common.toIntArray(r4), r13);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int r8, int[] r9, int[] r10, int[] r11, int[][] r12) throws FormatException, ChecksumException {
        int r0 = r11.length;
        int[] r1 = new int[r0];
        int r2 = 100;
    L3:
        int r3 = r2 - 1;
        if (r2 <= 0) goto L25;
        int r4 = 0;
    L6:
        if (r4 >= r0) goto L26;
        r9[r11[r4]] = r12[r4][r1[r4]];
        r4 = r4 + 1;
        goto L6
    L26:
        return decodeCodewords(r9, r8, r10);
    L10:
        if (r0 == 0) goto L23;
        int r5 = 0;
    L12:
        if (r5 >= r0) goto L21;
        int r6 = r1[r5];
        if (r6 < (r12[r5].length - 1)) goto L15;
        r1[r5] = 0;
        if (r5 == (r0 - 1)) goto L20;
        r5 = r5 + 1;
        goto L12
    L20:
        throw ChecksumException.getChecksumInstance();
    L15:
        r1[r5] = r6 + 1;
    L21:
        r2 = r3;
        goto L3
    L23:
        throw ChecksumException.getChecksumInstance();
    L25:
        throw ChecksumException.getChecksumInstance();
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult r11) {
        BarcodeValue[][] r0 = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, new int[]{r11.getBarcodeRowCount(), r11.getBarcodeColumnCount() + 2});
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L10;
        int r3 = 0;
    L6:
        BarcodeValue[] r4 = r0[r2];
        if (r3 >= r4.length) goto L9;
        r4[r3] = new BarcodeValue();
        r3 = r3 + 1;
        goto L6
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        DetectionResultColumn[] r12 = r11.getDetectionResultColumns();
        int r5 = r12.length;
        int r6 = 0;
        int r7 = 0;
    L11:
        if (r6 >= r5) goto L25;
        DetectionResultColumn r8 = r12[r6];
        if (r8 == null) goto L24;
        Codeword[] r9 = r8.getCodewords();
        int r10 = r9.length;
        int r13 = 0;
    L15:
        if (r13 >= r10) goto L24;
        Codeword r14 = r9[r13];
        if (r14 == null) goto L23;
        int r15 = r14.getRowNumber();
        if (r15 < 0) goto L23;
        if (r15 >= r0.length) goto L23;
        r0[r15][r7].setValue(r14.getValue());
    L23:
        r13 = r13 + 1;
    L24:
        r7 = r7 + 1;
        r6 = r6 + 1;
        goto L11
    L25:
        return r0;
    }

    private static boolean isValidBarcodeColumn(DetectionResult r1, int r2) {
        if (r2 >= 0) goto L4;
        return false;
    L4:
        if (r2 > (r1.getBarcodeColumnCount() + 1)) goto L8;
        return true;
    L8:
        return false;
    }

    private static int getStartColumn(DetectionResult r6, int r7, int r8, boolean r9) {
        if (r9 == false) goto L4;
        int r0 = 1;
    L5:
        int r1 = r7 - r0;
        if (isValidBarcodeColumn(r6, r1) == false) goto L8;
        Codeword r2 = r6.getDetectionResultColumn(r1).getCodeword(r8);
    L9:
        if (r2 == null) goto L15;
        if (r9 == false) goto L14;
        return r2.getEndX();
    L14:
        return r2.getStartX();
    L15:
        Codeword r3 = r6.getDetectionResultColumn(r7).getCodewordNearby(r8);
        if (r3 == null) goto L23;
        if (r9 == false) goto L21;
        return r3.getStartX();
    L21:
        return r3.getEndX();
    L23:
        if (isValidBarcodeColumn(r6, r1) == false) goto L25;
        r3 = r6.getDetectionResultColumn(r1).getCodewordNearby(r8);
    L25:
        if (r3 == null) goto L31;
        if (r9 == false) goto L30;
        return r3.getEndX();
    L30:
        return r3.getStartX();
    L31:
        int r4 = 0;
    L32:
        r7 = r7 - r0;
        if (isValidBarcodeColumn(r6, r7) == false) goto L45;
        Codeword[] r5 = r6.getDetectionResultColumn(r7).getCodewords();
        int r10 = r5.length;
        int r11 = 0;
    L35:
        if (r11 >= r10) goto L44;
        Codeword r12 = r5[r11];
        if (r12 != null) goto L38;
        r11 = r11 + 1;
        goto L35
    L38:
        if (r9 == false) goto L40;
        int r13 = r12.getEndX();
    L42:
        return r13 + ((r0 * r4) * (r12.getEndX() - r12.getStartX()));
    L40:
        r13 = r12.getStartX();
        goto L42
    L44:
        r4 = r4 + 1;
        goto L32
    L45:
        BoundingBox r14 = r6.getBoundingBox();
        if (r9 == false) goto L50;
        return r14.getMinX();
    L50:
        return r14.getMaxX();
    L8:
        r2 = null;
        goto L9
    L4:
        r0 = -1;
        goto L5
    }

    private static Codeword detectCodeword(BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = adjustCodewordStartColumn(r7, r8, r9, r10, r11, r12);
        int[] r16 = getModuleBitCount(r7, r8, r9, r10, r15, r12);
        if (r16 != null) goto L5;
        return null;
    L5:
        int r17 = MathUtils.sum(r16);
        if (r10 == false) goto L8;
        int r18 = r15 + r17;
    L14:
        if (checkCodewordSkew(r17, r13, r14) == true) goto L16;
        return null;
    L16:
        int r19 = PDF417CodewordDecoder.getDecodedValue(r16);
        int r20 = PDF417Common.getCodeword(r19);
        if (r20 != (-1)) goto L20;
        return null;
    L20:
        return new Codeword(r15, r18, getCodewordBucketNumber(r19), r20);
    L8:
        int r110 = 0;
    L10:
        if (r110 >= (r16.length / 2)) goto L12;
        int r111 = r16[r110];
        r16[r110] = r16[(r16.length - 1) - r110];
        r16[(r16.length - 1) - r110] = r111;
        r110 = r110 + 1;
        goto L10
    L12:
        r15 = r15 - r17;
        r18 = r15;
        goto L14
    }

    private static int[] getModuleBitCount(BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12) {
        int[] r1 = new int[8];
        if (r10 == false) goto L5;
        int r3 = 1;
    L6:
        int r4 = 0;
        boolean r5 = r10;
    L7:
        if (r10 == false) goto L10;
        if (r11 >= r9) goto L16;
    L11:
        if (r4 >= 8) goto L16;
        if (r7.get(r11, r12) == r5) goto L14;
        r4 = r4 + 1;
        r5 = !r5;
        goto L7
    L14:
        r1[r4] = r1[r4] + 1;
        r11 = r11 + r3;
    L16:
        if (r4 == 8) goto L25;
        if (r10 == false) goto L19;
        r8 = r9;
    L19:
        if (r11 == r8) goto L21;
        return null;
    L21:
        if (r4 == 7) goto L25;
        return null;
    L25:
        return r1;
    L10:
        if (r11 < r8) goto L16;
    L5:
        r3 = -1;
        goto L6
    }

    private static int adjustCodewordStartColumn(BitMatrix r5, int r6, int r7, boolean r8, int r9, int r10) {
        if (r8 == false) goto L4;
        int r0 = -1;
    L5:
        int r1 = 0;
        int r2 = r9;
    L7:
        if (r1 >= 2) goto L19;
    L8:
        if (r8 == false) goto L11;
        if (r2 < r6) goto L18;
    L13:
        if (r8 != r5.get(r2, r10)) goto L18;
        if (Math.abs(r9 - r2) > 2) goto L16;
        r2 = r2 + r0;
        goto L8
    L16:
        return r9;
    L18:
        r0 = -r0;
        r8 = !r8;
        r1 = r1 + 1;
        goto L7
    L11:
        if (r2 >= r7) goto L18;
    L19:
        return r2;
    L4:
        r0 = 1;
        goto L5
    }

    private static DecoderResult decodeCodewords(int[] r2, int r3, int[] r4) throws FormatException, ChecksumException {
        if (r2.length == 0) goto L7;
        int r0 = 1 << (r3 + 1);
        int r1 = correctErrors(r2, r4, r0);
        verifyCodewordCount(r2, r0);
        DecoderResult r5 = DecodedBitStreamParser.decode(r2, String.valueOf(r3));
        r5.setErrorsCorrected(Integer.valueOf(r1));
        r5.setErasures(Integer.valueOf(r4.length));
        return r5;
    L7:
        throw FormatException.getFormatInstance();
    }

    private static int correctErrors(int[] r2, int[] r3, int r4) throws ChecksumException {
        if (r3 != null) goto L4;
    L5:
        if (r4 >= 0) goto L7;
    L11:
        throw ChecksumException.getChecksumInstance();
    L7:
        if (r4 > 512) goto L11;
        return errorCorrection.decode(r2, r4, r3);
    L4:
        if (r3.length > ((r4 / 2) + 3)) goto L11;
        goto L5
    }

    private static void verifyCodewordCount(int[] r3, int r4) throws FormatException {
        if (r3.length < 4) goto L17;
        int r1 = r3[0];
        if (r1 > r3.length) goto L15;
        if (r1 == 0) goto L8;
        return;
    L8:
        if (r4 >= r3.length) goto L12;
        r3[0] = r3.length - r4;
        return;
    L12:
        throw FormatException.getFormatInstance();
    L15:
        throw FormatException.getFormatInstance();
    L17:
        throw FormatException.getFormatInstance();
    }

    private static int[] getBitCountForCodeword(int r4) {
        int[] r0 = new int[8];
        int r1 = 0;
        int r2 = 7;
    L3:
        int r3 = r4 & 1;
        if (r3 == r1) goto L9;
        r2 = r2 - 1;
        if (r2 < 0) goto L8;
        r1 = r3;
        goto L9
    L8:
        return r0;
    L9:
        r0[r2] = r0[r2] + 1;
        r4 = r4 >> 1;
        goto L3
    }

    private static int getCodewordBucketNumber(int r0) {
        return getCodewordBucketNumber(getBitCountForCodeword(r0));
    }

    private static int getCodewordBucketNumber(int[] r2) {
        return ((((r2[0] - r2[2]) + r2[4]) - r2[6]) + 9) % 9;
    }

    public static String toString(BarcodeValue[][] r8) {
        Formatter r0 = new Formatter();
        int r2 = 0;
    L4:
        if (r2 >= r8.length) goto L14;
        r0.format("Row %2d: ", new Object[]{Integer.valueOf(r2)});
        int r4 = 0;
    L6:
        BarcodeValue[] r5 = r8[r2];
        if (r4 >= r5.length) goto L13;
        BarcodeValue r6 = r5[r4];
        if (r6.getValue().length != 0) goto L11;
        r0.format("        ", null);
    L12:
        r4 = r4 + 1;
        goto L6
    L11:
        r0.format("%4d(%2d)", new Object[]{Integer.valueOf(r6.getValue()[0]), r6.getConfidence(r6.getValue()[0])});
        goto L12
    L13:
        r0.format("%n", new Object[0]);
        r2 = r2 + 1;
        goto L4
    L14:
        String r9 = r0.toString();
        r0.close();
        return r9;
    }
}
