package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
public class HandlerPoster extends Handler implements Poster {
    private final EventBus eventBus;
    private boolean handlerActive;
    private final int maxMillisInsideHandleMessage;
    private final PendingPostQueue queue;

    public HandlerPoster(EventBus r10, Looper r11, int r12) {
        super(r11);
        this.eventBus = r10;
        this.maxMillisInsideHandleMessage = r12;
        this.queue = new PendingPostQueue();
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription r10, Object r11) {
        PendingPost r12 = PendingPost.obtainPendingPost(r10, r11);
        monitor-enter(this);
        this.queue.enqueue(r12);     // Catch: Throwable -> L11
        if (this.handlerActive == true) goto L13;
        this.handlerActive = true;     // Catch: Throwable -> L11
        if (sendMessage(obtainMessage()) == true) goto L13;
        throw new EventBusException("Could not send handler message");     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler
    public void handleMessage(Message r10) {
        long r11 = SystemClock.uptimeMillis();     // Catch: Throwable -> L18
    L4:
        PendingPost r12 = this.queue.poll();     // Catch: Throwable -> L18
        if (r12 != null) goto L20;
        monitor-enter(this);     // Catch: Throwable -> L18
        r12 = this.queue.poll();     // Catch: Throwable -> L12
        if (r12 == null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L12
        goto L20
    L9:
        monitor-exit(this);     // Catch: Throwable -> L12
        this.handlerActive = false;
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L20:
        this.eventBus.invokeSubscriber(r12);     // Catch: Throwable -> L18
        if ((SystemClock.uptimeMillis() - r11) < this.maxMillisInsideHandleMessage) goto L4;
        if (sendMessage(obtainMessage()) == false) goto L27;
        this.handlerActive = true;
        return;
    L27:
        throw new EventBusException("Could not send handler message");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        this.handlerActive = false;
        throw th;
    }
}
