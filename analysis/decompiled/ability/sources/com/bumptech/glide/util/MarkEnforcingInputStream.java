package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
        this.availableBytes = Integer.MIN_VALUE;
    }

    private long getBytesToRead(long j5) {
        int i = this.availableBytes;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j5 <= ((long) i)) ? j5 : i;
    }

    private void updateAvailableBytesAfterRead(long j5) {
        int i = this.availableBytes;
        if (i == Integer.MIN_VALUE || j5 == -1) {
            return;
        }
        this.availableBytes = (int) (i - j5);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.availableBytes;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.availableBytes = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (getBytesToRead(1L) == -1) {
            return -1;
        }
        int i = super.read();
        updateAvailableBytesAfterRead(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.availableBytes = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j5) throws IOException {
        long bytesToRead = getBytesToRead(j5);
        if (bytesToRead == -1) {
            return 0L;
        }
        long jSkip = super.skip(bytesToRead);
        updateAvailableBytesAfterRead(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i6) throws IOException {
        int bytesToRead = (int) getBytesToRead(i6);
        if (bytesToRead == -1) {
            return -1;
        }
        int i10 = super.read(bArr, i, bytesToRead);
        updateAvailableBytesAfterRead(i10);
        return i10;
    }
}
