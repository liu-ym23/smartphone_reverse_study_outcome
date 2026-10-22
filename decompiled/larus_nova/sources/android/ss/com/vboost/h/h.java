package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f4660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f4661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f4662e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f4663a;

    public h(Context r100) {
        this.f4663a = null;
        c();
        Class<?> r101 = f4660c;     // Catch: Exception -> L7
        if (r101 == null) goto L16;
        this.f4663a = android.ss.com.vboost.utils.b.a(r101, new Class[]{Context.class}).newInstance(new Object[]{r100});     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        this.f4663a = android.ss.com.vboost.utils.b.a(f4660c, new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L10
        return;
    L10:
        LogUtil.error("BoostFramework", "BoostFramework() : Exception_3 = " + e);
    }

    private void c() {
        monitor-enter(h.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f4659b == false) goto L20;
    L13:
        monitor-exit(h.class);     // Catch: Throwable -> L15
        return;
    L20:
        LogUtil.debug("BoostFramework", "reflect android.util.BoostFramework class.");     // Catch: Exception -> L9 Throwable -> L15
        f4660c = android.ss.com.vboost.utils.b.a("android.util.BoostFramework");     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("BoostFramework", "reflect perfLockAcquire method.");     // Catch: Exception -> L9 Throwable -> L15
        f4661d = android.ss.com.vboost.utils.b.a(f4660c, "perfLockAcquire", new Class[]{Integer.TYPE, int[].class});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("BoostFramework", "reflect perfLockRelease method.");     // Catch: Exception -> L9 Throwable -> L15
        f4662e = android.ss.com.vboost.utils.b.a(f4660c, "perfLockRelease", new Class[0]);     // Catch: Exception -> L9 Throwable -> L15
        f4659b = true;     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.info("BoostFramework", "QcomBoostFramework is loaded.");     // Catch: Exception -> L9 Throwable -> L15
    L9:
        e = move-exception;
        f4659b = false;     // Catch: Throwable -> L15
        LogUtil.error("BoostFramework", "BoostFramework() : Exception_1 = " + e);     // Catch: Throwable -> L15
        goto L13
    }

    public int a(int r100, int... r110) {
        int r101 = -1;
        Method r102 = f4661d;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r101 = ((Integer) r102.invoke(this.f4663a, new Object[]{Integer.valueOf(r100), r110})).intValue();     // Catch: Exception -> L7
        LogUtil.info("BoostFramework", "invoke perfLockAcquire result " + r101 + " for " + r100 + " with " + Arrays.toString(r110));     // Catch: Exception -> L7
        return r101;
    L12:
        return -1;
    L7:
        e = move-exception;
        LogUtil.error("BoostFramework", "Exception " + e);
        return r101;
    }

    public boolean a() {
        return f4659b;
    }

    public int b() {
        int r100 = -1;
        Method r101 = f4662e;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        r100 = ((Integer) r101.invoke(this.f4663a, new Object[0])).intValue();     // Catch: Exception -> L7
        LogUtil.info("BoostFramework", "invoke perfLockRelease result " + r100);     // Catch: Exception -> L7
        return r100;
    L12:
        return -1;
    L7:
        e = move-exception;
        LogUtil.error("BoostFramework", "Exception " + e);
        return r100;
    }
}
