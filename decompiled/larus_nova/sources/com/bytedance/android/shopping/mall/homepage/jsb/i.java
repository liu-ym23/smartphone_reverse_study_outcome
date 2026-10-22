package com.bytedance.android.shopping.mall.homepage.jsb;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends qf3.e {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ec.mallRequestShowResult";
    }

    public i(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r110, IBDXBridgeContext r111, Map<String, ? extends Object> r112, Map<String, Object> r210) {
        Intrinsics.checkNotNullParameter(r110, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r111, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r210, "result");
        Object r113 = r112.get("canShow");
        Object r114 = null;
        if ((r113 instanceof Integer) == true) goto L5;
        r113 = null;
    L5:
        Integer r115 = (Integer) r113;
        if (r115 == null) goto L8;
        int r116 = r115.intValue();
    L9:
        Object r100 = r112.get("bizParams");
        if ((r100 instanceof Map) == true) goto L12;
        r100 = null;
    L12:
        Map r101 = (Map) r100;
        if (r101 != null) goto L15;
        r101 = MapsKt.emptyMap();
    L15:
        Object r102 = r101.get("plan");
        if ((r102 instanceof String) == false) goto L19;
        r114 = r102;
    L19:
        String r117 = (String) r114;
        if (r117 != null) goto L22;
        r117 = "default";
    L22:
        if (r116 != 0) goto L58;
        if (Intrinsics.areEqual(r117, "default") == false) goto L26;
        int r103 = 6;
    L60:
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L59
        r118.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: Throwable -> L59
        r118.put("plan", r117);     // Catch: Throwable -> L59
        r118.put("status", r103);     // Catch: Throwable -> L59
        r118.put("business_type", "shopping_product");     // Catch: Throwable -> L59
        r118.put("group_tag", "promote_consum");     // Catch: Throwable -> L59
        r118.put("type_tag", "Product_discounts");     // Catch: Throwable -> L59
        Map<String, Object> r104 = q93.a.f532094a;     // Catch: Throwable -> L59
        Object r119 = ((LinkedHashMap) r104).get("templateTag");     // Catch: Throwable -> L59
        Object r120 = "";
        if (r119 != null) goto L31;
        r119 = "";
    L31:
        r118.put("templateTag", r119);     // Catch: Throwable -> L59
        Object r105 = ((LinkedHashMap) r104).get(GXTemplateKey.GAIAX_TEMPLATE_ID);     // Catch: Throwable -> L59
        if (r105 != null) goto L34;
        r105 = "";
    L34:
        r118.put(GXTemplateKey.GAIAX_TEMPLATE_ID, r105);     // Catch: Throwable -> L59
        Object r106 = ((LinkedHashMap) r104).get("pushType");     // Catch: Throwable -> L59
        if (r106 != null) goto L37;
        r106 = "";
    L37:
        r118.put("pushType", r106);     // Catch: Throwable -> L59
        Object r107 = ((LinkedHashMap) r104).get("id");     // Catch: Throwable -> L59
        if (r107 != null) goto L40;
        r107 = "";
    L40:
        r118.put("id", r107);     // Catch: Throwable -> L59
        Object r108 = ((LinkedHashMap) r104).get("title");     // Catch: Throwable -> L59
        if (r108 != null) goto L43;
        r108 = "";
    L43:
        r118.put("title", r108);     // Catch: Throwable -> L59
        Object r109 = ((LinkedHashMap) r104).get("text");     // Catch: Throwable -> L59
        if (r109 != null) goto L46;
        r109 = "";
    L46:
        r118.put("text", r109);     // Catch: Throwable -> L59
        Object r121 = ((LinkedHashMap) r104).get(RuleConditionBean.OPEN_URL_KEY);     // Catch: Throwable -> L59
        if (r121 != null) goto L49;
        r121 = "";
    L49:
        r118.put(RuleConditionBean.OPEN_URL_KEY, r121);     // Catch: Throwable -> L59
        Object r122 = ((LinkedHashMap) r104).get("imageUrl");     // Catch: Throwable -> L59
        if (r122 != null) goto L52;
        r122 = "";
    L52:
        r118.put("imageUrl", r122);     // Catch: Throwable -> L59
        Object r123 = ((LinkedHashMap) r104).get("groupId");     // Catch: Throwable -> L59
        if (r123 == null) goto L56;
        r120 = r123;
    L56:
        r118.put("groupId", r120);     // Catch: Throwable -> L59
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L59
        AppLogNewUtils.onEventV3("iesec_mall_product_push_event", r118);     // Catch: Throwable -> L59
        goto L58
    L26:
        r103 = 7;
    L58:
        return qf3.e.f(this);
    L8:
        r116 = 1;
        goto L9
    }
}
