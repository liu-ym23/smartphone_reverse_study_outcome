package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public abstract class HashCode {
    private static final char[] hexDigits = null;

    public static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        public BytesHashCode(byte[] r10) {
            this.bytes = (byte[]) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            byte[] r10 = this.bytes;
            if (r10.length < 4) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkState(r11, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", r10.length);
            byte[] r12 = this.bytes;
            return ((r12[3] & UnsignedBytes.MAX_VALUE) << 24) | (((r12[0] & UnsignedBytes.MAX_VALUE) | ((r12[1] & UnsignedBytes.MAX_VALUE) << 8)) | ((r12[2] & UnsignedBytes.MAX_VALUE) << 16));
        L5:
            r11 = false;
            goto L6
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            byte[] r10 = this.bytes;
            if (r10.length < 8) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkState(r11, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", r10.length);
            return padToLong();
        L5:
            r11 = false;
            goto L6
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode r10) {
            if (this.bytes.length == r10.getBytesInternal().length) goto L5;
            return false;
        L5:
            boolean r11 = true;
            int r12 = 0;
        L6:
            byte[] r13 = this.bytes;
            if (r12 >= r13.length) goto L13;
            if (r13[r12] != r10.getBytesInternal()[r12]) goto L11;
            boolean r14 = true;
        L12:
            r11 = r11 & r14;
            r12 = r12 + 1;
            goto L6
        L11:
            r14 = false;
            goto L12
        L13:
            return r11;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] getBytesInternal() {
            return this.bytes;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            long r10 = this.bytes[0] & UnsignedBytes.MAX_VALUE;
            int r11 = 1;
        L4:
            if (r11 >= Math.min(this.bytes.length, 8)) goto L6;
            r10 = r10 | ((((long) this.bytes[r11]) & 255) << (r11 * 8));
            r11 = r11 + 1;
            goto L4
        L6:
            return r10;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] r10, int r11, int r12) {
            System.arraycopy(this.bytes, 0, r10, r11, r12);
        }
    }

    public static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final int hash;

        public IntHashCode(int r10) {
            this.hash = r10;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            int r10 = this.hash;
            return new byte[]{(byte) r10, (byte) (r10 >> 8), (byte) (r10 >> 16), (byte) (r10 >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode r10) {
            if (this.hash != r10.asInt()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] r10, int r11, int r12) {
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r10[r11 + r13] = (byte) (this.hash >> (r13 * 8));
            r13 = r13 + 1;
            goto L3
        }
    }

    public static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final long hash;

        public LongHashCode(long r10) {
            this.hash = r10;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            long r10 = this.hash;
            return new byte[]{(byte) r10, (byte) (r10 >> 8), (byte) (r10 >> 16), (byte) (r10 >> 24), (byte) (r10 >> 32), (byte) (r10 >> 40), (byte) (r10 >> 48), (byte) (r10 >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode r10) {
            if (this.hash != r10.asLong()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] r10, int r11, int r12) {
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r10[r11 + r13] = (byte) (this.hash >> (r13 * 8));
            r13 = r13 + 1;
            goto L3
        }
    }

    static {
        hexDigits = "0123456789abcdef".toCharArray();
    }

    public HashCode() {
    }

    private static int decode(char r10) {
        if (r10 < '0') goto L9;
        if (r10 > '9') goto L9;
        return r10 - '0';
    L9:
        if (r10 < 'a') goto L15;
        if (r10 > 'f') goto L15;
        return r10 - 'W';
    L15:
        throw new IllegalArgumentException("Illegal hexadecimal character: " + r10);
    }

    public static HashCode fromBytes(byte[] r10) {
        boolean r11 = true;
        if (r10.length >= 1) goto L6;
        r11 = false;
    L6:
        Preconditions.checkArgument(r11, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) r10.clone());
    }

    public static HashCode fromBytesNoCopy(byte[] r10) {
        return new BytesHashCode(r10);
    }

    public static HashCode fromInt(int r10) {
        return new IntHashCode(r10);
    }

    public static HashCode fromLong(long r10) {
        return new LongHashCode(r10);
    }

    public static HashCode fromString(String r10) {
        int r11 = 0;
        boolean r12 = true;
        if (r10.length() < 2) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "input string (%s) must have at least 2 characters", r10);
        if ((r10.length() % 2) == 0) goto L10;
        r12 = false;
    L10:
        Preconditions.checkArgument(r12, "input string (%s) must have an even number of characters", r10);
        byte[] r14 = new byte[r10.length() / 2];
    L12:
        if (r11 >= r10.length()) goto L15;
        r14[r11 / 2] = (byte) ((decode(r10.charAt(r11)) << 4) + decode(r10.charAt(r11 + 1)));
        r11 = r11 + 2;
        goto L12
    L15:
        return fromBytesNoCopy(r14);
    L5:
        r13 = false;
        goto L6
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof HashCode) == false) goto L10;
        HashCode r11 = (HashCode) r10;
        if (bits() == r11.bits()) goto L7;
        return false;
    L7:
        if (equalsSameBits(r11) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public abstract boolean equalsSameBits(HashCode r10);

    public byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) goto L5;
        byte[] r10 = getBytesInternal();
        int r11 = r10[0] & UnsignedBytes.MAX_VALUE;
        int r12 = 1;
    L8:
        if (r12 >= r10.length) goto L10;
        r11 = r11 | ((r10[r12] & UnsignedBytes.MAX_VALUE) << (r12 * 8));
        r12 = r12 + 1;
        goto L8
    L10:
        return r11;
    L5:
        return asInt();
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] r10 = getBytesInternal();
        StringBuilder r11 = new StringBuilder(r10.length * 2);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        byte r14 = r10[r13];
        char[] r15 = hexDigits;
        r11.append(r15[(r14 >> 4) & 15]);
        r11.append(r15[r14 & Ascii.SI]);
        r13 = r13 + 1;
        goto L3
    L6:
        return r11.toString();
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] r10, int r11, int r12) {
        int r13 = Ints.min(new int[]{r12, bits() / 8});
        Preconditions.checkPositionIndexes(r11, r11 + r13, r10.length);
        writeBytesToImpl(r10, r11, r13);
        return r13;
    }

    public abstract void writeBytesToImpl(byte[] r10, int r11, int r12);
}
