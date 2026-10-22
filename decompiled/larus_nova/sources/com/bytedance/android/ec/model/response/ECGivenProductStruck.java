package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003Ju\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/model/response/ECGivenProductStruck;", "Ljava/io/Serializable;", "background", "", "jumpUrl", "leftIcon", "rightIcon", "rightText", "", "Lcom/bytedance/android/ec/model/response/ECSpannableText;", "products", "Lcom/bytedance/android/ec/model/response/ECGivenProduct;", "eventParams", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getBackground", "()Ljava/lang/String;", "getEventParams", "()Ljava/util/Map;", "getJumpUrl", "getLeftIcon", "getProducts", "()Ljava/util/List;", "getRightIcon", "getRightText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECGivenProductStruck implements Serializable {

    @SerializedName("background")
    private final String background;

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("left_icon")
    private final String leftIcon;

    @SerializedName("products")
    private final List<ECGivenProduct> products;

    @SerializedName("right_icon")
    private final String rightIcon;

    @SerializedName("right_text")
    private final List<ECSpannableText> rightText;

    public ECGivenProductStruck() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECGivenProductStruck copy$default(ECGivenProductStruck r100, String r101, String r102, String r103, String r104, List r110, List r111, Map r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.background;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.jumpUrl;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.leftIcon;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.rightIcon;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.rightText;
    L17:
        List r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.products;
    L20:
        List r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.eventParams;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.background;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final String component3() {
        return this.leftIcon;
    }

    public final String component4() {
        return this.rightIcon;
    }

    public final List<ECSpannableText> component5() {
        return this.rightText;
    }

    public final List<ECGivenProduct> component6() {
        return this.products;
    }

    public final Map<String, String> component7() {
        return this.eventParams;
    }

    public final ECGivenProductStruck copy(String r110, String r111, String r112, String r113, List<ECSpannableText> r114, List<ECGivenProduct> r115, Map<String, String> r116) {
        return new ECGivenProductStruck(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECGivenProductStruck) == false) goto L20;
        ECGivenProductStruck r101 = (ECGivenProductStruck) r100;
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftIcon, r101.leftIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightIcon, r101.rightIcon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.rightText, r101.rightText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.products, r101.products) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.background;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.jumpUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.leftIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.rightIcon;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<ECSpannableText> r113 = this.rightText;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<ECGivenProduct> r116 = this.products;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.eventParams;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "ECGivenProductStruck(background=" + this.background + ", jumpUrl=" + this.jumpUrl + ", leftIcon=" + this.leftIcon + ", rightIcon=" + this.rightIcon + ", rightText=" + this.rightText + ", products=" + this.products + ", eventParams=" + this.eventParams + ")";
    }

    public final String getBackground() {
        return this.background;
    }

    public final Map<String, String> getEventParams() {
        return this.eventParams;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getLeftIcon() {
        return this.leftIcon;
    }

    public final List<ECGivenProduct> getProducts() {
        return this.products;
    }

    public final String getRightIcon() {
        return this.rightIcon;
    }

    public final List<ECSpannableText> getRightText() {
        return this.rightText;
    }

    public ECGivenProductStruck(String r100, String r101, String r102, String r103, List<ECSpannableText> r104, List<ECGivenProduct> r105, Map<String, String> r106) {
        this.background = r100;
        this.jumpUrl = r101;
        this.leftIcon = r102;
        this.rightIcon = r103;
        this.rightText = r104;
        this.products = r105;
        this.eventParams = r106;
    }

    public /* synthetic */ ECGivenProductStruck(String r100, String r101, String r102, String r110, List r111, List r112, Map r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        List r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        List r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Map r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
