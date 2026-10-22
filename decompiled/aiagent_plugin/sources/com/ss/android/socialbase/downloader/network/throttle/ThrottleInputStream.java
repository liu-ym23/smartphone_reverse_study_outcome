package com.ss.android.socialbase.downloader.network.throttle;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class ThrottleInputStream extends InputStream {
    public static final int DEFAULT_THROTTLE_SMOOTHNESS = 40;
    private final InputStream in;
    private long overReadAndSleepTime;
    protected long periodStartTime;
    private long readBytesInPeriod;
    protected long throttleNetSpeed;
    protected volatile long throttlePeriod;
    private volatile long throttlePeriodBytes;
    protected int throttleSmoothness;

    public ThrottleInputStream(InputStream r2) {
        this.throttleSmoothness = 40;
        this.in = r2;
    }

    public void setThrottleNetSpeed(long r2) {
        setThrottleNetSpeed(r2, 0);
    }

    public void setThrottleNetSpeed(long r3, int r5) {
        this.throttleNetSpeed = r3;
        if (r5 >= 1) goto L5;
    L7:
        this.throttlePeriod = 1000 / this.throttleSmoothness;
        this.throttlePeriodBytes = r3 / ((long) this.throttleSmoothness);
        return;
    L5:
        if (r5 > 100) goto L7;
        this.throttleSmoothness = r5;
        goto L7
    }

    @Override // java.io.InputStream
    public int read() {
        return this.in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r7, int r8, int r9) {
        if (this.throttlePeriodBytes <= 0) goto L37;
        if (this.periodStartTime != 0) goto L7;
        this.periodStartTime = System.currentTimeMillis();
    L7:
        long r0 = this.throttlePeriodBytes - this.readBytesInPeriod;
        if (r0 > 0) goto L10;
    L12:
        int r10 = this.in.read(r7, r8, r9);
        if (r10 == (-1)) goto L16;
        this.readBytesInPeriod += (long) r10;
    L16:
        if (this.readBytesInPeriod < this.throttlePeriodBytes) goto L35;
        long r11 = System.currentTimeMillis();
        long r1 = r11 - this.periodStartTime;
        this.periodStartTime = r11;
        long r12 = this.throttlePeriod - r1;
        if (r12 <= 0) goto L30;
        long r2 = this.overReadAndSleepTime;
        if (r12 <= r2) goto L29;
        long r13 = r12 - r2;
        this.overReadAndSleepTime = 0;
        if (r13 <= 0) goto L34;
        this.periodStartTime += r13;
        Thread.sleep(r13);     // Catch: InterruptedException -> L26
    L26:
        e = move-exception;
        throw new IOException(e);
    L34:
        this.readBytesInPeriod = 0;
        goto L35
    L29:
        this.overReadAndSleepTime = r2 - r12;
        goto L34
    L30:
        if (r12 >= 0) goto L34;
        long r3 = this.overReadAndSleepTime + (-r12);
        this.overReadAndSleepTime = r3;
        if (r3 <= 100) goto L34;
        this.overReadAndSleepTime = 100;
    L35:
        return r10;
    L10:
        if (r9 <= r0) goto L12;
        r9 = (int) r0;
        goto L12
    L37:
        return this.in.read(r7, r8, r9);
    }

    public int superRead(byte[] r1, int r2, int r3) {
        return super.read(r1, r2, r3);
    }

    @Override // java.io.InputStream
    public long skip(long r1) {
        return this.in.skip(r1);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        this.in.mark(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        this.in.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }
}
