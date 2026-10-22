package com.google.common.hash;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBoolean(boolean r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putByte(byte r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] r1, int r2, int r3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putChar(char r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putDouble(double r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putFloat(float r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putInt(int r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putLong(long r1);

    <T> Hasher putObject(T r1, Funnel<? super T> r2);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putShort(short r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence r1, Charset r2);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence r1);
}
