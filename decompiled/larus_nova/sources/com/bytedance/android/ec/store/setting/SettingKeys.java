package com.bytedance.android.ec.store.setting;

import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.dataplatform.config.SettingPanel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b'\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b@\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u001a8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010$\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\"\u0010\u0004R\u001a\u0010'\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u0004R\u001a\u0010*\u001a\u00020\u001a8GX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b(\u0010\u001cR\u001a\u0010-\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0006\u001a\u0004\b+\u0010\u0004R\u001a\u00100\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b.\u0010\u0004R\u001a\u00103\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0006\u001a\u0004\b1\u0010\u0004R\u001a\u00106\u001a\u00020\u001a8GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0006\u001a\u0004\b4\u0010\u001cR\u001a\u00109\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0006\u001a\u0004\b7\u0010\u0004R\u001a\u0010<\u001a\u00020\u001a8GX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0006\u001a\u0004\b:\u0010\u001cR\u001a\u0010?\u001a\u00020\u001a8GX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0006\u001a\u0004\b=\u0010\u001c¨\u0006A"}, d2 = {"Lcom/bytedance/android/ec/store/setting/SettingKeys;", "", "", "getLYNX_STORE_CATEGORY_SCHEMA", "()Ljava/lang/String;", "getLYNX_STORE_CATEGORY_SCHEMA$annotations", "()V", "LYNX_STORE_CATEGORY_SCHEMA", "getSTORE_MOMENT_TAB_PREFETCH_LYNX_URL", "getSTORE_MOMENT_TAB_PREFETCH_LYNX_URL$annotations", "STORE_MOMENT_TAB_PREFETCH_LYNX_URL", "getSTORE_LYNX_FLOAT_LAYER_NAME", "getSTORE_LYNX_FLOAT_LAYER_NAME$annotations", "STORE_LYNX_FLOAT_LAYER_NAME", "getSTORE_EXIT_INTERCEPTION_CONFIGS", "getSTORE_EXIT_INTERCEPTION_CONFIGS$annotations", "STORE_EXIT_INTERCEPTION_CONFIGS", "getECOM_SHOP_INFO_AREA_LYNX_RES", "getECOM_SHOP_INFO_AREA_LYNX_RES$annotations", "ECOM_SHOP_INFO_AREA_LYNX_RES", "getLYNX_STORE_V2_SELECTION_SCHEMA", "getLYNX_STORE_V2_SELECTION_SCHEMA$annotations", "LYNX_STORE_V2_SELECTION_SCHEMA", "getSTORE_V2_PUBLICITY_TEXT", "getSTORE_V2_PUBLICITY_TEXT$annotations", "STORE_V2_PUBLICITY_TEXT", "", "getUSE_AB_SDK", "()Z", "getUSE_AB_SDK$annotations", "USE_AB_SDK", "getEC_SEARCH_PAGE_URL", "getEC_SEARCH_PAGE_URL$annotations", "EC_SEARCH_PAGE_URL", "getEC_COMMERCE_WINDOW_COMMENT_GUIDE_TOAST", "getEC_COMMERCE_WINDOW_COMMENT_GUIDE_TOAST$annotations", "EC_COMMERCE_WINDOW_COMMENT_GUIDE_TOAST", "getEC_COMMERCE_WINDOW_LYNX_EVENT_CARD_URL", "getEC_COMMERCE_WINDOW_LYNX_EVENT_CARD_URL$annotations", "EC_COMMERCE_WINDOW_LYNX_EVENT_CARD_URL", "getEC_COMMERCE_WINDOW_TAB_LIST_ENABLE_ANIMATION", "getEC_COMMERCE_WINDOW_TAB_LIST_ENABLE_ANIMATION$annotations", "EC_COMMERCE_WINDOW_TAB_LIST_ENABLE_ANIMATION", "getLYNX_SHOP_FOLLOW", "getLYNX_SHOP_FOLLOW$annotations", "LYNX_SHOP_FOLLOW", "getLYNX_WINDOW_PRELOAD_CARD_URL", "getLYNX_WINDOW_PRELOAD_CARD_URL$annotations", "LYNX_WINDOW_PRELOAD_CARD_URL", "getWINDOW_TAG_PRE_CREATE", "getWINDOW_TAG_PRE_CREATE$annotations", "WINDOW_TAG_PRE_CREATE", "getSHOP_LIVE_TRY_AGAIN_SWITCH", "getSHOP_LIVE_TRY_AGAIN_SWITCH$annotations", "SHOP_LIVE_TRY_AGAIN_SWITCH", "getPUBLIC_REPUTATION_SCHEMA", "getPUBLIC_REPUTATION_SCHEMA$annotations", "PUBLIC_REPUTATION_SCHEMA", "getEC_TAB_KIT_BTM_ADD", "getEC_TAB_KIT_BTM_ADD$annotations", "EC_TAB_KIT_BTM_ADD", "getEC_TABKIT_DISABLE_PAGEVIEW_SINGLE", "getEC_TABKIT_DISABLE_PAGEVIEW_SINGLE$annotations", "EC_TABKIT_DISABLE_PAGEVIEW_SINGLE", "<init>", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@OptSetting(business = "shopping专用")
public final class SettingKeys {
    public static final SettingKeys INSTANCE = null;

    private SettingKeys() {
    }

    @JvmStatic
    public static /* synthetic */ void getECOM_SHOP_INFO_AREA_LYNX_RES$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_COMMERCE_WINDOW_COMMENT_GUIDE_TOAST$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_COMMERCE_WINDOW_LYNX_EVENT_CARD_URL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_COMMERCE_WINDOW_TAB_LIST_ENABLE_ANIMATION$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_SEARCH_PAGE_URL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_TABKIT_DISABLE_PAGEVIEW_SINGLE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_TAB_KIT_BTM_ADD$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLYNX_SHOP_FOLLOW$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLYNX_STORE_CATEGORY_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLYNX_STORE_V2_SELECTION_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLYNX_WINDOW_PRELOAD_CARD_URL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getPUBLIC_REPUTATION_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSHOP_LIVE_TRY_AGAIN_SWITCH$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSTORE_EXIT_INTERCEPTION_CONFIGS$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSTORE_LYNX_FLOAT_LAYER_NAME$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSTORE_MOMENT_TAB_PREFETCH_LYNX_URL$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSTORE_V2_PUBLICITY_TEXT$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getUSE_AB_SDK$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getWINDOW_TAG_PRE_CREATE$annotations() {
    }

    static {
        INSTANCE = new SettingKeys();
    }

    @SettingPanel("店铺店招区Lynx重构资源配置")
    public static final String getECOM_SHOP_INFO_AREA_LYNX_RES() {
        int r100 = p.f45243a;
        Object r101 = SliceInitService.DEFAULT_SWITCH;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ecom_shop_info_area_lynx_res", String.class, SliceInitService.DEFAULT_SWITCH, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("橱窗退出时候的拦截配置")
    public static final String getEC_COMMERCE_WINDOW_COMMENT_GUIDE_TOAST() {
        int r100 = p.f45243a;
        Object r101 = SliceInitService.DEFAULT_SWITCH;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ecom_window_comment_guide_toast", String.class, SliceInitService.DEFAULT_SWITCH, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("橱窗LynxEventCard Url")
    public static final String getEC_COMMERCE_WINDOW_LYNX_EVENT_CARD_URL() {
        int r100 = p.f45243a;
        Object r101 = "hybrid://lynxview?surl=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_window_lynx_card%2Fecom_window_page_event_card%2Ftemplate.js";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ecom_window_lynx_event_card_url", String.class, "hybrid://lynxview?surl=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_window_lynx_card%2Fecom_window_page_event_card%2Ftemplate.js", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("橱窗底部列表启用动画")
    public static final boolean getEC_COMMERCE_WINDOW_TAB_LIST_ENABLE_ANIMATION() {
        int r100 = p.f45243a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("window_enable_list_animation", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("搜索中间页面url")
    public static final String getEC_SEARCH_PAGE_URL() {
        int r100 = p.f45243a;
        Object r101 = "aweme://search?search_style=commodity_center&enter_from=search_product_detail&previous_page=search_product_detail&from=search_product_detail&previousPage=search_product_detail&transitionType=1&trending_words_from=search_bar_outer";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ecomterm_search_page_url", String.class, "aweme://search?search_style=commodity_center&enter_from=search_product_detail&previous_page=search_product_detail&from=search_product_detail&previousPage=search_product_detail&transitionType=1&trending_words_from=search_bar_outer", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("TabKit单tab禁用PageView降级开关")
    public static final boolean getEC_TABKIT_DISABLE_PAGEVIEW_SINGLE() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_tabkit_disable_pageview_single", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("TabKit新增BTM埋点")
    public static final boolean getEC_TAB_KIT_BTM_ADD() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ec_tab_kit_btm_add", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("店铺关注跳转粉丝券url")
    public static final String getLYNX_SHOP_FOLLOW() {
        int r100 = p.f45243a;
        Object r101 = "sslocal://webcast_lynxview?url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fmono%2Flynx%2Ffe_lynx_ecommerce_store%2Fapp%2Fcoupon%2Ftemplate.js&type=popup&gravity=center&open_animate=0&enable_full_screen=1&height_percent=100&width_percent=100&show_dim=1&mask_alpha=0.5";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ecom_store_coupon_guide_lynx_url", String.class, "sslocal://webcast_lynxview?url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fmono%2Flynx%2Ffe_lynx_ecommerce_store%2Fapp%2Fcoupon%2Ftemplate.js&type=popup&gravity=center&open_animate=0&enable_full_screen=1&height_percent=100&width_percent=100&show_dim=1&mask_alpha=0.5", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("电商Lynx分类页")
    public static final String getLYNX_STORE_CATEGORY_SCHEMA() {
        int r100 = p.f45243a;
        Object r101 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/fe_lynx_ecommerce_shop/classification/template.js";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("lynx_classification_bundle_url", String.class, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/fe_lynx_ecommerce_shop/classification/template.js", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("橱窗精选Tab页兜底lynx url")
    public static final String getLYNX_STORE_V2_SELECTION_SCHEMA() {
        int r100 = p.f45243a;
        Object r101 = "aweme://lynxview/?channel=fe_lynx_commerce_shop_merch&bundle=app/template.js&should_full_screen=1&enable_immersion_keyboard_control=0&status_font_dark=0&hide_debug_label=1&thread_strategy=2&dynamic=1";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("shopping_degraded_selection_tab_schema", String.class, "aweme://lynxview/?channel=fe_lynx_commerce_shop_merch&bundle=app/template.js&should_full_screen=1&enable_immersion_keyboard_control=0&status_font_dark=0&hide_debug_label=1&thread_strategy=2&dynamic=1", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("橱窗lynx卡bundle_url")
    public static final String getLYNX_WINDOW_PRELOAD_CARD_URL() {
        int r100 = p.f45243a;
        Object r101 = "";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("window_preload_lynx_card", String.class, "", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("卖货口碑页面 url")
    public static final String getPUBLIC_REPUTATION_SCHEMA() {
        int r100 = p.f45243a;
        Object r101 = "aweme://webview/?url=https%3A%2F%2Fffh.jinritemai.com%2Ffalcon%2Fe_commerce%2Frn%2Fpublic_reputation%3Fsec_author_id%3Dsec_author_id_placeholder%26dynamic%3D1%26follow_status%3Dfollow_status_placeholder%26author_id%3Dauthor_uid_placeholder%26hide_nav_bar%3D1%26status_font_dark%3D1%26status_bar_color%3Dffffff%26loading_bgcolor%3Dffffff%26enter_from%3Denter_from_placeholder&rn_schema=aweme%3A%2F%2Freactnative%2F%3Fmodule_name%3Dpage_public_reputation%26channel%3Dfe_lyon_public_reputation%26bundle%3Dindex.js%26dynamic%3D1%26sec_author_id%3Dsec_author_id_placeholder%26follow_status%3Dfollow_status_placeholder%26author_id%3Dauthor_uid_placeholder%26hide_nav_bar%3D1%26enter_form%3Denter_from_placeholder%26status_font_dark%3D1%26status_bar_color%3Dffffff%26loading_bgcolor%3Dffffff";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ecomterm_public_reputation_schema", String.class, "aweme://webview/?url=https%3A%2F%2Fffh.jinritemai.com%2Ffalcon%2Fe_commerce%2Frn%2Fpublic_reputation%3Fsec_author_id%3Dsec_author_id_placeholder%26dynamic%3D1%26follow_status%3Dfollow_status_placeholder%26author_id%3Dauthor_uid_placeholder%26hide_nav_bar%3D1%26status_font_dark%3D1%26status_bar_color%3Dffffff%26loading_bgcolor%3Dffffff%26enter_from%3Denter_from_placeholder&rn_schema=aweme%3A%2F%2Freactnative%2F%3Fmodule_name%3Dpage_public_reputation%26channel%3Dfe_lyon_public_reputation%26bundle%3Dindex.js%26dynamic%3D1%26sec_author_id%3Dsec_author_id_placeholder%26follow_status%3Dfollow_status_placeholder%26author_id%3Dauthor_uid_placeholder%26hide_nav_bar%3D1%26enter_form%3Denter_from_placeholder%26status_font_dark%3D1%26status_bar_color%3Dffffff%26loading_bgcolor%3Dffffff", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("店铺直播失败机制")
    public static final boolean getSHOP_LIVE_TRY_AGAIN_SWITCH() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("shop_live_try_again", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("店铺返回拦截跳转页面配置")
    public static final String getSTORE_EXIT_INTERCEPTION_CONFIGS() {
        int r100 = p.f45243a;
        Object r101 = SliceInitService.DEFAULT_SWITCH;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("store_exit_interception_configs", String.class, SliceInitService.DEFAULT_SWITCH, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("会挡住店铺置顶按钮的浮层")
    public static final String getSTORE_LYNX_FLOAT_LAYER_NAME() {
        int r100 = p.f45243a;
        Object r101 = "[]";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("store_lynx_float_layer_name", String.class, "[]", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("店铺动态预加载Lynx卡片列表")
    public static final String getSTORE_MOMENT_TAB_PREFETCH_LYNX_URL() {
        int r100 = p.f45243a;
        Object r101 = "";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("shop_moments_preload_lynx_card", String.class, "", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("橱窗商品Tab页法务文案")
    public static final String getSTORE_V2_PUBLICITY_TEXT() {
        int r100 = p.f45243a;
        Object r101 = "本橱窗账号为 name_placeholder 绑定账号newline_placeholder橱窗内所有「自卖商品」均为该店铺商品";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("shopping_store_product_publicity", String.class, "本橱窗账号为 name_placeholder 绑定账号newline_placeholder橱窗内所有「自卖商品」均为该店铺商品", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("是否启用AB Sdk")
    public static final boolean getUSE_AB_SDK() {
        int r100 = p.f45243a;
        Object r101 = Boolean.FALSE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("ecomterm_use_abtest_sdk", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("橱窗标签预创建")
    public static final String getWINDOW_TAG_PRE_CREATE() {
        int r100 = p.f45243a;
        Object r101 = "";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("window_tag_pre_create", String.class, "", false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }
}
