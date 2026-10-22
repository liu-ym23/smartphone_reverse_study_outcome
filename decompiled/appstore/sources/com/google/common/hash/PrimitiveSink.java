package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
@Beta
public interface PrimitiveSink {
    PrimitiveSink putBoolean(boolean r10);

    PrimitiveSink putByte(byte r10);

    PrimitiveSink putBytes(ByteBuffer r10);

    PrimitiveSink putBytes(byte[] r10);

    PrimitiveSink putBytes(byte[] r10, int r11, int r12);

    PrimitiveSink putChar(char r10);

    PrimitiveSink putDouble(double r10);

    PrimitiveSink putFloat(float r10);

    PrimitiveSink putInt(int r10);

    PrimitiveSink putLong(long r10);

    PrimitiveSink putShort(short r10);

    PrimitiveSink putString(CharSequence r10, Charset r11);

    PrimitiveSink putUnencodedChars(CharSequence r10);
}
