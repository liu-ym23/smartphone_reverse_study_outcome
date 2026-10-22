package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes;

    public MarkEnforcingInputStream(@NonNull InputStream r10) {
        super(r10);
        this.availableBytes = Integer.MIN_VALUE;
    }

    private long getBytesToRead(long r10) {
        int r11 = this.availableBytes;
        if (r11 != 0) goto L7;
        return -1;
    L7:
        if (r11 != Integer.MIN_VALUE) goto L9;
    L12:
        return r10;
    L9:
        if (r10 <= r11) goto L12;
        return r11;
    }

    private void updateAvailableBytesAfterRead(long r10) {
        int r11 = this.availableBytes;
        if (r11 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        this.availableBytes = (int) (((long) r11) - r10);
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int r10 = this.availableBytes;
        if (r10 != Integer.MIN_VALUE) goto L6;
        return super.available();
    L6:
        return Math.min(r10, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r10) {
        monitor-enter(this);
        super.mark(r10);     // Catch: Throwable -> L6
        this.availableBytes = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (getBytesToRead(1) != (-1)) goto L6;
        return -1;
    L6:
        int r10 = super.read();
        updateAvailableBytesAfterRead(1);
        return r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
        super.reset();     // Catch: Throwable -> L6
        this.availableBytes = Integer.MIN_VALUE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r10) throws IOException {
        long r11 = getBytesToRead(r10);
        if (r11 != (-1)) goto L6;
        return 0;
    L6:
        long r12 = super.skip(r11);
        updateAvailableBytesAfterRead(r12);
        return r12;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] r10, int r11, int r12) throws IOException {
        int r13 = (int) getBytesToRead(r12);
        if (r13 != (-1)) goto L5;
        return -1;
    L5:
        int r14 = super.read(r10, r11, r13);
        updateAvailableBytesAfterRead(r14);
        return r14;
    }
}
