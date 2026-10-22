package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@Beta
public interface HashFunction {
    int bits();

    HashCode hashBytes(ByteBuffer r10);

    HashCode hashBytes(byte[] r10);

    HashCode hashBytes(byte[] r10, int r11, int r12);

    HashCode hashInt(int r10);

    HashCode hashLong(long r10);

    <T> HashCode hashObject(T r10, Funnel<? super T> r11);

    HashCode hashString(CharSequence r10, Charset r11);

    HashCode hashUnencodedChars(CharSequence r10);

    Hasher newHasher();

    Hasher newHasher(int r10);
}
