package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.k;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public final class SegmentPool {
    static long byteCount = 0;
    static Segment next = null;
    private static long sMaxPoolSize = 262144;
    private static long sMinIdleSizeSinceLastCheck = 0;
    private static long sMinPoolSize = 131072;
    private static boolean sSizesSet = false;
    private static final AtomicLong segmentAllocateTimes = null;
    private static final AtomicLong segmentRequestTimes = null;
    private static final AtomicLong segmentReuseTimes = null;

    public SegmentPool() {
    }

    static {
        segmentAllocateTimes = new AtomicLong(0);
        segmentReuseTimes = new AtomicLong(0);
        segmentRequestTimes = new AtomicLong(0);
    }

    public static void setSizes(long r3, long r5) {
        if (r3 < 0) goto L25;
        if (r5 <= 0) goto L23;
        if (r3 > r5) goto L21;
        monitor-enter(SegmentPool.class);
    L17:
        th = move-exception;
        throw th;
    L11:
        if (sSizesSet == false) goto L14;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L17
        return;
    L14:
        sMinPoolSize = r3;     // Catch: Throwable -> L17
        sMaxPoolSize = r5;     // Catch: Throwable -> L17
        sSizesSet = true;     // Catch: Throwable -> L17
        releaseSegmentsToTarget(r5);     // Catch: Throwable -> L17
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L17
        return;
    L21:
        throw new IllegalArgumentException("Minimum pool size cannot be greater than maximum pool size");
    L23:
        throw new IllegalArgumentException("Max pool size cannot be negative");
    L25:
        throw new IllegalArgumentException("Minimum pool size cannot be negative");
    }

    static Segment take() {
        Segment r0 = take(false);
        if (k.a() == false) goto L5;
        StringBuilder r1 = new StringBuilder().append("after take state:当前pool中segment数量: ").append(byteCount / ((long) Segment.getSize())).append(" 请求次数: ");
        AtomicLong r2 = segmentRequestTimes;
        StringBuilder r3 = r1.append(r2.get()).append(" 不复用次数: ").append(segmentAllocateTimes.get()).append(" 复用次数: ");
        AtomicLong r4 = segmentReuseTimes;
        k.a("SegmentPool", r3.append(r4.get()).append(" 复用率: ").append(r4.get() / r2.get()).toString());
    L5:
        return r0;
    }

    static Segment take(boolean r8) {
        monitor-enter(SegmentPool.class);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (k.a() == false) goto L9;
        if (r8 == true) goto L9;
        segmentRequestTimes.incrementAndGet();     // Catch: Throwable -> L33
    L9:
        if (next != null) goto L11;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L33
        if (r8 == false) goto L28;
        return null;
    L28:
        if (k.a() == false) goto L31;
        segmentAllocateTimes.incrementAndGet();
    L31:
        return new Segment();
    L11:
        if (k.a() == false) goto L14;
        if (r8 == true) goto L14;
        segmentReuseTimes.incrementAndGet();     // Catch: Throwable -> L33
    L14:
        Segment r1 = next;     // Catch: Throwable -> L33
        next = r1.next;     // Catch: Throwable -> L33
        r1.next = null;     // Catch: Throwable -> L33
        byteCount -= (long) Segment.getSize();     // Catch: Throwable -> L33
        if (k.a() == false) goto L17;
        k.a("SegmentPool", "sMinIdleSizeSinceLastCheck check if decreased, current is " + (sMinIdleSizeSinceLastCheck / ((long) Segment.getSize())));     // Catch: Throwable -> L33
    L17:
        long r2 = byteCount;     // Catch: Throwable -> L33
        if (r2 >= sMinIdleSizeSinceLastCheck) goto L23;
        if (r8 == true) goto L23;
        sMinIdleSizeSinceLastCheck = r2;     // Catch: Throwable -> L33
        if (k.a() == false) goto L23;
        k.a("SegmentPool", "segment count decreased to " + (sMinIdleSizeSinceLastCheck / ((long) Segment.getSize())));     // Catch: Throwable -> L33
    L23:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L33
        return r1;
    }

    static boolean recycle(Segment r9) {
        if (r9.next != null) goto L26;
        if (r9.prev != null) goto L26;
        monitor-enter(SegmentPool.class);
        long r1 = Segment.getSize();     // Catch: Throwable -> L22
        long r3 = byteCount;     // Catch: Throwable -> L22
        if ((r3 + r1) > sMaxPoolSize) goto L11;
        byteCount = r3 + r1;     // Catch: Throwable -> L22
        r9.next = next;     // Catch: Throwable -> L22
        next = r9;     // Catch: Throwable -> L22
        if (k.a() == false) goto L19;
        k.a("SegmentPool", "after recycle state:当前pool中segment数量: " + (byteCount / ((long) Segment.getSize())));     // Catch: Throwable -> L22
    L19:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L22
        return true;
    L11:
        if (k.a() == false) goto L14;
        k.a("SegmentPool", "full, will not recycle this segment");     // Catch: Throwable -> L22
    L14:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L22
        return false;
    L22:
        th = move-exception;
        throw th;
    L26:
        throw new IllegalArgumentException("Segment is still in use");
    }

    public static boolean checkAndReleaseIdleSegments() {
        monitor-enter(SegmentPool.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (k.a() == false) goto L7;
        k.a("SegmentPool", "sMinIdleSizeSinceLastCheck before reset " + (sMinIdleSizeSinceLastCheck / ((long) Segment.getSize())) + ", byteCount: " + (byteCount / ((long) Segment.getSize())));     // Catch: Throwable -> L31
    L7:
        long r1 = byteCount;     // Catch: Throwable -> L31
        long r3 = sMinPoolSize;     // Catch: Throwable -> L31
        if (r1 <= r3) goto L10;
        long r2 = Math.max(r3, r1 - sMinIdleSizeSinceLastCheck);     // Catch: Throwable -> L31
        if (k.a() == false) goto L18;
        k.a("SegmentPool", "segment count want save targetByteCount " + (r2 / ((long) Segment.getSize())));     // Catch: Throwable -> L31
    L18:
        long r4 = byteCount;     // Catch: Throwable -> L31
        if (r4 > r2) goto L25;
        sMinIdleSizeSinceLastCheck = r4;     // Catch: Throwable -> L31
        if (k.a() == false) goto L23;
        k.a("SegmentPool", "will not shrink 2");     // Catch: Throwable -> L31
    L23:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L31
        return false;
    L25:
        releaseSegmentsToTarget(r2);     // Catch: Throwable -> L31
        sMinIdleSizeSinceLastCheck = byteCount;     // Catch: Throwable -> L31
        if (k.a() == false) goto L29;
        k.a("SegmentPool", "segment count has been reset to " + (sMinIdleSizeSinceLastCheck / ((long) Segment.getSize())));     // Catch: Throwable -> L31
    L29:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L31
        return true;
    L10:
        if (k.a() == false) goto L12;
        k.a("SegmentPool", "will not shrink 1");     // Catch: Throwable -> L31
    L12:
        sMinIdleSizeSinceLastCheck = byteCount;     // Catch: Throwable -> L31
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L31
        return false;
    }

    private static void releaseSegmentsToTarget(long r4) {
        if (byteCount > r4) goto L5;
        return;
    L5:
        int r0 = (int) Math.ceil((byteCount - r4) / Segment.getSize());
        if (k.a() == false) goto L8;
        k.a("SegmentPool", "releaseSegmentsToTarget, targetByteCount: " + r4 + ", segmentsToRelease: " + r0);
    L8:
        int r5 = 0;
    L9:
        if (r5 >= r0) goto L11;
        take(true);
        r5 = r5 + 1;
        goto L9
    }
}
