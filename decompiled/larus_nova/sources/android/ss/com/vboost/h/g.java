package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f4652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f4653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f4654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f4655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f4656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Method f4657h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f4658a;

    public g(Context r100) {
        this.f4658a = null;
        c();
        Class<?> r101 = f4652c;     // Catch: Exception -> L7
        if (r101 == null) goto L16;
        this.f4658a = android.ss.com.vboost.utils.b.a(r101, new Class[]{Context.class}).newInstance(new Object[]{r100});     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        this.f4658a = android.ss.com.vboost.utils.b.a(f4652c, new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L10
        return;
    L10:
        LogUtil.error("MTKPerfService", "MTKPerfService() : Exception_4 = " + e);
    }

    private void c() {
        monitor-enter(g.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f4651b == false) goto L18;
    L13:
        monitor-exit(g.class);     // Catch: Throwable -> L15
        return;
    L18:
        LogUtil.debug("MTKPerfService", "reflect com.mediatek.perfservice.PerfServiceWrapper class.");     // Catch: Exception -> L9 Throwable -> L15
        f4652c = android.ss.com.vboost.utils.b.a("com.mediatek.perfservice.PerfServiceWrapper");     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userGetCapability method.");     // Catch: Exception -> L9 Throwable -> L15
        Class r100 = Integer.TYPE;     // Catch: Exception -> L9 Throwable -> L15
        f4653d = android.ss.com.vboost.utils.b.a(f4652c, "userGetCapability", new Class[]{r100});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userRegScn method.");     // Catch: Exception -> L9 Throwable -> L15
        f4654e = android.ss.com.vboost.utils.b.a(f4652c, "userRegScn", new Class[0]);     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userRegScnConfig method.");     // Catch: Exception -> L9 Throwable -> L15
        f4655f = android.ss.com.vboost.utils.b.a(f4652c, "userRegScnConfig", new Class[]{r100, r100, r100, r100, r100, r100});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userEnable method.");     // Catch: Exception -> L9 Throwable -> L15
        android.ss.com.vboost.utils.b.a(f4652c, "userEnable", new Class[]{r100});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userEnableTimeoutMs method.");     // Catch: Exception -> L9 Throwable -> L15
        f4656g = android.ss.com.vboost.utils.b.a(f4652c, "userEnableTimeoutMs", new Class[]{r100, r100});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userDisable method.");     // Catch: Exception -> L9 Throwable -> L15
        f4657h = android.ss.com.vboost.utils.b.a(f4652c, "userDisable", new Class[]{r100});     // Catch: Exception -> L9 Throwable -> L15
        f4651b = true;     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.info("MTKPerfService", "MTKPerfService is loaded.");     // Catch: Exception -> L9 Throwable -> L15
    L9:
        e = move-exception;
        f4651b = false;     // Catch: Throwable -> L15
        LogUtil.error("MTKPerfService", "PerfService() : Exception_1 = " + e);     // Catch: Throwable -> L15
        goto L13
    }

    public void a(int r100) {
        Method r101 = f4657h;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        r101.invoke(this.f4658a, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L7
        LogUtil.info("MTKPerfService", "invoke userDisable with handle " + r100);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
    }

    public void a(int r100, int r101) {
        Method r102 = f4656g;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.invoke(this.f4658a, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)});     // Catch: Exception -> L7
        LogUtil.info("MTKPerfService", "invoke userEnableTimeoutMs with handle " + r100 + " and timeout " + r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
    }

    public void a(int r100, int r101, int r110, int r111, int r112, int r113) {
        Method r102 = f4655f;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.invoke(this.f4658a, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r112), Integer.valueOf(r113)});     // Catch: Exception -> L7
        LogUtil.info("MTKPerfService", "invoke userRegScnConfig with handle " + r100 + " and cmd " + r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
    }

    public boolean a() {
        return f4651b;
    }

    public int b() {
        Method r100 = f4654e;     // Catch: Exception -> L6
        if (r100 == null) goto L8;
        return ((Integer) r100.invoke(this.f4658a, new Object[0])).intValue();
    L8:
        return -1;
    L6:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
        goto L8
    }

    public int b(int r100) {
        Method r101 = f4653d;     // Catch: Exception -> L6
        if (r101 == null) goto L8;
        return ((Integer) r101.invoke(this.f4658a, new Object[]{Integer.valueOf(r100)})).intValue();
    L8:
        return -1;
    L6:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
        goto L8
    }
}
