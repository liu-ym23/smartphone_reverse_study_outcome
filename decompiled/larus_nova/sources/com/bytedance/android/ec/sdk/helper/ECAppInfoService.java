package com.bytedance.android.ec.sdk.helper;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class ECAppInfoService implements vi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f48110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f48111b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f48112c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f48113d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ECAppInfoService f48114e = null;

    public ECAppInfoService() {
    }

    static {
        f48114e = new ECAppInfoService();
        f48110a = LazyKt.lazy(ECAppInfoService$_isDouyinAndDefault$2.INSTANCE);
        f48111b = LazyKt.lazy(ECAppInfoService$_isDyLite$2.INSTANCE);
        f48112c = LazyKt.lazy(ECAppInfoService$_isHuoshan$2.INSTANCE);
        f48113d = LazyKt.lazy(ECAppInfoService$_isLegou$2.INSTANCE);
    }

    public static vi.a g() {
        return d.f48119b.getIECHostAppInfo();
    }

    public static boolean j() {
        return ((Boolean) f48110a.getValue()).booleanValue();
    }

    public static boolean k() {
        return ((Boolean) f48111b.getValue()).booleanValue();
    }

    public static boolean l() {
        return ((Boolean) f48112c.getValue()).booleanValue();
    }

    public static boolean m() {
        return ((Boolean) f48113d.getValue()).booleanValue();
    }

    public static boolean h() {
        if (j() == false) goto L5;
    L10:
        return true;
    L5:
        if (k() == true) goto L10;
        if (l() == true) goto L10;
        return false;
    }

    @Override // vi.a
    public final Activity a() {
        return g().a();
    }

    @Override // vi.a
    public final String e() {
        return g().e();
    }

    @Override // vi.a
    public final boolean f() {
        return g().f();
    }

    @Override // vi.a
    public final String getAppId() {
        String r100 = g().getAppId();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100;
    }

    @Override // vi.a
    public final String getAppVersion() {
        return g().getAppVersion();
    }

    @Override // vi.a
    public final String getAppVersionName() {
        return g().getAppVersionName();
    }

    @Override // vi.a
    public final Context getApplicationContext() {
        return g().getApplicationContext();
    }

    @Override // vi.a
    public final String getBussinessVersionName() {
        return g().getBussinessVersionName();
    }

    @Override // vi.a
    public final String getChannel() {
        return g().getChannel();
    }

    @Override // vi.a
    public final Activity getCurrentActivity() {
        return g().getCurrentActivity();
    }

    @Override // vi.a
    public final Float getCurrentFontScale() {
        return g().getCurrentFontScale();
    }

    @Override // vi.a
    public final String getInstallId() {
        return g().getInstallId();
    }

    @Override // vi.a
    public final String getServerDeviceId() {
        return g().getServerDeviceId();
    }

    @Override // vi.a
    public final String getSessionID() {
        return g().getSessionID();
    }

    @Override // vi.a
    public final String getSessionKey() {
        return g().getSessionKey();
    }

    @Override // vi.a
    public final String getUpdateVersionCode() {
        return g().getUpdateVersionCode();
    }

    public final boolean i() {
        if (isDebug() == false) goto L5;
    L8:
        return true;
    L5:
        if (isLocalTest() == true) goto L8;
        return false;
    }

    @Override // vi.a
    public final boolean isDebug() {
        return g().isDebug();
    }

    @Override // vi.a
    public final boolean isLocalTest() {
        return g().isLocalTest();
    }

    @Override // vi.a
    public final boolean isNightMode() {
        return g().isNightMode();
    }

    public final boolean n() {
        if (e() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // vi.a
    public final boolean b(Activity r100) {
        return g().b(r100);
    }

    @Override // vi.a
    public final void d(JSONObject r100) {
        g().d(r100);
    }

    @Override // vi.a
    public final Activity c(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return g().c(r100, r101);
    }
}
