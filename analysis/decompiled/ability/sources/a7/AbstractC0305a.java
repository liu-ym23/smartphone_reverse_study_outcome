package a7;

import java.math.BigInteger;

/* renamed from: a7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0305a {

    /* renamed from: a, reason: collision with root package name */
    public static final long[] f1647a = new long[37];
    public static final int[] b = new int[37];
    public static final int[] c = new int[37];

    static {
        long j5;
        long j6;
        long j10;
        long j11;
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; i++) {
            long[] jArr = f1647a;
            long j12 = i;
            if (j12 >= 0) {
                long j13 = (Long.MAX_VALUE / j12) << 1;
                j5 = Long.MIN_VALUE;
                j6 = -1;
                j10 = j13 + (Long.compare(((-1) - (j13 * j12)) ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) >= 0 ? 1 : 0);
            } else if (Long.compare(Long.MAX_VALUE, j12 ^ Long.MIN_VALUE) < 0) {
                j5 = Long.MIN_VALUE;
                j6 = -1;
                j10 = 0;
            } else {
                j10 = 1;
                j5 = Long.MIN_VALUE;
                j6 = -1;
            }
            jArr[i] = j10;
            int[] iArr = b;
            if (j12 < 0) {
                j11 = Long.compare(Long.MAX_VALUE, j12 ^ j5) < 0 ? j6 : j6 - j12;
            } else {
                long j14 = j6 - (((Long.MAX_VALUE / j12) << 1) * j12);
                if (Long.compare(j14 ^ j5, j12 ^ j5) < 0) {
                    j12 = 0;
                }
                j11 = j14 - j12;
            }
            iArr[i] = (int) j11;
            c[i] = bigInteger.toString(i).length() - 1;
        }
    }
}
