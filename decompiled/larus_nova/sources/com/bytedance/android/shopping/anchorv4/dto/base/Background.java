package com.bytedance.android.shopping.anchorv4.dto.base;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003J]\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\rHÖ\u0001R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "Ljava/io/Serializable;", KFFeatureEffect.GRADIENT_JSON_FIELD, "Lcom/bytedance/android/shopping/anchorv4/dto/base/Gradient;", "radius", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", GXTemplateKey.FLEXBOX_PADDING, "Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "border", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;", "backgroundImageModel", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "maskColor", "", "backgroundColor", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Gradient;Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getBackgroundImageModel", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getBorder", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;", "getGradient", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Gradient;", "getMaskColor", "getPadding", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "getRadius", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Background implements Serializable {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("background_image")
    private final ImageModel backgroundImageModel;

    @SerializedName("border")
    private final Border border;

    @SerializedName(KFFeatureEffect.GRADIENT_JSON_FIELD)
    private final Gradient gradient;

    @SerializedName("mask_color")
    private final String maskColor;

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private final Padding padding;

    @SerializedName("radius")
    private final Radius radius;

    public Background() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ Background copy$default(Background r100, Gradient r101, Radius r102, Padding r103, Border r104, ImageModel r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.gradient;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.radius;
    L8:
        Radius r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.padding;
    L11:
        Padding r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.border;
    L14:
        Border r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.backgroundImageModel;
    L17:
        ImageModel r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.maskColor;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.backgroundColor;
    L23:
        Gradient r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Gradient component1() {
        return this.gradient;
    }

    public final Radius component2() {
        return this.radius;
    }

    public final Padding component3() {
        return this.padding;
    }

    public final Border component4() {
        return this.border;
    }

    public final ImageModel component5() {
        return this.backgroundImageModel;
    }

    public final String component6() {
        return this.maskColor;
    }

    public final String component7() {
        return this.backgroundColor;
    }

    public final Background copy(Gradient r110, Radius r111, Padding r112, Border r113, ImageModel r114, String r115, String r116) {
        return new Background(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Background) == false) goto L20;
        Background r101 = (Background) r100;
        if (Intrinsics.areEqual(this.gradient, r101.gradient) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.border, r101.border) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.backgroundImageModel, r101.backgroundImageModel) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.maskColor, r101.maskColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        Gradient r100 = this.gradient;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Radius r104 = this.radius;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Padding r107 = this.padding;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Border r110 = this.border;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ImageModel r113 = this.backgroundImageModel;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.maskColor;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.backgroundColor;
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
        return "Background(gradient=" + this.gradient + ", radius=" + this.radius + ", padding=" + this.padding + ", border=" + this.border + ", backgroundImageModel=" + this.backgroundImageModel + ", maskColor=" + this.maskColor + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final ImageModel getBackgroundImageModel() {
        return this.backgroundImageModel;
    }

    public final Border getBorder() {
        return this.border;
    }

    public final Gradient getGradient() {
        return this.gradient;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final Radius getRadius() {
        return this.radius;
    }

    public Background(Gradient r100, Radius r101, Padding r102, Border r103, ImageModel r104, String r105, String r106) {
        this.gradient = r100;
        this.radius = r101;
        this.padding = r102;
        this.border = r103;
        this.backgroundImageModel = r104;
        this.maskColor = r105;
        this.backgroundColor = r106;
    }

    public /* synthetic */ Background(Gradient r100, Radius r101, Padding r102, Border r110, ImageModel r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Gradient r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Radius r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Padding r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Border r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        ImageModel r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
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
