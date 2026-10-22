package com.bytedance.android.shopping.anchorv4.dto.base;

import androidx.core.provider.FontsContractCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import f73.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u0001<Bm\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b9\u0010:J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jv\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\u0013\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010,R\"\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010*\u001a\u0004\b-\u0010,\"\u0004\b.\u0010/R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b0\u0010'R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b1\u0010'R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00102\u001a\u0004\b3\u0010\fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00104\u001a\u0004\b5\u00106R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00107\u001a\u0004\b8\u0010\u0010¨\u0006="}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "Ljava/io/Serializable;", "", "component1", "", "component2", "", "component3", "component4", "component5", "component6", "component7", "()Ljava/lang/Float;", "Lf73/b;", "component8", "component9", "()Ljava/lang/Integer;", "fontSize", "textColor", "fontWeight", "line", "fontEnum", "fontFamily", "verticalOffSet", GXTemplateKey.FLEXBOX_MARGIN, "fontUnit", "copy", "(FLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lf73/b;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "toString", "hashCode", "", "other", "", "equals", FaceService.girlLabel, "getFontSize", "()F", "Ljava/lang/String;", "getTextColor", "()Ljava/lang/String;", "setTextColor", "(Ljava/lang/String;)V", "I", "getFontWeight", "()I", "getLine", "setLine", "(I)V", "getFontEnum", "getFontFamily", "Ljava/lang/Float;", "getVerticalOffSet", "Lf73/b;", "getMargin", "()Lf73/b;", "Ljava/lang/Integer;", "getFontUnit", "<init>", "(FLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lf73/b;Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FontStyle implements Serializable {
    public static final String BOLD = "1";
    public static final String BOLD_ITALIC = "3";
    public static final a Companion = null;
    public static final String ITALIC = "2";
    public static final String NORMAL = "0";

    @SerializedName("font_enum")
    private final String fontEnum;

    @SerializedName("font_family")
    private final String fontFamily;

    @SerializedName("font_size")
    private final float fontSize;

    @SerializedName("font_unit")
    private final Integer fontUnit;

    @SerializedName(FontsContractCompat.Columns.WEIGHT)
    private final int fontWeight;

    @SerializedName("line")
    private int line;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    private final b margin;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("vertical_offset")
    private final Float verticalOffSet;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FontStyle() {
        this(0.0f, null, 0, 0, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ FontStyle copy$default(FontStyle r110, float r111, String r112, int r113, int r114, String r115, String r116, Float r117, b r118, Integer r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        float r100 = r110.fontSize;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.textColor;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.fontWeight;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = r110.line;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.fontEnum;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.fontFamily;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Float r106 = r110.verticalOffSet;
    L31:
        if ((r210 & 128) == 0) goto L33;
        b r107 = r110.margin;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Integer r108 = r110.fontUnit;
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

    public final float component1() {
        return this.fontSize;
    }

    public final String component2() {
        return this.textColor;
    }

    public final int component3() {
        return this.fontWeight;
    }

    public final int component4() {
        return this.line;
    }

    public final String component5() {
        return this.fontEnum;
    }

    public final String component6() {
        return this.fontFamily;
    }

    public final Float component7() {
        return this.verticalOffSet;
    }

    public final b component8() {
        return this.margin;
    }

    public final Integer component9() {
        return this.fontUnit;
    }

    public final FontStyle copy(float r110, String r111, int r112, int r113, String r114, String r115, Float r116, b r117, Integer r210) {
        return new FontStyle(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FontStyle) == false) goto L24;
        FontStyle r101 = (FontStyle) r100;
        if (Float.compare(this.fontSize, r101.fontSize) == 0) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L10;
        return false;
    L10:
        if (this.fontWeight == r101.fontWeight) goto L12;
        return false;
    L12:
        if (this.line == r101.line) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fontEnum, r101.fontEnum) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.fontFamily, r101.fontFamily) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.verticalOffSet, r101.verticalOffSet) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.margin, r101.margin) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.fontUnit, r101.fontUnit) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r100 = Float.floatToIntBits(this.fontSize) * 31;
        String r101 = this.textColor;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((((r100 + r103) * 31) + this.fontWeight) * 31) + this.line) * 31;
        String r105 = this.fontEnum;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.fontFamily;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Float r111 = this.verticalOffSet;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        b r114 = this.margin;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.fontUnit;
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
        return "FontStyle(fontSize=" + this.fontSize + ", textColor=" + this.textColor + ", fontWeight=" + this.fontWeight + ", line=" + this.line + ", fontEnum=" + this.fontEnum + ", fontFamily=" + this.fontFamily + ", verticalOffSet=" + this.verticalOffSet + ", margin=" + this.margin + ", fontUnit=" + this.fontUnit + ")";
    }

    public final String getFontEnum() {
        return this.fontEnum;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final Integer getFontUnit() {
        return this.fontUnit;
    }

    public final int getFontWeight() {
        return this.fontWeight;
    }

    public final int getLine() {
        return this.line;
    }

    public final b getMargin() {
        return this.margin;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final Float getVerticalOffSet() {
        return this.verticalOffSet;
    }

    public final void setLine(int r100) {
        this.line = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public FontStyle(float r100, String r101, int r102, int r103, String r104, String r105, Float r106, b r107, Integer r108) {
        this.fontSize = r100;
        this.textColor = r101;
        this.fontWeight = r102;
        this.line = r103;
        this.fontEnum = r104;
        this.fontFamily = r105;
        this.verticalOffSet = r106;
        this.margin = r107;
        this.fontUnit = r108;
    }

    public /* synthetic */ FontStyle(float r110, String r111, int r112, int r113, String r114, String r115, Float r116, b r117, Integer r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        float r100 = 13.0f;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = "#FF161823";
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = 400;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = 1;
    L18:
        b r104 = null;
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Float r107 = null;
    L31:
        if ((r210 & 128) != 0) goto L35;
        r104 = r117;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Integer r108 = 0;
    L38:
        this(r100, r101, r102, r103, r105, r106, r107, r104, r108);
        return;
    L37:
        r108 = r118;
        goto L38
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
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
