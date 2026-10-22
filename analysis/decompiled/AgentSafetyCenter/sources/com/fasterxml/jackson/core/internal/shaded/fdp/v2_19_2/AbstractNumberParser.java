package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import g5.f;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
abstract class AbstractNumberParser {
    static final byte[] CHAR_TO_HEX_MAP;
    static final byte DECIMAL_POINT_CLASS = -4;
    public static final String ILLEGAL_OFFSET_OR_ILLEGAL_LENGTH = "offset < 0 or length > str.length";
    static final byte OTHER_CLASS = -1;
    public static final String SYNTAX_ERROR = "illegal syntax";
    public static final String VALUE_EXCEEDS_LIMITS = "value exceeds limits";

    static {
        byte[] bArr = new byte[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        CHAR_TO_HEX_MAP = bArr;
        Arrays.fill(bArr, OTHER_CLASS);
        for (char c9 = '0'; c9 <= '9'; c9 = (char) (c9 + 1)) {
            CHAR_TO_HEX_MAP[c9] = (byte) (c9 - '0');
        }
        for (char c10 = 'A'; c10 <= 'F'; c10 = (char) (c10 + 1)) {
            CHAR_TO_HEX_MAP[c10] = (byte) (c10 - '7');
        }
        for (char c11 = 'a'; c11 <= 'f'; c11 = (char) (c11 + 1)) {
            CHAR_TO_HEX_MAP[c11] = (byte) (c11 - 'W');
        }
        CHAR_TO_HEX_MAP[46] = DECIMAL_POINT_CLASS;
    }

    public static char charAt(CharSequence charSequence, int i, int i3) {
        if (i < i3) {
            return charSequence.charAt(i);
        }
        return (char) 0;
    }

    public static int checkBounds(int i, int i3, int i10) {
        if ((((i - i10) - i3) | i3 | i10) >= 0) {
            return i10 + i3;
        }
        f.s(ILLEGAL_OFFSET_OR_ILLEGAL_LENGTH);
        return 0;
    }

    public static int lookupHex(char c9) {
        if (c9 < 128) {
            return CHAR_TO_HEX_MAP[c9];
        }
        return -1;
    }

    public static char charAt(char[] cArr, int i, int i3) {
        if (i < i3) {
            return cArr[i];
        }
        return (char) 0;
    }

    public static byte charAt(byte[] bArr, int i, int i3) {
        if (i < i3) {
            return bArr[i];
        }
        return (byte) 0;
    }

    public static int lookupHex(byte b10) {
        return CHAR_TO_HEX_MAP[b10 & OTHER_CLASS];
    }

    public static int checkBounds(int i, int i3, int i10, int i11) {
        if (i10 <= i11) {
            return checkBounds(i, i3, i10);
        }
        throw new NumberFormatException(VALUE_EXCEEDS_LIMITS);
    }
}
