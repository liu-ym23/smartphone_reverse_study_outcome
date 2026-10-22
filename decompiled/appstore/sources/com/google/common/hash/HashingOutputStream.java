package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class HashingOutputStream extends FilterOutputStream {
    private final Hasher hasher;

    public HashingOutputStream(HashFunction r10, OutputStream r11) {
        super((OutputStream) Preconditions.checkNotNull(r11));
        this.hasher = (Hasher) Preconditions.checkNotNull(r10.newHasher());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    public HashCode hash() {
        return this.hasher.hash();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r10) throws IOException {
        this.hasher.putByte((byte) r10);
        ((FilterOutputStream) this).out.write(r10);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) throws IOException {
        this.hasher.putBytes(r10, r11, r12);
        ((FilterOutputStream) this).out.write(r10, r11, r12);
    }
}
