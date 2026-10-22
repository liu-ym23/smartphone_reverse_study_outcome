package android.ss.com.vboost.h;

import android.content.Context;
import android.os.Build;
import android.ss.com.vboost.utils.LogUtil;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f4625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f4626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f4627d;

    public a(Context r100) {
        b();
    L20:
        e = move-exception;
        LogUtil.error("CHRYBoostFramework", "CHRYBoostFramework() : Exception_2 = " + e);
        return;
    L4:
        if (f4625b == null) goto L25;
        int r101 = Build.VERSION.SDK_INT;     // Catch: Exception -> L20
        if (r101 != 29) goto L12;
        f4627d = android.ss.com.vboost.utils.b.a(f4625b, "getInstance", new Class[0]).invoke(f4625b, new Object[0]);     // Catch: Exception -> L20
        android.ss.com.vboost.utils.b.a(f4625b, "init", new Class[0]).invoke(f4627d, new Object[0]);     // Catch: Exception -> L20
    L18:
        f4624a = true;     // Catch: Exception -> L20
        return;
    L12:
        if (r101 != 28) goto L14;
    L17:
        f4627d = android.ss.com.vboost.utils.b.a(f4625b, "getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L20
        goto L18
    L14:
        if (r101 == 27) goto L17;
        if (r101 == 26) goto L17;
        return;
    }

    private void b() {
        monitor-enter(a.class);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (f4624a == false) goto L30;
    L22:
        monitor-exit(a.class);     // Catch: Throwable -> L24
        return;
    L30:
        int r100 = Build.VERSION.SDK_INT;     // Catch: Exception -> L19 Throwable -> L24
        if (r100 != 29) goto L10;
        Class<?> r101 = android.ss.com.vboost.utils.b.a("android.scrollerboostmanager.ScrollerBoostManager");     // Catch: Exception -> L19 Throwable -> L24
        f4625b = r101;     // Catch: Exception -> L19 Throwable -> L24
        f4626c = android.ss.com.vboost.utils.b.a(r101, "listFling", new Class[]{Integer.TYPE});     // Catch: Exception -> L19 Throwable -> L24
    L29:
    L10:
        if (r100 != 28) goto L12;
    L15:
        Class<?> r102 = android.ss.com.vboost.utils.b.a("android.iawareperf.UniPerf");     // Catch: Exception -> L19 Throwable -> L24
        f4625b = r102;     // Catch: Exception -> L19 Throwable -> L24
        f4626c = android.ss.com.vboost.utils.b.a(r102, "uniPerfEvent", new Class[]{Integer.TYPE, String.class, int[].class});     // Catch: Exception -> L19 Throwable -> L24
        LogUtil.info("CHRYBoostFramework", "CHRYBoostFramework is loaded.");     // Catch: Exception -> L19 Throwable -> L24
        goto L29
    L12:
        if (r100 == 27) goto L15;
        if (r100 != 26) goto L29;
    L19:
        e = move-exception;
        LogUtil.error("CHRYBoostFramework", "CHRYBoostFramework() : Exception_1 = " + e);     // Catch: Throwable -> L24
        goto L22
    }

    public int a(long r110) {
        int r100 = -1;
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L19
        if (r101 != 29) goto L7;
        f4626c.invoke(f4627d, new Object[]{Integer.valueOf((int) r110)});     // Catch: Throwable -> L19
        String r111 = "invoke listFling result  for " + r110;     // Catch: Throwable -> L19
    L15:
        LogUtil.info("CHRYBoostFramework", r111);     // Catch: Throwable -> L19
    L21:
        return r100;
    L7:
        if (r101 != 28) goto L9;
    L12:
        int r102 = ((Integer) f4626c.invoke(f4627d, new Object[]{4099, "canBoost=true|screenOn=1", new int[0]})).intValue();     // Catch: Throwable -> L19
        r111 = "invoke uniPerfEvent result " + r102 + " for " + r110;     // Catch: Throwable -> L17
        r100 = r102;
    L17:
        th = th;
        r100 = r102;
    L20:
        LogUtil.warn("cpuboost boost fail:", th.getMessage());
        goto L21
    L9:
        if (r101 == 27) goto L12;
        if (r101 != 26) goto L21;
    L19:
        th = th;
        goto L20
    }

    public boolean a() {
        return f4624a;
    }
}
