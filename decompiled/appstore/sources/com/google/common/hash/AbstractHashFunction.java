package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
abstract class AbstractHashFunction implements HashFunction {
    public AbstractHashFunction() {
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r10) {
        return hashBytes(r10, 0, r10.length);
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashInt(int r10) {
        return newHasher(4).putInt(r10).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashLong(long r10) {
        return newHasher(8).putLong(r10).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public <T> HashCode hashObject(T r10, Funnel<? super T> r11) {
        return newHasher().putObject(r10, r11).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence r10, Charset r11) {
        return newHasher().putString(r10, r11).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence r10) {
        return newHasher(r10.length() * 2).putUnencodedChars(r10).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher(int r10) {
        if (r10 < 0) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11, "expectedInputSize must be >= 0 but was %s", r10);
        return newHasher();
    L4:
        r11 = false;
        goto L5
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r10, int r11, int r12) {
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        return newHasher(r12).putBytes(r10, r11, r12).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(ByteBuffer r10) {
        return newHasher(r10.remaining()).putBytes(r10).hash();
    }
}
