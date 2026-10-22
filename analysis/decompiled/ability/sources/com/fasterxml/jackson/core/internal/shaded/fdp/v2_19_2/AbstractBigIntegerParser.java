package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* loaded from: classes2.dex */
abstract class AbstractBigIntegerParser extends AbstractNumberParser {
    private static final int MAX_DECIMAL_DIGITS = 646456993;
    private static final int MAX_HEX_DIGITS = 536870912;
    static final int RECURSION_THRESHOLD = 400;

    public static void checkDecBigIntegerBounds(int i) {
        if (i > MAX_DECIMAL_DIGITS) {
            throw new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
        }
    }

    public static void checkHexBigIntegerBounds(int i) {
        if (i > MAX_HEX_DIGITS) {
            throw new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
        }
    }

    public static boolean hasManyDigits(int i) {
        return i > 18;
    }
}
