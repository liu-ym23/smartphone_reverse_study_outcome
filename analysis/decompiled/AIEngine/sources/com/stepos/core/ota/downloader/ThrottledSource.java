package com.stepos.core.ota.downloader;

import kotlin.jvm.internal.g;
import sd.e0;
import sd.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class ThrottledSource extends n {
    private static final long CHUNK = 16384;
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThrottledSource(e0 delegate) {
        super(delegate);
        g.f(delegate, "delegate");
    }

    @Override // sd.n, sd.e0
    public long read(sd.e sink, long j10) throws InterruptedException {
        g.f(sink, "sink");
        DownloadRateLimiter downloadRateLimiter = DownloadRateLimiter.INSTANCE;
        if (downloadRateLimiter.getBytesPerSec() > 0) {
            j10 = Math.min(j10, 16384L);
        }
        long j11 = super.read(sink, j10);
        if (j11 > 0) {
            downloadRateLimiter.acquire((int) j11);
        }
        return j11;
    }
}
