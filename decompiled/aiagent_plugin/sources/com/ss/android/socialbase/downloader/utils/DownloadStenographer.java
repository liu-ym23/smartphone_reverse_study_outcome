package com.ss.android.socialbase.downloader.utils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadStenographer {
    private static final int MAX_NODE_COUNT = 20;
    private static final int SECONDS_TO_MILLS = 1000;
    private int count;
    private Node head;
    private int maxCount;
    private Node tail;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.DownloadStenographer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Node {
        long curBytes;
        Node next;
        Node prev;
        long when;

        private Node() {
        }

        /* synthetic */ Node(AnonymousClass1 r1) {
            this();
        }
    }

    public DownloadStenographer() {
        this.maxCount = 10;
    }

    public DownloadStenographer(int r2) {
        if (r2 <= 20) goto L5;
        r2 = 20;
    L5:
        this.maxCount = r2;
    }

    public boolean markProgress(long r7, long r9) {
        monitor-enter(this);
        Node r0 = this.head;     // Catch: Throwable -> L26
        if (r0 != null) goto L6;
    L20:
        Node r2 = obtainNode();     // Catch: Throwable -> L26
        r2.curBytes = r7;     // Catch: Throwable -> L26
        r2.when = r9;     // Catch: Throwable -> L26
        if (r0 == null) goto L23;
        r2.next = r0;     // Catch: Throwable -> L26
        r0.prev = r2;     // Catch: Throwable -> L26
    L23:
        this.head = r2;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return true;
    L6:
        if (r7 < r0.curBytes) goto L18;
        if (r9 < r0.when) goto L18;
        Node r3 = r0.next;     // Catch: Throwable -> L26
        if (r3 == null) goto L20;
        if ((r9 - r3.when) >= 1000) goto L20;
        r0.curBytes = r7;     // Catch: Throwable -> L26
        r0.when = r9;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return true;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L26
        return false;
    L26:
        th = move-exception;
        throw th;
    }

    public long getRecentDownloadSpeed(long r8, long r10) {
        monitor-enter(this);
        Node r0 = this.head;     // Catch: Throwable -> L20
        if (r0 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L7:
        Node r9 = findFirstNodeNearWhen(r8);     // Catch: Throwable -> L20
        if (r9 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L11:
        long r3 = r0.curBytes - r9.curBytes;     // Catch: Throwable -> L20
        long r11 = r10 - r9.when;     // Catch: Throwable -> L20
        if (r3 >= 0) goto L14;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L14:
        if (r11 <= 0) goto L18;
        long r4 = r3 / r11;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return r4;
    L20:
        th = move-exception;
        throw th;
    }

    private Node obtainNode() {
        int r0 = this.count;
        AnonymousClass1 r2 = null;
        if (r0 < this.maxCount) goto L10;
        Node r1 = this.tail;
        if (r1 == null) goto L10;
        Node r3 = r1.prev;
        r1.prev = null;
        this.tail = r3;
        if (r3 == null) goto L9;
        r3.next = null;
    L9:
        return r1;
    L10:
        this.count = r0 + 1;
        return new Node(r2);
    }

    private Node findFirstNodeNearWhen(long r7) {
        Node r6 = this.head;
        Node r0 = null;
    L3:
        if (r6 == null) goto L7;
        if (r6.when <= r7) goto L7;
        r0 = r6;
        r6 = r6.next;
    L7:
        if (r6 == null) goto L13;
        if (r0 == null) goto L13;
        if (r6 == r0) goto L13;
        if ((r7 - r6.when) >= (r0.when - r7)) goto L13;
        return r6;
    L13:
        return r0;
    }
}
