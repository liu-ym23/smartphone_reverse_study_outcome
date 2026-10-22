package gc;

import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class n extends m {
    public static final void b0(String str) {
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    public static Integer c0(String str) {
        boolean z;
        int i10;
        int i11;
        kotlin.jvm.internal.g.f(str, "<this>");
        b1.l(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char cCharAt = str.charAt(0);
        int i13 = -2147483647;
        if (kotlin.jvm.internal.g.g(cCharAt, 48) < 0) {
            i10 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i13 = Integer.MIN_VALUE;
                z = true;
            }
        } else {
            z = false;
            i10 = 0;
        }
        int i14 = -59652323;
        while (i10 < length) {
            int iDigit = Character.digit((int) str.charAt(i10), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i12 < i14 && (i14 != -59652323 || i12 < (i14 = i13 / 10))) || (i11 = i12 * 10) < i13 + iDigit) {
                return null;
            }
            i12 = i11 - iDigit;
            i10++;
        }
        return z ? Integer.valueOf(i12) : Integer.valueOf(-i12);
    }

    public static Long d0(String str) {
        boolean z;
        kotlin.jvm.internal.g.f(str, "<this>");
        b1.l(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char cCharAt = str.charAt(0);
        long j10 = -9223372036854775807L;
        if (kotlin.jvm.internal.g.g(cCharAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
                i10 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j10 = Long.MIN_VALUE;
                i10 = 1;
            }
        } else {
            z = false;
        }
        long j11 = 0;
        long j12 = -256204778801521550L;
        while (i10 < length) {
            int iDigit = Character.digit((int) str.charAt(i10), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j11 < j12) {
                if (j12 != -256204778801521550L) {
                    return null;
                }
                j12 = j10 / 10;
                if (j11 < j12) {
                    return null;
                }
            }
            long j13 = j11 * 10;
            long j14 = iDigit;
            if (j13 < j10 + j14) {
                return null;
            }
            j11 = j13 - j14;
            i10++;
        }
        return z ? Long.valueOf(j11) : Long.valueOf(-j11);
    }
}
