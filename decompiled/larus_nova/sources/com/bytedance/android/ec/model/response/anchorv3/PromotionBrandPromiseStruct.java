package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006*"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBrandPromiseStruct;", "Ljava/io/Serializable;", "name", "", "icon", "shopPromise", "shopPromiseTextColor", "backgroundColor", "url", "arrowColor", "iconStruct", "Lcom/bytedance/android/ec/model/ECUrlModel;", "dividerColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;)V", "getArrowColor", "()Ljava/lang/String;", "getBackgroundColor", "getDividerColor", "getIcon", "getIconStruct", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getName", "getShopPromise", "getShopPromiseTextColor", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionBrandPromiseStruct implements Serializable {

    @SerializedName("arrow_color")
    private final String arrowColor;

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("divider_color")
    private final String dividerColor;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("icon_struct")
    private final ECUrlModel iconStruct;

    @SerializedName("name")
    private final String name;

    @SerializedName("shop_promise")
    private final String shopPromise;

    @SerializedName("shop_promise_text_color")
    private final String shopPromiseTextColor;

    @SerializedName("url")
    private final String url;

    public PromotionBrandPromiseStruct() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ PromotionBrandPromiseStruct copy$default(PromotionBrandPromiseStruct r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, ECUrlModel r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.icon;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.shopPromise;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.shopPromiseTextColor;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.backgroundColor;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.url;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.arrowColor;
    L31:
        if ((r210 & 128) == 0) goto L33;
        ECUrlModel r107 = r110.iconStruct;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.dividerColor;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
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

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.shopPromise;
    }

    public final String component4() {
        return this.shopPromiseTextColor;
    }

    public final String component5() {
        return this.backgroundColor;
    }

    public final String component6() {
        return this.url;
    }

    public final String component7() {
        return this.arrowColor;
    }

    public final ECUrlModel component8() {
        return this.iconStruct;
    }

    public final String component9() {
        return this.dividerColor;
    }

    public final PromotionBrandPromiseStruct copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, ECUrlModel r117, String r210) {
        return new PromotionBrandPromiseStruct(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionBrandPromiseStruct) == false) goto L24;
        PromotionBrandPromiseStruct r101 = (PromotionBrandPromiseStruct) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopPromise, r101.shopPromise) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shopPromiseTextColor, r101.shopPromiseTextColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.arrowColor, r101.arrowColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.iconStruct, r101.iconStruct) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.dividerColor, r101.dividerColor) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.icon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shopPromise;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.shopPromiseTextColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.backgroundColor;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.url;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.arrowColor;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ECUrlModel r122 = this.iconStruct;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.dividerColor;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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
        return "PromotionBrandPromiseStruct(name=" + this.name + ", icon=" + this.icon + ", shopPromise=" + this.shopPromise + ", shopPromiseTextColor=" + this.shopPromiseTextColor + ", backgroundColor=" + this.backgroundColor + ", url=" + this.url + ", arrowColor=" + this.arrowColor + ", iconStruct=" + this.iconStruct + ", dividerColor=" + this.dividerColor + ")";
    }

    public final String getArrowColor() {
        return this.arrowColor;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getDividerColor() {
        return this.dividerColor;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final ECUrlModel getIconStruct() {
        return this.iconStruct;
    }

    public final String getName() {
        return this.name;
    }

    public final String getShopPromise() {
        return this.shopPromise;
    }

    public final String getShopPromiseTextColor() {
        return this.shopPromiseTextColor;
    }

    public final String getUrl() {
        return this.url;
    }

    public PromotionBrandPromiseStruct(String r100, String r101, String r102, String r103, String r104, String r105, String r106, ECUrlModel r107, String r108) {
        this.name = r100;
        this.icon = r101;
        this.shopPromise = r102;
        this.shopPromiseTextColor = r103;
        this.backgroundColor = r104;
        this.url = r105;
        this.arrowColor = r106;
        this.iconStruct = r107;
        this.dividerColor = r108;
    }

    public /* synthetic */ PromotionBrandPromiseStruct(String r110, String r111, String r112, String r113, String r114, String r115, String r116, ECUrlModel r117, String r118, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        ECUrlModel r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
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
