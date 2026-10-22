package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/y;", "", "", "textColor", "Ljava/lang/String;", "getTextColor", "()Ljava/lang/String;", "frameColor", "getFrameColor", "bgColor", "getBgColor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("frame_color")
    private final String frameColor;

    @SerializedName("text_color")
    private final String textColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L12;
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.frameColor, r101.frameColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.textColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.frameColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bgColor;
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

    public final String toString() {
        return "ShopTextStyle(textColor=" + this.textColor + ", frameColor=" + this.frameColor + ", bgColor=" + this.bgColor + ")";
    }

    public y() {
        this.textColor = null;
        this.frameColor = null;
        this.bgColor = null;
    }
}
