package com.bytedance.android.window.shop.repository.dto;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001c\u00107\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010%\u001a\u0004\b8\u0010'R\u001c\u0010:\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006R\u001c\u0010@\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010\u0019\u001a\u0004\bA\u0010\u001bR\u001c\u0010C\u001a\u0004\u0018\u00010B8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR(\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006R.\u0010O\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020N\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010I\u001a\u0004\bP\u0010K¨\u0006Q"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/k0;", "", "", "searchHint", "Ljava/lang/String;", "getSearchHint", "()Ljava/lang/String;", "shopGuideText", "o", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "reputation", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "m", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "cartEntryConfig", "Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "c", "()Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "setCartEntryConfig", "(Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;)V", "orderUrl", "l", "", "shopGuideDisplay", "Ljava/lang/Boolean;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/lang/Boolean;", "setShopGuideDisplay", "(Ljava/lang/Boolean;)V", "Lyn/u;", "liveInfo", "Lyn/u;", RXScreenCaptureService.KEY_INDEX, "()Lyn/u;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "backgroundImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "coverBackgroundRgb", "d", "userAvatarMediumBackgroundRgbId", "q", "", "followStatus", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "nickName", ce.f26395j, "nickNameSuffix", ce.f26396k, "avatarMedium", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "fansClubInfo", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "f", "()Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "windowDetailUrl", "r", "showFollow", "p", "Lcom/bytedance/android/window/shop/repository/dto/y;", "imEntry", "Lcom/bytedance/android/window/shop/repository/dto/y;", "h", "()Lcom/bytedance/android/window/shop/repository/dto/y;", "", "extraParams", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "eventHandlerLynxUrl", "getEventHandlerLynxUrl", "", "windowSplitControl", "s", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k0 {

    @SerializedName("avatar_medium")
    private final ECUrlModel avatarMedium;

    @SerializedName("cover_url")
    private final ECUrlModel backgroundImg;

    @SerializedName("cart_entry_info")
    private WindowCartEntryConfig cartEntryConfig;

    @SerializedName("cover_background_rgb")
    private final String coverBackgroundRgb;

    @SerializedName("event_handler_lynx_url")
    private final String eventHandlerLynxUrl;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("fans_club_info")
    private final WindowFansClubInfo fansClubInfo;

    @SerializedName("follow_status")
    private Integer followStatus;

    @SerializedName("im_entry")
    private final y imEntry;

    @SerializedName("live_info")
    private final yn.u liveInfo;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("nick_name_suffix")
    private final String nickNameSuffix;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("reputation")
    private final AuthorReputationDTO reputation;

    @SerializedName("search_hint")
    private final String searchHint;

    @SerializedName("window_guide_display")
    private Boolean shopGuideDisplay;

    @SerializedName("window_guide_text")
    private final String shopGuideText;

    @SerializedName("window_show_follow_button")
    private final Boolean showFollow;

    @SerializedName("avatar_medium_background_rgb")
    private final String userAvatarMediumBackgroundRgbId;

    @SerializedName("detail_url")
    private final String windowDetailUrl;

    @SerializedName("split_config")
    private final Map<String, List<String>> windowSplitControl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k0) == false) goto L48;
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.searchHint, r101.searchHint) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopGuideText, r101.shopGuideText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.reputation, r101.reputation) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cartEntryConfig, r101.cartEntryConfig) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.orderUrl, r101.orderUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopGuideDisplay, r101.shopGuideDisplay) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.liveInfo, r101.liveInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.backgroundImg, r101.backgroundImg) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.coverBackgroundRgb, r101.coverBackgroundRgb) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userAvatarMediumBackgroundRgbId, r101.userAvatarMediumBackgroundRgbId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.nickNameSuffix, r101.nickNameSuffix) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.avatarMedium, r101.avatarMedium) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.fansClubInfo, r101.fansClubInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.windowDetailUrl, r101.windowDetailUrl) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.showFollow, r101.showFollow) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.imEntry, r101.imEntry) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.eventHandlerLynxUrl, r101.eventHandlerLynxUrl) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.windowSplitControl, r101.windowSplitControl) == true) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    public final int hashCode() {
        String r100 = this.searchHint;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.shopGuideText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        AuthorReputationDTO r107 = this.reputation;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        WindowCartEntryConfig r110 = this.cartEntryConfig;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.orderUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.shopGuideDisplay;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        yn.u r119 = this.liveInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ECUrlModel r122 = this.backgroundImg;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.coverBackgroundRgb;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.userAvatarMediumBackgroundRgbId;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.followStatus;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.nickName;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.nickNameSuffix;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        ECUrlModel r140 = this.avatarMedium;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        WindowFansClubInfo r143 = this.fansClubInfo;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.windowDetailUrl;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.showFollow;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        y r152 = this.imEntry;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        Map<String, String> r155 = this.extraParams;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.eventHandlerLynxUrl;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Map<String, List<String>> r161 = this.windowSplitControl;
        if (r161 == null) goto L86;
        r101 = r161.hashCode();
    L86:
        return r160 + r101;
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowHeaderOtherInfoDTO(searchHint=" + this.searchHint + ", shopGuideText=" + this.shopGuideText + ", reputation=" + this.reputation + ", cartEntryConfig=" + this.cartEntryConfig + ", orderUrl=" + this.orderUrl + ", shopGuideDisplay=" + this.shopGuideDisplay + ", liveInfo=" + this.liveInfo + ", backgroundImg=" + this.backgroundImg + ", coverBackgroundRgb=" + this.coverBackgroundRgb + ", userAvatarMediumBackgroundRgbId=" + this.userAvatarMediumBackgroundRgbId + ", followStatus=" + this.followStatus + ", nickName=" + this.nickName + ", nickNameSuffix=" + this.nickNameSuffix + ", avatarMedium=" + this.avatarMedium + ", fansClubInfo=" + this.fansClubInfo + ", windowDetailUrl=" + this.windowDetailUrl + ", showFollow=" + this.showFollow + ", imEntry=" + this.imEntry + ", extraParams=" + this.extraParams + ", eventHandlerLynxUrl=" + this.eventHandlerLynxUrl + ", windowSplitControl=" + this.windowSplitControl + ")";
    }

    public k0() {
        Boolean r100 = Boolean.FALSE;
        this.searchHint = null;
        this.shopGuideText = null;
        this.reputation = null;
        this.cartEntryConfig = null;
        this.orderUrl = null;
        this.shopGuideDisplay = null;
        this.liveInfo = null;
        this.backgroundImg = null;
        this.coverBackgroundRgb = null;
        this.userAvatarMediumBackgroundRgbId = null;
        this.followStatus = null;
        this.nickName = null;
        this.nickNameSuffix = null;
        this.avatarMedium = null;
        this.fansClubInfo = null;
        this.windowDetailUrl = null;
        this.showFollow = r100;
        this.imEntry = null;
        this.extraParams = null;
        this.eventHandlerLynxUrl = null;
        this.windowSplitControl = null;
    }

    public final ECUrlModel a() {
        return this.avatarMedium;
    }

    public final ECUrlModel b() {
        return this.backgroundImg;
    }

    public final WindowCartEntryConfig c() {
        return this.cartEntryConfig;
    }

    public final String d() {
        return this.coverBackgroundRgb;
    }

    public final Map<String, String> e() {
        return this.extraParams;
    }

    public final WindowFansClubInfo f() {
        return this.fansClubInfo;
    }

    public final Integer g() {
        return this.followStatus;
    }

    public final y h() {
        return this.imEntry;
    }

    public final yn.u i() {
        return this.liveInfo;
    }

    public final String j() {
        return this.nickName;
    }

    public final String k() {
        return this.nickNameSuffix;
    }

    public final String l() {
        return this.orderUrl;
    }

    public final AuthorReputationDTO m() {
        return this.reputation;
    }

    public final Boolean n() {
        return this.shopGuideDisplay;
    }

    public final String o() {
        return this.shopGuideText;
    }

    public final Boolean p() {
        return this.showFollow;
    }

    public final String q() {
        return this.userAvatarMediumBackgroundRgbId;
    }

    public final String r() {
        return this.windowDetailUrl;
    }

    public final Map<String, List<String>> s() {
        return this.windowSplitControl;
    }
}
