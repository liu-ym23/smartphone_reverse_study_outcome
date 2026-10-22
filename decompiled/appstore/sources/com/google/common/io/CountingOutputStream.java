package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class CountingOutputStream extends FilterOutputStream {
    private long count;

    public CountingOutputStream(OutputStream r10) {
        super((OutputStream) Preconditions.checkNotNull(r10));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    public long getCount() {
        return this.count;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) throws IOException {
        ((FilterOutputStream) this).out.write(r10, r11, r12);
        this.count += (long) r12;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r10) throws IOException {
        ((FilterOutputStream) this).out.write(r10);
        this.count++;
    }
}
