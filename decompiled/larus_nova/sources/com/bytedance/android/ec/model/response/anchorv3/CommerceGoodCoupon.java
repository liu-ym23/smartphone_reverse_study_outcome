package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b6\b\u0086\b\u0018\u0000 a2\u00020\u0001:\u0001bB»\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b\u0012\b\b\u0002\u0010 \u001a\u00020\b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0016\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b_\u0010`J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\bHÆ\u0003J\t\u0010\f\u001a\u00020\bHÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0011J\t\u0010\u0017\u001a\u00020\u0016HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003JÄ\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010'\u001a\u00020\u00162\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020\u0002HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001J\u0013\u0010/\u001a\u00020\u00162\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00100\u001a\u0004\b:\u00102\"\u0004\b;\u00104R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00100\u001a\u0004\b<\u00102\"\u0004\b=\u00104R\"\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00105\u001a\u0004\bC\u00107\"\u0004\bD\u00109R\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010>\u001a\u0004\bE\u0010@\"\u0004\bF\u0010BR\"\u0010 \u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010>\u001a\u0004\bG\u0010@\"\u0004\bH\u0010BR$\u0010!\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010I\u001a\u0004\bJ\u0010\u000f\"\u0004\bK\u0010LR$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010M\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010PR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00100\u001a\u0004\bQ\u00102\"\u0004\bR\u00104R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\bS\u00102\"\u0004\bT\u00104R$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010M\u001a\u0004\bU\u0010\u0011\"\u0004\bV\u0010PR$\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010M\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010PR\"\u0010'\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010Y\u001a\u0004\b'\u0010Z\"\u0004\b[\u0010\\R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u00100\u001a\u0004\b]\u00102\"\u0004\b^\u00104¨\u0006c"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/CommerceGoodCoupon;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "", "component5", "component6", "component7", "component8", "", "component9", "()Ljava/lang/Float;", "component10", "()Ljava/lang/Integer;", "component11", "component12", "component13", "component14", "", "component15", "component16", "couponMetaId", "type", "couponName", "shopName", "threshold", "credit", DyPayConstant.KEY_START_TIME, Keys.API_PARAM_KEY_SDK_EXPIRETIME, "discount", "discountLimit", "couponRange", "applyType", "periodType", "validPeriod", "isAutoApply", "extra", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JIJJLjava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)Lcom/bytedance/android/ec/model/response/anchorv3/CommerceGoodCoupon;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getCouponMetaId", "()Ljava/lang/String;", "setCouponMetaId", "(Ljava/lang/String;)V", "I", "getType", "()I", "setType", "(I)V", "getCouponName", "setCouponName", "getShopName", "setShopName", "J", "getThreshold", "()J", "setThreshold", "(J)V", "getCredit", "setCredit", "getStartTime", "setStartTime", "getExpireTime", "setExpireTime", "Ljava/lang/Float;", "getDiscount", "setDiscount", "(Ljava/lang/Float;)V", "Ljava/lang/Integer;", "getDiscountLimit", "setDiscountLimit", "(Ljava/lang/Integer;)V", "getCouponRange", "setCouponRange", "getApplyType", "setApplyType", "getPeriodType", "setPeriodType", "getValidPeriod", "setValidPeriod", "Z", "()Z", "setAutoApply", "(Z)V", "getExtra", "setExtra", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JIJJLjava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CommerceGoodCoupon implements Serializable {
    public static final a Companion = null;
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_21 = 21;
    public static final int TYPE_22 = 22;
    public static final int TYPE_23 = 23;
    public static final int TYPE_3 = 3;
    public static final int TYPE_41 = 41;
    public static final int TYPE_42 = 42;
    public static final int TYPE_43 = 43;

    @SerializedName(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE)
    private String applyType;

    @SerializedName("coupon_meta_id")
    private String couponMetaId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_NAME)
    private String couponName;

    @SerializedName("coupon_range")
    private String couponRange;

    @SerializedName("credit")
    private int credit;

    @SerializedName("discount")
    private Float discount;

    @SerializedName("discount_limit")
    private Integer discountLimit;

    @SerializedName("expire_time")
    private long expireTime;

    @SerializedName("extra")
    private String extra;

    @SerializedName("is_autoapply")
    private boolean isAutoApply;

    @SerializedName("period_type")
    private Integer periodType;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;

    @SerializedName("threshold")
    private long threshold;

    @SerializedName("type")
    private int type;

    @SerializedName("valid_period")
    private Integer validPeriod;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommerceGoodCoupon() {
        this(null, 0, null, null, 0, 0, 0, 0, null, null, null, null, null, null, false, null, 65535, null);
    }

    public static /* synthetic */ CommerceGoodCoupon copy$default(CommerceGoodCoupon r110, String r111, int r112, String r210, String r211, long r212, int r213, long r214, long r215, Float r216, Integer r310, String r311, String r312, Integer r313, Integer r314, boolean r315, String r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = r110.couponMetaId;
    L7:
        if ((r317 & 2) == 0) goto L9;
        int r101 = r110.type;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = r110.couponName;
    L15:
        if ((r317 & 8) == 0) goto L17;
        String r103 = r110.shopName;
    L19:
        if ((r317 & 16) == 0) goto L21;
        long r104 = r110.threshold;
    L23:
        if ((r317 & 32) == 0) goto L25;
        int r105 = r110.credit;
    L27:
        if ((r317 & 64) == 0) goto L29;
        long r106 = r110.startTime;
    L31:
        if ((r317 & 128) == 0) goto L33;
        long r113 = r110.expireTime;
    L35:
        if ((r317 & 256) == 0) goto L37;
        Float r114 = r110.discount;
    L39:
        if ((r317 & 512) == 0) goto L41;
        Integer r115 = r110.discountLimit;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        String r116 = r110.couponRange;
    L46:
        String r319 = r116;
        if ((r317 & 2048) == 0) goto L49;
        String r117 = r110.applyType;
    L50:
        String r320 = r117;
        if ((r317 & 4096) == 0) goto L53;
        Integer r118 = r110.periodType;
    L54:
        Integer r321 = r118;
        if ((r317 & 8192) == 0) goto L57;
        Integer r119 = r110.validPeriod;
    L58:
        Integer r322 = r119;
        if ((r317 & 16384) == 0) goto L61;
        boolean r120 = r110.isAutoApply;
    L63:
        if ((r317 & 32768) == 0) goto L65;
        String r107 = r110.extra;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r319, r320, r321, r322, r120, r107);
    L65:
        r107 = r316;
        goto L67
    L61:
        r120 = r315;
        goto L63
    L57:
        r119 = r314;
        goto L58
    L53:
        r118 = r313;
        goto L54
    L49:
        r117 = r312;
        goto L50
    L45:
        r116 = r311;
        goto L46
    L41:
        r115 = r310;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
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

    public final String component1() {
        return this.couponMetaId;
    }

    public final Integer component10() {
        return this.discountLimit;
    }

    public final String component11() {
        return this.couponRange;
    }

    public final String component12() {
        return this.applyType;
    }

    public final Integer component13() {
        return this.periodType;
    }

    public final Integer component14() {
        return this.validPeriod;
    }

    public final boolean component15() {
        return this.isAutoApply;
    }

    public final String component16() {
        return this.extra;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.couponName;
    }

    public final String component4() {
        return this.shopName;
    }

    public final long component5() {
        return this.threshold;
    }

    public final int component6() {
        return this.credit;
    }

    public final long component7() {
        return this.startTime;
    }

    public final long component8() {
        return this.expireTime;
    }

    public final Float component9() {
        return this.discount;
    }

    public final CommerceGoodCoupon copy(String r210, int r211, String r212, String r213, long r214, int r215, long r216, long r310, Float r311, Integer r312, String r313, String r314, Integer r315, Integer r316, boolean r317, String r410) {
        return new CommerceGoodCoupon(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r410);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommerceGoodCoupon) == false) goto L38;
        CommerceGoodCoupon r101 = (CommerceGoodCoupon) r100;
        if (Intrinsics.areEqual(this.couponMetaId, r101.couponMetaId) == true) goto L8;
        return false;
    L8:
        if (this.type == r101.type) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.couponName, r101.couponName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shopName, r101.shopName) == true) goto L14;
        return false;
    L14:
        if (this.threshold == r101.threshold) goto L16;
        return false;
    L16:
        if (this.credit == r101.credit) goto L18;
        return false;
    L18:
        if (this.startTime == r101.startTime) goto L20;
        return false;
    L20:
        if (this.expireTime == r101.expireTime) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.discount, r101.discount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.discountLimit, r101.discountLimit) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.couponRange, r101.couponRange) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.applyType, r101.applyType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.periodType, r101.periodType) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.validPeriod, r101.validPeriod) == true) goto L34;
        return false;
    L34:
        if (this.isAutoApply == r101.isAutoApply) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v44 */
    public int hashCode() {
        String r100 = this.couponMetaId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.type) * 31;
        String r104 = this.couponName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shopName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.threshold;
        int r111 = (((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.credit) * 31;
        long r112 = this.startTime;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.expireTime;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        Float r116 = this.discount;
        if (r116 == null) goto L17;
        int r117 = r116.hashCode();
    L18:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.discountLimit;
        if (r119 == null) goto L21;
        int r120 = r119.hashCode();
    L22:
        int r121 = (r118 + r120) * 31;
        String r122 = this.couponRange;
        if (r122 == null) goto L25;
        int r123 = r122.hashCode();
    L26:
        int r124 = (r121 + r123) * 31;
        String r125 = this.applyType;
        if (r125 == null) goto L29;
        int r126 = r125.hashCode();
    L30:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.periodType;
        if (r128 == null) goto L33;
        int r129 = r128.hashCode();
    L34:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.validPeriod;
        if (r131 == null) goto L37;
        int r132 = r131.hashCode();
    L38:
        int r133 = (r130 + r132) * 31;
        boolean r134 = this.isAutoApply;
        ?? r135 = r134;
        if (r134 == false) goto L41;
        r135 = 1;
    L41:
        int r136 = (r133 + r135) * 31;
        String r137 = this.extra;
        if (r137 == null) goto L45;
        r101 = r137.hashCode();
    L45:
        return r136 + r101;
    L37:
        r132 = 0;
        goto L38
    L33:
        r129 = 0;
        goto L34
    L29:
        r126 = 0;
        goto L30
    L25:
        r123 = 0;
        goto L26
    L21:
        r120 = 0;
        goto L22
    L17:
        r117 = 0;
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
        return "CommerceGoodCoupon(couponMetaId=" + this.couponMetaId + ", type=" + this.type + ", couponName=" + this.couponName + ", shopName=" + this.shopName + ", threshold=" + this.threshold + ", credit=" + this.credit + ", startTime=" + this.startTime + ", expireTime=" + this.expireTime + ", discount=" + this.discount + ", discountLimit=" + this.discountLimit + ", couponRange=" + this.couponRange + ", applyType=" + this.applyType + ", periodType=" + this.periodType + ", validPeriod=" + this.validPeriod + ", isAutoApply=" + this.isAutoApply + ", extra=" + this.extra + ")";
    }

    public final String getApplyType() {
        return this.applyType;
    }

    public final String getCouponMetaId() {
        return this.couponMetaId;
    }

    public final String getCouponName() {
        return this.couponName;
    }

    public final String getCouponRange() {
        return this.couponRange;
    }

    public final int getCredit() {
        return this.credit;
    }

    public final Float getDiscount() {
        return this.discount;
    }

    public final Integer getDiscountLimit() {
        return this.discountLimit;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final Integer getPeriodType() {
        return this.periodType;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getThreshold() {
        return this.threshold;
    }

    public final int getType() {
        return this.type;
    }

    public final Integer getValidPeriod() {
        return this.validPeriod;
    }

    public final boolean isAutoApply() {
        return this.isAutoApply;
    }

    public final void setApplyType(String r100) {
        this.applyType = r100;
    }

    public final void setAutoApply(boolean r100) {
        this.isAutoApply = r100;
    }

    public final void setCouponMetaId(String r100) {
        this.couponMetaId = r100;
    }

    public final void setCouponName(String r100) {
        this.couponName = r100;
    }

    public final void setCouponRange(String r100) {
        this.couponRange = r100;
    }

    public final void setCredit(int r100) {
        this.credit = r100;
    }

    public final void setDiscount(Float r100) {
        this.discount = r100;
    }

    public final void setDiscountLimit(Integer r100) {
        this.discountLimit = r100;
    }

    public final void setExpireTime(long r100) {
        this.expireTime = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setPeriodType(Integer r100) {
        this.periodType = r100;
    }

    public final void setShopName(String r100) {
        this.shopName = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setThreshold(long r100) {
        this.threshold = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setValidPeriod(Integer r100) {
        this.validPeriod = r100;
    }

    public CommerceGoodCoupon(String r100, int r101, String r102, String r103, long r104, int r110, long r111, long r112, Float r113, Integer r114, String r115, String r116, Integer r117, Integer r210, boolean r211, String r212) {
        this.couponMetaId = r100;
        this.type = r101;
        this.couponName = r102;
        this.shopName = r103;
        this.threshold = r104;
        this.credit = r110;
        this.startTime = r111;
        this.expireTime = r112;
        this.discount = r113;
        this.discountLimit = r114;
        this.couponRange = r115;
        this.applyType = r116;
        this.periodType = r117;
        this.validPeriod = r210;
        this.isAutoApply = r211;
        this.extra = r212;
    }

    public /* synthetic */ CommerceGoodCoupon(String r210, int r211, String r212, String r213, long r214, int r215, long r216, long r310, Float r311, Integer r312, String r313, String r314, Integer r315, Integer r316, boolean r317, String r318, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r410 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r410 & 8) == 0) goto L17;
        String r103 = "";
    L18:
        long r104 = 0;
        if ((r410 & 16) == 0) goto L21;
        long r110 = 0;
    L23:
        if ((r410 & 32) == 0) goto L25;
        int r105 = 0;
    L27:
        if ((r410 & 64) == 0) goto L29;
        long r111 = 0;
    L31:
        if ((r410 & 128) != 0) goto L35;
        r104 = r310;
    L35:
        if ((r410 & 256) == 0) goto L37;
        Float r112 = Float.valueOf(0.0f);
    L39:
        if ((r410 & 512) == 0) goto L41;
        Integer r113 = 0;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        String r106 = "";
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r107 = "";
    L50:
        String r114 = r107;
        if ((r410 & 4096) == 0) goto L53;
        Integer r108 = 1;
    L54:
        Integer r115 = r108;
        if ((r410 & 8192) == 0) goto L57;
        Integer r116 = 0;
    L59:
        if ((r410 & 16384) == 0) goto L61;
        boolean r109 = false;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        String r117 = "";
    L66:
        this(r100, r101, r102, r103, r110, r105, r111, r104, r112, r113, r106, r114, r115, r116, r109, r117);
        return;
    L65:
        r117 = r318;
        goto L66
    L61:
        r109 = r317;
        goto L63
    L57:
        r116 = r316;
        goto L59
    L53:
        r108 = r315;
        goto L54
    L49:
        r107 = r314;
        goto L50
    L45:
        r106 = r313;
        goto L47
    L41:
        r113 = r312;
        goto L43
    L37:
        r112 = r311;
        goto L39
    L29:
        r111 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r110 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L18
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
