package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    private static final enum CType extends Enum<CType> {
        private static final /* synthetic */ CType[] $VALUES = null;
        public static final CType FNC_1 = null;
        public static final CType ONE_DIGIT = null;
        public static final CType TWO_DIGITS = null;
        public static final CType UNCODABLE = null;

        private CType(String r1, int r2) {
            super(r1, r2);
        }

        public static CType valueOf(String r1) {
            return (CType) Enum.valueOf(CType.class, r1);
        }

        public static CType[] values() {
            return (CType[]) $VALUES.clone();
        }

        static {
            CType r0 = new CType("UNCODABLE", 0);
            UNCODABLE = r0;
            CType r1 = new CType("ONE_DIGIT", 1);
            ONE_DIGIT = r1;
            CType r3 = new CType("TWO_DIGITS", 2);
            TWO_DIGITS = r3;
            CType r5 = new CType("FNC_1", 3);
            FNC_1 = r5;
            $VALUES = new CType[]{r0, r1, r3, r5};
        }
    }

    public Code128Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.CODE_128) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + r3);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r11) {
        int r10 = r11.length();
        if (r10 <= 0) goto L52;
        if (r10 > 80) goto L52;
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r1 >= r10) goto L17;
        char r3 = r11.charAt(r1);
        if (r3 >= ' ') goto L12;
    L13:
        switch(r3) {
            case 241: goto L16;
            case 242: goto L16;
            case 243: goto L16;
            case 244: goto L16;
            default: goto L15;
        };
    L15:
        throw new IllegalArgumentException("Bad character in input: " + r3);
    L16:
        r1 = r1 + 1;
        goto L8
    L12:
        if (r3 <= '~') goto L16;
    L17:
        ArrayList r2 = new ArrayList();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 1;
    L18:
        if (r4 >= r10) goto L40;
        int r8 = chooseCode(r11, r4, r6);
        int r9 = 100;
        if (r8 == r6) goto L22;
        if (r6 != 0) goto L35;
        if (r8 != 100) goto L33;
        int r12 = 104;
    L34:
        r9 = r12;
    L36:
        r6 = r8;
    L37:
        r2.add(Code128Reader.CODE_PATTERNS[r9]);
        r5 = r5 + (r9 * r7);
        if (r4 == 0) goto L18;
        r7 = r7 + 1;
        goto L18
    L33:
        r12 = 105;
        goto L34
    L35:
        r9 = r8;
        goto L36
    L22:
        switch(r11.charAt(r4)) {
            case 241: goto L27;
            case 242: goto L26;
            case 243: goto L25;
            case 244: goto L29;
            default: goto L23;
        };
    L23:
        if (r6 != 100) goto L28;
        r9 = r11.charAt(r4) - ' ';
        goto L29
    L28:
        r9 = Integer.parseInt(r11.substring(r4, r4 + 2));
        r4 = r4 + 1;
        goto L29
    L25:
        r9 = 96;
        goto L29
    L26:
        r9 = 97;
        goto L29
    L27:
        r9 = 102;
    L29:
        r4 = r4 + 1;
        goto L37
    L40:
        r2.add(Code128Reader.CODE_PATTERNS[r5 % 103]);
        r2.add(Code128Reader.CODE_PATTERNS[106(0x6a, float:1.49E-43)]);
        Iterator r13 = r2.iterator();
        int r14 = 0;
    L42:
        if (r13.hasNext() == false) goto L46;
        int[] r15 = (int[]) r13.next();
        int r16 = r15.length;
        int r17 = 0;
    L44:
        if (r17 >= r16) goto L42;
        r14 = r14 + r15[r17];
        r17 = r17 + 1;
        goto L44
    L46:
        boolean[] r18 = new boolean[r14];
        Iterator r19 = r2.iterator();
    L48:
        if (r19.hasNext() == false) goto L50;
        r0 = r0 + appendPattern(r18, r0, (int[]) r19.next(), true);
        goto L48
    L50:
        return r18;
    L52:
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + r10);
    }

    private static CType findCType(CharSequence r4, int r5) {
        int r0 = r4.length();
        if (r5 >= r0) goto L5;
        char r1 = r4.charAt(r5);
        if (r1 != 241) goto L11;
        return CType.FNC_1;
    L11:
        if (r1 < '0') goto L28;
        if (r1 > '9') goto L28;
        int r6 = r5 + 1;
        if (r6 >= r0) goto L18;
        char r7 = r4.charAt(r6);
        if (r7 < '0') goto L26;
        if (r7 > '9') goto L26;
        return CType.TWO_DIGITS;
    L26:
        return CType.ONE_DIGIT;
    L18:
        return CType.ONE_DIGIT;
    L28:
        return CType.UNCODABLE;
    L5:
        return CType.UNCODABLE;
    }

    private static int chooseCode(CharSequence r4, int r5, int r6) {
        CType r0 = findCType(r4, r5);
        if (r0 != CType.UNCODABLE) goto L5;
    L40:
        return 100;
    L5:
        if (r0 == CType.ONE_DIGIT) goto L40;
        if (r6 != 99) goto L10;
        return r6;
    L10:
        if (r6 != 100) goto L35;
        if (r0 != CType.FNC_1) goto L14;
        return r6;
    L14:
        CType r1 = findCType(r4, r5 + 2);
        if (r1 != CType.UNCODABLE) goto L17;
    L33:
        return r6;
    L17:
        if (r1 == CType.ONE_DIGIT) goto L33;
        if (r1 == CType.FNC_1) goto L22;
        int r7 = r5 + 4;
    L26:
        CType r8 = findCType(r4, r7);
        if (r8 != CType.TWO_DIGITS) goto L30;
        r7 = r7 + 2;
        goto L26
    L30:
        if (r8 != CType.ONE_DIGIT) goto L32;
        return 100;
    L32:
        return 99;
    L22:
        if (findCType(r4, r5 + 3) != CType.TWO_DIGITS) goto L24;
        return 99;
    L24:
        return 100;
    L35:
        if (r0 != CType.FNC_1) goto L38;
        r0 = findCType(r4, r5 + 1);
    L38:
        if (r0 != CType.TWO_DIGITS) goto L40;
        return 99;
    }
}
