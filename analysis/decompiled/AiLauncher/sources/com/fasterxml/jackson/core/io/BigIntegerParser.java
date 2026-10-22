package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.JavaBigIntegerParser;
import java.math.BigInteger;

/* loaded from: classes.dex */
public final class BigIntegerParser {
    private BigIntegerParser() {
    }

    public static BigInteger parseWithFastParser(String str) {
        try {
            return JavaBigIntegerParser.parseBigInteger(str);
        } catch (NumberFormatException e10) {
            if (str.length() > 1000) {
                str = str.substring(0, 1000) + " [truncated]";
            }
            throw new NumberFormatException("Value \"" + str + "\" can not be represented as `java.math.BigInteger`, reason: " + e10.getMessage());
        }
    }

    public static BigInteger parseWithFastParser(String str, int i10) {
        try {
            return JavaBigIntegerParser.parseBigInteger(str, i10);
        } catch (NumberFormatException e10) {
            if (str.length() > 1000) {
                str = str.substring(0, 1000) + " [truncated]";
            }
            throw new NumberFormatException("Value \"" + str + "\" can not be represented as `java.math.BigInteger` with radix " + i10 + ", reason: " + e10.getMessage());
        }
    }
}
