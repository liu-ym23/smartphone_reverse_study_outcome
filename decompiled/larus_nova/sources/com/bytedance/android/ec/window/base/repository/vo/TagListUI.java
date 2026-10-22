package com.bytedance.android.ec.window.base.repository.vo;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u00002\u0006\u00105\u001a\u00020\u0015R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u0016\u0010 \u001a\u00020!8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010'R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150)8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R \u0010,\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR \u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\b¨\u00066"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/TagListUI;", "Ljava/io/Serializable;", "()V", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "bgImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBgImg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "borderColor", "getBorderColor", "setBorderColor", "borderWidth", "", "getBorderWidth", "()D", "colorFactor", "", "getColorFactor", "()F", "setColorFactor", "(F)V", "endBgColor", "getEndBgColor", "setEndBgColor", "endBorderColor", "getEndBorderColor", "setEndBorderColor", "hasBorder", "", "getHasBorder", "()Z", "height", "getHeight", "setHeight", "(D)V", "radius", "", "getRadius", "()Ljava/util/List;", "specialBgColor", "getSpecialBgColor", "setSpecialBgColor", "specialBorderColor", "getSpecialBorderColor", "setSpecialBorderColor", "setUpdateColor", "", "other", "factor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagListUI implements Serializable {

    @SerializedName("bg_color")
    private String bgColor;

    @SerializedName("bg_image")
    private final ECUrlModel bgImg;

    @SerializedName("border_color")
    private String borderColor;

    @SerializedName("border_width")
    private final double borderWidth;
    private float colorFactor;
    private String endBgColor;
    private String endBorderColor;

    @SerializedName("has_border")
    private final boolean hasBorder;

    @SerializedName("height")
    private double height;

    @SerializedName("radius_list")
    private final List<Float> radius;

    @SerializedName("special_bg_color")
    private String specialBgColor;

    @SerializedName("special_border_color")
    private String specialBorderColor;

    public TagListUI() {
        this.radius = CollectionsKt.emptyList();
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final ECUrlModel getBgImg() {
        return this.bgImg;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final double getBorderWidth() {
        return this.borderWidth;
    }

    public final float getColorFactor() {
        return this.colorFactor;
    }

    public final String getEndBgColor() {
        return this.endBgColor;
    }

    public final String getEndBorderColor() {
        return this.endBorderColor;
    }

    public final boolean getHasBorder() {
        return this.hasBorder;
    }

    public final double getHeight() {
        return this.height;
    }

    public final List<Float> getRadius() {
        return this.radius;
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
        this.borderColor = r100;
    }

    public final void setColorFactor(float r100) {
        this.colorFactor = r100;
    }

    public final void setEndBgColor(String r100) {
        this.endBgColor = r100;
    }

    public final void setEndBorderColor(String r100) {
        this.endBorderColor = r100;
    }

    public final void setHeight(double r100) {
        this.height = r100;
    }

    public final void setSpecialBgColor(String r100) {
        this.specialBgColor = r100;
    }

    public final void setSpecialBorderColor(String r100) {
        this.specialBorderColor = r100;
    }

    public final void setUpdateColor(TagListUI r100, float r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.bgColor;
    L6:
        this.endBgColor = r103;
        if (r100 == null) goto L9;
        r102 = r100.borderColor;
    L9:
        this.endBorderColor = r102;
        this.colorFactor = r101;
        return;
    L5:
        r103 = null;
        goto L6
    }
}
