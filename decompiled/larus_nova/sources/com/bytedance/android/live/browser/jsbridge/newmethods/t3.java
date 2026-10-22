package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Process;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.ie;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.ss.android.common.applog.AppLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getAppInfo")
public final class t3 extends AbsGetAppInfoMethod<JsonObject, GetAppInfoResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMiddleWareHostContext f63674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f63675b;

    public t3() {
        this.f63674a = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (com.bytedance.android.livesdk.v0.f159238a.getValue().booleanValue() == false) goto L7;
        IMiddlewareNetworkService r100 = (IMiddlewareNetworkService) jc1.k.f(IMiddlewareNetworkService.class);
        if (r100 == null) goto L10;
        Map<String, String> r101 = r100.getCommonParams();
    L11:
        this.f63675b = r101;
        return;
    L10:
        r101 = null;
        goto L11
    L7:
        IMiddlewareNetworkService r102 = (IMiddlewareNetworkService) jc1.k.f(IMiddlewareNetworkService.class);
        if (r102 == null) goto L10;
        r101 = r102.getCommonParams();
        goto L11
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        Intrinsics.checkNotNullParameter((JsonObject) r110, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetAppInfoResultModel r112 = new GetAppInfoResultModel();
        IMiddleWareHostContext r100 = this.f63674a;
        boolean r101 = true;
        boolean r102 = false;
        Object r103 = null;
        if (r100 == null) goto L64;
        r112.setAppID(String.valueOf(r100.hostAppId()));
        r112.setAppName(r100.appName());
        String r104 = r100.getVersionName();
        if (r104 != null) goto L7;
    L9:
        String r105 = r100.getVersionCode();
    L10:
        r112.setAppVersion(r105);
        r112.setUpdateVersionCode(String.valueOf(r100.getUpdateVersionCode()));
        r112.setNetworkType(NetworkUtils.getNetworkAccessType(r100.context()));
        r112.setDeviceID(AppLog.v());
        Context r113 = r111.getContext();
        if (r113 != null) goto L101;
    L62:
        r112.setScreenWidth(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.y())));
        r112.setInstallID(AppLog.r());
        r112.setChannel(r100.getChannel());
        r112.setTeenMode(Boolean.valueOf(r100.isNeedProtectUnderage()));
        goto L64
    L101:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L14
        r112.setCarrier(l30.h.a(r113, TokenCert.Companion.with("bpea-live_mobile_flow_old")));     // Catch: Throwable -> L14
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L17:
        if ((r113 instanceof Activity) == true) goto L19;
        Context r107 = null;
    L20:
        Activity r108 = (Activity) r107;
        String r109 = "portrait";
        if (r108 != null) goto L23;
    L37:
        r112.setScreenOrientation(r109);
        r112.setScreenHeight(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.q(r113).heightPixels - com.bytedance.android.live.core.utils.x1.j(r113))));
        int r114 = com.bytedance.android.livesdk.utils.y5.f159223a;
        if (Build.VERSION.SDK_INT < 28) goto L60;
        Activity r115 = ContextUtil.contextToActivity(r113);
        if (r115 == null) goto L52;
        Window r116 = r115.getWindow();
        if (r116 == null) goto L52;
        View r117 = r116.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L48;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r118 = ThreadMethodProxy.currentThread();
        if (r118 == com.larus.home.impl.utils.c.f346341a) goto L48;
        com.larus.home.impl.utils.c.a(r118, "getDecorView");
    L48:
        if (r117 == null) goto L52;
        WindowInsets r119 = r117.getRootWindowInsets();
        if (r119 == null) goto L52;
        DisplayCutout r120 = r119.getDisplayCutout();
    L53:
        if (r120 == null) goto L57;
        List<Rect> r121 = r120.getBoundingRects();
        if (r121 == null) goto L57;
        int r122 = r121.size();
    L58:
        if (r122 <= 0) goto L60;
        Intrinsics.checkNotNull(r120);
        com.bytedance.android.livesdk.utils.x5 r123 = new com.bytedance.android.livesdk.utils.x5(r120.getSafeInsetLeft(), r120.getSafeInsetTop(), r120.getSafeInsetRight(), r120.getSafeInsetBottom());
    L61:
        GetAppInfoResultModel.GetAppInfoSafeArea r124 = new GetAppInfoResultModel.GetAppInfoSafeArea();
        r124.setMarginLeft(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(r123.f159214a)));
        r124.setMarginTop(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(r123.f159215b)));
        r124.setMarginRight(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(r123.f159216c)));
        r124.setMarginBottom(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(r123.f159217d)));
        Unit r125 = Unit.INSTANCE;
        r112.setSafeArea(r124);
    L57:
        r122 = 0;
    L52:
        r120 = null;
    L60:
        r123 = new com.bytedance.android.livesdk.utils.x5(0, com.bytedance.android.live.core.utils.x1.j(r113), 0, 0);
        goto L61
    L23:
        if (r108.getRequestedOrientation() != 1) goto L25;
        String r126 = "portrait";
    L27:
        if (PadConfigUtils.c() == false) goto L32;
        if (com.bytedance.android.livesdk.utils.e5.g(r108) == false) goto L37;
    L35:
        r109 = "landscape";
        goto L37
    L32:
        if (ie.f120444a.getValue().booleanValue() == true) goto L34;
        r109 = r126;
        goto L37
    L34:
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L37;
    L25:
        r126 = "landscape";
        goto L27
    L19:
        r107 = r113;
    L14:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L7:
        if ((!StringsKt.isBlank(r104)) != true) goto L9;
        r105 = r100.getVersionName();
    L64:
        if (fm3.d.b() == true) goto L75;
        IMiddleWareHostContext r128 = this.f63674a;
        if (r128 == null) goto L69;
        Boolean r129 = r128.isDarkMode();
    L71:
        if (Intrinsics.areEqual(r129, Boolean.TRUE) == false) goto L74;
    L76:
        String r130 = "dark";
    L77:
        r112.setAppTheme(r130);
        Map<String, String> r131 = this.f63675b;
        if (r131 == null) goto L80;
        r112.setLanguage(r131.get("language"));
        r112.setOsVersion(r131.get("os_version"));
    L80:
        r112.setStatusBarHeight(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.A())));
        r112.setDevicePlatform("android");
        r112.setDeviceModel(Build.MODEL);
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L88
        if (Build.VERSION.SDK_INT >= 23) goto L84;
    L85:
        r102 = true;
    L86:
        Object r133 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L88
    L91:
        if (Result.m9455isFailureimpl(r133) == true) goto L94;
        r103 = r133;
    L94:
        Boolean r134 = (Boolean) r103;
        if (r134 == null) goto L97;
        r101 = r134.booleanValue();
    L97:
        r112.set32Bit(Boolean.valueOf(r101));
        r112.setMsg("SUCCESS");
        finishWithResult(r112);
        return;
    L84:
        if (Process.is64Bit() == true) goto L86;
    L88:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L91
    L74:
        if (Intrinsics.areEqual(r129, Boolean.FALSE) == false) goto L76;
    L69:
        r129 = null;
    L75:
        r130 = "light";
        goto L77
    }
}
