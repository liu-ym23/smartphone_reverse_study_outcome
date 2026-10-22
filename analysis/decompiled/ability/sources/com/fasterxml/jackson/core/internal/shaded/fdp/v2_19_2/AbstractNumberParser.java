package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.util.Arrays;

/* loaded from: classes2.dex */
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
        for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
            CHAR_TO_HEX_MAP[c] = (byte) (c - '0');
        }
        for (char c2 = 'A'; c2 <= 'F'; c2 = (char) (c2 + 1)) {
            CHAR_TO_HEX_MAP[c2] = (byte) (c2 - '7');
        }
        for (char c5 = 'a'; c5 <= 'f'; c5 = (char) (c5 + 1)) {
            CHAR_TO_HEX_MAP[c5] = (byte) (c5 - 'W');
        }
        CHAR_TO_HEX_MAP[46] = DECIMAL_POINT_CLASS;
    }

    public static byte charAt(byte[] bArr, int i, int i6) {
        if (i < i6) {
            return bArr[i];
        }
        return (byte) 0;
    }

    public static int checkBounds(int i, int i6, int i10, int i11) {
        if (i10 <= i11) {
            return checkBounds(i, i6, i10);
        }
        throw new NumberFormatException(VALUE_EXCEEDS_LIMITS);
    }

    public static int lookupHex(byte b) {
        return CHAR_TO_HEX_MAP[b & OTHER_CLASS];
    }

    public static char charAt(char[] cArr, int i, int i6) {
        if (i < i6) {
            return cArr[i];
        }
        return (char) 0;
    }

    public static int lookupHex(char c) {
        if (c < 128) {
            return CHAR_TO_HEX_MAP[c];
        }
        return -1;
    }

    public static char charAt(CharSequence charSequence, int i, int i6) {
        if (i < i6) {
            return charSequence.charAt(i);
        }
        return (char) 0;
    }

    public static int checkBounds(int i, int i6, int i10) {
        if ((((i - i10) - i6) | i6 | i10) >= 0) {
            return i10 + i6;
        }
        throw new IllegalArgumentException(ILLEGAL_OFFSET_OR_ILLEGAL_LENGTH);
    }
}
