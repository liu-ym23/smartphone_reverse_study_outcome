package com.blankj.utilcode.util;

import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
final class ThreadUtils$LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {

    /* renamed from: a, reason: collision with root package name */
    public volatile g f2198a;
    public final int b = 0;

    public ThreadUtils$LinkedBlockingQueue4Util(int i) {
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final boolean offer(Runnable runnable) {
        if (this.b > size() || this.f2198a == null || this.f2198a.getPoolSize() >= this.f2198a.getMaximumPoolSize()) {
            return super.offer(runnable);
        }
        return false;
    }
}
