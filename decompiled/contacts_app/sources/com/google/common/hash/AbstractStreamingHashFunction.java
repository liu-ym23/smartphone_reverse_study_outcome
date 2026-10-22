package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractStreamingHashFunction implements HashFunction {

    protected static abstract class AbstractStreamingHasher extends AbstractHasher {
        private final ByteBuffer buffer;
        private final int bufferSize;
        private final int chunkSize;

        abstract HashCode makeHash();

        protected abstract void process(ByteBuffer r1);

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

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence r1) {
            return putUnencodedChars(r1);
        }

        protected AbstractStreamingHasher(int r1) {
            this(r1, r1);
        }

        protected AbstractStreamingHasher(int r3, int r4) {
            if ((r4 % r3) != 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
            this.buffer = ByteBuffer.allocate(r4 + 7).order(ByteOrder.LITTLE_ENDIAN);
            this.bufferSize = r4;
            this.chunkSize = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        protected void processRemaining(ByteBuffer r3) {
            r3.position(r3.limit());
            r3.limit(this.chunkSize + 7);
        L3:
            int r0 = r3.position();
            int r1 = this.chunkSize;
            if (r0 >= r1) goto L6;
            r3.putLong(0);
            goto L3
        L6:
            r3.limit(r1);
            r3.flip();
            process(r3);
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public final Hasher putBytes(byte[] r3) {
            return putBytes(r3, 0, r3.length);
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public final Hasher putBytes(byte[] r1, int r2, int r3) {
            return putBytes(ByteBuffer.wrap(r1, r2, r3).order(ByteOrder.LITTLE_ENDIAN));
        }

        private Hasher putBytes(ByteBuffer r5) {
            if (r5.remaining() > this.buffer.remaining()) goto L6;
            this.buffer.put(r5);
            munchIfFull();
            return this;
        L6:
            int r0 = this.bufferSize - this.buffer.position();
            int r1 = 0;
        L7:
            if (r1 >= r0) goto L9;
            this.buffer.put(r5.get());
            r1 = r1 + 1;
            goto L7
        L9:
            munch();
        L11:
            if (r5.remaining() < this.chunkSize) goto L13;
            process(r5);
            goto L11
        L13:
            this.buffer.put(r5);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public final Hasher putUnencodedChars(CharSequence r3) {
            int r0 = 0;
        L4:
            if (r0 >= r3.length()) goto L6;
            putChar(r3.charAt(r0));
            r0 = r0 + 1;
            goto L4
        L6:
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public final Hasher putByte(byte r2) {
            this.buffer.put(r2);
            munchIfFull();
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public final Hasher putShort(short r2) {
            this.buffer.putShort(r2);
            munchIfFull();
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public final Hasher putChar(char r2) {
            this.buffer.putChar(r2);
            munchIfFull();
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public final Hasher putInt(int r2) {
            this.buffer.putInt(r2);
            munchIfFull();
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public final Hasher putLong(long r2) {
            this.buffer.putLong(r2);
            munchIfFull();
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final <T> Hasher putObject(T r1, Funnel<? super T> r2) {
            r2.funnel(r1, this);
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public final HashCode hash() {
            munch();
            this.buffer.flip();
            if (this.buffer.remaining() <= 0) goto L6;
            processRemaining(this.buffer);
        L6:
            return makeHash();
        }

        private void munchIfFull() {
            if (this.buffer.remaining() >= 8) goto L6;
            munch();
            return;
        }

        private void munch() {
            this.buffer.flip();
        L4:
            if (this.buffer.remaining() < this.chunkSize) goto L6;
            process(this.buffer);
            goto L4
        L6:
            this.buffer.compact();
        }
    }

    AbstractStreamingHashFunction() {
    }

    @Override // com.google.common.hash.HashFunction
    public <T> HashCode hashObject(T r1, Funnel<? super T> r2) {
        return newHasher().putObject(r1, r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence r1) {
        return newHasher().putUnencodedChars(r1).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence r1, Charset r2) {
        return newHasher().putString(r1, r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashInt(int r1) {
        return newHasher().putInt(r1).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashLong(long r1) {
        return newHasher().putLong(r1).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r1) {
        return newHasher().putBytes(r1).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r1, int r2, int r3) {
        return newHasher().putBytes(r1, r2, r3).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher(int r1) {
        if (r1 < 0) goto L4;
        boolean r2 = true;
    L5:
        Preconditions.checkArgument(r2);
        return newHasher();
    L4:
        r2 = false;
        goto L5
    }
}
