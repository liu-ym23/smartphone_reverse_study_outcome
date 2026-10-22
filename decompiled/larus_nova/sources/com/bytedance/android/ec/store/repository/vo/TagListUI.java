package com.bytedance.android.ec.store.repository.vo;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0018\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u00002\u0006\u0010@\u001a\u00020\u001dR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR$\u00101\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010\fR \u0010:\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\n\"\u0004\b<\u0010\f¨\u0006A"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/TagListUI;", "Ljava/io/Serializable;", "()V", "sliceData", "", "", "", "(Ljava/util/Map;)V", "bgColor", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "bgImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBgImg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setBgImg", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "borderColor", "getBorderColor", "setBorderColor", "borderWidth", "", "getBorderWidth", "()D", "setBorderWidth", "(D)V", "colorFactor", "", "getColorFactor", "()F", "setColorFactor", "(F)V", "endBgColor", "getEndBgColor", "setEndBgColor", "endBorderColor", "getEndBorderColor", "setEndBorderColor", "hasBorder", "", "getHasBorder", "()Z", "setHasBorder", "(Z)V", "height", "getHeight", "setHeight", "radius", "", "getRadius", "()Ljava/util/List;", "setRadius", "(Ljava/util/List;)V", "specialBgColor", "getSpecialBgColor", "setSpecialBgColor", "specialBorderColor", "getSpecialBorderColor", "setSpecialBorderColor", "setUpdateColor", "", "other", "factor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagListUI implements Serializable {

    @SerializedName("bg_color")
    private String bgColor;

    @SerializedName("bg_image")
    private ECUrlModel bgImg;

    @SerializedName("border_color")
    private String borderColor;

    @SerializedName("border_width")
    private double borderWidth;
    private float colorFactor;
    private String endBgColor;
    private String endBorderColor;

    @SerializedName("has_border")
    private boolean hasBorder;

    @SerializedName("height")
    private double height;

    @SerializedName("radius_list")
    private List<Float> radius;

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

    public TagListUI(Map<String, ? extends Object> r100) {
        this.radius = CollectionsKt.emptyList();
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = r100.get("height");
        Object r102 = null;
        if ((r101 instanceof Double) == true) goto L8;
        r101 = null;
    L8:
        Double r103 = (Double) r101;
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r103 == null) goto L11;
        double r105 = r103.doubleValue();
    L12:
        this.height = r105;
        Object r106 = r100.get("bg_color");
        if ((r106 instanceof String) == true) goto L15;
        r106 = null;
    L15:
        this.bgColor = (String) r106;
        Object r107 = r100.get("special_bg_color");
        if ((r107 instanceof String) == true) goto L18;
        r107 = null;
    L18:
        this.specialBgColor = (String) r107;
        Object r108 = r100.get("has_border");
        if ((r108 instanceof Boolean) == true) goto L21;
        r108 = null;
    L21:
        Boolean r109 = (Boolean) r108;
        if (r109 == null) goto L24;
        boolean r110 = r109.booleanValue();
    L25:
        this.hasBorder = r110;
        Object r111 = r100.get("border_color");
        if ((r111 instanceof String) == true) goto L28;
        r111 = null;
    L28:
        this.borderColor = (String) r111;
        Object r112 = r100.get("special_border_color");
        if ((r112 instanceof String) == true) goto L31;
        r112 = null;
    L31:
        this.specialBorderColor = (String) r112;
        Object r113 = r100.get("border_width");
        if ((r113 instanceof Double) == true) goto L34;
        r113 = null;
    L34:
        Double r114 = (Double) r113;
        if (r114 == null) goto L37;
        r104 = r114.doubleValue();
    L37:
        this.borderWidth = r104;
        Object r115 = r100.get("radius_list");
        if ((r115 instanceof List) == true) goto L40;
        r115 = null;
    L40:
        List<Float> r116 = (List) r115;
        if (r116 != null) goto L43;
        r116 = CollectionsKt.emptyList();
    L43:
        this.radius = r116;
        Object r117 = r100.get("bg_image");
        if ((r117 instanceof Map) == false) goto L47;
        r102 = r117;
    L47:
        this.bgImg = com.bytedance.android.shopping.store.slicecard.i.d((Map) r102);
        return;
    L24:
        r110 = false;
        goto L25
    L11:
        r105 = 0.0d;
        goto L12
    }

    public final void setBgColor(String r100) {
        this.bgColor = r100;
    }

    public final void setBgImg(ECUrlModel r100) {
        this.bgImg = r100;
    }

    public final void setBorderColor(String r100) {
        this.borderColor = r100;
    }

    public final void setBorderWidth(double r100) {
        this.borderWidth = r100;
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

    public final void setHasBorder(boolean r100) {
        this.hasBorder = r100;
    }

    public final void setHeight(double r100) {
        this.height = r100;
    }

    public final void setRadius(List<Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.radius = r100;
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
