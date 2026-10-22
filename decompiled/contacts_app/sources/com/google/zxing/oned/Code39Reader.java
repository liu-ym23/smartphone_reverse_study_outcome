package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.obric.oui.lisitem.OCardListItem;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Code39Reader extends OneDReader {
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    static final int ASTERISK_ENCODING = 0;
    static final int[] CHARACTER_ENCODINGS = null;
    private static final String CHECK_DIGIT_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    private final int[] counters;
    private final StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    static {
        int[] r0 = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 162, 138, 42};
        CHARACTER_ENCODINGS = r0;
        ASTERISK_ENCODING = r0[39];
    }

    public Code39Reader() {
        this(false);
    }

    public Code39Reader(boolean r2) {
        this(r2, false);
    }

    public Code39Reader(boolean r1, boolean r2) {
        this.usingCheckDigit = r1;
        this.extendedMode = r2;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r12, BitArray r13, Map<DecodeHintType, ?> r14) throws NotFoundException, ChecksumException, FormatException {
        int[] r15 = this.counters;
        Arrays.fill(r15, 0);
        StringBuilder r1 = this.decodeRowResult;
        r1.setLength(0);
        int[] r2 = findAsteriskPattern(r13, r15);
        int r4 = r13.getNextSet(r2[1]);
        int r5 = r13.getSize();
    L3:
        recordPattern(r13, r4, r15);
        int r6 = toNarrowWidePattern(r15);
        if (r6 < 0) goto L43;
        char r7 = patternToChar(r6);
        r1.append(r7);
        int r8 = r15.length;
        int r9 = 0;
        int r10 = r4;
    L6:
        if (r9 >= r8) goto L8;
        r10 = r10 + r15[r9];
        r9 = r9 + 1;
        goto L6
    L8:
        int r11 = r13.getNextSet(r10);
        if (r7 == '*') goto L10;
        r4 = r11;
        goto L3
    L10:
        r1.setLength(r1.length() - 1);
        int r16 = r15.length;
        int r17 = 0;
        int r18 = 0;
    L11:
        if (r17 >= r16) goto L13;
        r18 = r18 + r15[r17];
        r17 = r17 + 1;
        goto L11
    L13:
        int r19 = (r11 - r4) - r18;
        if (r11 == r5) goto L21;
        if ((r19 << 1) >= r18) goto L21;
        throw NotFoundException.getNotFoundInstance();
    L21:
        if (this.usingCheckDigit == false) goto L32;
        int r110 = r1.length() - 1;
        int r111 = 0;
        int r20 = 0;
    L24:
        if (r111 >= r110) goto L27;
        r20 = r20 + CHECK_DIGIT_STRING.indexOf(this.decodeRowResult.charAt(r111));
        r111 = r111 + 1;
        goto L24
    L27:
        if (r1.charAt(r110) != CHECK_DIGIT_STRING.charAt(r20 % 43)) goto L30;
        r1.setLength(r110);
        goto L32
    L30:
        throw ChecksumException.getChecksumInstance();
    L32:
        if (r1.length() == 0) goto L40;
        if (this.extendedMode == false) goto L36;
        String r112 = decodeExtended(r1);
    L37:
        float r113 = r12;
        return new Result(r112, null, new ResultPoint[]{new ResultPoint((r2[1] + r2[0]) / 2.0f, r113), new ResultPoint(r4 + (r18 / 2.0f), r113)}, BarcodeFormat.CODE_39);
    L36:
        r112 = r1.toString();
        goto L37
    L40:
        throw NotFoundException.getNotFoundInstance();
    L43:
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] findAsteriskPattern(BitArray r12, int[] r13) throws NotFoundException {
        int r0 = r12.getSize();
        int r2 = r12.getNextSet(0);
        int r3 = r13.length;
        boolean r5 = false;
        int r6 = 0;
        int r4 = r2;
    L3:
        if (r2 >= r0) goto L20;
        if ((r12.get(r2) ^ r5) == false) goto L7;
        r13[r6] = r13[r6] + 1;
    L18:
        r2 = r2 + 1;
        goto L3
    L7:
        int r7 = r3 - 1;
        if (r6 == r7) goto L10;
        r6 = r6 + 1;
    L17:
        r13[r6] = 1;
        r5 = !r5;
        goto L18
    L10:
        if (toNarrowWidePattern(r13) == ASTERISK_ENCODING) goto L12;
    L15:
        r4 = r4 + (r13[0] + r13[1]);
        int r9 = r3 - 2;
        System.arraycopy(r13, 2, r13, 0, r9);
        r13[r9] = 0;
        r13[r7] = 0;
        r6 = r6 - 1;
        goto L17
    L12:
        if (r12.isRange(Math.max(0, r4 - ((r2 - r4) / 2)), r4, false) == false) goto L15;
        return new int[]{r4, r2};
    L20:
        throw NotFoundException.getNotFoundInstance();
    }

    private static int toNarrowWidePattern(int[] r10) {
        int r0 = r10.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        int r3 = r10.length;
        int r4 = Integer.MAX_VALUE;
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L10;
        int r6 = r10[r5];
        if (r6 >= r4) goto L9;
        if (r6 <= r2) goto L9;
        r4 = r6;
    L9:
        r5 = r5 + 1;
        goto L4
    L10:
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r11 = 0;
    L11:
        if (r7 >= r0) goto L17;
        int r12 = r10[r7];
        if (r12 <= r4) goto L15;
        r9 = r9 | (1 << ((r0 - 1) - r7));
        r8 = r8 + 1;
        r11 = r11 + r12;
    L15:
        r7 = r7 + 1;
        goto L11
    L17:
        if (r8 == 3) goto L18;
        if (r8 <= 3) goto L28;
        r2 = r4;
        goto L3
    L28:
        return -1;
    L18:
        if (r1 >= r0) goto L26;
        if (r8 <= 0) goto L26;
        int r13 = r10[r1];
        if (r13 <= r4) goto L25;
        r8 = r8 - 1;
        if ((r13 << 1) < r11) goto L25;
        return -1;
    L25:
        r1 = r1 + 1;
    L26:
        return r9;
    }

    private static char patternToChar(int r3) throws NotFoundException {
        int r0 = 0;
    L3:
        int[] r1 = CHARACTER_ENCODINGS;
        if (r0 >= r1.length) goto L11;
        if (r1[r0] == r3) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return ALPHABET_STRING.charAt(r0);
    L11:
        throw NotFoundException.getNotFoundInstance();
    }

    private static String decodeExtended(CharSequence r12) throws FormatException {
        int r0 = r12.length();
        StringBuilder r1 = new StringBuilder(r0);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L50;
        char r4 = r12.charAt(r3);
        if (r4 == '+') goto L11;
        if (r4 == '$') goto L11;
        if (r4 == '%') goto L11;
        if (r4 == '/') goto L11;
        r1.append(r4);
    L46:
        r3 = r3 + 1;
    L11:
        r3 = r3 + 1;
        char r9 = r12.charAt(r3);
        if (r4 == '$') goto L41;
        if (r4 == '%') goto L30;
        if (r4 == '+') goto L25;
        if (r4 == '/') goto L17;
        char r5 = 0;
    L45:
        r1.append(r5);
        goto L46
    L17:
        if (r9 >= 'A') goto L19;
    L21:
        if (r9 != 'Z') goto L24;
        r5 = ':';
        goto L45
    L24:
        throw FormatException.getFormatInstance();
    L19:
        if (r9 > 'O') goto L21;
        int r10 = r9 - ' ';
    L44:
        r5 = (char) r10;
        goto L45
    L25:
        if (r9 < 'A') goto L29;
        if (r9 > 'Z') goto L29;
        r10 = r9 + ' ';
    L29:
        throw FormatException.getFormatInstance();
    L30:
        if (r9 < 'A') goto L35;
        if (r9 > 'E') goto L35;
        r10 = r9 - '&';
    L35:
        if (r9 < 'F') goto L40;
        if (r9 > 'W') goto L40;
        r10 = r9 - 11;
    L40:
        throw FormatException.getFormatInstance();
    L41:
        if (r9 < 'A') goto L48;
        if (r9 > 'Z') goto L48;
        r10 = r9 - '@';
    L48:
        throw FormatException.getFormatInstance();
    L50:
        return r1.toString();
    }
}
