package com.google.gson.internal;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class NumberLimits {
    private static final int MAX_NUMBER_STRING_LENGTH = 10000;

    private NumberLimits() {
    }

    private static void checkNumberStringLength(String r4) {
        if (r4.length() > 10000) goto L6;
        return;
    L6:
        throw new NumberFormatException("Number string too large: " + r4.substring(0, 30) + "...");
    }

    public static BigDecimal parseBigDecimal(String r5) throws NumberFormatException {
        checkNumberStringLength(r5);
        BigDecimal r0 = new BigDecimal(r5);
        if (Math.abs(r0.scale()) >= 10000) goto L6;
        return r0;
    L6:
        throw new NumberFormatException("Number has unsupported scale: " + r5);
    }

    public static BigInteger parseBigInteger(String r1) throws NumberFormatException {
        checkNumberStringLength(r1);
        return new BigInteger(r1);
    }
}
