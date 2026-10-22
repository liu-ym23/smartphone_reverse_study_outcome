package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/r;", "", "", "text", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "color", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "marginLeft", "I", "c", "()I", "marginRight", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("color")
    private final String color;

    @SerializedName("icon")
    private final ECUrlModel image;

    @SerializedName("margin_left")
    private final int marginLeft;

    @SerializedName("margin_right")
    private final int marginRight;

    @SerializedName("text")
    private final String text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L16;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L12;
        return false;
    L12:
        if (this.marginLeft == r101.marginLeft) goto L14;
        return false;
    L14:
        if (this.marginRight == r101.marginRight) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.image;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.color;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((((r106 + r101) * 31) + this.marginLeft) * 31) + this.marginRight;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowCustomLabelDTO(text=" + this.text + ", image=" + this.image + ", color=" + this.color + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ")";
    }

    public r() {
        this.text = null;
        this.image = null;
        this.color = null;
        this.marginLeft = 0;
        this.marginRight = 0;
    }

    public final String a() {
        return this.color;
    }

    public final ECUrlModel b() {
        return this.image;
    }

    public final int c() {
        return this.marginLeft;
    }

    public final int d() {
        return this.marginRight;
    }

    public final String e() {
        return this.text;
    }
}
