package com.bytedance.android.ec.host.impl;

import android.app.Activity;
import android.content.Context;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements yj.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f46212a = null;

    static {
        f46212a = new o();
    }

    public o() {
    }

    @Override // yj.i
    public final boolean b() {
        return false;
    }

    @Override // yj.i
    public final void c() {
    }

    @Override // yj.i
    public final boolean d() {
        return true;
    }

    @Override // yj.i
    public final boolean e() {
        return true;
    }

    @Override // yj.i
    public final Long f() {
        return null;
    }

    @Override // yj.i
    public final Activity a() {
        return AppHost.f326268a.a().getTopActivity();
    }

    @Override // yj.i
    public final String getAppId() {
        return String.valueOf(AppHost.f326268a.getAppId());
    }

    @Override // yj.i
    public final String getAppName() {
        return AppHost.f326268a.getAppName();
    }

    @Override // yj.i
    public final String getAppVersion() {
        return AppHost.f326268a.getVersionName();
    }

    @Override // yj.i
    public final String getAppVersionName() {
        return AppHost.f326268a.getVersionName();
    }

    @Override // yj.i
    public final Context getApplicationContext() {
        return AppHost.f326268a.getApplication();
    }

    @Override // yj.i
    public final String getChannel() {
        return AppHost.f326268a.getBuildChannel();
    }

    @Override // yj.i
    public final Float getCurrentFontScale() {
        return Float.valueOf(1.0f);
    }

    @Override // yj.i
    public final String getServerDeviceId() {
        return IApplog.f287053a.getDeviceId();
    }

    @Override // yj.i
    public final String getUpdateVersionCode() {
        return String.valueOf(AppHost.f326268a.getUpdateVersionCode());
    }

    @Override // yj.i
    public final boolean isLocalTest() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.isDebugChannel() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.isTestChannel() == true) goto L8;
        return false;
    }

    @Override // yj.i
    public final boolean isNightMode() {
        boolean r100 = v19.h.f552477a;
        return v19.h.a(null);
    }

    @Override // yj.i
    public final boolean isDebug() {
        return isLocalTest();
    }
}
