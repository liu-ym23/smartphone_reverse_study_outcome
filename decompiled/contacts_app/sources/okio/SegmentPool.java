package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
final class SegmentPool {
    static final long MAX_SIZE = 65536;
    static long byteCount;

    @Nullable
    static Segment next;

    private SegmentPool() {
    }

    static Segment take() {
        monitor-enter(SegmentPool.class);
        Segment r1 = next;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        next = r1.next;     // Catch: Throwable -> L12
        r1.next = null;     // Catch: Throwable -> L12
        byteCount -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;     // Catch: Throwable -> L12
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L12
        return r1;
    L9:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L12
        return new Segment();
    L12:
        th = move-exception;
        throw th;
    }

    static void recycle(Segment r9) {
        if (r9.next != null) goto L22;
        if (r9.prev != null) goto L22;
        if (r9.shared == false) goto L10;
        return;
    L10:
        monitor-enter(SegmentPool.class);
        long r1 = byteCount;     // Catch: Throwable -> L18
        if ((r1 + PlaybackStateCompat.ACTION_PLAY_FROM_URI) <= 65536) goto L15;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L18
        return;
    L15:
        byteCount = r1 + PlaybackStateCompat.ACTION_PLAY_FROM_URI;     // Catch: Throwable -> L18
        r9.next = next;     // Catch: Throwable -> L18
        r9.limit = 0;     // Catch: Throwable -> L18
        r9.pos = 0;     // Catch: Throwable -> L18
        next = r9;     // Catch: Throwable -> L18
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new IllegalArgumentException();
    }
}
