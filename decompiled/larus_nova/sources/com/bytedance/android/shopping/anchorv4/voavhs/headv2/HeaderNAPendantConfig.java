package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJb\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0010HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001f¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantConfig;", "Ljava/io/Serializable;", "backgroundColor", "", "borderRadius", "", "borderWidth", "borderColor", GXTemplateKey.FLEXBOX_PADDING, "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;", GXTemplateKey.FLEXBOX_MARGIN, "height", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;Ljava/lang/Double;)V", "getBackgroundColor", "()Ljava/lang/String;", "bgColorInt", "", "getBgColorInt", "()Ljava/lang/Integer;", "bgColorInt$delegate", "Lkotlin/Lazy;", "getBorderColor", "borderColorInt", "getBorderColorInt", "borderColorInt$delegate", "getBorderRadius", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getBorderWidth", "getHeight", "getMargin", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;", "getPadding", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;Ljava/lang/Double;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantConfig;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNAPendantConfig implements Serializable {

    @SerializedName("background_color")
    private final String backgroundColor;
    private final Lazy bgColorInt$delegate;

    @SerializedName("border_color")
    private final String borderColor;
    private final Lazy borderColorInt$delegate;

    @SerializedName("border_radius")
    private final Double borderRadius;

    @SerializedName("border_width")
    private final Double borderWidth;

    @SerializedName("height")
    private final Double height;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    private final Padding margin;

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private final Padding padding;

    public HeaderNAPendantConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ HeaderNAPendantConfig copy$default(HeaderNAPendantConfig r100, String r101, Double r102, Double r103, String r104, Padding r110, Padding r111, Double r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.backgroundColor;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.borderRadius;
    L8:
        Double r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.borderWidth;
    L11:
        Double r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.borderColor;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.padding;
    L17:
        Padding r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.margin;
    L20:
        Padding r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.height;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final Double component2() {
        return this.borderRadius;
    }

    public final Double component3() {
        return this.borderWidth;
    }

    public final String component4() {
        return this.borderColor;
    }

    public final Padding component5() {
        return this.padding;
    }

    public final Padding component6() {
        return this.margin;
    }

    public final Double component7() {
        return this.height;
    }

    public final HeaderNAPendantConfig copy(String r110, Double r111, Double r112, String r113, Padding r114, Padding r115, Double r116) {
        return new HeaderNAPendantConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeaderNAPendantConfig) == false) goto L20;
        HeaderNAPendantConfig r101 = (HeaderNAPendantConfig) r100;
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.borderRadius, r101.borderRadius) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.borderWidth, r101.borderWidth) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.margin, r101.margin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final Integer getBgColorInt() {
        return (Integer) this.bgColorInt$delegate.getValue();
    }

    public final Integer getBorderColorInt() {
        return (Integer) this.borderColorInt$delegate.getValue();
    }

    public int hashCode() {
        String r100 = this.backgroundColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Double r104 = this.borderRadius;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Double r107 = this.borderWidth;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.borderColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Padding r113 = this.padding;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Padding r116 = this.margin;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Double r119 = this.height;
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
        return "HeaderNAPendantConfig(backgroundColor=" + this.backgroundColor + ", borderRadius=" + this.borderRadius + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", padding=" + this.padding + ", margin=" + this.margin + ", height=" + this.height + ")";
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final Double getBorderRadius() {
        return this.borderRadius;
    }

    public final Double getBorderWidth() {
        return this.borderWidth;
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Padding getMargin() {
        return this.margin;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public HeaderNAPendantConfig(String r100, Double r101, Double r102, String r103, Padding r104, Padding r105, Double r106) {
        this.backgroundColor = r100;
        this.borderRadius = r101;
        this.borderWidth = r102;
        this.borderColor = r103;
        this.padding = r104;
        this.margin = r105;
        this.height = r106;
        this.bgColorInt$delegate = LazyKt.lazy(new HeaderNAPendantConfig$bgColorInt$2(this));
        this.borderColorInt$delegate = LazyKt.lazy(new HeaderNAPendantConfig$borderColorInt$2(this));
    }

    public /* synthetic */ HeaderNAPendantConfig(String r100, Double r101, Double r102, String r110, Padding r111, Padding r112, Double r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Double r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Double r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Padding r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Padding r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Double r117 = null;
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
