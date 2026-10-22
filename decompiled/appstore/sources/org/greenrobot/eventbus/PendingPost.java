package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class PendingPost {
    private static final List<PendingPost> pendingPostPool = null;
    Object event;
    PendingPost next;
    Subscription subscription;

    static {
        pendingPostPool = new ArrayList();
    }

    private PendingPost(Object r10, Subscription r11) {
        this.event = r10;
        this.subscription = r11;
    }

    public static PendingPost obtainPendingPost(Subscription r10, Object r11) {
        List<PendingPost> r12 = pendingPostPool;
        monitor-enter(r12);
        int r13 = r12.size();     // Catch: Throwable -> L9
        if (r13 <= 0) goto L11;
        PendingPost r14 = r12.remove(r13 - 1);     // Catch: Throwable -> L9
        r14.event = r11;     // Catch: Throwable -> L9
        r14.subscription = r10;     // Catch: Throwable -> L9
        r14.next = null;     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        return r14;
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L9
        return new PendingPost(r11, r10);
    L9:
        th = move-exception;
        throw th;
    }

    public static void releasePendingPost(PendingPost r10) {
        r10.event = null;
        r10.subscription = null;
        r10.next = null;
        List<PendingPost> r11 = pendingPostPool;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r11.size() >= 10000) goto L9;
        r11.add(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
    }
}
