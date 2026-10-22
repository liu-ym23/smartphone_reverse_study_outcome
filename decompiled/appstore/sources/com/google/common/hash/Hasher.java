package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
@Beta
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBoolean(boolean r10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putByte(byte r10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(ByteBuffer r10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] r10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] r10, int r11, int r12);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putChar(char r10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putDouble(double r10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putFloat(float r10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putInt(int r10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putLong(long r10);

    <T> Hasher putObject(T r10, Funnel<? super T> r11);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putShort(short r10);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence r10, Charset r11);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence r10);
}
