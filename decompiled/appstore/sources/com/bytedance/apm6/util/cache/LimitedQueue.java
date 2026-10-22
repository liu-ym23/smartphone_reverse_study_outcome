package com.bytedance.apm6.util.cache;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class LimitedQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentLinkedQueue f6822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EvictListener f6823c;

    public interface EvictListener<T> {
        void onEvict(T r10);
    }

    public LimitedQueue(int r10) {
        this.f6822b = new ConcurrentLinkedQueue();
        this.f6821a = r10;
    }

    public boolean a() {
        return this.f6822b.isEmpty();
    }

    public Object b() {
        return this.f6822b.poll();
    }

    public void c(Object r10) {
        this.f6822b.add(r10);
        if (this.f6822b.size() <= this.f6821a) goto L8;
        Object r11 = this.f6822b.poll();
        EvictListener r12 = this.f6823c;
        if (r12 == null) goto L9;
        r12.onEvict(r11);
        return;
    L9:
        return;
    }

    public void d(EvictListener r10) {
        this.f6823c = r10;
    }
}
