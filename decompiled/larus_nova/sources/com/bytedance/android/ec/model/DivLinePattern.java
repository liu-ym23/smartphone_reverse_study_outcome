package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\\\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006&"}, d2 = {"Lcom/bytedance/android/ec/model/DivLinePattern;", "Ljava/io/Serializable;", "divLineCharacter", "", "divLineFontSize", "", "divLineFontWeight", "divLinePadding", "divLineColor", "style", "divLineHeight", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;II)V", "getDivLineCharacter", "()Ljava/lang/String;", "getDivLineColor", "getDivLineFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDivLineFontWeight", "getDivLineHeight", "()I", "getDivLinePadding", "getStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;II)Lcom/bytedance/android/ec/model/DivLinePattern;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class DivLinePattern implements Serializable {

    @SerializedName("div_line_character")
    private final String divLineCharacter;

    @SerializedName("div_line_color")
    private final String divLineColor;

    @SerializedName("div_line_font_size")
    private final Integer divLineFontSize;

    @SerializedName("div_line_font_weight")
    private final Integer divLineFontWeight;

    @SerializedName("div_line_height")
    private final int divLineHeight;

    @SerializedName("div_line_padding")
    private final int divLinePadding;

    @SerializedName("div_line_style")
    private final int style;

    public DivLinePattern() {
        this(null, null, null, 0, null, 0, 0, 127, null);
    }

    public static /* synthetic */ DivLinePattern copy$default(DivLinePattern r100, String r101, Integer r102, Integer r103, int r104, String r110, int r111, int r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.divLineCharacter;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.divLineFontSize;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.divLineFontWeight;
    L11:
        Integer r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.divLinePadding;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.divLineColor;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.style;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.divLineHeight;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.divLineCharacter;
    }

    public final Integer component2() {
        return this.divLineFontSize;
    }

    public final Integer component3() {
        return this.divLineFontWeight;
    }

    public final int component4() {
        return this.divLinePadding;
    }

    public final String component5() {
        return this.divLineColor;
    }

    public final int component6() {
        return this.style;
    }

    public final int component7() {
        return this.divLineHeight;
    }

    public final DivLinePattern copy(String r110, Integer r111, Integer r112, int r113, String r114, int r115, int r116) {
        return new DivLinePattern(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DivLinePattern) == false) goto L20;
        DivLinePattern r101 = (DivLinePattern) r100;
        if (Intrinsics.areEqual(this.divLineCharacter, r101.divLineCharacter) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.divLineFontSize, r101.divLineFontSize) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.divLineFontWeight, r101.divLineFontWeight) == true) goto L12;
        return false;
    L12:
        if (this.divLinePadding == r101.divLinePadding) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.divLineColor, r101.divLineColor) == true) goto L16;
        return false;
    L16:
        if (this.style == r101.style) goto L18;
        return false;
    L18:
        if (this.divLineHeight == r101.divLineHeight) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.divLineCharacter;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.divLineFontSize;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.divLineFontWeight;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.divLinePadding) * 31;
        String r110 = this.divLineColor;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return ((((r109 + r101) * 31) + this.style) * 31) + this.divLineHeight;
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
        return "DivLinePattern(divLineCharacter=" + this.divLineCharacter + ", divLineFontSize=" + this.divLineFontSize + ", divLineFontWeight=" + this.divLineFontWeight + ", divLinePadding=" + this.divLinePadding + ", divLineColor=" + this.divLineColor + ", style=" + this.style + ", divLineHeight=" + this.divLineHeight + ")";
    }

    public final String getDivLineCharacter() {
        return this.divLineCharacter;
    }

    public final String getDivLineColor() {
        return this.divLineColor;
    }

    public final Integer getDivLineFontSize() {
        return this.divLineFontSize;
    }

    public final Integer getDivLineFontWeight() {
        return this.divLineFontWeight;
    }

    public final int getDivLineHeight() {
        return this.divLineHeight;
    }

    public final int getDivLinePadding() {
        return this.divLinePadding;
    }

    public final int getStyle() {
        return this.style;
    }

    public DivLinePattern(String r100, Integer r101, Integer r102, int r103, String r104, int r105, int r106) {
        this.divLineCharacter = r100;
        this.divLineFontSize = r101;
        this.divLineFontWeight = r102;
        this.divLinePadding = r103;
        this.divLineColor = r104;
        this.style = r105;
        this.divLineHeight = r106;
    }

    public /* synthetic */ DivLinePattern(String r100, Integer r101, Integer r102, int r103, String r110, int r111, int r112, int r113, DefaultConstructorMarker r114) {
        String r104 = null;
        if ((r113 & 1) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        Integer r105 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r113 & 16) != 0) goto L23;
        r104 = r110;
    L23:
        if ((r113 & 32) == 0) goto L25;
        r111 = DivLineStyle.DOTTED_LINE.getStyle();
    L25:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L28;
        int r116 = 16;
    L29:
        this(r115, r105, r106, r107, r104, r108, r116);
        return;
    L28:
        r116 = r112;
        goto L29
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
