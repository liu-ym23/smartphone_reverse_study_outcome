package com.google.zxing.pdf417.encoder;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes3.dex */
final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final Charset DEFAULT_ENCODING = null;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED = null;
    private static final int NUMERIC_COMPACTION = 2;
    private static final byte[] PUNCTUATION = null;
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = null;
    private static final byte[] TEXT_PUNCTUATION_RAW = null;

    private static boolean isAlphaLower(char r1) {
        if (r1 != ' ') goto L5;
        return true;
    L5:
        if (r1 >= 'a') goto L7;
        return false;
    L7:
        if (r1 <= 'z') goto L14;
        return false;
    L14:
        return true;
    }

    private static boolean isAlphaUpper(char r1) {
        if (r1 != ' ') goto L5;
        return true;
    L5:
        if (r1 >= 'A') goto L7;
        return false;
    L7:
        if (r1 <= 'Z') goto L14;
        return false;
    L14:
        return true;
    }

    private static boolean isDigit(char r1) {
        if (r1 >= '0') goto L5;
        return false;
    L5:
        if (r1 > '9') goto L10;
        return true;
    L10:
        return false;
    }

    private static boolean isText(char r1) {
        if (r1 != '\t') goto L5;
        return true;
    L5:
        if (r1 != '\n') goto L7;
        return true;
    L7:
        if (r1 != '\r') goto L9;
        return true;
    L9:
        if (r1 >= ' ') goto L11;
        return false;
    L11:
        if (r1 <= '~') goto L20;
        return false;
    L20:
        return true;
    }

    static {
        TEXT_MIXED_RAW = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, Ascii.CR, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, Base64.padSymbol, 94, 0, 32, 0, 0, 0};
        TEXT_PUNCTUATION_RAW = new byte[]{59, 60, 62, SignedBytes.MAX_POWER_OF_TWO, 91, 92, 93, 95, 96, 126, 33, Ascii.CR, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
        byte[] r1 = new byte[128];
        MIXED = r1;
        PUNCTUATION = new byte[128];
        DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
        Arrays.fill(r1, (byte) -1);
        int r2 = 0;
        int r3 = 0;
    L3:
        byte[] r4 = TEXT_MIXED_RAW;
        if (r3 >= r4.length) goto L9;
        byte r5 = r4[r3];
        if (r5 <= 0) goto L8;
        MIXED[r5] = (byte) r3;
    L8:
        r3 = r3 + 1;
        goto L3
    L9:
        Arrays.fill(PUNCTUATION, (byte) -1);
    L10:
        byte[] r0 = TEXT_PUNCTUATION_RAW;
        if (r2 >= r0.length) goto L16;
        byte r6 = r0[r2];
        if (r6 <= 0) goto L15;
        PUNCTUATION[r6] = (byte) r2;
    L15:
        r2 = r2 + 1;
        goto L10
    }

    private PDF417HighLevelEncoder() {
    }

    static String encodeHighLevel(String r10, Compaction r11, Charset r12) throws WriterException {
        StringBuilder r0 = new StringBuilder(r10.length());
        if (r12 != null) goto L6;
        r12 = DEFAULT_ENCODING;
    L10:
        int r1 = r10.length();
        if (r11 != Compaction.TEXT) goto L14;
        encodeText(r10, 0, r1, r0, 0);
    L41:
        return r0.toString();
    L14:
        if (r11 != Compaction.BYTE) goto L17;
        byte[] r13 = r10.getBytes(r12);
        encodeBinary(r13, 0, r13.length, 1, r0);
        goto L41
    L17:
        if (r11 != Compaction.NUMERIC) goto L19;
        r0.append(902);
        encodeNumeric(r10, 0, r1, r0);
        goto L41
    L19:
        int r14 = 0;
        int r2 = 0;
        int r6 = 0;
    L20:
        if (r14 >= r1) goto L41;
        int r7 = determineConsecutiveDigitCount(r10, r14);
        if (r7 >= 13) goto L23;
        int r8 = determineConsecutiveTextCount(r10, r14);
        if (r8 >= 5) goto L37;
        if (r7 == r1) goto L37;
        int r9 = determineConsecutiveBinaryCount(r10, r14, r12);
        if (r9 != 0) goto L31;
        r9 = 1;
    L31:
        int r15 = r9 + r14;
        byte[] r16 = r10.substring(r14, r15).getBytes(r12);
        if (r16.length != 1) goto L35;
        if (r6 != 0) goto L35;
        encodeBinary(r16, 0, 1, 0, r0);
    L36:
        r14 = r15;
    L35:
        encodeBinary(r16, 0, r16.length, r6, r0);
        r2 = 0;
        r6 = 1;
    L37:
        if (r6 == 0) goto L39;
        r0.append(900);
        r2 = 0;
        r6 = 0;
    L39:
        r2 = encodeText(r10, r14, r8, r0, r2);
        r14 = r14 + r8;
        goto L20
    L23:
        r0.append(902);
        encodeNumeric(r10, r14, r7, r0);
        r14 = r14 + r7;
        r6 = 2;
        r2 = 0;
        goto L20
    L6:
        if (DEFAULT_ENCODING.equals(r12) == true) goto L10;
        CharacterSetECI r3 = CharacterSetECI.getCharacterSetECIByName(r12.name());
        if (r3 == null) goto L10;
        encodingECI(r3.getValue(), r0);
        goto L10
    }

    private static int encodeText(CharSequence r16, int r17, int r18, StringBuilder r19, int r20) {
        StringBuilder r3 = new StringBuilder(r18);
        int r5 = r20;
        int r6 = 0;
    L3:
        int r7 = r17 + r6;
        char r8 = r16.charAt(r7);
        if (r5 == 0) goto L40;
        if (r5 != 1) goto L6;
        if (isAlphaLower(r8) == true) goto L29;
        if (isAlphaUpper(r8) == true) goto L34;
        if (isMixed(r8) == false) goto L38;
        r3.append(28);
    L51:
        r5 = 2;
        goto L3
    L38:
        r3.append(29);
        r3.append((char) PUNCTUATION[r8]);
    L53:
        r6 = r6 + 1;
        if (r6 < r18) goto L3;
        int r0 = r3.length();
        int r1 = 0;
        char r9 = 0;
    L56:
        if (r1 >= r0) goto L66;
        if ((r1 % 2) == 0) goto L60;
        boolean r10 = true;
    L61:
        if (r10 == false) goto L63;
        r9 = (char) ((r9 * 30) + r3.charAt(r1));
        r19.append(r9);
    L64:
        r1 = r1 + 1;
        goto L56
    L63:
        r9 = r3.charAt(r1);
        goto L64
    L60:
        r10 = false;
        goto L61
    L66:
        if ((r0 % 2) == 0) goto L68;
        r19.append((char) ((r9 * 30) + 29));
    L68:
        return r5;
    L34:
        r3.append(27);
        r3.append((char) (r8 - 'A'));
        goto L53
    L29:
        if (r8 != ' ') goto L31;
        r3.append(26);
        goto L53
    L31:
        r3.append((char) (r8 - 'a'));
        goto L53
    L6:
        if (r5 != 2) goto L8;
        if (isMixed(r8) == true) goto L14;
        if (isAlphaUpper(r8) == false) goto L19;
        r3.append(28);
    L11:
        r5 = 0;
        goto L3
    L19:
        if (isAlphaLower(r8) == false) goto L21;
        r3.append(27);
    L47:
        r5 = 1;
        goto L3
    L21:
        int r11 = r7 + 1;
        if (r11 >= r18) goto L26;
        if (isPunctuation(r16.charAt(r11)) == false) goto L26;
        r3.append(25);
        r5 = 3;
    L26:
        r3.append(29);
        r3.append((char) PUNCTUATION[r8]);
        goto L53
    L14:
        r3.append((char) MIXED[r8]);
        goto L53
    L8:
        if (isPunctuation(r8) == true) goto L9;
        r3.append(29);
        goto L11
    L9:
        r3.append((char) PUNCTUATION[r8]);
        goto L53
    L40:
        if (isAlphaUpper(r8) == true) goto L41;
        if (isAlphaLower(r8) == false) goto L49;
        r3.append(27);
        goto L47
    L49:
        if (isMixed(r8) == false) goto L52;
        r3.append(28);
        goto L51
    L52:
        r3.append(29);
        r3.append((char) PUNCTUATION[r8]);
        goto L53
    L41:
        if (r8 != ' ') goto L43;
        r3.append(26);
        goto L53
    L43:
        r3.append((char) (r8 - 'A'));
        goto L53
    }

    private static void encodeBinary(byte[] r10, int r11, int r12, int r13, StringBuilder r14) {
        if (r12 != 1) goto L7;
        if (r13 != 0) goto L7;
        r14.append(913);
    L11:
        if (r12 < 6) goto L24;
        char[] r1 = new char[5];
        int r2 = r11;
    L14:
        if (((r11 + r12) - r2) < 6) goto L26;
        int r3 = 0;
        long r4 = 0;
        int r6 = 0;
    L16:
        if (r6 >= 6) goto L18;
        r4 = (r4 << 8) + ((long) (r10[r2 + r6] & 255));
        r6 = r6 + 1;
    L18:
        if (r3 >= 5) goto L20;
        r1[r3] = (char) (r4 % 900);
        r4 = r4 / 900;
        r3 = r3 + 1;
        goto L18
    L20:
        int r5 = 4;
    L21:
        if (r5 < 0) goto L23;
        r14.append(r1[r5]);
        r5 = r5 - 1;
        goto L21
    L23:
        r2 = r2 + 6;
    L26:
        if (r2 >= (r11 + r12)) goto L28;
        r14.append((char) (r10[r2] & 255));
        r2 = r2 + 1;
        goto L26
    L28:
        return;
    L24:
        r2 = r11;
    L7:
        if ((r12 % 6) != 0) goto L9;
        r14.append(924);
        goto L11
    L9:
        r14.append(901);
        goto L11
    }

    private static void encodeNumeric(String r9, int r10, int r11, StringBuilder r12) {
        StringBuilder r0 = new StringBuilder((r11 / 3) + 1);
        BigInteger r1 = BigInteger.valueOf(900);
        BigInteger r2 = BigInteger.valueOf(0);
        int r4 = 0;
    L3:
        if (r4 >= r11) goto L11;
        r0.setLength(0);
        int r5 = Math.min(44, r11 - r4);
        int r7 = r10 + r4;
        BigInteger r8 = new BigInteger("1" + r9.substring(r7, r7 + r5));
    L5:
        r0.append((char) r8.mod(r1).intValue());
        r8 = r8.divide(r1);
        if (r8.equals(r2) == false) goto L5;
        int r6 = r0.length() - 1;
    L8:
        if (r6 < 0) goto L10;
        r12.append(r0.charAt(r6));
        r6 = r6 - 1;
        goto L8
    L10:
        r4 = r4 + r5;
        goto L3
    }

    private static boolean isMixed(char r1) {
        if (MIXED[r1] == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean isPunctuation(char r1) {
        if (PUNCTUATION[r1] == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    private static int determineConsecutiveDigitCount(CharSequence r4, int r5) {
        int r0 = r4.length();
        int r1 = 0;
        if (r5 >= r0) goto L11;
        char r2 = r4.charAt(r5);
    L6:
        if (isDigit(r2) == false) goto L11;
        if (r5 >= r0) goto L11;
        r1 = r1 + 1;
        r5 = r5 + 1;
        if (r5 >= r0) goto L6;
        r2 = r4.charAt(r5);
    L11:
        return r1;
    }

    private static int determineConsecutiveTextCount(CharSequence r6, int r7) {
        int r0 = r6.length();
        int r1 = r7;
    L3:
        if (r1 >= r0) goto L21;
        char r2 = r6.charAt(r1);
        int r3 = 0;
    L6:
        if (r3 >= 13) goto L13;
        if (isDigit(r2) == false) goto L13;
        if (r1 >= r0) goto L13;
        r3 = r3 + 1;
        r1 = r1 + 1;
        if (r1 >= r0) goto L6;
        r2 = r6.charAt(r1);
    L13:
        if (r3 >= 13) goto L15;
        if (r3 > 0) goto L3;
        if (isText(r6.charAt(r1)) == false) goto L21;
        r1 = r1 + 1;
        goto L3
    L15:
        return (r1 - r7) - r3;
    L21:
        return r1 - r7;
    }

    private static int determineConsecutiveBinaryCount(String r5, int r6, Charset r7) throws WriterException {
        CharsetEncoder r8 = r7.newEncoder();
        int r0 = r5.length();
        int r1 = r6;
    L3:
        if (r1 >= r0) goto L21;
        char r2 = r5.charAt(r1);
        int r3 = 0;
    L6:
        if (r3 >= 13) goto L12;
        if (isDigit(r2) == false) goto L12;
        r3 = r3 + 1;
        int r4 = r1 + r3;
        if (r4 >= r0) goto L12;
        r2 = r5.charAt(r4);
    L12:
        if (r3 >= 13) goto L14;
        char r9 = r5.charAt(r1);
        if (r8.canEncode(r9) == false) goto L19;
        r1 = r1 + 1;
        goto L3
    L19:
        throw new WriterException("Non-encodable character detected: " + r9 + " (Unicode: " + r9 + ')');
    L14:
        return r1 - r6;
    L21:
        return r1 - r6;
    }

    private static void encodingECI(int r2, StringBuilder r3) throws WriterException {
        if (r2 < 0) goto L8;
        if (r2 >= 900) goto L8;
        r3.append(927);
        r3.append((char) r2);
        return;
    L8:
        if (r2 >= 810900) goto L12;
        r3.append(926);
        r3.append((char) ((r2 / 900) - 1));
        r3.append((char) (r2 % 900));
        return;
    L12:
        if (r2 >= 811800) goto L16;
        r3.append(925);
        r3.append((char) (810900 - r2));
        return;
    L16:
        throw new WriterException("ECI number not in valid range from 0..811799, but was " + r2);
    }
}
