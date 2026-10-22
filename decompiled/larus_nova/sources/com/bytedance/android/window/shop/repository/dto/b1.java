package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/b1;", "", "", "marginTop", "I", "d", "()I", "marginBottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "marginLeft", "b", "marginRight", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b1 {

    @SerializedName("margin_bottom")
    private final int marginBottom;

    @SerializedName("margin_left")
    private final int marginLeft;

    @SerializedName("margin_right")
    private final int marginRight;

    @SerializedName("margin_top")
    private final int marginTop;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b1) == false) goto L14;
        b1 r101 = (b1) r100;
        if (this.marginTop == r101.marginTop) goto L8;
        return false;
    L8:
        if (this.marginBottom == r101.marginBottom) goto L10;
        return false;
    L10:
        if (this.marginLeft == r101.marginLeft) goto L12;
        return false;
    L12:
        if (this.marginRight == r101.marginRight) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.marginTop * 31) + this.marginBottom) * 31) + this.marginLeft) * 31) + this.marginRight;
    }

    public final String toString() {
        return "WindowSectionStyleData(marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ")";
    }

    public b1() {
        this.marginTop = -1;
        this.marginBottom = -1;
        this.marginLeft = -1;
        this.marginRight = -1;
    }

    public final int a() {
        return this.marginBottom;
    }

    public final int b() {
        return this.marginLeft;
    }

    public final int c() {
        return this.marginRight;
    }

    public final int d() {
        return this.marginTop;
    }
}
