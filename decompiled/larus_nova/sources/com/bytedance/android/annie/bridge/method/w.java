package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.annie.bridge.method.abs.AbsGetAppInfoMethod;
import com.bytedance.android.annie.bridge.method.abs.GetAppInfoResultModel;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getAppInfo")
public final class w extends AbsGetAppInfoMethod<JsonObject, GetAppInfoResultModel> {
    public w() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        Intrinsics.checkNotNullParameter((JsonObject) r110, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r100 = r111.getContext().getApplicationContext();
        GetAppInfoResultModel r101 = new GetAppInfoResultModel();
        boolean r102 = true;
        r101.setCode(1);
        r101.setMsg("SUCCESS");
        com.bytedance.android.annie.ng.g.b().getClass();
        o8.a r103 = com.bytedance.android.annie.ng.e.f39661a;
        r101.setAppID(String.valueOf(r103.f522305a));
        com.bytedance.android.annie.ng.g.b().getClass();
        r101.setAppName(r103.f522306b);
        Activity r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        String r106 = r111.getContext().getPackageManager().getPackageInfo(r111.getContext().getPackageName(), 0).versionName;     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L12:
        if (TextUtils.isEmpty(r106) == false) goto L14;
        com.bytedance.android.annie.ng.g.b().getClass();
        r106 = com.bytedance.android.annie.ng.e.f39661a.f522307c;
    L14:
        r101.setAppVersion(r106);
        com.bytedance.android.annie.ng.g.b().getClass();
        o8.a r107 = com.bytedance.android.annie.ng.e.f39661a;
        r101.setChannel(r107.f522309e);
        com.bytedance.android.annie.ng.g.b().getClass();
        r101.setLanguage(r107.f522310f);
        com.bytedance.android.annie.ng.g.b().getClass();
        r101.setTeenMode(Boolean.valueOf(r107.f522311g));
        com.bytedance.android.annie.ng.g.b().getClass();
        r101.setAppTheme(r107.f522312h);
        r101.setOsVersion(Build.VERSION.RELEASE);
        r101.setDevicePlatform("android");
        r101.setDeviceID(com.bytedance.android.annie.ng.g.b().f39658b.f522317b);
        r101.setDeviceModel(Build.MODEL);
        String r108 = NetworkUtils.getNetworkAccessType(r111.getContext().getApplicationContext());     // Catch: Throwable -> L20
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L23:
        r101.setNetworkType(r108);
        int r109 = g7.a.f480179a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.getResources().getConfiguration().orientation != 1) goto L26;
        String r112 = "portrait";
    L27:
        r101.setScreenOrientation(r112);
        com.bytedance.android.annie.ng.g.b().getClass();
        r101.setUpdateVersionCode(com.bytedance.android.annie.ng.e.f39661a.f522313i);
        r101.setStatusBarHeight(Integer.valueOf(g7.a.f(g7.a.d(r100), r100)));
        r101.setCarrier(com.bytedance.android.annie.ng.g.b().f39658b.f522316a);
        Context r113 = r111.getContext();
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        if (r113 != null) goto L31;
        r113 = r100;
    L31:
        if (r113.getResources().getConfiguration().orientation != 2) goto L33;
        boolean r114 = true;
    L34:
        int r115 = g7.a.f480180b;
        if (r115 > 0) goto L41;
        g7.a.e(r113);
        r115 = g7.a.f480180b;
        if (r115 > 0) goto L41;
        r115 = 0;
    L41:
        int r116 = g7.a.f(r115, r113);
        int r117 = g7.a.f480179a;
        if (r117 > 0) goto L48;
        g7.a.e(r113);
        r117 = g7.a.f480179a;
        if (r117 > 0) goto L48;
        r117 = 0;
    L48:
        int r118 = g7.a.f(r117, r113);
        if (r114 == false) goto L51;
        int r119 = Math.max(r116, r118);
    L52:
        r101.setScreenWidth(Integer.valueOf(r119));
        r101.setScreenHeight(Integer.valueOf(g7.a.c(r111.getContext(), r100)));
        Context r120 = r111.getContext();
        if ((r120 instanceof Activity) == false) goto L55;
        r104 = (Activity) r120;
    L55:
        r101.setSafeArea(g7.a.b(r104, r100));
        if (Build.SUPPORTED_64_BIT_ABIS.length == 0) goto L59;
        r102 = false;
    L59:
        r101.set32Bit(Boolean.valueOf(r102));
        finishWithResult(r101);
        return;
    L51:
        r119 = Math.min(r116, r118);
        goto L52
    L33:
        r114 = false;
        goto L34
    L26:
        r112 = "landscape";
    L18:
        Throwable th10 = th;
    L22:
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L20:
        th = move-exception;
        th10 = th;
        r108 = null;
    L6:
        Throwable th11 = th;
    L10:
        Result.Companion r122 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th11));
    L8:
        th = move-exception;
        th11 = th;
        r106 = null;
        goto L10
    }
}
