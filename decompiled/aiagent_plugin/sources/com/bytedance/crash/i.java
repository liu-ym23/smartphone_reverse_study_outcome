package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.crash.jni.NativeBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: Global.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile i f7507a = null;
    private static String i = "default";
    private static volatile boolean j;
    private static String k;
    private static n l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f7509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Application f7510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7511e;
    private long f;
    private final long g;
    private int h;

    static {
    }

    private static i k() {
        if (f7507a != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7507a != null) goto L9;
        f7507a = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f7507a;
    }

    private i() {
        this.f7511e = System.currentTimeMillis();
        this.g = SystemClock.uptimeMillis();
        this.f = SystemClock.elapsedRealtime();
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.f7511e -= this.f - Process.getStartElapsedRealtime();
        return;
    }

    public static String a() {
        return i;
    }

    static void a(String r0) {
        i = r0;
    }

    public static boolean b() {
        return j;
    }

    public static void a(boolean r0) {
        j = r0;
    }

    public static Context getContext() {
        return k().f7508b;
    }

    public static Application c() {
        return k().f7510d;
    }

    public static File d() {
        return k().f7509c;
    }

    public static File a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        File r0 = d();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return com.bytedance.crash.o.i.a(r3.getFilesDir(), "npth");
    }

    public static String e() {
        File r0 = new File(d(), "configs");
        if (r0.exists() == true) goto L6;
        com.bytedance.crash.o.i.b(r0);
    L6:
        return r0.getAbsolutePath();
    }

    public static long f() {
        return k().f7511e;
    }

    public static long g() {
        return k().f;
    }

    public static void a(Long r5) {
        i r0 = k();
        if (r5.longValue() >= k().f7511e) goto L5;
        long r1 = r5.longValue();
    L6:
        r0.f7511e = r1;
        return;
    L5:
        r1 = k().f7511e;
        goto L6
    }

    public static long h() {
        return k().g;
    }

    public static void b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        k().c(r3);
        return;
    L7:
        throw new IllegalArgumentException("Context cannot be null");
    }

    private void c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d(r4);
        if (this.f7508b != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f7508b != null) goto L8;
        this.f7508b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        if (this.f7509c != null) goto L24;
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L17:
        if (this.f7509c != null) goto L19;
        this.f7509c = com.bytedance.crash.o.i.a(r4.getFilesDir(), "npth");     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    }

    private void d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.f7510d == null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Application.class) == false) goto L7;
        this.f7510d = (Application) ZeusTransformUtils.preCheckCast(r4, Application.class, "com.obric.aiagent.plugin");
        return;
    L7:
        this.f7510d = (Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    public static void a(Application r2) {
        Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (k().f7510d != null) goto L9;
        k().f7510d = r3;
        return;
    }

    public static void a(long r1, long r3, long r5, String r7) {
        if (k != null) goto L8;
        String r2 = com.bytedance.crash.dumper.a.a(r1, r3, r5, r7);
        k = r2;
        if (r2 == null) goto L9;
        NativeBridge.l(r2);
        return;
    L9:
        return;
    }

    public static String i() {
        return k;
    }

    public static void a(int r1) {
        k().h = r1;
    }

    public static void a(n r2) {
        l = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.aiagent.plugin");
    }

    public static n j() {
        return l;
    }
}
