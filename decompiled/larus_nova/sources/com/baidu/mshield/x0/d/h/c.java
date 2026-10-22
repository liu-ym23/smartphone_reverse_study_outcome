package com.baidu.mshield.x0.d.h;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes39.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f32494a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f32495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f32496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f32497d;

    public c() {
        this(5);
    }

    static {
        f32494a = new AtomicInteger(1);
    }

    public c(int r100) {
        this.f32495b = new AtomicInteger(1);
        this.f32496c = "sec-" + f32494a.getAndIncrement() + "-thread-";
        this.f32497d = r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.f32496c + this.f32495b.getAndIncrement());
        if (r101.isDaemon() == false) goto L5;
        r101.setDaemon(false);
    L5:
        int r102 = this.f32497d;
        if (r102 == 5) goto L8;
        ThreadMethodProxy.setPriority(r101, r102);
    L9:
        return r101;
    L8:
        ThreadMethodProxy.setPriority(r101, 5);
        goto L9
    }
}
