package com.bytedance.android.ec.store.repository.vo;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0018\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010\u00002\u0006\u0010[\u001a\u00020\u001dR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001e\u00101\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\u001c\u00104\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\n\"\u0004\b6\u0010\fR\u001c\u00107\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010\fR\u001e\u0010:\u001a\u00020;8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u00020;8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u001e\u0010C\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u0010\u001bR\u001e\u0010F\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\u001e\u0010I\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001bR\u001e\u0010L\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010&\"\u0004\bN\u0010(R\u001e\u0010O\u001a\u00020;8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010=\"\u0004\bQ\u0010?R \u0010R\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\n\"\u0004\bT\u0010\fR \u0010U\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\n\"\u0004\bW\u0010\f¨\u0006\\"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/TagContainerUI;", "Ljava/io/Serializable;", "()V", "sliceData", "", "", "", "(Ljava/util/Map;)V", "bgColor", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "borderColor", "getBorderColor", "setBorderColor", "borderColors", "", "getBorderColors", "()Ljava/util/List;", "setBorderColors", "(Ljava/util/List;)V", "borderOrientation", "", "getBorderOrientation", "()I", "setBorderOrientation", "(I)V", "borderPositions", "", "getBorderPositions", "setBorderPositions", "borderRadius", "getBorderRadius", "setBorderRadius", "borderWidth", "", "getBorderWidth", "()D", "setBorderWidth", "(D)V", "colorFactor", "getColorFactor", "()F", "setColorFactor", "(F)V", "elementAliment", "getElementAliment", "setElementAliment", "elevation", "getElevation", "setElevation", "endBgColor", "getEndBgColor", "setEndBgColor", "endBorderColor", "getEndBorderColor", "setEndBorderColor", "fillContainer", "", "getFillContainer", "()Z", "setFillContainer", "(Z)V", "hasBorder", "getHasBorder", "setHasBorder", "height", "getHeight", "setHeight", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "maxWidth", "getMaxWidth", "setMaxWidth", "rightAlignment", "getRightAlignment", "setRightAlignment", "specialBgColor", "getSpecialBgColor", "setSpecialBgColor", "specialBorderColor", "getSpecialBorderColor", "setSpecialBorderColor", "setUpdateColor", "", "other", "factor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagContainerUI implements Serializable {

    @SerializedName("bg_color")
    private String bgColor;

    @SerializedName("border_color")
    private String borderColor;

    @SerializedName("border_colors")
    private List<String> borderColors;

    @SerializedName("border_orientation")
    private int borderOrientation;

    @SerializedName("border_positions")
    private List<Float> borderPositions;

    @SerializedName("radius_list")
    private List<Float> borderRadius;

    @SerializedName("border_width")
    private double borderWidth;
    private float colorFactor;

    @SerializedName("element_alignment")
    private int elementAliment;

    @SerializedName("elevation")
    private float elevation;
    private String endBgColor;
    private String endBorderColor;

    @SerializedName("fill_container")
    private boolean fillContainer;

    @SerializedName("has_border")
    private boolean hasBorder;

    @SerializedName("height")
    private int height;

    @SerializedName("margin_left")
    private int marginLeft;

    @SerializedName("margin_right")
    private int marginRight;

    @SerializedName(TextureRenderKeys.KEY_IS_MAX_WIDTH)
    private double maxWidth;

    @SerializedName("right_alignment")
    private boolean rightAlignment;

    @SerializedName("special_bg_color")
    private String specialBgColor;

    @SerializedName("special_border_color")
    private String specialBorderColor;

    public TagContainerUI() {
        this.borderColor = "";
        this.specialBorderColor = "";
        this.borderRadius = CollectionsKt.emptyList();
        this.elementAliment = ElementAlignment.LEADING.getType();
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final List<String> getBorderColors() {
        return this.borderColors;
    }

    public final int getBorderOrientation() {
        return this.borderOrientation;
    }

    public final List<Float> getBorderPositions() {
        return this.borderPositions;
    }

    public final List<Float> getBorderRadius() {
        return this.borderRadius;
    }

    public final double getBorderWidth() {
        return this.borderWidth;
    }

    public final float getColorFactor() {
        return this.colorFactor;
    }

    public final int getElementAliment() {
        return this.elementAliment;
    }

    public final float getElevation() {
        return this.elevation;
    }

    public final String getEndBgColor() {
        return this.endBgColor;
    }

    public final String getEndBorderColor() {
        return this.endBorderColor;
    }

    public final boolean getFillContainer() {
        return this.fillContainer;
    }

    public final boolean getHasBorder() {
        return this.hasBorder;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public final int getMarginRight() {
        return this.marginRight;
    }

    public final double getMaxWidth() {
        return this.maxWidth;
    }

    public final boolean getRightAlignment() {
        return this.rightAlignment;
    }

    public final String getSpecialBgColor() {
        return this.specialBgColor;
    }

    public final String getSpecialBorderColor() {
        return this.specialBorderColor;
    }

    public TagContainerUI(Map<String, ? extends Object> r110) {
        String r100 = "";
        this.borderColor = "";
        this.specialBorderColor = "";
        this.borderRadius = CollectionsKt.emptyList();
        ElementAlignment r101 = ElementAlignment.LEADING;
        this.elementAliment = r101.getType();
        if (r110 != null) goto L5;
        return;
    L5:
        Object r102 = r110.get("height");
        Object r103 = null;
        if ((r102 instanceof Number) == true) goto L8;
        r102 = null;
    L8:
        Number r104 = (Number) r102;
        int r105 = 0;
        if (r104 == null) goto L11;
        int r106 = r104.intValue();
    L12:
        this.height = r106;
        Object r107 = r110.get("margin_left");
        if ((r107 instanceof Number) == true) goto L15;
        r107 = null;
    L15:
        Number r108 = (Number) r107;
        if (r108 == null) goto L18;
        int r109 = r108.intValue();
    L19:
        this.marginLeft = r109;
        Object r111 = r110.get("margin_right");
        if ((r111 instanceof Number) == true) goto L22;
        r111 = null;
    L22:
        Number r112 = (Number) r111;
        if (r112 == null) goto L25;
        int r113 = r112.intValue();
    L26:
        this.marginRight = r113;
        Object r114 = r110.get("has_border");
        if ((r114 instanceof Boolean) == true) goto L29;
        r114 = null;
    L29:
        Boolean r115 = (Boolean) r114;
        if (r115 == null) goto L32;
        boolean r116 = r115.booleanValue();
    L33:
        this.hasBorder = r116;
        Object r117 = r110.get("border_color");
        if ((r117 instanceof String) == true) goto L36;
        r117 = null;
    L36:
        String r118 = (String) r117;
        if (r118 == null) goto L40;
        r100 = r118;
    L40:
        this.borderColor = r100;
        Object r119 = r110.get("special_border_color");
        if (r119 == null) goto L43;
        String r120 = r119.toString();
    L44:
        this.specialBorderColor = r120;
        Object r121 = r110.get("border_width");
        if ((r121 instanceof Double) == true) goto L47;
        r121 = null;
    L47:
        Double r122 = (Double) r121;
        double r123 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r122 == null) goto L50;
        double r124 = r122.doubleValue();
    L51:
        this.borderWidth = r124;
        Object r125 = r110.get("radius_list");
        if ((r125 instanceof List) == true) goto L54;
        r125 = null;
    L54:
        List<Float> r126 = (List) r125;
        if (r126 != null) goto L57;
        r126 = CollectionsKt.emptyList();
    L57:
        this.borderRadius = r126;
        Object r127 = r110.get("right_alignment");
        if ((r127 instanceof Boolean) == true) goto L60;
        r127 = null;
    L60:
        Boolean r128 = (Boolean) r127;
        if (r128 == null) goto L63;
        boolean r129 = r128.booleanValue();
    L64:
        this.rightAlignment = r129;
        Object r130 = r110.get(TextureRenderKeys.KEY_IS_MAX_WIDTH);
        if ((r130 instanceof Double) == true) goto L67;
        r130 = null;
    L67:
        Double r131 = (Double) r130;
        if (r131 == null) goto L70;
        r123 = r131.doubleValue();
    L70:
        this.maxWidth = r123;
        Object r132 = r110.get("element_alignment");
        if ((r132 instanceof Number) == true) goto L73;
        r132 = null;
    L73:
        Number r133 = (Number) r132;
        if (r133 == null) goto L76;
        int r134 = r133.intValue();
    L77:
        this.elementAliment = r134;
        Object r135 = r110.get("fill_container");
        if ((r135 instanceof Boolean) == true) goto L80;
        r135 = null;
    L80:
        Boolean r136 = (Boolean) r135;
        if (r136 == null) goto L83;
        boolean r137 = r136.booleanValue();
    L84:
        this.fillContainer = r137;
        Object r138 = r110.get("bg_color");
        if ((r138 instanceof String) == true) goto L87;
        r138 = null;
    L87:
        this.bgColor = (String) r138;
        Object r139 = r110.get("special_bg_color");
        if ((r139 instanceof String) == true) goto L90;
        r139 = null;
    L90:
        this.specialBgColor = (String) r139;
        Object r140 = r110.get("border_colors");
        if ((r140 instanceof List) == true) goto L93;
        r140 = null;
    L93:
        List<String> r141 = (List) r140;
        if (r141 != null) goto L96;
        r141 = CollectionsKt.emptyList();
    L96:
        this.borderColors = r141;
        Object r142 = r110.get("border_positions");
        if ((r142 instanceof List) == true) goto L99;
        r142 = null;
    L99:
        List<Float> r143 = (List) r142;
        if (r143 != null) goto L102;
        r143 = CollectionsKt.emptyList();
    L102:
        this.borderPositions = r143;
        Object r144 = r110.get("border_orientation");
        if ((r144 instanceof Number) == true) goto L105;
        r144 = null;
    L105:
        Number r145 = (Number) r144;
        if (r145 == null) goto L108;
        r105 = r145.intValue();
    L108:
        this.borderOrientation = r105;
        Object r146 = r110.get("elevation");
        if ((r146 instanceof Number) == false) goto L112;
        r103 = r146;
    L112:
        Number r147 = (Number) r103;
        if (r147 == null) goto L115;
        float r148 = r147.floatValue();
    L116:
        this.elevation = r148;
        return;
    L115:
        r148 = 0.0f;
        goto L116
    L83:
        r137 = false;
        goto L84
    L76:
        r134 = r101.getType();
        goto L77
    L63:
        r129 = false;
        goto L64
    L50:
        r124 = 0.0d;
        goto L51
    L43:
        r120 = null;
        goto L44
    L32:
        r116 = false;
        goto L33
    L25:
        r113 = 0;
        goto L26
    L18:
        r109 = 0;
        goto L19
    L11:
        r106 = 0;
        goto L12
    }

    public final void setBgColor(String r100) {
        this.bgColor = r100;
    }

    public final void setBorderColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.borderColor = r100;
    }

    public final void setBorderColors(List<String> r100) {
        this.borderColors = r100;
    }

    public final void setBorderOrientation(int r100) {
        this.borderOrientation = r100;
    }

    public final void setBorderPositions(List<Float> r100) {
        this.borderPositions = r100;
    }

    public final void setBorderRadius(List<Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.borderRadius = r100;
    }

    public final void setBorderWidth(double r100) {
        this.borderWidth = r100;
    }

    public final void setColorFactor(float r100) {
        this.colorFactor = r100;
    }

    public final void setElementAliment(int r100) {
        this.elementAliment = r100;
    }

    public final void setElevation(float r100) {
        this.elevation = r100;
    }

    public final void setEndBgColor(String r100) {
        this.endBgColor = r100;
    }

    public final void setEndBorderColor(String r100) {
        this.endBorderColor = r100;
    }

    public final void setFillContainer(boolean r100) {
        this.fillContainer = r100;
    }

    public final void setHasBorder(boolean r100) {
        this.hasBorder = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setMarginLeft(int r100) {
        this.marginLeft = r100;
    }

    public final void setMarginRight(int r100) {
        this.marginRight = r100;
    }

    public final void setMaxWidth(double r100) {
        this.maxWidth = r100;
    }

    public final void setRightAlignment(boolean r100) {
        this.rightAlignment = r100;
    }

    public final void setSpecialBgColor(String r100) {
        this.specialBgColor = r100;
    }

    public final void setSpecialBorderColor(String r100) {
        this.specialBorderColor = r100;
    }

    public final void setUpdateColor(TagContainerUI r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.endBgColor = r100.bgColor;
        this.endBorderColor = r100.borderColor;
        this.colorFactor = r101;
    }
}
