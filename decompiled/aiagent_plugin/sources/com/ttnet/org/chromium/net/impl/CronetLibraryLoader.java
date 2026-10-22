package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ttnet.org.chromium.net.NetworkChangeNotifier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class CronetLibraryLoader {
    private static final String TAG = "CronetLibraryLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37952a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f37953b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HandlerThread f37954c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f37955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f37956e;
    private static final ConditionVariable f = null;

    interface a {
        void a();

        String b();

        void c();
    }

    public CronetLibraryLoader() {
    }

    static {
        f37953b = new Object();
        f37954c = new HandlerThread("CronetInit");
        f37955d = false;
        f = new ConditionVariable();
    }

    public static void a(Context r6, CronetEngineBuilderImpl r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Object r0 = f37953b;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (f37956e == true) goto L11;
        com.ttnet.org.chromium.base.d.a(r8);     // Catch: Throwable -> L29
        HandlerThread r9 = f37954c;     // Catch: Throwable -> L29
        if (r9.isAlive() == true) goto L9;
        r9.start();     // Catch: Throwable -> L29
    L9:
        a(new AnonymousClass1());     // Catch: Throwable -> L29
    L11:
        if (f37955d == true) goto L27;
        aa.f38077a = System.nanoTime();     // Catch: Throwable -> L29
        a(r7);     // Catch: Throwable -> L29
        aa.f38078b = System.nanoTime();     // Catch: Throwable -> L29
        String r10 = ImplVersion.b();     // Catch: Throwable -> L29
        if (r7 == null) goto L22;
        if (r7.F() == false) goto L22;
        if (r10.equals("107.0.5273.2") == false) goto L20;
    L24:
        f37955d = true;     // Catch: Throwable -> L29
        f.open();     // Catch: Throwable -> L29
        goto L27
    L20:
        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", new Object[]{r10, "107.0.5273.2"}));     // Catch: Throwable -> L29
    L22:
        if (r10.equals(g.d().b()) == false) goto L26;
        com.ttnet.org.chromium.base.j.c(TAG, "Cronet version: %s, arch: %s", new Object[]{r10, System.getProperty("os.arch")});     // Catch: Throwable -> L29
        goto L24
    L26:
        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", new Object[]{r10, g.d().b()}));     // Catch: Throwable -> L29
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L29
    }

    private static void a(CronetEngineBuilderImpl r3) {
        String r0 = r3.w();
        if (TextUtils.isEmpty(r0) == true) goto L11;
        File r1 = new File(r0);
        if (r1.exists() == false) goto L11;
        if (r1.isDirectory() == true) goto L11;
        com.ttnet.org.chromium.base.j.c(TAG, "cronet so load: %s", new Object[]{r0});
        System.load(r0);
        return;
    L11:
        if (r3.f() == null) goto L13;
        r3.f().loadLibrary("sscronet");
        return;
    L13:
        System.loadLibrary("sscronet");
    }

    static void a() {
        g.d().c();
    }

    private static boolean c() {
        if (f37954c.getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    static void b() {
        boolean r0 = f37952a;
        if (r0 == true) goto L10;
        if (c() == true) goto L10;
        throw new AssertionError();
    L10:
        if (f37956e == false) goto L12;
        return;
    L12:
        aa.f38079c = System.nanoTime();
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.b();
        f.block();
        if (r0 == false) goto L15;
    L19:
        g.d().a();
        f37956e = true;
        aa.f38080d = System.nanoTime();
        return;
    L15:
        if (f37955d == true) goto L19;
        throw new AssertionError();
    }

    public static void a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (c() == false) goto L5;
        r3.run();
        return;
    L5:
        new Handler(f37954c.getLooper()).post(r3);
    }

    private static String getDefaultUserAgent() {
        return ai.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    private static void ensureInitializedFromNative() {
        Object r0 = f37953b;
        monitor-enter(r0);
        f37955d = true;     // Catch: Throwable -> L15
        f.open();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (f37952a == true) goto L13;
        if (r1 != null) goto L13;
        throw new AssertionError();
    L13:
        a(r1, null);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private static void setNetworkThreadPriorityOnNetworkThread(int r0) {
        Process.setThreadPriority(r0);
    }
}
