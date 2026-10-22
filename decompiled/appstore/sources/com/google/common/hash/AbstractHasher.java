package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
abstract class AbstractHasher implements Hasher {
    public AbstractHasher() {
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean r10) {
        return putBoolean(r10);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer r10) {
        return putBytes(r10);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putChar(char r10) {
        return putChar(r10);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putDouble(double r10) {
        return putDouble(r10);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putFloat(float r10) {
        return putFloat(r10);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putInt(int r10) {
        return putInt(r10);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putLong(long r10) {
        return putLong(r10);
    }

    @Override // com.google.common.hash.Hasher
    public <T> Hasher putObject(T r10, Funnel<? super T> r11) {
        r11.funnel(r10, this);
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putShort(short r10) {
        return putShort(r10);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence r10, Charset r11) {
        return putString(r10, r11);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence r10) {
        return putUnencodedChars(r10);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBoolean(boolean r10) {
        return putByte(r10 ? 1 : 0);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r10) {
        return putBytes(r10);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putChar(char r10) {
        putByte((byte) r10);
        putByte((byte) (r10 >>> '\b'));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putDouble(double r10) {
        return putLong(Double.doubleToRawLongBits(r10));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putFloat(float r10) {
        return putInt(Float.floatToRawIntBits(r10));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putInt(int r10) {
        putByte((byte) r10);
        putByte((byte) (r10 >>> 8));
        putByte((byte) (r10 >>> 16));
        putByte((byte) (r10 >>> 24));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putLong(long r10) {
        int r11 = 0;
    L4:
        if (r11 >= 64) goto L6;
        putByte((byte) (r10 >>> r11));
        r11 = r11 + 8;
        goto L4
    L6:
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putShort(short r10) {
        putByte((byte) r10);
        putByte((byte) (r10 >>> 8));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putString(CharSequence r10, Charset r11) {
        return putBytes(r10.toString().getBytes(r11));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putUnencodedChars(CharSequence r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        putChar(r10.charAt(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] r10, int r11, int r12) {
        return putBytes(r10, r11, r12);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] r10) {
        return putBytes(r10, 0, r10.length);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] r10, int r11, int r12) {
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        putByte(r10[r11 + r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putBytes(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L5;
        putBytes(r10.array(), r10.arrayOffset() + r10.position(), r10.remaining());
        r10.position(r10.limit());
    L8:
        return this;
    L5:
        int r11 = r10.remaining();
    L6:
        if (r11 <= 0) goto L8;
        putByte(r10.get());
        r11 = r11 - 1;
        goto L6
    }
}
