package com.bytedance.android.shopping.threed.repository.dto;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ButtonTime;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.ButtonTipsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLink;
import com.bytedance.android.livesdk.gift.model.n;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0019J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00108\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010@\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010B\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJÎ\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\bHÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b(\u0010!R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b)\u0010\u001bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b,\u0010\u001bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b-\u0010\u001eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00100¨\u0006K"}, d2 = {"Lcom/bytedance/android/shopping/threed/repository/dto/BuyButtonComponent;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "links", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "text", "", n.KEY_SUB_TEXT, "orderStatus", "", "applyCoupon", "applyCouponPrice", "", "alreadyBuy", "", "needCheckSku", "payType", "buttonTips", "Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "wordColor", "grayButton", "buttonTime", "Lcom/bytedance/android/ec/model/ButtonTime;", "buttonType", "tips", "discountPrice", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;Ljava/lang/String;Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/ButtonTime;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getAlreadyBuy", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApplyCoupon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getApplyCouponPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getButtonTime", "()Lcom/bytedance/android/ec/model/ButtonTime;", "getButtonTips", "()Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "getButtonType", "getDiscountPrice", "getGrayButton", "getLinks", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "getNeedCheckSku", "getOrderStatus", "getPayType", "getSubText", "()Ljava/lang/String;", "getText", "getTips", "getWordColor", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;Ljava/lang/String;Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/ButtonTime;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/shopping/threed/repository/dto/BuyButtonComponent;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyButtonComponent extends CommerceBaseResponse {

    @SerializedName("already_buy")
    private final Boolean alreadyBuy;

    @SerializedName("apply_coupon")
    private final Integer applyCoupon;

    @SerializedName("apply_coupon_price")
    private final Long applyCouponPrice;

    @SerializedName("button_time")
    private final ButtonTime buttonTime;

    @SerializedName("button_tips")
    private final ButtonTipsStruct buttonTips;

    @SerializedName(a.KEY_BUTTON_TYPE)
    private final Integer buttonType;

    @SerializedName("price")
    private final Long discountPrice;

    @SerializedName("gray_button")
    private final Boolean grayButton;

    @SerializedName("links")
    private final PromotionProductLink links;

    @SerializedName("need_check_sku")
    private final Boolean needCheckSku;

    @SerializedName(EventConstants.ExtraJson.KEY_ORDER_STATUS)
    private final Integer orderStatus;

    @SerializedName("pay_type")
    private final Integer payType;

    @SerializedName("sub_text")
    private final String subText;

    @SerializedName("text")
    private final String text;

    @SerializedName("tips")
    private final String tips;

    @SerializedName("word_color")
    private final String wordColor;

    public BuyButtonComponent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public static /* synthetic */ BuyButtonComponent copy$default(BuyButtonComponent r110, PromotionProductLink r111, String r112, String r210, Integer r211, Integer r212, Long r213, Boolean r214, Boolean r215, Integer r216, ButtonTipsStruct r217, String r218, Boolean r219, ButtonTime r310, Integer r311, String r312, Long r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        PromotionProductLink r100 = r110.links;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.text;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.subText;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Integer r103 = r110.orderStatus;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Integer r104 = r110.applyCoupon;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Long r105 = r110.applyCouponPrice;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Boolean r106 = r110.alreadyBuy;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Boolean r107 = r110.needCheckSku;
    L35:
        if ((r314 & 256) == 0) goto L37;
        Integer r113 = r110.payType;
    L39:
        if ((r314 & 512) == 0) goto L41;
        ButtonTipsStruct r114 = r110.buttonTips;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r115 = r110.wordColor;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        Boolean r116 = r110.grayButton;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        ButtonTime r117 = r110.buttonTime;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        Integer r118 = r110.buttonType;
    L58:
        Integer r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        String r119 = r110.tips;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        Long r108 = r110.discountPrice;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final PromotionProductLink component1() {
        return this.links;
    }

    public final ButtonTipsStruct component10() {
        return this.buttonTips;
    }

    public final String component11() {
        return this.wordColor;
    }

    public final Boolean component12() {
        return this.grayButton;
    }

    public final ButtonTime component13() {
        return this.buttonTime;
    }

    public final Integer component14() {
        return this.buttonType;
    }

    public final String component15() {
        return this.tips;
    }

    public final Long component16() {
        return this.discountPrice;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.subText;
    }

    public final Integer component4() {
        return this.orderStatus;
    }

    public final Integer component5() {
        return this.applyCoupon;
    }

    public final Long component6() {
        return this.applyCouponPrice;
    }

    public final Boolean component7() {
        return this.alreadyBuy;
    }

    public final Boolean component8() {
        return this.needCheckSku;
    }

    public final Integer component9() {
        return this.payType;
    }

    public final BuyButtonComponent copy(PromotionProductLink r110, String r210, String r211, Integer r212, Integer r213, Long r214, Boolean r215, Boolean r216, Integer r217, ButtonTipsStruct r218, String r219, Boolean r310, ButtonTime r311, Integer r312, String r313, Long r314) {
        return new BuyButtonComponent(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BuyButtonComponent) == false) goto L38;
        BuyButtonComponent r101 = (BuyButtonComponent) r100;
        if (Intrinsics.areEqual(this.links, r101.links) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subText, r101.subText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderStatus, r101.orderStatus) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.applyCoupon, r101.applyCoupon) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.applyCouponPrice, r101.applyCouponPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.alreadyBuy, r101.alreadyBuy) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.needCheckSku, r101.needCheckSku) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.payType, r101.payType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonTips, r101.buttonTips) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.wordColor, r101.wordColor) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.grayButton, r101.grayButton) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.buttonTime, r101.buttonTime) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.buttonType, r101.buttonType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        PromotionProductLink r100 = this.links;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.subText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.orderStatus;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.applyCoupon;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.applyCouponPrice;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.alreadyBuy;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.needCheckSku;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.payType;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        ButtonTipsStruct r128 = this.buttonTips;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.wordColor;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.grayButton;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        ButtonTime r137 = this.buttonTime;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.buttonType;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.tips;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Long r146 = this.discountPrice;
        if (r146 == null) goto L66;
        r101 = r146.hashCode();
    L66:
        return r145 + r101;
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

    public String toString() {
        return "BuyButtonComponent(links=" + this.links + ", text=" + this.text + ", subText=" + this.subText + ", orderStatus=" + this.orderStatus + ", applyCoupon=" + this.applyCoupon + ", applyCouponPrice=" + this.applyCouponPrice + ", alreadyBuy=" + this.alreadyBuy + ", needCheckSku=" + this.needCheckSku + ", payType=" + this.payType + ", buttonTips=" + this.buttonTips + ", wordColor=" + this.wordColor + ", grayButton=" + this.grayButton + ", buttonTime=" + this.buttonTime + ", buttonType=" + this.buttonType + ", tips=" + this.tips + ", discountPrice=" + this.discountPrice + ")";
    }

    public final Boolean getAlreadyBuy() {
        return this.alreadyBuy;
    }

    public final Integer getApplyCoupon() {
        return this.applyCoupon;
    }

    public final Long getApplyCouponPrice() {
        return this.applyCouponPrice;
    }

    public final ButtonTime getButtonTime() {
        return this.buttonTime;
    }

    public final ButtonTipsStruct getButtonTips() {
        return this.buttonTips;
    }

    public final Integer getButtonType() {
        return this.buttonType;
    }

    public final Long getDiscountPrice() {
        return this.discountPrice;
    }

    public final Boolean getGrayButton() {
        return this.grayButton;
    }

    public final PromotionProductLink getLinks() {
        return this.links;
    }

    public final Boolean getNeedCheckSku() {
        return this.needCheckSku;
    }

    public final Integer getOrderStatus() {
        return this.orderStatus;
    }

    public final Integer getPayType() {
        return this.payType;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getWordColor() {
        return this.wordColor;
    }

    public BuyButtonComponent(PromotionProductLink r100, String r101, String r102, Integer r103, Integer r104, Long r105, Boolean r106, Boolean r110, Integer r111, ButtonTipsStruct r112, String r113, Boolean r114, ButtonTime r115, Integer r116, String r117, Long r118) {
        this.links = r100;
        this.text = r101;
        this.subText = r102;
        this.orderStatus = r103;
        this.applyCoupon = r104;
        this.applyCouponPrice = r105;
        this.alreadyBuy = r106;
        this.needCheckSku = r110;
        this.payType = r111;
        this.buttonTips = r112;
        this.wordColor = r113;
        this.grayButton = r114;
        this.buttonTime = r115;
        this.buttonType = r116;
        this.tips = r117;
        this.discountPrice = r118;
    }

    public /* synthetic */ BuyButtonComponent(PromotionProductLink r110, String r111, String r210, Integer r211, Integer r212, Long r213, Boolean r214, Boolean r215, Integer r216, ButtonTipsStruct r217, String r218, Boolean r219, ButtonTime r310, Integer r311, String r312, Long r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        PromotionProductLink r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Long r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Boolean r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Boolean r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        Integer r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        ButtonTipsStruct r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        Boolean r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        ButtonTime r116 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        Integer r117 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        Long r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
