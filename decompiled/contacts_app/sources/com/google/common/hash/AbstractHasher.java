package com.google.common.hash;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractHasher implements Hasher {
    AbstractHasher() {
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean r1) {
        return putBoolean(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putDouble(double r1) {
        return putDouble(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putFloat(float r1) {
        return putFloat(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence r1, Charset r2) {
        return putString(r1, r2);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence r1) {
        return putUnencodedChars(r1);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBoolean(boolean r1) {
        return putByte(r1 ? 1 : 0);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putDouble(double r1) {
        return putLong(Double.doubleToRawLongBits(r1));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putFloat(float r1) {
        return putInt(Float.floatToRawIntBits(r1));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putUnencodedChars(CharSequence r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        putChar(r4.charAt(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putString(CharSequence r1, Charset r2) {
        return putBytes(r1.toString().getBytes(r2));
    }
}
