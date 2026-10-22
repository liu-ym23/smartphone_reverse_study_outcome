package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction GOOD_FAST_HASH_128 = null;
    static final HashFunction MURMUR3_128 = null;
    private static final long serialVersionUID = 0;
    private final int seed;

    public static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        private static final long C1 = -8663945395140668459L;
        private static final long C2 = 5545529020109919103L;
        private static final int CHUNK_SIZE = 16;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        private long f10356h1;

        /* JADX INFO: renamed from: h2, reason: collision with root package name */
        private long f10357h2;
        private int length;

        public Murmur3_128Hasher(int r10) {
            super(16);
            long r11 = r10;
            this.f10356h1 = r11;
            this.f10357h2 = r11;
            this.length = 0;
        }

        private void bmix64(long r10, long r11) {
            long r12 = this.f10356h1;
            long r13 = mixK1(r10) ^ r12;
            this.f10356h1 = r13;
            long r14 = Long.rotateLeft(r13, 27);
            long r15 = this.f10357h2;
            this.f10356h1 = ((r14 + r15) * 5) + 1390208809;
            long r16 = mixK2(r11) ^ r15;
            this.f10357h2 = r16;
            this.f10357h2 = ((Long.rotateLeft(r16, 31) + this.f10356h1) * 5) + 944331445;
        }

        private static long fmix64(long r10) {
            long r11 = (r10 ^ (r10 >>> 33)) * (-49064778989728563L);
            long r12 = (r11 ^ (r11 >>> 33)) * (-4265267296055464877L);
            return r12 ^ (r12 >>> 33);
        }

        private static long mixK1(long r10) {
            return Long.rotateLeft(r10 * C1, 31) * C2;
        }

        private static long mixK2(long r10) {
            return Long.rotateLeft(r10 * C2, 33) * C1;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long r10 = this.f10356h1;
            int r11 = this.length;
            long r12 = r10 ^ ((long) r11);
            long r13 = this.f10357h2 ^ ((long) r11);
            long r14 = r12 + r13;
            this.f10356h1 = r14;
            this.f10357h2 = r13 + r14;
            this.f10356h1 = fmix64(r14);
            long r15 = fmix64(this.f10357h2);
            long r16 = this.f10356h1 + r15;
            this.f10356h1 = r16;
            this.f10357h2 = r15 + r16;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f10356h1).putLong(this.f10357h2).array());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer r10) {
            bmix64(r10.getLong(), r10.getLong());
            this.length += 16;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer r14) {
            this.length += r14.remaining();
            long r10 = 0;
            switch(r14.remaining()) {
                case 1: goto L25;
                case 2: goto L23;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                case 15: goto L6;
                default: goto L5;
            };
        L6:
            r10 = ((long) UnsignedBytes.toInt(r14.get(14))) << 48;
        L7:
            r10 = r10 ^ (((long) UnsignedBytes.toInt(r14.get(13))) << 40);
        L8:
            r10 = r10 ^ (((long) UnsignedBytes.toInt(r14.get(12))) << 32);
        L9:
            r10 = r10 ^ (((long) UnsignedBytes.toInt(r14.get(11))) << 24);
        L10:
            r10 = r10 ^ (((long) UnsignedBytes.toInt(r14.get(10))) << 16);
        L11:
            r10 = r10 ^ (((long) UnsignedBytes.toInt(r14.get(9))) << 8);
        L12:
            r10 = r10 ^ ((long) UnsignedBytes.toInt(r14.get(8)));
        L13:
            long r11 = r14.getLong();
        L27:
            this.f10356h1 = mixK1(r11) ^ this.f10356h1;
            this.f10357h2 ^= mixK2(r10);
            return;
        L14:
            long r12 = ((long) UnsignedBytes.toInt(r14.get(6))) << 48;
        L16:
            long r13 = (((long) UnsignedBytes.toInt(r14.get(5))) << 40) ^ r12;
        L18:
            long r15 = r13 ^ (((long) UnsignedBytes.toInt(r14.get(4))) << 32);
        L20:
            long r16 = r15 ^ (((long) UnsignedBytes.toInt(r14.get(3))) << 24);
        L22:
            long r17 = (((long) UnsignedBytes.toInt(r14.get(2))) << 16) ^ r16;
        L24:
            long r18 = r17 ^ (((long) UnsignedBytes.toInt(r14.get(1))) << 8);
        L26:
            r11 = r18 ^ ((long) UnsignedBytes.toInt(r14.get(0)));
            goto L27
        L15:
            r12 = 0;
            goto L16
        L17:
            r13 = 0;
            goto L18
        L19:
            r15 = 0;
            goto L20
        L21:
            r16 = 0;
            goto L22
        L23:
            r17 = 0;
            goto L24
        L25:
            r18 = 0;
            goto L26
        L5:
            throw new AssertionError("Should never get here.");
        }
    }

    static {
        MURMUR3_128 = new Murmur3_128HashFunction(0);
        GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    }

    public Murmur3_128HashFunction(int r10) {
        this.seed = r10;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof Murmur3_128HashFunction) == true) goto L5;
        return false;
    L5:
        if (this.seed != ((Murmur3_128HashFunction) r10).seed) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        int r10 = Murmur3_128HashFunction.class.hashCode();
        return this.seed ^ r10;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }
}
