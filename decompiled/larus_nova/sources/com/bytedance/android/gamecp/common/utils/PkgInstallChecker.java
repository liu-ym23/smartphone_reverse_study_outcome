package com.bytedance.android.gamecp.common.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.LruCache;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class PkgInstallChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, r0> f57182a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f57183b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f57184c = null;

    public static boolean b() {
        return ((Boolean) f57184c.getValue()).booleanValue();
    }

    static {
        f57182a = new LruCache(30);
        f57183b = LazyKt.lazy(PkgInstallChecker$cacheValidTime$2.INSTANCE);
        f57184c = LazyKt.lazy(PkgInstallChecker$isUseCache$2.INSTANCE);
    }

    public static r0 a(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r100 = true;
        if (r111 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        PolarisFileWrapper r102 = null;
        if (r101 == false) goto L13;
        return null;
    L13:
        if (b() == false) goto L21;
        LruCache<String, r0> r103 = f57182a;
        r0 r104 = r103.get(r111);
        if (r104 == null) goto L21;
        if ((SystemClock.elapsedRealtime() - r104.f57276d) > ((Number) f57183b.getValue()).longValue()) goto L20;
        yr.c.a("PkgInstallChecker", "getPkgInstallInfo 使用缓存 Cache " + r104);
        return r104;
    L20:
        r103.remove(r111);
    L21:
        if (r111 != null) goto L23;
    L26:
        boolean r105 = true;
    L28:
        if (r105 == false) goto L77;
        yr.c.a("PkgInstallChecker", "pkg " + r111 + " is null");
        r0 r106 = new r0(0);
    L73:
        if (b() == false) goto L75;
        f57182a.put(r106.f57273a, r106);
    L75:
        yr.c.a("PkgInstallChecker", "getPkgInstallInfo isUseCache " + b() + ", 设置内存：" + r106);
        return r106;
    L77:
        PackageManager r107 = r110.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L70
        if (r107 == null) goto L33;
        PackageInfo r108 = r107.getPackageInfo(r111, 0);     // Catch: PackageManager.NameNotFoundException -> L70
    L35:
        if (r108 == null) goto L37;
        long r109 = r108.lastUpdateTime;     // Catch: PackageManager.NameNotFoundException -> L70
    L38:
        if (r108 == null) goto L40;
        int r112 = r108.versionCode;     // Catch: PackageManager.NameNotFoundException -> L70
    L42:
        if (r109 <= 0) goto L45;
        yr.c.a("PkgInstallChecker", "pkg " + r111 + ' ' + r109);     // Catch: PackageManager.NameNotFoundException -> L70
        r0 r113 = new r0(r111, true, r112, SystemClock.elapsedRealtime(), r109);     // Catch: PackageManager.NameNotFoundException -> L70
    L44:
        r106 = r113;
        goto L73
    L45:
        PackageManager r114 = r110.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L70
        if (r114 == null) goto L50;
        ApplicationInfo r115 = r114.getApplicationInfo(r111, 0);     // Catch: PackageManager.NameNotFoundException -> L70
        if (r115 == null) goto L50;
        String r116 = r115.sourceDir;     // Catch: PackageManager.NameNotFoundException -> L70
    L51:
        if (r116 != null) goto L53;
    L56:
        if (r100 == true) goto L65;
        PolarisFileWrapper r117 = new PolarisFileWrapper(r116);     // Catch: PackageManager.NameNotFoundException -> L70
        if (r117.exists() == false) goto L60;
        r102 = r117;
    L60:
        if (r102 == null) goto L62;
        long r118 = r102.lastModified();     // Catch: PackageManager.NameNotFoundException -> L70
    L63:
        r109 = r118;
        goto L65
    L62:
        r118 = 0;
    L65:
        if (r109 <= 0) goto L67;
        yr.c.a("PkgInstallChecker", "pkg " + r111 + " file modified time " + r109);     // Catch: PackageManager.NameNotFoundException -> L70
        r113 = new r0(r111, true, r112, SystemClock.elapsedRealtime(), r109);     // Catch: PackageManager.NameNotFoundException -> L70
        goto L44
    L67:
        if (r108 == null) goto L71;
        yr.c.a("PkgInstallChecker", "pkg " + r111 + " file firstInstallTime " + r108.firstInstallTime);     // Catch: PackageManager.NameNotFoundException -> L70
        r106 = new r0(r111, true, r112, SystemClock.elapsedRealtime(), r108.firstInstallTime);     // Catch: PackageManager.NameNotFoundException -> L70
    L71:
        r106 = new r0(r111, false, Integer.MIN_VALUE, SystemClock.elapsedRealtime(), 0);
        goto L73
    L53:
        if (r116.length() == 0) goto L56;
        r100 = false;
    L50:
        r116 = null;
        goto L51
    L40:
        r112 = 0;
        goto L42
    L37:
        r109 = 0;
        goto L38
    L33:
        r108 = null;
    L70:
        yr.c.a("PkgInstallChecker", "getPkgInstallTime pkg " + r111 + " is not Installed");
        goto L71
    L23:
        if (r111.length() == 0) goto L26;
        r105 = false;
        goto L28
    L5:
        if (r111.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
