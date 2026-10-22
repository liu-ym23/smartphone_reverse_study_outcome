package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
final class BackgroundPoster implements Runnable, Poster {
    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final PendingPostQueue queue;

    public BackgroundPoster(EventBus r10) {
        this.eventBus = r10;
        this.queue = new PendingPostQueue();
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription r10, Object r11) {
        PendingPost r12 = PendingPost.obtainPendingPost(r10, r11);
        monitor-enter(this);
        this.queue.enqueue(r12);     // Catch: Throwable -> L7
        if (this.executorRunning == true) goto L9;
        this.executorRunning = true;     // Catch: Throwable -> L7
        this.eventBus.getExecutorService().execute(this);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
    L29:
        PendingPost r10 = this.queue.poll(1000);     // Catch: Throwable -> L18 InterruptedException -> L20
        if (r10 != null) goto L22;
        monitor-enter(this);     // Catch: Throwable -> L18 InterruptedException -> L20
        r10 = this.queue.poll();     // Catch: Throwable -> L12
        if (r10 == null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L12
        goto L22
    L8:
        this.executorRunning = false;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        this.executorRunning = false;
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18 InterruptedException -> L20
    L22:
        this.eventBus.invokeSubscriber(r10);     // Catch: Throwable -> L18 InterruptedException -> L20
    L18:
        th = move-exception;
        this.executorRunning = false;
        throw th;
    L20:
        e = move-exception;
        this.eventBus.getLogger().log(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);     // Catch: Throwable -> L18
        this.executorRunning = false;
    }
}
