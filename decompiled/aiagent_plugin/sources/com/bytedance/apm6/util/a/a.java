package com.bytedance.apm6.util.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: LimitedQueue.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentLinkedQueue<T> f5457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0133a<T> f5458c;

    /* JADX INFO: renamed from: com.bytedance.apm6.util.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LimitedQueue.java */
    public interface InterfaceC0133a<T> {
        void a(T r1);
    }

    public a(int r2) {
        this.f5457b = new ConcurrentLinkedQueue();
        this.f5456a = r2;
    }

    public void a(InterfaceC0133a<T> r3) {
        this.f5458c = (InterfaceC0133a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0133a.class, "com.obric.aiagent.plugin");
    }

    public void a(T r2) {
        this.f5457b.add(r2);
        if (this.f5457b.size() <= this.f5456a) goto L8;
        T r3 = this.f5457b.poll();
        InterfaceC0133a<T> r1 = this.f5458c;
        if (r1 == null) goto L9;
        r1.a(r3);
        return;
    L9:
        return;
    }

    public T a() {
        return this.f5457b.poll();
    }

    public boolean b() {
        return this.f5457b.isEmpty();
    }
}
