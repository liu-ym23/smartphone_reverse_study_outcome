package y2;

import java.util.Random;

/* loaded from: classes.dex */
public final class f extends Random {

    /* renamed from: a, reason: collision with root package name */
    public long f16344a;

    /* renamed from: b, reason: collision with root package name */
    public long f16345b;

    @Override // java.util.Random
    public final int next(int i4) {
        return (int) (((1 << i4) - 1) & nextLong());
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        return (nextLong() & 1) != 0;
    }

    @Override // java.util.Random
    public final void nextBytes(byte[] bArr) {
        int length = bArr.length;
        while (length != 0) {
            int i4 = length < 8 ? length : 8;
            long jNextLong = nextLong();
            while (true) {
                int i5 = i4 - 1;
                if (i4 != 0) {
                    length--;
                    bArr[length] = (byte) jNextLong;
                    jNextLong >>= 8;
                    i4 = i5;
                }
            }
        }
    }

    @Override // java.util.Random
    public final double nextDouble() {
        return (nextLong() >>> 11) * 1.1102230246251565E-16d;
    }

    @Override // java.util.Random
    public final float nextFloat() {
        return (float) ((nextLong() >>> 40) * 5.960464477539063E-8d);
    }

    @Override // java.util.Random
    public final int nextInt(int i4) {
        long jNextLong;
        long j4;
        long j5 = i4;
        if (j5 <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        do {
            jNextLong = nextLong() >>> 1;
            j4 = jNextLong % j5;
        } while ((j5 - 1) + (jNextLong - j4) < 0);
        return (int) j4;
    }

    @Override // java.util.Random
    public final long nextLong() {
        long j4 = this.f16344a;
        long j5 = this.f16345b;
        this.f16344a = j5;
        long j6 = j4 ^ (j4 << 23);
        long j7 = ((j6 >>> 17) ^ (j6 ^ j5)) ^ (j5 >>> 26);
        this.f16345b = j7;
        return j7 + j5;
    }

    @Override // java.util.Random
    public final void setSeed(long j4) {
        if (j4 == 0) {
            j4 = Long.MIN_VALUE;
        }
        long j5 = (j4 ^ (j4 >>> 33)) * (-49064778989728563L);
        long j6 = (j5 ^ (j5 >>> 33)) * (-4265267296055464877L);
        long j7 = j6 ^ (j6 >>> 33);
        long j8 = ((j7 >>> 33) ^ j7) * (-49064778989728563L);
        long j9 = ((j8 >>> 33) ^ j8) * (-4265267296055464877L);
        this.f16344a = j7;
        this.f16345b = j9 ^ (j9 >>> 33);
    }

    @Override // java.util.Random
    public final int nextInt() {
        return (int) nextLong();
    }
}
