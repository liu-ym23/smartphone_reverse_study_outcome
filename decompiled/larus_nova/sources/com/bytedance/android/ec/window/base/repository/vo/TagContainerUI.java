package com.bytedance.android.ec.window.base.repository.vo;

import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u00002\u0006\u0010K\u001a\u00020\u000eR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001e\u00103\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u001e\u00106\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#R\u001e\u00109\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010!\"\u0004\b;\u0010#R\u001e\u0010<\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0016\"\u0004\b>\u0010\u0018R\u001e\u0010?\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010-\"\u0004\bA\u0010/R \u0010B\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR \u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\b¨\u0006L"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/TagContainerUI;", "Ljava/io/Serializable;", "()V", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "borderColor", "getBorderColor", "setBorderColor", "borderRadius", "", "", "getBorderRadius", "()Ljava/util/List;", "setBorderRadius", "(Ljava/util/List;)V", "borderWidth", "", "getBorderWidth", "()D", "setBorderWidth", "(D)V", "colorFactor", "getColorFactor", "()F", "setColorFactor", "(F)V", "elementAliment", "", "getElementAliment", "()I", "setElementAliment", "(I)V", "endBgColor", "getEndBgColor", "setEndBgColor", "endBorderColor", "getEndBorderColor", "setEndBorderColor", "fillContainer", "", "getFillContainer", "()Z", "setFillContainer", "(Z)V", "hasBorder", "getHasBorder", "setHasBorder", "height", "getHeight", "setHeight", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "maxWidth", "getMaxWidth", "setMaxWidth", "rightAlignment", "getRightAlignment", "setRightAlignment", "specialBgColor", "getSpecialBgColor", "setSpecialBgColor", "specialBorderColor", "getSpecialBorderColor", "setSpecialBorderColor", "setUpdateColor", "", "other", "factor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagContainerUI implements Serializable {

    @SerializedName("bg_color")
    private String bgColor;

    @SerializedName("border_color")
    private String borderColor;

    @SerializedName("radius_list")
    private List<Float> borderRadius;

    @SerializedName("border_width")
    private double borderWidth;
    private float colorFactor;

    @SerializedName("element_alignment")
    private int elementAliment;
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

    public final void setBgColor(String r100) {
        this.bgColor = r100;
    }

    public final void setBorderColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.borderColor = r100;
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
