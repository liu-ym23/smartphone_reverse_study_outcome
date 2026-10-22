package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class Murmur3_32HashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final long serialVersionUID = 0;
    private final int seed;

    private static final class Murmur3_32Hasher extends AbstractStreamingHashFunction.AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 4;
        private int h1;
        private int length;

        Murmur3_32Hasher(int r2) {
            super(4);
            this.h1 = r2;
            this.length = 0;
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void process(ByteBuffer r2) {
            this.h1 = Murmur3_32HashFunction.access$100(this.h1, Murmur3_32HashFunction.access$000(r2.getInt()));
            this.length += 4;
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer r4) {
            this.length += r4.remaining();
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r4.hasRemaining() == false) goto L6;
            r0 = r0 ^ (UnsignedBytes.toInt(r4.get()) << r1);
            r1 = r1 + 8;
            goto L4
        L6:
            this.h1 ^= Murmur3_32HashFunction.access$000(r0);
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        public HashCode makeHash() {
            return Murmur3_32HashFunction.access$200(this.h1, this.length);
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    static /* synthetic */ int access$000(int r0) {
        return mixK1(r0);
    }

    static /* synthetic */ int access$100(int r0, int r1) {
        return mixH1(r0, r1);
    }

    static /* synthetic */ HashCode access$200(int r0, int r1) {
        return fmix(r0, r1);
    }

    Murmur3_32HashFunction(int r1) {
        this.seed = r1;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof Murmur3_32HashFunction) == true) goto L5;
        return false;
    L5:
        if (this.seed != ((Murmur3_32HashFunction) r3).seed) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        int r0 = getClass().hashCode();
        return this.seed ^ r0;
    }

    @Override // com.google.common.hash.AbstractStreamingHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int r1) {
        int r2 = mixK1(r1);
        return fmix(mixH1(this.seed, r2), 4);
    }

    @Override // com.google.common.hash.AbstractStreamingHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long r3) {
        int r0 = (int) r3;
        int r4 = mixK1(r0);
        return fmix(mixH1(mixH1(this.seed, r4), mixK1((int) (r3 >>> 32))), 8);
    }

    @Override // com.google.common.hash.AbstractStreamingHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence r5) {
        int r4 = this.seed;
        int r1 = 1;
    L4:
        if (r1 >= r5.length()) goto L7;
        r4 = mixH1(r4, mixK1(r5.charAt(r1 - 1) | (r5.charAt(r1) << 16)));
        r1 = r1 + 2;
        goto L4
    L7:
        if ((r5.length() & 1) != 1) goto L10;
        r4 = r4 ^ mixK1(r5.charAt(r5.length() - 1));
    L10:
        return fmix(r4, r5.length() * 2);
    }

    private static int mixK1(int r1) {
        return Integer.rotateLeft(r1 * C1, 15) * C2;
    }

    private static int mixH1(int r0, int r1) {
        return (Integer.rotateLeft(r0 ^ r1, 13) * 5) - 430675100;
    }

    private static HashCode fmix(int r0, int r1) {
        int r2 = r0 ^ r1;
        int r3 = (r2 ^ (r2 >>> 16)) * (-2048144789);
        int r4 = (r3 ^ (r3 >>> 13)) * (-1028477387);
        return HashCode.fromInt(r4 ^ (r4 >>> 16));
    }
}
