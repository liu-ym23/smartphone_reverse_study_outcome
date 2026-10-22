package com.tmall.wireless.tangram.eventbus;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes4.dex */
class AsyncDispatcher extends Thread implements IDispatcher {
    private final Object LOCK;
    private final int STATE_DISPATCHING;
    private final int STATE_IDLE;
    private final int STATE_INIT;
    private final int STATE_SHUTDOWN;
    private final int STATE_STARTED;
    private volatile boolean isRunning;
    private IDispatcherDelegate mDispatcherDelegate;
    private ConcurrentLinkedQueue<Event> queue;
    private volatile int status;

    public AsyncDispatcher(IDispatcherDelegate r10) {
        super("Tangram-Dispatcher");
        this.STATE_INIT = 0;
        this.STATE_STARTED = 1;
        this.STATE_IDLE = 2;
        this.STATE_DISPATCHING = 3;
        this.STATE_SHUTDOWN = 4;
        this.LOCK = new Object();
        this.mDispatcherDelegate = r10;
        this.status = 0;
        this.queue = new ConcurrentLinkedQueue();
    }

    @Override // com.tmall.wireless.tangram.eventbus.IDispatcher
    public boolean enqueue(@NonNull List<Event> r10) {
        if (this.status != 4) goto L9;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        EventPool.sharedInstance().release(r10.get(r12));
        r12 = r12 + 1;
        goto L5
    L7:
        r10.clear();
        return false;
    L9:
        boolean r13 = this.queue.addAll(r10);
        Object r14 = this.LOCK;
        monitor-enter(r14);
        this.LOCK.notify();     // Catch: Throwable -> L14
        monitor-exit(r14);     // Catch: Throwable -> L14
        return r13;
    L14:
        th = move-exception;
        throw th;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        this.status = 1;
    L4:
        if (this.isRunning == false) goto L23;
        if (this.queue.isEmpty() == false) goto L17;
        this.status = 2;
        Object r10 = this.LOCK;
        monitor-enter(r10);
        this.LOCK.wait();     // Catch: Throwable -> L11 InterruptedException -> L24
    L11:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L17:
        Event r11 = this.queue.poll();
        if (r11 == null) goto L4;
        this.status = 3;
        IDispatcherDelegate r12 = this.mDispatcherDelegate;
        if (r12 == null) goto L22;
        r12.dispatch(r11);
    L22:
        EventPool.sharedInstance().release(r11);
        goto L4
    }

    @Override // java.lang.Thread, com.tmall.wireless.tangram.eventbus.IDispatcher
    public synchronized void start() {
        monitor-enter(this);
        super.start();     // Catch: Throwable -> L6
        this.isRunning = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.tmall.wireless.tangram.eventbus.IDispatcher
    public void stopSelf() {
        this.isRunning = false;
        this.status = 4;
        interrupt();
    L4:
        if (this.queue.isEmpty() == true) goto L6;
        Event r10 = this.queue.poll();
        EventPool.sharedInstance().release(r10);
        goto L4
    L6:
        this.queue.clear();
    }

    @Override // com.tmall.wireless.tangram.eventbus.IDispatcher
    public boolean enqueue(@NonNull Event r10) {
        if (this.status != 4) goto L6;
        EventPool.sharedInstance().release(r10);
        return false;
    L6:
        boolean r11 = this.queue.offer(r10);
        Object r12 = this.LOCK;
        monitor-enter(r12);
        this.LOCK.notify();     // Catch: Throwable -> L11
        monitor-exit(r12);     // Catch: Throwable -> L11
        return r11;
    L11:
        th = move-exception;
        throw th;
    }
}
