package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
abstract class AbstractStreamingHasher extends AbstractHasher {
    private final ByteBuffer buffer;
    private final int bufferSize;
    private final int chunkSize;

    public AbstractStreamingHasher(int r10) {
        this(r10, r10);
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

    private void munchIfFull() {
        if (this.buffer.remaining() >= 8) goto L6;
        munch();
        return;
    }

    private Hasher putBytesInternal(ByteBuffer r10) {
        if (r10.remaining() > this.buffer.remaining()) goto L6;
        this.buffer.put(r10);
        munchIfFull();
        return this;
    L6:
        int r11 = this.bufferSize - this.buffer.position();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L9;
        this.buffer.put(r10.get());
        r12 = r12 + 1;
        goto L7
    L9:
        munch();
    L11:
        if (r10.remaining() < this.chunkSize) goto L13;
        process(r10);
        goto L11
    L13:
        this.buffer.put(r10);
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        munch();
        this.buffer.flip();
        if (this.buffer.remaining() <= 0) goto L6;
        processRemaining(this.buffer);
        ByteBuffer r10 = this.buffer;
        r10.position(r10.limit());
    L6:
        return makeHash();
    }

    public abstract HashCode makeHash();

    public abstract void process(ByteBuffer r10);

    public void processRemaining(ByteBuffer r10) {
        r10.position(r10.limit());
        r10.limit(this.chunkSize + 7);
    L3:
        int r11 = r10.position();
        int r12 = this.chunkSize;
        if (r11 >= r12) goto L6;
        r10.putLong(0);
        goto L3
    L6:
        r10.limit(r12);
        r10.flip();
        process(r10);
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
    public /* bridge */ /* synthetic */ PrimitiveSink putShort(short r10) {
        return putShort(r10);
    }

    public AbstractStreamingHasher(int r10, int r11) {
        if ((r11 % r10) != 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        this.buffer = ByteBuffer.allocate(r11 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.bufferSize = r11;
        this.chunkSize = r10;
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putByte(byte r10) {
        this.buffer.put(r10);
        munchIfFull();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r10, int r11, int r12) {
        return putBytes(r10, r11, r12);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putChar(char r10) {
        this.buffer.putChar(r10);
        munchIfFull();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putInt(int r10) {
        this.buffer.putInt(r10);
        munchIfFull();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putLong(long r10) {
        this.buffer.putLong(r10);
        munchIfFull();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putShort(short r10) {
        this.buffer.putShort(r10);
        munchIfFull();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] r10, int r11, int r12) {
        return putBytesInternal(ByteBuffer.wrap(r10, r11, r12).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer r10) {
        ByteOrder r11 = r10.order();
        r10.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L6
        Hasher r12 = putBytesInternal(r10);     // Catch: Throwable -> L6
        r10.order(r11);
        return r12;
    L6:
        th = move-exception;
        r10.order(r11);
        throw th;
    }
}
