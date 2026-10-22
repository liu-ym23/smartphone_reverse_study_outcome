package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractNonStreamingHashFunction implements HashFunction {

    private final class BufferingHasher extends AbstractHasher {
        static final int BOTTOM_BYTE = 255;
        final ExposedByteArrayOutputStream stream;
        final /* synthetic */ AbstractNonStreamingHashFunction this$0;

        @Override // com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putByte(byte r1) {
            return putByte(r1);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r1) {
            return putBytes(r1);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r1, int r2, int r3) {
            return putBytes(r1, r2, r3);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putChar(char r1) {
            return putChar(r1);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putInt(int r1) {
            return putInt(r1);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putLong(long r1) {
            return putLong(r1);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putShort(short r1) {
            return putShort(r1);
        }

        BufferingHasher(AbstractNonStreamingHashFunction r1, int r2) {
            this.this$0 = r1;
            this.stream = new ExposedByteArrayOutputStream(r2);
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte r2) {
            this.stream.write(r2);
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] r2) {
            this.stream.write(r2);     // Catch: IOException -> L4
            return this;
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] r2, int r3, int r4) {
            this.stream.write(r2, r3, r4);
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putShort(short r3) {
            this.stream.write(r3 & 255);
            this.stream.write((r3 >>> 8) & 255);
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putInt(int r3) {
            this.stream.write(r3 & 255);
            this.stream.write((r3 >>> 8) & 255);
            this.stream.write((r3 >>> 16) & 255);
            this.stream.write((r3 >>> 24) & 255);
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putLong(long r7) {
            int r0 = 0;
        L4:
            if (r0 >= 64) goto L6;
            this.stream.write((byte) ((r7 >>> r0) & 255));
            r0 = r0 + 8;
            goto L4
        L6:
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putChar(char r3) {
            this.stream.write(r3 & 255);
            this.stream.write((r3 >>> '\b') & 255);
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public <T> Hasher putObject(T r1, Funnel<? super T> r2) {
            r2.funnel(r1, this);
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            return this.this$0.hashBytes(this.stream.byteArray(), 0, this.stream.length());
        }
    }

    private static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        ExposedByteArrayOutputStream(int r1) {
            super(r1);
        }

        byte[] byteArray() {
            return this.buf;
        }

        int length() {
            return this.count;
        }
    }

    AbstractNonStreamingHashFunction() {
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new BufferingHasher(this, 32);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher(int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0);
        return new BufferingHasher(this, r2);
    L4:
        r0 = false;
        goto L5
    }

    @Override // com.google.common.hash.HashFunction
    public <T> HashCode hashObject(T r1, Funnel<? super T> r2) {
        return newHasher().putObject(r1, r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence r4) {
        int r0 = r4.length();
        Hasher r3 = newHasher(r0 * 2);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r3.putChar(r4.charAt(r1));
        r1 = r1 + 1;
        goto L3
    L6:
        return r3.hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence r1, Charset r2) {
        return hashBytes(r1.toString().getBytes(r2));
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashInt(int r2) {
        return newHasher(4).putInt(r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashLong(long r2) {
        return newHasher(8).putLong(r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r3) {
        return hashBytes(r3, 0, r3.length);
    }
}
