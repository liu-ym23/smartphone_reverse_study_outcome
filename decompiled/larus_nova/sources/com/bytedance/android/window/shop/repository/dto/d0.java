package com.bytedance.android.window.shop.repository.dto;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006R\u001c\u00102\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00107\u001a\u0004\u0018\u0001068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010,\u001a\u0004\b=\u0010.R\u001c\u0010>\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006R\"\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010,\u001a\u0004\bB\u0010.R\u001c\u0010D\u001a\u0004\u0018\u00010C8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010C8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010E\u001a\u0004\bI\u0010GR\u001c\u0010K\u001a\u0004\u0018\u00010J8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N¨\u0006O"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/d0;", "", "", "userAvatarMediumBackgroundRgbId", "Ljava/lang/String;", "m", "()Ljava/lang/String;", "userId", "getUserId", "secAuthorId", "getSecAuthorId", "nickName", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/ec/model/ECUrlModel;", "avatarMedium", "Lcom/bytedance/android/ec/model/ECUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "reputation", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", ce.f26396k, "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "backgroundImg", "b", "coverBackgroundRgb", "e", "orderUrl", ce.f26395j, "shopGuideText", "l", "shopGuideIcon", "getShopGuideIcon", "storeUrl", "getStoreUrl", "Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "cartEntryConfig", "Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "d", "()Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "setCartEntryConfig", "(Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;)V", "", "followerUrls", "Ljava/util/List;", "getFollowerUrls", "()Ljava/util/List;", "followerOrderCount", "getFollowerOrderCount", "Lyn/u;", "liveInfo", "Lyn/u;", "h", "()Lyn/u;", "Lcom/bytedance/android/window/shop/repository/dto/x;", "fansInfo", "Lcom/bytedance/android/window/shop/repository/dto/x;", "f", "()Lcom/bytedance/android/window/shop/repository/dto/x;", "Lcom/bytedance/android/window/shop/repository/dto/r0;", "impressionWords", ce.f26391f, "windowDetailUrl", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/android/window/shop/repository/dto/n;", "bubble", "c", "Lcom/bytedance/android/window/shop/repository/dto/x0;", "fansNumForBuy", "Lcom/bytedance/android/window/shop/repository/dto/x0;", "getFansNumForBuy", "()Lcom/bytedance/android/window/shop/repository/dto/x0;", "salesNum", "getSalesNum", "Lcom/bytedance/android/window/shop/repository/dto/z;", "goodAuthorIcon", "Lcom/bytedance/android/window/shop/repository/dto/z;", "getGoodAuthorIcon", "()Lcom/bytedance/android/window/shop/repository/dto/z;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("avatar_medium")
    private final ECUrlModel avatarMedium;

    @SerializedName("cover_url")
    private final ECUrlModel backgroundImg;

    @SerializedName("bubble")
    private final List<n> bubble;

    @SerializedName("cart_entry_info")
    private WindowCartEntryConfig cartEntryConfig;

    @SerializedName("cover_background_rgb")
    private final String coverBackgroundRgb;

    @SerializedName("fans_info")
    private final x fansInfo;

    @SerializedName("fans_num_for_buy")
    private final x0 fansNumForBuy;

    @SerializedName("follower_order_count")
    private final String followerOrderCount;

    @SerializedName("follower_urls")
    private final List<ECUrlModel> followerUrls;

    @SerializedName("good_author_for_ecom")
    private final z goodAuthorIcon;

    @SerializedName("impression_words")
    private final List<r0> impressionWords;

    @SerializedName("live_info")
    private final yn.u liveInfo;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("reputation")
    private final AuthorReputationDTO reputation;

    @SerializedName("sales_num")
    private final x0 salesNum;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName("window_guide_icon")
    private final ECUrlModel shopGuideIcon;

    @SerializedName("window_guide_text")
    private final String shopGuideText;

    @SerializedName("store_url")
    private final String storeUrl;

    @SerializedName("avatar_medium_background_rgb")
    private final String userAvatarMediumBackgroundRgbId;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("detail_url")
    private final String windowDetailUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d0) == false) goto L52;
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.userAvatarMediumBackgroundRgbId, r101.userAvatarMediumBackgroundRgbId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.avatarMedium, r101.avatarMedium) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.reputation, r101.reputation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.backgroundImg, r101.backgroundImg) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.coverBackgroundRgb, r101.coverBackgroundRgb) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.orderUrl, r101.orderUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopGuideText, r101.shopGuideText) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.shopGuideIcon, r101.shopGuideIcon) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.storeUrl, r101.storeUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cartEntryConfig, r101.cartEntryConfig) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.followerUrls, r101.followerUrls) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.followerOrderCount, r101.followerOrderCount) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.liveInfo, r101.liveInfo) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.fansInfo, r101.fansInfo) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.impressionWords, r101.impressionWords) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.windowDetailUrl, r101.windowDetailUrl) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.bubble, r101.bubble) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.fansNumForBuy, r101.fansNumForBuy) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.salesNum, r101.salesNum) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.goodAuthorIcon, r101.goodAuthorIcon) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    public final int hashCode() {
        String r100 = this.userAvatarMediumBackgroundRgbId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.userId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.secAuthorId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.nickName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECUrlModel r113 = this.avatarMedium;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        AuthorReputationDTO r116 = this.reputation;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        ECUrlModel r119 = this.backgroundImg;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.coverBackgroundRgb;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.orderUrl;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.shopGuideText;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        ECUrlModel r131 = this.shopGuideIcon;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.storeUrl;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        WindowCartEntryConfig r137 = this.cartEntryConfig;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        List<ECUrlModel> r140 = this.followerUrls;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.followerOrderCount;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        yn.u r146 = this.liveInfo;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        x r149 = this.fansInfo;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        List<r0> r152 = this.impressionWords;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.windowDetailUrl;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        List<n> r158 = this.bubble;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        x0 r161 = this.fansNumForBuy;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        x0 r164 = this.salesNum;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        z r167 = this.goodAuthorIcon;
        if (r167 == null) goto L94;
        r101 = r167.hashCode();
    L94:
        return r166 + r101;
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
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
        return "WindowHeaderBaseInfoDTO(userAvatarMediumBackgroundRgbId=" + this.userAvatarMediumBackgroundRgbId + ", userId=" + this.userId + ", secAuthorId=" + this.secAuthorId + ", nickName=" + this.nickName + ", avatarMedium=" + this.avatarMedium + ", reputation=" + this.reputation + ", backgroundImg=" + this.backgroundImg + ", coverBackgroundRgb=" + this.coverBackgroundRgb + ", orderUrl=" + this.orderUrl + ", shopGuideText=" + this.shopGuideText + ", shopGuideIcon=" + this.shopGuideIcon + ", storeUrl=" + this.storeUrl + ", cartEntryConfig=" + this.cartEntryConfig + ", followerUrls=" + this.followerUrls + ", followerOrderCount=" + this.followerOrderCount + ", liveInfo=" + this.liveInfo + ", fansInfo=" + this.fansInfo + ", impressionWords=" + this.impressionWords + ", windowDetailUrl=" + this.windowDetailUrl + ", bubble=" + this.bubble + ", fansNumForBuy=" + this.fansNumForBuy + ", salesNum=" + this.salesNum + ", goodAuthorIcon=" + this.goodAuthorIcon + ")";
    }

    public d0() {
        this.userAvatarMediumBackgroundRgbId = null;
        this.userId = null;
        this.secAuthorId = null;
        this.nickName = null;
        this.avatarMedium = null;
        this.reputation = null;
        this.backgroundImg = null;
        this.coverBackgroundRgb = null;
        this.orderUrl = null;
        this.shopGuideText = null;
        this.shopGuideIcon = null;
        this.storeUrl = null;
        this.cartEntryConfig = null;
        this.followerUrls = null;
        this.followerOrderCount = null;
        this.liveInfo = null;
        this.fansInfo = null;
        this.impressionWords = null;
        this.windowDetailUrl = null;
        this.bubble = null;
        this.fansNumForBuy = null;
        this.salesNum = null;
        this.goodAuthorIcon = null;
    }

    public final ECUrlModel a() {
        return this.avatarMedium;
    }

    public final ECUrlModel b() {
        return this.backgroundImg;
    }

    public final List<n> c() {
        return this.bubble;
    }

    public final WindowCartEntryConfig d() {
        return this.cartEntryConfig;
    }

    public final String e() {
        return this.coverBackgroundRgb;
    }

    public final x f() {
        return this.fansInfo;
    }

    public final List<r0> g() {
        return this.impressionWords;
    }

    public final yn.u h() {
        return this.liveInfo;
    }

    public final String i() {
        return this.nickName;
    }

    public final String j() {
        return this.orderUrl;
    }

    public final AuthorReputationDTO k() {
        return this.reputation;
    }

    public final String l() {
        return this.shopGuideText;
    }

    public final String m() {
        return this.userAvatarMediumBackgroundRgbId;
    }

    public final String n() {
        return this.windowDetailUrl;
    }
}
