package com.bytedance.android.shopping.buynow.opt;

import android.net.Uri;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home.BaseStandardHomeFragment;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.android.shopping.buynow.ultimate.data.remote.UltimateBuyNowApi;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import com.bytedance.android.shopping.skubuy.cache.SkuBuyResponseCacheHelper;
import com.bytedance.retrofit2.SsResponse;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ma3.r;
import org.json.JSONArray;
import org.json.JSONObject;
import tf3.l;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171032a = 0;

    static {
    }

    public static com.bytedance.android.shopping.buynow.cache.a a(IOrderSchema r100) {
        Intrinsics.checkNotNullParameter(r100, "orderSchema");
        String r101 = null;
        if (r100.C() == false) goto L19;
        String r102 = r100.getQueryParam("id");
        String r103 = r100.getQueryParam("sku_promotion_id");
        String r104 = r100.getQueryParam("scene_type");
        String r105 = r100.getQueryParam("default_spec_id");
        if (r105 == null) goto L17;
        JSONArray r106 = z1.e(r105);
        if (r106 == null) goto L17;
        boolean r107 = false;
        String r108 = r106.optString(0);
        if (r108 == null) goto L17;
        HashMap<String, JSONObject> r109 = j.f44312a;
        if (j.e(r108) == true) goto L13;
    L15:
        if (r107 == false) goto L17;
        r101 = r108;
        goto L17
    L13:
        if ((!Intrinsics.areEqual(r108, "null")) == false) goto L15;
        r107 = true;
    L17:
        com.bytedance.android.shopping.buynow.cache.a r110 = new com.bytedance.android.shopping.buynow.cache.a(r103, r102, r104, r101);
        r100.X(r110);
        return r110;
    L19:
        return null;
    }

    public static void c(IOrderSchema r100) {
        com.bytedance.android.shopping.buynow.cache.a r101 = a(r100);
        String r102 = null;
        if ((r101 instanceof com.bytedance.android.shopping.buynow.cache.a) == true) goto L5;
        r101 = null;
    L5:
        dm.a.a("BuyNowPrefetcher").a("cache key " + r101);
        Map<String, UltimateBuyCacheQueryHelper> r103 = UltimateBuyCacheHelper.f170708b;
        if (UltimateBuyCacheHelper.a(r101) == true) goto L24;
        Lazy r104 = SkuBuyResponseCacheHelper.f183110a;
        if (r101 == null) goto L10;
        String r105 = r101.f170722a;
    L11:
        if (r101 == null) goto L13;
        String r106 = r101.f170723b;
    L14:
        if (r101 == null) goto L16;
        String r107 = r101.f170724c;
    L17:
        if (r101 == null) goto L19;
        r102 = r101.f170725d;
    L19:
        com.bytedance.android.shopping.skubuy.cache.a r108 = new com.bytedance.android.shopping.skubuy.cache.a(r105, r106, r107, r102);
        com.bytedance.android.shopping.abscontainer.arch.core.cache.b r109 = (com.bytedance.android.shopping.abscontainer.arch.core.cache.b) SkuBuyResponseCacheHelper.f183111b.getValue();
        String r110 = r108.a();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "cacheKey");
        if (SkuBuyResponseCacheHelper.c(r109.f164130a.b(r110)) == true) goto L24;
        dm.a.a("BuyNowPrefetcher").a("prefetchBuyOrderSchema cache INVALID");
        new s().a(r100);
        e(r100);
        return;
    L16:
        r107 = null;
        goto L17
    L13:
        r106 = null;
        goto L14
    L10:
        r105 = null;
    L24:
        dm.a.a("BuyNowPrefetcher").a("prefetchBuyOrderSchema cache VALID");
    }

    public static void e(IOrderSchema r110) {
        dm.a.a("BuyNowPrefetcher").a("prefetchDirectly");
        if (r110 != null) goto L5;
        return;
    L5:
        na3.g r100 = na3.g.f518461a;
        Integer r101 = null;
        com.bytedance.android.shopping.buynow.starter.e r102 = new com.bytedance.android.shopping.buynow.starter.e(r110, null, true);
        Intrinsics.checkNotNullParameter(r102, "requestBuilder");
        ma3.f r103 = r102.a(false);
        if ((r103.f512682a instanceof r) == false) goto L19;
        com.bytedance.android.shopping.buynow.cache.a r104 = a(r102.f171151c);
        dm.a.a("BuyNowPrefetcher").a("prefetch api cache key " + r104);
        r r105 = (r) r103.f512682a;
        int r106 = r103.f512683b;
        int r107 = r103.f512684c;
        String r108 = r102.f171151c.getQueryParam("shape");
        if (r108 == null) goto L11;
        r101 = StringsKt.toIntOrNull(r108);
    L11:
        String r111 = r102.f171151c.getQueryParam("biz_identity");
        Intrinsics.checkNotNullParameter(r105, HiAnalyticsConstant.Direction.REQUEST);
        UltimateBuyNowApi.f171179a.getClass();
        Observable<SsResponse<String>> r109 = UltimateBuyNowApi.a.f171181b.getPrefetchForUltimateBuy(r105, r106, r107, r101, r111);
        Intrinsics.checkNotNullParameter(r109, "$this$putCache");
        Observable<SsResponse<String>> r112 = r109.doOnNext(new com.bytedance.android.shopping.buynow.cache.b(r104, false)).subscribeOn(Schedulers.io());
        if (r112 == null) goto L17;
        Disposable r113 = r112.subscribe(na3.c.f518448a, na3.d.f518449a);
        if (r113 == null) goto L18;
        Intrinsics.checkNotNullParameter(r113, "$this$globalScope");
        return;
    L18:
        return;
    L17:
        return;
    }

    public static void b(ql.a r100, l r101) {
        dm.a.a("BuyNowPrefetcher").a("prefetchAsyncOnLiveRoom");
        com.bytedance.android.shopping.buynow.cache.a r102 = new com.bytedance.android.shopping.buynow.cache.a(r100.getPromotionId(), r100.getProductId(), String.valueOf(201), k.x(r101.f545731a));
        dm.a.a("BuyNowPrefetcher").a(" prefetchAsyncOnLiveRoomcache key " + r102);
        Map<String, UltimateBuyCacheQueryHelper> r103 = UltimateBuyCacheHelper.f170708b;
        if (UltimateBuyCacheHelper.a(r102) == false) goto L6;
        dm.a.a("BuyNowPrefetcher").a("prefetch cache VALID");
        return;
    L6:
        dm.a.a("BuyNowPrefetcher").a("prefetch cache INVALID");
        Uri.Builder r104 = new Uri.Builder().scheme(AppConstants.SCHEME_SS_LOCAL).authority("buy_now");
        r104.appendQueryParameter("id", r100.getProductId());
        r104.appendQueryParameter("is_single_sku", String.valueOf(r100.getSingleSku()));
        r104.appendQueryParameter("group_type", String.valueOf(r100.isMultiGroupBuy()));
        r104.appendQueryParameter("scene_type", String.valueOf(201));
        r104.appendQueryParameter("auto_apply_coupon", String.valueOf(false));
        List<String> r105 = r101.f545731a;
        if (r105 == null) goto L9;
        r104.appendQueryParameter("default_spec_id", k.x(r105));
    L9:
        String r106 = r100.getChannelId();
        if (r106 == null) goto L12;
        r104.appendQueryParameter("product_channel_id", r106);
    L12:
        Integer r107 = r100.getChannelType();
        if (r107 == null) goto L15;
        r104.appendQueryParameter("product_channel_type", String.valueOf(r107.intValue()));
    L15:
        r104.appendQueryParameter("sku_enter_from", "live");
        r104.appendQueryParameter("disable_server_specs_default_select", String.valueOf(false));
        Lazy r108 = ECAppInfoService.f48110a;
        r104.appendQueryParameter("enter_from_live_saas", String.valueOf(we.a.f559330a));
        r104.appendQueryParameter("ultimate_buy_version", "1");
        r104.appendQueryParameter("ultimate_buy_ab", "2");
        r104.appendQueryParameter("sku_promotion_id", r100.getPromotionId());
        r104.appendQueryParameter("panel_width", String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.b(false)));
        r104.appendQueryParameter(BaseStandardHomeFragment.KEY_PANEL_HEIGHT, String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.a()));
        r104.appendQueryParameter("biz_identity", r100.getBizIdentity());
        Uri r109 = r104.build();
        int r110 = ECSdk.f48106a;
        IECCommonService r111 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r111 == null) goto L18;
        IOrderSchema r112 = r111.convertToOrderSchema(r109, new EntranceInfoScene("ecomLive", "enterOrderPage"));
    L19:
        if (r112 == null) goto L21;
        r112.z0();
    L21:
        e(r112);
        return;
    L18:
        r112 = null;
        goto L19
    }

    public static void d(ql.a r100, l r101, BuyNowPrefetchType r102) {
        if (r102 != BuyNowPrefetchType.FIRST_SHOW) goto L12;
        Lazy r103 = ECSettingKeys.f43619d;
        if (((Number) r103.getValue()).intValue() != 2) goto L8;
        dm.a.a("BuyNowPrefetcher").a("prefetch use pitaya");
        dm.a.a("BuyNowPrefetcher").a("prefetchByPitaya");
        int r104 = com.bytedance.android.ec.core.buynow.b.f43911a;
        b(r100, r101);
        return;
    L8:
        if (((Number) r103.getValue()).intValue() != 1) goto L10;
        dm.a.a("BuyNowPrefetcher").a("prefetch not use pitaya");
        b(r100, r101);
        return;
    L10:
        dm.a.a("BuyNowPrefetcher").a("do not prefetch");
        return;
    L12:
        if (r102 != BuyNowPrefetchType.CLICK) goto L23;
        Lazy r105 = ECSettingKeys.f43620e;
        if (((Number) r105.getValue()).intValue() != 2) goto L17;
        dm.a.a("BuyNowPrefetcher").a("prefetch use pitaya");
        dm.a.a("BuyNowPrefetcher").a("prefetchByPitaya");
        int r106 = com.bytedance.android.ec.core.buynow.b.f43911a;
        b(r100, r101);
        return;
    L17:
        if (((Number) r105.getValue()).intValue() != 1) goto L25;
        dm.a.a("BuyNowPrefetcher").a("prefetch not use pitaya");
        b(r100, r101);
        return;
    L25:
        return;
    }
}
