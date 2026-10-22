package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b*\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0015J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J®\u0001\u00109\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\f2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\tHÖ\u0001J\t\u0010?\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b(\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b*\u0010\u0017R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010!¨\u0006@"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuClientParams;", "Ljava/io/Serializable;", "defaultSpecId", "", "", "defaultSkuId", "defaultCount", "", "hotSaleType", "", "detailUrl", "scrollToInstallment", "", "skuSessionId", "forceYataSku", "createNewActivity", "maskBackgroundColor", "maskAlpha", "", "standardAddCartToastType", "splitScreenHalfMode", "(Ljava/util/List;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCreateNewActivity", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDefaultCount", "()J", "getDefaultSkuId", "()Ljava/lang/String;", "getDefaultSpecId", "()Ljava/util/List;", "getDetailUrl", "getForceYataSku", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHotSaleType", "getMaskAlpha", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMaskBackgroundColor", "getScrollToInstallment", "getSkuSessionId", "getSplitScreenHalfMode", "getStandardAddCartToastType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/android/ec/model/sku/SkuClientParams;", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuClientParams implements Serializable {

    @SerializedName("create_new_activity")
    private final Boolean createNewActivity;

    @SerializedName("default_count")
    private final long defaultCount;

    @SerializedName("default_sku_id")
    private final String defaultSkuId;

    @SerializedName("default_spec_id")
    private final List<String> defaultSpecId;

    @SerializedName("detail_url")
    private final String detailUrl;

    @SerializedName("force_yata_sku")
    private final Integer forceYataSku;

    @SerializedName("hot_sale_type")
    private final Integer hotSaleType;

    @SerializedName("mask_alpha")
    private final Float maskAlpha;

    @SerializedName("mask_background_color")
    private final String maskBackgroundColor;

    @SerializedName("scroll_to_installment")
    private final Boolean scrollToInstallment;

    @SerializedName("sku_session_id")
    private final String skuSessionId;

    @SerializedName("split_screen_half_mode")
    private final Boolean splitScreenHalfMode;

    @SerializedName("add_cart_toast_type")
    private final Integer standardAddCartToastType;

    public SkuClientParams() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuClientParams copy$default(SkuClientParams r110, List r111, String r112, long r113, Integer r210, String r211, Boolean r212, String r213, Integer r214, Boolean r215, String r216, Float r217, Integer r218, Boolean r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        List r100 = r110.defaultSpecId;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.defaultSkuId;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r102 = r110.defaultCount;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r103 = r110.hotSaleType;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.detailUrl;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Boolean r105 = r110.scrollToInstallment;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.skuSessionId;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Integer r114 = r110.forceYataSku;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Boolean r115 = r110.createNewActivity;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = r110.maskBackgroundColor;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Float r117 = r110.maskAlpha;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Integer r118 = r110.standardAddCartToastType;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Boolean r107 = r110.splitScreenHalfMode;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r114, r115, r116, r117, r118, r107);
    L53:
        r107 = r219;
        goto L55
    L49:
        r118 = r218;
        goto L51
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
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

    public final List<String> component1() {
        return this.defaultSpecId;
    }

    public final String component10() {
        return this.maskBackgroundColor;
    }

    public final Float component11() {
        return this.maskAlpha;
    }

    public final Integer component12() {
        return this.standardAddCartToastType;
    }

    public final Boolean component13() {
        return this.splitScreenHalfMode;
    }

    public final String component2() {
        return this.defaultSkuId;
    }

    public final long component3() {
        return this.defaultCount;
    }

    public final Integer component4() {
        return this.hotSaleType;
    }

    public final String component5() {
        return this.detailUrl;
    }

    public final Boolean component6() {
        return this.scrollToInstallment;
    }

    public final String component7() {
        return this.skuSessionId;
    }

    public final Integer component8() {
        return this.forceYataSku;
    }

    public final Boolean component9() {
        return this.createNewActivity;
    }

    public final SkuClientParams copy(List<String> r110, String r111, long r112, Integer r210, String r211, Boolean r212, String r213, Integer r214, Boolean r215, String r216, Float r217, Integer r218, Boolean r310) {
        return new SkuClientParams(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuClientParams) == false) goto L32;
        SkuClientParams r101 = (SkuClientParams) r100;
        if (Intrinsics.areEqual(this.defaultSpecId, r101.defaultSpecId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.defaultSkuId, r101.defaultSkuId) == true) goto L10;
        return false;
    L10:
        if (this.defaultCount == r101.defaultCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hotSaleType, r101.hotSaleType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.detailUrl, r101.detailUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.scrollToInstallment, r101.scrollToInstallment) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.skuSessionId, r101.skuSessionId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.forceYataSku, r101.forceYataSku) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.createNewActivity, r101.createNewActivity) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maskBackgroundColor, r101.maskBackgroundColor) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.maskAlpha, r101.maskAlpha) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.standardAddCartToastType, r101.standardAddCartToastType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.splitScreenHalfMode, r101.splitScreenHalfMode) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.defaultSpecId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.defaultSkuId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.defaultCount;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        Integer r109 = this.hotSaleType;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.detailUrl;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        Boolean r115 = this.scrollToInstallment;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.skuSessionId;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        Integer r121 = this.forceYataSku;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        Boolean r124 = this.createNewActivity;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.maskBackgroundColor;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (r126 + r128) * 31;
        Float r130 = this.maskAlpha;
        if (r130 == null) goto L41;
        int r131 = r130.hashCode();
    L42:
        int r132 = (r129 + r131) * 31;
        Integer r133 = this.standardAddCartToastType;
        if (r133 == null) goto L45;
        int r134 = r133.hashCode();
    L46:
        int r135 = (r132 + r134) * 31;
        Boolean r136 = this.splitScreenHalfMode;
        if (r136 == null) goto L50;
        r101 = r136.hashCode();
    L50:
        return r135 + r101;
    L45:
        r134 = 0;
        goto L46
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
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SkuClientParams(defaultSpecId=" + this.defaultSpecId + ", defaultSkuId=" + this.defaultSkuId + ", defaultCount=" + this.defaultCount + ", hotSaleType=" + this.hotSaleType + ", detailUrl=" + this.detailUrl + ", scrollToInstallment=" + this.scrollToInstallment + ", skuSessionId=" + this.skuSessionId + ", forceYataSku=" + this.forceYataSku + ", createNewActivity=" + this.createNewActivity + ", maskBackgroundColor=" + this.maskBackgroundColor + ", maskAlpha=" + this.maskAlpha + ", standardAddCartToastType=" + this.standardAddCartToastType + ", splitScreenHalfMode=" + this.splitScreenHalfMode + ")";
    }

    public final Boolean getCreateNewActivity() {
        return this.createNewActivity;
    }

    public final long getDefaultCount() {
        return this.defaultCount;
    }

    public final String getDefaultSkuId() {
        return this.defaultSkuId;
    }

    public final List<String> getDefaultSpecId() {
        return this.defaultSpecId;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public final Integer getForceYataSku() {
        return this.forceYataSku;
    }

    public final Integer getHotSaleType() {
        return this.hotSaleType;
    }

    public final Float getMaskAlpha() {
        return this.maskAlpha;
    }

    public final String getMaskBackgroundColor() {
        return this.maskBackgroundColor;
    }

    public final Boolean getScrollToInstallment() {
        return this.scrollToInstallment;
    }

    public final String getSkuSessionId() {
        return this.skuSessionId;
    }

    public final Boolean getSplitScreenHalfMode() {
        return this.splitScreenHalfMode;
    }

    public final Integer getStandardAddCartToastType() {
        return this.standardAddCartToastType;
    }

    public SkuClientParams(List<String> r100, String r101, long r102, Integer r103, String r104, Boolean r105, String r106, Integer r107, Boolean r110, String r111, Float r112, Integer r113, Boolean r114) {
        this.defaultSpecId = r100;
        this.defaultSkuId = r101;
        this.defaultCount = r102;
        this.hotSaleType = r103;
        this.detailUrl = r104;
        this.scrollToInstallment = r105;
        this.skuSessionId = r106;
        this.forceYataSku = r107;
        this.createNewActivity = r110;
        this.maskBackgroundColor = r111;
        this.maskAlpha = r112;
        this.standardAddCartToastType = r113;
        this.splitScreenHalfMode = r114;
    }

    public /* synthetic */ SkuClientParams(List r110, String r111, long r112, Integer r210, String r211, Boolean r212, String r213, Integer r214, Boolean r215, String r216, Float r217, Integer r218, Boolean r219, int r310, DefaultConstructorMarker r311) {
        Boolean r100 = null;
        if ((r310 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r103 = 1;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Boolean r106 = Boolean.FALSE;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Integer r113 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Boolean r114 = Boolean.FALSE;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Float r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Integer r117 = null;
    L51:
        if ((r310 & 4096) != 0) goto L54;
        r100 = r219;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r100);
        return;
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
        r113 = r214;
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
