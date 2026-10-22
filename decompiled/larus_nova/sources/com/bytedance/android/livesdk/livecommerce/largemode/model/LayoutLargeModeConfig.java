package com.bytedance.android.livesdk.livecommerce.largemode.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u009e\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\bHÖ\u0001J\t\u00106\u001a\u000207HÖ\u0001R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001e\u0010\u0013R\u001a\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b \u0010\u0013R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "Ljava/io/Serializable;", "widthConfig", "Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;", "heightConfig", "drawableScale", "", "leftMargin", "", "rightMargin", "topMargin", "bottomMargin", "leftPadding", "rightPadding", "topPadding", "bottomPadding", "radius", "(Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottomMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBottomPadding", "getDrawableScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHeightConfig", "()Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;", "getLeftMargin", "getLeftPadding", "getRadius", "getRightMargin", "getRightPadding", "getTopMargin", "getTopPadding", "getWidthConfig", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "equals", "", "other", "", "hashCode", "toString", "", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class LayoutLargeModeConfig implements Serializable {

    @SerializedName("bottom_margin")
    private final Integer bottomMargin;

    @SerializedName("bottom_padding")
    private final Integer bottomPadding;

    @SerializedName("drawable_scale")
    private final Float drawableScale;

    @SerializedName("height")
    private final LayoutSizeLargeModeConfig heightConfig;

    @SerializedName("left_margin")
    private final Integer leftMargin;

    @SerializedName("left_padding")
    private final Integer leftPadding;

    @SerializedName("radius")
    private final Integer radius;

    @SerializedName("right_margin")
    private final Integer rightMargin;

    @SerializedName("right_padding")
    private final Integer rightPadding;

    @SerializedName("top_margin")
    private final Integer topMargin;

    @SerializedName("top_padding")
    private final Integer topPadding;

    @SerializedName("width")
    private final LayoutSizeLargeModeConfig widthConfig;

    public LayoutLargeModeConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ LayoutLargeModeConfig copy$default(LayoutLargeModeConfig r110, LayoutSizeLargeModeConfig r111, LayoutSizeLargeModeConfig r112, Float r113, Integer r114, Integer r115, Integer r116, Integer r210, Integer r211, Integer r212, Integer r213, Integer r214, Integer r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        LayoutSizeLargeModeConfig r100 = r110.widthConfig;
    L7:
        if ((r216 & 2) == 0) goto L9;
        LayoutSizeLargeModeConfig r101 = r110.heightConfig;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Float r102 = r110.drawableScale;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Integer r103 = r110.leftMargin;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Integer r104 = r110.rightMargin;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Integer r105 = r110.topMargin;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Integer r106 = r110.bottomMargin;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Integer r107 = r110.leftPadding;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Integer r117 = r110.rightPadding;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Integer r118 = r110.topPadding;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Integer r119 = r110.bottomPadding;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Integer r108 = r110.radius;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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

    public final LayoutSizeLargeModeConfig component1() {
        return this.widthConfig;
    }

    public final Integer component10() {
        return this.topPadding;
    }

    public final Integer component11() {
        return this.bottomPadding;
    }

    public final Integer component12() {
        return this.radius;
    }

    public final LayoutSizeLargeModeConfig component2() {
        return this.heightConfig;
    }

    public final Float component3() {
        return this.drawableScale;
    }

    public final Integer component4() {
        return this.leftMargin;
    }

    public final Integer component5() {
        return this.rightMargin;
    }

    public final Integer component6() {
        return this.topMargin;
    }

    public final Integer component7() {
        return this.bottomMargin;
    }

    public final Integer component8() {
        return this.leftPadding;
    }

    public final Integer component9() {
        return this.rightPadding;
    }

    public final LayoutLargeModeConfig copy(LayoutSizeLargeModeConfig r110, LayoutSizeLargeModeConfig r111, Float r112, Integer r113, Integer r114, Integer r210, Integer r211, Integer r212, Integer r213, Integer r214, Integer r215, Integer r216) {
        return new LayoutLargeModeConfig(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LayoutLargeModeConfig) == false) goto L30;
        LayoutLargeModeConfig r101 = (LayoutLargeModeConfig) r100;
        if (Intrinsics.areEqual(this.widthConfig, r101.widthConfig) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.heightConfig, r101.heightConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.drawableScale, r101.drawableScale) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.leftMargin, r101.leftMargin) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.rightMargin, r101.rightMargin) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.topMargin, r101.topMargin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bottomMargin, r101.bottomMargin) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.leftPadding, r101.leftPadding) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.rightPadding, r101.rightPadding) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.topPadding, r101.topPadding) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.bottomPadding, r101.bottomPadding) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        LayoutSizeLargeModeConfig r100 = this.widthConfig;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LayoutSizeLargeModeConfig r104 = this.heightConfig;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.drawableScale;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.leftMargin;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.rightMargin;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.topMargin;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.bottomMargin;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.leftPadding;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.rightPadding;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.topPadding;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.bottomPadding;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.radius;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
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
        return "LayoutLargeModeConfig(widthConfig=" + this.widthConfig + ", heightConfig=" + this.heightConfig + ", drawableScale=" + this.drawableScale + ", leftMargin=" + this.leftMargin + ", rightMargin=" + this.rightMargin + ", topMargin=" + this.topMargin + ", bottomMargin=" + this.bottomMargin + ", leftPadding=" + this.leftPadding + ", rightPadding=" + this.rightPadding + ", topPadding=" + this.topPadding + ", bottomPadding=" + this.bottomPadding + ", radius=" + this.radius + ")";
    }

    public final Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public final Integer getBottomPadding() {
        return this.bottomPadding;
    }

    public final Float getDrawableScale() {
        return this.drawableScale;
    }

    public final LayoutSizeLargeModeConfig getHeightConfig() {
        return this.heightConfig;
    }

    public final Integer getLeftMargin() {
        return this.leftMargin;
    }

    public final Integer getLeftPadding() {
        return this.leftPadding;
    }

    public final Integer getRadius() {
        return this.radius;
    }

    public final Integer getRightMargin() {
        return this.rightMargin;
    }

    public final Integer getRightPadding() {
        return this.rightPadding;
    }

    public final Integer getTopMargin() {
        return this.topMargin;
    }

    public final Integer getTopPadding() {
        return this.topPadding;
    }

    public final LayoutSizeLargeModeConfig getWidthConfig() {
        return this.widthConfig;
    }

    public LayoutLargeModeConfig(LayoutSizeLargeModeConfig r100, LayoutSizeLargeModeConfig r101, Float r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r107, Integer r108, Integer r110, Integer r111, Integer r112) {
        this.widthConfig = r100;
        this.heightConfig = r101;
        this.drawableScale = r102;
        this.leftMargin = r103;
        this.rightMargin = r104;
        this.topMargin = r105;
        this.bottomMargin = r106;
        this.leftPadding = r107;
        this.rightPadding = r108;
        this.topPadding = r110;
        this.bottomPadding = r111;
        this.radius = r112;
    }

    public /* synthetic */ LayoutLargeModeConfig(LayoutSizeLargeModeConfig r110, LayoutSizeLargeModeConfig r111, Float r112, Integer r113, Integer r114, Integer r115, Integer r210, Integer r211, Integer r212, Integer r213, Integer r214, Integer r215, int r216, DefaultConstructorMarker r217) {
        Integer r100 = null;
        if ((r216 & 1) == 0) goto L5;
        LayoutSizeLargeModeConfig r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        LayoutSizeLargeModeConfig r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Float r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Integer r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Integer r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Integer r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
