package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/ScaleFrame;", "Ljava/io/Serializable;", "scaleWidth", "", "scaleHeight", LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y, "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getScaleHeight", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getScaleWidth", "getScaleX", "getScaleY", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lcom/bytedance/android/shopping/anchorv4/dto/elements/ScaleFrame;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScaleFrame implements Serializable {

    @SerializedName("scale_height")
    private final Float scaleHeight;

    @SerializedName("scale_width")
    private final Float scaleWidth;

    @SerializedName("scale_x")
    private final Float scaleX;

    @SerializedName("scale_y")
    private final Float scaleY;

    public ScaleFrame() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ScaleFrame copy$default(ScaleFrame r100, Float r101, Float r102, Float r103, Float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.scaleWidth;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.scaleHeight;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.scaleX;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.scaleY;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Float component1() {
        return this.scaleWidth;
    }

    public final Float component2() {
        return this.scaleHeight;
    }

    public final Float component3() {
        return this.scaleX;
    }

    public final Float component4() {
        return this.scaleY;
    }

    public final ScaleFrame copy(Float r100, Float r101, Float r102, Float r103) {
        return new ScaleFrame(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ScaleFrame) == false) goto L14;
        ScaleFrame r101 = (ScaleFrame) r100;
        if (Intrinsics.areEqual(this.scaleWidth, r101.scaleWidth) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scaleHeight, r101.scaleHeight) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.scaleX, r101.scaleX) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scaleY, r101.scaleY) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Float r100 = this.scaleWidth;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.scaleHeight;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.scaleX;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.scaleY;
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
        return "ScaleFrame(scaleWidth=" + this.scaleWidth + ", scaleHeight=" + this.scaleHeight + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ")";
    }

    public final Float getScaleHeight() {
        return this.scaleHeight;
    }

    public final Float getScaleWidth() {
        return this.scaleWidth;
    }

    public final Float getScaleX() {
        return this.scaleX;
    }

    public final Float getScaleY() {
        return this.scaleY;
    }

    public ScaleFrame(Float r100, Float r101, Float r102, Float r103) {
        this.scaleWidth = r100;
        this.scaleHeight = r101;
        this.scaleX = r102;
        this.scaleY = r103;
    }

    public /* synthetic */ ScaleFrame(Float r100, Float r101, Float r102, Float r103, int r104, DefaultConstructorMarker r105) {
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
