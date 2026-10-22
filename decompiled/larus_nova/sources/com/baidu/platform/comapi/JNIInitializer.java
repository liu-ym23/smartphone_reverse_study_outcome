package com.baidu.platform.comapi;

import android.app.Application;
import android.content.Context;
import com.baidu.platform.comapi.resource.ResourceList;
import com.baidu.platform.comapi.resource.b;
import com.baidu.vi.VIContext;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes39.dex */
public class JNIInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f32718a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f32719b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f32720c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f32721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f32722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CountDownLatch f32723f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f32724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f32725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f32726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f32727j;

    static {
        f32718a = new AtomicBoolean(false);
        f32719b = new AtomicBoolean(false);
        f32720c = new AtomicBoolean(false);
        f32723f = new CountDownLatch(1);
    }

    public static void destroy() {
        f32722e.a();
        f32718a.set(false);
    }

    public static void initEngine() {
    L2:
        AtomicBoolean r100 = f32718a;
        boolean r101 = r100.get();
        if (r101 == true) goto L4;
        if (r100.compareAndSet(r101, true) == false) goto L2;
        a r102 = new a();
        f32722e = r102;
        if (r102.a(f32721d) == true) goto L2;
        throw new RuntimeException("BDMapSDKException: engine init failed");
    }

    public static void initLongLink() {
    L2:
        AtomicBoolean r100 = f32719b;
        boolean r101 = r100.get();
        if (r101 == true) goto L4;
        if (r100.compareAndSet(r101, true) == false) goto L2;
        a r102 = f32722e;
        if (r102 == null) goto L15;
        if (r102.b(f32721d) == true) goto L2;
        throw new RuntimeException("longlink init failed");
    L15:
        throw new RuntimeException("engine must init first");
    }

    public static boolean isInited() {
        return f32718a.get();
    }

    public static boolean isResourceInited() {
        return f32720c.get();
    }

    public JNIInitializer() {
    }

    public static Context getCachedContext() {
        return f32721d;
    }

    public static CountDownLatch getResourceDoneLatch() {
        return f32723f;
    }

    public static boolean isBaseLineRelease() {
        return f32727j;
    }

    public static boolean isDebug() {
        return f32725h;
    }

    public static boolean isMainProcess() {
        return f32724g;
    }

    public static boolean isUserTest() {
        return f32726i;
    }

    public static void initEngineResource(ResourceList r100) {
    L2:
        AtomicBoolean r101 = f32720c;
        boolean r102 = r101.get();
        if (r102 == true) goto L4;
        if (r101.compareAndSet(r102, true) == false) goto L2;
        if (r100 != null) goto L14;
    L13:
        f32723f.countDown();
        goto L2
    L14:
        b.f33381a.a(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        f32723f.countDown();
        throw th;
    }

    public static void attach(Application r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        if (r100 == null) goto L9;
        f32724g = r101;
        f32725h = r102;
        f32726i = r103;
        f32727j = r104;
        if (f32721d != null) goto L6;
        f32721d = r100;
    L6:
        VIContext.init(r100);
        return;
    L9:
        throw new RuntimeException("BDMapSDKException: Application Context is null");
    }
}
