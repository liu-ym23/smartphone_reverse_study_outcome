package com.bytedance.android.live.saas.middleware.middlelayer;

import android.content.Context;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import rm0.a;
import rm0.c;
import rm0.d;
import rm0.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/CommonServiceImpl;", "Lrm0/a;", "", "getAppId", "getChannel", "Landroid/content/Context;", "getContext", "getDeviceId", "Lrm0/c;", "getMiddleAppInfo", "Lrm0/d;", "getMiddleEnvParams", "Lrm0/e;", "getMiddleExtraParams", "", "isLocalTest", "", "SAAS", "I", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class CommonServiceImpl implements a {
    private final int SAAS;

    public c getMiddleAppInfo() {
        String r100 = String.valueOf(BDLiveSdk.getAppInfo().versionCode());
        Context r101 = getContext();
        if (r101 == null) goto L5;
        String r102 = r101.getPackageName();
    L7:
        return new c(r100, r102, Integer.valueOf(BDLiveSdk.getAppInfo().updateVersionCode()), BDLiveSdk.getAppInfo().appName(), Integer.valueOf(BDLiveSdk.getAppInfo().appIcon()), BDLiveSdk.getAppInfo().versionName());
    L5:
        r102 = null;
        goto L7
    }

    public d getMiddleEnvParams() {
        Boolean r100 = Boolean.FALSE;
        return new d(r100, r100, r100, r100);
    }

    public e getMiddleExtraParams() {
        return new e(Integer.valueOf(this.SAAS));
    }

    public CommonServiceImpl() {
        this.SAAS = 4;
    }

    public String getAppId() {
        return String.valueOf(BDLiveSdk.getAppInfo().appId());
    }

    public String getChannel() {
        return BDLiveSdk.getAppInfo().channel();
    }

    @Override // rm0.a
    public Context getContext() {
        return BDLiveSdk.getContext();
    }

    public String getDeviceId() {
        return BDLiveSdk.getAppInfo().devicesId();
    }

    @Override // rm0.a
    public boolean isLocalTest() {
        return StringsKt.equals("local_test", BDLiveSdk.getAppInfo().channel(), true);
    }
}
