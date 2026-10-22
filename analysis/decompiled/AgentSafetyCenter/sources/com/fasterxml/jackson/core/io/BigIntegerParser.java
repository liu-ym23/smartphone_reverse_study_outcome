package com.fasterxml.jackson.core.io;

import androidx.activity.b;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.JavaBigIntegerParser;
import java.math.BigInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class BigIntegerParser {
    private BigIntegerParser() {
    }

    public static BigInteger parseWithFastParser(String str, int i) {
        try {
            return JavaBigIntegerParser.parseBigInteger(str, i);
        } catch (NumberFormatException e10) {
            if (str.length() > 1000) {
                str = str.substring(0, 1000).concat(" [truncated]");
            }
            throw new NumberFormatException("Value \"" + str + "\" can not be represented as `java.math.BigInteger` with radix " + i + ", reason: " + e10.getMessage());
        }
    }

    public static BigInteger parseWithFastParser(String str) {
        try {
            return JavaBigIntegerParser.parseBigInteger(str);
        } catch (NumberFormatException e10) {
            if (str.length() > 1000) {
                str = str.substring(0, 1000).concat(" [truncated]");
            }
            StringBuilder sbO = b.o("Value \"", str, "\" can not be represented as `java.math.BigInteger`, reason: ");
            sbO.append(e10.getMessage());
            throw new NumberFormatException(sbO.toString());
        }
    }
}
