package com.bytedance.android.ec.common.impl.hybrid.bridges;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import ul.h;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/ECOpenSkuMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenSkuMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f42900e;

    public ECOpenSkuMethod() {
        this.f42900e = "openNativeSKU";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f42900e;
    }

    public final d d(JSONObject r100) {
        String r101 = r100.optString("btm");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return null;
    L12:
        JSONObject r103 = r100.optJSONObject("bcm");
        d r104 = new d();
        r104.f42022a = r101;
        r104.f42023b = PageFinder.via(b().f545990a);
        BcmParams.Companion.getClass();
        r104.f42024c = BcmParams.a.b(r103);
        return r104;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r123, ECBaseBridgeMethod.a r124) {
        Intrinsics.checkNotNullParameter(r123, "params");
        Intrinsics.checkNotNullParameter(r124, "iReturn");
        String r100 = r123.optString("page_name", "");
        String r210 = r123.optString("promotion_id", "");
        String r110 = r123.optString("product_id", "");
        JSONArray r101 = r123.optJSONArray("selected_ids");
        String r211 = r123.optString(a.KEY_SKU_ID, "");
        long r111 = r123.optLong("selected_count", 1);
        String r112 = r123.optString(a.KEY_COMMODITY_ID, "");
        String r102 = r123.optString("author_id", "");
        String r310 = r123.optString("sec_author_id", "");
        String r311 = r123.optString("room_id", "");
        long r212 = r123.optLong(a.KEY_BUTTON_TYPE, 0);
        String r510 = r123.optString("address_id", "");
        String r610 = r123.optString(a.KEY_MARKET_CHANNEL, "");
        String r710 = r123.optString(a.KEY_ENTRANCE_INFO, "");
        String r312 = r123.optString(a.KEY_COMBINATION_ID, "");
        String r103 = r123.optString("extra_params", "");
        String r410 = r123.optString("channel_id", "");
        int r104 = r123.optInt(WsConstants.KEY_CHANNEL_TYPE, 0);
        int r113 = r123.optInt("force_yata_sku", 0);
        String r411 = r123.optString("biz_identifier", "");
        String r105 = r123.optString("mask_background_color", "");
        if (r210.length() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L102;
        if (r110.length() != 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L102;
        if (r111 <= 0) goto L102;
        Activity r108 = ECAppInfoService.f48114e.getCurrentActivity();
        if ((r108 instanceof FragmentActivity) == true) goto L18;
        r108 = null;
    L18:
        FragmentActivity r109 = (FragmentActivity) r108;
        if (r109 == null) goto L100;
        FragmentManager r114 = r109.getSupportFragmentManager();
        if (r114 == null) goto L100;
        if (r101 != null) goto L105;
        String[] r213 = null;
    L28:
        JSONObject r115 = new JSONObject(r123.optString("event_params", SliceInitService.DEFAULT_SWITCH));     // Catch: Exception -> L25
        LinkedHashMap r116 = new LinkedHashMap();     // Catch: Exception -> L25
        Iterator<String> r117 = r115.keys();     // Catch: Exception -> L25
    L30:
        if (r117.hasNext() == false) goto L34;
        Iterator<String> r214 = r117;
        String r118 = r117.next();     // Catch: Exception -> L25
        JSONObject r215 = r115;
        r116.put(r118, r115.get(r118).toString());     // Catch: Exception -> L25
        r117 = r214;
        r115 = r215;
        goto L30
    L34:
        if (r100 != null) goto L37;
    L54:
        long r216 = 999;
    L55:
        long r313 = r216;
        int r119 = r123.optInt("scene_type", h.a(r313, null, false, null, false, 30));     // Catch: Exception -> L25
        int r120 = 0;
        int r121 = r123.optInt("action_type", ul.d.b(r313, false, 6));     // Catch: Exception -> L94
        if (r119 != 101) goto L60;
    L74:
        String r122 = a.VALUE_PRODUCT_DETAIL;
    L75:
        String r711 = r122;
    L76:
        int r125 = ECSdk.f48106a;     // Catch: Exception -> L94
        IECCommonService r1110 = (IECCommonService) ECSdk.a(IECCommonService.class);     // Catch: Exception -> L94
        if (r1110 == null) goto L89;
        if (r101 == null) goto L81;
        int r126 = r101.length();     // Catch: Exception -> L94
    L82:
        SkuRestoreState r127 = new SkuRestoreState(r126);     // Catch: Exception -> L94
        SkuRestoreState.saveSelectedSpec$default(r127, r213, Long.valueOf(r111), r211, null, null, null, 0, 120, null);     // Catch: Exception -> L94
        Unit r128 = Unit.INSTANCE;     // Catch: Exception -> L94
        LinkedHashMap r129 = new LinkedHashMap();     // Catch: Exception -> L94
        r129.put(a.KEY_COMMODITY_ID, r112);     // Catch: Exception -> L94
        r129.put("product_id", r110);     // Catch: Exception -> L94
        r129.put("author_id", r102);     // Catch: Exception -> L94
        r129.put("page_name", r100);     // Catch: Exception -> L94
        r129.putAll(r116);     // Catch: Exception -> L94
        IECCommonService.a.d(r1110, r114, new SkuParams(null, new SkuExtraData(null, null, false, null, null, null, null, null, null, null, r610, null, null, 7167, null), r127, null, null, 0, null, null, null, false, false, null, null, false, r110, r210, null, false, null, r312, r102, r310, null, null, r311, Long.valueOf(r212).equals(1L), r121, r119, null, null, 0, null, null, null, r411, r410, Integer.valueOf(r104), null, null, null, null, null, r510, null, null, null, false, null, null, null, Integer.valueOf(r113), false, false, false, null, null, null, r105, 0.0f, null, null, null, null, null, null, r710, null, r129, null, r711, null, 0, "ECOpenSkuMethod-handle", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, false, null, r103, null, null, null, null, null, null, -255377415, -33817629, -1073742123, 31, null), null, d(r123), null, null, null, ECOpenSkuMethod$handle$3.INSTANCE, null, new ECOpenSkuMethod$handle$4(this), null, 0, null, null, null, 30720);     // Catch: Exception -> L86
    L86:
        e = e;
    L96:
        ECBaseBridgeMethod.a r130 = r124;
    L97:
        ECExceptionMonitor.e(e);
        r130.onFailed(r120, e.toString());
        return;
    L81:
        r126 = 1;
    L89:
        r130 = r124;
        r130.onSuccess(SliceInitService.DEFAULT_SWITCH);     // Catch: Exception -> L92
        return;
    L92:
        e = e;
        goto L97
    L60:
        if (r119 == 102) goto L74;
        if (r119 != 201) goto L64;
        r122 = "live";
        goto L75
    L64:
        if (r119 != 901) goto L66;
        r122 = "cart";
        goto L75
    L66:
        if (r119 != 1001) goto L68;
        r122 = "exchange";
        goto L75
    L68:
        if (r119 == 1301) goto L70;
        r122 = PrefetchTiming.JSB;
        goto L75
    L70:
        r711 = "mix_page";
    L94:
        e = e;
    L25:
        e = e;
        r130 = r124;
        r120 = 0;
        goto L97
    L37:
        switch(r100.hashCode()) {
            case -1320774386: goto L52;
            case -1172298460: goto L49;
            case -1081930094: goto L46;
            case -828405016: goto L43;
            case -688094775: goto L40;
            default: goto L54;
        };     // Catch: Exception -> L25
    L40:
        if (r100.equals("insurance_apply") == false) goto L54;
        r216 = 4;
        goto L55
    L43:
        if (r100.equals("supermarket_cart") == false) goto L54;
        r216 = 13;
        goto L55
    L46:
        if (r100.equals("mix_page") == false) goto L54;
        r216 = 11;
        goto L55
    L49:
        if (r100.equals("shop_cart_tag") == false) goto L54;
        r216 = 2;
        goto L55
    L52:
        if (r100.equals("onecent") == false) goto L54;
        r216 = 12;
        goto L55
    L105:
        r213 = (String[]) new Gson().fromJson(r101.toString(), String[].class);     // Catch: Exception -> L25
    L100:
        return;
    L10:
        r107 = false;
    L102:
        return;
    L5:
        r106 = false;
        goto L6
    }
}
