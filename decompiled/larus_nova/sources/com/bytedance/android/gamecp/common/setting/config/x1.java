package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/x1;", "", "", "anchorIntroBackground", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "anchorExplainBackground", "getAnchorExplainBackground", "promoteCenterUrl", "getPromoteCenterUrl", "currentPromoteUrl", "getCurrentPromoteUrl", "currentPromoteUrlV2", "getCurrentPromoteUrlV2", "promoteManagerUrl", "getPromoteManagerUrl", "anchorPromoteHalfPage", "getAnchorPromoteHalfPage", "protocolTxt", "getProtocolTxt", "contractServiceUrl", "getContractServiceUrl", "protocolScheme", "getProtocolScheme", "couponEntranceUrl", "getCouponEntranceUrl", "anchorPropProtocol", "getAnchorPropProtocol", "anchorPropList", "getAnchorPropList", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x1 {

    @SerializedName("anchor_cp_explain_backgroud")
    private final String anchorExplainBackground;

    @SerializedName("anchor_cp_intro_background")
    private final String anchorIntroBackground;

    @SerializedName("anchor_cp_promote_half_page")
    private final String anchorPromoteHalfPage;

    @SerializedName("anchor_cp_props_list")
    private final String anchorPropList;

    @SerializedName("anchor_cp_props_promote_protocol")
    private final String anchorPropProtocol;

    @SerializedName("anchor_cp_promote_service_url")
    private final String contractServiceUrl;

    @SerializedName("anchor_cp_coupon_entrance_url")
    private final String couponEntranceUrl;

    @SerializedName("anchor_cp_mine_url")
    private final String currentPromoteUrl;

    @SerializedName("anchor_cp_mine_url_v2")
    private final String currentPromoteUrlV2;

    @SerializedName("anchor_cp_center_url")
    private final String promoteCenterUrl;

    @SerializedName("anchor_cp_manager_url")
    private final String promoteManagerUrl;

    @SerializedName("anchor_cp_promote_protocol_scheme")
    private final String protocolScheme;

    @SerializedName("anchor_cp_promote_prorocol_text")
    private final String protocolTxt;

    public x1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x1) == false) goto L32;
        x1 r101 = (x1) r100;
        if (Intrinsics.areEqual(this.anchorIntroBackground, r101.anchorIntroBackground) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.anchorExplainBackground, r101.anchorExplainBackground) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.promoteCenterUrl, r101.promoteCenterUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentPromoteUrl, r101.currentPromoteUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.currentPromoteUrlV2, r101.currentPromoteUrlV2) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.promoteManagerUrl, r101.promoteManagerUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.anchorPromoteHalfPage, r101.anchorPromoteHalfPage) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.protocolTxt, r101.protocolTxt) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.contractServiceUrl, r101.contractServiceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.protocolScheme, r101.protocolScheme) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.couponEntranceUrl, r101.couponEntranceUrl) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.anchorPropProtocol, r101.anchorPropProtocol) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.anchorPropList, r101.anchorPropList) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        String r100 = this.anchorIntroBackground;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.anchorExplainBackground;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.promoteCenterUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.currentPromoteUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.currentPromoteUrlV2;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.promoteManagerUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.anchorPromoteHalfPage;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.protocolTxt;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.contractServiceUrl;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.protocolScheme;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.couponEntranceUrl;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.anchorPropProtocol;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.anchorPropList;
        if (r137 == null) goto L54;
        r101 = r137.hashCode();
    L54:
        return r136 + r101;
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
        return "GamePromoteResConfig(anchorIntroBackground=" + this.anchorIntroBackground + ", anchorExplainBackground=" + this.anchorExplainBackground + ", promoteCenterUrl=" + this.promoteCenterUrl + ", currentPromoteUrl=" + this.currentPromoteUrl + ", currentPromoteUrlV2=" + this.currentPromoteUrlV2 + ", promoteManagerUrl=" + this.promoteManagerUrl + ", anchorPromoteHalfPage=" + this.anchorPromoteHalfPage + ", protocolTxt=" + this.protocolTxt + ", contractServiceUrl=" + this.contractServiceUrl + ", protocolScheme=" + this.protocolScheme + ", couponEntranceUrl=" + this.couponEntranceUrl + ", anchorPropProtocol=" + this.anchorPropProtocol + ", anchorPropList=" + this.anchorPropList + ")";
    }

    public final String a() {
        return this.anchorIntroBackground;
    }

    public x1(int r100) {
        StringBuilder r101 = new StringBuilder("https://");
        String r102 = com.bytedance.android.gamecp.common.utils.h0.f57225b;
        r101.append(r102);
        r101.append("/obj/live-android/ttlive_game_union_intro_dialog.png");
        String r103 = r101.toString();
        Intrinsics.checkNotNullParameter("https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/h5/links_mounted_douyin/template/pages/game_promote.html", "anchorPromoteHalfPage");
        this.anchorIntroBackground = r103;
        this.anchorExplainBackground = "https://" + r102 + "/obj/live-android/anchor_cp_explain_backgroud.png";
        this.promoteCenterUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/h5/douyin_h5_vertical/template/pages/game_operation/promotion_center/index.html";
        this.currentPromoteUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/h5/douyin_h5_vertical/template/pages/game_operation/introduction_list/index.html";
        this.currentPromoteUrlV2 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/h5/introduction_list_douyin/template/pages/index.html";
        this.promoteManagerUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/h5/douyin_h5_vertical/template/pages/game_operation/promotion_manage/index.html";
        this.anchorPromoteHalfPage = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/h5/links_mounted_douyin/template/pages/game_promote.html";
        this.protocolTxt = "尊敬的用户，你正在开通游戏推广，ARP协议是“Address Resolution Protocol”（地址解析协议）的缩写。在局域网中，网络中实际传输的是“帧”，帧里面是有目标主机的MAC地址的。在以太网中，一个主机要和另一个主机进行直接通信，必须要知道目标主机的MAC地址。但这个目标MAC地址是如何获得的呢？它就是通过地址解析协议获得的。所谓“地址解析”就是主机在发送帧前将目标IP地址转换成目标MAC地址的过程。ARP协议的基本功能就是通过目标设备的IP地址，查询目标设备的MAC地址，以保证通信的顺利进行。";
        this.contractServiceUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/h5/douyin_h5_vertical/template/pages/game_operation/protocol_page/index.html";
        this.protocolScheme = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/h5/douyin_h5_vertical/template/pages/game_operation/anchor_certify_popup/index.html";
        this.couponEntranceUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/h5/douyin_h5_vertical/template/pages/game_operation/coupon_list/index.html";
        this.anchorPropProtocol = "https://tosv.byted.org/obj/gecko-internal/webcast/mono/h5/douyin_h5_vertical/template/pages/game_operation/props_promote_certify_popup/index.html";
        this.anchorPropList = "https://tosv.byted.org/obj/gecko-internal/webcast/mono/h5/douyin_h5_vertical/template/pages/game_operation/props_list_popup/index.html";
    }
}
