package com.bytedance.frameworks.baselib.network.http.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CookieInitializer.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "CookieInitializer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f8140a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f8141b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f8142c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CountDownLatch f8143d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f8144e = null;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CookieInitializer.java */
    public interface InterfaceC0182a {
        void a();

        void a(String r1, String r2, JSONObject r3);

        void a(boolean r1);

        ArrayList<String> b();
    }

    public static /* synthetic */ void lambda$K5RqfPC8v024MotfzFRC6ZCBWVs(Context r0, boolean r1, InterfaceC0182a r2) {
        c(r0, r1, r2);
    }

    public a() {
    }

    static {
        f8141b = new Object();
        f8142c = new AtomicBoolean(false);
        f8143d = new CountDownLatch(1);
        f8144e = new AtomicBoolean(false);
    }

    public static void a() {
        f8144e.set(true);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "setForceDisableWebViewCookieMgr");
        return;
    }

    public static void a(Context r2, boolean r3, boolean r4, InterfaceC0182a r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        InterfaceC0182a r7 = (InterfaceC0182a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0182a.class, "com.obric.aiagent.plugin");
        if (f8140a == true) goto L8;
        if (r7 != null) goto L8;
        throw new AssertionError();
    L8:
        if (r3 == true) goto L10;
        if (r4 == false) goto L15;
        a(r6, false, r7);
        return;
    L15:
        a(r7);
        return;
    L10:
        if (com.bytedance.frameworks.baselib.network.b.b.i() == false) goto L12;
        b(r6, true, r7);
        return;
    L12:
        a(r6, true, r7);
    }

    public static CookieManager b() {
        Object r0 = f8141b;
        monitor-enter(r0);
        CountDownLatch r1 = f8143d;     // Catch: Throwable -> L6 Exception -> L20
        r1.await(5000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L6 Exception -> L20
        r1.countDown();     // Catch: Throwable -> L6 Exception -> L20
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L6
        CookieManager r2 = null;
        if (f8142c.get() == false) goto L13;
        return null;
    L13:
        if (f8144e.get() == false) goto L24;
    L17:
        return r2;
    L24:
        r2 = CookieManager.getInstance();     // Catch: Throwable -> L21
        if (r2.acceptCookie() == true) goto L17;
        r2.setAcceptCookie(true);     // Catch: Throwable -> L21
        goto L17
    }

    public static boolean a(Object r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (ZeusTransformUtils.instanceOf(r2, com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L8;
        if (((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r2, com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin")).w == false) goto L8;
        return true;
    }

    private static void a(CookieHandler r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (f8142c.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "CookieInitV2 set cookieHandler:" + r4);
    L15:
        CookieHandler.setDefault(r4);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        f8142c.set(false);
        Logger.e(TAG, "CookieInitV2 set cookieHandler error", e);
    }

    @Deprecated
    private static void a(Context r4, final boolean r5, InterfaceC0182a r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        final InterfaceC0182a r8 = (InterfaceC0182a) ZeusTransformUtils.wrapperContextForParams(r6, InterfaceC0182a.class, "com.obric.aiagent.plugin");
    L13:
        th = move-exception;
        th.printStackTrace();
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(r7) == true) goto L17;
    L19:
        r8.a(r5);
        return;
    L17:
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L19;
        new Handler(Looper.getMainLooper()).post(new $$Lambda$a$K5RqfPC8v024MotfzFRC6ZCBWVs(r7, r5, r8));
        a(th.getMessage(), r8);
        goto L19
    L4:
        if (com.bytedance.frameworks.baselib.network.c.c().j != 0) goto L6;
        com.bytedance.frameworks.baselib.network.c.c().j = System.nanoTime();     // Catch: Throwable -> L13
    L6:
        CookieManager r0 = null;
        if (f8144e.get() == true) goto L9;
        CookieSyncManager.createInstance(r7);     // Catch: Throwable -> L13
        r0 = CookieManager.getInstance();     // Catch: Throwable -> L13
        r0.setAcceptCookie(true);     // Catch: Throwable -> L13
    L9:
        a(r7, r8);     // Catch: Throwable -> L13
        if (Logger.debug() == false) goto L19;
        Logger.d("Process", " CookieManager = " + r0 + " pid = " + Process.myPid());     // Catch: Throwable -> L13
        goto L19
    }

    private static /* synthetic */ void c(Context r2, boolean r3, InterfaceC0182a r4) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, (InterfaceC0182a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0182a.class, "com.obric.aiagent.plugin"));
    }

    @Deprecated
    private static void a(Context r4, InterfaceC0182a r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        final InterfaceC0182a r7 = (InterfaceC0182a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0182a.class, "com.obric.aiagent.plugin");
    L21:
        th = move-exception;
        a(th.getMessage(), r7);
        th.printStackTrace();
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(CookieHandler.getDefault(), com.bytedance.frameworks.baselib.network.http.d.d.class) == false) goto L8;
        a(r7);     // Catch: Throwable -> L21
        return;
    L8:
        if (com.bytedance.frameworks.baselib.network.c.c().j != 0) goto L10;
        com.bytedance.frameworks.baselib.network.c r0 = com.bytedance.frameworks.baselib.network.c.c();     // Catch: Throwable -> L21
        r0.j = System.nanoTime();     // Catch: Throwable -> L21
    L10:
        CookieManager r1 = null;
        boolean r2 = f8144e.get();     // Catch: Throwable -> L21
        if (r2 == false) goto L25;
    L16:
        if (r2 == false) goto L18;
        com.bytedance.frameworks.baselib.network.http.d.d.a r3 = com.bytedance.frameworks.baselib.network.http.d.d.a.f8285c;     // Catch: Throwable -> L21
    L19:
        CookieHandler.setDefault(new com.bytedance.frameworks.baselib.network.http.d.d(r6, r1, r3, new AnonymousClass1(r7)));     // Catch: Throwable -> L21
        a(r7);     // Catch: Throwable -> L21
        com.bytedance.frameworks.baselib.network.c r8 = com.bytedance.frameworks.baselib.network.c.c();     // Catch: Throwable -> L21
        r8.k = System.nanoTime();     // Catch: Throwable -> L21
        return;
    L18:
        r3 = com.bytedance.frameworks.baselib.network.http.d.d.a.f8283a;     // Catch: Throwable -> L21
        goto L19
    L25:
        r1 = CookieManager.getInstance();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a(th.getMessage(), r7);     // Catch: Throwable -> L21
        goto L16
    }

    private static void b(Context r5, boolean r6, InterfaceC0182a r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        final InterfaceC0182a r9 = (InterfaceC0182a) ZeusTransformUtils.wrapperContextForParams(r7, InterfaceC0182a.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "cookieInitV2 start isMain:" + r6);
    L5:
        com.bytedance.frameworks.baselib.network.c.c().j = System.nanoTime();
    L12:
        th = move-exception;
        Logger.d(TAG, "cookieInitV2 failed", th);
        a(th.getMessage(), r9);
    L14:
        com.bytedance.frameworks.baselib.network.c.c().k = System.nanoTime();
        a(r9);
        r9.a(r6);
        return;
    L7:
        if (f8144e.get() == false) goto L9;
        com.bytedance.frameworks.baselib.network.http.d.d.a r0 = com.bytedance.frameworks.baselib.network.http.d.d.a.f8285c;     // Catch: Throwable -> L12
    L10:
        a(new com.bytedance.frameworks.baselib.network.http.d.d(r8, null, r0, new AnonymousClass2(r9)));     // Catch: Throwable -> L12
        goto L14
    L9:
        r0 = com.bytedance.frameworks.baselib.network.http.d.d.a.f8284b;     // Catch: Throwable -> L12
        goto L10
    }

    private static void a(InterfaceC0182a r2) {
        InterfaceC0182a r3 = (InterfaceC0182a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0182a.class, "com.obric.aiagent.plugin");
        f8143d.countDown();
        r3.a();
    }

    private static void a(String r3, InterfaceC0182a r4) {
        InterfaceC0182a r5 = (InterfaceC0182a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0182a.class, "com.obric.aiagent.plugin");
        if (com.bytedance.frameworks.baselib.network.b.b.e() == true) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("init", "failed");     // Catch: JSONException -> L8
        r1.put("exception", r3);     // Catch: JSONException -> L8
    L10:
        r5.a("TTNET-COOKIE", "init", r1);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
