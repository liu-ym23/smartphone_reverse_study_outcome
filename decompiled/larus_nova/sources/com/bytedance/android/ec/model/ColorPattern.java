package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003Ja\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/model/ColorPattern;", "Ljava/io/Serializable;", "borderColorStyle", "", "borderGradientColors", "", "", "leftTextColor", "rightTextColor", "leftBgColor", "rightBgColor", "borderColor", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBorderColor", "()Ljava/lang/String;", "getBorderColorStyle", "()I", "getBorderGradientColors", "()Ljava/util/List;", "getLeftBgColor", "getLeftTextColor", "getRightBgColor", "getRightTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ColorPattern implements Serializable {

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("border_color_style")
    private final int borderColorStyle;

    @SerializedName("border_gradient_colors")
    private final List<String> borderGradientColors;

    @SerializedName("left_bg_color")
    private final String leftBgColor;

    @SerializedName("left_text_color")
    private final String leftTextColor;

    @SerializedName("right_bg_color")
    private final String rightBgColor;

    @SerializedName("right_text_color")
    private final String rightTextColor;

    public ColorPattern() {
        this(0, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ColorPattern copy$default(ColorPattern r100, int r101, List r102, String r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.borderColorStyle;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.borderGradientColors;
    L8:
        List r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.leftTextColor;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.rightTextColor;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.leftBgColor;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.rightBgColor;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.borderColor;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.borderColorStyle;
    }

    public final List<String> component2() {
        return this.borderGradientColors;
    }

    public final String component3() {
        return this.leftTextColor;
    }

    public final String component4() {
        return this.rightTextColor;
    }

    public final String component5() {
        return this.leftBgColor;
    }

    public final String component6() {
        return this.rightBgColor;
    }

    public final String component7() {
        return this.borderColor;
    }

    public final ColorPattern copy(int r110, List<String> r111, String r112, String r113, String r114, String r115, String r116) {
        return new ColorPattern(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ColorPattern) == false) goto L20;
        ColorPattern r101 = (ColorPattern) r100;
        if (this.borderColorStyle == r101.borderColorStyle) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.borderGradientColors, r101.borderGradientColors) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftTextColor, r101.leftTextColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightTextColor, r101.rightTextColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.leftBgColor, r101.leftBgColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.rightBgColor, r101.rightBgColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r100 = this.borderColorStyle * 31;
        List<String> r101 = this.borderGradientColors;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.leftTextColor;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.rightTextColor;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.leftBgColor;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.rightBgColor;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.borderColor;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        return r116 + r102;
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
        return "ColorPattern(borderColorStyle=" + this.borderColorStyle + ", borderGradientColors=" + this.borderGradientColors + ", leftTextColor=" + this.leftTextColor + ", rightTextColor=" + this.rightTextColor + ", leftBgColor=" + this.leftBgColor + ", rightBgColor=" + this.rightBgColor + ", borderColor=" + this.borderColor + ")";
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderColorStyle() {
        return this.borderColorStyle;
    }

    public final List<String> getBorderGradientColors() {
        return this.borderGradientColors;
    }

    public final String getLeftBgColor() {
        return this.leftBgColor;
    }

    public final String getLeftTextColor() {
        return this.leftTextColor;
    }

    public final String getRightBgColor() {
        return this.rightBgColor;
    }

    public final String getRightTextColor() {
        return this.rightTextColor;
    }

    public ColorPattern(int r100, List<String> r101, String r102, String r103, String r104, String r105, String r106) {
        this.borderColorStyle = r100;
        this.borderGradientColors = r101;
        this.leftTextColor = r102;
        this.rightTextColor = r103;
        this.leftBgColor = r104;
        this.rightBgColor = r105;
        this.borderColor = r106;
    }

    public /* synthetic */ ColorPattern(int r100, List r101, String r102, String r103, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        String r104 = null;
        if ((r113 & 2) == 0) goto L8;
        List r115 = null;
    L10:
        if ((r113 & 4) == 0) goto L12;
        String r105 = null;
    L14:
        if ((r113 & 8) == 0) goto L16;
        String r106 = null;
    L18:
        if ((r113 & 16) == 0) goto L20;
        String r107 = null;
    L22:
        if ((r113 & 32) == 0) goto L24;
        String r108 = null;
    L26:
        if ((r113 & 64) != 0) goto L29;
        r104 = r112;
    L29:
        this(r100, r115, r105, r106, r107, r108, r104);
        return;
    L24:
        r108 = r111;
        goto L26
    L20:
        r107 = r110;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L12:
        r105 = r102;
        goto L14
    L8:
        r115 = r101;
        goto L10
    }
}
