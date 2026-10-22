package com.bytedance.android.shopping.skubuy.start_flow;

import android.content.Context;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home.BaseStandardHomeFragment;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.Starter;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.c;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.d;
import com.bytedance.android.shopping.model.abscontainer.PerformancePointType;
import com.bytedance.android.shopping.sku.common.controller.SkuCommonBigPicCacheController;
import com.bytedance.android.shopping.skubuy.platform.container.PlatformSkuBuyContainer;
import com.bytedance.android.shopping.skubuy.platform.container.PlatformSkuBuySplitScreenContainer;
import com.bytedance.android.shopping.skubuy.starter.SkuBuyPageInfo;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends u43.a<ISkuBuySchemaModel> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f183200c = 0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.skubuy.start_flow.a$a, reason: collision with other inner class name */
    public static final class C2724a {
    }

    static {
    }

    public final ISkuBuySchemaModel g() {
        return c();
    }

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u43.a
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        u43.a.e(this, PerformancePointType.PARSE_SCHEMA_END);
        Iterator r101 = ((LinkedHashMap) this.f548693a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry r102 = (Map.Entry) r101.next();
        c().skuBuyTimestamp().put(r102.getKey(), r102.getValue());
        goto L4
    L6:
        c r103 = f(r100);
        Lazy r104 = TrackCatcher.f187025a;
        if (TrackCatcher.a.a() == null) goto L9;
        TrackCatcher.a("step_order");
    L9:
        Starter r105 = new Starter(r103, r100);
        d r106 = r105.f164153b.f164172a;
        int r107 = j43.d.f497356a;
        r106.f164163a = Long.valueOf(System.currentTimeMillis());
        int r108 = j43.b.f497354a;
        Context r109 = ECAppInfoService.f48114e.getApplicationContext();
        if (r109 == null) goto L14;
        int r110 = ECSdk.f48106a;
        cj.b r111 = (cj.b) ECSdk.a(cj.b.class);
        if (r111 == null) goto L14;
        r111.e(r109);
    L14:
        r105.a();
        r105.b();
        final String r112 = r103.f164160a.getSessionID();
        b2.b(new SkuBuyStartupFlowController$reportSchema$1(this, r112));
    }

    public final c f(Context r110) {
        ISkuBuySchemaModel r100 = c();
        String r101 = UUID.randomUUID().toString();
        h43.a.a(r110);
        l0.c(r110);
        nj.d r111 = h43.a.b();
        if (r111 == null) goto L5;
        r111.g();
    L5:
        gl.a r112 = c().getEntranceInfo();
        JSONObject r102 = null;
        if (r112 == null) goto L8;
        String r103 = r112.getString(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO);
    L9:
        SkuBuyPageInfo r104 = new SkuBuyPageInfo("yata_skubuy", r101, r100, false, false, r103);
        ISkuBuySchemaModel r113 = c();
        int r105 = com.bytedance.android.shopping.sku.inner.ultimate.b.f182983a;
        r113.replaceOrAppendParam("panel_width", String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.b(r104.f183205d)));
        c().replaceOrAppendParam(BaseStandardHomeFragment.KEY_PANEL_HEIGHT, String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.a()));
        String r114 = c().getQueryParam("id");
        if (r114 != null) goto L12;
        r114 = "";
    L12:
        int r106 = com.bytedance.android.shopping.skubuy.platform.helper.a.f183161a;
        Intrinsics.checkNotNullParameter(r114, "cacheKey");
        com.bytedance.android.shopping.sku.common.controller.b r107 = SkuCommonBigPicCacheController.a(r114);
        if (r107 != null) goto L15;
        String r108 = null;
    L20:
        if (r108 == null) goto L22;
        c().replaceOrAppendParam("spec_mode", r108);
    L22:
        Intrinsics.checkNotNullParameter(r114, "cacheKey");
        com.bytedance.android.shopping.sku.common.controller.b r115 = SkuCommonBigPicCacheController.a(r114);
        if (r115 == null) goto L25;
        String r116 = String.valueOf(r115.f182631b / ((long) 1000));
    L26:
        if (r116 == null) goto L28;
        c().replaceOrAppendParam("spec_mode_time", r116);
    L28:
        gl.a r117 = c().getEntranceInfo();
        if (r117 == null) goto L33;
        JSONObject r118 = r117.e();
        if (r118 == null) goto L33;
        r102 = x0.a(r118);
    L33:
        c43.a r119 = c43.a.f22381a;
        g().getQueryParam(PhotoEnterModel.SOURCE_BTM_TOKEN);
        Intrinsics.checkNotNullParameter("yata_skubuy", "bizCode");
        int r109 = o43.b.f521962a;
        Intrinsics.checkNotNullParameter("yata_skubuy", "bizCode");
        if (r102 != null) goto L36;
        r102 = new JSONObject();
    L36:
        r102.remove(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO);
        c().setFixEntranceInfoStr(r102.toString());
        yh3.b r120 = new yh3.b(r104);
        if (r104.f183205d == false) goto L39;
        Class r121 = PlatformSkuBuySplitScreenContainer.class;
    L41:
        return new c(r104, r120, r121);
    L39:
        r121 = PlatformSkuBuyContainer.class;
        goto L41
    L25:
        r116 = null;
        goto L26
    L15:
        if (r107.f182630a == false) goto L17;
        int r122 = 1;
    L18:
        r108 = String.valueOf(r122);
        goto L20
    L17:
        r122 = 2;
        goto L18
    L8:
        r103 = null;
        goto L9
    }
}
