package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes4.dex */
final class PendingPostQueue {
    private PendingPost head;
    private PendingPost tail;

    public PendingPostQueue() {
    }

    public synchronized void enqueue(PendingPost r10) {
        monitor-enter(this);
        if (r10 == null) goto L18;
        PendingPost r11 = this.tail;     // Catch: Throwable -> L7
        if (r11 == null) goto L10;
        r11.next = r10;     // Catch: Throwable -> L7
        this.tail = r10;     // Catch: Throwable -> L7
    L12:
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L10:
        if (this.head != null) goto L16;
        this.tail = r10;     // Catch: Throwable -> L7
        this.head = r10;     // Catch: Throwable -> L7
        goto L12
    L16:
        throw new IllegalStateException("Head present, but no tail");     // Catch: Throwable -> L7
    L18:
        throw new NullPointerException("null cannot be enqueued");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized PendingPost poll() {
        monitor-enter(this);
        PendingPost r10 = this.head;     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        PendingPost r11 = r10.next;     // Catch: Throwable -> L9
        this.head = r11;     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        this.tail = null;     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
        return r10;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized PendingPost poll(int r10) throws InterruptedException {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.head != null) goto L8;
        wait(r10);     // Catch: Throwable -> L6
    L8:
        PendingPost r11 = poll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    }
}
