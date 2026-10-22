package com.bytedance.android.live.network.impl.interceptor;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.SystemPropertiesUtil;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IHostSessionAuth;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.init.LiveInitializeSettingConfig;
import com.bytedance.android.livesdkapi.recommend.IRecommendController;
import com.bytedance.android.livesdkapi.util.LiveSDKConstUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends b {
    public c() {
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.b
    public final void b(Map<String, String> r100) {
        String r101 = LiveSDKConstUtil.getSdkVersion();
        r100.put("gamecp_sdk_version", r101);
        r100.put("webcast_sdk_version", r101);
        r100.put("webcast_language", Locale.CHINA.getLanguage());
        r100.put("webcast_locale", Resources.getSystem().getConfiguration().locale.toString());
        r100.put("webcast_gps_access", "" + com.bytedance.android.live.network.impl.utils.i.b());
        if (r100.containsKey(LiveInitializeSettingConfig.Companion.getCombindKey()) == true) goto L6;
        r100.put("current_network_quality_info", ao0.g.a().toString());
        r100.put("device_score", z0.b(false) + "");
    L6:
        if (tb1.c.f545229a == false) goto L13;
        IHostService r102 = TTLiveSDK.hostService();
        if (r102 == null) goto L13;
        IHostUser r103 = r102.user();
        if (r103 == null) goto L13;
        r100.put("address_book_access", String.valueOf(r103.getUidContactPermissionState()));
        r100.put("user_id", r103.getCurUserId());
    L13:
        if (SettingUtil.isLocalTest() == false) goto L21;
        int r104 = CoreSettingKeys.TEST_FAKE_REGION.getValue().intValue();
        if (r104 < 0) goto L19;
        String[] r105 = this.f83860b;
        if (r104 >= r105.length) goto L19;
        String r106 = r105[r104];
    L20:
        r100.put("fake_region", r106);
    L19:
        r106 = "";
    L21:
        boolean r107 = PadConfigUtils.a();
        String r108 = "true";
        if (r107 == false) goto L24;
        String r109 = "true";
    L25:
        r100.put("is_pad", r109);
        String r110 = "1";
        if (r107 == false) goto L28;
        String r111 = "1";
    L29:
        r100.put("is_android_pad", r111);
        if (e5.n() == true) goto L33;
        r108 = "false";
    L33:
        r100.put("is_landscape", r108);
        r100.put("carrier_region", Locale.CHINA.getCountry());
        r100.put("webcast_app_id", "" + ((IHostContext) jc1.k.f(IHostContext.class)).appId());
        r100.put("app_name", "" + ((IHostContext) jc1.k.f(IHostContext.class)).appName());
        if (jc1.k.f(IHostCommerceServiceLive.class) != null) goto L54;
    L41:
        String r112 = ((IHostContext) jc1.k.f(IHostContext.class)).ecHostAppId();
        if (mz.c.b(r112) == true) goto L44;
        r100.put("ecom_host_appid", r112);
    L44:
        IRecommendController r113 = (IRecommendController) jc1.k.f(IRecommendController.class);
        if (r113 != null) goto L47;
    L49:
        r110 = "0";
    L50:
        r100.put("openlive_personal_recommend", r110);
        if (SettingUtil.isLocalTest() == false) goto L56;
        r100.put("channel", "local_test");
        return;
    L56:
        return;
    L47:
        if (r113.getNeedPersonalRecommend() == false) goto L49;
    L54:
        String r114 = ((IHostCommerceServiceLive) jc1.k.f(IHostCommerceServiceLive.class)).getEcomSdkVersion();     // Catch: Throwable -> L39
        if (r114 == null) goto L41;
        r100.put("ecom_sdk_version", r114);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
        goto L41
    L28:
        r111 = "0";
        goto L29
    L24:
        r109 = "false";
        goto L25
    }

    public final com.bytedance.android.live.network.b.a c(com.bytedance.android.live.network.b.a r110) {
        String r100 = r110.f83798a;
        if (TextUtils.isEmpty(r100) == true) goto L48;
        StringBuilder r101 = new StringBuilder(r100);
        String r102 = r101.toString();
        if (r102.indexOf(63) >= 0) goto L7;
        r101.append("?");
    L8:
        LinkedHashMap r103 = new LinkedHashMap();
        b(r103);
        this.f83859a.a(r102, r103);
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L13;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.add(new Pair((String) r106.getKey(), (String) r106.getValue()));
        goto L10
    L13:
        if (com.bytedance.android.livesdk.b.f104228a.getValue().booleanValue() == false) goto L35;
        StringBuilder r107 = new StringBuilder();
        Iterator r108 = r104.iterator();
    L16:
        if (r108.hasNext() == false) goto L34;
        Pair r109 = (Pair) r108.next();
        String r111 = URLEncoder.encode((String) r109.first, "UTF-8");     // Catch: UnsupportedEncodingException -> L31
        String r112 = (String) r109.second;
        if (r112 != null) goto L126;
        String r113 = "";
    L28:
        if (r107.length() <= 0) goto L30;
        r107.append("&");
    L30:
        r107.append(r111);
        r107.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r107.append(r113);
        goto L16
    L126:
        r113 = URLEncoder.encode(r112, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L23:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L31:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L34:
        r101.append(r107.toString());
    L47:
        r110.f83798a = r101.toString();
        goto L48
    L35:
        StringBuilder r114 = new StringBuilder();
        Iterator r115 = r104.iterator();
    L37:
        if (r115.hasNext() == false) goto L46;
        Pair r116 = (Pair) r115.next();
        String r117 = com.bytedance.android.live.network.a.a((String) r116.first);
        String r118 = (String) r116.second;
        if (r118 == null) goto L41;
        String r119 = com.bytedance.android.live.network.a.a(r118);
    L43:
        if (r114.length() <= 0) goto L45;
        r114.append("&");
    L45:
        r114.append(r117);
        r114.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r114.append(r119);
        goto L37
    L41:
        r119 = "";
        goto L43
    L46:
        r101.append(r114.toString());
        goto L47
    L7:
        r101.append("&");
    L48:
        String r120 = r110.f83798a;
        if (TextUtils.isEmpty(r120) == true) goto L123;
        TextUtils.equals(r110.a(), "/webcast/room/create/");
        r110.f83798a = new StringBuilder(r120).toString();
        IHostContext r121 = (IHostContext) jc1.k.f(IHostContext.class);
        od1.a r122 = (od1.a) jc1.k.f(od1.a.class);
        if (r122 == null) goto L108;
        String r123 = r122.getAccessToken();
        if (r123 == null) goto L76;
        r110.f83799b.add(new NameValuePair("Authorization", "Bearer ".concat(r123)));
        if (LiveConfigSettingKeys.ENABLE_USE_BD_ACCOUNT_TICKET_NEW.getValue().booleanValue() == false) goto L75;
        INetworkService r124 = (INetworkService) jc1.k.f(INetworkService.class);
        if (r124 == null) goto L76;
        List<Pair<String, String>> r125 = r124.getBdTicketParams(r123, r110.a());
        if (r125 == null) goto L76;
        if (r125.isEmpty() == true) goto L76;
        Iterator<Pair<String, String>> r126 = r125.iterator();
    L67:
        if (r126.hasNext() == false) goto L76;
        Pair<String, String> r127 = r126.next();
        if (r127 == null) goto L67;
        if (TextUtils.isEmpty((CharSequence) r127.first) == true) goto L67;
        if (TextUtils.isEmpty((CharSequence) r127.second) == true) goto L67;
        r110.f83799b.add(new NameValuePair((String) r127.first, (String) r127.second));
        goto L67
    L75:
        r110.f83799b.add(new NameValuePair("bd-ticket-guard-target", r123));
    L76:
        String r128 = r122.getOpenId();
        if (r128 == null) goto L85;
        r110.f83799b.add(new NameValuePair(com.alipay.sdk.m.d.a.f25267a, r128));
        IUserService r129 = (IUserService) jc1.k.f(IUserService.class);
        if (r129 == null) goto L85;
        String r130 = r129.user().n();
        if (r130 == null) goto L85;
        if (mz.c.a(r128, r130) == true) goto L85;
        ALogger.e("CommonParamsInterceptor", String.format("request[%s] uid[%s] openid[%s] not null and not equal", new Object[]{r110.a(), r130, r128}));
    L85:
        if (r121 == null) goto L89;
        String r131 = r121.clientKey();
        if (r131 == null) goto L89;
        r110.f83799b.add(new NameValuePair("ClientKey", r131));
    L89:
        nn2.a r132 = nn2.a.f519628d;
        String r133 = nn2.a.C6941a.a().f519631c;
        if (TextUtils.isEmpty(r133) == true) goto L92;
        r110.f83799b.add(new NameValuePair("id-sign", r133));
    L92:
        IHostSessionAuth r134 = TTLiveSDK.hostService().sessionAuth();
        if (r134 == null) goto L108;
        Map<String, String> r135 = r134.getTokenRequestHeaders(r110.f83798a);
        if (r135 == null) goto L108;
        if (r135.isEmpty() == true) goto L108;
        Iterator<Map.Entry<String, String>> r136 = r135.entrySet().iterator();
    L100:
        if (r136.hasNext() == false) goto L108;
        Map.Entry<String, String> r137 = r136.next();
        if (r137 == null) goto L100;
        if (TextUtils.isEmpty(r137.getKey()) == true) goto L100;
        if (TextUtils.isEmpty(r137.getValue()) == true) goto L100;
        r110.f83799b.add(new NameValuePair(r137.getKey(), r137.getValue()));
    L108:
        String r138 = TTLiveSDK.hostService().user().hostUserIdentifier();
        if (mz.c.b(r138) == true) goto L112;
        r110.f83799b.add(new NameValuePair("odin-tt", r138));
    L112:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L123;
        r110.f83799b.add(new NameValuePair("x-app-id", "4207"));
        IMiddleWareHostContext r139 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r139 != null) goto L116;
    L118:
        String r140 = SystemPropertiesUtil.getPpeProp("debug.ttlive.ppe.env");
        if (r140 == null) goto L123;
        if (r140.length() <= 0) goto L123;
        r110.f83799b.add(new NameValuePair("X-Tt-Env", r140));
        r110.f83799b.add(new NameValuePair("X-Use-Ppe", "1"));
        goto L123
    L116:
        if (TextUtils.isEmpty(r139.getServerDeviceId()) == true) goto L118;
        r110.f83799b.add(new NameValuePair("x-device-id", r139.getServerDeviceId()));
    L123:
        return r110;
    }
}
