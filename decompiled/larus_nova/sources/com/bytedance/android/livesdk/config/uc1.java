package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010 \u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u001c\u0010\"\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001a\u0010&\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001a\u0010(\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b+\u0010\fR\u001a\u0010,\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006R\u001a\u0010.\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0011\u001a\u0004\b/\u0010\u0013R\u001a\u00100\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013R\u001a\u00102\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0011\u001a\u0004\b3\u0010\u0013R\u001a\u00104\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b5\u0010\u0013R\u001a\u00106\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u0010\u0013R\u001a\u00108\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/config/uc1;", "", "", "maxShelvesPagesNum", "I", "o", "()I", "", "", "anchorApiList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "audienceApiList", "b", "", "showExplainCardHotAtmosphere", "Z", BaseSwitches.V, "()Z", "explainCardSupplementInfoPriorityList", com.amap.api.col.s.ce.f26395j, "canSeeNewSlotComponent", "d", "explainCardAddShowDurationCompare", RXScreenCaptureService.KEY_INDEX, "explainCardTopIconUrlDefault", "Ljava/lang/String;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/lang/String;", "explainCardTopIconUrlCoexist", "m", "explainCardTagTypeDefault", "l", "explainCardTagTypeCoexist", com.amap.api.col.s.ce.f26396k, "showAnchorLiveData", "u", "showAnchorExplainCardLiveData", "t", "shelfCardExpandType", "p", "shelfCardLabelPriorityList", "q", "shelfFixedHeight", "r", "enableLynxShelf", "f", "bootconfigOffline", "c", "enableShelfEditOpt", com.amap.api.col.s.ce.f26391f, "shelfSellingPointEnabled", "s", "enableAudienceShelfSellingPoint", "e", "enableShelfNewPosterCover", "h", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class uc1 {

    @SerializedName("anchor_api_list")
    private final List<String> anchorApiList;

    @SerializedName("audience_api_list")
    private final List<String> audienceApiList;

    @SerializedName("bootconfig_offline")
    private final boolean bootconfigOffline;

    @SerializedName("can_see_new_slot_component")
    private final int canSeeNewSlotComponent;

    @SerializedName("enable_audience_selling_point")
    private final boolean enableAudienceShelfSellingPoint;

    @SerializedName("enable_lynx_shelf")
    private final boolean enableLynxShelf;

    @SerializedName("enable_optimize_microapp_anchor_edit_shelf")
    private final boolean enableShelfEditOpt;

    @SerializedName("enable_new_poster_cover")
    private final boolean enableShelfNewPosterCover;

    @SerializedName("card_add_show_duration_compare")
    private final boolean explainCardAddShowDurationCompare;

    @SerializedName("card_atmosphere_priority_list")
    private final List<Integer> explainCardSupplementInfoPriorityList;

    @SerializedName("explain_card_tag_type_coexist")
    private final String explainCardTagTypeCoexist;

    @SerializedName("explain_card_tag_type_default")
    private final String explainCardTagTypeDefault;

    @SerializedName("explain_card_top_icon_url_coexist")
    private final String explainCardTopIconUrlCoexist;

    @SerializedName("explain_card_top_icon_url_default")
    private final String explainCardTopIconUrlDefault;

    @SerializedName("max_shelves_pages_num")
    private final int maxShelvesPagesNum;

    @SerializedName("shelf_card_expand_type")
    private final int shelfCardExpandType;

    @SerializedName("shelf_card_lable_priority_list")
    private final List<Integer> shelfCardLabelPriorityList;

    @SerializedName("shelf_fixed_height")
    private final int shelfFixedHeight;

    @SerializedName("selling_point_enable")
    private final boolean shelfSellingPointEnabled;

    @SerializedName("show_anchor_explain_card_live_data")
    private final int showAnchorExplainCardLiveData;

    @SerializedName("show_anchor_live_data")
    private final int showAnchorLiveData;

    @SerializedName("show_card_hot_sale")
    private final boolean showExplainCardHotAtmosphere;

    public static final class a {
    }

    static {
    }

    public uc1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof uc1) == false) goto L50;
        uc1 r101 = (uc1) r100;
        if (this.maxShelvesPagesNum == r101.maxShelvesPagesNum) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.anchorApiList, r101.anchorApiList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.audienceApiList, r101.audienceApiList) == true) goto L12;
        return false;
    L12:
        if (this.showExplainCardHotAtmosphere == r101.showExplainCardHotAtmosphere) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.explainCardSupplementInfoPriorityList, r101.explainCardSupplementInfoPriorityList) == true) goto L16;
        return false;
    L16:
        if (this.canSeeNewSlotComponent == r101.canSeeNewSlotComponent) goto L18;
        return false;
    L18:
        if (this.explainCardAddShowDurationCompare == r101.explainCardAddShowDurationCompare) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.explainCardTopIconUrlDefault, r101.explainCardTopIconUrlDefault) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.explainCardTopIconUrlCoexist, r101.explainCardTopIconUrlCoexist) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.explainCardTagTypeDefault, r101.explainCardTagTypeDefault) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.explainCardTagTypeCoexist, r101.explainCardTagTypeCoexist) == true) goto L28;
        return false;
    L28:
        if (this.showAnchorLiveData == r101.showAnchorLiveData) goto L30;
        return false;
    L30:
        if (this.showAnchorExplainCardLiveData == r101.showAnchorExplainCardLiveData) goto L32;
        return false;
    L32:
        if (this.shelfCardExpandType == r101.shelfCardExpandType) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.shelfCardLabelPriorityList, r101.shelfCardLabelPriorityList) == true) goto L36;
        return false;
    L36:
        if (this.shelfFixedHeight == r101.shelfFixedHeight) goto L38;
        return false;
    L38:
        if (this.enableLynxShelf == r101.enableLynxShelf) goto L40;
        return false;
    L40:
        if (this.bootconfigOffline == r101.bootconfigOffline) goto L42;
        return false;
    L42:
        if (this.enableShelfEditOpt == r101.enableShelfEditOpt) goto L44;
        return false;
    L44:
        if (this.shelfSellingPointEnabled == r101.shelfSellingPointEnabled) goto L46;
        return false;
    L46:
        if (this.enableAudienceShelfSellingPoint == r101.enableAudienceShelfSellingPoint) goto L48;
        return false;
    L48:
        if (this.enableShelfNewPosterCover == r101.enableShelfNewPosterCover) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r0v36, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v34, types: [int] */
    /* JADX WARN: Type inference failed for: r1v36, types: [int] */
    /* JADX WARN: Type inference failed for: r1v38, types: [int] */
    /* JADX WARN: Type inference failed for: r1v40, types: [int] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r100 = this.maxShelvesPagesNum * 31;
        List<String> r101 = this.anchorApiList;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        List<String> r105 = this.audienceApiList;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.showExplainCardHotAtmosphere;
        ?? r109 = 1;
        ?? r110 = r108;
        if (r108 == false) goto L13;
        r110 = 1;
    L13:
        int r111 = (r107 + r110) * 31;
        List<Integer> r112 = this.explainCardSupplementInfoPriorityList;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (((r111 + r113) * 31) + this.canSeeNewSlotComponent) * 31;
        boolean r115 = this.explainCardAddShowDurationCompare;
        ?? r116 = r115;
        if (r115 == false) goto L20;
        r116 = 1;
    L20:
        int r117 = (r114 + r116) * 31;
        String r118 = this.explainCardTopIconUrlDefault;
        if (r118 == null) goto L23;
        int r119 = r118.hashCode();
    L24:
        int r120 = (r117 + r119) * 31;
        String r121 = this.explainCardTopIconUrlCoexist;
        if (r121 == null) goto L27;
        int r122 = r121.hashCode();
    L28:
        int r123 = (r120 + r122) * 31;
        String r124 = this.explainCardTagTypeDefault;
        if (r124 == null) goto L31;
        int r125 = r124.hashCode();
    L32:
        int r126 = (r123 + r125) * 31;
        String r127 = this.explainCardTagTypeCoexist;
        if (r127 == null) goto L35;
        int r128 = r127.hashCode();
    L36:
        int r129 = (((((((r126 + r128) * 31) + this.showAnchorLiveData) * 31) + this.showAnchorExplainCardLiveData) * 31) + this.shelfCardExpandType) * 31;
        List<Integer> r130 = this.shelfCardLabelPriorityList;
        if (r130 == null) goto L39;
        r102 = r130.hashCode();
    L39:
        int r131 = (((r129 + r102) * 31) + this.shelfFixedHeight) * 31;
        boolean r132 = this.enableLynxShelf;
        ?? r133 = r132;
        if (r132 == false) goto L42;
        r133 = 1;
    L42:
        int r134 = (r131 + r133) * 31;
        boolean r135 = this.bootconfigOffline;
        ?? r136 = r135;
        if (r135 == false) goto L45;
        r136 = 1;
    L45:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.enableShelfEditOpt;
        ?? r139 = r138;
        if (r138 == false) goto L48;
        r139 = 1;
    L48:
        int r140 = (r137 + r139) * 31;
        boolean r141 = this.shelfSellingPointEnabled;
        ?? r142 = r141;
        if (r141 == false) goto L51;
        r142 = 1;
    L51:
        int r143 = (r140 + r142) * 31;
        boolean r144 = this.enableAudienceShelfSellingPoint;
        ?? r145 = r144;
        if (r144 == false) goto L54;
        r145 = 1;
    L54:
        int r146 = (r143 + r145) * 31;
        boolean r147 = this.enableShelfNewPosterCover;
        if (r147 == true) goto L59;
        r109 = r147;
    L59:
        return r146 + r109;
    L35:
        r128 = 0;
        goto L36
    L31:
        r125 = 0;
        goto L32
    L27:
        r122 = 0;
        goto L28
    L23:
        r119 = 0;
        goto L24
    L16:
        r113 = 0;
        goto L17
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformMicroAppConfig(maxShelvesPagesNum=" + this.maxShelvesPagesNum + ", anchorApiList=" + this.anchorApiList + ", audienceApiList=" + this.audienceApiList + ", showExplainCardHotAtmosphere=" + this.showExplainCardHotAtmosphere + ", explainCardSupplementInfoPriorityList=" + this.explainCardSupplementInfoPriorityList + ", canSeeNewSlotComponent=" + this.canSeeNewSlotComponent + ", explainCardAddShowDurationCompare=" + this.explainCardAddShowDurationCompare + ", explainCardTopIconUrlDefault=" + this.explainCardTopIconUrlDefault + ", explainCardTopIconUrlCoexist=" + this.explainCardTopIconUrlCoexist + ", explainCardTagTypeDefault=" + this.explainCardTagTypeDefault + ", explainCardTagTypeCoexist=" + this.explainCardTagTypeCoexist + ", showAnchorLiveData=" + this.showAnchorLiveData + ", showAnchorExplainCardLiveData=" + this.showAnchorExplainCardLiveData + ", shelfCardExpandType=" + this.shelfCardExpandType + ", shelfCardLabelPriorityList=" + this.shelfCardLabelPriorityList + ", shelfFixedHeight=" + this.shelfFixedHeight + ", enableLynxShelf=" + this.enableLynxShelf + ", bootconfigOffline=" + this.bootconfigOffline + ", enableShelfEditOpt=" + this.enableShelfEditOpt + ", shelfSellingPointEnabled=" + this.shelfSellingPointEnabled + ", enableAudienceShelfSellingPoint=" + this.enableAudienceShelfSellingPoint + ", enableShelfNewPosterCover=" + this.enableShelfNewPosterCover + ")";
    }

    public final List<String> a() {
        return this.anchorApiList;
    }

    public final List<String> b() {
        return this.audienceApiList;
    }

    public final boolean c() {
        return this.bootconfigOffline;
    }

    public final int d() {
        return this.canSeeNewSlotComponent;
    }

    public final boolean e() {
        return this.enableAudienceShelfSellingPoint;
    }

    public final boolean f() {
        return this.enableLynxShelf;
    }

    public final boolean g() {
        return this.enableShelfEditOpt;
    }

    public final boolean h() {
        return this.enableShelfNewPosterCover;
    }

    public final boolean i() {
        return this.explainCardAddShowDurationCompare;
    }

    public final List<Integer> j() {
        return this.explainCardSupplementInfoPriorityList;
    }

    public final String k() {
        return this.explainCardTagTypeCoexist;
    }

    public final String l() {
        return this.explainCardTagTypeDefault;
    }

    public final String m() {
        return this.explainCardTopIconUrlCoexist;
    }

    public final String n() {
        return this.explainCardTopIconUrlDefault;
    }

    public final int o() {
        return this.maxShelvesPagesNum;
    }

    public final int p() {
        return this.shelfCardExpandType;
    }

    public final List<Integer> q() {
        return this.shelfCardLabelPriorityList;
    }

    public final int r() {
        return this.shelfFixedHeight;
    }

    public final boolean s() {
        return this.shelfSellingPointEnabled;
    }

    public final int t() {
        return this.showAnchorExplainCardLiveData;
    }

    public final int u() {
        return this.showAnchorLiveData;
    }

    public final boolean v() {
        return this.showExplainCardHotAtmosphere;
    }

    public uc1(Object r100) {
        List<Integer> r101 = CollectionsKt.listOf(new Integer[]{1, 2, 4, 5, 3});
        this.maxShelvesPagesNum = 20;
        this.anchorApiList = null;
        this.audienceApiList = null;
        this.showExplainCardHotAtmosphere = true;
        this.explainCardSupplementInfoPriorityList = null;
        this.canSeeNewSlotComponent = 0;
        this.explainCardAddShowDurationCompare = false;
        this.explainCardTopIconUrlDefault = null;
        this.explainCardTopIconUrlCoexist = null;
        this.explainCardTagTypeDefault = null;
        this.explainCardTagTypeCoexist = null;
        this.showAnchorLiveData = 0;
        this.showAnchorExplainCardLiveData = 0;
        this.shelfCardExpandType = 0;
        this.shelfCardLabelPriorityList = r101;
        this.shelfFixedHeight = 0;
        this.enableLynxShelf = false;
        this.bootconfigOffline = false;
        this.enableShelfEditOpt = false;
        this.shelfSellingPointEnabled = false;
        this.enableAudienceShelfSellingPoint = false;
        this.enableShelfNewPosterCover = false;
    }
}
