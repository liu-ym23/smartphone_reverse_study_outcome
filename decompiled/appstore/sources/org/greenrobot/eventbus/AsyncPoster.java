package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes4.dex */
class AsyncPoster implements Runnable, Poster {
    private final EventBus eventBus;
    private final PendingPostQueue queue;

    public AsyncPoster(EventBus r10) {
        this.eventBus = r10;
        this.queue = new PendingPostQueue();
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription r10, Object r11) {
        PendingPost r12 = PendingPost.obtainPendingPost(r10, r11);
        this.queue.enqueue(r12);
        this.eventBus.getExecutorService().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        PendingPost r10 = this.queue.poll();
        if (r10 == null) goto L7;
        this.eventBus.invokeSubscriber(r10);
        return;
    L7:
        throw new IllegalStateException("No pending post available");
    }
}
