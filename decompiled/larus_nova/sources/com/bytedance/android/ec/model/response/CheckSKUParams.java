package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0082\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001b¨\u00065"}, d2 = {"Lcom/bytedance/android/ec/model/response/CheckSKUParams;", "Ljava/io/Serializable;", "forceYataSku", "", "bizIdentifier", "", "originId", "originType", "buttonType", "addCartOptLive", "heightPercent", "maskAlpha", "", "warehouseListId", "", "liveShopMode", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/Long;)V", "getAddCartOptLive", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBizIdentifier", "()Ljava/lang/String;", "getButtonType", "()I", "getForceYataSku", "getHeightPercent", "getLiveShopMode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaskAlpha", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getOriginId", "getOriginType", "getWarehouseListId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/android/ec/model/response/CheckSKUParams;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CheckSKUParams implements Serializable {

    @SerializedName("add_cart_opt_live")
    private final Integer addCartOptLive;

    @SerializedName("biz_identifier")
    private final String bizIdentifier;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE)
    private final int buttonType;

    @SerializedName("force_yata_sku")
    private final int forceYataSku;

    @SerializedName(ECFindSimilarConfig.HEIGHT_PERCENT)
    private final Integer heightPercent;

    @SerializedName("live_shop_mode")
    private final Long liveShopMode;

    @SerializedName("mask_alpha")
    private final Float maskAlpha;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID)
    private final String originId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_TYPE)
    private final String originType;

    @SerializedName("warehouse_list_id")
    private final Long warehouseListId;

    public CheckSKUParams() {
        this(0, null, null, null, 0, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ CheckSKUParams copy$default(CheckSKUParams r110, int r111, String r112, String r113, String r114, int r115, Integer r116, Integer r117, Float r118, Long r210, Long r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = r110.forceYataSku;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.bizIdentifier;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.originId;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.originType;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.buttonType;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Integer r105 = r110.addCartOptLive;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Integer r106 = r110.heightPercent;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Float r107 = r110.maskAlpha;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Long r119 = r110.warehouseListId;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Long r108 = r110.liveShopMode;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
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

    public final int component1() {
        return this.forceYataSku;
    }

    public final Long component10() {
        return this.liveShopMode;
    }

    public final String component2() {
        return this.bizIdentifier;
    }

    public final String component3() {
        return this.originId;
    }

    public final String component4() {
        return this.originType;
    }

    public final int component5() {
        return this.buttonType;
    }

    public final Integer component6() {
        return this.addCartOptLive;
    }

    public final Integer component7() {
        return this.heightPercent;
    }

    public final Float component8() {
        return this.maskAlpha;
    }

    public final Long component9() {
        return this.warehouseListId;
    }

    public final CheckSKUParams copy(int r110, String r111, String r112, String r113, int r114, Integer r115, Integer r116, Float r210, Long r211, Long r212) {
        return new CheckSKUParams(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CheckSKUParams) == false) goto L26;
        CheckSKUParams r101 = (CheckSKUParams) r100;
        if (this.forceYataSku == r101.forceYataSku) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizIdentifier, r101.bizIdentifier) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originId, r101.originId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originType, r101.originType) == true) goto L14;
        return false;
    L14:
        if (this.buttonType == r101.buttonType) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.addCartOptLive, r101.addCartOptLive) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.heightPercent, r101.heightPercent) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.maskAlpha, r101.maskAlpha) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.warehouseListId, r101.warehouseListId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liveShopMode, r101.liveShopMode) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r100 = this.forceYataSku * 31;
        String r101 = this.bizIdentifier;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.originId;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.originType;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (((r107 + r109) * 31) + this.buttonType) * 31;
        Integer r111 = this.addCartOptLive;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.heightPercent;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        Float r117 = this.maskAlpha;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        Long r120 = this.warehouseListId;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        Long r123 = this.liveShopMode;
        if (r123 == null) goto L34;
        r102 = r123.hashCode();
    L34:
        return r122 + r102;
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "CheckSKUParams(forceYataSku=" + this.forceYataSku + ", bizIdentifier=" + this.bizIdentifier + ", originId=" + this.originId + ", originType=" + this.originType + ", buttonType=" + this.buttonType + ", addCartOptLive=" + this.addCartOptLive + ", heightPercent=" + this.heightPercent + ", maskAlpha=" + this.maskAlpha + ", warehouseListId=" + this.warehouseListId + ", liveShopMode=" + this.liveShopMode + ")";
    }

    public final Integer getAddCartOptLive() {
        return this.addCartOptLive;
    }

    public final String getBizIdentifier() {
        return this.bizIdentifier;
    }

    public final int getButtonType() {
        return this.buttonType;
    }

    public final int getForceYataSku() {
        return this.forceYataSku;
    }

    public final Integer getHeightPercent() {
        return this.heightPercent;
    }

    public final Long getLiveShopMode() {
        return this.liveShopMode;
    }

    public final Float getMaskAlpha() {
        return this.maskAlpha;
    }

    public final String getOriginId() {
        return this.originId;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final Long getWarehouseListId() {
        return this.warehouseListId;
    }

    public CheckSKUParams(int r100, String r101, String r102, String r103, int r104, Integer r105, Integer r106, Float r107, Long r108, Long r110) {
        this.forceYataSku = r100;
        this.bizIdentifier = r101;
        this.originId = r102;
        this.originType = r103;
        this.buttonType = r104;
        this.addCartOptLive = r105;
        this.heightPercent = r106;
        this.maskAlpha = r107;
        this.warehouseListId = r108;
        this.liveShopMode = r110;
    }

    public /* synthetic */ CheckSKUParams(int r110, String r111, String r112, String r113, int r114, Integer r115, Integer r116, Float r117, Long r210, Long r211, int r212, DefaultConstructorMarker r213) {
        int r100 = 0;
        if ((r212 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        Long r102 = null;
        if ((r212 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r212 & 16) != 0) goto L23;
        r100 = r114;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Float r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Long r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r102 = r211;
    L42:
        this(r101, r103, r104, r105, r100, r106, r107, r108, r118, r102);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
