package com.bytedance.android.ec.core.opt.ab;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b$\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\b¨\u00066"}, d2 = {"Lcom/bytedance/android/ec/core/opt/ab/k;", "", "", "gcOnPromotionsLaunch", "Z", "e", "()Z", "setGcOnPromotionsLaunch", "(Z)V", "gcOnPromotionsSwipe", "f", "setGcOnPromotionsSwipe", "gcOnDetailLaunch", "c", "setGcOnDetailLaunch", "gcOnDetailSwipe", "d", "setGcOnDetailSwipe", "", "gcDurationOnPromotions", "J", "b", "()J", "setGcDurationOnPromotions", "(J)V", "gcDurationOnDetail", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setGcDurationOnDetail", "jitOnPromotionsSwipe", "m", "setJitOnPromotionsSwipe", "jitOnDetailSwipe", "l", "setJitOnDetailSwipe", "hwLayerOnFloatWindow", ce.f26391f, "setHwLayerOnFloatWindow", "hwLayerOnTopBackgroundView", ce.f26395j, "setHwLayerOnTopBackgroundView", "hwLayerOnIronListHeader", "h", "setHwLayerOnIronListHeader", "hwLayerOnTopCategory", ce.f26396k, "setHwLayerOnTopCategory", "hwLayerOnPromotionItem", RXScreenCaptureService.KEY_INDEX, "setHwLayerOnPromotionItem", "settingGetterOptInToolbar", OfficeSDKRequestTag.KEY_NEW_USER, "setSettingGetterOptInToolbar", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("gc_duration_on_detail")
    private long gcDurationOnDetail;

    @SerializedName("gc_duration_on_promotions")
    private long gcDurationOnPromotions;

    @SerializedName("gc_on_detail_launch")
    private boolean gcOnDetailLaunch;

    @SerializedName("gc_on_detail_swipe")
    private boolean gcOnDetailSwipe;

    @SerializedName("gc_on_promotions_launch")
    private boolean gcOnPromotionsLaunch;

    @SerializedName("gc_on_promotions_swipe")
    private boolean gcOnPromotionsSwipe;

    @SerializedName("hw_layer_on_float_window")
    private boolean hwLayerOnFloatWindow;

    @SerializedName("hw_layer_on_iron_list_header")
    private boolean hwLayerOnIronListHeader;

    @SerializedName("hw_layer_on_promotion_item")
    private boolean hwLayerOnPromotionItem;

    @SerializedName("hw_layer_on_top_background_view")
    private boolean hwLayerOnTopBackgroundView;

    @SerializedName("hw_layer_on_top_category")
    private boolean hwLayerOnTopCategory;

    @SerializedName("jit_on_detail_swipe")
    private boolean jitOnDetailSwipe;

    @SerializedName("jit_on_promotions_swipe")
    private boolean jitOnPromotionsSwipe;

    @SerializedName("setting_getter_opt_in_toolbar")
    private boolean settingGetterOptInToolbar;

    public k() {
        this.gcDurationOnPromotions = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        this.gcDurationOnDetail = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    }

    public final long a() {
        return this.gcDurationOnDetail;
    }

    public final long b() {
        return this.gcDurationOnPromotions;
    }

    public final boolean c() {
        return this.gcOnDetailLaunch;
    }

    public final boolean d() {
        return this.gcOnDetailSwipe;
    }

    public final boolean e() {
        return this.gcOnPromotionsLaunch;
    }

    public final boolean f() {
        return this.gcOnPromotionsSwipe;
    }

    public final boolean g() {
        return this.hwLayerOnFloatWindow;
    }

    public final boolean h() {
        return this.hwLayerOnIronListHeader;
    }

    public final boolean i() {
        return this.hwLayerOnPromotionItem;
    }

    public final boolean j() {
        return this.hwLayerOnTopBackgroundView;
    }

    public final boolean k() {
        return this.hwLayerOnTopCategory;
    }

    public final boolean l() {
        return this.jitOnDetailSwipe;
    }

    public final boolean m() {
        return this.jitOnPromotionsSwipe;
    }

    public final boolean n() {
        return this.settingGetterOptInToolbar;
    }
}
