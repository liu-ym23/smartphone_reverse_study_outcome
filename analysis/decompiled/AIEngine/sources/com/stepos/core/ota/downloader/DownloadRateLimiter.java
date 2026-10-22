package com.stepos.core.ota.downloader;

import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadRateLimiter {
    private static final String TAG = "OtaDlRate";
    private static volatile long bytesPerSec;
    private static long nextAllowedNs;
    public static final DownloadRateLimiter INSTANCE = new DownloadRateLimiter();
    private static final Object lock = new Object();

    private DownloadRateLimiter() {
    }

    public final void acquire(int i10) throws InterruptedException {
        long j10;
        long j11 = bytesPerSec;
        if (j11 <= 0 || i10 <= 0) {
            return;
        }
        synchronized (lock) {
            try {
                long jNanoTime = System.nanoTime();
                if (nextAllowedNs < jNanoTime) {
                    nextAllowedNs = jNanoTime;
                }
                long j12 = nextAllowedNs;
                nextAllowedNs = ((long) ((i10 / j11) * 1.0E9d)) + j12;
                j10 = (j12 - jNanoTime) / 1000000;
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (j10 > 0) {
            try {
                Thread.sleep(j10);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final long getBytesPerSec() {
        return bytesPerSec;
    }

    public final void updateRate(long j10) {
        String str;
        if (j10 < 0) {
            j10 = 0;
        }
        if (j10 != bytesPerSec) {
            bytesPerSec = j10;
            if (j10 > 0) {
                str = (j10 / 1024) + "KB/s";
            } else {
                str = "unlimited";
            }
            a0.a.y("download rate -> ", str, TAG);
        }
    }
}
