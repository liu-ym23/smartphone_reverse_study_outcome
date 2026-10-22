package com.baidu.mshield.x6.f.m;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f8526a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f8527b;

    /* renamed from: c, reason: collision with root package name */
    public String f8528c;

    /* renamed from: d, reason: collision with root package name */
    public int f8529d;

    public b() {
        this(5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f8528c + this.f8527b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i4 = this.f8529d;
        if (i4 != 5) {
            thread.setPriority(i4);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }

    public b(int i4) {
        this.f8527b = new AtomicInteger(1);
        this.f8528c = "fin-" + f8526a.getAndIncrement() + "-thread-";
        this.f8529d = i4;
    }
}
