package com.bytedance.android.shopping.anchorv3.sku;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010A\u001a\u00020\rHÆ\u0003J\t\u0010B\u001a\u00020\rHÆ\u0003JÒ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\rHÖ\u0001J\t\u0010I\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0017\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001f¨\u0006J"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/sku/SkuDataCollection;", "Ljava/io/Serializable;", "promotionSource", "", "h5Url", "", "isVirtual", "", "defaultImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "showLimitNumber", "addShopCart", ReportConstant.COMMON_ACTION_TYPE, "", "applyCoupon", "preSellType", "preSellDelayDes", "deliveryDelayDes", "isSecKillActivity", "isInSecKill", "kolUserTags", "isGroupingBuy", "logData", "showInstallmentFlag", "depositPresaleActivity", "Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "(JLjava/lang/String;ZLcom/bytedance/android/ec/model/ECUrlModel;ZZLjava/lang/Integer;IILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;ZLcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;)V", "getActionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAddShopCart", "()Z", "getApplyCoupon", "()I", "getDefaultImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getDeliveryDelayDes", "()Ljava/lang/String;", "getDepositPresaleActivity", "()Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "getH5Url", "getKolUserTags", "getLogData", "getPreSellDelayDes", "getPreSellType", "getPromotionSource", "()J", "getShowInstallmentFlag", "getShowLimitNumber", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;ZLcom/bytedance/android/ec/model/ECUrlModel;ZZLjava/lang/Integer;IILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;ZLcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;)Lcom/bytedance/android/shopping/anchorv3/sku/SkuDataCollection;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuDataCollection implements Serializable {
    private final Integer actionType;
    private final boolean addShopCart;
    private final int applyCoupon;
    private final ECUrlModel defaultImage;
    private final String deliveryDelayDes;
    private final PromotionDepositPresaleActivity depositPresaleActivity;
    private final String h5Url;
    private final boolean isGroupingBuy;
    private final boolean isInSecKill;
    private final boolean isSecKillActivity;
    private final boolean isVirtual;
    private final String kolUserTags;
    private final String logData;
    private final String preSellDelayDes;
    private final int preSellType;
    private final long promotionSource;
    private final boolean showInstallmentFlag;
    private final boolean showLimitNumber;

    public SkuDataCollection() {
        this(0, null, false, null, false, false, null, 0, 0, null, null, false, false, null, false, null, false, null, 262143, null);
    }

    public static /* synthetic */ SkuDataCollection copy$default(SkuDataCollection r110, long r111, String r210, boolean r211, ECUrlModel r212, boolean r213, boolean r214, Integer r215, int r216, int r217, String r218, String r219, boolean r310, boolean r311, String r312, boolean r313, String r314, boolean r315, PromotionDepositPresaleActivity r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        long r100 = r110.promotionSource;
    L7:
        if ((r317 & 2) == 0) goto L9;
        String r101 = r110.h5Url;
    L11:
        if ((r317 & 4) == 0) goto L13;
        boolean r102 = r110.isVirtual;
    L15:
        if ((r317 & 8) == 0) goto L17;
        ECUrlModel r103 = r110.defaultImage;
    L19:
        if ((r317 & 16) == 0) goto L21;
        boolean r104 = r110.showLimitNumber;
    L23:
        if ((r317 & 32) == 0) goto L25;
        boolean r105 = r110.addShopCart;
    L27:
        if ((r317 & 64) == 0) goto L29;
        Integer r106 = r110.actionType;
    L31:
        if ((r317 & 128) == 0) goto L33;
        int r112 = r110.applyCoupon;
    L35:
        if ((r317 & 256) == 0) goto L37;
        int r113 = r110.preSellType;
    L39:
        if ((r317 & 512) == 0) goto L41;
        String r114 = r110.preSellDelayDes;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        String r115 = r110.deliveryDelayDes;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        boolean r116 = r110.isSecKillActivity;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        boolean r117 = r110.isInSecKill;
    L54:
        boolean r319 = r117;
        if ((r317 & 8192) == 0) goto L57;
        String r118 = r110.kolUserTags;
    L58:
        String r320 = r118;
        if ((r317 & 16384) == 0) goto L61;
        boolean r119 = r110.isGroupingBuy;
    L62:
        boolean r321 = r119;
        if ((r317 & 32768) == 0) goto L65;
        String r120 = r110.logData;
    L66:
        String r322 = r120;
        if ((r317 & 65536) == 0) goto L69;
        boolean r121 = r110.showInstallmentFlag;
    L71:
        if ((r317 & 131072) == 0) goto L73;
        PromotionDepositPresaleActivity r107 = r110.depositPresaleActivity;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r319, r320, r321, r322, r121, r107);
    L73:
        r107 = r316;
        goto L75
    L69:
        r121 = r315;
        goto L71
    L65:
        r120 = r314;
        goto L66
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r219;
        goto L47
    L41:
        r114 = r218;
        goto L43
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.promotionSource;
    }

    public final String component10() {
        return this.preSellDelayDes;
    }

    public final String component11() {
        return this.deliveryDelayDes;
    }

    public final boolean component12() {
        return this.isSecKillActivity;
    }

    public final boolean component13() {
        return this.isInSecKill;
    }

    public final String component14() {
        return this.kolUserTags;
    }

    public final boolean component15() {
        return this.isGroupingBuy;
    }

    public final String component16() {
        return this.logData;
    }

    public final boolean component17() {
        return this.showInstallmentFlag;
    }

    public final PromotionDepositPresaleActivity component18() {
        return this.depositPresaleActivity;
    }

    public final String component2() {
        return this.h5Url;
    }

    public final boolean component3() {
        return this.isVirtual;
    }

    public final ECUrlModel component4() {
        return this.defaultImage;
    }

    public final boolean component5() {
        return this.showLimitNumber;
    }

    public final boolean component6() {
        return this.addShopCart;
    }

    public final Integer component7() {
        return this.actionType;
    }

    public final int component8() {
        return this.applyCoupon;
    }

    public final int component9() {
        return this.preSellType;
    }

    public final SkuDataCollection copy(long r210, String r211, boolean r212, ECUrlModel r213, boolean r214, boolean r215, Integer r216, int r310, int r311, String r312, String r313, boolean r314, boolean r315, String r316, boolean r317, String r318, boolean r319, PromotionDepositPresaleActivity r410) {
        return new SkuDataCollection(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuDataCollection) == false) goto L42;
        SkuDataCollection r101 = (SkuDataCollection) r100;
        if (this.promotionSource == r101.promotionSource) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.h5Url, r101.h5Url) == true) goto L10;
        return false;
    L10:
        if (this.isVirtual == r101.isVirtual) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultImage, r101.defaultImage) == true) goto L14;
        return false;
    L14:
        if (this.showLimitNumber == r101.showLimitNumber) goto L16;
        return false;
    L16:
        if (this.addShopCart == r101.addShopCart) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L20;
        return false;
    L20:
        if (this.applyCoupon == r101.applyCoupon) goto L22;
        return false;
    L22:
        if (this.preSellType == r101.preSellType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.preSellDelayDes, r101.preSellDelayDes) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.deliveryDelayDes, r101.deliveryDelayDes) == true) goto L28;
        return false;
    L28:
        if (this.isSecKillActivity == r101.isSecKillActivity) goto L30;
        return false;
    L30:
        if (this.isInSecKill == r101.isInSecKill) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.kolUserTags, r101.kolUserTags) == true) goto L34;
        return false;
    L34:
        if (this.isGroupingBuy == r101.isGroupingBuy) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.logData, r101.logData) == true) goto L38;
        return false;
    L38:
        if (this.showInstallmentFlag == r101.showInstallmentFlag) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.depositPresaleActivity, r101.depositPresaleActivity) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        long r100 = this.promotionSource;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.h5Url;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.isVirtual;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L9;
        r108 = 1;
    L9:
        int r109 = (r105 + r108) * 31;
        ECUrlModel r110 = this.defaultImage;
        if (r110 == null) goto L12;
        int r111 = r110.hashCode();
    L13:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.showLimitNumber;
        ?? r114 = r113;
        if (r113 == false) goto L16;
        r114 = 1;
    L16:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.addShopCart;
        ?? r117 = r116;
        if (r116 == false) goto L19;
        r117 = 1;
    L19:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.actionType;
        if (r119 == null) goto L22;
        int r120 = r119.hashCode();
    L23:
        int r121 = (((((r118 + r120) * 31) + this.applyCoupon) * 31) + this.preSellType) * 31;
        String r122 = this.preSellDelayDes;
        if (r122 == null) goto L26;
        int r123 = r122.hashCode();
    L27:
        int r124 = (r121 + r123) * 31;
        String r125 = this.deliveryDelayDes;
        if (r125 == null) goto L30;
        int r126 = r125.hashCode();
    L31:
        int r127 = (r124 + r126) * 31;
        boolean r128 = this.isSecKillActivity;
        ?? r129 = r128;
        if (r128 == false) goto L34;
        r129 = 1;
    L34:
        int r130 = (r127 + r129) * 31;
        boolean r131 = this.isInSecKill;
        ?? r132 = r131;
        if (r131 == false) goto L37;
        r132 = 1;
    L37:
        int r133 = (r130 + r132) * 31;
        String r134 = this.kolUserTags;
        if (r134 == null) goto L40;
        int r135 = r134.hashCode();
    L41:
        int r136 = (r133 + r135) * 31;
        boolean r137 = this.isGroupingBuy;
        ?? r138 = r137;
        if (r137 == false) goto L44;
        r138 = 1;
    L44:
        int r139 = (r136 + r138) * 31;
        String r140 = this.logData;
        if (r140 == null) goto L47;
        int r141 = r140.hashCode();
    L48:
        int r142 = (r139 + r141) * 31;
        boolean r143 = this.showInstallmentFlag;
        if (r143 == true) goto L52;
        r107 = r143;
    L52:
        int r144 = (r142 + r107) * 31;
        PromotionDepositPresaleActivity r145 = this.depositPresaleActivity;
        if (r145 == null) goto L56;
        r103 = r145.hashCode();
    L56:
        return r144 + r103;
    L47:
        r141 = 0;
        goto L48
    L40:
        r135 = 0;
        goto L41
    L30:
        r126 = 0;
        goto L31
    L26:
        r123 = 0;
        goto L27
    L22:
        r120 = 0;
        goto L23
    L12:
        r111 = 0;
        goto L13
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "SkuDataCollection(promotionSource=" + this.promotionSource + ", h5Url=" + this.h5Url + ", isVirtual=" + this.isVirtual + ", defaultImage=" + this.defaultImage + ", showLimitNumber=" + this.showLimitNumber + ", addShopCart=" + this.addShopCart + ", actionType=" + this.actionType + ", applyCoupon=" + this.applyCoupon + ", preSellType=" + this.preSellType + ", preSellDelayDes=" + this.preSellDelayDes + ", deliveryDelayDes=" + this.deliveryDelayDes + ", isSecKillActivity=" + this.isSecKillActivity + ", isInSecKill=" + this.isInSecKill + ", kolUserTags=" + this.kolUserTags + ", isGroupingBuy=" + this.isGroupingBuy + ", logData=" + this.logData + ", showInstallmentFlag=" + this.showInstallmentFlag + ", depositPresaleActivity=" + this.depositPresaleActivity + ")";
    }

    public final Integer getActionType() {
        return this.actionType;
    }

    public final boolean getAddShopCart() {
        return this.addShopCart;
    }

    public final int getApplyCoupon() {
        return this.applyCoupon;
    }

    public final ECUrlModel getDefaultImage() {
        return this.defaultImage;
    }

    public final String getDeliveryDelayDes() {
        return this.deliveryDelayDes;
    }

    public final PromotionDepositPresaleActivity getDepositPresaleActivity() {
        return this.depositPresaleActivity;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final String getKolUserTags() {
        return this.kolUserTags;
    }

    public final String getLogData() {
        return this.logData;
    }

    public final String getPreSellDelayDes() {
        return this.preSellDelayDes;
    }

    public final int getPreSellType() {
        return this.preSellType;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final boolean getShowInstallmentFlag() {
        return this.showInstallmentFlag;
    }

    public final boolean getShowLimitNumber() {
        return this.showLimitNumber;
    }

    public final boolean isGroupingBuy() {
        return this.isGroupingBuy;
    }

    public final boolean isInSecKill() {
        return this.isInSecKill;
    }

    public final boolean isSecKillActivity() {
        return this.isSecKillActivity;
    }

    public final boolean isVirtual() {
        return this.isVirtual;
    }

    public SkuDataCollection(long r100, String r101, boolean r102, ECUrlModel r103, boolean r104, boolean r110, Integer r111, int r112, int r113, String r114, String r115, boolean r116, boolean r117, String r118, boolean r119, String r210, boolean r211, PromotionDepositPresaleActivity r212) {
        this.promotionSource = r100;
        this.h5Url = r101;
        this.isVirtual = r102;
        this.defaultImage = r103;
        this.showLimitNumber = r104;
        this.addShopCart = r110;
        this.actionType = r111;
        this.applyCoupon = r112;
        this.preSellType = r113;
        this.preSellDelayDes = r114;
        this.deliveryDelayDes = r115;
        this.isSecKillActivity = r116;
        this.isInSecKill = r117;
        this.kolUserTags = r118;
        this.isGroupingBuy = r119;
        this.logData = r210;
        this.showInstallmentFlag = r211;
        this.depositPresaleActivity = r212;
    }

    public /* synthetic */ SkuDataCollection(long r210, String r211, boolean r212, ECUrlModel r213, boolean r214, boolean r215, Integer r216, int r217, int r218, String r310, String r311, boolean r312, boolean r313, String r314, boolean r315, String r316, boolean r317, PromotionDepositPresaleActivity r318, int r319, DefaultConstructorMarker r410) {
        if ((r319 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r319 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r319 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r319 & 8) == 0) goto L17;
        ECUrlModel r103 = null;
    L19:
        if ((r319 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r319 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r319 & 64) == 0) goto L29;
        Integer r110 = null;
    L31:
        if ((r319 & 128) == 0) goto L33;
        int r111 = 0;
    L35:
        if ((r319 & 256) == 0) goto L37;
        int r112 = 0;
    L39:
        if ((r319 & 512) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        boolean r115 = false;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        boolean r106 = false;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        String r107 = null;
    L58:
        String r411 = r107;
        if ((r319 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r319 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r319 & 65536) == 0) goto L69;
        boolean r117 = false;
    L71:
        if ((r319 & 131072) == 0) goto L73;
        PromotionDepositPresaleActivity r109 = null;
    L74:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r411, r108, r116, r117, r109);
        return;
    L73:
        r109 = r318;
        goto L74
    L69:
        r117 = r317;
        goto L71
    L65:
        r116 = r316;
        goto L67
    L61:
        r108 = r315;
        goto L63
    L57:
        r107 = r314;
        goto L58
    L53:
        r106 = r313;
        goto L55
    L49:
        r115 = r312;
        goto L51
    L45:
        r114 = r311;
        goto L47
    L41:
        r113 = r310;
        goto L43
    L37:
        r112 = r218;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
