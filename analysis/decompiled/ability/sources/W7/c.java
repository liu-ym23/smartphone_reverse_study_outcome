package W7;

import N9.j;
import kotlin.random.Random$Default;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Random$Default f1492a = new Random$Default(0);
    public static final a b;

    static {
        Integer num = N7.a.f1012a;
        b = (num == null || num.intValue() >= 34) ? new X7.a() : new b();
    }

    public abstract int a(int i);

    public abstract int b();

    public int c(int i, int i6) {
        int iB;
        int i10;
        int iA;
        if (i6 <= i) {
            throw new IllegalArgumentException(j.l(Integer.valueOf(i), Integer.valueOf(i6)).toString());
        }
        int i11 = i6 - i;
        if (i11 > 0 || i11 == Integer.MIN_VALUE) {
            if (((-i11) & i11) == i11) {
                iA = a(31 - Integer.numberOfLeadingZeros(i11));
            } else {
                do {
                    iB = b() >>> 1;
                    i10 = iB % i11;
                } while ((i11 - 1) + (iB - i10) < 0);
                iA = i10;
            }
            return i + iA;
        }
        while (true) {
            int iB2 = b();
            if (i <= iB2 && iB2 < i6) {
                return iB2;
            }
        }
    }

    public abstract long d();

    public long e(long j5, long j6) {
        long jD;
        long j10;
        long jA;
        int iB;
        if (j6 <= j5) {
            throw new IllegalArgumentException(j.l(Long.valueOf(j5), Long.valueOf(j6)).toString());
        }
        long j11 = j6 - j5;
        if (j11 > 0) {
            if (((-j11) & j11) == j11) {
                int i = (int) j11;
                int i6 = (int) (j11 >>> 32);
                if (i != 0) {
                    iB = a(31 - Integer.numberOfLeadingZeros(i));
                } else if (i6 == 1) {
                    iB = b();
                } else {
                    jA = (a(31 - Integer.numberOfLeadingZeros(i6)) << 32) + (b() & 4294967295L);
                }
                jA = iB & 4294967295L;
            } else {
                do {
                    jD = d() >>> 1;
                    j10 = jD % j11;
                } while ((j11 - 1) + (jD - j10) < 0);
                jA = j10;
            }
            return j5 + jA;
        }
        while (true) {
            long jD2 = d();
            if (j5 <= jD2 && jD2 < j6) {
                return jD2;
            }
        }
    }
}
