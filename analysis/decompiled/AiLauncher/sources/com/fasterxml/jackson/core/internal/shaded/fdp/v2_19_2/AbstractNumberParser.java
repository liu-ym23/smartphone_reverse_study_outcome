package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.util.Arrays;

/* loaded from: classes.dex */
abstract class AbstractNumberParser {
    static final byte[] CHAR_TO_HEX_MAP;
    static final byte DECIMAL_POINT_CLASS = -4;
    public static final String ILLEGAL_OFFSET_OR_ILLEGAL_LENGTH = "offset < 0 or length > str.length";
    static final byte OTHER_CLASS = -1;
    public static final String SYNTAX_ERROR = "illegal syntax";
    public static final String VALUE_EXCEEDS_LIMITS = "value exceeds limits";

    static {
        byte[] bArr = new byte[256];
        CHAR_TO_HEX_MAP = bArr;
        Arrays.fill(bArr, OTHER_CLASS);
        for (char c10 = '0'; c10 <= '9'; c10 = (char) (c10 + 1)) {
            CHAR_TO_HEX_MAP[c10] = (byte) (c10 - '0');
        }
        for (char c11 = 'A'; c11 <= 'F'; c11 = (char) (c11 + 1)) {
            CHAR_TO_HEX_MAP[c11] = (byte) (c11 - '7');
        }
        for (char c12 = 'a'; c12 <= 'f'; c12 = (char) (c12 + 1)) {
            CHAR_TO_HEX_MAP[c12] = (byte) (c12 - 'W');
        }
        CHAR_TO_HEX_MAP[46] = DECIMAL_POINT_CLASS;
    }

    public static byte charAt(byte[] bArr, int i10, int i11) {
        if (i10 < i11) {
            return bArr[i10];
        }
        return (byte) 0;
    }

    public static int checkBounds(int i10, int i11, int i12, int i13) {
        if (i12 <= i13) {
            return checkBounds(i10, i11, i12);
        }
        throw new NumberFormatException(VALUE_EXCEEDS_LIMITS);
    }

    public static int lookupHex(byte b10) {
        return CHAR_TO_HEX_MAP[b10 & OTHER_CLASS];
    }

    public static char charAt(char[] cArr, int i10, int i11) {
        if (i10 < i11) {
            return cArr[i10];
        }
        return (char) 0;
    }

    public static int lookupHex(char c10) {
        if (c10 < 128) {
            return CHAR_TO_HEX_MAP[c10];
        }
        return -1;
    }

    public static char charAt(CharSequence charSequence, int i10, int i11) {
        if (i10 < i11) {
            return charSequence.charAt(i10);
        }
        return (char) 0;
    }

    public static int checkBounds(int i10, int i11, int i12) {
        if ((((i10 - i12) - i11) | i11 | i12) >= 0) {
            return i12 + i11;
        }
        throw new IllegalArgumentException(ILLEGAL_OFFSET_OR_ILLEGAL_LENGTH);
    }
}
