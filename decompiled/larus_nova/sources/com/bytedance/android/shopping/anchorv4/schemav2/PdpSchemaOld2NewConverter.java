package com.bytedance.android.shopping.anchorv4.schemav2;

import android.app.Activity;
import android.net.Uri;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.base.pdp.PackDataSource;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.AnchorV3Starter;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.launcher.PdpLauncher;
import com.bytedance.android.shopping.anchorv4.perf.preload.PdpPreloadController;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpSchemaOld2NewConverter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f167342d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gl.a f167343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f167344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnchorV3Starter f167345c;

    public static final class Companion {
        public static void a(final AnchorV3Starter r100, final String r101) {
            Intrinsics.checkNotNullParameter(r100, "oldStarter");
            Intrinsics.checkNotNullParameter(r101, "source");
            Activity r102 = ECAppInfoService.f48114e.getCurrentActivity();
            if (r102 == null) goto L5;
            w.f166998b.getClass();
            w.a.c(r102);
        L5:
            final boolean r103 = false;
            b2.b(new PdpSchemaOld2NewConverter$Companion$schemaDiff$1(r100, r101, r103));
        }
    }

    static {
    }

    public final String a() {
        AnchorV3Starter r100 = this.f167345c;
        ECUIParam r101 = r100.C;
        if (r101 == null) goto L44;
        s73.c r102 = this.f167344b.f166993b;
        String r103 = r100.f164376q.getFrameCovImage();
        ECUIParam r104 = this.f167345c.C;
        if (r104 == null) goto L7;
        WireFrameSchemaInfo r105 = r104.getWireFrameSchemaInfo();
    L8:
        JSONObject r106 = this.f167345c.B;
        if (r106 == null) goto L17;
        String r110 = r106.optString("ecom_scene_id");
        if (r110 == null) goto L17;
        List r107 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null);
        if (r107 == null) goto L17;
        String r108 = (String) CollectionsKt.lastOrNull(r107);
        if (r108 == null) goto L17;
        Integer r111 = StringsKt.toIntOrNull(r108);
    L18:
        ECUIParam r109 = this.f167345c.C;
        if (r109 == null) goto L21;
        String r112 = r109.getFirstCid();
    L22:
        boolean r113 = this.f167345c.f164384y.getFullMode();
        ECUIParam r114 = this.f167345c.C;
        if (r114 == null) goto L25;
        float r115 = r114.getHalfHeadScale();
    L26:
        ECUIParam r116 = this.f167345c.C;
        if (r116 == null) goto L29;
        int r117 = r116.getHalfHeadSpace();
    L30:
        ECUIParam r118 = this.f167345c.C;
        if (r118 == null) goto L36;
        String r119 = r118.getPdpHalf2026HeightType();
        if (r119 == null) goto L36;
        String r120 = r119;
    L37:
        String r121 = this.f167345c.f164381v;
        if (r121 == null) goto L42;
        JSONObject r122 = com.bytedance.android.shopping.extensions.k.w(r121);
        if (r122 == null) goto L42;
        String r123 = r122.optString("is_explaining");
    L43:
        r101.setWireFrameSchemaInfo(r102.a(r103, r105, r111, r112, r113, r115, r117, r120, Intrinsics.areEqual(r123, "1")));
    L42:
        r123 = null;
    L36:
        r120 = "";
        goto L37
    L29:
        r117 = 0;
        goto L30
    L25:
        r115 = 0.0f;
        goto L26
    L21:
        r112 = null;
    L17:
        r111 = null;
        goto L18
    L7:
        r105 = null;
    L44:
        int r124 = ECSdk.f48106a;
        IEntranceInfoService r125 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r125 == null) goto L47;
        gl.a r126 = r125.initEntranceInfo(new EntranceInfoScene("productDetail", "initParamsInPdpSchemaModel"), this.f167345c.f164381v);
    L48:
        this.f167343a = r126;
        if (r126 == null) goto L57;
        Pair<String, ? extends Object>[] r127 = new Pair[9];
        r127[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, this.f167345c.A.getEnterFrom());
        r127[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, com.bytedance.android.shopping.extensions.h.b(this.f167345c.A));
        r127[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "");
        r127[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_WHICH_ACCOUNT, this.f167345c.A.getWhichAccount());
        String r128 = this.f167345c.A.getV3EventsAdditions();
        if (r128 == null) goto L55;
        JSONObject r129 = com.bytedance.android.shopping.extensions.k.w(r128);
        if (r129 == null) goto L55;
        String r130 = r129.optString("search_params");
    L56:
        r127[4] = TuplesKt.to("search_params", r130);
        r127[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.f167345c.A.getRecommendInfo());
        r127[6] = TuplesKt.to("request_id", this.f167345c.A.getRequestId());
        r127[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, this.f167345c.A.getProductSourcePage());
        r127[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, this.f167345c.A.getModuleLabel());
        r126.b(r127, PdpSchemaOld2NewConverter$processParams$1.INSTANCE);
    L55:
        r130 = null;
    L57:
        gl.a r131 = this.f167343a;
        if (r131 == null) goto L66;
        Pair<String, ? extends Object>[] r132 = new Pair[1];
        String r133 = this.f167345c.A.getV3EventsAdditions();
        if (r133 == null) goto L64;
        JSONObject r134 = com.bytedance.android.shopping.extensions.k.w(r133);
        if (r134 == null) goto L64;
        String r135 = r134.optString(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
    L65:
        r132[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r135);
        r131.b(r132, PdpSchemaOld2NewConverter$processParams$2.INSTANCE);
    L64:
        r135 = null;
    L66:
        gl.a r136 = this.f167343a;
        if (r136 == null) goto L74;
        Pair<String, ? extends Object>[] r137 = new Pair[3];
        r137[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, this.f167345c.A.getLabelNameLive());
        ECAdLogExtra r138 = this.f167345c.f164379t;
        if (r138 == null) goto L71;
        String r139 = r138.getCreativeId();
    L72:
        r137[1] = TuplesKt.to("cid", r139);
        r137[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FRIENDS_ECOM_TAG, this.f167345c.f164377r.getTopLabelText());
        r136.b(r137, PdpSchemaOld2NewConverter$processParams$3.INSTANCE);
        goto L74
    L71:
        r139 = null;
    L74:
        if (cg4.a.a(this.f167345c.f164377r.getUserId()) == true) goto L76;
    L82:
        String r140 = this.f167345c.A.getTransitionTrackerData();
        if (r140 == null) goto L89;
        JSONObject r141 = com.bytedance.android.shopping.extensions.k.w(r140);
        if (r141 == null) goto L89;
        gl.a r142 = this.f167343a;
        if (r142 == null) goto L89;
        r142.i(r141);
    L89:
        gl.a r143 = this.f167343a;
        if (r143 == null) goto L92;
        r143.b(new Pair[]{TuplesKt.to("group_id", this.f167345c.f164377r.getItemId()), TuplesKt.to("promotion_id", this.f167345c.f164376q.getCurrentPromotionId())}, new PdpSchemaOld2NewConverter$processParams$5(this));
    L92:
        String r144 = this.f167345c.A.getV3EventsAdditions();
        if (r144 == null) goto L103;
        JSONObject r145 = com.bytedance.android.shopping.extensions.k.w(r144);
        if (r145 == null) goto L103;
        String r146 = r145.optString("transmissible_json");
        if (r146 == null) goto L103;
        final JSONObject r147 = com.bytedance.android.shopping.extensions.k.w(r146);
        if (r147 == null) goto L103;
        gl.a r148 = this.f167343a;
        if (r148 == null) goto L103;
        r148.j(new Pair[]{TuplesKt.to("promotion_id", r147.optString("promotion_id")), TuplesKt.to("anchor_id", r147.optString("anchor_id")), TuplesKt.to("room_id", r147.optString("room_id"))}, new PdpSchemaOld2NewConverter$processParams$6$1(r147));
    L103:
        gl.a r149 = this.f167343a;
        if (r149 == null) goto L110;
        Pair<String, ? extends Object>[] r150 = new Pair[1];
        ECUIParam r151 = this.f167345c.C;
        if (r151 == null) goto L108;
        String r152 = r151.getIconType();
    L109:
        r150[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ICON, r152);
        r149.g(r150);
        goto L110
    L108:
        r152 = null;
    L110:
        int r153 = com.bytedance.android.shopping.utils.w.f187158a;
        JSONObject r154 = this.f167345c.f164378s;
        gl.a r155 = this.f167343a;
        if (r155 == null) goto L113;
        String r156 = r155.h();
    L114:
        com.bytedance.android.shopping.utils.w.a(r154, r156);
        AnchorV3Starter r157 = this.f167345c;
        JSONObject r158 = r157.f164378s;
        ECAdLogExtra r159 = r157.f164379t;
        Intrinsics.checkNotNullParameter(r158, "metaParam");
        if (r159 == null) goto L119;
        String r160 = r159.getCreativeId();
        if (r160 == null) goto L119;
    L120:
        com.bytedance.android.shopping.extensions.d.b(r158, "creative_id", r160);
        String r161 = this.f167345c.A.getV3EventsAdditions();
        if (r161 == null) goto L125;
        JSONObject r162 = com.bytedance.android.shopping.extensions.k.w(r161);
        if (r162 == null) goto L125;
        String r163 = r162.optString("transmissible_json");
    L126:
        JSONObject r164 = com.bytedance.android.shopping.extensions.k.w(r163);
        if (r164 == null) goto L131;
        gl.a r165 = this.f167343a;
        if (r165 == null) goto L131;
        r165.i(r164);
    L131:
        Map<String, xg.b> r166 = xg.a.f563565a;
        a.C2525a r167 = a.f167365a;
        AnchorV3Starter r168 = this.f167345c;
        gl.a r169 = this.f167343a;
        r167.getClass();
        JSONObject r170 = a.C2525a.b(r168, r169);
        Intrinsics.checkNotNullParameter("iesec_goods_detail", "type");
        Intrinsics.checkNotNullParameter(r170, "params");
        xg.b r171 = (xg.b) ((LinkedHashMap) xg.a.f563565a).get("iesec_goods_detail");
        if (r171 == null) goto L137;
        long r172 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r171, PrefetchTiming.ROUTER);
        dm.a.a("eztf").b("use native convertor, type: iesec_goods_detail", null);
        String r173 = r171.a(r170);
        pi.b r174 = (pi.b) ECSdk.a(pi.b.class);
        if (r174 == null) goto L136;
        JSONObject r175 = new JSONObject();
        r175.put("run_time", System.currentTimeMillis() - r172);
        r171.tag();
        r175.put("tag", "iesec_goods_detail");
        r175.put("js_success", true);
        r175.put("error_reason", null);
        Unit r176 = Unit.INSTANCE;
        r174.monitorEvent("iesec_eztf_invoke_quality", r175, null, null);
    L136:
        return r173;
    L137:
        dm.a.a("eztf").b("generate schema error: target router is empty, type: iesec_goods_detail", null);
        throw new Exception("target router is empty");
    L125:
        r163 = null;
    L119:
        r160 = null;
        goto L120
    L113:
        r156 = null;
        goto L114
    L76:
        if (com.bytedance.android.shopping.extensions.h.d(this.f167345c.A) == true) goto L82;
        if (com.bytedance.android.shopping.extensions.h.c(this.f167345c.A) == true) goto L82;
        gl.a r177 = this.f167343a;
        if (r177 == null) goto L82;
        r177.g(new Pair[]{TuplesKt.to("anchor_id", this.f167345c.f164377r.getUserId())});
        goto L82
    L47:
        r126 = null;
        goto L48
    }

    public PdpSchemaOld2NewConverter(AnchorV3Starter r100) {
        Intrinsics.checkNotNullParameter(r100, "oldStarter");
        this.f167345c = r100;
        u r101 = new u(0);
        if (PdpAB.b() == false) goto L5;
        r101.f166994c = new PdpPreloadController();
    L5:
        Unit r102 = Unit.INSTANCE;
        this.f167344b = r101;
    }

    public final void c(String r210) {
        String r100 = a();
        new PdpLauncher(this.f167345c.getContext()).b(UriProtector.parse(r100), new p83.h(this.f167345c.D, null, null, true, null, null, null, null, null, null, null, Boolean.TRUE, r210, null, null, 13631478), new ze.a(PackDataSource.FORCE_NET));
    }

    public final void d(String r210) {
        cl.d.f24079a.getClass();
        cl.d r100 = cl.d.a.b();
        if (r100 == null) goto L5;
        r100.b();
    L5:
        long r101 = System.currentTimeMillis();
        String r102 = a();
        new PdpLauncher(this.f167345c.getContext()).c(UriProtector.parse(r102), new p83.h(this.f167345c.D, null, null, false, null, null, null, null, null, null, null, Boolean.TRUE, r210, Long.valueOf(r101), Long.valueOf(System.currentTimeMillis() - r101), MethodCollector.METHOD_ID_DISPATCH));
    }

    public final void b(String r100, String r101, String r102, String r103) {
        if (ECAppInfoService.f48114e.i() == false) goto L5;
        String r104 = "schema_report_localtest";
    L6:
        int r105 = ECSdk.f48106a;
        pi.b r106 = (pi.b) ECSdk.a(pi.b.class);
        if (r106 == null) goto L23;
        JSONObject r107 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r107, "in_schema", r100);
        KtSafeMethodExtensionKt.safePut(r107, "out_schema", r101);
        Uri r108 = this.f167345c.N;
        if (r108 == null) goto L20;
        Uri.Builder r109 = r108.buildUpon();
        if (r109 == null) goto L20;
        Uri.Builder r110 = r109.appendQueryParameter("code_source", r103);
        if (r110 == null) goto L20;
        Uri.Builder r111 = r110.appendQueryParameter("session_id", this.f167345c.z());
        if (r111 == null) goto L20;
        Uri r112 = r111.build();
        if (r112 == null) goto L20;
        String r113 = r112.toString();
        if (r113 == null) goto L20;
    L21:
        KtSafeMethodExtensionKt.safePut(r107, "pdp_schema", r113);
        KtSafeMethodExtensionKt.safePut(r107, "location", r102);
        KtSafeMethodExtensionKt.safePut(r107, "business", "productDetail");
        KtSafeMethodExtensionKt.safePut(r107, "source", r103);
        KtSafeMethodExtensionKt.safePut(r107, "session_id", this.f167345c.z());
        Unit r114 = Unit.INSTANCE;
        r106.monitorEvent(r104, r107, null, null);
        return;
    L20:
        r113 = "code_source=" + r103;
        goto L21
    L23:
        return;
    L5:
        r104 = "schema_report";
        goto L6
    }
}
