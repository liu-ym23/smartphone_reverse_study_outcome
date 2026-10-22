package com.jeffmony.async;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Semaphore f10391a;

    public a() {
        this.f10391a = new Semaphore(0);
    }

    public void a() {
        ThreadQueue r10 = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        a r11 = r10.waiter;
        r10.waiter = this;
        Semaphore r12 = r10.queueSemaphore;
    L13:
        th = move-exception;
        r10.waiter = r11;
        throw th;
    L4:
        if (this.f10391a.tryAcquire() == false) goto L7;
        r10.waiter = r11;
        return;
    L7:
        Runnable r13 = r10.remove();     // Catch: Throwable -> L13
        if (r13 == null) goto L9;
        r13.run();     // Catch: Throwable -> L13
        goto L7
    L9:
        r12.acquire(Math.max(1, r12.availablePermits()));     // Catch: Throwable -> L13
        if (this.f10391a.tryAcquire() == false) goto L7;
        r10.waiter = r11;
    }

    public void b() {
        this.f10391a.release();
        ThreadQueue.release(this);
    }

    public boolean c(long r10, TimeUnit r12) {
        long r11 = TimeUnit.MILLISECONDS.convert(r10, r12);
        ThreadQueue r13 = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        a r14 = r13.waiter;
        r13.waiter = this;
        Semaphore r15 = r13.queueSemaphore;
    L25:
        th = move-exception;
        r13.waiter = r14;
        throw th;
    L5:
        if (this.f10391a.tryAcquire() == false) goto L8;
        r13.waiter = r14;
        return true;
    L8:
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L25
    L9:
        Runnable r17 = r13.remove();     // Catch: Throwable -> L25
        if (r17 == null) goto L13;
        r17.run();     // Catch: Throwable -> L25
        goto L9
    L13:
        if (r15.tryAcquire(Math.max(1, r15.availablePermits()), r11, TimeUnit.MILLISECONDS) == false) goto L14;
        if (this.f10391a.tryAcquire() == true) goto L18;
        if ((System.currentTimeMillis() - r16) < r11) goto L9;
        r13.waiter = r14;
        return false;
    L18:
        r13.waiter = r14;
        return true;
    L14:
        r13.waiter = r14;
        return false;
    }
}
