package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class HighLevelEncoder {
    static final int ASCII_ENCODATION = 0;
    static final int BASE256_ENCODATION = 5;
    static final int C40_ENCODATION = 1;
    static final char C40_UNLATCH = 254;
    static final int EDIFACT_ENCODATION = 4;
    static final char LATCH_TO_ANSIX12 = 238;
    static final char LATCH_TO_BASE256 = 231;
    static final char LATCH_TO_C40 = 230;
    static final char LATCH_TO_EDIFACT = 240;
    static final char LATCH_TO_TEXT = 239;
    private static final char MACRO_05 = 236;
    private static final String MACRO_05_HEADER = "[)>\u001e05\u001d";
    private static final char MACRO_06 = 237;
    private static final String MACRO_06_HEADER = "[)>\u001e06\u001d";
    private static final String MACRO_TRAILER = "\u001e\u0004";
    private static final char PAD = 129;
    static final int TEXT_ENCODATION = 2;
    static final char UPPER_SHIFT = 235;
    static final int X12_ENCODATION = 3;
    static final char X12_UNLATCH = 254;

    static boolean isDigit(char r1) {
        if (r1 >= '0') goto L5;
        return false;
    L5:
        if (r1 > '9') goto L10;
        return true;
    L10:
        return false;
    }

    static boolean isExtendedASCII(char r1) {
        if (r1 >= 128) goto L5;
        return false;
    L5:
        if (r1 > 255) goto L10;
        return true;
    L10:
        return false;
    }

    private static boolean isNativeC40(char r1) {
        if (r1 != ' ') goto L5;
        return true;
    L5:
        if (r1 < '0') goto L9;
        if (r1 > '9') goto L9;
        return true;
    L9:
        if (r1 >= 'A') goto L11;
        return false;
    L11:
        if (r1 <= 'Z') goto L19;
        return false;
    L19:
        return true;
    }

    private static boolean isNativeEDIFACT(char r1) {
        if (r1 >= ' ') goto L5;
        return false;
    L5:
        if (r1 > '^') goto L10;
        return true;
    L10:
        return false;
    }

    private static boolean isNativeText(char r1) {
        if (r1 != ' ') goto L5;
        return true;
    L5:
        if (r1 < '0') goto L9;
        if (r1 > '9') goto L9;
        return true;
    L9:
        if (r1 >= 'a') goto L11;
        return false;
    L11:
        if (r1 <= 'z') goto L19;
        return false;
    L19:
        return true;
    }

    private static boolean isSpecialB256(char r0) {
        return false;
    }

    private static boolean isX12TermSep(char r1) {
        if (r1 != '\r') goto L5;
        return true;
    L5:
        if (r1 != '*') goto L7;
        return true;
    L7:
        if (r1 == '>') goto L14;
        return false;
    L14:
        return true;
    }

    private HighLevelEncoder() {
    }

    private static char randomize253State(char r0, int r1) {
        int r2 = r0 + (((r1 * 149) % 253) + 1);
        if (r2 <= 254) goto L7;
        r2 = r2 - 254;
    L7:
        return (char) r2;
    }

    public static String encodeHighLevel(String r2) {
        return encodeHighLevel(r2, SymbolShapeHint.FORCE_NONE, null, null);
    }

    public static String encodeHighLevel(String r6, SymbolShapeHint r7, Dimension r8, Dimension r9) {
        int r2 = 0;
        Encoder[] r0 = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
        EncoderContext r1 = new EncoderContext(r6);
        r1.setSymbolShape(r7);
        r1.setSizeConstraints(r8, r9);
        if (r6.startsWith(MACRO_05_HEADER) == false) goto L8;
        if (r6.endsWith(MACRO_TRAILER) == false) goto L8;
        r1.writeCodeword(MACRO_05);
        r1.setSkipAtEnd(2);
        r1.pos += 7;
    L13:
        if (r1.hasMoreCharacters() == false) goto L17;
        r0[r2].encode(r1);
        if (r1.getNewEncoding() < 0) goto L13;
        r2 = r1.getNewEncoding();
        r1.resetEncoderSignal();
        goto L13
    L17:
        int r10 = r1.getCodewordCount();
        r1.updateSymbolInfo();
        int r11 = r1.getSymbolInfo().getDataCapacity();
        if (r10 >= r11) goto L22;
        if (r2 == 0) goto L22;
        if (r2 == 5) goto L22;
        r1.writeCodeword(254);
    L22:
        StringBuilder r12 = r1.getCodewords();
        if (r12.length() >= r11) goto L26;
        r12.append(PAD);
    L26:
        if (r12.length() >= r11) goto L29;
        r12.append(randomize253State(PAD, r12.length() + 1));
        goto L26
    L29:
        return r1.getCodewords().toString();
    L8:
        if (r6.startsWith(MACRO_06_HEADER) == false) goto L13;
        if (r6.endsWith(MACRO_TRAILER) == false) goto L13;
        r1.writeCodeword(MACRO_06);
        r1.setSkipAtEnd(2);
        r1.pos += 7;
        goto L13
    }

    static int lookAheadTest(CharSequence r19, int r20, int r21) {
        if (r20 < r19.length()) goto L5;
        return r21;
    L5:
        int r2 = 6;
        if (r21 != 0) goto L8;
        float[] r3 = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
    L9:
        int r5 = 0;
    L10:
        int r6 = r20 + r5;
        if (r6 == r19.length()) goto L12;
        char r7 = r19.charAt(r6);
        r5 = r5 + 1;
        if (isDigit(r7) == false) goto L36;
        r3[0] = r3[0] + 0.5f;
    L40:
        if (isNativeC40(r7) == false) goto L43;
        r3[1] = r3[1] + 0.6666667f;
    L47:
        if (isNativeText(r7) == false) goto L50;
        r3[2] = r3[2] + 0.6666667f;
    L54:
        if (isNativeX12(r7) == false) goto L57;
        r3[3] = r3[3] + 0.6666667f;
    L61:
        if (isNativeEDIFACT(r7) == false) goto L64;
        r3[4] = r3[4] + 0.75f;
    L68:
        if (isSpecialB256(r7) == false) goto L70;
        char r8 = 5;
        r3[5] = r3[5] + 4.0f;
    L71:
        if (r5 < 4) goto L120;
        int[] r9 = new int[r2];
        byte[] r10 = new byte[r2];
        findMinimums(r3, r9, Integer.MAX_VALUE, r10);
        int r11 = getMinimumCount(r10);
        int r14 = r9[0];
        int r15 = r9[r8];
        if (r14 < r15) goto L75;
    L83:
        if (r15 < r14) goto L118;
        byte r4 = r10[1];
        byte r17 = r10[2];
        byte r18 = r10[3];
        byte r12 = r10[4];
        if ((((r4 + r17) + r18) + r12) == 0) goto L139;
        if (r11 != 1) goto L90;
        if (r12 <= 0) goto L90;
        return 4;
    L90:
        if (r11 != 1) goto L93;
        if (r17 <= 0) goto L93;
        return 2;
    L93:
        if (r11 != 1) goto L96;
        if (r18 <= 0) goto L96;
        return 3;
    L96:
        int r13 = r9[1];
        if ((r13 + 1) >= r14) goto L120;
        if ((r13 + 1) >= r15) goto L120;
        if ((r13 + 1) >= r9[4]) goto L120;
        if ((r13 + 1) >= r9[2]) goto L120;
        int r16 = r9[3];
        if (r13 < r16) goto L106;
        if (r13 != r16) goto L120;
        int r1 = (r20 + r5) + 1;
    L110:
        if (r1 >= r19.length()) goto L117;
        char r22 = r19.charAt(r1);
        if (isX12TermSep(r22) == true) goto L113;
        if (isNativeX12(r22) == false) goto L117;
        r1 = r1 + 1;
        goto L110
    L113:
        return 3;
    L117:
        return 1;
    L106:
        return 1;
    L139:
        return 5;
    L118:
        return 5;
    L75:
        if (r14 >= r9[1]) goto L83;
        if (r14 >= r9[2]) goto L83;
        if (r14 >= r9[3]) goto L83;
        if (r14 >= r9[4]) goto L83;
        return 0;
    L120:
        r2 = 6;
        goto L10
    L70:
        r8 = 5;
        r3[5] = r3[5] + 1.0f;
        goto L71
    L64:
        if (isExtendedASCII(r7) == false) goto L66;
        r3[4] = r3[4] + 4.25f;
        goto L68
    L66:
        r3[4] = r3[4] + 3.25f;
        goto L68
    L57:
        if (isExtendedASCII(r7) == false) goto L59;
        r3[3] = r3[3] + 4.3333335f;
        goto L61
    L59:
        r3[3] = r3[3] + 3.3333333f;
        goto L61
    L50:
        if (isExtendedASCII(r7) == false) goto L52;
        r3[2] = r3[2] + 2.6666667f;
        goto L54
    L52:
        r3[2] = r3[2] + 1.3333334f;
        goto L54
    L43:
        if (isExtendedASCII(r7) == false) goto L45;
        r3[1] = r3[1] + 2.6666667f;
        goto L47
    L45:
        r3[1] = r3[1] + 1.3333334f;
        goto L47
    L36:
        if (isExtendedASCII(r7) == false) goto L38;
        float r23 = (float) Math.ceil(r3[0]);
        r3[0] = r23;
        r3[0] = r23 + 2.0f;
        goto L40
    L38:
        float r24 = (float) Math.ceil(r3[0]);
        r3[0] = r24;
        r3[0] = r24 + 1.0f;
        goto L40
    L12:
        byte[] r0 = new byte[r2];
        int[] r25 = new int[r2];
        int r26 = findMinimums(r3, r25, Integer.MAX_VALUE, r0);
        int r27 = getMinimumCount(r0);
        if (r25[0] != r26) goto L15;
        return 0;
    L15:
        if (r27 == 1) goto L17;
    L19:
        if (r27 == 1) goto L21;
    L23:
        if (r27 == 1) goto L25;
    L27:
        if (r27 == 1) goto L29;
    L31:
        return 1;
    L29:
        if (r0[3] <= 0) goto L31;
        return 3;
    L25:
        if (r0[2] <= 0) goto L27;
        return 2;
    L21:
        if (r0[4] <= 0) goto L23;
        return 4;
    L17:
        if (r0[5] <= 0) goto L19;
        return 5;
    L8:
        r3 = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
        r3[r21] = 0.0f;
        goto L9
    }

    private static int findMinimums(float[] r4, int[] r5, int r6, byte[] r7) {
        Arrays.fill(r7, (byte) 0);
        int r1 = 0;
    L4:
        if (r1 >= 6) goto L11;
        int r2 = (int) Math.ceil(r4[r1]);
        r5[r1] = r2;
        if (r6 <= r2) goto L8;
        Arrays.fill(r7, (byte) 0);
        r6 = r2;
    L8:
        if (r6 != r2) goto L10;
        r7[r1] = (byte) (r7[r1] + 1);
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return r6;
    }

    private static int getMinimumCount(byte[] r3) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= 6) goto L6;
        r1 = r1 + r3[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    private static boolean isNativeX12(char r1) {
        if (isX12TermSep(r1) == false) goto L5;
        return true;
    L5:
        if (r1 != ' ') goto L7;
        return true;
    L7:
        if (r1 < '0') goto L11;
        if (r1 > '9') goto L11;
        return true;
    L11:
        if (r1 >= 'A') goto L13;
        return false;
    L13:
        if (r1 <= 'Z') goto L22;
        return false;
    L22:
        return true;
    }

    public static int determineConsecutiveDigitCount(CharSequence r4, int r5) {
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

    static void illegalCharacter(char r5) {
        String r0 = Integer.toHexString(r5);
        throw new IllegalArgumentException("Illegal character: " + r5 + " (0x" + ("0000".substring(0, 4 - r0.length()) + r0) + ')');
    }
}
