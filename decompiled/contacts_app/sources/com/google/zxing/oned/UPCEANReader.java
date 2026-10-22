package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UPCEANReader extends OneDReader {
    static final int[] END_PATTERN = null;
    static final int[][] L_AND_G_PATTERNS = null;
    static final int[][] L_PATTERNS = null;
    private static final float MAX_AVG_VARIANCE = 0.48f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    static final int[] MIDDLE_PATTERN = null;
    static final int[] START_END_PATTERN = null;
    private final StringBuilder decodeRowStringBuffer;
    private final EANManufacturerOrgSupport eanManSupport;
    private final UPCEANExtensionSupport extensionReader;

    protected abstract int decodeMiddle(BitArray r1, int[] r2, StringBuilder r3) throws NotFoundException;

    abstract BarcodeFormat getBarcodeFormat();

    static {
        START_END_PATTERN = new int[]{1, 1, 1};
        MIDDLE_PATTERN = new int[]{1, 1, 1, 1, 1};
        END_PATTERN = new int[]{1, 1, 1, 1, 1, 1};
        int r3 = 10;
        int[][] r4 = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        L_PATTERNS = r4;
        int[][] r1 = new int[20][];
        L_AND_G_PATTERNS = r1;
        System.arraycopy(r4, 0, r1, 0, 10);
    L3:
        if (r3 >= 20) goto L9;
        int[] r2 = L_PATTERNS[r3 - 10];
        int[] r5 = new int[r2.length];
        int r6 = 0;
    L6:
        if (r6 >= r2.length) goto L8;
        r5[r6] = r2[(r2.length - r6) - 1];
        r6 = r6 + 1;
        goto L6
    L8:
        L_AND_G_PATTERNS[r3] = r5;
        r3 = r3 + 1;
        goto L3
    }

    protected UPCEANReader() {
        this.decodeRowStringBuffer = new StringBuilder(20);
        this.extensionReader = new UPCEANExtensionSupport();
        this.eanManSupport = new EANManufacturerOrgSupport();
    }

    static int[] findStartGuardPattern(BitArray r7) throws NotFoundException {
        int[] r0 = new int[START_END_PATTERN.length];
        int[] r2 = null;
        boolean r3 = false;
        int r4 = 0;
    L3:
        if (r3 == true) goto L8;
        int[] r5 = START_END_PATTERN;
        Arrays.fill(r0, 0, r5.length, 0);
        r2 = findGuardPattern(r7, r4, false, r5, r0);
        int r6 = r2[0];
        int r8 = r2[1];
        int r9 = r6 - (r8 - r6);
        if (r9 < 0) goto L7;
        r3 = r7.isRange(r9, r6, false);
    L7:
        r4 = r8;
        goto L3
    L8:
        return r2;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r2, BitArray r3, Map<DecodeHintType, ?> r4) throws NotFoundException, ChecksumException, FormatException {
        return decodeRow(r2, r3, findStartGuardPattern(r3), r4);
    }

    public Result decodeRow(int r12, BitArray r13, int[] r14, Map<DecodeHintType, ?> r15) throws NotFoundException, ChecksumException, FormatException {
        int[] r0 = null;
        if (r15 != null) goto L5;
        ResultPointCallback r1 = null;
    L6:
        boolean r3 = true;
        if (r1 == null) goto L9;
        r1.foundPossibleResultPoint(new ResultPoint((r14[0] + r14[1]) / 2.0f, r12));
    L9:
        StringBuilder r5 = this.decodeRowStringBuffer;
        r5.setLength(0);
        int r6 = decodeMiddle(r13, r14, r5);
        if (r1 == null) goto L12;
        r1.foundPossibleResultPoint(new ResultPoint(r6, r12));
    L12:
        int[] r7 = decodeEnd(r13, r6);
        if (r1 == null) goto L15;
        r1.foundPossibleResultPoint(new ResultPoint((r7[0] + r7[1]) / 2.0f, r12));
    L15:
        int r2 = r7[1];
        int r8 = (r2 - r7[0]) + r2;
        if (r8 >= r13.getSize()) goto L55;
        if (r13.isRange(r2, r8, false) == false) goto L55;
        String r4 = r5.toString();
        if (r4.length() < 8) goto L53;
        if (checkChecksum(r4) == false) goto L51;
        float r16 = (r14[1] + r14[0]) / 2.0f;
        float r9 = (r7[1] + r7[0]) / 2.0f;
        BarcodeFormat r10 = getBarcodeFormat();
        float r11 = r12;
        Result r17 = new Result(r4, null, new ResultPoint[]{new ResultPoint(r16, r11), new ResultPoint(r9, r11)}, r10);
        Result r18 = this.extensionReader.decodeRow(r12, r13, r7[1]);     // Catch: ReaderException -> L26
        r17.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, r18.getText());     // Catch: ReaderException -> L26
        r17.putAllMetadata(r18.getResultMetadata());     // Catch: ReaderException -> L26
        r17.addResultPoints(r18.getResultPoints());     // Catch: ReaderException -> L26
        int r19 = r18.getText().length();     // Catch: ReaderException -> L26
    L27:
        if (r15 == null) goto L30;
        r0 = (int[]) r15.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
    L30:
        if (r0 == null) goto L43;
        int r110 = r0.length;
        int r111 = 0;
    L32:
        if (r111 >= r110) goto L37;
        if (r19 == r0[r111]) goto L38;
        r111 = r111 + 1;
    L38:
        if (r3 == true) goto L43;
        throw NotFoundException.getNotFoundInstance();
    L37:
        r3 = false;
    L43:
        if (r10 != BarcodeFormat.EAN_13) goto L45;
    L46:
        String r112 = this.eanManSupport.lookupCountryIdentifier(r4);
        if (r112 == null) goto L49;
        r17.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, r112);
    L49:
        return r17;
    L45:
        if (r10 != BarcodeFormat.UPC_A) goto L49;
    L26:
        r19 = 0;
        goto L27
    L51:
        throw ChecksumException.getChecksumInstance();
    L53:
        throw FormatException.getFormatInstance();
    L55:
        throw NotFoundException.getNotFoundInstance();
    L5:
        r1 = (ResultPointCallback) r15.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        goto L6
    }

    boolean checkChecksum(String r1) throws FormatException {
        return checkStandardUPCEANChecksum(r1);
    }

    static boolean checkStandardUPCEANChecksum(CharSequence r6) throws FormatException {
        int r0 = r6.length();
        if (r0 != 0) goto L5;
        return false;
    L5:
        int r2 = r0 - 2;
        int r3 = 0;
    L7:
        if (r2 < 0) goto L14;
        int r5 = r6.charAt(r2) - '0';
        if (r5 < 0) goto L13;
        if (r5 > 9) goto L13;
        r3 = r3 + r5;
        r2 = r2 - 2;
    L13:
        throw FormatException.getFormatInstance();
    L14:
        int r4 = r3 * 3;
        int r1 = r0 - 1;
    L15:
        if (r1 < 0) goto L23;
        int r7 = r6.charAt(r1) - '0';
        if (r7 < 0) goto L21;
        if (r7 > 9) goto L21;
        r4 = r4 + r7;
        r1 = r1 - 2;
    L21:
        throw FormatException.getFormatInstance();
    L23:
        if ((r4 % 10) != 0) goto L25;
        return true;
    L25:
        return false;
    }

    int[] decodeEnd(BitArray r2, int r3) throws NotFoundException {
        return findGuardPattern(r2, r3, false, START_END_PATTERN);
    }

    static int[] findGuardPattern(BitArray r1, int r2, boolean r3, int[] r4) throws NotFoundException {
        return findGuardPattern(r1, r2, r3, r4, new int[r4.length]);
    }

    private static int[] findGuardPattern(BitArray r10, int r11, boolean r12, int[] r13, int[] r14) throws NotFoundException {
        int r0 = r10.getSize();
        if (r12 == false) goto L5;
        int r15 = r10.getNextUnset(r11);
    L6:
        int r1 = r13.length;
        boolean r3 = r12;
        int r4 = 0;
        int r16 = r15;
    L7:
        if (r15 >= r0) goto L22;
        if ((r10.get(r15) ^ r3) == false) goto L11;
        r14[r4] = r14[r4] + 1;
    L20:
        r15 = r15 + 1;
        goto L7
    L11:
        int r5 = r1 - 1;
        if (r4 == r5) goto L14;
        r4 = r4 + 1;
    L19:
        r14[r4] = 1;
        r3 = !r3;
        goto L20
    L14:
        if (patternMatchVariance(r14, r13, 0.7f) < MAX_AVG_VARIANCE) goto L16;
        r16 = r16 + (r14[0] + r14[1]);
        int r7 = r1 - 2;
        System.arraycopy(r14, 2, r14, 0, r7);
        r14[r7] = 0;
        r14[r5] = 0;
        r4 = r4 - 1;
        goto L19
    L16:
        return new int[]{r16, r15};
    L22:
        throw NotFoundException.getNotFoundInstance();
    L5:
        r15 = r10.getNextSet(r11);
        goto L6
    }

    static int decodeDigit(BitArray r4, int[] r5, int r6, int[][] r7) throws NotFoundException {
        recordPattern(r4, r6, r5);
        int r8 = r7.length;
        float r9 = MAX_AVG_VARIANCE;
        int r0 = -1;
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        float r2 = patternMatchVariance(r5, r7[r1], 0.7f);
        if (r2 >= r9) goto L7;
        r0 = r1;
        r9 = r2;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        if (r0 < 0) goto L11;
        return r0;
    L11:
        throw NotFoundException.getNotFoundInstance();
    }
}
