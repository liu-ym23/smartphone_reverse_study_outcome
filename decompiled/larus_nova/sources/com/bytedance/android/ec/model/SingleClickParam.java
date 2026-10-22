package com.bytedance.android.ec.model;

import com.bytedance.android.ec.model.response.anchorv3.ButtonTipsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLink;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010.\u001a\u00020\u0003HÆ\u0003Jz\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u000fHÖ\u0001J\t\u00105\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015¨\u00066"}, d2 = {"Lcom/bytedance/android/ec/model/SingleClickParam;", "Ljava/io/Serializable;", "setGrey", "", "needCheckSku", "applyCoupon", "applyCouponPrice", "", "links", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "applyCouponIds", "", "buttonType", "Lcom/bytedance/android/ec/model/ButtonType;", "orderStatus", "", "isInSecKillActivity", "buttonTipsStruct", "Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "(ZZZJLcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;Ljava/lang/String;Lcom/bytedance/android/ec/model/ButtonType;Ljava/lang/Integer;ZLcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;)V", "getApplyCoupon", "()Z", "getApplyCouponIds", "()Ljava/lang/String;", "getApplyCouponPrice", "()J", "getButtonTipsStruct", "()Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "getButtonType", "()Lcom/bytedance/android/ec/model/ButtonType;", "getLinks", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "getNeedCheckSku", "getOrderStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSetGrey", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZZZJLcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;Ljava/lang/String;Lcom/bytedance/android/ec/model/ButtonType;Ljava/lang/Integer;ZLcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;)Lcom/bytedance/android/ec/model/SingleClickParam;", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SingleClickParam implements Serializable {
    private final boolean applyCoupon;
    private final String applyCouponIds;
    private final long applyCouponPrice;
    private final ButtonTipsStruct buttonTipsStruct;
    private final ButtonType buttonType;
    private final boolean isInSecKillActivity;
    private final PromotionProductLink links;
    private final boolean needCheckSku;
    private final Integer orderStatus;
    private final boolean setGrey;

    public SingleClickParam() {
        this(false, false, false, 0, null, null, null, null, false, null, 1023, null);
    }

    public static /* synthetic */ SingleClickParam copy$default(SingleClickParam r110, boolean r111, boolean r112, boolean r113, long r114, PromotionProductLink r115, String r116, ButtonType r210, Integer r211, boolean r212, ButtonTipsStruct r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        boolean r100 = r110.setGrey;
    L7:
        if ((r214 & 2) == 0) goto L9;
        boolean r101 = r110.needCheckSku;
    L11:
        if ((r214 & 4) == 0) goto L13;
        boolean r102 = r110.applyCoupon;
    L15:
        if ((r214 & 8) == 0) goto L17;
        long r103 = r110.applyCouponPrice;
    L19:
        if ((r214 & 16) == 0) goto L21;
        PromotionProductLink r104 = r110.links;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.applyCouponIds;
    L27:
        if ((r214 & 64) == 0) goto L29;
        ButtonType r106 = r110.buttonType;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Integer r117 = r110.orderStatus;
    L35:
        if ((r214 & 256) == 0) goto L37;
        boolean r118 = r110.isInSecKillActivity;
    L39:
        if ((r214 & 512) == 0) goto L41;
        ButtonTipsStruct r107 = r110.buttonTipsStruct;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r117, r118, r107);
    L41:
        r107 = r213;
        goto L43
    L37:
        r118 = r212;
        goto L39
    L33:
        r117 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
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

    public final boolean component1() {
        return this.setGrey;
    }

    public final ButtonTipsStruct component10() {
        return this.buttonTipsStruct;
    }

    public final boolean component2() {
        return this.needCheckSku;
    }

    public final boolean component3() {
        return this.applyCoupon;
    }

    public final long component4() {
        return this.applyCouponPrice;
    }

    public final PromotionProductLink component5() {
        return this.links;
    }

    public final String component6() {
        return this.applyCouponIds;
    }

    public final ButtonType component7() {
        return this.buttonType;
    }

    public final Integer component8() {
        return this.orderStatus;
    }

    public final boolean component9() {
        return this.isInSecKillActivity;
    }

    public final SingleClickParam copy(boolean r110, boolean r111, boolean r112, long r113, PromotionProductLink r114, String r210, ButtonType r211, Integer r212, boolean r213, ButtonTipsStruct r214) {
        Intrinsics.checkNotNullParameter(r211, "buttonType");
        return new SingleClickParam(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SingleClickParam) == false) goto L26;
        SingleClickParam r101 = (SingleClickParam) r100;
        if (this.setGrey == r101.setGrey) goto L8;
        return false;
    L8:
        if (this.needCheckSku == r101.needCheckSku) goto L10;
        return false;
    L10:
        if (this.applyCoupon == r101.applyCoupon) goto L12;
        return false;
    L12:
        if (this.applyCouponPrice == r101.applyCouponPrice) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.links, r101.links) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.applyCouponIds, r101.applyCouponIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buttonType, r101.buttonType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.orderStatus, r101.orderStatus) == true) goto L22;
        return false;
    L22:
        if (this.isInSecKillActivity == r101.isInSecKillActivity) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonTipsStruct, r101.buttonTipsStruct) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    public int hashCode() {
        boolean r100 = this.setGrey;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.needCheckSku;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.applyCoupon;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        long r110 = this.applyCouponPrice;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        PromotionProductLink r112 = this.links;
        int r113 = 0;
        if (r112 == null) goto L14;
        int r114 = r112.hashCode();
    L15:
        int r115 = (r111 + r114) * 31;
        String r116 = this.applyCouponIds;
        if (r116 == null) goto L18;
        int r117 = r116.hashCode();
    L19:
        int r118 = (r115 + r117) * 31;
        ButtonType r119 = this.buttonType;
        if (r119 == null) goto L22;
        int r120 = r119.hashCode();
    L23:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.orderStatus;
        if (r122 == null) goto L26;
        int r123 = r122.hashCode();
    L27:
        int r124 = (r121 + r123) * 31;
        boolean r125 = this.isInSecKillActivity;
        if (r125 == true) goto L31;
        r101 = r125;
    L31:
        int r126 = (r124 + r101) * 31;
        ButtonTipsStruct r127 = this.buttonTipsStruct;
        if (r127 == null) goto L35;
        r113 = r127.hashCode();
    L35:
        return r126 + r113;
    L26:
        r123 = 0;
        goto L27
    L22:
        r120 = 0;
        goto L23
    L18:
        r117 = 0;
        goto L19
    L14:
        r114 = 0;
        goto L15
    }

    public String toString() {
        return "SingleClickParam(setGrey=" + this.setGrey + ", needCheckSku=" + this.needCheckSku + ", applyCoupon=" + this.applyCoupon + ", applyCouponPrice=" + this.applyCouponPrice + ", links=" + this.links + ", applyCouponIds=" + this.applyCouponIds + ", buttonType=" + this.buttonType + ", orderStatus=" + this.orderStatus + ", isInSecKillActivity=" + this.isInSecKillActivity + ", buttonTipsStruct=" + this.buttonTipsStruct + ")";
    }

    public final boolean getApplyCoupon() {
        return this.applyCoupon;
    }

    public final String getApplyCouponIds() {
        return this.applyCouponIds;
    }

    public final long getApplyCouponPrice() {
        return this.applyCouponPrice;
    }

    public final ButtonTipsStruct getButtonTipsStruct() {
        return this.buttonTipsStruct;
    }

    public final ButtonType getButtonType() {
        return this.buttonType;
    }

    public final PromotionProductLink getLinks() {
        return this.links;
    }

    public final boolean getNeedCheckSku() {
        return this.needCheckSku;
    }

    public final Integer getOrderStatus() {
        return this.orderStatus;
    }

    public final boolean getSetGrey() {
        return this.setGrey;
    }

    public final boolean isInSecKillActivity() {
        return this.isInSecKillActivity;
    }

    public SingleClickParam(boolean r100, boolean r101, boolean r102, long r103, PromotionProductLink r104, String r105, ButtonType r106, Integer r110, boolean r111, ButtonTipsStruct r112) {
        Intrinsics.checkNotNullParameter(r106, "buttonType");
        this.setGrey = r100;
        this.needCheckSku = r101;
        this.applyCoupon = r102;
        this.applyCouponPrice = r103;
        this.links = r104;
        this.applyCouponIds = r105;
        this.buttonType = r106;
        this.orderStatus = r110;
        this.isInSecKillActivity = r111;
        this.buttonTipsStruct = r112;
    }

    public /* synthetic */ SingleClickParam(boolean r110, boolean r111, boolean r112, long r113, PromotionProductLink r114, String r210, ButtonType r211, Integer r212, boolean r213, ButtonTipsStruct r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 1) == 0) goto L5;
        boolean r100 = true;
    L6:
        boolean r101 = false;
        if ((r215 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r215 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r215 & 8) == 0) goto L17;
        long r104 = 0;
    L18:
        ButtonTipsStruct r105 = null;
        if ((r215 & 16) == 0) goto L21;
        PromotionProductLink r106 = null;
    L23:
        if ((r215 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r215 & 64) == 0) goto L29;
        ButtonType r115 = ButtonType.NORMAL;
    L31:
        if ((r215 & 128) == 0) goto L33;
        Integer r116 = null;
    L35:
        if ((r215 & 256) != 0) goto L39;
        r101 = r213;
    L39:
        if ((r215 & 512) != 0) goto L42;
        r105 = r214;
    L42:
        this(r100, r102, r103, r104, r106, r107, r115, r116, r101, r105);
        return;
    L33:
        r116 = r212;
        goto L35
    L29:
        r115 = r211;
        goto L31
    L25:
        r107 = r210;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
