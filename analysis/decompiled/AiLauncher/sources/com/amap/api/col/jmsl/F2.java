package com.amap.api.col.jmsl;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class F2 implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f16083a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16084b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16085c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadGroup f16086d;

    static {
        new AtomicInteger(1);
    }

    public F2(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f16086d, runnable, this.f16084b + this.f16083a.getAndIncrement(), 0L);
        thread.setDaemon(this.f16085c);
        return thread;
    }

    public F2(String str, boolean z10) {
        String str2;
        this.f16083a = new AtomicInteger(1);
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str + "-thread-";
        }
        this.f16084b = str2;
        this.f16085c = z10;
        SecurityManager securityManager = System.getSecurityManager();
        this.f16086d = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
    }
}
