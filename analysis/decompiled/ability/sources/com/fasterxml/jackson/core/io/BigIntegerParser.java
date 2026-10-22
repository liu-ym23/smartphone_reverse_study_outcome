package com.fasterxml.jackson.core.io;

import B7.a;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.JavaBigIntegerParser;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class BigIntegerParser {
    private BigIntegerParser() {
    }

    public static BigInteger parseWithFastParser(String str) {
        try {
            return JavaBigIntegerParser.parseBigInteger(str);
        } catch (NumberFormatException e) {
            if (str.length() > 1000) {
                str = str.substring(0, 1000) + " [truncated]";
            }
            StringBuilder sbV = a.v("Value \"", str, "\" can not be represented as `java.math.BigInteger`, reason: ");
            sbV.append(e.getMessage());
            throw new NumberFormatException(sbV.toString());
        }
    }

    public static BigInteger parseWithFastParser(String str, int i) {
        try {
            return JavaBigIntegerParser.parseBigInteger(str, i);
        } catch (NumberFormatException e) {
            if (str.length() > 1000) {
                str = str.substring(0, 1000) + " [truncated]";
            }
            StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "Value \"", str, "\" can not be represented as `java.math.BigInteger` with radix ", ", reason: ");
            sbT.append(e.getMessage());
            throw new NumberFormatException(sbT.toString());
        }
    }
}
