package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import androidx.collection.SieveCacheKt;

/* loaded from: classes2.dex */
abstract class AbstractBigDecimalParser extends AbstractNumberParser {
    public static final int MANY_DIGITS_THRESHOLD = 32;
    protected static final int MAX_DIGITS_WITHOUT_LEADING_ZEROS = 646456993;
    protected static final long MAX_EXPONENT_NUMBER = 2147483647L;
    static final int RECURSION_THRESHOLD = 400;

    public static void checkParsedBigDecimalBounds(boolean z10, int i, int i6, int i10, long j5) {
        if (z10 || i < i6) {
            throw new NumberFormatException(AbstractNumberParser.SYNTAX_ERROR);
        }
        if (j5 <= SieveCacheKt.NodeMetaAndPreviousMask || j5 > 2147483647L || i10 > MAX_DIGITS_WITHOUT_LEADING_ZEROS) {
            throw new NumberFormatException(AbstractNumberParser.VALUE_EXCEEDS_LIMITS);
        }
    }

    public static boolean hasManyDigits(int i) {
        return i >= 32;
    }
}
