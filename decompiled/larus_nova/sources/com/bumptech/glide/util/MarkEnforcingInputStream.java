package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes;

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
    public int available() throws IOException {
        int r100 = this.availableBytes;
        if (r100 != Integer.MIN_VALUE) goto L6;
        return super.available();
    L6:
        return Math.min(r100, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (getBytesToRead(1) != (-1)) goto L6;
        return -1;
    L6:
        int r100 = super.read();
        updateAvailableBytesAfterRead(1);
        return r100;
    }

    public MarkEnforcingInputStream(InputStream r100) {
        super(r100);
        this.availableBytes = Integer.MIN_VALUE;
    }

    private long getBytesToRead(long r100) {
        int r101 = this.availableBytes;
        if (r101 != 0) goto L7;
        return -1;
    L7:
        if (r101 != Integer.MIN_VALUE) goto L9;
        return r100;
    L9:
        if (r100 > r101) goto L11;
        return r100;
    L11:
        return r101;
    }

    private void updateAvailableBytesAfterRead(long r100) {
        int r101 = this.availableBytes;
        if (r101 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (r100 == (-1)) goto L9;
        this.availableBytes = (int) (((long) r101) - r100);
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r100) {
        monitor-enter(this);
        super.mark(r100);     // Catch: Throwable -> L6
        this.availableBytes = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r100) throws IOException {
        long r101 = getBytesToRead(r100);
        if (r101 != (-1)) goto L6;
        return 0;
    L6:
        long r102 = super.skip(r101);
        updateAvailableBytesAfterRead(r102);
        return r102;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = (int) getBytesToRead(r102);
        if (r103 != (-1)) goto L5;
        return -1;
    L5:
        int r104 = super.read(r100, r101, r103);
        updateAvailableBytesAfterRead(r104);
        return r104;
    }
}
