package com.bytedance.android.ecom.live.adapter.impl;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements vi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAppInfo f51177a;

    @Override // vi.a
    public final boolean b(Activity r100) {
        return false;
    }

    @Override // vi.a
    public final void d(JSONObject r100) {
    }

    @Override // vi.a
    public final boolean f() {
        return false;
    }

    @Override // vi.a
    public final Float getCurrentFontScale() {
        return null;
    }

    @Override // vi.a
    public final String getSessionID() {
        return null;
    }

    @Override // vi.a
    public final boolean isLocalTest() {
        IHostContext r100 = (IHostContext) jc1.k.f(IHostContext.class);     // Catch: Exception -> L7
        if (r100 == null) goto L10;
        return r100.isLocalTest();
    L10:
        return false;
    L11:
        return false;
    }

    @Override // vi.a
    public final boolean isNightMode() {
        return false;
    }

    @Override // vi.a
    public final Activity a() {
        IHostApp r100 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTopActivity();
    }

    @Override // vi.a
    public final String e() {
        IHostContext r100 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.ecHostAppId();
    }

    @Override // vi.a
    public final String getAppId() {
        IHostContext r100 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.hostAppId());
    L7:
        return String.valueOf(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // vi.a
    public final String getAppVersion() {
        return String.valueOf(this.f51177a.versionCode());
    }

    @Override // vi.a
    public final String getAppVersionName() {
        return this.f51177a.versionName();
    }

    @Override // vi.a
    public final Context getApplicationContext() {
        IHostContext r100 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r100 == null) goto L7;
        Context r101 = r100.context();
        if (r101 == null) goto L7;
        return r101.getApplicationContext();
    L7:
        return null;
    }

    @Override // vi.a
    public final String getBussinessVersionName() {
        return this.f51177a.versionName();
    }

    @Override // vi.a
    public final String getChannel() {
        return this.f51177a.channel();
    }

    @Override // vi.a
    public final Activity getCurrentActivity() {
        IHostApp r100 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r100 == null) goto L6;
        Activity r101 = r100.getCurrentActivity();
        if (r101 == null) goto L6;
        return r101;
    L6:
        LinkedList<Activity> r102 = com.bytedance.android.ecom.live.adapter.a.f51165a;
        if (r102.isEmpty() == false) goto L10;
        return null;
    L10:
        return r102.getLast();
    }

    @Override // vi.a
    public final String getServerDeviceId() {
        return this.f51177a.devicesId();
    }

    @Override // vi.a
    public final String getSessionKey() {
        fi.b r100 = gi.a.f481329a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("appLog");
    L6:
        return r100.getSessionKey();
    }

    @Override // vi.a
    public final String getUpdateVersionCode() {
        return String.valueOf(this.f51177a.updateVersionCode());
    }

    public e() {
        this.f51177a = BDLiveSdk.getAppInfo();
    }

    @Override // vi.a
    public final String getInstallId() {
        IAppLog r100 = BDLiveSdk.appLog();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getInstallId();
    }

    @Override // vi.a
    public final boolean isDebug() {
        return isLocalTest();
    }

    @Override // vi.a
    public final Activity c(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Activity) == true) goto L5;
        r100 = null;
    L5:
        Activity r102 = (Activity) r100;
        if (r102 == null) goto L8;
        return r102;
    L8:
        return getCurrentActivity();
    }
}
