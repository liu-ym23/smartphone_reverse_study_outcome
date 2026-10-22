package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class Murmur3_128HashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;

    private static final class Murmur3_128Hasher extends AbstractStreamingHashFunction.AbstractStreamingHasher {
        private static final long C1 = -8663945395140668459L;
        private static final long C2 = 5545529020109919103L;
        private static final int CHUNK_SIZE = 16;
        private long h1;
        private long h2;
        private int length;

        private static long fmix64(long r3) {
            long r4 = (r3 ^ (r3 >>> 33)) * (-49064778989728563L);
            long r5 = (r4 ^ (r4 >>> 33)) * (-4265267296055464877L);
            return r5 ^ (r5 >>> 33);
        }

        Murmur3_128Hasher(int r3) {
            super(16);
            long r0 = r3;
            this.h1 = r0;
            this.h2 = r0;
            this.length = 0;
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void process(ByteBuffer r5) {
            bmix64(r5.getLong(), r5.getLong());
            this.length += 16;
        }

        private void bmix64(long r7, long r9) {
            long r0 = this.h1;
            long r8 = mixK1(r7) ^ r0;
            this.h1 = r8;
            long r10 = Long.rotateLeft(r8, 27);
            long r1 = this.h2;
            this.h1 = ((r10 + r1) * 5) + 1390208809;
            long r11 = mixK2(r9) ^ r1;
            this.h2 = r11;
            this.h2 = ((Long.rotateLeft(r11, 31) + this.h1) * 5) + 944331445;
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer r12) {
            this.length += r12.remaining();
            long r7 = 0;
            switch(r12.remaining()) {
                case 1: goto L32;
                case 2: goto L30;
                case 3: goto L28;
                case 4: goto L26;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L19;
                case 9: goto L17;
                case 10: goto L15;
                case 11: goto L13;
                case 12: goto L11;
                case 13: goto L9;
                case 14: goto L7;
                case 15: goto L6;
                default: goto L5;
            };
        L6:
            long r0 = (((long) UnsignedBytes.toInt(r12.get(14))) << 48) ^ 0;
        L8:
            long r1 = r0 ^ (((long) UnsignedBytes.toInt(r12.get(13))) << 40);
        L10:
            long r2 = r1 ^ (((long) UnsignedBytes.toInt(r12.get(12))) << 32);
        L12:
            long r3 = r2 ^ (((long) UnsignedBytes.toInt(r12.get(11))) << 24);
        L14:
            long r4 = r3 ^ (((long) UnsignedBytes.toInt(r12.get(10))) << 16);
        L16:
            long r5 = r4 ^ (((long) UnsignedBytes.toInt(r12.get(9))) << 8);
        L18:
            long r6 = r5 ^ ((long) UnsignedBytes.toInt(r12.get(8)));
        L20:
            long r8 = r12.getLong() ^ 0;
            r7 = r6;
        L34:
            this.h1 ^= mixK1(r8);
            this.h2 ^= mixK2(r7);
            return;
        L7:
            r0 = 0;
            goto L8
        L9:
            r1 = 0;
            goto L10
        L11:
            r2 = 0;
            goto L12
        L13:
            r3 = 0;
            goto L14
        L15:
            r4 = 0;
            goto L16
        L17:
            r5 = 0;
            goto L18
        L19:
            r6 = 0;
            goto L20
        L21:
            long r9 = (((long) UnsignedBytes.toInt(r12.get(6))) << 48) ^ 0;
        L23:
            long r10 = r9 ^ (((long) UnsignedBytes.toInt(r12.get(5))) << 40);
        L25:
            long r11 = r10 ^ (((long) UnsignedBytes.toInt(r12.get(4))) << 32);
        L27:
            long r13 = r11 ^ (((long) UnsignedBytes.toInt(r12.get(3))) << 24);
        L29:
            long r14 = r13 ^ (((long) UnsignedBytes.toInt(r12.get(2))) << 16);
        L31:
            long r15 = r14 ^ (((long) UnsignedBytes.toInt(r12.get(1))) << 8);
        L33:
            r8 = ((long) UnsignedBytes.toInt(r12.get(0))) ^ r15;
            goto L34
        L22:
            r9 = 0;
            goto L23
        L24:
            r10 = 0;
            goto L25
        L26:
            r11 = 0;
            goto L27
        L28:
            r13 = 0;
            goto L29
        L30:
            r14 = 0;
            goto L31
        L32:
            r15 = 0;
            goto L33
        L5:
            throw new AssertionError("Should never get here.");
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        public HashCode makeHash() {
            long r0 = this.h1;
            int r2 = this.length;
            long r1 = r0 ^ ((long) r2);
            long r3 = this.h2 ^ ((long) r2);
            long r4 = r1 + r3;
            this.h1 = r4;
            this.h2 = r3 + r4;
            this.h1 = fmix64(r4);
            long r5 = fmix64(this.h2);
            long r6 = this.h1 + r5;
            this.h1 = r6;
            this.h2 = r5 + r6;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.h1).putLong(this.h2).array());
        }

        private static long mixK1(long r2) {
            return Long.rotateLeft(r2 * C1, 31) * C2;
        }

        private static long mixK2(long r2) {
            return Long.rotateLeft(r2 * C2, 33) * C1;
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    Murmur3_128HashFunction(int r1) {
        this.seed = r1;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof Murmur3_128HashFunction) == true) goto L5;
        return false;
    L5:
        if (this.seed != ((Murmur3_128HashFunction) r3).seed) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        int r0 = getClass().hashCode();
        return this.seed ^ r0;
    }
}
