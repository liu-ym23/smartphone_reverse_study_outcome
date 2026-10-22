package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.digests.ISAPDigest;
import org.bouncycastle.util.Longs;

/* loaded from: classes.dex */
public class AsconPermutationFriend {

    public static class AsconPermutation {

        /* renamed from: x0, reason: collision with root package name */
        public long f4448x0;

        /* renamed from: x1, reason: collision with root package name */
        public long f4449x1;

        /* renamed from: x2, reason: collision with root package name */
        public long f4450x2;

        /* renamed from: x3, reason: collision with root package name */
        public long f4451x3;

        /* renamed from: x4, reason: collision with root package name */
        public long f4452x4;

        public void p(int i8) {
            if (i8 == 12) {
                round(240L);
                round(225L);
                round(210L);
                round(195L);
            }
            if (i8 >= 8) {
                round(180L);
                round(165L);
            }
            round(150L);
            round(135L);
            round(120L);
            round(105L);
            round(90L);
            round(75L);
        }

        public void round(long j4) {
            long j8 = this.f4450x2 ^ j4;
            this.f4450x2 = j8;
            long j9 = this.f4448x0;
            long j10 = this.f4452x4;
            long j11 = j9 ^ j10;
            long j12 = this.f4449x1;
            long j13 = j12 ^ j8;
            long j14 = j12 | j8;
            long j15 = this.f4451x3;
            long j16 = ((j15 ^ j14) ^ j9) ^ (j12 & j11);
            long j17 = (j11 ^ (j14 | j15)) ^ ((j12 & j8) & j15);
            long j18 = ((~j15) & j10) ^ j13;
            long j19 = j13 ^ (j9 | (j15 ^ j10));
            long j20 = (j15 ^ (j10 | j12)) ^ (j9 & j12);
            this.f4448x0 = Longs.rotateRight(j16, 28) ^ (Longs.rotateRight(j16, 19) ^ j16);
            this.f4449x1 = (Longs.rotateRight(j17, 39) ^ j17) ^ Longs.rotateRight(j17, 61);
            this.f4450x2 = ~((Longs.rotateRight(j18, 1) ^ j18) ^ Longs.rotateRight(j18, 6));
            this.f4451x3 = (Longs.rotateRight(j19, 10) ^ j19) ^ Longs.rotateRight(j19, 17);
            this.f4452x4 = Longs.rotateRight(j20, 41) ^ (Longs.rotateRight(j20, 7) ^ j20);
        }

        public void set(long j4, long j8, long j9, long j10, long j11) {
            this.f4448x0 = j4;
            this.f4449x1 = j8;
            this.f4450x2 = j9;
            this.f4451x3 = j10;
            this.f4452x4 = j11;
        }
    }

    public static AsconPermutation getAsconPermutation(ISAPDigest.Friend friend) {
        if (friend != null) {
            return new AsconPermutation();
        }
        throw new NullPointerException("This method is only for use by ISAPDigest or Ascon Digest");
    }
}
