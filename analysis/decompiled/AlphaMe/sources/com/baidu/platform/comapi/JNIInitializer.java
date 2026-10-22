package com.baidu.platform.comapi;

import android.app.Application;
import android.content.Context;
import com.baidu.platform.comapi.resource.ResourceList;
import com.baidu.platform.comapi.resource.b;
import com.baidu.vi.VIContext;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class JNIInitializer {

    /* renamed from: d, reason: collision with root package name */
    private static Context f8584d;

    /* renamed from: e, reason: collision with root package name */
    private static a f8585e;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f8587g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f8588h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f8589i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f8590j;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f8581a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f8582b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f8583c = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private static final CountDownLatch f8586f = new CountDownLatch(1);

    public static void attach(Application application, boolean z4, boolean z5, boolean z6, boolean z7) {
        if (application == null) {
            throw new RuntimeException("BDMapSDKException: Application Context is null");
        }
        f8587g = z4;
        f8588h = z5;
        f8589i = z6;
        f8590j = z7;
        if (f8584d == null) {
            f8584d = application;
        }
        VIContext.init(application);
    }

    public static void destroy() {
        f8585e.a();
        f8581a.set(false);
    }

    public static Context getCachedContext() {
        return f8584d;
    }

    public static CountDownLatch getResourceDoneLatch() {
        return f8586f;
    }

    public static void initEngine() {
        while (true) {
            AtomicBoolean atomicBoolean = f8581a;
            boolean z4 = atomicBoolean.get();
            if (z4) {
                return;
            }
            if (atomicBoolean.compareAndSet(z4, true)) {
                a aVar = new a();
                f8585e = aVar;
                if (!aVar.a(f8584d)) {
                    throw new RuntimeException("BDMapSDKException: engine init failed");
                }
            }
        }
    }

    public static void initEngineResource(ResourceList resourceList) {
        while (true) {
            AtomicBoolean atomicBoolean = f8583c;
            boolean z4 = atomicBoolean.get();
            if (z4) {
                return;
            }
            if (atomicBoolean.compareAndSet(z4, true)) {
                if (resourceList != null) {
                    try {
                        b.f9262a.a(resourceList);
                    } finally {
                        f8586f.countDown();
                    }
                }
            }
        }
    }

    public static void initLongLink() {
        while (true) {
            AtomicBoolean atomicBoolean = f8582b;
            boolean z4 = atomicBoolean.get();
            if (z4) {
                return;
            }
            if (atomicBoolean.compareAndSet(z4, true)) {
                a aVar = f8585e;
                if (aVar == null) {
                    throw new RuntimeException("engine must init first");
                }
                if (!aVar.b(f8584d)) {
                    throw new RuntimeException("longlink init failed");
                }
            }
        }
    }

    public static boolean isBaseLineRelease() {
        return f8590j;
    }

    public static boolean isDebug() {
        return f8588h;
    }

    public static boolean isInited() {
        return f8581a.get();
    }

    public static boolean isMainProcess() {
        return f8587g;
    }

    public static boolean isResourceInited() {
        return f8583c.get();
    }

    public static boolean isUserTest() {
        return f8589i;
    }
}
