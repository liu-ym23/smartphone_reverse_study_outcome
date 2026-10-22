package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
abstract class AbstractBigDecimalParser extends AbstractNumberParser {
    public static final int MANY_DIGITS_THRESHOLD = 32;
    protected static final int MAX_DIGITS_WITHOUT_LEADING_ZEROS = 646456993;
    protected static final long MAX_EXPONENT_NUMBER = 2147483647L;
    static final int RECURSION_THRESHOLD = 400;

    public static void checkParsedBigDecimalBounds(boolean z10, int i, int i3, int i10, long j10) {
        if (z10 || i < i3) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (j10 <= -2147483648L || j10 > MAX_EXPONENT_NUMBER || i10 > MAX_DIGITS_WITHOUT_LEADING_ZEROS) {
            throw new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
        }
    }

    public static boolean hasManyDigits(int i) {
        return i >= 32;
    }
}
