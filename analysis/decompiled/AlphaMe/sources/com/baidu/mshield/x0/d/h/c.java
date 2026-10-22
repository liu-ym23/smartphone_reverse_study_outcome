package com.baidu.mshield.x0.d.h;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f8395a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f8396b;

    /* renamed from: c, reason: collision with root package name */
    public String f8397c;

    /* renamed from: d, reason: collision with root package name */
    public int f8398d;

    public c() {
        this(5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f8397c + this.f8396b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i4 = this.f8398d;
        if (i4 != 5) {
            thread.setPriority(i4);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }

    public c(int i4) {
        this.f8396b = new AtomicInteger(1);
        this.f8397c = "sec-" + f8395a.getAndIncrement() + "-thread-";
        this.f8398d = i4;
    }
}
