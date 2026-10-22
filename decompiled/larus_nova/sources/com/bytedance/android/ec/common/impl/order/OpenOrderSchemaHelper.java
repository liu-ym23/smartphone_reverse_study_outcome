package com.bytedance.android.ec.common.impl.order;

import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mf.b;
import nl.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class OpenOrderSchemaHelper implements mf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f42906b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f42907c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f42908a;

    public static final class a {
        public a() {
        }
    }

    static {
        f42907c = new a();
        f42906b = LazyKt.lazy(OpenOrderSchemaHelper$Companion$orderSchemaHelperCache$2.INSTANCE);
    }

    public OpenOrderSchemaHelper(b r100) {
        this.f42908a = r100;
    }

    @Override // mf.a
    public final String a(String r110, e r111) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        Intrinsics.checkNotNullParameter(r111, "orderSchemaVo");
        UrlBuilderV2 r100 = new UrlBuilderV2(r110);
        this.f42908a.i(r100.getMMap(), r111);
        this.f42908a.b(r100.getMMap(), r111);
        JSONObject r112 = this.f42908a.h(r100.getMMap(), r111);
        if (r112 == null) goto L5;
        r100.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r112);
    L5:
        JSONObject r113 = this.f42908a.a(r100.getMMap(), r111);
        if (r113 == null) goto L8;
        r100.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r113);
    L8:
        JSONObject r114 = this.f42908a.d(r100.getMMap(), r111);
        if (r114 == null) goto L11;
        r100.addOrReplaceParam("log_data", r114);
    L11:
        String r115 = this.f42908a.c(r100.getMMap(), r111);
        if (r115 == null) goto L14;
        r100.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, r115);
    L14:
        r100.addOrReplaceParam("page_init_timestamp", System.currentTimeMillis());
        this.f42908a.g(r100.getMMap(), r111);
        String r116 = this.f42908a.e(r100.getMMap(), r111);
        if (r116 == null) goto L17;
        r100.addOrReplaceParam("poi_id", r116);
    L17:
        String r117 = this.f42908a.f(r100.getMMap(), r111);
        if (r117 == null) goto L20;
        r100.addOrReplaceParam("spell_group_id", r117);
    L20:
        Map<String, String> r118 = r100.getMMap();
        boolean r101 = Intrinsics.areEqual("1", r118.get("use_rifle"));
        String r102 = com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT;
        if (r101 == false) goto L23;
        Object r103 = com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT;
    L24:
        nl.a r104 = r111.f519523h;
        JSONObject r105 = null;
        if (r104 != null) goto L27;
    L40:
        JSONObject r119 = null;
    L41:
        if (r119 == null) goto L43;
        r100.addOrReplaceParam("has_adinfojson", "1");
        r100.addOrReplaceParam("adinfojson", r119);
    L43:
        Map<String, String> r120 = r100.getMMap();
        nl.a r106 = r111.f519523h;
        if (r106 == null) goto L71;
        String r107 = r106.f519515d;
        if (r107 == null) goto L71;
        JSONObject r108 = z1.g(r106.f519514c);
        if (r120.get("ad_extra_data") != null) goto L51;
        if (r108 == null) goto L71;
    L51:
        if (r108 != null) goto L53;
        r108 = new JSONObject();
    L53:
        int r121 = r107.hashCode();
        if (r121 == (-1377687758)) goto L67;
        if (r121 == 3046160) goto L64;
        if (r121 == 93819220) goto L61;
    L69:
        String r122 = "";
    L70:
        r108.put("source_page", r122);
    L72:
        if (r108 == null) goto L75;
        r100.addOrReplaceParam("ad_extra_data", r108);
    L75:
        if (Intrinsics.areEqual("1", r100.getMMap().get("use_rifle")) == true) goto L78;
        r102 = "mega_object";
    L78:
        JSONObject r123 = z1.g(r100.getMMap().get(r102));
        r100.getMMap();
        nl.a r124 = r111.f519523h;
        if (r124 != null) goto L81;
    L93:
        if (r105 == null) goto L96;
        r100.addOrReplaceParam("mega_object", r105);
    L96:
        return r100.build();
    L81:
        if (a2.b(r124.f519512a) == true) goto L84;
        r124 = null;
    L84:
        if (r124 == null) goto L93;
        if (r123 == null) goto L93;
        r123.put("cid", r124.f519512a);
        String r109 = r124.f519513b;
        if (r109 == null) goto L89;
        r123.put("log_extra", r109);
    L89:
        String r125 = r124.f519514c;
        if (r125 == null) goto L92;
        r123.put("ad_extra_data", r125);
    L92:
        r105 = r123;
        goto L93
    L61:
        if (r107.equals("blank") == false) goto L69;
        r122 = "live_product_button";
        goto L70
    L64:
        if (r107.equals(BrowserDependency.UrlClickType.CARD) == false) goto L69;
        r122 = "live_card_button";
        goto L70
    L67:
        if (r107.equals("button") == false) goto L69;
        r122 = "live_confirm_button";
    L71:
        r108 = null;
        goto L72
    L27:
        if (a2.b(r104.f519512a) == true) goto L30;
        r104 = null;
    L30:
        if (r104 == null) goto L40;
        if (r118.get(r103) != null) goto L40;
        r119 = new JSONObject();
        r119.put("cid", r104.f519512a);
        String r126 = r104.f519513b;
        if (r126 == null) goto L36;
        r119.put("log_extra", r126);
    L36:
        String r127 = r104.f519514c;
        if (r127 == null) goto L39;
        r119.put("ad_extra_data", r127);
    L39:
        Unit r128 = Unit.INSTANCE;
        goto L41
    L23:
        r103 = "mega_object";
        goto L24
    }
}
