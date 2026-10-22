package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Checksum;
import javax.crypto.spec.SecretKeySpec;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class Hashing {
    static final int GOOD_FAST_HASH_SEED = 0;

    /* JADX INFO: renamed from: com.google.common.hash.Hashing$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    @Immutable
    public static abstract enum ChecksumType extends Enum<ChecksumType> implements ImmutableSupplier<Checksum> {
        private static final /* synthetic */ ChecksumType[] $VALUES = null;
        public static final ChecksumType ADLER_32 = null;
        public static final ChecksumType CRC_32 = null;
        public final HashFunction hashFunction;

        static {
            final int r10 = 0;
            final String r11 = "Hashing.crc32()";
            final String r12 = "CRC_32";
            ChecksumType r13 = new AnonymousClass1(r12, r10, r11);
            CRC_32 = r13;
            final int r14 = 1;
            final String r15 = "Hashing.adler32()";
            final String r16 = "ADLER_32";
            ChecksumType r17 = new AnonymousClass2(r16, r14, r15);
            ADLER_32 = r17;
            $VALUES = new ChecksumType[]{r13, r17};
        }

        public /* synthetic */ ChecksumType(String r10, int r11, String r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        public static ChecksumType valueOf(String r10) {
            return (ChecksumType) Enum.valueOf(ChecksumType.class, r10);
        }

        public static ChecksumType[] values() {
            return (ChecksumType[]) $VALUES.clone();
        }

        private ChecksumType(String r10, int r11, String r12) {
            super(r10, r11);
            this.hashFunction = new ChecksumHashFunction(this, 32, r12);
        }
    }

    public static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        public /* synthetic */ ConcatenatedHashFunction(HashFunction[] r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.hash.HashFunction
        public int bits() {
            HashFunction[] r10 = this.functions;
            int r11 = r10.length;
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r12 >= r11) goto L5;
            r13 = r13 + r10[r12].bits();
            r12 = r12 + 1;
            goto L3
        L5:
            return r13;
        }

        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof ConcatenatedHashFunction) == true) goto L5;
            return false;
        L5:
            return Arrays.equals(this.functions, ((ConcatenatedHashFunction) r10).functions);
        }

        public int hashCode() {
            return Arrays.hashCode(this.functions);
        }

        @Override // com.google.common.hash.AbstractCompositeHashFunction
        public HashCode makeHash(Hasher[] r10) {
            byte[] r11 = new byte[bits() / 8];
            int r12 = r10.length;
            int r13 = 0;
            int r14 = 0;
        L3:
            if (r13 >= r12) goto L6;
            HashCode r15 = r10[r13].hash();
            r14 = r14 + r15.writeBytesTo(r11, r14, r15.bits() / 8);
            r13 = r13 + 1;
            goto L3
        L6:
            return HashCode.fromBytesNoCopy(r11);
        }

        private ConcatenatedHashFunction(HashFunction... r10) {
            super(r10);
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            HashFunction r13 = r10[r12];
            if ((r13.bits() % 8) != 0) goto L7;
            boolean r14 = true;
        L8:
            Preconditions.checkArgument(r14, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", r13.bits(), r13);
            r12 = r12 + 1;
            goto L3
        L7:
            r14 = false;
            goto L8
        }
    }

    public static final class LinearCongruentialGenerator {
        private long state;

        public LinearCongruentialGenerator(long r10) {
            this.state = r10;
        }

        public double nextDouble() {
            long r10 = (this.state * 2862933555777941757L) + 1;
            this.state = r10;
            return ((double) (((int) (r10 >>> 33)) + 1)) / 2.147483648E9d;
        }
    }

    public static class Md5Holder {
        static final HashFunction MD5 = null;

        static {
            MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");
        }

        private Md5Holder() {
        }
    }

    public static class Sha1Holder {
        static final HashFunction SHA_1 = null;

        static {
            SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
        }

        private Sha1Holder() {
        }
    }

    public static class Sha256Holder {
        static final HashFunction SHA_256 = null;

        static {
            SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
        }

        private Sha256Holder() {
        }
    }

    public static class Sha384Holder {
        static final HashFunction SHA_384 = null;

        static {
            SHA_384 = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
        }

        private Sha384Holder() {
        }
    }

    public static class Sha512Holder {
        static final HashFunction SHA_512 = null;

        static {
            SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
        }

        private Sha512Holder() {
        }
    }

    static {
        GOOD_FAST_HASH_SEED = (int) System.currentTimeMillis();
    }

    private Hashing() {
    }

    public static HashFunction adler32() {
        return ChecksumType.ADLER_32.hashFunction;
    }

    public static int checkPositiveAndMakeMultipleOf32(int r10) {
        if (r10 <= 0) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11, "Number of bits must be positive");
        return (r10 + 31) & (-32);
    L4:
        r11 = false;
        goto L5
    }

    public static HashCode combineOrdered(Iterable<HashCode> r10) {
        Iterator<HashCode> r11 = r10.iterator();
        Preconditions.checkArgument(r11.hasNext(), "Must be at least 1 hash code to combine.");
        int r12 = r11.next().bits() / 8;
        byte[] r13 = new byte[r12];
        Iterator<HashCode> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L14;
        byte[] r15 = r14.next().asBytes();
        int r16 = 0;
        if (r15.length != r12) goto L8;
        boolean r17 = true;
    L9:
        Preconditions.checkArgument(r17, "All hashcodes must have the same bit length.");
    L11:
        if (r16 >= r15.length) goto L4;
        r13[r16] = (byte) ((r13[r16] * 37) ^ r15[r16]);
        r16 = r16 + 1;
        goto L11
    L8:
        r17 = false;
        goto L9
    L14:
        return HashCode.fromBytesNoCopy(r13);
    }

    public static HashCode combineUnordered(Iterable<HashCode> r10) {
        Iterator<HashCode> r11 = r10.iterator();
        Preconditions.checkArgument(r11.hasNext(), "Must be at least 1 hash code to combine.");
        int r12 = r11.next().bits() / 8;
        byte[] r13 = new byte[r12];
        Iterator<HashCode> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L14;
        byte[] r15 = r14.next().asBytes();
        int r16 = 0;
        if (r15.length != r12) goto L8;
        boolean r17 = true;
    L9:
        Preconditions.checkArgument(r17, "All hashcodes must have the same bit length.");
    L11:
        if (r16 >= r15.length) goto L4;
        r13[r16] = (byte) (r13[r16] + r15[r16]);
        r16 = r16 + 1;
        goto L11
    L8:
        r17 = false;
        goto L9
    L14:
        return HashCode.fromBytesNoCopy(r13);
    }

    public static HashFunction concatenating(HashFunction r10, HashFunction r11, HashFunction... r12) {
        ArrayList r13 = new ArrayList();
        r13.add(r10);
        r13.add(r11);
        r13.addAll(Arrays.asList(r12));
        return new ConcatenatedHashFunction((HashFunction[]) r13.toArray(new HashFunction[0]), null);
    }

    public static int consistentHash(HashCode r10, int r11) {
        return consistentHash(r10.padToLong(), r11);
    }

    public static HashFunction crc32() {
        return ChecksumType.CRC_32.hashFunction;
    }

    public static HashFunction crc32c() {
        return Crc32cHashFunction.CRC_32_C;
    }

    public static HashFunction farmHashFingerprint64() {
        return FarmHashFingerprint64.FARMHASH_FINGERPRINT_64;
    }

    public static HashFunction goodFastHash(int r10) {
        int r11 = checkPositiveAndMakeMultipleOf32(r10);
        if (r11 != 32) goto L7;
        return Murmur3_32HashFunction.GOOD_FAST_HASH_32;
    L7:
        if (r11 <= 128) goto L9;
        int r12 = (r11 + 127) / 128;
        HashFunction[] r13 = new HashFunction[r12];
        r13[0] = Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        int r14 = GOOD_FAST_HASH_SEED;
        int r15 = 1;
    L11:
        if (r15 >= r12) goto L14;
        r14 = r14 + 1500450271;
        r13[r15] = murmur3_128(r14);
        r15 = r15 + 1;
        goto L11
    L14:
        return new ConcatenatedHashFunction(r13, null);
    L9:
        return Murmur3_128HashFunction.GOOD_FAST_HASH_128;
    }

    public static HashFunction hmacMd5(Key r10) {
        return new MacHashFunction("HmacMD5", r10, hmacToString("hmacMd5", r10));
    }

    public static HashFunction hmacSha1(Key r10) {
        return new MacHashFunction("HmacSHA1", r10, hmacToString("hmacSha1", r10));
    }

    public static HashFunction hmacSha256(Key r10) {
        return new MacHashFunction("HmacSHA256", r10, hmacToString("hmacSha256", r10));
    }

    public static HashFunction hmacSha512(Key r10) {
        return new MacHashFunction("HmacSHA512", r10, hmacToString("hmacSha512", r10));
    }

    private static String hmacToString(String r10, Key r11) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", new Object[]{r10, r11.getAlgorithm(), r11.getFormat()});
    }

    @Deprecated
    public static HashFunction md5() {
        return Md5Holder.MD5;
    }

    public static HashFunction murmur3_128(int r10) {
        return new Murmur3_128HashFunction(r10);
    }

    public static HashFunction murmur3_32(int r10) {
        return new Murmur3_32HashFunction(r10);
    }

    @Deprecated
    public static HashFunction sha1() {
        return Sha1Holder.SHA_1;
    }

    public static HashFunction sha256() {
        return Sha256Holder.SHA_256;
    }

    public static HashFunction sha384() {
        return Sha384Holder.SHA_384;
    }

    public static HashFunction sha512() {
        return Sha512Holder.SHA_512;
    }

    public static HashFunction sipHash24() {
        return SipHashFunction.SIP_HASH_24;
    }

    public static int consistentHash(long r10, int r11) {
        int r12 = 0;
        if (r11 <= 0) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "buckets must be positive: %s", r11);
        LinearCongruentialGenerator r14 = new LinearCongruentialGenerator(r10);
    L7:
        int r15 = (int) (((double) (r12 + 1)) / r14.nextDouble());
        if (r15 < 0) goto L11;
        if (r15 >= r11) goto L11;
        r12 = r15;
    L11:
        return r12;
    L5:
        r13 = false;
        goto L6
    }

    public static HashFunction hmacMd5(byte[] r10) {
        return hmacMd5(new SecretKeySpec((byte[]) Preconditions.checkNotNull(r10), "HmacMD5"));
    }

    public static HashFunction hmacSha1(byte[] r10) {
        return hmacSha1(new SecretKeySpec((byte[]) Preconditions.checkNotNull(r10), "HmacSHA1"));
    }

    public static HashFunction hmacSha256(byte[] r10) {
        return hmacSha256(new SecretKeySpec((byte[]) Preconditions.checkNotNull(r10), "HmacSHA256"));
    }

    public static HashFunction hmacSha512(byte[] r10) {
        return hmacSha512(new SecretKeySpec((byte[]) Preconditions.checkNotNull(r10), "HmacSHA512"));
    }

    public static HashFunction murmur3_128() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    public static HashFunction murmur3_32() {
        return Murmur3_32HashFunction.MURMUR3_32;
    }

    public static HashFunction sipHash24(long r10, long r11) {
        return new SipHashFunction(2, 4, r10, r11);
    }

    public static HashFunction concatenating(Iterable<HashFunction> r10) {
        Preconditions.checkNotNull(r10);
        ArrayList r11 = new ArrayList();
        Iterator<HashFunction> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r11.add(r12.next());
        goto L4
    L7:
        if (r11.size() <= 0) goto L9;
        boolean r13 = true;
    L10:
        Preconditions.checkArgument(r13, "number of hash functions (%s) must be > 0", r11.size());
        return new ConcatenatedHashFunction((HashFunction[]) r11.toArray(new HashFunction[0]), null);
    L9:
        r13 = false;
        goto L10
    }
}
