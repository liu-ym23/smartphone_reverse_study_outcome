package com.bytedance.android.ec.core.cart;

import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u001a\u0010 \u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013R\u001a\u0010)\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000bR\u001a\u0010+\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000bR\u001a\u0010-\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b.\u0010\u000bR\u001a\u0010/\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\t\u001a\u0004\b0\u0010\u000bR\u001a\u00101\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b2\u0010\u000bR\u001a\u00103\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b4\u0010\u000bR\u001a\u00105\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b6\u0010\u000bR\"\u00107\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0011\u001a\u0004\b8\u0010\u0013R\u001a\u00109\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010!\u001a\u0004\b:\u0010#R&\u0010<\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000f0;8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010\t\u001a\u0004\bA\u0010\u000b¨\u0006B"}, d2 = {"Lcom/bytedance/android/ec/core/cart/c;", "", "Lcom/bytedance/android/ec/core/cart/d;", "loadMoreInfo", "Lcom/bytedance/android/ec/core/cart/d;", "l", "()Lcom/bytedance/android/ec/core/cart/d;", "", "enableUiAdapt", "Z", "getEnableUiAdapt", "()Z", "bigFontSwitch", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "tabListWidths", "Ljava/util/List;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/util/List;", "enableLynxTypeface", ce.f26396k, "enableHitSlop", ce.f26395j, "counterNormalHitSlop", RXScreenCaptureService.KEY_INDEX, "counterBtnDecreaseHitSlop", ce.f26391f, "counterBtnIncreaseHitSlop", "h", "clickDebounceSwitch", "f", "clickDebounceDuration", "I", "e", "()I", "", "cartSkipExplicitLoadingTriggerList", "d", "bottomPlaceholderEnableScenes", "b", "enableEmptyAdjust", "getEnableEmptyAdjust", "enableForbiddenDataCompareCopy", "getEnableForbiddenDataCompareCopy", "enableNewPageViewLogic", "getEnableNewPageViewLogic", "enableAlignLoadingOpts", "getEnableAlignLoadingOpts", "enableQuestEventParallelExecute", "getEnableQuestEventParallelExecute", "enableNewEventChainLogic", "getEnableNewEventChainLogic", "disableIncrementalFacade", "getDisableIncrementalFacade", "uplinkCodesNeedReload", "p", "cacheValidDuration", "c", "", "templateList", "Ljava/util/Map;", "o", "()Ljava/util/Map;", "submitShowRadiusSwitch", "m", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("big_font_switch")
    private final boolean bigFontSwitch;

    @SerializedName("bottom_placeholder_enable_scenes")
    private final List<String> bottomPlaceholderEnableScenes;

    @SerializedName("cache_valid_timestamp")
    private final int cacheValidDuration;

    @SerializedName("cartSkipExplicitLoadingTriggerList")
    private final List<String> cartSkipExplicitLoadingTriggerList;

    @SerializedName("click_debounce_duration")
    private final int clickDebounceDuration;

    @SerializedName("click_debounce_switch")
    private final boolean clickDebounceSwitch;

    @SerializedName("counter_btn_decrease_hit_slop")
    private final List<Integer> counterBtnDecreaseHitSlop;

    @SerializedName("counter_btn_increase_hit_slop")
    private final List<Integer> counterBtnIncreaseHitSlop;

    @SerializedName("counter_normal_hit_slop")
    private final List<Integer> counterNormalHitSlop;

    @SerializedName("disable_incremental_facade")
    private final boolean disableIncrementalFacade;

    @SerializedName("enableAlignLoadingOpts")
    private final boolean enableAlignLoadingOpts;

    @SerializedName("enableEmptyAdjust")
    private final boolean enableEmptyAdjust;

    @SerializedName("enableForbiddenDataCompareCopy")
    private final boolean enableForbiddenDataCompareCopy;

    @SerializedName("enable_hit_slop")
    private final boolean enableHitSlop;

    @SerializedName("enable_lynx_typeface")
    private final boolean enableLynxTypeface;

    @SerializedName("enableNewEventChainLogic")
    private final boolean enableNewEventChainLogic;

    @SerializedName("enableNewPageViewLogic")
    private final boolean enableNewPageViewLogic;

    @SerializedName("enableQuestEventParallelExecute")
    private final boolean enableQuestEventParallelExecute;

    @SerializedName("enable_ui_adapt")
    private final boolean enableUiAdapt;

    @SerializedName(GYLFetchType.LOAD_MORE)
    private final d loadMoreInfo;

    @SerializedName("submit_show_radius_switch")
    private final boolean submitShowRadiusSwitch;

    @SerializedName("tab_list_widths")
    private final List<Integer> tabListWidths;

    @SerializedName("cart_slice_templates")
    private final Map<String, Integer> templateList;

    @SerializedName("uplink_codes_need_reload")
    private final List<Integer> uplinkCodesNeedReload;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L54;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.loadMoreInfo, r101.loadMoreInfo) == true) goto L8;
        return false;
    L8:
        if (this.enableUiAdapt == r101.enableUiAdapt) goto L10;
        return false;
    L10:
        if (this.bigFontSwitch == r101.bigFontSwitch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabListWidths, r101.tabListWidths) == true) goto L14;
        return false;
    L14:
        if (this.enableLynxTypeface == r101.enableLynxTypeface) goto L16;
        return false;
    L16:
        if (this.enableHitSlop == r101.enableHitSlop) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.counterNormalHitSlop, r101.counterNormalHitSlop) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.counterBtnDecreaseHitSlop, r101.counterBtnDecreaseHitSlop) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.counterBtnIncreaseHitSlop, r101.counterBtnIncreaseHitSlop) == true) goto L24;
        return false;
    L24:
        if (this.clickDebounceSwitch == r101.clickDebounceSwitch) goto L26;
        return false;
    L26:
        if (this.clickDebounceDuration == r101.clickDebounceDuration) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.cartSkipExplicitLoadingTriggerList, r101.cartSkipExplicitLoadingTriggerList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bottomPlaceholderEnableScenes, r101.bottomPlaceholderEnableScenes) == true) goto L32;
        return false;
    L32:
        if (this.enableEmptyAdjust == r101.enableEmptyAdjust) goto L34;
        return false;
    L34:
        if (this.enableForbiddenDataCompareCopy == r101.enableForbiddenDataCompareCopy) goto L36;
        return false;
    L36:
        if (this.enableNewPageViewLogic == r101.enableNewPageViewLogic) goto L38;
        return false;
    L38:
        if (this.enableAlignLoadingOpts == r101.enableAlignLoadingOpts) goto L40;
        return false;
    L40:
        if (this.enableQuestEventParallelExecute == r101.enableQuestEventParallelExecute) goto L42;
        return false;
    L42:
        if (this.enableNewEventChainLogic == r101.enableNewEventChainLogic) goto L44;
        return false;
    L44:
        if (this.disableIncrementalFacade == r101.disableIncrementalFacade) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.uplinkCodesNeedReload, r101.uplinkCodesNeedReload) == true) goto L48;
        return false;
    L48:
        if (this.cacheValidDuration == r101.cacheValidDuration) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.templateList, r101.templateList) == true) goto L52;
        return false;
    L52:
        if (this.submitShowRadiusSwitch == r101.submitShowRadiusSwitch) goto L82;
        return false;
    L82:
        return true;
    L54:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        d r100 = this.loadMoreInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.enableUiAdapt;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.bigFontSwitch;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        List<Integer> r111 = this.tabListWidths;
        if (r111 == null) goto L15;
        int r112 = r111.hashCode();
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.enableLynxTypeface;
        ?? r115 = r114;
        if (r114 == false) goto L19;
        r115 = 1;
    L19:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.enableHitSlop;
        ?? r118 = r117;
        if (r117 == false) goto L22;
        r118 = 1;
    L22:
        int r119 = (r116 + r118) * 31;
        List<Integer> r120 = this.counterNormalHitSlop;
        if (r120 == null) goto L25;
        int r121 = r120.hashCode();
    L26:
        int r122 = (r119 + r121) * 31;
        List<Integer> r123 = this.counterBtnDecreaseHitSlop;
        if (r123 == null) goto L29;
        int r124 = r123.hashCode();
    L30:
        int r125 = (r122 + r124) * 31;
        List<Integer> r126 = this.counterBtnIncreaseHitSlop;
        if (r126 == null) goto L33;
        int r127 = r126.hashCode();
    L34:
        int r128 = (r125 + r127) * 31;
        boolean r129 = this.clickDebounceSwitch;
        ?? r130 = r129;
        if (r129 == false) goto L37;
        r130 = 1;
    L37:
        int r131 = (((r128 + r130) * 31) + this.clickDebounceDuration) * 31;
        List<String> r132 = this.cartSkipExplicitLoadingTriggerList;
        if (r132 == null) goto L40;
        int r133 = r132.hashCode();
    L41:
        int r134 = (r131 + r133) * 31;
        List<String> r135 = this.bottomPlaceholderEnableScenes;
        if (r135 == null) goto L44;
        int r136 = r135.hashCode();
    L45:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.enableEmptyAdjust;
        ?? r139 = r138;
        if (r138 == false) goto L48;
        r139 = 1;
    L48:
        int r140 = (r137 + r139) * 31;
        boolean r141 = this.enableForbiddenDataCompareCopy;
        ?? r142 = r141;
        if (r141 == false) goto L51;
        r142 = 1;
    L51:
        int r143 = (r140 + r142) * 31;
        boolean r144 = this.enableNewPageViewLogic;
        ?? r145 = r144;
        if (r144 == false) goto L54;
        r145 = 1;
    L54:
        int r146 = (r143 + r145) * 31;
        boolean r147 = this.enableAlignLoadingOpts;
        ?? r148 = r147;
        if (r147 == false) goto L57;
        r148 = 1;
    L57:
        int r149 = (r146 + r148) * 31;
        boolean r150 = this.enableQuestEventParallelExecute;
        ?? r151 = r150;
        if (r150 == false) goto L60;
        r151 = 1;
    L60:
        int r152 = (r149 + r151) * 31;
        boolean r153 = this.enableNewEventChainLogic;
        ?? r154 = r153;
        if (r153 == false) goto L63;
        r154 = 1;
    L63:
        int r155 = (r152 + r154) * 31;
        boolean r156 = this.disableIncrementalFacade;
        ?? r157 = r156;
        if (r156 == false) goto L66;
        r157 = 1;
    L66:
        int r158 = (r155 + r157) * 31;
        List<Integer> r159 = this.uplinkCodesNeedReload;
        if (r159 == null) goto L69;
        int r160 = r159.hashCode();
    L70:
        int r161 = (((r158 + r160) * 31) + this.cacheValidDuration) * 31;
        Map<String, Integer> r162 = this.templateList;
        if (r162 == null) goto L73;
        r101 = r162.hashCode();
    L73:
        int r163 = (r161 + r101) * 31;
        boolean r164 = this.submitShowRadiusSwitch;
        if (r164 == true) goto L78;
        r105 = r164;
    L78:
        return r163 + r105;
    L69:
        r160 = 0;
        goto L70
    L44:
        r136 = 0;
        goto L45
    L40:
        r133 = 0;
        goto L41
    L33:
        r127 = 0;
        goto L34
    L29:
        r124 = 0;
        goto L30
    L25:
        r121 = 0;
        goto L26
    L15:
        r112 = 0;
        goto L16
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CartSettingConfig(loadMoreInfo=" + this.loadMoreInfo + ", enableUiAdapt=" + this.enableUiAdapt + ", bigFontSwitch=" + this.bigFontSwitch + ", tabListWidths=" + this.tabListWidths + ", enableLynxTypeface=" + this.enableLynxTypeface + ", enableHitSlop=" + this.enableHitSlop + ", counterNormalHitSlop=" + this.counterNormalHitSlop + ", counterBtnDecreaseHitSlop=" + this.counterBtnDecreaseHitSlop + ", counterBtnIncreaseHitSlop=" + this.counterBtnIncreaseHitSlop + ", clickDebounceSwitch=" + this.clickDebounceSwitch + ", clickDebounceDuration=" + this.clickDebounceDuration + ", cartSkipExplicitLoadingTriggerList=" + this.cartSkipExplicitLoadingTriggerList + ", bottomPlaceholderEnableScenes=" + this.bottomPlaceholderEnableScenes + ", enableEmptyAdjust=" + this.enableEmptyAdjust + ", enableForbiddenDataCompareCopy=" + this.enableForbiddenDataCompareCopy + ", enableNewPageViewLogic=" + this.enableNewPageViewLogic + ", enableAlignLoadingOpts=" + this.enableAlignLoadingOpts + ", enableQuestEventParallelExecute=" + this.enableQuestEventParallelExecute + ", enableNewEventChainLogic=" + this.enableNewEventChainLogic + ", disableIncrementalFacade=" + this.disableIncrementalFacade + ", uplinkCodesNeedReload=" + this.uplinkCodesNeedReload + ", cacheValidDuration=" + this.cacheValidDuration + ", templateList=" + this.templateList + ", submitShowRadiusSwitch=" + this.submitShowRadiusSwitch + ")";
    }

    public final boolean a() {
        return this.bigFontSwitch;
    }

    public final List<String> b() {
        return this.bottomPlaceholderEnableScenes;
    }

    public final int c() {
        return this.cacheValidDuration;
    }

    public final List<String> d() {
        return this.cartSkipExplicitLoadingTriggerList;
    }

    public final int e() {
        return this.clickDebounceDuration;
    }

    public final boolean f() {
        return this.clickDebounceSwitch;
    }

    public final List<Integer> g() {
        return this.counterBtnDecreaseHitSlop;
    }

    public final List<Integer> h() {
        return this.counterBtnIncreaseHitSlop;
    }

    public final List<Integer> i() {
        return this.counterNormalHitSlop;
    }

    public final boolean j() {
        return this.enableHitSlop;
    }

    public final boolean k() {
        return this.enableLynxTypeface;
    }

    public final d l() {
        return this.loadMoreInfo;
    }

    public final boolean m() {
        return this.submitShowRadiusSwitch;
    }

    public final List<Integer> n() {
        return this.tabListWidths;
    }

    public final Map<String, Integer> o() {
        return this.templateList;
    }

    public final List<Integer> p() {
        return this.uplinkCodesNeedReload;
    }

    public c(Object r110) {
        d r111 = new d(null);
        List<Integer> r100 = CollectionsKt.listOf(new Integer[]{12, 12, 12, 12});
        List<Integer> r101 = CollectionsKt.listOf(new Integer[]{12, 12, 0, 12});
        List<Integer> r102 = CollectionsKt.listOf(new Integer[]{0, 12, 12, 12});
        List<String> r103 = CollectionsKt.emptyList();
        List<String> r104 = CollectionsKt.emptyList();
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("cart_header_card", 1);
        r105.put(LocationMonitorConst.SUBMIT, 1);
        r105.put("shop_header", 5);
        r105.put("product_card", 7);
        r105.put("shop_activity_card", 1);
        Map<String, Integer> r106 = MapsKt.toMap(r105);
        Intrinsics.checkNotNullParameter(r106, "templateList");
        this.loadMoreInfo = r111;
        this.enableUiAdapt = true;
        this.bigFontSwitch = true;
        this.tabListWidths = null;
        this.enableLynxTypeface = true;
        this.enableHitSlop = true;
        this.counterNormalHitSlop = r100;
        this.counterBtnDecreaseHitSlop = r101;
        this.counterBtnIncreaseHitSlop = r102;
        this.clickDebounceSwitch = false;
        this.clickDebounceDuration = TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG;
        this.cartSkipExplicitLoadingTriggerList = r103;
        this.bottomPlaceholderEnableScenes = r104;
        this.enableEmptyAdjust = true;
        this.enableForbiddenDataCompareCopy = true;
        this.enableNewPageViewLogic = true;
        this.enableAlignLoadingOpts = true;
        this.enableQuestEventParallelExecute = true;
        this.enableNewEventChainLogic = false;
        this.disableIncrementalFacade = false;
        this.uplinkCodesNeedReload = null;
        this.cacheValidDuration = 0;
        this.templateList = r106;
        this.submitShowRadiusSwitch = false;
    }
}
