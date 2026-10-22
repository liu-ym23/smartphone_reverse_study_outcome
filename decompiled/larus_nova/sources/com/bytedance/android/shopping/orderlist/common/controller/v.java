package com.bytedance.android.shopping.orderlist.common.controller;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f179753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f179754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<?, ?> f179755c;

    public final void a() {
        Object r100 = this.f179755c.get("preload_url");
        JSONObject r101 = null;
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r102 = (String) r100;
        if (r102 != null) goto L8;
        return;
    L8:
        Object r103 = this.f179755c.get("render_type");
        if (r103 == null) goto L85;
        Integer r104 = com.bytedance.kmp.ec.yata.common.utils.d.d(r103);
        if (r104 == null) goto L86;
        int r105 = r104.intValue();
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        PreloadType r106 = null;
    L18:
        if (r106 != null) goto L20;
        return;
    L20:
        Object r107 = this.f179755c.get("sub_preload_resource");
        if ((r107 instanceof Map) == true) goto L23;
        r107 = null;
    L23:
        Map r108 = (Map) r107;
        int r109 = com.bytedance.android.shopping.yata.init.a.f187608a;
        Object r110 = ECSettingKeys.f0().get("fix_self_add_preload_task");
        if ((r110 instanceof Boolean) == true) goto L26;
        r110 = null;
    L26:
        Boolean r111 = (Boolean) r110;
        if (r111 == null) goto L29;
        boolean r112 = r111.booleanValue();
    L30:
        if (r112 == false) goto L51;
        JSONObject r113 = new JSONObject();
        if (r108 == null) goto L45;
        Iterator r114 = r108.entrySet().iterator();
    L35:
        if (r114.hasNext() == false) goto L45;
        Map.Entry r115 = (Map.Entry) r114.next();
        JSONArray r116 = new JSONArray();
        List r117 = (List) r115.getValue();
        if (r117 == null) goto L44;
        Iterator r118 = r117.iterator();
    L40:
        if (r118.hasNext() == false) goto L44;
        if (((String) r118.next()) == null) goto L40;
        JSONObject r119 = new JSONObject();
        r119.put("url", r115);
        r119.put("enableMemory", true);
        r119.put("processType", "templateBundle");
        Unit r120 = Unit.INSTANCE;
        r116.put(r119);
    L44:
        r113.put((String) r115.getKey(), r116);
    L45:
        PreloadType r121 = PreloadType.LYNX;
        if (r106 != r121) goto L48;
        com.bytedance.ies.bullet.forest.f<String, com.bytedance.forest.model.o> r122 = ForestLoader.f246728a;
        ForestLoader.m(null, r102, r113, BuyNowUrlType.ORDER_LIST, null, r121, new v26.l(), new com.bytedance.ies.bullet.forest.w(ib.e.a(UriProtector.parse(r102)), 2), true, 1);
    L48:
        PreloadType r123 = PreloadType.WEB;
        if (r106 != r123) goto L87;
        com.bytedance.ies.bullet.forest.f<String, com.bytedance.forest.model.o> r124 = ForestLoader.f246728a;
        ForestLoader.j(null, r102, r113, BuyNowUrlType.ORDER_LIST, null, r123, new v26.l(), true, 1);
        return;
    L87:
        return;
    L51:
        if (r108 == null) goto L68;
        r101 = new JSONObject();
        Iterator r125 = r108.entrySet().iterator();
    L54:
        if (r125.hasNext() == false) goto L68;
        Map.Entry r126 = (Map.Entry) r125.next();
        JSONArray r127 = new JSONArray();
        List r128 = (List) r126.getValue();
        if (r128 == null) goto L67;
        ArrayList r129 = new ArrayList();
        Iterator r130 = r128.iterator();
    L59:
        if (r130.hasNext() == false) goto L63;
        Object r131 = r130.next();
        if ((r131 instanceof String) == false) goto L59;
        r129.add(r131);
        goto L59
    L63:
        Iterator r132 = r129.iterator();
    L65:
        if (r132.hasNext() == false) goto L67;
        r127.put((String) r132.next());
    L67:
        r101.put((String) r126.getKey(), r127);
    L68:
        JSONObject r133 = r101;
        com.bytedance.ies.bullet.forest.f<String, com.bytedance.forest.model.o> r134 = ForestLoader.f246728a;
        ForestLoader.j(ForestLoader.d(), r102, r133, BuyNowUrlType.ORDER_LIST, null, r106, null, true, 64);
        return;
    L29:
        r112 = true;
        goto L30
    L16:
        r106 = PreloadType.WEB;
        goto L18
    L17:
        r106 = PreloadType.LYNX;
        goto L18
    L86:
        return;
    }

    public v(Map<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "originMap");
        this.f179755c = r100;
        Object r101 = r100.get("preload_biz_scene");
        Object r102 = null;
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        this.f179753a = (String) r101;
        Object r103 = r100.get("bundle_id");
        if ((r103 instanceof String) == false) goto L9;
        r102 = r103;
    L9:
        String r104 = (String) r102;
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        this.f179754b = r104;
    }
}
