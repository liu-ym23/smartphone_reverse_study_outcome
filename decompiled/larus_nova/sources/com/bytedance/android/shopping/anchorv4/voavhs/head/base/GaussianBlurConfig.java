package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "Ljava/io/Serializable;", "radius", "", "fps", "maskColor", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getFps", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaskColor", "()Ljava/lang/String;", "getRadius", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GaussianBlurConfig implements Serializable {

    @SerializedName("fps")
    private final Integer fps;

    @SerializedName("mask_color")
    private final String maskColor;

    @SerializedName("gaussian_blur_radius")
    private final Integer radius;

    public GaussianBlurConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GaussianBlurConfig copy$default(GaussianBlurConfig r100, Integer r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.radius;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.fps;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.maskColor;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.radius;
    }

    public final Integer component2() {
        return this.fps;
    }

    public final String component3() {
        return this.maskColor;
    }

    public final GaussianBlurConfig copy(Integer r100, Integer r101, String r102) {
        return new GaussianBlurConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GaussianBlurConfig) == false) goto L12;
        GaussianBlurConfig r101 = (GaussianBlurConfig) r100;
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fps, r101.fps) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maskColor, r101.maskColor) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.radius;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.fps;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.maskColor;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "GaussianBlurConfig(radius=" + this.radius + ", fps=" + this.fps + ", maskColor=" + this.maskColor + ")";
    }

    public final Integer getFps() {
        return this.fps;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final Integer getRadius() {
        return this.radius;
    }

    public GaussianBlurConfig(Integer r100, Integer r101, String r102) {
        this.radius = r100;
        this.fps = r101;
        this.maskColor = r102;
    }

    public /* synthetic */ GaussianBlurConfig(Integer r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(30));
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 24;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "#80666666";
    L11:
        this(r100, r101, r102);
    }
}
