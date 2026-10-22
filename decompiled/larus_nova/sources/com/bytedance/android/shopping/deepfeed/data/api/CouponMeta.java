package com.bytedance.android.shopping.deepfeed.data.api;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016Jª\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\bHÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b%\u0010\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014¨\u0006<"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/api/CouponMeta;", "Ljava/io/Serializable;", "couponMetaId", "", "couponMetaName", "", "couponMetaDesc", "status", "", "couponType", "shopId", "limitKolId", "couponSubType", "discount", "threshold", "credit", "thresholdText", "productId", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getCouponMetaDesc", "()Ljava/lang/String;", "getCouponMetaId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCouponMetaName", "getCouponSubType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCouponType", "getCredit", "getDiscount", "getLimitKolId", "getProductId", "setProductId", "(Ljava/lang/String;)V", "getShopId", "getStatus", "getThreshold", "getThresholdText", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/deepfeed/data/api/CouponMeta;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponMeta implements Serializable {

    @SerializedName("coupon_meta_desc")
    private final String couponMetaDesc;

    @SerializedName("coupon_meta_id")
    private final Long couponMetaId;

    @SerializedName("coupon_meta_name")
    private final String couponMetaName;

    @SerializedName("coupon_sub_type")
    private final Integer couponSubType;

    @SerializedName(a.KEY_COUPON_TYPE)
    private final Integer couponType;

    @SerializedName("credit")
    private final Long credit;

    @SerializedName("discount")
    private final Long discount;

    @SerializedName("limit_kol_id")
    private final Long limitKolId;
    private String productId;

    @SerializedName(a.KEY_SHOP_ID)
    private final Long shopId;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("threshold")
    private final Long threshold;

    @SerializedName("threshold_text")
    private final String thresholdText;

    public CouponMeta() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public static /* synthetic */ CouponMeta copy$default(CouponMeta r110, Long r111, String r112, String r113, Integer r114, Integer r115, Long r210, Long r211, Integer r212, Long r213, Long r214, Long r215, String r216, String r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        Long r100 = r110.couponMetaId;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.couponMetaName;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = r110.couponMetaDesc;
    L15:
        if ((r218 & 8) == 0) goto L17;
        Integer r103 = r110.status;
    L19:
        if ((r218 & 16) == 0) goto L21;
        Integer r104 = r110.couponType;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Long r105 = r110.shopId;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Long r106 = r110.limitKolId;
    L31:
        if ((r218 & 128) == 0) goto L33;
        Integer r107 = r110.couponSubType;
    L35:
        if ((r218 & 256) == 0) goto L37;
        Long r116 = r110.discount;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Long r117 = r110.threshold;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Long r118 = r110.credit;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r119 = r110.thresholdText;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        String r108 = r110.productId;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
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

    public final Long component1() {
        return this.couponMetaId;
    }

    public final Long component10() {
        return this.threshold;
    }

    public final Long component11() {
        return this.credit;
    }

    public final String component12() {
        return this.thresholdText;
    }

    public final String component13() {
        return this.productId;
    }

    public final String component2() {
        return this.couponMetaName;
    }

    public final String component3() {
        return this.couponMetaDesc;
    }

    public final Integer component4() {
        return this.status;
    }

    public final Integer component5() {
        return this.couponType;
    }

    public final Long component6() {
        return this.shopId;
    }

    public final Long component7() {
        return this.limitKolId;
    }

    public final Integer component8() {
        return this.couponSubType;
    }

    public final Long component9() {
        return this.discount;
    }

    public final CouponMeta copy(Long r110, String r111, String r112, Integer r113, Integer r210, Long r211, Long r212, Integer r213, Long r214, Long r215, Long r216, String r217, String r218) {
        return new CouponMeta(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CouponMeta) == false) goto L32;
        CouponMeta r101 = (CouponMeta) r100;
        if (Intrinsics.areEqual(this.couponMetaId, r101.couponMetaId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.couponMetaName, r101.couponMetaName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.couponMetaDesc, r101.couponMetaDesc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.couponType, r101.couponType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.limitKolId, r101.limitKolId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.couponSubType, r101.couponSubType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.discount, r101.discount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.threshold, r101.threshold) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.credit, r101.credit) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.thresholdText, r101.thresholdText) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        Long r100 = this.couponMetaId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.couponMetaName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.couponMetaDesc;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.status;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.couponType;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.shopId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.limitKolId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.couponSubType;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.discount;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.threshold;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.credit;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.thresholdText;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.productId;
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

    public String toString() {
        return "CouponMeta(couponMetaId=" + this.couponMetaId + ", couponMetaName=" + this.couponMetaName + ", couponMetaDesc=" + this.couponMetaDesc + ", status=" + this.status + ", couponType=" + this.couponType + ", shopId=" + this.shopId + ", limitKolId=" + this.limitKolId + ", couponSubType=" + this.couponSubType + ", discount=" + this.discount + ", threshold=" + this.threshold + ", credit=" + this.credit + ", thresholdText=" + this.thresholdText + ", productId=" + this.productId + ")";
    }

    public final String getCouponMetaDesc() {
        return this.couponMetaDesc;
    }

    public final Long getCouponMetaId() {
        return this.couponMetaId;
    }

    public final String getCouponMetaName() {
        return this.couponMetaName;
    }

    public final Integer getCouponSubType() {
        return this.couponSubType;
    }

    public final Integer getCouponType() {
        return this.couponType;
    }

    public final Long getCredit() {
        return this.credit;
    }

    public final Long getDiscount() {
        return this.discount;
    }

    public final Long getLimitKolId() {
        return this.limitKolId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Long getShopId() {
        return this.shopId;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Long getThreshold() {
        return this.threshold;
    }

    public final String getThresholdText() {
        return this.thresholdText;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public CouponMeta(Long r100, String r101, String r102, Integer r103, Integer r104, Long r105, Long r106, Integer r107, Long r108, Long r110, Long r111, String r112, String r113) {
        this.couponMetaId = r100;
        this.couponMetaName = r101;
        this.couponMetaDesc = r102;
        this.status = r103;
        this.couponType = r104;
        this.shopId = r105;
        this.limitKolId = r106;
        this.couponSubType = r107;
        this.discount = r108;
        this.threshold = r110;
        this.credit = r111;
        this.thresholdText = r112;
        this.productId = r113;
    }

    public /* synthetic */ CouponMeta(Long r110, String r111, String r112, Integer r113, Integer r114, Long r210, Long r211, Integer r212, Long r213, Long r214, Long r215, String r216, String r217, int r218, DefaultConstructorMarker r219) {
        String r100 = null;
        if ((r218 & 1) == 0) goto L5;
        Long r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r218 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Long r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Long r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r218 & 256) == 0) goto L37;
        Long r115 = null;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Long r116 = null;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Long r117 = null;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r118 = null;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r100 = r217;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
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
