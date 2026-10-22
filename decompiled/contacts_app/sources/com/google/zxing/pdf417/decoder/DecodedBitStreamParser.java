package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final Charset DEFAULT_ENCODING = null;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900 = null;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = null;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = null;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    /* JADX INFO: renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = null;

        static {
            int[] r0 = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = r0;
            r0[Mode.ALPHA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    private static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode ALPHA = null;
        public static final Mode ALPHA_SHIFT = null;
        public static final Mode LOWER = null;
        public static final Mode MIXED = null;
        public static final Mode PUNCT = null;
        public static final Mode PUNCT_SHIFT = null;

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            Mode r0 = new Mode("ALPHA", 0);
            ALPHA = r0;
            Mode r1 = new Mode("LOWER", 1);
            LOWER = r1;
            Mode r3 = new Mode("MIXED", 2);
            MIXED = r3;
            Mode r5 = new Mode("PUNCT", 3);
            PUNCT = r5;
            Mode r7 = new Mode("ALPHA_SHIFT", 4);
            ALPHA_SHIFT = r7;
            Mode r9 = new Mode("PUNCT_SHIFT", 5);
            PUNCT_SHIFT = r9;
            $VALUES = new Mode[]{r0, r1, r3, r5, r7, r9};
        }
    }

    static {
        PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
        MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
        DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
        BigInteger[] r0 = new BigInteger[16];
        EXP900 = r0;
        r0[0] = BigInteger.ONE;
        BigInteger r1 = BigInteger.valueOf(900);
        r0[1] = r1;
        int r2 = 2;
    L3:
        BigInteger[] r3 = EXP900;
        if (r2 >= r3.length) goto L6;
        r3[r2] = r3[r2 - 1].multiply(r1);
        r2 = r2 + 1;
        goto L3
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] r6, String r7) throws FormatException {
        StringBuilder r0 = new StringBuilder(r6.length << 1);
        Charset r1 = DEFAULT_ENCODING;
        int r2 = r6[1];
        PDF417ResultMetadata r3 = new PDF417ResultMetadata();
        int r4 = 2;
    L4:
        if (r4 >= r6[0]) goto L26;
        if (r2 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L19;
        switch(r2) {
            case 900: goto L18;
            case 901: goto L17;
            case 902: goto L16;
            default: goto L8;
        };
    L8:
        switch(r2) {
            case 922: goto L15;
            case 923: goto L15;
            case 924: goto L17;
            case 925: goto L13;
            case 926: goto L12;
            case 927: goto L11;
            case 928: goto L10;
            default: goto L9;
        };
    L9:
        int r5 = textCompaction(r6, r4 - 1, r0);
    L21:
        if (r5 >= r6.length) goto L24;
        r4 = r5 + 1;
        r2 = r6[r5];
        goto L4
    L24:
        throw FormatException.getFormatInstance();
    L10:
        r5 = decodeMacroBlock(r6, r4, r3);
        goto L21
    L11:
        r5 = r4 + 1;
        r1 = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(r6[r4]).name());
        goto L21
    L12:
        r5 = r4 + 2;
        goto L21
    L13:
        r5 = r4 + 1;
        goto L21
    L15:
        throw FormatException.getFormatInstance();
    L16:
        r5 = numericCompaction(r6, r4, r0);
    L17:
        r5 = byteCompaction(r2, r6, r1, r4, r0);
        goto L21
    L18:
        r5 = textCompaction(r6, r4, r0);
        goto L21
    L19:
        r5 = r4 + 1;
        r0.append((char) r6[r4]);
        goto L21
    L26:
        if (r0.length() == 0) goto L30;
        DecoderResult r8 = new DecoderResult(null, r0.toString(), null, r7);
        r8.setOther(r3);
        return r8;
    L30:
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] r8, int r9, PDF417ResultMetadata r10) throws FormatException {
        if ((r9 + 2) > r8[0]) goto L25;
        int[] r2 = new int[2];
        int r3 = 0;
    L5:
        if (r3 >= 2) goto L7;
        r2[r3] = r8[r9];
        r3 = r3 + 1;
        r9 = r9 + 1;
        goto L5
    L7:
        r10.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(r2, 2)));
        StringBuilder r0 = new StringBuilder();
        int r11 = textCompaction(r8, r9, r0);
        r10.setFileId(r0.toString());
        int r1 = r8[r11];
        if (r1 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) goto L21;
        int r12 = r11 + 1;
        int[] r4 = new int[r8[0] - r12];
        boolean r5 = false;
        int r6 = 0;
    L11:
        if (r12 >= r8[0]) goto L20;
        if (r5 == true) goto L20;
        int r7 = r12 + 1;
        int r13 = r8[r12];
        if (r13 < 900) goto L15;
        if (r13 != MACRO_PDF417_TERMINATOR) goto L19;
        r10.setLastSegment(true);
        r12 = r7 + 1;
        r5 = true;
        goto L11
    L19:
        throw FormatException.getFormatInstance();
    L15:
        r4[r6] = r13;
        r12 = r7;
        r6 = r6 + 1;
    L20:
        r10.setOptionalData(Arrays.copyOf(r4, r6));
        return r12;
    L21:
        if (r1 != MACRO_PDF417_TERMINATOR) goto L36;
        r10.setLastSegment(true);
        return r11 + 1;
    L36:
        return r11;
    L25:
        throw FormatException.getFormatInstance();
    }

    private static int textCompaction(int[] r9, int r10, StringBuilder r11) {
        int r1 = r9[0];
        int[] r2 = new int[(r1 - r10) << 1];
        int[] r3 = new int[(r1 - r10) << 1];
        boolean r4 = false;
        int r5 = 0;
    L4:
        if (r10 >= r9[0]) goto L20;
        if (r4 == true) goto L20;
        int r6 = r10 + 1;
        int r12 = r9[r10];
        if (r12 < 900) goto L8;
        if (r12 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L13;
        r2[r5] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
        r10 = r6 + 1;
        r3[r5] = r9[r6];
        r5 = r5 + 1;
        goto L4
    L13:
        if (r12 == 928) goto L18;
        switch(r12) {
            case 900: goto L17;
            case 901: goto L18;
            case 902: goto L18;
            default: goto L15;
        };
    L15:
        switch(r12) {
            case 922: goto L18;
            case 923: goto L18;
            case 924: goto L18;
            default: goto L9;
        };
    L9:
        r10 = r6;
        goto L4
    L17:
        r2[r5] = 900;
        r5 = r5 + 1;
    L18:
        r10 = r6 - 1;
        r4 = true;
        goto L4
    L8:
        r2[r5] = r12 / 30;
        r2[r5 + 1] = r12 % 30;
        r5 = r5 + 2;
    L20:
        decodeTextCompaction(r2, r3, r5, r11);
        return r10;
    }

    private static void decodeTextCompaction(int[] r16, int[] r17, int r18, StringBuilder r19) {
        Mode r1 = Mode.ALPHA;
        Mode r2 = Mode.ALPHA;
        int r5 = 0;
    L3:
        if (r5 >= r18) goto L82;
        int r6 = r16[r5];
        char r10 = ' ';
        switch(AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[r1.ordinal()]) {
            case 1: goto L63;
            case 2: goto L48;
            case 3: goto L32;
            case 4: goto L23;
            case 5: goto L15;
            case 6: goto L7;
            default: goto L78;
        };
    L7:
        if (r6 >= 29) goto L9;
        r10 = PUNCT_CHARS[r6];
    L17:
        r1 = r2;
    L79:
        if (r10 == 0) goto L81;
        r19.append(r10);
    L81:
        r5 = r5 + 1;
        goto L3
    L9:
        if (r6 != 29) goto L11;
        r1 = Mode.ALPHA;
        goto L78
    L11:
        if (r6 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L13;
        r19.append((char) r17[r5]);
    L22:
        r1 = r2;
        goto L78
    L13:
        if (r6 != 900) goto L22;
        r1 = Mode.ALPHA;
        goto L78
    L15:
        if (r6 >= 26) goto L18;
        r10 = (char) (r6 + 65);
        goto L17
    L18:
        if (r6 == 26) goto L17;
        if (r6 != 900) goto L22;
        r1 = Mode.ALPHA;
        goto L78
    L23:
        if (r6 >= 29) goto L25;
        r10 = PUNCT_CHARS[r6];
        goto L79
    L25:
        if (r6 != 29) goto L27;
        r1 = Mode.ALPHA;
        goto L78
    L27:
        if (r6 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L29;
        r19.append((char) r17[r5]);
        goto L78
    L29:
        if (r6 != 900) goto L78;
        r1 = Mode.ALPHA;
        goto L78
    L48:
        if (r6 >= 26) goto L50;
        int r7 = r6 + 97;
    L65:
        r10 = (char) r7;
        goto L79
    L50:
        if (r6 == 26) goto L79;
        if (r6 != 27) goto L55;
        Mode r3 = Mode.ALPHA_SHIFT;
    L54:
        r10 = 0;
        Mode r15 = r3;
        r2 = r1;
        r1 = r15;
        goto L79
    L55:
        if (r6 != 28) goto L57;
        r1 = Mode.MIXED;
        goto L78
    L57:
        if (r6 != 29) goto L59;
        r3 = Mode.PUNCT_SHIFT;
        goto L54
    L59:
        if (r6 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L61;
        r19.append((char) r17[r5]);
        goto L78
    L61:
        if (r6 != 900) goto L78;
        r1 = Mode.ALPHA;
        goto L78
    L63:
        if (r6 >= 26) goto L66;
        r7 = r6 + 65;
        goto L65
    L66:
        if (r6 == 26) goto L79;
        if (r6 != 27) goto L70;
        r1 = Mode.LOWER;
        goto L78
    L70:
        if (r6 != 28) goto L72;
        r1 = Mode.MIXED;
        goto L78
    L72:
        if (r6 != 29) goto L74;
        r3 = Mode.PUNCT_SHIFT;
        goto L54
    L74:
        if (r6 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L76;
        r19.append((char) r17[r5]);
        goto L78
    L76:
        if (r6 != 900) goto L78;
        r1 = Mode.ALPHA;
    L78:
        r10 = 0;
        goto L79
    L32:
        if (r6 >= 25) goto L34;
        r10 = MIXED_CHARS[r6];
        goto L79
    L34:
        if (r6 != 25) goto L36;
        r1 = Mode.PUNCT;
        goto L78
    L36:
        if (r6 == 26) goto L79;
        if (r6 != 27) goto L40;
        r1 = Mode.LOWER;
        goto L78
    L40:
        if (r6 != 28) goto L42;
        r1 = Mode.ALPHA;
        goto L78
    L42:
        if (r6 != 29) goto L44;
        r3 = Mode.PUNCT_SHIFT;
        goto L54
    L44:
        if (r6 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) goto L46;
        r19.append((char) r17[r5]);
        goto L78
    L46:
        if (r6 != 900) goto L78;
        r1 = Mode.ALPHA;
        goto L78
    }

    private static int byteCompaction(int r20, int[] r21, Charset r22, int r23, StringBuilder r24) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        int r2 = MACRO_PDF417_TERMINATOR;
        int r3 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        int r4 = 928;
        int r5 = 902;
        long r6 = 900;
        int r14 = 0;
        if (r20 != 901) goto L32;
        int[] r0 = new int[6];
        int r11 = r23 + 1;
        int r12 = r21[r23];
        long r18 = 0;
        boolean r16 = false;
        int r17 = 0;
    L5:
        int r13 = r21[0];
        if (r11 >= r13) goto L26;
        if (r16 == true) goto L26;
        int r15 = r17 + 1;
        r0[r17] = r12;
        r18 = (r18 * r6) + ((long) r12);
        int r7 = r11 + 1;
        r12 = r21[r11];
        if (r12 == 900) goto L25;
        if (r12 == 901) goto L25;
        if (r12 == 902) goto L25;
        if (r12 == BYTE_COMPACTION_MODE_LATCH_6) goto L25;
        if (r12 == 928) goto L25;
        if (r12 == r3) goto L25;
        if (r12 == r2) goto L25;
        if ((r15 % 5) != 0) goto L24;
        if (r15 <= 0) goto L24;
        int r8 = 0;
    L21:
        if (r8 >= 6) goto L23;
        r1.write((byte) (r18 >> ((5 - r8) * 8)));
        r8 = r8 + 1;
        r2 = MACRO_PDF417_TERMINATOR;
        r3 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        goto L21
    L23:
        r11 = r7;
        r17 = 0;
        r6 = 900;
        r18 = 0;
    L24:
        r11 = r7;
        r17 = r15;
        r2 = MACRO_PDF417_TERMINATOR;
        r3 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        r6 = 900;
    L25:
        r11 = r7 - 1;
        r17 = r15;
        r2 = MACRO_PDF417_TERMINATOR;
        r3 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        r6 = 900;
        r16 = true;
    L26:
        if (r11 != r13) goto L29;
        if (r12 >= 900) goto L29;
        int r9 = r17 + 1;
        r0[r17] = r12;
    L30:
        if (r14 >= r9) goto L62;
        r1.write((byte) r0[r14]);
        r14 = r14 + 1;
    L62:
        r24.append(new String(r1.toByteArray(), r22));
        return r11;
    L29:
        r9 = r17;
        goto L30
    L32:
        if (r20 != BYTE_COMPACTION_MODE_LATCH_6) goto L61;
        int r10 = r23;
        boolean r19 = false;
        int r25 = 0;
        long r26 = 0;
    L35:
        if (r10 >= r21[0]) goto L60;
        if (r19 == true) goto L60;
        int r110 = r10 + 1;
        int r27 = r21[r10];
        if (r27 >= 900) goto L40;
        r25 = r25 + 1;
        r26 = (r26 * 900) + ((long) r27);
        r10 = r110;
    L53:
        if ((r25 % 5) != 0) goto L59;
        if (r25 <= 0) goto L59;
        int r28 = 0;
    L56:
        if (r28 >= 6) goto L58;
        r1.write((byte) (r26 >> ((5 - r28) * 8)));
        r28 = r28 + 1;
        goto L56
    L58:
        r25 = 0;
        r26 = 0;
    L59:
        r4 = 928;
        r5 = 902;
        goto L35
    L40:
        if (r27 == 900) goto L51;
        if (r27 == 901) goto L51;
        if (r27 == r5) goto L51;
        if (r27 == BYTE_COMPACTION_MODE_LATCH_6) goto L51;
        if (r27 == r4) goto L51;
        if (r27 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) goto L51;
        if (r27 == MACRO_PDF417_TERMINATOR) goto L51;
        r10 = r110;
    L51:
        r10 = r110 - 1;
        r19 = true;
    L60:
        r11 = r10;
        goto L62
    L61:
        r11 = r23;
        goto L62
    }

    private static int numericCompaction(int[] r7, int r8, StringBuilder r9) throws FormatException {
        int[] r0 = new int[15];
        boolean r2 = false;
        int r3 = 0;
    L3:
        int r4 = r7[0];
        if (r8 >= r4) goto L32;
        if (r2 == true) goto L32;
        int r5 = r8 + 1;
        int r10 = r7[r8];
        if (r5 != r4) goto L10;
        r2 = true;
    L10:
        if (r10 >= 900) goto L12;
        r0[r3] = r10;
        r3 = r3 + 1;
    L25:
        if ((r3 % 15) != 0) goto L27;
    L29:
        if (r3 <= 0) goto L31;
        r9.append(decodeBase900toBase10(r0, r3));
        r3 = 0;
    L31:
        r8 = r5;
        goto L3
    L27:
        if (r10 == 902) goto L29;
        if (r2 == false) goto L31;
    L12:
        if (r10 != 900) goto L14;
    L23:
        r5 = r5 - 1;
        r2 = true;
        goto L25
    L14:
        if (r10 == 901) goto L23;
        if (r10 == BYTE_COMPACTION_MODE_LATCH_6) goto L23;
        if (r10 == 928) goto L23;
        if (r10 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) goto L23;
        if (r10 != MACRO_PDF417_TERMINATOR) goto L25;
    L32:
        return r8;
    }

    private static String decodeBase900toBase10(int[] r6, int r7) throws FormatException {
        BigInteger r0 = BigInteger.ZERO;
        int r2 = 0;
    L4:
        if (r2 >= r7) goto L6;
        r0 = r0.add(EXP900[(r7 - r2) - 1].multiply(BigInteger.valueOf(r6[r2])));
        r2 = r2 + 1;
        goto L4
    L6:
        String r8 = r0.toString();
        if (r8.charAt(0) != '1') goto L11;
        return r8.substring(1);
    L11:
        throw FormatException.getFormatInstance();
    }
}
