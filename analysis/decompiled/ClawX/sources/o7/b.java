package o7;

import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final BigInteger f4333a = BigInteger.valueOf(1);

    /* renamed from: b, reason: collision with root package name */
    public static final BigInteger f4334b = BigInteger.valueOf(2);

    static {
        BigInteger.valueOf(3L);
    }

    public static void a(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 1 || bigInteger.bitLength() < 2) {
            throw new IllegalArgumentException("'candidate' must be non-null and >= 2");
        }
    }

    public static boolean b(BigInteger bigInteger) {
        a(bigInteger);
        int iIntValue = bigInteger.mod(BigInteger.valueOf(223092870)).intValue();
        if (iIntValue % 2 == 0 || iIntValue % 3 == 0 || iIntValue % 5 == 0 || iIntValue % 7 == 0 || iIntValue % 11 == 0 || iIntValue % 13 == 0 || iIntValue % 17 == 0 || iIntValue % 19 == 0 || iIntValue % 23 == 0) {
            return true;
        }
        int iIntValue2 = bigInteger.mod(BigInteger.valueOf(58642669)).intValue();
        if (iIntValue2 % 29 == 0 || iIntValue2 % 31 == 0 || iIntValue2 % 37 == 0 || iIntValue2 % 41 == 0 || iIntValue2 % 43 == 0) {
            return true;
        }
        int iIntValue3 = bigInteger.mod(BigInteger.valueOf(600662303)).intValue();
        if (iIntValue3 % 47 == 0 || iIntValue3 % 53 == 0 || iIntValue3 % 59 == 0 || iIntValue3 % 61 == 0 || iIntValue3 % 67 == 0) {
            return true;
        }
        int iIntValue4 = bigInteger.mod(BigInteger.valueOf(33984931)).intValue();
        if (iIntValue4 % 71 == 0 || iIntValue4 % 73 == 0 || iIntValue4 % 79 == 0 || iIntValue4 % 83 == 0) {
            return true;
        }
        int iIntValue5 = bigInteger.mod(BigInteger.valueOf(89809099)).intValue();
        if (iIntValue5 % 89 == 0 || iIntValue5 % 97 == 0 || iIntValue5 % 101 == 0 || iIntValue5 % 103 == 0) {
            return true;
        }
        int iIntValue6 = bigInteger.mod(BigInteger.valueOf(167375713)).intValue();
        if (iIntValue6 % 107 == 0 || iIntValue6 % 109 == 0 || iIntValue6 % 113 == 0 || iIntValue6 % 127 == 0) {
            return true;
        }
        int iIntValue7 = bigInteger.mod(BigInteger.valueOf(371700317)).intValue();
        if (iIntValue7 % 131 == 0 || iIntValue7 % 137 == 0 || iIntValue7 % 139 == 0 || iIntValue7 % 149 == 0) {
            return true;
        }
        int iIntValue8 = bigInteger.mod(BigInteger.valueOf(645328247)).intValue();
        if (iIntValue8 % 151 == 0 || iIntValue8 % 157 == 0 || iIntValue8 % 163 == 0 || iIntValue8 % 167 == 0) {
            return true;
        }
        int iIntValue9 = bigInteger.mod(BigInteger.valueOf(1070560157)).intValue();
        if (iIntValue9 % 173 == 0 || iIntValue9 % 179 == 0 || iIntValue9 % 181 == 0 || iIntValue9 % 191 == 0) {
            return true;
        }
        int iIntValue10 = bigInteger.mod(BigInteger.valueOf(1596463769)).intValue();
        return iIntValue10 % 193 == 0 || iIntValue10 % 197 == 0 || iIntValue10 % 199 == 0 || iIntValue10 % 211 == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x005d, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(java.math.BigInteger r12, java.security.SecureRandom r13, int r14) {
        /*
            a(r12)
            if (r13 == 0) goto L69
            r0 = 1
            if (r14 < r0) goto L61
            int r1 = r12.bitLength()
            r2 = 2
            if (r1 != r2) goto L10
            goto L60
        L10:
            r1 = 0
            boolean r2 = r12.testBit(r1)
            if (r2 != 0) goto L18
            goto L5c
        L18:
            java.math.BigInteger r2 = o7.b.f4333a
            java.math.BigInteger r3 = r12.subtract(r2)
            java.math.BigInteger r4 = o7.b.f4334b
            java.math.BigInteger r5 = r12.subtract(r4)
            int r6 = r3.getLowestSetBit()
            java.math.BigInteger r7 = r3.shiftRight(r6)
            r8 = r1
        L2d:
            if (r8 >= r14) goto L60
            java.math.BigInteger r9 = org.bouncycastle.util.BigIntegers.createRandomInRange(r4, r5, r13)
            java.math.BigInteger r9 = r9.modPow(r7, r12)
            boolean r10 = r9.equals(r2)
            if (r10 != 0) goto L5d
            boolean r10 = r9.equals(r3)
            if (r10 == 0) goto L44
            goto L5d
        L44:
            r10 = r0
        L45:
            if (r10 >= r6) goto L5c
            java.math.BigInteger r9 = r9.modPow(r4, r12)
            boolean r11 = r9.equals(r3)
            if (r11 == 0) goto L52
            goto L5d
        L52:
            boolean r11 = r9.equals(r2)
            if (r11 == 0) goto L59
            goto L5c
        L59:
            int r10 = r10 + 1
            goto L45
        L5c:
            return r1
        L5d:
            int r8 = r8 + 1
            goto L2d
        L60:
            return r0
        L61:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "'iterations' must be > 0"
            r12.<init>(r13)
            throw r12
        L69:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "'random' cannot be null"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.b.c(java.math.BigInteger, java.security.SecureRandom, int):boolean");
    }
}
