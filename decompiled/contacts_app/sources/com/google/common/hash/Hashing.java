package com.google.common.hash;

import com.bytedance.common.utility.StringEncryptUtils;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Iterator;
import java.util.zip.Checksum;
import javax.annotation.Nullable;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes2.dex */
public final class Hashing {
    private static final int GOOD_FAST_HASH_SEED = 0;

    /* JADX INFO: renamed from: com.google.common.hash.Hashing$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Adler32Holder {
        static final HashFunction ADLER_32 = null;

        private Adler32Holder() {
        }

        static {
            ADLER_32 = Hashing.access$100(ChecksumType.ADLER_32, "Hashing.adler32()");
        }
    }

    static abstract enum ChecksumType extends Enum<ChecksumType> implements Supplier<Checksum> {
        private static final /* synthetic */ ChecksumType[] $VALUES = null;
        public static final ChecksumType ADLER_32 = null;
        public static final ChecksumType CRC_32 = null;
        private final int bits;

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public abstract Checksum get2();

        /* synthetic */ ChecksumType(String r1, int r2, int r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        static /* synthetic */ int access$200(ChecksumType r0) {
            return r0.bits;
        }

        public static ChecksumType valueOf(String r1) {
            return (ChecksumType) Enum.valueOf(ChecksumType.class, r1);
        }

        public static ChecksumType[] values() {
            return (ChecksumType[]) $VALUES.clone();
        }

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ Checksum get() {
            return get2();
        }

        static {
            final String r1 = "CRC_32";
            final int r2 = 0;
            final int r3 = 32;
            ChecksumType r0 = new AnonymousClass1(r1, r2, r3);
            CRC_32 = r0;
            final String r4 = "ADLER_32";
            final int r5 = 1;
            ChecksumType r6 = new AnonymousClass2(r4, r5, r3);
            ADLER_32 = r6;
            $VALUES = new ChecksumType[]{r0, r6};
        }

        private ChecksumType(String r1, int r2, int r3) {
            super(r1, r2);
            this.bits = r3;
        }
    }

    static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        private final int bits;

        ConcatenatedHashFunction(HashFunction... r5) {
            super(r5);
            int r0 = r5.length;
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r2 = r2 + r5[r1].bits();
            r1 = r1 + 1;
            goto L3
        L5:
            this.bits = r2;
        }

        @Override // com.google.common.hash.AbstractCompositeHashFunction
        HashCode makeHash(Hasher[] r6) {
            byte[] r5 = new byte[this.bits / 8];
            int r0 = r6.length;
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r1 >= r0) goto L6;
            HashCode r3 = r6[r1].hash();
            r2 = r2 + r3.writeBytesTo(r5, r2, r3.bits() / 8);
            r1 = r1 + 1;
            goto L3
        L6:
            return HashCode.fromBytesNoCopy(r5);
        }

        @Override // com.google.common.hash.HashFunction
        public int bits() {
            return this.bits;
        }

        public boolean equals(@Nullable Object r5) {
            if ((r5 instanceof ConcatenatedHashFunction) == false) goto L18;
            ConcatenatedHashFunction r6 = (ConcatenatedHashFunction) r5;
            if (this.bits != r6.bits) goto L18;
            if (this.functions.length != r6.functions.length) goto L18;
            int r0 = 0;
        L11:
            if (r0 >= this.functions.length) goto L16;
            if (this.functions[r0].equals(r6.functions[r0]) == false) goto L14;
            r0 = r0 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            int r0 = this.bits;
            HashFunction[] r4 = this.functions;
            int r1 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            r0 = r0 ^ r4[r2].hashCode();
            r2 = r2 + 1;
            goto L3
        L5:
            return r0;
        }
    }

    private static class Crc32Holder {
        static final HashFunction CRC_32 = null;

        private Crc32Holder() {
        }

        static {
            CRC_32 = Hashing.access$100(ChecksumType.CRC_32, "Hashing.crc32()");
        }
    }

    private static final class Crc32cHolder {
        static final HashFunction CRC_32_C = null;

        private Crc32cHolder() {
        }

        static {
            CRC_32_C = new Crc32cHashFunction();
        }
    }

    private static final class LinearCongruentialGenerator {
        private long state;

        public LinearCongruentialGenerator(long r1) {
            this.state = r1;
        }

        public double nextDouble() {
            long r2 = (this.state * 2862933555777941757L) + 1;
            this.state = r2;
            return ((double) (((int) (r2 >>> 33)) + 1)) / 2.147483648E9d;
        }
    }

    private static class Md5Holder {
        static final HashFunction MD5 = null;

        private Md5Holder() {
        }

        static {
            MD5 = new MessageDigestHashFunction(StringEncryptUtils.MD5, "Hashing.md5()");
        }
    }

    private static class Murmur3_128Holder {
        static final HashFunction GOOD_FAST_HASH_FUNCTION_128 = null;
        static final HashFunction MURMUR3_128 = null;

        private Murmur3_128Holder() {
        }

        static {
            MURMUR3_128 = new Murmur3_128HashFunction(0);
            GOOD_FAST_HASH_FUNCTION_128 = Hashing.murmur3_128(Hashing.access$000());
        }
    }

    private static class Murmur3_32Holder {
        static final HashFunction GOOD_FAST_HASH_FUNCTION_32 = null;
        static final HashFunction MURMUR3_32 = null;

        private Murmur3_32Holder() {
        }

        static {
            MURMUR3_32 = new Murmur3_32HashFunction(0);
            GOOD_FAST_HASH_FUNCTION_32 = Hashing.murmur3_32(Hashing.access$000());
        }
    }

    private static class Sha1Holder {
        static final HashFunction SHA_1 = null;

        private Sha1Holder() {
        }

        static {
            SHA_1 = new MessageDigestHashFunction(StringEncryptUtils.SHA_1, "Hashing.sha1()");
        }
    }

    private static class Sha256Holder {
        static final HashFunction SHA_256 = null;

        private Sha256Holder() {
        }

        static {
            SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
        }
    }

    private static class Sha512Holder {
        static final HashFunction SHA_512 = null;

        private Sha512Holder() {
        }

        static {
            SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
        }
    }

    private static class SipHash24Holder {
        static final HashFunction SIP_HASH_24 = null;

        private SipHash24Holder() {
        }

        static {
            SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
        }
    }

    static /* synthetic */ int access$000() {
        return GOOD_FAST_HASH_SEED;
    }

    static /* synthetic */ HashFunction access$100(ChecksumType r0, String r1) {
        return checksumHashFunction(r0, r1);
    }

    public static HashFunction goodFastHash(int r4) {
        int r5 = checkPositiveAndMakeMultipleOf32(r4);
        if (r5 != 32) goto L7;
        return Murmur3_32Holder.GOOD_FAST_HASH_FUNCTION_32;
    L7:
        if (r5 <= 128) goto L9;
        int r6 = (r5 + WorkQueueKt.MASK) / 128;
        HashFunction[] r0 = new HashFunction[r6];
        r0[0] = Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
        int r1 = GOOD_FAST_HASH_SEED;
        int r2 = 1;
    L11:
        if (r2 >= r6) goto L14;
        r1 = r1 + 1500450271;
        r0[r2] = murmur3_128(r1);
        r2 = r2 + 1;
        goto L11
    L14:
        return new ConcatenatedHashFunction(r0);
    L9:
        return Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
    }

    static {
        GOOD_FAST_HASH_SEED = (int) System.currentTimeMillis();
    }

    public static HashFunction murmur3_32(int r1) {
        return new Murmur3_32HashFunction(r1);
    }

    public static HashFunction murmur3_32() {
        return Murmur3_32Holder.MURMUR3_32;
    }

    public static HashFunction murmur3_128(int r1) {
        return new Murmur3_128HashFunction(r1);
    }

    public static HashFunction murmur3_128() {
        return Murmur3_128Holder.MURMUR3_128;
    }

    public static HashFunction sipHash24() {
        return SipHash24Holder.SIP_HASH_24;
    }

    public static HashFunction sipHash24(long r8, long r10) {
        return new SipHashFunction(2, 4, r8, r10);
    }

    public static HashFunction md5() {
        return Md5Holder.MD5;
    }

    public static HashFunction sha1() {
        return Sha1Holder.SHA_1;
    }

    public static HashFunction sha256() {
        return Sha256Holder.SHA_256;
    }

    public static HashFunction sha512() {
        return Sha512Holder.SHA_512;
    }

    public static HashFunction crc32c() {
        return Crc32cHolder.CRC_32_C;
    }

    public static HashFunction crc32() {
        return Crc32Holder.CRC_32;
    }

    public static HashFunction adler32() {
        return Adler32Holder.ADLER_32;
    }

    private static HashFunction checksumHashFunction(ChecksumType r2, String r3) {
        return new ChecksumHashFunction(r2, ChecksumType.access$200(r2), r3);
    }

    public static int consistentHash(HashCode r2, int r3) {
        return consistentHash(r2.padToLong(), r3);
    }

    public static int consistentHash(long r4, int r6) {
        int r1 = 0;
        if (r6 <= 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "buckets must be positive: %s", new Object[]{Integer.valueOf(r6)});
        LinearCongruentialGenerator r0 = new LinearCongruentialGenerator(r4);
    L7:
        int r5 = (int) (((double) (r1 + 1)) / r0.nextDouble());
        if (r5 < 0) goto L11;
        if (r5 >= r6) goto L11;
        r1 = r5;
    L11:
        return r1;
    L5:
        r2 = false;
        goto L6
    }

    public static HashCode combineOrdered(Iterable<HashCode> r6) {
        Iterator<HashCode> r0 = r6.iterator();
        Preconditions.checkArgument(r0.hasNext(), "Must be at least 1 hash code to combine.");
        int r1 = r0.next().bits() / 8;
        byte[] r2 = new byte[r1];
        Iterator<HashCode> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        byte[] r3 = r7.next().asBytes();
        int r4 = 0;
        if (r3.length != r1) goto L8;
        boolean r5 = true;
    L9:
        Preconditions.checkArgument(r5, "All hashcodes must have the same bit length.");
    L11:
        if (r4 >= r3.length) goto L4;
        r2[r4] = (byte) ((r2[r4] * 37) ^ r3[r4]);
        r4 = r4 + 1;
        goto L11
    L8:
        r5 = false;
        goto L9
    L14:
        return HashCode.fromBytesNoCopy(r2);
    }

    public static HashCode combineUnordered(Iterable<HashCode> r6) {
        Iterator<HashCode> r0 = r6.iterator();
        Preconditions.checkArgument(r0.hasNext(), "Must be at least 1 hash code to combine.");
        int r1 = r0.next().bits() / 8;
        byte[] r2 = new byte[r1];
        Iterator<HashCode> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        byte[] r3 = r7.next().asBytes();
        int r4 = 0;
        if (r3.length != r1) goto L8;
        boolean r5 = true;
    L9:
        Preconditions.checkArgument(r5, "All hashcodes must have the same bit length.");
    L11:
        if (r4 >= r3.length) goto L4;
        r2[r4] = (byte) (r2[r4] + r3[r4]);
        r4 = r4 + 1;
        goto L11
    L8:
        r5 = false;
        goto L9
    L14:
        return HashCode.fromBytesNoCopy(r2);
    }

    static int checkPositiveAndMakeMultipleOf32(int r2) {
        if (r2 <= 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Number of bits must be positive");
        return (r2 + 31) & (-32);
    L4:
        r0 = false;
        goto L5
    }

    private Hashing() {
    }
}
