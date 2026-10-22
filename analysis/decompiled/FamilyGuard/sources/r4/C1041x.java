package r4;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: r4.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1041x extends C1040w {
    public static Long j(String str) {
        j4.k.g(str, "<this>");
        return k(str, 10);
    }

    public static final Long k(String str, int i5) {
        boolean z5;
        j4.k.g(str, "<this>");
        C1018a.a(i5);
        int length = str.length();
        Long l5 = null;
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char cCharAt = str.charAt(0);
        long j5 = -9223372036854775807L;
        if (j4.k.i(cCharAt, 48) < 0) {
            z5 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z5 = false;
                i6 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j5 = Long.MIN_VALUE;
                i6 = 1;
            }
        } else {
            z5 = false;
        }
        long j6 = 0;
        long j7 = -256204778801521550L;
        while (i6 < length) {
            int iB = C1018a.b(str.charAt(i6), i5);
            if (iB < 0) {
                return l5;
            }
            if (j6 < j7) {
                if (j7 != -256204778801521550L) {
                    return l5;
                }
                j7 = j5 / i5;
                if (j6 < j7) {
                    return l5;
                }
            }
            Long l6 = l5;
            int i7 = i6;
            long j8 = j6 * i5;
            long j9 = iB;
            if (j8 < j5 + j9) {
                return l6;
            }
            j6 = j8 - j9;
            i6 = i7 + 1;
            l5 = l6;
        }
        return z5 ? Long.valueOf(j6) : Long.valueOf(-j6);
    }
}
