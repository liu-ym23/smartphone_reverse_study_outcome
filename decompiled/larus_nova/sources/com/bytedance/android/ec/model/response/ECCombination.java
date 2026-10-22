package com.bytedance.android.ec.model.response;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\tHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0088\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00065"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECCombination;", "Ljava/io/Serializable;", "combinationId", "", "combinationTitle", "combinationProducts", "", "Lcom/bytedance/android/ec/model/response/ECCombinationProduct;", "originMinPrice", "", "originMaxPrice", "combinationMinPrice", "combinationMaxPrice", "jumpUrl", AppletNaviType.POI, "popStyle", "Lcom/bytedance/android/ec/model/response/PopStyle;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/Long;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/PopStyle;)V", "getCombinationId", "()Ljava/lang/String;", "getCombinationMaxPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCombinationMinPrice", "()J", "getCombinationProducts", "()Ljava/util/List;", "getCombinationTitle", "getJumpUrl", "getOriginMaxPrice", "getOriginMinPrice", "getPoi", "getPopStyle", "()Lcom/bytedance/android/ec/model/response/PopStyle;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/Long;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/PopStyle;)Lcom/bytedance/android/ec/model/response/ECCombination;", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECCombination implements Serializable {

    @SerializedName("id")
    private final String combinationId;

    @SerializedName("max_price")
    private final Long combinationMaxPrice;

    @SerializedName("min_price")
    private final long combinationMinPrice;

    @SerializedName("products")
    private final List<ECCombinationProduct> combinationProducts;

    @SerializedName("title")
    private final String combinationTitle;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("origin_max_price")
    private final Long originMaxPrice;

    @SerializedName("origin_min_price")
    private final long originMinPrice;

    @SerializedName(AppletNaviType.POI)
    private final String poi;

    @SerializedName(BindCardPayConfirmConstants.Key.POP_STYLE)
    private final PopStyle popStyle;

    public ECCombination() {
        this(null, null, null, 0, null, 0, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECCombination copy$default(ECCombination r110, String r111, String r112, List r113, long r114, Long r115, long r210, Long r211, String r212, String r213, PopStyle r214, int r215, Object r216) {
        if ((r215 & 1) == 0) goto L5;
        String r100 = r110.combinationId;
    L7:
        if ((r215 & 2) == 0) goto L9;
        String r101 = r110.combinationTitle;
    L11:
        if ((r215 & 4) == 0) goto L13;
        List r102 = r110.combinationProducts;
    L15:
        if ((r215 & 8) == 0) goto L17;
        long r103 = r110.originMinPrice;
    L19:
        if ((r215 & 16) == 0) goto L21;
        Long r104 = r110.originMaxPrice;
    L23:
        if ((r215 & 32) == 0) goto L25;
        long r105 = r110.combinationMinPrice;
    L27:
        if ((r215 & 64) == 0) goto L29;
        Long r116 = r110.combinationMaxPrice;
    L31:
        if ((r215 & 128) == 0) goto L33;
        String r117 = r110.jumpUrl;
    L35:
        if ((r215 & 256) == 0) goto L37;
        String r118 = r110.poi;
    L39:
        if ((r215 & 512) == 0) goto L41;
        PopStyle r106 = r110.popStyle;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116, r117, r118, r106);
    L41:
        r106 = r214;
        goto L43
    L37:
        r118 = r213;
        goto L39
    L33:
        r117 = r212;
        goto L35
    L29:
        r116 = r211;
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

    public final String component1() {
        return this.combinationId;
    }

    public final PopStyle component10() {
        return this.popStyle;
    }

    public final String component2() {
        return this.combinationTitle;
    }

    public final List<ECCombinationProduct> component3() {
        return this.combinationProducts;
    }

    public final long component4() {
        return this.originMinPrice;
    }

    public final Long component5() {
        return this.originMaxPrice;
    }

    public final long component6() {
        return this.combinationMinPrice;
    }

    public final Long component7() {
        return this.combinationMaxPrice;
    }

    public final String component8() {
        return this.jumpUrl;
    }

    public final String component9() {
        return this.poi;
    }

    public final ECCombination copy(String r110, String r111, List<ECCombinationProduct> r112, long r113, Long r210, long r211, Long r212, String r213, String r214, PopStyle r215) {
        return new ECCombination(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECCombination) == false) goto L26;
        ECCombination r101 = (ECCombination) r100;
        if (Intrinsics.areEqual(this.combinationId, r101.combinationId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.combinationTitle, r101.combinationTitle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.combinationProducts, r101.combinationProducts) == true) goto L12;
        return false;
    L12:
        if (this.originMinPrice == r101.originMinPrice) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.originMaxPrice, r101.originMaxPrice) == true) goto L16;
        return false;
    L16:
        if (this.combinationMinPrice == r101.combinationMinPrice) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.combinationMaxPrice, r101.combinationMaxPrice) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.poi, r101.poi) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.popStyle, r101.popStyle) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r100 = this.combinationId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.combinationTitle;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<ECCombinationProduct> r107 = this.combinationProducts;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.originMinPrice;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        Long r112 = this.originMaxPrice;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        long r115 = this.combinationMinPrice;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        Long r117 = this.combinationMaxPrice;
        if (r117 == null) goto L21;
        int r118 = r117.hashCode();
    L22:
        int r119 = (r116 + r118) * 31;
        String r120 = this.jumpUrl;
        if (r120 == null) goto L25;
        int r121 = r120.hashCode();
    L26:
        int r122 = (r119 + r121) * 31;
        String r123 = this.poi;
        if (r123 == null) goto L29;
        int r124 = r123.hashCode();
    L30:
        int r125 = (r122 + r124) * 31;
        PopStyle r126 = this.popStyle;
        if (r126 == null) goto L34;
        r101 = r126.hashCode();
    L34:
        return r125 + r101;
    L29:
        r124 = 0;
        goto L30
    L25:
        r121 = 0;
        goto L26
    L21:
        r118 = 0;
        goto L22
    L17:
        r113 = 0;
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
        return "ECCombination(combinationId=" + this.combinationId + ", combinationTitle=" + this.combinationTitle + ", combinationProducts=" + this.combinationProducts + ", originMinPrice=" + this.originMinPrice + ", originMaxPrice=" + this.originMaxPrice + ", combinationMinPrice=" + this.combinationMinPrice + ", combinationMaxPrice=" + this.combinationMaxPrice + ", jumpUrl=" + this.jumpUrl + ", poi=" + this.poi + ", popStyle=" + this.popStyle + ")";
    }

    public final String getCombinationId() {
        return this.combinationId;
    }

    public final Long getCombinationMaxPrice() {
        return this.combinationMaxPrice;
    }

    public final long getCombinationMinPrice() {
        return this.combinationMinPrice;
    }

    public final List<ECCombinationProduct> getCombinationProducts() {
        return this.combinationProducts;
    }

    public final String getCombinationTitle() {
        return this.combinationTitle;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Long getOriginMaxPrice() {
        return this.originMaxPrice;
    }

    public final long getOriginMinPrice() {
        return this.originMinPrice;
    }

    public final String getPoi() {
        return this.poi;
    }

    public final PopStyle getPopStyle() {
        return this.popStyle;
    }

    public ECCombination(String r100, String r101, List<ECCombinationProduct> r102, long r103, Long r104, long r105, Long r106, String r110, String r111, PopStyle r112) {
        this.combinationId = r100;
        this.combinationTitle = r101;
        this.combinationProducts = r102;
        this.originMinPrice = r103;
        this.originMaxPrice = r104;
        this.combinationMinPrice = r105;
        this.combinationMaxPrice = r106;
        this.jumpUrl = r110;
        this.poi = r111;
        this.popStyle = r112;
    }

    public /* synthetic */ ECCombination(String r110, String r111, List r112, long r113, Long r114, long r210, Long r211, String r212, String r213, PopStyle r214, int r215, DefaultConstructorMarker r216) {
        PopStyle r100 = null;
        if ((r215 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r215 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r215 & 4) == 0) goto L13;
        List r103 = null;
    L14:
        long r104 = 0;
        if ((r215 & 8) == 0) goto L17;
        long r105 = 0;
    L19:
        if ((r215 & 16) == 0) goto L21;
        Long r106 = null;
    L23:
        if ((r215 & 32) != 0) goto L27;
        r104 = r210;
    L27:
        if ((r215 & 64) == 0) goto L29;
        Long r115 = null;
    L31:
        if ((r215 & 128) == 0) goto L33;
        String r116 = null;
    L35:
        if ((r215 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r215 & 512) != 0) goto L42;
        r100 = r214;
    L42:
        this(r101, r102, r103, r105, r106, r104, r115, r116, r117, r100);
        return;
    L37:
        r117 = r213;
        goto L39
    L33:
        r116 = r212;
        goto L35
    L29:
        r115 = r211;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
