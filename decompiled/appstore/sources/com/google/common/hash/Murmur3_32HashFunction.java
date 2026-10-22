package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    static final HashFunction GOOD_FAST_HASH_32 = null;
    static final HashFunction MURMUR3_32 = null;
    private static final long serialVersionUID = 0;
    private final int seed;

    @CanIgnoreReturnValue
    public static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        private int f10358h1;
        private boolean isDone;
        private int length;
        private int shift;

        public Murmur3_32Hasher(int r10) {
            this.f10358h1 = r10;
            this.length = 0;
            this.isDone = false;
        }

        private void update(int r10, long r11) {
            long r12 = this.buffer;
            int r13 = this.shift;
            long r14 = ((r11 & 4294967295L) << r13) | r12;
            this.buffer = r14;
            int r15 = r13 + (r10 * 8);
            this.shift = r15;
            this.length += r10;
            if (r15 < 32) goto L6;
            this.f10358h1 = Murmur3_32HashFunction.access$100(this.f10358h1, Murmur3_32HashFunction.access$000((int) r14));
            this.buffer >>>= 32;
            this.shift -= 32;
            return;
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int r10 = this.f10358h1 ^ Murmur3_32HashFunction.access$000((int) this.buffer);
            this.f10358h1 = r10;
            return Murmur3_32HashFunction.access$600(r10, this.length);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putByte(byte r10) {
            return putByte(r10);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer r10) {
            return putBytes(r10);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putChar(char r10) {
            return putChar(r10);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putInt(int r10) {
            return putInt(r10);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putLong(long r10) {
            return putLong(r10);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence r10, Charset r11) {
            return putString(r10, r11);
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte r10) {
            update(1, r10 & UnsignedBytes.MAX_VALUE);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r10, int r11, int r12) {
            return putBytes(r10, r11, r12);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putChar(char r10) {
            update(2, r10);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putInt(int r10) {
            update(4, r10);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putLong(long r10) {
            update(4, (int) r10);
            update(4, r10 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence r10, Charset r11) {
            if (Charsets.UTF_8.equals(r11) == false) goto L34;
            int r12 = r10.length();
            int r13 = 0;
        L5:
            int r14 = r13 + 4;
            if (r14 > r12) goto L13;
            char r15 = r10.charAt(r13);
            char r16 = r10.charAt(r13 + 1);
            char r17 = r10.charAt(r13 + 2);
            char r18 = r10.charAt(r13 + 3);
            if (r15 >= 128) goto L13;
            if (r16 >= 128) goto L13;
            if (r17 >= 128) goto L13;
            if (r18 >= 128) goto L13;
            update(4, (((r16 << '\b') | r15) | (r17 << 16)) | (r18 << 24));
            r13 = r14;
        L13:
            if (r13 >= r12) goto L32;
            char r19 = r10.charAt(r13);
            if (r19 >= 128) goto L18;
            update(1, r19);
        L31:
            r13 = r13 + 1;
            goto L13
        L18:
            if (r19 >= 2048) goto L21;
            update(2, Murmur3_32HashFunction.access$300(r19));
            goto L31
        L21:
            if (r19 >= 55296) goto L23;
        L30:
            update(3, Murmur3_32HashFunction.access$400(r19));
            goto L31
        L23:
            if (r19 > 57343) goto L30;
            int r20 = Character.codePointAt(r10, r13);
            if (r20 == r19) goto L27;
            r13 = r13 + 1;
            update(4, Murmur3_32HashFunction.access$500(r20));
            goto L31
        L27:
            putBytes(r10.subSequence(r13, r12).toString().getBytes(r11));
            return this;
        L32:
            return this;
        L34:
            return super.putString(r10, r11);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] r10, int r11, int r12) {
            Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
            int r13 = 0;
        L3:
            int r14 = r13 + 4;
            if (r14 > r12) goto L6;
            update(4, Murmur3_32HashFunction.access$200(r10, r13 + r11));
            r13 = r14;
        L6:
            if (r13 >= r12) goto L8;
            putByte(r10[r11 + r13]);
            r13 = r13 + 1;
            goto L6
        L8:
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer r10) {
            ByteOrder r11 = r10.order();
            r10.order(ByteOrder.LITTLE_ENDIAN);
        L4:
            if (r10.remaining() < 4) goto L7;
            putInt(r10.getInt());
        L7:
            if (r10.hasRemaining() == false) goto L9;
            putByte(r10.get());
            goto L7
        L9:
            r10.order(r11);
            return this;
        }
    }

    static {
        MURMUR3_32 = new Murmur3_32HashFunction(0);
        GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    }

    public Murmur3_32HashFunction(int r10) {
        this.seed = r10;
    }

    public static /* synthetic */ int access$000(int r10) {
        return mixK1(r10);
    }

    public static /* synthetic */ int access$100(int r10, int r11) {
        return mixH1(r10, r11);
    }

    public static /* synthetic */ int access$200(byte[] r10, int r11) {
        return getIntLittleEndian(r10, r11);
    }

    public static /* synthetic */ long access$300(char r10) {
        return charToTwoUtf8Bytes(r10);
    }

    public static /* synthetic */ long access$400(char r10) {
        return charToThreeUtf8Bytes(r10);
    }

    public static /* synthetic */ long access$500(int r10) {
        return codePointToFourUtf8Bytes(r10);
    }

    public static /* synthetic */ HashCode access$600(int r10, int r11) {
        return fmix(r10, r11);
    }

    private static long charToThreeUtf8Bytes(char r10) {
        return (((r10 & '?') | 128) << 16) | ((((r10 >>> '\f') | 480) & PrivateKeyType.INVALID) | ((((r10 >>> 6) & 63) | 128) << 8));
    }

    private static long charToTwoUtf8Bytes(char r10) {
        return (((r10 & '?') | 128) << 8) | (((r10 >>> 6) | 960) & PrivateKeyType.INVALID);
    }

    private static long codePointToFourUtf8Bytes(int r10) {
        return ((((((long) (r10 >>> 18)) | 240) & 255) | ((((long) ((r10 >>> 12) & 63)) | 128) << 8)) | ((((long) ((r10 >>> 6) & 63)) | 128) << 16)) | ((((long) (r10 & 63)) | 128) << 24);
    }

    private static HashCode fmix(int r10, int r11) {
        int r12 = r10 ^ r11;
        int r13 = (r12 ^ (r12 >>> 16)) * (-2048144789);
        int r14 = (r13 ^ (r13 >>> 13)) * (-1028477387);
        return HashCode.fromInt(r14 ^ (r14 >>> 16));
    }

    private static int getIntLittleEndian(byte[] r10, int r11) {
        return Ints.fromBytes(r10[r11 + 3], r10[r11 + 2], r10[r11 + 1], r10[r11]);
    }

    private static int mixH1(int r10, int r11) {
        return (Integer.rotateLeft(r10 ^ r11, 13) * 5) - 430675100;
    }

    private static int mixK1(int r10) {
        return Integer.rotateLeft(r10 * C1, 15) * C2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof Murmur3_32HashFunction) == true) goto L5;
        return false;
    L5:
        if (this.seed != ((Murmur3_32HashFunction) r10).seed) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r10, int r11, int r12) {
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        int r13 = this.seed;
        int r14 = 0;
        int r15 = 0;
    L3:
        int r16 = r15 + 4;
        if (r16 > r12) goto L6;
        r13 = mixH1(r13, mixK1(getIntLittleEndian(r10, r15 + r11)));
        r15 = r16;
        goto L3
    L6:
        int r17 = r15;
        int r18 = 0;
    L7:
        if (r17 >= r12) goto L10;
        r14 = r14 ^ (UnsignedBytes.toInt(r10[r11 + r17]) << r18);
        r17 = r17 + 1;
        r18 = r18 + 8;
        goto L7
    L10:
        return fmix(r13 ^ mixK1(r14), r12);
    }

    public int hashCode() {
        int r10 = Murmur3_32HashFunction.class.hashCode();
        return this.seed ^ r10;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int r10) {
        int r11 = mixK1(r10);
        return fmix(mixH1(this.seed, r11), 4);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long r10) {
        int r11 = (int) r10;
        int r12 = mixK1(r11);
        return fmix(mixH1(mixH1(this.seed, r12), mixK1((int) (r10 >>> 32))), 8);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence r12, Charset r13) {
        if (Charsets.UTF_8.equals(r13) == false) goto L39;
        int r10 = r12.length();
        int r11 = this.seed;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L5:
        int r17 = r15 + 4;
        if (r17 > r10) goto L13;
        char r18 = r12.charAt(r15);
        char r19 = r12.charAt(r15 + 1);
        char r20 = r12.charAt(r15 + 2);
        char r110 = r12.charAt(r15 + 3);
        if (r18 >= 128) goto L13;
        if (r19 >= 128) goto L13;
        if (r20 >= 128) goto L13;
        if (r110 >= 128) goto L13;
        r11 = mixH1(r11, mixK1((((r19 << '\b') | r18) | (r20 << 16)) | (r110 << 24)));
        r16 = r16 + 4;
        r15 = r17;
    L13:
        long r21 = 0;
    L14:
        if (r15 >= r10) goto L37;
        char r22 = r12.charAt(r15);
        if (r22 >= 128) goto L19;
        r21 = r21 | (((long) r22) << r14);
        r14 = r14 + 8;
        r16 = r16 + 1;
    L33:
        if (r14 < 32) goto L35;
        r11 = mixH1(r11, mixK1((int) r21));
        r21 = r21 >>> 32;
        r14 = r14 - 32;
    L35:
        r15 = r15 + 1;
        goto L14
    L19:
        if (r22 >= 2048) goto L22;
        r21 = r21 | (charToTwoUtf8Bytes(r22) << r14);
        r14 = r14 + 16;
        r16 = r16 + 2;
        goto L33
    L22:
        if (r22 >= 55296) goto L24;
    L31:
        r21 = r21 | (charToThreeUtf8Bytes(r22) << r14);
        r14 = r14 + 24;
        r16 = r16 + 3;
        goto L33
    L24:
        if (r22 > 57343) goto L31;
        int r23 = Character.codePointAt(r12, r15);
        if (r23 == r22) goto L29;
        r15 = r15 + 1;
        r21 = r21 | (codePointToFourUtf8Bytes(r23) << r14);
        r16 = r16 + 4;
        goto L33
    L29:
        return hashBytes(r12.toString().getBytes(r13));
    L37:
        return fmix(mixK1((int) r21) ^ r11, r16);
    L39:
        return hashBytes(r12.toString().getBytes(r13));
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence r10) {
        int r11 = this.seed;
        int r12 = 1;
    L4:
        if (r12 >= r10.length()) goto L7;
        r11 = mixH1(r11, mixK1(r10.charAt(r12 - 1) | (r10.charAt(r12) << 16)));
        r12 = r12 + 2;
        goto L4
    L7:
        if ((r10.length() & 1) != 1) goto L10;
        r11 = r11 ^ mixK1(r10.charAt(r10.length() - 1));
    L10:
        return fmix(r11, r10.length() * 2);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }
}
