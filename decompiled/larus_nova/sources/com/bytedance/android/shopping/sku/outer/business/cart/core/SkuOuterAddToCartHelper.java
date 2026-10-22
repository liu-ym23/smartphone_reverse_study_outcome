package com.bytedance.android.shopping.sku.outer.business.cart.core;

import android.view.View;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuOuterAddToCartHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mh3.a f183065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.ec.core.async.b f183066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f183067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f183068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<SkuCartResult, Unit> f183069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.sku.common.ability.a f183070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f183071g;

    public final void d() {
        com.bytedance.android.shopping.sku.common.utils.d.b(CollectionsKt.listOf(new com.bytedance.android.shopping.sku.common.utils.a[]{com.bytedance.android.shopping.sku.common.utils.d.a("监控", new SkuOuterAddToCartHelper$start$1(this)), com.bytedance.android.shopping.sku.common.utils.d.a("【NavBtnClickHelper.onClickAddShopCartImpl】请求加入购物车的网络接口", new SkuOuterAddToCartHelper$start$2(this)), com.bytedance.android.shopping.sku.common.utils.d.a("【checkSuccess】通知营销层用户下单行为", SkuOuterAddToCartHelper$start$3.INSTANCE), com.bytedance.android.shopping.sku.common.utils.d.a("【checkSuccess】logAdEvent host service", new SkuOuterAddToCartHelper$start$4(this))}));
    }

    public final void c(String r100) {
        boolean r101 = true;
        if (this.f183067c.f183077d.getEnableAddCartFailToastForSchema() == false) goto L5;
    L6:
        int r102 = SkuCommonToast.f182777a;
        if (r100 != null) goto L9;
    L16:
        r100 = "添加失败，请稍后重试";
    L17:
        SkuCommonToast.c(r100);
        return;
    L9:
        if (r100.length() > 0) goto L12;
        r101 = false;
    L12:
        if (r101 == true) goto L15;
        r100 = null;
    L15:
        if (r100 != null) goto L17;
    L5:
        if (this.f183067c.f183076c == 1) goto L6;
    }

    public final void b(String r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L15;
        mh3.a r103 = this.f183065a;
        if (r103 == null) goto L16;
        com.bytedance.android.shopping.sku.common.monitor.error.a r104 = r103.f513942c;
        if (r104 == null) goto L17;
        SkuErrorMonitorType r105 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        String r106 = r100 + 20026 + r101 + ", product_id:" + this.f183067c.c();
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r107 = com.bytedance.android.shopping.sku.common.monitor.error.a.f182753b;
        r104.a(r105, r106, null);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L4:
        if (r101.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public static final void a(SkuOuterAddToCartHelper r100, String r101, String r102, String r103, Integer r104) {
        r100.getClass();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L19
        String r106 = new JSONObject(r101).optString("btm_show_id");     // Catch: Throwable -> L19
        int r107 = b.f183073a;     // Catch: Throwable -> L19
        LinkedHashMap r108 = new LinkedHashMap();     // Catch: Throwable -> L19
        String r109 = r100.f183067c.f183077d.getEntranceInfo();     // Catch: Throwable -> L19
        if (r109 == null) goto L6;
        r108.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r109);     // Catch: Throwable -> L19
    L6:
        SkuExtraData r110 = r100.f183067c.f183077d.getSkuExtraData();     // Catch: Throwable -> L19
        if (r110 == null) goto L9;
        Map<String, Object> r111 = r110.getAddCartTrackMeta();     // Catch: Throwable -> L19
    L10:
        if (r111 == null) goto L17;
        Iterator<Map.Entry<String, Object>> r112 = r111.entrySet().iterator();     // Catch: Throwable -> L19
    L13:
        if (r112.hasNext() == false) goto L17;
        Map.Entry<String, Object> r113 = r112.next();     // Catch: Throwable -> L19
        if (r113.getValue() == null) goto L13;
        r108.put(r113.getKey(), r113.getValue());     // Catch: Throwable -> L19
    L17:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L19
        b.c(r102, r106, r103, r104, r108);     // Catch: Throwable -> L19
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L9:
        r111 = null;
    L19:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public SkuOuterAddToCartHelper(mh3.a r100, com.bytedance.android.shopping.sku.inner.container.b r101, c r102, View r103, Function1 r104, com.bytedance.android.shopping.sku.inner.function.business.a r105, Function0 r106) {
        Intrinsics.checkNotNullParameter(r101, "disposableScope");
        Intrinsics.checkNotNullParameter(r102, "cartData");
        Intrinsics.checkNotNullParameter(r105, "skuAddCartListener");
        this.f183065a = r100;
        this.f183066b = r101;
        this.f183067c = r102;
        this.f183068d = r103;
        this.f183069e = r104;
        this.f183070f = r105;
        this.f183071g = r106;
    }
}
