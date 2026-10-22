package com.bytedance.apm6.monitor;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: compiled from: Monitor.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<c> f5430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<d> f5431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BlockingQueue<b> f5432c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f5433d;

    static /* synthetic */ BlockingQueue a() {
        return f5432c;
    }

    static /* synthetic */ List b() {
        return f5431b;
    }

    static /* synthetic */ List c() {
        return f5430a;
    }

    static {
        f5430a = new CopyOnWriteArrayList();
        f5431b = new CopyOnWriteArrayList();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        f5432c = new LinkedTransferQueue();
    L6:
        f5433d = false;
        return;
    L5:
        f5432c = new LinkedBlockingQueue();
        goto L6
    }

    public static void a(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        if (f5430a.contains(r3) == true) goto L6;
        f5430a.add(r3);
        return;
    }

    public static void a(d r2) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (f5431b.contains(r3) == true) goto L9;
        f5431b.add(r3);
        return;
    }

    public static void a(b r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        f5432c.offer(r3);
        if (f5433d == true) goto L9;
        d();
        return;
    }

    private static synchronized void d() {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f5433d == false) goto L9;
        monitor-exit(a.class);
        return;
    L9:
        f5433d = true;     // Catch: Throwable -> L12
        new Thread(new AnonymousClass1(), "APM-Monitor").start();     // Catch: Throwable -> L12
        monitor-exit(a.class);
    }
}
