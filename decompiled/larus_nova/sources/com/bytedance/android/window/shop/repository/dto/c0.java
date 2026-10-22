package com.bytedance.android.window.shop.repository.dto;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R*\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010;\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109R*\u0010>\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u00105\u001a\u0004\b?\u00107\"\u0004\b@\u00109R*\u0010A\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u00105\u001a\u0004\bB\u00107\"\u0004\bC\u00109R\u001c\u0010E\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010F\u001a\u0004\bJ\u0010HR$\u0010K\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\t\u001a\u0004\bL\u0010\u000b\"\u0004\bM\u0010,R\u001c\u0010N\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006¨\u0006P"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/c0;", "", "", "nickName", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "avatarMedium", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "followerOrderCount", "getFollowerOrderCount", "Lcom/bytedance/android/window/shop/repository/dto/e;", "rankInfo", "Lcom/bytedance/android/window/shop/repository/dto/e;", OfficeSDKRequestTag.KEY_NEW_USER, "()Lcom/bytedance/android/window/shop/repository/dto/e;", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "reputation", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "o", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "Lcom/bytedance/android/window/shop/repository/dto/s0;", "levelInfo", "Lcom/bytedance/android/window/shop/repository/dto/s0;", "m", "()Lcom/bytedance/android/window/shop/repository/dto/s0;", "Lcom/bytedance/android/window/shop/repository/dto/x;", "fansInfo", "Lcom/bytedance/android/window/shop/repository/dto/x;", "d", "()Lcom/bytedance/android/window/shop/repository/dto/x;", "", "newReputationStyle", "Ljava/lang/Boolean;", "getNewReputationStyle", "()Ljava/lang/Boolean;", "setNewReputationStyle", "(Ljava/lang/Boolean;)V", "followButtonBubble", "f", "setFollowButtonBubble", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "followStatus", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "", "Lcom/bytedance/android/window/shop/repository/dto/x0;", "guideInfo", "Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/List;", "setGuideInfo", "(Ljava/util/List;)V", "Lcom/bytedance/android/window/shop/repository/dto/m;", "guideInfoTop", "l", "setGuideInfoTop", "guideInfoSelfIntro", ce.f26396k, "setGuideInfoSelfIntro", "guideInfoBottom", ce.f26395j, "setGuideInfoBottom", "Lcom/bytedance/android/window/shop/repository/dto/z;", "authorNameIcon", "Lcom/bytedance/android/window/shop/repository/dto/z;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/window/shop/repository/dto/z;", "goodAuthorIcon", "h", "fansRedPackBubble", "e", "setFansRedPackBubble", "fansAmountDes", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("author_name_icon")
    private final z authorNameIcon;

    @SerializedName("avatar_medium")
    private final ECUrlModel avatarMedium;

    @SerializedName("fans_amount_des")
    private final String fansAmountDes;

    @SerializedName("fans_info")
    private final x fansInfo;

    @SerializedName("fans_redpack_apply_bubble")
    private ECUrlModel fansRedPackBubble;

    @SerializedName("follow_button_bubble")
    private ECUrlModel followButtonBubble;

    @SerializedName("follow_status")
    private final Integer followStatus;

    @SerializedName("follower_order_count")
    private final String followerOrderCount;

    @SerializedName("good_author_for_ecom")
    private final z goodAuthorIcon;

    @SerializedName("guide_info")
    private List<x0> guideInfo;

    @SerializedName("author_guide_info_bottom")
    private List<m> guideInfoBottom;

    @SerializedName("author_guide_info_self_intro")
    private List<m> guideInfoSelfIntro;

    @SerializedName("author_guide_info_top")
    private List<m> guideInfoTop;

    @SerializedName("level_info")
    private final s0 levelInfo;

    @SerializedName("new_reputation_style")
    private Boolean newReputationStyle;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("rank_info")
    private final e rankInfo;

    @SerializedName("reputation")
    private final AuthorReputationDTO reputation;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L42;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatarMedium, r101.avatarMedium) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.followerOrderCount, r101.followerOrderCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rankInfo, r101.rankInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.reputation, r101.reputation) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.levelInfo, r101.levelInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fansInfo, r101.fansInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.newReputationStyle, r101.newReputationStyle) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.followButtonBubble, r101.followButtonBubble) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.guideInfo, r101.guideInfo) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.guideInfoTop, r101.guideInfoTop) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.guideInfoSelfIntro, r101.guideInfoSelfIntro) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.guideInfoBottom, r101.guideInfoBottom) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.authorNameIcon, r101.authorNameIcon) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.goodAuthorIcon, r101.goodAuthorIcon) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.fansRedPackBubble, r101.fansRedPackBubble) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.fansAmountDes, r101.fansAmountDes) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    public final int hashCode() {
        String r100 = this.nickName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.avatarMedium;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.followerOrderCount;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        e r110 = this.rankInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        AuthorReputationDTO r113 = this.reputation;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        s0 r116 = this.levelInfo;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        x r119 = this.fansInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.newReputationStyle;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        ECUrlModel r125 = this.followButtonBubble;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.followStatus;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        List<x0> r131 = this.guideInfo;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        List<m> r134 = this.guideInfoTop;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        List<m> r137 = this.guideInfoSelfIntro;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        List<m> r140 = this.guideInfoBottom;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        z r143 = this.authorNameIcon;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        z r146 = this.goodAuthorIcon;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        ECUrlModel r149 = this.fansRedPackBubble;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.fansAmountDes;
        if (r152 == null) goto L74;
        r101 = r152.hashCode();
    L74:
        return r151 + r101;
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
        return "WindowHeaderAuthorInfoDTO(nickName=" + this.nickName + ", avatarMedium=" + this.avatarMedium + ", followerOrderCount=" + this.followerOrderCount + ", rankInfo=" + this.rankInfo + ", reputation=" + this.reputation + ", levelInfo=" + this.levelInfo + ", fansInfo=" + this.fansInfo + ", newReputationStyle=" + this.newReputationStyle + ", followButtonBubble=" + this.followButtonBubble + ", followStatus=" + this.followStatus + ", guideInfo=" + this.guideInfo + ", guideInfoTop=" + this.guideInfoTop + ", guideInfoSelfIntro=" + this.guideInfoSelfIntro + ", guideInfoBottom=" + this.guideInfoBottom + ", authorNameIcon=" + this.authorNameIcon + ", goodAuthorIcon=" + this.goodAuthorIcon + ", fansRedPackBubble=" + this.fansRedPackBubble + ", fansAmountDes=" + this.fansAmountDes + ")";
    }

    public c0() {
        Boolean r100 = Boolean.FALSE;
        this.nickName = null;
        this.avatarMedium = null;
        this.followerOrderCount = null;
        this.rankInfo = null;
        this.reputation = null;
        this.levelInfo = null;
        this.fansInfo = null;
        this.newReputationStyle = r100;
        this.followButtonBubble = null;
        this.followStatus = null;
        this.guideInfo = null;
        this.guideInfoTop = null;
        this.guideInfoSelfIntro = null;
        this.guideInfoBottom = null;
        this.authorNameIcon = null;
        this.goodAuthorIcon = null;
        this.fansRedPackBubble = null;
        this.fansAmountDes = null;
    }

    public final z a() {
        return this.authorNameIcon;
    }

    public final ECUrlModel b() {
        return this.avatarMedium;
    }

    public final String c() {
        return this.fansAmountDes;
    }

    public final x d() {
        return this.fansInfo;
    }

    public final ECUrlModel e() {
        return this.fansRedPackBubble;
    }

    public final ECUrlModel f() {
        return this.followButtonBubble;
    }

    public final Integer g() {
        return this.followStatus;
    }

    public final z h() {
        return this.goodAuthorIcon;
    }

    public final List<x0> i() {
        return this.guideInfo;
    }

    public final List<m> j() {
        return this.guideInfoBottom;
    }

    public final List<m> k() {
        return this.guideInfoSelfIntro;
    }

    public final List<m> l() {
        return this.guideInfoTop;
    }

    public final s0 m() {
        return this.levelInfo;
    }

    public final e n() {
        return this.rankInfo;
    }

    public final AuthorReputationDTO o() {
        return this.reputation;
    }
}
