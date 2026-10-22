package com.bytedance.android.marketing.sdk.impl.data;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/data/g;", "", "", "width", "I", "f", "()I", "height", "b", "left", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "right", "d", "top", "e", "bottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "zPosition", ce.f26391f, "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("bottom")
    private final Integer bottom;

    @SerializedName("height")
    private final int height;

    @SerializedName("left")
    private final Integer left;

    @SerializedName("right")
    private final Integer right;

    @SerializedName("top")
    private final Integer top;

    @SerializedName("width")
    private final int width;

    @SerializedName("z_position")
    private final Integer zPosition;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L20;
        g r101 = (g) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.left, r101.left) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.top, r101.top) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bottom, r101.bottom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.zPosition, r101.zPosition) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.width * 31) + this.height) * 31;
        Integer r101 = this.left;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.right;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.top;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.bottom;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.zPosition;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
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

    public final String toString() {
        return "LayoutInfo(width=" + this.width + ", height=" + this.height + ", left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + ", zPosition=" + this.zPosition + ")";
    }

    public g() {
        this.width = 0;
        this.height = 0;
        this.left = null;
        this.right = null;
        this.top = null;
        this.bottom = null;
        this.zPosition = null;
    }

    public final Integer a() {
        return this.bottom;
    }

    public final int b() {
        return this.height;
    }

    public final Integer c() {
        return this.left;
    }

    public final Integer d() {
        return this.right;
    }

    public final Integer e() {
        return this.top;
    }

    public final int f() {
        return this.width;
    }

    public final Integer g() {
        return this.zPosition;
    }
}
