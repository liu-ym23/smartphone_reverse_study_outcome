package com.ss.android.socialbase.downloader.segment;

/* JADX INFO: loaded from: classes4.dex */
class BufferQueue implements IBufferPool, IInput, IOutput {
    private static final int MIN_BUFFER_COUNT = 64;
    private static final int MIN_BUFFER_SIZE = 8192;
    private int bufferCount;
    private final int bufferSize;
    private volatile boolean closed;
    private final int maxBufferCount;
    private Buffer rHead;
    private final Object rLock;
    private Buffer rSafe;
    private Buffer rTail;
    private Buffer wHead;
    private final Object wLock;
    private Buffer wTail;

    BufferQueue(int r2, int r3) {
        this.wLock = new Object();
        this.rLock = new Object();
        if (r2 >= 64) goto L6;
        r2 = 64;
    L6:
        if (r3 >= 8192) goto L8;
        r3 = 8192;
    L8:
        this.maxBufferCount = r2;
        this.bufferSize = r3;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IInput
    public Buffer read() {
        Buffer r0 = this.rSafe;
        if (r0 == null) goto L6;
        this.rSafe = r0.next;
        r0.next = null;
        return r0;
    L6:
        Object r1 = this.rLock;
        monitor-enter(r1);
        Buffer r2 = this.rHead;     // Catch: Throwable -> L18
    L9:
        if (r2 != null) goto L15;
        if (this.closed == true) goto L14;
        this.rLock.wait();     // Catch: Throwable -> L18
        r2 = this.rHead;     // Catch: Throwable -> L18
        goto L9
    L14:
        throw new StreamClosedException("read");     // Catch: Throwable -> L18
    L15:
        this.rSafe = r2.next;     // Catch: Throwable -> L18
        this.rTail = null;     // Catch: Throwable -> L18
        this.rHead = null;     // Catch: Throwable -> L18
        r2.next = null;     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r2;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    public void recycle(Buffer r3) {
        Object r0 = this.wLock;
        monitor-enter(r0);
        Buffer r1 = this.wTail;     // Catch: Throwable -> L11
        if (r1 != null) goto L7;
        this.wTail = r3;     // Catch: Throwable -> L11
        this.wHead = r3;     // Catch: Throwable -> L11
    L8:
        this.wLock.notify();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r1.next = r3;     // Catch: Throwable -> L11
        this.wTail = r3;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    public Buffer obtain() {
        Object r0 = this.wLock;
        monitor-enter(r0);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == true) goto L27;
        Buffer r1 = this.wHead;     // Catch: Throwable -> L28
        if (r1 != null) goto L20;
        int r2 = this.bufferCount;     // Catch: Throwable -> L28
        if (r2 >= this.maxBufferCount) goto L13;
        this.bufferCount = r2 + 1;     // Catch: Throwable -> L28
        Buffer r3 = new Buffer(this.bufferSize);     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r3;
    L13:
        this.wLock.wait();     // Catch: Throwable -> L28
        if (this.closed == true) goto L19;
        r1 = this.wHead;     // Catch: Throwable -> L28
        if (r1 == null) goto L13;
    L19:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L28
    L20:
        this.wHead = r1.next;     // Catch: Throwable -> L28
        if (r1 != this.wTail) goto L23;
        this.wTail = null;     // Catch: Throwable -> L28
    L23:
        r1.next = null;     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r1;
    L27:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L28
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(Buffer r3) {
        Object r0 = this.rLock;
        monitor-enter(r0);
        Buffer r1 = this.rTail;     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        this.rTail = r3;     // Catch: Throwable -> L10
        this.rHead = r3;     // Catch: Throwable -> L10
        this.rLock.notify();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        r1.next = r3;     // Catch: Throwable -> L10
        this.rTail = r3;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void close() {
        this.closed = true;
        Object r0 = this.wLock;
        monitor-enter(r0);
        this.wLock.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        Object r1 = this.rLock;
        monitor-enter(r1);
        this.rLock.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }
}
