package com.obric.performance.power.monitor.utils;

import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ThreadNativeTid.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "TCpuReflect";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f37020a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f37021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f37022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f37023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f37024e = null;

    public static /* synthetic */ int lambda$fvomSg2dfg4KU4AJI9VnzmvHonM() {
        return c();
    }

    private b() {
    }

    static {
        f37020a = new b();
        f37024e = g.a($$Lambda$b$fvomSg2dfg4KU4AJI9VnzmvHonM.INSTANCE);
    }

    private final int b() {
        return ((Number) ZeusTransformUtils.preCheckCast(f37024e.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    private static final int c() {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        return 12;
    L5:
        return 16;
    }

    public final boolean a() {
        f37023d = a.a(Thread.class, "nativePeer");     // Catch: Throwable -> L9
        Class r2 = ZeusTransformUtils.forName("sun.misc.Unsafe", "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        f37021b = a.a(r2, "getUnsafe", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L9
        boolean r4 = true;
        Method r3 = a.a(r2, "getInt", new Class[]{Long.TYPE});     // Catch: Throwable -> L9
        f37022c = r3;     // Catch: Throwable -> L9
        if (f37021b == null) goto L11;
        if (r3 == null) goto L11;
        if (f37023d == null) goto L11;
    L12:
        if (r4 == false) goto L19;
        Thread r5 = Thread.currentThread();
        o.c(r5, "currentThread(...)");
        File r6 = new File("/proc/self/task/" + a(r5));
        if (r6.exists() == true) goto L16;
    L17:
        a(TAG, "native tid format error");
        return false;
    L16:
        if (r6.canRead() == false) goto L17;
    L19:
        return r4;
    L11:
        r4 = false;
    L9:
        th = move-exception;
        a(TAG, "reflect", th);
        goto L11
    }

    public final int a(Thread r9) {
        o.e(r9, "t");
        long r0 = b(r9);
        if (r0 == 0) goto L18;
        Method r10 = f37022c;     // Catch: Throwable -> L15
        Integer r3 = null;
        if (r10 == null) goto L7;
        Object r8 = r10.invoke(f37021b, new Object[]{Long.valueOf(r0 + ((long) b()))});     // Catch: Throwable -> L15
    L9:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L11;
        r3 = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
    L11:
        if (r3 == null) goto L19;
        return r3.intValue();
    L19:
        return 0;
    L7:
        r8 = null;
    L20:
        return 0;
    L18:
        return 0;
    }

    private final long b(Thread r4) {
        Field r3 = f37023d;
        if (r3 == null) goto L9;
        Object r5 = r3.get(r4);     // Catch: Throwable -> L6
        o.a(r5, "null cannot be cast to non-null type kotlin.Long");     // Catch: Throwable -> L6
        return ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.aiagent.plugin")).longValue();
    L10:
        return 0;
    L9:
        return 0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
