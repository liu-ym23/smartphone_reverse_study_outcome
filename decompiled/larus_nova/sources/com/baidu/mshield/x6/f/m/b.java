package com.baidu.mshield.x6.f.m;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes39.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f32625a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f32626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f32627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f32628d;

    public b() {
        this(5);
    }

    static {
        f32625a = new AtomicInteger(1);
    }

    public b(int r100) {
        this.f32626b = new AtomicInteger(1);
        this.f32627c = "fin-" + f32625a.getAndIncrement() + "-thread-";
        this.f32628d = r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.f32627c + this.f32626b.getAndIncrement());
        if (r101.isDaemon() == false) goto L5;
        r101.setDaemon(false);
    L5:
        int r102 = this.f32628d;
        if (r102 == 5) goto L8;
        ThreadMethodProxy.setPriority(r101, r102);
    L9:
        return r101;
    L8:
        ThreadMethodProxy.setPriority(r101, 5);
        goto L9
    }
}
