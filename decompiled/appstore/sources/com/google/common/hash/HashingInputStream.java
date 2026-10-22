package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class HashingInputStream extends FilterInputStream {
    private final Hasher hasher;

    public HashingInputStream(HashFunction r10, InputStream r11) {
        super((InputStream) Preconditions.checkNotNull(r11));
        this.hasher = (Hasher) Preconditions.checkNotNull(r10.newHasher());
    }

    public HashCode hash() {
        return this.hasher.hash();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r10) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @CanIgnoreReturnValue
    public int read() throws IOException {
        int r10 = ((FilterInputStream) this).in.read();
        if (r10 == (-1)) goto L5;
        this.hasher.putByte((byte) r10);
    L5:
        return r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @CanIgnoreReturnValue
    public int read(byte[] r10, int r11, int r12) throws IOException {
        int r13 = ((FilterInputStream) this).in.read(r10, r11, r12);
        if (r13 == (-1)) goto L5;
        this.hasher.putBytes(r10, r11, r13);
    L5:
        return r13;
    }
}
