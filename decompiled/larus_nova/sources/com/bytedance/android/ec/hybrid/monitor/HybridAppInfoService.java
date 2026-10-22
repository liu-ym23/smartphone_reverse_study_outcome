package com.bytedance.android.ec.hybrid.monitor;

import android.app.Activity;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class HybridAppInfoService implements yj.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f47530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f47531b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f47532c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f47533d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f47534e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f47535f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f47536g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f47537h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f47538i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f47539j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f47540k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f47541l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f47542m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f47543n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f47544o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HybridAppInfoService f47545p = null;

    public HybridAppInfoService() {
    }

    public static yj.i g() {
        return (yj.i) f47530a.getValue();
    }

    @Override // yj.i
    public final void c() {
    }

    static {
        f47545p = new HybridAppInfoService();
        f47530a = LazyKt.lazy(HybridAppInfoService$proxy$2.INSTANCE);
        f47531b = LazyKt.lazy(HybridAppInfoService$_isHuoshan$2.INSTANCE);
        f47532c = LazyKt.lazy(HybridAppInfoService$_isDouyinAndDefault$2.INSTANCE);
        f47533d = LazyKt.lazy(HybridAppInfoService$_isDyLite$2.INSTANCE);
        f47534e = LazyKt.lazy(HybridAppInfoService$_isLegou$2.INSTANCE);
        f47535f = LazyKt.lazy(HybridAppInfoService$_isDouyin$2.INSTANCE);
        f47536g = LazyKt.lazy(HybridAppInfoService$_isSaas$2.INSTANCE);
        f47537h = LazyKt.lazy(HybridAppInfoService$_isTobSaas$2.INSTANCE);
        f47538i = LazyKt.lazy(HybridAppInfoService$_isToutiao$2.INSTANCE);
        f47539j = LazyKt.lazy(HybridAppInfoService$_isToutiaoLite$2.INSTANCE);
        f47540k = LazyKt.lazy(HybridAppInfoService$_isFanQieChangTing$2.INSTANCE);
        f47541l = LazyKt.lazy(HybridAppInfoService$_isFanQieXiaoShuo$2.INSTANCE);
        f47542m = LazyKt.lazy(HybridAppInfoService$_isFanQieShortSeries$2.INSTANCE);
        f47543n = LazyKt.lazy(HybridAppInfoService$_isXiGua$2.INSTANCE);
        f47544o = LazyKt.lazy(HybridAppInfoService$_isHongGuoManJu$2.INSTANCE);
    }

    public static boolean i() {
        return ((Boolean) f47532c.getValue()).booleanValue();
    }

    public static boolean j() {
        return ((Boolean) f47533d.getValue()).booleanValue();
    }

    public static boolean k() {
        return ((Boolean) f47531b.getValue()).booleanValue();
    }

    public static boolean l() {
        return ((Boolean) f47534e.getValue()).booleanValue();
    }

    public static boolean m() {
        return ((Boolean) f47536g.getValue()).booleanValue();
    }

    public static boolean n() {
        return ((Boolean) f47538i.getValue()).booleanValue();
    }

    public static boolean h() {
        if (i() == false) goto L5;
    L10:
        return true;
    L5:
        if (j() == true) goto L10;
        if (k() == true) goto L10;
        return false;
    }

    @Override // yj.i
    public final Activity a() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // yj.i
    public final boolean b() {
        yj.i r100 = g();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.b() != true) goto L7;
        return true;
    }

    @Override // yj.i
    public final boolean d() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.d();
    }

    @Override // yj.i
    public final boolean e() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.e();
    }

    @Override // yj.i
    public final Long f() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f();
    }

    @Override // yj.i
    public final String getAppId() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAppId();
    }

    @Override // yj.i
    public final String getAppName() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAppVersionName();
    }

    @Override // yj.i
    public final String getAppVersion() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAppVersion();
    }

    @Override // yj.i
    public final String getAppVersionName() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAppVersionName();
    }

    @Override // yj.i
    public final Context getApplicationContext() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getApplicationContext();
    }

    @Override // yj.i
    public final String getChannel() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getChannel();
    }

    @Override // yj.i
    public final Float getCurrentFontScale() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentFontScale();
    }

    @Override // yj.i
    public final String getServerDeviceId() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getServerDeviceId();
    }

    @Override // yj.i
    public final String getUpdateVersionCode() {
        yj.i r100 = g();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUpdateVersionCode();
    }

    @Override // yj.i
    public final boolean isDebug() {
        yj.i r100 = g();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isDebug() != true) goto L7;
        return true;
    }

    @Override // yj.i
    public final boolean isLocalTest() {
        yj.i r100 = g();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isLocalTest() != true) goto L7;
        return true;
    }

    @Override // yj.i
    public final boolean isNightMode() {
        yj.i r100 = g();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isNightMode() != true) goto L7;
        return true;
    }
}
