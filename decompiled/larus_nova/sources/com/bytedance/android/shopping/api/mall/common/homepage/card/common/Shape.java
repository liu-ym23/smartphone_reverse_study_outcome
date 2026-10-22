package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.facebook.keyframes.model.KFFeature;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003JD\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;", "", "shapeRadius", "", "", "strokeColor", "", "strokeWidth", "shapeColor", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)V", "getShapeColor", "()Ljava/lang/String;", "getShapeRadius", "()Ljava/util/List;", "getStrokeColor", "getStrokeWidth", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Shape {

    @SerializedName("shape_color")
    private final String shapeColor;

    @SerializedName("radius")
    private final List<Float> shapeRadius;

    @SerializedName(KFFeature.STROKE_COLOR_JSON_FIELD)
    private final String strokeColor;

    @SerializedName(KFFeature.STROKE_WIDTH_JSON_FIELD)
    private final Float strokeWidth;

    public Shape() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Shape copy$default(Shape r100, List r101, String r102, Float r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.shapeRadius;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.strokeColor;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.strokeWidth;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.shapeColor;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<Float> component1() {
        return this.shapeRadius;
    }

    public final String component2() {
        return this.strokeColor;
    }

    public final Float component3() {
        return this.strokeWidth;
    }

    public final String component4() {
        return this.shapeColor;
    }

    public final Shape copy(List<Float> r100, String r101, Float r102, String r103) {
        return new Shape(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Shape) == false) goto L14;
        Shape r101 = (Shape) r100;
        if (Intrinsics.areEqual(this.shapeRadius, r101.shapeRadius) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.strokeColor, r101.strokeColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strokeWidth, r101.strokeWidth) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shapeColor, r101.shapeColor) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<Float> r100 = this.shapeRadius;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.strokeColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.strokeWidth;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.shapeColor;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "Shape(shapeRadius=" + this.shapeRadius + ", strokeColor=" + this.strokeColor + ", strokeWidth=" + this.strokeWidth + ", shapeColor=" + this.shapeColor + ")";
    }

    public final String getShapeColor() {
        return this.shapeColor;
    }

    public final List<Float> getShapeRadius() {
        return this.shapeRadius;
    }

    public final String getStrokeColor() {
        return this.strokeColor;
    }

    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    public Shape(List<Float> r100, String r101, Float r102, String r103) {
        this.shapeRadius = r100;
        this.strokeColor = r101;
        this.strokeWidth = r102;
        this.shapeColor = r103;
    }

    public /* synthetic */ Shape(List r100, String r101, Float r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
