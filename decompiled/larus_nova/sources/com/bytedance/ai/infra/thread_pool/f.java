package com.bytedance.ai.infra.thread_pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f36611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f36612b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f36613c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f36614d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f36615e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f36616f = null;

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        c5.b r101 = new c5.b("APPLET-IO");
        TimeUnit r110 = TimeUnit.SECONDS;
        SynchronousQueue r102 = new SynchronousQueue();
        ThreadPriority r111 = ThreadPriority.NORMAL;
        f36611a = new e(0, 128, r110, r102, new d("APPLET-IO", r111), r101);
        int r112 = (r100 * 2) + 1;
        int r113 = Math.max(Math.min(r112, 4), Math.min(r100 + 1, 9));
        c5.b r103 = new c5.b("APPLET-CALC");
        e r104 = new e(r113, r112, r110, new LinkedBlockingQueue(256), new d("APPLET-CALC", r111), r103);
        r104.allowCoreThreadTimeOut(true);
        f36612b = r104;
        e r105 = new e(4, 4, 15, r110, new LinkedBlockingQueue(256), new d("APPLET-BACKGROUND", ThreadPriority.LOW));
        r105.allowCoreThreadTimeOut(true);
        f36613c = r105;
        e r106 = new e(1, 1, 30, r110, new LinkedBlockingQueue(), new d("APPLET-SERIAL", r111));
        r106.allowCoreThreadTimeOut(true);
        f36614d = r106;
        f36615e = new c(new d("APPLET-SCHEDULE", r111));
        e r107 = new e(4, 4, 30, r110, new LinkedBlockingQueue(), new d("APPLET-SAFEGUARD", r111));
        r107.allowCoreThreadTimeOut(true);
        f36616f = r107;
    }
}
