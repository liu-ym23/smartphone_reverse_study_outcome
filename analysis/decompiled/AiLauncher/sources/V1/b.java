package V1;

import io.ktor.sse.ServerSentEventKt;

/* loaded from: classes.dex */
public class b {
    public static String a(long j10) {
        if (j10 < 0 || j10 > 281474976710655L) {
            return null;
        }
        return a.a(a.b(j10, 6, true), null, ServerSentEventKt.COLON);
    }

    public static long b(String str) {
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i10 = 0;
        long j10 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long jCharAt = str.charAt(length);
            long j11 = 48;
            if (jCharAt < 48 || jCharAt > 57) {
                if (jCharAt >= 97 && jCharAt <= 102) {
                    j11 = 87;
                } else if (jCharAt >= 65 && jCharAt <= 70) {
                    j11 = 55;
                } else if (jCharAt != 58 && jCharAt != 124) {
                    return 0L;
                }
                j10 += (jCharAt - j11) << i10;
                i10 += 4;
            } else {
                j10 += (jCharAt - j11) << i10;
                i10 += 4;
            }
        }
        if (i10 != 48) {
            return 0L;
        }
        return j10;
    }
}
