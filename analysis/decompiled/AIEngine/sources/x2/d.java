package x2;

import com.stepos.core.error.AIEngineError;
import java.math.BigDecimal;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13725a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* renamed from: b, reason: collision with root package name */
    public static final String f13726b = String.valueOf(Long.MAX_VALUE);

    public static BigDecimal a(char[] cArr, int i10, int i11) {
        try {
            return new BigDecimal(cArr, i10, i11);
        } catch (NumberFormatException unused) {
            throw new NumberFormatException(a0.a.k("Value \"", new String(cArr, i10, i11), "\" can not be represented as BigDecimal"));
        }
    }

    public static double b(String str) {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0072, code lost:
    
        return java.lang.Integer.parseInt(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.String r10) {
        /*
            r0 = 0
            char r1 = r10.charAt(r0)
            int r2 = r10.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto Lf
            r0 = r4
        Lf:
            r3 = 2
            r5 = 10
            if (r0 == 0) goto L24
            if (r2 == r4) goto L1f
            if (r2 <= r5) goto L19
            goto L1f
        L19:
            char r1 = r10.charAt(r4)
            r4 = r3
            goto L2d
        L1f:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L24:
            r6 = 9
            if (r2 <= r6) goto L2d
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L2d:
            r6 = 57
            if (r1 > r6) goto L82
            r7 = 48
            if (r1 >= r7) goto L36
            goto L82
        L36:
            int r1 = r1 - r7
            if (r4 >= r2) goto L7d
            int r8 = r4 + 1
            char r9 = r10.charAt(r4)
            if (r9 > r6) goto L78
            if (r9 >= r7) goto L44
            goto L78
        L44:
            int r1 = r1 * 10
            int r9 = r9 - r7
            int r1 = r1 + r9
            if (r8 >= r2) goto L7d
            int r4 = r4 + r3
            char r3 = r10.charAt(r8)
            if (r3 > r6) goto L73
            if (r3 >= r7) goto L54
            goto L73
        L54:
            int r1 = r1 * 10
            int r3 = r3 - r7
            int r1 = r1 + r3
            if (r4 >= r2) goto L7d
        L5a:
            int r3 = r4 + 1
            char r4 = r10.charAt(r4)
            if (r4 > r6) goto L6e
            if (r4 >= r7) goto L65
            goto L6e
        L65:
            int r1 = r1 * r5
            int r4 = r4 + (-48)
            int r1 = r1 + r4
            if (r3 < r2) goto L6c
            goto L7d
        L6c:
            r4 = r3
            goto L5a
        L6e:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L73:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L78:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L7d:
            if (r0 == 0) goto L81
            int r10 = -r1
            return r10
        L81:
            return r1
        L82:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.d.c(java.lang.String):int");
    }

    public static int d(char[] cArr, int i10, int i11) {
        int i12 = cArr[(i10 + i11) - 1] - '0';
        switch (i11) {
            case 9:
                i12 += (cArr[i10] - '0') * 100000000;
                i10++;
            case 8:
                i12 += (cArr[i10] - '0') * 10000000;
                i10++;
            case 7:
                i12 += (cArr[i10] - '0') * 1000000;
                i10++;
            case 6:
                i12 += (cArr[i10] - '0') * AIEngineError.UNKNOWN;
                i10++;
            case 5:
                i12 += (cArr[i10] - '0') * 10000;
                i10++;
            case 4:
                i12 += (cArr[i10] - '0') * 1000;
                i10++;
            case 3:
                i12 += (cArr[i10] - '0') * 100;
                i10++;
            case 2:
                return ((cArr[i10] - '0') * 10) + i12;
            default:
                return i12;
        }
    }

    public static long e(char[] cArr, int i10, int i11) {
        int i12 = i11 - 9;
        return (d(cArr, i10, i12) * 1000000000) + d(cArr, i10 + i12, 9);
    }
}
