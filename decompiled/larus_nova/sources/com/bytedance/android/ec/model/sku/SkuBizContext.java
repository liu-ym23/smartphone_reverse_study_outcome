package com.bytedance.android.ec.model.sku;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÂ\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u000eHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u0006\u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016¨\u0006>"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuBizContext;", "Ljava/io/Serializable;", "authorId", "", "secAuthorId", "roomId", "isGroupBuy", "", "orderUrl", "itemId", ReportConstant.COMMON_ACTION_TYPE, SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "skuId", "hotSaleType", "", "detailUrl", "nGroupBuyToken", "bizIdentifier", "foodTakeoutCustomPropertyList", "foodTakeoutSalePackageList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Ljava/lang/String;", "getAuthorId", "getBizIdentifier", "getDetailUrl", "getFoodTakeoutCustomPropertyList", "getFoodTakeoutSalePackageList", "getHotSaleType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemId", "getNGroupBuyToken", "getOrderUrl", "getRoomId", "getSceneType", "getSecAuthorId", "getSkuId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/ec/model/sku/SkuBizContext;", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuBizContext implements Serializable {

    @SerializedName("action_type")
    private final String actionType;

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("biz_identifier")
    private final String bizIdentifier;

    @SerializedName("detail_url")
    private final String detailUrl;

    @SerializedName("custom_property_list")
    private final String foodTakeoutCustomPropertyList;

    @SerializedName("sale_package_list")
    private final String foodTakeoutSalePackageList;

    @SerializedName("hot_sale_type")
    private final Integer hotSaleType;

    @SerializedName("is_group_buy")
    private final Boolean isGroupBuy;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("ngroup_buy_token")
    private final String nGroupBuyToken;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID)
    private final String roomId;

    @SerializedName("scene_type")
    private final String sceneType;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName(a.KEY_SKU_ID)
    private final String skuId;

    public SkuBizContext() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public static /* synthetic */ SkuBizContext copy$default(SkuBizContext r110, String r111, String r112, String r113, Boolean r210, String r211, String r212, String r213, String r214, String r215, Integer r216, String r217, String r218, String r219, String r310, String r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.authorId;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.secAuthorId;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r102 = r110.roomId;
    L15:
        if ((r312 & 8) == 0) goto L17;
        Boolean r103 = r110.isGroupBuy;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r104 = r110.orderUrl;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r105 = r110.itemId;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r106 = r110.actionType;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r107 = r110.sceneType;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r114 = r110.skuId;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Integer r115 = r110.hotSaleType;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r116 = r110.detailUrl;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        String r117 = r110.nGroupBuyToken;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        String r118 = r110.bizIdentifier;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        String r119 = r110.foodTakeoutCustomPropertyList;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        String r108 = r110.foodTakeoutSalePackageList;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.authorId;
    }

    public final Integer component10() {
        return this.hotSaleType;
    }

    public final String component11() {
        return this.detailUrl;
    }

    public final String component12() {
        return this.nGroupBuyToken;
    }

    public final String component13() {
        return this.bizIdentifier;
    }

    public final String component14() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String component15() {
        return this.foodTakeoutSalePackageList;
    }

    public final String component2() {
        return this.secAuthorId;
    }

    public final String component3() {
        return this.roomId;
    }

    public final Boolean component4() {
        return this.isGroupBuy;
    }

    public final String component5() {
        return this.orderUrl;
    }

    public final String component6() {
        return this.itemId;
    }

    public final String component7() {
        return this.actionType;
    }

    public final String component8() {
        return this.sceneType;
    }

    public final String component9() {
        return this.skuId;
    }

    public final SkuBizContext copy(String r110, String r111, String r210, Boolean r211, String r212, String r213, String r214, String r215, String r216, Integer r217, String r218, String r219, String r310, String r311, String r312) {
        return new SkuBizContext(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuBizContext) == false) goto L36;
        SkuBizContext r101 = (SkuBizContext) r100;
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isGroupBuy, r101.isGroupBuy) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.orderUrl, r101.orderUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.sceneType, r101.sceneType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hotSaleType, r101.hotSaleType) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.detailUrl, r101.detailUrl) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.nGroupBuyToken, r101.nGroupBuyToken) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bizIdentifier, r101.bizIdentifier) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.foodTakeoutCustomPropertyList, r101.foodTakeoutCustomPropertyList) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.foodTakeoutSalePackageList, r101.foodTakeoutSalePackageList) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        String r100 = this.authorId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.secAuthorId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.roomId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isGroupBuy;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.orderUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.itemId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.actionType;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.sceneType;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.skuId;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.hotSaleType;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.detailUrl;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.nGroupBuyToken;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.bizIdentifier;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.foodTakeoutCustomPropertyList;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.foodTakeoutSalePackageList;
        if (r143 == null) goto L62;
        r101 = r143.hashCode();
    L62:
        return r142 + r101;
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

    public String toString() {
        return "SkuBizContext(authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ", roomId=" + this.roomId + ", isGroupBuy=" + this.isGroupBuy + ", orderUrl=" + this.orderUrl + ", itemId=" + this.itemId + ", actionType=" + this.actionType + ", sceneType=" + this.sceneType + ", skuId=" + this.skuId + ", hotSaleType=" + this.hotSaleType + ", detailUrl=" + this.detailUrl + ", nGroupBuyToken=" + this.nGroupBuyToken + ", bizIdentifier=" + this.bizIdentifier + ", foodTakeoutCustomPropertyList=" + this.foodTakeoutCustomPropertyList + ", foodTakeoutSalePackageList=" + this.foodTakeoutSalePackageList + ")";
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getBizIdentifier() {
        return this.bizIdentifier;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public final String getFoodTakeoutCustomPropertyList() {
        return this.foodTakeoutCustomPropertyList;
    }

    public final String getFoodTakeoutSalePackageList() {
        return this.foodTakeoutSalePackageList;
    }

    public final Integer getHotSaleType() {
        return this.hotSaleType;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getNGroupBuyToken() {
        return this.nGroupBuyToken;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSceneType() {
        return this.sceneType;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final Boolean isGroupBuy() {
        return this.isGroupBuy;
    }

    public SkuBizContext(String r100, String r101, String r102, Boolean r103, String r104, String r105, String r106, String r107, String r108, Integer r110, String r111, String r112, String r113, String r114, String r115) {
        this.authorId = r100;
        this.secAuthorId = r101;
        this.roomId = r102;
        this.isGroupBuy = r103;
        this.orderUrl = r104;
        this.itemId = r105;
        this.actionType = r106;
        this.sceneType = r107;
        this.skuId = r108;
        this.hotSaleType = r110;
        this.detailUrl = r111;
        this.nGroupBuyToken = r112;
        this.bizIdentifier = r113;
        this.foodTakeoutCustomPropertyList = r114;
        this.foodTakeoutSalePackageList = r115;
    }

    public /* synthetic */ SkuBizContext(String r110, String r111, String r112, Boolean r210, String r211, String r212, String r213, String r214, String r215, Integer r216, String r217, String r218, String r219, String r310, String r311, int r312, DefaultConstructorMarker r313) {
        String r100 = null;
        if ((r312 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r312 & 8) == 0) goto L17;
        Boolean r104 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Integer r114 = null;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        String r116 = null;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        String r118 = null;
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r100 = r311;
    L62:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r118, r100);
        return;
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r108 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
