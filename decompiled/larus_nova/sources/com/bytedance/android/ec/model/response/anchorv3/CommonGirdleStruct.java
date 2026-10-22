package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 <2\u00020\u0001:\u0001=B\u0081\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b:\u0010;J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u009e\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020!HÖ\u0001J\u0013\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b-\u0010,R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b.\u0010,R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b/\u0010,R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00100\u001a\u0004\b3\u00102R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b4\u00102R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b5\u00102R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b6\u00102R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b8\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b9\u0010\u0010¨\u0006>"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component2", "component3", "component4", "component5", "", "component6", "component7", "component8", "component9", "component10", "component11", "()Ljava/lang/Long;", "component12", "type", "background", "leftBackground", "midBackground", "rightBackground", "effectivePriceDesc", "discountPriceDesc", "regularPriceDesc", "priceDesc", "headerText", "endTime", "serverTime", "copy", "(JLcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;", "toString", "", "hashCode", "", "other", "", "equals", "J", "getType", "()J", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBackground", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getLeftBackground", "getMidBackground", "getRightBackground", "Ljava/lang/String;", "getEffectivePriceDesc", "()Ljava/lang/String;", "getDiscountPriceDesc", "getRegularPriceDesc", "getPriceDesc", "getHeaderText", "Ljava/lang/Long;", "getEndTime", "getServerTime", "<init>", "(JLcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CommonGirdleStruct implements Serializable {
    public static final a Companion = null;
    public static final long TYPE_NEWBIE_COUPON = 150;
    public static final long TYPE_PLATFORM = 160;

    @SerializedName("bg_picture")
    private final ECUrlModel background;

    @SerializedName("discount_price_desc")
    private final String discountPriceDesc;

    @SerializedName("effective_price_desc")
    private final String effectivePriceDesc;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("header_text")
    private final String headerText;

    @SerializedName("bg_left_picture")
    private final ECUrlModel leftBackground;

    @SerializedName("bg_mid_picture")
    private final ECUrlModel midBackground;

    @SerializedName("price_desc")
    private final String priceDesc;

    @SerializedName("regular_price_desc")
    private final String regularPriceDesc;

    @SerializedName("bg_right_picture")
    private final ECUrlModel rightBackground;

    @SerializedName("server_time")
    private final Long serverTime;

    @SerializedName("type")
    private final long type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ CommonGirdleStruct copy$default(CommonGirdleStruct r110, long r111, ECUrlModel r112, ECUrlModel r113, ECUrlModel r114, ECUrlModel r210, String r211, String r212, String r213, String r214, String r215, Long r216, Long r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        long r100 = r110.type;
    L7:
        if ((r218 & 2) == 0) goto L9;
        ECUrlModel r101 = r110.background;
    L11:
        if ((r218 & 4) == 0) goto L13;
        ECUrlModel r102 = r110.leftBackground;
    L15:
        if ((r218 & 8) == 0) goto L17;
        ECUrlModel r103 = r110.midBackground;
    L19:
        if ((r218 & 16) == 0) goto L21;
        ECUrlModel r104 = r110.rightBackground;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = r110.effectivePriceDesc;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r106 = r110.discountPriceDesc;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r115 = r110.regularPriceDesc;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.priceDesc;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r117 = r110.headerText;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Long r118 = r110.endTime;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        Long r107 = r110.serverTime;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r115, r116, r117, r118, r107);
    L49:
        r107 = r217;
        goto L51
    L45:
        r118 = r216;
        goto L47
    L41:
        r117 = r215;
        goto L43
    L37:
        r116 = r214;
        goto L39
    L33:
        r115 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public final long component1() {
        return this.type;
    }

    public final String component10() {
        return this.headerText;
    }

    public final Long component11() {
        return this.endTime;
    }

    public final Long component12() {
        return this.serverTime;
    }

    public final ECUrlModel component2() {
        return this.background;
    }

    public final ECUrlModel component3() {
        return this.leftBackground;
    }

    public final ECUrlModel component4() {
        return this.midBackground;
    }

    public final ECUrlModel component5() {
        return this.rightBackground;
    }

    public final String component6() {
        return this.effectivePriceDesc;
    }

    public final String component7() {
        return this.discountPriceDesc;
    }

    public final String component8() {
        return this.regularPriceDesc;
    }

    public final String component9() {
        return this.priceDesc;
    }

    public final CommonGirdleStruct copy(long r110, ECUrlModel r111, ECUrlModel r112, ECUrlModel r210, ECUrlModel r211, String r212, String r213, String r214, String r215, String r216, Long r217, Long r218) {
        return new CommonGirdleStruct(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonGirdleStruct) == false) goto L30;
        CommonGirdleStruct r101 = (CommonGirdleStruct) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftBackground, r101.leftBackground) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.midBackground, r101.midBackground) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.rightBackground, r101.rightBackground) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.effectivePriceDesc, r101.effectivePriceDesc) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountPriceDesc, r101.discountPriceDesc) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.regularPriceDesc, r101.regularPriceDesc) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.priceDesc, r101.priceDesc) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headerText, r101.headerText) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.serverTime, r101.serverTime) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        long r100 = this.type;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        ECUrlModel r102 = this.background;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        ECUrlModel r106 = this.leftBackground;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        ECUrlModel r109 = this.midBackground;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        ECUrlModel r112 = this.rightBackground;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.effectivePriceDesc;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.discountPriceDesc;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.regularPriceDesc;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        String r124 = this.priceDesc;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.headerText;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (r126 + r128) * 31;
        Long r130 = this.endTime;
        if (r130 == null) goto L41;
        int r131 = r130.hashCode();
    L42:
        int r132 = (r129 + r131) * 31;
        Long r133 = this.serverTime;
        if (r133 == null) goto L46;
        r103 = r133.hashCode();
    L46:
        return r132 + r103;
    L41:
        r131 = 0;
        goto L42
    L37:
        r128 = 0;
        goto L38
    L33:
        r125 = 0;
        goto L34
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "CommonGirdleStruct(type=" + this.type + ", background=" + this.background + ", leftBackground=" + this.leftBackground + ", midBackground=" + this.midBackground + ", rightBackground=" + this.rightBackground + ", effectivePriceDesc=" + this.effectivePriceDesc + ", discountPriceDesc=" + this.discountPriceDesc + ", regularPriceDesc=" + this.regularPriceDesc + ", priceDesc=" + this.priceDesc + ", headerText=" + this.headerText + ", endTime=" + this.endTime + ", serverTime=" + this.serverTime + ")";
    }

    public final ECUrlModel getBackground() {
        return this.background;
    }

    public final String getDiscountPriceDesc() {
        return this.discountPriceDesc;
    }

    public final String getEffectivePriceDesc() {
        return this.effectivePriceDesc;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final String getHeaderText() {
        return this.headerText;
    }

    public final ECUrlModel getLeftBackground() {
        return this.leftBackground;
    }

    public final ECUrlModel getMidBackground() {
        return this.midBackground;
    }

    public final String getPriceDesc() {
        return this.priceDesc;
    }

    public final String getRegularPriceDesc() {
        return this.regularPriceDesc;
    }

    public final ECUrlModel getRightBackground() {
        return this.rightBackground;
    }

    public final Long getServerTime() {
        return this.serverTime;
    }

    public final long getType() {
        return this.type;
    }

    public CommonGirdleStruct(long r100, ECUrlModel r101, ECUrlModel r102, ECUrlModel r103, ECUrlModel r104, String r105, String r106, String r107, String r110, String r111, Long r112, Long r113) {
        this.type = r100;
        this.background = r101;
        this.leftBackground = r102;
        this.midBackground = r103;
        this.rightBackground = r104;
        this.effectivePriceDesc = r105;
        this.discountPriceDesc = r106;
        this.regularPriceDesc = r107;
        this.priceDesc = r110;
        this.headerText = r111;
        this.endTime = r112;
        this.serverTime = r113;
    }

    public /* synthetic */ CommonGirdleStruct(long r110, ECUrlModel r210, ECUrlModel r211, ECUrlModel r212, ECUrlModel r213, String r214, String r215, String r216, String r217, String r218, Long r219, Long r310, int r311, DefaultConstructorMarker r312) {
        if ((r311 & 1024) == 0) goto L5;
        Long r111 = null;
    L7:
        if ((r311 & 2048) == 0) goto L9;
        Long r112 = null;
    L10:
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r111, r112);
        return;
    L9:
        r112 = r310;
        goto L10
    L5:
        r111 = r219;
        goto L7
    }
}
