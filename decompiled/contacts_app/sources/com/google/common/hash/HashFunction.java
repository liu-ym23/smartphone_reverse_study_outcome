package com.google.common.hash;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface HashFunction {
    int bits();

    HashCode hashBytes(byte[] r1);

    HashCode hashBytes(byte[] r1, int r2, int r3);

    HashCode hashInt(int r1);

    HashCode hashLong(long r1);

    <T> HashCode hashObject(T r1, Funnel<? super T> r2);

    HashCode hashString(CharSequence r1, Charset r2);

    HashCode hashUnencodedChars(CharSequence r1);

    Hasher newHasher();

    Hasher newHasher(int r1);
}
