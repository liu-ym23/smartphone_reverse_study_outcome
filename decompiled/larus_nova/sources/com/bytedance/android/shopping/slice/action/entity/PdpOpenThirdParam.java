package com.bytedance.android.shopping.slice.action.entity;

import com.bytedance.android.ec.model.ECAdLogExtra;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001CB¯\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b@\u0010AJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J¸\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\u0002HÖ\u0001J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\u0013\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b/\u0010.R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b0\u0010.R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b3\u0010.R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b4\u0010.R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b5\u0010.R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b6\u0010.R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b7\u0010.R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0010R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\b:\u0010.R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010,\u001a\u0004\b;\u0010.R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010,\u001a\u0004\b<\u0010.R\u001c\u0010#\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/PdpOpenThirdParam;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "()Ljava/lang/Long;", "component5", "component6", "component7", "component8", "component9", "", "component10", "()Ljava/lang/Integer;", "component11", "component12", "component13", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "component14", "orderUrl", "smallAppUrl", "openAppUrl", "promotionSource", "promotionId", "productId", "itemId", "secAuthorId", "authorId", "followStatus", "sourcePage", "pageName", "carrierType", "adLogExtra", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;)Lcom/bytedance/android/shopping/slice/action/entity/PdpOpenThirdParam;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getOrderUrl", "()Ljava/lang/String;", "getSmallAppUrl", "getOpenAppUrl", "Ljava/lang/Long;", "getPromotionSource", "getPromotionId", "getProductId", "getItemId", "getSecAuthorId", "getAuthorId", "Ljava/lang/Integer;", "getFollowStatus", "getSourcePage", "getPageName", "getCarrierType", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpOpenThirdParam implements Serializable {
    public static final a Companion = null;
    public static final String KEY_AD_LOG_EXTRA = "ad_log_extra";
    public static final String KEY_AUTHOR_ID = "author_id";
    public static final String KEY_CARRIER_TYPE = "carrier_type";
    public static final String KEY_FOLLOW_STATUS = "follow_status";
    public static final String KEY_ITEM_ID = "item_id";
    public static final String KEY_OPEN_APP_URL = "open_app_url";
    public static final String KEY_ORDER_URL = "order_url";
    public static final String KEY_PAGE_NAME = "page_name";
    public static final String KEY_PRODUCT_ID = "product_id";
    public static final String KEY_PROMOTION_ID = "promotion_id";
    public static final String KEY_PROMOTION_SOURCE = "promotion_source";
    public static final String KEY_SEC_AUTHOR_ID = "sec_author_id";
    public static final String KEY_SMALL_APP_URL = "small_app_url";
    public static final String KEY_SOURCE_PAGE = "source_page";

    @SerializedName(KEY_AD_LOG_EXTRA)
    private final ECAdLogExtra adLogExtra;

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("carrier_type")
    private final String carrierType;

    @SerializedName("follow_status")
    private final Integer followStatus;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName(KEY_OPEN_APP_URL)
    private final String openAppUrl;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("page_name")
    private final String pageName;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName(KEY_PROMOTION_SOURCE)
    private final Long promotionSource;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName("small_app_url")
    private final String smallAppUrl;

    @SerializedName("source_page")
    private final String sourcePage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PdpOpenThirdParam() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public static /* synthetic */ PdpOpenThirdParam copy$default(PdpOpenThirdParam r110, String r111, String r112, String r113, Long r114, String r210, String r211, String r212, String r213, String r214, Integer r215, String r216, String r217, String r218, ECAdLogExtra r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.orderUrl;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.smallAppUrl;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.openAppUrl;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Long r103 = r110.promotionSource;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.promotionId;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.productId;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.itemId;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r107 = r110.secAuthorId;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r115 = r110.authorId;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Integer r116 = r110.followStatus;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.sourcePage;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r118 = r110.pageName;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r119 = r110.carrierType;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        ECAdLogExtra r108 = r110.adLogExtra;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
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

    public final String component1() {
        return this.orderUrl;
    }

    public final Integer component10() {
        return this.followStatus;
    }

    public final String component11() {
        return this.sourcePage;
    }

    public final String component12() {
        return this.pageName;
    }

    public final String component13() {
        return this.carrierType;
    }

    public final ECAdLogExtra component14() {
        return this.adLogExtra;
    }

    public final String component2() {
        return this.smallAppUrl;
    }

    public final String component3() {
        return this.openAppUrl;
    }

    public final Long component4() {
        return this.promotionSource;
    }

    public final String component5() {
        return this.promotionId;
    }

    public final String component6() {
        return this.productId;
    }

    public final String component7() {
        return this.itemId;
    }

    public final String component8() {
        return this.secAuthorId;
    }

    public final String component9() {
        return this.authorId;
    }

    public final PdpOpenThirdParam copy(String r110, String r111, String r112, Long r210, String r211, String r212, String r213, String r214, String r215, Integer r216, String r217, String r218, String r219, ECAdLogExtra r310) {
        return new PdpOpenThirdParam(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PdpOpenThirdParam) == false) goto L34;
        PdpOpenThirdParam r101 = (PdpOpenThirdParam) r100;
        if (Intrinsics.areEqual(this.orderUrl, r101.orderUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.smallAppUrl, r101.smallAppUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.openAppUrl, r101.openAppUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promotionSource, r101.promotionSource) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.carrierType, r101.carrierType) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.adLogExtra, r101.adLogExtra) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public int hashCode() {
        String r100 = this.orderUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.smallAppUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.openAppUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.promotionSource;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.promotionId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.productId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.itemId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.secAuthorId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.authorId;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.followStatus;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.sourcePage;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.pageName;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.carrierType;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        ECAdLogExtra r140 = this.adLogExtra;
        if (r140 == null) goto L58;
        r101 = r140.hashCode();
    L58:
        return r139 + r101;
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
        return "PdpOpenThirdParam(orderUrl=" + this.orderUrl + ", smallAppUrl=" + this.smallAppUrl + ", openAppUrl=" + this.openAppUrl + ", promotionSource=" + this.promotionSource + ", promotionId=" + this.promotionId + ", productId=" + this.productId + ", itemId=" + this.itemId + ", secAuthorId=" + this.secAuthorId + ", authorId=" + this.authorId + ", followStatus=" + this.followStatus + ", sourcePage=" + this.sourcePage + ", pageName=" + this.pageName + ", carrierType=" + this.carrierType + ", adLogExtra=" + this.adLogExtra + ")";
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getCarrierType() {
        return this.carrierType;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getOpenAppUrl() {
        return this.openAppUrl;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final Long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSmallAppUrl() {
        return this.smallAppUrl;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public PdpOpenThirdParam(String r100, String r101, String r102, Long r103, String r104, String r105, String r106, String r107, String r108, Integer r110, String r111, String r112, String r113, ECAdLogExtra r114) {
        this.orderUrl = r100;
        this.smallAppUrl = r101;
        this.openAppUrl = r102;
        this.promotionSource = r103;
        this.promotionId = r104;
        this.productId = r105;
        this.itemId = r106;
        this.secAuthorId = r107;
        this.authorId = r108;
        this.followStatus = r110;
        this.sourcePage = r111;
        this.pageName = r112;
        this.carrierType = r113;
        this.adLogExtra = r114;
    }

    public /* synthetic */ PdpOpenThirdParam(String r110, String r111, String r112, Long r113, String r210, String r211, String r212, String r213, String r214, Integer r215, String r216, String r217, String r218, ECAdLogExtra r219, int r310, DefaultConstructorMarker r311) {
        ECAdLogExtra r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Long r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Integer r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
