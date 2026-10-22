package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f183074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f183075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f183076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SkuParams f183077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PageFinder f183078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f183079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f183080g;

    public final String a() {
        uh3.b r100 = this.f183074a.k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    public final mh3.a b() {
        Map<String, mh3.a> r100 = mh3.a.f513939m;
        return mh3.a.C6814a.c(this.f183077d.getMonitorId());
    }

    public final int e() {
        return this.f183077d.getSceneType();
    }

    public final Map<String, Object> g() {
        return this.f183074a.n();
    }

    public final String c() {
        mh3.a r100 = b();
        if (r100 == null) goto L5;
        com.bytedance.android.shopping.sku.common.monitor.error.a r101 = r100.f513942c;
    L7:
        return (String) com.bytedance.android.shopping.sku.common.utils.b.b(r101, "加购 product_id", this.f183074a.h(), this.f183077d.getProductId());
    L5:
        r101 = null;
        goto L7
    }

    public final String d() {
        mh3.a r100 = b();
        if (r100 == null) goto L5;
        com.bytedance.android.shopping.sku.common.monitor.error.a r101 = r100.f513942c;
    L6:
        String r102 = (String) com.bytedance.android.shopping.sku.common.utils.b.b(r101, "加购 promotion_id", this.f183074a.i(), this.f183077d.getPromotionId());
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    public final String f() {
        mh3.a r100 = b();
        if (r100 == null) goto L5;
        com.bytedance.android.shopping.sku.common.monitor.error.a r101 = r100.f513942c;
    L7:
        return (String) com.bytedance.android.shopping.sku.common.utils.b.b(r101, "加购 sku_session_id", this.f183074a.l(), this.f183077d.getSkuSessionId());
    L5:
        r101 = null;
        goto L7
    }

    public c(SkuParams r100, PageFinder r101, Map<String, ? extends Object> r102, float[] r103) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        Intrinsics.checkNotNullParameter(r101, "btmPageFinder");
        Intrinsics.checkNotNullParameter(r102, "businessParamsMap");
        this.f183077d = r100;
        this.f183078e = r101;
        this.f183079f = r102;
        this.f183080g = r103;
        r100.getMonitorId();
        int r104 = a.f183072a;
        mh3.a r105 = b();
        Intrinsics.checkNotNullParameter(r102, "params");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L5
        int r107 = t0.f45720a;     // Catch: Throwable -> L5
        Object r108 = Result.m9449constructorimpl((a) t0.a.f45721a.fromJson(k.b(r102).toString(), a.class));     // Catch: Throwable -> L5
    L7:
        String r109 = null;
        if (Result.m9455isFailureimpl(r108) == false) goto L25;
        if (r105 == null) goto L19;
        com.bytedance.android.shopping.sku.common.monitor.error.a r110 = r105.f513942c;
        if (r110 == null) goto L19;
        SkuErrorMonitorType r111 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Throwable r112 = Result.m9452exceptionOrNullimpl(r108);
        if (r112 == null) goto L16;
        String r113 = r112.getMessage();
        if (r113 == null) goto L16;
    L17:
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r114 = com.bytedance.android.shopping.sku.common.monitor.error.a.f182753b;
        r110.a(r111, r113, null);
    L16:
        r113 = "";
    L19:
        if (ECAppInfoService.f48114e.i() == false) goto L25;
        Throwable r115 = Result.m9452exceptionOrNullimpl(r108);
        if (r115 == null) goto L23;
        throw r115;
    L23:
        throw new Exception("mapToCartParams数据解析失败");
    L25:
        if (Result.m9455isFailureimpl(r108) == false) goto L27;
        r108 = null;
    L27:
        a r116 = (a) r108;
        if (r116 != null) goto L30;
        r116 = new a(null);
    L30:
        this.f183074a = r116;
        String r117 = r116.b();
        boolean r118 = false;
        if (r117 != null) goto L33;
    L36:
        boolean r119 = true;
    L37:
        if (r119 == false) goto L43;
        mh3.a r120 = b();
        if (r120 == null) goto L43;
        com.bytedance.android.shopping.sku.common.monitor.error.a r121 = r120.f513942c;
        if (r121 == null) goto L43;
        SkuErrorMonitorType r122 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r123 = com.bytedance.android.shopping.sku.common.monitor.error.a.f182753b;
        r121.a(r122, "加购缺少btm参数", null);
    L43:
        if (r117 != null) goto L45;
    L46:
        r118 = true;
    L48:
        if ((!r118) == false) goto L50;
        r109 = r117;
    L50:
        if (r109 != null) goto L52;
        r109 = "a1.b5267.c7323.d1871";
    L52:
        this.f183075b = r109;
        this.f183076c = this.f183077d.getStandardAddCartToastType();
        return;
    L45:
        if (StringsKt.isBlank(r117) == false) goto L48;
    L33:
        if (StringsKt.isBlank(r117) == true) goto L36;
        r119 = false;
    L5:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
