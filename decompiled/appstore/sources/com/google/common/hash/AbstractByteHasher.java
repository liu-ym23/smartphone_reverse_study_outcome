package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
abstract class AbstractByteHasher extends AbstractHasher {
    private final ByteBuffer scratch;

    public AbstractByteHasher() {
        this.scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
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

    public abstract void update(byte r10);

    public void update(byte[] r10) {
        update(r10, 0, r10.length);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putByte(byte r10) {
        update(r10);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r10) {
        return putBytes(r10);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putChar(char r10) {
        this.scratch.putChar(r10);
        return update(2);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putInt(int r10) {
        this.scratch.putInt(r10);
        return update(4);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putLong(long r10) {
        this.scratch.putLong(r10);
        return update(8);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putShort(short r10) {
        this.scratch.putShort(r10);
        return update(2);
    }

    public void update(byte[] r10, int r11, int r12) {
        int r13 = r11;
    L4:
        if (r13 >= (r11 + r12)) goto L6;
        update(r10[r13]);
        r13 = r13 + 1;
        goto L4
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r10, int r11, int r12) {
        return putBytes(r10, r11, r12);
    }

    public void update(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L5;
        update(r10.array(), r10.arrayOffset() + r10.position(), r10.remaining());
        r10.position(r10.limit());
        return;
    L5:
        int r11 = r10.remaining();
    L6:
        if (r11 <= 0) goto L10;
        update(r10.get());
        r11 = r11 - 1;
        goto L6
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] r10) {
        Preconditions.checkNotNull(r10);
        update(r10);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] r10, int r11, int r12) {
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        update(r10, r11, r12);
        return this;
    }

    private Hasher update(int r10) {
        update(this.scratch.array(), 0, r10);     // Catch: Throwable -> L5
        this.scratch.clear();
        return this;
    L5:
        th = move-exception;
        this.scratch.clear();
        throw th;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putBytes(ByteBuffer r10) {
        update(r10);
        return this;
    }
}
