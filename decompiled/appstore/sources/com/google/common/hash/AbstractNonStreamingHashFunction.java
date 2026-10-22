package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
abstract class AbstractNonStreamingHashFunction extends AbstractHashFunction {

    public final class BufferingHasher extends AbstractHasher {
        final ExposedByteArrayOutputStream stream;
        final /* synthetic */ AbstractNonStreamingHashFunction this$0;

        public BufferingHasher(AbstractNonStreamingHashFunction r10, int r11) {
            this.this$0 = r10;
            this.stream = new ExposedByteArrayOutputStream(r11);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            return this.this$0.hashBytes(this.stream.byteArray(), 0, this.stream.length());
        }

        @Override // com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putByte(byte r10) {
            return putByte(r10);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer r10) {
            return putBytes(r10);
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte r10) {
            this.stream.write(r10);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r10, int r11, int r12) {
            return putBytes(r10, r11, r12);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] r10, int r11, int r12) {
            this.stream.write(r10, r11, r12);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer r10) {
            this.stream.write(r10);
            return this;
        }
    }

    public static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream(int r10) {
            super(r10);
        }

        public byte[] byteArray() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int length() {
            return ((ByteArrayOutputStream) this).count;
        }

        public void write(ByteBuffer r10) {
            int r11 = r10.remaining();
            int r12 = ((ByteArrayOutputStream) this).count;
            int r13 = r12 + r11;
            byte[] r14 = ((ByteArrayOutputStream) this).buf;
            if (r13 <= r14.length) goto L5;
            ((ByteArrayOutputStream) this).buf = Arrays.copyOf(r14, r12 + r11);
        L5:
            r10.get(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count, r11);
            ((ByteArrayOutputStream) this).count += r11;
        }
    }

    public AbstractNonStreamingHashFunction() {
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(ByteBuffer r10) {
        return newHasher(r10.remaining()).putBytes(r10).hash();
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public abstract HashCode hashBytes(byte[] r10, int r11, int r12);

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int r10) {
        return hashBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(r10).array());
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long r10) {
        return hashBytes(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(r10).array());
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence r10, Charset r11) {
        return hashBytes(r10.toString().getBytes(r11));
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence r10) {
        int r11 = r10.length();
        ByteBuffer r12 = ByteBuffer.allocate(r11 * 2).order(ByteOrder.LITTLE_ENDIAN);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        r12.putChar(r10.charAt(r13));
        r13 = r13 + 1;
        goto L3
    L6:
        return hashBytes(r12.array());
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return newHasher(32);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public Hasher newHasher(int r10) {
        if (r10 < 0) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11);
        return new BufferingHasher(this, r10);
    L4:
        r11 = false;
        goto L5
    }
}
