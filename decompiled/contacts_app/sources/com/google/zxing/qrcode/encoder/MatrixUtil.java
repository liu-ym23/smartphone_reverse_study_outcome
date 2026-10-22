package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import obric.widget.ChipsView;

/* JADX INFO: loaded from: classes3.dex */
final class MatrixUtil {
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = null;
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = null;
    private static final int[][] POSITION_DETECTION_PATTERN = null;
    private static final int[][] TYPE_INFO_COORDINATES = null;
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;

    private static boolean isEmpty(int r1) {
        if (r1 != (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    private MatrixUtil() {
    }

    static {
        POSITION_DETECTION_PATTERN = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
        POSITION_ADJUSTMENT_PATTERN = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
        POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, ChipsView.RECOMMENDED, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, SmsMmsDatabaseUtil.MESSAGE_TYPE_RETRIEVE_CONF, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
        TYPE_INFO_COORDINATES = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    }

    static void clearMatrix(ByteMatrix r1) {
        r1.clear((byte) -1);
    }

    static void buildMatrix(BitArray r0, ErrorCorrectionLevel r1, Version r2, int r3, ByteMatrix r4) throws WriterException {
        clearMatrix(r4);
        embedBasicPatterns(r2, r4);
        embedTypeInfo(r1, r3, r4);
        maybeEmbedVersionInfo(r2, r4);
        embedDataBits(r0, r3, r4);
    }

    static void embedBasicPatterns(Version r0, ByteMatrix r1) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(r1);
        embedDarkDotAtLeftBottomCorner(r1);
        maybeEmbedPositionAdjustmentPatterns(r0, r1);
        embedTimingPatterns(r1);
    }

    static void embedTypeInfo(ErrorCorrectionLevel r5, int r6, ByteMatrix r7) throws WriterException {
        BitArray r0 = new BitArray();
        makeTypeInfoBits(r5, r6, r0);
        int r8 = 0;
    L4:
        if (r8 >= r0.getSize()) goto L10;
        boolean r1 = r0.get((r0.getSize() - 1) - r8);
        int[] r3 = TYPE_INFO_COORDINATES[r8];
        r7.set(r3[0], r3[1], r1);
        if (r8 >= 8) goto L8;
        r7.set((r7.getWidth() - r8) - 1, 8, r1);
    L9:
        r8 = r8 + 1;
        goto L4
    L8:
        r7.set(8, (r7.getHeight() - 7) + (r8 - 8), r1);
        goto L9
    }

    static void maybeEmbedVersionInfo(Version r6, ByteMatrix r7) throws WriterException {
        if (r6.getVersionNumber() >= 7) goto L5;
        return;
    L5:
        BitArray r0 = new BitArray();
        makeVersionInfoBits(r6, r0);
        int r1 = 17;
        int r2 = 0;
    L7:
        if (r2 >= 6) goto L13;
        int r3 = 0;
    L10:
        if (r3 >= 3) goto L12;
        boolean r4 = r0.get(r1);
        r1 = r1 - 1;
        r7.set(r2, (r7.getHeight() - 11) + r3, r4);
        r7.set((r7.getHeight() - 11) + r3, r2, r4);
        r3 = r3 + 1;
        goto L10
    L12:
        r2 = r2 + 1;
        goto L7
    }

    static void embedDataBits(BitArray r10, int r11, ByteMatrix r12) throws WriterException {
        int r0 = r12.getWidth() - 1;
        int r1 = r12.getHeight() - 1;
        int r4 = 0;
        int r5 = -1;
    L3:
        if (r0 <= 0) goto L28;
        if (r0 != 6) goto L7;
        r0 = r0 - 1;
    L7:
        if (r1 < 0) goto L26;
        if (r1 >= r12.getHeight()) goto L26;
        int r6 = 0;
    L12:
        if (r6 >= 2) goto L25;
        int r7 = r0 - r6;
        if (isEmpty(r12.get(r7, r1)) == false) goto L24;
        if (r4 >= r10.getSize()) goto L18;
        boolean r8 = r10.get(r4);
        r4 = r4 + 1;
    L19:
        if (r11 != (-1)) goto L21;
    L23:
        r12.set(r7, r1, r8);
        goto L24
    L21:
        if (MaskUtil.getDataMaskBit(r11, r7, r1) == false) goto L23;
        r8 = !r8;
        goto L23
    L18:
        r8 = false;
    L24:
        r6 = r6 + 1;
        goto L12
    L25:
        r1 = r1 + r5;
    L26:
        r5 = -r5;
        r1 = r1 + r5;
        r0 = r0 - 2;
        goto L3
    L28:
        if (r4 != r10.getSize()) goto L31;
        return;
    L31:
        throw new WriterException("Not all bits consumed: " + r4 + '/' + r10.getSize());
    }

    static int findMSBSet(int r0) {
        return 32 - Integer.numberOfLeadingZeros(r0);
    }

    static int calculateBCHCode(int r2, int r3) {
        if (r3 == 0) goto L9;
        int r0 = findMSBSet(r3);
        int r4 = r2 << (r0 - 1);
    L5:
        if (findMSBSet(r4) < r0) goto L7;
        r4 = r4 ^ (r3 << (findMSBSet(r4) - r0));
        goto L5
    L7:
        return r4;
    L9:
        throw new IllegalArgumentException("0 polynomial");
    }

    static void makeTypeInfoBits(ErrorCorrectionLevel r1, int r2, BitArray r3) throws WriterException {
        if (QRCode.isValidMaskPattern(r2) == false) goto L10;
        int r4 = (r1.getBits() << 3) | r2;
        r3.appendBits(r4, 5);
        r3.appendBits(calculateBCHCode(r4, TYPE_INFO_POLY), 10);
        BitArray r5 = new BitArray();
        r5.appendBits(TYPE_INFO_MASK_PATTERN, 15);
        r3.xor(r5);
        if (r3.getSize() != 15) goto L8;
        return;
    L8:
        throw new WriterException("should not happen but we got: " + r3.getSize());
    L10:
        throw new WriterException("Invalid mask pattern");
    }

    static void makeVersionInfoBits(Version r2, BitArray r3) throws WriterException {
        r3.appendBits(r2.getVersionNumber(), 6);
        r3.appendBits(calculateBCHCode(r2.getVersionNumber(), VERSION_INFO_POLY), 12);
        if (r3.getSize() != 18) goto L6;
        return;
    L6:
        throw new WriterException("should not happen but we got: " + r3.getSize());
    }

    private static void embedTimingPatterns(ByteMatrix r6) {
        int r1 = 8;
    L4:
        if (r1 >= (r6.getWidth() - 8)) goto L12;
        int r2 = r1 + 1;
        int r3 = r2 % 2;
        if (isEmpty(r6.get(r1, 6)) == false) goto L9;
        r6.set(r1, 6, r3);
    L9:
        if (isEmpty(r6.get(6, r1)) == false) goto L11;
        r6.set(6, r1, r3);
    L11:
        r1 = r2;
        goto L4
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix r3) throws WriterException {
        if (r3.get(8, r3.getHeight() - 8) == 0) goto L7;
        r3.set(8, r3.getHeight() - 8, 1);
        return;
    L7:
        throw new WriterException();
    }

    private static void embedHorizontalSeparationPattern(int r4, int r5, ByteMatrix r6) throws WriterException {
        int r1 = 0;
    L4:
        if (r1 >= 8) goto L10;
        int r2 = r4 + r1;
        if (isEmpty(r6.get(r2, r5)) == false) goto L9;
        r6.set(r2, r5, 0);
        r1 = r1 + 1;
        goto L4
    L9:
        throw new WriterException();
    }

    private static void embedVerticalSeparationPattern(int r4, int r5, ByteMatrix r6) throws WriterException {
        int r1 = 0;
    L4:
        if (r1 >= 7) goto L10;
        int r2 = r5 + r1;
        if (isEmpty(r6.get(r4, r2)) == false) goto L9;
        r6.set(r4, r2, 0);
        r1 = r1 + 1;
        goto L4
    L9:
        throw new WriterException();
    }

    private static void embedPositionAdjustmentPattern(int r7, int r8, ByteMatrix r9) {
        int r1 = 0;
    L4:
        if (r1 >= 5) goto L9;
        int r3 = 0;
    L6:
        if (r3 >= 5) goto L8;
        r9.set(r7 + r3, r8 + r1, POSITION_ADJUSTMENT_PATTERN[r1][r3]);
        r3 = r3 + 1;
        goto L6
    L8:
        r1 = r1 + 1;
        goto L4
    }

    private static void embedPositionDetectionPattern(int r7, int r8, ByteMatrix r9) {
        int r1 = 0;
    L4:
        if (r1 >= 7) goto L9;
        int r3 = 0;
    L6:
        if (r3 >= 7) goto L8;
        r9.set(r7 + r3, r8 + r1, POSITION_DETECTION_PATTERN[r1][r3]);
        r3 = r3 + 1;
        goto L6
    L8:
        r1 = r1 + 1;
        goto L4
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix r3) throws WriterException {
        int r0 = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, r3);
        embedPositionDetectionPattern(r3.getWidth() - r0, 0, r3);
        embedPositionDetectionPattern(0, r3.getWidth() - r0, r3);
        embedHorizontalSeparationPattern(0, 7, r3);
        embedHorizontalSeparationPattern(r3.getWidth() - 8, 7, r3);
        embedHorizontalSeparationPattern(0, r3.getWidth() - 8, r3);
        embedVerticalSeparationPattern(7, 0, r3);
        embedVerticalSeparationPattern((r3.getHeight() - 7) - 1, 0, r3);
        embedVerticalSeparationPattern(7, r3.getHeight() - 7, r3);
    }

    private static void maybeEmbedPositionAdjustmentPatterns(Version r7, ByteMatrix r8) {
        if (r7.getVersionNumber() >= 2) goto L5;
        return;
    L5:
        int[] r9 = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[r7.getVersionNumber() - 1];
        int r0 = r9.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L17;
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L16;
        int r4 = r9[r2];
        int r5 = r9[r3];
        if (r5 == (-1)) goto L15;
        if (r4 == (-1)) goto L15;
        if (isEmpty(r8.get(r5, r4)) == false) goto L15;
        embedPositionAdjustmentPattern(r5 - 2, r4 - 2, r8);
    L15:
        r3 = r3 + 1;
        goto L8
    L16:
        r2 = r2 + 1;
        goto L6
    }
}
