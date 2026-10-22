package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.live.browser.jsbridge.base.AppInfoResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.af0;
import com.bytedance.android.livesdk.config.f91;
import com.bytedance.android.livesdk.config.ie;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "appInfo")
public final class z extends w20.i<JSONObject, AppInfoResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f142255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f91 f142256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TokenCert f142257c;

    public final boolean j() {
        WebView r100 = this.f142255a;
        if (r100 != null) goto L5;
    L24:
        return false;
    L5:
        if (r100.getUrl() == null) goto L24;
        if (this.f142256b != null) goto L10;
        this.f142256b = af0.f119785a.getValue();
    L10:
        f91 r101 = this.f142256b;
        if (r101 == null) goto L24;
        List<String> r102 = r101.blackList;
        if (r102 == null) goto L24;
        if (r102.size() == 0) goto L24;
        String r103 = this.f142255a.getUrl();
        Iterator<String> r104 = this.f142256b.blackList.iterator();
    L19:
        if (r104.hasNext() == false) goto L24;
        if (r104.next().contains(r103) == false) goto L19;
        return true;
    }

    public z(m16.b r100) {
        this.f142256b = null;
        this.f142257c = TokenCert.with("bpea-appInfoMethod_jsb_get_network_access");
        this.f142255a = (WebView) r100.c(WebView.class);
    }

    public z(WebView r100) {
        this.f142256b = null;
        this.f142257c = TokenCert.with("bpea-appInfoMethod_jsb_get_network_access");
        this.f142255a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) throws Exception {
        JSONObject r102 = (JSONObject) r100;
        AppInfoResultModel r103 = new AppInfoResultModel();
        IMiddleWareHostContext r104 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        r103.c(r104.appName());
        r103.b(String.valueOf(r104.appId()));
        String r105 = r101.getContext().getPackageManager().getPackageInfo(r101.getContext().getPackageName(), 0).versionName;     // Catch: Exception -> L5
    L7:
        if (TextUtils.isEmpty(r105) == false) goto L9;
        r105 = r104.getVersionCode();
    L9:
        r103.d(r105);
        r103.u(r104.getVersionCode());
        r103.v(r105);
        String r106 = r102.optString("token", "");
        if (r106 != null) goto L12;
    L14:
        r103.j(NetworkUtils.a(r104.context(), this.f142257c));
        String r107 = "vertical";
        if ((r101.getContext() instanceof Activity) == false) goto L34;
        Activity r108 = (Activity) r101.getContext();
        if (r108.getRequestedOrientation() != 1) goto L19;
        String r109 = "vertical";
    L20:
        ALogger.d("app info", "request orientation :" + r108.getRequestedOrientation());
        if (PadConfigUtils.c() == false) goto L28;
        if (j() == false) goto L25;
    L33:
        r107 = r109;
        goto L34
    L25:
        if (com.bytedance.android.livesdk.utils.e5.g(r108) == false) goto L34;
        r107 = "horizontal";
        goto L34
    L28:
        if (ie.f120444a.getValue().booleanValue() == false) goto L33;
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L32;
        r107 = "horizontal";
    L32:
        ALogger.d("app info", "on back up run and padconfig utils ab value : " + PadConfigUtils.c());
        goto L34
    L19:
        r109 = "horizontal";
    L34:
        r103.l(r107);
        r103.i(TTMiddlewareLiveSDK.hostMiddlewareService().appContext().getServerDeviceId());
        r103.t(((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().n());
        r103.q(((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().b().getCastSecUid());
        r103.o(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.y())));
        r103.n(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.w())));
        r103.s(String.valueOf(r104.getUpdateVersionCode()));
        r103.w(String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        com.bytedance.android.livesdk.user.e r110 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user();
        if (r110.isLogin() == false) goto L37;
        r103.k(r110.n());
    L37:
        IMiddlewareNetworkService r111 = (IMiddlewareNetworkService) jc1.k.f(IMiddlewareNetworkService.class);
        if (r111 == null) goto L58;
        Map<String, String> r112 = r111.getCommonParams();
        if (r112 == null) goto L58;
        Iterator<String> r113 = r112.keySet().iterator();
    L43:
        if (r113.hasNext() == false) goto L58;
        String r114 = r113.next();
        if (r114.isEmpty() == true) goto L43;
        if (r114.equals("device_platform") == true) goto L48;
        if (r114.equals("os_version") == true) goto L51;
        if (r114.equals("device_type") == true) goto L54;
        if (r114.equals("device_brand") == false) goto L43;
        r103.f(r112.get(r114));
        goto L43
    L54:
        r103.h(r112.get(r114));
        goto L43
    L51:
        r103.m(r112.get(r114));
        goto L43
    L48:
        r103.g(r112.get(r114));
    L58:
        r103.p(String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        Room r115 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r115 == null) goto L61;
        r103.r(Long.valueOf(r115.getCreateTime()));
    L61:
        r103.e(AppInfoResultModel.Code.Success);
        HashMap r116 = new HashMap();
        r116.put("orientation", r103.a());
        r116.put("pad_ab", String.valueOf(PadConfigUtils.c()));
        r116.put("black_list", String.valueOf(j()));
        r116.put("width", String.valueOf(com.bytedance.android.live.core.utils.s1.y()));
        r116.put("height", String.valueOf(com.bytedance.android.live.core.utils.s1.w()));
        ALogger.d("AppInfoMethod", "monitorAppInfo: " + r116.toString());
        LiveSlardarMonitor.monitorStatus("ttlive_app_info_status", 0, r116);
        finishWithResult(r103);
        return;
    L12:
        if (r106.isEmpty() == true) goto L14;
        this.f142257c = TokenCert.with(r106);
    L5:
        r105 = "";
        goto L7
    }
}
