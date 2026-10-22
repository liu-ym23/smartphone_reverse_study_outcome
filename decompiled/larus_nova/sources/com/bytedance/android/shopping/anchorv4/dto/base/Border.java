package com.bytedance.android.shopping.anchorv4.dto.base;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;", "Ljava/io/Serializable;", "borderColor", "", "borderWidth", "", "borderType", "(Ljava/lang/String;II)V", "getBorderColor", "()Ljava/lang/String;", "getBorderType", "()I", "getBorderWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Border implements Serializable {

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("border_type")
    private final int borderType;

    @SerializedName("border_width")
    private final int borderWidth;

    public Border() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ Border copy$default(Border r100, String r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.borderColor;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.borderWidth;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.borderType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.borderColor;
    }

    public final int component2() {
        return this.borderWidth;
    }

    public final int component3() {
        return this.borderType;
    }

    public final Border copy(String r100, int r101, int r102) {
        return new Border(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Border) == false) goto L12;
        Border r101 = (Border) r100;
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L8;
        return false;
    L8:
        if (this.borderWidth == r101.borderWidth) goto L10;
        return false;
    L10:
        if (this.borderType == r101.borderType) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.borderColor;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.borderWidth) * 31) + this.borderType;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "Border(borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", borderType=" + this.borderType + ")";
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderType() {
        return this.borderType;
    }

    public final int getBorderWidth() {
        return this.borderWidth;
    }

    public Border(String r100, int r101, int r102) {
        this.borderColor = r100;
        this.borderWidth = r101;
        this.borderType = r102;
    }

    public /* synthetic */ Border(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
